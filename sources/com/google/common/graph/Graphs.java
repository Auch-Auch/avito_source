package com.google.common.graph;

import a2.j.d.f.k;
import a2.j.d.f.x;
import a2.j.d.f.y;
import a2.j.d.f.z;
import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
public final class Graphs {

    public enum a {
        PENDING,
        COMPLETE
    }

    @CanIgnoreReturnValue
    public static int a(int i) {
        Preconditions.checkArgument(i >= 0, "Not true that %s is non-negative.", i);
        return i;
    }

    @CanIgnoreReturnValue
    public static long b(long j) {
        Preconditions.checkArgument(j >= 0, "Not true that %s is non-negative.", j);
        return j;
    }

    @CanIgnoreReturnValue
    public static int c(int i) {
        Preconditions.checkArgument(i > 0, "Not true that %s is positive.", i);
        return i;
    }

    public static <N> MutableGraph<N> copyOf(Graph<N> graph) {
        MutableGraph mutableGraph = (MutableGraph<N1>) GraphBuilder.from(graph).expectedNodeCount(graph.nodes().size()).build();
        for (N n : graph.nodes()) {
            mutableGraph.addNode(n);
        }
        for (EndpointPair<N> endpointPair : graph.edges()) {
            mutableGraph.putEdge(endpointPair.nodeU(), endpointPair.nodeV());
        }
        return mutableGraph;
    }

    public static <N> boolean d(Graph<N> graph, Map<Object, a> map, N n, @NullableDecl N n2) {
        a aVar = a.COMPLETE;
        a aVar2 = map.get(n);
        if (aVar2 == aVar) {
            return false;
        }
        a aVar3 = a.PENDING;
        if (aVar2 == aVar3) {
            return true;
        }
        map.put(n, aVar3);
        for (N n3 : graph.mo140successors((Graph<N>) n)) {
            if ((graph.isDirected() || !Objects.equal(n2, n3)) && d(graph, map, n3, n)) {
                return true;
            }
        }
        map.put(n, aVar);
        return false;
    }

    public static <N> EndpointPair<N> e(EndpointPair<N> endpointPair) {
        return endpointPair.isOrdered() ? EndpointPair.ordered(endpointPair.target(), endpointPair.source()) : endpointPair;
    }

