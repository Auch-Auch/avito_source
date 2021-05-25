package org.spongycastle.crypto.generators;

import a2.b.a.a.a;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
public class PKCS12ParametersGenerator extends PBEParametersGenerator {
    public static final int IV_MATERIAL = 2;
    public static final int KEY_MATERIAL = 1;
    public static final int MAC_MATERIAL = 3;
    public Digest a;
    public int b;
    public int c;

    public PKCS12ParametersGenerator(Digest digest) {
        this.a = digest;
        if (digest instanceof ExtendedDigest) {
            this.b = digest.getDigestSize();
            this.c = ((ExtendedDigest) digest).getByteLength();
            return;
        }
        StringBuilder L = a.L("Digest ");
        L.append(digest.getAlgorithmName());
        L.append(" unsupported");
        throw new IllegalArgumentException(L.toString());
    }

    public final byte[] a(int i, int i2) {
        byte[] bArr;
        byte[] bArr2;
        int i3 = this.c;
        byte[] bArr3 = new byte[i3];
        byte[] bArr4 = new byte[i2];
        int i4 = 0;
        for (int i5 = 0; i5 != i3; i5++) {
            bArr3[i5] = (byte) i;
        }
        byte[] bArr5 = this.salt;
        if (bArr5 == null || bArr5.length == 0) {
            bArr = new byte[0];
        } else {
            int i6 = this.c;
            int length = (((bArr5.length + i6) - 1) / i6) * i6;
            bArr = new byte[length];
            for (int i7 = 0; i7 != length; i7++) {
                byte[] bArr6 = this.salt;
                bArr[i7] = bArr6[i7 % bArr6.length];
            }
        }
        byte[] bArr7 = this.password;
        if (bArr7 == null || bArr7.length == 0) {
            bArr2 = new byte[0];
        } else {
            int i8 = this.c;
            int length2 = (((bArr7.length + i8) - 1) / i8) * i8;
            bArr2 = new byte[length2];
            for (int i9 = 0; i9 != length2; i9++) {
                byte[] bArr8 = this.password;
                bArr2[i9] = bArr8[i9 % bArr8.length];
            }
        }
        int length3 = bArr.length + bArr2.length;
        byte[] bArr9 = new byte[length3];
        System.arraycopy(bArr, 0, bArr9, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr9, bArr.length, bArr2.length);
        int i10 = this.c;
        byte[] bArr10 = new byte[i10];
        int i11 = this.b;
        int i12 = ((i2 + i11) - 1) / i11;
        byte[] bArr11 = new byte[i11];
        int i13 = 1;
        while (i13 <= i12) {
            this.a.update(bArr3, i4, i3);
            this.a.update(bArr9, i4, length3);
            this.a.doFinal(bArr11, i4);
            for (int i14 = 1; i14 < this.iterationCount; i14++) {
                this.a.update(bArr11, i4, i11);
                this.a.doFinal(bArr11, i4);
            }
            for (int i15 = 0; i15 != i10; i15++) {
                bArr10[i15] = bArr11[i15 % i11];
            }
            int i16 = 0;
            while (true) {
                int i17 = this.c;
                if (i16 == length3 / i17) {
                    break;
                }
                int i18 = i17 * i16;
                int i19 = (i10 + i18) - 1;
                int i20 = (bArr10[i10 - 1] & 255) + (bArr9[i19] & 255) + 1;
                bArr9[i19] = (byte) i20;
                int i21 = i20 >>> 8;
                int i22 = i10 - 2;
                while (i22 >= 0) {
                    int i23 = i18 + i22;
                    int i24 = (bArr10[i22] & 255) + (bArr9[i23] & 255) + i21;
                    bArr9[i23] = (byte) i24;
                    i21 = i24 >>> 8;
                    i22--;
                    bArr3 = bArr3;
                    length3 = length3;
                }
                i16++;
                bArr3 = bArr3;
                i3 = i3;
                length3 = length3;
            }
            if (i13 == i12) {
                int i25 = i13 - 1;
                int i26 = this.b;
                System.arraycopy(bArr11, 0, bArr4, i25 * i26, i2 - (i25 * i26));
            } else {
                System.arraycopy(bArr11, 0, bArr4, (i13 - 1) * this.b, i11);
            }
            i13++;
            bArr3 = bArr3;
            i3 = i3;
            length3 = length3;
            i4 = 0;
        }
        return bArr4;
    }

    @Override // org.spongycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedMacParameters(int i) {
        int i2 = i / 8;
        return new KeyParameter(a(3, i2), 0, i2);
    }

    @Override // org.spongycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i) {
        int i2 = i / 8;
        return new KeyParameter(a(1, i2), 0, i2);
    }

    @Override // org.spongycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i, int i2) {
        int i3 = i / 8;
        int i4 = i2 / 8;
        byte[] a3 = a(1, i3);
        return new ParametersWithIV(new KeyParameter(a3, 0, i3), a(2, i4), 0, i4);
    }
}
