package t6.n;

import java.util.Map;
import kotlin.jvm.internal.markers.KMutableMap;
import org.jetbrains.annotations.NotNull;
public interface t<K, V> extends Map<K, V>, n<K, V>, KMutableMap {
    @Override // t6.n.n
    @NotNull
    Map<K, V> getMap();
}
