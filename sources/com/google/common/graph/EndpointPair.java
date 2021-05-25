package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Immutable(containerOf = {"N"})
@Beta
public abstract class EndpointPair<N> implements Iterable<N> {
    public final N a;
    public final N b;

    public static final class b<N> extends EndpointPair<N> {
        public b(Object obj, Object obj2, a aVar) {
            super(obj, obj2, null);
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (true == endpointPair.isOrdered() && nodeU().equals(endpointPair.source()) && nodeV().equals(endpointPair.target())) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Object
        public int hashCode() {
            return Objects.hashCode(nodeU(), nodeV());
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return true;
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return EndpointPair.super.iterator();
        }

        @Override // com.google.common.graph.EndpointPair
        public N source() {
            return nodeU();
        }

        @Override // com.google.common.graph.EndpointPair
        public N target() {
            return nodeV();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("<");
            L.append((Object) nodeU());
            L.append(" -> ");
            L.append((Object) nodeV());
            L.append(">");
            return L.toString();
        }
    }

    public static final class c<N> extends EndpointPair<N> {
        public c(Object obj, Object obj2, a aVar) {
            super(obj, obj2, null);
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (endpointPair.isOrdered()) {
                return false;
            }
            if (nodeU().equals(endpointPair.nodeU())) {
                return nodeV().equals(endpointPair.nodeV());
            }
            if (!nodeU().equals(endpointPair.nodeV()) || !nodeV().equals(endpointPair.nodeU())) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Object
        public int hashCode() {
            return nodeV().hashCode() + nodeU().hashCode();
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return false;
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return EndpointPair.super.iterator();
        }

        @Override // com.google.common.graph.EndpointPair
        public N source() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        @Override // com.google.common.graph.EndpointPair
        public N target() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("[");
            L.append((Object) nodeU());
            L.append(", ");
            L.append((Object) nodeV());
            L.append("]");
            return L.toString();
        }
    }

    public EndpointPair(Object obj, Object obj2, a aVar) {
        this.a = (N) Preconditions.checkNotNull(obj);
        this.b = (N) Preconditions.checkNotNull(obj2);
    }

    public static <N> EndpointPair<N> a(Network<?, ?> network, N n, N n2) {
        return network.isDirected() ? ordered(n, n2) : unordered(n, n2);
    }

    public static <N> EndpointPair<N> ordered(N n, N n2) {
        return new b(n, n2, null);
    }

    public static <N> EndpointPair<N> unordered(N n, N n2) {
        return new c(n2, n, null);
    }

    public final N adjacentNode(Object obj) {
        if (obj.equals(this.a)) {
            return this.b;
        }
        if (obj.equals(this.b)) {
            return this.a;
        }
        throw new IllegalArgumentException("EndpointPair " + this + " does not contain node " + obj);
    }

    @Override // java.lang.Object
    public abstract boolean equals(@NullableDecl Object obj);

    @Override // java.lang.Object
    public abstract int hashCode();

    public abstract boolean isOrdered();

    public final N nodeU() {
        return this.a;
    }

    public final N nodeV() {
        return this.b;
    }

    public abstract N source();

    public abstract N target();

    @Override // java.lang.Iterable
    public final UnmodifiableIterator<N> iterator() {
        return Iterators.forArray(this.a, this.b);
    }
}
