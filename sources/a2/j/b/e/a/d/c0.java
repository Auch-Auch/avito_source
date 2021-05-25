package a2.j.b.e.a.d;

import java.lang.ref.Reference;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
public final class c0 extends y {
    public final a0 a = new a0();

    @Override // a2.j.b.e.a.d.y
    public final void a(Throwable th, Throwable th2) {
        List<Throwable> putIfAbsent;
        if (th2 != th) {
            Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
            a0 a0Var = this.a;
            while (true) {
                Reference<? extends Throwable> poll = a0Var.b.poll();
                if (poll == null) {
                    break;
                }
                a0Var.a.remove(poll);
            }
            List<Throwable> list = a0Var.a.get(new z(th, null));
            if (list == null && (putIfAbsent = a0Var.a.putIfAbsent(new z(th, a0Var.b), (list = new Vector<>(2)))) != null) {
                list = putIfAbsent;
            }
            list.add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
