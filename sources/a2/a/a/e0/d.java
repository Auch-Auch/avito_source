package a2.a.a.e0;

import com.avito.android.code_confirmation.CodeConfirmationPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Consumer<Throwable> {
    public final /* synthetic */ CodeConfirmationPresenterImpl a;

    public d(CodeConfirmationPresenterImpl codeConfirmationPresenterImpl) {
        this.a = codeConfirmationPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        CodeConfirmationPresenterImpl codeConfirmationPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "error");
        CodeConfirmationPresenterImpl.access$handleError(codeConfirmationPresenterImpl, th2);
    }
}
