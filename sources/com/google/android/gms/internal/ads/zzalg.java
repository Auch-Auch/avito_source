package com.google.android.gms.internal.ads;
public final class zzalg implements zzbbu<zzajx> {
    public final /* synthetic */ zzalb zzdhl;

    public zzalg(zzalb zzalb) {
        this.zzdhl = zzalb;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbbu
    public final /* synthetic */ void zzh(zzajx zzajx) {
        zzbbi.zzedy.execute(new Runnable(this, zzajx) { // from class: com.google.android.gms.internal.ads.zzalf
            private final zzalg zzdhj;
            private final zzajx zzdhk;

            {
                this.zzdhj = r1;
                this.zzdhk = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzalg zzalg = this.zzdhj;
                zzajx zzajx2 = this.zzdhk;
                zzalg.zzdhl.zzdgp.zzh(zzajx2);
                zzajx2.destroy();
            }
        });
    }
}
