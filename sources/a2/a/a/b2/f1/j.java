package a2.a.a.b2.f1;

import com.avito.android.authorization.smart_lock.NeedResolveResultException;
import com.avito.android.profile.password_change.PasswordChangePresenter;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class j<T> implements Consumer<Throwable> {
    public final /* synthetic */ k a;

    public j(k kVar) {
        this.a = kVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        if (th2 instanceof NeedResolveResultException) {
            PasswordChangePresenter.Router router = this.a.a.b;
            if (router != null) {
                router.resolveSaveResult(((NeedResolveResultException) th2).getResult());
                return;
            }
            return;
        }
        Logs.error(th2);
        k kVar = this.a;
        kVar.a.a(kVar.b);
    }
}
