package com.google.android.gms.internal.ads;
public final class zzehy {
    private static final zzehw zzihx = zzbhb();
    private static final zzehw zzihy = new zzehv();

    public static zzehw zzbgz() {
        return zzihx;
    }

    public static zzehw zzbha() {
        return zzihy;
    }

    private static zzehw zzbhb() {
        try {
            return (zzehw) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