    public static <N> boolean hasCycle(Graph<N> graph) {
        int size = graph.edges().size();
        if (size == 0) {
            return false;
        }
        if (!graph.isDirected() && size >= graph.nodes().size()) {
            return true;
        }
        HashMap newHashMapWithExpectedSize = Maps.newHashMapWithExpectedSize(graph.nodes().size());
        for (N n : graph.nodes()) {
            if (d(graph, newHashMapWithExpectedSize, n, null)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: com.google.common.graph.MutableGraph */
    /* JADX WARN: Multi-variable type inference failed */
    public static <N> MutableGraph<N> inducedSubgraph(Graph<N> graph, Iterable<? extends N> iterable) {
        MutableGraph mutableGraph = iterable instanceof Collection ? (MutableGraph<N1>) GraphBuilder.from(graph).expectedNodeCount(((Collection) iterable).size()).build() : (MutableGraph<N>) GraphBuilder.from(graph).build();
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            mutableGraph.addNode(it.next());
        }
        for (N n : mutableGraph.nodes()) {
            for (N n2 : graph.mo140successors((Graph<N>) n)) {
                if (mutableGraph.nodes().contains(n2)) {
                    mutableGraph.putEdge(n, n2);
                }
            }
        }
        return (MutableGraph<N>) mutableGraph;
    }

    public static <N> Set<N> reachableNodes(Graph<N> graph, N n) {
        Preconditions.checkArgument(graph.nodes().contains(n), "Node %s is not an element of this graph.", n);
        return ImmutableSet.copyOf(Traverser.forGraph(graph).breadthFirst((Traverser) n));
    }

    public static <N> Graph<N> transitiveClosure(Graph<N> graph) {
        MutableGraph<N1> build = GraphBuilder.from(graph).allowsSelfLoops(true).build();
        if (graph.isDirected()) {
            for (N n : graph.nodes()) {
                for (N1 n1 : reachableNodes(graph, n)) {
                    build.putEdge(n, n1);
                }
            }
        } else {
            HashSet hashSet = new HashSet();
            for (N n2 : graph.nodes()) {
                if (!hashSet.contains(n2)) {
                    Set<N1> reachableNodes = reachableNodes(graph, n2);
                    hashSet.addAll(reachableNodes);
                    int i = 1;
                    for (N1 n12 : reachableNodes) {
                        int i2 = i + 1;
                        for (N1 n13 : Iterables.limit(reachableNodes, i)) {
                            build.putEdge(n12, n13);
                        }
                        i = i2;
                    }
                }
            }
        }
        return build;
    }

    public static <N> Graph<N> transpose(Graph<N> graph) {
        if (!graph.isDirected()) {
            return graph;
        }
        if (graph instanceof b) {
            return ((b) graph).a;
        }
        return new b(graph);
    }

    public static class b<N> extends x<N> {
        public final Graph<N> a;

        public b(Graph<N> graph) {
            this.a = graph;
        }

        @Override // a2.j.d.f.x
        public k delegate() {
            return this.a;
        }

        @Override // a2.j.d.f.x, com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
        public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
            return this.a.hasEdgeConnecting(Graphs.e(endpointPair));
        }

        @Override // a2.j.d.f.x, com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
        public int inDegree(N n) {
            return this.a.outDegree(n);
        }

        @Override // a2.j.d.f.x, com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
        public int outDegree(N n) {
            return this.a.inDegree(n);
        }

        @Override // a2.j.d.f.x, a2.j.d.f.k, com.google.common.graph.PredecessorsFunction
        /* renamed from: predecessors */
        public Iterable mo139predecessors(Object obj) {
            return this.a.mo140successors((Graph<N>) obj);
        }

        @Override // a2.j.d.f.x, a2.j.d.f.k, com.google.common.graph.SuccessorsFunction
        /* renamed from: successors */
        public Iterable mo140successors(Object obj) {
            return this.a.mo139predecessors((Graph<N>) obj);
        }

        @Override // a2.j.d.f.x, com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
        public boolean hasEdgeConnecting(N n, N n2) {
            return this.a.hasEdgeConnecting(n2, n);
        }

        @Override // a2.j.d.f.x, a2.j.d.f.k, com.google.common.graph.PredecessorsFunction
        /* renamed from: predecessors  reason: collision with other method in class */
        public Set<N> mo139predecessors(N n) {
            return this.a.mo140successors((Graph<N>) n);
        }

        @Override // a2.j.d.f.x, a2.j.d.f.k, com.google.common.graph.SuccessorsFunction
        /* renamed from: successors  reason: collision with other method in class */
        public Set<N> mo140successors(N n) {
            return this.a.mo139predecessors((Graph<N>) n);
        }
    }

    public static class c<N, E> extends y<N, E> {
        public final Network<N, E> a;

        public c(Network<N, E> network) {
            this.a = network;
        }

        @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
            return this.a.edgeConnectingOrNull(Graphs.e(endpointPair));
        }

        @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
            return this.a.edgesConnecting(Graphs.e(endpointPair));
        }

