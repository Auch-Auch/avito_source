package com.google.android.gms.internal.ads;
public final class zzeij {
    private static final zzeih zziir = zzbhe();
    private static final zzeih zziis = new zzeik();

    public static zzeih zzbhc() {
        return zziir;
    }

    public static zzeih zzbhd() {
        return zziis;
    }

    private static zzeih zzbhe() {
        try {
            return (zzeih) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
