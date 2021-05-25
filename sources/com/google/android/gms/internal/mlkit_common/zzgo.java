package com.google.android.gms.internal.mlkit_common;
public final class zzgo implements zzhq {
    private static final zzgy zzb = new zzgr();
    private final zzgy zza;

    public zzgo() {
        this(new zzgq(zzfr.zza(), zza()));
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhq
    public final <T> zzhr<T> zza(Class<T> cls) {
        zzht.zza((Class<?>) cls);
        zzgz zzb2 = this.zza.zzb(cls);
        if (zzb2.zzb()) {
            if (zzfq.class.isAssignableFrom(cls)) {
                return zzhe.zza(zzht.zzc(), zzfi.zza(), zzb2.zzc());
            }
            return zzhe.zza(zzht.zza(), zzfi.zzb(), zzb2.zzc());
        } else if (zzfq.class.isAssignableFrom(cls)) {
            if (zza(zzb2)) {
                return zzhf.zza(cls, zzb2, zzhi.zzb(), zzgl.zzb(), zzht.zzc(), zzfi.zza(), zzgw.zzb());
            }
            return zzhf.zza(cls, zzb2, zzhi.zzb(), zzgl.zzb(), zzht.zzc(), null, zzgw.zzb());
        } else if (zza(zzb2)) {
            return zzhf.zza(cls, zzb2, zzhi.zza(), zzgl.zza(), zzht.zza(), zzfi.zzb(), zzgw.zza());
        } else {
            return zzhf.zza(cls, zzb2, zzhi.zza(), zzgl.zza(), zzht.zzb(), null, zzgw.zza());
        }
    }

    private zzgo(zzgy zzgy) {
        this.zza = (zzgy) zzfs.zza(zzgy, "messageInfoFactory");
    }

    private static boolean zza(zzgz zzgz) {
        return zzgz.zza() == zzhn.zza;
    }

    private static zzgy zza() {
        try {
            return (zzgy) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzb;
        }
    }
}
