package a2.a.a.b.d;

import com.avito.android.authorization.login.LoginPresenterImpl;
import com.avito.android.authorization.login.LoginView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class a<T> implements Consumer<Disposable> {
    public final /* synthetic */ LoginPresenterImpl.c a;

    public a(LoginPresenterImpl.c cVar) {
        this.a = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        LoginView loginView = this.a.a.i;
        if (loginView != null) {
            loginView.hideKeyboard();
        }
        LoginView loginView2 = this.a.a.i;
        if (loginView2 != null) {
            loginView2.showProgress();
        }
    }
}
