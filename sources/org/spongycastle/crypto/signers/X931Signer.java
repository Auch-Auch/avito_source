package org.spongycastle.crypto.signers;

import a2.b.a.a.a;
import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
public class X931Signer implements Signer {
    public static final int TRAILER_IMPLICIT = 188;
    public static final int TRAILER_RIPEMD128 = 13004;
    public static final int TRAILER_RIPEMD160 = 12748;
    public static final int TRAILER_SHA1 = 13260;
    public static final int TRAILER_SHA224 = 14540;
    public static final int TRAILER_SHA256 = 13516;
    public static final int TRAILER_SHA384 = 14028;
    public static final int TRAILER_SHA512 = 13772;
    public static final int TRAILER_WHIRLPOOL = 14284;
    public Digest a;
    public AsymmetricBlockCipher b;
    public RSAKeyParameters c;
    public int d;
    public int e;
    public byte[] f;

    public X931Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, boolean z) {
        this.b = asymmetricBlockCipher;
        this.a = digest;
        if (z) {
            this.d = 188;
            return;
        }
        Integer trailer = ISOTrailers.getTrailer(digest);
        if (trailer != null) {
            this.d = trailer.intValue();
            return;
        }
        StringBuilder L = a.L("no valid trailer for digest: ");
        L.append(digest.getAlgorithmName());
        throw new IllegalArgumentException(L.toString());
    }

    public final void a(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = 0;
        }
    }

    public final void b() {
        int i;
        int digestSize = this.a.getDigestSize();
        if (this.d == 188) {
            byte[] bArr = this.f;
            i = (bArr.length - digestSize) - 1;
            this.a.doFinal(bArr, i);
            byte[] bArr2 = this.f;
            bArr2[bArr2.length - 1] = PSSSigner.TRAILER_IMPLICIT;
        } else {
            byte[] bArr3 = this.f;
            i = (bArr3.length - digestSize) - 2;
            this.a.doFinal(bArr3, i);
            byte[] bArr4 = this.f;
            int i2 = this.d;
            bArr4[bArr4.length - 2] = (byte) (i2 >>> 8);
            bArr4[bArr4.length - 1] = (byte) i2;
        }
        this.f[0] = 107;
        for (int i3 = i - 2; i3 != 0; i3--) {
            this.f[i3] = -69;
        }
        this.f[i - 1] = -70;
    }

    @Override // org.spongycastle.crypto.Signer
    public byte[] generateSignature() throws CryptoException {
        b();
        AsymmetricBlockCipher asymmetricBlockCipher = this.b;
        byte[] bArr = this.f;
        BigInteger bigInteger = new BigInteger(1, asymmetricBlockCipher.processBlock(bArr, 0, bArr.length));
        a(this.f);
        return BigIntegers.asUnsignedByteArray((this.c.getModulus().bitLength() + 7) / 8, bigInteger.min(this.c.getModulus().subtract(bigInteger)));
    }

    @Override // org.spongycastle.crypto.Signer
    public void init(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        this.c = rSAKeyParameters;
        this.b.init(z, rSAKeyParameters);
        int bitLength = this.c.getModulus().bitLength();
        this.e = bitLength;
        this.f = new byte[((bitLength + 7) / 8)];
        reset();
    }

    @Override // org.spongycastle.crypto.Signer
    public void reset() {
        this.a.reset();
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte b2) {
        this.a.update(b2);
    }

    @Override // org.spongycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        try {
            this.f = this.b.processBlock(bArr, 0, bArr.length);
            BigInteger bigInteger = new BigInteger(1, this.f);
            if ((bigInteger.intValue() & 15) != 12) {
                bigInteger = this.c.getModulus().subtract(bigInteger);
                if ((bigInteger.intValue() & 15) != 12) {
                    return false;
                }
            }
            b();
            byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.f.length, bigInteger);
            boolean constantTimeAreEqual = Arrays.constantTimeAreEqual(this.f, asUnsignedByteArray);
            a(this.f);
            a(asUnsignedByteArray);
            return constantTimeAreEqual;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte[] bArr, int i, int i2) {
        this.a.update(bArr, i, i2);
    }

    public X931Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        this(asymmetricBlockCipher, digest, false);
    }
}
