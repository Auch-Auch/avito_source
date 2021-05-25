package com.google.common.hash;

import a2.j.d.g.h;
import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.math.DoubleMath;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    public final h.c a;
    public final int b;
    public final Funnel<? super T> c;
    public final b d;

    public static class a<T> implements Serializable {
        private static final long serialVersionUID = 1;
        public final long[] a;
        public final int b;
        public final Funnel<? super T> c;
        public final b d;

        public a(BloomFilter<T> bloomFilter) {
            this.a = h.c.d(bloomFilter.a.a);
            this.b = bloomFilter.b;
            this.c = bloomFilter.c;
            this.d = bloomFilter.d;
        }

        public Object readResolve() {
            return new BloomFilter(new h.c(this.a), this.b, this.c, this.d);
        }
    }

    public interface b extends Serializable {
        <T> boolean g(T t, Funnel<? super T> funnel, int i, h.c cVar);

        <T> boolean k(T t, Funnel<? super T> funnel, int i, h.c cVar);

        int ordinal();
    }

    public BloomFilter(h.c cVar, int i, Funnel<? super T> funnel, b bVar) {
        boolean z = true;
        Preconditions.checkArgument(i > 0, "numHashFunctions (%s) must be > 0", i);
        Preconditions.checkArgument(i > 255 ? false : z, "numHashFunctions (%s) must be <= 255", i);
        this.a = (h.c) Preconditions.checkNotNull(cVar);
        this.b = i;
        this.c = (Funnel) Preconditions.checkNotNull(funnel);
        this.d = (b) Preconditions.checkNotNull(bVar);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i, double d2) {
        return create(funnel, (long) i, d2);
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel) throws IOException {
        RuntimeException e;
        int i;
        int i2;
        Preconditions.checkNotNull(inputStream, "InputStream");
        Preconditions.checkNotNull(funnel, "Funnel");
        byte b2 = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            b2 = dataInputStream.readByte();
            try {
                i = UnsignedBytes.toInt(dataInputStream.readByte());
                try {
                    i2 = dataInputStream.readInt();
                } catch (RuntimeException e2) {
                    e = e2;
                    i2 = -1;
                    StringBuilder N = a2.b.a.a.a.N("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ", b2, " numHashFunctions: ", i, " dataLength: ");
                    N.append(i2);
                    throw new IOException(N.toString(), e);
                }
            } catch (RuntimeException e3) {
                e = e3;
                i = -1;
                i2 = -1;
                StringBuilder N = a2.b.a.a.a.N("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ", b2, " numHashFunctions: ", i, " dataLength: ");
                N.append(i2);
                throw new IOException(N.toString(), e);
            }
            try {
                h hVar = h.values()[b2];
                long[] jArr = new long[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    jArr[i3] = dataInputStream.readLong();
                }
                return new BloomFilter<>(new h.c(jArr), i, funnel, hVar);
            } catch (RuntimeException e4) {
                e = e4;
                StringBuilder N = a2.b.a.a.a.N("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ", b2, " numHashFunctions: ", i, " dataLength: ");
                N.append(i2);
                throw new IOException(N.toString(), e);
            }
        } catch (RuntimeException e5) {
            e = e5;
            i2 = -1;
            i = -1;
            StringBuilder N = a2.b.a.a.a.N("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ", b2, " numHashFunctions: ", i, " dataLength: ");
            N.append(i2);
            throw new IOException(N.toString(), e);
        }
    }

    private Object writeReplace() {
        return new a(this);
    }

    @VisibleForTesting
    public long a() {
        return this.a.a();
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(T t) {
        return mightContain(t);
    }

    public long approximateElementCount() {
        double a3 = (double) this.a.a();
        return DoubleMath.roundToLong(((-Math.log1p(-(((double) this.a.b.a()) / a3))) * a3) / ((double) this.b), RoundingMode.HALF_UP);
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(new h.c(h.c.d(this.a.a)), this.b, this.c, this.d);
    }

    @Override // com.google.common.base.Predicate, java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        if (this.b != bloomFilter.b || !this.c.equals(bloomFilter.c) || !this.a.equals(bloomFilter.a) || !this.d.equals(bloomFilter.d)) {
            return false;
        }
        return true;
    }

    public double expectedFpp() {
        return Math.pow(((double) this.a.b.a()) / ((double) a()), (double) this.b);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.b), this.c, this.d, this.a);
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        return this != bloomFilter && this.b == bloomFilter.b && a() == bloomFilter.a() && this.d.equals(bloomFilter.d) && this.c.equals(bloomFilter.c);
    }

    public boolean mightContain(T t) {
        return this.d.g(t, this.c, this.b, this.a);
    }

    @CanIgnoreReturnValue
    public boolean put(T t) {
        return this.d.k(t, this.c, this.b, this.a);
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        long j;
        long j2;
        boolean z;
        Preconditions.checkNotNull(bloomFilter);
        Preconditions.checkArgument(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        int i = this.b;
        int i2 = bloomFilter.b;
        Preconditions.checkArgument(i == i2, "BloomFilters must have the same number of hash functions (%s != %s)", i, i2);
        Preconditions.checkArgument(a() == bloomFilter.a(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", a(), bloomFilter.a());
        Preconditions.checkArgument(this.d.equals(bloomFilter.d), "BloomFilters must have equal strategies (%s != %s)", this.d, bloomFilter.d);
        Preconditions.checkArgument(this.c.equals(bloomFilter.c), "BloomFilters must have equal funnels (%s != %s)", this.c, bloomFilter.c);
        h.c cVar = this.a;
        h.c cVar2 = bloomFilter.a;
        Preconditions.checkArgument(cVar.a.length() == cVar2.a.length(), "BitArrays must be of equal length (%s != %s)", cVar.a.length(), cVar2.a.length());
        for (int i3 = 0; i3 < cVar.a.length(); i3++) {
            long j3 = cVar2.a.get(i3);
            while (true) {
                j = cVar.a.get(i3);
                j2 = j | j3;
                if (j != j2) {
                    if (cVar.a.compareAndSet(i3, j, j2)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                cVar.b.add((long) (Long.bitCount(j2) - Long.bitCount(j)));
            }
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.checkedCast((long) this.d.ordinal()));
        dataOutputStream.writeByte(UnsignedBytes.checkedCast((long) this.b));
        dataOutputStream.writeInt(this.a.a.length());
        for (int i = 0; i < this.a.a.length(); i++) {
            dataOutputStream.writeLong(this.a.a.get(i));
        }
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j, double d2) {
        h hVar = h.MURMUR128_MITZ_64;
        Preconditions.checkNotNull(funnel);
        boolean z = false;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        Preconditions.checkArgument(i >= 0, "Expected insertions (%s) must be >= 0", j);
        int i2 = (d2 > 0.0d ? 1 : (d2 == 0.0d ? 0 : -1));
        Preconditions.checkArgument(i2 > 0, "False positive probability (%s) must be > 0.0", Double.valueOf(d2));
        if (d2 < 1.0d) {
            z = true;
        }
        Preconditions.checkArgument(z, "False positive probability (%s) must be < 1.0", Double.valueOf(d2));
        Preconditions.checkNotNull(hVar);
        if (i == 0) {
            j = 1;
        }
        if (i2 == 0) {
            d2 = Double.MIN_VALUE;
        }
        long log = (long) ((Math.log(d2) * ((double) (-j))) / (Math.log(2.0d) * Math.log(2.0d)));
        try {
            return new BloomFilter<>(new h.c(log), Math.max(1, (int) Math.round(Math.log(2.0d) * (((double) log) / ((double) j)))), funnel, hVar);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(a2.b.a.a.a.V2("Could not create BloomFilter of ", log, " bits"), e);
        }
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i) {
        return create(funnel, (long) i);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j) {
        return create(funnel, j, 0.03d);
    }
}
