package kotlin.collections.builders;

import a2.g.r.g;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0012\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005:\u0001\u0013BO\b\u0002\u0012\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000G\u0012\u0006\u0010P\u001a\u00020\t\u0012\u0006\u0010R\u001a\u00020\t\u0012\u0006\u0010T\u001a\u00020\u001a\u0012\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0004\bU\u0010VB\t\b\u0016¢\u0006\u0004\bU\u0010\bB\u0011\b\u0016\u0012\u0006\u0010W\u001a\u00020\t¢\u0006\u0004\bU\u0010XJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\rJ5\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001aH\u0016¢\u0006\u0004\b!\u0010\"J\u0018\u0010$\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\tH\u0002¢\u0006\u0004\b$\u0010\u0016J \u0010%\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b)\u0010(J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000*H\u0002¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0016¢\u0006\u0004\b.\u0010/J\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000-2\u0006\u0010#\u001a\u00020\tH\u0016¢\u0006\u0004\b.\u00100J\u0017\u00101\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b1\u00102J\u001f\u00101\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b1\u0010\u0010J\u001d\u00103\u001a\u00020\u001a2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b3\u00104J%\u00103\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b3\u00105J\u000f\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u0010\bJ\u0017\u00107\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\tH\u0016¢\u0006\u0004\b7\u0010\u0016J\u0017\u00108\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b8\u00102J\u001d\u00109\u001a\u00020\u001a2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b9\u00104J\u001d\u0010:\u001a\u00020\u001a2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b:\u00104J%\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\tH\u0016¢\u0006\u0004\b=\u0010>J\u001a\u0010A\u001a\u00020\u001a2\b\u0010@\u001a\u0004\u0018\u00010?H\u0002¢\u0006\u0004\bA\u00102J\u000f\u0010B\u001a\u00020\tH\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bE\u0010FR\u001c\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010HR\u0016\u0010K\u001a\u00020\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010CR\u001e\u0010M\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010LR\u0016\u0010P\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u001e\u0010Q\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010LR\u0016\u0010R\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010OR\u0016\u0010T\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010S¨\u0006Y"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "", "d", "()V", "", "i", "n", "e", "(II)V", "element", "c", "(ILjava/lang/Object;)V", "", MessengerShareContentUtility.ELEMENTS, AuthSource.SEND_ABUSE, "(ILjava/util/Collection;I)V", "f", "(I)Ljava/lang/Object;", "rangeOffset", "rangeLength", g.a, "", "retain", "h", "(IILjava/util/Collection;Z)I", "", "build", "()Ljava/util/List;", "isEmpty", "()Z", FirebaseAnalytics.Param.INDEX, "get", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "iterator", "()Ljava/util/Iterator;", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", ProductAction.ACTION_ADD, "(Ljava/lang/Object;)Z", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "clear", "removeAt", ProductAction.ACTION_REMOVE, "removeAll", "retainAll", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "", "other", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "[Ljava/lang/Object;", "array", "getSize", "size", "Lkotlin/collections/builders/ListBuilder;", "root", AuthSource.BOOKING_ORDER, "I", "offset", "backing", "length", "Z", "isReadOnly", "<init>", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "initialCapacity", "(I)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, KMutableList {
    public E[] a;
    public int b;
    public int c;
    public boolean d;
    public final ListBuilder<E> e;
    public final ListBuilder<E> f;

    public static final class a<E> implements ListIterator<E>, KMutableListIterator {
        public final ListBuilder<E> a;
        public int b;
        public int c = -1;

        public a(@NotNull ListBuilder<E> listBuilder, int i) {
            Intrinsics.checkNotNullParameter(listBuilder, "list");
            this.a = listBuilder;
            this.b = i;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            ListBuilder<E> listBuilder = this.a;
            int i = this.b;
            this.b = i + 1;
            listBuilder.add(i, e);
            this.c = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.c;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.b < this.a.c) {
                int i = this.b;
                this.b = i + 1;
                this.c = i;
                return (E) this.a.a[this.a.b + this.c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.b;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i = this.b;
            if (i > 0) {
                int i2 = i - 1;
                this.b = i2;
                this.c = i2;
                return (E) this.a.a[this.a.b + this.c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i = this.c;
            if (i != -1) {
                this.a.remove(i);
                this.b = this.c;
                this.c = -1;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            int i = this.c;
            if (i != -1) {
                this.a.set(i, e);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    public ListBuilder(E[] eArr, int i, int i2, boolean z, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.a = eArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = listBuilder;
        this.f = listBuilder2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: E[] */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(int i, Collection<? extends E> collection, int i2) {
        ListBuilder<E> listBuilder = this.e;
        if (listBuilder != null) {
            listBuilder.a(i, collection, i2);
            this.a = this.e.a;
            this.c += i2;
            return;
        }
        e(i, i2);
        Iterator<? extends E> it = collection.iterator();
        for (int i3 = 0; i3 < i2; i3++) {
            this.a[i + i3] = it.next();
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean add(E e2) {
        d();
        c(this.b + this.c, e2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        d();
        int size = collection.size();
        a(this.b + this.c, collection, size);
        return size > 0;
    }

    @NotNull
    public final List<E> build() {
        if (this.e == null) {
            d();
            this.d = true;
            return this;
        }
        throw new IllegalStateException();
    }

    public final void c(int i, E e2) {
        ListBuilder<E> listBuilder = this.e;
        if (listBuilder != null) {
            listBuilder.c(i, e2);
            this.a = this.e.a;
            this.c++;
            return;
        }
        e(i, 1);
        this.a[i] = e2;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public void clear() {
        d();
        g(this.b, this.c);
    }

    public final void d() {
        ListBuilder<E> listBuilder;
        if (this.d || ((listBuilder = this.f) != null && listBuilder.d)) {
            throw new UnsupportedOperationException();
        }
    }

    public final void e(int i, int i2) {
        int i3 = this.c + i2;
        if (this.e == null) {
            E[] eArr = this.a;
            if (i3 > eArr.length) {
                this.a = (E[]) ListBuilderKt.copyOfUninitializedElements(this.a, ArrayDeque.Companion.newCapacity$kotlin_stdlib(eArr.length, i3));
            }
            E[] eArr2 = this.a;
            ArraysKt___ArraysJvmKt.copyInto(eArr2, eArr2, i + i2, i, this.b + this.c);
            this.c += i2;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (obj != this) {
            if (obj instanceof List) {
                if (ListBuilderKt.access$subarrayContentEquals(this.a, this.b, this.c, (List) obj)) {
                }
            }
            return false;
        }
        return true;
    }

    public final E f(int i) {
        ListBuilder<E> listBuilder = this.e;
        if (listBuilder != null) {
            this.c--;
            return listBuilder.f(i);
        }
        E[] eArr = this.a;
        E e2 = eArr[i];
        ArraysKt___ArraysJvmKt.copyInto(eArr, eArr, i, i + 1, this.b + this.c);
        ListBuilderKt.resetAt(this.a, (this.b + this.c) - 1);
        this.c--;
        return e2;
    }

    public final void g(int i, int i2) {
        ListBuilder<E> listBuilder = this.e;
        if (listBuilder != null) {
            listBuilder.g(i, i2);
        } else {
            E[] eArr = this.a;
            ArraysKt___ArraysJvmKt.copyInto(eArr, eArr, i, i + i2, this.c);
            E[] eArr2 = this.a;
            int i3 = this.c;
            ListBuilderKt.resetRange(eArr2, i3 - i2, i3);
        }
        this.c -= i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, this.c);
        return this.a[this.b + i];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.c;
    }

    public final int h(int i, int i2, Collection<? extends E> collection, boolean z) {
        ListBuilder<E> listBuilder = this.e;
        if (listBuilder != null) {
            int h = listBuilder.h(i, i2, collection, z);
            this.c -= h;
            return h;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.a[i5]) == z) {
                E[] eArr = this.a;
                i3++;
                eArr[i4 + i] = eArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        E[] eArr2 = this.a;
        ArraysKt___ArraysJvmKt.copyInto(eArr2, eArr2, i + i4, i2 + i, this.c);
        E[] eArr3 = this.a;
        int i7 = this.c;
        ListBuilderKt.resetRange(eArr3, i7 - i6, i7);
        this.c -= i6;
        return i6;
    }

    @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public int hashCode() {
        return ListBuilderKt.access$subarrayContentHashCode(this.a, this.b, this.c);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i = 0; i < this.c; i++) {
            if (Intrinsics.areEqual(this.a[this.b + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.c == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<E> iterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i = this.c - 1; i >= 0; i--) {
            if (Intrinsics.areEqual(this.a[this.b + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        d();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        return indexOf >= 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Collection<? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        d();
        return h(this.b, this.c, collection, false) > 0;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int i) {
        d();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, this.c);
        return f(this.b + i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Collection<? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        d();
        return h(this.b, this.c, collection, true) > 0;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int i, E e2) {
        d();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, this.c);
        E[] eArr = this.a;
        int i2 = this.b;
        E e3 = eArr[i2 + i];
        eArr[i2 + i] = e2;
        return e3;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public List<E> subList(int i, int i2) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, this.c);
        E[] eArr = this.a;
        int i3 = this.b + i;
        int i4 = i2 - i;
        boolean z = this.d;
        ListBuilder<E> listBuilder = this.f;
        return new ListBuilder(eArr, i3, i4, z, this, listBuilder != null ? listBuilder : this);
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    @NotNull
    public String toString() {
        return ListBuilderKt.access$subarrayContentToString(this.a, this.b, this.c);
    }

    public ListBuilder() {
        this(10);
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator(int i) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, this.c);
        return new a(this, i);
    }

    public ListBuilder(int i) {
        this.a = (E[]) ListBuilderKt.arrayOfUninitializedElements(i);
        this.b = 0;
        this.c = 0;
        this.d = false;
        this.e = null;
        this.f = null;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i, E e2) {
        d();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, this.c);
        c(this.b + i, e2);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, @NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        d();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, this.c);
        int size = collection.size();
        a(this.b + i, collection, size);
        return size > 0;
    }
}
