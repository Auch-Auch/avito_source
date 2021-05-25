package a2.a.a.e0;

import com.avito.android.code_confirmation.CodeConfirmationPresenter;
import com.avito.android.code_confirmation.CodeConfirmationPresenterImpl;
import com.avito.android.code_confirmation.CodeConfirmationView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Action;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function0<Unit> {
    public final /* synthetic */ CodeConfirmationPresenterImpl a;
    public final /* synthetic */ Action b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl, Action action) {
        super(0);
        this.a = codeConfirmationPresenterImpl;
        this.b = action;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        DeepLink deepLink;
        int ordinal = this.a.m.ordinal();
        if (ordinal == 1) {
            deepLink = CodeConfirmationPresenterImpl.access$mixResetPasswordSrc(this.a, this.b.getDeepLink(), "antihack");
        } else if (ordinal != 2) {
            deepLink = this.b.getDeepLink();
        } else {
            deepLink = CodeConfirmationPresenterImpl.access$mixResetPasswordSrc(this.a, this.b.getDeepLink(), "tfa");
        }
        CodeConfirmationView codeConfirmationView = this.a.a;
        if (codeConfirmationView != null) {
            codeConfirmationView.hideKeyboard();
        }
        CodeConfirmationPresenter.Router router = this.a.b;
        if (router != null) {
            router.followDeepLink(deepLink);
        }
        CodeConfirmationView codeConfirmationView2 = this.a.a;
        if (codeConfirmationView2 != null) {
            codeConfirmationView2.closeUserDialog();
        }
        return Unit.INSTANCE;
    }
}
