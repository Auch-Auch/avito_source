package org.spongycastle.crypto.macs;

import a2.b.a.a.a;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithSBox;
public class GOST28147Mac implements Mac {
    public int a = 8;
    public int b = 4;
    public int c = 0;
    public byte[] d = new byte[8];
    public byte[] e = new byte[8];
    public boolean f = true;
    public int[] g = null;
    public byte[] h = null;
    public byte[] i = {9, 6, 3, 2, 8, Ascii.VT, 1, 7, 10, 4, Ascii.SO, Ascii.SI, Ascii.FF, 0, Ascii.CR, 5, 3, 7, Ascii.SO, 9, 8, 10, Ascii.SI, 0, 5, 2, 6, Ascii.FF, Ascii.VT, 4, Ascii.CR, 1, Ascii.SO, 4, 6, 2, Ascii.VT, 3, Ascii.CR, 8, Ascii.FF, Ascii.SI, 5, 10, 0, 7, 1, 9, Ascii.SO, 7, 10, Ascii.FF, Ascii.CR, 1, 3, 9, 0, 2, Ascii.VT, 4, Ascii.SI, 8, 5, 6, Ascii.VT, 5, 1, 9, 8, Ascii.CR, Ascii.SI, 0, Ascii.SO, 4, 2, 3, Ascii.FF, 7, 10, 6, 3, 10, Ascii.CR, Ascii.FF, 1, 2, 0, Ascii.VT, 7, 5, 9, 4, 8, Ascii.SI, Ascii.SO, 6, 1, Ascii.CR, 2, 9, 7, 10, 6, 0, 8, Ascii.FF, 4, 5, Ascii.SI, 3, Ascii.VT, Ascii.SO, Ascii.VT, 10, Ascii.SI, 5, 0, Ascii.FF, Ascii.SO, 8, 6, 2, 3, 9, 1, 7, Ascii.CR, 4};

