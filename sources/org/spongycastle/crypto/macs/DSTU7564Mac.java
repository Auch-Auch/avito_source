package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.digests.DSTU7564Digest;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Pack;
public class DSTU7564Mac implements Mac {
    public DSTU7564Digest a;
    public int b;
    public byte[] c = null;
    public byte[] d = null;
    public long e;

    public DSTU7564Mac(int i) {
        this.a = new DSTU7564Digest(i);
        this.b = i / 8;
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        if (this.c == null) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (bArr.length - i >= this.b) {
            int byteLength = this.a.getByteLength() - ((int) (this.e % ((long) this.a.getByteLength())));
            if (byteLength < 13) {
                byteLength += this.a.getByteLength();
            }
            byte[] bArr2 = new byte[byteLength];
            bArr2[0] = Byte.MIN_VALUE;
            Pack.longToLittleEndian(this.e * 8, bArr2, byteLength - 12);
            this.a.update(bArr2, 0, byteLength);
            DSTU7564Digest dSTU7564Digest = this.a;
            byte[] bArr3 = this.d;
            dSTU7564Digest.update(bArr3, 0, bArr3.length);
            this.e = 0;
            return this.a.doFinal(bArr, i);
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        return "DSTU7564Mac";
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return this.b;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            this.d = new byte[key.length];
            int byteLength = this.a.getByteLength() * (((this.a.getByteLength() + key.length) - 1) / this.a.getByteLength());
            if (this.a.getByteLength() - (key.length % this.a.getByteLength()) < 13) {
                byteLength += this.a.getByteLength();
            }
            byte[] bArr = new byte[byteLength];
            System.arraycopy(key, 0, bArr, 0, key.length);
            bArr[key.length] = Byte.MIN_VALUE;
            Pack.intToLittleEndian(key.length * 8, bArr, byteLength - 12);
            this.c = bArr;
            int i = 0;
            while (true) {
                byte[] bArr2 = this.d;
                if (i < bArr2.length) {
                    bArr2[i] = (byte) (~key[i]);
                    i++;
                } else {
                    DSTU7564Digest dSTU7564Digest = this.a;
                    byte[] bArr3 = this.c;
                    dSTU7564Digest.update(bArr3, 0, bArr3.length);
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Bad parameter passed");
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        this.e = 0;
        this.a.reset();
        byte[] bArr = this.c;
        if (bArr != null) {
            this.a.update(bArr, 0, bArr.length);
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b2) throws IllegalStateException {
        this.a.update(b2);
        this.e++;
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
        if (bArr.length - i < i2) {
            throw new DataLengthException("Input buffer too short");
        } else if (this.c != null) {
            this.a.update(bArr, i, i2);
            this.e += (long) i2;
        } else {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        }
    }
}
