package com.avito.security.libfp;

import com.avito.security.libfp.Application;
import com.google.common.base.Ascii;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Array;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
public class Application$Application$FingerprintService$a extends FilterInputStream {
    private static Object[] f;
    public int[] pyD;
    public int vAF;

    private Application$Application$FingerprintService$a(InputStream inputStream) throws IOException {
        super(new PushbackInputStream(inputStream, 4));
        InputStream application;
        for (boolean z = false; !z; z = true) {
            try {
                vEFmIGrBe();
                this.pyD = new int[4];
                this.vAF = 0;
                break;
            } catch (Exception unused) {
            }
        }
        byte[] bArr = (byte[]) f[7];
        byte[] bArr2 = new byte[16];
        IOException e = null;
        for (char c = 0; c == 0; c = 3) {
            try {
                int read = ((FilterInputStream) this).in.read(bArr2, 0, 4);
                if (read > 0) {
                    if (read == 4 && bArr2[0] == bArr[0] && bArr2[1] == bArr[1] && bArr2[2] == bArr[2] && bArr2[3] == bArr[3] + 1) {
                        ((FilterInputStream) this).in.read(bArr2, 4, 12);
                        for (int i = 0; i < 16; i++) {
                            int[] iArr = this.pyD;
                            iArr[i / 4] = (iArr[i / 4] << 8) | (bArr2[i] & 255);
                        }
                        application = new InflaterInputStream(((FilterInputStream) this).in, new Inflater(this) { // from class: com.avito.security.libfp.Application$Application$Application$FingerprintService$a
                            public Application$Application$FingerprintService$a G;

                            {
                                this.G = r2;
                            }

                            @Override // java.util.zip.Inflater
                            public void setInput(byte[] bArr3, int i2, int i3) {
                                this.G.xnw(bArr3, i2, i3);
                                super.setInput(bArr3, i2, i3);
                            }
                        });
                    } else if (read == 4 && bArr2[0] == bArr[0] && bArr2[1] == bArr[1] && bArr2[2] == bArr[2] && bArr2[3] == bArr[3]) {
                        ((FilterInputStream) this).in.read(bArr2, 4, 12);
                        for (int i2 = 0; i2 < 16; i2++) {
                            int[] iArr2 = this.pyD;
                            iArr2[i2 / 4] = (iArr2[i2 / 4] << 8) | (bArr2[i2] & 255);
                        }
                        application = new Application.C0170Application.C0171Application.C0172Application(((FilterInputStream) this).in, this);
                    } else {
                        ((PushbackInputStream) ((FilterInputStream) this).in).unread(bArr2, 0, 4);
                        return;
                    }
                    ((FilterInputStream) this).in = application;
                    return;
                }
                return;
            } catch (IOException e2) {
                e = e2;
            }
        }
        throw e;
    }

    public static InputStream eCsrG(InputStream inputStream) throws IOException {
        return new Application$Application$FingerprintService$a(inputStream);
    }

