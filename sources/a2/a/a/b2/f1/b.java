package a2.a.a.b2.f1;

import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.profile.password_change.PasswordChangePresenterImpl;
import com.avito.android.profile.password_change.PasswordChangeView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<Throwable> {
    public final /* synthetic */ PasswordChangePresenterImpl a;

    public b(PasswordChangePresenterImpl passwordChangePresenterImpl) {
        this.a = passwordChangePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        PasswordChangeView passwordChangeView = this.a.a;
        if (passwordChangeView != null) {
            ErrorHelper errorHelper = this.a.q;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            passwordChangeView.showSnackbar(errorHelper.recycle(th2));
        }
    }
}
