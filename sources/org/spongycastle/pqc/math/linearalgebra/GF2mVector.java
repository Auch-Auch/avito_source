package org.spongycastle.pqc.math.linearalgebra;
public class GF2mVector extends Vector {
    public GF2mField a;
    public int[] b;

    public GF2mVector(GF2mField gF2mField, byte[] bArr) {
        this.a = new GF2mField(gF2mField);
        int i = 8;
        int i2 = 1;
        while (gF2mField.getDegree() > i) {
            i2++;
            i += 8;
        }
        if (bArr.length % i2 == 0) {
            int length = bArr.length / i2;
            this.length = length;
            this.b = new int[length];
            int i3 = 0;
            for (int i4 = 0; i4 < this.b.length; i4++) {
                int i5 = 0;
                while (i5 < i) {
                    int[] iArr = this.b;
                    iArr[i4] = ((bArr[i3] & 255) << i5) | iArr[i4];
                    i5 += 8;
                    i3++;
                }
                if (!gF2mField.isElementOfThisField(this.b[i4])) {
                    throw new IllegalArgumentException("Byte array is not an encoded vector over the given finite field.");
                }
            }
            return;
        }
        throw new IllegalArgumentException("Byte array is not an encoded vector over the given finite field.");
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Vector
    public Vector add(Vector vector) {
        throw new RuntimeException("not implemented");
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Vector
    public boolean equals(Object obj) {
        if (!(obj instanceof GF2mVector)) {
            return false;
        }
        GF2mVector gF2mVector = (GF2mVector) obj;
        if (!this.a.equals(gF2mVector.a)) {
            return false;
        }
        return IntUtils.equals(this.b, gF2mVector.b);
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Vector
    public byte[] getEncoded() {
        int i = 8;
        int i2 = 1;
        while (this.a.getDegree() > i) {
            i2++;
            i += 8;
        }
        byte[] bArr = new byte[(this.b.length * i2)];
        int i3 = 0;
        for (int i4 = 0; i4 < this.b.length; i4++) {
            int i5 = 0;
            while (i5 < i) {
                bArr[i3] = (byte) (this.b[i4] >>> i5);
                i5 += 8;
                i3++;
            }
        }
        return bArr;
    }

    public GF2mField getField() {
        return this.a;
    }

    public int[] getIntArrayForm() {
        return IntUtils.clone(this.b);
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Vector
    public int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Vector
    public boolean isZero() {
        for (int length = this.b.length - 1; length >= 0; length--) {
            if (this.b[length] != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Vector
    public Vector multiply(Permutation permutation) {
        int[] vector = permutation.getVector();
        int i = this.length;
        if (i == vector.length) {
            int[] iArr = new int[i];
            for (int i2 = 0; i2 < vector.length; i2++) {
                iArr[i2] = this.b[vector[i2]];
            }
            return new GF2mVector(this.a, iArr);
        }
        throw new ArithmeticException("permutation size and vector size mismatch");
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Vector
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.b.length; i++) {
            for (int i2 = 0; i2 < this.a.getDegree(); i2++) {
                if (((1 << (i2 & 31)) & this.b[i]) != 0) {
                    stringBuffer.append('1');
                } else {
                    stringBuffer.append('0');
                }
            }
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    public GF2mVector(GF2mField gF2mField, int[] iArr) {
        this.a = gF2mField;
        this.length = iArr.length;
        for (int length = iArr.length - 1; length >= 0; length--) {
            if (!gF2mField.isElementOfThisField(iArr[length])) {
                throw new ArithmeticException("Element array is not specified over the given finite field.");
            }
        }
        this.b = IntUtils.clone(iArr);
    }

    public GF2mVector(GF2mVector gF2mVector) {
        this.a = new GF2mField(gF2mVector.a);
        this.length = gF2mVector.length;
        this.b = IntUtils.clone(gF2mVector.b);
    }
}
