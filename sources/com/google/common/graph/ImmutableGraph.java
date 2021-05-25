package com.google.common.graph;

import a2.j.d.f.b0;
import a2.j.d.f.k;
import a2.j.d.f.n0;
import a2.j.d.f.p;
import a2.j.d.f.r;
import a2.j.d.f.x;
import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Set;
@Immutable(containerOf = {"N"})
@Beta
public class ImmutableGraph<N> extends x<N> {
    public final k<N> a;

    public static class Builder<N> {
        public final MutableGraph<N> a;

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: com.google.common.graph.MutableGraph<N1 extends N>, com.google.common.graph.MutableGraph<N> */
        public Builder(GraphBuilder<N> graphBuilder) {
            this.a = (MutableGraph<N1>) graphBuilder.build();
        }

        @CanIgnoreReturnValue
        public Builder<N> addNode(N n) {
            this.a.addNode(n);
            return this;
        }

        public ImmutableGraph<N> build() {
            return ImmutableGraph.copyOf(this.a);
        }

        @CanIgnoreReturnValue
        public Builder<N> putEdge(N n, N n2) {
            this.a.putEdge(n, n2);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<N> putEdge(EndpointPair<N> endpointPair) {
            this.a.putEdge(endpointPair);
            return this;
        }
    }

    public ImmutableGraph(k<N> kVar) {
        this.a = kVar;
    }

    public static <N> ImmutableGraph<N> copyOf(Graph<N> graph) {
        Object obj;
        if (graph instanceof ImmutableGraph) {
            return (ImmutableGraph) graph;
        }
        GraphBuilder from = GraphBuilder.from(graph);
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (N n : graph.nodes()) {
            Function constant = Functions.constant(b0.EDGE_EXISTS);
            if (graph.isDirected()) {
                obj = r.i(graph.mo139predecessors((Graph<N>) n), Maps.asMap(graph.mo140successors((Graph<N>) n), constant));
            } else {
                obj = new n0(ImmutableMap.copyOf(Maps.asMap(graph.adjacentNodes(n), constant)));
            }
            builder.put(n, obj);
        }
        return new ImmutableGraph<>(new p(from, builder.build(), (long) graph.edges().size()));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.x, a2.j.d.f.k, com.google.common.graph.ValueGraph
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    @Override // a2.j.d.f.x, a2.j.d.f.k, com.google.common.graph.ValueGraph
    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.x, com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
    public /* bridge */ /* synthetic */ int degree(Object obj) {
        return super.degree(obj);
    }

    @Override // a2.j.d.f.x
    public k<N> delegate() {
        return this.a;
    }

    @Override // a2.j.d.f.x, com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return super.hasEdgeConnecting(endpointPair);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.x, com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
    public /* bridge */ /* synthetic */ int inDegree(Object obj) {
        return super.inDegree(obj);
    }

    @Override // a2.j.d.f.x, a2.j.d.f.k, com.google.common.graph.ValueGraph
    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    @Override // a2.j.d.f.x, a2.j.d.f.k, com.google.common.graph.ValueGraph
    public /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    @Override // a2.j.d.f.x, a2.j.d.f.k, com.google.common.graph.ValueGraph
    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.x, com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
    public /* bridge */ /* synthetic */ int outDegree(Object obj) {
        return super.outDegree(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.x, a2.j.d.f.k, com.google.common.graph.PredecessorsFunction
    /* renamed from: predecessors */
    public /* bridge */ /* synthetic */ Set mo139predecessors(Object obj) {
        return super.mo139predecessors((ImmutableGraph<N>) obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.x, a2.j.d.f.k, com.google.common.graph.SuccessorsFunction
    /* renamed from: successors */
    public /* bridge */ /* synthetic */ Set mo140successors(Object obj) {
        return super.mo140successors((ImmutableGraph<N>) obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.x, com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object obj, Object obj2) {
        return super.hasEdgeConnecting(obj, obj2);
    }

    @Deprecated
    public static <N> ImmutableGraph<N> copyOf(ImmutableGraph<N> immutableGraph) {
        return (ImmutableGraph) Preconditions.checkNotNull(immutableGraph);
    }
}
