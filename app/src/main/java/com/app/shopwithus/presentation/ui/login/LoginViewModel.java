package com.app.shopwithus.presentation.ui.login;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class LoginViewModel extends ViewModel {

    public static final String login_click="Login";
    public static final String create_click="Create";
    public static final String switch_mode="Switch";
    public MutableLiveData<String> click_handle = new MutableLiveData<>();

    public LoginViewModel() {

    }

    public void OnLoginPressed() {
        ClickHandle(login_click);
    }

    public void onSwitchModePressed() {
        ClickHandle(switch_mode);
    }

    public void onCreatePressed() {
        ClickHandle(create_click);
    }

    public void ClickHandle(String choice) {
    click_handle.setValue(choice);
    }
}
