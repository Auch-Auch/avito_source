package s6.a.b;

import a2.b.a.a.a;
import io.reactivex.annotations.NonNull;
public final class d extends c<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    public d(Runnable runnable) {
        super(runnable);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // s6.a.b.c
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
