package com.google.common.graph;

import a2.j.d.f.j;
import com.google.common.annotations.Beta;
import com.google.common.collect.Maps;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
public abstract class AbstractValueGraph<N, V> extends a2.j.d.f.a<N> implements ValueGraph<N, V> {

    public class a extends AbstractGraph<N> {
        public a() {
        }

        @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
        public Set<N> adjacentNodes(N n) {
            return AbstractValueGraph.this.adjacentNodes(n);
        }

        @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
        public boolean allowsSelfLoops() {
            return AbstractValueGraph.this.allowsSelfLoops();
        }

        @Override // com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
        public int degree(N n) {
            return AbstractValueGraph.this.degree(n);
        }

        @Override // com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
        public Set<EndpointPair<N>> edges() {
            return AbstractValueGraph.this.edges();
        }

        @Override // com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
        public int inDegree(N n) {
            return AbstractValueGraph.this.inDegree(n);
        }

        @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
        public boolean isDirected() {
            return AbstractValueGraph.this.isDirected();
        }

        @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
        public ElementOrder<N> nodeOrder() {
            return AbstractValueGraph.this.nodeOrder();
        }

        @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
        public Set<N> nodes() {
            return AbstractValueGraph.this.nodes();
        }

        @Override // com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
        public int outDegree(N n) {
            return AbstractValueGraph.this.outDegree(n);
        }

        @Override // a2.j.d.f.k, com.google.common.graph.PredecessorsFunction
        /* renamed from: predecessors */
        public Iterable mo139predecessors(Object obj) {
            return AbstractValueGraph.this.mo139predecessors((AbstractValueGraph) obj);
        }

        @Override // a2.j.d.f.k, com.google.common.graph.SuccessorsFunction
        /* renamed from: successors */
        public Iterable mo140successors(Object obj) {
            return AbstractValueGraph.this.mo140successors((AbstractValueGraph) obj);
        }

        @Override // a2.j.d.f.k, com.google.common.graph.PredecessorsFunction
        /* renamed from: predecessors  reason: collision with other method in class */
        public Set<N> mo139predecessors(N n) {
            return AbstractValueGraph.this.mo139predecessors((AbstractValueGraph) n);
        }

        @Override // a2.j.d.f.k, com.google.common.graph.SuccessorsFunction
        /* renamed from: successors  reason: collision with other method in class */
        public Set<N> mo140successors(N n) {
            return AbstractValueGraph.this.mo140successors((AbstractValueGraph) n);
        }
    }

    @Override // com.google.common.graph.ValueGraph
    public Graph<N> asGraph() {
        return new a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.a, a2.j.d.f.k
    public /* bridge */ /* synthetic */ int degree(Object obj) {
        return super.degree(obj);
    }

    @Override // a2.j.d.f.a, a2.j.d.f.k
    public /* bridge */ /* synthetic */ Set edges() {
        return super.edges();
    }

    @Override // com.google.common.graph.ValueGraph
    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueGraph)) {
            return false;
        }
        ValueGraph valueGraph = (ValueGraph) obj;
        if (isDirected() == valueGraph.isDirected() && nodes().equals(valueGraph.nodes())) {
            if (Maps.asMap(edges(), new j(this)).equals(Maps.asMap(valueGraph.edges(), new j(valueGraph)))) {
                return true;
            }
        }
        return false;
    }

    @Override // a2.j.d.f.a, a2.j.d.f.k
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return super.hasEdgeConnecting(endpointPair);
    }

    @Override // com.google.common.graph.ValueGraph
    public final int hashCode() {
        return Maps.asMap(edges(), new j(this)).hashCode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.a, a2.j.d.f.k
    public /* bridge */ /* synthetic */ int inDegree(Object obj) {
        return super.inDegree(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.a, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set incidentEdges(Object obj) {
        return super.incidentEdges(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.a, a2.j.d.f.k
    public /* bridge */ /* synthetic */ int outDegree(Object obj) {
        return super.outDegree(obj);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("isDirected: ");
        L.append(isDirected());
        L.append(", allowsSelfLoops: ");
        L.append(allowsSelfLoops());
        L.append(", nodes: ");
        L.append(nodes());
        L.append(", edges: ");
        L.append(Maps.asMap(edges(), new j(this)));
        return L.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.a, a2.j.d.f.k
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object obj, Object obj2) {
        return super.hasEdgeConnecting(obj, obj2);
    }
}
