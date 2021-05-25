package com.voximplant.sdk.client;
public interface IClientLoginListener {
    void onLoginFailed(LoginError loginError);

    void onLoginSuccessful(String str, AuthParams authParams);

    void onOneTimeKeyGenerated(String str);

    void onRefreshTokenFailed(LoginError loginError);

    void onRefreshTokenSuccess(AuthParams authParams);
}
