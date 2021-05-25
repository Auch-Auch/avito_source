package com.yandex.metrica;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public interface AppMetricaDeviceIDListener {

    public enum Reason {
        UNKNOWN,
        NETWORK,
        INVALID_RESPONSE
    }

    void onError(@NonNull Reason reason);

    void onLoaded(@Nullable String str);
}
