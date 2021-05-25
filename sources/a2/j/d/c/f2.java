package a2.j.d.c;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
public final class f2 implements Function<Map.Entry<K, V1>, Map.Entry<K, V2>> {
    public final /* synthetic */ Maps.EntryTransformer a;

    public f2(Maps.EntryTransformer entryTransformer) {
        this.a = entryTransformer;
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Maps.EntryTransformer entryTransformer = this.a;
        Preconditions.checkNotNull(entryTransformer);
        Preconditions.checkNotNull(entry);
        return new e2(entry, entryTransformer);
    }
}
