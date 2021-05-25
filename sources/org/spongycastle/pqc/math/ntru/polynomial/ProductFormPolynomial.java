package org.spongycastle.pqc.math.ntru.polynomial;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import org.spongycastle.util.Arrays;
public class ProductFormPolynomial implements Polynomial {
    public SparseTernaryPolynomial a;
    public SparseTernaryPolynomial b;
    public SparseTernaryPolynomial c;

    public ProductFormPolynomial(SparseTernaryPolynomial sparseTernaryPolynomial, SparseTernaryPolynomial sparseTernaryPolynomial2, SparseTernaryPolynomial sparseTernaryPolynomial3) {
        this.a = sparseTernaryPolynomial;
        this.b = sparseTernaryPolynomial2;
        this.c = sparseTernaryPolynomial3;
    }

    public static ProductFormPolynomial fromBinary(byte[] bArr, int i, int i2, int i3, int i4, int i5) throws IOException {
        return fromBinary(new ByteArrayInputStream(bArr), i, i2, i3, i4, i5);
    }

    public static ProductFormPolynomial generateRandom(int i, int i2, int i3, int i4, int i5, SecureRandom secureRandom) {
        return new ProductFormPolynomial(SparseTernaryPolynomial.generateRandom(i, i2, i2, secureRandom), SparseTernaryPolynomial.generateRandom(i, i3, i3, secureRandom), SparseTernaryPolynomial.generateRandom(i, i4, i5, secureRandom));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ProductFormPolynomial productFormPolynomial = (ProductFormPolynomial) obj;
        SparseTernaryPolynomial sparseTernaryPolynomial = this.a;
        if (sparseTernaryPolynomial == null) {
            if (productFormPolynomial.a != null) {
                return false;
            }
        } else if (!sparseTernaryPolynomial.equals(productFormPolynomial.a)) {
            return false;
        }
        SparseTernaryPolynomial sparseTernaryPolynomial2 = this.b;
        if (sparseTernaryPolynomial2 == null) {
            if (productFormPolynomial.b != null) {
                return false;
            }
        } else if (!sparseTernaryPolynomial2.equals(productFormPolynomial.b)) {
            return false;
        }
        SparseTernaryPolynomial sparseTernaryPolynomial3 = this.c;
        if (sparseTernaryPolynomial3 == null) {
            if (productFormPolynomial.c != null) {
                return false;
            }
        } else if (!sparseTernaryPolynomial3.equals(productFormPolynomial.c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        SparseTernaryPolynomial sparseTernaryPolynomial = this.a;
        int i = 0;
        int hashCode = ((sparseTernaryPolynomial == null ? 0 : sparseTernaryPolynomial.hashCode()) + 31) * 31;
        SparseTernaryPolynomial sparseTernaryPolynomial2 = this.b;
        int hashCode2 = (hashCode + (sparseTernaryPolynomial2 == null ? 0 : sparseTernaryPolynomial2.hashCode())) * 31;
        SparseTernaryPolynomial sparseTernaryPolynomial3 = this.c;
        if (sparseTernaryPolynomial3 != null) {
            i = sparseTernaryPolynomial3.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.Polynomial
    public IntegerPolynomial mult(IntegerPolynomial integerPolynomial) {
        IntegerPolynomial mult = this.b.mult(this.a.mult(integerPolynomial));
        mult.add(this.c.mult(integerPolynomial));
        return mult;
    }

    public byte[] toBinary() {
        byte[] binary = this.a.toBinary();
        byte[] binary2 = this.b.toBinary();
        byte[] binary3 = this.c.toBinary();
        byte[] copyOf = Arrays.copyOf(binary, binary.length + binary2.length + binary3.length);
        System.arraycopy(binary2, 0, copyOf, binary.length, binary2.length);
        System.arraycopy(binary3, 0, copyOf, binary.length + binary2.length, binary3.length);
        return copyOf;
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.Polynomial
    public IntegerPolynomial toIntegerPolynomial() {
        IntegerPolynomial mult = this.a.mult(this.b.toIntegerPolynomial());
        mult.add(this.c.toIntegerPolynomial());
        return mult;
    }

    public static ProductFormPolynomial fromBinary(InputStream inputStream, int i, int i2, int i3, int i4, int i5) throws IOException {
        return new ProductFormPolynomial(SparseTernaryPolynomial.fromBinary(inputStream, i, i2, i2), SparseTernaryPolynomial.fromBinary(inputStream, i, i3, i3), SparseTernaryPolynomial.fromBinary(inputStream, i, i4, i5));
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.Polynomial
    public BigIntPolynomial mult(BigIntPolynomial bigIntPolynomial) {
        BigIntPolynomial mult = this.b.mult(this.a.mult(bigIntPolynomial));
        mult.add(this.c.mult(bigIntPolynomial));
        return mult;
    }

    @Override // org.spongycastle.pqc.math.ntru.polynomial.Polynomial
    public IntegerPolynomial mult(IntegerPolynomial integerPolynomial, int i) {
        IntegerPolynomial mult = mult(integerPolynomial);
        mult.mod(i);
        return mult;
    }
}
