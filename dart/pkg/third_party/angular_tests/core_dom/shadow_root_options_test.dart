/// auto-generated by generate_angular_tests.sh

// Copyright (c) 2014, the Dart project authors.  Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.

library angular_tests;

import 'package:angular/mock/module.dart';
import 'package:unittest/html_config.dart';
import 'package:unittest/unittest.dart';
import '../../../../third_party/pkg/angular/test/core_dom/shadow_root_options_spec.dart' as test_lib;

main() {
  useHtmlConfiguration();

  setUp(() {
    setUpInjector();
  });

  test_lib.main();
}

