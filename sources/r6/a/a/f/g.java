package r6.a.a.f;

import hu.akarnokd.rxjava2.functions.Consumer6;
import io.reactivex.Notification;
import io.reactivex.functions.Action;
public final class g<T1, T2, T3, T4, T5, T6> extends a {
    public final Consumer6<T1, T2, T3, T4, T5, T6> b;
    public final Action c;
    public final l<T1> d;
    public final l<T2> e;
    public final l<T3> f;
    public final l<T4> g;
    public final l<T5> h;
    public final l<T6> i;

    public g(l<T1> lVar, l<T2> lVar2, l<T3> lVar3, l<T4> lVar4, l<T5> lVar5, l<T6> lVar6, Consumer6<T1, T2, T3, T4, T5, T6> consumer6, Action action) {
        this.b = consumer6;
        this.c = action;
        this.d = lVar;
        this.e = lVar2;
        this.f = lVar3;
        this.g = lVar4;
        this.h = lVar5;
        this.i = lVar6;
        this.a.put(lVar, lVar);
        this.a.put(lVar2, lVar2);
        this.a.put(lVar3, lVar3);
        this.a.put(lVar4, lVar4);
        this.a.put(lVar5, lVar5);
        this.a.put(lVar6, lVar6);
    }

    @Override // r6.a.a.f.a
    public void b() throws Exception {
        if (!this.d.e.isEmpty() && !this.e.e.isEmpty() && !this.f.e.isEmpty() && !this.g.e.isEmpty() && !this.h.e.isEmpty() && !this.i.e.isEmpty()) {
            Notification<T> peek = this.d.e.peek();
            Notification<T> peek2 = this.e.e.peek();
            Notification<T> peek3 = this.f.e.peek();
            Notification<T> peek4 = this.g.e.peek();
            Notification<T> peek5 = this.h.e.peek();
            Notification<T> peek6 = this.i.e.peek();
            if (peek.isOnComplete() || peek2.isOnComplete() || peek3.isOnComplete() || peek4.isOnComplete() || peek5.isOnComplete() || peek6.isOnComplete()) {
                this.c.run();
                return;
            }
            a();
            this.b.accept(peek.getValue(), peek2.getValue(), peek3.getValue(), peek4.getValue(), peek5.getValue(), peek6.getValue());
        }
    }
}
