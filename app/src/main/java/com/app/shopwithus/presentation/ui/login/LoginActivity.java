package com.app.shopwithus.presentation.ui.login;

import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.app.shopwithus.NetworkState;
import com.app.shopwithus.R;
import com.app.shopwithus.databinding.ActivityLoginBinding;
import com.app.shopwithus.presentation.ui.home.MainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends AppCompatActivity {


    private AlertDialog.Builder builder;
    private LoginViewModel loginViewModel;
    private FirebaseAuth firebaseAuth;
    private ActivityLoginBinding binding;
    private String password;
    private String email;
    private ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        builder = new AlertDialog.Builder(this);
        firebaseAuth = FirebaseAuth.getInstance();
        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory()).get(LoginViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setLoginViewModel(loginViewModel);
        setProgressBar(binding.loading);
        loginViewModel.click_handle.observeForever(s -> {
            if (loginViewModel.click_handle.getValue().equals(LoginViewModel.create_click)) {
                if (validateForm()) {
                    getData();
                    showProgressBar();
                    createUser(firebaseAuth, email, password);
                }
            } else if (loginViewModel.click_handle.getValue().equals(LoginViewModel.login_click)) {
                if (validateForm()) {
                    getData();
                    showProgressBar();
                    login(firebaseAuth, email, password);
                }
            } else {
                switchMode();
            }
        });
    }

    public void getData() {
        email = binding.username.getText().toString();
        password = binding.password.getText().toString();
    }

    public void login(@NotNull FirebaseAuth firebaseAuth, String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        startMainActivity();
                    } else if (!task.isSuccessful()) {
                        hideProgressBar();
                        Toast.makeText(this, "Something went wrong!", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void createUser(@NotNull FirebaseAuth firebaseAuth, String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        startMainActivity();
                    } else if (!task.isSuccessful()) {
                        hideProgressBar();
                        Toast.makeText(this, "Something went wrong!", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void switchMode() {
        clearForm();
        if (binding.login.getVisibility() == View.VISIBLE) {
            binding.login.setVisibility(View.GONE);
            binding.registrate.setVisibility(View.VISIBLE);
        }else{
            binding.registrate.setVisibility(View.GONE);
            binding.login.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user!=null){
            startMainActivity();
        }

    }

    public void startMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        this.finish();
    }

    boolean validateForm() {
        boolean valid = true;
        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        if (!NetworkState.hasNetworkAccess(this)) {
            valid = false;
            Toast.makeText(this, "Miss internet connection!", Toast.LENGTH_LONG).show();
        } else if (usernameEditText.getText().toString().equals("") || passwordEditText.getText().toString().equals("")) {
            valid = false;
            Toast.makeText(this, "Empty fields are not allowed!", Toast.LENGTH_LONG).show();
        } else if (usernameEditText.getText().toString().equals("")) {
            valid = false;
            Toast.makeText(this,
                    R.string.invalid_username, Toast.LENGTH_LONG).show();
        } else if (passwordEditText.getText().toString().length() < 5) {
            valid = false;
            Toast.makeText(this,
                    R.string.invalid_password, Toast.LENGTH_LONG).show();
        }
        return valid;
    }

    public void clearForm() {
        binding.password.setText("");
        binding.username.setText("");
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public void showProgressBar() {
        if (progressBar != null) {
            binding.loading.setVisibility(View.VISIBLE);
        }
    }

    public void hideProgressBar() {
        if (progressBar != null) {
            binding.loading.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        clearForm();
        firebaseAuth.signOut();

    }
}