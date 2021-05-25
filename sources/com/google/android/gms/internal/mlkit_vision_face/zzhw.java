package com.google.android.gms.internal.mlkit_vision_face;
public final class zzhw {
    private static final zzhu zza = zzc();
    private static final zzhu zzb = new zzht();

    public static zzhu zza() {
        return zza;
    }

    public static zzhu zzb() {
        return zzb;
    }

    private static zzhu zzc() {
        try {
            return (zzhu) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
