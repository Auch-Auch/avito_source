package com.google.android.gms.internal.ads;
public final class zzbjy implements zzcia {
    private zzbxj zzetx;
    private zzbsg zzety;
    private zzdlj zzeua;
    private zzdjf zzeub;
    private zzdij zzeuc;
    private final /* synthetic */ zzbjc zzeud;

    private zzbjy(zzbjc zzbjc) {
        this.zzeud = zzbjc;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbsd' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbsd
    public final /* synthetic */ zzbsd<zzchx> zza(zzdij zzdij) {
        this.zzeuc = zzdij;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcia
    /* renamed from: zzage */
    public final zzchx zzael() {
        zzelu.zza(this.zzetx, zzbxj.class);
        zzelu.zza(this.zzety, zzbsg.class);
        return new zzbkb(this.zzeud, new zzbqh(), new zzdmi(), new zzbrq(), new zzclw(), this.zzetx, this.zzety, new zzdmq(), this.zzeua, this.zzeub, this.zzeuc);
    }

    @Override // com.google.android.gms.internal.ads.zzcia
    public final /* synthetic */ zzcia zze(zzbsg zzbsg) {
        this.zzety = (zzbsg) zzelu.checkNotNull(zzbsg);
        return this;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbsd' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbsd
    public final /* synthetic */ zzbsd<zzchx> zza(zzdjf zzdjf) {
        this.zzeub = zzdjf;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcia
    public final /* synthetic */ zzcia zze(zzbxj zzbxj) {
        this.zzetx = (zzbxj) zzelu.checkNotNull(zzbxj);
        return this;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbsd' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbsd
    public final /* synthetic */ zzbsd<zzchx> zza(zzdlj zzdlj) {
        this.zzeua = zzdlj;
        return this;
    }
}
