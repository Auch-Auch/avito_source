package a2.a.a.e0;

import com.avito.android.code_confirmation.CodeConfirmationPresenterImpl;
import com.avito.android.code_confirmation.CodeConfirmationView;
import io.reactivex.functions.Action;
public final class b implements Action {
    public final /* synthetic */ CodeConfirmationPresenterImpl a;

    public b(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl) {
        this.a = codeConfirmationPresenterImpl;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        CodeConfirmationView codeConfirmationView = this.a.a;
        if (codeConfirmationView != null) {
            codeConfirmationView.hideProgress();
        }
    }
}
