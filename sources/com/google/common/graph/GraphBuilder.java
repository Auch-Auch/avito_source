package com.google.common.graph;

import a2.j.d.f.f;
import a2.j.d.f.l;
import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.ImmutableGraph;
@Beta
public final class GraphBuilder<N> extends f<N> {
    public GraphBuilder(boolean z) {
        super(z);
    }

    public static GraphBuilder<Object> directed() {
        return new GraphBuilder<>(true);
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: com.google.common.graph.GraphBuilder<N1 extends N>, com.google.common.graph.GraphBuilder<N> */
    public static <N> GraphBuilder<N> from(Graph<N> graph) {
        return (GraphBuilder<N1>) new GraphBuilder(graph.isDirected()).allowsSelfLoops(graph.allowsSelfLoops()).nodeOrder(graph.nodeOrder());
    }

    public static GraphBuilder<Object> undirected() {
        return new GraphBuilder<>(false);
    }

    public GraphBuilder<N> allowsSelfLoops(boolean z) {
        this.b = z;
        return this;
    }

    public <N1 extends N> MutableGraph<N1> build() {
        return new l(this);
    }

    public GraphBuilder<N> expectedNodeCount(int i) {
        Graphs.a(i);
        this.d = Optional.of(Integer.valueOf(i));
        return this;
    }

    public <N1 extends N> ImmutableGraph.Builder<N1> immutable() {
        return new ImmutableGraph.Builder<>(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.graph.GraphBuilder<N> */
    /* JADX WARN: Multi-variable type inference failed */
    public <N1 extends N> GraphBuilder<N1> nodeOrder(ElementOrder<N1> elementOrder) {
        this.c = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return this;
    }
}
