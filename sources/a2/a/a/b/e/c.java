package a2.a.a.b.e;

import com.avito.android.authorization.login_protection.LoginProtectionListPresenterImpl;
import com.avito.android.code_confirmation.model.CodeInfo;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<CodeInfo> {
    public final /* synthetic */ LoginProtectionListPresenterImpl a;
    public final /* synthetic */ String b;

    public c(LoginProtectionListPresenterImpl loginProtectionListPresenterImpl, String str) {
        this.a = loginProtectionListPresenterImpl;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(CodeInfo codeInfo) {
        CodeInfo codeInfo2 = codeInfo;
        LoginProtectionListPresenterImpl loginProtectionListPresenterImpl = this.a;
        String str = this.b;
        Intrinsics.checkNotNullExpressionValue(codeInfo2, "it");
        LoginProtectionListPresenterImpl.access$handleTfaCodeRequested(loginProtectionListPresenterImpl, str, codeInfo2);
    }
}
