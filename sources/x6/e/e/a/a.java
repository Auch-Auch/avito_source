package x6.e.e.a;

import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.common.primitives.Shorts;
import java.math.BigInteger;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.util.Arrays;
public class a implements Cloneable {
    public static final short[] b = {0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85, 256, 257, 260, 261, 272, 273, 276, 277, 320, 321, 324, 325, 336, 337, 340, 341, SilenceSkippingAudioProcessor.DEFAULT_SILENCE_THRESHOLD_LEVEL, 1025, 1028, 1029, 1040, 1041, 1044, 1045, 1088, 1089, 1092, 1093, 1104, 1105, 1108, 1109, 1280, 1281, 1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 1360, 1361, 1364, 1365, 4096, 4097, 4100, 4101, 4112, 4113, 4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, Shorts.MAX_POWER_OF_TWO, 16385, 16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 17748, 17749, 20480, 20481, 20484, 20485, 20496, 20497, 20500, 20501, 20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 21828, 21829, 21840, 21841, 21844, 21845};
    public static final byte[] c = {0, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
    public long[] a;

    public a(int i) {
        this.a = new long[i];
    }

    public static void a(long[] jArr, int i, long[] jArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i + i4;
            jArr[i5] = jArr[i5] ^ jArr2[i2 + i4];
        }
    }

