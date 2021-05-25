package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.TweakableBlockCipherParameters;
public class ThreefishEngine implements BlockCipher {
    public static final int BLOCKSIZE_1024 = 1024;
    public static final int BLOCKSIZE_256 = 256;
    public static final int BLOCKSIZE_512 = 512;
    public static int[] h;
    public static int[] i;
    public static int[] j;
    public static int[] k;
    public int a;
    public int b;
    public long[] c;
    public long[] d;
    public long[] e;
    public d f;
    public boolean g;

    public static final class a extends d {
        public a(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // org.spongycastle.crypto.engines.ThreefishEngine.d
        public void a(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.b;
            long[] jArr4 = this.a;
            int i = ThreefishEngine.BLOCKSIZE_256;
            int[] iArr = ThreefishEngine.i;
            int[] iArr2 = ThreefishEngine.k;
            if (jArr3.length != 33) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long j = jArr[0];
                int i2 = 1;
                long j2 = jArr[1];
                long j3 = jArr[2];
                long j4 = jArr[3];
                long j5 = jArr[4];
                long j6 = jArr[5];
                long j7 = jArr[6];
                long j8 = jArr[7];
                long j9 = jArr[8];
                long j10 = jArr[9];
                long j11 = jArr[10];
                long j12 = jArr[11];
                long j13 = jArr[12];
                long j14 = jArr[13];
                long j15 = jArr[14];
                long j16 = jArr[15];
                int i3 = 19;
                while (i3 >= i2) {
                    int i4 = iArr[i3];
                    int i5 = iArr2[i3];
                    int i6 = i4 + 1;
                    long j17 = j - jArr3[i6];
                    int i7 = i4 + 2;
                    long j18 = j2 - jArr3[i7];
                    int i8 = i4 + 3;
                    long j19 = j3 - jArr3[i8];
                    int i9 = i4 + 4;
                    long j20 = j4 - jArr3[i9];
                    int i10 = i4 + 5;
                    long j21 = j5 - jArr3[i10];
                    int i11 = i4 + 6;
                    long j22 = j6 - jArr3[i11];
                    int i12 = i4 + 7;
                    long j23 = j7 - jArr3[i12];
                    int i13 = i4 + 8;
                    long j24 = j8 - jArr3[i13];
                    int i14 = i4 + 9;
                    long j25 = j9 - jArr3[i14];
                    int i15 = i4 + 10;
                    long j26 = j10 - jArr3[i15];
                    int i16 = i4 + 11;
                    long j27 = j11 - jArr3[i16];
                    int i17 = i4 + 12;
                    long j28 = j12 - jArr3[i17];
                    int i18 = i4 + 13;
                    long j29 = j13 - jArr3[i18];
                    int i19 = i4 + 14;
                    int i20 = i5 + 1;
                    long j30 = j14 - (jArr3[i19] + jArr4[i20]);
                    int i21 = i4 + 15;
                    long j31 = j15 - (jArr3[i21] + jArr4[i5 + 2]);
                    long j32 = jArr3[i4 + 16];
                    long j33 = (long) i3;
                    long b = ThreefishEngine.b(j16 - ((j32 + j33) + 1), 9, j17);
                    long j34 = j17 - b;
                    long b2 = ThreefishEngine.b(j28, 48, j19);
                    long j35 = j19 - b2;
                    long b3 = ThreefishEngine.b(j30, 35, j23);
                    long j36 = j23 - b3;
                    long b4 = ThreefishEngine.b(j26, 52, j21);
                    long j37 = j21 - b4;
                    long b5 = ThreefishEngine.b(j18, 23, j31);
                    long j38 = j31 - b5;
                    long b6 = ThreefishEngine.b(j22, 31, j25);
                    long j39 = j25 - b6;
                    long b8 = ThreefishEngine.b(j20, 37, j27);
                    long j40 = j27 - b8;
                    long b9 = ThreefishEngine.b(j24, 20, j29);
                    long j41 = j29 - b9;
                    long b10 = ThreefishEngine.b(b9, 31, j34);
                    long j42 = j34 - b10;
                    long b11 = ThreefishEngine.b(b6, 44, j35);
                    long j43 = j35 - b11;
                    long b12 = ThreefishEngine.b(b8, 47, j37);
                    long j44 = j37 - b12;
                    long b13 = ThreefishEngine.b(b5, 46, j36);
                    long j45 = j36 - b13;
                    long b14 = ThreefishEngine.b(b, 19, j41);
                    long j46 = j41 - b14;
                    long b15 = ThreefishEngine.b(b3, 42, j38);
                    long j47 = j38 - b15;
                    long b16 = ThreefishEngine.b(b2, 44, j39);
                    long j48 = j39 - b16;
                    long b17 = ThreefishEngine.b(b4, 25, j40);
                    long j49 = j40 - b17;
                    long b18 = ThreefishEngine.b(b17, 16, j42);
                    long j50 = j42 - b18;
                    long b19 = ThreefishEngine.b(b15, 34, j43);
                    long j51 = j43 - b19;
                    long b20 = ThreefishEngine.b(b16, 56, j45);
                    long j52 = j45 - b20;
                    long b21 = ThreefishEngine.b(b14, 51, j44);
                    long j53 = j44 - b21;
                    long b22 = ThreefishEngine.b(b10, 4, j49);
                    long j54 = j49 - b22;
                    long b23 = ThreefishEngine.b(b12, 53, j46);
                    long j55 = j46 - b23;
                    long b24 = ThreefishEngine.b(b11, 42, j47);
                    long j56 = j47 - b24;
                    long b25 = ThreefishEngine.b(b13, 41, j48);
                    long j57 = j48 - b25;
                    long b26 = ThreefishEngine.b(b25, 41, j50);
                    long b27 = ThreefishEngine.b(b23, 9, j51);
                    long b28 = ThreefishEngine.b(b24, 37, j53);
                    long j58 = j53 - b28;
                    long b29 = ThreefishEngine.b(b22, 31, j52);
                    long j59 = j52 - b29;
                    long b30 = ThreefishEngine.b(b18, 12, j57);
                    long j60 = j57 - b30;
                    long b31 = ThreefishEngine.b(b20, 47, j54);
                    long j61 = j54 - b31;
                    long b32 = ThreefishEngine.b(b19, 44, j55);
                    long j62 = j55 - b32;
                    long b33 = ThreefishEngine.b(b21, 30, j56);
                    long j63 = j56 - b33;
                    long j64 = (j50 - b26) - jArr3[i4];
                    long j65 = b26 - jArr3[i6];
                    long j66 = (j51 - b27) - jArr3[i7];
                    long j67 = b27 - jArr3[i8];
                    long j68 = j58 - jArr3[i9];
                    long j69 = b28 - jArr3[i10];
                    long j70 = j59 - jArr3[i11];
                    long j71 = b29 - jArr3[i12];
                    long j72 = j60 - jArr3[i13];
                    long j73 = b30 - jArr3[i14];
                    long j74 = j61 - jArr3[i15];
                    long j75 = b31 - jArr3[i16];
                    long j76 = j62 - jArr3[i17];
                    long j77 = b32 - (jArr3[i18] + jArr4[i5]);
                    long j78 = j63 - (jArr3[i19] + jArr4[i20]);
                    long b34 = ThreefishEngine.b(b33 - (jArr3[i21] + j33), 5, j64);
                    long j79 = j64 - b34;
                    long b35 = ThreefishEngine.b(j75, 20, j66);
                    long j80 = j66 - b35;
                    long b36 = ThreefishEngine.b(j77, 48, j70);
                    long j81 = j70 - b36;
                    long b37 = ThreefishEngine.b(j73, 41, j68);
                    long j82 = j68 - b37;
                    long b38 = ThreefishEngine.b(j65, 47, j78);
                    long j83 = j78 - b38;
                    long b39 = ThreefishEngine.b(j69, 28, j72);
                    long j84 = j72 - b39;
                    long b40 = ThreefishEngine.b(j67, 16, j74);
                    long j85 = j74 - b40;
                    long b41 = ThreefishEngine.b(j71, 25, j76);
                    long j86 = j76 - b41;
                    long b42 = ThreefishEngine.b(b41, 33, j79);
                    long j87 = j79 - b42;
                    long b43 = ThreefishEngine.b(b39, 4, j80);
                    long j88 = j80 - b43;
                    long b44 = ThreefishEngine.b(b40, 51, j82);
                    long j89 = j82 - b44;
                    long b45 = ThreefishEngine.b(b38, 13, j81);
                    long j90 = j81 - b45;
                    long b46 = ThreefishEngine.b(b34, 34, j86);
                    long j91 = j86 - b46;
                    long b47 = ThreefishEngine.b(b36, 41, j83);
                    long j92 = j83 - b47;
                    long b48 = ThreefishEngine.b(b35, 59, j84);
                    long j93 = j84 - b48;
                    long b49 = ThreefishEngine.b(b37, 17, j85);
                    long j94 = j85 - b49;
                    long b50 = ThreefishEngine.b(b49, 38, j87);
                    long j95 = j87 - b50;
                    long b51 = ThreefishEngine.b(b47, 19, j88);
                    long j96 = j88 - b51;
                    long b52 = ThreefishEngine.b(b48, 10, j90);
                    long j97 = j90 - b52;
                    long b53 = ThreefishEngine.b(b46, 55, j89);
                    long j98 = j89 - b53;
                    long b54 = ThreefishEngine.b(b42, 49, j94);
                    long j99 = j94 - b54;
                    long b55 = ThreefishEngine.b(b44, 18, j91);
                    long j100 = j91 - b55;
                    long b56 = ThreefishEngine.b(b43, 23, j92);
                    long j101 = j92 - b56;
                    long b57 = ThreefishEngine.b(b45, 52, j93);
                    long j102 = j93 - b57;
                    long b58 = ThreefishEngine.b(b57, 24, j95);
                    long j103 = j95 - b58;
                    long b59 = ThreefishEngine.b(b55, 13, j96);
                    j3 = j96 - b59;
                    long b60 = ThreefishEngine.b(b56, 8, j98);
                    long b61 = ThreefishEngine.b(b54, 47, j97);
                    long j104 = j97 - b61;
                    long b62 = ThreefishEngine.b(b50, 8, j102);
                    long j105 = j102 - b62;
                    long b63 = ThreefishEngine.b(b52, 17, j99);
                    long j106 = j99 - b63;
                    long b64 = ThreefishEngine.b(b51, 22, j100);
                    j16 = ThreefishEngine.b(b53, 37, j101);
                    j15 = j101 - j16;
                    i3 -= 2;
                    j11 = j106;
                    j9 = j105;
                    j12 = b63;
                    jArr3 = jArr3;
                    iArr = iArr;
                    jArr4 = jArr4;
                    j4 = b59;
                    j = j103;
                    j14 = b64;
                    j8 = b61;
                    j5 = j98 - b60;
                    j13 = j100 - b64;
                    j10 = b62;
                    iArr2 = iArr2;
                    i2 = 1;
                    j2 = b58;
                    j7 = j104;
                    j6 = b60;
                }
                long j107 = j2 - jArr3[1];
                long j108 = j3 - jArr3[2];
                long j109 = j4 - jArr3[3];
                long j110 = j5 - jArr3[4];
                long j111 = j6 - jArr3[5];
                long j112 = j7 - jArr3[6];
                long j113 = j8 - jArr3[7];
                long j114 = j9 - jArr3[8];
                long j115 = j10 - jArr3[9];
                long j116 = j11 - jArr3[10];
                long j117 = j13 - jArr3[12];
                long j118 = j14 - (jArr3[13] + jArr4[0]);
                long j119 = j15 - (jArr3[14] + jArr4[1]);
                jArr2[0] = j - jArr3[0];
                jArr2[1] = j107;
                jArr2[2] = j108;
                jArr2[3] = j109;
                jArr2[4] = j110;
                jArr2[5] = j111;
                jArr2[6] = j112;
                jArr2[7] = j113;
                jArr2[8] = j114;
                jArr2[9] = j115;
                jArr2[10] = j116;
                jArr2[11] = j12 - jArr3[11];
                jArr2[12] = j117;
                jArr2[13] = j118;
                jArr2[14] = j119;
                jArr2[15] = j16 - jArr3[15];
            } else {
                throw new IllegalArgumentException();
            }
        }

