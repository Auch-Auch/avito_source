package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;
public final class zzdkl extends zzauk {
    private final String zzbuo;
    private final zzdli zzfsl;
    private final Context zzgpr;
    private final zzdkd zzgzu;
    private final zzdje zzgzv;
    @Nullable
    @GuardedBy("this")
    private zzchu zzgzw;

    public zzdkl(@Nullable String str, zzdkd zzdkd, Context context, zzdje zzdje, zzdli zzdli) {
        this.zzbuo = str;
        this.zzgzu = zzdkd;
        this.zzgzv = zzdje;
        this.zzfsl = zzdli;
        this.zzgpr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzchu zzchu = this.zzgzw;
        return zzchu != null ? zzchu.getAdMetadata() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        zzchu zzchu = this.zzgzw;
        if (zzchu == null || zzchu.zzaim() == null) {
            return null;
        }
        return this.zzgzw.zzaim().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final boolean isLoaded() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzchu zzchu = this.zzgzw;
        return zzchu != null && !zzchu.zzanh();
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final synchronized void zza(zzvc zzvc, zzaut zzaut) throws RemoteException {
        zza(zzvc, zzaut, zzdlf.zzhbi);
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final synchronized void zzb(zzvc zzvc, zzaut zzaut) throws RemoteException {
        zza(zzvc, zzaut, zzdlf.zzhbj);
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final synchronized void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        zza(iObjectWrapper, false);
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final zzyf zzkg() {
        zzchu zzchu;
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcwy)).booleanValue() && (zzchu = this.zzgzw) != null) {
            return zzchu.zzaim();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    @Nullable
    public final zzaug zzqw() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzchu zzchu = this.zzgzw;
        if (zzchu != null) {
            return zzchu.zzqw();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final synchronized void zza(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzgzw == null) {
            zzbbd.zzfe("Rewarded can not be shown before loaded");
            this.zzgzv.zzf(zzdmb.zza(zzdmd.zzhcw, null, null));
            return;
        }
        this.zzgzw.zzb(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final void zza(zzaum zzaum) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgzv.zzb(zzaum);
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final void zza(zzauu zzauu) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgzv.zzb(zzauu);
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final void zza(zzxz zzxz) {
        if (zzxz == null) {
            this.zzgzv.zza(null);
        } else {
            this.zzgzv.zza(new zzdkk(this, zzxz));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final synchronized void zza(zzavc zzavc) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdli zzdli = this.zzfsl;
        zzdli.zzdve = zzavc.zzdve;
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcod)).booleanValue()) {
            zzdli.zzdvf = zzavc.zzdvf;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final void zza(zzya zzya) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        this.zzgzv.zzc(zzya);
    }

    private final synchronized void zza(zzvc zzvc, zzaut zzaut, int i) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgzv.zzb(zzaut);
        zzp.zzkp();
        if (zzayh.zzbe(this.zzgpr) && zzvc.zzchi == null) {
            zzbbd.zzfc("Failed to load the ad because app ID is missing.");
            this.zzgzv.zzg(zzdmb.zza(zzdmd.zzhcr, null, null));
        } else if (this.zzgzw == null) {
            zzdka zzdka = new zzdka(null);
            this.zzgzu.zzea(i);
            this.zzgzu.zza(zzvc, this.zzbuo, zzdka, new zzdkn(this));
        }
    }
}
