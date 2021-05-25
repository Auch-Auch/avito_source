package a2.j.d.f;

import com.google.common.base.Function;
import com.google.common.graph.Network;
public final class e0 implements Function<E, N> {
    public final /* synthetic */ Network a;
    public final /* synthetic */ Object b;

    public e0(Network network, Object obj) {
        this.a = network;
        this.b = obj;
    }

    @Override // com.google.common.base.Function
    public N apply(E e) {
        return (N) this.a.incidentNodes(e).adjacentNode(this.b);
    }
}