        @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
            return this.a.hasEdgeConnecting(Graphs.e(endpointPair));
        }

        @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int inDegree(N n) {
            return this.a.outDegree(n);
        }

        @Override // com.google.common.graph.Network
        public Set<E> inEdges(N n) {
            return this.a.outEdges(n);
        }

        @Override // com.google.common.graph.Network
        public EndpointPair<N> incidentNodes(E e) {
            EndpointPair<N> incidentNodes = this.a.incidentNodes(e);
            return EndpointPair.a(this.a, incidentNodes.nodeV(), incidentNodes.nodeU());
        }

        @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int outDegree(N n) {
            return this.a.inDegree(n);
        }

        @Override // com.google.common.graph.Network
        public Set<E> outEdges(N n) {
            return this.a.inEdges(n);
        }

        @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
        /* renamed from: predecessors */
        public Iterable mo139predecessors(Object obj) {
            return this.a.mo140successors((Network<N, E>) obj);
        }

        @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
        /* renamed from: successors */
        public Iterable mo140successors(Object obj) {
            return this.a.mo139predecessors((Network<N, E>) obj);
        }

        @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public E edgeConnectingOrNull(N n, N n2) {
            return this.a.edgeConnectingOrNull(n2, n);
        }

        @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set<E> edgesConnecting(N n, N n2) {
            return this.a.edgesConnecting(n2, n);
        }

        @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(N n, N n2) {
            return this.a.hasEdgeConnecting(n2, n);
        }

        @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
        /* renamed from: predecessors  reason: collision with other method in class */
        public Set<N> mo139predecessors(N n) {
            return this.a.mo140successors((Network<N, E>) n);
        }

        @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
        /* renamed from: successors  reason: collision with other method in class */
        public Set<N> mo140successors(N n) {
            return this.a.mo139predecessors((Network<N, E>) n);
        }
    }

    public static class d<N, V> extends z<N, V> {
        public final ValueGraph<N, V> a;

        public d(ValueGraph<N, V> valueGraph) {
            this.a = valueGraph;
        }

        @Override // com.google.common.graph.ValueGraph
        @NullableDecl
        public V edgeValueOrDefault(EndpointPair<N> endpointPair, @NullableDecl V v) {
            return this.a.edgeValueOrDefault(Graphs.e(endpointPair), v);
        }

        @Override // com.google.common.graph.AbstractValueGraph, a2.j.d.f.a, a2.j.d.f.k
        public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
            return this.a.hasEdgeConnecting(Graphs.e(endpointPair));
        }

        @Override // com.google.common.graph.AbstractValueGraph, a2.j.d.f.a, a2.j.d.f.k
        public int inDegree(N n) {
            return this.a.outDegree(n);
        }

        @Override // com.google.common.graph.AbstractValueGraph, a2.j.d.f.a, a2.j.d.f.k
        public int outDegree(N n) {
            return this.a.inDegree(n);
        }

        @Override // a2.j.d.f.k, com.google.common.graph.PredecessorsFunction
        /* renamed from: predecessors */
        public Iterable mo139predecessors(Object obj) {
            return this.a.mo140successors((ValueGraph<N, V>) obj);
        }

        @Override // a2.j.d.f.k, com.google.common.graph.SuccessorsFunction
        /* renamed from: successors */
        public Iterable mo140successors(Object obj) {
            return this.a.mo139predecessors((ValueGraph<N, V>) obj);
        }

        @Override // com.google.common.graph.ValueGraph
        @NullableDecl
        public V edgeValueOrDefault(N n, N n2, @NullableDecl V v) {
            return this.a.edgeValueOrDefault(n2, n, v);
        }

        @Override // com.google.common.graph.AbstractValueGraph, a2.j.d.f.a, a2.j.d.f.k
        public boolean hasEdgeConnecting(N n, N n2) {
            return this.a.hasEdgeConnecting(n2, n);
        }

        @Override // a2.j.d.f.k, com.google.common.graph.PredecessorsFunction
        /* renamed from: predecessors  reason: collision with other method in class */
        public Set<N> mo139predecessors(N n) {
            return this.a.mo140successors((ValueGraph<N, V>) n);
        }

        @Override // a2.j.d.f.k, com.google.common.graph.SuccessorsFunction
        /* renamed from: successors  reason: collision with other method in class */
        public Set<N> mo140successors(N n) {
            return this.a.mo139predecessors((ValueGraph<N, V>) n);
        }
    }

    public static <N, V> MutableValueGraph<N, V> copyOf(ValueGraph<N, V> valueGraph) {
        MutableValueGraph mutableValueGraph = (MutableValueGraph<N1, V1>) ValueGraphBuilder.from(valueGraph).expectedNodeCount(valueGraph.nodes().size()).build();
        for (N n : valueGraph.nodes()) {
            mutableValueGraph.addNode(n);
        }
        for (EndpointPair<N> endpointPair : valueGraph.edges()) {
            mutableValueGraph.putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), valueGraph.edgeValueOrDefault(endpointPair.nodeU(), endpointPair.nodeV(), null));
        }
        return mutableValueGraph;
    }

    public static boolean hasCycle(Network<?, ?> network) {
        if (network.isDirected() || !network.allowsParallelEdges() || network.edges().size() <= network.asGraph().edges().size()) {
            return hasCycle(network.asGraph());
        }
        return true;
    }

    public static <N, V> ValueGraph<N, V> transpose(ValueGraph<N, V> valueGraph) {
        if (!valueGraph.isDirected()) {
            return valueGraph;
        }
        if (valueGraph instanceof d) {
            return ((d) valueGraph).a;
        }
        return new d(valueGraph);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: com.google.common.graph.MutableValueGraph */
    /* JADX WARN: Multi-variable type inference failed */
    public static <N, V> MutableValueGraph<N, V> inducedSubgraph(ValueGraph<N, V> valueGraph, Iterable<? extends N> iterable) {
        MutableValueGraph mutableValueGraph = iterable instanceof Collection ? (MutableValueGraph<N1, V1>) ValueGraphBuilder.from(valueGraph).expectedNodeCount(((Collection) iterable).size()).build() : (MutableValueGraph<N, V>) ValueGraphBuilder.from(valueGraph).build();
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            mutableValueGraph.addNode(it.next());
        }
        for (N n : mutableValueGraph.nodes()) {
            for (N n2 : valueGraph.mo140successors((ValueGraph<N, V>) n)) {
                if (mutableValueGraph.nodes().contains(n2)) {
                    mutableValueGraph.putEdgeValue(n, n2, valueGraph.edgeValueOrDefault(n, n2, null));
                }
            }
        }
        return (MutableValueGraph<N, V>) mutableValueGraph;
    }

    public static <N, E> Network<N, E> transpose(Network<N, E> network) {
        if (!network.isDirected()) {
            return network;
        }
        if (network instanceof c) {
            return ((c) network).a;
        }
        return new c(network);
    }

    public static <N, E> MutableNetwork<N, E> copyOf(Network<N, E> network) {
        MutableNetwork mutableNetwork = (MutableNetwork<N1, E1>) NetworkBuilder.from(network).expectedNodeCount(network.nodes().size()).expectedEdgeCount(network.edges().size()).build();
        for (N n : network.nodes()) {
            mutableNetwork.addNode(n);
        }
        for (E e : network.edges()) {
            EndpointPair<N> incidentNodes = network.incidentNodes(e);
            mutableNetwork.addEdge(incidentNodes.nodeU(), incidentNodes.nodeV(), e);
        }
        return mutableNetwork;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: com.google.common.graph.MutableNetwork */
    /* JADX WARN: Multi-variable type inference failed */
    public static <N, E> MutableNetwork<N, E> inducedSubgraph(Network<N, E> network, Iterable<? extends N> iterable) {
        MutableNetwork mutableNetwork = iterable instanceof Collection ? (MutableNetwork<N1, E1>) NetworkBuilder.from(network).expectedNodeCount(((Collection) iterable).size()).build() : (MutableNetwork<N, E>) NetworkBuilder.from(network).build();
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            mutableNetwork.addNode(it.next());
        }
        for (E e : mutableNetwork.nodes()) {
            for (E e2 : network.outEdges(e)) {
                N adjacentNode = network.incidentNodes(e2).adjacentNode(e);
                if (mutableNetwork.nodes().contains(adjacentNode)) {
                    mutableNetwork.addEdge(e, adjacentNode, e2);
                }
            }
        }
        return (MutableNetwork<N, E>) mutableNetwork;
    }
}
