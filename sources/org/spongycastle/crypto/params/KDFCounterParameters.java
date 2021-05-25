package org.spongycastle.crypto.params;

import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.util.Arrays;
public final class KDFCounterParameters implements DerivationParameters {
    public byte[] a;
    public byte[] b;
    public byte[] c;
    public int d;

    public KDFCounterParameters(byte[] bArr, byte[] bArr2, int i) {
        this(bArr, null, bArr2, i);
    }

    public byte[] getFixedInputData() {
        return Arrays.clone(this.c);
    }

    public byte[] getFixedInputDataCounterPrefix() {
        return Arrays.clone(this.b);
    }

    public byte[] getFixedInputDataCounterSuffix() {
        return Arrays.clone(this.c);
    }

    public byte[] getKI() {
        return this.a;
    }

    public int getR() {
        return this.d;
    }

    public KDFCounterParameters(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        if (bArr != null) {
            this.a = Arrays.clone(bArr);
            if (bArr2 == null) {
                this.b = new byte[0];
            } else {
                this.b = Arrays.clone(bArr2);
            }
            if (bArr3 == null) {
                this.c = new byte[0];
            } else {
                this.c = Arrays.clone(bArr3);
            }
            if (i == 8 || i == 16 || i == 24 || i == 32) {
                this.d = i;
                return;
            }
            throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
        }
        throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
    }
}
