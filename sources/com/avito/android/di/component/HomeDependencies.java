package com.avito.android.di.component;

import com.avito.android.ab_tests.configs.AntifraudStartupBannerTestGroup;
import com.avito.android.ab_tests.configs.HomeNewRubricatorTestGroup;
import com.avito.android.ab_tests.groups.HomeSkeletonTestGroup;
import com.avito.android.ab_tests.groups.ViewedItemsTabTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.advert.actions.HiddenAdvertsStorage;
import com.avito.android.di.ComponentDependencies;
import com.avito.android.geo.GeoStorage;
import com.avito.android.home.default_search_location.DefaultSearchLocationStorage;
import com.avito.android.lib.util.DarkThemeConfig;
import com.avito.android.notification_center.counter.NotificationCenterCounterInteractor;
import com.avito.android.preferences.UpdateStorage;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.remote.StoriesApi;
import com.avito.android.remote.notification.UnreadNotificationsInteractor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H&¢\u0006\u0004\b$\u0010%J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&H&¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/avito/android/di/component/HomeDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/remote/notification/UnreadNotificationsInteractor;", "unreadNotificationsInteractor", "()Lcom/avito/android/remote/notification/UnreadNotificationsInteractor;", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;", "notificationCenterCounterInteractor", "()Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;", "Lcom/avito/android/preferences/UpdateStorage;", "updateStorage", "()Lcom/avito/android/preferences/UpdateStorage;", "Lcom/avito/android/remote/FavoriteSellersApi;", "favoriteSellersApi", "()Lcom/avito/android/remote/FavoriteSellersApi;", "Lcom/avito/android/advert/actions/HiddenAdvertsStorage;", "hiddenAdvertsStorage", "()Lcom/avito/android/advert/actions/HiddenAdvertsStorage;", "Lcom/avito/android/geo/GeoStorage;", "geoStorage", "()Lcom/avito/android/geo/GeoStorage;", "Lcom/avito/android/lib/util/DarkThemeConfig;", "darkThemeConfig", "()Lcom/avito/android/lib/util/DarkThemeConfig;", "Lcom/avito/android/remote/StoriesApi;", "storiesApi", "()Lcom/avito/android/remote/StoriesApi;", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationStorage;", "defaultSearchLocationStorage", "()Lcom/avito/android/home/default_search_location/DefaultSearchLocationStorage;", "Lcom/avito/android/ab_tests/groups/HomeSkeletonTestGroup;", "homeSkeletonTestGroup", "()Lcom/avito/android/ab_tests/groups/HomeSkeletonTestGroup;", "Lcom/avito/android/ab_tests/configs/AntifraudStartupBannerTestGroup;", "startupBannerTestGroup", "()Lcom/avito/android/ab_tests/configs/AntifraudStartupBannerTestGroup;", "Lcom/avito/android/ab_tests/configs/HomeNewRubricatorTestGroup;", "homeNewRubricatorTestGroup", "()Lcom/avito/android/ab_tests/configs/HomeNewRubricatorTestGroup;", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/ViewedItemsTabTestGroup;", "viewedItemsWidgetOnMainTestGroup", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface HomeDependencies extends ComponentDependencies {
    @Override // com.avito.android.di.component.StoriesDependencies, com.avito.android.settings.di.SettingsDependencies
    @NotNull
    DarkThemeConfig darkThemeConfig();

    @NotNull
    DefaultSearchLocationStorage defaultSearchLocationStorage();

    @Override // com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.public_profile.di.PublicProfileFragmentDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.user_subscribers.di.UserSubscribersDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    FavoriteSellersApi favoriteSellersApi();

    @Override // com.avito.android.location_list.di.LocationListDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.geo.di.GeoDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies
    @NotNull
    GeoStorage geoStorage();

    @NotNull
    HiddenAdvertsStorage hiddenAdvertsStorage();

    @NotNull
    HomeNewRubricatorTestGroup homeNewRubricatorTestGroup();

    @NotNull
    HomeSkeletonTestGroup homeSkeletonTestGroup();

    @NotNull
    NotificationCenterCounterInteractor notificationCenterCounterInteractor();

    @NotNull
    AntifraudStartupBannerTestGroup startupBannerTestGroup();

    @Override // com.avito.android.di.component.StoriesDependencies
    @NotNull
    StoriesApi storiesApi();

    @NotNull
    UnreadNotificationsInteractor unreadNotificationsInteractor();

    @NotNull
    UpdateStorage updateStorage();

    @NotNull
    SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> viewedItemsWidgetOnMainTestGroup();
}
