/*
 * Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.beaglesampleandroid.utils

//class BiometricLogic(val success: List<Action>, val error:List<Action>) {

//    val biometricPrompt: BiometricPrompt
//    val biometricManager = BiometricManager.from(rootView.getContext())
//
//    biometricPrompt = instanceOfBiometricPrompt(rootView, origin)
//
//    val canAuthenticate = biometricManager.canAuthenticate()
//    if (canAuthenticate == BiometricManager.BIOMETRIC_SUCCESS) {
//        biometricPrompt.authenticate(getPromptInfo())
//    } else {
//        Log.d(TAG, "could not authenticate because: $canAuthenticate")
//    }

//    private fun instanceOfBiometricPrompt(rootView: RootView, origin: View): BiometricPrompt {
//        val executor = ContextCompat.getMainExecutor(rootView.getContext())
//
//        val callback =
//            @RequiresApi(Build.VERSION_CODES.P)
//            object : BiometricPrompt.AuthenticationCallback() {
//                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
//                    super.onAuthenticationError(errorCode, errString)
//                    Log.i("Biometrics", "$errorCode :: $errString")
//                    //  handleEvent(rootView, origin, error)
//                }
//
//                override fun onAuthenticationFailed() {
//                    super.onAuthenticationFailed()
//                    Log.i("Biometrics", "error")
//                    //   handleEvent(rootView, origin, error)
//                }
//
//                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
//                    super.onAuthenticationSucceeded(result)
//                    Log.i("Biometrics", "Authentication was successful")
//                    //   handleEvent(rootView, origin, success)
//                }
//            }
//        return BiometricPrompt(rootView.getContext() as FragmentActivity, executor, callback)
//    }
//
//    private fun getPromptInfo(): BiometricPrompt.PromptInfo {
//        val promptInfo = BiometricPrompt.PromptInfo.Builder()
//            .setTitle("My App's Authentication")
//            .setSubtitle("Please login to get access")
//            .setDescription("My App is using Android biometric authentication")
//            .setDeviceCredentialAllowed(true)
//            .setConfirmationRequired(true)
//            .build()
//        return promptInfo
//    }
//}