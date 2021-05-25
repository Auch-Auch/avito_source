package com.google.common.collect;

import a2.j.d.c.b2;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import java.util.Objects;
@Beta
@GwtIncompatible
public final class Interners {

    public static class b<E> implements Function<E, E> {
        public final Interner<E> a;

        public b(Interner<E> interner) {
            this.a = interner;
        }

        @Override // com.google.common.base.Function
        public E apply(E e) {
            return this.a.intern(e);
        }

        @Override // com.google.common.base.Function, java.lang.Object
        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    @VisibleForTesting
    public static final class c<E> implements Interner<E> {
        @VisibleForTesting
        public final b2<E, MapMaker.a, ?, ?> a;

        public c(MapMaker mapMaker, a aVar) {
            b2<E, MapMaker.a, ?, ?> b2Var;
            mapMaker.c(Equivalence.equals());
            b2.f0<Object, Object, b2.e> f0Var = b2.j;
            b2.p a3 = mapMaker.a();
            b2.p pVar = b2.p.STRONG;
            if (a3 == pVar && mapMaker.b() == pVar) {
                b2Var = new b2<>(mapMaker, b2.q.a.a);
            } else {
                b2.p a4 = mapMaker.a();
                b2.p pVar2 = b2.p.WEAK;
                if (a4 == pVar2 && mapMaker.b() == pVar) {
                    b2Var = new b2<>(mapMaker, b2.y.a.a);
                } else if (mapMaker.b() == pVar2) {
                    throw new IllegalArgumentException("Map cannot have both weak and dummy values");
                } else {
                    throw new AssertionError();
                }
            }
            this.a = b2Var;
        }

        @Override // com.google.common.collect.Interner
        public E intern(E e) {
            b2.i iVar;
            E e2;
            do {
                b2<E, MapMaker.a, ?, ?> b2Var = this.a;
                Objects.requireNonNull(b2Var);
                if (e == null) {
                    iVar = null;
                } else {
                    int c = b2Var.c(e);
                    iVar = b2Var.d(c).e(e, c);
                }
                if (iVar != null && (e2 = (E) iVar.getKey()) != null) {
                    return e2;
                }
            } while (this.a.putIfAbsent(e, MapMaker.a.VALUE) != null);
            return e;
        }
    }

    public static <E> Function<E, E> asFunction(Interner<E> interner) {
        return new b((Interner) Preconditions.checkNotNull(interner));
    }

    public static InternerBuilder newBuilder() {
        return new InternerBuilder(null);
    }

    public static <E> Interner<E> newStrongInterner() {
        return newBuilder().strong().build();
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public static <E> Interner<E> newWeakInterner() {
        return newBuilder().weak().build();
    }

    public static class InternerBuilder {
        public final MapMaker a = new MapMaker();
        public boolean b = true;

        public InternerBuilder() {
        }

        public <E> Interner<E> build() {
            if (!this.b) {
                this.a.weakKeys();
            }
            return new c(this.a, null);
        }

        public InternerBuilder concurrencyLevel(int i) {
            this.a.concurrencyLevel(i);
            return this;
        }

        public InternerBuilder strong() {
            this.b = true;
            return this;
        }

        @GwtIncompatible("java.lang.ref.WeakReference")
        public InternerBuilder weak() {
            this.b = false;
            return this;
        }

        public InternerBuilder(a aVar) {
        }
    }
}
