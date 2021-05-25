package r6.a.b.g;

import hu.akarnokd.rxjava3.functions.Consumer3;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.functions.Action;
public final class d<T1, T2, T3> extends a {
    public final Consumer3<T1, T2, T3> b;
    public final Action c;
    public final l<T1> d;
    public final l<T2> e;
    public final l<T3> f;

    public d(l<T1> lVar, l<T2> lVar2, l<T3> lVar3, Consumer3<T1, T2, T3> consumer3, Action action) {
        this.b = consumer3;
        this.c = action;
        this.d = lVar;
        this.e = lVar2;
        this.f = lVar3;
        this.a.put(lVar, lVar);
        this.a.put(lVar2, lVar2);
        this.a.put(lVar3, lVar3);
    }

    @Override // r6.a.b.g.a
    public void b() throws Throwable {
        if (!this.d.e.isEmpty() && !this.e.e.isEmpty() && !this.f.e.isEmpty()) {
            Notification<T> peek = this.d.e.peek();
            Notification<T> peek2 = this.e.e.peek();
            Notification<T> peek3 = this.f.e.peek();
            if (peek.isOnComplete() || peek2.isOnComplete() || peek3.isOnComplete()) {
                this.c.run();
                return;
            }
            a();
            this.b.accept(peek.getValue(), peek2.getValue(), peek3.getValue());
        }
    }
}
