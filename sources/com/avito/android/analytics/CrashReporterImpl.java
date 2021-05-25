package com.avito.android.analytics;

import a2.a.a.i.b;
import a2.a.a.i.c;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/analytics/CrashReporterImpl;", "Lcom/avito/android/analytics/CrashReporter;", "Lkotlin/Function0;", "", "onInitialized", "initialize", "(Lkotlin/jvm/functions/Function0;)V", "", "isInitialized", "()Z", AuthSource.SEND_ABUSE, "Z", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "analytics-core_release"}, k = 1, mv = {1, 4, 2})
public final class CrashReporterImpl implements CrashReporter {
    public boolean a;
    public final Analytics b;

    @Inject
    public CrashReporterImpl(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = analytics;
    }

    public static final void access$report(CrashReporterImpl crashReporterImpl, Throwable th) {
        crashReporterImpl.b.track(new c(th));
    }

    @Override // com.avito.android.util.Initializable
    public synchronized void initialize(@Nullable Function0<Unit> function0) {
        if (!this.a) {
            Thread.setDefaultUncaughtExceptionHandler(new b(this, Thread.getDefaultUncaughtExceptionHandler()));
            this.a = true;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    @Override // com.avito.android.util.Initializable
    public boolean isInitialized() {
        return this.a;
    }
}
