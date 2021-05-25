package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Iterator;
@GwtCompatible
public abstract class b5<F, T> implements Iterator<T> {
    public final Iterator<? extends F> a;

    public b5(Iterator<? extends F> it) {
        this.a = (Iterator) Preconditions.checkNotNull(it);
    }

    public abstract T a(F f);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: a2.j.d.c.b5<F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Iterator
    public final T next() {
        return (T) a(this.a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.a.remove();
    }
}
