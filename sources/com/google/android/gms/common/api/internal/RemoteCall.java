package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
public interface RemoteCall<T, U> {
    @KeepForSdk
    void accept(@RecentlyNonNull T t, @RecentlyNonNull U u) throws RemoteException;
}
