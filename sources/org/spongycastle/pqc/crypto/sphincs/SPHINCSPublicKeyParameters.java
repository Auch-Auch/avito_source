package org.spongycastle.pqc.crypto.sphincs;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.util.Arrays;
public class SPHINCSPublicKeyParameters extends AsymmetricKeyParameter {
    public final byte[] b;

    public SPHINCSPublicKeyParameters(byte[] bArr) {
        super(false);
        this.b = Arrays.clone(bArr);
    }

    public byte[] getKeyData() {
        return Arrays.clone(this.b);
    }
}
