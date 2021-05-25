package com.google.android.gms.internal.vision;
public final class zzji {
    private static final zzjg zzaag = zzic();
    private static final zzjg zzaah = new zzjj();

    public static zzjg zzia() {
        return zzaag;
    }

    public static zzjg zzib() {
        return zzaah;
    }

    private static zzjg zzic() {
        try {
            return (zzjg) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
