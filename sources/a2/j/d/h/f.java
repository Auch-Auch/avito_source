package a2.j.d.h;

import com.google.common.collect.AbstractIterator;
import com.google.common.io.CharSource;
import java.util.Iterator;
public class f extends AbstractIterator<String> {
    public Iterator<String> c;
    public final /* synthetic */ CharSource.b d;

    public f(CharSource.b bVar) {
        this.d = bVar;
        this.c = CharSource.b.b.split(bVar.a).iterator();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.common.collect.AbstractIterator
    public String computeNext() {
        if (this.c.hasNext()) {
            String next = this.c.next();
            if (this.c.hasNext() || !next.isEmpty()) {
                return next;
            }
        }
        return (String) endOfData();
    }
}
