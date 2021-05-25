package com.facebook.imageutils;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
public class JfifUtil {
    public static final int APP1_EXIF_MAGIC = 1165519206;
    public static final int MARKER_APP1 = 225;
    public static final int MARKER_EOI = 217;
    public static final int MARKER_ESCAPE_BYTE = 0;
    public static final int MARKER_FIRST_BYTE = 255;
    public static final int MARKER_RST0 = 208;
    public static final int MARKER_RST7 = 215;
    public static final int MARKER_SOFn = 192;
    public static final int MARKER_SOI = 216;
    public static final int MARKER_SOS = 218;
    public static final int MARKER_TEM = 1;

    public static int getAutoRotateAngleFromOrientation(int i) {
        if (i == 3) {
            return 180;
        }
        if (i != 6) {
            return i != 8 ? 0 : 270;
        }
        return 90;
    }

    public static int getOrientation(byte[] bArr) {
        return getOrientation(new ByteArrayInputStream(bArr));
    }

    public static boolean moveToMarker(InputStream inputStream, int i) throws IOException {
        boolean z;
        Preconditions.checkNotNull(inputStream);
        while (AppCompatDelegateImpl.i.L1(inputStream, 1, false) == 255) {
            int i2 = 255;
            while (i2 == 255) {
                i2 = AppCompatDelegateImpl.i.L1(inputStream, 1, false);
            }
            if (i == 192) {
                switch (i2) {
                    case 192:
                    case 193:
                    case 194:
                    case 195:
                    case 197:
                    case 198:
                    case 199:
                    case 201:
                    case 202:
                    case 203:
                    case 205:
                    case 206:
                    case 207:
                        z = true;
                        break;
                    case 196:
                    case 200:
                    case 204:
                    default:
                        z = false;
                        break;
                }
                if (z) {
                    return true;
                }
            }
            if (i2 == i) {
                return true;
            }
            if (!(i2 == 216 || i2 == 1)) {
                if (!(i2 == 217 || i2 == 218)) {
                    inputStream.skip((long) (AppCompatDelegateImpl.i.L1(inputStream, 2, false) - 2));
                }
                return false;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a A[Catch:{ IOException -> 0x00ae }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b A[Catch:{ IOException -> 0x00ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0066 A[Catch:{ IOException -> 0x00ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getOrientation(java.io.InputStream r11) {
        /*
            r0 = 225(0xe1, float:3.15E-43)
            r1 = 0
            boolean r0 = moveToMarker(r11, r0)     // Catch:{ IOException -> 0x00ae }
            r2 = 4
            r3 = 2
            if (r0 == 0) goto L_0x0027
            int r0 = androidx.appcompat.app.AppCompatDelegateImpl.i.L1(r11, r3, r1)     // Catch:{ IOException -> 0x00ae }
            int r0 = r0 - r3
            r4 = 6
            if (r0 <= r4) goto L_0x0027
            int r4 = androidx.appcompat.app.AppCompatDelegateImpl.i.L1(r11, r2, r1)     // Catch:{ IOException -> 0x00ae }
            int r0 = r0 + -4
            int r5 = androidx.appcompat.app.AppCompatDelegateImpl.i.L1(r11, r3, r1)     // Catch:{ IOException -> 0x00ae }
            int r0 = r0 + -2
            r6 = 1165519206(0x45786966, float:3974.5874)
            if (r4 != r6) goto L_0x0027
            if (r5 != 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            if (r0 != 0) goto L_0x002b
            return r1
        L_0x002b:
            java.lang.Class<a2.g.q.a> r4 = a2.g.q.a.class
            r5 = 8
            r6 = 1
            if (r0 > r5) goto L_0x0033
            goto L_0x0048
        L_0x0033:
            int r7 = androidx.appcompat.app.AppCompatDelegateImpl.i.L1(r11, r2, r1)     // Catch:{ IOException -> 0x00ae }
            int r0 = r0 + -4
            r8 = 1229531648(0x49492a00, float:823968.0)
            if (r7 == r8) goto L_0x004c
            r9 = 1296891946(0x4d4d002a, float:2.14958752E8)
            if (r7 == r9) goto L_0x004c
            java.lang.String r0 = "Invalid TIFF header"
            com.facebook.common.logging.FLog.e(r4, r0)     // Catch:{ IOException -> 0x00ae }
        L_0x0048:
            r0 = 0
            r7 = 0
            r8 = 0
            goto L_0x0063
        L_0x004c:
            if (r7 != r8) goto L_0x0050
            r7 = 1
            goto L_0x0051
        L_0x0050:
            r7 = 0
        L_0x0051:
            int r8 = androidx.appcompat.app.AppCompatDelegateImpl.i.L1(r11, r2, r7)     // Catch:{ IOException -> 0x00ae }
            int r0 = r0 + -4
            if (r8 < r5) goto L_0x005d
            int r9 = r8 + -8
            if (r9 <= r0) goto L_0x0063
        L_0x005d:
            java.lang.String r0 = "Invalid offset"
            com.facebook.common.logging.FLog.e(r4, r0)     // Catch:{ IOException -> 0x00ae }
            r0 = 0
        L_0x0063:
            int r8 = r8 - r5
            if (r0 == 0) goto L_0x00ae
            if (r8 <= r0) goto L_0x0069
            goto L_0x00ae
        L_0x0069:
            long r4 = (long) r8     // Catch:{ IOException -> 0x00ae }
            r11.skip(r4)     // Catch:{ IOException -> 0x00ae }
            int r0 = r0 - r8
            r4 = 274(0x112, float:3.84E-43)
            r5 = 14
            if (r0 >= r5) goto L_0x0075
            goto L_0x0095
        L_0x0075:
            int r5 = androidx.appcompat.app.AppCompatDelegateImpl.i.L1(r11, r3, r7)     // Catch:{ IOException -> 0x00ae }
            int r0 = r0 + -2
        L_0x007b:
            int r8 = r5 + -1
            if (r5 <= 0) goto L_0x0095
            r5 = 12
            if (r0 < r5) goto L_0x0095
            int r5 = androidx.appcompat.app.AppCompatDelegateImpl.i.L1(r11, r3, r7)     // Catch:{ IOException -> 0x00ae }
            int r0 = r0 + -2
            if (r5 != r4) goto L_0x008c
            goto L_0x0096
        L_0x008c:
            r9 = 10
            r11.skip(r9)     // Catch:{ IOException -> 0x00ae }
            int r0 = r0 + -10
            r5 = r8
            goto L_0x007b
        L_0x0095:
            r0 = 0
        L_0x0096:
            r4 = 10
            if (r0 >= r4) goto L_0x009b
            goto L_0x00ae
        L_0x009b:
            int r0 = androidx.appcompat.app.AppCompatDelegateImpl.i.L1(r11, r3, r7)     // Catch:{ IOException -> 0x00ae }
            r4 = 3
            if (r0 == r4) goto L_0x00a3
            goto L_0x00ae
        L_0x00a3:
            int r0 = androidx.appcompat.app.AppCompatDelegateImpl.i.L1(r11, r2, r7)     // Catch:{ IOException -> 0x00ae }
            if (r0 == r6) goto L_0x00aa
            goto L_0x00ae
        L_0x00aa:
            int r1 = androidx.appcompat.app.AppCompatDelegateImpl.i.L1(r11, r3, r7)     // Catch:{ IOException -> 0x00ae }
        L_0x00ae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imageutils.JfifUtil.getOrientation(java.io.InputStream):int");
    }
}
