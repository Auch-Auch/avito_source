package r6.a.a.f;

import io.reactivex.Notification;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
public final class b<T1> extends a {
    public final Consumer<T1> b;
    public final Action c;
    public final l<T1> d;

    public b(l<T1> lVar, Consumer<T1> consumer, Action action) {
        this.b = consumer;
        this.c = action;
        this.d = lVar;
        this.a.put(lVar, lVar);
    }

    @Override // r6.a.a.f.a
    public void b() throws Exception {
        if (!this.d.e.isEmpty()) {
            Notification<T> peek = this.d.e.peek();
            if (peek.isOnComplete()) {
                this.c.run();
                return;
            }
            a();
            this.b.accept(peek.getValue());
        }
    }
}
