package a2.j.d.c;

import com.google.common.annotations.VisibleForTesting;
import java.util.Collection;
import java.util.Iterator;
@VisibleForTesting
public class h4<E> extends r4 implements Collection<E> {
    private static final long serialVersionUID = 0;

    public h4(Collection collection, Object obj, b4 b4Var) {
        super(collection, obj);
    }

    @Override // java.util.Collection
    public boolean add(E e) {
        boolean add;
        synchronized (this.b) {
            add = d().add(e);
        }
        return add;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        boolean addAll;
        synchronized (this.b) {
            addAll = d().addAll(collection);
        }
        return addAll;
    }

    @Override // java.util.Collection
    public void clear() {
        synchronized (this.b) {
            d().clear();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        boolean contains;
        synchronized (this.b) {
            contains = d().contains(obj);
        }
        return contains;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this.b) {
            containsAll = d().containsAll(collection);
        }
        return containsAll;
    }

    public Collection<E> d() {
        return (Collection) this.a;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.b) {
            isEmpty = d().isEmpty();
        }
        return isEmpty;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return d().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        boolean remove;
        synchronized (this.b) {
            remove = d().remove(obj);
        }
        return remove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.b) {
            removeAll = d().removeAll(collection);
        }
        return removeAll;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.b) {
            retainAll = d().retainAll(collection);
        }
        return retainAll;
    }

    @Override // java.util.Collection
    public int size() {
        int size;
        synchronized (this.b) {
            size = d().size();
        }
        return size;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        Object[] array;
        synchronized (this.b) {
            array = d().toArray();
        }
        return array;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        T[] tArr2;
        synchronized (this.b) {
            tArr2 = (T[]) d().toArray(tArr);
        }
        return tArr2;
    }
}
