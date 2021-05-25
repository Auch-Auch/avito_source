package r6.a.a.f;

import hu.akarnokd.rxjava2.functions.Consumer5;
import io.reactivex.Notification;
import io.reactivex.functions.Action;
public final class f<T1, T2, T3, T4, T5> extends a {
    public final Consumer5<T1, T2, T3, T4, T5> b;
    public final Action c;
    public final l<T1> d;
    public final l<T2> e;
    public final l<T3> f;
    public final l<T4> g;
    public final l<T5> h;

    public f(l<T1> lVar, l<T2> lVar2, l<T3> lVar3, l<T4> lVar4, l<T5> lVar5, Consumer5<T1, T2, T3, T4, T5> consumer5, Action action) {
        this.b = consumer5;
        this.c = action;
        this.d = lVar;
        this.e = lVar2;
        this.f = lVar3;
        this.g = lVar4;
        this.h = lVar5;
        this.a.put(lVar, lVar);
        this.a.put(lVar2, lVar2);
        this.a.put(lVar3, lVar3);
        this.a.put(lVar4, lVar4);
        this.a.put(lVar5, lVar5);
    }

    @Override // r6.a.a.f.a
    public void b() throws Exception {
        if (!this.d.e.isEmpty() && !this.e.e.isEmpty() && !this.f.e.isEmpty() && !this.g.e.isEmpty() && !this.h.e.isEmpty()) {
            Notification<T> peek = this.d.e.peek();
            Notification<T> peek2 = this.e.e.peek();
            Notification<T> peek3 = this.f.e.peek();
            Notification<T> peek4 = this.g.e.peek();
            Notification<T> peek5 = this.h.e.peek();
            if (peek.isOnComplete() || peek2.isOnComplete() || peek3.isOnComplete() || peek4.isOnComplete() || peek5.isOnComplete()) {
                this.c.run();
                return;
            }
            a();
            this.b.accept(peek.getValue(), peek2.getValue(), peek3.getValue(), peek4.getValue(), peek5.getValue());
        }
    }
}
