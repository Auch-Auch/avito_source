package com.yandex.mobile.ads.core.identifiers.ad.huawei;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.core.identifiers.ad.huawei.OpenDeviceIdentifierService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
public final class b implements ServiceConnection {
    @NonNull
    private final BlockingQueue<OpenDeviceIdentifierService> a = new LinkedBlockingQueue();

    @Nullable
    public final OpenDeviceIdentifierService a() throws InterruptedException {
        return this.a.poll(5, TimeUnit.SECONDS);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        try {
            this.a.put(OpenDeviceIdentifierService.Stub.asInterface(iBinder));
        } catch (Exception unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(@NonNull ComponentName componentName) {
        try {
            this.a.clear();
        } catch (UnsupportedOperationException unused) {
        }
    }
}
