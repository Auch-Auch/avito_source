package org.spongycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.ElGamalKeyParameters;
import org.spongycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.BigIntegers;
public class ElGamalEngine implements AsymmetricBlockCipher {
    public static final BigInteger e = BigInteger.valueOf(0);
    public static final BigInteger f = BigInteger.valueOf(1);
    public static final BigInteger g = BigInteger.valueOf(2);
    public ElGamalKeyParameters a;
    public SecureRandom b;
    public boolean c;
    public int d;

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        if (this.c) {
            return (this.d - 1) / 8;
        }
        return ((this.d + 7) / 8) * 2;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        if (this.c) {
            return ((this.d + 7) / 8) * 2;
        }
        return (this.d - 1) / 8;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.a = (ElGamalKeyParameters) parametersWithRandom.getParameters();
            this.b = parametersWithRandom.getRandom();
        } else {
            this.a = (ElGamalKeyParameters) cipherParameters;
            this.b = new SecureRandom();
        }
        this.c = z;
        this.d = this.a.getParameters().getP().bitLength();
        if (z) {
            if (!(this.a instanceof ElGamalPublicKeyParameters)) {
                throw new IllegalArgumentException("ElGamalPublicKeyParameters are required for encryption.");
            }
        } else if (!(this.a instanceof ElGamalPrivateKeyParameters)) {
            throw new IllegalArgumentException("ElGamalPrivateKeyParameters are required for decryption.");
        }
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i, int i2) {
        int i3;
        if (this.a != null) {
            if (this.c) {
                i3 = ((this.d - 1) + 7) / 8;
            } else {
                i3 = getInputBlockSize();
            }
            if (i2 <= i3) {
                BigInteger p = this.a.getParameters().getP();
                if (this.a instanceof ElGamalPrivateKeyParameters) {
                    int i4 = i2 / 2;
                    byte[] bArr2 = new byte[i4];
                    byte[] bArr3 = new byte[i4];
                    System.arraycopy(bArr, i, bArr2, 0, i4);
                    System.arraycopy(bArr, i + i4, bArr3, 0, i4);
                    BigInteger bigInteger = new BigInteger(1, bArr2);
                    return BigIntegers.asUnsignedByteArray(bigInteger.modPow(p.subtract(f).subtract(((ElGamalPrivateKeyParameters) this.a).getX()), p).multiply(new BigInteger(1, bArr3)).mod(p));
                }
                if (!(i == 0 && i2 == bArr.length)) {
                    byte[] bArr4 = new byte[i2];
                    System.arraycopy(bArr, i, bArr4, 0, i2);
                    bArr = bArr4;
                }
                BigInteger bigInteger2 = new BigInteger(1, bArr);
                if (bigInteger2.compareTo(p) < 0) {
                    ElGamalPublicKeyParameters elGamalPublicKeyParameters = (ElGamalPublicKeyParameters) this.a;
                    int bitLength = p.bitLength();
                    BigInteger bigInteger3 = new BigInteger(bitLength, this.b);
                    while (true) {
                        if (!bigInteger3.equals(e) && bigInteger3.compareTo(p.subtract(g)) <= 0) {
                            break;
                        }
                        bigInteger3 = new BigInteger(bitLength, this.b);
                    }
                    BigInteger modPow = this.a.getParameters().getG().modPow(bigInteger3, p);
                    BigInteger mod = bigInteger2.multiply(elGamalPublicKeyParameters.getY().modPow(bigInteger3, p)).mod(p);
                    byte[] byteArray = modPow.toByteArray();
                    byte[] byteArray2 = mod.toByteArray();
                    int outputBlockSize = getOutputBlockSize();
                    byte[] bArr5 = new byte[outputBlockSize];
                    int i5 = outputBlockSize / 2;
                    if (byteArray.length > i5) {
                        System.arraycopy(byteArray, 1, bArr5, i5 - (byteArray.length - 1), byteArray.length - 1);
                    } else {
                        System.arraycopy(byteArray, 0, bArr5, i5 - byteArray.length, byteArray.length);
                    }
                    if (byteArray2.length > i5) {
                        System.arraycopy(byteArray2, 1, bArr5, outputBlockSize - (byteArray2.length - 1), byteArray2.length - 1);
                    } else {
                        System.arraycopy(byteArray2, 0, bArr5, outputBlockSize - byteArray2.length, byteArray2.length);
                    }
                    return bArr5;
                }
                throw new DataLengthException("input too large for ElGamal cipher.\n");
            }
            throw new DataLengthException("input too large for ElGamal cipher.\n");
        }
        throw new IllegalStateException("ElGamal engine not initialised");
    }
}
