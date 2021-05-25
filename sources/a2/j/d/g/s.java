package a2.j.d.g;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Immutable
public final class s extends d implements Serializable {
    public static final HashFunction b = new s(0);
    public static final HashFunction c = new s(Hashing.a);
    private static final long serialVersionUID = 0;
    public final int a;

    public static final class a extends g {
        public long d;
        public long e;
        public int f = 0;

        public a(int i) {
            super(16);
            long j = (long) i;
            this.d = j;
            this.e = j;
        }

        public static long g(long j) {
            long j2 = (j ^ (j >>> 33)) * -49064778989728563L;
            long j3 = (j2 ^ (j2 >>> 33)) * -4265267296055464877L;
            return j3 ^ (j3 >>> 33);
        }

        @Override // a2.j.d.g.g
        public HashCode a() {
            long j = this.d;
            int i = this.f;
            long j2 = j ^ ((long) i);
            this.d = j2;
            long j3 = this.e ^ ((long) i);
            this.e = j3;
            long j4 = j2 + j3;
            this.d = j4;
            this.e = j3 + j4;
            this.d = g(j4);
            long g = g(this.e);
            this.e = g;
            long j5 = this.d + g;
            this.d = j5;
            this.e = g + j5;
            byte[] array = ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.d).putLong(this.e).array();
            char[] cArr = HashCode.a;
            return new HashCode.a(array);
        }

        @Override // a2.j.d.g.g
        public void d(ByteBuffer byteBuffer) {
            long j = byteBuffer.getLong();
            long j2 = byteBuffer.getLong();
            long rotateLeft = (Long.rotateLeft(j * -8663945395140668459L, 31) * 5545529020109919103L) ^ this.d;
            this.d = rotateLeft;
            long rotateLeft2 = Long.rotateLeft(rotateLeft, 27);
            this.d = rotateLeft2;
            long j3 = this.e;
            long j4 = rotateLeft2 + j3;
            this.d = j4;
            this.d = (j4 * 5) + 1390208809;
            long rotateLeft3 = (Long.rotateLeft(j2 * 5545529020109919103L, 33) * -8663945395140668459L) ^ j3;
            this.e = rotateLeft3;
            long rotateLeft4 = Long.rotateLeft(rotateLeft3, 31);
            this.e = rotateLeft4;
            long j5 = rotateLeft4 + this.d;
            this.e = j5;
            this.e = (j5 * 5) + 944331445;
            this.f += 16;
        }

