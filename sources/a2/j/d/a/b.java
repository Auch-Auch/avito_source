package a2.j.d.a;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class b<T> implements Iterator<T> {
    public a a = a.NOT_READY;
    @NullableDecl
    public T b;

    public enum a {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public abstract T a();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        a aVar = this.a;
        a aVar2 = a.FAILED;
        Preconditions.checkState(aVar != aVar2);
        int ordinal = this.a.ordinal();
        if (ordinal == 0) {
            return true;
        }
        if (ordinal == 2) {
            return false;
        }
        this.a = aVar2;
        this.b = a();
        if (this.a == a.DONE) {
            return false;
        }
        this.a = a.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.a = a.NOT_READY;
            T t = this.b;
            this.b = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
