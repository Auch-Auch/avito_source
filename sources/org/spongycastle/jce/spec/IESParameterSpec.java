package org.spongycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.util.Arrays;
public class IESParameterSpec implements AlgorithmParameterSpec {
    public byte[] a;
    public byte[] b;
    public int c;
    public int d;
    public byte[] e;
    public boolean f;

    public IESParameterSpec(byte[] bArr, byte[] bArr2, int i) {
        this(bArr, bArr2, i, -1, null, false);
    }

    public int getCipherKeySize() {
        return this.d;
    }

    public byte[] getDerivationV() {
        return Arrays.clone(this.a);
    }

    public byte[] getEncodingV() {
        return Arrays.clone(this.b);
    }

    public int getMacKeySize() {
        return this.c;
    }

    public byte[] getNonce() {
        return Arrays.clone(this.e);
    }

    public boolean getPointCompression() {
        return this.f;
    }

    public void setPointCompression(boolean z) {
        this.f = z;
    }

    public IESParameterSpec(byte[] bArr, byte[] bArr2, int i, int i2, byte[] bArr3) {
        this(bArr, bArr2, i, i2, bArr3, false);
    }

    public IESParameterSpec(byte[] bArr, byte[] bArr2, int i, int i2, byte[] bArr3, boolean z) {
        if (bArr != null) {
            byte[] bArr4 = new byte[bArr.length];
            this.a = bArr4;
            System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        } else {
            this.a = null;
        }
        if (bArr2 != null) {
            byte[] bArr5 = new byte[bArr2.length];
            this.b = bArr5;
            System.arraycopy(bArr2, 0, bArr5, 0, bArr2.length);
        } else {
            this.b = null;
        }
        this.c = i;
        this.d = i2;
        this.e = Arrays.clone(bArr3);
        this.f = z;
    }
}
