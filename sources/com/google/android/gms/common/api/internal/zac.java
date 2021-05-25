package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
public abstract class zac {
    public final int zaa;

    public zac(int i) {
        this.zaa = i;
    }

    /* access modifiers changed from: private */
    public static Status zab(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void zaa(@NonNull Status status);

    public abstract void zaa(@NonNull zaw zaw, boolean z);

    public abstract void zaa(@NonNull Exception exc);

    public abstract void zac(GoogleApiManager.zaa<?> zaa2) throws DeadObjectException;
}
