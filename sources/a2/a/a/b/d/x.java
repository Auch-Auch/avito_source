package a2.a.a.b.d;

import com.avito.android.authorization.login.LoginPresenterImpl;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class x<T> implements Consumer<Disposable> {
    public final /* synthetic */ LoginPresenterImpl a;

    public x(LoginPresenterImpl loginPresenterImpl) {
        this.a = loginPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        LoginPresenterImpl.access$handleOperationStarted(this.a);
    }
}
