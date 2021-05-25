package com.avito.android.app.task;

import android.app.Application;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.clickstream.ClickStreamEventTrackerImplKt;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.analytics.provider.crashlytics.CrashRecorder;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/app/task/SendCrashRecordsToClickStreamTask;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "execute", "(Landroid/app/Application;)V", "Lcom/avito/android/analytics/provider/crashlytics/CrashRecorder;", "crashRecorder", "Lcom/avito/android/analytics/provider/crashlytics/CrashRecorder;", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "<init>", "(Lcom/avito/android/analytics/provider/crashlytics/CrashRecorder;Lcom/avito/android/analytics/Analytics;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class SendCrashRecordsToClickStreamTask implements ApplicationBackgroundStartupTask {
    public final Analytics analytics;
    public final CrashRecorder crashRecorder;

    public SendCrashRecordsToClickStreamTask(@NotNull CrashRecorder crashRecorder2, @NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(crashRecorder2, "crashRecorder");
        Intrinsics.checkNotNullParameter(analytics2, "analytics");
        this.crashRecorder = crashRecorder2;
        this.analytics = analytics2;
    }

    @Override // com.avito.android.app.task.ApplicationBackgroundStartupTask
    public void execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        long lastRecordedCrashTime = this.crashRecorder.getLastRecordedCrashTime();
        if (lastRecordedCrashTime != 0) {
            this.analytics.track(new ParametrizedClickStreamEvent(2638, 0, q.mapOf(TuplesKt.to(ClickStreamEventTrackerImplKt.CLIENT_TIMESTAMP_MS, Long.valueOf(lastRecordedCrashTime))), null, 8, null));
            this.crashRecorder.cleanRecords();
        }
    }
}
