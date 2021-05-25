package s6.a.e.c;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
public final class a extends d<Action> {
    private static final long serialVersionUID = -8219729196779211169L;

    public a(Action action) {
        super(action);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // s6.a.e.c.d
    public void a(@NonNull Action action) {
        try {
            action.run();
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference, java.lang.Object
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("ActionDisposable(disposed=");
        L.append(isDisposed());
        L.append(", ");
        L.append(get());
        L.append(")");
        return L.toString();
    }
}
