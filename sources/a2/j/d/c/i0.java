package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.primitives.Booleans;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class i0<C extends Comparable> implements Comparable<i0<C>>, Serializable {
    private static final long serialVersionUID = 0;
    @NullableDecl
    public final C a;

    public static final class a extends i0<Comparable<?>> {
        public static final a b = new a();
        private static final long serialVersionUID = 0;

        public a() {
            super(null);
        }

        private Object readResolve() {
            return b;
        }

        @Override // a2.j.d.c.i0
        /* renamed from: b */
        public int compareTo(i0<Comparable<?>> i0Var) {
            return i0Var == this ? 0 : 1;
        }

        @Override // a2.j.d.c.i0
        public void c(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // a2.j.d.c.i0
        public void d(StringBuilder sb) {
            sb.append("+∞)");
        }

        @Override // a2.j.d.c.i0
        public Comparable<?> e() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // a2.j.d.c.i0
        public Comparable<?> f(DiscreteDomain<Comparable<?>> discreteDomain) {
            return discreteDomain.maxValue();
        }

        @Override // a2.j.d.c.i0
        public boolean h(Comparable<?> comparable) {
            return false;
        }

        @Override // a2.j.d.c.i0, java.lang.Object
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // a2.j.d.c.i0
        public Comparable<?> i(DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError();
        }

        @Override // a2.j.d.c.i0
        public BoundType j() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // a2.j.d.c.i0
        public BoundType l() {
            throw new IllegalStateException();
        }

        @Override // a2.j.d.c.i0
        public i0<Comparable<?>> m(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // a2.j.d.c.i0
        public i0<Comparable<?>> n(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new IllegalStateException();
        }

        @Override // java.lang.Object
        public String toString() {
            return "+∞";
        }
    }

    public static final class b<C extends Comparable> extends i0<C> {
        private static final long serialVersionUID = 0;

        public b(C c) {
            super((Comparable) Preconditions.checkNotNull(c));
        }

        @Override // a2.j.d.c.i0
        public i0<C> a(DiscreteDomain<C> discreteDomain) {
            C next = discreteDomain.next(this.a);
            if (next != null) {
                return new d(next);
            }
            return a.b;
        }

        @Override // a2.j.d.c.i0
        public void c(StringBuilder sb) {
            sb.append('(');
            sb.append(this.a);
        }

        @Override // a2.j.d.c.i0, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((i0) obj);
        }

        @Override // a2.j.d.c.i0
        public void d(StringBuilder sb) {
            sb.append(this.a);
            sb.append(']');
        }

        @Override // a2.j.d.c.i0
        public C f(DiscreteDomain<C> discreteDomain) {
            return this.a;
        }

        @Override // a2.j.d.c.i0
        public boolean h(C c) {
            C c2 = this.a;
            Range<Comparable> range = Range.c;
            return c2.compareTo(c) < 0;
        }

        @Override // a2.j.d.c.i0, java.lang.Object
        public int hashCode() {
            return ~this.a.hashCode();
        }

        @Override // a2.j.d.c.i0
        public C i(DiscreteDomain<C> discreteDomain) {
            return discreteDomain.next(this.a);
        }

        @Override // a2.j.d.c.i0
        public BoundType j() {
            return BoundType.OPEN;
        }

        @Override // a2.j.d.c.i0
        public BoundType l() {
            return BoundType.CLOSED;
        }

        @Override // a2.j.d.c.i0
        public i0<C> m(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int ordinal = boundType.ordinal();
            if (ordinal == 0) {
                return this;
            }
            if (ordinal == 1) {
                C next = discreteDomain.next(this.a);
                if (next == null) {
                    return c.b;
                }
                return new d(next);
            }
            throw new AssertionError();
        }

        @Override // a2.j.d.c.i0
        public i0<C> n(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int ordinal = boundType.ordinal();
            if (ordinal == 0) {
                C next = discreteDomain.next(this.a);
                if (next == null) {
                    return a.b;
                }
                return new d(next);
            } else if (ordinal == 1) {
                return this;
            } else {
                throw new AssertionError();
            }
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("/");
            L.append(this.a);
            L.append("\\");
            return L.toString();
        }
    }

    public static final class c extends i0<Comparable<?>> {
        public static final c b = new c();
        private static final long serialVersionUID = 0;

        public c() {
            super(null);
        }

        private Object readResolve() {
            return b;
        }

        @Override // a2.j.d.c.i0
        public i0<Comparable<?>> a(DiscreteDomain<Comparable<?>> discreteDomain) {
            try {
                return new d(discreteDomain.minValue());
            } catch (NoSuchElementException unused) {
                return this;
            }
        }

        @Override // a2.j.d.c.i0
        /* renamed from: b */
        public int compareTo(i0<Comparable<?>> i0Var) {
            return i0Var == this ? 0 : -1;
        }

        @Override // a2.j.d.c.i0
        public void c(StringBuilder sb) {
            sb.append("(-∞");
        }

        @Override // a2.j.d.c.i0
        public void d(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // a2.j.d.c.i0
        public Comparable<?> e() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // a2.j.d.c.i0
        public Comparable<?> f(DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError();
        }

        @Override // a2.j.d.c.i0
        public boolean h(Comparable<?> comparable) {
            return true;
        }

        @Override // a2.j.d.c.i0, java.lang.Object
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // a2.j.d.c.i0
        public Comparable<?> i(DiscreteDomain<Comparable<?>> discreteDomain) {
            return discreteDomain.minValue();
        }

        @Override // a2.j.d.c.i0
        public BoundType j() {
            throw new IllegalStateException();
        }

        @Override // a2.j.d.c.i0
        public BoundType l() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // a2.j.d.c.i0
        public i0<Comparable<?>> m(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new IllegalStateException();
        }

        @Override // a2.j.d.c.i0
        public i0<Comparable<?>> n(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // java.lang.Object
        public String toString() {
            return "-∞";
        }
    }

    public static final class d<C extends Comparable> extends i0<C> {
        private static final long serialVersionUID = 0;

        public d(C c) {
            super((Comparable) Preconditions.checkNotNull(c));
        }

        @Override // a2.j.d.c.i0
        public void c(StringBuilder sb) {
            sb.append('[');
            sb.append(this.a);
        }

        @Override // a2.j.d.c.i0, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((i0) obj);
        }

        @Override // a2.j.d.c.i0
        public void d(StringBuilder sb) {
            sb.append(this.a);
            sb.append(')');
        }

        @Override // a2.j.d.c.i0
        public C f(DiscreteDomain<C> discreteDomain) {
            return discreteDomain.previous(this.a);
        }

        @Override // a2.j.d.c.i0
        public boolean h(C c) {
            C c2 = this.a;
            Range<Comparable> range = Range.c;
            return c2.compareTo(c) <= 0;
        }

        @Override // a2.j.d.c.i0, java.lang.Object
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // a2.j.d.c.i0
        public C i(DiscreteDomain<C> discreteDomain) {
            return this.a;
        }

        @Override // a2.j.d.c.i0
        public BoundType j() {
            return BoundType.CLOSED;
        }

        @Override // a2.j.d.c.i0
        public BoundType l() {
            return BoundType.OPEN;
        }

        @Override // a2.j.d.c.i0
        public i0<C> m(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int ordinal = boundType.ordinal();
            if (ordinal == 0) {
                C previous = discreteDomain.previous(this.a);
                return previous == null ? c.b : new b(previous);
            } else if (ordinal == 1) {
                return this;
            } else {
                throw new AssertionError();
            }
        }

        @Override // a2.j.d.c.i0
        public i0<C> n(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int ordinal = boundType.ordinal();
            if (ordinal == 0) {
                return this;
            }
            if (ordinal == 1) {
                C previous = discreteDomain.previous(this.a);
                return previous == null ? a.b : new b(previous);
            }
            throw new AssertionError();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("\\");
            L.append(this.a);
            L.append("/");
            return L.toString();
        }
    }

    public i0(@NullableDecl C c2) {
        this.a = c2;
    }

    public i0<C> a(DiscreteDomain<C> discreteDomain) {
        return this;
    }

    /* renamed from: b */
    public int compareTo(i0<C> i0Var) {
        if (i0Var == c.b) {
            return 1;
        }
        if (i0Var == a.b) {
            return -1;
        }
        C c2 = this.a;
        C c3 = i0Var.a;
        Range<Comparable> range = Range.c;
        int compareTo = c2.compareTo(c3);
        if (compareTo != 0) {
            return compareTo;
        }
        return Booleans.compare(this instanceof b, i0Var instanceof b);
    }

    public abstract void c(StringBuilder sb);

    public abstract void d(StringBuilder sb);

    public C e() {
        return this.a;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof i0)) {
            return false;
        }
        try {
            if (compareTo((i0) obj) == 0) {
                return true;
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public abstract C f(DiscreteDomain<C> discreteDomain);

    public abstract boolean h(C c2);

    @Override // java.lang.Object
    public abstract int hashCode();

    public abstract C i(DiscreteDomain<C> discreteDomain);

    public abstract BoundType j();

    public abstract BoundType l();

    public abstract i0<C> m(BoundType boundType, DiscreteDomain<C> discreteDomain);

    public abstract i0<C> n(BoundType boundType, DiscreteDomain<C> discreteDomain);
}
