package a2.j.d.g;

import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Hashing;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public enum h implements BloomFilter.b {
    MURMUR128_MITZ_32 {
        @Override // com.google.common.hash.BloomFilter.b
        public <T> boolean g(T t, Funnel<? super T> funnel, int i, c cVar) {
            long a = cVar.a();
            long asLong = Hashing.murmur3_128().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 = ~i5;
                }
                if (!cVar.b(((long) i5) % a)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.b
        public <T> boolean k(T t, Funnel<? super T> funnel, int i, c cVar) {
            long a = cVar.a();
            long asLong = Hashing.murmur3_128().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            boolean z = false;
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 = ~i5;
                }
                z |= cVar.c(((long) i5) % a);
            }
            return z;
        }
    },
    MURMUR128_MITZ_64 {
        public final long a(byte[] bArr) {
            return Longs.fromBytes(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        public final long b(byte[] bArr) {
            return Longs.fromBytes(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.b
        public <T> boolean g(T t, Funnel<? super T> funnel, int i, c cVar) {
            long a = cVar.a();
            byte[] c = Hashing.murmur3_128().hashObject(t, funnel).c();
            long a3 = a(c);
            long b = b(c);
            for (int i2 = 0; i2 < i; i2++) {
                if (!cVar.b((Long.MAX_VALUE & a3) % a)) {
                    return false;
                }
                a3 += b;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.b
        public <T> boolean k(T t, Funnel<? super T> funnel, int i, c cVar) {
            long a = cVar.a();
            byte[] c = Hashing.murmur3_128().hashObject(t, funnel).c();
            long a3 = a(c);
            long b = b(c);
            boolean z = false;
            for (int i2 = 0; i2 < i; i2++) {
                z |= cVar.c((Long.MAX_VALUE & a3) % a);
                a3 += b;
            }
            return z;
        }
    };

    /* access modifiers changed from: public */
    h(a aVar) {
    }

    public static final class c {
        public final AtomicLongArray a;
        public final n b;

        public c(long j) {
            Preconditions.checkArgument(j > 0, "data length is zero!");
            this.a = new AtomicLongArray(Ints.checkedCast(LongMath.divide(j, 64, RoundingMode.CEILING)));
            this.b = o.a.get();
        }

        public static long[] d(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                jArr[i] = atomicLongArray.get(i);
            }
            return jArr;
        }

        public long a() {
            return ((long) this.a.length()) * 64;
        }

        public boolean b(long j) {
            return ((1 << ((int) j)) & this.a.get((int) (j >>> 6))) != 0;
        }

        public boolean c(long j) {
            long j2;
            long j3;
            if (b(j)) {
                return false;
            }
            int i = (int) (j >>> 6);
            long j4 = 1 << ((int) j);
            do {
                j2 = this.a.get(i);
                j3 = j2 | j4;
                if (j2 == j3) {
                    return false;
                }
            } while (!this.a.compareAndSet(i, j2, j3));
            this.b.b();
            return true;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof c) {
                return Arrays.equals(d(this.a), d(((c) obj).a));
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(d(this.a));
        }

        public c(long[] jArr) {
            Preconditions.checkArgument(jArr.length > 0, "data length is zero!");
            this.a = new AtomicLongArray(jArr);
            this.b = o.a.get();
            long j = 0;
            for (long j2 : jArr) {
                j += (long) Long.bitCount(j2);
            }
            this.b.add(j);
        }
    }
}
