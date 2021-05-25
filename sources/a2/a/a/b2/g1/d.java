package a2.a.a.b2.g1;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.profile.password_setting.PasswordSettingPresenter;
import com.avito.android.profile.password_setting.PasswordSettingPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Consumer<DeepLink> {
    public final /* synthetic */ PasswordSettingPresenterImpl a;

    public d(PasswordSettingPresenterImpl passwordSettingPresenterImpl) {
        this.a = passwordSettingPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        PasswordSettingPresenter.Router router = this.a.b;
        if (router != null) {
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            router.followDeeplink(deepLink2);
        }
    }
}
