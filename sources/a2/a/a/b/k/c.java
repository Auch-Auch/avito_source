package a2.a.a.b.k;

import com.avito.android.authorization.reset_password.StartRegistrationView;
import com.avito.android.authorization.start_registration.StartRegistrationPresenterImpl;
import com.avito.android.code_confirmation.CodeAlreadyConfirmedException;
import com.avito.android.util.TypedResultException;
import io.reactivex.functions.Consumer;
public final class c<T> implements Consumer<Throwable> {
    public final /* synthetic */ StartRegistrationPresenterImpl a;

    public c(StartRegistrationPresenterImpl startRegistrationPresenterImpl) {
        this.a = startRegistrationPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        if (th2 instanceof CodeAlreadyConfirmedException) {
            CodeAlreadyConfirmedException codeAlreadyConfirmedException = (CodeAlreadyConfirmedException) th2;
            StartRegistrationPresenterImpl.access$onPhoneConfirmed(this.a, codeAlreadyConfirmedException.getInfo().getLogin(), codeAlreadyConfirmedException.getInfo().getHash(), codeAlreadyConfirmedException.getInfo().isPhoneUsed());
        } else if (th2 instanceof TypedResultException) {
            StartRegistrationPresenterImpl.access$handleFieldError(this.a, ((TypedResultException) th2).getErrorResult());
        } else {
            StartRegistrationView startRegistrationView = this.a.a;
            if (startRegistrationView != null) {
                startRegistrationView.showUnknownError();
            }
        }
    }
}
