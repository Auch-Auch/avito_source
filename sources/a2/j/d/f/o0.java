package a2.j.d.f;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class o0<N, E> extends i<N, E> {
    @LazyInit
    public transient Reference<Multiset<N>> b;

    public class a extends l0<E> {
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Map map, Object obj, Object obj2) {
            super(map, obj);
            this.c = obj2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return o0.this.m().count(this.c);
        }
    }

    public o0(Map<E, N> map) {
        super(map);
    }

    @NullableDecl
    public static <T> T n(@NullableDecl Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    @Override // a2.j.d.f.m0
    public Set<N> a() {
        return Collections.unmodifiableSet(m().mo6elementSet());
    }

    @Override // a2.j.d.f.i, a2.j.d.f.m0
    public N f(E e) {
        N n = (N) Preconditions.checkNotNull(this.a.remove(e));
        Multiset multiset = (Multiset) n(this.b);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(n));
        }
        return n;
    }

    @Override // a2.j.d.f.i, a2.j.d.f.m0
    public N h(E e, boolean z) {
        if (!z) {
            return f(e);
        }
        return null;
    }

    @Override // a2.j.d.f.i, a2.j.d.f.m0
    public void i(E e, N n) {
        super.i(e, n);
        Multiset multiset = (Multiset) n(this.b);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(n));
        }
    }

    @Override // a2.j.d.f.i, a2.j.d.f.m0
    public void j(E e, N n, boolean z) {
        if (!z) {
            i(e, n);
        }
    }

    @Override // a2.j.d.f.m0
    public Set<E> l(N n) {
        return new a(this.a, n, n);
    }

    public final Multiset<N> m() {
        Multiset<N> multiset = (Multiset) n(this.b);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset create = HashMultiset.create(this.a.values());
        this.b = new SoftReference(create);
        return create;
    }
}
