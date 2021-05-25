package a2.a.a.b.h;

import com.avito.android.authorization.reset_password.ResetPasswordPresenterImpl;
import com.avito.android.authorization.reset_password.ResetPasswordView;
import io.reactivex.functions.Action;
public final class f implements Action {
    public final /* synthetic */ ResetPasswordPresenterImpl a;

    public f(ResetPasswordPresenterImpl resetPasswordPresenterImpl) {
        this.a = resetPasswordPresenterImpl;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        ResetPasswordView resetPasswordView = this.a.a;
        if (resetPasswordView != null) {
            resetPasswordView.hideProgress();
        }
    }
}
