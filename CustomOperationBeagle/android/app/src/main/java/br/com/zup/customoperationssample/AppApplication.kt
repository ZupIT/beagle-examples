package br.com.zup.customoperationssample

import android.app.Application
import br.com.zup.beagle.scaffold.BeagleScaffold
import br.com.zup.customoperationssample.beagle.BeagleSetup

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        BeagleScaffold(BeagleSetup()).init(this)
    }
}