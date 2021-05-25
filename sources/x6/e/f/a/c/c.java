package x6.e.f.a.c;

import org.spongycastle.util.Pack;
public class c {

    public static class a {
        public int a;
        public long b;
        public long c;
    }

    public static void a(a aVar, byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        int i4;
        int i5 = 67;
        for (int i6 = 0; i6 < 7; i6++) {
            int i7 = 0;
            while (true) {
                i4 = i5 >>> 1;
                if (i7 >= i4) {
                    break;
                }
                aVar.a(bArr2, (i7 * 32) + i2, bArr2, (i7 * 2 * 32) + i2, bArr3, (i6 * 2 * 32) + i3);
                i7++;
            }
            if ((i5 & 1) != 0) {
                System.arraycopy(bArr2, ((i5 - 1) * 32) + i2, bArr2, (i4 * 32) + i2, 32);
                i4++;
            }
            i5 = i4;
        }
        System.arraycopy(bArr2, i2, bArr, i, 32);
    }

    public static void b(a aVar, byte[] bArr, int i, int i2, byte[] bArr2, a aVar2, byte[] bArr3, int i3) {
        int i4 = aVar2.a;
        long j = aVar2.b;
        long j2 = aVar2.c;
        int i5 = i2 + 1;
        byte[] bArr4 = new byte[(i5 * 32)];
        int[] iArr = new int[i5];
        int i6 = (int) (((long) (1 << i2)) + j2);
        int i7 = 0;
        long j3 = j2;
        int i8 = 0;
        while (j3 < ((long) i6)) {
            int i9 = i8 * 32;
            byte[] bArr5 = new byte[32];
            byte[] bArr6 = new byte[2144];
            byte[] bArr7 = new byte[40];
            for (int i10 = 0; i10 < 32; i10++) {
                bArr7[i10] = bArr2[i10];
            }
            Pack.longToLittleEndian((j3 << 59) | ((long) i4) | (j << 4), bArr7, 32);
            aVar.a.update(bArr7, i7, 40);
            aVar.a.doFinal(bArr5, i7);
            d.a(bArr6, i7, bArr5, i7);
            int i11 = 0;
            while (i11 < 67) {
                int i12 = (i11 * 32) + 0;
                d.b(aVar, bArr6, i12, bArr6, i12, bArr3, i3, 15);
                i11++;
                bArr6 = bArr6;
            }
            a(aVar, bArr4, i9, bArr6, 0, bArr3, i3);
            iArr[i8] = 0;
            int i13 = i8 + 1;
            while (i13 > 1) {
                int i14 = i13 - 1;
                int i15 = i13 - 2;
                if (iArr[i14] != iArr[i15]) {
                    break;
                }
                int i16 = i15 * 32;
                aVar.a(bArr4, i16, bArr4, i16, bArr3, i3 + ((iArr[i14] + 7) * 2 * 32));
                iArr[i15] = iArr[i15] + 1;
                i13 = i14;
            }
            j3++;
            i8 = i13;
            i7 = 0;
        }
        for (int i17 = 0; i17 < 32; i17++) {
            bArr[i + i17] = bArr4[i17];
        }
    }
}
