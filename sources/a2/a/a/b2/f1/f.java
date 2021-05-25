package a2.a.a.b2.f1;

import com.avito.android.authorization.smart_lock.NeedResolveResultException;
import com.avito.android.profile.password_change.PasswordChangePresenter;
import com.avito.android.profile.password_change.PasswordChangeView;
import io.reactivex.functions.Consumer;
public final class f<T> implements Consumer<Throwable> {
    public final /* synthetic */ g a;

    public f(g gVar) {
        this.a = gVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        PasswordChangeView passwordChangeView;
        Throwable th2 = th;
        if (th2 instanceof NeedResolveResultException) {
            PasswordChangePresenter.Router router = this.a.a.b;
            if (router != null) {
                router.resolveLoadingResult(((NeedResolveResultException) th2).getResult());
            }
        } else if (!this.a.a.t.isSessionsFlow() && (passwordChangeView = this.a.a.a) != null) {
            passwordChangeView.highlightOldPassword();
        }
    }
}
