package com.google.common.collect;

import a2.j.d.c.c3;
import a2.j.d.c.f;
import a2.j.d.c.m1;
import a2.j.d.c.r1;
import a2.j.d.c.v2;
import a2.j.d.c.w2;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableMultiset<E> extends m1<E> implements Multiset<E> {
    public static final /* synthetic */ int d = 0;
    @LazyInit
    public transient ImmutableList<E> b;
    @LazyInit
    public transient ImmutableSet<Multiset.Entry<E>> c;

    public static class Builder<E> extends ImmutableCollection.Builder<E> {
        public v2<E> a;
        public boolean b;
        public boolean c;

        public Builder() {
            this(4);
        }

        @CanIgnoreReturnValue
        public Builder<E> addCopies(E e, int i) {
            if (i == 0) {
                return this;
            }
            if (this.b) {
                this.a = new v2<>(this.a);
                this.c = false;
            }
            this.b = false;
            Preconditions.checkNotNull(e);
            v2<E> v2Var = this.a;
            v2Var.o(e, v2Var.d(e) + i);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: a2.j.d.c.v2<E> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public Builder<E> setCount(E e, int i) {
            if (i == 0 && !this.c) {
                this.a = new w2(this.a);
                this.c = true;
            } else if (this.b) {
                this.a = new v2<>(this.a);
                this.c = false;
            }
            this.b = false;
            Preconditions.checkNotNull(e);
            if (i == 0) {
                v2<E> v2Var = this.a;
                Objects.requireNonNull(v2Var);
                v2Var.p(e, AppCompatDelegateImpl.i.W1(e));
            } else {
                this.a.o(Preconditions.checkNotNull(e), i);
            }
            return this;
        }

        public Builder(int i) {
            this.b = false;
            this.c = false;
            this.a = new v2<>(i);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableMultiset<E> build() {
            v2<E> v2Var = this.a;
            if (v2Var.c == 0) {
                return ImmutableMultiset.of();
            }
            if (this.c) {
                this.a = new v2<>(v2Var);
                this.c = false;
            }
            this.b = true;
            return new c3(this.a);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E e) {
            return addCopies(e, 1);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            v2<E> v2Var;
            if (iterable instanceof Multiset) {
                Multiset multiset = (Multiset) iterable;
                if (multiset instanceof c3) {
                    v2Var = ((c3) multiset).e;
                } else {
                    v2Var = multiset instanceof f ? ((f) multiset).c : null;
                }
                if (v2Var != null) {
                    v2<E> v2Var2 = this.a;
                    v2Var2.b(Math.max(v2Var2.c, v2Var.c));
                    for (int c2 = v2Var.c(); c2 >= 0; c2 = v2Var.m(c2)) {
                        addCopies(v2Var.f(c2), v2Var.g(c2));
                    }
                } else {
                    Set<Multiset.Entry<E>> entrySet = multiset.entrySet();
                    v2<E> v2Var3 = this.a;
                    v2Var3.b(Math.max(v2Var3.c, entrySet.size()));
                    for (Multiset.Entry<E> entry : multiset.entrySet()) {
                        addCopies(entry.getElement(), entry.getCount());
                    }
                }
            } else {
                super.addAll((Iterable) iterable);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            super.add((Object[]) eArr);
            return this;
        }

        public Builder(boolean z) {
            this.b = false;
            this.c = false;
            this.a = null;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            super.addAll((Iterator) it);
            return this;
        }
    }

    public class a extends UnmodifiableIterator<E> {
        public int a;
        @MonotonicNonNullDecl
        public E b;
        public final /* synthetic */ Iterator c;

        public a(ImmutableMultiset immutableMultiset, Iterator it) {
            this.c = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a > 0 || this.c.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.a <= 0) {
                Multiset.Entry entry = (Multiset.Entry) this.c.next();
                this.b = (E) entry.getElement();
                this.a = entry.getCount();
            }
            this.a--;
            return this.b;
        }
    }

    public final class b extends r1<Multiset.Entry<E>> {
        private static final long serialVersionUID = 0;

        public b(a aVar) {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            if (entry.getCount() > 0 && ImmutableMultiset.this.count(entry.getElement()) == entry.getCount()) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean e() {
            return ImmutableMultiset.this.e();
        }

        @Override // a2.j.d.c.r1
        public Object get(int i) {
            return ImmutableMultiset.this.h(i);
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.lang.Object, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultiset.this.mo6elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        public Object writeReplace() {
            return new c(ImmutableMultiset.this);
        }
    }

    @GwtIncompatible
    public static class c<E> implements Serializable {
        public final ImmutableMultiset<E> a;

        public c(ImmutableMultiset<E> immutableMultiset) {
            this.a = immutableMultiset;
        }

        public Object readResolve() {
            return this.a.entrySet();
        }
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return f(eArr);
    }

    public static <E> ImmutableMultiset<E> f(E... eArr) {
        return new Builder().add((Object[]) eArr).build();
    }

    public static <E> ImmutableMultiset<E> of() {
        return c3.h;
    }

    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public int a(Object[] objArr, int i) {
        UnmodifiableIterator<Multiset.Entry<E>> it = entrySet().mo99iterator();
        while (it.hasNext()) {
            Multiset.Entry<E> next = it.next();
            Arrays.fill(objArr, i, next.getCount() + i, next.getElement());
            i += next.getCount();
        }
        return i;
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final int add(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.b;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> asList = super.asList();
        this.b = asList;
        return asList;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return count(obj) > 0;
    }

    @Override // com.google.common.collect.Multiset
    /* renamed from: elementSet */
    public abstract ImmutableSet<E> mo6elementSet();

    @Override // java.util.Collection, java.lang.Object, com.google.common.collect.Multiset
    public boolean equals(@NullableDecl Object obj) {
        return Multisets.b(this, obj);
    }

    public abstract Multiset.Entry<E> h(int i);

    @Override // java.util.Collection, java.lang.Object, com.google.common.collect.Multiset
    public int hashCode() {
        return Sets.b(entrySet());
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final int remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final int setCount(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.lang.Object, com.google.common.collect.Multiset
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public abstract Object writeReplace();

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.e()) {
                return immutableMultiset;
            }
        }
        Builder builder = new Builder(Multisets.c(iterable));
        builder.addAll((Iterable) iterable);
        return builder.build();
    }

    public static <E> ImmutableMultiset<E> of(E e) {
        return f(e);
    }

    @Override // com.google.common.collect.Multiset
    public ImmutableSet<Multiset.Entry<E>> entrySet() {
        ImmutableSet<Multiset.Entry<E>> immutableSet = this.c;
        if (immutableSet == null) {
            immutableSet = isEmpty() ? ImmutableSet.of() : new b(null);
            this.c = immutableSet;
        }
        return immutableSet;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: iterator */
    public UnmodifiableIterator<E> mo99iterator() {
        return new a(this, entrySet().mo99iterator());
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean setCount(E e, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2) {
        return f(e, e2);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3) {
        return f(e, e2, e3);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4) {
        return f(e, e2, e3, e4);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4, E e5) {
        return f(e, e2, e3, e4, e5);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        return new Builder().add((Builder) e).add((Builder<E>) e2).add((Builder<E>) e3).add((Builder<E>) e4).add((Builder<E>) e5).add((Builder<E>) e6).add((Object[]) eArr).build();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        return new Builder().addAll((Iterator) it).build();
    }
}
