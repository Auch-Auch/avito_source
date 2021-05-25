package org.spongycastle.pqc.crypto.ntru;

import a2.b.a.a.a;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.ntru.IndexGenerator;
import org.spongycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;
import org.spongycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.SparseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.TernaryPolynomial;
import org.spongycastle.util.Arrays;
public class NTRUEngine implements AsymmetricBlockCipher {
    public boolean a;
    public NTRUEncryptionParameters b;
    public NTRUEncryptionPublicKeyParameters c;
    public NTRUEncryptionPrivateKeyParameters d;
    public SecureRandom e;

    public final IntegerPolynomial a(byte[] bArr, int i, int i2, boolean z) {
        Digest digest = this.b.hashAlg;
        int digestSize = digest.getDigestSize();
        byte[] bArr2 = new byte[(i2 * digestSize)];
        if (z) {
            byte[] bArr3 = new byte[digest.getDigestSize()];
            digest.update(bArr, 0, bArr.length);
            digest.doFinal(bArr3, 0);
            bArr = bArr3;
        }
        int i3 = 0;
        while (i3 < i2) {
            digest.update(bArr, 0, bArr.length);
            e(digest, i3);
            byte[] bArr4 = new byte[digest.getDigestSize()];
            digest.doFinal(bArr4, 0);
            System.arraycopy(bArr4, 0, bArr2, i3 * digestSize, digestSize);
            i3++;
        }
        IntegerPolynomial integerPolynomial = new IntegerPolynomial(i);
        while (true) {
            int i4 = 0;
            for (int i5 = 0; i5 != bArr2.length; i5++) {
                int i6 = bArr2[i5] & 255;
                if (i6 < 243) {
                    for (int i7 = 0; i7 < 4; i7++) {
                        int i8 = i6 % 3;
                        integerPolynomial.coeffs[i4] = i8 - 1;
                        i4++;
                        if (i4 == i) {
                            return integerPolynomial;
                        }
                        i6 = (i6 - i8) / 3;
                    }
                    integerPolynomial.coeffs[i4] = i6 - 1;
                    i4++;
                    if (i4 == i) {
                        return integerPolynomial;
                    }
                }
            }
            if (i4 >= i) {
                return integerPolynomial;
            }
            digest.update(bArr, 0, bArr.length);
            e(digest, i3);
            bArr2 = new byte[digest.getDigestSize()];
            digest.doFinal(bArr2, 0);
            i3++;
        }
    }

    public final byte[] b(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        byte[] bArr5 = new byte[(bArr.length + i + bArr3.length + bArr4.length)];
        System.arraycopy(bArr, 0, bArr5, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr5, bArr.length, bArr2.length);
        System.arraycopy(bArr3, 0, bArr5, bArr.length + bArr2.length, bArr3.length);
        System.arraycopy(bArr4, 0, bArr5, bArr.length + bArr2.length + bArr3.length, bArr4.length);
        return bArr5;
    }

