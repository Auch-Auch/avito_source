package a2.j.d.c;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@VisibleForTesting
@GwtIncompatible
public class q4<E> extends x4<E> implements NavigableSet<E> {
    private static final long serialVersionUID = 0;
    @MonotonicNonNullDecl
    public transient NavigableSet<E> c;

    public q4(NavigableSet<E> navigableSet, @NullableDecl Object obj) {
        super(navigableSet, obj);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e) {
        E ceiling;
        synchronized (this.b) {
            ceiling = f().ceiling(e);
        }
        return ceiling;
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return f().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        synchronized (this.b) {
            NavigableSet<E> navigableSet = this.c;
            if (navigableSet != null) {
                return navigableSet;
            }
            q4 q4Var = new q4(f().descendingSet(), this.b);
            this.c = q4Var;
            return q4Var;
        }
    }

    @Override // java.util.NavigableSet
    public E floor(E e) {
        E floor;
        synchronized (this.b) {
            floor = f().floor(e);
        }
        return floor;
    }

    /* renamed from: h */
    public NavigableSet<E> f() {
        return (NavigableSet) super.e();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e, boolean z) {
        q4 q4Var;
        synchronized (this.b) {
            q4Var = new q4(f().headSet(e, z), this.b);
        }
        return q4Var;
    }

    @Override // java.util.NavigableSet
    public E higher(E e) {
        E higher;
        synchronized (this.b) {
            higher = f().higher(e);
        }
        return higher;
    }

    @Override // java.util.NavigableSet
    public E lower(E e) {
        E lower;
        synchronized (this.b) {
            lower = f().lower(e);
        }
        return lower;
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        E pollFirst;
        synchronized (this.b) {
            pollFirst = f().pollFirst();
        }
        return pollFirst;
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        E pollLast;
        synchronized (this.b) {
            pollLast = f().pollLast();
        }
        return pollLast;
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        q4 q4Var;
        synchronized (this.b) {
            q4Var = new q4(f().subSet(e, z, e2, z2), this.b);
        }
        return q4Var;
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e, boolean z) {
        q4 q4Var;
        synchronized (this.b) {
            q4Var = new q4(f().tailSet(e, z), this.b);
        }
        return q4Var;
    }

    @Override // a2.j.d.c.x4, java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> headSet(E e) {
        return headSet(e, false);
    }

    @Override // a2.j.d.c.x4, java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> subSet(E e, E e2) {
        return subSet(e, true, e2, false);
    }

    @Override // a2.j.d.c.x4, java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> tailSet(E e) {
        return tailSet(e, true);
    }
}
