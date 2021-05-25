package com.my.target.common;

import android.content.Context;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.my.target.ae;
import com.my.target.af;
import com.my.target.common.MyTargetConfig;
import com.my.target.fc;
import java.util.concurrent.atomic.AtomicBoolean;
public final class MyTargetManager {
    public static final AtomicBoolean a = new AtomicBoolean();
    @NonNull
    public static volatile MyTargetConfig b = new MyTargetConfig.Builder().build();

    public static class a implements Runnable {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            fc.dP().K(this.a);
        }
    }

    @NonNull
    @WorkerThread
    public static String getBidderToken(@NonNull Context context) {
        fc dP = fc.dP();
        dP.C(MyTargetPrivacy.currentPrivacy().isConsent());
        return dP.getBidderToken(context);
    }

    @NonNull
    public static MyTargetConfig getSdkConfig() {
        return b;
    }

    @AnyThread
    public static void initSdk(@NonNull Context context) {
        if (a.compareAndSet(false, true)) {
            Context applicationContext = context.getApplicationContext();
            ae.c("MyTarget initialization");
            af.a(new a(applicationContext));
        }
    }

    public static void setDebugMode(boolean z) {
        ae.enabled = z;
        if (z) {
            ae.a("Debug mode enabled");
        }
    }

    public static void setSdkConfig(@NonNull MyTargetConfig myTargetConfig) {
        b = myTargetConfig;
    }
}
