package org.spongycastle.crypto.agreement;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SM3Digest;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ParametersWithID;
import org.spongycastle.crypto.params.SM2KeyExchangePrivateParameters;
import org.spongycastle.crypto.params.SM2KeyExchangePublicParameters;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
public class SM2KeyExchange {
    public final Digest a;
    public byte[] b;
    public ECPrivateKeyParameters c;
    public ECPoint d;
    public ECPoint e;
    public ECDomainParameters f;
    public int g;
    public int h;
    public ECPrivateKeyParameters i;
    public boolean j;

    public SM2KeyExchange() {
        this(new SM3Digest());
    }

    public final byte[] a(Digest digest, ECPoint eCPoint, byte[] bArr) {
        byte[] bArr2 = new byte[digest.getDigestSize()];
        digest.update((byte) 2);
        c(digest, eCPoint.getAffineYCoord());
        digest.update(bArr, 0, bArr.length);
        digest.doFinal(bArr2, 0);
        return bArr2;
    }

    public final byte[] b(Digest digest, ECPoint eCPoint, byte[] bArr) {
        byte[] bArr2 = new byte[digest.getDigestSize()];
        digest.update((byte) 3);
        c(digest, eCPoint.getAffineYCoord());
        digest.update(bArr, 0, bArr.length);
        digest.doFinal(bArr2, 0);
        return bArr2;
    }

