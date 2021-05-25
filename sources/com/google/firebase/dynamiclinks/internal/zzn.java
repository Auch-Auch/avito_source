package com.google.firebase.dynamiclinks.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_dynamic_links.zza;
import com.google.android.gms.internal.firebase_dynamic_links.zzd;
public abstract class zzn extends zza implements zzk {
    public zzn() {
        super("com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks");
    }

    @Override // com.google.android.gms.internal.firebase_dynamic_links.zza
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zza((Status) zzd.zza(parcel, Status.CREATOR), (DynamicLinkData) zzd.zza(parcel, DynamicLinkData.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            zza((Status) zzd.zza(parcel, Status.CREATOR), (zzo) zzd.zza(parcel, zzo.CREATOR));
        }
        return true;
    }
}
