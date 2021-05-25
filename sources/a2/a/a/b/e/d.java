package a2.a.a.b.e;

import com.avito.android.authorization.login_protection.LoginProtectionListPresenterImpl;
import com.avito.android.authorization.login_protection.LoginProtectionPhoneListView;
import io.reactivex.rxjava3.functions.Consumer;
public final class d<T> implements Consumer<Throwable> {
    public final /* synthetic */ LoginProtectionListPresenterImpl a;

    public d(LoginProtectionListPresenterImpl loginProtectionListPresenterImpl) {
        this.a = loginProtectionListPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.avito.android.util.ErrorFormatter */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        LoginProtectionPhoneListView loginProtectionPhoneListView = this.a.a;
        if (loginProtectionPhoneListView != null) {
            loginProtectionPhoneListView.showSnackbar(this.a.n.format(th2));
        }
    }
}
