package com.facebook.imageformat;

import com.facebook.common.internal.Ints;
import com.facebook.imageformat.ImageFormat;
import com.google.common.base.Ascii;
public class DefaultImageFormatChecker implements ImageFormat.FormatChecker {
    public static final byte[] b;
    public static final int c;
    public static final byte[] d;
    public static final int e;
    public static final byte[] f = ImageFormatCheckerUtils.asciiBytes("GIF87a");
    public static final byte[] g = ImageFormatCheckerUtils.asciiBytes("GIF89a");
    public static final byte[] h;
    public static final int i;
    public static final byte[] j;
    public static final int k;
    public static final byte[] l = ImageFormatCheckerUtils.asciiBytes("ftyp");
    public static final byte[][] m = {ImageFormatCheckerUtils.asciiBytes("heic"), ImageFormatCheckerUtils.asciiBytes("heix"), ImageFormatCheckerUtils.asciiBytes("hevc"), ImageFormatCheckerUtils.asciiBytes("hevx"), ImageFormatCheckerUtils.asciiBytes("mif1"), ImageFormatCheckerUtils.asciiBytes("msf1")};
    public static final byte[] n;
    public static final byte[] o = {77, 77, 0, 42};
    public static final int p;
    public final int a = Ints.max(21, 20, c, e, 6, i, k, 12);

    static {
        byte[] bArr = {-1, -40, -1};
        b = bArr;
        c = bArr.length;
        byte[] bArr2 = {-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10};
        d = bArr2;
        e = bArr2.length;
        byte[] asciiBytes = ImageFormatCheckerUtils.asciiBytes("BM");
        h = asciiBytes;
        i = asciiBytes.length;
        byte[] bArr3 = {0, 0, 1, 0};
        j = bArr3;
        k = bArr3.length;
        byte[] bArr4 = {73, 73, 42, 0};
        n = bArr4;
        p = bArr4.length;
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00d5  */
    @Override // com.facebook.imageformat.ImageFormat.FormatChecker
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.imageformat.ImageFormat determineFormat(byte[] r8, int r9) {
        /*
        // Method dump skipped, instructions count: 242
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imageformat.DefaultImageFormatChecker.determineFormat(byte[], int):com.facebook.imageformat.ImageFormat");
    }

    @Override // com.facebook.imageformat.ImageFormat.FormatChecker
    public int getHeaderSize() {
        return this.a;
    }
}
