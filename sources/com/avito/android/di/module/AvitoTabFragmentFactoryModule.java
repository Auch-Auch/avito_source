package com.avito.android.di.module;

import com.avito.android.advert.di.AdvertDetailsTabFragmentFactoryModule;
import com.avito.android.auto_catalog.di.AutoCatalogTabFragmentFactoryModule;
import com.avito.android.brandspace.di.BrandspaceTabFragmentFactoryModule;
import com.avito.android.developments_catalog.di.DevelopmentsCatalogTabFragmentFactoryModule;
import com.avito.android.extended_profile.di.ExtendedProfileTabFragmentFactoryModule;
import com.avito.android.grouping_adverts.GroupingAdvertsTabFragmentFactoryModule;
import com.avito.android.item_map.di.ItemMapTabFragmentFactoryModule;
import com.avito.android.messenger.channels.mvi.di.MessengerTabFragmentFactoryModule;
import com.avito.android.order.di.module.OrderTabFragmentFactoryModule;
import com.avito.android.orders.di.module.OrdersTabFragmentFactoryModule;
import com.avito.android.player.di.PlayerTabFragmentFactoryModule;
import com.avito.android.profile.di.ProfileTabFragmentFactoryModule;
import com.avito.android.profile_phones.PhonesTabFragmentFactoryModule;
import com.avito.android.public_profile.PublicProfileTabFragmentFactoryModule;
import com.avito.android.publish.di.PublishTabFragmentFactoryModule;
import com.avito.android.screen_opener.di.ProfileScreenResolverTabFragmentFactoryModule;
import com.avito.android.search.map.di.SearchMapTabFragmentFactoryModule;
import com.avito.android.select.new_metro.di.SelectMetroFragmentFactoryModule;
import com.avito.android.settings.di.SettingsTabFragmentFactoryModule;
import com.avito.android.shop.detailed.di.ShopDetailedTabFragmentFactoryModule;
import com.avito.android.shop.list.di.ShopTabFragmentFactoryModule;
import com.avito.android.suggest_locations.di.SuggestLocationsTabFragmentFactoryModule;
import com.avito.android.user_adverts.di.UserAdvertsTabFragmentFactoryModule;
import com.avito.android.user_favorites.di.UserFavoritesTabFragmentFactoryModule;
import com.avito.android.user_stats.di.UserStatsTabFragmentFactoryModule;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/di/module/AvitoTabFragmentFactoryModule;", "", "<init>", "()V", "avito-103.5-(1342)_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {TabFragmentFactoryModule.class, AdvertDetailsTabFragmentFactoryModule.class, AutoCatalogTabFragmentFactoryModule.class, BrandspaceTabFragmentFactoryModule.class, DevelopmentsCatalogTabFragmentFactoryModule.class, GroupingAdvertsTabFragmentFactoryModule.class, ItemMapTabFragmentFactoryModule.class, MessengerTabFragmentFactoryModule.class, OrdersTabFragmentFactoryModule.class, OrderTabFragmentFactoryModule.class, PhonesTabFragmentFactoryModule.class, PlayerTabFragmentFactoryModule.class, ProfileTabFragmentFactoryModule.class, PublicProfileTabFragmentFactoryModule.class, PublishTabFragmentFactoryModule.class, SearchMapTabFragmentFactoryModule.class, SelectMetroFragmentFactoryModule.class, SerpTabFragmentFactoryModule.class, SettingsTabFragmentFactoryModule.class, ShopDetailedTabFragmentFactoryModule.class, ShopTabFragmentFactoryModule.class, SuggestLocationsTabFragmentFactoryModule.class, UserAdvertsTabFragmentFactoryModule.class, UserFavoritesTabFragmentFactoryModule.class, UserStatsTabFragmentFactoryModule.class, ProfileScreenResolverTabFragmentFactoryModule.class, ExtendedProfileTabFragmentFactoryModule.class})
public final class AvitoTabFragmentFactoryModule {
    @NotNull
    public static final AvitoTabFragmentFactoryModule INSTANCE = new AvitoTabFragmentFactoryModule();
}
