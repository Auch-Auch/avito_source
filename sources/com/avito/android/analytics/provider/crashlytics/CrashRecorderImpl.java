package com.avito.android.analytics.provider.crashlytics;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.preferences.Preferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/analytics/provider/crashlytics/CrashRecorderImpl;", "Lcom/avito/android/analytics/provider/crashlytics/CrashRecorder;", "", "recordUncaughtException", "()V", "", "getLastRecordedCrashTime", "()J", "cleanRecords", "Lcom/avito/android/server_time/TimeSource;", AuthSource.SEND_ABUSE, "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/preferences/Preferences;", "preferences", "<init>", "(Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/util/preferences/Preferences;)V", "analytics-firebase-crashlytics_release"}, k = 1, mv = {1, 4, 2})
public final class CrashRecorderImpl implements CrashRecorder {
    public final TimeSource a;
    public final Preferences b;

    @Inject
    public CrashRecorderImpl(@NotNull TimeSource timeSource, @NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.a = timeSource;
        this.b = preferences;
    }

    @Override // com.avito.android.analytics.provider.crashlytics.CrashRecorder
    public void cleanRecords() {
        this.b.putLong("LAST_UNCAUGHT_CRASH_TIME", 0);
    }

    @Override // com.avito.android.analytics.provider.crashlytics.CrashRecorder
    public long getLastRecordedCrashTime() {
        return this.b.getLong("LAST_UNCAUGHT_CRASH_TIME", 0);
    }

    @Override // com.avito.android.analytics.provider.crashlytics.CrashRecorder
    public void recordUncaughtException() {
        this.b.putLong("LAST_UNCAUGHT_CRASH_TIME", this.a.now());
    }
}
