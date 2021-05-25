package com.google.common.collect;

import a2.j.d.c.c0;
import a2.j.d.c.l1;
import a2.j.d.c.l3;
import a2.j.d.c.q0;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true, serializable = true)
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements SetMultimap<K, V> {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    public final transient ImmutableSet<V> h;
    @RetainedWith
    @LazyInit
    @MonotonicNonNullDecl
    public transient ImmutableSetMultimap<V, K> i;
    @MonotonicNonNullDecl
    public transient ImmutableSet<Map.Entry<K, V>> j;

    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public Collection<V> a() {
            return new c0();
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public ImmutableSetMultimap<K, V> build() {
            Collection entrySet = this.a.entrySet();
            Comparator<? super K> comparator = this.b;
            if (comparator != null) {
                entrySet = Ordering.from(comparator).a().immutableSortedCopy(entrySet);
            }
            return ImmutableSetMultimap.n(entrySet, this.c);
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> orderKeysBy(Comparator<? super K> comparator) {
            super.orderKeysBy((Comparator) comparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> orderValuesBy(Comparator<? super V> comparator) {
            super.orderValuesBy((Comparator) comparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(K k, V v) {
            super.put((Builder<K, V>) k, (K) v);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put((Map.Entry) entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K k, Iterable<? extends V> iterable) {
            super.putAll((Builder<K, V>) k, (Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K k, V... vArr) {
            return putAll((Builder<K, V>) k, (Iterable) Arrays.asList(vArr));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.ImmutableSetMultimap$Builder<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap) {
            for (Map.Entry<? extends K, Collection<? extends V>> entry : multimap.asMap().entrySet()) {
                putAll((Builder<K, V>) entry.getKey(), (Iterable) entry.getValue());
            }
            return this;
        }
    }

    public static final class a<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        @Weak
        public final transient ImmutableSetMultimap<K, V> c;

        public a(ImmutableSetMultimap<K, V> immutableSetMultimap) {
            this.c = immutableSetMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.c.containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean e() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.c.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: iterator */
        public UnmodifiableIterator<Map.Entry<K, V>> mo99iterator() {
            ImmutableSetMultimap<K, V> immutableSetMultimap = this.c;
            Objects.requireNonNull(immutableSetMultimap);
            return new l1(immutableSetMultimap);
        }
    }

    @GwtIncompatible
    public static final class b {
        public static final l3<ImmutableSetMultimap> a = AppCompatDelegateImpl.i.D0(ImmutableSetMultimap.class, "emptySet");
    }

    public ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> immutableMap, int i2, @NullableDecl Comparator<? super V> comparator) {
        super(immutableMap, i2);
        ImmutableSet<V> immutableSet;
        if (comparator == null) {
            immutableSet = ImmutableSet.of();
        } else {
            immutableSet = ImmutableSortedSet.n(comparator);
        }
        this.h = immutableSet;
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        Preconditions.checkNotNull(multimap);
        if (multimap.isEmpty()) {
            return of();
        }
        if (multimap instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap) multimap;
            if (!immutableSetMultimap.l()) {
                return immutableSetMultimap;
            }
        }
        return n(multimap.asMap().entrySet(), null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.collect.ImmutableMap$Builder */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> ImmutableSetMultimap<K, V> n(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, @NullableDecl Comparator<? super V> comparator) {
        AbstractCollection abstractCollection;
        if (collection.isEmpty()) {
            return of();
        }
        ImmutableMap.Builder builder = new ImmutableMap.Builder(collection.size());
        int i2 = 0;
        Iterator<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> it = collection.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Collection collection2 = (Collection) entry.getValue();
            if (comparator == null) {
                abstractCollection = ImmutableSet.copyOf(collection2);
            } else {
                abstractCollection = ImmutableSortedSet.copyOf((Comparator) comparator, collection2);
            }
            if (!abstractCollection.isEmpty()) {
                builder.put(key, abstractCollection);
                i2 = abstractCollection.size() + i2;
            }
        }
        return new ImmutableSetMultimap<>(builder.build(), i2, comparator);
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return q0.k;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.ImmutableMap$Builder */
    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Object obj;
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            int i2 = 0;
            for (int i3 = 0; i3 < readInt; i3++) {
                Object readObject = objectInputStream.readObject();
                int readInt2 = objectInputStream.readInt();
                if (readInt2 > 0) {
                    ImmutableSet.Builder builder2 = comparator == null ? new ImmutableSet.Builder() : new ImmutableSortedSet.Builder(comparator);
                    for (int i4 = 0; i4 < readInt2; i4++) {
                        builder2.add((ImmutableSet.Builder) objectInputStream.readObject());
                    }
                    ImmutableSet build = builder2.build();
                    if (build.size() == readInt2) {
                        builder.put(readObject, build);
                        i2 += readInt2;
                    } else {
                        throw new InvalidObjectException(a2.b.a.a.a.b3("Duplicate key-value pairs exist for key ", readObject));
                    }
                } else {
                    throw new InvalidObjectException(a2.b.a.a.a.M2("Invalid value count ", readInt2));
                }
            }
            try {
                ImmutableMultimap.c.a.a(this, builder.build());
                l3<ImmutableMultimap> l3Var = ImmutableMultimap.c.b;
                Objects.requireNonNull(l3Var);
                try {
                    l3Var.a.set(this, Integer.valueOf(i2));
                    l3<ImmutableSetMultimap> l3Var2 = b.a;
                    if (comparator == null) {
                        obj = ImmutableSet.of();
                    } else {
                        obj = ImmutableSortedSet.n(comparator);
                    }
                    l3Var2.a(this, obj);
                } catch (IllegalAccessException e) {
                    throw new AssertionError(e);
                }
            } catch (IllegalArgumentException e2) {
                throw ((InvalidObjectException) new InvalidObjectException(e2.getMessage()).initCause(e2));
            }
        } else {
            throw new InvalidObjectException(a2.b.a.a.a.M2("Invalid key count ", readInt));
        }
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        ImmutableSet<V> immutableSet = this.h;
        objectOutputStream.writeObject(immutableSet instanceof ImmutableSortedSet ? ((ImmutableSortedSet) immutableSet).comparator() : null);
        AppCompatDelegateImpl.i.u2(this, objectOutputStream);
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v) {
        Builder builder = builder();
        builder.put((Builder) k, (K) v);
        return builder.build();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.ImmutableSetMultimap<K, V> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.collect.ImmutableSetMultimap$Builder */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> immutableSetMultimap = this.i;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        Builder builder = builder();
        UnmodifiableIterator it = entries().mo99iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.put((Builder) entry.getValue(), entry.getKey());
        }
        ImmutableSetMultimap<V, K> build = builder.build();
        build.i = this;
        this.i = build;
        return build;
    }

    @Override // com.google.common.collect.ImmutableMultimap, a2.j.d.c.h, com.google.common.collect.Multimap
    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.j;
        if (immutableSet != null) {
            return immutableSet;
        }
        a aVar = new a(this);
        this.j = aVar;
        return aVar;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public ImmutableSet<V> mo118get(@NullableDecl K k) {
        return (ImmutableSet) MoreObjects.firstNonNull((ImmutableSet) this.f.get(k), this.h);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    @Deprecated
    /* renamed from: removeAll */
    public ImmutableSet<V> mo119removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    @Deprecated
    /* renamed from: replaceValues */
    public ImmutableSet<V> mo120replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2) {
        Builder builder = builder();
        builder.put((Builder) k, (K) v);
        builder.put((Builder) k2, (K) v2);
        return builder.build();
    }

    @Beta
    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new Builder().putAll((Iterable) iterable).build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        Builder builder = builder();
        builder.put((Builder) k, (K) v);
        builder.put((Builder) k2, (K) v2);
        builder.put((Builder) k3, (K) v3);
        return builder.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        Builder builder = builder();
        builder.put((Builder) k, (K) v);
        builder.put((Builder) k2, (K) v2);
        builder.put((Builder) k3, (K) v3);
        builder.put((Builder) k4, (K) v4);
        return builder.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Builder builder = builder();
        builder.put((Builder) k, (K) v);
        builder.put((Builder) k2, (K) v2);
        builder.put((Builder) k3, (K) v3);
        builder.put((Builder) k4, (K) v4);
        builder.put((Builder) k5, (K) v5);
        return builder.build();
    }
}
