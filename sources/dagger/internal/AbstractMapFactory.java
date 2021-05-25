package dagger.internal;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;
public abstract class AbstractMapFactory<K, V, V2> implements Factory<Map<K, V2>> {
    public final Map<K, Provider<V>> a;

    public static abstract class Builder<K, V, V2> {
        public final LinkedHashMap<K, Provider<V>> a;

        public Builder(int i) {
            this.a = DaggerCollections.newLinkedHashMapWithExpectedSize(i);
        }

        public Builder<K, V, V2> putAll(Provider<Map<K, V2>> provider) {
            if (provider instanceof DelegateFactory) {
                return putAll((Provider) Preconditions.checkNotNull(((DelegateFactory) provider).a));
            }
            this.a.putAll(((AbstractMapFactory) provider).a);
            return this;
        }
    }

    public AbstractMapFactory(Map<K, Provider<V>> map) {
        this.a = Collections.unmodifiableMap(map);
    }
}
