package a2.a.a.s2.b;

import com.avito.android.FilterAnalyticsData;
import com.avito.android.shop.detailed.ShopDetailedPresenter;
import com.avito.android.shop.detailed.ShopDetailedPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class k<T> implements Consumer<Integer> {
    public final /* synthetic */ ShopDetailedPresenterImpl a;

    public k(ShopDetailedPresenterImpl shopDetailedPresenterImpl) {
        this.a = shopDetailedPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Integer num) {
        FilterAnalyticsData filterAnalyticsData = new FilterAnalyticsData(FilterAnalyticsData.Source.SHOP_DETAILED, this.a.d(), ShopDetailedPresenterImpl.access$getProProfileType(this.a));
        ShopDetailedPresenter.Router router = this.a.h;
        if (router != null) {
            router.openFilters(this.a.p, filterAnalyticsData);
        }
    }
}
