package a2.a.a.b.d;

import com.avito.android.authorization.login.LoginPresenterImpl;
import com.avito.android.authorization.login.LoginView;
import io.reactivex.functions.Action;
public final class b implements Action {
    public final /* synthetic */ LoginPresenterImpl.c a;

    public b(LoginPresenterImpl.c cVar) {
        this.a = cVar;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        LoginView loginView = this.a.a.i;
        if (loginView != null) {
            loginView.hideProgress();
        }
    }
}
