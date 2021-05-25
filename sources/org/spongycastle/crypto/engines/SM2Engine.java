package org.spongycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.digests.SM3Digest;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
public class SM2Engine {
    public final Digest a;
    public boolean b;
    public ECKeyParameters c;
    public ECDomainParameters d;
    public int e;
    public SecureRandom f;

    public SM2Engine() {
        this(new SM3Digest());
    }

    public final void a(Digest digest, ECFieldElement eCFieldElement) {
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.e, eCFieldElement.toBigInteger());
        digest.update(asUnsignedByteArray, 0, asUnsignedByteArray.length);
    }

    public final void b(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = 0;
        }
    }

    public final void c(Digest digest, ECPoint eCPoint, byte[] bArr) {
        int digestSize = digest.getDigestSize();
        int digestSize2 = digest.getDigestSize();
        byte[] bArr2 = new byte[digestSize2];
        int i = 1;
        int i2 = 1;
        int i3 = 0;
        while (i <= ((bArr.length + digestSize) - 1) / digestSize) {
            a(digest, eCPoint.getAffineXCoord());
            a(digest, eCPoint.getAffineYCoord());
            digest.update((byte) (i2 >> 24));
            digest.update((byte) (i2 >> 16));
            digest.update((byte) (i2 >> 8));
            digest.update((byte) i2);
            digest.doFinal(bArr2, 0);
            int i4 = i3 + digestSize2;
            if (i4 < bArr.length) {
                d(bArr, bArr2, i3, digestSize2);
            } else {
                d(bArr, bArr2, i3, bArr.length - i3);
            }
            i2++;
            i++;
            i3 = i4;
        }
    }

    public final void d(byte[] bArr, byte[] bArr2, int i, int i2) {
        for (int i3 = 0; i3 != i2; i3++) {
            int i4 = i + i3;
            bArr[i4] = (byte) (bArr[i4] ^ bArr2[i3]);
        }
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        this.b = z;
        if (z) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            ECKeyParameters eCKeyParameters = (ECKeyParameters) parametersWithRandom.getParameters();
            this.c = eCKeyParameters;
            this.d = eCKeyParameters.getParameters();
            if (!((ECPublicKeyParameters) this.c).getQ().multiply(this.d.getH()).isInfinity()) {
                this.f = parametersWithRandom.getRandom();
            } else {
                throw new IllegalArgumentException("invalid key: [h]Q at infinity");
            }
        } else {
            ECKeyParameters eCKeyParameters2 = (ECKeyParameters) cipherParameters;
            this.c = eCKeyParameters2;
            this.d = eCKeyParameters2.getParameters();
        }
        this.e = (this.d.getCurve().getFieldSize() + 7) / 8;
    }

    public byte[] processBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        BigInteger bigInteger;
        byte[] encoded;
        ECPoint normalize;
        boolean z;
        if (this.b) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            do {
                int bitLength = this.d.getN().bitLength();
                while (true) {
                    bigInteger = new BigInteger(bitLength, this.f);
                    if (!bigInteger.equals(ECConstants.ZERO) && bigInteger.compareTo(this.d.getN()) < 0) {
                        break;
                    }
                }
                encoded = this.d.getG().multiply(bigInteger).normalize().getEncoded(false);
                normalize = ((ECPublicKeyParameters) this.c).getQ().multiply(bigInteger).normalize();
                c(this.a, normalize, bArr2);
                int i3 = 0;
                while (true) {
                    if (i3 == i2) {
                        z = true;
                        continue;
                        break;
                    } else if (bArr2[i3] != bArr[i]) {
                        z = false;
                        continue;
                        break;
                    } else {
                        i3++;
                    }
                }
            } while (z);
            byte[] bArr3 = new byte[this.a.getDigestSize()];
            a(this.a, normalize.getAffineXCoord());
            this.a.update(bArr, i, i2);
            a(this.a, normalize.getAffineYCoord());
            this.a.doFinal(bArr3, 0);
            return Arrays.concatenate(encoded, bArr2, bArr3);
        }
        int i4 = (this.e * 2) + 1;
        byte[] bArr4 = new byte[i4];
        System.arraycopy(bArr, i, bArr4, 0, i4);
        ECPoint decodePoint = this.d.getCurve().decodePoint(bArr4);
        if (!decodePoint.multiply(this.d.getH()).isInfinity()) {
            ECPoint normalize2 = decodePoint.multiply(((ECPrivateKeyParameters) this.c).getD()).normalize();
            int digestSize = (i2 - i4) - this.a.getDigestSize();
            byte[] bArr5 = new byte[digestSize];
            System.arraycopy(bArr, i + i4, bArr5, 0, digestSize);
            c(this.a, normalize2, bArr5);
            int digestSize2 = this.a.getDigestSize();
            byte[] bArr6 = new byte[digestSize2];
            a(this.a, normalize2.getAffineXCoord());
            this.a.update(bArr5, 0, digestSize);
            a(this.a, normalize2.getAffineYCoord());
            this.a.doFinal(bArr6, 0);
            int i5 = 0;
            for (int i6 = 0; i6 != digestSize2; i6++) {
                i5 |= bArr6[i6] ^ bArr[(i4 + digestSize) + i6];
            }
            b(bArr4);
            b(bArr6);
            if (i5 == 0) {
                return bArr5;
            }
            b(bArr5);
            throw new InvalidCipherTextException("invalid cipher text");
        }
        throw new InvalidCipherTextException("[h]C1 at infinity");
    }

    public SM2Engine(Digest digest) {
        this.a = digest;
    }
}
