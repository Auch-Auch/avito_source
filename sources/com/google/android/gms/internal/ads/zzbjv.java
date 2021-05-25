package com.google.android.gms.internal.ads;
public final class zzbjv implements zzcau {
    private zzbxj zzetx;
    private zzbsg zzety;
    private zzdlj zzeua;
    private zzdjf zzeub;
    private zzdij zzeuc;
    private final /* synthetic */ zzbjc zzeud;
    private zzcwh zzfga;

    private zzbjv(zzbjc zzbjc) {
        this.zzeud = zzbjc;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbsd' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbsd
    public final /* synthetic */ zzbsd<zzcar> zza(zzdij zzdij) {
        this.zzeuc = zzdij;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcau
    /* renamed from: zzafz */
    public final zzcar zzael() {
        zzelu.zza(this.zzetx, zzbxj.class);
        zzelu.zza(this.zzety, zzbsg.class);
        zzelu.zza(this.zzfga, zzcwh.class);
        return new zzbju(this.zzeud, new zzbqh(), new zzdmi(), new zzbrq(), new zzclw(), this.zzetx, this.zzety, new zzdmq(), this.zzfga, this.zzeua, this.zzeub, this.zzeuc);
    }

    @Override // com.google.android.gms.internal.ads.zzcau
    public final /* synthetic */ zzcau zzb(zzcwh zzcwh) {
        this.zzfga = (zzcwh) zzelu.checkNotNull(zzcwh);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcau
    public final /* synthetic */ zzcau zzd(zzbsg zzbsg) {
        this.zzety = (zzbsg) zzelu.checkNotNull(zzbsg);
        return this;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbsd' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbsd
    public final /* synthetic */ zzbsd<zzcar> zza(zzdjf zzdjf) {
        this.zzeub = zzdjf;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcau
    public final /* synthetic */ zzcau zzd(zzbxj zzbxj) {
        this.zzetx = (zzbxj) zzelu.checkNotNull(zzbxj);
        return this;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbsd' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbsd
    public final /* synthetic */ zzbsd<zzcar> zza(zzdlj zzdlj) {
        this.zzeua = zzdlj;
        return this;
    }
}
