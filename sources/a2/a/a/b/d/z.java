package a2.a.a.b.d;

import com.avito.android.authorization.login.LoginPresenterImpl;
import com.avito.android.code_confirmation.model.CodeInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class z<T> implements Consumer<CodeInfo> {
    public final /* synthetic */ LoginPresenterImpl a;
    public final /* synthetic */ String b;

    public z(LoginPresenterImpl loginPresenterImpl, String str) {
        this.a = loginPresenterImpl;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CodeInfo codeInfo) {
        CodeInfo codeInfo2 = codeInfo;
        LoginPresenterImpl loginPresenterImpl = this.a;
        String str = this.b;
        Intrinsics.checkNotNullExpressionValue(codeInfo2, "it");
        LoginPresenterImpl.access$handleTfaCodeRequested(loginPresenterImpl, str, codeInfo2);
    }
}
