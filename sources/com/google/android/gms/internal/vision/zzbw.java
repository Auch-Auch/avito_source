package com.google.android.gms.internal.vision;

import kotlin.text.Typography;
public enum zzbw implements zzih {
    RGBA(0),
    NV12(5),
    NV21(1),
    YV12(6),
    YV21(7),
    RGB(2),
    GRAY(3),
    GRAY16(4);
    
    private static final zzig<zzbw> zzhq = new zzbz();
    private final int value;

    private zzbw(int i) {
        this.value = i;
    }

    public static zzij zzal() {
        return zzby.zzht;
    }

    public static zzbw zzf(int i) {
        switch (i) {
            case 0:
                return RGBA;
            case 1:
                return NV21;
            case 2:
                return RGB;
            case 3:
                return GRAY;
            case 4:
                return GRAY16;
            case 5:
                return NV12;
            case 6:
                return YV12;
            case 7:
                return YV21;
            default:
                return null;
        }
    }

    @Override // java.lang.Enum, java.lang.Object
    public final String toString() {
        return "<" + zzbw.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
    }

    @Override // com.google.android.gms.internal.vision.zzih
    public final int zzak() {
        return this.value;
    }
}
