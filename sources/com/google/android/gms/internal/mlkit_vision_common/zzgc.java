package com.google.android.gms.internal.mlkit_vision_common;
public final class zzgc {
    private static final zzga zza = zzc();
    private static final zzga zzb = new zzfz();

    public static zzga zza() {
        return zza;
    }

    public static zzga zzb() {
        return zzb;
    }

    private static zzga zzc() {
        try {
            return (zzga) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
