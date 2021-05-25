package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;
public interface IAccountAccessor extends IInterface {

    public static abstract class Stub extends com.google.android.gms.internal.common.zza implements IAccountAccessor {

        public static class zza extends zzb implements IAccountAccessor {
            public zza(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // com.google.android.gms.common.internal.IAccountAccessor
            public final Account zza() throws RemoteException {
                Parcel zza = zza(2, a_());
                Account account = (Account) zzd.zza(zza, Account.CREATOR);
                zza.recycle();
                return account;
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.IAccountAccessor");
        }

        @RecentlyNonNull
        public static IAccountAccessor asInterface(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof IAccountAccessor) {
                return (IAccountAccessor) queryLocalInterface;
            }
            return new zza(iBinder);
        }

        @Override // com.google.android.gms.internal.common.zza
        @RecentlyNonNull
        public final boolean zza(@RecentlyNonNull int i, @RecentlyNonNull Parcel parcel, @RecentlyNonNull Parcel parcel2, @RecentlyNonNull int i2) throws RemoteException {
            if (i != 2) {
                return false;
            }
            Account zza2 = zza();
            parcel2.writeNoException();
            zzd.zzb(parcel2, zza2);
            return true;
        }
    }

    @RecentlyNonNull
    Account zza() throws RemoteException;
}
