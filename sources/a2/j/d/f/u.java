package a2.j.d.f;

import com.google.common.collect.BiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
public final class u<N, E> extends e<N, E> {
    public u(Map<E, N> map, Map<E, N> map2, int i) {
        super(map, map2, i);
    }

    @Override // a2.j.d.f.m0
    public Set<N> b() {
        return Collections.unmodifiableSet(((BiMap) this.b).values());
    }

    @Override // a2.j.d.f.m0
    public Set<N> c() {
        return Collections.unmodifiableSet(((BiMap) this.a).values());
    }

    @Override // a2.j.d.f.m0
    public Set<E> l(N n) {
        return new v(((BiMap) this.b).mo35inverse(), n);
    }
}
