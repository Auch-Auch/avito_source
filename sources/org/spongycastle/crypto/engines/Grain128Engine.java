package org.spongycastle.crypto.engines;

import com.google.common.base.Ascii;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
public class Grain128Engine implements StreamCipher {
    public byte[] a;
    public byte[] b;
    public byte[] c;
    public int[] d;
    public int[] e;
    public int f;
    public int g = 4;
    public boolean h = false;

    public final byte a() {
        if (this.g > 3) {
            int b2 = b();
            this.f = b2;
            byte[] bArr = this.c;
            bArr[0] = (byte) b2;
            bArr[1] = (byte) (b2 >> 8);
            bArr[2] = (byte) (b2 >> 16);
            bArr[3] = (byte) (b2 >> 24);
            int[] iArr = this.e;
            e(iArr, d() ^ this.d[0]);
            this.e = iArr;
            int[] iArr2 = this.d;
            e(iArr2, c());
            this.d = iArr2;
            this.g = 0;
        }
        byte[] bArr2 = this.c;
        int i = this.g;
        this.g = i + 1;
        return bArr2[i];
    }

    public final int b() {
        int[] iArr = this.e;
        int i = (iArr[0] >>> 2) | (iArr[1] << 30);
        int i2 = (iArr[0] >>> 12) | (iArr[1] << 20);
        int i3 = (iArr[0] >>> 15) | (iArr[1] << 17);
        int i4 = (iArr[1] >>> 4) | (iArr[2] << 28);
        int i5 = (iArr[1] >>> 13) | (iArr[2] << 19);
        int i6 = iArr[2];
        int i7 = (iArr[2] >>> 9) | (iArr[3] << 23);
        int i8 = (iArr[2] >>> 25) | (iArr[3] << 7);
        int i9 = (iArr[3] << 1) | (iArr[2] >>> 31);
        int[] iArr2 = this.d;
        int i10 = (iArr2[0] >>> 8) | (iArr2[1] << 24);
        int i11 = (iArr2[0] >>> 13) | (iArr2[1] << 19);
        int i12 = (iArr2[0] >>> 20) | (iArr2[1] << 12);
        int i13 = (iArr2[1] >>> 10) | (iArr2[2] << 22);
        int i14 = (iArr2[1] >>> 28) | (iArr2[2] << 4);
        int i15 = (iArr2[2] >>> 15) | (iArr2[3] << 17);
        int i16 = i9 & i2 & ((iArr2[2] >>> 31) | (iArr2[3] << 1));
        return ((((((((i16 ^ ((((i11 & i12) ^ (i2 & i10)) ^ (i9 & i13)) ^ (i14 & i15))) ^ ((iArr2[2] >>> 29) | (iArr2[3] << 3))) ^ i) ^ i3) ^ i4) ^ i5) ^ i6) ^ i7) ^ i8;
    }

    public final int c() {
        int[] iArr = this.d;
        int i = iArr[0];
        int i2 = (iArr[0] >>> 7) | (iArr[1] << 25);
        int i3 = (iArr[1] >>> 6) | (iArr[2] << 26);
        return iArr[3] ^ ((((i2 ^ i) ^ i3) ^ ((iArr[2] >>> 6) | (iArr[3] << 26))) ^ ((iArr[2] >>> 17) | (iArr[3] << 15)));
    }

