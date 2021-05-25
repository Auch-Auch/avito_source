package com.google.common.graph;

import a2.j.d.f.k;
import com.google.common.annotations.Beta;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
public interface Graph<N> extends k<N> {
    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    Set<N> adjacentNodes(N n);

    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    boolean allowsSelfLoops();

    @Override // a2.j.d.f.k
    int degree(N n);

    @Override // a2.j.d.f.k
    Set<EndpointPair<N>> edges();

    boolean equals(@NullableDecl Object obj);

    @Override // a2.j.d.f.k
    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    @Override // a2.j.d.f.k
    boolean hasEdgeConnecting(N n, N n2);

    int hashCode();

    @Override // a2.j.d.f.k
    int inDegree(N n);

    Set<EndpointPair<N>> incidentEdges(N n);

    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    boolean isDirected();

    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    ElementOrder<N> nodeOrder();

    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    Set<N> nodes();

    @Override // a2.j.d.f.k
    int outDegree(N n);

    @Override // a2.j.d.f.k, com.google.common.graph.PredecessorsFunction
    /* renamed from: predecessors */
    Set<N> mo139predecessors(N n);

    @Override // a2.j.d.f.k, com.google.common.graph.SuccessorsFunction
    /* renamed from: successors */
    Set<N> mo140successors(N n);
}
