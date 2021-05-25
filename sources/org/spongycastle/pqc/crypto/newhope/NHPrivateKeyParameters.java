package org.spongycastle.pqc.crypto.newhope;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.util.Arrays;
public class NHPrivateKeyParameters extends AsymmetricKeyParameter {
    public final short[] b;

    public NHPrivateKeyParameters(short[] sArr) {
        super(true);
        this.b = Arrays.clone(sArr);
    }

    public short[] getSecData() {
        return Arrays.clone(this.b);
    }
}
