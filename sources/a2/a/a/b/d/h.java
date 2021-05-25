package a2.a.a.b.d;

import com.avito.android.authorization.login.LoginPresenterImpl;
import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.remote.model.LoginResult;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class h<T> implements Consumer<CodeInfo> {
    public final /* synthetic */ LoginPresenterImpl a;
    public final /* synthetic */ LoginResult.AntihackCheckPhone b;

    public h(LoginPresenterImpl loginPresenterImpl, LoginResult.AntihackCheckPhone antihackCheckPhone) {
        this.a = loginPresenterImpl;
        this.b = antihackCheckPhone;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CodeInfo codeInfo) {
        CodeInfo codeInfo2 = codeInfo;
        LoginPresenterImpl loginPresenterImpl = this.a;
        String challengeId = this.b.getChallengeId();
        Intrinsics.checkNotNullExpressionValue(codeInfo2, "it");
        LoginPresenterImpl.access$handlePhoneAntihackCodeRequested(loginPresenterImpl, challengeId, codeInfo2);
    }
}
