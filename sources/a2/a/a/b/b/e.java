package a2.a.a.b.b;

import com.avito.android.authorization.auth.AuthPresenterImpl;
import com.avito.android.authorization.smart_lock.NeedResolveResultException;
import io.reactivex.rxjava3.functions.Consumer;
public final class e<T> implements Consumer<Throwable> {
    public final /* synthetic */ AuthPresenterImpl.c a;

    public e(AuthPresenterImpl.c cVar) {
        this.a = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        if (th2 instanceof NeedResolveResultException) {
            this.a.b.resolveResult(((NeedResolveResultException) th2).getResult());
        }
    }
}
