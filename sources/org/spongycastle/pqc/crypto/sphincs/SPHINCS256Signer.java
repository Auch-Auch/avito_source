package org.spongycastle.pqc.crypto.sphincs;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.base.Ascii;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.pqc.crypto.MessageSigner;
import org.spongycastle.util.Pack;
import x6.e.f.a.c.a;
import x6.e.f.a.c.c;
import x6.e.f.a.c.d;
public class SPHINCS256Signer implements MessageSigner {
    public final a a;
    public byte[] b;

    public SPHINCS256Signer(Digest digest, Digest digest2) {
        if (digest.getDigestSize() != 32) {
            throw new IllegalArgumentException("n-digest needs to produce 32 bytes of output");
        } else if (digest2.getDigestSize() == 64) {
            this.a = new a(digest, digest2);
        } else {
            throw new IllegalArgumentException("2n-digest needs to produce 64 bytes of output");
        }
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        a aVar = this.a;
        byte[] bArr2 = this.b;
        byte[] bArr3 = new byte[41000];
        byte[] bArr4 = new byte[32];
        byte[] bArr5 = new byte[64];
        long[] jArr = new long[8];
        byte[] bArr6 = new byte[32];
        byte[] bArr7 = new byte[32];
        byte[] bArr8 = new byte[1024];
        byte[] bArr9 = new byte[1088];
        for (int i = 0; i < 1088; i++) {
            bArr9[i] = bArr2[i];
        }
        System.arraycopy(bArr9, 1056, bArr3, 40968, 32);
        Digest digest = aVar.b;
        byte[] bArr10 = new byte[digest.getDigestSize()];
        digest.update(bArr3, 40968, 32);
        digest.update(bArr, 0, bArr.length);
        digest.doFinal(bArr10, 0);
        for (int i2 = 0; i2 != 32; i2++) {
            bArr3[40968 + i2] = 0;
        }
        for (int i3 = 0; i3 != 8; i3++) {
            jArr[i3] = Pack.littleEndianToLong(bArr10, i3 * 8);
        }
        long j = jArr[0] & 1152921504606846975L;
        System.arraycopy(bArr10, 16, bArr4, 0, 32);
        System.arraycopy(bArr4, 0, bArr3, 39912, 32);
        c.a aVar2 = new c.a();
        aVar2.a = 11;
        aVar2.b = 0;
        aVar2.c = 0;
        System.arraycopy(bArr9, 32, bArr3, 39944, 1024);
        c.b(aVar, bArr3, 40968, 5, bArr9, aVar2, bArr3, 39944);
        Digest digest2 = aVar.b;
        digest2.update(bArr3, 39912, 1088);
        digest2.update(bArr, 0, bArr.length);
        digest2.doFinal(bArr5, 0);
        long j2 = (long) ((int) (j & 31));
        long j3 = j >>> 5;
        int i4 = 32;
        for (int i5 = 0; i5 < 32; i5++) {
            bArr3[i5] = bArr4[i5];
        }
        byte[] bArr11 = bArr8;
        System.arraycopy(bArr9, 32, bArr11, 0, 1024);
        int i6 = 0;
        while (i6 < 8) {
            bArr3[i4 + i6] = (byte) ((int) ((j >>> (i6 * 8)) & 255));
            i6++;
            bArr11 = bArr11;
            i4 = 32;
        }
        byte[] bArr12 = bArr11;
        byte[] bArr13 = new byte[40];
        for (int i7 = 0; i7 < 32; i7++) {
            bArr13[i7] = bArr9[i7];
        }
        Pack.longToLittleEndian((j2 << 59) | ((long) 12) | (j3 << 4), bArr13, 32);
        aVar.a.update(bArr13, 0, 40);
        byte[] bArr14 = bArr7;
        aVar.a.doFinal(bArr14, 0);
        byte[] bArr15 = new byte[2097152];
        byte[] bArr16 = new byte[4194272];
        AppCompatDelegateImpl.i.C1(bArr15, 0, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, bArr14, 0);
        for (int i8 = 0; i8 < 65536; i8++) {
            aVar.b(bArr16, (i8 + 65535) * 32, bArr15, i8 * 32);
        }
        int i9 = 0;
        while (i9 < 16) {
            int i10 = 16 - i9;
            long j4 = (long) ((1 << i10) - 1);
            int i11 = 1 << (i10 - 1);
            long j5 = (long) (i11 - 1);
            int i12 = 0;
            while (i12 < i11) {
                bArr16 = bArr16;
                aVar.a(bArr16, (int) ((((long) i12) + j5) * 32), bArr16, (int) ((((long) (i12 * 2)) + j4) * 32), bArr12, i9 * 2 * 32);
                i12++;
                bArr14 = bArr14;
                i9 = i9;
                i11 = i11;
                bArr15 = bArr15;
                j5 = j5;
                j2 = j2;
                bArr12 = bArr12;
            }
            i9++;
            aVar = aVar;
        }
        a aVar3 = aVar;
        int i13 = 2016;
        int i14 = 40;
        while (i13 < 4064) {
            bArr3[i14] = bArr16[i13];
            i13++;
            i14++;
        }
        int i15 = i14;
        int i16 = 0;
        while (true) {
            if (i16 >= 32) {
                break;
            }
            int i17 = i16 * 2;
            int i18 = (bArr5[i17] & 255) + ((bArr5[i17 + 1] & 255) << 8);
            int i19 = 0;
            for (int i20 = 32; i19 < i20; i20 = 32) {
                bArr3[i15] = bArr15[(i18 * 32) + i19];
                i19++;
                i15++;
            }
            int i21 = i18 + 65535;
            for (int i22 = 0; i22 < 10; i22++) {
                int i23 = (i21 & 1) != 0 ? i21 + 1 : i21 - 1;
                int i24 = 0;
                while (i24 < 32) {
                    bArr3[i15] = bArr16[(i23 * 32) + i24];
                    i24++;
                    i15++;
                }
                i21 = (i23 - 1) / 2;
            }
            i16++;
        }
        int i25 = 32;
        for (int i26 = 0; i26 < 32; i26++) {
            bArr6[i26] = bArr16[i26];
        }
        long j6 = j2;
        int i27 = 13352;
        int i28 = 0;
        for (int i29 = 12; i28 < i29; i29 = 12) {
            byte[] bArr17 = new byte[40];
            for (int i30 = 0; i30 < i25; i30++) {
                bArr17[i30] = bArr9[i30];
            }
            long j7 = ((long) i28) | (j3 << 4);
            Pack.longToLittleEndian(j7 | (j6 << 59), bArr17, i25);
            aVar3.a.update(bArr17, 0, 40);
            aVar3.a.doFinal(bArr14, 0);
            int[] iArr = new int[67];
            int i31 = 0;
            int i32 = 0;
            while (i31 < 64) {
                int i33 = i31 / 2;
                iArr[i31] = bArr6[i33] & Ascii.SI;
                int i34 = i31 + 1;
                iArr[i34] = (bArr6[i33] & 255) >>> 4;
                i32 = (15 - iArr[i34]) + (15 - iArr[i31]) + i32;
                i31 += 2;
            }
            while (i31 < 67) {
                iArr[i31] = i32 & 15;
                i32 >>>= 4;
                i31++;
            }
            d.a(bArr3, i27, bArr14, 0);
            int i35 = 0;
            for (int i36 = 67; i35 < i36; i36 = 67) {
                int i37 = (i35 * 32) + i27;
                d.b(aVar3, bArr3, i37, bArr3, i37, bArr12, 0, iArr[i35]);
                i35++;
                iArr = iArr;
                j6 = j6;
            }
            int i38 = 40;
            int i39 = i27 + 2144;
            byte[] bArr18 = new byte[2048];
            byte[] bArr19 = new byte[1024];
            byte[] bArr20 = new byte[68608];
            long j8 = 0;
            while (j8 < 32) {
                int i40 = (int) (j8 * 32);
                byte[] bArr21 = new byte[i38];
                for (int i41 = 0; i41 < 32; i41++) {
                    bArr21[i41] = bArr9[i41];
                }
                Pack.longToLittleEndian((j8 << 59) | j7, bArr21, 32);
                i38 = 40;
                aVar3.a.update(bArr21, 0, 40);
                aVar3.a.doFinal(bArr19, i40);
                j8++;
                bArr18 = bArr18;
            }
            byte[] bArr22 = bArr18;
            for (long j9 = 0; j9 < 32; j9++) {
                int i42 = (int) (67 * j9 * 32);
                d.a(bArr20, i42, bArr19, (int) (j9 * 32));
                int i43 = 0;
                for (int i44 = 67; i43 < i44; i44 = 67) {
                    int i45 = (i43 * 32) + i42;
                    d.b(aVar3, bArr20, i45, bArr20, i45, bArr12, 0, 15);
                    i43++;
                    bArr19 = bArr19;
                    i42 = i42;
                    bArr20 = bArr20;
                    bArr22 = bArr22;
                }
            }
            for (long j10 = 0; j10 < 32; j10++) {
                c.a(aVar3, bArr22, (int) ((j10 * 32) + 1024), bArr20, (int) (j10 * 67 * 32), bArr12, 0);
            }
            int i46 = 0;
            for (int i47 = 32; i47 > 0; i47 >>>= 1) {
                for (int i48 = 0; i48 < i47; i48 += 2) {
                    aVar3.a(bArr22, ((i48 >>> 1) * 32) + ((i47 >>> 1) * 32), bArr22, (i48 * 32) + (i47 * 32), bArr12, (i46 + 7) * 2 * 32);
                }
                i46++;
            }
            int i49 = (int) j6;
            for (int i50 = 0; i50 < 5; i50++) {
                System.arraycopy(bArr22, (((i49 >>> i50) ^ 1) * 32) + ((32 >>> i50) * 32), bArr3, (i50 * 32) + i39, 32);
            }
            System.arraycopy(bArr22, 32, bArr6, 0, 32);
            i27 = i39 + 160;
            j6 = (long) ((int) (j3 & 31));
            j3 >>>= 5;
            i28++;
            aVar3 = aVar3;
            i25 = 32;
        }
        for (int i51 = 0; i51 != 1088; i51++) {
            bArr9[i51 + 0] = 0;
        }
        return bArr3;
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public void init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            this.b = ((SPHINCSPrivateKeyParameters) cipherParameters).getKeyData();
        } else {
            this.b = ((SPHINCSPublicKeyParameters) cipherParameters).getKeyData();
        }
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        int i;
        boolean z;
        int i2;
        byte[] bArr3;
        int i3;
        int i4;
        a aVar = this.a;
        byte[] bArr4 = this.b;
        byte[] bArr5 = new byte[2144];
        byte[] bArr6 = new byte[32];
        byte[] bArr7 = new byte[32];
        byte[] bArr8 = new byte[41000];
        byte[] bArr9 = new byte[1056];
        if (bArr2.length == 41000) {
            byte[] bArr10 = new byte[64];
            int i5 = 0;
            for (int i6 = 0; i6 < 1056; i6++) {
                bArr9[i6] = bArr4[i6];
            }
            byte[] bArr11 = new byte[32];
            for (int i7 = 0; i7 < 32; i7++) {
                bArr11[i7] = bArr2[i7];
            }
            System.arraycopy(bArr2, 0, bArr8, 0, 41000);
            Digest digest = aVar.b;
            digest.update(bArr11, 0, 32);
            digest.update(bArr9, 0, 1056);
            digest.update(bArr, 0, bArr.length);
            digest.doFinal(bArr10, 0);
            int i8 = 0;
            long j = 0;
            while (true) {
                i = 8;
                if (i8 >= 8) {
                    break;
                }
                j ^= ((long) (bArr8[32 + i8] & 255)) << (i8 * 8);
                i8++;
            }
            byte[] bArr12 = new byte[1024];
            int i9 = 2088;
            int i10 = 0;
            while (true) {
                z = true;
                if (i10 < 32) {
                    int i11 = i10 * 2;
                    int i12 = (bArr10[i11] & 255) + ((bArr10[i11 + 1] & 255) << i);
                    if ((i12 & 1) == 0) {
                        aVar.b(bArr12, i5, bArr8, i9);
                        for (int i13 = 0; i13 < 32; i13++) {
                            bArr12[i13 + 32] = bArr8[i9 + 32 + i13];
                        }
                    } else {
                        aVar.b(bArr12, 32, bArr8, i9);
                        for (int i14 = 0; i14 < 32; i14++) {
                            bArr12[i14] = bArr8[i9 + 32 + i14];
                        }
                    }
                    int i15 = i9 + 64;
                    int i16 = i12;
                    int i17 = 1;
                    while (i17 < 10) {
                        int i18 = i16 >>> 1;
                        if ((i18 & 1) == 0) {
                            i3 = i17;
                            i4 = i10;
                            bArr3 = bArr12;
                            aVar.a(bArr12, 0, bArr12, 0, bArr9, (i17 - 1) * 2 * 32);
                            for (int i19 = 0; i19 < 32; i19++) {
                                bArr3[i19 + 32] = bArr8[i15 + i19];
                            }
                        } else {
                            i3 = i17;
                            i4 = i10;
                            bArr3 = bArr12;
                            aVar.a(bArr3, 32, bArr3, 0, bArr9, (i3 - 1) * 2 * 32);
                            for (int i20 = 0; i20 < 32; i20++) {
                                bArr3[i20] = bArr8[i15 + i20];
                            }
                        }
                        i15 += 32;
                        i17 = i3 + 1;
                        i16 = i18;
                        i10 = i4;
                        bArr12 = bArr3;
                    }
                    int i21 = i16 >>> 1;
                    aVar.a(bArr12, 0, bArr12, 0, bArr9, 576);
                    int i22 = 0;
                    while (i22 < 32) {
                        if (bArr8[a2.b.a.a.a.c2(i21, 32, 40, i22)] != bArr12[i22]) {
                            for (int i23 = 0; i23 < 32; i23++) {
                                bArr7[i23] = 0;
                            }
                        } else {
                            i22++;
                            i21 = i21;
                        }
                    }
                    i10++;
                    i5 = 0;
                    i = 8;
                    i9 = i15;
                    bArr12 = bArr12;
                } else {
                    for (int i24 = 0; i24 < 32; i24++) {
                        aVar.a(bArr12, i24 * 32, bArr8, (i24 * 2 * 32) + 40, bArr9, 640);
                    }
                    for (int i25 = 0; i25 < 16; i25++) {
                        aVar.a(bArr12, i25 * 32, bArr12, i25 * 2 * 32, bArr9, 704);
                    }
                    int i26 = 0;
                    for (int i27 = 8; i26 < i27; i27 = 8) {
                        aVar.a(bArr12, i26 * 32, bArr12, i26 * 2 * 32, bArr9, 768);
                        i26++;
                    }
                    int i28 = 0;
                    for (int i29 = 4; i28 < i29; i29 = 4) {
                        aVar.a(bArr12, i28 * 32, bArr12, i28 * 2 * 32, bArr9, 832);
                        i28++;
                    }
                    for (int i30 = 0; i30 < 2; i30++) {
                        aVar.a(bArr12, i30 * 32, bArr12, i30 * 2 * 32, bArr9, 896);
                    }
                    aVar.a(bArr7, 0, bArr12, 0, bArr9, 960);
                }
            }
            int i31 = 13352;
            for (int i32 = 0; i32 < 12; i32++) {
                int i33 = 67;
                int[] iArr = new int[67];
                int i34 = 0;
                int i35 = 0;
                while (i34 < 64) {
                    int i36 = i34 / 2;
                    iArr[i34] = bArr7[i36] & Ascii.SI;
                    int i37 = i34 + 1;
                    iArr[i37] = (bArr7[i36] & 255) >>> 4;
                    i35 = (15 - iArr[i37]) + (15 - iArr[i34]) + i35;
                    i34 += 2;
                }
                while (i34 < 67) {
                    iArr[i34] = i35 & 15;
                    i35 >>>= 4;
                    i34++;
                }
                int i38 = 0;
                while (i38 < i33) {
                    int i39 = i38 * 32;
                    d.b(aVar, bArr5, i39, bArr8, i31 + i39, bArr9, iArr[i38] * 32, 15 - iArr[i38]);
                    i38++;
                    i33 = 67;
                    i31 = i31;
                    iArr = iArr;
                }
                int i40 = i31 + 2144;
                c.a(aVar, bArr6, 0, bArr5, 0, bArr9, 0);
                int i41 = (int) (j & 31);
                byte[] bArr13 = new byte[64];
                if ((i41 & 1) != 0) {
                    for (int i42 = 0; i42 < 32; i42++) {
                        bArr13[i42 + 32] = bArr6[i42];
                    }
                    for (int i43 = 0; i43 < 32; i43++) {
                        bArr13[i43] = bArr8[i40 + i43];
                    }
                } else {
                    for (int i44 = 0; i44 < 32; i44++) {
                        bArr13[i44] = bArr6[i44];
                    }
                    int i45 = 0;
                    for (int i46 = 32; i45 < i46; i46 = 32) {
                        bArr13[i45 + 32] = bArr8[i40 + i45];
                        i45++;
                    }
                }
                int i47 = 4;
                int i48 = i40 + 32;
                int i49 = 0;
                while (i49 < i47) {
                    int i50 = i41 >>> 1;
                    if ((i50 & 1) != 0) {
                        i2 = i49;
                        aVar.a(bArr13, 32, bArr13, 0, bArr9, (i49 + 7) * 2 * 32);
                        for (int i51 = 0; i51 < 32; i51++) {
                            bArr13[i51] = bArr8[i48 + i51];
                        }
                    } else {
                        i2 = i49;
                        aVar.a(bArr13, 0, bArr13, 0, bArr9, (i2 + 7) * 2 * 32);
                        for (int i52 = 0; i52 < 32; i52++) {
                            bArr13[i52 + 32] = bArr8[i48 + i52];
                        }
                    }
                    i48 += 32;
                    i49 = i2 + 1;
                    i47 = 4;
                    i41 = i50;
                }
                aVar.a(bArr7, 0, bArr13, 0, bArr9, 704);
                j >>= 5;
                i31 = i40 + 160;
            }
            for (int i53 = 0; i53 < 32; i53++) {
                if (bArr7[i53] != bArr9[i53 + 1024]) {
                    z = false;
                }
            }
            return z;
        }
        throw new IllegalArgumentException("signature wrong size");
    }
}
