package a2.j.d.g;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import org.spongycastle.asn1.cmc.BodyPartID;
public final class k extends f {
    public static final HashFunction a = new k();

    public static long a(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    public static long b(long j) {
        return j ^ (j >>> 47);
    }

    public static void c(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long b = m.b(bArr, i);
        long b2 = m.b(bArr, i + 8);
        long b3 = m.b(bArr, i + 16);
        long b4 = m.b(bArr, i + 24);
        long j3 = j + b;
        long rotateRight = Long.rotateRight(j2 + j3 + b4, 21);
        long j4 = b2 + j3 + b3;
        jArr[0] = j4 + b4;
        jArr[1] = Long.rotateRight(j4, 44) + rotateRight + j3;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    @Override // a2.j.d.g.d, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        long rotateRight;
        long b;
        long rotateRight2;
        int i3 = i + i2;
        Preconditions.checkPositionIndexes(i, i3, bArr.length);
        long j = -7286425919675154353L;
        if (i2 <= 32) {
            if (i2 > 16) {
                long j2 = ((long) (i2 * 2)) - 7286425919675154353L;
                long b2 = m.b(bArr, i) * -5435081209227447693L;
                long b3 = m.b(bArr, i + 8);
                long b4 = m.b(bArr, i3 - 8) * j2;
                j = a(Long.rotateRight(b4, 30) + Long.rotateRight(b2 + b3, 43) + (m.b(bArr, i3 - 16) * -7286425919675154353L), Long.rotateRight(b3 - 7286425919675154353L, 18) + b2 + b4, j2);
            } else if (i2 >= 8) {
                long j3 = ((long) (i2 * 2)) - 7286425919675154353L;
                long b5 = m.b(bArr, i) - 7286425919675154353L;
                long b6 = m.b(bArr, i3 - 8);
                j = a((Long.rotateRight(b6, 37) * j3) + b5, (Long.rotateRight(b5, 25) + b6) * j3, j3);
            } else if (i2 >= 4) {
                j = a(((long) i2) + ((((long) m.a(bArr, i)) & BodyPartID.bodyIdMax) << 3), BodyPartID.bodyIdMax & ((long) m.a(bArr, i3 - 4)), ((long) (i2 * 2)) - 7286425919675154353L);
            } else if (i2 > 0) {
                j = -7286425919675154353L * b((((long) ((bArr[i] & 255) + ((bArr[(i2 >> 1) + i] & 255) << 8))) * -7286425919675154353L) ^ (((long) (((bArr[(i2 - 1) + i] & 255) << 2) + i2)) * -4348849565147123417L));
            }
        } else if (i2 <= 64) {
            long j4 = ((long) (i2 * 2)) - 7286425919675154353L;
            long b8 = m.b(bArr, i) * -7286425919675154353L;
            long b9 = m.b(bArr, i + 8);
            long b10 = m.b(bArr, i3 - 8) * j4;
            long rotateRight3 = Long.rotateRight(b10, 30) + Long.rotateRight(b8 + b9, 43) + (m.b(bArr, i3 - 16) * -7286425919675154353L);
            long a3 = a(rotateRight3, Long.rotateRight(b9 - 7286425919675154353L, 18) + b8 + b10, j4);
            long b11 = m.b(bArr, i + 16) * j4;
            long b12 = m.b(bArr, i + 24);
            long b13 = (m.b(bArr, i3 - 32) + rotateRight3) * j4;
            j = a(Long.rotateRight(b13, 30) + Long.rotateRight(b11 + b12, 43) + ((m.b(bArr, i3 - 24) + a3) * j4), Long.rotateRight(b12 + b8, 18) + b11 + b13, j4);
        } else {
            long b14 = b(-7956866745689871395L) * -7286425919675154353L;
            long[] jArr = new long[2];
            long[] jArr2 = new long[2];
            long b15 = m.b(bArr, i) + 95310865018149119L;
            int i4 = i2 - 1;
            int i5 = ((i4 / 64) * 64) + i;
            int i6 = i4 & 63;
            int i7 = (i5 + i6) - 63;
            int i8 = i;
            long j5 = 2480279821605975764L;
            while (true) {
                long b16 = m.b(bArr, i8 + 8);
                long j6 = j5 + jArr[1];
                rotateRight = (Long.rotateRight(b16 + ((b15 + j5) + jArr[0]), 37) * -5435081209227447693L) ^ jArr2[1];
                b = m.b(bArr, i8 + 40) + jArr[0] + (Long.rotateRight(m.b(bArr, i8 + 48) + j6, 42) * -5435081209227447693L);
                rotateRight2 = Long.rotateRight(b14 + jArr2[0], 33) * -5435081209227447693L;
                c(bArr, i8, jArr[1] * -5435081209227447693L, rotateRight + jArr2[0], jArr);
                c(bArr, i8 + 32, rotateRight2 + jArr2[1], m.b(bArr, i8 + 16) + b, jArr2);
                int i9 = i8 + 64;
                if (i9 == i5) {
                    break;
                }
                i8 = i9;
                b14 = rotateRight;
                j5 = b;
                b15 = rotateRight2;
            }
            long j7 = -5435081209227447693L + ((rotateRight & 255) << 1);
            jArr2[0] = jArr2[0] + ((long) i6);
            jArr[0] = jArr[0] + jArr2[0];
            jArr2[0] = jArr2[0] + jArr[0];
            long j8 = rotateRight2 + b + jArr[0];
            long j9 = b + jArr[1];
            long rotateRight4 = (Long.rotateRight(m.b(bArr, i7 + 8) + j8, 37) * j7) ^ (jArr2[1] * 9);
            long b17 = m.b(bArr, i7 + 40) + (jArr[0] * 9) + (Long.rotateRight(m.b(bArr, i7 + 48) + j9, 42) * j7);
            long rotateRight5 = Long.rotateRight(rotateRight + jArr2[0], 33) * j7;
            c(bArr, i7, jArr[1] * j7, rotateRight4 + jArr2[0], jArr);
            c(bArr, i7 + 32, rotateRight5 + jArr2[1], m.b(bArr, i7 + 16) + b17, jArr2);
            j = a((b(b17) * -4348849565147123417L) + a(jArr[0], jArr2[0], j7) + rotateRight4, a(jArr[1], jArr2[1], j7) + rotateRight5, j7);
        }
        return HashCode.fromLong(j);
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }
}
