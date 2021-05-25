package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
public final class zzzd extends RemoteCreator<zzxp> {
    public zzzd() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ zzxp getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        if (queryLocalInterface instanceof zzxp) {
            return (zzxp) queryLocalInterface;
        }
        return new zzxo(iBinder);
    }

    public final zzxk zzi(Context context) {
        try {
            IBinder zzb = ((zzxp) getRemoteCreatorInstance(context)).zzb(ObjectWrapper.wrap(context), 202006000);
            if (zzb == null) {
                return null;
            }
            IInterface queryLocalInterface = zzb.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzxk) {
                return (zzxk) queryLocalInterface;
            }
            return new zzxm(zzb);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbbd.zzd("Could not get remote MobileAdsSettingManager.", e);
            return null;
        }
    }
}
