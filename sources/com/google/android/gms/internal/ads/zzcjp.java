package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zztw;
public final class zzcjp implements zzelo<zzto> {
    private final zzelx<Context> zzert;
    private final zzelx<zztw.zza.EnumC0204zza> zzfne;
    private final zzelx<String> zzfsc;
    private final zzelx<zzbbg> zzfsr;
    private final zzelx<String> zzgec;

    private zzcjp(zzelx<Context> zzelx, zzelx<String> zzelx2, zzelx<zzbbg> zzelx3, zzelx<zztw.zza.EnumC0204zza> zzelx4, zzelx<String> zzelx5) {
        this.zzert = zzelx;
        this.zzfsc = zzelx2;
        this.zzfsr = zzelx3;
        this.zzfne = zzelx4;
        this.zzgec = zzelx5;
    }

    public static zzcjp zze(zzelx<Context> zzelx, zzelx<String> zzelx2, zzelx<zzbbg> zzelx3, zzelx<zztw.zza.EnumC0204zza> zzelx4, zzelx<String> zzelx5) {
        return new zzcjp(zzelx, zzelx2, zzelx3, zzelx4, zzelx5);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        String str = this.zzfsc.get();
        zzbbg zzbbg = this.zzfsr.get();
        zztw.zza.EnumC0204zza zza = this.zzfne.get();
        String str2 = this.zzgec.get();
        zzto zzto = new zzto(new zztt(this.zzert.get()));
        zzto.zza(new zztn(zza, str, (zztw.zzu) ((zzegp) zztw.zzu.zzor().zzcq(zzbbg.zzedq).zzcr(zzbbg.zzedr).zzcs(zzbbg.zzeds ? 0 : 2).zzbfx()), str2) { // from class: com.google.android.gms.internal.ads.zzcjq
            private final String zzdft;
            private final zztw.zza.EnumC0204zza zzged;
            private final zztw.zzu zzgee;
            private final String zzgef;

            {
                this.zzged = r1;
                this.zzdft = r2;
                this.zzgee = r3;
                this.zzgef = r4;
            }

            @Override // com.google.android.gms.internal.ads.zztn
            public final void zza(zztw.zzi.zza zza2) {
                zztw.zza.EnumC0204zza zza3 = this.zzged;
                String str3 = this.zzdft;
                zztw.zzu zzu = this.zzgee;
                zza2.zza(((zztw.zza.zzb) zza2.zznx().zzbfk()).zzb(zza3)).zza(((zztw.zzg.zza) zza2.zznw().zzbfk()).zzbz(str3).zza(zzu)).zzcb(this.zzgef);
            }
        });
        return (zzto) zzelu.zza(zzto, "Cannot return null from a non-@Nullable @Provides method");
    }
}
