// Copyright (c) 2012, the Dart project authors.  Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.

// WARNING: Do not edit - generated code.

interface CSSKeyframesRule extends CSSRule {

  final CSSRuleList cssRules;

  String name;

  void deleteRule(String key);

  CSSKeyframeRule findRule(String key);

  void insertRule(String rule);
}
