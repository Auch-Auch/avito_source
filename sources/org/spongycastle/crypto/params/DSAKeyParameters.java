package org.spongycastle.crypto.params;
public class DSAKeyParameters extends AsymmetricKeyParameter {
    public DSAParameters b;

    public DSAKeyParameters(boolean z, DSAParameters dSAParameters) {
        super(z);
        this.b = dSAParameters;
    }

    public DSAParameters getParameters() {
        return this.b;
    }
}
