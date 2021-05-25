package x6.e.f.a.c;

import org.spongycastle.util.Pack;
public class b {
    public static int b(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    public void a(byte[] bArr, byte[] bArr2) {
        int i = 16;
        int[] iArr = new int[16];
        for (int i2 = 0; i2 < 16; i2++) {
            iArr[i2] = Pack.littleEndianToInt(bArr2, i2 * 4);
        }
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        int i7 = iArr[4];
        int i8 = iArr[5];
        int i9 = iArr[6];
        int i10 = 7;
        int i11 = iArr[7];
        int i12 = iArr[8];
        int i13 = iArr[9];
        int i14 = iArr[10];
        int i15 = iArr[11];
        int i16 = iArr[12];
        int i17 = iArr[13];
        int i18 = iArr[14];
        int i19 = iArr[15];
        int i20 = 12;
        while (i20 > 0) {
            int i21 = i3 + i7;
            int b = b(i16 ^ i21, i);
            int i22 = i12 + b;
            int b2 = b(i7 ^ i22, 12);
            int i23 = i21 + b2;
            int b3 = b(b ^ i23, 8);
            int i24 = i22 + b3;
            int b4 = b(b2 ^ i24, i10);
            int i25 = i4 + i8;
            int b5 = b(i17 ^ i25, i);
            int i26 = i13 + b5;
            int b6 = b(i8 ^ i26, 12);
            int i27 = i25 + b6;
            int b8 = b(b5 ^ i27, 8);
            int i28 = i26 + b8;
            int b9 = b(b6 ^ i28, i10);
            int i29 = i5 + i9;
            int b10 = b(i18 ^ i29, i);
            int i30 = i14 + b10;
            int b11 = b(i9 ^ i30, 12);
            int i31 = i29 + b11;
            int b12 = b(b10 ^ i31, 8);
            int i32 = i30 + b12;
            int b13 = b(b11 ^ i32, i10);
            int i33 = i6 + i11;
            int b14 = b(i19 ^ i33, i);
            int i34 = i15 + b14;
            int b15 = b(i11 ^ i34, 12);
            int i35 = i33 + b15;
            int b16 = b(b14 ^ i35, 8);
            int i36 = i34 + b16;
            int b17 = b(b15 ^ i36, i10);
            int i37 = i23 + b9;
            int b18 = b(b16 ^ i37, 16);
            int i38 = i32 + b18;
            int b19 = b(b9 ^ i38, 12);
            i3 = i37 + b19;
            i19 = b(b18 ^ i3, 8);
            i14 = i38 + i19;
            int b20 = b(b19 ^ i14, 7);
            int i39 = i27 + b13;
            int b21 = b(b3 ^ i39, 16);
            int i40 = i36 + b21;
            int b22 = b(b13 ^ i40, 12);
            i4 = i39 + b22;
            i16 = b(b21 ^ i4, 8);
            i15 = i40 + i16;
            i9 = b(b22 ^ i15, 7);
            int i41 = i31 + b17;
            int b23 = b(b8 ^ i41, 16);
            int i42 = i24 + b23;
            int b24 = b(b17 ^ i42, 12);
            i5 = i41 + b24;
            i17 = b(b23 ^ i5, 8);
            i12 = i42 + i17;
            i11 = b(b24 ^ i12, 7);
            int i43 = i35 + b4;
            int b25 = b(b12 ^ i43, 16);
            int i44 = i28 + b25;
            int b26 = b(b4 ^ i44, 12);
            i6 = i43 + b26;
            i18 = b(b25 ^ i6, 8);
            i13 = i44 + i18;
            i7 = b(b26 ^ i13, 7);
            i20 -= 2;
            i8 = b20;
            i = 16;
            i10 = 7;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        iArr[2] = i5;
        iArr[3] = i6;
        iArr[4] = i7;
        iArr[5] = i8;
        iArr[6] = i9;
        iArr[7] = i11;
        iArr[8] = i12;
        iArr[9] = i13;
        iArr[10] = i14;
        iArr[11] = i15;
        iArr[12] = i16;
        iArr[13] = i17;
        iArr[14] = i18;
        iArr[15] = i19;
        for (int i45 = 0; i45 < 16; i45++) {
            Pack.intToLittleEndian(iArr[i45], bArr, i45 * 4);
        }
    }
}
