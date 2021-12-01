// ignore: import_of_legacy_library_into_null_safe
import 'package:beagle/beagle.dart';
import 'package:beagle_components/beagle_components.dart';
import 'package:flutter/material.dart';
import 'package:get_started_beagle_flutter/beagle-config/beagle.dart';
import 'package:get_started_beagle_flutter/pages/native-screen.dart';

void main() {
  BeagleFlutterConfig.initBeagle();
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Beagle Flutter Demo',
      initialRoute: '/',
      routes: {'native-route': (context) => NativeScreen()},
      theme: ThemeData(
        primarySwatch: Colors.teal,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MyHomePage('Flutter Beagle Demo'),
    );
  }
}

class MyHomePage extends StatelessWidget {
  String title = '';

  MyHomePage(title) {
    this.title = title;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            BeagleWidget(
              screenRequest: BeagleScreenRequest('/get-started'),
            ),
          ],
        ),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
