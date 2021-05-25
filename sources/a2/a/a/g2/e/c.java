package a2.a.a.g2.e;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.rating.user_review_details.UserReviewDetailsPresenter;
import com.avito.android.rating.user_review_details.UserReviewDetailsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<DeepLink> {
    public final /* synthetic */ UserReviewDetailsPresenterImpl a;

    public c(UserReviewDetailsPresenterImpl userReviewDetailsPresenterImpl) {
        this.a = userReviewDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        UserReviewDetailsPresenter.Router router = this.a.b;
        if (router != null) {
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            router.followDeepLink(deepLink2);
        }
    }
}
