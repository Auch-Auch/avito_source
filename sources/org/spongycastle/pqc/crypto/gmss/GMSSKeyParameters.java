package org.spongycastle.pqc.crypto.gmss;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;
public class GMSSKeyParameters extends AsymmetricKeyParameter {
    public GMSSParameters b;

    public GMSSKeyParameters(boolean z, GMSSParameters gMSSParameters) {
        super(z);
        this.b = gMSSParameters;
    }

    public GMSSParameters getParameters() {
        return this.b;
    }
}