        @Override // org.spongycastle.crypto.engines.ThreefishEngine.d
        public void b(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.b;
            long[] jArr4 = this.a;
            int i = ThreefishEngine.BLOCKSIZE_256;
            int[] iArr = ThreefishEngine.i;
            int[] iArr2 = ThreefishEngine.k;
            if (jArr3.length != 33) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long j = jArr[0];
                int i2 = 1;
                long j2 = jArr[1];
                long j3 = jArr[2];
                long j4 = jArr[3];
                long j5 = jArr[4];
                long j6 = jArr[5];
                long j7 = jArr[6];
                long j8 = jArr[7];
                long j9 = jArr[8];
                long j10 = jArr[9];
                long j11 = jArr[10];
                long j12 = jArr[11];
                long j13 = jArr[12];
                int i3 = 13;
                long j14 = jArr[13];
                long j15 = jArr[14];
                long j16 = jArr[15];
                long j17 = j + jArr3[0];
                long j18 = j2 + jArr3[1];
                long j19 = j3 + jArr3[2];
                long j20 = j4 + jArr3[3];
                long j21 = j5 + jArr3[4];
                long j22 = j6 + jArr3[5];
                long j23 = j7 + jArr3[6];
                long j24 = j8 + jArr3[7];
                long j25 = j9 + jArr3[8];
                long j26 = j10 + jArr3[9];
                long j27 = j11 + jArr3[10];
                long j28 = j12 + jArr3[11];
                long j29 = j13 + jArr3[12];
                long j30 = jArr3[13] + jArr4[0] + j14;
                long j31 = jArr3[14] + jArr4[1] + j15;
                long j32 = j20;
                long j33 = j22;
                long j34 = j24;
                long j35 = j26;
                long j36 = j28;
                long j37 = j16 + jArr3[15];
                long j38 = j30;
                while (i2 < 20) {
                    int i4 = iArr[i2];
                    int i5 = iArr2[i2];
                    long j39 = j17 + j18;
                    long a = ThreefishEngine.a(j18, 24, j39);
                    long j40 = j19 + j32;
                    long a3 = ThreefishEngine.a(j32, i3, j40);
                    long j41 = j21 + j33;
                    long a4 = ThreefishEngine.a(j33, 8, j41);
                    long j42 = j23 + j34;
                    long a5 = ThreefishEngine.a(j34, 47, j42);
                    long j43 = j25 + j35;
                    long a6 = ThreefishEngine.a(j35, 8, j43);
                    long j44 = j27 + j36;
                    long a8 = ThreefishEngine.a(j36, 17, j44);
                    long j45 = j29 + j38;
                    long a9 = ThreefishEngine.a(j38, 22, j45);
                    long j46 = j31 + j37;
                    long a10 = ThreefishEngine.a(j37, 37, j46);
                    long j47 = j39 + a6;
                    long a11 = ThreefishEngine.a(a6, 38, j47);
                    long j48 = j40 + a9;
                    long a12 = ThreefishEngine.a(a9, 19, j48);
                    long j49 = j42 + a8;
                    long a13 = ThreefishEngine.a(a8, 10, j49);
                    long j50 = j41 + a10;
                    long a14 = ThreefishEngine.a(a10, 55, j50);
                    long j51 = j44 + a5;
                    long a15 = ThreefishEngine.a(a5, 49, j51);
                    long j52 = j45 + a3;
                    long a16 = ThreefishEngine.a(a3, 18, j52);
                    long j53 = j46 + a4;
                    long a17 = ThreefishEngine.a(a4, 23, j53);
                    long j54 = j43 + a;
                    long a18 = ThreefishEngine.a(a, 52, j54);
                    long j55 = j47 + a15;
                    long a19 = ThreefishEngine.a(a15, 33, j55);
                    long j56 = j48 + a17;
                    long a20 = ThreefishEngine.a(a17, 4, j56);
                    long j57 = j50 + a16;
                    long a21 = ThreefishEngine.a(a16, 51, j57);
                    long j58 = j49 + a18;
                    long a22 = ThreefishEngine.a(a18, 13, j58);
                    long j59 = j52 + a14;
                    long a23 = ThreefishEngine.a(a14, 34, j59);
                    long j60 = j53 + a12;
                    long a24 = ThreefishEngine.a(a12, 41, j60);
                    long j61 = j54 + a13;
                    long a25 = ThreefishEngine.a(a13, 59, j61);
                    long j62 = j51 + a11;
                    long a26 = ThreefishEngine.a(a11, 17, j62);
                    long j63 = j55 + a23;
                    long a27 = ThreefishEngine.a(a23, 5, j63);
                    long j64 = j56 + a25;
                    long a28 = ThreefishEngine.a(a25, 20, j64);
                    long j65 = j58 + a24;
                    long a29 = ThreefishEngine.a(a24, 48, j65);
                    long j66 = j57 + a26;
                    long a30 = ThreefishEngine.a(a26, 41, j66);
                    long j67 = j60 + a22;
                    long a31 = ThreefishEngine.a(a22, 47, j67);
                    long j68 = j61 + a20;
                    long a32 = ThreefishEngine.a(a20, 28, j68);
                    long j69 = j62 + a21;
                    long a33 = ThreefishEngine.a(a21, 16, j69);
                    long j70 = j59 + a19;
                    long a34 = ThreefishEngine.a(a19, 25, j70);
                    long j71 = j63 + jArr3[i4];
                    int i6 = i4 + 1;
                    long j72 = a31 + jArr3[i6];
                    int i7 = i4 + 2;
                    long j73 = j64 + jArr3[i7];
                    int i8 = i4 + 3;
                    long j74 = a33 + jArr3[i8];
                    int i9 = i4 + 4;
                    long j75 = j66 + jArr3[i9];
                    int i10 = i4 + 5;
                    long j76 = a32 + jArr3[i10];
                    int i11 = i4 + 6;
                    long j77 = j65 + jArr3[i11];
                    int i12 = i4 + 7;
                    long j78 = a34 + jArr3[i12];
                    int i13 = i4 + 8;
                    long j79 = j68 + jArr3[i13];
                    int i14 = i4 + 9;
                    long j80 = a30 + jArr3[i14];
                    int i15 = i4 + 10;
                    long j81 = j69 + jArr3[i15];
                    int i16 = i4 + 11;
                    long j82 = a28 + jArr3[i16];
                    int i17 = i4 + 12;
                    long j83 = j70 + jArr3[i17];
                    int i18 = i4 + 13;
                    long j84 = jArr3[i18] + jArr4[i5] + a29;
                    int i19 = i4 + 14;
                    int i20 = i5 + 1;
                    long j85 = jArr3[i19] + jArr4[i20] + j67;
                    int i21 = i4 + 15;
                    long j86 = (long) i2;
                    long j87 = jArr3[i21] + j86 + a27;
                    long j88 = j71 + j72;
                    long a35 = ThreefishEngine.a(j72, 41, j88);
                    long j89 = j73 + j74;
                    long a36 = ThreefishEngine.a(j74, 9, j89);
                    long j90 = j75 + j76;
                    long a37 = ThreefishEngine.a(j76, 37, j90);
                    long j91 = j77 + j78;
                    long a38 = ThreefishEngine.a(j78, 31, j91);
                    long j92 = j79 + j80;
                    long a39 = ThreefishEngine.a(j80, 12, j92);
                    long j93 = j81 + j82;
                    long a40 = ThreefishEngine.a(j82, 47, j93);
                    long j94 = j83 + j84;
                    long a41 = ThreefishEngine.a(j84, 44, j94);
                    long j95 = j85 + j87;
                    long a42 = ThreefishEngine.a(j87, 30, j95);
                    long j96 = j88 + a39;
                    long a43 = ThreefishEngine.a(a39, 16, j96);
                    long j97 = j89 + a41;
                    long a44 = ThreefishEngine.a(a41, 34, j97);
                    long j98 = j91 + a40;
                    long a45 = ThreefishEngine.a(a40, 56, j98);
                    long j99 = j90 + a42;
                    long a46 = ThreefishEngine.a(a42, 51, j99);
                    long j100 = j93 + a38;
                    long a47 = ThreefishEngine.a(a38, 4, j100);
                    long j101 = j94 + a36;
                    long a48 = ThreefishEngine.a(a36, 53, j101);
                    long j102 = j95 + a37;
                    long a49 = ThreefishEngine.a(a37, 42, j102);
                    long j103 = j92 + a35;
                    long a50 = ThreefishEngine.a(a35, 41, j103);
                    long j104 = j96 + a47;
                    long a51 = ThreefishEngine.a(a47, 31, j104);
                    long j105 = j97 + a49;
                    long a52 = ThreefishEngine.a(a49, 44, j105);
                    long j106 = j99 + a48;
                    long a53 = ThreefishEngine.a(a48, 47, j106);
                    long j107 = j98 + a50;
                    long a54 = ThreefishEngine.a(a50, 46, j107);
                    long j108 = j101 + a46;
                    long a55 = ThreefishEngine.a(a46, 19, j108);
                    long j109 = j102 + a44;
                    long a56 = ThreefishEngine.a(a44, 42, j109);
                    long j110 = j103 + a45;
                    long a57 = ThreefishEngine.a(a45, 44, j110);
                    long j111 = j100 + a43;
                    long a58 = ThreefishEngine.a(a43, 25, j111);
                    long j112 = j104 + a55;
                    long a59 = ThreefishEngine.a(a55, 9, j112);
                    long j113 = j105 + a57;
                    long a60 = ThreefishEngine.a(a57, 48, j113);
                    long j114 = j107 + a56;
                    long a61 = ThreefishEngine.a(a56, 35, j114);
                    long j115 = j106 + a58;
                    long a62 = ThreefishEngine.a(a58, 52, j115);
                    long j116 = j109 + a54;
                    long a63 = ThreefishEngine.a(a54, 23, j116);
                    long j117 = j110 + a52;
                    long a64 = ThreefishEngine.a(a52, 31, j117);
                    long j118 = j111 + a53;
                    long a65 = ThreefishEngine.a(a53, 37, j118);
                    long j119 = j108 + a51;
                    long a66 = ThreefishEngine.a(a51, 20, j119);
                    long j120 = j112 + jArr3[i6];
                    long j121 = a63 + jArr3[i7];
                    j19 = jArr3[i8] + j113;
                    long j122 = jArr3[i9] + a65;
                    long j123 = jArr3[i10] + j115;
                    long j124 = a64 + jArr3[i11];
                    long j125 = j114 + jArr3[i12];
                    long j126 = a66 + jArr3[i13];
                    long j127 = j117 + jArr3[i14];
                    j36 = a60 + jArr3[i17];
                    long j128 = j119 + jArr3[i18];
                    j31 = jArr3[i21] + jArr4[i5 + 2] + j116;
                    j37 = jArr3[i4 + 16] + j86 + 1 + a59;
                    j33 = j124;
                    j29 = j128;
                    j38 = jArr3[i19] + jArr4[i20] + a61;
                    i2 += 2;
                    j23 = j125;
                    j35 = a62 + jArr3[i15];
                    j27 = j118 + jArr3[i16];
                    j18 = j121;
                    j25 = j127;
                    j17 = j120;
                    j21 = j123;
                    iArr = iArr;
                    jArr4 = jArr4;
                    i3 = 13;
                    j34 = j126;
                    iArr2 = iArr2;
                    j32 = j122;
                    jArr3 = jArr3;
                }
                jArr2[0] = j17;
                jArr2[1] = j18;
                jArr2[2] = j19;
                jArr2[3] = j32;
                jArr2[4] = j21;
                jArr2[5] = j33;
                jArr2[6] = j23;
                jArr2[7] = j34;
                jArr2[8] = j25;
                jArr2[9] = j35;
                jArr2[10] = j27;
                jArr2[11] = j36;
                jArr2[12] = j29;
                jArr2[13] = j38;
                jArr2[14] = j31;
                jArr2[15] = j37;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static final class b extends d {
        public b(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // org.spongycastle.crypto.engines.ThreefishEngine.d
        public void a(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.b;
            long[] jArr4 = this.a;
            int i = ThreefishEngine.BLOCKSIZE_256;
            int[] iArr = ThreefishEngine.j;
            int[] iArr2 = ThreefishEngine.k;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long j = jArr[0];
                long j2 = jArr[1];
                long j3 = jArr[2];
                long j4 = jArr[3];
                int i2 = 17;
                for (int i3 = 1; i2 >= i3; i3 = 1) {
                    int i4 = iArr[i2];
                    int i5 = iArr2[i2];
                    int i6 = i4 + 1;
                    long j5 = j - jArr3[i6];
                    int i7 = i4 + 2;
                    int i8 = i5 + 1;
                    long j6 = j2 - (jArr3[i7] + jArr4[i8]);
                    int i9 = i4 + 3;
                    long j7 = j3 - (jArr3[i9] + jArr4[i5 + 2]);
                    long j8 = (long) i2;
                    long b = ThreefishEngine.b(j4 - ((jArr3[i4 + 4] + j8) + 1), 32, j5);
                    long j9 = j5 - b;
                    long b2 = ThreefishEngine.b(j6, 32, j7);
                    long j10 = j7 - b2;
                    long b3 = ThreefishEngine.b(b2, 58, j9);
                    long j11 = j9 - b3;
                    long b4 = ThreefishEngine.b(b, 22, j10);
                    long j12 = j10 - b4;
                    long b5 = ThreefishEngine.b(b4, 46, j11);
                    long j13 = j11 - b5;
                    long b6 = ThreefishEngine.b(b3, 12, j12);
                    long j14 = j12 - b6;
                    long b8 = ThreefishEngine.b(b6, 25, j13);
                    long b9 = ThreefishEngine.b(b5, 33, j14);
                    long j15 = (j13 - b8) - jArr3[i4];
                    long j16 = b8 - (jArr3[i6] + jArr4[i5]);
                    long j17 = (j14 - b9) - (jArr3[i7] + jArr4[i8]);
                    long b10 = ThreefishEngine.b(b9 - (jArr3[i9] + j8), 5, j15);
                    long j18 = j15 - b10;
                    long b11 = ThreefishEngine.b(j16, 37, j17);
                    long j19 = j17 - b11;
                    long b12 = ThreefishEngine.b(b11, 23, j18);
                    long j20 = j18 - b12;
                    long b13 = ThreefishEngine.b(b10, 40, j19);
                    long j21 = j19 - b13;
                    long b14 = ThreefishEngine.b(b13, 52, j20);
                    long j22 = j20 - b14;
                    long b15 = ThreefishEngine.b(b12, 57, j21);
                    long j23 = j21 - b15;
                    long b16 = ThreefishEngine.b(b15, 14, j22);
                    j = j22 - b16;
                    j4 = ThreefishEngine.b(b14, 16, j23);
                    j3 = j23 - j4;
                    i2 -= 2;
                    j2 = b16;
                    iArr = iArr;
                    iArr2 = iArr2;
                }
                long j24 = j2 - (jArr3[1] + jArr4[0]);
                long j25 = j3 - (jArr3[2] + jArr4[1]);
                jArr2[0] = j - jArr3[0];
                jArr2[1] = j24;
                jArr2[2] = j25;
                jArr2[3] = j4 - jArr3[3];
            } else {
                throw new IllegalArgumentException();
            }
        }

        @Override // org.spongycastle.crypto.engines.ThreefishEngine.d
        public void b(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.b;
            long[] jArr4 = this.a;
            int i = ThreefishEngine.BLOCKSIZE_256;
            int[] iArr = ThreefishEngine.j;
            int[] iArr2 = ThreefishEngine.k;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long j = jArr[0];
                long j2 = jArr[1];
                long j3 = jArr[2];
                long j4 = jArr[3];
                long j5 = j + jArr3[0];
                long j6 = jArr3[1] + jArr4[0] + j2;
                long j7 = jArr3[2] + jArr4[1] + j3;
                long j8 = j4 + jArr3[3];
                long j9 = j6;
                int i2 = 1;
                while (i2 < 18) {
                    int i3 = iArr[i2];
                    int i4 = iArr2[i2];
                    long j10 = j5 + j9;
                    long a = ThreefishEngine.a(j9, 14, j10);
                    long j11 = j7 + j8;
                    long a3 = ThreefishEngine.a(j8, 16, j11);
                    long j12 = j10 + a3;
                    long a4 = ThreefishEngine.a(a3, 52, j12);
                    long j13 = j11 + a;
                    long a5 = ThreefishEngine.a(a, 57, j13);
                    long j14 = j12 + a5;
                    long a6 = ThreefishEngine.a(a5, 23, j14);
                    long j15 = j13 + a4;
                    long a8 = ThreefishEngine.a(a4, 40, j15);
                    long j16 = j14 + a8;
                    long a9 = ThreefishEngine.a(a8, 5, j16);
                    long j17 = j15 + a6;
                    long a10 = ThreefishEngine.a(a6, 37, j17);
                    long j18 = j16 + jArr3[i3];
                    int i5 = i3 + 1;
                    long j19 = jArr3[i5] + jArr4[i4] + a10;
                    int i6 = i3 + 2;
                    int i7 = i4 + 1;
                    long j20 = jArr3[i6] + jArr4[i7] + j17;
                    int i8 = i3 + 3;
                    long j21 = (long) i2;
                    long j22 = jArr3[i8] + j21 + a9;
                    long j23 = j18 + j19;
                    long a11 = ThreefishEngine.a(j19, 25, j23);
                    long j24 = j20 + j22;
                    long a12 = ThreefishEngine.a(j22, 33, j24);
                    long j25 = j23 + a12;
                    long a13 = ThreefishEngine.a(a12, 46, j25);
                    long j26 = j24 + a11;
                    long a14 = ThreefishEngine.a(a11, 12, j26);
                    long j27 = j25 + a14;
                    long a15 = ThreefishEngine.a(a14, 58, j27);
                    long j28 = j26 + a13;
                    long a16 = ThreefishEngine.a(a13, 22, j28);
                    long j29 = j27 + a16;
                    long a17 = ThreefishEngine.a(a16, 32, j29);
                    long j30 = j28 + a15;
                    long a18 = ThreefishEngine.a(a15, 32, j30);
                    j5 = j29 + jArr3[i5];
                    j9 = a18 + jArr3[i6] + jArr4[i7];
                    long j31 = j30 + jArr3[i8] + jArr4[i4 + 2];
                    j8 = jArr3[i3 + 4] + j21 + 1 + a17;
                    i2 += 2;
                    j7 = j31;
                    iArr = iArr;
                    iArr2 = iArr2;
                }
                jArr2[0] = j5;
                jArr2[1] = j9;
                jArr2[2] = j7;
                jArr2[3] = j8;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static final class c extends d {
        public c(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // org.spongycastle.crypto.engines.ThreefishEngine.d
        public void a(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.b;
            long[] jArr4 = this.a;
            int i = ThreefishEngine.BLOCKSIZE_256;
            int[] iArr = ThreefishEngine.h;
            int[] iArr2 = ThreefishEngine.k;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long j = jArr[0];
                int i2 = 1;
                long j2 = jArr[1];
                long j3 = jArr[2];
                long j4 = jArr[3];
                long j5 = jArr[4];
                long j6 = jArr[5];
                long j7 = jArr[6];
                long j8 = jArr[7];
                int i3 = 17;
                while (i3 >= i2) {
                    int i4 = iArr[i3];
                    int i5 = iArr2[i3];
                    int i6 = i4 + 1;
                    long j9 = j - jArr3[i6];
                    int i7 = i4 + 2;
                    long j10 = j2 - jArr3[i7];
                    int i8 = i4 + 3;
                    long j11 = j3 - jArr3[i8];
                    int i9 = i4 + 4;
                    long j12 = j4 - jArr3[i9];
                    int i10 = i4 + 5;
                    long j13 = j5 - jArr3[i10];
                    int i11 = i4 + 6;
                    int i12 = i5 + 1;
                    long j14 = j6 - (jArr3[i11] + jArr4[i12]);
                    int i13 = i4 + 7;
                    long j15 = j7 - (jArr3[i13] + jArr4[i5 + 2]);
                    long j16 = (long) i3;
                    long b = ThreefishEngine.b(j10, 8, j15);
                    long j17 = j15 - b;
                    long b2 = ThreefishEngine.b(j8 - ((jArr3[i4 + 8] + j16) + 1), 35, j9);
                    long j18 = j9 - b2;
                    long b3 = ThreefishEngine.b(j14, 56, j11);
                    long j19 = j11 - b3;
                    long b4 = ThreefishEngine.b(j12, 22, j13);
                    long j20 = j13 - b4;
                    long b5 = ThreefishEngine.b(b, 25, j20);
                    long j21 = j20 - b5;
                    long b6 = ThreefishEngine.b(b4, 29, j17);
                    long j22 = j17 - b6;
                    long b8 = ThreefishEngine.b(b3, 39, j18);
                    long j23 = j18 - b8;
                    long b9 = ThreefishEngine.b(b2, 43, j19);
                    long j24 = j19 - b9;
                    long b10 = ThreefishEngine.b(b5, 13, j24);
                    long j25 = j24 - b10;
                    long b11 = ThreefishEngine.b(b9, 50, j21);
                    long j26 = j21 - b11;
                    long b12 = ThreefishEngine.b(b8, 10, j22);
                    long j27 = j22 - b12;
                    long b13 = ThreefishEngine.b(b6, 17, j23);
                    long j28 = j23 - b13;
                    long b14 = ThreefishEngine.b(b10, 39, j28);
                    long b15 = ThreefishEngine.b(b13, 30, j25);
                    long b16 = ThreefishEngine.b(b12, 34, j26);
                    long j29 = j26 - b16;
                    long b17 = ThreefishEngine.b(b11, 24, j27);
                    long j30 = (j28 - b14) - jArr3[i4];
                    long j31 = b14 - jArr3[i6];
                    long j32 = (j25 - b15) - jArr3[i7];
                    long j33 = b15 - jArr3[i8];
                    long j34 = j29 - jArr3[i9];
                    long j35 = b16 - (jArr3[i10] + jArr4[i5]);
                    long j36 = (j27 - b17) - (jArr3[i11] + jArr4[i12]);
                    long b18 = ThreefishEngine.b(j31, 44, j36);
                    long j37 = j36 - b18;
                    long b19 = ThreefishEngine.b(b17 - (jArr3[i13] + j16), 9, j30);
                    long j38 = j30 - b19;
                    long b20 = ThreefishEngine.b(j35, 54, j32);
                    long j39 = j32 - b20;
                    long b21 = ThreefishEngine.b(j33, 56, j34);
                    long j40 = j34 - b21;
                    long b22 = ThreefishEngine.b(b18, 17, j40);
                    long j41 = j40 - b22;
                    long b23 = ThreefishEngine.b(b21, 49, j37);
                    long j42 = j37 - b23;
                    long b24 = ThreefishEngine.b(b20, 36, j38);
                    long j43 = j38 - b24;
                    long b25 = ThreefishEngine.b(b19, 39, j39);
                    long j44 = j39 - b25;
                    long b26 = ThreefishEngine.b(b22, 33, j44);
                    long j45 = j44 - b26;
                    long b27 = ThreefishEngine.b(b25, 27, j41);
                    long j46 = j41 - b27;
                    long b28 = ThreefishEngine.b(b24, 14, j42);
                    long j47 = j42 - b28;
                    long b29 = ThreefishEngine.b(b23, 42, j43);
                    long j48 = j43 - b29;
                    long b30 = ThreefishEngine.b(b26, 46, j48);
                    long j49 = j48 - b30;
                    j4 = ThreefishEngine.b(b29, 36, j45);
                    long b31 = ThreefishEngine.b(b28, 19, j46);
                    j5 = j46 - b31;
                    j8 = ThreefishEngine.b(b27, 37, j47);
                    j7 = j47 - j8;
                    j3 = j45 - j4;
                    j2 = b30;
                    j6 = b31;
                    i3 -= 2;
                    iArr2 = iArr2;
                    jArr3 = jArr3;
                    i2 = 1;
                    j = j49;
                    jArr4 = jArr4;
                    iArr = iArr;
                }
                long j50 = j - jArr3[0];
                long j51 = j2 - jArr3[1];
                long j52 = j3 - jArr3[2];
                long j53 = j4 - jArr3[3];
                long j54 = j5 - jArr3[4];
                long j55 = j7 - (jArr3[6] + jArr4[1]);
                jArr2[0] = j50;
                jArr2[1] = j51;
                jArr2[2] = j52;
                jArr2[3] = j53;
                jArr2[4] = j54;
                jArr2[5] = j6 - (jArr3[5] + jArr4[0]);
                jArr2[6] = j55;
                jArr2[7] = j8 - jArr3[7];
            } else {
                throw new IllegalArgumentException();
            }
        }

        @Override // org.spongycastle.crypto.engines.ThreefishEngine.d
        public void b(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.b;
            long[] jArr4 = this.a;
            int i = ThreefishEngine.BLOCKSIZE_256;
            int[] iArr = ThreefishEngine.h;
            int[] iArr2 = ThreefishEngine.k;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long j = jArr[0];
                long j2 = jArr[1];
                long j3 = jArr[2];
                long j4 = jArr[3];
                long j5 = jArr[4];
                long j6 = jArr[5];
                long j7 = jArr[6];
                long j8 = jArr[7];
                long j9 = j + jArr3[0];
                long j10 = j2 + jArr3[1];
                long j11 = j3 + jArr3[2];
                long j12 = j4 + jArr3[3];
                long j13 = j5 + jArr3[4];
                long j14 = jArr3[5] + jArr4[0] + j6;
                long j15 = jArr3[6] + jArr4[1] + j7;
                long j16 = j12;
                long j17 = j8 + jArr3[7];
                long j18 = j14;
                int i2 = 1;
                while (i2 < 18) {
                    int i3 = iArr[i2];
                    int i4 = iArr2[i2];
                    long j19 = j9 + j10;
                    long a = ThreefishEngine.a(j10, 46, j19);
                    long j20 = j11 + j16;
                    long a3 = ThreefishEngine.a(j16, 36, j20);
                    long j21 = j13 + j18;
                    long a4 = ThreefishEngine.a(j18, 19, j21);
                    long j22 = j15 + j17;
                    long a5 = ThreefishEngine.a(j17, 37, j22);
                    long j23 = j20 + a;
                    long a6 = ThreefishEngine.a(a, 33, j23);
                    long j24 = j21 + a5;
                    long a8 = ThreefishEngine.a(a5, 27, j24);
                    long j25 = j22 + a4;
                    long a9 = ThreefishEngine.a(a4, 14, j25);
                    long j26 = j19 + a3;
                    long a10 = ThreefishEngine.a(a3, 42, j26);
                    long j27 = j24 + a6;
                    long a11 = ThreefishEngine.a(a6, 17, j27);
                    long j28 = j25 + a10;
                    long a12 = ThreefishEngine.a(a10, 49, j28);
                    long j29 = j26 + a9;
                    long a13 = ThreefishEngine.a(a9, 36, j29);
                    long j30 = j23 + a8;
                    long a14 = ThreefishEngine.a(a8, 39, j30);
                    long j31 = j28 + a11;
                    long a15 = ThreefishEngine.a(a11, 44, j31);
                    long j32 = j29 + a14;
                    long a16 = ThreefishEngine.a(a14, 9, j32);
                    long j33 = j30 + a13;
                    long a17 = ThreefishEngine.a(a13, 54, j33);
                    long j34 = j27 + a12;
                    long a18 = ThreefishEngine.a(a12, 56, j34);
                    long j35 = j32 + jArr3[i3];
                    int i5 = i3 + 1;
                    long j36 = a15 + jArr3[i5];
                    int i6 = i3 + 2;
                    long j37 = j33 + jArr3[i6];
                    int i7 = i3 + 3;
                    long j38 = a18 + jArr3[i7];
                    int i8 = i3 + 4;
                    long j39 = j34 + jArr3[i8];
                    int i9 = i3 + 5;
                    long j40 = jArr3[i9] + jArr4[i4] + a17;
                    int i10 = i3 + 6;
                    int i11 = i4 + 1;
                    long j41 = jArr3[i10] + jArr4[i11] + j31;
                    int i12 = i3 + 7;
                    long j42 = (long) i2;
                    long j43 = jArr3[i12] + j42 + a16;
                    long j44 = j35 + j36;
                    long a19 = ThreefishEngine.a(j36, 39, j44);
                    long j45 = j37 + j38;
                    long a20 = ThreefishEngine.a(j38, 30, j45);
                    long j46 = j39 + j40;
                    long a21 = ThreefishEngine.a(j40, 34, j46);
                    long j47 = j41 + j43;
                    long a22 = ThreefishEngine.a(j43, 24, j47);
                    long j48 = j45 + a19;
                    long a23 = ThreefishEngine.a(a19, 13, j48);
                    long j49 = j46 + a22;
                    long a24 = ThreefishEngine.a(a22, 50, j49);
                    long j50 = j47 + a21;
                    long a25 = ThreefishEngine.a(a21, 10, j50);
                    long j51 = j44 + a20;
                    long a26 = ThreefishEngine.a(a20, 17, j51);
                    long j52 = j49 + a23;
                    long a27 = ThreefishEngine.a(a23, 25, j52);
                    long j53 = j50 + a26;
                    long a28 = ThreefishEngine.a(a26, 29, j53);
                    long j54 = j51 + a25;
                    long a29 = ThreefishEngine.a(a25, 39, j54);
                    long j55 = j48 + a24;
                    long a30 = ThreefishEngine.a(a24, 43, j55);
                    long j56 = j53 + a27;
                    long a31 = ThreefishEngine.a(a27, 8, j56);
                    long j57 = j54 + a30;
                    long a32 = ThreefishEngine.a(a30, 35, j57);
                    long j58 = j55 + a29;
                    long a33 = ThreefishEngine.a(a29, 56, j58);
                    long j59 = j52 + a28;
                    long a34 = ThreefishEngine.a(a28, 22, j59);
                    j10 = a31 + jArr3[i6];
                    long j60 = j58 + jArr3[i7];
                    long j61 = a34 + jArr3[i8];
                    long j62 = j59 + jArr3[i9];
                    j18 = jArr3[i10] + jArr4[i11] + a33;
                    j15 = jArr3[i12] + jArr4[i4 + 2] + j56;
                    j17 = jArr3[i3 + 8] + j42 + 1 + a32;
                    j13 = j62;
                    iArr = iArr;
                    iArr2 = iArr2;
                    i2 += 2;
                    j16 = j61;
                    j11 = j60;
                    j9 = j57 + jArr3[i5];
                    jArr3 = jArr3;
                }
                jArr2[0] = j9;
                jArr2[1] = j10;
                jArr2[2] = j11;
                jArr2[3] = j16;
                jArr2[4] = j13;
                jArr2[5] = j18;
                jArr2[6] = j15;
                jArr2[7] = j17;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static abstract class d {
        public final long[] a;
        public final long[] b;

        public d(long[] jArr, long[] jArr2) {
            this.b = jArr;
            this.a = jArr2;
        }

        public abstract void a(long[] jArr, long[] jArr2);

        public abstract void b(long[] jArr, long[] jArr2);
    }

    static {
        int[] iArr = new int[80];
        h = iArr;
        i = new int[iArr.length];
        j = new int[iArr.length];
        k = new int[iArr.length];
        int i2 = 0;
        while (true) {
            int[] iArr2 = h;
            if (i2 < iArr2.length) {
                i[i2] = i2 % 17;
                iArr2[i2] = i2 % 9;
                j[i2] = i2 % 5;
                k[i2] = i2 % 3;
                i2++;
            } else {
                return;
            }
        }
    }

    public ThreefishEngine(int i2) {
        long[] jArr = new long[5];
        this.d = jArr;
        int i3 = i2 / 8;
        this.a = i3;
        int i4 = i3 / 8;
        this.b = i4;
        this.c = new long[i4];
        long[] jArr2 = new long[((i4 * 2) + 1)];
        this.e = jArr2;
        if (i2 == 256) {
            this.f = new b(jArr2, jArr);
        } else if (i2 == 512) {
            this.f = new c(jArr2, jArr);
        } else if (i2 == 1024) {
            this.f = new a(jArr2, jArr);
        } else {
            throw new IllegalArgumentException("Invalid blocksize - Threefish is defined with block size of 256, 512, or 1024 bits");
        }
    }

    public static long a(long j2, int i2, long j3) {
        return ((j2 >>> (-i2)) | (j2 << i2)) ^ j3;
    }

    public static long b(long j2, int i2, long j3) {
        long j4 = j2 ^ j3;
        return (j4 << (-i2)) | (j4 >>> i2);
    }

    public static long bytesToWord(byte[] bArr, int i2) {
        if (i2 + 8 <= bArr.length) {
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            return ((((long) bArr[i8 + 1]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i3]) & 255) << 8) | ((((long) bArr[i4]) & 255) << 16) | ((((long) bArr[i5]) & 255) << 24) | ((((long) bArr[i6]) & 255) << 32) | ((((long) bArr[i7]) & 255) << 40) | ((((long) bArr[i8]) & 255) << 48);
        }
        throw new IllegalArgumentException();
    }

    public static void wordToBytes(long j2, byte[] bArr, int i2) {
        if (i2 + 8 <= bArr.length) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((int) j2);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((int) (j2 >> 8));
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((int) (j2 >> 16));
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((int) (j2 >> 24));
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((int) (j2 >> 32));
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((int) (j2 >> 40));
            bArr[i8] = (byte) ((int) (j2 >> 48));
            bArr[i8 + 1] = (byte) ((int) (j2 >> 56));
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        StringBuilder L = a2.b.a.a.a.L("Threefish-");
        L.append(this.a * 8);
        return L.toString();
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.a;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        byte[] bArr;
        byte[] bArr2;
        long[] jArr;
        long[] jArr2 = null;
        if (cipherParameters instanceof TweakableBlockCipherParameters) {
            TweakableBlockCipherParameters tweakableBlockCipherParameters = (TweakableBlockCipherParameters) cipherParameters;
            bArr2 = tweakableBlockCipherParameters.getKey().getKey();
            bArr = tweakableBlockCipherParameters.getTweak();
        } else if (cipherParameters instanceof KeyParameter) {
            bArr2 = ((KeyParameter) cipherParameters).getKey();
            bArr = null;
        } else {
            throw new IllegalArgumentException(a2.b.a.a.a.E(cipherParameters, a2.b.a.a.a.L("Invalid parameter passed to Threefish init - ")));
        }
        if (bArr2 == null) {
            jArr = null;
        } else if (bArr2.length == this.a) {
            int i2 = this.b;
            jArr = new long[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                jArr[i3] = bytesToWord(bArr2, i3 * 8);
            }
        } else {
            throw new IllegalArgumentException(a2.b.a.a.a.j(a2.b.a.a.a.L("Threefish key must be same size as block ("), this.a, " bytes)"));
        }
        if (bArr != null) {
            if (bArr.length == 16) {
                jArr2 = new long[]{bytesToWord(bArr, 0), bytesToWord(bArr, 8)};
            } else {
                throw new IllegalArgumentException("Threefish tweak must be 16 bytes");
            }
        }
        init(z, jArr, jArr2);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i2, byte[] bArr2, int i3) throws DataLengthException, IllegalStateException {
        int i4 = this.a;
        if (i2 + i4 > bArr.length) {
            throw new DataLengthException("Input buffer too short");
        } else if (i4 + i3 <= bArr2.length) {
            int i5 = 0;
            for (int i6 = 0; i6 < this.a; i6 += 8) {
                this.c[i6 >> 3] = bytesToWord(bArr, i2 + i6);
            }
            long[] jArr = this.c;
            processBlock(jArr, jArr);
            while (true) {
                int i7 = this.a;
                if (i5 >= i7) {
                    return i7;
                }
                wordToBytes(this.c[i5 >> 3], bArr2, i3 + i5);
                i5 += 8;
            }
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }

    public int processBlock(long[] jArr, long[] jArr2) throws DataLengthException, IllegalStateException {
        long[] jArr3 = this.e;
        int i2 = this.b;
        if (jArr3[i2] == 0) {
            throw new IllegalStateException("Threefish engine not initialised");
        } else if (jArr.length != i2) {
            throw new DataLengthException("Input buffer too short");
        } else if (jArr2.length == i2) {
            if (this.g) {
                this.f.b(jArr, jArr2);
            } else {
                this.f.a(jArr, jArr2);
            }
            return this.b;
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    public void init(boolean z, long[] jArr, long[] jArr2) {
        int i2;
        this.g = z;
        if (jArr != null) {
            if (jArr.length == this.b) {
                long j2 = 2004413935125273122L;
                int i3 = 0;
                while (true) {
                    i2 = this.b;
                    if (i3 >= i2) {
                        break;
                    }
                    long[] jArr3 = this.e;
                    jArr3[i3] = jArr[i3];
                    j2 ^= jArr3[i3];
                    i3++;
                }
                long[] jArr4 = this.e;
                jArr4[i2] = j2;
                System.arraycopy(jArr4, 0, jArr4, i2 + 1, i2);
            } else {
                throw new IllegalArgumentException(a2.b.a.a.a.j(a2.b.a.a.a.L("Threefish key must be same size as block ("), this.b, " words)"));
            }
        }
        if (jArr2 == null) {
            return;
        }
        if (jArr2.length == 2) {
            long[] jArr5 = this.d;
            jArr5[0] = jArr2[0];
            jArr5[1] = jArr2[1];
            jArr5[2] = jArr5[0] ^ jArr5[1];
            jArr5[3] = jArr5[0];
            jArr5[4] = jArr5[1];
            return;
        }
        throw new IllegalArgumentException("Tweak must be 2 words.");
    }
}