    public final int[] c(IndexGenerator indexGenerator, int i) {
        int leadingAsInt;
        int i2;
        int i3;
        int i4;
        int[] iArr = new int[this.b.N];
        for (int i5 = -1; i5 <= 1; i5 += 2) {
            int i6 = 0;
            while (i6 < i) {
                if (!indexGenerator.i) {
                    indexGenerator.g = new IndexGenerator.BitString();
                    byte[] bArr = new byte[indexGenerator.j.getDigestSize()];
                    while (true) {
                        int i7 = indexGenerator.h;
                        i4 = indexGenerator.d;
                        if (i7 >= i4) {
                            break;
                        }
                        indexGenerator.a(indexGenerator.g, bArr);
                        indexGenerator.h++;
                    }
                    int i8 = i4 * 8 * indexGenerator.k;
                    indexGenerator.e = i8;
                    indexGenerator.f = i8;
                    indexGenerator.i = true;
                }
                do {
                    indexGenerator.e += indexGenerator.c;
                    IndexGenerator.BitString trailing = indexGenerator.g.getTrailing(indexGenerator.f);
                    int i9 = indexGenerator.f;
                    int i10 = indexGenerator.c;
                    if (i9 < i10) {
                        int i11 = i10 - i9;
                        int i12 = indexGenerator.h;
                        int i13 = indexGenerator.k;
                        int i14 = (((i11 + i13) - 1) / i13) + i12;
                        int digestSize = indexGenerator.j.getDigestSize();
                        byte[] bArr2 = new byte[digestSize];
                        while (indexGenerator.h < i14) {
                            indexGenerator.a(trailing, bArr2);
                            indexGenerator.h++;
                            int i15 = indexGenerator.k * 8;
                            if (i11 > i15) {
                                i11 -= i15;
                            }
                        }
                        indexGenerator.f = (indexGenerator.k * 8) - i11;
                        IndexGenerator.BitString bitString = new IndexGenerator.BitString();
                        indexGenerator.g = bitString;
                        for (int i16 = 0; i16 != digestSize; i16++) {
                            bitString.appendBits(bArr2[i16]);
                        }
                    } else {
                        indexGenerator.f = i9 - i10;
                    }
                    leadingAsInt = trailing.getLeadingAsInt(indexGenerator.c);
                    i2 = 1 << indexGenerator.c;
                    i3 = indexGenerator.b;
                } while (leadingAsInt >= i2 - (i2 % i3));
                int i17 = leadingAsInt % i3;
                if (iArr[i17] == 0) {
                    iArr[i17] = i5;
                    i6++;
                }
            }
        }
        return iArr;
    }

    public final Polynomial d(byte[] bArr) {
        IndexGenerator indexGenerator = new IndexGenerator(bArr, this.b);
        NTRUEncryptionParameters nTRUEncryptionParameters = this.b;
        if (nTRUEncryptionParameters.polyType == 1) {
            return new ProductFormPolynomial(new SparseTernaryPolynomial(c(indexGenerator, nTRUEncryptionParameters.dr1)), new SparseTernaryPolynomial(c(indexGenerator, this.b.dr2)), new SparseTernaryPolynomial(c(indexGenerator, this.b.dr3)));
        }
        int i = nTRUEncryptionParameters.dr;
        boolean z = nTRUEncryptionParameters.sparse;
        int[] c2 = c(indexGenerator, i);
        if (z) {
            return new SparseTernaryPolynomial(c2);
        }
        return new DenseTernaryPolynomial(c2);
    }

    public IntegerPolynomial decrypt(IntegerPolynomial integerPolynomial, Polynomial polynomial, IntegerPolynomial integerPolynomial2) {
        IntegerPolynomial integerPolynomial3;
        NTRUEncryptionParameters nTRUEncryptionParameters = this.b;
        if (nTRUEncryptionParameters.fastFp) {
            integerPolynomial3 = polynomial.mult(integerPolynomial, nTRUEncryptionParameters.q);
            integerPolynomial3.mult(3);
            integerPolynomial3.add(integerPolynomial);
        } else {
            integerPolynomial3 = polynomial.mult(integerPolynomial, nTRUEncryptionParameters.q);
        }
        integerPolynomial3.center0(this.b.q);
        integerPolynomial3.mod3();
        if (!this.b.fastFp) {
            integerPolynomial3 = new DenseTernaryPolynomial(integerPolynomial3).mult(integerPolynomial2, 3);
        }
        integerPolynomial3.center0(3);
        return integerPolynomial3;
    }

    public final void e(Digest digest, int i) {
        digest.update((byte) (i >> 24));
        digest.update((byte) (i >> 16));
        digest.update((byte) (i >> 8));
        digest.update((byte) i);
    }

