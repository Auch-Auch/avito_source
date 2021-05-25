package a2.j.d.f;

import com.google.common.graph.AbstractValueGraph;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.Graphs;
import java.util.Set;
public abstract class z<N, V> extends AbstractValueGraph<N, V> {
    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    public Set<N> adjacentNodes(N n) {
        return ((Graphs.d) this).a.adjacentNodes(n);
    }

    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    public boolean allowsSelfLoops() {
        return ((Graphs.d) this).a.allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractValueGraph, a2.j.d.f.a, a2.j.d.f.k
    public int degree(N n) {
        return ((Graphs.d) this).a.degree(n);
    }

    @Override // a2.j.d.f.a
    public long edgeCount() {
        return (long) ((Graphs.d) this).a.edges().size();
    }

    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    public boolean isDirected() {
        return ((Graphs.d) this).a.isDirected();
    }

    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    public ElementOrder<N> nodeOrder() {
        return ((Graphs.d) this).a.nodeOrder();
    }

    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    public Set<N> nodes() {
        return ((Graphs.d) this).a.nodes();
    }
}
