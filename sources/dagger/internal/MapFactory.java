package dagger.internal;

import com.avito.android.util.preferences.GeoContract;
import dagger.internal.AbstractMapFactory;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;
public final class MapFactory<K, V> extends AbstractMapFactory<K, V, V> {
    public static final Provider<Map<Object, Object>> b = InstanceFactory.create(Collections.emptyMap());

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, V> {
        public Builder(int i, a aVar) {
            super(i);
        }

        public MapFactory<K, V> build() {
            return new MapFactory<>(this.a, null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.LinkedHashMap<K, javax.inject.Provider<V>> */
        /* JADX WARN: Multi-variable type inference failed */
        public Builder<K, V> put(K k, Provider<V> provider) {
            this.a.put(Preconditions.checkNotNull(k, "key"), Preconditions.checkNotNull(provider, GeoContract.PROVIDER));
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: javax.inject.Provider<java.util.Map<K, V>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> putAll(Provider<Map<K, V>> provider) {
            super.putAll((Provider) provider);
            return this;
        }
    }

    public MapFactory(Map map, a aVar) {
        super(map);
    }

    public static <K, V> Builder<K, V> builder(int i) {
        return new Builder<>(i, null);
    }

    public static <K, V> Provider<Map<K, V>> emptyMapProvider() {
        return (Provider<Map<K, V>>) b;
    }

    @Override // javax.inject.Provider
    public Map<K, V> get() {
        LinkedHashMap newLinkedHashMapWithExpectedSize = DaggerCollections.newLinkedHashMapWithExpectedSize(this.a.size());
        for (Map.Entry<K, Provider<V>> entry : this.a.entrySet()) {
            newLinkedHashMapWithExpectedSize.put(entry.getKey(), entry.getValue().get());
        }
        return Collections.unmodifiableMap(newLinkedHashMapWithExpectedSize);
    }
}
