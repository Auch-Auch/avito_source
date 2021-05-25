package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
public final class zzcvv implements zzcre<zzbni> {
    private final zzdpf zzfqo;
    private final zzboe zzglh;
    private final zzdvw zzgoi;
    private final Context zzgoo;
    @Nullable
    private final zzabq zzgop;

    public zzcvv(Context context, zzboe zzboe, zzdpf zzdpf, zzdvw zzdvw, @Nullable zzabq zzabq) {
        this.zzgoo = context;
        this.zzglh = zzboe;
        this.zzfqo = zzdpf;
        this.zzgoi = zzdvw;
        this.zzgop = zzabq;
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final boolean zza(zzdlj zzdlj, zzdkx zzdkx) {
        zzdlb zzdlb;
        return (this.zzgop == null || (zzdlb = zzdkx.zzhao) == null || zzdlb.zzdou == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final zzdvt<zzbni> zzb(zzdlj zzdlj, zzdkx zzdkx) {
        zzbnh zza = this.zzglh.zza(new zzbpt(zzdlj, zzdkx, null), new zzcwa(this, new View(this.zzgoo), null, zzcvy.zzgot, zzdkx.zzhaq.get(0)));
        zzcvz zzafu = zza.zzafu();
        zzdlb zzdlb = zzdkx.zzhao;
        return this.zzfqo.zzu(zzdpg.CUSTOM_RENDER_SYN).zza(new zzdop(this, new zzabj(zzafu, zzdlb.zzdos, zzdlb.zzdou)) { // from class: com.google.android.gms.internal.ads.zzcvx
            private final zzcvv zzgor;
            private final zzabj zzgos;

            {
                this.zzgor = r1;
                this.zzgos = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzdop
            public final void run() {
                this.zzgor.zza(this.zzgos);
            }
        }, this.zzgoi).zzw(zzdpg.CUSTOM_RENDER_ACK).zze(zzdvl.zzaf(zza.zzafs())).zzauz();
    }

    public final /* synthetic */ void zza(zzabj zzabj) throws Exception {
        this.zzgop.zza(zzabj);
    }
}
