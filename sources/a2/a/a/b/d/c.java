package a2.a.a.b.d;

import com.avito.android.authorization.login.LoginPresenterImpl;
import com.avito.android.authorization.login.LoginView;
import io.reactivex.functions.Consumer;
public final class c<T> implements Consumer<Throwable> {
    public final /* synthetic */ LoginPresenterImpl.c a;

    public c(LoginPresenterImpl.c cVar) {
        this.a = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        LoginView loginView = this.a.a.i;
        if (loginView != null) {
            loginView.hideProgress();
        }
    }
}
