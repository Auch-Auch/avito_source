package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public final class k1<K, V> extends ImmutableCollection<V> {
    public final ImmutableMap<K, V> b;

    public class a extends UnmodifiableIterator<V> {
        public final UnmodifiableIterator<Map.Entry<K, V>> a;

        public a() {
            this.a = k1.this.b.entrySet().mo99iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.a.next().getValue();
        }
    }

    public class b extends ImmutableList<V> {
        public final /* synthetic */ ImmutableList c;

        public b(k1 k1Var, ImmutableList immutableList) {
            this.c = immutableList;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean e() {
            return true;
        }

        @Override // java.util.List
        public V get(int i) {
            return (V) ((Map.Entry) this.c.get(i)).getValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.c.size();
        }
    }

    @GwtIncompatible
    public static class c<V> implements Serializable {
        private static final long serialVersionUID = 0;
        public final ImmutableMap<?, V> a;

        public c(ImmutableMap<?, V> immutableMap) {
            this.a = immutableMap;
        }

        public Object readResolve() {
            return this.a.values();
        }
    }

    public k1(ImmutableMap<K, V> immutableMap) {
        this.b = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<V> asList() {
        return new b(this, this.b.entrySet().asList());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return obj != null && Iterators.contains(new a(), obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean e() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: iterator */
    public UnmodifiableIterator<V> mo99iterator() {
        return new a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.b.size();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new c(this.b);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: iterator  reason: collision with other method in class */
    public Iterator mo99iterator() {
        return new a();
    }
}
