package com.avito.android.search.map.di;

import com.avito.android.di.PerFragment;
import com.avito.android.search.map.view.advert.AdvertItemEventListener;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.OnCloseItemListener;
import com.avito.android.serp.adapter.SellerItemListener;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItemListener;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemListener;
import com.avito.android.serp.adapter.map_banner.MapBannerItemListener;
import com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener;
import com.avito.android.serp.adapter.warning.SerpWarningItemListener;
import com.avito.android.serp.adapter.witcher.WitcherItemListener;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/avito/android/search/map/di/AdvertItemEventListenerModule;", "", "Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;", "advertItemEventListener", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "bindsAdvertItemListener", "(Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;)Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemListener;", "bindsAdvertXlItemListener", "(Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;)Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemListener;", "Lcom/avito/android/serp/adapter/warning/SerpWarningItemListener;", "bindsSerpWarningItemListener", "(Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;)Lcom/avito/android/serp/adapter/warning/SerpWarningItemListener;", "Lcom/avito/android/serp/adapter/OnCloseItemListener;", "bindsOnCloseItemListener", "(Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;)Lcom/avito/android/serp/adapter/OnCloseItemListener;", "Lcom/avito/android/serp/adapter/AdBannerEventListener;", "bindsAdvertRichItemListener", "(Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;)Lcom/avito/android/serp/adapter/AdBannerEventListener;", "Lcom/avito/android/serp/adapter/rich_snippets/AdvertRichItemListener;", "bindsBannerEventListener", "(Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;)Lcom/avito/android/serp/adapter/rich_snippets/AdvertRichItemListener;", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemListener;", "bindsEmptyPlaceholderItemListener", "(Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;)Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemListener;", "Lcom/avito/android/serp/adapter/witcher/WitcherItemListener;", "bindsWitcherItemListener", "(Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;)Lcom/avito/android/serp/adapter/witcher/WitcherItemListener;", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItemListener;", "bindsMapBannerItemListener", "(Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;)Lcom/avito/android/serp/adapter/map_banner/MapBannerItemListener;", "Lcom/avito/android/serp/adapter/SellerItemListener;", "bindsSellItemListener", "(Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;)Lcom/avito/android/serp/adapter/SellerItemListener;", "map_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface AdvertItemEventListenerModule {
    @PerFragment
    @Binds
    @NotNull
    AdvertItemListener bindsAdvertItemListener(@NotNull AdvertItemEventListener advertItemEventListener);

    @PerFragment
    @Binds
    @NotNull
    AdBannerEventListener bindsAdvertRichItemListener(@NotNull AdvertItemEventListener advertItemEventListener);

    @PerFragment
    @Binds
    @NotNull
    AdvertXlItemListener bindsAdvertXlItemListener(@NotNull AdvertItemEventListener advertItemEventListener);

    @PerFragment
    @Binds
    @NotNull
    AdvertRichItemListener bindsBannerEventListener(@NotNull AdvertItemEventListener advertItemEventListener);

    @PerFragment
    @Binds
    @NotNull
    EmptyPlaceholderItemListener bindsEmptyPlaceholderItemListener(@NotNull AdvertItemEventListener advertItemEventListener);

    @PerFragment
    @Binds
    @NotNull
    MapBannerItemListener bindsMapBannerItemListener(@NotNull AdvertItemEventListener advertItemEventListener);

    @PerFragment
    @Binds
    @NotNull
    OnCloseItemListener bindsOnCloseItemListener(@NotNull AdvertItemEventListener advertItemEventListener);

    @PerFragment
    @Binds
    @NotNull
    SellerItemListener bindsSellItemListener(@NotNull AdvertItemEventListener advertItemEventListener);

    @PerFragment
    @Binds
    @NotNull
    SerpWarningItemListener bindsSerpWarningItemListener(@NotNull AdvertItemEventListener advertItemEventListener);

    @PerFragment
    @Binds
    @NotNull
    WitcherItemListener bindsWitcherItemListener(@NotNull AdvertItemEventListener advertItemEventListener);
}
