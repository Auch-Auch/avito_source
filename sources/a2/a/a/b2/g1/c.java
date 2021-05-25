package a2.a.a.b2.g1;

import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.profile.password_setting.PasswordSettingPresenterImpl;
import com.avito.android.profile.password_setting.PasswordSettingView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<Throwable> {
    public final /* synthetic */ PasswordSettingPresenterImpl a;

    public c(PasswordSettingPresenterImpl passwordSettingPresenterImpl) {
        this.a = passwordSettingPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        PasswordSettingView passwordSettingView = this.a.a;
        if (passwordSettingView != null) {
            ErrorHelper errorHelper = this.a.l;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            passwordSettingView.showSnackbar(errorHelper.recycle(th2));
        }
    }
}
