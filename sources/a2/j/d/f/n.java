package a2.j.d.f;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.Graphs;
import com.google.common.graph.MutableValueGraph;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
public final class n<N, V> extends p<N, V> implements MutableValueGraph<N, V> {
    public n(f<? super N> fVar) {
        super(fVar, fVar.c.a(fVar.d.or((Optional<Integer>) 10).intValue()), 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.util.Map<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @CanIgnoreReturnValue
    public final a0<N, V> a(N n) {
        a0<N, V> a0Var;
        boolean z = false;
        if (isDirected()) {
            a0Var = new r<>(new HashMap(4, 1.0f), 0, 0);
        } else {
            a0Var = new n0<>(new HashMap(2, 1.0f));
        }
        i0<N, a0<N, V>> i0Var = this.nodeConnections;
        i0Var.a();
        if (i0Var.a.put(n, a0Var) == null) {
            z = true;
        }
        Preconditions.checkState(z);
        return a0Var;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public boolean addNode(N n) {
        Preconditions.checkNotNull(n, "node");
        if (containsNode(n)) {
            return false;
        }
        a(n);
        return true;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public V putEdgeValue(N n, N n2, V v) {
        Preconditions.checkNotNull(n, "nodeU");
        Preconditions.checkNotNull(n2, "nodeV");
        Preconditions.checkNotNull(v, "value");
        boolean z = true;
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!n.equals(n2), "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", n);
        }
        a0<N, V> c = this.nodeConnections.c(n);
        if (c == null) {
            c = a(n);
        }
        V h = c.h(n2, v);
        a0<N, V> c2 = this.nodeConnections.c(n2);
        if (c2 == null) {
            c2 = a(n2);
        }
        c2.d(n, v);
        if (h == null) {
            long j = this.edgeCount + 1;
            this.edgeCount = j;
            if (j <= 0) {
                z = false;
            }
            Preconditions.checkArgument(z, "Not true that %s is positive.", j);
        }
        return h;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public V removeEdge(N n, N n2) {
        Preconditions.checkNotNull(n, "nodeU");
        Preconditions.checkNotNull(n2, "nodeV");
        a0<N, V> c = this.nodeConnections.c(n);
        a0<N, V> c2 = this.nodeConnections.c(n2);
        if (c == null || c2 == null) {
            return null;
        }
        V f = c.f(n2);
        if (f != null) {
            c2.g(n);
            long j = this.edgeCount - 1;
            this.edgeCount = j;
            Graphs.b(j);
        }
        return f;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public boolean removeNode(N n) {
        Preconditions.checkNotNull(n, "node");
        a0<N, V> c = this.nodeConnections.c(n);
        if (c == null) {
            return false;
        }
        if (allowsSelfLoops() && c.f(n) != null) {
            c.g(n);
            this.edgeCount--;
        }
        for (N n2 : c.b()) {
            this.nodeConnections.e(n2).g(n);
            this.edgeCount--;
        }
        if (isDirected()) {
            for (N n3 : c.c()) {
                Preconditions.checkState(this.nodeConnections.e(n3).f(n) != null);
                this.edgeCount--;
            }
        }
        i0<N, a0<N, V>> i0Var = this.nodeConnections;
        i0Var.a();
        i0Var.a.remove(n);
        Graphs.b(this.edgeCount);
        return true;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public V removeEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public V putEdgeValue(EndpointPair<N> endpointPair, V v) {
        validateEndpoints(endpointPair);
        return putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), v);
    }
}
