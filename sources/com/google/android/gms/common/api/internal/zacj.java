package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;
public final class zacj implements Runnable {
    private final /* synthetic */ Result zaa;
    private final /* synthetic */ zack zab;

    public zacj(zack zack, Result result) {
        this.zab = zack;
        this.zaa = result;
    }

    @Override // java.lang.Runnable
    @WorkerThread
    public final void run() {
        try {
            ThreadLocal<Boolean> threadLocal = BasePendingResult.zaa;
            threadLocal.set(Boolean.TRUE);
            this.zab.zah.sendMessage(this.zab.zah.obtainMessage(0, ((ResultTransform) Preconditions.checkNotNull(this.zab.zaa)).onSuccess(this.zaa)));
            threadLocal.set(Boolean.FALSE);
            zack zack = this.zab;
            zack.zaa(this.zaa);
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zab.zag.get();
            if (googleApiClient != null) {
                googleApiClient.zab(this.zab);
            }
        } catch (RuntimeException e) {
            this.zab.zah.sendMessage(this.zab.zah.obtainMessage(1, e));
            BasePendingResult.zaa.set(Boolean.FALSE);
            zack zack2 = this.zab;
            zack.zaa(this.zaa);
            GoogleApiClient googleApiClient2 = (GoogleApiClient) this.zab.zag.get();
            if (googleApiClient2 != null) {
                googleApiClient2.zab(this.zab);
            }
        } catch (Throwable th) {
            BasePendingResult.zaa.set(Boolean.FALSE);
            zack zack3 = this.zab;
            zack.zaa(this.zaa);
            GoogleApiClient googleApiClient3 = (GoogleApiClient) this.zab.zag.get();
            if (googleApiClient3 != null) {
                googleApiClient3.zab(this.zab);
            }
            throw th;
        }
    }
}
