package com.google.android.gms.internal.mlkit_vision_common;
public final class zzfi implements zzgk {
    private static final zzfs zzb = new zzfh();
    private final zzfs zza;

    public zzfi() {
        this(new zzfk(zzeh.zza(), zza()));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgk
    public final <T> zzgh<T> zza(Class<T> cls) {
        zzgj.zza((Class<?>) cls);
        zzfp zzb2 = this.zza.zzb(cls);
        if (zzb2.zzb()) {
            if (zzej.class.isAssignableFrom(cls)) {
                return zzfy.zza(zzgj.zzc(), zzec.zza(), zzb2.zzc());
            }
            return zzfy.zza(zzgj.zza(), zzec.zzb(), zzb2.zzc());
        } else if (zzej.class.isAssignableFrom(cls)) {
            if (zza(zzb2)) {
                return zzfv.zza(cls, zzb2, zzgc.zzb(), zzfb.zzb(), zzgj.zzc(), zzec.zza(), zzfq.zzb());
            }
            return zzfv.zza(cls, zzb2, zzgc.zzb(), zzfb.zzb(), zzgj.zzc(), null, zzfq.zzb());
        } else if (zza(zzb2)) {
            return zzfv.zza(cls, zzb2, zzgc.zza(), zzfb.zza(), zzgj.zza(), zzec.zzb(), zzfq.zza());
        } else {
            return zzfv.zza(cls, zzb2, zzgc.zza(), zzfb.zza(), zzgj.zzb(), null, zzfq.zza());
        }
    }

    private zzfi(zzfs zzfs) {
        this.zza = (zzfs) zzem.zza(zzfs, "messageInfoFactory");
    }

    private static boolean zza(zzfp zzfp) {
        return zzfp.zza() == zzgd.zza;
    }

    private static zzfs zza() {
        try {
            return (zzfs) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzb;
        }
    }
}
