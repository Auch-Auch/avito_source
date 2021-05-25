package r6.a.a.f;

import hu.akarnokd.rxjava2.functions.Consumer8;
import io.reactivex.Notification;
import io.reactivex.functions.Action;
public final class i<T1, T2, T3, T4, T5, T6, T7, T8> extends a {
    public final Consumer8<T1, T2, T3, T4, T5, T6, T7, T8> b;
    public final Action c;
    public final l<T1> d;
    public final l<T2> e;
    public final l<T3> f;
    public final l<T4> g;
    public final l<T5> h;
    public final l<T6> i;
    public final l<T7> j;
    public final l<T8> k;

    public i(l<T1> lVar, l<T2> lVar2, l<T3> lVar3, l<T4> lVar4, l<T5> lVar5, l<T6> lVar6, l<T7> lVar7, l<T8> lVar8, Consumer8<T1, T2, T3, T4, T5, T6, T7, T8> consumer8, Action action) {
        this.b = consumer8;
        this.c = action;
        this.d = lVar;
        this.e = lVar2;
        this.f = lVar3;
        this.g = lVar4;
        this.h = lVar5;
        this.i = lVar6;
        this.j = lVar7;
        this.k = lVar8;
        this.a.put(lVar, lVar);
        this.a.put(lVar2, lVar2);
        this.a.put(lVar3, lVar3);
        this.a.put(lVar4, lVar4);
        this.a.put(lVar5, lVar5);
        this.a.put(lVar6, lVar6);
        this.a.put(lVar7, lVar7);
        this.a.put(lVar8, lVar8);
    }

    @Override // r6.a.a.f.a
    public void b() throws Exception {
        if (!this.d.e.isEmpty() && !this.e.e.isEmpty() && !this.f.e.isEmpty() && !this.g.e.isEmpty() && !this.h.e.isEmpty() && !this.i.e.isEmpty() && !this.j.e.isEmpty() && !this.k.e.isEmpty()) {
            Notification<T> peek = this.d.e.peek();
            Notification<T> peek2 = this.e.e.peek();
            Notification<T> peek3 = this.f.e.peek();
            Notification<T> peek4 = this.g.e.peek();
            Notification<T> peek5 = this.h.e.peek();
            Notification<T> peek6 = this.i.e.peek();
            Notification<T> peek7 = this.j.e.peek();
            Notification<T> peek8 = this.k.e.peek();
            if (peek.isOnComplete() || peek2.isOnComplete() || peek3.isOnComplete() || peek4.isOnComplete() || peek5.isOnComplete() || peek6.isOnComplete() || peek7.isOnComplete() || peek8.isOnComplete()) {
                this.c.run();
                return;
            }
            a();
            this.b.accept(peek.getValue(), peek2.getValue(), peek3.getValue(), peek4.getValue(), peek5.getValue(), peek6.getValue(), peek7.getValue(), peek8.getValue());
        }
    }
}
