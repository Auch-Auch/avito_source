package a2.j.d.f;

import com.google.common.graph.EndpointPair;
import com.google.common.graph.MutableGraph;
import com.google.common.graph.MutableValueGraph;
public final class l<N> extends x<N> implements MutableGraph<N> {
    public final MutableValueGraph<N, b0> a;

    public l(f<? super N> fVar) {
        this.a = new n(fVar);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean addNode(N n) {
        return this.a.addNode(n);
    }

    @Override // a2.j.d.f.x
    public k<N> delegate() {
        return this.a;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(N n, N n2) {
        return this.a.putEdgeValue(n, n2, b0.EDGE_EXISTS) == null;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(N n, N n2) {
        return this.a.removeEdge(n, n2) != null;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeNode(N n) {
        return this.a.removeNode(n);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return putEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return this.a.removeEdge(endpointPair.nodeU(), endpointPair.nodeV()) != null;
    }
}
