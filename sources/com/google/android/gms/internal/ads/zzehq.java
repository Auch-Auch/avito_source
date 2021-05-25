package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzehq implements zzeiy {
    private static final zzeia zzihr = new zzehp();
    private final zzeia zzihq;

    public zzehq() {
        this(new zzehs(zzegq.zzbfs(), zzbgs()));
    }

    private static boolean zza(zzehx zzehx) {
        return zzehx.zzbgw() == zzegp.zze.zzige;
    }

    private static zzeia zzbgs() {
        try {
            return (zzeia) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzihr;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeiy
    public final <T> zzeiv<T> zzg(Class<T> cls) {
        zzeix.zzi(cls);
        zzehx zzf = this.zzihq.zzf(cls);
        if (zzf.zzbgx()) {
            if (zzegp.class.isAssignableFrom(cls)) {
                return zzeif.zza(zzeix.zzbhn(), zzegf.zzbfa(), zzf.zzbgy());
            }
            return zzeif.zza(zzeix.zzbhl(), zzegf.zzbfb(), zzf.zzbgy());
        } else if (zzegp.class.isAssignableFrom(cls)) {
            if (zza(zzf)) {
                return zzeid.zza(cls, zzf, zzeij.zzbhd(), zzehj.zzbgq(), zzeix.zzbhn(), zzegf.zzbfa(), zzehy.zzbha());
            }
            return zzeid.zza(cls, zzf, zzeij.zzbhd(), zzehj.zzbgq(), zzeix.zzbhn(), (zzege<?>) null, zzehy.zzbha());
        } else if (zza(zzf)) {
            return zzeid.zza(cls, zzf, zzeij.zzbhc(), zzehj.zzbgp(), zzeix.zzbhl(), zzegf.zzbfb(), zzehy.zzbgz());
        } else {
            return zzeid.zza(cls, zzf, zzeij.zzbhc(), zzehj.zzbgp(), zzeix.zzbhm(), (zzege<?>) null, zzehy.zzbgz());
        }
    }

    private zzehq(zzeia zzeia) {
        this.zzihq = (zzeia) zzegr.zza(zzeia, "messageInfoFactory");
    }
}
