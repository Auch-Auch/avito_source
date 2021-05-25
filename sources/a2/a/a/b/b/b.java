package a2.a.a.b.b;

import com.avito.android.authorization.auth.AuthPresenterImpl;
import com.avito.android.authorization.auth.AuthView;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class b<T> implements Consumer<Disposable> {
    public final /* synthetic */ AuthPresenterImpl.c a;

    public b(AuthPresenterImpl.c cVar) {
        this.a = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        AuthView authView = this.a.a.c;
        if (authView != null) {
            authView.showProgress();
        }
    }
}
