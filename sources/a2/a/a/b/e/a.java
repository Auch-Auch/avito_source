package a2.a.a.b.e;

import com.avito.android.authorization.login_protection.LoginProtectionListPresenterImpl;
import com.avito.android.authorization.login_protection.LoginProtectionPhoneListView;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<Disposable> {
    public final /* synthetic */ LoginProtectionListPresenterImpl a;

    public a(LoginProtectionListPresenterImpl loginProtectionListPresenterImpl) {
        this.a = loginProtectionListPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        LoginProtectionPhoneListView loginProtectionPhoneListView = this.a.a;
        if (loginProtectionPhoneListView != null) {
            loginProtectionPhoneListView.showProgress();
        }
    }
}
