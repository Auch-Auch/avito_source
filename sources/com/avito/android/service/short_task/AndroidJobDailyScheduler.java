package com.avito.android.service.short_task;

import android.os.Bundle;
import com.avito.android.util.Logs;
import com.evernote.android.job.DailyJob;
import com.evernote.android.job.JobRequest;
import com.facebook.applinks.AppLinkData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/service/short_task/AndroidJobDailyScheduler;", "Lcom/avito/android/service/short_task/ShortTaskDailyScheduler;", "Lcom/avito/android/service/short_task/ShortTask;", "task", "", "startMs", "endMs", "", "updateCurrent", "Landroid/os/Bundle;", AppLinkData.ARGUMENTS_EXTRAS_KEY, "", "schedule", "(Lcom/avito/android/service/short_task/ShortTask;JJZLandroid/os/Bundle;)V", "<init>", "()V", "job-scheduler_release"}, k = 1, mv = {1, 4, 2})
public final class AndroidJobDailyScheduler implements ShortTaskDailyScheduler {

    public static final class a implements JobRequest.JobScheduledCallback {
        public static final a a = new a();

        @Override // com.evernote.android.job.JobRequest.JobScheduledCallback
        public final void onJobScheduled(int i, @NotNull String str, @Nullable Exception exc) {
            Intrinsics.checkNotNullParameter(str, "tag");
            if (exc != null) {
                Logs.error("android-job", "Schedule async error " + str + ' ' + i, exc);
            }
        }
    }

    @Override // com.avito.android.service.short_task.ShortTaskDailyScheduler
    public void schedule(@NotNull ShortTask shortTask, long j, long j2, boolean z, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(shortTask, "task");
        DailyJob.scheduleAsync(new JobRequest.Builder(shortTask.getTag()).setRequiredNetworkType(ShortTasksKt.toAndroidJobNetworkState(shortTask.getRequiredNetworkState())).setRequiresCharging(true).setRequirementsEnforced(true).setUpdateCurrent(z), j, j2, a.a);
    }
}
