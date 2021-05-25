package org.spongycastle.pqc.crypto.mceliece;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.prng.DigestRandomGenerator;
import org.spongycastle.pqc.crypto.MessageEncryptor;
import org.spongycastle.pqc.math.linearalgebra.BigIntUtils;
import org.spongycastle.pqc.math.linearalgebra.ByteUtils;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;
import org.spongycastle.pqc.math.linearalgebra.IntegerFunctions;
import x6.e.f.a.a.a;
public class McElieceKobaraImaiCipher implements MessageEncryptor {
    public static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.2.3";
    public static final byte[] PUBLIC_CONSTANT = "a predetermined public constant".getBytes();
    public Digest a;
    public SecureRandom b;
    public McElieceCCA2KeyParameters c;
    public int d;
    public int e;
    public int f;
    public boolean g;

    public final void a(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters) {
        this.a = AppCompatDelegateImpl.i.v0(mcElieceCCA2PublicKeyParameters.getDigest());
        this.d = mcElieceCCA2PublicKeyParameters.getN();
        this.e = mcElieceCCA2PublicKeyParameters.getK();
        this.f = mcElieceCCA2PublicKeyParameters.getT();
    }

    public int getKeySize(McElieceCCA2KeyParameters mcElieceCCA2KeyParameters) {
        if (mcElieceCCA2KeyParameters instanceof McElieceCCA2PublicKeyParameters) {
            return ((McElieceCCA2PublicKeyParameters) mcElieceCCA2KeyParameters).getN();
        }
        if (mcElieceCCA2KeyParameters instanceof McElieceCCA2PrivateKeyParameters) {
            return ((McElieceCCA2PrivateKeyParameters) mcElieceCCA2KeyParameters).getN();
        }
        throw new IllegalArgumentException("unsupported type");
    }

    @Override // org.spongycastle.pqc.crypto.MessageEncryptor
    public void init(boolean z, CipherParameters cipherParameters) {
        this.g = z;
        if (!z) {
            McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters = (McElieceCCA2PrivateKeyParameters) cipherParameters;
            this.c = mcElieceCCA2PrivateKeyParameters;
            McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters2 = mcElieceCCA2PrivateKeyParameters;
            this.a = AppCompatDelegateImpl.i.v0(mcElieceCCA2PrivateKeyParameters2.getDigest());
            this.d = mcElieceCCA2PrivateKeyParameters2.getN();
            this.e = mcElieceCCA2PrivateKeyParameters2.getK();
            this.f = mcElieceCCA2PrivateKeyParameters2.getT();
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.b = parametersWithRandom.getRandom();
            McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters = (McElieceCCA2PublicKeyParameters) parametersWithRandom.getParameters();
            this.c = mcElieceCCA2PublicKeyParameters;
            a(mcElieceCCA2PublicKeyParameters);
        } else {
            this.b = new SecureRandom();
            McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters2 = (McElieceCCA2PublicKeyParameters) cipherParameters;
            this.c = mcElieceCCA2PublicKeyParameters2;
            a(mcElieceCCA2PublicKeyParameters2);
        }
    }