    public final void c(Digest digest, ECFieldElement eCFieldElement) {
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.g, eCFieldElement.toBigInteger());
        digest.update(asUnsignedByteArray, 0, asUnsignedByteArray.length);
    }

    public byte[] calculateKey(int i2, CipherParameters cipherParameters) {
        byte[] bArr;
        SM2KeyExchangePublicParameters sM2KeyExchangePublicParameters;
        if (cipherParameters instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters;
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) parametersWithID.getParameters();
            bArr = parametersWithID.getID();
        } else {
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) cipherParameters;
            bArr = new byte[0];
        }
        byte[] f2 = f(this.a, this.b, this.d);
        byte[] f3 = f(this.a, bArr, sM2KeyExchangePublicParameters.getStaticPublicKey().getQ());
        ECPoint e2 = e(sM2KeyExchangePublicParameters);
        if (this.j) {
            return g(e2, f2, f3, i2);
        }
        return g(e2, f3, f2, i2);
    }

    public byte[][] calculateKeyWithConfirmation(int i2, byte[] bArr, CipherParameters cipherParameters) {
        SM2KeyExchangePublicParameters sM2KeyExchangePublicParameters;
        byte[] bArr2;
        if (cipherParameters instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters;
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) parametersWithID.getParameters();
            bArr2 = parametersWithID.getID();
        } else {
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) cipherParameters;
            bArr2 = new byte[0];
        }
        if (!this.j || bArr != null) {
            byte[] f2 = f(this.a, this.b, this.d);
            byte[] f3 = f(this.a, bArr2, sM2KeyExchangePublicParameters.getStaticPublicKey().getQ());
            ECPoint e2 = e(sM2KeyExchangePublicParameters);
            if (this.j) {
                byte[] g2 = g(e2, f2, f3, i2);
                byte[] d2 = d(this.a, e2, f2, f3, this.e, sM2KeyExchangePublicParameters.getEphemeralPublicKey().getQ());
                if (Arrays.constantTimeAreEqual(a(this.a, e2, d2), bArr)) {
                    return new byte[][]{g2, b(this.a, e2, d2)};
                }
                throw new IllegalStateException("confirmation tag mismatch");
            }
            byte[] g3 = g(e2, f3, f2, i2);
            byte[] d3 = d(this.a, e2, f3, f2, sM2KeyExchangePublicParameters.getEphemeralPublicKey().getQ(), this.e);
            return new byte[][]{g3, a(this.a, e2, d3), b(this.a, e2, d3)};
        }
        throw new IllegalArgumentException("if initiating, confirmationTag must be set");
    }

    public final byte[] d(Digest digest, ECPoint eCPoint, byte[] bArr, byte[] bArr2, ECPoint eCPoint2, ECPoint eCPoint3) {
        c(digest, eCPoint.getAffineXCoord());
        digest.update(bArr, 0, bArr.length);
        digest.update(bArr2, 0, bArr2.length);
        c(digest, eCPoint2.getAffineXCoord());
        c(digest, eCPoint2.getAffineYCoord());
        c(digest, eCPoint3.getAffineXCoord());
        c(digest, eCPoint3.getAffineYCoord());
        byte[] bArr3 = new byte[digest.getDigestSize()];
        digest.doFinal(bArr3, 0);
        return bArr3;
    }

    public final ECPoint e(SM2KeyExchangePublicParameters sM2KeyExchangePublicParameters) {
        BigInteger mod = this.c.getD().add(h(this.e.getAffineXCoord().toBigInteger()).multiply(this.i.getD())).mod(this.f.getN());
        return sM2KeyExchangePublicParameters.getStaticPublicKey().getQ().add(sM2KeyExchangePublicParameters.getEphemeralPublicKey().getQ().multiply(h(sM2KeyExchangePublicParameters.getEphemeralPublicKey().getQ().getAffineXCoord().toBigInteger())).normalize()).normalize().multiply(this.f.getH().multiply(mod)).normalize();
    }

    public final byte[] f(Digest digest, byte[] bArr, ECPoint eCPoint) {
        int length = bArr.length * 8;
        digest.update((byte) ((length >> 8) & 255));
        digest.update((byte) (length & 255));
        digest.update(bArr, 0, bArr.length);
        c(digest, this.f.getCurve().getA());
        c(digest, this.f.getCurve().getB());
        c(digest, this.f.getG().getAffineXCoord());
        c(digest, this.f.getG().getAffineYCoord());
        c(digest, eCPoint.getAffineXCoord());
        c(digest, eCPoint.getAffineYCoord());
        byte[] bArr2 = new byte[digest.getDigestSize()];
        digest.doFinal(bArr2, 0);
        return bArr2;
    }

    public final byte[] g(ECPoint eCPoint, byte[] bArr, byte[] bArr2, int i2) {
        int digestSize = this.a.getDigestSize() * 8;
        int digestSize2 = this.a.getDigestSize();
        byte[] bArr3 = new byte[digestSize2];
        int i3 = (i2 + 7) / 8;
        byte[] bArr4 = new byte[i3];
        int i4 = 1;
        int i5 = 1;
        int i6 = 0;
        while (i4 <= ((i2 + digestSize) - 1) / digestSize) {
            c(this.a, eCPoint.getAffineXCoord());
            c(this.a, eCPoint.getAffineYCoord());
            this.a.update(bArr, 0, bArr.length);
            this.a.update(bArr2, 0, bArr2.length);
            this.a.update((byte) (i5 >> 24));
            this.a.update((byte) (i5 >> 16));
            this.a.update((byte) (i5 >> 8));
            this.a.update((byte) i5);
            this.a.doFinal(bArr3, 0);
            int i7 = i6 + digestSize2;
            if (i7 < i3) {
                System.arraycopy(bArr3, 0, bArr4, i6, digestSize2);
            } else {
                System.arraycopy(bArr3, 0, bArr4, i6, i3 - i6);
            }
            i5++;
            i4++;
            i6 = i7;
        }
        return bArr4;
    }

    public int getFieldSize() {
        return (this.c.getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    public final BigInteger h(BigInteger bigInteger) {
        return bigInteger.and(BigInteger.valueOf(1).shiftLeft(this.h).subtract(BigInteger.valueOf(1))).setBit(this.h);
    }

    public void init(CipherParameters cipherParameters) {
        SM2KeyExchangePrivateParameters sM2KeyExchangePrivateParameters;
        if (cipherParameters instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters;
            sM2KeyExchangePrivateParameters = (SM2KeyExchangePrivateParameters) parametersWithID.getParameters();
            this.b = parametersWithID.getID();
        } else {
            sM2KeyExchangePrivateParameters = (SM2KeyExchangePrivateParameters) cipherParameters;
            this.b = new byte[0];
        }
        this.j = sM2KeyExchangePrivateParameters.isInitiator();
        this.c = sM2KeyExchangePrivateParameters.getStaticPrivateKey();
        this.i = sM2KeyExchangePrivateParameters.getEphemeralPrivateKey();
        this.f = this.c.getParameters();
        this.d = sM2KeyExchangePrivateParameters.getStaticPublicPoint();
        this.e = sM2KeyExchangePrivateParameters.getEphemeralPublicPoint();
        this.g = (this.f.getCurve().getFieldSize() + 7) / 8;
        this.h = (this.f.getCurve().getFieldSize() / 2) - 1;
    }

    public SM2KeyExchange(Digest digest) {
        this.a = digest;
    }
}
