// ignore: import_of_legacy_library_into_null_safe
import 'package:beagle/beagle.dart';
// ignore: import_of_legacy_library_into_null_safe
import 'package:beagle_components/beagle_components.dart';

class BeagleFlutterConfig {
  static const _BASE_URL = 'http://192.168.18.5:8080';

  static initBeagle() {
    BeagleSdk.init(baseUrl: _BASE_URL, components: {...defaultComponents});
  }
}
