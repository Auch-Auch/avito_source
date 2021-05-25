package a2.j.d.k;

import com.google.common.base.Function;
import com.google.common.reflect.MutableTypeToInstanceMap;
import java.util.Map;
public final class c implements Function<Map.Entry<K, V>, Map.Entry<K, V>> {
    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        return new MutableTypeToInstanceMap.b((Map.Entry) obj, null);
    }
}
