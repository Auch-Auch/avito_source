package com.bluejamesbond.text;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
public class ConcurrentModifiableLinkedList<E> extends AbstractSequentialList<E> implements List<E>, Cloneable, Serializable {
    public static final /* synthetic */ int c = 0;
    private static final long serialVersionUID = 876323262645176354L;
    public transient c<E> a;
    public transient int b;

    public class b implements Iterator {
        public final ConcurrentModifiableLinkedList<E>.d a;

        public b(a aVar) {
            this.a = new d(ConcurrentModifiableLinkedList.this.size());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasPrevious();
        }

        @Override // java.util.Iterator
        public E next() {
            return (E) this.a.previous();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.a.remove();
        }
    }

    public static class c<E> {
        public E a;
        public c<E> b;
        public c<E> c;

        public c(E e, c<E> cVar, c<E> cVar2) {
            this.a = e;
            this.b = cVar;
            this.c = cVar2;
        }
    }

    public class d implements ListIterator<E> {
        public c<E> a;
        public int b;
        public c<E> c;

        public d(int i) {
            int i2;
            c<E> cVar = ConcurrentModifiableLinkedList.this.a;
            this.c = cVar;
            if (i < 0 || i > (i2 = ConcurrentModifiableLinkedList.this.b)) {
                StringBuilder M = a2.b.a.a.a.M("Index: ", i, ", Size: ");
                M.append(ConcurrentModifiableLinkedList.this.b);
                throw new IndexOutOfBoundsException(M.toString());
            } else if (i < (i2 >> 1)) {
                this.a = cVar.b;
                int i3 = 0;
                while (true) {
                    this.b = i3;
                    int i4 = this.b;
                    if (i4 < i) {
                        this.a = this.a.b;
                        i3 = i4 + 1;
                    } else {
                        return;
                    }
                }
            } else {
                this.a = cVar;
                this.b = i2;
                while (true) {
                    int i5 = this.b;
                    if (i5 > i) {
                        this.a = this.a.c;
                        this.b = i5 - 1;
                    } else {
                        return;
                    }
                }
            }
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            ConcurrentModifiableLinkedList concurrentModifiableLinkedList = ConcurrentModifiableLinkedList.this;
            this.c = concurrentModifiableLinkedList.a;
            concurrentModifiableLinkedList.a(e, this.a);
            this.b++;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.b != ConcurrentModifiableLinkedList.this.b;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.b != 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            int i = this.b;
            if (i != ConcurrentModifiableLinkedList.this.b) {
                c<E> cVar = this.a;
                this.c = cVar;
                this.a = cVar.b;
                this.b = i + 1;
                return cVar.a;
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
            if (i != 0) {
                c<E> cVar = this.a.c;
                this.a = cVar;
                this.c = cVar;
                this.b = i - 1;
                return cVar.a;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            c<E> cVar = this.c;
            c<E> cVar2 = cVar.b;
            try {
                ConcurrentModifiableLinkedList concurrentModifiableLinkedList = ConcurrentModifiableLinkedList.this;
                int i = ConcurrentModifiableLinkedList.c;
                concurrentModifiableLinkedList.c(cVar);
                if (this.a == this.c) {
                    this.a = cVar2;
                } else {
                    this.b--;
                }
                this.c = ConcurrentModifiableLinkedList.this.a;
            } catch (NoSuchElementException unused) {
                throw new IllegalStateException();
            }
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            c<E> cVar = this.c;
            if (cVar != ConcurrentModifiableLinkedList.this.a) {
                cVar.a = e;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public ConcurrentModifiableLinkedList() {
        c<E> cVar = new c<>(null, null, null);
        this.a = cVar;
        this.b = 0;
        cVar.c = cVar;
        cVar.b = cVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bluejamesbond.text.ConcurrentModifiableLinkedList<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        c<E> cVar = new c<>(null, null, null);
        this.a = cVar;
        cVar.c = cVar;
        cVar.b = cVar;
        for (int i = 0; i < readInt; i++) {
            a(objectInputStream.readObject(), this.a);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.b);
        c<E> cVar = this.a;
        while (true) {
            cVar = cVar.b;
            if (cVar != this.a) {
                objectOutputStream.writeObject(cVar.a);
            } else {
                return;
            }
        }
    }

    public final c<E> a(E e, c<E> cVar) {
        c<E> cVar2 = new c<>(e, cVar, cVar.c);
        cVar2.c.b = cVar2;
        cVar2.b.c = cVar2;
        this.b++;
        ((AbstractSequentialList) this).modCount++;
        return cVar2;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(E e) {
        a(e, this.a);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        return addAll(this.b, collection);
    }

    public void addFirst(E e) {
        a(e, this.a.b);
    }

    public void addLast(E e) {
        a(e, this.a);
    }

    public final c<E> b(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.b)) {
            StringBuilder M = a2.b.a.a.a.M("Index: ", i, ", Size: ");
            M.append(this.b);
            throw new IndexOutOfBoundsException(M.toString());
        }
        c<E> cVar = this.a;
        if (i < (i2 >> 1)) {
            for (int i3 = 0; i3 <= i; i3++) {
                cVar = cVar.b;
            }
        } else {
            while (i2 > i) {
                cVar = cVar.c;
                i2--;
            }
        }
        return cVar;
    }

    public final E c(c<E> cVar) {
        if (cVar != this.a) {
            E e = cVar.a;
            c<E> cVar2 = cVar.c;
            cVar2.b = cVar.b;
            cVar.b.c = cVar2;
            cVar.c = null;
            cVar.b = null;
            cVar.a = null;
            this.b--;
            ((AbstractSequentialList) this).modCount++;
            return e;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public void clear() {
        c<E> cVar = this.a.b;
        while (true) {
            c<E> cVar2 = this.a;
            if (cVar != cVar2) {
                c<E> cVar3 = cVar.b;
                cVar.c = null;
                cVar.b = null;
                cVar.a = null;
                cVar = cVar3;
            } else {
                cVar2.c = cVar2;
                cVar2.b = cVar2;
                this.b = 0;
                ((AbstractSequentialList) this).modCount++;
                return;
            }
        }
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            ConcurrentModifiableLinkedList concurrentModifiableLinkedList = (ConcurrentModifiableLinkedList) super.clone();
            c<E> cVar = new c<>(null, null, null);
            concurrentModifiableLinkedList.a = cVar;
            cVar.c = cVar;
            cVar.b = cVar;
            concurrentModifiableLinkedList.b = 0;
            ((AbstractSequentialList) concurrentModifiableLinkedList).modCount = 0;
            c<E> cVar2 = this.a;
            while (true) {
                cVar2 = cVar2.b;
                if (cVar2 == this.a) {
                    return concurrentModifiableLinkedList;
                }
                concurrentModifiableLinkedList.add(cVar2.a);
            }
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public Iterator<E> descendingIterator() {
        return new b(null);
    }

    public E element() {
        return getFirst();
    }

    @Override // java.util.AbstractSequentialList, java.util.List, java.util.AbstractList
    public E get(int i) {
        return b(i).a;
    }

    public E getFirst() {
        if (this.b != 0) {
            return this.a.b.a;
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        if (this.b != 0) {
            return this.a.c.a;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.List, java.util.AbstractList
    public int indexOf(Object obj) {
        int i = 0;
        if (obj == null) {
            c<E> cVar = this.a;
            while (true) {
                cVar = cVar.b;
                if (cVar == this.a) {
                    return -1;
                }
                if (cVar.a == null) {
                    return i;
                }
                i++;
            }
        } else {
            c<E> cVar2 = this.a;
            while (true) {
                cVar2 = cVar2.b;
                if (cVar2 == this.a) {
                    return -1;
                }
                if (obj.equals(cVar2.a)) {
                    return i;
                }
                i++;
            }
        }
    }

    @Override // java.util.List, java.util.AbstractList
    public int lastIndexOf(Object obj) {
        int i = this.b;
        if (obj == null) {
            c<E> cVar = this.a;
            do {
                cVar = cVar.c;
                if (cVar != this.a) {
                    i--;
                }
            } while (cVar.a != null);
            return i;
        }
        c<E> cVar2 = this.a;
        do {
            cVar2 = cVar2.c;
            if (cVar2 != this.a) {
                i--;
            }
        } while (!obj.equals(cVar2.a));
        return i;
        return -1;
    }

    @Override // java.util.AbstractSequentialList, java.util.List, java.util.AbstractList
    public ListIterator<E> listIterator(int i) {
        return new d(i);
    }

    public boolean offer(E e) {
        return add(e);
    }

    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    public E peek() {
        if (this.b == 0) {
            return null;
        }
        return getFirst();
    }

    public E peekFirst() {
        if (this.b == 0) {
            return null;
        }
        return getFirst();
    }

    public E peekLast() {
        if (this.b == 0) {
            return null;
        }
        return getLast();
    }

    public E poll() {
        if (this.b == 0) {
            return null;
        }
        return removeFirst();
    }

    public E pollFirst() {
        if (this.b == 0) {
            return null;
        }
        return removeFirst();
    }

    public E pollLast() {
        if (this.b == 0) {
            return null;
        }
        return removeLast();
    }

    public E pop() {
        return removeFirst();
    }

    public void push(E e) {
        addFirst(e);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        if (obj == null) {
            c<E> cVar = this.a;
            do {
                cVar = cVar.b;
                if (cVar == this.a) {
                    return false;
                }
            } while (cVar.a != null);
            c(cVar);
            return true;
        }
        c<E> cVar2 = this.a;
        do {
            cVar2 = cVar2.b;
            if (cVar2 == this.a) {
                return false;
            }
        } while (!obj.equals(cVar2.a));
        c(cVar2);
        return true;
    }

    public E removeFirst() {
        return c(this.a.b);
    }

    public boolean removeFirstOccurrence(Object obj) {
        return remove(obj);
    }

    public E removeLast() {
        return c(this.a.c);
    }

    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            c<E> cVar = this.a;
            do {
                cVar = cVar.c;
                if (cVar == this.a) {
                    return false;
                }
            } while (cVar.a != null);
            c(cVar);
            return true;
        }
        c<E> cVar2 = this.a;
        do {
            cVar2 = cVar2.c;
            if (cVar2 == this.a) {
                return false;
            }
        } while (!obj.equals(cVar2.a));
        c(cVar2);
        return true;
    }

    @Override // java.util.AbstractSequentialList, java.util.List, java.util.AbstractList
    public E set(int i, E e) {
        c<E> b2 = b(i);
        E e2 = b2.a;
        b2.a = e;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.b;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public Object[] toArray() {
        Object[] objArr = new Object[this.b];
        c<E> cVar = this.a.b;
        int i = 0;
        while (cVar != this.a) {
            objArr[i] = cVar.a;
            cVar = cVar.b;
            i++;
        }
        return objArr;
    }

    @Override // java.util.AbstractSequentialList, java.util.List, java.util.AbstractList
    public void add(int i, E e) {
        a(e, i == this.b ? this.a : b(i));
    }

    @Override // java.util.AbstractSequentialList, java.util.List, java.util.AbstractList
    public boolean addAll(int i, Collection<? extends E> collection) {
        if (i < 0 || i > this.b) {
            StringBuilder M = a2.b.a.a.a.M("Index: ", i, ", Size: ");
            M.append(this.b);
            throw new IndexOutOfBoundsException(M.toString());
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int i2 = 0;
        if (length == 0) {
            return false;
        }
        ((AbstractSequentialList) this).modCount++;
        c<E> b2 = i == this.b ? this.a : b(i);
        c<E> cVar = b2.c;
        while (i2 < length) {
            c<E> cVar2 = new c<>(array[i2], b2, cVar);
            cVar.b = cVar2;
            i2++;
            cVar = cVar2;
        }
        b2.c = cVar;
        this.b += length;
        return true;
    }

    public ConcurrentModifiableLinkedList(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v9, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.b) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.b));
        }
        int i = 0;
        c<E> cVar = this.a.b;
        while (cVar != this.a) {
            tArr[i] = cVar.a;
            cVar = cVar.b;
            i++;
        }
        int length = tArr.length;
        int i2 = this.b;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    @Override // java.util.AbstractSequentialList, java.util.List, java.util.AbstractList
    public E remove(int i) {
        return c(b(i));
    }

    public E remove() {
        return removeFirst();
    }
}
