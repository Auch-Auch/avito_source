package a2.a.a.b.d;

import com.avito.android.authorization.login.LoginPresenterImpl;
import com.avito.android.authorization.smart_lock.NeedResolveResultException;
import io.reactivex.functions.Consumer;
public final class e<T> implements Consumer<Throwable> {
    public final /* synthetic */ LoginPresenterImpl.c a;

    public e(LoginPresenterImpl.c cVar) {
        this.a = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        if (th2 instanceof NeedResolveResultException) {
            this.a.b.resolveResult(((NeedResolveResultException) th2).getResult());
        } else {
            this.a.b.completeLogin();
        }
    }
}
