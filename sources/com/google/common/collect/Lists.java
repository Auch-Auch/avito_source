package com.google.common.collect;

import a2.j.d.c.c5;
import a2.j.d.c.x;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public final class Lists {

    public static class a<E> extends AbstractList<E> {
        public final List<E> a;

        public a(List<E> list) {
            this.a = (List) Preconditions.checkNotNull(list);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, E e) {
            this.a.add(i, e);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i, Collection<? extends E> collection) {
            return this.a.addAll(i, collection);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return this.a.contains(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            return this.a.get(i);
        }

        @Override // java.util.AbstractList, java.util.List
        public E remove(int i) {
            return this.a.remove(i);
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int i, E e) {
            return this.a.set(i, e);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.a.size();
        }
    }

    public static final class b extends AbstractList<Character> {
        public final CharSequence a;

        public b(CharSequence charSequence) {
            this.a = charSequence;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            Preconditions.checkElementIndex(i, size());
            return Character.valueOf(this.a.charAt(i));
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.a.length();
        }
    }

    public static class c<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        @NullableDecl
        public final E a;
        public final E[] b;

        public c(@NullableDecl E e, E[] eArr) {
            this.a = e;
            this.b = (E[]) ((Object[]) Preconditions.checkNotNull(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            Preconditions.checkElementIndex(i, size());
            return i == 0 ? this.a : this.b[i - 1];
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return IntMath.saturatedAdd(this.b.length, 1);
        }
    }

    public static class d<T> extends AbstractList<List<T>> {
        public final List<T> a;
        public final int b;

        public d(List<T> list, int i) {
            this.a = list;
            this.b = i;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            Preconditions.checkElementIndex(i, size());
            int i2 = this.b;
            int i3 = i * i2;
            return this.a.subList(i3, Math.min(i2 + i3, this.a.size()));
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return IntMath.divide(this.a.size(), this.b, RoundingMode.CEILING);
        }
    }

    public static class e<E> extends a<E> implements RandomAccess {
        public e(List<E> list) {
            super(list);
        }
    }

    public static class f<T> extends d<T> implements RandomAccess {
        public f(List<T> list, int i) {
            super(list, i);
        }
    }

    public static class g<T> extends h<T> implements RandomAccess {
        public g(List<T> list) {
            super(list);
        }
    }

    public static class h<T> extends AbstractList<T> {
        public final List<T> a;

        public class a implements ListIterator<T> {
            public boolean a;
            public final /* synthetic */ ListIterator b;

            public a(ListIterator listIterator) {
                this.b = listIterator;
            }

            @Override // java.util.ListIterator
            public void add(T t) {
                this.b.add(t);
                this.b.previous();
                this.a = false;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.b.hasPrevious();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.b.hasNext();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public T next() {
                if (hasNext()) {
                    this.a = true;
                    return (T) this.b.previous();
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                h hVar = h.this;
                int nextIndex = this.b.nextIndex();
                int size = hVar.size();
                Preconditions.checkPositionIndex(nextIndex, size);
                return size - nextIndex;
            }

            @Override // java.util.ListIterator
            public T previous() {
                if (hasPrevious()) {
                    this.a = true;
                    return (T) this.b.next();
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return nextIndex() - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                Preconditions.checkState(this.a, "no calls to next() since the last call to remove()");
                this.b.remove();
                this.a = false;
            }

            @Override // java.util.ListIterator
            public void set(T t) {
                Preconditions.checkState(this.a);
                this.b.set(t);
            }
        }

        public h(List<T> list) {
            this.a = (List) Preconditions.checkNotNull(list);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, @NullableDecl T t) {
            List<T> list = this.a;
            int size = size();
            Preconditions.checkPositionIndex(i, size);
            list.add(size - i, t);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            List<T> list = this.a;
            int size = size();
            Preconditions.checkElementIndex(i, size);
            return list.get((size - 1) - i);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i) {
            int size = size();
            Preconditions.checkPositionIndex(i, size);
            return new a(this.a.listIterator(size - i));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i) {
            List<T> list = this.a;
            int size = size();
            Preconditions.checkElementIndex(i, size);
            return list.remove((size - 1) - i);
        }

        @Override // java.util.AbstractList
        public void removeRange(int i, int i2) {
            subList(i, i2).clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T set(int i, @NullableDecl T t) {
            List<T> list = this.a;
            int size = size();
            Preconditions.checkElementIndex(i, size);
            return list.set((size - 1) - i, t);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.a.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            List<T> list = this.a;
            int size = size();
            Preconditions.checkPositionIndex(i2, size);
            int i3 = size - i2;
            int size2 = size();
            Preconditions.checkPositionIndex(i, size2);
            return Lists.reverse(list.subList(i3, size2 - i));
        }
    }

    public static final class i extends ImmutableList<Character> {
        public final String c;

        public i(String str) {
            this.c = str;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean e() {
            return false;
        }

        @Override // java.util.List
        public Object get(int i) {
            Preconditions.checkElementIndex(i, size());
            return Character.valueOf(this.c.charAt(i));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@NullableDecl Object obj) {
            if (obj instanceof Character) {
                return this.c.indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@NullableDecl Object obj) {
            if (obj instanceof Character) {
                return this.c.lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.c.length();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<Character> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            return Lists.charactersOf(this.c.substring(i, i2));
        }
    }

    public static class j<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final List<F> a;
        public final Function<? super F, ? extends T> b;

        public class a extends c5<F, T> {
            public a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // a2.j.d.c.b5
            public T a(F f) {
                return (T) j.this.b.apply(f);
            }
        }

        public j(List<F> list, Function<? super F, ? extends T> function) {
            this.a = (List) Preconditions.checkNotNull(list);
            this.b = (Function) Preconditions.checkNotNull(function);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            return (T) this.b.apply(this.a.get(i));
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i) {
            return new a(this.a.listIterator(i));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i) {
            return (T) this.b.apply(this.a.remove(i));
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.a.size();
        }
    }

    public static class k<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        public final List<F> a;
        public final Function<? super F, ? extends T> b;

        public class a extends c5<F, T> {
            public a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // a2.j.d.c.b5
            public T a(F f) {
                return (T) k.this.b.apply(f);
            }
        }

        public k(List<F> list, Function<? super F, ? extends T> function) {
            this.a = (List) Preconditions.checkNotNull(list);
            this.b = (Function) Preconditions.checkNotNull(function);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractSequentialList, java.util.List, java.util.AbstractList
        public ListIterator<T> listIterator(int i) {
            return new a(this.a.listIterator(i));
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.a.size();
        }
    }

    public static class l<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        @NullableDecl
        public final E a;
        @NullableDecl
        public final E b;
        public final E[] c;

        public l(@NullableDecl E e, @NullableDecl E e2, E[] eArr) {
            this.a = e;
            this.b = e2;
            this.c = (E[]) ((Object[]) Preconditions.checkNotNull(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            if (i == 0) {
                return this.a;
            }
            if (i == 1) {
                return this.b;
            }
            Preconditions.checkElementIndex(i, size());
            return this.c[i - 2];
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return IntMath.saturatedAdd(this.c.length, 2);
        }
    }

    @VisibleForTesting
    public static int a(int i2) {
        AppCompatDelegateImpl.i.z(i2, "arraySize");
        return Ints.saturatedCast(((long) i2) + 5 + ((long) (i2 / 10)));
    }

    public static <E> List<E> asList(@NullableDecl E e2, E[] eArr) {
        return new c(e2, eArr);
    }

    public static boolean b(List<?> list, @NullableDecl Object obj) {
        if (obj == Preconditions.checkNotNull(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.elementsEqual(list.iterator(), list2.iterator());
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (!Objects.equal(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public static int c(List<?> list, @NullableDecl Object obj) {
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            if (obj == null) {
                while (i2 < size) {
                    if (list.get(i2) != null) {
                        i2++;
                    }
                }
                return -1;
            }
            while (i2 < size) {
                if (!obj.equals(list.get(i2))) {
                    i2++;
                }
            }
            return -1;
            return i2;
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (Objects.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public static <B> List<List<B>> cartesianProduct(List<? extends List<? extends B>> list) {
        int i2 = x.c;
        ImmutableList.Builder builder = new ImmutableList.Builder(list.size());
        Iterator<? extends List<? extends B>> it = list.iterator();
        while (it.hasNext()) {
            ImmutableList copyOf = ImmutableList.copyOf((Collection) ((List) it.next()));
            if (copyOf.isEmpty()) {
                return ImmutableList.of();
            }
            builder.add((ImmutableList.Builder) copyOf);
        }
        return new x(builder.build());
    }

    public static ImmutableList<Character> charactersOf(String str) {
        return new i((String) Preconditions.checkNotNull(str));
    }

    public static int d(List<?> list, @NullableDecl Object obj) {
        if (!(list instanceof RandomAccess)) {
            ListIterator<?> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (Objects.equal(obj, listIterator.previous())) {
                    return listIterator.nextIndex();
                }
            }
            return -1;
        } else if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        } else {
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                if (obj.equals(list.get(size2))) {
                    return size2;
                }
            }
            return -1;
        }
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayListWithCapacity(int i2) {
        AppCompatDelegateImpl.i.z(i2, "initialArraySize");
        return new ArrayList<>(i2);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayListWithExpectedSize(int i2) {
        return new ArrayList<>(a(i2));
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<>();
    }

    public static <T> List<List<T>> partition(List<T> list, int i2) {
        Preconditions.checkNotNull(list);
        Preconditions.checkArgument(i2 > 0);
        return list instanceof RandomAccess ? new f(list, i2) : new d(list, i2);
    }

    public static <T> List<T> reverse(List<T> list) {
        if (list instanceof ImmutableList) {
            return ((ImmutableList) list).reverse();
        }
        if (list instanceof h) {
            return ((h) list).a;
        }
        if (list instanceof RandomAccess) {
            return new g(list);
        }
        return new h(list);
    }

    public static <F, T> List<T> transform(List<F> list, Function<? super F, ? extends T> function) {
        return list instanceof RandomAccess ? new j(list, function) : new k(list, function);
    }

    public static <E> List<E> asList(@NullableDecl E e2, @NullableDecl E e3, E[] eArr) {
        return new l(e2, e3, eArr);
    }

    @Beta
    public static List<Character> charactersOf(CharSequence charSequence) {
        return new b((CharSequence) Preconditions.checkNotNull(charSequence));
    }

    @SafeVarargs
    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(E... eArr) {
        Preconditions.checkNotNull(eArr);
        ArrayList<E> arrayList = new ArrayList<>(a(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList(Iterable<? extends E> iterable) {
        Collection collection;
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            collection = newArrayList(iterable);
        }
        return new CopyOnWriteArrayList<>(collection);
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> newLinkedList(Iterable<? extends E> iterable) {
        LinkedList<E> newLinkedList = newLinkedList();
        Iterables.addAll(newLinkedList, iterable);
        return newLinkedList;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList<>((Collection) iterable);
        }
        return newArrayList(iterable.iterator());
    }

    @SafeVarargs
    public static <B> List<List<B>> cartesianProduct(List<? extends B>... listArr) {
        return cartesianProduct(Arrays.asList(listArr));
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(Iterator<? extends E> it) {
        ArrayList<E> newArrayList = newArrayList();
        Iterators.addAll(newArrayList, it);
        return newArrayList;
    }
}
