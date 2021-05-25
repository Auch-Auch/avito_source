package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
public final class zzcvu implements zzbuf {
    private final /* synthetic */ zzcrg zzgnw;
    private boolean zzgol = false;
    private final /* synthetic */ zzbbq zzgom;
    private final /* synthetic */ zzcvp zzgon;

    public zzcvu(zzcvp zzcvp, zzcrg zzcrg, zzbbq zzbbq) {
        this.zzgon = zzcvp;
        this.zzgnw = zzcrg;
        this.zzgom = zzbbq;
    }

    private final void zzi(zzuw zzuw) {
        int i = zzdmd.zzhco;
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcuk)).booleanValue()) {
            i = zzdmd.zzhcq;
        }
        this.zzgom.setException(new zzcri(i, zzuw));
    }

    @Override // com.google.android.gms.internal.ads.zzbuf
    public final void onAdFailedToLoad(int i) {
        if (!this.zzgol) {
            zzi(new zzuw(i, zzcvp.zza(this.zzgnw.zzfqh, i), AdError.UNDEFINED_DOMAIN, null));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuf
    public final synchronized void onAdLoaded() {
        this.zzgom.set(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbuf
    public final synchronized void zzf(int i, @Nullable String str) {
        if (!this.zzgol) {
            this.zzgol = true;
            if (str == null) {
                str = zzcvp.zza(this.zzgnw.zzfqh, i);
            }
            zzi(new zzuw(i, str, AdError.UNDEFINED_DOMAIN, null));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuf
    public final synchronized void zzg(zzuw zzuw) {
        this.zzgol = true;
        zzi(zzuw);
    }
}
