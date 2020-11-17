package com.ugb.mvvmproject.ui.login;

import android.annotation.SuppressLint;
import android.widget.Toast;
import androidx.lifecycle.MutableLiveData;
import com.ugb.mvvmproject.data.local.SharedPreference;
import com.ugb.mvvmproject.data.remote.respons.UserResponse;
import com.ugb.mvvmproject.data.remote.ApiClient;
import com.ugb.mvvmproject.helper.BaseViewModel;
import java.util.HashMap;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends BaseViewModel<NavigatorLogin> {
    public MutableLiveData<UserResponse> userMutableLiveData = new MutableLiveData<>();


    @SuppressLint("CheckResult")
    public void login(HashMap<Object, Object> map) {
        setIsLoading(true);
        Single<UserResponse> observableLogin = ApiClient.getINSTANCE().login(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        observableLogin.subscribe(new SingleObserver<UserResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onSuccess(UserResponse userResponse) {
                setIsLoading(false);
                userMutableLiveData.setValue(userResponse);
                if (userResponse.isStatus()){
                    SharedPreference.getInstance(ApiClient.mContext).setUser(userResponse.getUserModel());
                    SharedPreference.getInstance(ApiClient.mContext).setToken(userResponse.getToken_type()
                            + " " + userResponse.getAccess_token());
                    getNavigator().openMainActivity();
                }
                else {
                    Toast.makeText(ApiClient.mContext, userResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(Throwable e) {
                setIsLoading(false);
                getNavigator().handleError(e);

            }
        });


    }
    public void onServerLoginClick() {
        getNavigator().login();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
