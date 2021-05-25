package a2.a.a.y2;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.social_management.SocialManagementPresenter;
import com.avito.android.social_management.SocialManagementPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class j<T> implements Consumer<DeepLink> {
    public final /* synthetic */ SocialManagementPresenterImpl a;

    public j(SocialManagementPresenterImpl socialManagementPresenterImpl) {
        this.a = socialManagementPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        SocialManagementPresenter.Router router = this.a.b;
        if (router != null) {
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            router.followDeepLink(deepLink2);
        }
    }
}
