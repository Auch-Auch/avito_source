package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.IAccountAccessor;
public class AccountAccessor extends IAccountAccessor.Stub {
    @RecentlyNullable
    @KeepForSdk
    public static Account getAccountBinderSafe(@RecentlyNonNull IAccountAccessor iAccountAccessor) {
        if (iAccountAccessor != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return iAccountAccessor.zza();
            } catch (RemoteException unused) {
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public boolean equals(@Nullable Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.common.internal.IAccountAccessor
    @RecentlyNonNull
    public final Account zza() {
        throw new NoSuchMethodError();
    }
}
