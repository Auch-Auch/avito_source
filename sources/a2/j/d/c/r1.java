package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
@GwtCompatible(emulated = true)
public abstract class r1<E> extends ImmutableSet<E> {

    public class a extends ImmutableList<E> {
        public a() {
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean e() {
            return r1.this.e();
        }

        @Override // java.util.List
        public E get(int i) {
            return (E) r1.this.get(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return r1.this.size();
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public int a(Object[] objArr, int i) {
        return asList().a(objArr, i);
    }

    public abstract E get(int i);

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<E> i() {
        return new a();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: iterator */
    public UnmodifiableIterator<E> mo99iterator() {
        return asList().mo99iterator();
    }
}
