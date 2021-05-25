package a2.j.d.f;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
public final class n0<N, V> implements a0<N, V> {
    public final Map<N, V> a;

    public n0(Map<N, V> map) {
        this.a = (Map) Preconditions.checkNotNull(map);
    }

    @Override // a2.j.d.f.a0
    public Set<N> a() {
        return Collections.unmodifiableSet(this.a.keySet());
    }

    @Override // a2.j.d.f.a0
    public Set<N> b() {
        return a();
    }

    @Override // a2.j.d.f.a0
    public Set<N> c() {
        return a();
    }

    @Override // a2.j.d.f.a0
    public void d(N n, V v) {
        this.a.put(n, v);
    }

    @Override // a2.j.d.f.a0
    public V e(N n) {
        return this.a.get(n);
    }

    @Override // a2.j.d.f.a0
    public V f(N n) {
        return this.a.remove(n);
    }

    @Override // a2.j.d.f.a0
    public void g(N n) {
        this.a.remove(n);
    }

    @Override // a2.j.d.f.a0
    public V h(N n, V v) {
        return this.a.put(n, v);
    }
}
