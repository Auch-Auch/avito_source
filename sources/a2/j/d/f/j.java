package a2.j.d.f;

import com.google.common.base.Function;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.ValueGraph;
public final class j implements Function<EndpointPair<N>, V> {
    public final /* synthetic */ ValueGraph a;

    public j(ValueGraph valueGraph) {
        this.a = valueGraph;
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        EndpointPair endpointPair = (EndpointPair) obj;
        return this.a.edgeValueOrDefault(endpointPair.nodeU(), endpointPair.nodeV(), null);
    }
}
