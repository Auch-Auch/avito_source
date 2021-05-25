package r6.a.b.g;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public final class k extends a {
    public final Consumer<? super Object[]> b;
    public final Action c;
    public final List<l<? extends Object>> d;

    public k(List<l<? extends Object>> list, Consumer<? super Object[]> consumer, Action action) {
        this.b = consumer;
        this.c = action;
        ArrayList arrayList = new ArrayList(list);
        this.d = arrayList;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            this.a.put(lVar, lVar);
        }
    }

    @Override // r6.a.b.g.a
    public void b() throws Throwable {
        Object[] objArr = new Object[this.d.size()];
        int i = 0;
        int i2 = 0;
        for (l<? extends Object> lVar : this.d) {
            if (!lVar.e.isEmpty()) {
                Notification<T> peek = lVar.e.peek();
                if (peek.isOnComplete()) {
                    i++;
                }
                objArr[i2] = peek.getValue();
                i2++;
            } else {
                return;
            }
        }
        if (i == i2) {
            this.c.run();
            return;
        }
        a();
        this.b.accept(objArr);
    }
}
