package a2.j.d.c;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import java.util.Map;
public final class d2 implements Function<Map.Entry<K, V1>, V2> {
    public final /* synthetic */ Maps.EntryTransformer a;

    public d2(Maps.EntryTransformer entryTransformer) {
        this.a = entryTransformer;
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        return this.a.transformEntry(entry.getKey(), entry.getValue());
    }
}
