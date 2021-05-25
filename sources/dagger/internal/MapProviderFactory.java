package dagger.internal;

import com.avito.android.util.preferences.GeoContract;
import dagger.Lazy;
import dagger.internal.AbstractMapFactory;
import java.util.Map;
import javax.inject.Provider;
public final class MapProviderFactory<K, V> extends AbstractMapFactory<K, V, Provider<V>> implements Lazy<Map<K, Provider<V>>> {

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, Provider<V>> {
        public Builder(int i, a aVar) {
            super(i);
        }

        public MapProviderFactory<K, V> build() {
            return new MapProviderFactory<>(this.a, null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.LinkedHashMap<K, javax.inject.Provider<V>> */
        /* JADX WARN: Multi-variable type inference failed */
        public Builder<K, V> put(K k, Provider<V> provider) {
            this.a.put(Preconditions.checkNotNull(k, "key"), Preconditions.checkNotNull(provider, GeoContract.PROVIDER));
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: javax.inject.Provider<java.util.Map<K, javax.inject.Provider<V>>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> putAll(Provider<Map<K, Provider<V>>> provider) {
            super.putAll((Provider) provider);
            return this;
        }
    }

    public MapProviderFactory(Map map, a aVar) {
        super(map);
    }

    public static <K, V> Builder<K, V> builder(int i) {
        return new Builder<>(i, null);
    }

    @Override // javax.inject.Provider
    public Map<K, Provider<V>> get() {
        return this.a;
    }
}