    @Override // org.spongycastle.pqc.crypto.MessageEncryptor
    public byte[] messageDecrypt(byte[] bArr) throws InvalidCipherTextException {
        byte[] bArr2;
        if (!this.g) {
            int i = this.d >> 3;
            if (bArr.length >= i) {
                int digestSize = this.a.getDigestSize();
                int i2 = this.e >> 3;
                int length = bArr.length - i;
                if (length > 0) {
                    byte[][] split = ByteUtils.split(bArr, length);
                    bArr2 = split[0];
                    bArr = split[1];
                } else {
                    bArr2 = new byte[0];
                }
                GF2Vector[] c0 = AppCompatDelegateImpl.i.c0((McElieceCCA2PrivateKeyParameters) this.c, GF2Vector.OS2VP(this.d, bArr));
                byte[] encoded = c0[0].getEncoded();
                GF2Vector gF2Vector = c0[1];
                if (encoded.length > i2) {
                    encoded = ByteUtils.subArray(encoded, 0, i2);
                }
                int i3 = this.d;
                int i4 = this.f;
                BigInteger bigInteger = a.a;
                if (gF2Vector.getLength() == i3 && gF2Vector.getHammingWeight() == i4) {
                    int[] vecArray = gF2Vector.getVecArray();
                    BigInteger binomial = IntegerFunctions.binomial(i3, i4);
                    BigInteger bigInteger2 = a.a;
                    int i5 = i3;
                    for (int i6 = 0; i6 < i3; i6++) {
                        binomial = binomial.multiply(BigInteger.valueOf((long) (i5 - i4))).divide(BigInteger.valueOf((long) i5));
                        i5--;
                        if ((vecArray[i6 >> 5] & (1 << (i6 & 31))) != 0) {
                            bigInteger2 = bigInteger2.add(binomial);
                            i4--;
                            if (i5 == i4) {
                                binomial = a.b;
                            } else {
                                binomial = binomial.multiply(BigInteger.valueOf((long) (i4 + 1))).divide(BigInteger.valueOf((long) (i5 - i4)));
                            }
                        }
                    }
                    byte[] concatenate = ByteUtils.concatenate(ByteUtils.concatenate(bArr2, BigIntUtils.toMinimalByteArray(bigInteger2)), encoded);
                    int length2 = concatenate.length - digestSize;
                    byte[][] split2 = ByteUtils.split(concatenate, digestSize);
                    byte[] bArr3 = split2[0];
                    byte[] bArr4 = split2[1];
                    byte[] bArr5 = new byte[this.a.getDigestSize()];
                    this.a.update(bArr4, 0, bArr4.length);
                    this.a.doFinal(bArr5, 0);
                    for (int i7 = digestSize - 1; i7 >= 0; i7--) {
                        bArr5[i7] = (byte) (bArr5[i7] ^ bArr3[i7]);
                    }
                    DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
                    digestRandomGenerator.addSeedMaterial(bArr5);
                    byte[] bArr6 = new byte[length2];
                    digestRandomGenerator.nextBytes(bArr6);
                    for (int i8 = length2 - 1; i8 >= 0; i8--) {
                        bArr6[i8] = (byte) (bArr6[i8] ^ bArr4[i8]);
                    }
                    if (length2 >= length2) {
                        byte[] bArr7 = PUBLIC_CONSTANT;
                        byte[][] split3 = ByteUtils.split(bArr6, length2 - bArr7.length);
                        byte[] bArr8 = split3[0];
                        if (ByteUtils.equals(split3[1], bArr7)) {
                            return bArr8;
                        }
                        throw new InvalidCipherTextException("Bad Padding: invalid ciphertext");
                    }
                    throw new InvalidCipherTextException("Bad Padding: invalid ciphertext");
                }
                throw new IllegalArgumentException("vector has wrong length or hamming weight");
            }
            throw new InvalidCipherTextException("Bad Padding: Ciphertext too short.");
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }

    @Override // org.spongycastle.pqc.crypto.MessageEncryptor
    public byte[] messageEncrypt(byte[] bArr) {
        if (this.g) {
            int digestSize = this.a.getDigestSize();
            int i = this.e >> 3;
            int bitLength = (IntegerFunctions.binomial(this.d, this.f).bitLength() - 1) >> 3;
            byte[] bArr2 = PUBLIC_CONSTANT;
            int length = ((i + bitLength) - digestSize) - bArr2.length;
            if (bArr.length > length) {
                length = bArr.length;
            }
            int length2 = bArr2.length + length;
            int i2 = ((length2 + digestSize) - i) - bitLength;
            byte[] bArr3 = new byte[length2];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, length, bArr2.length);
            byte[] bArr4 = new byte[digestSize];
            this.b.nextBytes(bArr4);
            DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
            digestRandomGenerator.addSeedMaterial(bArr4);
            byte[] bArr5 = new byte[length2];
            digestRandomGenerator.nextBytes(bArr5);
            for (int i3 = length2 - 1; i3 >= 0; i3--) {
                bArr5[i3] = (byte) (bArr5[i3] ^ bArr3[i3]);
            }
            byte[] bArr6 = new byte[this.a.getDigestSize()];
            this.a.update(bArr5, 0, length2);
            this.a.doFinal(bArr6, 0);
            for (int i4 = digestSize - 1; i4 >= 0; i4--) {
                bArr6[i4] = (byte) (bArr6[i4] ^ bArr4[i4]);
            }
            byte[] concatenate = ByteUtils.concatenate(bArr6, bArr5);
            byte[] bArr7 = new byte[0];
            if (i2 > 0) {
                bArr7 = new byte[i2];
                System.arraycopy(concatenate, 0, bArr7, 0, i2);
            }
            byte[] bArr8 = new byte[bitLength];
            System.arraycopy(concatenate, i2, bArr8, 0, bitLength);
            byte[] bArr9 = new byte[i];
            System.arraycopy(concatenate, bitLength + i2, bArr9, 0, i);
            byte[] encoded = AppCompatDelegateImpl.i.i0((McElieceCCA2PublicKeyParameters) this.c, GF2Vector.OS2VP(this.e, bArr9), a.a(this.d, this.f, bArr8)).getEncoded();
            return i2 > 0 ? ByteUtils.concatenate(bArr7, encoded) : encoded;
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }
}
