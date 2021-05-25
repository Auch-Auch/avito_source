package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zabz;
public abstract class ResultTransform<R extends Result, S extends Result> {
    @NonNull
    public final PendingResult<S> createFailedResult(@RecentlyNonNull Status status) {
        return new zabz(status);
    }

    @NonNull
    public Status onFailure(@RecentlyNonNull Status status) {
        return status;
    }

    @RecentlyNullable
    @WorkerThread
    public abstract PendingResult<S> onSuccess(@RecentlyNonNull R r);
}
