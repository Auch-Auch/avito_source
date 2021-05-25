package a2.a.a.e0;

import com.avito.android.code_confirmation.CodeConfirmationPresenterImpl;
import com.avito.android.code_confirmation.CodeConfirmationView;
import io.reactivex.functions.Consumer;
public final class g<T> implements Consumer<Long> {
    public final /* synthetic */ CodeConfirmationPresenterImpl a;

    public g(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl) {
        this.a = codeConfirmationPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.avito.android.util.Formatter */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(Long l) {
        Long l2 = l;
        CodeConfirmationView codeConfirmationView = this.a.a;
        if (codeConfirmationView != null) {
            codeConfirmationView.showTimer(this.a.s.codeRequestTimer(this.a.t.format(l2)));
        }
    }
}
