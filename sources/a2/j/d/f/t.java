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
public final class t<N, E> extends e<N, E> {
    @LazyInit
    public transient Reference<Multiset<N>> d;
    @LazyInit
    public transient Reference<Multiset<N>> e;

    public class a extends l0<E> {
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Map map, Object obj, Object obj2) {
            super(map, obj);
            this.c = obj2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return t.this.n().count(this.c);
        }
    }

    public t(Map<E, N> map, Map<E, N> map2, int i) {
        super(map, map2, i);
    }

    @NullableDecl
    public static <T> T m(@NullableDecl Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    @Override // a2.j.d.f.m0
    public Set<N> b() {
        return Collections.unmodifiableSet(n().mo6elementSet());
    }

    @Override // a2.j.d.f.m0
    public Set<N> c() {
        Multiset multiset = (Multiset) m(this.d);
        if (multiset == null) {
            multiset = HashMultiset.create(this.a.values());
            this.d = new SoftReference(multiset);
        }
        return Collections.unmodifiableSet(multiset.mo6elementSet());
    }

    @Override // a2.j.d.f.e, a2.j.d.f.m0
    public N f(E e2) {
        N n = (N) Preconditions.checkNotNull(this.b.remove(e2));
        Multiset multiset = (Multiset) m(this.e);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(n));
        }
        return n;
    }

    @Override // a2.j.d.f.e, a2.j.d.f.m0
    public N h(E e2, boolean z) {
        N n = (N) super.h(e2, z);
        Multiset multiset = (Multiset) m(this.d);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(n));
        }
        return n;
    }

    @Override // a2.j.d.f.e, a2.j.d.f.m0
    public void i(E e2, N n) {
        Preconditions.checkState(this.b.put(e2, n) == null);
        Multiset multiset = (Multiset) m(this.e);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(n));
        }
    }

    @Override // a2.j.d.f.e, a2.j.d.f.m0
    public void j(E e2, N n, boolean z) {
        super.j(e2, n, z);
        Multiset multiset = (Multiset) m(this.d);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(n));
        }
    }

    @Override // a2.j.d.f.m0
    public Set<E> l(N n) {
        return new a(this.b, n, n);
    }

    public final Multiset<N> n() {
        Multiset<N> multiset = (Multiset) m(this.e);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset create = HashMultiset.create(this.b.values());
        this.e = new SoftReference(create);
        return create;
    }
}
