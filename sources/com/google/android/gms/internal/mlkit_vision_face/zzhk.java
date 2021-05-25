package com.google.android.gms.internal.mlkit_vision_face;
public final class zzhk {
    private static final zzhi zza = zzc();
    private static final zzhi zzb = new zzhh();

    public static zzhi zza() {
        return zza;
    }

    public static zzhi zzb() {
        return zzb;
    }

    private static zzhi zzc() {
        try {
            return (zzhi) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
