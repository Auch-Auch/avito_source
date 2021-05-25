package a2.a.a.b2.f1;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.profile.password_change.PasswordChangePresenter;
import com.avito.android.profile.password_change.PasswordChangePresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class m<T> implements Consumer<DeepLink> {
    public final /* synthetic */ PasswordChangePresenterImpl a;

    public m(PasswordChangePresenterImpl passwordChangePresenterImpl) {
        this.a = passwordChangePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        PasswordChangePresenter.Router router = this.a.b;
        if (router != null) {
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            router.followDeeplink(deepLink2);
        }
    }
}
