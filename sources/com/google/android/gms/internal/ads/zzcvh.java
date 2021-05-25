package com.google.android.gms.internal.ads;
public final class zzcvh implements zzbzf {
    private final /* synthetic */ zzdkx zzgnh;
    private final /* synthetic */ zzdlj zzgnv;
    private final /* synthetic */ zzcrg zzgnw;
    public final /* synthetic */ zzcvf zzgnx;

    public zzcvh(zzcvf zzcvf, zzdlj zzdlj, zzdkx zzdkx, zzcrg zzcrg) {
        this.zzgnx = zzcvf;
        this.zzgnv = zzdlj;
        this.zzgnh = zzdkx;
        this.zzgnw = zzcrg;
    }

    @Override // com.google.android.gms.internal.ads.zzbzf
    public final void onInitializationSucceeded() {
        this.zzgnx.zzfmk.execute(new Runnable(this, this.zzgnv, this.zzgnh, this.zzgnw) { // from class: com.google.android.gms.internal.ads.zzcvk
            private final zzdkx zzfoo;
            private final zzdlj zzgbj;
            private final zzcvh zzgoc;
            private final zzcrg zzgod;

            {
                this.zzgoc = r1;
                this.zzgbj = r2;
                this.zzfoo = r3;
                this.zzgod = r4;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzcvh zzcvh = this.zzgoc;
                zzdlj zzdlj = this.zzgbj;
                zzdkx zzdkx = this.zzfoo;
                zzcrg zzcrg = this.zzgod;
                zzcvf zzcvf = zzcvh.zzgnx;
                zzcvf.zzc(zzdlj, zzdkx, zzcrg);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbzf
    public final void zzdx(int i) {
        String valueOf = String.valueOf(this.zzgnw.zzfqh);
        zzbbd.zzfe(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "));
    }
}
