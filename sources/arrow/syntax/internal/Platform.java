package arrow.syntax.internal;

import androidx.exifinterface.media.ExifInterface;
import com.vk.sdk.api.VKApiConst;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\f²\u0006&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00038\n@\nX\u0002"}, d2 = {"Larrow/syntax/internal/Platform;", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Larrow/syntax/internal/Platform$ConcurrentMap;", "newConcurrentMap", "()Larrow/syntax/internal/Platform$ConcurrentMap;", "<init>", "()V", "ConcurrentMap", "Ljava/util/concurrent/ConcurrentHashMap;", "map", "arrow-syntax"}, k = 1, mv = {1, 4, 0})
public final class Platform {
    public static final Platform INSTANCE = new Platform();
    public static final /* synthetic */ KProperty[] a = {Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinClass(Platform.class), "map", "<v#0>"))};

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003J\u001f\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Larrow/syntax/internal/Platform$ConcurrentMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "k", VKApiConst.VERSION, "putSafely", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "arrow-syntax"}, k = 1, mv = {1, 4, 0})
    public interface ConcurrentMap<K, V> extends Map<K, V>, KMutableMap {
        V putSafely(K k, V v);
    }

    public static final class a extends Lambda implements Function0<ConcurrentHashMap<K, V>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return new ConcurrentHashMap();
        }
    }

    @NotNull
    public final <K, V> ConcurrentMap<K, V> newConcurrentMap() {
        return new Object(c.lazy(a.a), a[0]) { // from class: arrow.syntax.internal.Platform$newConcurrentMap$1
            public final /* synthetic */ ConcurrentHashMap a;
            public final /* synthetic */ Lazy b;
            public final /* synthetic */ KProperty c;

            {
                this.b = r1;
                this.c = r2;
                this.a = (ConcurrentHashMap) r1.getValue();
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
            public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
                return getEntries();
            }

            @Override // java.util.Map
            @Nullable
            public V get(Object obj) {
                return (V) this.a.get(obj);
            }

            @NotNull
            public Set<Map.Entry<K, V>> getEntries() {
                Set<Map.Entry<K, V>> entrySet = this.a.entrySet();
                Intrinsics.checkExpressionValueIsNotNull(entrySet, "<get-entries>(...)");
                return entrySet;
            }

            @NotNull
            public Set<K> getKeys() {
                Set<K> keySet = this.a.keySet();
                Intrinsics.checkExpressionValueIsNotNull(keySet, "<get-keys>(...)");
                return keySet;
            }

            public int getSize() {
                return this.a.size();
            }

            @NotNull
            public Collection<V> getValues() {
                Collection<V> values = this.a.values();
                Intrinsics.checkExpressionValueIsNotNull(values, "<get-values>(...)");
                return values;
            }

            @Override // java.util.Map
            public boolean isEmpty() {
                return this.a.isEmpty();
            }

            @Override // java.util.Map
            public final /* bridge */ Set<K> keySet() {
                return getKeys();
            }

            @Override // java.util.Map
            @Nullable
            public V put(K k, V v) {
                return (V) this.a.put(k, v);
            }

            @Override // java.util.Map
            public void putAll(@NotNull Map<? extends K, ? extends V> map) {
                Intrinsics.checkParameterIsNotNull(map, "from");
                this.a.putAll(map);
            }

            @Override // arrow.syntax.internal.Platform.ConcurrentMap
            public V putSafely(K k, V v) {
                V v2 = (V) ((ConcurrentHashMap) this.b.getValue()).putIfAbsent(k, v);
                return v2 != null ? v2 : v;
            }

            @Override // java.util.Map
            @Nullable
            public V remove(Object obj) {
                return (V) this.a.remove(obj);
            }

            @Override // java.util.Map
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.Map
            public final /* bridge */ Collection<V> values() {
                return getValues();
            }
        };
    }
}
