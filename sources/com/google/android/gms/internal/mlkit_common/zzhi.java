package com.google.android.gms.internal.mlkit_common;
public final class zzhi {
    private static final zzhg zza = zzc();
    private static final zzhg zzb = new zzhj();

    public static zzhg zza() {
        return zza;
    }

    public static zzhg zzb() {
        return zzb;
    }

    private static zzhg zzc() {
        try {
            return (zzhg) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
