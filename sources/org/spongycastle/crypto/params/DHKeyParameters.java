package org.spongycastle.crypto.params;
public class DHKeyParameters extends AsymmetricKeyParameter {
    public DHParameters b;

    public DHKeyParameters(boolean z, DHParameters dHParameters) {
        super(z);
        this.b = dHParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHKeyParameters)) {
            return false;
        }
        DHKeyParameters dHKeyParameters = (DHKeyParameters) obj;
        DHParameters dHParameters = this.b;
        if (dHParameters != null) {
            return dHParameters.equals(dHKeyParameters.getParameters());
        }
        if (dHKeyParameters.getParameters() == null) {
            return true;
        }
        return false;
    }

    public DHParameters getParameters() {
        return this.b;
    }

    public int hashCode() {
        int i = !isPrivate();
        DHParameters dHParameters = this.b;
        return dHParameters != null ? i ^ dHParameters.hashCode() : i;
    }
}
