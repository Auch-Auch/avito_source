package org.spongycastle.crypto.params;
public class ElGamalKeyParameters extends AsymmetricKeyParameter {
    public ElGamalParameters b;

    public ElGamalKeyParameters(boolean z, ElGamalParameters elGamalParameters) {
        super(z);
        this.b = elGamalParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ElGamalKeyParameters)) {
            return false;
        }
        ElGamalKeyParameters elGamalKeyParameters = (ElGamalKeyParameters) obj;
        ElGamalParameters elGamalParameters = this.b;
        if (elGamalParameters != null) {
            return elGamalParameters.equals(elGamalKeyParameters.getParameters());
        }
        if (elGamalKeyParameters.getParameters() == null) {
            return true;
        }
        return false;
    }

    public ElGamalParameters getParameters() {
        return this.b;
    }

    public int hashCode() {
        ElGamalParameters elGamalParameters = this.b;
        if (elGamalParameters != null) {
            return elGamalParameters.hashCode();
        }
        return 0;
    }
}
