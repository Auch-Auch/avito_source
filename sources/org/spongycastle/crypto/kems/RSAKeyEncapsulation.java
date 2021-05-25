package org.spongycastle.crypto.kems;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.KeyEncapsulation;
import org.spongycastle.crypto.params.KDFParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.util.BigIntegers;
public class RSAKeyEncapsulation implements KeyEncapsulation {
    public static final BigInteger d = BigInteger.valueOf(0);
    public static final BigInteger e = BigInteger.valueOf(1);
    public DerivationFunction a;
    public SecureRandom b;
    public RSAKeyParameters c;

    public RSAKeyEncapsulation(DerivationFunction derivationFunction, SecureRandom secureRandom) {
        this.a = derivationFunction;
        this.b = secureRandom;
    }

    @Override // org.spongycastle.crypto.KeyEncapsulation
    public CipherParameters decrypt(byte[] bArr, int i, int i2, int i3) throws IllegalArgumentException {
        if (this.c.isPrivate()) {
            BigInteger modulus = this.c.getModulus();
            BigInteger exponent = this.c.getExponent();
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return generateKey(modulus, new BigInteger(1, bArr2).modPow(exponent, modulus), i3);
        }
        throw new IllegalArgumentException("Private key required for decryption");
    }

    @Override // org.spongycastle.crypto.KeyEncapsulation
    public CipherParameters encrypt(byte[] bArr, int i, int i2) throws IllegalArgumentException {
        if (!this.c.isPrivate()) {
            BigInteger modulus = this.c.getModulus();
            BigInteger exponent = this.c.getExponent();
            BigInteger createRandomInRange = BigIntegers.createRandomInRange(d, modulus.subtract(e), this.b);
            byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray((modulus.bitLength() + 7) / 8, createRandomInRange.modPow(exponent, modulus));
            System.arraycopy(asUnsignedByteArray, 0, bArr, i, asUnsignedByteArray.length);
            return generateKey(modulus, createRandomInRange, i2);
        }
        throw new IllegalArgumentException("Public key required for encryption");
    }

    public KeyParameter generateKey(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.a.init(new KDFParameters(BigIntegers.asUnsignedByteArray((bigInteger.bitLength() + 7) / 8, bigInteger2), null));
        byte[] bArr = new byte[i];
        this.a.generateBytes(bArr, 0, i);
        return new KeyParameter(bArr);
    }

    @Override // org.spongycastle.crypto.KeyEncapsulation
    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof RSAKeyParameters) {
            this.c = (RSAKeyParameters) cipherParameters;
            return;
        }
        throw new IllegalArgumentException("RSA key required");
    }

    public CipherParameters decrypt(byte[] bArr, int i) {
        return decrypt(bArr, 0, bArr.length, i);
    }

    public CipherParameters encrypt(byte[] bArr, int i) {
        return encrypt(bArr, 0, i);
    }
}
