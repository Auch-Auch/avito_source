package a2.j.d.f;

import com.google.common.base.Function;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.Network;
public final class h implements Function<E, EndpointPair<N>> {
    public final /* synthetic */ Network a;

    public h(Network network) {
        this.a = network;
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        return this.a.incidentNodes(obj);
    }
}
