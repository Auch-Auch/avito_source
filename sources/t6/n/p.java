package t6.n;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public class p {
    @PublishedApi
    @JvmName(name = "getOrImplicitDefaultNullable")
    public static final <K, V> V getOrImplicitDefaultNullable(@NotNull Map<K, ? extends V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "$this$getOrImplicitDefault");
        if (map instanceof n) {
            return (V) ((n) map).b(k);
        }
        V v = (V) map.get(k);
        if (v != null || map.containsKey(k)) {
            return v;
        }
        throw new NoSuchElementException("Key " + ((Object) k) + " is missing in the map.");
    }

    @NotNull
    public static final <K, V> Map<K, V> withDefault(@NotNull Map<K, ? extends V> map, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(map, "$this$withDefault");
        Intrinsics.checkNotNullParameter(function1, "defaultValue");
        if (map instanceof n) {
            return withDefault(((n) map).getMap(), function1);
        }
        return new o(map, function1);
    }

    @JvmName(name = "withDefaultMutable")
    @NotNull
    public static final <K, V> Map<K, V> withDefaultMutable(@NotNull Map<K, V> map, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(map, "$this$withDefault");
        Intrinsics.checkNotNullParameter(function1, "defaultValue");
        if (map instanceof t) {
            return withDefaultMutable(((t) map).getMap(), function1);
        }
        return new u(map, function1);
    }
}
