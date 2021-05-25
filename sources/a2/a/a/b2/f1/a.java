package a2.a.a.b2.f1;

import com.avito.android.profile.password_change.PasswordChangePresenterImpl;
import com.avito.android.remote.model.password.PasswordChangeResult;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<LoadingState<? super PasswordChangeResult>> {
    public final /* synthetic */ PasswordChangePresenterImpl a;
    public final /* synthetic */ String b;

    public a(PasswordChangePresenterImpl passwordChangePresenterImpl, String str) {
        this.a = passwordChangePresenterImpl;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super PasswordChangeResult> loadingState) {
        LoadingState<? super PasswordChangeResult> loadingState2 = loadingState;
        PasswordChangePresenterImpl passwordChangePresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
        PasswordChangePresenterImpl.access$handleLoadingState(passwordChangePresenterImpl, loadingState2, this.b);
    }
}
