package com.avito.android.service.short_task;

import com.avito.android.service.short_task.ShortTask;
import com.evernote.android.job.DailyJob;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\t\u001a\u00020\b*\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/service/short_task/ShortTask$NetworkState;", "Lcom/evernote/android/job/JobRequest$NetworkType;", "toAndroidJobNetworkState", "(Lcom/avito/android/service/short_task/ShortTask$NetworkState;)Lcom/evernote/android/job/JobRequest$NetworkType;", "Lcom/avito/android/service/short_task/ShortTask$Status;", "Lcom/evernote/android/job/Job$Result;", "toAndroidJobResult", "(Lcom/avito/android/service/short_task/ShortTask$Status;)Lcom/evernote/android/job/Job$Result;", "Lcom/evernote/android/job/DailyJob$DailyJobResult;", "toAndroidJobDailyResult", "(Lcom/avito/android/service/short_task/ShortTask$Status;)Lcom/evernote/android/job/DailyJob$DailyJobResult;", "job-scheduler_release"}, k = 2, mv = {1, 4, 2})
public final class ShortTasksKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            ShortTask.NetworkState.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            ShortTask.Status.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[1] = 2;
            iArr2[2] = 3;
            ShortTask.Status.values();
            int[] iArr3 = new int[3];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[0] = 1;
            iArr3[2] = 2;
            iArr3[1] = 3;
        }
    }

    @NotNull
    public static final DailyJob.DailyJobResult toAndroidJobDailyResult(@NotNull ShortTask.Status status) {
        Intrinsics.checkNotNullParameter(status, "$this$toAndroidJobDailyResult");
        int ordinal = status.ordinal();
        if (ordinal == 0) {
            return DailyJob.DailyJobResult.SUCCESS;
        }
        if (ordinal == 1) {
            return DailyJob.DailyJobResult.CANCEL;
        }
        if (ordinal == 2) {
            return DailyJob.DailyJobResult.SUCCESS;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final JobRequest.NetworkType toAndroidJobNetworkState(@NotNull ShortTask.NetworkState networkState) {
        Intrinsics.checkNotNullParameter(networkState, "$this$toAndroidJobNetworkState");
        int ordinal = networkState.ordinal();
        if (ordinal == 0) {
            return JobRequest.NetworkType.ANY;
        }
        if (ordinal == 1) {
            return JobRequest.NetworkType.CONNECTED;
        }
        if (ordinal == 2) {
            return JobRequest.NetworkType.UNMETERED;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final Job.Result toAndroidJobResult(@NotNull ShortTask.Status status) {
        Intrinsics.checkNotNullParameter(status, "$this$toAndroidJobResult");
        int ordinal = status.ordinal();
        if (ordinal == 0) {
            return Job.Result.SUCCESS;
        }
        if (ordinal == 1) {
            return Job.Result.FAILURE;
        }
        if (ordinal == 2) {
            return Job.Result.RESCHEDULE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
