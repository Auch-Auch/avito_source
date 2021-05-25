package a2.j.d.f;

import a2.j.d.f.r;
import com.google.common.collect.AbstractIterator;
import java.util.Iterator;
import java.util.Map;
public class s extends AbstractIterator<N> {
    public final /* synthetic */ Iterator c;

    public s(r.b bVar, Iterator it) {
        this.c = it;
    }

    @Override // com.google.common.collect.AbstractIterator
    public N computeNext() {
        boolean z;
        while (this.c.hasNext()) {
            Map.Entry entry = (Map.Entry) this.c.next();
            Object value = entry.getValue();
            if (value == r.d || value == null) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                return (N) entry.getKey();
            }
        }
        return (N) endOfData();
    }
}
