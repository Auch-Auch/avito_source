package org.spongycastle.crypto.agreement;

import java.math.BigInteger;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.MQVPrivateParameters;
import org.spongycastle.crypto.params.MQVPublicParameters;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Properties;
public class ECMQVBasicAgreement implements BasicAgreement {
    public MQVPrivateParameters a;

    @Override // org.spongycastle.crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        if (!Properties.isOverrideSet("org.spongycastle.ec.disable_mqv")) {
            MQVPublicParameters mQVPublicParameters = (MQVPublicParameters) cipherParameters;
            ECPrivateKeyParameters staticPrivateKey = this.a.getStaticPrivateKey();
            ECDomainParameters parameters = staticPrivateKey.getParameters();
            if (parameters.equals(mQVPublicParameters.getStaticPublicKey().getParameters())) {
                ECPrivateKeyParameters ephemeralPrivateKey = this.a.getEphemeralPrivateKey();
                ECPublicKeyParameters ephemeralPublicKey = this.a.getEphemeralPublicKey();
                ECPublicKeyParameters staticPublicKey = mQVPublicParameters.getStaticPublicKey();
                ECPublicKeyParameters ephemeralPublicKey2 = mQVPublicParameters.getEphemeralPublicKey();
                BigInteger n = parameters.getN();
                int bitLength = (n.bitLength() + 1) / 2;
                BigInteger shiftLeft = ECConstants.ONE.shiftLeft(bitLength);
                ECCurve curve = parameters.getCurve();
                ECPoint[] eCPointArr = {ECAlgorithms.importPoint(curve, ephemeralPublicKey.getQ()), ECAlgorithms.importPoint(curve, staticPublicKey.getQ()), ECAlgorithms.importPoint(curve, ephemeralPublicKey2.getQ())};
                curve.normalizeAll(eCPointArr);
                ECPoint eCPoint = eCPointArr[0];
                ECPoint eCPoint2 = eCPointArr[1];
                ECPoint eCPoint3 = eCPointArr[2];
                BigInteger mod = staticPrivateKey.getD().multiply(eCPoint.getAffineXCoord().toBigInteger().mod(shiftLeft).setBit(bitLength)).add(ephemeralPrivateKey.getD()).mod(n);
                BigInteger bit = eCPoint3.getAffineXCoord().toBigInteger().mod(shiftLeft).setBit(bitLength);
                BigInteger mod2 = parameters.getH().multiply(mod).mod(n);
                ECPoint normalize = ECAlgorithms.sumOfTwoMultiplies(eCPoint2, bit.multiply(mod2).mod(n), eCPoint3, mod2).normalize();
                if (!normalize.isInfinity()) {
                    return normalize.getAffineXCoord().toBigInteger();
                }
                throw new IllegalStateException("Infinity is not a valid agreement value for MQV");
            }
            throw new IllegalStateException("ECMQV public key components have wrong domain parameters");
        }
        throw new IllegalStateException("ECMQV explicitly disabled");
    }

    @Override // org.spongycastle.crypto.BasicAgreement
    public int getFieldSize() {
        return (this.a.getStaticPrivateKey().getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    @Override // org.spongycastle.crypto.BasicAgreement
    public void init(CipherParameters cipherParameters) {
        this.a = (MQVPrivateParameters) cipherParameters;
    }
}
