package com.google.common.base;

import a2.j.d.a.g;
import a2.j.d.a.j;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public final class Predicates {

    public static class b<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final List<? extends Predicate<? super T>> a;

        public b(List list, a aVar) {
            this.a = list;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl T t) {
            for (int i = 0; i < this.a.size(); i++) {
                if (!((Predicate) this.a.get(i)).apply(t)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.a.hashCode() + 306654252;
        }

        @Override // java.lang.Object
        public String toString() {
            return Predicates.a("and", this.a);
        }
    }

    public static class c<A, B> implements Predicate<A>, Serializable {
        private static final long serialVersionUID = 0;
        public final Predicate<B> a;
        public final Function<A, ? extends B> b;

        public c(Predicate predicate, Function function, a aVar) {
            this.a = (Predicate) Preconditions.checkNotNull(predicate);
            this.b = (Function) Preconditions.checkNotNull(function);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.base.Predicate<B> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl A a3) {
            return this.a.apply(this.b.apply(a3));
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.b.equals(cVar.b) || !this.a.equals(cVar.a)) {
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

    @GwtIncompatible
    public static class d extends e {
        private static final long serialVersionUID = 0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(new a2.j.d.a.g(Pattern.compile(str)));
            a2.j.d.a.i iVar = a2.j.d.a.j.a;
            Preconditions.checkNotNull(str);
            Objects.requireNonNull((j.b) a2.j.d.a.j.a);
        }

        @Override // com.google.common.base.Predicates.e, java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Predicates.containsPattern(");
            L.append(this.a.c());
            L.append(")");
            return L.toString();
        }
    }

    @GwtIncompatible
    public static class e implements Predicate<CharSequence>, Serializable {
        private static final long serialVersionUID = 0;
        public final a2.j.d.a.e a;

        public e(a2.j.d.a.e eVar) {
            this.a = (a2.j.d.a.e) Preconditions.checkNotNull(eVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Predicate
        public boolean apply(CharSequence charSequence) {
            return ((g.a) this.a.b(charSequence)).a.find();
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (!Objects.equal(this.a.c(), eVar.a.c()) || this.a.a() != eVar.a.a()) {
                return false;
            }
            return true;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return Objects.hashCode(this.a.c(), Integer.valueOf(this.a.a()));
        }

        @Override // java.lang.Object
        public String toString() {
            return a2.b.a.a.a.e3("Predicates.contains(", MoreObjects.toStringHelper(this.a).add("pattern", this.a.c()).add("pattern.flags", this.a.a()).toString(), ")");
        }
    }

    public static class f<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final Collection<?> a;

        public f(Collection collection, a aVar) {
            this.a = (Collection) Preconditions.checkNotNull(collection);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl T t) {
            try {
                return this.a.contains(t);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof f) {
                return this.a.equals(((f) obj).a);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Predicates.in(");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    @GwtIncompatible
    public static class g implements Predicate<Object>, Serializable {
        private static final long serialVersionUID = 0;
        public final Class<?> a;

        public g(Class cls, a aVar) {
            this.a = (Class) Preconditions.checkNotNull(cls);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl Object obj) {
            return this.a.isInstance(obj);
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof g) || this.a != ((g) obj).a) {
                return false;
            }
            return true;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            return a2.b.a.a.a.D2(this.a, a2.b.a.a.a.L("Predicates.instanceOf("), ")");
        }
    }

    public static class h<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final T a;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        public h(Object obj, a aVar) {
            this.a = obj;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(T t) {
            return this.a.equals(t);
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
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
            return a2.b.a.a.a.r(a2.b.a.a.a.L("Predicates.equalTo("), this.a, ")");
        }
    }

    public static class i<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final Predicate<T> a;

        public i(Predicate<T> predicate) {
            this.a = (Predicate) Preconditions.checkNotNull(predicate);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl T t) {
            return !this.a.apply(t);
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof i) {
                return this.a.equals(((i) obj).a);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return ~this.a.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Predicates.not(");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    public enum j implements Predicate<Object> {
        ALWAYS_TRUE {
            @Override // com.google.common.base.Predicate
            public boolean apply(@NullableDecl Object obj) {
                return true;
            }

            @Override // java.lang.Enum, java.lang.Object
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE {
            @Override // com.google.common.base.Predicate
            public boolean apply(@NullableDecl Object obj) {
                return false;
            }

            @Override // java.lang.Enum, java.lang.Object
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL {
            @Override // com.google.common.base.Predicate
            public boolean apply(@NullableDecl Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum, java.lang.Object
            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL {
            @Override // com.google.common.base.Predicate
            public boolean apply(@NullableDecl Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum, java.lang.Object
            public String toString() {
                return "Predicates.notNull()";
            }
        };

        /* access modifiers changed from: public */
        j(a aVar) {
        }
    }

    public static class k<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final List<? extends Predicate<? super T>> a;

        public k(List list, a aVar) {
            this.a = list;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl T t) {
            for (int i = 0; i < this.a.size(); i++) {
                if (((Predicate) this.a.get(i)).apply(t)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof k) {
                return this.a.equals(((k) obj).a);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.a.hashCode() + 87855567;
        }

        @Override // java.lang.Object
        public String toString() {
            return Predicates.a("or", this.a);
        }
    }

    @GwtIncompatible
    public static class l implements Predicate<Class<?>>, Serializable {
        private static final long serialVersionUID = 0;
        public final Class<?> a;

        public l(Class cls, a aVar) {
            this.a = (Class) Preconditions.checkNotNull(cls);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Predicate
        public boolean apply(Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }

        @Override // com.google.common.base.Predicate, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof l) || this.a != ((l) obj).a) {
                return false;
            }
            return true;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            return a2.b.a.a.a.D2(this.a, a2.b.a.a.a.L("Predicates.subtypeOf("), ")");
        }
    }

    public static String a(String str, Iterable iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z = true;
        for (Object obj : iterable) {
            if (!z) {
                sb.append(',');
            }
            sb.append(obj);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> alwaysFalse() {
        return j.ALWAYS_FALSE;
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> alwaysTrue() {
        return j.ALWAYS_TRUE;
    }

    public static <T> Predicate<T> and(Iterable<? extends Predicate<? super T>> iterable) {
        return new b(b(iterable), null);
    }

    public static <T> List<T> b(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            arrayList.add(Preconditions.checkNotNull(t));
        }
        return arrayList;
    }

    public static <A, B> Predicate<A> compose(Predicate<B> predicate, Function<A, ? extends B> function) {
        return new c(predicate, function, null);
    }

    @GwtIncompatible("java.util.regex.Pattern")
    public static Predicate<CharSequence> contains(Pattern pattern) {
        return new e(new a2.j.d.a.g(pattern));
    }

    @GwtIncompatible
    public static Predicate<CharSequence> containsPattern(String str) {
        return new d(str);
    }

    public static <T> Predicate<T> equalTo(@NullableDecl T t) {
        return t == null ? isNull() : new h(t, null);
    }

    public static <T> Predicate<T> in(Collection<? extends T> collection) {
        return new f(collection, null);
    }

    @GwtIncompatible
    public static Predicate<Object> instanceOf(Class<?> cls) {
        return new g(cls, null);
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> isNull() {
        return j.IS_NULL;
    }

    public static <T> Predicate<T> not(Predicate<T> predicate) {
        return new i(predicate);
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> notNull() {
        return j.NOT_NULL;
    }

    public static <T> Predicate<T> or(Iterable<? extends Predicate<? super T>> iterable) {
        return new k(b(iterable), null);
    }

    @Beta
    @GwtIncompatible
    public static Predicate<Class<?>> subtypeOf(Class<?> cls) {
        return new l(cls, null);
    }

    @SafeVarargs
    public static <T> Predicate<T> and(Predicate<? super T>... predicateArr) {
        return new b(b(Arrays.asList(predicateArr)), null);
    }

    @SafeVarargs
    public static <T> Predicate<T> or(Predicate<? super T>... predicateArr) {
        return new k(b(Arrays.asList(predicateArr)), null);
    }

    public static <T> Predicate<T> and(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new b(Arrays.asList((Predicate) Preconditions.checkNotNull(predicate), (Predicate) Preconditions.checkNotNull(predicate2)), null);
    }

    public static <T> Predicate<T> or(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new k(Arrays.asList((Predicate) Preconditions.checkNotNull(predicate), (Predicate) Preconditions.checkNotNull(predicate2)), null);
    }
}
