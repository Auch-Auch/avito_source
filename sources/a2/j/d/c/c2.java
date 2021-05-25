package a2.j.d.c;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class c2 implements Function<V1, V2> {
    public final /* synthetic */ Maps.EntryTransformer a;
    public final /* synthetic */ Object b;

    public c2(Maps.EntryTransformer entryTransformer, Object obj) {
        this.a = entryTransformer;
        this.b = obj;
    }

    @Override // com.google.common.base.Function
    public V2 apply(@NullableDecl V1 v1) {
        return (V2) this.a.transformEntry(this.b, v1);
    }
}
