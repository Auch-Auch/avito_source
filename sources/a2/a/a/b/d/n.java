package a2.a.a.b.d;

import com.avito.android.authorization.login.LoginPresenter;
import com.avito.android.authorization.login.LoginPresenterImpl;
import com.avito.android.authorization.login.LoginView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Action;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class n extends Lambda implements Function0<Unit> {
    public final /* synthetic */ LoginPresenterImpl a;
    public final /* synthetic */ Action b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(LoginPresenterImpl loginPresenterImpl, Action action) {
        super(0);
        this.a = loginPresenterImpl;
        this.b = action;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        DeepLink deepLink = this.b.getDeepLink();
        this.a.d();
        LoginPresenter.Router router = this.a.j;
        if (router != null) {
            router.followDeepLink(deepLink);
        }
        LoginView loginView = this.a.i;
        if (loginView != null) {
            loginView.closeUserDialog();
        }
        return Unit.INSTANCE;
    }
}
