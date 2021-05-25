package a2.j.d.f;

import a2.j.d.f.w;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.graph.EndpointPair;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class a<N> implements k<N> {

    /* renamed from: a2.j.d.f.a$a  reason: collision with other inner class name */
    public class C0072a extends AbstractSet<EndpointPair<N>> {
        public C0072a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: a2.j.d.f.a */
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
        public Iterator iterator() {
            a aVar = a.this;
            return aVar.isDirected() ? new w.b(aVar, null) : new w.c(aVar, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Ints.saturatedCast(a.this.edgeCount());
        }
    }

    public static abstract class b<N> extends AbstractSet<EndpointPair<N>> {
        public static final /* synthetic */ int c = 0;
        public final N a;
        public final k<N> b;

        /* renamed from: a2.j.d.f.a$b$a  reason: collision with other inner class name */
        public static final class C0073a<N> extends b<N> {
            public C0073a(k kVar, Object obj, C0072a aVar) {
                super(kVar, obj, null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (!endpointPair.isOrdered()) {
                    return false;
                }
                Object source = endpointPair.source();
                Object target = endpointPair.target();
                if ((!this.a.equals(source) || !this.b.mo140successors((k<N>) this.a).contains(target)) && (!this.a.equals(target) || !this.b.mo139predecessors((k<N>) this.a).contains(source))) {
                    return false;
                }
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator iterator() {
                return Iterators.unmodifiableIterator(Iterators.concat(Iterators.transform(this.b.mo139predecessors((k<N>) this.a).iterator(), new b(this)), Iterators.transform(Sets.difference(this.b.mo140successors((k<N>) this.a), ImmutableSet.of(this.a)).iterator(), new c(this))));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return (this.b.outDegree(this.a) + this.b.inDegree(this.a)) - (this.b.mo140successors(this.a).contains(this.a) ? 1 : 0);
            }
        }

        /* renamed from: a2.j.d.f.a$b$b  reason: collision with other inner class name */
        public static final class C0074b<N> extends b<N> {
            public C0074b(k kVar, Object obj, C0072a aVar) {
                super(kVar, obj, null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (endpointPair.isOrdered()) {
                    return false;
                }
                Set<N> adjacentNodes = this.b.adjacentNodes(this.a);
                Object nodeU = endpointPair.nodeU();
                Object nodeV = endpointPair.nodeV();
                if ((!this.a.equals(nodeV) || !adjacentNodes.contains(nodeU)) && (!this.a.equals(nodeU) || !adjacentNodes.contains(nodeV))) {
                    return false;
                }
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator iterator() {
                return Iterators.unmodifiableIterator(Iterators.transform(this.b.adjacentNodes(this.a).iterator(), new d(this)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.b.adjacentNodes(this.a).size();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        public b(k kVar, Object obj, C0072a aVar) {
            this.b = kVar;
            this.a = obj;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // a2.j.d.f.k
    public int degree(N n) {
        if (isDirected()) {
            return IntMath.saturatedAdd(mo139predecessors((a<N>) n).size(), mo140successors((a<N>) n).size());
        }
        Set<N> adjacentNodes = adjacentNodes(n);
        return IntMath.saturatedAdd(adjacentNodes.size(), (!allowsSelfLoops() || !adjacentNodes.contains(n)) ? 0 : 1);
    }

    public long edgeCount() {
        long j = 0;
        for (N n : nodes()) {
            j += (long) degree(n);
        }
        Preconditions.checkState((1 & j) == 0);
        return j >>> 1;
    }

    @Override // a2.j.d.f.k
    public Set<EndpointPair<N>> edges() {
        return new C0072a();
    }

    @Override // a2.j.d.f.k
    public boolean hasEdgeConnecting(N n, N n2) {
        Preconditions.checkNotNull(n);
        Preconditions.checkNotNull(n2);
        return nodes().contains(n) && mo140successors(n).contains(n2);
    }

    @Override // a2.j.d.f.k
    public int inDegree(N n) {
        return isDirected() ? mo139predecessors((a<N>) n).size() : degree(n);
    }

    @Override // com.google.common.graph.Graph
    public Set<EndpointPair<N>> incidentEdges(N n) {
        Preconditions.checkNotNull(n);
        Preconditions.checkArgument(nodes().contains(n), "Node %s is not an element of this graph.", n);
        int i = b.c;
        return isDirected() ? new b.C0073a(this, n, null) : new b.C0074b(this, n, null);
    }

    public final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        return endpointPair.isOrdered() || !isDirected();
    }

    @Override // a2.j.d.f.k
    public int outDegree(N n) {
        return isDirected() ? mo140successors((a<N>) n).size() : degree(n);
    }

    public final void validateEndpoints(EndpointPair<?> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(isOrderingCompatible(endpointPair), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }

    @Override // a2.j.d.f.k
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (!isOrderingCompatible(endpointPair)) {
            return false;
        }
        N nodeU = endpointPair.nodeU();
        N nodeV = endpointPair.nodeV();
        if (!nodes().contains(nodeU) || !mo140successors((a<N>) nodeU).contains(nodeV)) {
            return false;
        }
        return true;
    }
}
