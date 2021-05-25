package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
public final class zzaga extends RemoteCreator<zzaeb> {
    @VisibleForTesting
    public zzaga() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ zzaeb getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        if (queryLocalInterface instanceof zzaeb) {
            return (zzaeb) queryLocalInterface;
        }
        return new zzaee(iBinder);
    }

    public final zzaea zzb(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        try {
            IBinder zza = ((zzaeb) getRemoteCreatorInstance(context)).zza(ObjectWrapper.wrap(context), ObjectWrapper.wrap(frameLayout), ObjectWrapper.wrap(frameLayout2), 202006000);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            if (queryLocalInterface instanceof zzaea) {
                return (zzaea) queryLocalInterface;
            }
            return new zzaec(zza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbbd.zzd("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }
}