    public IntegerPolynomial encrypt(IntegerPolynomial integerPolynomial, TernaryPolynomial ternaryPolynomial, IntegerPolynomial integerPolynomial2) {
        IntegerPolynomial mult = ternaryPolynomial.mult(integerPolynomial2, this.b.q);
        mult.add(integerPolynomial, this.b.q);
        mult.ensurePositive(this.b.q);
        return mult;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        return this.b.maxMsgLenBytes;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        NTRUEncryptionParameters nTRUEncryptionParameters = this.b;
        int i = nTRUEncryptionParameters.N;
        if (nTRUEncryptionParameters.q == 2048) {
            return ((i * 11) + 7) / 8;
        }
        throw new IllegalStateException("log2 not fully implemented");
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        this.a = z;
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.e = parametersWithRandom.getRandom();
                this.c = (NTRUEncryptionPublicKeyParameters) parametersWithRandom.getParameters();
            } else {
                this.e = new SecureRandom();
                this.c = (NTRUEncryptionPublicKeyParameters) cipherParameters;
            }
            this.b = this.c.getParameters();
            return;
        }
        NTRUEncryptionPrivateKeyParameters nTRUEncryptionPrivateKeyParameters = (NTRUEncryptionPrivateKeyParameters) cipherParameters;
        this.d = nTRUEncryptionPrivateKeyParameters;
        this.b = nTRUEncryptionPrivateKeyParameters.getParameters();
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        if (this.a) {
            IntegerPolynomial integerPolynomial = this.c.h;
            NTRUEncryptionParameters nTRUEncryptionParameters = this.b;
            int i3 = nTRUEncryptionParameters.N;
            int i4 = nTRUEncryptionParameters.q;
            int i5 = nTRUEncryptionParameters.maxMsgLenBytes;
            int i6 = nTRUEncryptionParameters.db;
            int i7 = nTRUEncryptionParameters.bufferLenBits;
            int i8 = nTRUEncryptionParameters.dm0;
            int i9 = nTRUEncryptionParameters.pkLen;
            int i10 = nTRUEncryptionParameters.minCallsMask;
            int i11 = i8;
            boolean z = nTRUEncryptionParameters.hashSeed;
            byte[] bArr3 = nTRUEncryptionParameters.oid;
            if (i5 > 255) {
                throw new IllegalArgumentException("llen values bigger than 1 are not supported");
            } else if (i2 <= i5) {
                while (true) {
                    int i12 = i6 / 8;
                    byte[] bArr4 = new byte[i12];
                    this.e.nextBytes(bArr4);
                    int i13 = (i5 + 1) - i2;
                    byte[] bArr5 = new byte[(i7 / 8)];
                    System.arraycopy(bArr4, 0, bArr5, 0, i12);
                    bArr5[i12] = (byte) i2;
                    int i14 = i12 + 1;
                    System.arraycopy(bArr2, 0, bArr5, i14, i2);
                    System.arraycopy(new byte[i13], 0, bArr5, i14 + i2, i13);
                    IntegerPolynomial fromBinary3Sves = IntegerPolynomial.fromBinary3Sves(bArr5, i3);
                    byte[] binary = integerPolynomial.toBinary(i4);
                    int i15 = i9 / 8;
                    byte[] bArr6 = new byte[i15];
                    if (i15 >= binary.length) {
                        i15 = binary.length;
                    }
                    System.arraycopy(binary, 0, bArr6, 0, i15);
                    IntegerPolynomial mult = d(b(bArr3, bArr2, i2, bArr4, bArr6)).mult(integerPolynomial, i4);
                    IntegerPolynomial integerPolynomial2 = (IntegerPolynomial) mult.clone();
                    integerPolynomial2.modPositive(4);
                    fromBinary3Sves.add(a(integerPolynomial2.toBinary(4), i3, i10, z));
                    fromBinary3Sves.mod3();
                    if (fromBinary3Sves.count(-1) >= i11 && fromBinary3Sves.count(0) >= i11 && fromBinary3Sves.count(1) >= i11) {
                        mult.add(fromBinary3Sves, i4);
                        mult.ensurePositive(i4);
                        return mult.toBinary(i4);
                    }
                    i11 = i11;
                    i10 = i10;
                    i6 = i6;
                    bArr3 = bArr3;
                    i9 = i9;
                    i7 = i7;
                }
            } else {
                throw new DataLengthException(a.R2("Message too long: ", i2, ">", i5));
            }
        } else {
            NTRUEncryptionPrivateKeyParameters nTRUEncryptionPrivateKeyParameters = this.d;
            Polynomial polynomial = nTRUEncryptionPrivateKeyParameters.t;
            IntegerPolynomial integerPolynomial3 = nTRUEncryptionPrivateKeyParameters.fp;
            IntegerPolynomial integerPolynomial4 = nTRUEncryptionPrivateKeyParameters.h;
            NTRUEncryptionParameters nTRUEncryptionParameters2 = this.b;
            int i16 = nTRUEncryptionParameters2.N;
            int i17 = nTRUEncryptionParameters2.q;
            int i18 = nTRUEncryptionParameters2.db;
            int i19 = nTRUEncryptionParameters2.maxMsgLenBytes;
            int i20 = nTRUEncryptionParameters2.dm0;
            int i21 = nTRUEncryptionParameters2.pkLen;
            int i22 = nTRUEncryptionParameters2.minCallsMask;
            boolean z2 = nTRUEncryptionParameters2.hashSeed;
            byte[] bArr7 = nTRUEncryptionParameters2.oid;
            if (i19 <= 255) {
                int i23 = i18 / 8;
                IntegerPolynomial fromBinary = IntegerPolynomial.fromBinary(bArr2, i16, i17);
                IntegerPolynomial decrypt = decrypt(fromBinary, polynomial, integerPolynomial3);
                if (decrypt.count(-1) < i20) {
                    throw new InvalidCipherTextException("Less than dm0 coefficients equal -1");
                } else if (decrypt.count(0) < i20) {
                    throw new InvalidCipherTextException("Less than dm0 coefficients equal 0");
                } else if (decrypt.count(1) >= i20) {
                    IntegerPolynomial integerPolynomial5 = (IntegerPolynomial) fromBinary.clone();
                    integerPolynomial5.sub(decrypt);
                    integerPolynomial5.modPositive(i17);
                    IntegerPolynomial integerPolynomial6 = (IntegerPolynomial) integerPolynomial5.clone();
                    integerPolynomial6.modPositive(4);
                    decrypt.sub(a(integerPolynomial6.toBinary(4), i16, i22, z2));
                    decrypt.mod3();
                    byte[] binary3Sves = decrypt.toBinary3Sves();
                    byte[] bArr8 = new byte[i23];
                    System.arraycopy(binary3Sves, 0, bArr8, 0, i23);
                    int i24 = binary3Sves[i23] & 255;
                    if (i24 <= i19) {
                        byte[] bArr9 = new byte[i24];
                        int i25 = i23 + 1;
                        System.arraycopy(binary3Sves, i25, bArr9, 0, i24);
                        int i26 = i25 + i24;
                        int length = binary3Sves.length - i26;
                        byte[] bArr10 = new byte[length];
                        System.arraycopy(binary3Sves, i26, bArr10, 0, length);
                        if (Arrays.constantTimeAreEqual(bArr10, new byte[length])) {
                            byte[] binary2 = integerPolynomial4.toBinary(i17);
                            int i27 = i21 / 8;
                            byte[] bArr11 = new byte[i27];
                            if (i27 >= binary2.length) {
                                i27 = binary2.length;
                            }
                            System.arraycopy(binary2, 0, bArr11, 0, i27);
                            IntegerPolynomial mult2 = d(b(bArr7, bArr9, i24, bArr8, bArr11)).mult(integerPolynomial4);
                            mult2.modPositive(i17);
                            if (mult2.equals(integerPolynomial5)) {
                                return bArr9;
                            }
                            throw new InvalidCipherTextException("Invalid message encoding");
                        }
                        throw new InvalidCipherTextException("The message is not followed by zeroes");
                    }
                    throw new InvalidCipherTextException(a.R2("Message too long: ", i24, ">", i19));
                } else {
                    throw new InvalidCipherTextException("Less than dm0 coefficients equal 1");
                }
            } else {
                throw new DataLengthException("maxMsgLenBytes values bigger than 255 are not supported");
            }
        }
    }
}
