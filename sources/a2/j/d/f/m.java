package a2.j.d.f;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.HashMap;
public final class m<N, E> extends o<N, E> implements MutableNetwork<N, E> {
    public m(NetworkBuilder<? super N, ? super E> networkBuilder) {
        super(networkBuilder, networkBuilder.c.a(networkBuilder.d.or((Optional<Integer>) 10).intValue()), networkBuilder.f.a(networkBuilder.g.or((Optional<Integer>) 20).intValue()));
    }

    @CanIgnoreReturnValue
    public final m0<N, E> a(N n) {
        m0<N, E> m0Var;
        boolean z = false;
        if (isDirected()) {
            if (allowsParallelEdges()) {
                m0Var = new t<>(new HashMap(2, 1.0f), new HashMap(2, 1.0f), 0);
            } else {
                m0Var = new u<>(HashBiMap.create(2), HashBiMap.create(2), 0);
            }
        } else if (allowsParallelEdges()) {
            m0Var = new o0<>(new HashMap(2, 1.0f));
        } else {
            m0Var = new p0<>(HashBiMap.create(2));
        }
        i0<N, m0<N, E>> i0Var = this.nodeConnections;
        i0Var.a();
        if (i0Var.a.put(n, m0Var) == null) {
            z = true;
        }
        Preconditions.checkState(z);
        return m0Var;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean addEdge(N n, N n2, E e) {
        Preconditions.checkNotNull(n, "nodeU");
        Preconditions.checkNotNull(n2, "nodeV");
        Preconditions.checkNotNull(e, "edge");
        boolean z = false;
        if (containsEdge(e)) {
            EndpointPair<N> incidentNodes = incidentNodes(e);
            EndpointPair a = EndpointPair.a(this, n, n2);
            Preconditions.checkArgument(incidentNodes.equals(a), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", e, incidentNodes, a);
            return false;
        }
        m0<N, E> c = this.nodeConnections.c(n);
        if (!allowsParallelEdges()) {
            if (c == null || !c.b().contains(n2)) {
                z = true;
            }
            Preconditions.checkArgument(z, "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.", n, n2);
        }
        boolean equals = n.equals(n2);
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!equals, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", n);
        }
        if (c == null) {
            c = a(n);
        }
        c.i(e, n2);
        m0<N, E> c2 = this.nodeConnections.c(n2);
        if (c2 == null) {
            c2 = a(n2);
        }
        c2.j(e, n, equals);
        i0<E, N> i0Var = this.edgeToReferenceNode;
        i0Var.a();
        i0Var.a.put(e, n);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean addNode(N n) {
        Preconditions.checkNotNull(n, "node");
        if (containsNode(n)) {
            return false;
        }
        a(n);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean removeEdge(E e) {
        Preconditions.checkNotNull(e, "edge");
        N c = this.edgeToReferenceNode.c(e);
        boolean z = false;
        if (c == null) {
            return false;
        }
        m0<N, E> c2 = this.nodeConnections.c(c);
        N d = c2.d(e);
        m0<N, E> c3 = this.nodeConnections.c(d);
        c2.f(e);
        if (allowsSelfLoops() && c.equals(d)) {
            z = true;
        }
        c3.h(e, z);
        i0<E, N> i0Var = this.edgeToReferenceNode;
        i0Var.a();
        i0Var.a.remove(e);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean removeNode(N n) {
        Preconditions.checkNotNull(n, "node");
        m0<N, E> c = this.nodeConnections.c(n);
        if (c == null) {
            return false;
        }
        UnmodifiableIterator<E> it = ImmutableList.copyOf((Collection) c.k()).mo99iterator();
        while (true) {
            boolean z = true;
            if (it.hasNext()) {
                E next = it.next();
                Preconditions.checkNotNull(next, "edge");
                N c2 = this.edgeToReferenceNode.c(next);
                if (c2 != null) {
                    m0<N, E> c3 = this.nodeConnections.c(c2);
                    N d = c3.d(next);
                    m0<N, E> c4 = this.nodeConnections.c(d);
                    c3.f(next);
                    if (!allowsSelfLoops() || !c2.equals(d)) {
                        z = false;
                    }
                    c4.h(next, z);
                    i0<E, N> i0Var = this.edgeToReferenceNode;
                    i0Var.a();
                    i0Var.a.remove(next);
                }
            } else {
                i0<N, m0<N, E>> i0Var2 = this.nodeConnections;
                i0Var2.a();
                i0Var2.a.remove(n);
                return true;
            }
        }
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean addEdge(EndpointPair<N> endpointPair, E e) {
        validateEndpoints(endpointPair);
        return addEdge(endpointPair.nodeU(), endpointPair.nodeV(), e);
    }
}
