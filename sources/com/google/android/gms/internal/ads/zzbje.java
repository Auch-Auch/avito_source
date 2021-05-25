package com.google.android.gms.internal.ads;
public final class zzbje implements zzcbq {
    private zzbxj zzetx;
    private zzbsg zzety;
    private zzcbj zzetz;
    private zzdlj zzeua;
    private zzdjf zzeub;
    private zzdij zzeuc;
    private final /* synthetic */ zzbjc zzeud;

    private zzbje(zzbjc zzbjc) {
        this.zzeud = zzbjc;
    }

    @Override // com.google.android.gms.internal.ads.zzcbq
    public final /* synthetic */ zzcbq zza(zzcbj zzcbj) {
        this.zzetz = (zzcbj) zzelu.checkNotNull(zzcbj);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcbq
    /* renamed from: zzaek */
    public final zzcbn zzael() {
        zzelu.zza(this.zzetx, zzbxj.class);
        zzelu.zza(this.zzety, zzbsg.class);
        zzelu.zza(this.zzetz, zzcbj.class);
        return new zzbjh(this.zzeud, this.zzetz, new zzbqh(), new zzdmi(), new zzbrq(), new zzclw(), this.zzetx, this.zzety, new zzdmq(), this.zzeua, this.zzeub, this.zzeuc);
    }

    @Override // com.google.android.gms.internal.ads.zzcbq
    public final /* synthetic */ zzcbq zza(zzbsg zzbsg) {
        this.zzety = (zzbsg) zzelu.checkNotNull(zzbsg);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcbq
    public final /* synthetic */ zzcbq zza(zzbxj zzbxj) {
        this.zzetx = (zzbxj) zzelu.checkNotNull(zzbxj);
        return this;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbsd' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbsd
    public final /* synthetic */ zzbsd<zzcbn> zza(zzdij zzdij) {
        this.zzeuc = zzdij;
        return this;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbsd' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbsd
    public final /* synthetic */ zzbsd<zzcbn> zza(zzdjf zzdjf) {
        this.zzeub = zzdjf;
        return this;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbsd' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbsd
    public final /* synthetic */ zzbsd<zzcbn> zza(zzdlj zzdlj) {
        this.zzeua = zzdlj;
        return this;
    }
}
