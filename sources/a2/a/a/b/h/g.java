package a2.a.a.b.h;

import com.avito.android.authorization.reset_password.ResetPasswordPresenterImpl;
import com.avito.android.remote.model.ResetPasswordResult;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class g<T> implements Consumer<ResetPasswordResult> {
    public final /* synthetic */ ResetPasswordPresenterImpl a;

    public g(ResetPasswordPresenterImpl resetPasswordPresenterImpl) {
        this.a = resetPasswordPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(ResetPasswordResult resetPasswordResult) {
        ResetPasswordResult resetPasswordResult2 = resetPasswordResult;
        ResetPasswordPresenterImpl resetPasswordPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(resetPasswordResult2, "it");
        ResetPasswordPresenterImpl.access$handleResetPasswordCompleted(resetPasswordPresenterImpl, resetPasswordResult2);
    }
}
