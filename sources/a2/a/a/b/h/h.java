package a2.a.a.b.h;

import com.avito.android.authorization.reset_password.ResetPasswordPresenterImpl;
import com.avito.android.authorization.reset_password.ResetPasswordView;
import com.avito.android.code_confirmation.CodeAlreadyConfirmedException;
import com.avito.android.util.TypedResultException;
import io.reactivex.functions.Consumer;
public final class h<T> implements Consumer<Throwable> {
    public final /* synthetic */ ResetPasswordPresenterImpl a;

    public h(ResetPasswordPresenterImpl resetPasswordPresenterImpl) {
        this.a = resetPasswordPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        ResetPasswordPresenterImpl.access$clearFieldErrors(this.a);
        if (th2 instanceof CodeAlreadyConfirmedException) {
            CodeAlreadyConfirmedException codeAlreadyConfirmedException = (CodeAlreadyConfirmedException) th2;
            ResetPasswordPresenterImpl.access$onPhoneConfirmed(this.a, codeAlreadyConfirmedException.getInfo().getLogin(), codeAlreadyConfirmedException.getInfo().getHash());
        } else if (th2 instanceof TypedResultException) {
            ResetPasswordPresenterImpl.access$handleResetPasswordError(this.a, ((TypedResultException) th2).getErrorResult());
        } else {
            ResetPasswordView resetPasswordView = this.a.a;
            if (resetPasswordView != null) {
                resetPasswordView.showUnknownError();
            }
        }
    }
}
