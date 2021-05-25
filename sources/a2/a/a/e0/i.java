package a2.a.a.e0;

import com.avito.android.code_confirmation.CodeConfirmationPresenterImpl;
import com.avito.android.code_confirmation.CodeConfirmationView;
import io.reactivex.functions.Action;
public final class i implements Action {
    public final /* synthetic */ CodeConfirmationPresenterImpl a;

    public i(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl) {
        this.a = codeConfirmationPresenterImpl;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.a.i = null;
        CodeConfirmationView codeConfirmationView = this.a.a;
        if (codeConfirmationView != null) {
            codeConfirmationView.showRequestButton();
        }
    }
}
