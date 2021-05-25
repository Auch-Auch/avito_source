package a2.a.a.b.d;

import com.avito.android.authorization.login.LoginPresenterImpl;
import com.avito.android.remote.model.ResetPasswordResult;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class v<T> implements Consumer<ResetPasswordResult> {
    public final /* synthetic */ LoginPresenterImpl a;

    public v(LoginPresenterImpl loginPresenterImpl) {
        this.a = loginPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(ResetPasswordResult resetPasswordResult) {
        ResetPasswordResult resetPasswordResult2 = resetPasswordResult;
        LoginPresenterImpl loginPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(resetPasswordResult2, "it");
        LoginPresenterImpl.access$handleResetPasswordRequestCompleted(loginPresenterImpl, resetPasswordResult2);
    }
}
