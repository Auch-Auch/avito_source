package a2.a.a.s0.h0.a;

import com.avito.android.favorite_sellers.SellerCarouselItem;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class j<T> implements Consumer<Throwable> {
    public final /* synthetic */ RecommendationItemPresenterImpl a;
    public final /* synthetic */ SellerCarouselItem b;

    public j(RecommendationItemPresenterImpl recommendationItemPresenterImpl, SellerCarouselItem sellerCarouselItem) {
        this.a = recommendationItemPresenterImpl;
        this.b = sellerCarouselItem;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        RecommendationItemPresenterImpl recommendationItemPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        RecommendationItemPresenterImpl.access$handleError(recommendationItemPresenterImpl, th2, this.b);
    }
}
