package org.spongycastle.pqc.crypto.ntru;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;
import org.spongycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.SparseTernaryPolynomial;
public class NTRUSigningPrivateKeyParameters extends AsymmetricKeyParameter {
    public List<Basis> b;
    public NTRUSigningPublicKeyParameters c;

    public NTRUSigningPrivateKeyParameters(byte[] bArr, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) throws IOException {
        this(new ByteArrayInputStream(bArr), nTRUSigningKeyGenerationParameters);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NTRUSigningPrivateKeyParameters nTRUSigningPrivateKeyParameters = (NTRUSigningPrivateKeyParameters) obj;
        List<Basis> list = this.b;
        if ((list == null) != (nTRUSigningPrivateKeyParameters.b == null)) {
            return false;
        }
        if (list == null) {
            return true;
        }
        if (list.size() != nTRUSigningPrivateKeyParameters.b.size()) {
            return false;
        }
        for (int i = 0; i < this.b.size(); i++) {
            Basis basis = this.b.get(i);
            Basis basis2 = nTRUSigningPrivateKeyParameters.b.get(i);
            if (!(basis.f.equals(basis2.f) && basis.fPrime.equals(basis2.fPrime))) {
                return false;
            }
            if (!((i == 0 || basis.h.equals(basis2.h)) && basis.a.equals(basis2.a))) {
                return false;
            }
        }
        return true;
    }

