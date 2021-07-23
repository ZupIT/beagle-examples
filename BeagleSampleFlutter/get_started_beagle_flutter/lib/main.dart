// ignore: import_of_legacy_library_into_null_safe
import 'package:beagle/beagle.dart';
import 'package:flutter/material.dart';
import 'package:get_started_beagle_flutter/beagle-config/beagle.dart';

void main() {
  BeagleFlutterConfig.initBeagle();
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MyHomePage('Flutter Demo Home Page'),
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
          children: <Widget>[
            Text(
              'This is a Beagle Component',
            ),
            BeagleWidget(
              screenRequest: BeagleScreenRequest('/screen'),
            )
          ],
        ),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
