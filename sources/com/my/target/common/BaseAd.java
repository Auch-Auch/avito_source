package com.my.target.common;

import androidx.annotation.NonNull;
import com.my.target.a;
import java.util.concurrent.atomic.AtomicBoolean;
public abstract class BaseAd {
    @NonNull
    public final AtomicBoolean a = new AtomicBoolean();
    @NonNull
    public final a adConfig;

    public BaseAd(int i, @NonNull String str) {
        this.adConfig = a.newConfig(i, str);
    }

    @NonNull
    public CustomParams getCustomParams() {
        return this.adConfig.getCustomParams();
    }

    public boolean isLoadCalled() {
        return !this.a.compareAndSet(false, true);
    }
}
