package r6.a.b.g;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
public final class c<T1, T2> extends a {
    public final BiConsumer<T1, T2> b;
    public final Action c;
    public final l<T1> d;
    public final l<T2> e;

    public c(l<T1> lVar, l<T2> lVar2, BiConsumer<T1, T2> biConsumer, Action action) {
        this.b = biConsumer;
        this.c = action;
        this.d = lVar;
        this.e = lVar2;
        this.a.put(lVar, lVar);
        this.a.put(lVar2, lVar2);
    }

    @Override // r6.a.b.g.a
    public void b() throws Throwable {
        if (!this.d.e.isEmpty() && !this.e.e.isEmpty()) {
            Notification<T> peek = this.d.e.peek();
            Notification<T> peek2 = this.e.e.peek();
            if (peek.isOnComplete() || peek2.isOnComplete()) {
                this.c.run();
                return;
            }
            a();
            this.b.accept(peek.getValue(), peek2.getValue());
        }
    }
}
