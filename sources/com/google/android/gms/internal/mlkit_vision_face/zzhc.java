package com.google.android.gms.internal.mlkit_vision_face;
public final class zzhc implements zzie {
    private static final zzhm zzb = new zzhb();
    private final zzhm zza;

    public zzhc() {
        this(new zzhe(zzgb.zza(), zza()));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzie
    public final <T> zzib<T> zza(Class<T> cls) {
        zzid.zza((Class<?>) cls);
        zzhj zzb2 = this.zza.zzb(cls);
        if (zzb2.zzb()) {
            if (zzgd.class.isAssignableFrom(cls)) {
                return zzhs.zza(zzid.zzc(), zzfw.zza(), zzb2.zzc());
            }
            return zzhs.zza(zzid.zza(), zzfw.zzb(), zzb2.zzc());
        } else if (zzgd.class.isAssignableFrom(cls)) {
            if (zza(zzb2)) {
                return zzhp.zza(cls, zzb2, zzhw.zzb(), zzgv.zzb(), zzid.zzc(), zzfw.zza(), zzhk.zzb());
            }
            return zzhp.zza(cls, zzb2, zzhw.zzb(), zzgv.zzb(), zzid.zzc(), null, zzhk.zzb());
        } else if (zza(zzb2)) {
            return zzhp.zza(cls, zzb2, zzhw.zza(), zzgv.zza(), zzid.zza(), zzfw.zzb(), zzhk.zza());
        } else {
            return zzhp.zza(cls, zzb2, zzhw.zza(), zzgv.zza(), zzid.zzb(), null, zzhk.zza());
        }
    }

    private zzhc(zzhm zzhm) {
        this.zza = (zzhm) zzgg.zza(zzhm, "messageInfoFactory");
    }

    private static boolean zza(zzhj zzhj) {
        return zzhj.zza() == zzhx.zza;
    }

    private static zzhm zza() {
        try {
            return (zzhm) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzb;
        }
    }
}
