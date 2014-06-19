/*
 * Copyright (c) 2012, the Dart project authors.
 * 
 * Licensed under the Eclipse Public License v1.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.github.sdbg.debug.ui.internal.launch;

import com.github.sdbg.debug.core.SDBGDebugCorePlugin;
import com.github.sdbg.debug.core.util.ResourceServer;
import com.github.sdbg.debug.core.util.ResourceServerManager;
import com.github.sdbg.debug.ui.internal.DebugErrorHandler;
import com.github.sdbg.debug.ui.internal.SDBGDebugUIPlugin;
import com.github.sdbg.debug.ui.internal.util.LaunchUtils;
import com.github.sdbg.ui.instrumentation.UIInstrumentationBuilder;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * Action to launch in default browser
 */
public class RunInBrowserAction extends RunAbstractAction {

  public RunInBrowserAction() {
    this(null);
  }

  public RunInBrowserAction(IWorkbenchWindow window) {
    this(window, false);
  }

  public RunInBrowserAction(IWorkbenchWindow window, boolean noMenu) {
    super(window, "Run in Browser", noMenu ? IAction.AS_PUSH_BUTTON : IAction.AS_DROP_DOWN_MENU);

    setActionDefinitionId("com.google.dart.tools.debug.ui.run.browser");
    setImageDescriptor(SDBGDebugUIPlugin.getImageDescriptor("obj16/run_exc.png"));
  }

  @Override
  protected void doLaunch(UIInstrumentationBuilder instrumentation) {
    IResource resource = LaunchUtils.getSelectedResource(window);

    try {
      if (resource != null) {
        instrumentation.metric("Resource-Class", resource.getClass().toString());
        instrumentation.data("Resource-Name", resource.getName());

        ResourceServer server = ResourceServerManager.getServer();
        String url = server.getUrlForResource(resource);

        if (SDBGDebugCorePlugin.getPlugin().getIsDefaultBrowser()) {
          LaunchUtils.openBrowser(url);
        } else {
          LaunchUtils.launchInExternalBrowser(url);
        }
      }
    } catch (Exception exception) {
      instrumentation.metric("Problem", "Exception launching " + exception.getClass().toString());
      instrumentation.data("Problem", "Exception launching " + exception.toString());

      DebugErrorHandler.errorDialog(window.getShell(), "Error Launching", "Unable to launch "
          + resource.getName() + ".", exception);
    }
  }
}
