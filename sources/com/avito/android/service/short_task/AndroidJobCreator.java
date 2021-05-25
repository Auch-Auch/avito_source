package com.avito.android.service.short_task;

import a2.a.a.o2.a.b;
import com.avito.android.remote.auth.AuthSource;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/service/short_task/AndroidJobCreator;", "Lcom/evernote/android/job/JobCreator;", "", "tag", "Lcom/evernote/android/job/Job;", "create", "(Ljava/lang/String;)Lcom/evernote/android/job/Job;", "Lcom/avito/android/service/short_task/ShortTaskFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/service/short_task/ShortTaskFactory;", "shortTaskFactory", "Lcom/avito/android/service/short_task/RunJobFailedListener;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/service/short_task/RunJobFailedListener;", "runJobFailedListener", "<init>", "(Lcom/avito/android/service/short_task/ShortTaskFactory;Lcom/avito/android/service/short_task/RunJobFailedListener;)V", "job-scheduler_release"}, k = 1, mv = {1, 4, 2})
public final class AndroidJobCreator implements JobCreator {
    public final ShortTaskFactory a;
    public final RunJobFailedListener b;

    public AndroidJobCreator(@NotNull ShortTaskFactory shortTaskFactory, @NotNull RunJobFailedListener runJobFailedListener) {
        Intrinsics.checkNotNullParameter(shortTaskFactory, "shortTaskFactory");
        Intrinsics.checkNotNullParameter(runJobFailedListener, "runJobFailedListener");
        this.a = shortTaskFactory;
        this.b = runJobFailedListener;
    }

    @Override // com.evernote.android.job.JobCreator
    @Nullable
    public Job create(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        ShortTask createTask = this.a.createTask(str);
        if (createTask != null) {
            return new b(createTask, this.b);
        }
        return null;
    }
}
