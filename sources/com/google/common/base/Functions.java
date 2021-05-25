package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public final class Functions {

    public static class b<E> implements Function<Object, E>, Serializable {
        private static final long serialVersionUID = 0;
        @NullableDecl
        public final E a;

        public b(@NullableDecl E e) {
            this.a = e;
        }

        @Override // com.google.common.base.Function
        public E apply(@NullableDecl Object obj) {
            return this.a;
        }

        @Override // com.google.common.base.Function, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof b) {
                return Objects.equal(this.a, ((b) obj).a);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            E e = this.a;
            if (e == null) {
                return 0;
            }
            return e.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            return a2.b.a.a.a.r(a2.b.a.a.a.L("Functions.constant("), this.a, ")");
        }
    }

    public static class c<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        public final Map<K, ? extends V> a;
        @NullableDecl
        public final V b;

        public c(Map<K, ? extends V> map, @NullableDecl V v) {
            this.a = (Map) Preconditions.checkNotNull(map);
            this.b = v;
        }

        @Override // com.google.common.base.Function
        public V apply(@NullableDecl K k) {
            V v = (V) this.a.get(k);
            return (v != null || this.a.containsKey(k)) ? v : this.b;
        }

        @Override // com.google.common.base.Function, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.a.equals(cVar.a) || !Objects.equal(this.b, cVar.b)) {
                return false;
            }
            return true;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return Objects.hashCode(this.a, this.b);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Functions.forMap(");
            L.append(this.a);
            L.append(", defaultValue=");
            return a2.b.a.a.a.r(L, this.b, ")");
        }
    }

    public static class d<A, B, C> implements Function<A, C>, Serializable {
        private static final long serialVersionUID = 0;
        public final Function<B, C> a;
        public final Function<A, ? extends B> b;

        public d(Function<B, C> function, Function<A, ? extends B> function2) {
            this.a = (Function) Preconditions.checkNotNull(function);
            this.b = (Function) Preconditions.checkNotNull(function2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.base.Function<B, C> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Function
        public C apply(@NullableDecl A a3) {
            return (C) this.a.apply(this.b.apply(a3));
        }

        @Override // com.google.common.base.Function, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (!this.b.equals(dVar.b) || !this.a.equals(dVar.a)) {
                return false;
            }
            return true;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.b.hashCode() ^ this.a.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            return this.a + "(" + this.b + ")";
        }
    }

    public static class e<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        public final Map<K, V> a;

        public e(Map<K, V> map) {
            this.a = (Map) Preconditions.checkNotNull(map);
        }

        @Override // com.google.common.base.Function
        public V apply(@NullableDecl K k) {
            V v = this.a.get(k);
            Preconditions.checkArgument(v != null || this.a.containsKey(k), "Key '%s' not present in map", k);
            return v;
        }

        @Override // com.google.common.base.Function, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof e) {
                return this.a.equals(((e) obj).a);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            return a2.b.a.a.a.x(a2.b.a.a.a.L("Functions.forMap("), this.a, ")");
        }
    }

    public enum f implements Function<Object, Object> {
        INSTANCE;

        @Override // com.google.common.base.Function
        @NullableDecl
        public Object apply(@NullableDecl Object obj) {
            return obj;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Functions.identity()";
        }
    }

    public static class g<T> implements Function<T, Boolean>, Serializable {
        private static final long serialVersionUID = 0;
        public final Predicate<T> a;

        public g(Predicate predicate, a aVar) {
            this.a = (Predicate) Preconditions.checkNotNull(predicate);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.common.base.Function
        public Boolean apply(@NullableDecl Object obj) {
            return Boolean.valueOf(this.a.apply(obj));
        }

        @Override // com.google.common.base.Function, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof g) {
                return this.a.equals(((g) obj).a);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Functions.forPredicate(");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    public static class h<T> implements Function<Object, T>, Serializable {
        private static final long serialVersionUID = 0;
        public final Supplier<T> a;

        public h(Supplier supplier, a aVar) {
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.base.Function
        public T apply(@NullableDecl Object obj) {
            return this.a.get();
        }

        @Override // com.google.common.base.Function, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof h) {
                return this.a.equals(((h) obj).a);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Functions.forSupplier(");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    public enum i implements Function<Object, String> {
        INSTANCE;

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.common.base.Function
        public String apply(Object obj) {
            Preconditions.checkNotNull(obj);
            return obj.toString();
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Functions.toStringFunction()";
        }
    }

    public static <A, B, C> Function<A, C> compose(Function<B, C> function, Function<A, ? extends B> function2) {
        return new d(function, function2);
    }

    public static <E> Function<Object, E> constant(@NullableDecl E e2) {
        return new b(e2);
    }

    public static <K, V> Function<K, V> forMap(Map<K, V> map) {
        return new e(map);
    }

    public static <T> Function<T, Boolean> forPredicate(Predicate<T> predicate) {
        return new g(predicate, null);
    }

    public static <T> Function<Object, T> forSupplier(Supplier<T> supplier) {
        return new h(supplier, null);
    }

    public static <E> Function<E, E> identity() {
        return f.INSTANCE;
    }

    public static Function<Object, String> toStringFunction() {
        return i.INSTANCE;
    }

    public static <K, V> Function<K, V> forMap(Map<K, ? extends V> map, @NullableDecl V v) {
        return new c(map, v);
    }
}
