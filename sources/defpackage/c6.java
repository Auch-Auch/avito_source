package defpackage;

import com.avito.android.authorization.login.LoginPresenterImpl;
import com.avito.android.authorization.login.LoginView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: c6  reason: default package */
public final class c6 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c6(int i, Object obj) {
        super(0);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.a;
        if (i == 0) {
            LoginPresenterImpl.access$onResetPasswordWithoutPhoneEntry((LoginPresenterImpl) this.b);
            LoginView loginView = ((LoginPresenterImpl) this.b).i;
            if (loginView != null) {
                loginView.closeUserDialog();
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            LoginView loginView2 = ((LoginPresenterImpl) this.b).i;
            if (loginView2 != null) {
                loginView2.closeUserDialog();
            }
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
