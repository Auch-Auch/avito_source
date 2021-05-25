package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SM3Digest;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithID;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.FixedPointCombMultiplier;
import org.spongycastle.util.BigIntegers;
public class SM2Signer implements DSA, ECConstants {
    public final DSAKCalculator a = new RandomDSAKCalculator();
    public byte[] b;
    public int c;
    public ECDomainParameters d;
    public ECPoint e;
    public ECKeyParameters f;

    public final void a(Digest digest, ECFieldElement eCFieldElement) {
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.c, eCFieldElement.toBigInteger());
        digest.update(asUnsignedByteArray, 0, asUnsignedByteArray.length);
    }

    public final byte[] b(Digest digest) {
        byte[] bArr = this.b;
        int length = bArr.length * 8;
        digest.update((byte) ((length >> 8) & 255));
        digest.update((byte) (length & 255));
        digest.update(bArr, 0, bArr.length);
        a(digest, this.d.getCurve().getA());
        a(digest, this.d.getCurve().getB());
        a(digest, this.d.getG().getAffineXCoord());
        a(digest, this.d.getG().getAffineYCoord());
        a(digest, this.e.getAffineXCoord());
        a(digest, this.e.getAffineYCoord());
        byte[] bArr2 = new byte[digest.getDigestSize()];
        digest.doFinal(bArr2, 0);
        return bArr2;
    }

    public BigInteger calculateE(byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    @Override // org.spongycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        SM3Digest sM3Digest = new SM3Digest();
        byte[] b2 = b(sM3Digest);
        sM3Digest.update(b2, 0, b2.length);
        sM3Digest.update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[sM3Digest.getDigestSize()];
        sM3Digest.doFinal(bArr2, 0);
        BigInteger n = this.d.getN();
        BigInteger calculateE = calculateE(bArr2);
        BigInteger d2 = ((ECPrivateKeyParameters) this.f).getD();
        ECMultiplier createBasePointMultiplier = createBasePointMultiplier();
        while (true) {
            BigInteger nextK = this.a.nextK();
            BigInteger mod = calculateE.add(createBasePointMultiplier.multiply(this.d.getG(), nextK).normalize().getAffineXCoord().toBigInteger()).mod(n);
            Object obj = ECConstants.ZERO;
            if (!mod.equals(obj) && !mod.add(nextK).equals(n)) {
                BigInteger mod2 = d2.add(ECConstants.ONE).modInverse(n).multiply(nextK.subtract(mod.multiply(d2)).mod(n)).mod(n);
                if (!mod2.equals(obj)) {
                    return new BigInteger[]{mod, mod2};
                }
            }
        }
    }

    @Override // org.spongycastle.crypto.DSA
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters;
            CipherParameters parameters = parametersWithID.getParameters();
            this.b = parametersWithID.getID();
            cipherParameters = parameters;
        } else {
            this.b = new byte[0];
        }
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                ECKeyParameters eCKeyParameters = (ECKeyParameters) parametersWithRandom.getParameters();
                this.f = eCKeyParameters;
                ECDomainParameters parameters2 = eCKeyParameters.getParameters();
                this.d = parameters2;
                this.a.init(parameters2.getN(), parametersWithRandom.getRandom());
            } else {
                ECKeyParameters eCKeyParameters2 = (ECKeyParameters) cipherParameters;
                this.f = eCKeyParameters2;
                ECDomainParameters parameters3 = eCKeyParameters2.getParameters();
                this.d = parameters3;
                this.a.init(parameters3.getN(), new SecureRandom());
            }
            this.e = this.d.getG().multiply(((ECPrivateKeyParameters) this.f).getD()).normalize();
        } else {
            ECKeyParameters eCKeyParameters3 = (ECKeyParameters) cipherParameters;
            this.f = eCKeyParameters3;
            this.d = eCKeyParameters3.getParameters();
            this.e = ((ECPublicKeyParameters) this.f).getQ();
        }
        this.c = (this.d.getCurve().getFieldSize() + 7) / 8;
    }

    @Override // org.spongycastle.crypto.DSA
    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger n = this.d.getN();
        BigInteger bigInteger3 = ECConstants.ONE;
        if (bigInteger.compareTo(bigInteger3) < 0 || bigInteger.compareTo(n) >= 0 || bigInteger2.compareTo(bigInteger3) < 0 || bigInteger2.compareTo(n) >= 0) {
            return false;
        }
        ECPoint q = ((ECPublicKeyParameters) this.f).getQ();
        SM3Digest sM3Digest = new SM3Digest();
        byte[] b2 = b(sM3Digest);
        sM3Digest.update(b2, 0, b2.length);
        sM3Digest.update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[sM3Digest.getDigestSize()];
        sM3Digest.doFinal(bArr2, 0);
        BigInteger calculateE = calculateE(bArr2);
        BigInteger mod = bigInteger.add(bigInteger2).mod(n);
        if (mod.equals(ECConstants.ZERO)) {
            return false;
        }
        return bigInteger.equals(calculateE.add(this.d.getG().multiply(bigInteger2).add(q.multiply(mod)).normalize().getAffineXCoord().toBigInteger()).mod(n));
    }
}
