package org.spongycastle.crypto.agreement;

import java.math.BigInteger;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.math.ec.ECPoint;
public class ECDHCBasicAgreement implements BasicAgreement {
    public ECPrivateKeyParameters a;

    @Override // org.spongycastle.crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) cipherParameters;
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        if (parameters.equals(this.a.getParameters())) {
            ECPoint normalize = eCPublicKeyParameters.getQ().multiply(parameters.getH().multiply(this.a.getD()).mod(parameters.getN())).normalize();
            if (!normalize.isInfinity()) {
                return normalize.getAffineXCoord().toBigInteger();
            }
            throw new IllegalStateException("Infinity is not a valid agreement value for ECDHC");
        }
        throw new IllegalStateException("ECDHC public key has wrong domain parameters");
    }

    @Override // org.spongycastle.crypto.BasicAgreement
    public int getFieldSize() {
        return (this.a.getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    @Override // org.spongycastle.crypto.BasicAgreement
    public void init(CipherParameters cipherParameters) {
        this.a = (ECPrivateKeyParameters) cipherParameters;
    }
}
