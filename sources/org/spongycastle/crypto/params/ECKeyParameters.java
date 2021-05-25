package org.spongycastle.crypto.params;
public class ECKeyParameters extends AsymmetricKeyParameter {
    public ECDomainParameters b;

    public ECKeyParameters(boolean z, ECDomainParameters eCDomainParameters) {
        super(z);
        this.b = eCDomainParameters;
    }

    public ECDomainParameters getParameters() {
        return this.b;
    }
}
