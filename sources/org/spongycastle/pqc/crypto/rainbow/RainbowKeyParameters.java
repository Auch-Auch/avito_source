package org.spongycastle.pqc.crypto.rainbow;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;
public class RainbowKeyParameters extends AsymmetricKeyParameter {
    public int b;

    public RainbowKeyParameters(boolean z, int i) {
        super(z);
        this.b = i;
    }

    public int getDocLength() {
        return this.b;
    }
}
