package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;
public final class zack<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    @Nullable
    private ResultTransform<? super R, ? extends Result> zaa = null;
    @Nullable
    private zack<? extends Result> zab = null;
    @Nullable
    private volatile ResultCallbacks<? super R> zac = null;
    @Nullable
    private PendingResult<R> zad = null;
    private final Object zae = new Object();
    @Nullable
    private Status zaf = null;
    private final WeakReference<GoogleApiClient> zag;
    private final zacm zah;
    private boolean zai = false;

    public zack(WeakReference<GoogleApiClient> weakReference) {
        Preconditions.checkNotNull(weakReference, "GoogleApiClient reference must not be null");
        this.zag = weakReference;
        GoogleApiClient googleApiClient = weakReference.get();
        this.zah = new zacm(this, googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    @GuardedBy("mSyncToken")
    private final void zab() {
        if (this.zaa != null || this.zac != null) {
            GoogleApiClient googleApiClient = this.zag.get();
            if (!(this.zai || this.zaa == null || googleApiClient == null)) {
                googleApiClient.zaa(this);
                this.zai = true;
            }
            Status status = this.zaf;
            if (status != null) {
                zab(status);
                return;
            }
            PendingResult<R> pendingResult = this.zad;
            if (pendingResult != null) {
                pendingResult.setResultCallback(this);
            }
        }
    }

    @GuardedBy("mSyncToken")
    private final boolean zac() {
        return (this.zac == null || this.zag.get() == null) ? false : true;
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public final void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        synchronized (this.zae) {
            boolean z = true;
            Preconditions.checkState(this.zac == null, "Cannot call andFinally() twice.");
            if (this.zaa != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zac = resultCallbacks;
            zab();
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(R r) {
        synchronized (this.zae) {
            if (!r.getStatus().isSuccess()) {
                zaa(r.getStatus());
                zaa(r);
            } else if (this.zaa != null) {
                zaca.zaa().submit(new zacj(this, r));
            } else if (zac()) {
                ((ResultCallbacks) Preconditions.checkNotNull(this.zac)).onSuccess(r);
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    @NonNull
    public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        zack<? extends Result> zack;
        synchronized (this.zae) {
            boolean z = true;
            Preconditions.checkState(this.zaa == null, "Cannot call then() twice.");
            if (this.zac != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zaa = resultTransform;
            zack = new zack<>(this.zag);
            this.zab = zack;
            zab();
        }
        return zack;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.android.gms.common.api.PendingResult<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zaa(PendingResult<?> pendingResult) {
        synchronized (this.zae) {
            this.zad = pendingResult;
            zab();
        }
    }

    /* access modifiers changed from: private */
    public final void zaa(Status status) {
        synchronized (this.zae) {
            this.zaf = status;
            zab(status);
        }
    }

    public final void zaa() {
        this.zac = null;
    }

    /* access modifiers changed from: private */
    public static void zaa(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException unused) {
                String.valueOf(result).length();
            }
        }
    }

    private final void zab(Status status) {
        synchronized (this.zae) {
            ResultTransform<? super R, ? extends Result> resultTransform = this.zaa;
            if (resultTransform != null) {
                ((zack) Preconditions.checkNotNull(this.zab)).zaa((Status) Preconditions.checkNotNull(resultTransform.onFailure(status), "onFailure must not return null"));
            } else if (zac()) {
                ((ResultCallbacks) Preconditions.checkNotNull(this.zac)).onFailure(status);
            }
        }
    }
}
