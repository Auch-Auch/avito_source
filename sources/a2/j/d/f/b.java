package a2.j.d.f;

import a2.j.d.f.a;
import com.google.common.base.Function;
import com.google.common.graph.EndpointPair;
public class b implements Function<N, EndpointPair<N>> {
    public final /* synthetic */ a.b.C0073a a;

    public b(a.b.C0073a aVar) {
        this.a = aVar;
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        return EndpointPair.ordered(obj, this.a.a);
    }
}