    public static void b(long[] jArr, int i, long[] jArr2, int i2, long[] jArr3, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            jArr3[i3 + i5] = jArr[i + i5] ^ jArr2[i2 + i5];
        }
    }

    public static void c(long[] jArr, int i, long[] jArr2, int i2, long[] jArr3, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i + i5;
            jArr[i6] = jArr[i6] ^ (jArr2[i2 + i5] ^ jArr3[i3 + i5]);
        }
    }

    public static long f(long[] jArr, int i, long[] jArr2, int i2, int i3, int i4) {
        int i5 = 64 - i4;
        long j = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            long j2 = jArr2[i2 + i6];
            int i7 = i + i6;
            jArr[i7] = (j | (j2 << i4)) ^ jArr[i7];
            j = j2 >>> i5;
        }
        return j;
    }

    public static int g(long j) {
        int i;
        int i2 = 32;
        int i3 = (int) (j >>> 32);
        if (i3 == 0) {
            i3 = (int) j;
            i2 = 0;
        }
        int i4 = i3 >>> 16;
        if (i4 == 0) {
            int i5 = i3 >>> 8;
            i = i5 == 0 ? c[i3] : c[i5] + 8;
        } else {
            int i6 = i4 >>> 8;
            i = i6 == 0 ? c[i4] + 16 : c[i6] + 24;
        }
        return i2 + i;
    }

    public static void j(long[] jArr, int i, int i2) {
        int i3 = i + (i2 >>> 6);
        jArr[i3] = jArr[i3] ^ (1 << (i2 & 63));
    }

    public static void k(long[] jArr, int i, long[] jArr2, int i2, int i3, int i4) {
        int i5 = i + (i4 >>> 6);
        int i6 = i4 & 63;
        if (i6 == 0) {
            a(jArr, i5, jArr2, i2, i3);
            return;
        }
        int i7 = i3;
        int i8 = i5 + 1;
        int i9 = 64 - i6;
        int i10 = 64 - i9;
        long j = 0;
        while (true) {
            i7--;
            if (i7 >= 0) {
                long j2 = jArr2[i2 + i7];
                int i11 = i8 + i7;
                jArr[i11] = (j | (j2 >>> i9)) ^ jArr[i11];
                j = j2 << i10;
            } else {
                jArr[i5] = jArr[i5] ^ j;
                return;
            }
        }
    }

    public static void l(long[] jArr, int i, int i2, long j) {
        int i3 = i + (i2 >>> 6);
        int i4 = i2 & 63;
        if (i4 == 0) {
            jArr[i3] = jArr[i3] ^ j;
            return;
        }
        jArr[i3] = jArr[i3] ^ (j << i4);
        long j2 = j >>> (64 - i4);
        if (j2 != 0) {
            int i5 = i3 + 1;
            jArr[i5] = j2 ^ jArr[i5];
        }
    }

    public static long n(int i) {
        short[] sArr = b;
        int i2 = sArr[i & 255] | (sArr[(i >>> 8) & 255] << 16);
        short s = sArr[(i >>> 16) & 255];
        return (((long) i2) & BodyPartID.bodyIdMax) | ((((long) ((sArr[i >>> 24] << 16) | s)) & BodyPartID.bodyIdMax) << 32);
    }

    public static void s(long j, long[] jArr, int i, long[] jArr2, int i2) {
        if ((j & 1) != 0) {
            a(jArr2, i2, jArr, 0, i);
        }
        int i3 = 1;
        long j2 = j;
        while (true) {
            long j3 = j2 >>> 1;
            if (j3 != 0) {
                if ((j3 & 1) != 0) {
                    long f = f(jArr2, i2, jArr, 0, i, i3);
                    if (f != 0) {
                        int i4 = i2 + i;
                        jArr2[i4] = f ^ jArr2[i4];
                    }
                }
                i3++;
                j2 = j3;
            } else {
                return;
            }
        }
    }

    public static void u(long[] jArr, int i, int i2, int i3, int[] iArr) {
        j(jArr, i, i2);
        int i4 = i2 - i3;
        int length = iArr.length;
        while (true) {
            length--;
            if (length >= 0) {
                j(jArr, i, iArr[length] + i4);
            } else {
                j(jArr, i, i4);
                return;
            }
        }
    }

    public static int v(long[] jArr, int i, int i2, int i3, int[] iArr) {
        int i4 = (i3 + 63) >>> 6;
        if (i2 < i4) {
            return i2;
        }
        int i5 = i2 << 6;
        int min = Math.min(i5, (i3 << 1) - 1);
        int i6 = i5 - min;
        int i7 = i2;
        while (i6 >= 64) {
            i7--;
            i6 -= 64;
        }
        int length = iArr.length;
        int i8 = iArr[length - 1];
        int i9 = length > 1 ? iArr[length - 2] : 0;
        int max = Math.max(i3, i8 + 64);
        int min2 = (Math.min(min - max, i3 - i9) + i6) >> 6;
        if (min2 > 1) {
            int i10 = i7 - min2;
            int i11 = i10 << 6;
            int i12 = i11 - i3;
            int length2 = iArr.length;
            while (true) {
                int i13 = length2 - 1;
                if (i13 < 0) {
                    break;
                }
                k(jArr, i, jArr, i + i10, i7 - i10, i12 + iArr[i13]);
                i10 = i10;
                length2 = i13;
            }
            k(jArr, i, jArr, i + i10, i7 - i10, i12);
            while (i7 > i10) {
                i7--;
                jArr[i + i7] = 0;
            }
            min = i11;
        }
        if (min > max) {
            int i14 = max >>> 6;
            while (true) {
                i7--;
                if (i7 <= i14) {
                    break;
                }
                int i15 = i + i7;
                long j = jArr[i15];
                if (j != 0) {
                    jArr[i15] = 0;
                    int i16 = (i7 << 6) - i3;
                    int length3 = iArr.length;
                    while (true) {
                        length3--;
                        if (length3 < 0) {
                            break;
                        }
                        l(jArr, i, iArr[length3] + i16, j);
                    }
                    l(jArr, i, i16, j);
                }
            }
            int i17 = max & 63;
            int i18 = i14 + i;
            long j2 = jArr[i18] >>> i17;
            if (j2 != 0) {
                jArr[i18] = jArr[i18] ^ (j2 << i17);
                int i19 = max - i3;
                int length4 = iArr.length;
                while (true) {
                    length4--;
                    if (length4 < 0) {
                        break;
                    }
                    l(jArr, i, iArr[length4] + i19, j2);
                }
                l(jArr, i, i19, j2);
            }
        } else {
            max = min;
        }
        if (max > i3) {
            while (true) {
                max--;
                if (max < i3) {
                    break;
                }
                if ((jArr[(max >>> 6) + i] & (1 << (max & 63))) != 0) {
                    u(jArr, i, max, i3, iArr);
                }
            }
        }
        return i4;
    }

    public static long w(long[] jArr, int i, long[] jArr2, int i2, int i3, int i4) {
        int i5 = 64 - i4;
        long j = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            long j2 = jArr[i + i6];
            jArr2[i2 + i6] = j | (j2 << i4);
            j = j2 >>> i5;
        }
        return j;
    }

    @Override // java.lang.Object
    public Object clone() {
        return new a(Arrays.clone(this.a));
    }

    public final void d(a aVar, int i, int i2) {
        int i3 = (i + 63) >>> 6;
        int i4 = i2 >>> 6;
        int i5 = i2 & 63;
        if (i5 == 0) {
            a(this.a, i4, aVar.a, 0, i3);
            return;
        }
        long f = f(this.a, i4, aVar.a, 0, i3, i5);
        if (f != 0) {
            long[] jArr = this.a;
            int i6 = i3 + i4;
            jArr[i6] = f ^ jArr[i6];
        }
    }

    public void e(a aVar, int i) {
        int m = aVar.m();
        if (m != 0) {
            int i2 = m + i;
            long[] jArr = this.a;
            if (i2 > jArr.length) {
                long[] jArr2 = new long[i2];
                System.arraycopy(jArr, 0, jArr2, 0, Math.min(jArr.length, i2));
                this.a = jArr2;
            }
            a(this.a, i, aVar.a, 0, m);
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        int m = m();
        if (aVar.m() != m) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            if (this.a[i] != aVar.a[i]) {
                return false;
            }
        }
        return true;
    }

    public int h() {
        int length = this.a.length;
        while (length != 0) {
            length--;
            long j = this.a[length];
            if (j != 0) {
                return g(j) + (length << 6);
            }
        }
        return 0;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int m = m();
        int i = 1;
        for (int i2 = 0; i2 < m; i2++) {
            long j = this.a[i2];
            i = (((i * 31) ^ ((int) j)) * 31) ^ ((int) (j >>> 32));
        }
        return i;
    }

    public final int i(int i) {
        int i2 = (i + 62) >>> 6;
        while (i2 != 0) {
            i2--;
            long j = this.a[i2];
            if (j != 0) {
                return g(j) + (i2 << 6);
            }
        }
        return 0;
    }

    public int m() {
        long[] jArr = this.a;
        int min = Math.min(jArr.length, jArr.length);
        if (min < 1) {
            return 0;
        }
        if (jArr[0] != 0) {
            do {
                min--;
            } while (jArr[min] == 0);
        } else {
            do {
                min--;
                if (jArr[min] != 0) {
                }
            } while (min > 0);
            return 0;
        }
        return min + 1;
    }

    public boolean o() {
        long[] jArr = this.a;
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean p() {
        long[] jArr;
        for (long j : this.a) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    public a q(int i, int[] iArr) {
        int h = h();
        if (h != 0) {
            int i2 = 1;
            if (h == 1) {
                return this;
            }
            int i3 = (i + 63) >>> 6;
            a aVar = new a(i3);
            u(aVar.a, 0, i, i, iArr);
            a aVar2 = new a(i3);
            aVar2.a[0] = 1;
            a aVar3 = new a(i3);
            int[] iArr2 = {h, i + 1};
            a[] aVarArr = {(a) clone(), aVar};
            int[] iArr3 = {1, 0};
            a[] aVarArr2 = {aVar2, aVar3};
            int i4 = iArr2[1];
            int i5 = iArr3[1];
            int i6 = i4 - iArr2[0];
            while (true) {
                if (i6 < 0) {
                    i6 = -i6;
                    iArr2[i2] = i4;
                    iArr3[i2] = i5;
                    int i7 = 1 - i2;
                    int i8 = iArr2[i7];
                    i5 = iArr3[i7];
                    i2 = i7;
                    i4 = i8;
                }
                int i9 = 1 - i2;
                aVarArr[i2].d(aVarArr[i9], iArr2[i9], i6);
                int i10 = aVarArr[i2].i(i4);
                if (i10 == 0) {
                    return aVarArr2[i9];
                }
                int i11 = iArr3[i9];
                aVarArr2[i2].d(aVarArr2[i9], i11, i6);
                int i12 = i11 + i6;
                if (i12 > i5) {
                    i5 = i12;
                } else if (i12 == i5) {
                    i5 = aVarArr2[i2].i(i5);
                }
                i6 += i10 - i4;
                i4 = i10;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public a r(a aVar) {
        int i;
        int i2;
        a aVar2;
        a aVar3;
        long[] jArr;
        int i3;
        int h = h();
        if (h == 0) {
            return this;
        }
        int h2 = aVar.h();
        if (h2 == 0) {
            return aVar;
        }
        if (h > h2) {
            i = h;
            i2 = h2;
            aVar3 = this;
            aVar2 = aVar;
        } else {
            i2 = h;
            i = h2;
            aVar2 = this;
            aVar3 = aVar;
        }
        int i4 = (i2 + 63) >>> 6;
        int i5 = (i + 63) >>> 6;
        int i6 = ((i2 + i) + 62) >>> 6;
        if (i4 == 1) {
            long j = aVar2.a[0];
            if (j == 1) {
                return aVar3;
            }
            long[] jArr2 = new long[i6];
            s(j, aVar3.a, i5, jArr2, 0);
            return new a(jArr2, 0, i6);
        }
        int i7 = ((i + 7) + 63) >>> 6;
        int[] iArr = new int[16];
        int i8 = i7 << 4;
        long[] jArr3 = new long[i8];
        iArr[1] = i7;
        System.arraycopy(aVar3.a, 0, jArr3, i7, i5);
        int i9 = 2;
        int i10 = i7;
        for (int i11 = 16; i9 < i11; i11 = 16) {
            i10 += i7;
            iArr[i9] = i10;
            if ((i9 & 1) == 0) {
                jArr = jArr3;
                i3 = i8;
                w(jArr3, i10 >>> 1, jArr3, i10, i7, 1);
            } else {
                jArr = jArr3;
                i3 = i8;
                b(jArr, i7, jArr, i10 - i7, jArr3, i10, i7);
            }
            i9++;
            i8 = i3;
            jArr3 = jArr;
        }
        long[] jArr4 = new long[i8];
        w(jArr3, 0, jArr4, 0, i8, 4);
        long[] jArr5 = aVar2.a;
        int i12 = i6 << 3;
        long[] jArr6 = new long[i12];
        for (int i13 = 0; i13 < i4; i13++) {
            long j2 = jArr5[i13];
            int i14 = i13;
            while (true) {
                long j3 = j2 >>> 4;
                c(jArr6, i14, jArr3, iArr[((int) j2) & 15], jArr4, iArr[((int) j3) & 15], i7);
                j2 = j3 >>> 4;
                if (j2 == 0) {
                    break;
                }
                i14 += i6;
            }
        }
        while (true) {
            i12 -= i6;
            if (i12 == 0) {
                return new a(jArr6, 0, i6);
            }
            f(jArr6, i12 - i6, jArr6, i12, i6, 8);
        }
    }

    public void t(int i, int[] iArr) {
        long[] jArr = this.a;
        int v = v(jArr, 0, jArr.length, i, iArr);
        if (v < jArr.length) {
            long[] jArr2 = new long[v];
            this.a = jArr2;
            System.arraycopy(jArr, 0, jArr2, 0, v);
        }
    }

    @Override // java.lang.Object
    public String toString() {
        int m = m();
        if (m == 0) {
            return "0";
        }
        int i = m - 1;
        StringBuffer stringBuffer = new StringBuffer(Long.toBinaryString(this.a[i]));
        while (true) {
            i--;
            if (i < 0) {
                return stringBuffer.toString();
            }
            String binaryString = Long.toBinaryString(this.a[i]);
            int length = binaryString.length();
            if (length < 64) {
                stringBuffer.append("0000000000000000000000000000000000000000000000000000000000000000".substring(length));
            }
            stringBuffer.append(binaryString);
        }
    }

    public BigInteger x() {
        int m = m();
        if (m == 0) {
            return ECConstants.ZERO;
        }
        int i = m - 1;
        long j = this.a[i];
        byte[] bArr = new byte[8];
        int i2 = 0;
        boolean z = false;
        for (int i3 = 7; i3 >= 0; i3--) {
            byte b2 = (byte) ((int) (j >>> (i3 * 8)));
            if (z || b2 != 0) {
                bArr[i2] = b2;
                i2++;
                z = true;
            }
        }
        byte[] bArr2 = new byte[((i * 8) + i2)];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4] = bArr[i4];
        }
        for (int i5 = m - 2; i5 >= 0; i5--) {
            long j2 = this.a[i5];
            int i6 = 7;
            while (i6 >= 0) {
                bArr2[i2] = (byte) ((int) (j2 >>> (i6 * 8)));
                i6--;
                i2++;
            }
        }
        return new BigInteger(1, bArr2);
    }

    public a(long[] jArr) {
        this.a = jArr;
    }

    public a(long[] jArr, int i, int i2) {
        if (i == 0 && i2 == jArr.length) {
            this.a = jArr;
            return;
        }
        long[] jArr2 = new long[i2];
        this.a = jArr2;
        System.arraycopy(jArr, i, jArr2, 0, i2);
    }

    public a(BigInteger bigInteger) {
        int i;
        if (bigInteger == null || bigInteger.signum() < 0) {
            throw new IllegalArgumentException("invalid F2m field value");
        } else if (bigInteger.signum() == 0) {
            this.a = new long[]{0};
        } else {
            byte[] byteArray = bigInteger.toByteArray();
            int length = byteArray.length;
            if (byteArray[0] == 0) {
                length--;
                i = 1;
            } else {
                i = 0;
            }
            int i2 = (length + 7) / 8;
            this.a = new long[i2];
            int i3 = i2 - 1;
            int i4 = (length % 8) + i;
            if (i < i4) {
                long j = 0;
                while (i < i4) {
                    j = (j << 8) | ((long) (byteArray[i] & 255));
                    i++;
                }
                this.a[i3] = j;
                i3--;
            }
            while (i3 >= 0) {
                long j2 = 0;
                int i5 = 0;
                while (i5 < 8) {
                    j2 = (j2 << 8) | ((long) (byteArray[i] & 255));
                    i5++;
                    i++;
                }
                this.a[i3] = j2;
                i3--;
            }
        }
    }
}
