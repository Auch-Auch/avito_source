package a2.a.a.e0;

import com.avito.android.code_confirmation.CodeConfirmationPresenterImpl;
import com.avito.android.code_confirmation.model.CodeInfo;
import io.reactivex.functions.Consumer;
public final class c<T> implements Consumer<CodeInfo> {
    public final /* synthetic */ CodeConfirmationPresenterImpl a;

    public c(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl) {
        this.a = codeConfirmationPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CodeInfo codeInfo) {
        CodeInfo codeInfo2 = codeInfo;
        CodeConfirmationPresenterImpl codeConfirmationPresenterImpl = this.a;
        codeConfirmationPresenterImpl.initData(codeConfirmationPresenterImpl.f, codeInfo2.getText(), codeInfo2.getTimeout(), codeInfo2.getLength());
    }
}
