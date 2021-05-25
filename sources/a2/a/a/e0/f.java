package a2.a.a.e0;

import com.avito.android.code_confirmation.CodeConfirmationPresenterImpl;
import com.avito.android.code_confirmation.CodeConfirmationView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function0<Unit> {
    public final /* synthetic */ CodeConfirmationPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl) {
        super(0);
        this.a = codeConfirmationPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        CodeConfirmationView codeConfirmationView = this.a.a;
        if (codeConfirmationView != null) {
            codeConfirmationView.closeUserDialog();
        }
        return Unit.INSTANCE;
    }
}
