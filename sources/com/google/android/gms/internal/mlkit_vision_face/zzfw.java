package com.google.android.gms.internal.mlkit_vision_face;
public final class zzfw {
    private static final zzfu<?> zza = new zzft();
    private static final zzfu<?> zzb = zzc();

    public static zzfu<?> zza() {
        return zza;
    }

    public static zzfu<?> zzb() {
        zzfu<?> zzfu = zzb;
        if (zzfu != null) {
            return zzfu;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static zzfu<?> zzc() {
        try {
            return (zzfu) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
