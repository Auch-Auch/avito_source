package com.google.android.gms.internal.measurement;
public final class zzhs {
    private static final zzhq<?> zza = new zzhp();
    private static final zzhq<?> zzb = zzc();

    public static zzhq<?> zza() {
        return zza;
    }

    public static zzhq<?> zzb() {
        zzhq<?> zzhq = zzb;
        if (zzhq != null) {
            return zzhq;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static zzhq<?> zzc() {
        try {
            return (zzhq) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
