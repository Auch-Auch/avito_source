package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.engines.DSTU7624Engine;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;
public class DSTU7624Mac implements Mac {
    public byte[] a;
    public int b;
    public int c;
    public int d;
    public DSTU7624Engine e;
    public byte[] f;
    public byte[] g;
    public byte[] h;

    public DSTU7624Mac(int i, int i2) {
        this.e = new DSTU7624Engine(i);
        int i3 = i / 8;
        this.d = i3;
        this.c = i2 / 8;
        this.f = new byte[i3];
        this.h = new byte[i3];
        this.g = new byte[i3];
        this.a = new byte[i3];
    }

    public final void a(byte[] bArr, int i) {
        b(this.f, 0, bArr, i, this.g);
        this.e.processBlock(this.g, 0, this.f, 0);
    }

    public final void b(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3) {
        int length = bArr.length - i;
        int i3 = this.d;
        if (length < i3 || bArr2.length - i2 < i3 || bArr3.length < i3) {
            throw new IllegalArgumentException("some of input buffers too short");
        }
        for (int i4 = 0; i4 < this.d; i4++) {
            bArr3[i4] = (byte) (bArr[i4 + i] ^ bArr2[i4 + i2]);
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        int i2 = this.b;
        byte[] bArr2 = this.a;
        if (i2 % bArr2.length == 0) {
            b(this.f, 0, bArr2, 0, this.g);
            b(this.g, 0, this.h, 0, this.f);
            DSTU7624Engine dSTU7624Engine = this.e;
            byte[] bArr3 = this.f;
            dSTU7624Engine.processBlock(bArr3, 0, bArr3, 0);
            int i3 = this.c;
            if (i3 + i <= bArr.length) {
                System.arraycopy(this.f, 0, bArr, i, i3);
                return this.c;
            }
            throw new OutputLengthException("output buffer too short");
        }
        throw new DataLengthException("input must be a multiple of blocksize");
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        return "DSTU7624Mac";
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return this.c;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            this.e.init(true, cipherParameters);
            DSTU7624Engine dSTU7624Engine = this.e;
            byte[] bArr = this.h;
            dSTU7624Engine.processBlock(bArr, 0, bArr, 0);
            return;
        }
        throw new IllegalArgumentException("Invalid parameter passed to DSTU7624Mac");
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        Arrays.fill(this.f, (byte) 0);
        Arrays.fill(this.g, (byte) 0);
        Arrays.fill(this.h, (byte) 0);
        Arrays.fill(this.a, (byte) 0);
        this.e.reset();
        DSTU7624Engine dSTU7624Engine = this.e;
        byte[] bArr = this.h;
        dSTU7624Engine.processBlock(bArr, 0, bArr, 0);
        this.b = 0;
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b2) {
        int i = this.b;
        byte[] bArr = this.a;
        if (i == bArr.length) {
            a(bArr, 0);
            this.b = 0;
        }
        byte[] bArr2 = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr2[i2] = b2;
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            int blockSize = this.e.getBlockSize();
            int i3 = this.b;
            int i4 = blockSize - i3;
            if (i2 > i4) {
                System.arraycopy(bArr, i, this.a, i3, i4);
                a(this.a, 0);
                this.b = 0;
                i2 -= i4;
                i += i4;
                while (i2 > blockSize) {
                    a(bArr, i);
                    i2 -= blockSize;
                    i += blockSize;
                }
            }
            System.arraycopy(bArr, i, this.a, this.b, i2);
            this.b += i2;
            return;
        }
        throw new IllegalArgumentException("can't have a negative input length!");
    }
}
