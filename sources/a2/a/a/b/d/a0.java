package a2.a.a.b.d;

import com.avito.android.authorization.login.LoginPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a0<T> implements Consumer<Throwable> {
    public final /* synthetic */ LoginPresenterImpl a;

    public a0(LoginPresenterImpl loginPresenterImpl) {
        this.a = loginPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        LoginPresenterImpl loginPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        LoginPresenterImpl.access$handlePhoneVerificationError(loginPresenterImpl, th2);
    }
}
