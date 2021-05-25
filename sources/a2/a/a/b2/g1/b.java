package a2.a.a.b2.g1;

import com.avito.android.profile.password_setting.PasswordSettingPresenterImpl;
import com.avito.android.remote.model.password.PasswordChangeResult;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<LoadingState<? super PasswordChangeResult>> {
    public final /* synthetic */ PasswordSettingPresenterImpl a;

    public b(PasswordSettingPresenterImpl passwordSettingPresenterImpl) {
        this.a = passwordSettingPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super PasswordChangeResult> loadingState) {
        LoadingState<? super PasswordChangeResult> loadingState2 = loadingState;
        PasswordSettingPresenterImpl passwordSettingPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
        PasswordSettingPresenterImpl.access$handleLoadingState(passwordSettingPresenterImpl, loadingState2);
    }
}
