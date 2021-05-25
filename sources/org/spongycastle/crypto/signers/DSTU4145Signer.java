package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.FixedPointCombMultiplier;
import org.spongycastle.util.Arrays;
public class DSTU4145Signer implements DSA {
    public static final BigInteger c = BigInteger.valueOf(1);
    public ECKeyParameters a;
    public SecureRandom b;

    public static BigInteger a(BigInteger bigInteger, ECFieldElement eCFieldElement) {
        BigInteger bigInteger2 = eCFieldElement.toBigInteger();
        int bitLength = bigInteger.bitLength() - 1;
        return bigInteger2.bitLength() > bitLength ? bigInteger2.mod(c.shiftLeft(bitLength)) : bigInteger2;
    }

    public static ECFieldElement b(ECCurve eCCurve, byte[] bArr) {
        BigInteger bigInteger = new BigInteger(1, Arrays.reverse(bArr));
        int fieldSize = eCCurve.getFieldSize();
        if (bigInteger.bitLength() > fieldSize) {
            bigInteger = bigInteger.mod(c.shiftLeft(fieldSize));
        }
        return eCCurve.fromBigInteger(bigInteger);
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    @Override // org.spongycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        ECDomainParameters parameters = this.a.getParameters();
        ECCurve curve = parameters.getCurve();
        ECFieldElement b2 = b(curve, bArr);
        if (b2.isZero()) {
            b2 = curve.fromBigInteger(c);
        }
        BigInteger n = parameters.getN();
        BigInteger d = ((ECPrivateKeyParameters) this.a).getD();
        ECMultiplier createBasePointMultiplier = createBasePointMultiplier();
        while (true) {
            BigInteger bigInteger = new BigInteger(n.bitLength() - 1, this.b);
            ECFieldElement affineXCoord = createBasePointMultiplier.multiply(parameters.getG(), bigInteger).normalize().getAffineXCoord();
            if (!affineXCoord.isZero()) {
                BigInteger a3 = a(n, b2.multiply(affineXCoord));
                if (a3.signum() != 0) {
                    BigInteger mod = a3.multiply(d).add(bigInteger).mod(n);
                    if (mod.signum() != 0) {
                        return new BigInteger[]{a3, mod};
                    }
                } else {
                    continue;
                }
            }
        }
    }

    @Override // org.spongycastle.crypto.DSA
    public void init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.b = parametersWithRandom.getRandom();
                cipherParameters = parametersWithRandom.getParameters();
            } else {
                this.b = new SecureRandom();
            }
            this.a = (ECPrivateKeyParameters) cipherParameters;
            return;
        }
        this.a = (ECPublicKeyParameters) cipherParameters;
    }

    @Override // org.spongycastle.crypto.DSA
    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger.signum() <= 0 || bigInteger2.signum() <= 0) {
            return false;
        }
        ECDomainParameters parameters = this.a.getParameters();
        BigInteger n = parameters.getN();
        if (bigInteger.compareTo(n) >= 0 || bigInteger2.compareTo(n) >= 0) {
            return false;
        }
        ECCurve curve = parameters.getCurve();
        ECFieldElement b2 = b(curve, bArr);
        if (b2.isZero()) {
            b2 = curve.fromBigInteger(c);
        }
        ECPoint normalize = ECAlgorithms.sumOfTwoMultiplies(parameters.getG(), bigInteger2, ((ECPublicKeyParameters) this.a).getQ(), bigInteger).normalize();
        if (!normalize.isInfinity() && a(n, b2.multiply(normalize.getAffineXCoord())).compareTo(bigInteger) == 0) {
            return true;
        }
        return false;
    }
}
