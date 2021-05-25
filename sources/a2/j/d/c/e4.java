package a2.j.d.c;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class e4<K, V> extends u4<Map.Entry<K, Collection<V>>> {
    private static final long serialVersionUID = 0;

    public class a extends b5<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>> {
        public a(Iterator it) {
            super(it);
        }

        @Override // a2.j.d.c.b5
        public Object a(Object obj) {
            return new d4(this, (Map.Entry) obj);
        }
    }

    public e4(Set<Map.Entry<K, Collection<V>>> set, @NullableDecl Object obj) {
        super(set, obj);
    }

    @Override // a2.j.d.c.h4, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        boolean z;
        synchronized (this.b) {
            Set<E> e = d();
            if (!(obj instanceof Map.Entry)) {
                z = false;
            } else {
                z = e.contains(Maps.n((Map.Entry) obj));
            }
        }
        return z;
    }

    @Override // a2.j.d.c.h4, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        boolean b;
        synchronized (this.b) {
            b = Collections2.b(d(), collection);
        }
        return b;
    }

    @Override // a2.j.d.c.u4, java.lang.Object, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        boolean a3;
        if (obj == this) {
            return true;
        }
        synchronized (this.b) {
            a3 = Sets.a(d(), obj);
        }
        return a3;
    }

    @Override // a2.j.d.c.h4, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, Collection<V>>> iterator() {
        return new a(super.iterator());
    }

    @Override // a2.j.d.c.h4, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        boolean z;
        synchronized (this.b) {
            Set<E> e = d();
            if (!(obj instanceof Map.Entry)) {
                z = false;
            } else {
                z = e.remove(Maps.n((Map.Entry) obj));
            }
        }
        return z;
    }

    @Override // a2.j.d.c.h4, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.b) {
            removeAll = Iterators.removeAll(d().iterator(), collection);
        }
        return removeAll;
    }

    @Override // a2.j.d.c.h4, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.b) {
            retainAll = Iterators.retainAll(d().iterator(), collection);
        }
        return retainAll;
    }

    @Override // a2.j.d.c.h4, java.util.Collection, java.util.Set
    public Object[] toArray() {
        Object[] objArr;
        synchronized (this.b) {
            Set<E> e = d();
            objArr = new Object[e.size()];
            ObjectArrays.c(e, objArr);
        }
        return objArr;
    }

    @Override // a2.j.d.c.h4, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        T[] tArr2;
        synchronized (this.b) {
            tArr2 = (T[]) ObjectArrays.d(d(), tArr);
        }
        return tArr2;
    }
}
