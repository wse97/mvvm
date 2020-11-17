package com.ugb.mvvmproject.ui.login;

public interface NavigatorLogin {

    void handleError(Throwable throwable);

    void login();

    void openMainActivity();

}
