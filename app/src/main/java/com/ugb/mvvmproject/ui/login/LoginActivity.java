package com.ugb.mvvmproject.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.ugb.mvvmproject.R;
import com.ugb.mvvmproject.databinding.ActivityLoginBinding;
import com.ugb.mvvmproject.ui.mainActivity.MainActivity;

import java.util.HashMap;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements NavigatorLogin {
    LoginViewModel loginViewModel;
    ActivityLoginBinding loginBinding;
    HashMap<Object, Object> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.setNavigator(this);

        loginBinding.setViewModel(loginViewModel);
        loginBinding.setLifecycleOwner(this);


    }

    public void login(String email, String password) {
        if (!email.isEmpty() && !password.isEmpty()) {
            hashMap.put("email", email);
            hashMap.put("password", password);
            loginViewModel.login(hashMap);
        }
    }

    @Override
    public void handleError(Throwable throwable) {
       Log.d("errorLogin",throwable.hashCode()+"");
    }

    @Override
    public void login() {
        login(Objects.requireNonNull(loginBinding.eTextEmail.getText()).toString(),
                Objects.requireNonNull(loginBinding.eTextPassword.getText()).toString());
    }

    @Override
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}