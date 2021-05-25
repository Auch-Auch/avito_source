package t6.n;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class u<K, V> implements t<K, V> {
    @NotNull
    public final Map<K, V> a;
    public final Function1<K, V> b;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super K, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    public u(@NotNull Map<K, V> map, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(function1, "default");
        this.a = map;
        this.b = function1;
    }

    @Override // t6.n.n
    public V b(K k) {
        Map<K, V> map = this.a;
        V v = map.get(k);
        return (v != null || map.containsKey(k)) ? v : this.b.invoke(k);
    }

    @Override // java.util.Map
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.a.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return this.a.entrySet();
    }

    @Override // java.util.Map, java.lang.Object
    public boolean equals(@Nullable Object obj) {
        return this.a.equals(obj);
    }

    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        return this.a.get(obj);
    }

    @Override // t6.n.t, t6.n.n
    @NotNull
    public Map<K, V> getMap() {
        return this.a;
    }

    @Override // java.util.Map, java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        return this.a.keySet();
    }

    @Override // java.util.Map
    @Nullable
    public V put(K k, V v) {
        return this.a.put(k, v);
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "from");
        this.a.putAll(map);
    }

    @Override // java.util.Map
    @Nullable
    public V remove(Object obj) {
        return this.a.remove(obj);
    }

    @Override // java.util.Map
    public final int size() {
        return this.a.size();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return this.a.toString();
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return this.a.values();
    }
}
