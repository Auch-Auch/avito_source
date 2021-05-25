package a2.j.d.f;

import com.google.common.collect.AbstractIterator;
import java.util.Iterator;
import java.util.Map;
public class k0 extends AbstractIterator<E> {
    public final /* synthetic */ Iterator c;
    public final /* synthetic */ l0 d;

    public k0(l0 l0Var, Iterator it) {
        this.d = l0Var;
        this.c = it;
    }

    @Override // com.google.common.collect.AbstractIterator
    public E computeNext() {
        while (this.c.hasNext()) {
            Map.Entry entry = (Map.Entry) this.c.next();
            if (this.d.b.equals(entry.getValue())) {
                return (E) entry.getKey();
            }
        }
        return (E) endOfData();
    }
}
