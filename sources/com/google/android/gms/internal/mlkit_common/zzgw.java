package com.google.android.gms.internal.mlkit_common;
public final class zzgw {
    private static final zzgu zza = zzc();
    private static final zzgu zzb = new zzgx();

    public static zzgu zza() {
        return zza;
    }

    public static zzgu zzb() {
        return zzb;
    }

    private static zzgu zzc() {
        try {
            return (zzgu) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
