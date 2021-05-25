package a2.j.d.f;

import com.google.common.collect.BiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
public final class p0<N, E> extends i<N, E> {
    public p0(Map<E, N> map) {
        super(map);
    }

    @Override // a2.j.d.f.m0
    public Set<N> a() {
        return Collections.unmodifiableSet(((BiMap) this.a).values());
    }

    @Override // a2.j.d.f.m0
    public Set<E> l(N n) {
        return new v(((BiMap) this.a).mo35inverse(), n);
    }
}
