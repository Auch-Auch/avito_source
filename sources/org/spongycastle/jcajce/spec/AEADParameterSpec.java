package org.spongycastle.jcajce.spec;

import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.util.Arrays;
public class AEADParameterSpec extends IvParameterSpec {
    public final byte[] a;
    public final int b;

    public AEADParameterSpec(byte[] bArr, int i) {
        this(bArr, i, null);
    }

    public byte[] getAssociatedData() {
        return Arrays.clone(this.a);
    }

    public int getMacSizeInBits() {
        return this.b;
    }

    public byte[] getNonce() {
        return getIV();
    }

    public AEADParameterSpec(byte[] bArr, int i, byte[] bArr2) {
        super(bArr);
        this.b = i;
        this.a = Arrays.clone(bArr2);
    }
}
