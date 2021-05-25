package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
@GwtCompatible(emulated = true, serializable = true)
public abstract class d1<E> extends ImmutableList<E> {

    @GwtIncompatible
    public static class a implements Serializable {
        private static final long serialVersionUID = 0;
        public final ImmutableCollection<?> a;

        public a(ImmutableCollection<?> immutableCollection) {
            this.a = immutableCollection;
        }

        public Object readResolve() {
            return this.a.asList();
        }
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return j().contains(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean e() {
        return j().e();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return j().isEmpty();
    }

    public abstract ImmutableCollection<E> j();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return j().size();
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new a(j());
    }
}
