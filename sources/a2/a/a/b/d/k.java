package a2.a.a.b.d;

import com.avito.android.authorization.login.LoginPresenterImpl;
import com.avito.android.authorization.login.LoginView;
import io.reactivex.functions.Action;
public final class k implements Action {
    public final /* synthetic */ LoginPresenterImpl a;

    public k(LoginPresenterImpl loginPresenterImpl) {
        this.a = loginPresenterImpl;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        LoginView loginView = this.a.i;
        if (loginView != null) {
            loginView.hideProgress();
        }
    }
}
