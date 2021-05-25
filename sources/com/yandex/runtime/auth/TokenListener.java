package com.yandex.runtime.auth;

import androidx.annotation.NonNull;
public interface TokenListener {
    void onPasswordRequired(@NonNull Object obj);

    void onTokenReceived(@NonNull String str);

    void onTokenRefreshFailed(@NonNull String str);
}
