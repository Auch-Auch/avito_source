package t6.n;

import java.util.Map;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
public interface n<K, V> extends Map<K, V>, KMappedMarker {
    V b(K k);

    @NotNull
    Map<K, V> getMap();
}
