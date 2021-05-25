package dagger.internal;

import java.util.Collections;
import java.util.Map;
public final class MapBuilder<K, V> {
    public final Map<K, V> a;

    public MapBuilder(int i) {
        this.a = DaggerCollections.newLinkedHashMapWithExpectedSize(i);
    }

    public static <K, V> MapBuilder<K, V> newMapBuilder(int i) {
        return new MapBuilder<>(i);
    }

    public Map<K, V> build() {
        if (this.a.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(this.a);
    }

    public MapBuilder<K, V> put(K k, V v) {
        this.a.put(k, v);
        return this;
    }

    public MapBuilder<K, V> putAll(Map<K, V> map) {
        this.a.putAll(map);
        return this;
    }
}
