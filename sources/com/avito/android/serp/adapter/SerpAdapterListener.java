package com.avito.android.serp.adapter;

import com.avito.android.serp.adapter.AdvertItemListener;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/serp/adapter/SerpAdapterListener;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemListener;", "Lcom/avito/android/serp/adapter/warning/SerpWarningItemListener;", "Lcom/avito/android/serp/adapter/OnCloseItemListener;", "Lcom/avito/android/serp/adapter/AdBannerEventListener;", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemListener;", "Lcom/avito/android/serp/adapter/rich_snippets/AdvertRichItemListener;", "Lcom/avito/android/serp/adapter/witcher/WitcherItemListener;", "Lcom/avito/android/serp/adapter/SellerItemListener;", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItemListener;", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter$Router;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SerpAdapterListener extends AdvertItemListener, AdvertXlItemListener, SerpWarningItemListener, OnCloseItemListener, AdBannerEventListener, EmptyPlaceholderItemListener, AdvertRichItemListener, WitcherItemListener, SellerItemListener, MapBannerItemListener, PromoCardItemPresenter.Router {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onMoreActionsClicked(@NotNull SerpAdapterListener serpAdapterListener, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            AdvertItemListener.DefaultImpls.onMoreActionsClicked(serpAdapterListener, str);
        }
    }
}
