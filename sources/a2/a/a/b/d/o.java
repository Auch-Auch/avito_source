package a2.a.a.b.d;

import com.avito.android.authorization.login.LoginPresenterImpl;
import com.avito.android.authorization.login.LoginView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class o extends Lambda implements Function0<Unit> {
    public final /* synthetic */ LoginPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(LoginPresenterImpl loginPresenterImpl) {
        super(0);
        this.a = loginPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        LoginView loginView = this.a.i;
        if (loginView != null) {
            loginView.closeUserDialog();
        }
        return Unit.INSTANCE;
    }
}
