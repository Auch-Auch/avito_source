package org.spongycastle.crypto.macs;

import com.google.common.base.Ascii;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
public class VMPCMac implements Mac {
    public byte a;
    public byte b = 0;
    public byte[] c = null;
    public byte d = 0;
    public byte[] e;
    public byte[] f;
    public byte[] g;
    public byte h;
    public byte i;
    public byte j;
    public byte k;

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i2) throws DataLengthException, IllegalStateException {
        for (int i3 = 1; i3 < 25; i3++) {
            byte[] bArr2 = this.c;
            byte b2 = this.d;
            byte b3 = this.b;
            byte b4 = bArr2[(b2 + bArr2[b3 & 255]) & 255];
            this.d = b4;
            byte b5 = this.k;
            byte b6 = this.j;
            byte b8 = bArr2[(b5 + b6 + i3) & 255];
            this.k = b8;
            byte b9 = this.i;
            byte b10 = bArr2[(b6 + b9 + i3) & 255];
            this.j = b10;
            byte b11 = this.h;
            byte b12 = bArr2[(b9 + b11 + i3) & 255];
            this.i = b12;
            byte b13 = bArr2[(b11 + b4 + i3) & 255];
            this.h = b13;
            byte[] bArr3 = this.e;
            byte b14 = this.a;
            bArr3[b14 & Ascii.US] = (byte) (b13 ^ bArr3[b14 & Ascii.US]);
            bArr3[(b14 + 1) & 31] = (byte) (b12 ^ bArr3[(b14 + 1) & 31]);
            bArr3[(b14 + 2) & 31] = (byte) (b10 ^ bArr3[(b14 + 2) & 31]);
            bArr3[(b14 + 3) & 31] = (byte) (b8 ^ bArr3[(b14 + 3) & 31]);
            this.a = (byte) ((b14 + 4) & 31);
            byte b15 = bArr2[b3 & 255];
            bArr2[b3 & 255] = bArr2[b4 & 255];
            bArr2[b4 & 255] = b15;
            this.b = (byte) ((b3 + 1) & 255);
        }
        for (int i4 = 0; i4 < 768; i4++) {
            byte[] bArr4 = this.c;
            int i5 = i4 & 255;
            byte b16 = bArr4[(this.d + bArr4[i5] + this.e[i4 & 31]) & 255];
            this.d = b16;
            byte b17 = bArr4[i5];
            bArr4[i5] = bArr4[b16 & 255];
            bArr4[b16 & 255] = b17;
        }
        byte[] bArr5 = new byte[20];
        for (int i6 = 0; i6 < 20; i6++) {
            byte[] bArr6 = this.c;
            int i7 = i6 & 255;
            byte b18 = bArr6[(this.d + bArr6[i7]) & 255];
            this.d = b18;
            bArr5[i6] = bArr6[(bArr6[bArr6[b18 & 255] & 255] + 1) & 255];
            byte b19 = bArr6[i7];
            bArr6[i7] = bArr6[b18 & 255];
            bArr6[b18 & 255] = b19;
        }
        System.arraycopy(bArr5, 0, bArr, i2, 20);
        reset();
        return 20;
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        return "VMPC-MAC";
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return 20;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
            if (parametersWithIV.getParameters() instanceof KeyParameter) {
                byte[] iv = parametersWithIV.getIV();
                this.f = iv;
                if (iv == null || iv.length < 1 || iv.length > 768) {
                    throw new IllegalArgumentException("VMPC-MAC requires 1 to 768 bytes of IV");
                }
                this.g = keyParameter.getKey();
                reset();
                return;
            }
            throw new IllegalArgumentException("VMPC-MAC Init parameters must include a key");
        }
        throw new IllegalArgumentException("VMPC-MAC Init parameters must include an IV");
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        byte[] bArr = this.g;
        byte[] bArr2 = this.f;
        this.d = 0;
        this.c = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            this.c[i2] = (byte) i2;
        }
        for (int i3 = 0; i3 < 768; i3++) {
            byte[] bArr3 = this.c;
            int i4 = i3 & 255;
            byte b2 = bArr3[(this.d + bArr3[i4] + bArr[i3 % bArr.length]) & 255];
            this.d = b2;
            byte b3 = bArr3[i4];
            int i5 = b2 & 255;
            bArr3[i4] = bArr3[i5];
            bArr3[i5] = b3;
        }
        for (int i6 = 0; i6 < 768; i6++) {
            byte[] bArr4 = this.c;
            int i7 = i6 & 255;
            byte b4 = bArr4[(this.d + bArr4[i7] + bArr2[i6 % bArr2.length]) & 255];
            this.d = b4;
            byte b5 = bArr4[i7];
            int i8 = b4 & 255;
            bArr4[i7] = bArr4[i8];
            bArr4[i8] = b5;
        }
        this.b = 0;
        this.b = 0;
        this.k = 0;
        this.j = 0;
        this.i = 0;
        this.h = 0;
        this.a = 0;
        this.e = new byte[32];
        for (int i9 = 0; i9 < 32; i9++) {
            this.e[i9] = 0;
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b2) throws IllegalStateException {
        byte[] bArr = this.c;
        byte b3 = this.d;
        byte b4 = this.b;
        byte b5 = bArr[(b3 + bArr[b4 & 255]) & 255];
        this.d = b5;
        byte b6 = this.k;
        byte b8 = this.j;
        byte b9 = bArr[(b6 + b8) & 255];
        this.k = b9;
        byte b10 = this.i;
        byte b11 = bArr[(b8 + b10) & 255];
        this.j = b11;
        byte b12 = this.h;
        byte b13 = bArr[(b10 + b12) & 255];
        this.i = b13;
        byte b14 = bArr[(b12 + b5 + ((byte) (b2 ^ bArr[(bArr[bArr[b5 & 255] & 255] + 1) & 255]))) & 255];
        this.h = b14;
        byte[] bArr2 = this.e;
        byte b15 = this.a;
        bArr2[b15 & Ascii.US] = (byte) (b14 ^ bArr2[b15 & Ascii.US]);
        bArr2[(b15 + 1) & 31] = (byte) (b13 ^ bArr2[(b15 + 1) & 31]);
        bArr2[(b15 + 2) & 31] = (byte) (b11 ^ bArr2[(b15 + 2) & 31]);
        bArr2[(b15 + 3) & 31] = (byte) (b9 ^ bArr2[(b15 + 3) & 31]);
        this.a = (byte) ((b15 + 4) & 31);
        byte b16 = bArr[b4 & 255];
        bArr[b4 & 255] = bArr[b5 & 255];
        bArr[b5 & 255] = b16;
        this.b = (byte) ((b4 + 1) & 255);
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i2, int i3) throws DataLengthException, IllegalStateException {
        if (i2 + i3 <= bArr.length) {
            for (int i4 = 0; i4 < i3; i4++) {
                update(bArr[i2 + i4]);
            }
            return;
        }
        throw new DataLengthException("input buffer too short");
    }
}
