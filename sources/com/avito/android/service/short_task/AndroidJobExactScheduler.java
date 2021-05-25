package com.avito.android.service.short_task;

import android.app.Application;
import android.os.Bundle;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.evernote.android.job.JobApi;
import com.evernote.android.job.JobConfig;
import com.evernote.android.job.JobCreator;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobManagerCreateException;
import com.evernote.android.job.JobRequest;
import com.facebook.applinks.AppLinkData;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0019\u0010\u001aJ1\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/service/short_task/AndroidJobExactScheduler;", "Lcom/avito/android/service/short_task/ShortTaskExactScheduler;", "Lcom/avito/android/service/short_task/ShortTask;", "task", "Lkotlin/ranges/LongRange;", "execWindowMs", "", "updateCurrent", "Landroid/os/Bundle;", AppLinkData.ARGUMENTS_EXTRAS_KEY, "", "schedule", "(Lcom/avito/android/service/short_task/ShortTask;Lkotlin/ranges/LongRange;ZLandroid/os/Bundle;)V", "Ldagger/Lazy;", "Lcom/evernote/android/job/JobCreator;", "c", "Ldagger/Lazy;", "jobCreator", "Landroid/app/Application;", AuthSource.BOOKING_ORDER, "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, AuthSource.SEND_ABUSE, "Z", "isInited", "<init>", "(Landroid/app/Application;Ldagger/Lazy;)V", "job-scheduler_release"}, k = 1, mv = {1, 4, 2})
public final class AndroidJobExactScheduler implements ShortTaskExactScheduler {
    public boolean a;
    public final Application b;
    public final Lazy<JobCreator> c;

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

    public AndroidJobExactScheduler(@NotNull Application application, @NotNull Lazy<JobCreator> lazy) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(lazy, "jobCreator");
        this.b = application;
        this.c = lazy;
    }

    @Override // com.avito.android.service.short_task.ShortTaskExactScheduler
    public void schedule(@NotNull ShortTask shortTask, @NotNull LongRange longRange, boolean z, @Nullable Bundle bundle) {
        JobManager jobManager;
        Intrinsics.checkNotNullParameter(shortTask, "task");
        Intrinsics.checkNotNullParameter(longRange, "execWindowMs");
        synchronized (this) {
            if (!this.a) {
                JobConfig.setApiEnabled(JobApi.GCM, false);
                try {
                    jobManager = JobManager.create(this.b);
                } catch (JobManagerCreateException unused) {
                    JobConfig.setForceAllowApi14(true);
                    jobManager = JobManager.create(this.b);
                }
                jobManager.addJobCreator(this.c.get());
                this.a = true;
            }
        }
        new JobRequest.Builder(shortTask.getTag()).setExecutionWindow(longRange.getStart().longValue(), longRange.getEndInclusive().longValue()).setRequiredNetworkType(ShortTasksKt.toAndroidJobNetworkState(shortTask.getRequiredNetworkState())).setUpdateCurrent(z).setExtras(bundle != null ? BundlesKt.toPersistableBundleCompat(bundle) : null).build().scheduleAsync(a.a);
    }
}
