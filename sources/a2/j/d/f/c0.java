package a2.j.d.f;

import com.google.common.base.Function;
import com.google.common.graph.Network;
public final class c0 implements Function<E, N> {
    public final /* synthetic */ Network a;

    public c0(Network network) {
        this.a = network;
    }

    @Override // com.google.common.base.Function
    public N apply(E e) {
        return (N) this.a.incidentNodes(e).source();
    }
}
