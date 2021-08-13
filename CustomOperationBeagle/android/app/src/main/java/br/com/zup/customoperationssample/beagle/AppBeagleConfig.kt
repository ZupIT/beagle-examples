package br.com.zup.customoperationssample.beagle

import br.com.zup.beagle.android.annotation.BeagleComponent
import br.com.zup.beagle.scaffold.BeagleConfigScaffold

@BeagleComponent
class AppBeagleConfig : BeagleConfigScaffold(baseUrl = "http://10.0.2.2:8080")