package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public abstract class i1<K, V> extends ImmutableSet<Map.Entry<K, V>> {

    @GwtIncompatible
    public static class a<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        public final ImmutableMap<K, V> a;

        public a(ImmutableMap<K, V> immutableMap) {
            this.a = immutableMap;
        }

        public Object readResolve() {
            return this.a.entrySet();
        }
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        V v = l().get(entry.getKey());
        if (v == null || !v.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean e() {
        return l().h();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        return l().hashCode();
    }

    @Override // com.google.common.collect.ImmutableSet
    @GwtIncompatible
    public boolean j() {
        return l().f();
    }

    public abstract ImmutableMap<K, V> l();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return l().size();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new a(l());
    }
}