    public Basis getBasis(int i) {
        return this.b.get(i);
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < this.b.size()) {
            Basis basis = this.b.get(i);
            boolean z = i != 0;
            int i2 = basis.a.q;
            byteArrayOutputStream.write(basis.a(basis.f));
            if (basis.a.basisType == 0) {
                IntegerPolynomial integerPolynomial = basis.fPrime.toIntegerPolynomial();
                int i3 = 0;
                while (true) {
                    int[] iArr = integerPolynomial.coeffs;
                    if (i3 >= iArr.length) {
                        break;
                    }
                    iArr[i3] = (i2 / 2) + iArr[i3];
                    i3++;
                }
                byteArrayOutputStream.write(integerPolynomial.toBinary(i2));
            } else {
                byteArrayOutputStream.write(basis.a(basis.fPrime));
            }
            if (z) {
                byteArrayOutputStream.write(basis.h.toBinary(i2));
            }
            i++;
        }
        byteArrayOutputStream.write(this.c.getEncoded());
        return byteArrayOutputStream.toByteArray();
    }

    public NTRUSigningPublicKeyParameters getPublicKey() {
        return this.c;
    }

    public int hashCode() {
        List<Basis> list = this.b;
        if (list == null) {
            return 31;
        }
        int hashCode = list.hashCode() + 31;
        for (Basis basis : this.b) {
            hashCode += basis.hashCode();
        }
        return hashCode;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(getEncoded());
    }

    public NTRUSigningPrivateKeyParameters(InputStream inputStream, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) throws IOException {
        super(true);
        this.b = new ArrayList();
        int i = 0;
        while (i <= nTRUSigningKeyGenerationParameters.B) {
            this.b.add(new Basis(inputStream, nTRUSigningKeyGenerationParameters, i != 0));
            i++;
        }
        this.c = new NTRUSigningPublicKeyParameters(inputStream, nTRUSigningKeyGenerationParameters.getSigningParameters());
    }

    public static class Basis {
        public NTRUSigningKeyGenerationParameters a;
        public Polynomial f;
        public Polynomial fPrime;
        public IntegerPolynomial h;

        public Basis(Polynomial polynomial, Polynomial polynomial2, IntegerPolynomial integerPolynomial, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) {
            this.f = polynomial;
            this.fPrime = polynomial2;
            this.h = integerPolynomial;
            this.a = nTRUSigningKeyGenerationParameters;
        }

        public final byte[] a(Polynomial polynomial) {
            if (polynomial instanceof ProductFormPolynomial) {
                return ((ProductFormPolynomial) polynomial).toBinary();
            }
            return polynomial.toIntegerPolynomial().toBinary3Tight();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof Basis)) {
                return false;
            }
            Basis basis = (Basis) obj;
            Polynomial polynomial = this.f;
            if (polynomial == null) {
                if (basis.f != null) {
                    return false;
                }
            } else if (!polynomial.equals(basis.f)) {
                return false;
            }
            Polynomial polynomial2 = this.fPrime;
            if (polynomial2 == null) {
                if (basis.fPrime != null) {
                    return false;
                }
            } else if (!polynomial2.equals(basis.fPrime)) {
                return false;
            }
            IntegerPolynomial integerPolynomial = this.h;
            if (integerPolynomial == null) {
                if (basis.h != null) {
                    return false;
                }
            } else if (!integerPolynomial.equals(basis.h)) {
                return false;
            }
            NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = this.a;
            if (nTRUSigningKeyGenerationParameters == null) {
                if (basis.a != null) {
                    return false;
                }
            } else if (!nTRUSigningKeyGenerationParameters.equals(basis.a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            Polynomial polynomial = this.f;
            int i = 0;
            int hashCode = ((polynomial == null ? 0 : polynomial.hashCode()) + 31) * 31;
            Polynomial polynomial2 = this.fPrime;
            int hashCode2 = (hashCode + (polynomial2 == null ? 0 : polynomial2.hashCode())) * 31;
            IntegerPolynomial integerPolynomial = this.h;
            int hashCode3 = (hashCode2 + (integerPolynomial == null ? 0 : integerPolynomial.hashCode())) * 31;
            NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = this.a;
            if (nTRUSigningKeyGenerationParameters != null) {
                i = nTRUSigningKeyGenerationParameters.hashCode();
            }
            return hashCode3 + i;
        }

        public Basis(InputStream inputStream, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters, boolean z) throws IOException {
            int i = nTRUSigningKeyGenerationParameters.N;
            int i2 = nTRUSigningKeyGenerationParameters.q;
            int i3 = nTRUSigningKeyGenerationParameters.d1;
            int i4 = nTRUSigningKeyGenerationParameters.d2;
            int i5 = nTRUSigningKeyGenerationParameters.d3;
            boolean z2 = nTRUSigningKeyGenerationParameters.sparse;
            this.a = nTRUSigningKeyGenerationParameters;
            if (nTRUSigningKeyGenerationParameters.polyType == 1) {
                this.f = ProductFormPolynomial.fromBinary(inputStream, i, i3, i4, i5 + 1, i5);
            } else {
                IntegerPolynomial fromBinary3Tight = IntegerPolynomial.fromBinary3Tight(inputStream, i);
                this.f = z2 ? new SparseTernaryPolynomial(fromBinary3Tight) : new DenseTernaryPolynomial(fromBinary3Tight);
            }
            if (nTRUSigningKeyGenerationParameters.basisType == 0) {
                IntegerPolynomial fromBinary = IntegerPolynomial.fromBinary(inputStream, i, i2);
                int i6 = 0;
                while (true) {
                    int[] iArr = fromBinary.coeffs;
                    if (i6 >= iArr.length) {
                        break;
                    }
                    iArr[i6] = iArr[i6] - (i2 / 2);
                    i6++;
                }
                this.fPrime = fromBinary;
            } else if (nTRUSigningKeyGenerationParameters.polyType == 1) {
                this.fPrime = ProductFormPolynomial.fromBinary(inputStream, i, i3, i4, i5 + 1, i5);
            } else {
                this.fPrime = IntegerPolynomial.fromBinary3Tight(inputStream, i);
            }
            if (z) {
                this.h = IntegerPolynomial.fromBinary(inputStream, i, i2);
            }
        }
    }

    public NTRUSigningPrivateKeyParameters(List<Basis> list, NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters) {
        super(true);
        this.b = new ArrayList(list);
        this.c = nTRUSigningPublicKeyParameters;
    }
}
