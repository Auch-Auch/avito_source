package com.google.firebase.dynamiclinks.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.firebase_dynamic_links.zzb;
import com.google.android.gms.internal.firebase_dynamic_links.zzd;
public final class zzp extends zzb implements zzm {
    public zzp(IBinder iBinder) {
        super(iBinder, "com.google.firebase.dynamiclinks.internal.IDynamicLinksService");
    }

    @Override // com.google.firebase.dynamiclinks.internal.zzm
    public final void zza(zzk zzk, String str) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzk);
        zza.writeString(str);
        zza(1, zza);
    }

    @Override // com.google.firebase.dynamiclinks.internal.zzm
    public final void zza(zzk zzk, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzk);
        zzd.zza(zza, bundle);
        zza(2, zza);
    }
}
