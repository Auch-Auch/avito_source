package r6.a.b.g;

import hu.akarnokd.rxjava3.functions.Consumer7;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.functions.Action;
public final class h<T1, T2, T3, T4, T5, T6, T7> extends a {
    public final Consumer7<T1, T2, T3, T4, T5, T6, T7> b;
    public final Action c;
    public final l<T1> d;
    public final l<T2> e;
    public final l<T3> f;
    public final l<T4> g;
    public final l<T5> h;
    public final l<T6> i;
    public final l<T7> j;

    public h(l<T1> lVar, l<T2> lVar2, l<T3> lVar3, l<T4> lVar4, l<T5> lVar5, l<T6> lVar6, l<T7> lVar7, Consumer7<T1, T2, T3, T4, T5, T6, T7> consumer7, Action action) {
        this.b = consumer7;
        this.c = action;
        this.d = lVar;
        this.e = lVar2;
        this.f = lVar3;
        this.g = lVar4;
        this.h = lVar5;
        this.i = lVar6;
        this.j = lVar7;
        this.a.put(lVar, lVar);
        this.a.put(lVar2, lVar2);
        this.a.put(lVar3, lVar3);
        this.a.put(lVar4, lVar4);
        this.a.put(lVar5, lVar5);
        this.a.put(lVar6, lVar6);
        this.a.put(lVar7, lVar7);
    }

    @Override // r6.a.b.g.a
    public void b() throws Throwable {
        if (!this.d.e.isEmpty() && !this.e.e.isEmpty() && !this.f.e.isEmpty() && !this.g.e.isEmpty() && !this.h.e.isEmpty() && !this.i.e.isEmpty() && !this.j.e.isEmpty()) {
            Notification<T> peek = this.d.e.peek();
            Notification<T> peek2 = this.e.e.peek();
            Notification<T> peek3 = this.f.e.peek();
            Notification<T> peek4 = this.g.e.peek();
            Notification<T> peek5 = this.h.e.peek();
            Notification<T> peek6 = this.i.e.peek();
            Notification<T> peek7 = this.j.e.peek();
            if (peek.isOnComplete() || peek2.isOnComplete() || peek3.isOnComplete() || peek4.isOnComplete() || peek5.isOnComplete() || peek6.isOnComplete() || peek7.isOnComplete()) {
                this.c.run();
                return;
            }
            a();
            this.b.accept(peek.getValue(), peek2.getValue(), peek3.getValue(), peek4.getValue(), peek5.getValue(), peek6.getValue(), peek7.getValue());
        }
    }
}
