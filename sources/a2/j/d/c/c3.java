package a2.j.d.c;

import a2.j.d.c.v2;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true, serializable = true)
public class c3<E> extends ImmutableMultiset<E> {
    public static final c3<Object> h = new c3<>(new v2());
    public final transient v2<E> e;
    public final transient int f;
    @LazyInit
    public transient ImmutableSet<E> g;

    public final class b extends r1<E> {
        public b(a aVar) {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return c3.this.contains(obj);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean e() {
            return true;
        }

        @Override // a2.j.d.c.r1
        public E get(int i) {
            v2<E> v2Var = c3.this.e;
            Preconditions.checkElementIndex(i, v2Var.c);
            return (E) v2Var.a[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return c3.this.e.c;
        }
    }

    @GwtIncompatible
    public static class c implements Serializable {
        private static final long serialVersionUID = 0;
        public final Object[] a;
        public final int[] b;

        public c(Multiset<?> multiset) {
            int size = multiset.entrySet().size();
            this.a = new Object[size];
            this.b = new int[size];
            int i = 0;
            for (Multiset.Entry<?> entry : multiset.entrySet()) {
                this.a[i] = entry.getElement();
                this.b[i] = entry.getCount();
                i++;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableMultiset$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        public Object readResolve() {
            ImmutableMultiset.Builder builder = new ImmutableMultiset.Builder(this.a.length);
            int i = 0;
            while (true) {
                Object[] objArr = this.a;
                if (i >= objArr.length) {
                    return builder.build();
                }
                builder.addCopies(objArr[i], this.b[i]);
                i++;
            }
        }
    }

    public c3(v2<E> v2Var) {
        this.e = v2Var;
        long j = 0;
        for (int i = 0; i < v2Var.c; i++) {
            j += (long) v2Var.g(i);
        }
        this.f = Ints.saturatedCast(j);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        return this.e.d(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean e() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public Multiset.Entry<E> h(int i) {
        v2<E> v2Var = this.e;
        Preconditions.checkElementIndex(i, v2Var.c);
        return new v2.a(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return this.f;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new c(this);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    /* renamed from: elementSet */
    public ImmutableSet<E> mo6elementSet() {
        ImmutableSet<E> immutableSet = this.g;
        if (immutableSet != null) {
            return immutableSet;
        }
        b bVar = new b(null);
        this.g = bVar;
        return bVar;
    }
}
