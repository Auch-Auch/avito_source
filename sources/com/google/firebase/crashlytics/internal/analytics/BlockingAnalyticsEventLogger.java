package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
public class BlockingAnalyticsEventLogger implements AnalyticsEventReceiver, AnalyticsEventLogger {
    public final CrashlyticsOriginAnalyticsEventLogger a;
    public final int b;
    public final TimeUnit c;
    public final Object d = new Object();
    public CountDownLatch e;

    public BlockingAnalyticsEventLogger(@NonNull CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger, int i, TimeUnit timeUnit) {
        this.a = crashlyticsOriginAnalyticsEventLogger;
        this.b = i;
        this.c = timeUnit;
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
    public void logEvent(@NonNull String str, @Nullable Bundle bundle) {
        synchronized (this.d) {
            Logger.getLogger().d("Logging Crashlytics event to Firebase");
            this.e = new CountDownLatch(1);
            this.a.logEvent(str, bundle);
            Logger.getLogger().d("Awaiting app exception callback from FA...");
            try {
                if (this.e.await((long) this.b, this.c)) {
                    Logger.getLogger().d("App exception callback received from FA listener.");
                } else {
                    Logger.getLogger().d("Timeout exceeded while awaiting app exception callback from FA listener.");
                }
            } catch (InterruptedException unused) {
                Logger.getLogger().d("Interrupted while awaiting app exception callback from FA listener.");
            }
            this.e = null;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver
    public void onEvent(@NonNull String str, @NonNull Bundle bundle) {
        CountDownLatch countDownLatch = this.e;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
