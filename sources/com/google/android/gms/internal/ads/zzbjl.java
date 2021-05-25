package com.google.android.gms.internal.ads;
public final class zzbjl implements zzbmv {
    private zzbxj zzetx;
    private zzbsg zzety;
    private zzdlj zzeua;
    private zzdjf zzeub;
    private zzdij zzeuc;
    private final /* synthetic */ zzbjc zzeud;

    private zzbjl(zzbjc zzbjc) {
        this.zzeud = zzbjc;
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    @Deprecated
    public final /* synthetic */ zzbmv zza(zzbnd zzbnd) {
        zzelu.checkNotNull(zzbnd);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    /* renamed from: zzafl */
    public final zzbmw zzael() {
        zzelu.zza(this.zzetx, zzbxj.class);
        zzelu.zza(this.zzety, zzbsg.class);
        return new zzbjk(this.zzeud, new zzbqh(), new zzdmi(), new zzbrq(), new zzclw(), this.zzetx, this.zzety, new zzdmq(), this.zzeua, this.zzeub, this.zzeuc);
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final /* synthetic */ zzbmv zzb(zzbsg zzbsg) {
        this.zzety = (zzbsg) zzelu.checkNotNull(zzbsg);
        return this;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbsd' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbsd
    public final /* synthetic */ zzbsd<zzbmw> zza(zzdij zzdij) {
        this.zzeuc = zzdij;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbmv
    public final /* synthetic */ zzbmv zzb(zzbxj zzbxj) {
        this.zzetx = (zzbxj) zzelu.checkNotNull(zzbxj);
        return this;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbsd' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbsd
    public final /* synthetic */ zzbsd<zzbmw> zza(zzdjf zzdjf) {
        this.zzeub = zzdjf;
        return this;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbsd' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbsd
    public final /* synthetic */ zzbsd<zzbmw> zza(zzdlj zzdlj) {
        this.zzeua = zzdlj;
        return this;
    }
}
