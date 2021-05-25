package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.ForwardingList;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public class x0<K, V> extends h<K, V> implements z0<K, V> {
    public final Multimap<K, V> f;
    public final Predicate<? super K> g;

    public static class a<K, V> extends ForwardingList<V> {
        public final K a;

        public a(K k) {
            this.a = k;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean add(V v) {
            add(0, v);
            throw null;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends V> collection) {
            addAll(0, collection);
            throw null;
        }

        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Object mo147delegate() {
            return Collections.emptyList();
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public void add(int i, V v) {
            Preconditions.checkPositionIndex(i, 0);
            StringBuilder L = a2.b.a.a.a.L("Key does not satisfy predicate: ");
            L.append((Object) this.a);
            throw new IllegalArgumentException(L.toString());
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        @CanIgnoreReturnValue
        public boolean addAll(int i, Collection<? extends V> collection) {
            Preconditions.checkNotNull(collection);
            Preconditions.checkPositionIndex(i, 0);
            StringBuilder L = a2.b.a.a.a.L("Key does not satisfy predicate: ");
            L.append((Object) this.a);
            throw new IllegalArgumentException(L.toString());
        }

        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate  reason: collision with other method in class */
        public Collection mo147delegate() {
            return Collections.emptyList();
        }

        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public List<V> mo147delegate() {
            return Collections.emptyList();
        }
    }

    public static class b<K, V> extends ForwardingSet<V> {
        public final K a;

        public b(K k) {
            this.a = k;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean add(V v) {
            StringBuilder L = a2.b.a.a.a.L("Key does not satisfy predicate: ");
            L.append((Object) this.a);
            throw new IllegalArgumentException(L.toString());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends V> collection) {
            Preconditions.checkNotNull(collection);
            StringBuilder L = a2.b.a.a.a.L("Key does not satisfy predicate: ");
            L.append((Object) this.a);
            throw new IllegalArgumentException(L.toString());
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Object mo147delegate() {
            return Collections.emptySet();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate  reason: collision with other method in class */
        public Collection mo147delegate() {
            return Collections.emptySet();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Set<V> mo147delegate() {
            return Collections.emptySet();
        }
    }

    public class c extends ForwardingCollection<Map.Entry<K, V>> {
        public c() {
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!x0.this.f.containsKey(entry.getKey()) || !x0.this.g.apply((Object) entry.getKey())) {
                return false;
            }
            return x0.this.f.remove(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Collection<Map.Entry<K, V>> mo147delegate() {
            return Collections2.filter(x0.this.f.entries(), x0.this.c());
        }
    }

    public x0(Multimap<K, V> multimap, Predicate<? super K> predicate) {
        this.f = (Multimap) Preconditions.checkNotNull(multimap);
        this.g = (Predicate) Preconditions.checkNotNull(predicate);
    }

    @Override // a2.j.d.c.z0
    /* renamed from: a */
    public Multimap<K, V> mo31a() {
        return this.f;
    }

    @Override // a2.j.d.c.h
    public Map<K, Collection<V>> b() {
        return Maps.filterKeys(this.f.asMap(), this.g);
    }

    @Override // a2.j.d.c.z0
    public Predicate<? super Map.Entry<K, V>> c() {
        return Maps.j(this.g);
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        keySet().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object obj) {
        if (this.f.containsKey(obj)) {
            return this.g.apply(obj);
        }
        return false;
    }

    @Override // a2.j.d.c.h
    public Collection<Map.Entry<K, V>> d() {
        return new c();
    }

    @Override // a2.j.d.c.h
    public Set<K> e() {
        return Sets.filter(this.f.keySet(), this.g);
    }

    @Override // a2.j.d.c.h
    public Multiset<K> f() {
        return Multisets.filter(this.f.keys(), this.g);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public Collection<V> mo118get(K k) {
        if (this.g.apply(k)) {
            return this.f.mo118get(k);
        }
        if (this.f instanceof SetMultimap) {
            return new b(k);
        }
        return new a(k);
    }

    @Override // a2.j.d.c.h
    public Collection<V> h() {
        return new a1(this);
    }

    @Override // a2.j.d.c.h
    public Iterator<Map.Entry<K, V>> i() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: removeAll */
    public Collection<V> mo119removeAll(Object obj) {
        if (containsKey(obj)) {
            return this.f.mo119removeAll(obj);
        }
        if (this.f instanceof SetMultimap) {
            return ImmutableSet.of();
        }
        return ImmutableList.of();
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        int i = 0;
        for (Collection<V> collection : asMap().values()) {
            i += collection.size();
        }
        return i;
    }
}
