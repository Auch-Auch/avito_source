package org.spongycastle.pqc.math.linearalgebra;

import a2.b.a.a.a;
import java.security.SecureRandom;
public class GF2mField {
    public int a = 0;
    public int b;

    public GF2mField(int i) {
        if (i >= 32) {
            throw new IllegalArgumentException(" Error: the degree of field is too large ");
        } else if (i >= 1) {
            this.a = i;
            this.b = PolynomialRingGF2.getIrreduciblePolynomial(i);
        } else {
            throw new IllegalArgumentException(" Error: the degree of field is non-positive ");
        }
    }

    public int add(int i, int i2) {
        return i ^ i2;
    }

    public String elementToStr(int i) {
        String str = "";
        for (int i2 = 0; i2 < this.a; i2++) {
            if ((((byte) i) & 1) == 0) {
                str = a.c3("0", str);
            } else {
                str = a.c3("1", str);
            }
            i >>>= 1;
        }
        return str;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof GF2mField)) {
            GF2mField gF2mField = (GF2mField) obj;
            if (this.a == gF2mField.a && this.b == gF2mField.b) {
                return true;
            }
        }
        return false;
    }

    public int exp(int i, int i2) {
        if (i2 == 0) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        if (i2 < 0) {
            i = inverse(i);
            i2 = -i2;
        }
        int i3 = 1;
        while (i2 != 0) {
            if ((i2 & 1) == 1) {
                i3 = mult(i3, i);
            }
            i = mult(i, i);
            i2 >>>= 1;
        }
        return i3;
    }

    public int getDegree() {
        return this.a;
    }

    public byte[] getEncoded() {
        return LittleEndianConversions.I2OSP(this.b);
    }

    public int getPolynomial() {
        return this.b;
    }

    public int getRandomElement(SecureRandom secureRandom) {
        return RandUtils.a(secureRandom, 1 << this.a);
    }

    public int getRandomNonZeroElement() {
        return getRandomNonZeroElement(new SecureRandom());
    }

    public int hashCode() {
        return this.b;
    }

    public int inverse(int i) {
        return exp(i, (1 << this.a) - 2);
    }

    public boolean isElementOfThisField(int i) {
        int i2 = this.a;
        return i2 == 31 ? i >= 0 : i >= 0 && i < (1 << i2);
    }

    public int mult(int i, int i2) {
        return PolynomialRingGF2.modMultiply(i, i2, this.b);
    }

    public int sqRoot(int i) {
        for (int i2 = 1; i2 < this.a; i2++) {
            i = mult(i, i);
        }
        return i;
    }

    public String toString() {
        String str;
        StringBuilder L = a.L("Finite Field GF(2^");
        L.append(this.a);
        L.append(") = GF(2)[X]/<");
        int i = this.b;
        if (i == 0) {
            str = "0";
        } else {
            String str2 = ((byte) (i & 1)) == 1 ? "1" : "";
            int i2 = i >>> 1;
            int i3 = 1;
            while (i2 != 0) {
                if (((byte) (i2 & 1)) == 1) {
                    str2 = str2 + "+x^" + i3;
                }
                i2 >>>= 1;
                i3++;
            }
            str = str2;
        }
        return a.t(L, str, "> ");
    }

    public int getRandomNonZeroElement(SecureRandom secureRandom) {
        int a3 = RandUtils.a(secureRandom, 1 << this.a);
        int i = 0;
        while (a3 == 0 && i < 1048576) {
            a3 = RandUtils.a(secureRandom, 1 << this.a);
            i++;
        }
        if (i == 1048576) {
            return 1;
        }
        return a3;
    }

    public GF2mField(int i, int i2) {
        if (i != PolynomialRingGF2.degree(i2)) {
            throw new IllegalArgumentException(" Error: the degree is not correct");
        } else if (PolynomialRingGF2.isIrreducible(i2)) {
            this.a = i;
            this.b = i2;
        } else {
            throw new IllegalArgumentException(" Error: given polynomial is reducible");
        }
    }

    public GF2mField(byte[] bArr) {
        if (bArr.length == 4) {
            int OS2IP = LittleEndianConversions.OS2IP(bArr);
            this.b = OS2IP;
            if (PolynomialRingGF2.isIrreducible(OS2IP)) {
                this.a = PolynomialRingGF2.degree(this.b);
                return;
            }
            throw new IllegalArgumentException("byte array is not an encoded finite field");
        }
        throw new IllegalArgumentException("byte array is not an encoded finite field");
    }

    public GF2mField(GF2mField gF2mField) {
        this.a = gF2mField.a;
        this.b = gF2mField.b;
    }
}
