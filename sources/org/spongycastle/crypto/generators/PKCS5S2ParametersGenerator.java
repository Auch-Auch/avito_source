package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.util.DigestFactory;
import org.spongycastle.util.Arrays;
public class PKCS5S2ParametersGenerator extends PBEParametersGenerator {
    public Mac a;
    public byte[] b;

    public PKCS5S2ParametersGenerator() {
        this(DigestFactory.createSHA1());
    }

    public final byte[] a(int i) {
        int macSize = this.a.getMacSize();
        int i2 = ((i + macSize) - 1) / macSize;
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[(i2 * macSize)];
        this.a.init(new KeyParameter(this.password));
        int i3 = 0;
        for (int i4 = 1; i4 <= i2; i4++) {
            int i5 = 3;
            while (true) {
                byte b2 = (byte) (bArr[i5] + 1);
                bArr[i5] = b2;
                if (b2 != 0) {
                    break;
                }
                i5--;
            }
            byte[] bArr3 = this.salt;
            int i6 = this.iterationCount;
            if (i6 != 0) {
                if (bArr3 != null) {
                    this.a.update(bArr3, 0, bArr3.length);
                }
                this.a.update(bArr, 0, 4);
                this.a.doFinal(this.b, 0);
                byte[] bArr4 = this.b;
                System.arraycopy(bArr4, 0, bArr2, i3, bArr4.length);
                for (int i7 = 1; i7 < i6; i7++) {
                    Mac mac = this.a;
                    byte[] bArr5 = this.b;
                    mac.update(bArr5, 0, bArr5.length);
                    this.a.doFinal(this.b, 0);
                    int i8 = 0;
                    while (true) {
                        byte[] bArr6 = this.b;
                        if (i8 == bArr6.length) {
                            break;
                        }
                        int i9 = i3 + i8;
                        bArr2[i9] = (byte) (bArr6[i8] ^ bArr2[i9]);
                        i8++;
                    }
                }
                i3 += macSize;
            } else {
                throw new IllegalArgumentException("iteration count must be at least 1.");
            }
        }
        return bArr2;
    }

    @Override // org.spongycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedMacParameters(int i) {
        return generateDerivedParameters(i);
    }

    @Override // org.spongycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i) {
        int i2 = i / 8;
        return new KeyParameter(Arrays.copyOfRange(a(i2), 0, i2), 0, i2);
    }

    public PKCS5S2ParametersGenerator(Digest digest) {
        HMac hMac = new HMac(digest);
        this.a = hMac;
        this.b = new byte[hMac.getMacSize()];
    }

    @Override // org.spongycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i, int i2) {
        int i3 = i / 8;
        int i4 = i2 / 8;
        byte[] a3 = a(i3 + i4);
        return new ParametersWithIV(new KeyParameter(a3, 0, i3), a3, i3, i4);
    }
}
