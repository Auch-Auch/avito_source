package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import java.util.Queue;
@GwtCompatible
public class h0<T> extends AbstractIterator<T> {
    public final Queue<T> c;

    public h0(Queue<T> queue) {
        this.c = (Queue) Preconditions.checkNotNull(queue);
    }

    @Override // com.google.common.collect.AbstractIterator
    public T computeNext() {
        return this.c.isEmpty() ? endOfData() : this.c.remove();
    }
}
