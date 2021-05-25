package com.google.common.graph;

import a2.j.d.f.o;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Set;
@Immutable(containerOf = {"N", ExifInterface.LONGITUDE_EAST})
@Beta
public final class ImmutableNetwork<N, E> extends o<N, E> {

    public static class Builder<N, E> {
        public final MutableNetwork<N, E> a;

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: com.google.common.graph.MutableNetwork<N1 extends N, E1 extends E>, com.google.common.graph.MutableNetwork<N, E> */
        public Builder(NetworkBuilder<N, E> networkBuilder) {
            this.a = (MutableNetwork<N1, E1>) networkBuilder.build();
        }

        @CanIgnoreReturnValue
        public Builder<N, E> addEdge(N n, N n2, E e) {
            this.a.addEdge(n, n2, e);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<N, E> addNode(N n) {
            this.a.addNode(n);
            return this;
        }

        public ImmutableNetwork<N, E> build() {
            return ImmutableNetwork.copyOf(this.a);
        }

        @CanIgnoreReturnValue
        public Builder<N, E> addEdge(EndpointPair<N> endpointPair, E e) {
            this.a.addEdge(endpointPair, e);
            return this;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ImmutableNetwork(com.google.common.graph.Network<N, E> r9) {
        /*
            r8 = this;
            com.google.common.graph.NetworkBuilder r0 = com.google.common.graph.NetworkBuilder.from(r9)
            com.google.common.collect.ImmutableMap$Builder r1 = com.google.common.collect.ImmutableMap.builder()
            java.util.Set r2 = r9.nodes()
            java.util.Iterator r2 = r2.iterator()
        L_0x0010:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x008f
            java.lang.Object r3 = r2.next()
            boolean r4 = r9.isDirected()
            if (r4 == 0) goto L_0x0064
            java.util.Set r4 = r9.inEdges(r3)
            a2.j.d.f.c0 r5 = new a2.j.d.f.c0
            r5.<init>(r9)
            java.util.Map r4 = com.google.common.collect.Maps.asMap(r4, r5)
            java.util.Set r5 = r9.outEdges(r3)
            a2.j.d.f.d0 r6 = new a2.j.d.f.d0
            r6.<init>(r9)
            java.util.Map r5 = com.google.common.collect.Maps.asMap(r5, r6)
            java.util.Set r6 = r9.edgesConnecting(r3, r3)
            int r6 = r6.size()
            boolean r7 = r9.allowsParallelEdges()
            if (r7 == 0) goto L_0x0056
            a2.j.d.f.t r7 = new a2.j.d.f.t
            com.google.common.collect.ImmutableMap r4 = com.google.common.collect.ImmutableMap.copyOf(r4)
            com.google.common.collect.ImmutableMap r5 = com.google.common.collect.ImmutableMap.copyOf(r5)
            r7.<init>(r4, r5, r6)
            goto L_0x008b
        L_0x0056:
            a2.j.d.f.u r7 = new a2.j.d.f.u
            com.google.common.collect.ImmutableBiMap r4 = com.google.common.collect.ImmutableBiMap.copyOf(r4)
            com.google.common.collect.ImmutableBiMap r5 = com.google.common.collect.ImmutableBiMap.copyOf(r5)
            r7.<init>(r4, r5, r6)
            goto L_0x008b
        L_0x0064:
            java.util.Set r4 = r9.incidentEdges(r3)
            a2.j.d.f.e0 r5 = new a2.j.d.f.e0
            r5.<init>(r9, r3)
            java.util.Map r4 = com.google.common.collect.Maps.asMap(r4, r5)
            boolean r5 = r9.allowsParallelEdges()
            if (r5 == 0) goto L_0x0081
            a2.j.d.f.o0 r5 = new a2.j.d.f.o0
            com.google.common.collect.ImmutableMap r4 = com.google.common.collect.ImmutableMap.copyOf(r4)
            r5.<init>(r4)
            goto L_0x008a
        L_0x0081:
            a2.j.d.f.p0 r5 = new a2.j.d.f.p0
            com.google.common.collect.ImmutableBiMap r4 = com.google.common.collect.ImmutableBiMap.copyOf(r4)
            r5.<init>(r4)
        L_0x008a:
            r7 = r5
        L_0x008b:
            r1.put(r3, r7)
            goto L_0x0010
        L_0x008f:
            com.google.common.collect.ImmutableMap r1 = r1.build()
            com.google.common.collect.ImmutableMap$Builder r2 = com.google.common.collect.ImmutableMap.builder()
            java.util.Set r3 = r9.edges()
            java.util.Iterator r3 = r3.iterator()
        L_0x009f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00b5
            java.lang.Object r4 = r3.next()
            com.google.common.graph.EndpointPair r5 = r9.incidentNodes(r4)
            java.lang.Object r5 = r5.nodeU()
            r2.put(r4, r5)
            goto L_0x009f
        L_0x00b5:
            com.google.common.collect.ImmutableMap r9 = r2.build()
            r8.<init>(r0, r1, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.ImmutableNetwork.<init>(com.google.common.graph.Network):void");
    }

    public static <N, E> ImmutableNetwork<N, E> copyOf(Network<N, E> network) {
        return network instanceof ImmutableNetwork ? (ImmutableNetwork) network : new ImmutableNetwork<>(network);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.o, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    @Override // a2.j.d.f.o, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean allowsParallelEdges() {
        return super.allowsParallelEdges();
    }

    @Override // a2.j.d.f.o, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    @Override // a2.j.d.f.o, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ ElementOrder edgeOrder() {
        return super.edgeOrder();
    }

    @Override // a2.j.d.f.o, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set edges() {
        return super.edges();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.o, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set edgesConnecting(Object obj, Object obj2) {
        return super.edgesConnecting(obj, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.o, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set inEdges(Object obj) {
        return super.inEdges(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.o, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set incidentEdges(Object obj) {
        return super.incidentEdges(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.o, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ EndpointPair incidentNodes(Object obj) {
        return super.incidentNodes(obj);
    }

    @Override // a2.j.d.f.o, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    @Override // a2.j.d.f.o, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    @Override // a2.j.d.f.o, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.o, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set outEdges(Object obj) {
        return super.outEdges(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.o, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    /* renamed from: predecessors */
    public /* bridge */ /* synthetic */ Set mo139predecessors(Object obj) {
        return super.mo139predecessors((ImmutableNetwork<N, E>) obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.f.o, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    /* renamed from: successors */
    public /* bridge */ /* synthetic */ Set mo140successors(Object obj) {
        return super.mo140successors((ImmutableNetwork<N, E>) obj);
    }

    @Deprecated
    public static <N, E> ImmutableNetwork<N, E> copyOf(ImmutableNetwork<N, E> immutableNetwork) {
        return (ImmutableNetwork) Preconditions.checkNotNull(immutableNetwork);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public ImmutableGraph<N> asGraph() {
        return new ImmutableGraph<>(super.asGraph());
    }
}
