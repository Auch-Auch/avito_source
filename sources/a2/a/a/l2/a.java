package a2.a.a.l2;

import com.avito.android.favorite_sellers.RecommendationCarouselItem;
import com.avito.android.remote.model.recommended_sellers.RecommendedSellerElement;
import com.avito.android.remote.model.recommended_sellers.RecommendedSellersCarousel;
import com.avito.android.section.SectionItemConverterImpl;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.collections.CollectionsKt__CollectionsKt;
public final class a<V> implements Callable<List<? extends RecommendationCarouselItem>> {
    public final /* synthetic */ SectionItemConverterImpl a;
    public final /* synthetic */ RecommendedSellersCarousel b;
    public final /* synthetic */ String c;

    public a(SectionItemConverterImpl sectionItemConverterImpl, RecommendedSellersCarousel recommendedSellersCarousel, String str) {
        this.a = sectionItemConverterImpl;
        this.b = recommendedSellersCarousel;
        this.c = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public List<? extends RecommendationCarouselItem> call() {
        List<RecommendationCarouselItem> convert;
        List<RecommendedSellerElement> items = this.b.getItems();
        return (items == null || (convert = this.a.b.convert(items, this.c)) == null) ? CollectionsKt__CollectionsKt.emptyList() : convert;
    }
}
