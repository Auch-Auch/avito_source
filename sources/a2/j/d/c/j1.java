package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public final class j1<K, V> extends r1<K> {
    public final ImmutableMap<K, V> c;

    @GwtIncompatible
    public static class a<K> implements Serializable {
        private static final long serialVersionUID = 0;
        public final ImmutableMap<K, ?> a;

        public a(ImmutableMap<K, ?> immutableMap) {
            this.a = immutableMap;
        }

        public Object readResolve() {
            return this.a.keySet();
        }
    }

    public j1(ImmutableMap<K, V> immutableMap) {
        this.c = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return this.c.containsKey(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean e() {
        return true;
    }

    @Override // a2.j.d.c.r1
    public K get(int i) {
        return this.c.entrySet().asList().get(i).getKey();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.c.size();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new a(this.c);
    }

    @Override // a2.j.d.c.r1, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: iterator */
    public UnmodifiableIterator<K> mo99iterator() {
        return this.c.i();
    }
}
