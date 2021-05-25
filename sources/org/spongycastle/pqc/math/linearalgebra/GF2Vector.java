package org.spongycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;
public class GF2Vector extends Vector {
    public int[] a;

    public GF2Vector(int i) {
        if (i >= 0) {
            this.length = i;
            this.a = new int[((i + 31) >> 5)];
            return;
        }
        throw new ArithmeticException("Negative length.");
    }

    public static GF2Vector OS2VP(int i, byte[] bArr) {
        if (i >= 0) {
            if (bArr.length <= ((i + 7) >> 3)) {
                return new GF2Vector(i, LittleEndianConversions.toIntArray(bArr));
            }
            throw new ArithmeticException("length mismatch");
        }
        throw new ArithmeticException("negative length");
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Vector
    public Vector add(Vector vector) {
        if (vector instanceof GF2Vector) {
            GF2Vector gF2Vector = (GF2Vector) vector;
            if (this.length == gF2Vector.length) {
                int[] clone = IntUtils.clone(gF2Vector.a);
                for (int length = clone.length - 1; length >= 0; length--) {
                    clone[length] = clone[length] ^ this.a[length];
                }
                return new GF2Vector(this.length, clone);
            }
            throw new ArithmeticException("length mismatch");
        }
        throw new ArithmeticException("vector is not defined over GF(2)");
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Vector
    public boolean equals(Object obj) {
        if (!(obj instanceof GF2Vector)) {
            return false;
        }
        GF2Vector gF2Vector = (GF2Vector) obj;
        if (this.length != gF2Vector.length || !IntUtils.equals(this.a, gF2Vector.a)) {
            return false;
        }
        return true;
    }

    public GF2Vector extractLeftVector(int i) {
        int i2 = this.length;
        if (i > i2) {
            throw new ArithmeticException("invalid length");
        } else if (i == i2) {
            return new GF2Vector(this);
        } else {
            GF2Vector gF2Vector = new GF2Vector(i);
            int i3 = i >> 5;
            int i4 = i & 31;
            System.arraycopy(this.a, 0, gF2Vector.a, 0, i3);
            if (i4 != 0) {
                gF2Vector.a[i3] = ((1 << i4) - 1) & this.a[i3];
            }
            return gF2Vector;
        }
    }

    public GF2Vector extractRightVector(int i) {
        int i2;
        int i3 = this.length;
        if (i > i3) {
            throw new ArithmeticException("invalid length");
        } else if (i == i3) {
            return new GF2Vector(this);
        } else {
            GF2Vector gF2Vector = new GF2Vector(i);
            int i4 = this.length;
            int i5 = (i4 - i) >> 5;
            int i6 = (i4 - i) & 31;
            int i7 = (i + 31) >> 5;
            int i8 = 0;
            if (i6 != 0) {
                while (true) {
                    i2 = i7 - 1;
                    if (i8 >= i2) {
                        break;
                    }
                    int[] iArr = gF2Vector.a;
                    int[] iArr2 = this.a;
                    int i9 = i5 + 1;
                    iArr[i8] = (iArr2[i5] >>> i6) | (iArr2[i9] << (32 - i6));
                    i8++;
                    i5 = i9;
                }
                int[] iArr3 = gF2Vector.a;
                int[] iArr4 = this.a;
                int i10 = i5 + 1;
                iArr3[i2] = iArr4[i5] >>> i6;
                if (i10 < iArr4.length) {
                    iArr3[i2] = (iArr4[i10] << (32 - i6)) | iArr3[i2];
                }
            } else {
                System.arraycopy(this.a, i5, gF2Vector.a, 0, i7);
            }
            return gF2Vector;
        }
    }

    public GF2Vector extractVector(int[] iArr) {
        int length = iArr.length;
        if (iArr[length - 1] <= this.length) {
            GF2Vector gF2Vector = new GF2Vector(length);
            for (int i = 0; i < length; i++) {
                if ((this.a[iArr[i] >> 5] & (1 << (iArr[i] & 31))) != 0) {
                    int[] iArr2 = gF2Vector.a;
                    int i2 = i >> 5;
                    iArr2[i2] = (1 << (i & 31)) | iArr2[i2];
                }
            }
            return gF2Vector;
        }
        throw new ArithmeticException("invalid index set");
    }

    public int getBit(int i) {
        if (i < this.length) {
            int i2 = i >> 5;
            int i3 = i & 31;
            return (this.a[i2] & (1 << i3)) >>> i3;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Vector
    public byte[] getEncoded() {
        return LittleEndianConversions.toByteArray(this.a, (this.length + 7) >> 3);
    }

    public int getHammingWeight() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i >= iArr.length) {
                return i2;
            }
            int i3 = iArr[i];
            for (int i4 = 0; i4 < 32; i4++) {
                if ((i3 & 1) != 0) {
                    i2++;
                }
                i3 >>>= 1;
            }
            i++;
        }
    }

    public int[] getVecArray() {
        return this.a;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Vector
    public int hashCode() {
        return this.a.hashCode() + (this.length * 31);
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Vector
    public boolean isZero() {
        for (int length = this.a.length - 1; length >= 0; length--) {
            if (this.a[length] != 0) {
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
            GF2Vector gF2Vector = new GF2Vector(i);
            for (int i2 = 0; i2 < vector.length; i2++) {
                if ((this.a[vector[i2] >> 5] & (1 << (vector[i2] & 31))) != 0) {
                    int[] iArr = gF2Vector.a;
                    int i3 = i2 >> 5;
                    iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
                }
            }
            return gF2Vector;
        }
        throw new ArithmeticException("length mismatch");
    }

    public void setBit(int i) {
        if (i < this.length) {
            int[] iArr = this.a;
            int i2 = i >> 5;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public GF2mVector toExtensionFieldVector(GF2mField gF2mField) {
        int degree = gF2mField.getDegree();
        int i = this.length;
        if (i % degree == 0) {
            int i2 = i / degree;
            int[] iArr = new int[i2];
            int i3 = 0;
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                for (int degree2 = gF2mField.getDegree() - 1; degree2 >= 0; degree2--) {
                    if (((this.a[i3 >>> 5] >>> (i3 & 31)) & 1) == 1) {
                        iArr[i4] = iArr[i4] ^ (1 << degree2);
                    }
                    i3++;
                }
            }
            return new GF2mVector(gF2mField, iArr);
        }
        throw new ArithmeticException("conversion is impossible");
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Vector
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.length; i++) {
            if (i != 0 && (i & 31) == 0) {
                stringBuffer.append(' ');
            }
            if ((this.a[i >> 5] & (1 << (i & 31))) == 0) {
                stringBuffer.append('0');
            } else {
                stringBuffer.append('1');
            }
        }
        return stringBuffer.toString();
    }

    public GF2Vector(int i, SecureRandom secureRandom) {
        this.length = i;
        int i2 = (i + 31) >> 5;
        this.a = new int[i2];
        int i3 = i2 - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            this.a[i4] = secureRandom.nextInt();
        }
        int i5 = i & 31;
        if (i5 != 0) {
            int[] iArr = this.a;
            iArr[i3] = ((1 << i5) - 1) & iArr[i3];
        }
    }

    public GF2Vector(int i, int i2, SecureRandom secureRandom) {
        if (i2 <= i) {
            this.length = i;
            this.a = new int[((i + 31) >> 5)];
            int[] iArr = new int[i];
            for (int i3 = 0; i3 < i; i3++) {
                iArr[i3] = i3;
            }
            for (int i4 = 0; i4 < i2; i4++) {
                int a3 = RandUtils.a(secureRandom, i);
                setBit(iArr[a3]);
                i--;
                iArr[a3] = iArr[i];
            }
            return;
        }
        throw new ArithmeticException("The hamming weight is greater than the length of vector.");
    }

    public GF2Vector(int i, int[] iArr) {
        if (i >= 0) {
            this.length = i;
            int i2 = (i + 31) >> 5;
            if (iArr.length == i2) {
                int[] clone = IntUtils.clone(iArr);
                this.a = clone;
                int i3 = i & 31;
                if (i3 != 0) {
                    int i4 = i2 - 1;
                    clone[i4] = ((1 << i3) - 1) & clone[i4];
                    return;
                }
                return;
            }
            throw new ArithmeticException("length mismatch");
        }
        throw new ArithmeticException("negative length");
    }

    public GF2Vector(GF2Vector gF2Vector) {
        this.length = gF2Vector.length;
        this.a = IntUtils.clone(gF2Vector.a);
    }

    public GF2Vector(int[] iArr, int i) {
        this.a = iArr;
        this.length = i;
    }
}
