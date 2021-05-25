package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Collection;
import java.util.EnumSet;
@GwtCompatible(emulated = true, serializable = true)
public final class g1<E extends Enum<E>> extends ImmutableSet<E> {
    public final transient EnumSet<E> c;
    @LazyInit
    public transient int d;

    public static class b<E extends Enum<E>> implements Serializable {
        private static final long serialVersionUID = 0;
        public final EnumSet<E> a;

        public b(EnumSet<E> enumSet) {
            this.a = enumSet;
        }

        public Object readResolve() {
            return new g1(this.a.clone(), null);
        }
    }

    public g1(EnumSet<E> enumSet) {
        this.c = enumSet;
    }

    public static ImmutableSet l(EnumSet enumSet) {
        int size = enumSet.size();
        if (size == 0) {
            return ImmutableSet.of();
        }
        if (size != 1) {
            return new g1(enumSet);
        }
        return ImmutableSet.of(Iterables.getOnlyElement(enumSet));
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.c.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof g1) {
            collection = ((g1) collection).c;
        }
        return this.c.containsAll(collection);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean e() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.lang.Object, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g1) {
            obj = ((g1) obj).c;
        }
        return this.c.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int hashCode = this.c.hashCode();
        this.d = hashCode;
        return hashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean j() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.c.size();
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        return this.c.toString();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new b(this.c);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: iterator */
    public UnmodifiableIterator<E> mo99iterator() {
        return Iterators.unmodifiableIterator(this.c.iterator());
    }

    public g1(EnumSet enumSet, a aVar) {
        this.c = enumSet;
    }
}
