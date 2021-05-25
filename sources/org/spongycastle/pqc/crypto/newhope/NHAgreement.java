package org.spongycastle.pqc.crypto.newhope;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.digests.SHA3Digest;
import x6.e.f.a.b.a;
public class NHAgreement {
    public NHPrivateKeyParameters a;

    public byte[] calculateAgreement(CipherParameters cipherParameters) {
        byte[] bArr = new byte[32];
        short[] sArr = this.a.b;
        byte[] bArr2 = ((NHPublicKeyParameters) cipherParameters).b;
        short[] sArr2 = new short[1024];
        short[] sArr3 = new short[1024];
        a.c(sArr2, bArr2);
        for (int i = 0; i < 256; i++) {
            int i2 = i * 4;
            int i3 = bArr2[i + 1792] & 255;
            sArr3[i2 + 0] = (short) (i3 & 3);
            sArr3[i2 + 1] = (short) ((i3 >>> 2) & 3);
            sArr3[i2 + 2] = (short) ((i3 >>> 4) & 3);
            sArr3[i2 + 3] = (short) (i3 >>> 6);
        }
        short[] sArr4 = new short[1024];
        a.h(sArr, sArr2, sArr4);
        a.d(sArr4);
        a.i(bArr, sArr4, sArr3);
        SHA3Digest sHA3Digest = new SHA3Digest(256);
        sHA3Digest.update(bArr, 0, 32);
        sHA3Digest.doFinal(bArr, 0);
        return bArr;
    }

    public void init(CipherParameters cipherParameters) {
        this.a = (NHPrivateKeyParameters) cipherParameters;
    }
}
