package a2.a.a.b.e;

import com.avito.android.authorization.login_protection.LoginProtectionListPresenterImpl;
import com.avito.android.authorization.login_protection.LoginProtectionPhoneListView;
import io.reactivex.rxjava3.functions.Action;
public final class b implements Action {
    public final /* synthetic */ LoginProtectionListPresenterImpl a;

    public b(LoginProtectionListPresenterImpl loginProtectionListPresenterImpl) {
        this.a = loginProtectionListPresenterImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        LoginProtectionPhoneListView loginProtectionPhoneListView = this.a.a;
        if (loginProtectionPhoneListView != null) {
            loginProtectionPhoneListView.hideProgress();
        }
    }
}
