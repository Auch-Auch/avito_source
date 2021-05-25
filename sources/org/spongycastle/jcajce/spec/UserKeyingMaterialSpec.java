package org.spongycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.util.Arrays;
public class UserKeyingMaterialSpec implements AlgorithmParameterSpec {
    public final byte[] a;

    public UserKeyingMaterialSpec(byte[] bArr) {
        this.a = Arrays.clone(bArr);
    }

    public byte[] getUserKeyingMaterial() {
        return Arrays.clone(this.a);
    }
}
