package a2.a.a.s0.h0.a;

import com.avito.android.FavoriteSeller;
import com.avito.android.favorite_sellers.RecommendationItem;
import com.avito.android.favorite_sellers.SellerCarouselItem;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
public final class h<T> implements Consumer<Map<String, ? extends FavoriteSeller>> {
    public final /* synthetic */ RecommendationItemPresenterImpl a;

    public h(RecommendationItemPresenterImpl recommendationItemPresenterImpl) {
        this.a = recommendationItemPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Map<String, ? extends FavoriteSeller> map) {
        Map<String, ? extends FavoriteSeller> map2 = map;
        Collection<RecommendationItem> values = this.a.getBoundItems$favorite_sellers_items_release().values();
        Intrinsics.checkNotNullExpressionValue(values, "boundItems.values");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            t6.n.h.addAll(arrayList, it.next().getCarousel());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (next instanceof SellerCarouselItem) {
                arrayList2.add(next);
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            SellerCarouselItem sellerCarouselItem = (SellerCarouselItem) it3.next();
            FavoriteSeller favoriteSeller = (FavoriteSeller) map2.get(sellerCarouselItem.getUserKey());
            if (favoriteSeller != null) {
                sellerCarouselItem.setSubscribed(favoriteSeller.isSubscribed());
                sellerCarouselItem.setNotificationsActivated(favoriteSeller.isNotificationsActivated());
                this.a.e(sellerCarouselItem);
            }
        }
    }
}
