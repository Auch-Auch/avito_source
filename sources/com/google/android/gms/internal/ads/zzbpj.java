package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;
public final class zzbpj {
    public final List<? extends zzdvt<? extends zzbpd>> zzfpy;

    public zzbpj(List<? extends zzdvt<? extends zzbpd>> list) {
        this.zzfpy = list;
    }

    public static zzcre<zzbpj> zza(@NonNull zzctf<? extends zzbpd> zzctf) {
        return new zzcrd(zzctf, zzbpm.zzdwg);
    }

    public static zzcre<zzbpj> zza(@NonNull zzcre<? extends zzbpd> zzcre) {
        return new zzcrd(zzcre, zzbpl.zzdwg);
    }

    public zzbpj(zzbpd zzbpd) {
        this.zzfpy = Collections.singletonList(zzdvl.zzaf(zzbpd));
    }
}
