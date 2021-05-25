package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.util.VisibleForTesting;
public final class zzcxb extends zzwq {
    private zzwl zzbpf;
    private final zzbii zzgmy;
    private final Context zzgpr;
    @VisibleForTesting
    private final zzdlp zzgps;
    @VisibleForTesting
    private final zzcdi zzgpt = new zzcdi();

    public zzcxb(zzbii zzbii, Context context, String str) {
        zzdlp zzdlp = new zzdlp();
        this.zzgps = zzdlp;
        this.zzgmy = zzbii;
        zzdlp.zzgt(str);
        this.zzgpr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void zza(zzaew zzaew) {
        this.zzgpt.zzb(zzaew);
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void zzb(zzwl zzwl) {
        this.zzbpf = zzwl;
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final zzwm zzqc() {
        zzcdg zzamk = this.zzgpt.zzamk();
        this.zzgps.zzc(zzamk.zzamh());
        this.zzgps.zzd(zzamk.zzami());
        zzdlp zzdlp = this.zzgps;
        if (zzdlp.zzke() == null) {
            zzdlp.zze(zzvj.zzpi());
        }
        return new zzcxe(this.zzgpr, this.zzgmy, this.zzgps, zzamk, this.zzbpf);
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void zza(zzafl zzafl) {
        this.zzgpt.zzb(zzafl);
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void zzb(zzxi zzxi) {
        this.zzgps.zzc(zzxi);
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void zza(zzaex zzaex) {
        this.zzgpt.zzb(zzaex);
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void zza(String str, zzafd zzafd, zzafc zzafc) {
        this.zzgpt.zzb(str, zzafd, zzafc);
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void zza(zzadm zzadm) {
        this.zzgps.zzb(zzadm);
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void zza(zzair zzair) {
        this.zzgps.zzb(zzair);
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void zza(zzaiz zzaiz) {
        this.zzgpt.zzb(zzaiz);
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void zza(zzafk zzafk, zzvj zzvj) {
        this.zzgpt.zza(zzafk);
        this.zzgps.zze(zzvj);
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzgps.zzb(publisherAdViewOptions);
    }
}
