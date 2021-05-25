package defpackage;

import com.avito.android.authorization.login.LoginPresenter;
import com.avito.android.authorization.login.LoginPresenterImpl;
import com.avito.android.authorization.login.LoginView;
import com.avito.android.remote.model.Action;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: i6  reason: default package */
public final class i6 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i6(int i, Object obj, Object obj2) {
        super(0);
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.a;
        if (i == 0) {
            ((LoginPresenterImpl) this.b).d();
            LoginPresenter.Router router = ((LoginPresenterImpl) this.b).j;
            if (router != null) {
                router.followDeepLink(((Action) this.c).getDeepLink());
            }
            LoginView loginView = ((LoginPresenterImpl) this.b).i;
            if (loginView != null) {
                loginView.closeUserDialog();
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            ((LoginPresenterImpl) this.b).d();
            LoginPresenter.Router router2 = ((LoginPresenterImpl) this.b).j;
            if (router2 != null) {
                router2.followDeepLink(((Action) this.c).getDeepLink());
            }
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
