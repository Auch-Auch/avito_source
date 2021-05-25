package com.google.common.graph;

import a2.j.d.f.f;
import a2.j.d.f.m;
import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.ImmutableNetwork;
@Beta
public final class NetworkBuilder<N, E> extends f<N> {
    public boolean e = false;
    public ElementOrder<? super E> f = ElementOrder.insertion();
    public Optional<Integer> g = Optional.absent();

    public NetworkBuilder(boolean z) {
        super(z);
    }

    public static NetworkBuilder<Object, Object> directed() {
        return new NetworkBuilder<>(true);
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: com.google.common.graph.NetworkBuilder<N1 extends N, E1 extends E>, com.google.common.graph.NetworkBuilder<N, E> */
    public static <N, E> NetworkBuilder<N, E> from(Network<N, E> network) {
        return (NetworkBuilder<N1, E1>) new NetworkBuilder(network.isDirected()).allowsParallelEdges(network.allowsParallelEdges()).allowsSelfLoops(network.allowsSelfLoops()).nodeOrder(network.nodeOrder()).edgeOrder(network.edgeOrder());
    }

    public static NetworkBuilder<Object, Object> undirected() {
        return new NetworkBuilder<>(false);
    }

    public NetworkBuilder<N, E> allowsParallelEdges(boolean z) {
        this.e = z;
        return this;
    }

    public NetworkBuilder<N, E> allowsSelfLoops(boolean z) {
        this.b = z;
        return this;
    }

    public <N1 extends N, E1 extends E> MutableNetwork<N1, E1> build() {
        return new m(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.graph.NetworkBuilder<N, E> */
    /* JADX WARN: Multi-variable type inference failed */
    public <E1 extends E> NetworkBuilder<N, E1> edgeOrder(ElementOrder<E1> elementOrder) {
        this.f = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return this;
    }

    public NetworkBuilder<N, E> expectedEdgeCount(int i) {
        Graphs.a(i);
        this.g = Optional.of(Integer.valueOf(i));
        return this;
    }

    public NetworkBuilder<N, E> expectedNodeCount(int i) {
        Graphs.a(i);
        this.d = Optional.of(Integer.valueOf(i));
        return this;
    }

    public <N1 extends N, E1 extends E> ImmutableNetwork.Builder<N1, E1> immutable() {
        return new ImmutableNetwork.Builder<>(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.graph.NetworkBuilder<N, E> */
    /* JADX WARN: Multi-variable type inference failed */
    public <N1 extends N> NetworkBuilder<N1, E> nodeOrder(ElementOrder<N1> elementOrder) {
        this.c = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return this;
    }
}
