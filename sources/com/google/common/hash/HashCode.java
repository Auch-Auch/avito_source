package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
public abstract class HashCode {
    public static final char[] a = "0123456789abcdef".toCharArray();

    public static final class a extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        public final byte[] b;

        public a(byte[] bArr) {
            this.b = (byte[]) Preconditions.checkNotNull(bArr);
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            return (byte[]) this.b.clone();
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            byte[] bArr = this.b;
            Preconditions.checkState(bArr.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", bArr.length);
            byte[] bArr2 = this.b;
            return ((bArr2[3] & 255) << 24) | (bArr2[0] & 255) | ((bArr2[1] & 255) << 8) | ((bArr2[2] & 255) << 16);
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            byte[] bArr = this.b;
            Preconditions.checkState(bArr.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", bArr.length);
            return padToLong();
        }

        @Override // com.google.common.hash.HashCode
        public boolean b(HashCode hashCode) {
            if (this.b.length != hashCode.c().length) {
                return false;
            }
            int i = 0;
            boolean z = true;
            while (true) {
                byte[] bArr = this.b;
                if (i >= bArr.length) {
                    return z;
                }
                z &= bArr[i] == hashCode.c()[i];
                i++;
            }
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return this.b.length * 8;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] c() {
            return this.b;
        }

        @Override // com.google.common.hash.HashCode
        public void d(byte[] bArr, int i, int i2) {
            System.arraycopy(this.b, 0, bArr, i, i2);
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            long j = (long) (this.b[0] & 255);
            for (int i = 1; i < Math.min(this.b.length, 8); i++) {
                j |= (((long) this.b[i]) & 255) << (i * 8);
            }
            return j;
        }
    }

    public static final class b extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        public final int b;

        public b(int i) {
            this.b = i;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            int i = this.b;
            return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return this.b;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        @Override // com.google.common.hash.HashCode
        public boolean b(HashCode hashCode) {
            return this.b == hashCode.asInt();
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 32;
        }

        @Override // com.google.common.hash.HashCode
        public void d(byte[] bArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i + i3] = (byte) (this.b >> (i3 * 8));
            }
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return UnsignedInts.toLong(this.b);
        }
    }

    public static final class c extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        public final long b;

        public c(long j) {
            this.b = j;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            long j = this.b;
            return new byte[]{(byte) ((int) j), (byte) ((int) (j >> 8)), (byte) ((int) (j >> 16)), (byte) ((int) (j >> 24)), (byte) ((int) (j >> 32)), (byte) ((int) (j >> 40)), (byte) ((int) (j >> 48)), (byte) ((int) (j >> 56))};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return (int) this.b;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            return this.b;
        }

        @Override // com.google.common.hash.HashCode
        public boolean b(HashCode hashCode) {
            return this.b == hashCode.asLong();
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 64;
        }

        @Override // com.google.common.hash.HashCode
        public void d(byte[] bArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i + i3] = (byte) ((int) (this.b >> (i3 * 8)));
            }
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return this.b;
        }
    }

    public static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return (c2 - 'a') + 10;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.K2("Illegal hexadecimal character: ", c2));
    }

    public static HashCode fromBytes(byte[] bArr) {
        boolean z = true;
        if (bArr.length < 1) {
            z = false;
        }
        Preconditions.checkArgument(z, "A HashCode must contain at least 1 byte.");
        return new a((byte[]) bArr.clone());
    }

    public static HashCode fromInt(int i) {
        return new b(i);
    }

    public static HashCode fromLong(long j) {
        return new c(j);
    }

    public static HashCode fromString(String str) {
        boolean z = true;
        Preconditions.checkArgument(str.length() >= 2, "input string (%s) must have at least 2 characters", str);
        if (str.length() % 2 != 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "input string (%s) must have an even number of characters", str);
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length(); i += 2) {
            bArr[i / 2] = (byte) ((a(str.charAt(i)) << 4) + a(str.charAt(i + 1)));
        }
        return new a(bArr);
    }

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    public abstract boolean b(HashCode hashCode);

    public abstract int bits();

    public byte[] c() {
        return asBytes();
    }

    public abstract void d(byte[] bArr, int i, int i2);

    public final boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof HashCode)) {
            return false;
        }
        HashCode hashCode = (HashCode) obj;
        if (bits() != hashCode.bits() || !b(hashCode)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        if (bits() >= 32) {
            return asInt();
        }
        byte[] c2 = c();
        int i = c2[0] & 255;
        for (int i2 = 1; i2 < c2.length; i2++) {
            i |= (c2[i2] & 255) << (i2 * 8);
        }
        return i;
    }

    public abstract long padToLong();

    public final String toString() {
        byte[] c2 = c();
        StringBuilder sb = new StringBuilder(c2.length * 2);
        for (byte b2 : c2) {
            char[] cArr = a;
            sb.append(cArr[(b2 >> 4) & 15]);
            sb.append(cArr[b2 & Ascii.SI]);
        }
        return sb.toString();
    }

    @CanIgnoreReturnValue
    public int writeBytesTo(byte[] bArr, int i, int i2) {
        int min = Ints.min(i2, bits() / 8);
        Preconditions.checkPositionIndexes(i, i + min, bArr.length);
        d(bArr, i, min);
        return min;
    }
}
