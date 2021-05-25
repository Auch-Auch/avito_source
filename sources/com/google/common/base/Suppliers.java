package com.google.common.base;

import a2.j.d.a.i;
import a2.j.d.a.j;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public final class Suppliers {

    @VisibleForTesting
    public static class a<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final Supplier<T> a;
        public final long b;
        @NullableDecl
        public volatile transient T c;
        public volatile transient long d;

        public a(Supplier<T> supplier, long j, TimeUnit timeUnit) {
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
            this.b = timeUnit.toNanos(j);
            Preconditions.checkArgument(j > 0, "duration (%s %s) must be > 0", j, timeUnit);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            long j = this.d;
            i iVar = j.a;
            long nanoTime = System.nanoTime();
            if (j == 0 || nanoTime - j >= 0) {
                synchronized (this) {
                    if (j == this.d) {
                        T t = this.a.get();
                        this.c = t;
                        long j2 = nanoTime + this.b;
                        if (j2 == 0) {
                            j2 = 1;
                        }
                        this.d = j2;
                        return t;
                    }
                }
            }
            return this.c;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Suppliers.memoizeWithExpiration(");
            L.append(this.a);
            L.append(", ");
            return a2.b.a.a.a.l(L, this.b, ", NANOS)");
        }
    }

    @VisibleForTesting
    public static class b<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final Supplier<T> a;
        public volatile transient boolean b;
        @NullableDecl
        public transient T c;

        public b(Supplier<T> supplier) {
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            if (!this.b) {
                synchronized (this) {
                    if (!this.b) {
                        T t = this.a.get();
                        this.c = t;
                        this.b = true;
                        return t;
                    }
                }
            }
            return this.c;
        }

        @Override // java.lang.Object
        public String toString() {
            return a2.b.a.a.a.r(a2.b.a.a.a.L("Suppliers.memoize("), this.b ? a2.b.a.a.a.r(a2.b.a.a.a.L("<supplier that returned "), this.c, ">") : this.a, ")");
        }
    }

    @VisibleForTesting
    public static class c<T> implements Supplier<T> {
        public volatile Supplier<T> a;
        public volatile boolean b;
        @NullableDecl
        public T c;

        public c(Supplier<T> supplier) {
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            if (!this.b) {
                synchronized (this) {
                    if (!this.b) {
                        T t = this.a.get();
                        this.c = t;
                        this.b = true;
                        this.a = null;
                        return t;
                    }
                }
            }
            return this.c;
        }

        public String toString() {
            Object obj = this.a;
            StringBuilder L = a2.b.a.a.a.L("Suppliers.memoize(");
            if (obj == null) {
                obj = a2.b.a.a.a.r(a2.b.a.a.a.L("<supplier that returned "), this.c, ">");
            }
            return a2.b.a.a.a.r(L, obj, ")");
        }
    }

    public static class d<F, T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final Function<? super F, T> a;
        public final Supplier<F> b;

        public d(Function<? super F, T> function, Supplier<F> supplier) {
            this.a = (Function) Preconditions.checkNotNull(function);
            this.b = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (!this.a.equals(dVar.a) || !this.b.equals(dVar.b)) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            return this.a.apply(this.b.get());
        }

        @Override // java.lang.Object
        public int hashCode() {
            return Objects.hashCode(this.a, this.b);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Suppliers.compose(");
            L.append(this.a);
            L.append(", ");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    public enum e implements Object<Object> {
        INSTANCE;

        public Object apply(Object obj) {
            return ((Supplier) obj).get();
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Suppliers.supplierFunction()";
        }
    }

    public static class f<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        @NullableDecl
        public final T a;

        public f(@NullableDecl T t) {
            this.a = t;
        }

        @Override // java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof f) {
                return Objects.equal(this.a, ((f) obj).a);
            }
            return false;
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return Objects.hashCode(this.a);
        }

        @Override // java.lang.Object
        public String toString() {
            return a2.b.a.a.a.r(a2.b.a.a.a.L("Suppliers.ofInstance("), this.a, ")");
        }
    }

    public static class g<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final Supplier<T> a;

        public g(Supplier<T> supplier) {
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            T t;
            synchronized (this.a) {
                t = this.a.get();
            }
            return t;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Suppliers.synchronizedSupplier(");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    public static <F, T> Supplier<T> compose(Function<? super F, T> function, Supplier<F> supplier) {
        return new d(function, supplier);
    }

    public static <T> Supplier<T> memoize(Supplier<T> supplier) {
        if ((supplier instanceof c) || (supplier instanceof b)) {
            return supplier;
        }
        return supplier instanceof Serializable ? new b(supplier) : new c(supplier);
    }

    public static <T> Supplier<T> memoizeWithExpiration(Supplier<T> supplier, long j, TimeUnit timeUnit) {
        return new a(supplier, j, timeUnit);
    }

    public static <T> Supplier<T> ofInstance(@NullableDecl T t) {
        return new f(t);
    }

    public static <T> Function<Supplier<T>, T> supplierFunction() {
        return e.INSTANCE;
    }

    public static <T> Supplier<T> synchronizedSupplier(Supplier<T> supplier) {
        return new g(supplier);
    }
}
