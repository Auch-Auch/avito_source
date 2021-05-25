package a2.j.d.f;

import com.google.common.base.Preconditions;
import com.google.common.graph.AbstractValueGraph;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.Graphs;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class p<N, V> extends AbstractValueGraph<N, V> {
    public final boolean a;
    public final boolean b;
    public final ElementOrder<N> c;
    public long edgeCount;
    public final i0<N, a0<N, V>> nodeConnections;

    public p(f<? super N> fVar, Map<N, a0<N, V>> map, long j) {
        this.a = fVar.a;
        this.b = fVar.b;
        ElementOrder<N> elementOrder = fVar.c;
        Objects.requireNonNull(elementOrder);
        this.c = elementOrder;
        this.nodeConnections = map instanceof TreeMap ? new j0<>(map) : new i0<>(map);
        Graphs.b(j);
        this.edgeCount = j;
    }

    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    public Set<N> adjacentNodes(N n) {
        return checkedConnections(n).a();
    }

    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    public boolean allowsSelfLoops() {
        return this.b;
    }

    public final a0<N, V> checkedConnections(N n) {
        a0<N, V> c2 = this.nodeConnections.c(n);
        if (c2 != null) {
            return c2;
        }
        Preconditions.checkNotNull(n);
        throw new IllegalArgumentException("Node " + ((Object) n) + " is not an element of this graph.");
    }

    public final boolean containsNode(@NullableDecl N n) {
        return this.nodeConnections.b(n);
    }

    @Override // a2.j.d.f.a
    public long edgeCount() {
        return this.edgeCount;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: a2.j.d.f.p<N, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ValueGraph
    @NullableDecl
    public V edgeValueOrDefault(N n, N n2, @NullableDecl V v) {
        return (V) edgeValueOrDefault_internal(Preconditions.checkNotNull(n), Preconditions.checkNotNull(n2), v);
    }

    public final V edgeValueOrDefault_internal(N n, N n2, V v) {
        V v2;
        a0<N, V> c2 = this.nodeConnections.c(n);
        if (c2 == null) {
            v2 = null;
        } else {
            v2 = c2.e(n2);
        }
        return v2 == null ? v : v2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: a2.j.d.f.p<N, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractValueGraph, a2.j.d.f.a, a2.j.d.f.k
    public boolean hasEdgeConnecting(N n, N n2) {
        return hasEdgeConnecting_internal(Preconditions.checkNotNull(n), Preconditions.checkNotNull(n2));
    }

    public final boolean hasEdgeConnecting_internal(N n, N n2) {
        a0<N, V> c2 = this.nodeConnections.c(n);
        return c2 != null && c2.b().contains(n2);
    }

    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    public boolean isDirected() {
        return this.a;
    }

    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    public ElementOrder<N> nodeOrder() {
        return this.c;
    }

    @Override // a2.j.d.f.k, com.google.common.graph.ValueGraph
    public Set<N> nodes() {
        i0<N, a0<N, V>> i0Var = this.nodeConnections;
        Objects.requireNonNull(i0Var);
        return new h0(i0Var);
    }

    @Override // com.google.common.graph.ValueGraph
    @NullableDecl
    public V edgeValueOrDefault(EndpointPair<N> endpointPair, @NullableDecl V v) {
        validateEndpoints(endpointPair);
        return edgeValueOrDefault_internal(endpointPair.nodeU(), endpointPair.nodeV(), v);
    }

    @Override // com.google.common.graph.AbstractValueGraph, a2.j.d.f.a, a2.j.d.f.k
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        return isOrderingCompatible(endpointPair) && hasEdgeConnecting_internal(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // a2.j.d.f.k, com.google.common.graph.PredecessorsFunction
    /* renamed from: predecessors */
    public Set<N> mo139predecessors(N n) {
        return checkedConnections(n).c();
    }

    @Override // a2.j.d.f.k, com.google.common.graph.SuccessorsFunction
    /* renamed from: successors */
    public Set<N> mo140successors(N n) {
        return checkedConnections(n).b();
    }
}