        @Override // a2.j.d.g.g
        public void e(ByteBuffer byteBuffer) {
            long j;
            long j2;
            long j3;
            long j4;
            long j5;
            long j6;
            long j7;
            long j8;
            long j9;
            long j10;
            long j11;
            long j12;
            long j13;
            long j14;
            this.f = byteBuffer.remaining() + this.f;
            long j15 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    j2 = 0;
                    j = ((long) UnsignedBytes.toInt(byteBuffer.get(0))) ^ j2;
                    this.d ^= Long.rotateLeft(j * -8663945395140668459L, 31) * 5545529020109919103L;
                    this.e ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * -8663945395140668459L;
                    return;
                case 2:
                    j3 = 0;
                    j2 = j3 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j = ((long) UnsignedBytes.toInt(byteBuffer.get(0))) ^ j2;
                    this.d ^= Long.rotateLeft(j * -8663945395140668459L, 31) * 5545529020109919103L;
                    this.e ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * -8663945395140668459L;
                    return;
                case 3:
                    j4 = 0;
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16);
                    j2 = j3 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j = ((long) UnsignedBytes.toInt(byteBuffer.get(0))) ^ j2;
                    this.d ^= Long.rotateLeft(j * -8663945395140668459L, 31) * 5545529020109919103L;
                    this.e ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * -8663945395140668459L;
                    return;
                case 4:
                    j5 = 0;
                    j4 = j5 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16);
                    j2 = j3 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j = ((long) UnsignedBytes.toInt(byteBuffer.get(0))) ^ j2;
                    this.d ^= Long.rotateLeft(j * -8663945395140668459L, 31) * 5545529020109919103L;
                    this.e ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * -8663945395140668459L;
                    return;
                case 5:
                    j6 = 0;
                    j5 = j6 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(4))) << 32);
                    j4 = j5 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16);
                    j2 = j3 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j = ((long) UnsignedBytes.toInt(byteBuffer.get(0))) ^ j2;
                    this.d ^= Long.rotateLeft(j * -8663945395140668459L, 31) * 5545529020109919103L;
                    this.e ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * -8663945395140668459L;
                    return;
                case 6:
                    j7 = 0;
                    j6 = j7 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(5))) << 40);
                    j5 = j6 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(4))) << 32);
                    j4 = j5 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16);
                    j2 = j3 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j = ((long) UnsignedBytes.toInt(byteBuffer.get(0))) ^ j2;
                    this.d ^= Long.rotateLeft(j * -8663945395140668459L, 31) * 5545529020109919103L;
                    this.e ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * -8663945395140668459L;
                    return;
                case 7:
                    j7 = (((long) UnsignedBytes.toInt(byteBuffer.get(6))) << 48) ^ 0;
                    j6 = j7 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(5))) << 40);
                    j5 = j6 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(4))) << 32);
                    j4 = j5 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16);
                    j2 = j3 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j = ((long) UnsignedBytes.toInt(byteBuffer.get(0))) ^ j2;
                    this.d ^= Long.rotateLeft(j * -8663945395140668459L, 31) * 5545529020109919103L;
                    this.e ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * -8663945395140668459L;
                    return;
                case 8:
                    j8 = 0;
                    j = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= Long.rotateLeft(j * -8663945395140668459L, 31) * 5545529020109919103L;
                    this.e ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * -8663945395140668459L;
                    return;
                case 9:
                    j9 = 0;
                    j8 = j9 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= Long.rotateLeft(j * -8663945395140668459L, 31) * 5545529020109919103L;
                    this.e ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * -8663945395140668459L;
                    return;
                case 10:
                    j10 = 0;
                    j9 = j10 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8);
                    j8 = j9 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= Long.rotateLeft(j * -8663945395140668459L, 31) * 5545529020109919103L;
                    this.e ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * -8663945395140668459L;
                    return;
                case 11:
                    j11 = 0;
                    j10 = j11 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16);
                    j9 = j10 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8);
                    j8 = j9 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= Long.rotateLeft(j * -8663945395140668459L, 31) * 5545529020109919103L;
                    this.e ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * -8663945395140668459L;
                    return;
                case 12:
                    j12 = 0;
                    j11 = j12 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24);
                    j10 = j11 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16);
                    j9 = j10 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8);
                    j8 = j9 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= Long.rotateLeft(j * -8663945395140668459L, 31) * 5545529020109919103L;
                    this.e ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * -8663945395140668459L;
                    return;
                case 13:
                    j13 = 0;
                    j12 = j13 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(12))) << 32);
                    j11 = j12 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24);
                    j10 = j11 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16);
                    j9 = j10 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8);
                    j8 = j9 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= Long.rotateLeft(j * -8663945395140668459L, 31) * 5545529020109919103L;
                    this.e ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * -8663945395140668459L;
                    return;
                case 14:
                    j14 = 0;
                    j13 = j14 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(13))) << 40);
                    j12 = j13 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(12))) << 32);
                    j11 = j12 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24);
                    j10 = j11 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16);
                    j9 = j10 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8);
                    j8 = j9 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= Long.rotateLeft(j * -8663945395140668459L, 31) * 5545529020109919103L;
                    this.e ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * -8663945395140668459L;
                    return;
                case 15:
                    j14 = (((long) UnsignedBytes.toInt(byteBuffer.get(14))) << 48) ^ 0;
                    j13 = j14 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(13))) << 40);
                    j12 = j13 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(12))) << 32);
                    j11 = j12 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24);
                    j10 = j11 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16);
                    j9 = j10 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8);
                    j8 = j9 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    j15 = j8;
                    this.d ^= Long.rotateLeft(j * -8663945395140668459L, 31) * 5545529020109919103L;
                    this.e ^= Long.rotateLeft(j15 * 5545529020109919103L, 33) * -8663945395140668459L;
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }
    }

    public s(int i) {
        this.a = i;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 128;
    }

    @Override // java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof s) || this.a != ((s) obj).a) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return s.class.hashCode() ^ this.a;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new a(this.a);
    }

    @Override // java.lang.Object
    public String toString() {
        return a2.b.a.a.a.j(a2.b.a.a.a.L("Hashing.murmur3_128("), this.a, ")");
    }
}
