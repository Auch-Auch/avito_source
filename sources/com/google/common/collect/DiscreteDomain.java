package com.google.common.collect;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.avito.android.remote.model.Sort;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.Comparable;
import java.math.BigInteger;
import java.util.NoSuchElementException;
@GwtCompatible
public abstract class DiscreteDomain<C extends Comparable> {
    public final boolean a;

    public static final class b extends DiscreteDomain<BigInteger> implements Serializable {
        public static final b b = new b();
        public static final BigInteger c = BigInteger.valueOf(Long.MIN_VALUE);
        public static final BigInteger d = BigInteger.valueOf(Long.MAX_VALUE);
        private static final long serialVersionUID = 0;

        public b() {
            super(true, null);
        }

        private Object readResolve() {
            return b;
        }

        /* Return type fixed from 'java.lang.Comparable' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable, long] */
        @Override // com.google.common.collect.DiscreteDomain
        public BigInteger a(BigInteger bigInteger, long j) {
            AppCompatDelegateImpl.i.A(j, Sort.DISTANCE);
            return bigInteger.add(BigInteger.valueOf(j));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable, java.lang.Comparable] */
        @Override // com.google.common.collect.DiscreteDomain
        public long distance(BigInteger bigInteger, BigInteger bigInteger2) {
            return bigInteger2.subtract(bigInteger).max(c).min(d).longValue();
        }

        /* Return type fixed from 'java.lang.Comparable' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
        @Override // com.google.common.collect.DiscreteDomain
        public BigInteger next(BigInteger bigInteger) {
            return bigInteger.add(BigInteger.ONE);
        }

        /* Return type fixed from 'java.lang.Comparable' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
        @Override // com.google.common.collect.DiscreteDomain
        public BigInteger previous(BigInteger bigInteger) {
            return bigInteger.subtract(BigInteger.ONE);
        }

        @Override // java.lang.Object
        public String toString() {
            return "DiscreteDomain.bigIntegers()";
        }
    }

    public static final class c extends DiscreteDomain<Integer> implements Serializable {
        public static final c b = new c();
        private static final long serialVersionUID = 0;

        public c() {
            super(true, null);
        }

        private Object readResolve() {
            return b;
        }

        /* Return type fixed from 'java.lang.Comparable' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable, long] */
        @Override // com.google.common.collect.DiscreteDomain
        public Integer a(Integer num, long j) {
            AppCompatDelegateImpl.i.A(j, Sort.DISTANCE);
            return Integer.valueOf(Ints.checkedCast(num.longValue() + j));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable, java.lang.Comparable] */
        @Override // com.google.common.collect.DiscreteDomain
        public long distance(Integer num, Integer num2) {
            return ((long) num2.intValue()) - ((long) num.intValue());
        }

        /* Return type fixed from 'java.lang.Comparable' to match base method */
        @Override // com.google.common.collect.DiscreteDomain
        public Integer maxValue() {
            return Integer.MAX_VALUE;
        }

        /* Return type fixed from 'java.lang.Comparable' to match base method */
        @Override // com.google.common.collect.DiscreteDomain
        public Integer minValue() {
            return Integer.MIN_VALUE;
        }

        /* Return type fixed from 'java.lang.Comparable' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
        @Override // com.google.common.collect.DiscreteDomain
        public Integer next(Integer num) {
            int intValue = num.intValue();
            if (intValue == Integer.MAX_VALUE) {
                return null;
            }
            return Integer.valueOf(intValue + 1);
        }

        /* Return type fixed from 'java.lang.Comparable' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
        @Override // com.google.common.collect.DiscreteDomain
        public Integer previous(Integer num) {
            int intValue = num.intValue();
            if (intValue == Integer.MIN_VALUE) {
                return null;
            }
            return Integer.valueOf(intValue - 1);
        }

        @Override // java.lang.Object
        public String toString() {
            return "DiscreteDomain.integers()";
        }
    }

    public static final class d extends DiscreteDomain<Long> implements Serializable {
        public static final d b = new d();
        private static final long serialVersionUID = 0;

        public d() {
            super(true, null);
        }

        private Object readResolve() {
            return b;
        }

        /* Return type fixed from 'java.lang.Comparable' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable, long] */
        @Override // com.google.common.collect.DiscreteDomain
        public Long a(Long l, long j) {
            Long l2 = l;
            AppCompatDelegateImpl.i.A(j, Sort.DISTANCE);
            long longValue = l2.longValue() + j;
            if (longValue < 0) {
                Preconditions.checkArgument(l2.longValue() < 0, "overflow");
            }
            return Long.valueOf(longValue);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable, java.lang.Comparable] */
        @Override // com.google.common.collect.DiscreteDomain
        public long distance(Long l, Long l2) {
            Long l3 = l;
            Long l4 = l2;
            long longValue = l4.longValue() - l3.longValue();
            if (l4.longValue() > l3.longValue() && longValue < 0) {
                return Long.MAX_VALUE;
            }
            if (l4.longValue() >= l3.longValue() || longValue <= 0) {
                return longValue;
            }
            return Long.MIN_VALUE;
        }

        /* Return type fixed from 'java.lang.Comparable' to match base method */
        @Override // com.google.common.collect.DiscreteDomain
        public Long maxValue() {
            return Long.MAX_VALUE;
        }

        /* Return type fixed from 'java.lang.Comparable' to match base method */
        @Override // com.google.common.collect.DiscreteDomain
        public Long minValue() {
            return Long.MIN_VALUE;
        }

        /* Return type fixed from 'java.lang.Comparable' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
        @Override // com.google.common.collect.DiscreteDomain
        public Long next(Long l) {
            long longValue = l.longValue();
            if (longValue == Long.MAX_VALUE) {
                return null;
            }
            return Long.valueOf(longValue + 1);
        }

        /* Return type fixed from 'java.lang.Comparable' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
        @Override // com.google.common.collect.DiscreteDomain
        public Long previous(Long l) {
            long longValue = l.longValue();
            if (longValue == Long.MIN_VALUE) {
                return null;
            }
            return Long.valueOf(longValue - 1);
        }

        @Override // java.lang.Object
        public String toString() {
            return "DiscreteDomain.longs()";
        }
    }

    public DiscreteDomain() {
        this.a = false;
    }

    public static DiscreteDomain<BigInteger> bigIntegers() {
        b bVar = b.b;
        return b.b;
    }

    public static DiscreteDomain<Integer> integers() {
        return c.b;
    }

    public static DiscreteDomain<Long> longs() {
        return d.b;
    }

    public C a(C c2, long j) {
        AppCompatDelegateImpl.i.A(j, Sort.DISTANCE);
        for (long j2 = 0; j2 < j; j2++) {
            c2 = next(c2);
        }
        return c2;
    }

    public abstract long distance(C c2, C c3);

    @CanIgnoreReturnValue
    public C maxValue() {
        throw new NoSuchElementException();
    }

    @CanIgnoreReturnValue
    public C minValue() {
        throw new NoSuchElementException();
    }

    public abstract C next(C c2);

    public abstract C previous(C c2);

    public DiscreteDomain(boolean z, a aVar) {
        this.a = z;
    }
}
