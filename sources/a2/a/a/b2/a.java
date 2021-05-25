package a2.a.a.b2;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.profile.UserProfilePresenter;
import com.avito.android.profile.UserProfilePresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<DeepLink> {
    public final /* synthetic */ UserProfilePresenterImpl a;

    public a(UserProfilePresenterImpl userProfilePresenterImpl) {
        this.a = userProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        UserProfilePresenter.Router router = this.a.b;
        if (router != null) {
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            router.followDeepLink(deepLink2);
        }
    }
}
