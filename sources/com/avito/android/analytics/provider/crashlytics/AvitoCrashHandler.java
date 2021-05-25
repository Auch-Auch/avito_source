package com.avito.android.analytics.provider.crashlytics;

import com.avito.android.remote.auth.AuthSource;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/avito/android/analytics/provider/crashlytics/AvitoCrashHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "Ljava/lang/Thread;", "thread", "", OkListener.KEY_EXCEPTION, "", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", AuthSource.BOOKING_ORDER, "Ljava/lang/Thread$UncaughtExceptionHandler;", "logBufferCrashHandler", "Lcom/avito/android/analytics/provider/crashlytics/CrashRecorder;", "c", "Lcom/avito/android/analytics/provider/crashlytics/CrashRecorder;", "crashRecorder", AuthSource.SEND_ABUSE, "defaultCrashHandler", "<init>", "(Ljava/lang/Thread$UncaughtExceptionHandler;Ljava/lang/Thread$UncaughtExceptionHandler;Lcom/avito/android/analytics/provider/crashlytics/CrashRecorder;)V", "analytics-firebase-crashlytics_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoCrashHandler implements Thread.UncaughtExceptionHandler {
    public final Thread.UncaughtExceptionHandler a;
    public final Thread.UncaughtExceptionHandler b;
    public final CrashRecorder c;

    public AvitoCrashHandler(@Nullable Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NotNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler2, @NotNull CrashRecorder crashRecorder) {
        Intrinsics.checkNotNullParameter(uncaughtExceptionHandler2, "logBufferCrashHandler");
        Intrinsics.checkNotNullParameter(crashRecorder, "crashRecorder");
        this.a = uncaughtExceptionHandler;
        this.b = uncaughtExceptionHandler2;
        this.c = crashRecorder;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@Nullable Thread thread, @Nullable Throwable th) {
        this.c.recordUncaughtException();
        this.b.uncaughtException(thread, th);
        Thread.sleep(500);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
