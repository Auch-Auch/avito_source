package a2.j.d.c;

import com.google.common.collect.UnmodifiableIterator;
import java.util.NoSuchElementException;
public final class t1 extends UnmodifiableIterator<T> {
    public int a = 0;
    public final /* synthetic */ Object[] b;

    public t1(Object[] objArr) {
        this.b = objArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.b.length;
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            Object[] objArr = this.b;
            int i = this.a;
            T t = (T) objArr[i];
            objArr[i] = null;
            this.a = i + 1;
            return t;
        }
        throw new NoSuchElementException();
    }
}
