package org.spongycastle.crypto.ec;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.FixedPointCombMultiplier;
public class ECNewPublicKeyTransform implements ECPairTransform {
    public ECPublicKeyParameters a;
    public SecureRandom b;

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    @Override // org.spongycastle.crypto.ec.ECPairTransform
    public void init(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            if (parametersWithRandom.getParameters() instanceof ECPublicKeyParameters) {
                this.a = (ECPublicKeyParameters) parametersWithRandom.getParameters();
                this.b = parametersWithRandom.getRandom();
                return;
            }
            throw new IllegalArgumentException("ECPublicKeyParameters are required for new public key transform.");
        } else if (cipherParameters instanceof ECPublicKeyParameters) {
            this.a = (ECPublicKeyParameters) cipherParameters;
            this.b = new SecureRandom();
        } else {
            throw new IllegalArgumentException("ECPublicKeyParameters are required for new public key transform.");
        }
    }

    @Override // org.spongycastle.crypto.ec.ECPairTransform
    public ECPair transform(ECPair eCPair) {
        ECPublicKeyParameters eCPublicKeyParameters = this.a;
        if (eCPublicKeyParameters != null) {
            ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
            BigInteger n = parameters.getN();
            ECMultiplier createBasePointMultiplier = createBasePointMultiplier();
            BigInteger p0 = AppCompatDelegateImpl.i.p0(n, this.b);
            ECPoint[] eCPointArr = {createBasePointMultiplier.multiply(parameters.getG(), p0), this.a.getQ().multiply(p0).add(eCPair.getY())};
            parameters.getCurve().normalizeAll(eCPointArr);
            return new ECPair(eCPointArr[0], eCPointArr[1]);
        }
        throw new IllegalStateException("ECNewPublicKeyTransform not initialised");
    }
}
