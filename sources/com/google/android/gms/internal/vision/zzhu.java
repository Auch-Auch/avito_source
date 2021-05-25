package com.google.android.gms.internal.vision;
public final class zzhu {
    private static final zzhq<?> zzvb = new zzhs();
    private static final zzhq<?> zzvc = zzgj();

    private static zzhq<?> zzgj() {
        try {
            return (zzhq) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static zzhq<?> zzgk() {
        return zzvb;
    }

    public static zzhq<?> zzgl() {
        zzhq<?> zzhq = zzvc;
        if (zzhq != null) {
            return zzhq;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
