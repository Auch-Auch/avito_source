package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
public class kl {
    @NonNull
    private Context a;
    @NonNull
    private ServiceConnection b;
    @NonNull
    private final ado c;

    public kl(@NonNull Context context) {
        this(context, new ServiceConnection() { // from class: com.yandex.metrica.impl.ob.kl.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }
        }, new ado());
    }

    @TargetApi(12)
    private void b(@NonNull Intent intent) {
        intent.addFlags(32);
    }

    public void a(@Nullable String str) {
        Intent a3;
        if (!TextUtils.isEmpty(str) && (a3 = a(this.a, str)) != null) {
            this.a.bindService(a3, this.b, 1);
        }
    }

    @VisibleForTesting
    public kl(@NonNull Context context, @NonNull ServiceConnection serviceConnection, @NonNull ado ado) {
        this.a = context;
        this.b = serviceConnection;
        this.c = ado;
    }

    public void a() {
        this.a.unbindService(this.b);
    }

    @Nullable
    private Intent a(@NonNull Context context, @NonNull String str) {
        try {
            ResolveInfo resolveService = context.getPackageManager().resolveService(a(context).setPackage(str), 0);
            if (resolveService == null) {
                return null;
            }
            Intent intent = new Intent();
            ServiceInfo serviceInfo = resolveService.serviceInfo;
            return intent.setClassName(serviceInfo.packageName, serviceInfo.name).setAction("com.yandex.metrica.ACTION_C_BG_L");
        } catch (Throwable unused) {
            return null;
        }
    }

    @NonNull
    private Intent a(@NonNull Context context) {
        StringBuilder L = a.L("metrica://");
        L.append(context.getPackageName());
        Intent intent = new Intent("com.yandex.metrica.IMetricaService", Uri.parse(L.toString()));
        a(intent);
        return intent;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    private void a(@NonNull Intent intent) {
        b(intent);
    }
}
