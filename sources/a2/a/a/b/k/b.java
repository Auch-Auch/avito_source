package a2.a.a.b.k;

import com.avito.android.authorization.start_registration.StartRegistrationPresenterImpl;
import com.avito.android.code_confirmation.model.CodeInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<CodeInfo> {
    public final /* synthetic */ StartRegistrationPresenterImpl a;

    public b(StartRegistrationPresenterImpl startRegistrationPresenterImpl) {
        this.a = startRegistrationPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CodeInfo codeInfo) {
        CodeInfo codeInfo2 = codeInfo;
        StartRegistrationPresenterImpl startRegistrationPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(codeInfo2, "it");
        StartRegistrationPresenterImpl.access$handleRequestCompleted(startRegistrationPresenterImpl, codeInfo2);
    }
}
