package com.avito.android.service.short_task;

import android.os.Bundle;
import com.avito.android.util.Logs;
import com.evernote.android.job.JobRequest;
import com.facebook.applinks.AppLinkData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/service/short_task/AndroidJobPeriodicScheduler;", "Lcom/avito/android/service/short_task/ShortTaskPeriodicScheduler;", "Lcom/avito/android/service/short_task/ShortTask;", "task", "", "periodMs", "", "updateCurrent", "Landroid/os/Bundle;", AppLinkData.ARGUMENTS_EXTRAS_KEY, "", "schedule", "(Lcom/avito/android/service/short_task/ShortTask;JZLandroid/os/Bundle;)V", "<init>", "()V", "job-scheduler_release"}, k = 1, mv = {1, 4, 2})
public final class AndroidJobPeriodicScheduler implements ShortTaskPeriodicScheduler {

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

    @Override // com.avito.android.service.short_task.ShortTaskPeriodicScheduler
    public void schedule(@NotNull ShortTask shortTask, long j, boolean z, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(shortTask, "task");
        new JobRequest.Builder(shortTask.getTag()).setPeriodic(j).setRequiredNetworkType(ShortTasksKt.toAndroidJobNetworkState(shortTask.getRequiredNetworkState())).setRequiresCharging(true).setRequirementsEnforced(true).setUpdateCurrent(z).build().scheduleAsync(a.a);
    }
}
