package a2.j.d.c;

import com.google.common.collect.Multiset;
import java.util.Iterator;
public final class q2 extends b5<Multiset.Entry<E>, E> {
    public q2(Iterator it) {
        super(it);
    }

    @Override // a2.j.d.c.b5
    public Object a(Object obj) {
        return ((Multiset.Entry) obj).getElement();
    }
}
