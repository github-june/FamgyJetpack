package com.famgy.famgyjetpack.viewmodel.model

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    enum class AuthenticationState {
        UNAUTHENTICATED,
        AUTHENTICATED,
        INVALID_AUTHENTICATION  // Authentication failed
    }

    var mAccount: String = ""
    var mPassword: String = ""
    val authenticationState by lazy {
        MutableLiveData<AuthenticationState>()
    }

    init {
        // In this example, the user is always unauthenticated when MainActivity is launched
        authenticationState.value = AuthenticationState.UNAUTHENTICATED
    }

    fun refuseAuthentication() {
        authenticationState.value = AuthenticationState.UNAUTHENTICATED
    }

    fun authenticate() {
        if (passwordIsValidForUsername()) {
            authenticationState.value = AuthenticationState.AUTHENTICATED
        } else {
            authenticationState.value = AuthenticationState.INVALID_AUTHENTICATION
        }
    }

    private fun passwordIsValidForUsername(): Boolean {
        if ("famgy".equals(mAccount) && "abcd".equals(mPassword)) {
            return true
        }

        return false
    }


    fun onAccountChanged(s: CharSequence) {
        mAccount = s.toString()
    }

    fun onPasswordChanged(s: CharSequence) {
        mPassword = s.toString()
    }
}