package a2.j.d.f;

import com.google.common.graph.AbstractGraph;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import java.util.Set;
public abstract class x<N> extends AbstractGraph<N> {
    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    public Set<N> adjacentNodes(N n) {
        return delegate().adjacentNodes(n);
    }

    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
    public int degree(N n) {
        return delegate().degree(n);
    }

    public abstract k<N> delegate();

    @Override // a2.j.d.f.a
    public long edgeCount() {
        return (long) delegate().edges().size();
    }

    @Override // com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
    public boolean hasEdgeConnecting(N n, N n2) {
        return delegate().hasEdgeConnecting(n, n2);
    }

    @Override // com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
    public int inDegree(N n) {
        return delegate().inDegree(n);
    }

    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    public boolean isDirected() {
        return delegate().isDirected();
    }

    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    public ElementOrder<N> nodeOrder() {
        return delegate().nodeOrder();
    }

    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    public Set<N> nodes() {
        return delegate().nodes();
    }

    @Override // com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
    public int outDegree(N n) {
        return delegate().outDegree(n);
    }

    @Override // com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        return delegate().hasEdgeConnecting(endpointPair);
    }

    @Override // a2.j.d.f.k, com.google.common.graph.PredecessorsFunction
    /* renamed from: predecessors */
    public Set<N> mo139predecessors(N n) {
        return delegate().mo139predecessors((k<N>) n);
    }

    @Override // a2.j.d.f.k, com.google.common.graph.SuccessorsFunction
    /* renamed from: successors */
    public Set<N> mo140successors(N n) {
        return delegate().mo140successors((k<N>) n);
    }
}
