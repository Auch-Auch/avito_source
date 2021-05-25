package a2.j.d.f;

import a2.j.d.f.r;
import com.google.common.collect.AbstractIterator;
import java.util.Iterator;
import java.util.Map;
public class q extends AbstractIterator<N> {
    public final /* synthetic */ Iterator c;

    public q(r.a aVar, Iterator it) {
        this.c = it;
    }

    @Override // com.google.common.collect.AbstractIterator
    public N computeNext() {
        boolean z;
        while (this.c.hasNext()) {
            Map.Entry entry = (Map.Entry) this.c.next();
            Object value = entry.getValue();
            if (value == r.d || (value instanceof r.c)) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                return (N) entry.getKey();
            }
        }
        return (N) endOfData();
    }
}
