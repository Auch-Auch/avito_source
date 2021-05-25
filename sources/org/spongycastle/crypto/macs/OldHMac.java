package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
public class OldHMac implements Mac {
    public Digest a;
    public int b;
    public byte[] c = new byte[64];
    public byte[] d = new byte[64];

    public OldHMac(Digest digest) {
        this.a = digest;
        this.b = digest.getDigestSize();
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i) {
        int i2 = this.b;
        byte[] bArr2 = new byte[i2];
        this.a.doFinal(bArr2, 0);
        Digest digest = this.a;
        byte[] bArr3 = this.d;
        digest.update(bArr3, 0, bArr3.length);
        this.a.update(bArr2, 0, i2);
        int doFinal = this.a.doFinal(bArr, i);
        reset();
        return doFinal;
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        return this.a.getAlgorithmName() + "/HMAC";
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return this.b;
    }

    public Digest getUnderlyingDigest() {
        return this.a;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) {
        this.a.reset();
        byte[] key = ((KeyParameter) cipherParameters).getKey();
        if (key.length <= 64) {
            System.arraycopy(key, 0, this.c, 0, key.length);
            int length = key.length;
            while (true) {
                byte[] bArr = this.c;
                if (length >= bArr.length) {
                    break;
                }
                bArr[length] = 0;
                length++;
            }
        } else {
            this.a.update(key, 0, key.length);
            this.a.doFinal(this.c, 0);
            int i = this.b;
            while (true) {
                byte[] bArr2 = this.c;
                if (i >= bArr2.length) {
                    break;
                }
                bArr2[i] = 0;
                i++;
            }
        }
        byte[] bArr3 = this.c;
        byte[] bArr4 = new byte[bArr3.length];
        this.d = bArr4;
        System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
        int i2 = 0;
        while (true) {
            byte[] bArr5 = this.c;
            if (i2 >= bArr5.length) {
                break;
            }
            bArr5[i2] = (byte) (bArr5[i2] ^ 54);
            i2++;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr6 = this.d;
            if (i3 < bArr6.length) {
                bArr6[i3] = (byte) (bArr6[i3] ^ 92);
                i3++;
            } else {
                Digest digest = this.a;
                byte[] bArr7 = this.c;
                digest.update(bArr7, 0, bArr7.length);
                return;
            }
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        this.a.reset();
        Digest digest = this.a;
        byte[] bArr = this.c;
        digest.update(bArr, 0, bArr.length);
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b2) {
        this.a.update(b2);
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i, int i2) {
        this.a.update(bArr, i, i2);
    }
}
