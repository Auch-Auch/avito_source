package a2.j.d.f;

import com.google.common.base.Predicate;
import com.google.common.graph.AbstractNetwork;
public class g implements Predicate<E> {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ AbstractNetwork c;

    public g(AbstractNetwork abstractNetwork, Object obj, Object obj2) {
        this.c = abstractNetwork;
        this.a = obj;
        this.b = obj2;
    }

    @Override // com.google.common.base.Predicate
    public boolean apply(E e) {
        return this.c.incidentNodes(e).adjacentNode(this.a).equals(this.b);
    }
}
