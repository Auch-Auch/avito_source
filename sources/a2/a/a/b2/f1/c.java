package a2.a.a.b2.f1;

import com.avito.android.profile.password_change.PasswordChangeView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class c<T> implements Consumer<Disposable> {
    public final /* synthetic */ g a;

    public c(g gVar) {
        this.a = gVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        PasswordChangeView passwordChangeView = this.a.a.a;
        if (passwordChangeView != null) {
            passwordChangeView.showProgress();
        }
    }
}
