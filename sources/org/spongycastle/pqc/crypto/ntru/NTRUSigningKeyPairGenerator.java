package org.spongycastle.pqc.crypto.ntru;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.ntru.NTRUSigningPrivateKeyParameters;
import org.spongycastle.pqc.math.ntru.euclid.BigIntEuclidean;
import org.spongycastle.pqc.math.ntru.polynomial.BigDecimalPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.BigIntPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;
import org.spongycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Resultant;
public class NTRUSigningKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public NTRUSigningKeyGenerationParameters a;

    public class FGBasis extends NTRUSigningPrivateKeyParameters.Basis {
        public IntegerPolynomial F;
        public IntegerPolynomial G;

        public FGBasis(NTRUSigningKeyPairGenerator nTRUSigningKeyPairGenerator, Polynomial polynomial, Polynomial polynomial2, IntegerPolynomial integerPolynomial, IntegerPolynomial integerPolynomial2, IntegerPolynomial integerPolynomial3, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) {
            super(polynomial, polynomial2, integerPolynomial, nTRUSigningKeyGenerationParameters);
            this.F = integerPolynomial2;
            this.G = integerPolynomial3;
        }
    }

    public class b implements Callable<NTRUSigningPrivateKeyParameters.Basis> {
        public b(a aVar) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public NTRUSigningPrivateKeyParameters.Basis call() throws Exception {
            return NTRUSigningKeyPairGenerator.this.generateBoundedBasis();
        }
    }

    public NTRUSigningPrivateKeyParameters.Basis generateBoundedBasis() {
        int i;
        int i2;
        Polynomial polynomial;
        Polynomial polynomial2;
        IntegerPolynomial integerPolynomial;
        IntegerPolynomial invertFq;
        int i3;
        int i4;
        int i5;
        int i6;
        Polynomial polynomial3;
        IntegerPolynomial integerPolynomial2;
        IntegerPolynomial integerPolynomial3;
        Resultant resultant;
        Polynomial polynomial4;
        IntegerPolynomial integerPolynomial4;
        Resultant resultant2;
        BigIntEuclidean calculate;
        BigIntPolynomial bigIntPolynomial;
        IntegerPolynomial integerPolynomial5;
        IntegerPolynomial integerPolynomial6;
        FGBasis fGBasis;
        boolean z;
        int i7;
        int i8;
        do {
            NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = this.a;
            int i9 = nTRUSigningKeyGenerationParameters.N;
            int i10 = nTRUSigningKeyGenerationParameters.q;
            int i11 = nTRUSigningKeyGenerationParameters.d;
            int i12 = nTRUSigningKeyGenerationParameters.d1;
            int i13 = nTRUSigningKeyGenerationParameters.d2;
            int i14 = nTRUSigningKeyGenerationParameters.d3;
            int i15 = nTRUSigningKeyGenerationParameters.basisType;
            int i16 = i9 * 2;
            int i17 = i16 + 1;
            boolean z2 = nTRUSigningKeyGenerationParameters.primeCheck;
            while (true) {
                if (this.a.polyType == 0) {
                    polynomial = DenseTernaryPolynomial.generateRandom(i9, i11 + 1, i11, new SecureRandom());
                    i = i15;
                    i2 = i17;
                } else {
                    i = i15;
                    i2 = i17;
                    polynomial = ProductFormPolynomial.generateRandom(i9, i12, i13, i14 + 1, i14, new SecureRandom());
                }
                polynomial2 = polynomial;
                integerPolynomial = polynomial2.toIntegerPolynomial();
                if ((!z2 || !integerPolynomial.resultant(i2).res.equals(BigInteger.ZERO)) && (invertFq = integerPolynomial.invertFq(i10)) != null) {
                    break;
                }
                i16 = i16;
                i17 = i2;
                i13 = i13;
                i15 = i;
                i11 = i11;
                i12 = i12;
                i14 = i14;
            }
            Resultant resultant3 = integerPolynomial.resultant();
            while (true) {
                if (this.a.polyType == 0) {
                    polynomial4 = DenseTernaryPolynomial.generateRandom(i9, i11 + 1, i11, new SecureRandom());
                    i5 = i11;
                    i4 = i12;
                    i6 = i13;
                    i3 = i14;
                    resultant = resultant3;
                    integerPolynomial3 = invertFq;
                    integerPolynomial2 = integerPolynomial;
                    polynomial3 = polynomial2;
                } else {
                    i5 = i11;
                    resultant = resultant3;
                    i4 = i12;
                    integerPolynomial3 = invertFq;
                    i6 = i13;
                    integerPolynomial2 = integerPolynomial;
                    i3 = i14;
                    polynomial3 = polynomial2;
                    polynomial4 = ProductFormPolynomial.generateRandom(i9, i12, i13, i14 + 1, i14, new SecureRandom());
                }
                integerPolynomial4 = polynomial4.toIntegerPolynomial();
                if ((!z2 || !integerPolynomial4.resultant(i2).res.equals(BigInteger.ZERO)) && integerPolynomial4.invertFq(i10) != null) {
                    resultant2 = integerPolynomial4.resultant();
                    calculate = BigIntEuclidean.calculate(resultant.res, resultant2.res);
                    if (calculate.gcd.equals(BigInteger.ONE)) {
                        break;
                    }
                }
                i16 = i16;
                resultant3 = resultant;
                invertFq = integerPolynomial3;
                i13 = i6;
                i11 = i5;
                i12 = i4;
                i14 = i3;
                polynomial2 = polynomial3;
                integerPolynomial = integerPolynomial2;
            }
            BigIntPolynomial bigIntPolynomial2 = (BigIntPolynomial) resultant.rho.clone();
            bigIntPolynomial2.mult(calculate.x.multiply(BigInteger.valueOf((long) i10)));
            BigIntPolynomial bigIntPolynomial3 = (BigIntPolynomial) resultant2.rho.clone();
            bigIntPolynomial3.mult(calculate.y.multiply(BigInteger.valueOf((long) (-i10))));
            if (this.a.keyGenAlg == 0) {
                int[] iArr = new int[i9];
                int[] iArr2 = new int[i9];
                iArr[0] = integerPolynomial2.coeffs[0];
                iArr2[0] = integerPolynomial4.coeffs[0];
                for (int i18 = 1; i18 < i9; i18++) {
                    int i19 = i9 - i18;
                    iArr[i18] = integerPolynomial2.coeffs[i19];
                    iArr2[i18] = integerPolynomial4.coeffs[i19];
                }
                IntegerPolynomial integerPolynomial7 = new IntegerPolynomial(iArr);
                IntegerPolynomial integerPolynomial8 = new IntegerPolynomial(iArr2);
                IntegerPolynomial mult = polynomial3.mult(integerPolynomial7);
                mult.add(polynomial4.mult(integerPolynomial8));
                Resultant resultant4 = mult.resultant();
                BigIntPolynomial mult2 = integerPolynomial7.mult(bigIntPolynomial3);
                mult2.add(integerPolynomial8.mult(bigIntPolynomial2));
                bigIntPolynomial = mult2.mult(resultant4.rho);
                bigIntPolynomial.div(resultant4.res);
            } else {
                int i20 = 0;
                for (int i21 = 1; i21 < i9; i21 *= 10) {
                    i20++;
                }
                BigDecimalPolynomial div = resultant.rho.div(new BigDecimal(resultant.res), bigIntPolynomial3.getMaxCoeffLength() + 1 + i20);
                BigDecimalPolynomial div2 = resultant2.rho.div(new BigDecimal(resultant2.res), bigIntPolynomial2.getMaxCoeffLength() + 1 + i20);
                BigDecimalPolynomial mult3 = div.mult(bigIntPolynomial3);
                mult3.add(div2.mult(bigIntPolynomial2));
                mult3.halve();
                bigIntPolynomial = mult3.round();
            }
            BigIntPolynomial bigIntPolynomial4 = (BigIntPolynomial) bigIntPolynomial3.clone();
            bigIntPolynomial4.sub(polynomial3.mult(bigIntPolynomial));
            BigIntPolynomial bigIntPolynomial5 = (BigIntPolynomial) bigIntPolynomial2.clone();
            bigIntPolynomial5.sub(polynomial4.mult(bigIntPolynomial));
            IntegerPolynomial integerPolynomial9 = new IntegerPolynomial(bigIntPolynomial4);
            IntegerPolynomial integerPolynomial10 = new IntegerPolynomial(bigIntPolynomial5);
            int i22 = 0;
            for (int i23 = 0; i23 < i9; i23++) {
                int[] iArr3 = integerPolynomial2.coeffs;
                int i24 = iArr3[i23] * iArr3[i23];
                int[] iArr4 = integerPolynomial4.coeffs;
                i22 += ((iArr4[i23] * iArr4[i23]) + i24) * i16;
            }
            int i25 = i22 - 4;
            IntegerPolynomial integerPolynomial11 = (IntegerPolynomial) integerPolynomial2.clone();
            IntegerPolynomial integerPolynomial12 = (IntegerPolynomial) integerPolynomial4.clone();
            int i26 = 0;
            int i27 = 0;
            while (i26 < i9 && i27 < i9) {
                int i28 = 0;
                int i29 = 0;
                while (i28 < i9) {
                    i29 = (((integerPolynomial9.coeffs[i28] * integerPolynomial2.coeffs[i28]) + (integerPolynomial10.coeffs[i28] * integerPolynomial4.coeffs[i28])) * i9 * 4) + i29;
                    i28++;
                    i27 = i27;
                    polynomial3 = polynomial3;
                    integerPolynomial2 = integerPolynomial2;
                }
                int sumCoeffs = i29 - ((integerPolynomial10.sumCoeffs() + integerPolynomial9.sumCoeffs()) * 4);
                if (sumCoeffs > i25) {
                    integerPolynomial9.sub(integerPolynomial11);
                    integerPolynomial10.sub(integerPolynomial12);
                } else if (sumCoeffs < (-i25)) {
                    integerPolynomial9.add(integerPolynomial11);
                    integerPolynomial10.add(integerPolynomial12);
                } else {
                    i7 = i27;
                    i8 = 1;
                    i27 = i7 + i8;
                    integerPolynomial11.rotate1();
                    integerPolynomial12.rotate1();
                    polynomial3 = polynomial3;
                    integerPolynomial2 = integerPolynomial2;
                }
                i26++;
                i8 = 1;
                i7 = 0;
                i27 = i7 + i8;
                integerPolynomial11.rotate1();
                integerPolynomial12.rotate1();
                polynomial3 = polynomial3;
                integerPolynomial2 = integerPolynomial2;
            }
            if (i == 0) {
                integerPolynomial5 = polynomial4.mult(integerPolynomial3, i10);
                integerPolynomial6 = integerPolynomial9;
            } else {
                integerPolynomial5 = integerPolynomial9.mult(integerPolynomial3, i10);
                integerPolynomial6 = polynomial4;
            }
            integerPolynomial5.modPositive(i10);
            fGBasis = new FGBasis(this, polynomial3, integerPolynomial6, integerPolynomial5, integerPolynomial9, integerPolynomial10, this.a);
            NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters2 = fGBasis.a;
            double d = nTRUSigningKeyGenerationParameters2.keyNormBoundSq;
            int i30 = nTRUSigningKeyGenerationParameters2.q;
            if (((double) fGBasis.F.centeredNormSq(i30)) >= d || ((double) fGBasis.G.centeredNormSq(i30)) >= d) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
        } while (!z);
        return fGBasis;
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ArrayList arrayList = new ArrayList();
        int i = this.a.B;
        while (true) {
            nTRUSigningPublicKeyParameters = null;
            if (i < 0) {
                break;
            }
            arrayList.add(newCachedThreadPool.submit(new b(null)));
            i--;
        }
        newCachedThreadPool.shutdown();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = this.a.B; i2 >= 0; i2--) {
            Future future = (Future) arrayList.get(i2);
            try {
                arrayList2.add(future.get());
                if (i2 == this.a.B) {
                    nTRUSigningPublicKeyParameters = new NTRUSigningPublicKeyParameters(((NTRUSigningPrivateKeyParameters.Basis) future.get()).h, this.a.getSigningParameters());
                }
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) nTRUSigningPublicKeyParameters, (AsymmetricKeyParameter) new NTRUSigningPrivateKeyParameters(arrayList2, nTRUSigningPublicKeyParameters));
    }

    public AsymmetricCipherKeyPair generateKeyPairSingleThread() {
        ArrayList arrayList = new ArrayList();
        NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters = null;
        for (int i = this.a.B; i >= 0; i--) {
            NTRUSigningPrivateKeyParameters.Basis generateBoundedBasis = generateBoundedBasis();
            arrayList.add(generateBoundedBasis);
            if (i == 0) {
                nTRUSigningPublicKeyParameters = new NTRUSigningPublicKeyParameters(generateBoundedBasis.h, this.a.getSigningParameters());
            }
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) nTRUSigningPublicKeyParameters, (AsymmetricKeyParameter) new NTRUSigningPrivateKeyParameters(arrayList, nTRUSigningPublicKeyParameters));
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.a = (NTRUSigningKeyGenerationParameters) keyGenerationParameters;
    }
}
