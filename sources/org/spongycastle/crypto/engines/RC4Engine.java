package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
public class RC4Engine implements StreamCipher {
    public byte[] a = null;
    public int b = 0;
    public int c = 0;
    public byte[] d = null;

    public final void a(byte[] bArr) {
        this.d = bArr;
        this.b = 0;
        this.c = 0;
        if (this.a == null) {
            this.a = new byte[256];
        }
        for (int i = 0; i < 256; i++) {
            this.a[i] = (byte) i;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            byte[] bArr2 = this.a;
            i3 = ((bArr[i2] & 255) + bArr2[i4] + i3) & 255;
            byte b2 = bArr2[i4];
            bArr2[i4] = bArr2[i3];
            bArr2[i3] = b2;
            i2 = (i2 + 1) % bArr.length;
        }
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "RC4";
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            this.d = key;
            a(key);
            return;
        }
        throw new IllegalArgumentException(a.E(cipherParameters, a.L("invalid parameter passed to RC4 init - ")));
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = (this.b + 1) & 255;
                this.b = i5;
                byte[] bArr3 = this.a;
                int i6 = (bArr3[i5] + this.c) & 255;
                this.c = i6;
                byte b2 = bArr3[i5];
                bArr3[i5] = bArr3[i6];
                bArr3[i6] = b2;
                bArr2[i4 + i3] = (byte) (bArr3[(bArr3[i5] + bArr3[i6]) & 255] ^ bArr[i4 + i]);
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void reset() {
        a(this.d);
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public byte returnByte(byte b2) {
        int i = (this.b + 1) & 255;
        this.b = i;
        byte[] bArr = this.a;
        int i2 = (bArr[i] + this.c) & 255;
        this.c = i2;
        byte b3 = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b3;
        return (byte) (b2 ^ bArr[(bArr[i] + bArr[i2]) & 255]);
    }
}
