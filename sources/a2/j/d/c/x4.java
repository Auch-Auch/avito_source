package a2.j.d.c;

import java.util.Comparator;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class x4<E> extends u4<E> implements SortedSet<E> {
    private static final long serialVersionUID = 0;

    public x4(SortedSet<E> sortedSet, @NullableDecl Object obj) {
        super(sortedSet, obj);
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator;
        synchronized (this.b) {
            comparator = e().comparator();
        }
        return comparator;
    }

    /* renamed from: f */
    public SortedSet<E> e() {
        return (SortedSet) super.d();
    }

    @Override // java.util.SortedSet
    public E first() {
        E first;
        synchronized (this.b) {
            first = e().first();
        }
        return first;
    }

    @Override // java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> headSet(E e) {
        x4 x4Var;
        synchronized (this.b) {
            x4Var = new x4(e().headSet(e), this.b);
        }
        return x4Var;
    }

    @Override // java.util.SortedSet
    public E last() {
        E last;
        synchronized (this.b) {
            last = e().last();
        }
        return last;
    }

    @Override // java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> subSet(E e, E e2) {
        x4 x4Var;
        synchronized (this.b) {
            x4Var = new x4(e().subSet(e, e2), this.b);
        }
        return x4Var;
    }

    @Override // java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> tailSet(E e) {
        x4 x4Var;
        synchronized (this.b) {
            x4Var = new x4(e().tailSet(e), this.b);
        }
        return x4Var;
    }
}
