package com.google.android.gms.internal.p001authapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
/* renamed from: com.google.android.gms.internal.auth-api.zzai  reason: invalid package */
public final class zzai extends IStatusCallback.Stub {
    private final /* synthetic */ TaskCompletionSource zzbn;

    public zzai(zzaf zzaf, TaskCompletionSource taskCompletionSource) {
        this.zzbn = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) throws RemoteException {
        TaskUtil.setResultOrApiException(status, this.zzbn);
    }
}