    private static int jsnxHA(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    public static final void vEFmIGrBe() {
        int i = 256;
        int[] iArr = new int[256];
        byte[] bArr = new byte[256];
        int[] iArr2 = new int[256];
        int[] iArr3 = new int[256];
        int[] iArr4 = new int[256];
        int[] iArr5 = new int[256];
        int[] iArr6 = new int[30];
        int i2 = 0;
        while (true) {
            if (i2 != 0) {
                break;
            }
            i2 += 2;
            int i3 = 1;
            for (int i4 = 0; i4 < i; i4++) {
                try {
                    iArr[i4] = i3;
                    i3 ^= (i3 << 1) ^ ((i3 >>> 7) * 283);
                } catch (Exception unused) {
                }
            }
            bArr[0] = 99;
            for (int i5 = 0; i5 < 255; i5++) {
                int i6 = iArr[255 - i5];
                int i7 = i6 | (i6 << 8);
                bArr[iArr[i5]] = (byte) ((i7 ^ ((((i7 >> 4) ^ (i7 >> 5)) ^ (i7 >> 6)) ^ (i7 >> 7))) ^ 99);
            }
            int i8 = 0;
            while (i8 < i) {
                int i9 = bArr[i8] & 255;
                int i10 = ((i9 >>> 7) * 283) ^ (i9 << 1);
                int i11 = (i10 ^ ((i9 << 8) ^ (((i9 ^ i10) << 24) ^ (i9 << 16)))) & -1;
                try {
                    iArr2[i8] = i11;
                    iArr3[i8] = (i11 << 8) | (i11 >>> -8);
                    iArr4[i8] = (i11 << 16) | (i11 >>> -16);
                    iArr5[i8] = (i11 >>> -24) | (i11 << 24);
                    i8++;
                    i = 256;
                } catch (Exception unused2) {
                    i = 256;
                }
            }
            int i12 = 1;
            for (int i13 = 0; i13 < 30; i13++) {
                iArr6[i13] = i12;
                i12 = ((i12 >>> 7) * 283) ^ (i12 << 1);
            }
        }
        byte[] bArr2 = null;
        boolean z = false;
        loop5:
        while (true) {
            if (z) {
                break;
            }
            try {
                long parseLong = Long.parseLong("-4954122079066109275") ^ (((Long.MAX_VALUE - System.currentTimeMillis()) >> 63) & 1);
                long parseLong2 = Long.parseLong("-764525481510992023");
                bArr2 = new byte[16];
                int i14 = 0;
                for (int i15 = 16; i14 < i15; i15 = 16) {
                    try {
                        bArr2[i14] = (byte) ((int) (((i14 > 7 ? parseLong2 : parseLong) >> ((7 - (i14 % 8)) * 8)) & 255));
                        i14++;
                        iArr6 = iArr6;
                    } catch (Exception unused3) {
                        iArr6 = iArr6;
                    }
                }
                break loop5;
            } catch (Exception unused4) {
            }
            z = true;
        }
        int length = bArr2.length / 4;
        int i16 = length + 6 + 1;
        int[] iArr7 = new int[2];
        iArr7[1] = 4;
        iArr7[0] = i16;
        int[][] iArr8 = (int[][]) Array.newInstance(int.class, iArr7);
        int i17 = 0;
        int i18 = 0;
        while (i17 < bArr2.length) {
            iArr8[i18 >> 2][i18 & 3] = ((bArr2[i17 + 1] & 255) << 8) | (bArr2[i17] & 255) | ((bArr2[i17 + 2] & 255) << 16) | (bArr2[i17 + 3] << Ascii.CAN);
            i17 += 4;
            i18++;
        }
        int i19 = i16 << 2;
        for (int i20 = length; i20 < i19; i20++) {
            int i21 = i20 - 1;
            int i22 = iArr8[i21 >> 2][i21 & 3];
            int i23 = i20 % length;
            if (i23 == 0) {
                i22 = iArr6[(i20 / length) - 1] ^ ymc(bArr, jsnxHA(i22, 8));
            } else if (length > 6 && i23 == 4) {
                i22 = ymc(bArr, i22);
            }
            int i24 = i20 - length;
            iArr8[i20 >> 2][i20 & 3] = iArr8[i24 >> 2][i24 & 3] ^ i22;
        }
        int i25 = 4;
        byte[] bArr3 = new byte[4];
        char c = 0;
        loop9:
        while (c == 0) {
            try {
                int parseInt = Integer.parseInt("-939200675");
                int i26 = 0;
                while (i26 < i25) {
                    try {
                        bArr3[i26] = (byte) ((parseInt >> ((3 - (i26 % 8)) * 8)) & 255);
                        i26++;
                        i25 = 4;
                    } catch (Exception unused5) {
                        c = 2;
                        i25 = 4;
                    }
                }
                break loop9;
            } catch (Exception unused6) {
                c = 2;
            }
        }
        f = new Object[]{bArr, iArr2, iArr3, iArr4, iArr5, iArr8, new int[]{Integer.parseInt("-1145832651"), Integer.parseInt("1680172387"), Integer.parseInt("353087370"), Integer.parseInt("-1192877860")}, bArr3};
    }

    private static int ymc(byte[] bArr, int i) {
        int i2 = bArr[14] << Ascii.DLE;
        boolean z = false;
        int i3 = 0;
        while (i3 == 0) {
            i3 += 3;
            try {
                return (bArr[i & 255] & 255) | ((bArr[(i >> 8) & 255] & 255) << 8) | ((bArr[(i >> 16) & 255] & 255) << 16) | (bArr[(i >> 24) & 255] << Ascii.CAN);
            } catch (Exception unused) {
            }
        }
        while (!z) {
            z = true;
            try {
                return bArr[i & 127] >> 8;
            } catch (Exception unused2) {
            }
        }
        return i2;
    }

    public final void xnw(byte[] bArr, int i, int i2) {
        int[] iArr;
        int i3;
        Object[] objArr = f;
        int[][] iArr2 = (int[][]) objArr[5];
        char c = 1;
        int[] iArr3 = (int[]) objArr[1];
        int i4 = 2;
        int[] iArr4 = (int[]) objArr[2];
        char c2 = 3;
        int[] iArr5 = (int[]) objArr[3];
        int i5 = 4;
        int[] iArr6 = (int[]) objArr[4];
        char c3 = 0;
        byte[] bArr2 = (byte[]) objArr[0];
        int i6 = i2;
        int i7 = 0;
        while (i7 < i6) {
            int i8 = this.vAF;
            int i9 = (i8 % 16) / i5;
            int i10 = (i8 % 16) % 4;
            if (i8 % 16 == 0) {
                int i11 = 0;
                while (i11 == 0) {
                    i11 += 3;
                    try {
                        int[] iArr7 = this.pyD;
                        iArr7[c3] = iArr7[c3] ^ iArr2[c3][c3];
                        iArr7[c] = iArr7[c] ^ iArr2[c3][c];
                        iArr7[i4] = iArr7[i4] ^ iArr2[c3][i4];
                        iArr7[c2] = iArr7[c2] ^ iArr2[c3][c2];
                        break;
                    } catch (Exception unused) {
                    }
                }
                int i12 = 1;
                while (i12 < iArr2.length - i4) {
                    int[] iArr8 = this.pyD;
                    int i13 = (((iArr4[(iArr8[c] >> 8) & 255] ^ iArr3[iArr8[c3] & 255]) ^ iArr5[(iArr8[i4] >> 16) & 255]) ^ iArr6[(iArr8[3] >> 24) & 255]) ^ iArr2[i12][c3];
                    int i14 = (((iArr3[iArr8[1] & 255] ^ iArr4[(iArr8[i4] >> 8) & 255]) ^ iArr5[(iArr8[3] >> 16) & 255]) ^ iArr6[(iArr8[0] >> 24) & 255]) ^ iArr2[i12][1];
                    int i15 = (((iArr4[(iArr8[3] >> 8) & 255] ^ iArr3[iArr8[i4] & 255]) ^ iArr5[(iArr8[0] >> 16) & 255]) ^ iArr6[(iArr8[1] >> 24) & 255]) ^ iArr2[i12][2];
                    int i16 = i12 + 1;
                    int i17 = iArr2[i12][3] ^ (((iArr3[iArr8[3] & 255] ^ iArr4[(iArr8[0] >> 8) & 255]) ^ iArr5[(iArr8[1] >> 16) & 255]) ^ iArr6[(iArr8[2] >> 24) & 255]);
                    iArr8[0] = (((iArr3[i13 & 255] ^ iArr4[(i14 >> 8) & 255]) ^ iArr5[(i15 >> 16) & 255]) ^ iArr6[(i17 >> 24) & 255]) ^ iArr2[i16][0];
                    iArr8[1] = (((iArr3[i14 & 255] ^ iArr4[(i15 >> 8) & 255]) ^ iArr5[(i17 >> 16) & 255]) ^ iArr6[(i13 >> 24) & 255]) ^ iArr2[i16][1];
                    iArr8[2] = (((iArr3[i15 & 255] ^ iArr4[(i17 >> 8) & 255]) ^ iArr5[(i13 >> 16) & 255]) ^ iArr6[(i14 >> 24) & 255]) ^ iArr2[i16][2];
                    int i18 = iArr3[i17 & 255];
                    i12 = i16 + 1;
                    iArr8[3] = (((iArr4[(i13 >> 8) & 255] ^ i18) ^ iArr5[(i14 >> 16) & 255]) ^ iArr6[(i15 >> 24) & 255]) ^ iArr2[i16][3];
                    i9 = i9;
                    c = 1;
                    i4 = 2;
                    c3 = 0;
                }
                i3 = i9;
                char c4 = 0;
                while (true) {
                    if (c4 != 0) {
                        iArr = iArr3;
                        c2 = 3;
                        break;
                    }
                    try {
                        int[] iArr9 = this.pyD;
                        try {
                        } catch (Exception unused2) {
                            c4 = 3;
                        }
                        try {
                            int i19 = (((iArr3[iArr9[0] & 255] ^ iArr4[(iArr9[1] >> 8) & 255]) ^ iArr5[(iArr9[2] >> 16) & 255]) ^ iArr6[(iArr9[3] >> 24) & 255]) ^ iArr2[i12][0];
                            try {
                                int i20 = (((iArr3[iArr9[1] & 255] ^ iArr4[(iArr9[2] >> 8) & 255]) ^ iArr5[(iArr9[3] >> 16) & 255]) ^ iArr6[(iArr9[0] >> 24) & 255]) ^ iArr2[i12][1];
                                int i21 = (((iArr3[iArr9[2] & 255] ^ iArr4[(iArr9[3] >> 8) & 255]) ^ iArr5[(iArr9[0] >> 16) & 255]) ^ iArr6[(iArr9[1] >> 24) & 255]) ^ iArr2[i12][2];
                                int i22 = i12 + 1;
                                int i23 = (((iArr3[iArr9[3] & 255] ^ iArr4[(iArr9[0] >> 8) & 255]) ^ iArr5[(iArr9[1] >> 16) & 255]) ^ iArr6[(iArr9[2] >> 24) & 255]) ^ iArr2[i12][3];
                                iArr = iArr3;
                                try {
                                } catch (Exception unused3) {
                                    iArr3 = iArr;
                                    c4 = 3;
                                }
                                try {
                                    iArr9[0] = (((((bArr2[(i20 >> 8) & 255] & 255) << 8) ^ (bArr2[i19 & 255] & 255)) ^ ((bArr2[(i21 >> 16) & 255] & 255) << 16)) ^ (bArr2[(i23 >> 24) & 255] << Ascii.CAN)) ^ iArr2[i22][0];
                                    iArr9[1] = ((((bArr2[i20 & 255] & 255) ^ ((bArr2[(i21 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(i23 >> 16) & 255] & 255) << 16)) ^ (bArr2[(i19 >> 24) & 255] << Ascii.CAN)) ^ iArr2[i22][1];
                                } catch (Exception unused4) {
                                    iArr3 = iArr;
                                    c4 = 3;
                                }
                                try {
                                    iArr9[2] = ((((bArr2[i21 & 255] & 255) ^ ((bArr2[(i23 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(i19 >> 16) & 255] & 255) << 16)) ^ (bArr2[(i20 >> 24) & 255] << Ascii.CAN)) ^ iArr2[i22][2];
                                    int i24 = (((bArr2[i23 & 255] & 255) ^ ((bArr2[(i19 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(i20 >> 16) & 255] & 255) << 16)) ^ (bArr2[(i21 >> 24) & 255] << Ascii.CAN);
                                    c2 = 3;
                                    try {
                                        iArr9[3] = i24 ^ iArr2[i22][3];
                                        break;
                                    } catch (Exception unused5) {
                                    }
                                } catch (Exception unused6) {
                                    iArr3 = iArr;
                                    c4 = 3;
                                }
                            } catch (Exception unused7) {
                            }
                        } catch (Exception unused8) {
                            c4 = 3;
                        }
                    } catch (Exception unused9) {
                        c4 = 3;
                    }
                    c4 = 3;
                }
            } else {
                iArr = iArr3;
                i3 = i9;
            }
            int i25 = i + i7;
            bArr[i25] = (byte) (((byte) (this.pyD[i3] >> (i10 * 8))) ^ bArr[i25]);
            this.vAF++;
            i7++;
            i6 = i2;
            iArr3 = iArr;
            c = 1;
            i4 = 2;
            i5 = 4;
            c3 = 0;
        }
    }
}
