package com.yandex.metrica.impl.ac;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.an;
public class NativeCrashesHelper {
    private String a;
    private final Context b;
    private boolean c;
    private boolean d;
    @NonNull
    private final an e;

    public NativeCrashesHelper(@NonNull Context context) {
        this(context, new an());
    }

    private void b() {
        if (!this.d && a()) {
            b(false);
            this.a = this.e.a(this.b).getAbsolutePath() + "/YandexMetricaNativeCrashes";
        }
        this.d = true;
    }

    private void c() {
        try {
            b();
            if (d()) {
                setUpNativeUncaughtExceptionHandler(this.a);
                this.c = true;
            }
        } catch (Throwable unused) {
            this.c = false;
        }
    }

    private static native void cancelSetUpNativeUncaughtExceptionHandler();

    private boolean d() {
        return this.a != null;
    }

    private void e() {
        try {
            if (d() && this.c) {
                cancelSetUpNativeUncaughtExceptionHandler();
            }
        } catch (Throwable unused) {
        }
        this.c = false;
    }

    private static native void logsEnabled(boolean z);

    private static native void setUpNativeUncaughtExceptionHandler(String str);

    public synchronized void a(boolean z) {
        if (z) {
            c();
        } else {
            e();
        }
    }

    @VisibleForTesting
    public NativeCrashesHelper(@NonNull Context context, @NonNull an anVar) {
        this.b = context;
        this.e = anVar;
    }

    @VisibleForTesting
    public boolean a() {
        try {
            System.loadLibrary("YandexMetricaNativeModule");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean b(boolean z) {
        try {
            logsEnabled(z);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
