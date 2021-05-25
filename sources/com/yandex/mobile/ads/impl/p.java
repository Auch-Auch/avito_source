package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class p implements n {
    @NonNull
    private final Activity a;
    @Nullable
    private final ResultReceiver b;

    public p(@NonNull Activity activity, @Nullable ResultReceiver resultReceiver) {
        this.a = activity;
        this.b = resultReceiver;
    }

    @Override // com.yandex.mobile.ads.impl.n
    public final void a(int i) {
        try {
            if (Build.VERSION.SDK_INT != 26) {
                this.a.setRequestedOrientation(i);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.yandex.mobile.ads.impl.n
    public final void a(int i, @Nullable Bundle bundle) {
        ResultReceiver resultReceiver = this.b;
        if (resultReceiver != null) {
            resultReceiver.send(i, bundle);
        }
    }

    @Override // com.yandex.mobile.ads.impl.n
    public final void a() {
        this.a.finish();
    }
}
