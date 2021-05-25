package a2.a.a.l2;

import com.avito.android.favorite_sellers.AdvertDetailsRecommendationItem;
import com.avito.android.favorite_sellers.RecommendationCarouselItem;
import com.avito.android.remote.model.recommended_sellers.RecommendedSellersCarousel;
import com.avito.android.serp.adapter.PersistableSpannedItem;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import t6.n.d;
public final class b<T, R> implements Function<List<? extends RecommendationCarouselItem>, List<? extends PersistableSpannedItem>> {
    public final /* synthetic */ RecommendedSellersCarousel a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;

    public b(RecommendedSellersCarousel recommendedSellersCarousel, String str, int i) {
        this.a = recommendedSellersCarousel;
        this.b = str;
        this.c = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public List<? extends PersistableSpannedItem> apply(List<? extends RecommendationCarouselItem> list) {
        List<? extends RecommendationCarouselItem> list2 = list;
        String str = this.b;
        Intrinsics.checkNotNullExpressionValue(list2, "items");
        return d.listOf(new AdvertDetailsRecommendationItem(str, list2, this.a.getTitle(), this.c));
    }
}
