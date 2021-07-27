import 'package:flutter/material.dart';

class NativeScreen extends StatelessWidget {
  const NativeScreen({Key? key}) : super(key: key);

  Widget buildTextFields(String text, double fontSize) {
    return Padding(
      padding: EdgeInsets.fromLTRB(0, 0, 0, 50),
      child: Text(
        text,
        textAlign: TextAlign.center,
        style: TextStyle(fontSize: fontSize),
      ),
    );
  }

  Widget buildButton(context) {
    return Padding(
        padding: EdgeInsets.fromLTRB(0, 70, 0, 0),
        child: ElevatedButton(
          onPressed: () => Navigator.pop(context),
          child: Text("Go back to the Beagle Screen"),
          style: ButtonStyle(
              padding: MaterialStateProperty.all(EdgeInsets.all(20)),
              backgroundColor: MaterialStateProperty.all(Colors.blue)),
        ));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Flutter Native Screen'),
        ),
        body: Center(
          child: Padding(
            padding: EdgeInsets.all(20.0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                buildTextFields("This is a native screen", 25),
                Image(image: AssetImage('assets/images/flutter-logo.png')),
                buildTextFields(
                    "You can compose your apps from both Beagle and Native components... isn't that nice!!!",
                    15),
                buildButton(context)
              ],
            ),
          ),
        ));
  }
}
