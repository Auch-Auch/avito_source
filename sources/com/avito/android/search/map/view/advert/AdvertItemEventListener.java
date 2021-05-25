package com.avito.android.search.map.view.advert;

import com.avito.android.async_phone.AsyncPhoneAuthRouter;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.GroupingListener;
import com.avito.android.serp.adapter.OnCloseItemListener;
import com.avito.android.serp.adapter.SellerItemListener;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItemListener;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemListener;
import com.avito.android.serp.adapter.map_banner.MapBannerItemListener;
import com.avito.android.serp.adapter.promo_card.PromoCardItemPresenter;
import com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener;
import com.avito.android.serp.adapter.warning.SerpWarningItemListener;
import com.avito.android.serp.adapter.witcher.WitcherItemListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/search/map/view/advert/AdvertItemEventProvider;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemListener;", "Lcom/avito/android/serp/adapter/warning/SerpWarningItemListener;", "Lcom/avito/android/serp/adapter/AdBannerEventListener;", "Lcom/avito/android/serp/adapter/OnCloseItemListener;", "Lcom/avito/android/serp/adapter/rich_snippets/AdvertRichItemListener;", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemListener;", "Lcom/avito/android/serp/adapter/GroupingListener;", "Lcom/avito/android/serp/adapter/SellerItemListener;", "Lcom/avito/android/serp/adapter/witcher/WitcherItemListener;", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItemListener;", "Lcom/avito/android/async_phone/AsyncPhoneAuthRouter;", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter$Router;", "map_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertItemEventListener extends AdvertItemListener, AdvertItemEventProvider, AdvertXlItemListener, SerpWarningItemListener, AdBannerEventListener, OnCloseItemListener, AdvertRichItemListener, EmptyPlaceholderItemListener, GroupingListener, SellerItemListener, WitcherItemListener, MapBannerItemListener, AsyncPhoneAuthRouter, PromoCardItemPresenter.Router {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onMoreActionsClicked(@NotNull AdvertItemEventListener advertItemEventListener, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            AdvertItemListener.DefaultImpls.onMoreActionsClicked(advertItemEventListener, str);
        }

        public static void showAuth(@NotNull AdvertItemEventListener advertItemEventListener, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "src");
            AsyncPhoneAuthRouter.DefaultImpls.showAuth(advertItemEventListener, str);
        }
    }
}
