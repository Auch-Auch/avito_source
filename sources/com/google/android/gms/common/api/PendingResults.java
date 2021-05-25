package com.google.android.gms.common.api;

import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
public final class PendingResults {

    public static final class zaa<R extends Result> extends BasePendingResult<R> {
        private final R zab;

        public zaa(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.zab = r;
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public final R createFailedResult(Status status) {
            return this.zab;
        }
    }

    public static final class zab<R extends Result> extends BasePendingResult<R> {
        private final R zab;

        public zab(R r) {
            super(Looper.getMainLooper());
            this.zab = r;
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public final R createFailedResult(Status status) {
            if (status.getStatusCode() == this.zab.getStatus().getStatusCode()) {
                return this.zab;
            }
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    public static final class zac<R extends Result> extends BasePendingResult<R> {
        public zac(@Nullable GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public final R createFailedResult(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    @KeepForSdk
    private PendingResults() {
    }

    @RecentlyNonNull
    public static PendingResult<Status> canceledPendingResult() {
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.cancel();
        return statusPendingResult;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <R extends Result> PendingResult<R> immediateFailedResult(@RecentlyNonNull R r, @RecentlyNonNull GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(r, "Result must not be null");
        Preconditions.checkArgument(!r.getStatus().isSuccess(), "Status code must not be SUCCESS");
        zaa zaa2 = new zaa(googleApiClient, r);
        zaa2.setResult(r);
        return zaa2;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static PendingResult<Status> immediatePendingResult(@RecentlyNonNull Status status) {
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }

    @RecentlyNonNull
    public static <R extends Result> PendingResult<R> canceledPendingResult(@RecentlyNonNull R r) {
        Preconditions.checkNotNull(r, "Result must not be null");
        Preconditions.checkArgument(r.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        zab zab2 = new zab(r);
        zab2.cancel();
        return zab2;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static PendingResult<Status> immediatePendingResult(@RecentlyNonNull Status status, @RecentlyNonNull GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(googleApiClient);
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(@RecentlyNonNull R r) {
        Preconditions.checkNotNull(r, "Result must not be null");
        zac zac2 = new zac(null);
        zac2.setResult(r);
        return new OptionalPendingResultImpl(zac2);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(@RecentlyNonNull R r, @RecentlyNonNull GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(r, "Result must not be null");
        zac zac2 = new zac(googleApiClient);
        zac2.setResult(r);
        return new OptionalPendingResultImpl(zac2);
    }
}
