package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
public final class zzzq extends zzauk {
    @Override // com.google.android.gms.internal.ads.zzaul
    public final Bundle getAdMetadata() throws RemoteException {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final String getMediationAdapterClassName() throws RemoteException {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final boolean isLoaded() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final void zza(IObjectWrapper iObjectWrapper, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final void zza(zzaum zzaum) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final void zza(zzauu zzauu) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final void zza(zzavc zzavc) {
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final void zza(zzvc zzvc, zzaut zzaut) throws RemoteException {
        zza(zzaut);
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final void zza(zzxz zzxz) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final void zza(zzya zzya) {
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final void zzb(zzvc zzvc, zzaut zzaut) throws RemoteException {
        zza(zzaut);
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final zzyf zzkg() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    @Nullable
    public final zzaug zzqw() {
        return null;
    }

    private static void zza(zzaut zzaut) {
        zzbbd.zzfc("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzbat.zzaah.post(new Runnable(zzaut) { // from class: com.google.android.gms.internal.ads.zzzp
            private final zzaut zzcko;

            {
                this.zzcko = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzaut zzaut2 = this.zzcko;
                if (zzaut2 != null) {
                    try {
                        zzaut2.onRewardedAdFailedToLoad(1);
                    } catch (RemoteException e) {
                        zzbbd.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        });
    }
}
