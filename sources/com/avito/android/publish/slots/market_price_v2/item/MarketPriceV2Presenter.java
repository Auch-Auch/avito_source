package com.avito.android.publish.slots.market_price_v2.item;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.items.MarketPriceV2Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2Presenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2View;", "Lcom/avito/android/items/MarketPriceV2Item;", "Lio/reactivex/Observable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLinkClickStream", "()Lio/reactivex/Observable;", "deepLinkClickStream", "", "getUrlClickStream", "urlClickStream", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface MarketPriceV2Presenter extends ItemPresenter<MarketPriceV2View, MarketPriceV2Item> {
    @NotNull
    Observable<DeepLink> getDeepLinkClickStream();

    @NotNull
    Observable<String> getUrlClickStream();
}
