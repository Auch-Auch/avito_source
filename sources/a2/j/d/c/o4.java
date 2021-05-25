package a2.j.d.c;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.collect.Multiset;
import java.util.Collection;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class o4<E> extends h4<E> implements Multiset<E> {
    private static final long serialVersionUID = 0;
    @MonotonicNonNullDecl
    public transient Set<E> c;
    @MonotonicNonNullDecl
    public transient Set<Multiset.Entry<E>> d;

    public o4(Multiset<E> multiset, @NullableDecl Object obj) {
        super(multiset, obj, null);
    }

    @Override // com.google.common.collect.Multiset
    public int add(E e, int i) {
        int add;
        synchronized (this.b) {
            add = d().add(e, i);
        }
        return add;
    }

    @Override // com.google.common.collect.Multiset
    public int count(Object obj) {
        int count;
        synchronized (this.b) {
            count = d().count(obj);
        }
        return count;
    }

    /* renamed from: e */
    public Multiset<E> d() {
        return (Multiset) ((Collection) this.a);
    }

    @Override // com.google.common.collect.Multiset
    /* renamed from: elementSet */
    public Set<E> mo6elementSet() {
        Set<E> set;
        synchronized (this.b) {
            if (this.c == null) {
                this.c = AppCompatDelegateImpl.i.c(d().mo6elementSet(), this.b);
            }
            set = this.c;
        }
        return set;
    }

    @Override // com.google.common.collect.Multiset
    public Set<Multiset.Entry<E>> entrySet() {
        Set<Multiset.Entry<E>> set;
        synchronized (this.b) {
            if (this.d == null) {
                this.d = AppCompatDelegateImpl.i.c(d().entrySet(), this.b);
            }
            set = this.d;
        }
        return set;
    }

    @Override // java.lang.Object, java.util.Collection, com.google.common.collect.Multiset
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

    @Override // java.lang.Object, java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        int hashCode;
        synchronized (this.b) {
            hashCode = d().hashCode();
        }
        return hashCode;
    }

    @Override // com.google.common.collect.Multiset
    public int remove(Object obj, int i) {
        int remove;
        synchronized (this.b) {
            remove = d().remove(obj, i);
        }
        return remove;
    }

    @Override // com.google.common.collect.Multiset
    public int setCount(E e, int i) {
        int count;
        synchronized (this.b) {
            count = d().setCount(e, i);
        }
        return count;
    }

    @Override // com.google.common.collect.Multiset
    public boolean setCount(E e, int i, int i2) {
        boolean count;
        synchronized (this.b) {
            count = d().setCount(e, i, i2);
        }
        return count;
    }
}
