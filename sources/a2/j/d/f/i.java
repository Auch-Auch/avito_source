package a2.j.d.f;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
public abstract class i<N, E> implements m0<N, E> {
    public final Map<E, N> a;

    public i(Map<E, N> map) {
        this.a = (Map) Preconditions.checkNotNull(map);
    }

    @Override // a2.j.d.f.m0
    public Set<N> b() {
        return a();
    }

    @Override // a2.j.d.f.m0
    public Set<N> c() {
        return a();
    }

    @Override // a2.j.d.f.m0
    public N d(E e) {
        return (N) Preconditions.checkNotNull(this.a.get(e));
    }

    @Override // a2.j.d.f.m0
    public Set<E> e() {
        return k();
    }

    @Override // a2.j.d.f.m0
    public N f(E e) {
        return (N) Preconditions.checkNotNull(this.a.remove(e));
    }

    @Override // a2.j.d.f.m0
    public Set<E> g() {
        return k();
    }

    @Override // a2.j.d.f.m0
    public N h(E e, boolean z) {
        if (!z) {
            return f(e);
        }
        return null;
    }

    @Override // a2.j.d.f.m0
    public void i(E e, N n) {
        Preconditions.checkState(this.a.put(e, n) == null);
    }

    @Override // a2.j.d.f.m0
    public void j(E e, N n, boolean z) {
        if (!z) {
            i(e, n);
        }
    }

    @Override // a2.j.d.f.m0
    public Set<E> k() {
        return Collections.unmodifiableSet(this.a.keySet());
    }
}
