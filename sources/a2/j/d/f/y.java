package a2.j.d.f;

import com.google.common.graph.AbstractNetwork;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.Graphs;
import java.util.Set;
public abstract class y<N, E> extends AbstractNetwork<N, E> {
    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> adjacentEdges(E e) {
        return ((Graphs.c) this).a.adjacentEdges(e);
    }

    @Override // com.google.common.graph.Network
    public Set<N> adjacentNodes(N n) {
        return ((Graphs.c) this).a.adjacentNodes(n);
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return ((Graphs.c) this).a.allowsParallelEdges();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return ((Graphs.c) this).a.allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int degree(N n) {
        return ((Graphs.c) this).a.degree(n);
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<E> edgeOrder() {
        return ((Graphs.c) this).a.edgeOrder();
    }

    @Override // com.google.common.graph.Network
    public Set<E> edges() {
        return ((Graphs.c) this).a.edges();
    }

    @Override // com.google.common.graph.Network
    public Set<E> incidentEdges(N n) {
        return ((Graphs.c) this).a.incidentEdges(n);
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return ((Graphs.c) this).a.isDirected();
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<N> nodeOrder() {
        return ((Graphs.c) this).a.nodeOrder();
    }

    @Override // com.google.common.graph.Network
    public Set<N> nodes() {
        return ((Graphs.c) this).a.nodes();
    }
}
