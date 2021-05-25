package com.facebook.common.webp;

import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
public class WebpSupportStatus {
    public static boolean a = false;
    public static final byte[] b = a("RIFF");
    public static final byte[] c = a("WEBP");
    public static final byte[] d = a("VP8 ");
    public static final byte[] e = a("VP8L");
    public static final byte[] f = a("VP8X");
    public static final boolean sIsExtendedWebpSupported = true;
    public static final boolean sIsSimpleWebpSupported = true;
    public static final boolean sIsWebpSupportRequired = false;
    @Nullable
    public static WebpBitmapFactory sWebpBitmapFactory = null;

    public static byte[] a(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII not found!", e2);
        }
    }

    public static boolean b(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnimatedWebpHeader(byte[] bArr, int i) {
        return b(bArr, i + 12, f) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean isExtendedWebpHeader(byte[] bArr, int i, int i2) {
        return i2 >= 21 && b(bArr, i + 12, f);
    }

    public static boolean isExtendedWebpHeaderWithAlpha(byte[] bArr, int i) {
        return b(bArr, i + 12, f) && ((bArr[i + 20] & Ascii.DLE) == 16);
    }

    public static boolean isLosslessWebpHeader(byte[] bArr, int i) {
        return b(bArr, i + 12, e);
    }

    public static boolean isSimpleWebpHeader(byte[] bArr, int i) {
        return b(bArr, i + 12, d);
    }

    public static boolean isWebpHeader(byte[] bArr, int i, int i2) {
        return i2 >= 20 && b(bArr, i, b) && b(bArr, i + 8, c);
    }

    public static boolean isWebpSupportedByPlatform(byte[] bArr, int i, int i2) {
        if (isSimpleWebpHeader(bArr, i)) {
            return sIsSimpleWebpSupported;
        }
        if (isLosslessWebpHeader(bArr, i)) {
            return sIsExtendedWebpSupported;
        }
        if (!isExtendedWebpHeader(bArr, i, i2) || isAnimatedWebpHeader(bArr, i)) {
            return false;
        }
        return sIsExtendedWebpSupported;
    }

    @Nullable
    public static WebpBitmapFactory loadWebpBitmapFactoryIfExists() {
        if (a) {
            return sWebpBitmapFactory;
        }
        WebpBitmapFactory webpBitmapFactory = null;
        try {
            webpBitmapFactory = (WebpBitmapFactory) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable unused) {
        }
        a = true;
        return webpBitmapFactory;
    }
}
