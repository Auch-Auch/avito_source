package com.google.common.graph;

import a2.j.d.f.f;
import a2.j.d.f.n;
import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.ImmutableValueGraph;
@Beta
public final class ValueGraphBuilder<N, V> extends f<N> {
    public ValueGraphBuilder(boolean z) {
        super(z);
    }

    public static ValueGraphBuilder<Object, Object> directed() {
        return new ValueGraphBuilder<>(true);
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: com.google.common.graph.ValueGraphBuilder<N1 extends N, V>, com.google.common.graph.ValueGraphBuilder<N, V> */
    public static <N, V> ValueGraphBuilder<N, V> from(ValueGraph<N, V> valueGraph) {
        return (ValueGraphBuilder<N1, V>) new ValueGraphBuilder(valueGraph.isDirected()).allowsSelfLoops(valueGraph.allowsSelfLoops()).nodeOrder(valueGraph.nodeOrder());
    }

    public static ValueGraphBuilder<Object, Object> undirected() {
        return new ValueGraphBuilder<>(false);
    }

    public ValueGraphBuilder<N, V> allowsSelfLoops(boolean z) {
        this.b = z;
        return this;
    }

    public <N1 extends N, V1 extends V> MutableValueGraph<N1, V1> build() {
        return new n(this);
    }

    public ValueGraphBuilder<N, V> expectedNodeCount(int i) {
        Graphs.a(i);
        this.d = Optional.of(Integer.valueOf(i));
        return this;
    }

    public <N1 extends N, V1 extends V> ImmutableValueGraph.Builder<N1, V1> immutable() {
        return new ImmutableValueGraph.Builder<>(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.graph.ValueGraphBuilder<N, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public <N1 extends N> ValueGraphBuilder<N1, V> nodeOrder(ElementOrder<N1> elementOrder) {
        this.c = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return this;
    }
}
