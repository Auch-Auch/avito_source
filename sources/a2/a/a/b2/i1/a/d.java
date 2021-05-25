package a2.a.a.b2.i1.a;

import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.profile.tfa.settings.TfaSettingsPresenterImpl;
import com.avito.android.profile.tfa.settings.TfaSettingsView;
import com.avito.android.util.TypedResultException;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Consumer<Throwable> {
    public final /* synthetic */ TfaSettingsPresenterImpl a;
    public final /* synthetic */ boolean b;

    public d(TfaSettingsPresenterImpl tfaSettingsPresenterImpl, boolean z) {
        this.a = tfaSettingsPresenterImpl;
        this.b = z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        if (th2 instanceof TypedResultException) {
            TfaSettingsPresenterImpl.access$handleTypedError(this.a, ((TypedResultException) th2).getErrorResult());
        } else {
            TfaSettingsView tfaSettingsView = this.a.a;
            if (tfaSettingsView != null) {
                ErrorHelper errorHelper = this.a.i;
                Intrinsics.checkNotNullExpressionValue(th2, "error");
                tfaSettingsView.showSnackbar(errorHelper.recycle(th2));
            }
        }
        TfaSettingsView tfaSettingsView2 = this.a.a;
        if (tfaSettingsView2 != null) {
            tfaSettingsView2.showToggleChecked(!this.b);
        }
    }
}
