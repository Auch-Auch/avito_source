package a2.a.a.e0;

import com.avito.android.code_confirmation.CodeConfirmationPresenterImpl;
import com.avito.android.code_confirmation.CodeConfirmationView;
import io.reactivex.functions.Consumer;
public final class h<T> implements Consumer<Throwable> {
    public final /* synthetic */ CodeConfirmationPresenterImpl a;

    public h(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl) {
        this.a = codeConfirmationPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.avito.android.util.ErrorFormatter */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        CodeConfirmationView codeConfirmationView = this.a.a;
        if (codeConfirmationView != null) {
            codeConfirmationView.showError(this.a.r.format(th2));
        }
    }
}
