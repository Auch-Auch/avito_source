package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;
public abstract class zae<T> extends zab {
    public final TaskCompletionSource<T> zab;

    public zae(int i, TaskCompletionSource<T> taskCompletionSource) {
        super(i);
        this.zab = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public void zaa(@NonNull Status status) {
        this.zab.trySetException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public void zaa(@NonNull zaw zaw, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zac(GoogleApiManager.zaa<?> zaa) throws DeadObjectException {
        try {
            zad(zaa);
        } catch (DeadObjectException e) {
            zaa(zac.zab(e));
            throw e;
        } catch (RemoteException e2) {
            zaa(zac.zab(e2));
        } catch (RuntimeException e3) {
            zaa(e3);
        }
    }

    public abstract void zad(GoogleApiManager.zaa<?> zaa) throws RemoteException;

    @Override // com.google.android.gms.common.api.internal.zac
    public void zaa(@NonNull Exception exc) {
        this.zab.trySetException(exc);
    }
}
