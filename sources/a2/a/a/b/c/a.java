package a2.a.a.b.c;

import com.avito.android.authorization.complete_registration.CompleteRegistrationPresenterImpl;
import com.avito.android.authorization.complete_registration.CompleteRegistrationView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class a<T> implements Consumer<Disposable> {
    public final /* synthetic */ CompleteRegistrationPresenterImpl.c a;

    public a(CompleteRegistrationPresenterImpl.c cVar) {
        this.a = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        CompleteRegistrationView completeRegistrationView = this.a.a.a;
        if (completeRegistrationView != null) {
            completeRegistrationView.hideKeyboard();
        }
        CompleteRegistrationView completeRegistrationView2 = this.a.a.a;
        if (completeRegistrationView2 != null) {
            completeRegistrationView2.showProgress();
        }
    }
}
