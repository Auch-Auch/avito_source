package a2.a.a.g2.c;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.rating.review_details.ReviewDetailsPresenter;
import com.avito.android.rating.review_details.ReviewDetailsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<DeepLink> {
    public final /* synthetic */ ReviewDetailsPresenterImpl a;

    public a(ReviewDetailsPresenterImpl reviewDetailsPresenterImpl) {
        this.a = reviewDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        ReviewDetailsPresenter.Router router = this.a.b;
        if (router != null) {
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            router.followDeepLink(deepLink2);
        }
    }
}
