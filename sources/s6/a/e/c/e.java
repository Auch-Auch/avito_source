package s6.a.e.c;

import a2.b.a.a.a;
import io.reactivex.rxjava3.annotations.NonNull;
public final class e extends d<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    public e(Runnable runnable) {
        super(runnable);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // s6.a.e.c.d
    public void a(@NonNull Runnable runnable) {
        runnable.run();
    }

    @Override // java.util.concurrent.atomic.AtomicReference, java.lang.Object
    public String toString() {
        StringBuilder L = a.L("RunnableDisposable(disposed=");
        L.append(isDisposed());
        L.append(", ");
        L.append(get());
        L.append(")");
        return L.toString();
    }
}
