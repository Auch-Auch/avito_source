package a2.j.d.f;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.graph.Graphs;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class e<N, E> implements m0<N, E> {
    public final Map<E, N> a;
    public final Map<E, N> b;
    public int c;

    public class a extends AbstractSet<E> {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return e.this.a.containsKey(obj) || e.this.b.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator iterator() {
            Iterable iterable;
            e eVar = e.this;
            if (eVar.c == 0) {
                iterable = Iterables.concat(eVar.a.keySet(), e.this.b.keySet());
            } else {
                iterable = Sets.union(eVar.a.keySet(), e.this.b.keySet());
            }
            return Iterators.unmodifiableIterator(iterable.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IntMath.saturatedAdd(e.this.a.size(), e.this.b.size() - e.this.c);
        }
    }

    public e(Map<E, N> map, Map<E, N> map2, int i) {
        this.a = (Map) Preconditions.checkNotNull(map);
        this.b = (Map) Preconditions.checkNotNull(map2);
        Graphs.a(i);
        this.c = i;
        Preconditions.checkState(i <= map.size() && i <= map2.size());
    }

    @Override // a2.j.d.f.m0
    public Set<N> a() {
        return Sets.union(c(), b());
    }

    @Override // a2.j.d.f.m0
    public N d(E e) {
        return (N) Preconditions.checkNotNull(this.b.get(e));
    }

    @Override // a2.j.d.f.m0
    public Set<E> e() {
        return Collections.unmodifiableSet(this.a.keySet());
    }

    @Override // a2.j.d.f.m0
    public N f(E e) {
        return (N) Preconditions.checkNotNull(this.b.remove(e));
    }

    @Override // a2.j.d.f.m0
    public Set<E> g() {
        return Collections.unmodifiableSet(this.b.keySet());
    }

    @Override // a2.j.d.f.m0
    public N h(E e, boolean z) {
        if (z) {
            int i = this.c - 1;
            this.c = i;
            Graphs.a(i);
        }
        return (N) Preconditions.checkNotNull(this.a.remove(e));
    }

    @Override // a2.j.d.f.m0
    public void i(E e, N n) {
        Preconditions.checkState(this.b.put(e, n) == null);
    }

    @Override // a2.j.d.f.m0
    public void j(E e, N n, boolean z) {
        boolean z2 = true;
        if (z) {
            int i = this.c + 1;
            this.c = i;
            Graphs.c(i);
        }
        if (this.a.put(e, n) != null) {
            z2 = false;
        }
        Preconditions.checkState(z2);
    }

    @Override // a2.j.d.f.m0
    public Set<E> k() {
        return new a();
    }
}
