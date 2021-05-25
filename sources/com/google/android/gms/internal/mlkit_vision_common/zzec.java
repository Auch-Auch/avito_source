package com.google.android.gms.internal.mlkit_vision_common;
public final class zzec {
    private static final zzea<?> zza = new zzdz();
    private static final zzea<?> zzb = zzc();

    public static zzea<?> zza() {
        return zza;
    }

    public static zzea<?> zzb() {
        zzea<?> zzea = zzb;
        if (zzea != null) {
            return zzea;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static zzea<?> zzc() {
        try {
            return (zzea) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
