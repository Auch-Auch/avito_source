package com.google.android.gms.internal.mlkit_vision_common;
public final class zzfq {
    private static final zzfo zza = zzc();
    private static final zzfo zzb = new zzfn();

    public static zzfo zza() {
        return zza;
    }

    public static zzfo zzb() {
        return zzb;
    }

    private static zzfo zzc() {
        try {
            return (zzfo) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
