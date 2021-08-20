import 'package:beagle/beagle.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

class MyDesignSystem extends BeagleDesignSystem {
  Map<String, TextStyle> textMap = {
    'h1': TextStyle(
      fontSize: 25,
    ),
    'h2': TextStyle(
      fontSize: 20,
    )
  };

  @override
  TextStyle textStyle(String id) {
    return textMap[id] ??
        TextStyle(
          fontSize: 18,
        );
  }

  @override
  BeagleButtonStyle buttonStyle(String id) {
    return BeagleButtonStyle(
      androidButtonStyle: ButtonStyle(
        backgroundColor: MaterialStateProperty.all<Color>(Colors.teal),
      ),
      iosButtonStyle: BeagleIosButtonStyle(
        color: Colors.teal,
      ),
    );
  }

  @override
  String image(String id) {
    return '';
  }
}
