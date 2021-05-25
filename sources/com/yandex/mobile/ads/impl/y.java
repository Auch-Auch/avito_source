package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;
public final class y extends ResultReceiver {
    private WeakReference<a> a = new WeakReference<>(null);

    public interface a {
        void a(int i, @Nullable Bundle bundle);
    }

    public y(Handler handler) {
        super(handler);
    }

    public final void a(a aVar) {
        this.a = new WeakReference<>(aVar);
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, @Nullable Bundle bundle) {
        a aVar;
        WeakReference<a> weakReference = this.a;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            aVar.a(i, bundle);
        }
    }
}
