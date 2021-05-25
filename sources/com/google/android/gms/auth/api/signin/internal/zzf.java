package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import androidx.loader.content.AsyncTaskLoader;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
public final class zzf extends AsyncTaskLoader<Void> implements SignInConnectionListener {
    private Semaphore zzce = new Semaphore(0);
    private Set<GoogleApiClient> zzcf;

    public zzf(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.zzcf = set;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzj */
    public final Void loadInBackground() {
        int i = 0;
        for (GoogleApiClient googleApiClient : this.zzcf) {
            if (googleApiClient.maybeSignIn(this)) {
                i++;
            }
        }
        try {
            this.zzce.tryAcquire(i, 5, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // com.google.android.gms.common.api.internal.SignInConnectionListener
    public final void onComplete() {
        this.zzce.release();
    }

    @Override // androidx.loader.content.Loader
    public final void onStartLoading() {
        this.zzce.drainPermits();
        forceLoad();
    }
}
