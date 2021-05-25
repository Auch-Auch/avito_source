package a2.j.d.f;

import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.PredecessorsFunction;
import com.google.common.graph.SuccessorsFunction;
import java.util.Set;
public interface k<N> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    @Override // com.google.common.graph.ValueGraph
    Set<N> adjacentNodes(N n);

    @Override // com.google.common.graph.ValueGraph
    boolean allowsSelfLoops();

    int degree(N n);

    Set<EndpointPair<N>> edges();

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n, N n2);

    int inDegree(N n);

    @Override // com.google.common.graph.ValueGraph
    boolean isDirected();

    @Override // com.google.common.graph.ValueGraph
    ElementOrder<N> nodeOrder();

    @Override // com.google.common.graph.ValueGraph
    Set<N> nodes();

    int outDegree(N n);

    @Override // com.google.common.graph.PredecessorsFunction
    /* renamed from: predecessors */
    Set<N> mo139predecessors(N n);

    @Override // com.google.common.graph.SuccessorsFunction
    /* renamed from: successors */
    Set<N> mo140successors(N n);
}
