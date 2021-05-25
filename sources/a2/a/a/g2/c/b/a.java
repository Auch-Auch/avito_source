package a2.a.a.g2.c.b;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.rating.review_details.reply.ReviewReplyPresenter;
import com.avito.android.rating.review_details.reply.ReviewReplyPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<DeepLink> {
    public final /* synthetic */ ReviewReplyPresenterImpl a;

    public a(ReviewReplyPresenterImpl reviewReplyPresenterImpl) {
        this.a = reviewReplyPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        ReviewReplyPresenter.Router router = this.a.b;
        if (router != null) {
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            router.followDeepLink(deepLink2);
        }
    }
}