    public final byte[] a(byte[] bArr, int i2, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length - i2)];
        System.arraycopy(bArr, i2, bArr3, 0, bArr2.length);
        for (int i3 = 0; i3 != bArr2.length; i3++) {
            bArr3[i3] = (byte) (bArr3[i3] ^ bArr2[i3]);
        }
        return bArr3;
    }

    public final int b(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK) + ((bArr[i2 + 2] << Ascii.DLE) & 16711680) + ((bArr[i2 + 1] << 8) & 65280) + (bArr[i2] & 255);
    }

    public final int[] c(byte[] bArr) {
        if (bArr.length == 32) {
            int[] iArr = new int[8];
            for (int i2 = 0; i2 != 8; i2++) {
                iArr[i2] = b(bArr, i2 * 4);
            }
            return iArr;
        }
        throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
    }

    public final void d(int[] iArr, byte[] bArr, int i2, byte[] bArr2, int i3) {
        int b2 = b(bArr, i2);
        int b3 = b(bArr, i2 + 4);
        for (int i4 = 0; i4 < 2; i4++) {
            int i5 = 0;
            while (i5 < 8) {
                int i6 = iArr[i5] + b2;
                byte[] bArr3 = this.i;
                int i7 = (bArr3[((i6 >> 0) & 15) + 0] << 0) + (bArr3[((i6 >> 4) & 15) + 16] << 4) + (bArr3[((i6 >> 8) & 15) + 32] << 8) + (bArr3[((i6 >> 12) & 15) + 48] << Ascii.FF) + (bArr3[((i6 >> 16) & 15) + 64] << Ascii.DLE) + (bArr3[((i6 >> 20) & 15) + 80] << Ascii.DC4) + (bArr3[((i6 >> 24) & 15) + 96] << Ascii.CAN) + (bArr3[((i6 >> 28) & 15) + 112] << Ascii.FS);
                i5++;
                b2 = b3 ^ ((i7 << 11) | (i7 >>> 21));
                b3 = b2;
            }
        }
        e(b2, bArr2, i3);
        e(b3, bArr2, i3 + 4);
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i2) throws DataLengthException, IllegalStateException {
        while (true) {
            int i3 = this.c;
            if (i3 >= this.a) {
                break;
            }
            this.d[i3] = 0;
            this.c = i3 + 1;
        }
        byte[] bArr2 = this.d;
        byte[] bArr3 = new byte[bArr2.length];
        System.arraycopy(bArr2, 0, bArr3, 0, this.e.length);
        if (this.f) {
            this.f = false;
        } else {
            bArr3 = a(this.d, 0, this.e);
        }
        d(this.g, bArr3, 0, this.e, 0);
        byte[] bArr4 = this.e;
        int i4 = this.b;
        System.arraycopy(bArr4, (bArr4.length / 2) - i4, bArr, i2, i4);
        reset();
        return this.b;
    }

    public final void e(int i2, byte[] bArr, int i3) {
        bArr[i3 + 3] = (byte) (i2 >>> 24);
        bArr[i3 + 2] = (byte) (i2 >>> 16);
        bArr[i3 + 1] = (byte) (i2 >>> 8);
        bArr[i3] = (byte) i2;
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        return "GOST28147Mac";
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return this.b;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        reset();
        this.d = new byte[this.a];
        this.h = null;
        if (cipherParameters instanceof ParametersWithSBox) {
            ParametersWithSBox parametersWithSBox = (ParametersWithSBox) cipherParameters;
            System.arraycopy(parametersWithSBox.getSBox(), 0, this.i, 0, parametersWithSBox.getSBox().length);
            if (parametersWithSBox.getParameters() != null) {
                this.g = c(((KeyParameter) parametersWithSBox.getParameters()).getKey());
            }
        } else if (cipherParameters instanceof KeyParameter) {
            this.g = c(((KeyParameter) cipherParameters).getKey());
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.g = c(((KeyParameter) parametersWithIV.getParameters()).getKey());
            byte[] iv = parametersWithIV.getIV();
            byte[] bArr = this.e;
            System.arraycopy(iv, 0, bArr, 0, bArr.length);
            this.h = parametersWithIV.getIV();
        } else {
            throw new IllegalArgumentException(a.E(cipherParameters, a.L("invalid parameter passed to GOST28147 init - ")));
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.d;
            if (i2 < bArr.length) {
                bArr[i2] = 0;
                i2++;
            } else {
                this.c = 0;
                this.f = true;
                return;
            }
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b2) throws IllegalStateException {
        int i2 = this.c;
        byte[] bArr = this.d;
        if (i2 == bArr.length) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, this.e.length);
            if (this.f) {
                this.f = false;
                byte[] bArr3 = this.h;
                if (bArr3 != null) {
                    bArr2 = a(this.d, 0, bArr3);
                }
            } else {
                bArr2 = a(this.d, 0, this.e);
            }
            d(this.g, bArr2, 0, this.e, 0);
            this.c = 0;
        }
        byte[] bArr4 = this.d;
        int i3 = this.c;
        this.c = i3 + 1;
        bArr4[i3] = b2;
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i2, int i3) throws DataLengthException, IllegalStateException {
        if (i3 >= 0) {
            int i4 = this.a;
            int i5 = this.c;
            int i6 = i4 - i5;
            if (i3 > i6) {
                System.arraycopy(bArr, i2, this.d, i5, i6);
                byte[] bArr2 = this.d;
                byte[] bArr3 = new byte[bArr2.length];
                System.arraycopy(bArr2, 0, bArr3, 0, this.e.length);
                if (this.f) {
                    this.f = false;
                    byte[] bArr4 = this.h;
                    if (bArr4 != null) {
                        bArr3 = a(this.d, 0, bArr4);
                    }
                } else {
                    bArr3 = a(this.d, 0, this.e);
                }
                d(this.g, bArr3, 0, this.e, 0);
                this.c = 0;
                while (true) {
                    i3 -= i6;
                    i2 += i6;
                    if (i3 <= this.a) {
                        break;
                    }
                    d(this.g, a(bArr, i2, this.e), 0, this.e, 0);
                    i6 = this.a;
                }
            }
            System.arraycopy(bArr, i2, this.d, this.c, i3);
            this.c += i3;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
