package com.avito.android.analytics.provider.crashlytics;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import dagger.Lazy;
import java.lang.Thread;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/analytics/provider/crashlytics/LogBufferCrashHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "Ljava/lang/Thread;", "thread", "", OkListener.KEY_EXCEPTION, "", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "Ldagger/Lazy;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", "eventTracker", "<init>", "(Ldagger/Lazy;)V", "analytics-firebase-crashlytics_release"}, k = 1, mv = {1, 4, 2})
public final class LogBufferCrashHandler implements Thread.UncaughtExceptionHandler {
    public final Lazy<FirebaseCrashlyticsEventTracker> a;

    @Inject
    public LogBufferCrashHandler(@NotNull Lazy<FirebaseCrashlyticsEventTracker> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "eventTracker");
        this.a = lazy;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@Nullable Thread thread, @Nullable Throwable th) {
        Logs.debug$default("LogBufferCrashHandler", "Log dump initiated due to crash: " + th, null, 4, null);
        this.a.get().dumpLogsFromBuffer();
    }
}
