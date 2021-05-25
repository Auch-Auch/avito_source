package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
public class Grainv1Engine implements StreamCipher {
    public byte[] a;
    public byte[] b;
    public byte[] c;
    public int[] d;
    public int[] e;
    public int f;
    public int g = 2;
    public boolean h = false;

    public final byte a() {
        if (this.g > 1) {
            int b2 = b();
            this.f = b2;
            byte[] bArr = this.c;
            bArr[0] = (byte) b2;
            bArr[1] = (byte) (b2 >> 8);
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
        int i = (iArr[0] >>> 1) | (iArr[1] << 15);
        int i2 = (iArr[0] >>> 2) | (iArr[1] << 14);
        int i3 = (iArr[0] >>> 4) | (iArr[1] << 12);
        int i4 = (iArr[0] >>> 10) | (iArr[1] << 6);
        int i5 = (iArr[1] >>> 15) | (iArr[2] << 1);
        int i6 = (iArr[2] >>> 11) | (iArr[3] << 5);
        int i7 = (iArr[3] >>> 8) | (iArr[4] << 8);
        int i8 = (iArr[4] << 1) | (iArr[3] >>> 15);
        int[] iArr2 = this.d;
        int i9 = (iArr2[0] >>> 3) | (iArr2[1] << 13);
        int i10 = (iArr2[1] >>> 9) | (iArr2[2] << 7);
        int i11 = (iArr2[3] << 2) | (iArr2[2] >>> 14);
        int i12 = iArr2[4];
        int i13 = (i10 ^ i8) ^ (i9 & i12);
        int i14 = i11 & i12;
        int i15 = i9 & i11;
        int i16 = i12 & i15;
        int i17 = i15 & i8;
        return (((((((((i8 & i14) ^ ((i17 ^ (i16 ^ (((i13 ^ i14) ^ (i12 & i8)) ^ ((i9 & i10) & i11)))) ^ ((i10 & i11) & i8))) ^ i) ^ i2) ^ i3) ^ i4) ^ i5) ^ i6) ^ i7) & 65535;
    }

    public final int c() {
        int[] iArr = this.d;
        int i = iArr[0];
        int i2 = (iArr[1] >>> 7) | (iArr[2] << 9);
        int i3 = (iArr[2] >>> 6) | (iArr[3] << 10);
        return (((iArr[4] << 2) | (iArr[3] >>> 14)) ^ ((((((iArr[0] >>> 13) | (iArr[1] << 3)) ^ i) ^ i2) ^ i3) ^ ((iArr[3] >>> 3) | (iArr[4] << 13)))) & 65535;
    }

    public final int d() {
        int[] iArr = this.e;
        int i = iArr[0];
        int i2 = (iArr[0] >>> 9) | (iArr[1] << 7);
        int i3 = (iArr[0] >>> 14) | (iArr[1] << 2);
        int i4 = (iArr[0] >>> 15) | (iArr[1] << 1);
        int i5 = (iArr[1] >>> 5) | (iArr[2] << 11);
        int i6 = (iArr[1] >>> 12) | (iArr[2] << 4);
        int i7 = (iArr[2] >>> 1) | (iArr[3] << 15);
        int i8 = (iArr[2] >>> 5) | (iArr[3] << 11);
        int i9 = (iArr[2] >>> 13) | (iArr[3] << 3);
        int i10 = (iArr[3] >>> 4) | (iArr[4] << 12);
        int i11 = (iArr[3] >>> 12) | (iArr[4] << 4);
        int i12 = (iArr[4] << 1) | (iArr[3] >>> 15);
        int i13 = i12 & i11;
        int i14 = i11 & i10;
        int i15 = ((((i ^ (((((((((((iArr[3] >>> 14) | (iArr[4] << 2)) ^ i11) ^ i10) ^ i9) ^ i8) ^ i7) ^ i6) ^ i5) ^ i3) ^ i2)) ^ i13) ^ (i8 & i7)) ^ (i4 & i2)) ^ (i14 & i9);
        int i16 = i7 & i6 & i5;
        return (((((((((i12 & i9) & i6) & i2) ^ (i15 ^ i16)) ^ ((i14 & i8) & i7)) ^ ((i13 & i5) & i4)) ^ (((i13 & i10) & i9) & i8)) ^ ((i4 & i16) & i2)) ^ (((((i10 & i9) & i8) & i7) & i6) & i5)) & 65535;
    }

    public final int[] e(int[] iArr, int i) {
        iArr[0] = iArr[1];
        iArr[1] = iArr[2];
        iArr[2] = iArr[3];
        iArr[3] = iArr[4];
        iArr[4] = i;
        return iArr;
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "Grain v1";
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            if (iv == null || iv.length != 8) {
                throw new IllegalArgumentException("Grain v1 requires exactly 8 bytes of IV");
            } else if (parametersWithIV.getParameters() instanceof KeyParameter) {
                KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
                this.b = new byte[keyParameter.getKey().length];
                this.a = new byte[keyParameter.getKey().length];
                this.d = new int[5];
                this.e = new int[5];
                this.c = new byte[2];
                System.arraycopy(iv, 0, this.b, 0, iv.length);
                System.arraycopy(keyParameter.getKey(), 0, this.a, 0, keyParameter.getKey().length);
                reset();
            } else {
                throw new IllegalArgumentException("Grain v1 Init parameters must include a key");
            }
        } else {
            throw new IllegalArgumentException("Grain v1 Init parameters must include an IV");
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
        this.g = 2;
        byte[] bArr = this.a;
        byte[] bArr2 = this.b;
        bArr2[8] = -1;
        bArr2[9] = -1;
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
            int i3 = i2 + 1;
            iArr[i] = ((bArr3[i2] & 255) | (bArr3[i3] << 8)) & 65535;
            int[] iArr2 = this.d;
            byte[] bArr4 = this.b;
            iArr2[i] = ((bArr4[i2] & 255) | (bArr4[i3] << 8)) & 65535;
            i2 += 2;
            i++;
        }
        for (int i4 = 0; i4 < 10; i4++) {
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
