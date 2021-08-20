// ignore: import_of_legacy_library_into_null_safe
import 'package:beagle/beagle.dart';
// ignore: import_of_legacy_library_into_null_safe
import 'package:beagle_components/beagle_components.dart';
import 'package:get_started_beagle_flutter/beagle-config/design_system.dart';

class BeagleFlutterConfig {
  static const _BASE_URL = 'Your endpoint here!!!';

  static initBeagle() {
    BeagleSdk.init(
        baseUrl: _BASE_URL,
        components: {...defaultComponents},
        designSystem: MyDesignSystem());
  }
}
