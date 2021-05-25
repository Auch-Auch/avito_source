package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
public final class zzczf implements zzduv<zzasp, zzczg> {
    private Executor executor;
    private zzcnq zzgsa;

    public zzczf(Executor executor2, zzcnq zzcnq) {
        this.executor = executor2;
        this.zzgsa = zzcnq;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdvt' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduv
    public final /* synthetic */ zzdvt<zzczg> zzf(zzasp zzasp) throws Exception {
        zzasp zzasp2 = zzasp;
        return zzdvl.zzb(this.zzgsa.zzg(zzasp2), new zzduv(zzasp2) { // from class: com.google.android.gms.internal.ads.zzcze
            private final zzasp zzftf;

            {
                this.zzftf = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return zzdvl.zzaf(new zzczg(new JsonReader(new InputStreamReader((InputStream) obj))).zzo(this.zzftf.zzdtd));
            }
        }, this.executor);
    }
}
