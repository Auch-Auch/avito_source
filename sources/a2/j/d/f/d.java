package a2.j.d.f;

import a2.j.d.f.a;
import com.google.common.base.Function;
import com.google.common.graph.EndpointPair;
public class d implements Function<N, EndpointPair<N>> {
    public final /* synthetic */ a.b.C0074b a;

    public d(a.b.C0074b bVar) {
        this.a = bVar;
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        return EndpointPair.unordered(this.a.a, obj);
    }
}
