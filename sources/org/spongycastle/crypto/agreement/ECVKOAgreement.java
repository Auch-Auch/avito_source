package org.spongycastle.crypto.agreement;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithUKM;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.BigIntegers;
public class ECVKOAgreement {
    public final Digest a;
    public ECPrivateKeyParameters b;
    public BigInteger c;

    public ECVKOAgreement(Digest digest) {
        this.a = digest;
    }

    public byte[] calculateAgreement(CipherParameters cipherParameters) {
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) cipherParameters;
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        if (parameters.equals(this.b.getParameters())) {
            ECPoint normalize = eCPublicKeyParameters.getQ().multiply(parameters.getH().multiply(this.c).multiply(this.b.getD()).mod(parameters.getN())).normalize();
            if (!normalize.isInfinity()) {
                ECPoint normalize2 = normalize.normalize();
                BigInteger bigInteger = normalize2.getAffineXCoord().toBigInteger();
                BigInteger bigInteger2 = normalize2.getAffineYCoord().toBigInteger();
                int i = bigInteger.toByteArray().length > 33 ? 64 : 32;
                int i2 = i * 2;
                byte[] bArr = new byte[i2];
                byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(i, bigInteger);
                byte[] asUnsignedByteArray2 = BigIntegers.asUnsignedByteArray(i, bigInteger2);
                for (int i3 = 0; i3 != i; i3++) {
                    bArr[i3] = asUnsignedByteArray[(i - i3) - 1];
                }
                for (int i4 = 0; i4 != i; i4++) {
                    bArr[i + i4] = asUnsignedByteArray2[(i - i4) - 1];
                }
                this.a.update(bArr, 0, i2);
                byte[] bArr2 = new byte[this.a.getDigestSize()];
                this.a.doFinal(bArr2, 0);
                return bArr2;
            }
            throw new IllegalStateException("Infinity is not a valid agreement value for ECVKO");
        }
        throw new IllegalStateException("ECVKO public key has wrong domain parameters");
    }

    public int getFieldSize() {
        return (this.b.getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    public void init(CipherParameters cipherParameters) {
        ParametersWithUKM parametersWithUKM = (ParametersWithUKM) cipherParameters;
        this.b = (ECPrivateKeyParameters) parametersWithUKM.getParameters();
        byte[] ukm = parametersWithUKM.getUKM();
        int length = ukm.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = ukm[(ukm.length - i) - 1];
        }
        this.c = new BigInteger(1, bArr);
    }
}
