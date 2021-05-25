package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zztw;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
public final class zzckp implements zzelo<Set<zzbys<zzdpl>>> {
    private final zzelx<Executor> zzerr;
    private final zzelx<Context> zzert;
    private final zzelx<String> zzgeo;
    private final zzelx<Map<zzdpg, zzcku>> zzgep;

    public zzckp(zzelx<String> zzelx, zzelx<Context> zzelx2, zzelx<Executor> zzelx3, zzelx<Map<zzdpg, zzcku>> zzelx4) {
        this.zzgeo = zzelx;
        this.zzert = zzelx2;
        this.zzerr = zzelx3;
        this.zzgep = zzelx4;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        Set set;
        String str = this.zzgeo.get();
        Context context = this.zzert.get();
        Executor executor = this.zzerr.get();
        Map<zzdpg, zzcku> map = this.zzgep.get();
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzctk)).booleanValue()) {
            zzto zzto = new zzto(new zztt(context));
            zzto.zza(new zztn(str) { // from class: com.google.android.gms.internal.ads.zzckr
                private final String zzdgb;

                {
                    this.zzdgb = r1;
                }

                @Override // com.google.android.gms.internal.ads.zztn
                public final void zza(zztw.zzi.zza zza) {
                    zza.zzcb(this.zzdgb);
                }
            });
            set = Collections.singleton(new zzbys(new zzcks(zzto, map), executor));
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzelu.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
