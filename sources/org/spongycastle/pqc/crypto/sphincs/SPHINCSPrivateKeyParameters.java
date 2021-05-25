package org.spongycastle.pqc.crypto.sphincs;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.util.Arrays;
public class SPHINCSPrivateKeyParameters extends AsymmetricKeyParameter {
    public final byte[] b;

    public SPHINCSPrivateKeyParameters(byte[] bArr) {
        super(true);
        this.b = Arrays.clone(bArr);
    }

    public byte[] getKeyData() {
        return Arrays.clone(this.b);
    }
}
