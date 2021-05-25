package com.google.common.graph;

import a2.j.d.f.g;
import a2.j.d.f.h;
import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
public abstract class AbstractNetwork<N, E> implements Network<N, E> {

    public class a extends AbstractGraph<N> {

        /* renamed from: com.google.common.graph.AbstractNetwork$a$a  reason: collision with other inner class name */
        public class C0290a extends AbstractSet<EndpointPair<N>> {

            /* renamed from: com.google.common.graph.AbstractNetwork$a$a$a  reason: collision with other inner class name */
            public class C0291a implements Function<E, EndpointPair<N>> {
                public C0291a() {
                }

                @Override // com.google.common.base.Function
                public Object apply(Object obj) {
                    return AbstractNetwork.this.incidentNodes(obj);
                }
            }

            public C0290a() {
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.google.common.graph.AbstractNetwork$a */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair<?> endpointPair = (EndpointPair) obj;
                if (!a.this.isOrderingCompatible(endpointPair) || !a.this.nodes().contains(endpointPair.nodeU()) || !a.this.mo140successors((a) endpointPair.nodeU()).contains(endpointPair.nodeV())) {
                    return false;
                }
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<EndpointPair<N>> iterator() {
                return Iterators.transform(AbstractNetwork.this.edges().iterator(), new C0291a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractNetwork.this.edges().size();
            }
        }

        public a() {
        }

        @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
        public Set<N> adjacentNodes(N n) {
            return AbstractNetwork.this.adjacentNodes(n);
        }

        @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
        public boolean allowsSelfLoops() {
            return AbstractNetwork.this.allowsSelfLoops();
        }

        @Override // com.google.common.graph.AbstractGraph, a2.j.d.f.a, a2.j.d.f.k
        public Set<EndpointPair<N>> edges() {
            if (AbstractNetwork.this.allowsParallelEdges()) {
                return super.edges();
            }
            return new C0290a();
        }

        @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
        public boolean isDirected() {
            return AbstractNetwork.this.isDirected();
        }

        @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
        public ElementOrder<N> nodeOrder() {
            return AbstractNetwork.this.nodeOrder();
        }

        @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
        public Set<N> nodes() {
            return AbstractNetwork.this.nodes();
        }

        @Override // a2.j.d.f.k, com.google.common.graph.PredecessorsFunction
        /* renamed from: predecessors */
        public Iterable mo139predecessors(Object obj) {
            return AbstractNetwork.this.mo139predecessors((AbstractNetwork) obj);
        }

        @Override // a2.j.d.f.k, com.google.common.graph.SuccessorsFunction
        /* renamed from: successors */
        public Iterable mo140successors(Object obj) {
            return AbstractNetwork.this.mo140successors((AbstractNetwork) obj);
        }

        @Override // a2.j.d.f.k, com.google.common.graph.PredecessorsFunction
        /* renamed from: predecessors  reason: collision with other method in class */
        public Set<N> mo139predecessors(N n) {
            return AbstractNetwork.this.mo139predecessors((AbstractNetwork) n);
        }

        @Override // a2.j.d.f.k, com.google.common.graph.SuccessorsFunction
        /* renamed from: successors  reason: collision with other method in class */
        public Set<N> mo140successors(N n) {
            return AbstractNetwork.this.mo140successors((AbstractNetwork) n);
        }
    }

    @Override // com.google.common.graph.Network
    public Set<E> adjacentEdges(E e) {
        EndpointPair<N> incidentNodes = incidentNodes(e);
        return Sets.difference(Sets.union(incidentEdges(incidentNodes.nodeU()), incidentEdges(incidentNodes.nodeV())), ImmutableSet.of((Object) e));
    }

    @Override // com.google.common.graph.Network
    public Graph<N> asGraph() {
        return new a();
    }

    @Override // com.google.common.graph.Network
    public int degree(N n) {
        if (isDirected()) {
            return IntMath.saturatedAdd(inEdges(n).size(), outEdges(n).size());
        }
        return IntMath.saturatedAdd(incidentEdges(n).size(), edgesConnecting(n, n).size());
    }

    @Override // com.google.common.graph.Network
    @NullableDecl
    public E edgeConnectingOrNull(N n, N n2) {
        Set<E> edgesConnecting = edgesConnecting(n, n2);
        int size = edgesConnecting.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return edgesConnecting.iterator().next();
        }
        throw new IllegalArgumentException(String.format("Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.", n, n2));
    }

    @Override // com.google.common.graph.Network
    public Set<E> edgesConnecting(N n, N n2) {
        Set<E> outEdges = outEdges(n);
        Set<E> inEdges = inEdges(n2);
        if (outEdges.size() <= inEdges.size()) {
            return Collections.unmodifiableSet(Sets.filter(outEdges, new g(this, n, n2)));
        }
        return Collections.unmodifiableSet(Sets.filter(inEdges, new g(this, n2, n)));
    }

    @Override // com.google.common.graph.Network
    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Network)) {
            return false;
        }
        Network network = (Network) obj;
        if (isDirected() == network.isDirected() && nodes().equals(network.nodes())) {
            if (Maps.asMap(edges(), new h(this)).equals(Maps.asMap(network.edges(), new h(network)))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.graph.Network
    public boolean hasEdgeConnecting(N n, N n2) {
        return !edgesConnecting(n, n2).isEmpty();
    }

    @Override // com.google.common.graph.Network
    public final int hashCode() {
        return Maps.asMap(edges(), new h(this)).hashCode();
    }

    @Override // com.google.common.graph.Network
    public int inDegree(N n) {
        return isDirected() ? inEdges(n).size() : degree(n);
    }

    public final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        return endpointPair.isOrdered() || !isDirected();
    }

    @Override // com.google.common.graph.Network
    public int outDegree(N n) {
        return isDirected() ? outEdges(n).size() : degree(n);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("isDirected: ");
        L.append(isDirected());
        L.append(", allowsParallelEdges: ");
        L.append(allowsParallelEdges());
        L.append(", allowsSelfLoops: ");
        L.append(allowsSelfLoops());
        L.append(", nodes: ");
        L.append(nodes());
        L.append(", edges: ");
        L.append(Maps.asMap(edges(), new h(this)));
        return L.toString();
    }

    public final void validateEndpoints(EndpointPair<?> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(isOrderingCompatible(endpointPair), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }

    @Override // com.google.common.graph.Network
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (!isOrderingCompatible(endpointPair)) {
            return false;
        }
        return !edgesConnecting(endpointPair.nodeU(), endpointPair.nodeV()).isEmpty();
    }

    @Override // com.google.common.graph.Network
    @NullableDecl
    public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return edgeConnectingOrNull(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.Network
    public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return edgesConnecting(endpointPair.nodeU(), endpointPair.nodeV());
    }
}
