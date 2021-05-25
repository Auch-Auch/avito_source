package org.spongycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;
import java.security.SecureRandom;
public class GF2Matrix extends Matrix {
    public int[][] a;
    public int b;

    public GF2Matrix(byte[] bArr) {
        if (bArr.length >= 9) {
            this.numRows = LittleEndianConversions.OS2IP(bArr, 0);
            int OS2IP = LittleEndianConversions.OS2IP(bArr, 4);
            this.numColumns = OS2IP;
            int i = this.numRows;
            int i2 = ((OS2IP + 7) >>> 3) * i;
            if (i > 0) {
                int i3 = 8;
                if (i2 == bArr.length - 8) {
                    int i4 = (OS2IP + 31) >>> 5;
                    this.b = i4;
                    int[] iArr = new int[2];
                    iArr[1] = i4;
                    iArr[0] = i;
                    this.a = (int[][]) Array.newInstance(int.class, iArr);
                    int i5 = this.numColumns;
                    int i6 = i5 >> 5;
                    int i7 = i5 & 31;
                    for (int i8 = 0; i8 < this.numRows; i8++) {
                        int i9 = 0;
                        while (i9 < i6) {
                            this.a[i8][i9] = LittleEndianConversions.OS2IP(bArr, i3);
                            i9++;
                            i3 += 4;
                        }
                        int i10 = 0;
                        while (i10 < i7) {
                            int[] iArr2 = this.a[i8];
                            iArr2[i6] = ((bArr[i3] & 255) << i10) ^ iArr2[i6];
                            i10 += 8;
                            i3++;
                        }
                    }
                    return;
                }
            }
            throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
        }
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x004e: APUT  
      (r3v0 org.spongycastle.pqc.math.linearalgebra.GF2Matrix[])
      (0 ??[int, short, byte, char])
      (wrap: org.spongycastle.pqc.math.linearalgebra.GF2Matrix : 0x004b: CONSTRUCTOR  (r1v2 org.spongycastle.pqc.math.linearalgebra.GF2Matrix) = (r18v0 int), (r2v3 int[][]) call: org.spongycastle.pqc.math.linearalgebra.GF2Matrix.<init>(int, int[][]):void type: CONSTRUCTOR)
     */
    public static GF2Matrix[] createRandomRegularMatrixAndItsInverse(int i, SecureRandom secureRandom) {
        GF2Matrix[] gF2MatrixArr = new GF2Matrix[2];
        int i2 = (i + 31) >> 5;
        GF2Matrix gF2Matrix = new GF2Matrix(i, Matrix.MATRIX_TYPE_RANDOM_LT, secureRandom);
        GF2Matrix gF2Matrix2 = new GF2Matrix(i, Matrix.MATRIX_TYPE_RANDOM_UT, secureRandom);
        GF2Matrix gF2Matrix3 = (GF2Matrix) gF2Matrix.rightMultiply(gF2Matrix2);
        Permutation permutation = new Permutation(i, secureRandom);
        int[] vector = permutation.getVector();
        int[] iArr = new int[2];
        iArr[1] = i2;
        iArr[0] = i;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        for (int i3 = 0; i3 < i; i3++) {
            System.arraycopy(gF2Matrix3.a[vector[i3]], 0, iArr2[i3], 0, i2);
        }
        gF2MatrixArr[0] = new GF2Matrix(i, iArr2);
        GF2Matrix gF2Matrix4 = new GF2Matrix(i, 'I');
        int i4 = 0;
        while (i4 < i) {
            int i5 = i4 >>> 5;
            int i6 = 1 << (i4 & 31);
            int i7 = i4 + 1;
            for (int i8 = i7; i8 < i; i8++) {
                if ((gF2Matrix.a[i8][i5] & i6) != 0) {
                    for (int i9 = 0; i9 <= i5; i9++) {
                        int[][] iArr3 = gF2Matrix4.a;
                        int[] iArr4 = iArr3[i8];
                        iArr4[i9] = iArr4[i9] ^ iArr3[i4][i9];
                    }
                }
            }
            i4 = i7;
        }
        GF2Matrix gF2Matrix5 = new GF2Matrix(i, 'I');
        for (int i10 = i - 1; i10 >= 0; i10--) {
            int i11 = i10 >>> 5;
            int i12 = 1 << (i10 & 31);
            for (int i13 = i10 - 1; i13 >= 0; i13--) {
                if ((gF2Matrix2.a[i13][i11] & i12) != 0) {
                    for (int i14 = i11; i14 < i2; i14++) {
                        int[][] iArr5 = gF2Matrix5.a;
                        int[] iArr6 = iArr5[i13];
                        iArr6[i14] = iArr5[i10][i14] ^ iArr6[i14];
                    }
                }
            }
        }
        gF2MatrixArr[1] = (GF2Matrix) gF2Matrix5.rightMultiply(gF2Matrix4.rightMultiply(permutation));
        return gF2MatrixArr;
    }

    public final void a(int i, int i2) {
        this.numRows = i;
        this.numColumns = i2;
        int i3 = (i2 + 31) >>> 5;
        this.b = i3;
        int[] iArr = new int[2];
        iArr[1] = i3;
        iArr[0] = i;
        this.a = (int[][]) Array.newInstance(int.class, iArr);
        for (int i4 = 0; i4 < this.numRows; i4++) {
            for (int i5 = 0; i5 < this.b; i5++) {
                this.a[i4][i5] = 0;
            }
        }
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Matrix
    public Matrix computeInverse() {
        int i = this.numRows;
        if (i == this.numColumns) {
            int[] iArr = new int[2];
            iArr[1] = this.b;
            iArr[0] = i;
            int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
            for (int i2 = this.numRows - 1; i2 >= 0; i2--) {
                iArr2[i2] = IntUtils.clone(this.a[i2]);
            }
            int i3 = this.numRows;
            int[] iArr3 = new int[2];
            iArr3[1] = this.b;
            iArr3[0] = i3;
            int[][] iArr4 = (int[][]) Array.newInstance(int.class, iArr3);
            for (int i4 = this.numRows - 1; i4 >= 0; i4--) {
                iArr4[i4][i4 >> 5] = 1 << (i4 & 31);
            }
            for (int i5 = 0; i5 < this.numRows; i5++) {
                int i6 = i5 >> 5;
                int i7 = 1 << (i5 & 31);
                if ((iArr2[i5][i6] & i7) == 0) {
                    int i8 = i5 + 1;
                    boolean z = false;
                    while (true) {
                        int i9 = this.numRows;
                        if (i8 >= i9) {
                            break;
                        }
                        if ((iArr2[i8][i6] & i7) != 0) {
                            int[] iArr5 = iArr2[i5];
                            iArr2[i5] = iArr2[i8];
                            iArr2[i8] = iArr5;
                            int[] iArr6 = iArr4[i5];
                            iArr4[i5] = iArr4[i8];
                            iArr4[i8] = iArr6;
                            i8 = i9;
                            z = true;
                        }
                        i8++;
                    }
                    if (!z) {
                        throw new ArithmeticException("Matrix is not invertible.");
                    }
                }
                for (int i10 = this.numRows - 1; i10 >= 0; i10--) {
                    if (i10 != i5 && (iArr2[i10][i6] & i7) != 0) {
                        int[] iArr7 = iArr2[i5];
                        int[] iArr8 = iArr2[i10];
                        int length = iArr8.length;
                        while (true) {
                            length--;
                            if (length < i6) {
                                break;
                            }
                            iArr8[length] = iArr7[length] ^ iArr8[length];
                        }
                        int[] iArr9 = iArr4[i5];
                        int[] iArr10 = iArr4[i10];
                        int length2 = iArr10.length;
                        while (true) {
                            length2--;
                            if (length2 < 0) {
                                break;
                            }
                            iArr10[length2] = iArr9[length2] ^ iArr10[length2];
                        }
                    }
                }
            }
            return new GF2Matrix(this.numColumns, iArr4);
        }
        throw new ArithmeticException("Matrix is not invertible.");
    }

    public Matrix computeTranspose() {
        int i = this.numColumns;
        int[] iArr = new int[2];
        iArr[1] = (this.numRows + 31) >>> 5;
        iArr[0] = i;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        int i2 = 0;
        while (true) {
            int i3 = this.numRows;
            if (i2 >= i3) {
                return new GF2Matrix(i3, iArr2);
            }
            for (int i4 = 0; i4 < this.numColumns; i4++) {
                int i5 = i2 >>> 5;
                int i6 = i2 & 31;
                if (((this.a[i2][i4 >>> 5] >>> (i4 & 31)) & 1) == 1) {
                    int[] iArr3 = iArr2[i4];
                    iArr3[i5] = (1 << i6) | iArr3[i5];
                }
            }
            i2++;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GF2Matrix)) {
            return false;
        }
        GF2Matrix gF2Matrix = (GF2Matrix) obj;
        if (!(this.numRows == gF2Matrix.numRows && this.numColumns == gF2Matrix.numColumns && this.b == gF2Matrix.b)) {
            return false;
        }
        for (int i = 0; i < this.numRows; i++) {
            if (!IntUtils.equals(this.a[i], gF2Matrix.a[i])) {
                return false;
            }
        }
        return true;
    }

    public GF2Matrix extendLeftCompactForm() {
        int i = this.numColumns;
        int i2 = this.numRows;
        GF2Matrix gF2Matrix = new GF2Matrix(i2, i + i2);
        int i3 = this.numRows;
        int i4 = (i3 - 1) + this.numColumns;
        int i5 = i3 - 1;
        while (i5 >= 0) {
            System.arraycopy(this.a[i5], 0, gF2Matrix.a[i5], 0, this.b);
            int[] iArr = gF2Matrix.a[i5];
            int i6 = i4 >> 5;
            iArr[i6] = iArr[i6] | (1 << (i4 & 31));
            i5--;
            i4--;
        }
        return gF2Matrix;
    }

    public GF2Matrix extendRightCompactForm() {
        int i;
        int i2 = this.numRows;
        GF2Matrix gF2Matrix = new GF2Matrix(i2, this.numColumns + i2);
        int i3 = this.numRows;
        int i4 = i3 >> 5;
        int i5 = i3 & 31;
        for (int i6 = i3 - 1; i6 >= 0; i6--) {
            int[][] iArr = gF2Matrix.a;
            int[] iArr2 = iArr[i6];
            int i7 = i6 >> 5;
            iArr2[i7] = iArr2[i7] | (1 << (i6 & 31));
            int i8 = 0;
            if (i5 != 0) {
                int i9 = i4;
                while (true) {
                    i = this.b;
                    if (i8 >= i - 1) {
                        break;
                    }
                    int i10 = this.a[i6][i8];
                    int[][] iArr3 = gF2Matrix.a;
                    int[] iArr4 = iArr3[i6];
                    int i11 = i9 + 1;
                    iArr4[i9] = iArr4[i9] | (i10 << i5);
                    int[] iArr5 = iArr3[i6];
                    iArr5[i11] = (i10 >>> (32 - i5)) | iArr5[i11];
                    i8++;
                    i9 = i11;
                }
                int i12 = this.a[i6][i - 1];
                int[][] iArr6 = gF2Matrix.a;
                int[] iArr7 = iArr6[i6];
                int i13 = i9 + 1;
                iArr7[i9] = iArr7[i9] | (i12 << i5);
                if (i13 < gF2Matrix.b) {
                    int[] iArr8 = iArr6[i6];
                    iArr8[i13] = (i12 >>> (32 - i5)) | iArr8[i13];
                }
            } else {
                System.arraycopy(this.a[i6], 0, iArr[i6], i4, this.b);
            }
        }
        return gF2Matrix;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Matrix
    public byte[] getEncoded() {
        int i = this.numRows;
        int i2 = 8;
        byte[] bArr = new byte[((((this.numColumns + 7) >>> 3) * i) + 8)];
        LittleEndianConversions.I2OSP(i, bArr, 0);
        LittleEndianConversions.I2OSP(this.numColumns, bArr, 4);
        int i3 = this.numColumns;
        int i4 = i3 >>> 5;
        int i5 = i3 & 31;
        for (int i6 = 0; i6 < this.numRows; i6++) {
            int i7 = 0;
            while (i7 < i4) {
                LittleEndianConversions.I2OSP(this.a[i6][i7], bArr, i2);
                i7++;
                i2 += 4;
            }
            int i8 = 0;
            while (i8 < i5) {
                bArr[i2] = (byte) ((this.a[i6][i4] >>> i8) & 255);
                i8 += 8;
                i2++;
            }
        }
        return bArr;
    }

    public double getHammingWeight() {
        int i = this.numColumns & 31;
        int i2 = i == 0 ? this.b : this.b - 1;
        double d = 0.0d;
        double d2 = 0.0d;
        for (int i3 = 0; i3 < this.numRows; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = this.a[i3][i4];
                for (int i6 = 0; i6 < 32; i6++) {
                    d += (double) ((i5 >>> i6) & 1);
                    d2 += 1.0d;
                }
            }
            int i7 = this.a[i3][this.b - 1];
            for (int i8 = 0; i8 < i; i8++) {
                d += (double) ((i7 >>> i8) & 1);
                d2 += 1.0d;
            }
        }
        return d / d2;
    }

    public int[][] getIntArray() {
        return this.a;
    }

    public GF2Matrix getLeftSubMatrix() {
        int i = this.numColumns;
        int i2 = this.numRows;
        if (i > i2) {
            int i3 = (i2 + 31) >> 5;
            int[] iArr = new int[2];
            iArr[1] = i3;
            iArr[0] = i2;
            int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
            int i4 = this.numRows;
            int i5 = (1 << (i4 & 31)) - 1;
            if (i5 == 0) {
                i5 = -1;
            }
            for (int i6 = i4 - 1; i6 >= 0; i6--) {
                System.arraycopy(this.a[i6], 0, iArr2[i6], 0, i3);
                int[] iArr3 = iArr2[i6];
                int i7 = i3 - 1;
                iArr3[i7] = iArr3[i7] & i5;
            }
            return new GF2Matrix(this.numRows, iArr2);
        }
        throw new ArithmeticException("empty submatrix");
    }

    public int getLength() {
        return this.b;
    }

    public GF2Matrix getRightSubMatrix() {
        int i;
        int i2 = this.numColumns;
        int i3 = this.numRows;
        if (i2 > i3) {
            int i4 = i3 >> 5;
            int i5 = i3 & 31;
            GF2Matrix gF2Matrix = new GF2Matrix(i3, i2 - i3);
            for (int i6 = this.numRows - 1; i6 >= 0; i6--) {
                int i7 = 0;
                if (i5 != 0) {
                    int i8 = i4;
                    while (true) {
                        i = gF2Matrix.b;
                        if (i7 >= i - 1) {
                            break;
                        }
                        int[] iArr = gF2Matrix.a[i6];
                        int[][] iArr2 = this.a;
                        int i9 = i8 + 1;
                        iArr[i7] = (iArr2[i6][i8] >>> i5) | (iArr2[i6][i9] << (32 - i5));
                        i7++;
                        i8 = i9;
                    }
                    int[][] iArr3 = gF2Matrix.a;
                    int[][] iArr4 = this.a;
                    int i10 = i8 + 1;
                    iArr3[i6][i - 1] = iArr4[i6][i8] >>> i5;
                    if (i10 < this.b) {
                        int[] iArr5 = iArr3[i6];
                        int i11 = i - 1;
                        iArr5[i11] = iArr5[i11] | (iArr4[i6][i10] << (32 - i5));
                    }
                } else {
                    System.arraycopy(this.a[i6], i4, gF2Matrix.a[i6], 0, gF2Matrix.b);
                }
            }
            return gF2Matrix;
        }
        throw new ArithmeticException("empty submatrix");
    }

    public int[] getRow(int i) {
        return this.a[i];
    }

    public int hashCode() {
        int i = (((this.numRows * 31) + this.numColumns) * 31) + this.b;
        for (int i2 = 0; i2 < this.numRows; i2++) {
            i = (i * 31) + this.a[i2].hashCode();
        }
        return i;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Matrix
    public boolean isZero() {
        for (int i = 0; i < this.numRows; i++) {
            for (int i2 = 0; i2 < this.b; i2++) {
                if (this.a[i][i2] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public Matrix leftMultiply(Permutation permutation) {
        int[] vector = permutation.getVector();
        int length = vector.length;
        int i = this.numRows;
        if (length == i) {
            int[][] iArr = new int[i][];
            for (int i2 = i - 1; i2 >= 0; i2--) {
                iArr[i2] = IntUtils.clone(this.a[vector[i2]]);
            }
            return new GF2Matrix(this.numRows, iArr);
        }
        throw new ArithmeticException("length mismatch");
    }

    public Vector leftMultiplyLeftCompactForm(Vector vector) {
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.length == this.numRows) {
            int[] vecArray = ((GF2Vector) vector).getVecArray();
            int i = this.numRows;
            int[] iArr = new int[(((this.numColumns + i) + 31) >>> 5)];
            int i2 = i >>> 5;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = 1;
                do {
                    if ((vecArray[i4] & i5) != 0) {
                        for (int i6 = 0; i6 < this.b; i6++) {
                            iArr[i6] = iArr[i6] ^ this.a[i3][i6];
                        }
                        int i7 = this.numColumns;
                        int i8 = (i7 + i3) >>> 5;
                        iArr[i8] = (1 << ((i7 + i3) & 31)) | iArr[i8];
                    }
                    i3++;
                    i5 <<= 1;
                } while (i5 != 0);
            }
            int i9 = 1 << (this.numRows & 31);
            for (int i10 = 1; i10 != i9; i10 <<= 1) {
                if ((vecArray[i2] & i10) != 0) {
                    for (int i11 = 0; i11 < this.b; i11++) {
                        iArr[i11] = iArr[i11] ^ this.a[i3][i11];
                    }
                    int i12 = this.numColumns;
                    int i13 = (i12 + i3) >>> 5;
                    iArr[i13] = (1 << ((i12 + i3) & 31)) | iArr[i13];
                }
                i3++;
            }
            return new GF2Vector(iArr, this.numRows + this.numColumns);
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Matrix
    public Matrix rightMultiply(Matrix matrix) {
        int i;
        if (!(matrix instanceof GF2Matrix)) {
            throw new ArithmeticException("matrix is not defined over GF(2)");
        } else if (matrix.numRows == this.numColumns) {
            GF2Matrix gF2Matrix = (GF2Matrix) matrix;
            GF2Matrix gF2Matrix2 = new GF2Matrix(this.numRows, matrix.numColumns);
            int i2 = this.numColumns & 31;
            if (i2 == 0) {
                i = this.b;
            } else {
                i = this.b - 1;
            }
            for (int i3 = 0; i3 < this.numRows; i3++) {
                int i4 = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = this.a[i3][i5];
                    for (int i7 = 0; i7 < 32; i7++) {
                        if (((1 << i7) & i6) != 0) {
                            for (int i8 = 0; i8 < gF2Matrix.b; i8++) {
                                int[] iArr = gF2Matrix2.a[i3];
                                iArr[i8] = iArr[i8] ^ gF2Matrix.a[i4][i8];
                            }
                        }
                        i4++;
                    }
                }
                int i9 = this.a[i3][this.b - 1];
                for (int i10 = 0; i10 < i2; i10++) {
                    if (((1 << i10) & i9) != 0) {
                        for (int i11 = 0; i11 < gF2Matrix.b; i11++) {
                            int[] iArr2 = gF2Matrix2.a[i3];
                            iArr2[i11] = iArr2[i11] ^ gF2Matrix.a[i4][i11];
                        }
                    }
                    i4++;
                }
            }
            return gF2Matrix2;
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public Vector rightMultiplyRightCompactForm(Vector vector) {
        int i;
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.length == this.numColumns + this.numRows) {
            int[] vecArray = ((GF2Vector) vector).getVecArray();
            int i2 = this.numRows;
            int[] iArr = new int[((i2 + 31) >>> 5)];
            int i3 = i2 >> 5;
            int i4 = i2 & 31;
            int i5 = 0;
            while (true) {
                int i6 = this.numRows;
                if (i5 >= i6) {
                    return new GF2Vector(iArr, i6);
                }
                int i7 = i5 >> 5;
                int i8 = i5 & 31;
                int i9 = (vecArray[i7] >>> i8) & 1;
                if (i4 != 0) {
                    int i10 = i3;
                    int i11 = 0;
                    while (true) {
                        i = this.b;
                        if (i11 >= i - 1) {
                            break;
                        }
                        int i12 = i10 + 1;
                        i9 ^= ((vecArray[i10] >>> i4) | (vecArray[i12] << (32 - i4))) & this.a[i5][i11];
                        i11++;
                        i10 = i12;
                    }
                    int i13 = i10 + 1;
                    int i14 = vecArray[i10] >>> i4;
                    if (i13 < vecArray.length) {
                        i14 |= vecArray[i13] << (32 - i4);
                    }
                    i9 ^= this.a[i5][i - 1] & i14;
                } else {
                    int i15 = i3;
                    int i16 = 0;
                    while (i16 < this.b) {
                        i9 ^= vecArray[i15] & this.a[i5][i16];
                        i16++;
                        i15++;
                    }
                }
                int i17 = 0;
                for (int i18 = 0; i18 < 32; i18++) {
                    i17 ^= i9 & 1;
                    i9 >>>= 1;
                }
                if (i17 == 1) {
                    iArr[i7] = iArr[i7] | (1 << i8);
                }
                i5++;
            }
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Matrix
    public String toString() {
        int i = this.numColumns & 31;
        int i2 = i == 0 ? this.b : this.b - 1;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < this.numRows; i3++) {
            stringBuffer.append(i3 + ": ");
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = this.a[i3][i4];
                for (int i6 = 0; i6 < 32; i6++) {
                    if (((i5 >>> i6) & 1) == 0) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append('1');
                    }
                }
                stringBuffer.append(' ');
            }
            int i7 = this.a[i3][this.b - 1];
            for (int i8 = 0; i8 < i; i8++) {
                if (((i7 >>> i8) & 1) == 0) {
                    stringBuffer.append('0');
                } else {
                    stringBuffer.append('1');
                }
            }
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Matrix
    public Vector leftMultiply(Vector vector) {
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.length == this.numRows) {
            int[] vecArray = ((GF2Vector) vector).getVecArray();
            int[] iArr = new int[this.b];
            int i = this.numRows;
            int i2 = i >> 5;
            int i3 = 1 << (i & 31);
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = 1;
                do {
                    if ((vecArray[i5] & i6) != 0) {
                        for (int i7 = 0; i7 < this.b; i7++) {
                            iArr[i7] = iArr[i7] ^ this.a[i4][i7];
                        }
                    }
                    i4++;
                    i6 <<= 1;
                } while (i6 != 0);
            }
            for (int i8 = 1; i8 != i3; i8 <<= 1) {
                if ((vecArray[i2] & i8) != 0) {
                    for (int i9 = 0; i9 < this.b; i9++) {
                        iArr[i9] = iArr[i9] ^ this.a[i4][i9];
                    }
                }
                i4++;
            }
            return new GF2Vector(iArr, this.numColumns);
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public GF2Matrix(int i, int[][] iArr) {
        if (iArr[0].length == ((i + 31) >> 5)) {
            this.numColumns = i;
            this.numRows = iArr.length;
            this.b = iArr[0].length;
            int i2 = i & 31;
            int i3 = i2 == 0 ? -1 : (1 << i2) - 1;
            for (int i4 = 0; i4 < this.numRows; i4++) {
                int[] iArr2 = iArr[i4];
                int i5 = this.b - 1;
                iArr2[i5] = iArr2[i5] & i3;
            }
            this.a = iArr;
            return;
        }
        throw new ArithmeticException("Int array does not match given number of columns.");
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Matrix
    public Matrix rightMultiply(Permutation permutation) {
        int[] vector = permutation.getVector();
        int length = vector.length;
        int i = this.numColumns;
        if (length == i) {
            GF2Matrix gF2Matrix = new GF2Matrix(this.numRows, i);
            for (int i2 = this.numColumns - 1; i2 >= 0; i2--) {
                int i3 = i2 >>> 5;
                int i4 = i2 & 31;
                int i5 = vector[i2] >>> 5;
                int i6 = vector[i2] & 31;
                for (int i7 = this.numRows - 1; i7 >= 0; i7--) {
                    int[] iArr = gF2Matrix.a[i7];
                    iArr[i3] = iArr[i3] | (((this.a[i7][i5] >>> i6) & 1) << i4);
                }
            }
            return gF2Matrix;
        }
        throw new ArithmeticException("length mismatch");
    }

    public GF2Matrix(int i, char c) {
        this(i, c, new SecureRandom());
    }

    public GF2Matrix(int i, char c, SecureRandom secureRandom) {
        int i2;
        if (i > 0) {
            if (c == 'I') {
                this.numRows = i;
                this.numColumns = i;
                int i3 = (i + 31) >>> 5;
                this.b = i3;
                int[] iArr = new int[2];
                iArr[1] = i3;
                iArr[0] = i;
                this.a = (int[][]) Array.newInstance(int.class, iArr);
                for (int i4 = 0; i4 < this.numRows; i4++) {
                    for (int i5 = 0; i5 < this.b; i5++) {
                        this.a[i4][i5] = 0;
                    }
                }
                for (int i6 = 0; i6 < this.numRows; i6++) {
                    this.a[i6][i6 >>> 5] = 1 << (i6 & 31);
                }
            } else if (c == 'L') {
                this.numRows = i;
                this.numColumns = i;
                int i7 = (i + 31) >>> 5;
                this.b = i7;
                int[] iArr2 = new int[2];
                iArr2[1] = i7;
                iArr2[0] = i;
                this.a = (int[][]) Array.newInstance(int.class, iArr2);
                for (int i8 = 0; i8 < this.numRows; i8++) {
                    int i9 = i8 >>> 5;
                    int i10 = i8 & 31;
                    int i11 = 31 - i10;
                    int i12 = 1 << i10;
                    for (int i13 = 0; i13 < i9; i13++) {
                        this.a[i8][i13] = secureRandom.nextInt();
                    }
                    this.a[i8][i9] = i12 | (secureRandom.nextInt() >>> i11);
                    while (true) {
                        i9++;
                        if (i9 >= this.b) {
                            break;
                        }
                        this.a[i8][i9] = 0;
                    }
                }
            } else if (c == 'R') {
                this.numRows = i;
                this.numColumns = i;
                int i14 = (i + 31) >>> 5;
                this.b = i14;
                int[] iArr3 = new int[2];
                iArr3[1] = i14;
                iArr3[0] = i;
                this.a = (int[][]) Array.newInstance(int.class, iArr3);
                GF2Matrix gF2Matrix = (GF2Matrix) new GF2Matrix(i, Matrix.MATRIX_TYPE_RANDOM_LT, secureRandom).rightMultiply(new GF2Matrix(i, Matrix.MATRIX_TYPE_RANDOM_UT, secureRandom));
                int[] vector = new Permutation(i, secureRandom).getVector();
                for (int i15 = 0; i15 < i; i15++) {
                    System.arraycopy(gF2Matrix.a[i15], 0, this.a[vector[i15]], 0, this.b);
                }
            } else if (c == 'U') {
                this.numRows = i;
                this.numColumns = i;
                int i16 = (i + 31) >>> 5;
                this.b = i16;
                int[] iArr4 = new int[2];
                iArr4[1] = i16;
                iArr4[0] = i;
                this.a = (int[][]) Array.newInstance(int.class, iArr4);
                int i17 = i & 31;
                int i18 = i17 == 0 ? -1 : (1 << i17) - 1;
                for (int i19 = 0; i19 < this.numRows; i19++) {
                    int i20 = i19 >>> 5;
                    int i21 = i19 & 31;
                    int i22 = 1 << i21;
                    for (int i23 = 0; i23 < i20; i23++) {
                        this.a[i19][i23] = 0;
                    }
                    this.a[i19][i20] = (secureRandom.nextInt() << i21) | i22;
                    while (true) {
                        i20++;
                        i2 = this.b;
                        if (i20 >= i2) {
                            break;
                        }
                        this.a[i19][i20] = secureRandom.nextInt();
                    }
                    int[] iArr5 = this.a[i19];
                    int i24 = i2 - 1;
                    iArr5[i24] = iArr5[i24] & i18;
                }
            } else if (c == 'Z') {
                a(i, i);
            } else {
                throw new ArithmeticException("Unknown matrix type.");
            }
        } else {
            throw new ArithmeticException("Size of matrix is non-positive.");
        }
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Matrix
    public Vector rightMultiply(Vector vector) {
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.length == this.numColumns) {
            int[] vecArray = ((GF2Vector) vector).getVecArray();
            int[] iArr = new int[((this.numRows + 31) >>> 5)];
            int i = 0;
            while (true) {
                int i2 = this.numRows;
                if (i >= i2) {
                    return new GF2Vector(iArr, i2);
                }
                int i3 = 0;
                for (int i4 = 0; i4 < this.b; i4++) {
                    i3 ^= this.a[i][i4] & vecArray[i4];
                }
                int i5 = 0;
                for (int i6 = 0; i6 < 32; i6++) {
                    i5 ^= (i3 >>> i6) & 1;
                }
                if (i5 == 1) {
                    int i7 = i >>> 5;
                    iArr[i7] = iArr[i7] | (1 << (i & 31));
                }
                i++;
            }
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public GF2Matrix(GF2Matrix gF2Matrix) {
        this.numColumns = gF2Matrix.getNumColumns();
        this.numRows = gF2Matrix.getNumRows();
        this.b = gF2Matrix.b;
        this.a = new int[gF2Matrix.a.length][];
        int i = 0;
        while (true) {
            int[][] iArr = this.a;
            if (i < iArr.length) {
                iArr[i] = IntUtils.clone(gF2Matrix.a[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public GF2Matrix(int i, int i2) {
        if (i2 <= 0 || i <= 0) {
            throw new ArithmeticException("size of matrix is non-positive");
        }
        a(i, i2);
    }
}
