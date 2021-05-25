package a2.j.d.f;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.graph.AbstractNetwork;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.NetworkBuilder;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class o<N, E> extends AbstractNetwork<N, E> {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final ElementOrder<N> d;
    public final ElementOrder<E> e;
    public final i0<E, N> edgeToReferenceNode;
    public final i0<N, m0<N, E>> nodeConnections;

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: com.google.common.graph.ElementOrder<? super E>, java.lang.Object, com.google.common.graph.ElementOrder<E> */
    public o(NetworkBuilder<? super N, ? super E> networkBuilder, Map<N, m0<N, E>> map, Map<E, N> map2) {
        this.a = networkBuilder.a;
        this.b = networkBuilder.e;
        this.c = networkBuilder.b;
        ElementOrder<N> elementOrder = networkBuilder.c;
        Objects.requireNonNull(elementOrder);
        this.d = elementOrder;
        ElementOrder elementOrder2 = (ElementOrder<? super E>) networkBuilder.f;
        Objects.requireNonNull(elementOrder2);
        this.e = elementOrder2;
        this.nodeConnections = map instanceof TreeMap ? new j0<>(map) : new i0<>(map);
        this.edgeToReferenceNode = new i0<>(map2);
    }

    @Override // com.google.common.graph.Network
    public Set<N> adjacentNodes(N n) {
        return checkedConnections(n).a();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return this.b;
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return this.c;
    }

    public final m0<N, E> checkedConnections(N n) {
        m0<N, E> c2 = this.nodeConnections.c(n);
        if (c2 != null) {
            return c2;
        }
        Preconditions.checkNotNull(n);
        throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", n));
    }

    public final N checkedReferenceNode(E e2) {
        N c2 = this.edgeToReferenceNode.c(e2);
        if (c2 != null) {
            return c2;
        }
        Preconditions.checkNotNull(e2);
        throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", e2));
    }

    public final boolean containsEdge(@NullableDecl E e2) {
        return this.edgeToReferenceNode.b(e2);
    }

    public final boolean containsNode(@NullableDecl N n) {
        return this.nodeConnections.b(n);
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<E> edgeOrder() {
        return this.e;
    }

    @Override // com.google.common.graph.Network
    public Set<E> edges() {
        i0<E, N> i0Var = this.edgeToReferenceNode;
        Objects.requireNonNull(i0Var);
        return new h0(i0Var);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(N n, N n2) {
        m0<N, E> checkedConnections = checkedConnections(n);
        if (!this.c && n == n2) {
            return ImmutableSet.of();
        }
        Preconditions.checkArgument(containsNode(n2), "Node %s is not an element of this graph.", n2);
        return checkedConnections.l(n2);
    }

    @Override // com.google.common.graph.Network
    public Set<E> inEdges(N n) {
        return checkedConnections(n).e();
    }

    @Override // com.google.common.graph.Network
    public Set<E> incidentEdges(N n) {
        return checkedConnections(n).k();
    }

    @Override // com.google.common.graph.Network
    public EndpointPair<N> incidentNodes(E e2) {
        N checkedReferenceNode = checkedReferenceNode(e2);
        return EndpointPair.a(this, checkedReferenceNode, this.nodeConnections.c(checkedReferenceNode).d(e2));
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return this.a;
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<N> nodeOrder() {
        return this.d;
    }

    @Override // com.google.common.graph.Network
    public Set<N> nodes() {
        i0<N, m0<N, E>> i0Var = this.nodeConnections;
        Objects.requireNonNull(i0Var);
        return new h0(i0Var);
    }

    @Override // com.google.common.graph.Network
    public Set<E> outEdges(N n) {
        return checkedConnections(n).g();
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    /* renamed from: predecessors */
    public Set<N> mo139predecessors(N n) {
        return checkedConnections(n).c();
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    /* renamed from: successors */
    public Set<N> mo140successors(N n) {
        return checkedConnections(n).b();
    }
}
