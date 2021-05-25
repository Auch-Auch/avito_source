package a2.j.d.f;

import com.google.common.base.Function;
import com.google.common.graph.ValueGraph;
public final class f0 implements Function<N, V> {
    public final /* synthetic */ ValueGraph a;
    public final /* synthetic */ Object b;

    public f0(ValueGraph valueGraph, Object obj) {
        this.a = valueGraph;
        this.b = obj;
    }

    @Override // com.google.common.base.Function
    public V apply(N n) {
        return (V) this.a.edgeValueOrDefault(this.b, n, null);
    }
}
