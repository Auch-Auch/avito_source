package a2.j.d.c;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
public final class u1 extends UnmodifiableIterator<List<T>> {
    public final /* synthetic */ Iterator a;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean c;

    public u1(Iterator it, int i, boolean z) {
        this.a = it;
        this.b = i;
        this.c = z;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        if (hasNext()) {
            Object[] objArr = new Object[this.b];
            int i = 0;
            while (i < this.b && this.a.hasNext()) {
                objArr[i] = this.a.next();
                i++;
            }
            for (int i2 = i; i2 < this.b; i2++) {
                objArr[i2] = null;
            }
            List unmodifiableList = Collections.unmodifiableList(Arrays.asList(objArr));
            return (this.c || i == this.b) ? unmodifiableList : unmodifiableList.subList(0, i);
        }
        throw new NoSuchElementException();
    }
}
