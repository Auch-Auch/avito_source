package org.spongycastle.pqc.crypto.newhope;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.util.Arrays;
public class NHPublicKeyParameters extends AsymmetricKeyParameter {
    public final byte[] b;

    public NHPublicKeyParameters(byte[] bArr) {
        super(false);
        this.b = Arrays.clone(bArr);
    }

    public byte[] getPubData() {
        return Arrays.clone(this.b);
    }
}
