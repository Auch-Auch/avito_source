package com.google.common.graph;

import a2.j.d.f.p;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Immutable(containerOf = {"N", ExifInterface.GPS_MEASUREMENT_INTERRUPTED})
@Beta
public final class ImmutableValueGraph<N, V> extends p<N, V> {

    public static class Builder<N, V> {
        public final MutableValueGraph<N, V> a;

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: com.google.common.graph.MutableValueGraph<N1 extends N, V1 extends V>, com.google.common.graph.MutableValueGraph<N, V> */
        public Builder(ValueGraphBuilder<N, V> valueGraphBuilder) {
            this.a = (MutableValueGraph<N1, V1>) valueGraphBuilder.build();
        }

        @CanIgnoreReturnValue
        public Builder<N, V> addNode(N n) {
            this.a.addNode(n);
            return this;
        }

        public ImmutableValueGraph<N, V> build() {
            return ImmutableValueGraph.copyOf(this.a);
        }

        @CanIgnoreReturnValue
        public Builder<N, V> putEdgeValue(N n, N n2, V v) {
            this.a.putEdgeValue(n, n2, v);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<N, V> putEdgeValue(EndpointPair<N> endpointPair, V v) {
            this.a.putEdgeValue(endpointPair, v);
            return this;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.ImmutableMap$Builder */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ImmutableValueGraph(com.google.common.graph.ValueGraph<N, V> r8) {
        /*
            r7 = this;
            com.google.common.graph.ValueGraphBuilder r0 = com.google.common.graph.ValueGraphBuilder.from(r8)
            com.google.common.collect.ImmutableMap$Builder r1 = com.google.common.collect.ImmutableMap.builder()
            java.util.Set r2 = r8.nodes()
            java.util.Iterator r2 = r2.iterator()
        L_0x0010:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x004c
            java.lang.Object r3 = r2.next()
            a2.j.d.f.f0 r4 = new a2.j.d.f.f0
            r4.<init>(r8, r3)
            boolean r5 = r8.isDirected()
            if (r5 == 0) goto L_0x0036
            java.util.Set r5 = r8.mo139predecessors(r3)
            java.util.Set r6 = r8.mo140successors(r3)
            java.util.Map r4 = com.google.common.collect.Maps.asMap(r6, r4)
            a2.j.d.f.r r4 = a2.j.d.f.r.i(r5, r4)
            goto L_0x0048
        L_0x0036:
            java.util.Set r5 = r8.adjacentNodes(r3)
            java.util.Map r4 = com.google.common.collect.Maps.asMap(r5, r4)
            a2.j.d.f.n0 r5 = new a2.j.d.f.n0
            com.google.common.collect.ImmutableMap r4 = com.google.common.collect.ImmutableMap.copyOf(r4)
            r5.<init>(r4)
            r4 = r5
        L_0x0048:
            r1.put(r3, r4)
            goto L_0x0010
        L_0x004c:
            com.google.common.collect.ImmutableMap r1 = r1.build()
            java.util.Set r8 = r8.edges()
            int r8 = r8.size()
            long r2 = (long) r8
            r7.<init>(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.ImmutableValueGraph.<init>(com.google.common.graph.ValueGraph):void");
    }

    public static <N, V> ImmutableValueGraph<N, V> copyOf(ValueGraph<N, V> valueGraph) {
        return valueGraph instanceof ImmutableValueGraph ? (ImmutableValueGraph) valueGraph : new ImmutableValueGraph<>(valueGraph);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.p, a2.j.d.f.k, com.google.common.graph.ValueGraph
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    @Override // a2.j.d.f.p, a2.j.d.f.k, com.google.common.graph.ValueGraph
    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.p, com.google.common.graph.ValueGraph
    @NullableDecl
    public /* bridge */ /* synthetic */ Object edgeValueOrDefault(EndpointPair endpointPair, @NullableDecl Object obj) {
        return super.edgeValueOrDefault(endpointPair, obj);
    }

    @Override // a2.j.d.f.p, com.google.common.graph.AbstractValueGraph, a2.j.d.f.a, a2.j.d.f.k
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return super.hasEdgeConnecting(endpointPair);
    }

    @Override // a2.j.d.f.p, a2.j.d.f.k, com.google.common.graph.ValueGraph
    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    @Override // a2.j.d.f.p, a2.j.d.f.k, com.google.common.graph.ValueGraph
    public /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    @Override // a2.j.d.f.p, a2.j.d.f.k, com.google.common.graph.ValueGraph
    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.p, a2.j.d.f.k, com.google.common.graph.PredecessorsFunction
    /* renamed from: predecessors */
    public /* bridge */ /* synthetic */ Set mo139predecessors(Object obj) {
        return super.mo139predecessors((ImmutableValueGraph<N, V>) obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.p, a2.j.d.f.k, com.google.common.graph.SuccessorsFunction
    /* renamed from: successors */
    public /* bridge */ /* synthetic */ Set mo140successors(Object obj) {
        return super.mo140successors((ImmutableValueGraph<N, V>) obj);
    }

    @Deprecated
    public static <N, V> ImmutableValueGraph<N, V> copyOf(ImmutableValueGraph<N, V> immutableValueGraph) {
        return (ImmutableValueGraph) Preconditions.checkNotNull(immutableValueGraph);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.ValueGraph
    public ImmutableGraph<N> asGraph() {
        return new ImmutableGraph<>(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.p, com.google.common.graph.ValueGraph
    @NullableDecl
    public /* bridge */ /* synthetic */ Object edgeValueOrDefault(Object obj, Object obj2, @NullableDecl Object obj3) {
        return super.edgeValueOrDefault(obj, obj2, obj3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.p, com.google.common.graph.AbstractValueGraph, a2.j.d.f.a, a2.j.d.f.k
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object obj, Object obj2) {
        return super.hasEdgeConnecting(obj, obj2);
    }
}
