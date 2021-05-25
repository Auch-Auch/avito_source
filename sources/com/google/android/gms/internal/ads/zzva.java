package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
public final class zzva extends RemoteCreator<zzwz> {
    @VisibleForTesting
    public zzva() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ zzwz getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (queryLocalInterface instanceof zzwz) {
            return (zzwz) queryLocalInterface;
        }
        return new zzwy(iBinder);
    }

    public final zzwu zza(Context context, zzvj zzvj, String str, zzamu zzamu, int i) {
        try {
            IBinder zza = ((zzwz) getRemoteCreatorInstance(context)).zza(ObjectWrapper.wrap(context), zzvj, str, zzamu, 202006000, i);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzwu) {
                return (zzwu) queryLocalInterface;
            }
            return new zzww(zza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbbd.zzb("Could not create remote AdManager.", e);
            return null;
        }
    }
}
