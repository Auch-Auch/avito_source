package com.google.common.graph;

import a2.j.d.f.k;
import com.google.common.annotations.Beta;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
public interface ValueGraph<N, V> extends k<N> {
    Set<N> adjacentNodes(N n);

    boolean allowsSelfLoops();

    Graph<N> asGraph();

    @Override // a2.j.d.f.k
    int degree(N n);

    @NullableDecl
    V edgeValueOrDefault(EndpointPair<N> endpointPair, @NullableDecl V v);

    @NullableDecl
    V edgeValueOrDefault(N n, N n2, @NullableDecl V v);

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

    boolean isDirected();

    ElementOrder<N> nodeOrder();

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
