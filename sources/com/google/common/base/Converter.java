package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class Converter<A, B> implements Function<A, B> {
    public final boolean a = true;
    @LazyInit
    @MonotonicNonNullDecl
    public transient Converter<B, A> b;

    public class a implements Iterable<B> {
        public final /* synthetic */ Iterable a;

        /* renamed from: com.google.common.base.Converter$a$a  reason: collision with other inner class name */
        public class C0275a implements Iterator<B> {
            public final Iterator<? extends A> a;

            public C0275a() {
                this.a = a.this.a.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a.hasNext();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.base.Converter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Iterator
            public B next() {
                return (B) Converter.this.convert(this.a.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.a.remove();
            }
        }

        public a(Iterable iterable) {
            this.a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<B> iterator() {
            return new C0275a();
        }
    }

    public static final class b<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        public final Converter<A, B> c;
        public final Converter<B, C> d;

        public b(Converter<A, B> converter, Converter<B, C> converter2) {
            this.c = converter;
            this.d = converter2;
        }

        @Override // com.google.common.base.Converter
        @NullableDecl
        public A a(@NullableDecl C c2) {
            return this.c.a(this.d.a(c2));
        }

        @Override // com.google.common.base.Converter
        @NullableDecl
        public C b(@NullableDecl A a) {
            return this.d.b(this.c.b(a));
        }

        @Override // com.google.common.base.Converter
        public A doBackward(C c2) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public C doForward(A a) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.c.equals(bVar.c) || !this.d.equals(bVar.d)) {
                return false;
            }
            return true;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.d.hashCode() + (this.c.hashCode() * 31);
        }

        @Override // java.lang.Object
        public String toString() {
            return this.c + ".andThen(" + this.d + ")";
        }
    }

    public static final class c<A, B> extends Converter<A, B> implements Serializable {
        public final Function<? super A, ? extends B> c;
        public final Function<? super B, ? extends A> d;

        public c(Function function, Function function2, a aVar) {
            this.c = (Function) Preconditions.checkNotNull(function);
            this.d = (Function) Preconditions.checkNotNull(function2);
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B b) {
            return (A) this.d.apply(b);
        }

        @Override // com.google.common.base.Converter
        public B doForward(A a) {
            return (B) this.c.apply(a);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.c.equals(cVar.c) || !this.d.equals(cVar.d)) {
                return false;
            }
            return true;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.d.hashCode() + (this.c.hashCode() * 31);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Converter.from(");
            L.append(this.c);
            L.append(", ");
            L.append(this.d);
            L.append(")");
            return L.toString();
        }
    }

    public static final class d<T> extends Converter<T, T> implements Serializable {
        public static final d c = new d();
        private static final long serialVersionUID = 0;

        private Object readResolve() {
            return c;
        }

        @Override // com.google.common.base.Converter
        public <S> Converter<T, S> c(Converter<T, S> converter) {
            return (Converter) Preconditions.checkNotNull(converter, "otherConverter");
        }

        @Override // com.google.common.base.Converter
        public T doBackward(T t) {
            return t;
        }

        @Override // com.google.common.base.Converter
        public T doForward(T t) {
            return t;
        }

        @Override // com.google.common.base.Converter
        public Converter reverse() {
            return this;
        }

        @Override // java.lang.Object
        public String toString() {
            return "Converter.identity()";
        }
    }

    public static final class e<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        public final Converter<A, B> c;

        public e(Converter<A, B> converter) {
            this.c = converter;
        }

        @Override // com.google.common.base.Converter
        @NullableDecl
        public B a(@NullableDecl A a) {
            return this.c.b(a);
        }

        @Override // com.google.common.base.Converter
        @NullableDecl
        public A b(@NullableDecl B b) {
            return this.c.a(b);
        }

        @Override // com.google.common.base.Converter
        public B doBackward(A a) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public A doForward(B b) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof e) {
                return this.c.equals(((e) obj).c);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return ~this.c.hashCode();
        }

        @Override // com.google.common.base.Converter
        public Converter<A, B> reverse() {
            return this.c;
        }

        @Override // java.lang.Object
        public String toString() {
            return this.c + ".reverse()";
        }
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new c(function, function2, null);
    }

    public static <T> Converter<T, T> identity() {
        return d.c;
    }

    @NullableDecl
    public A a(@NullableDecl B b2) {
        if (!this.a) {
            return doBackward(b2);
        }
        if (b2 == null) {
            return null;
        }
        return (A) Preconditions.checkNotNull(doBackward(b2));
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return c(converter);
    }

    @Override // com.google.common.base.Function
    @NullableDecl
    @Deprecated
    @CanIgnoreReturnValue
    public final B apply(@NullableDecl A a3) {
        return convert(a3);
    }

    @NullableDecl
    public B b(@NullableDecl A a3) {
        if (!this.a) {
            return doForward(a3);
        }
        if (a3 == null) {
            return null;
        }
        return (B) Preconditions.checkNotNull(doForward(a3));
    }

    public <C> Converter<A, C> c(Converter<B, C> converter) {
        return new b(this, (Converter) Preconditions.checkNotNull(converter));
    }

    @CanIgnoreReturnValue
    @NullableDecl
    public final B convert(@NullableDecl A a3) {
        return b(a3);
    }

    @CanIgnoreReturnValue
    public Iterable<B> convertAll(Iterable<? extends A> iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new a(iterable);
    }

    @ForOverride
    public abstract A doBackward(B b2);

    @ForOverride
    public abstract B doForward(A a3);

    @Override // com.google.common.base.Function, java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @CanIgnoreReturnValue
    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.b;
        if (converter != null) {
            return converter;
        }
        e eVar = new e(this);
        this.b = eVar;
        return eVar;
    }
}
