package org.spongycastle.crypto.params;
public class CramerShoupKeyParameters extends AsymmetricKeyParameter {
    public CramerShoupParameters b;

    public CramerShoupKeyParameters(boolean z, CramerShoupParameters cramerShoupParameters) {
        super(z);
        this.b = cramerShoupParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupKeyParameters)) {
            return false;
        }
        CramerShoupKeyParameters cramerShoupKeyParameters = (CramerShoupKeyParameters) obj;
        CramerShoupParameters cramerShoupParameters = this.b;
        if (cramerShoupParameters != null) {
            return cramerShoupParameters.equals(cramerShoupKeyParameters.getParameters());
        }
        if (cramerShoupKeyParameters.getParameters() == null) {
            return true;
        }
        return false;
    }

    public CramerShoupParameters getParameters() {
        return this.b;
    }

    public int hashCode() {
        int i = !isPrivate();
        CramerShoupParameters cramerShoupParameters = this.b;
        return cramerShoupParameters != null ? i ^ cramerShoupParameters.hashCode() : i;
    }
}
