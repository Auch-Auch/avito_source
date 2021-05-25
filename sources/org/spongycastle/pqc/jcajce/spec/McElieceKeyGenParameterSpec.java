package org.spongycastle.pqc.jcajce.spec;

import java.security.InvalidParameterException;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2;
public class McElieceKeyGenParameterSpec implements AlgorithmParameterSpec {
    public static final int DEFAULT_M = 11;
    public static final int DEFAULT_T = 50;
    public int a;
    public int b;
    public int c;
    public int d;

    public McElieceKeyGenParameterSpec() {
        this(11, 50);
    }

    public int getFieldPoly() {
        return this.d;
    }

    public int getM() {
        return this.a;
    }

    public int getN() {
        return this.c;
    }

    public int getT() {
        return this.b;
    }

    public McElieceKeyGenParameterSpec(int i) {
        if (i >= 1) {
            this.a = 0;
            this.c = 1;
            while (true) {
                int i2 = this.c;
                if (i2 < i) {
                    this.c = i2 << 1;
                    this.a++;
                } else {
                    int i3 = i2 >>> 1;
                    this.b = i3;
                    int i4 = this.a;
                    this.b = i3 / i4;
                    this.d = PolynomialRingGF2.getIrreduciblePolynomial(i4);
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("key size must be positive");
        }
    }

    public McElieceKeyGenParameterSpec(int i, int i2) throws InvalidParameterException {
        if (i < 1) {
            throw new IllegalArgumentException("m must be positive");
        } else if (i <= 32) {
            this.a = i;
            int i3 = 1 << i;
            this.c = i3;
            if (i2 < 0) {
                throw new IllegalArgumentException("t must be positive");
            } else if (i2 <= i3) {
                this.b = i2;
                this.d = PolynomialRingGF2.getIrreduciblePolynomial(i);
            } else {
                throw new IllegalArgumentException("t must be less than n = 2^m");
            }
        } else {
            throw new IllegalArgumentException("m is too large");
        }
    }

    public McElieceKeyGenParameterSpec(int i, int i2, int i3) {
        this.a = i;
        if (i < 1) {
            throw new IllegalArgumentException("m must be positive");
        } else if (i <= 32) {
            int i4 = 1 << i;
            this.c = i4;
            this.b = i2;
            if (i2 < 0) {
                throw new IllegalArgumentException("t must be positive");
            } else if (i2 > i4) {
                throw new IllegalArgumentException("t must be less than n = 2^m");
            } else if (PolynomialRingGF2.degree(i3) != i || !PolynomialRingGF2.isIrreducible(i3)) {
                throw new IllegalArgumentException("polynomial is not a field polynomial for GF(2^m)");
            } else {
                this.d = i3;
            }
        } else {
            throw new IllegalArgumentException(" m is too large");
        }
    }
}
