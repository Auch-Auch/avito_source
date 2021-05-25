package com.google.android.gms.internal.ads;
public final /* synthetic */ class zzedp {
    public static final /* synthetic */ int[] zzhzb;
    public static final /* synthetic */ int[] zzhzc;

    static {
        zzeds.values();
        int[] iArr = new int[3];
        zzhzc = iArr;
        try {
            zzeds zzeds = zzeds.NIST_P256;
            iArr[0] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            int[] iArr2 = zzhzc;
            zzeds zzeds2 = zzeds.NIST_P384;
            iArr2[1] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            int[] iArr3 = zzhzc;
            zzeds zzeds3 = zzeds.NIST_P521;
            iArr3[2] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        zzedr.values();
        int[] iArr4 = new int[3];
        zzhzb = iArr4;
        try {
            zzedr zzedr = zzedr.UNCOMPRESSED;
            iArr4[0] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            int[] iArr5 = zzhzb;
            zzedr zzedr2 = zzedr.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
            iArr5[2] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            int[] iArr6 = zzhzb;
            zzedr zzedr3 = zzedr.COMPRESSED;
            iArr6[1] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
