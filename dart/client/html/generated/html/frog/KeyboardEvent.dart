
class _KeyboardEventImpl extends _UIEventImpl implements KeyboardEvent native "*KeyboardEvent" {

  final bool altGraphKey;

  final bool altKey;

  final bool ctrlKey;

  final String keyIdentifier;

  final int keyLocation;

  final bool metaKey;

  final bool shiftKey;

  void initKeyboardEvent(String type, bool canBubble, bool cancelable, _WindowImpl view, String keyIdentifier, int keyLocation, bool ctrlKey, bool altKey, bool shiftKey, bool metaKey, bool altGraphKey) native;
}
