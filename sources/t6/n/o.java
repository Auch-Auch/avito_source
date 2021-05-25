package t6.n;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class o<K, V> implements n<K, V> {
    @NotNull
    public final Map<K, V> a;
    public final Function1<K, V> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<K, ? extends V> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super K, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    public o(@NotNull Map<K, ? extends V> map, @NotNull Function1<? super K, ? extends V> function1) {
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
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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

    @Override // t6.n.n
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
    public V put(K k, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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
