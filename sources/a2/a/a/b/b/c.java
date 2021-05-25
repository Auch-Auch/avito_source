package a2.a.a.b.b;

import com.avito.android.authorization.auth.AuthPresenterImpl;
import com.avito.android.authorization.auth.AuthView;
import io.reactivex.rxjava3.functions.Action;
public final class c implements Action {
    public final /* synthetic */ AuthPresenterImpl.c a;

    public c(AuthPresenterImpl.c cVar) {
        this.a = cVar;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        AuthView authView = this.a.a.c;
        if (authView != null) {
            authView.showContent();
        }
    }
}
