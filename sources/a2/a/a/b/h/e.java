package a2.a.a.b.h;

import com.avito.android.authorization.reset_password.ResetPasswordPresenterImpl;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class e<T> implements Consumer<Disposable> {
    public final /* synthetic */ ResetPasswordPresenterImpl a;

    public e(ResetPasswordPresenterImpl resetPasswordPresenterImpl) {
        this.a = resetPasswordPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        ResetPasswordPresenterImpl.access$handleResetPasswordStarted(this.a);
    }
}
