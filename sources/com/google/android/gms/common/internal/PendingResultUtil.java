package com.google.android.gms.common.internal;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
@KeepForSdk
public class PendingResultUtil {
    private static final zaa zaa = new zan();

    @KeepForSdk
    public interface ResultConverter<R extends Result, T> {
        @RecentlyNonNull
        @KeepForSdk
        T convert(@RecentlyNonNull R r);
    }

    public interface zaa {
        ApiException zaa(Status status);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <R extends Result, T extends Response<R>> Task<T> toResponseTask(@RecentlyNonNull PendingResult<R> pendingResult, @RecentlyNonNull T t) {
        return toTask(pendingResult, new zao(t));
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <R extends Result, T> Task<T> toTask(@RecentlyNonNull PendingResult<R> pendingResult, @RecentlyNonNull ResultConverter<R, T> resultConverter) {
        zaa zaa2 = zaa;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new zap(pendingResult, taskCompletionSource, resultConverter, zaa2));
        return taskCompletionSource.getTask();
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <R extends Result> Task<Void> toVoidTask(@RecentlyNonNull PendingResult<R> pendingResult) {
        return toTask(pendingResult, new zaq());
    }
}
