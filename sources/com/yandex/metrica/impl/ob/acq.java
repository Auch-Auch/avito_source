package com.yandex.metrica.impl.ob;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
public class acq {
    @NonNull
    public Handler a() {
        return new Handler(Looper.getMainLooper());
    }

    @NonNull
    public acs b() {
        return new acs("YMM-APT");
    }

    @NonNull
    public acs c() {
        return new acs("YMM-RS");
    }

    @NonNull
    public acs d() {
        return new acs("YMM-YM");
    }
}