    public final int d() {
        int[] iArr = this.e;
        int i = iArr[0];
        int i2 = (iArr[0] >>> 3) | (iArr[1] << 29);
        int i3 = (iArr[0] >>> 11) | (iArr[1] << 21);
        int i4 = (iArr[0] >>> 13) | (iArr[1] << 19);
        int i5 = (iArr[0] >>> 17) | (iArr[1] << 15);
        int i6 = (iArr[0] >>> 18) | (iArr[1] << 14);
        int i7 = (iArr[0] >>> 26) | (iArr[1] << 6);
        int i8 = (iArr[0] >>> 27) | (iArr[1] << 5);
        int i9 = (iArr[1] >>> 8) | (iArr[2] << 24);
        int i10 = (iArr[1] >>> 16) | (iArr[2] << 16);
        int i11 = (iArr[1] >>> 24) | (iArr[2] << 8);
        int i12 = (iArr[1] >>> 27) | (iArr[2] << 5);
        int i13 = (iArr[1] >>> 29) | (iArr[2] << 3);
        int i14 = (iArr[2] >>> 1) | (iArr[3] << 31);
        return (((((((iArr[3] ^ (((i ^ i7) ^ i11) ^ ((iArr[2] >>> 27) | (iArr[3] << 5)))) ^ (i2 & ((iArr[2] >>> 3) | (iArr[3] << 29)))) ^ (i3 & i4)) ^ (i5 & i6)) ^ (i8 & i12)) ^ (i9 & i10)) ^ (i13 & i14)) ^ (((iArr[2] >>> 4) | (iArr[3] << 28)) & ((iArr[2] >>> 20) | (iArr[3] << 12)));
    }

    public final int[] e(int[] iArr, int i) {
        iArr[0] = iArr[1];
        iArr[1] = iArr[2];
        iArr[2] = iArr[3];
        iArr[3] = i;
        return iArr;
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "Grain-128";
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            if (iv == null || iv.length != 12) {
                throw new IllegalArgumentException("Grain-128  requires exactly 12 bytes of IV");
            } else if (parametersWithIV.getParameters() instanceof KeyParameter) {
                KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
                this.b = new byte[keyParameter.getKey().length];
                this.a = new byte[keyParameter.getKey().length];
                this.d = new int[4];
                this.e = new int[4];
                this.c = new byte[4];
                System.arraycopy(iv, 0, this.b, 0, iv.length);
                System.arraycopy(keyParameter.getKey(), 0, this.a, 0, keyParameter.getKey().length);
                reset();
            } else {
                throw new IllegalArgumentException("Grain-128 Init parameters must include a key");
            }
        } else {
            throw new IllegalArgumentException("Grain-128 Init parameters must include an IV");
        }
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
        if (!this.h) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                bArr2[i3 + i4] = (byte) (bArr[i + i4] ^ a());
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void reset() {
        this.g = 4;
        byte[] bArr = this.a;
        byte[] bArr2 = this.b;
        bArr2[12] = -1;
        bArr2[13] = -1;
        bArr2[14] = -1;
        bArr2[15] = -1;
        this.a = bArr;
        this.b = bArr2;
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.e;
            if (i >= iArr.length) {
                break;
            }
            byte[] bArr3 = this.a;
            int i3 = i2 + 3;
            int i4 = i2 + 2;
            int i5 = (bArr3[i3] << Ascii.CAN) | ((bArr3[i4] << Ascii.DLE) & 16711680);
            int i6 = i2 + 1;
            iArr[i] = (bArr3[i2] & 255) | i5 | ((bArr3[i6] << 8) & 65280);
            int[] iArr2 = this.d;
            byte[] bArr4 = this.b;
            int i7 = (bArr4[i3] << Ascii.CAN) | ((bArr4[i4] << Ascii.DLE) & 16711680);
            iArr2[i] = (bArr4[i2] & 255) | ((bArr4[i6] << 8) & 65280) | i7;
            i2 += 4;
            i++;
        }
        for (int i8 = 0; i8 < 8; i8++) {
            this.f = b();
            int[] iArr3 = this.e;
            e(iArr3, (d() ^ this.d[0]) ^ this.f);
            this.e = iArr3;
            int[] iArr4 = this.d;
            e(iArr4, c() ^ this.f);
            this.d = iArr4;
        }
        this.h = true;
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public byte returnByte(byte b2) {
        if (this.h) {
            return (byte) (b2 ^ a());
        }
        throw new IllegalStateException(getAlgorithmName() + " not initialised");
    }
}
