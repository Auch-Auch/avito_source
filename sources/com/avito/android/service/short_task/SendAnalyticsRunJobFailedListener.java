package com.avito.android.service.short_task;

import a2.b.a.a.a;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/service/short_task/SendAnalyticsRunJobFailedListener;", "Lcom/avito/android/service/short_task/RunJobFailedListener;", "Lcom/avito/android/service/short_task/ShortTask;", "shortTask", "", "error", "", "onRunJobFailed", "(Lcom/avito/android/service/short_task/ShortTask;Ljava/lang/Throwable;)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class SendAnalyticsRunJobFailedListener implements RunJobFailedListener {
    public final Analytics a;

    public SendAnalyticsRunJobFailedListener(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = analytics;
    }

    @Override // com.avito.android.service.short_task.RunJobFailedListener
    public void onRunJobFailed(@NotNull ShortTask shortTask, @NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(shortTask, "shortTask");
        Intrinsics.checkNotNullParameter(th, "error");
        Analytics analytics = this.a;
        StringBuilder L = a.L("Cannot run task with tag ");
        L.append(shortTask.getTag());
        analytics.track(new NonFatalError(L.toString(), th, null, 4, null));
    }
}
