package a2.j.b.b.a1.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
public final class a {
    public static final byte[] h = {0, 7, 8, Ascii.SI};
    public static final byte[] i = {0, 119, -120, -1};
    public static final byte[] j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    public final Paint a;
    public final Paint b;
    public final Canvas c = new Canvas();
    public final b d = new b(719, 575, 0, 719, 0, 575);
    public final C0037a e = new C0037a(0, new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505}, b(), c());
    public final h f;
    public Bitmap g;

    /* renamed from: a2.j.b.b.a1.d.a$a  reason: collision with other inner class name */
    public static final class C0037a {
        public final int a;
        public final int[] b;
        public final int[] c;
        public final int[] d;

        public C0037a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.a = i;
            this.b = iArr;
            this.c = iArr2;
            this.d = iArr3;
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }
    }

    public static final class c {
        public final int a;
        public final boolean b;
        public final byte[] c;
        public final byte[] d;

        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.a = i;
            this.b = z;
            this.c = bArr;
            this.d = bArr2;
        }
    }

    public static final class d {
        public final int a;
        public final int b;
        public final SparseArray<e> c;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.a = i2;
            this.b = i3;
            this.c = sparseArray;
        }
    }

    public static final class e {
        public final int a;
        public final int b;

        public e(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public static final class f {
        public final int a;
        public final boolean b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final SparseArray<g> j;

        public f(int i2, boolean z, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, SparseArray<g> sparseArray) {
            this.a = i2;
            this.b = z;
            this.c = i3;
            this.d = i4;
            this.e = i6;
            this.f = i7;
            this.g = i8;
            this.h = i9;
            this.i = i10;
            this.j = sparseArray;
        }
    }

    public static final class g {
        public final int a;
        public final int b;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = i3;
            this.b = i4;
        }
    }

    public static final class h {
        public final int a;
        public final int b;
        public final SparseArray<f> c = new SparseArray<>();
        public final SparseArray<C0037a> d = new SparseArray<>();
        public final SparseArray<c> e = new SparseArray<>();
        public final SparseArray<C0037a> f = new SparseArray<>();
        public final SparseArray<c> g = new SparseArray<>();
        @Nullable
        public b h;
        @Nullable
        public d i;

        public h(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }
    }

    public a(int i2, int i3) {
        Paint paint = new Paint();
        this.a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f = new h(i2, i3);
    }

    public static byte[] a(int i2, int i3, ParsableBitArray parsableBitArray) {
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) parsableBitArray.readBits(i3);
        }
        return bArr;
    }

    public static int[] b() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i2 = 1; i2 < 16; i2++) {
            if (i2 < 8) {
                iArr[i2] = d(255, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) != 0 ? 255 : 0);
            } else {
                int i3 = 127;
                int i4 = (i2 & 1) != 0 ? 127 : 0;
                int i5 = (i2 & 2) != 0 ? 127 : 0;
                if ((i2 & 4) == 0) {
                    i3 = 0;
                }
                iArr[i2] = d(255, i4, i5, i3);
            }
        }
        return iArr;
    }

    public static int[] c() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            int i3 = 255;
            if (i2 < 8) {
                int i4 = (i2 & 1) != 0 ? 255 : 0;
                int i5 = (i2 & 2) != 0 ? 255 : 0;
                if ((i2 & 4) == 0) {
                    i3 = 0;
                }
                iArr[i2] = d(63, i4, i5, i3);
            } else {
                int i6 = i2 & 136;
                int i7 = 170;
                int i8 = 85;
                if (i6 == 0) {
                    int i9 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0);
                    int i10 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0);
                    if ((i2 & 4) == 0) {
                        i8 = 0;
                    }
                    if ((i2 & 64) == 0) {
                        i7 = 0;
                    }
                    iArr[i2] = d(255, i9, i10, i8 + i7);
                } else if (i6 != 8) {
                    int i11 = 43;
                    if (i6 == 128) {
                        int i12 = ((i2 & 1) != 0 ? 43 : 0) + 127 + ((i2 & 16) != 0 ? 85 : 0);
                        int i13 = ((i2 & 2) != 0 ? 43 : 0) + 127 + ((i2 & 32) != 0 ? 85 : 0);
                        if ((i2 & 4) == 0) {
                            i11 = 0;
                        }
                        int i14 = i11 + 127;
                        if ((i2 & 64) == 0) {
                            i8 = 0;
                        }
                        iArr[i2] = d(255, i12, i13, i14 + i8);
                    } else if (i6 == 136) {
                        int i15 = ((i2 & 1) != 0 ? 43 : 0) + ((i2 & 16) != 0 ? 85 : 0);
                        int i16 = ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0);
                        if ((i2 & 4) == 0) {
                            i11 = 0;
                        }
                        if ((i2 & 64) == 0) {
                            i8 = 0;
                        }
                        iArr[i2] = d(255, i15, i16, i11 + i8);
                    }
                } else {
                    int i17 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0);
                    int i18 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0);
                    if ((i2 & 4) == 0) {
                        i8 = 0;
                    }
                    if ((i2 & 64) == 0) {
                        i7 = 0;
                    }
                    iArr[i2] = d(127, i17, i18, i8 + i7);
                }
            }
        }
        return iArr;
    }

    public static int d(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:0x0114 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:106:0x01d3 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01d1 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x020b A[LOOP:3: B:83:0x0163->B:113:0x020b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x013b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0205 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0112 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0141 A[LOOP:2: B:38:0x00ab->B:70:0x0141, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x016a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void e(byte[] r23, int[] r24, int r25, int r26, int r27, @androidx.annotation.Nullable android.graphics.Paint r28, android.graphics.Canvas r29) {
        /*
        // Method dump skipped, instructions count: 554
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.b.a1.d.a.e(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    public static C0037a f(ParsableBitArray parsableBitArray, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 8;
        int readBits = parsableBitArray.readBits(8);
        parsableBitArray.skipBits(8);
        int i8 = i2 - 2;
        int i9 = 4;
        int[] iArr = {0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
        int[] b2 = b();
        int[] c2 = c();
        while (i8 > 0) {
            int readBits2 = parsableBitArray.readBits(i7);
            int readBits3 = parsableBitArray.readBits(i7);
            int i10 = i8 - 2;
            int[] iArr2 = (readBits3 & 128) != 0 ? iArr : (readBits3 & 64) != 0 ? b2 : c2;
            if ((readBits3 & 1) != 0) {
                i6 = parsableBitArray.readBits(i7);
                i5 = parsableBitArray.readBits(i7);
                i4 = parsableBitArray.readBits(i7);
                i3 = parsableBitArray.readBits(i7);
                i8 = i10 - 4;
            } else {
                i8 = i10 - 2;
                i5 = parsableBitArray.readBits(i9) << i9;
                i3 = parsableBitArray.readBits(2) << 6;
                i6 = parsableBitArray.readBits(6) << 2;
                i4 = parsableBitArray.readBits(i9) << i9;
            }
            if (i6 == 0) {
                i5 = 0;
                i4 = 0;
                i3 = 255;
            }
            double d2 = (double) i6;
            double d3 = (double) (i5 - 128);
            double d4 = (double) (i4 - 128);
            iArr2[readBits2] = d((byte) (255 - (i3 & 255)), Util.constrainValue((int) ((1.402d * d3) + d2), 0, 255), Util.constrainValue((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255), Util.constrainValue((int) ((d4 * 1.772d) + d2), 0, 255));
            iArr = iArr;
            readBits = readBits;
            i7 = 8;
            i9 = 4;
        }
        return new C0037a(readBits, iArr, b2, c2);
    }

    public static c g(ParsableBitArray parsableBitArray) {
        byte[] bArr;
        int readBits = parsableBitArray.readBits(16);
        parsableBitArray.skipBits(4);
        int readBits2 = parsableBitArray.readBits(2);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(1);
        byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
        if (readBits2 == 1) {
            parsableBitArray.skipBits(parsableBitArray.readBits(8) * 16);
        } else if (readBits2 == 0) {
            int readBits3 = parsableBitArray.readBits(16);
            int readBits4 = parsableBitArray.readBits(16);
            if (readBits3 > 0) {
                bArr2 = new byte[readBits3];
                parsableBitArray.readBytes(bArr2, 0, readBits3);
            }
            if (readBits4 > 0) {
                bArr = new byte[readBits4];
                parsableBitArray.readBytes(bArr, 0, readBits4);
                return new c(readBits, readBit, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new c(readBits, readBit, bArr2, bArr);
    }
}
