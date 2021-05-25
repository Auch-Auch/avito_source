package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zztq;
import com.google.android.gms.internal.ads.zztw;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
public final class zzckb implements zzbsz, zzbtm, zzbuj, zzbvj, zzbxf, zzut {
    private final zzto zzgei;
    @GuardedBy("this")
    private boolean zzgej = false;

    public zzckb(zzto zzto, @Nullable zzdjf zzdjf) {
        this.zzgei = zzto;
        zzto.zza(zztq.zza.zzb.AD_REQUEST);
        if (zzdjf != null) {
            zzto.zza(zztq.zza.zzb.REQUEST_IS_PREFETCH);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final synchronized void onAdClicked() {
        if (!this.zzgej) {
            this.zzgei.zza(zztq.zza.zzb.AD_FIRST_CLICK);
            this.zzgej = true;
            return;
        }
        this.zzgei.zza(zztq.zza.zzb.AD_SUBSEQUENT_CLICK);
    }

    @Override // com.google.android.gms.internal.ads.zzbtm
    public final synchronized void onAdImpression() {
        this.zzgei.zza(zztq.zza.zzb.AD_IMPRESSION);
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final void onAdLoaded() {
        this.zzgei.zza(zztq.zza.zzb.AD_LOADED);
    }

    @Override // com.google.android.gms.internal.ads.zzbxf
    public final void zzajs() {
        this.zzgei.zza(zztq.zza.zzb.REQUEST_FAILED_TO_LOAD_FROM_CACHE);
    }

    @Override // com.google.android.gms.internal.ads.zzbvj
    public final void zzb(zzdlj zzdlj) {
        this.zzgei.zza(new zztn(zzdlj) { // from class: com.google.android.gms.internal.ads.zzcke
            private final zzdlj zzfte;

            {
                this.zzfte = r1;
            }

            @Override // com.google.android.gms.internal.ads.zztn
            public final void zza(zztw.zzi.zza zza) {
                zza.zza(((zztw.zza.zzb) zza.zznx().zzbfk()).zza(((zztw.zze.zza) zza.zznx().zznb().zzbfk()).zzbx(this.zzfte.zzhbq.zzhbn.zzdsg)));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbxf
    public final void zzbg(boolean z) {
        zztq.zza.zzb zzb;
        zzto zzto = this.zzgei;
        if (z) {
            zzb = zztq.zza.zzb.REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED;
        } else {
            zzb = zztq.zza.zzb.REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED;
        }
        zzto.zza(zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbxf
    public final void zzbh(boolean z) {
        zztq.zza.zzb zzb;
        zzto zzto = this.zzgei;
        if (z) {
            zzb = zztq.zza.zzb.NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED;
        } else {
            zzb = zztq.zza.zzb.NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED;
        }
        zzto.zza(zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbxf
    public final void zzc(zztw.zzb zzb) {
        this.zzgei.zza(new zztn(zzb) { // from class: com.google.android.gms.internal.ads.zzckd
            private final zztw.zzb zzftr;

            {
                this.zzftr = r1;
            }

            @Override // com.google.android.gms.internal.ads.zztn
            public final void zza(zztw.zzi.zza zza) {
                zza.zza(this.zzftr);
            }
        });
        this.zzgei.zza(zztq.zza.zzb.REQUEST_LOADED_FROM_CACHE);
    }

    @Override // com.google.android.gms.internal.ads.zzbvj
    public final void zzd(zzasp zzasp) {
    }

    @Override // com.google.android.gms.internal.ads.zzbxf
    public final void zzd(zztw.zzb zzb) {
        this.zzgei.zza(new zztn(zzb) { // from class: com.google.android.gms.internal.ads.zzckg
            private final zztw.zzb zzftr;

            {
                this.zzftr = r1;
            }

            @Override // com.google.android.gms.internal.ads.zztn
            public final void zza(zztw.zzi.zza zza) {
                zza.zza(this.zzftr);
            }
        });
        this.zzgei.zza(zztq.zza.zzb.REQUEST_SAVED_TO_CACHE);
    }

    @Override // com.google.android.gms.internal.ads.zzbxf
    public final void zze(zztw.zzb zzb) {
        this.zzgei.zza(new zztn(zzb) { // from class: com.google.android.gms.internal.ads.zzckf
            private final zztw.zzb zzftr;

            {
                this.zzftr = r1;
            }

            @Override // com.google.android.gms.internal.ads.zztn
            public final void zza(zztw.zzi.zza zza) {
                zza.zza(this.zzftr);
            }
        });
        this.zzgei.zza(zztq.zza.zzb.REQUEST_PREFETCH_INTERCEPTED);
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzg(zzuw zzuw) {
        switch (zzuw.errorCode) {
            case 1:
                this.zzgei.zza(zztq.zza.zzb.AD_FAILED_TO_LOAD_INVALID_REQUEST);
                return;
            case 2:
                this.zzgei.zza(zztq.zza.zzb.AD_FAILED_TO_LOAD_NETWORK_ERROR);
                return;
            case 3:
                this.zzgei.zza(zztq.zza.zzb.AD_FAILED_TO_LOAD_NO_FILL);
                return;
            case 4:
                this.zzgei.zza(zztq.zza.zzb.AD_FAILED_TO_LOAD_TIMEOUT);
                return;
            case 5:
                this.zzgei.zza(zztq.zza.zzb.AD_FAILED_TO_LOAD_CANCELLED);
                return;
            case 6:
                this.zzgei.zza(zztq.zza.zzb.AD_FAILED_TO_LOAD_NO_ERROR);
                return;
            case 7:
                this.zzgei.zza(zztq.zza.zzb.AD_FAILED_TO_LOAD_NOT_FOUND);
                return;
            default:
                this.zzgei.zza(zztq.zza.zzb.AD_FAILED_TO_LOAD);
                return;
        }
    }
}
