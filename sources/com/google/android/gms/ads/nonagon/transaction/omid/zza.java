package com.google.android.gms.ads.nonagon.transaction.omid;
public final /* synthetic */ class zza {
    public static final /* synthetic */ int[] zzhcf;

    static {
        OmidMediaType.values();
        int[] iArr = new int[3];
        zzhcf = iArr;
        try {
            OmidMediaType omidMediaType = OmidMediaType.DISPLAY;
            iArr[1] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            int[] iArr2 = zzhcf;
            OmidMediaType omidMediaType2 = OmidMediaType.VIDEO;
            iArr2[0] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            int[] iArr3 = zzhcf;
            OmidMediaType omidMediaType3 = OmidMediaType.UNKNOWN;
            iArr3[2] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
