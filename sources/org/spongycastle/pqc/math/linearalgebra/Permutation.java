package org.spongycastle.pqc.math.linearalgebra;

import a2.b.a.a.a;
import java.security.SecureRandom;
public class Permutation {
    public int[] a;

    public Permutation(int i) {
        if (i > 0) {
            this.a = new int[i];
            for (int i2 = i - 1; i2 >= 0; i2--) {
                this.a[i2] = i2;
            }
            return;
        }
        throw new IllegalArgumentException("invalid length");
    }

    public final boolean a(int[] iArr) {
        int length = iArr.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (iArr[i] < 0 || iArr[i] >= length || zArr[iArr[i]]) {
                return false;
            }
            zArr[iArr[i]] = true;
        }
        return true;
    }

    public Permutation computeInverse() {
        Permutation permutation = new Permutation(this.a.length);
        for (int length = this.a.length - 1; length >= 0; length--) {
            permutation.a[this.a[length]] = length;
        }
        return permutation;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Permutation)) {
            return false;
        }
        return IntUtils.equals(this.a, ((Permutation) obj).a);
    }

    public byte[] getEncoded() {
        int length = this.a.length;
        int ceilLog256 = IntegerFunctions.ceilLog256(length - 1);
        byte[] bArr = new byte[((length * ceilLog256) + 4)];
        LittleEndianConversions.I2OSP(length, bArr, 0);
        for (int i = 0; i < length; i++) {
            LittleEndianConversions.I2OSP(this.a[i], bArr, (i * ceilLog256) + 4, ceilLog256);
        }
        return bArr;
    }

    public int[] getVector() {
        return IntUtils.clone(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Permutation rightMultiply(Permutation permutation) {
        int length = permutation.a.length;
        int[] iArr = this.a;
        if (length == iArr.length) {
            Permutation permutation2 = new Permutation(iArr.length);
            for (int length2 = this.a.length - 1; length2 >= 0; length2--) {
                permutation2.a[length2] = this.a[permutation.a[length2]];
            }
            return permutation2;
        }
        throw new IllegalArgumentException("length mismatch");
    }

    public String toString() {
        StringBuilder L = a.L("[");
        L.append(this.a[0]);
        String sb = L.toString();
        for (int i = 1; i < this.a.length; i++) {
            StringBuilder Q = a.Q(sb, ", ");
            Q.append(this.a[i]);
            sb = Q.toString();
        }
        return a.c3(sb, "]");
    }

    public Permutation(int[] iArr) {
        if (a(iArr)) {
            this.a = IntUtils.clone(iArr);
            return;
        }
        throw new IllegalArgumentException("array is not a permutation vector");
    }

    public Permutation(byte[] bArr) {
        if (bArr.length > 4) {
            int OS2IP = LittleEndianConversions.OS2IP(bArr, 0);
            int ceilLog256 = IntegerFunctions.ceilLog256(OS2IP - 1);
            if (bArr.length == (OS2IP * ceilLog256) + 4) {
                this.a = new int[OS2IP];
                for (int i = 0; i < OS2IP; i++) {
                    this.a[i] = LittleEndianConversions.OS2IP(bArr, (i * ceilLog256) + 4, ceilLog256);
                }
                if (!a(this.a)) {
                    throw new IllegalArgumentException("invalid encoding");
                }
                return;
            }
            throw new IllegalArgumentException("invalid encoding");
        }
        throw new IllegalArgumentException("invalid encoding");
    }

    public Permutation(int i, SecureRandom secureRandom) {
        if (i > 0) {
            this.a = new int[i];
            int[] iArr = new int[i];
            for (int i2 = 0; i2 < i; i2++) {
                iArr[i2] = i2;
            }
            int i3 = i;
            for (int i4 = 0; i4 < i; i4++) {
                int a3 = RandUtils.a(secureRandom, i3);
                i3--;
                this.a[i4] = iArr[a3];
                iArr[a3] = iArr[i3];
            }
            return;
        }
        throw new IllegalArgumentException("invalid length");
    }
}
