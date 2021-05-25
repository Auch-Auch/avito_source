package a2.a.a.b.h;

import com.avito.android.authorization.reset_password.ResetPasswordInteractorImpl;
import com.avito.android.remote.model.ResetPasswordResult;
import com.avito.android.remote.model.SuccessResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<SuccessResult, ResetPasswordResult> {
    public final /* synthetic */ ResetPasswordInteractorImpl a;
    public final /* synthetic */ String b;

    public b(ResetPasswordInteractorImpl resetPasswordInteractorImpl, String str) {
        this.a = resetPasswordInteractorImpl;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ResetPasswordResult apply(SuccessResult successResult) {
        Intrinsics.checkNotNullParameter(successResult, "it");
        return new ResetPasswordResult.ViaLink(this.a.d.resetPasswordViaLinkText(this.b));
    }
}
