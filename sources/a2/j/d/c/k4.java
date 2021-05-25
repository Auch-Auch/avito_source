package a2.j.d.c;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class k4<E> extends h4<E> implements List<E> {
    private static final long serialVersionUID = 0;

    public k4(List<E> list, @NullableDecl Object obj) {
        super(list, obj, null);
    }

    @Override // java.util.List
    public void add(int i, E e) {
        synchronized (this.b) {
            d().add(i, e);
        }
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        boolean addAll;
        synchronized (this.b) {
            addAll = d().addAll(i, collection);
        }
        return addAll;
    }

    /* renamed from: e */
    public List<E> d() {
        return (List) ((Collection) this.a);
    }

    @Override // java.lang.Object, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        boolean equals;
        if (obj == this) {
            return true;
        }
        synchronized (this.b) {
            equals = d().equals(obj);
        }
        return equals;
    }

    @Override // java.util.List
    public E get(int i) {
        E e;
        synchronized (this.b) {
            e = d().get(i);
        }
        return e;
    }

    @Override // java.lang.Object, java.util.Collection, java.util.List
    public int hashCode() {
        int hashCode;
        synchronized (this.b) {
            hashCode = d().hashCode();
        }
        return hashCode;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        int indexOf;
        synchronized (this.b) {
            indexOf = d().indexOf(obj);
        }
        return indexOf;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        int lastIndexOf;
        synchronized (this.b) {
            lastIndexOf = d().lastIndexOf(obj);
        }
        return lastIndexOf;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return d().listIterator();
    }

    @Override // java.util.List
    public E remove(int i) {
        E remove;
        synchronized (this.b) {
            remove = d().remove(i);
        }
        return remove;
    }

    @Override // java.util.List
    public E set(int i, E e) {
        E e2;
        synchronized (this.b) {
            e2 = d().set(i, e);
        }
        return e2;
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        List<E> t4Var;
        synchronized (this.b) {
            List<E> subList = d().subList(i, i2);
            Object obj = this.b;
            t4Var = subList instanceof RandomAccess ? new t4<>(subList, obj) : new k4<>(subList, obj);
        }
        return t4Var;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return d().listIterator(i);
    }
}
