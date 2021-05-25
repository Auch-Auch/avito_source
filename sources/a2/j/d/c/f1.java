package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true, serializable = true)
public final class f1<K extends Enum<K>, V> extends ImmutableMap.b<K, V> {
    public final transient EnumMap<K, V> f;

    public static class b<K extends Enum<K>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        public final EnumMap<K, V> a;

        public b(EnumMap<K, V> enumMap) {
            this.a = enumMap;
        }

        public Object readResolve() {
            return new f1(this.a, null);
        }
    }

    public f1(EnumMap<K, V> enumMap) {
        this.f = enumMap;
        Preconditions.checkArgument(!enumMap.isEmpty());
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return this.f.containsKey(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f1) {
            obj = ((f1) obj).f;
        }
        return this.f.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        return this.f.get(obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean h() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    public UnmodifiableIterator<K> i() {
        return Iterators.unmodifiableIterator(this.f.keySet().iterator());
    }

    @Override // com.google.common.collect.ImmutableMap.b
    public UnmodifiableIterator<Map.Entry<K, V>> j() {
        return new l2(this.f.entrySet().iterator());
    }

    @Override // java.util.Map
    public int size() {
        return this.f.size();
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new b(this.f);
    }

    public f1(EnumMap enumMap, a aVar) {
        this.f = enumMap;
        Preconditions.checkArgument(!enumMap.isEmpty());
    }
}
