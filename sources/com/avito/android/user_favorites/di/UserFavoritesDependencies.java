package com.avito.android.user_favorites.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.ViewedItemsTabTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.cart_fab.CartFabDependencies;
import com.avito.android.common.CounterInteractor;
import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.di.ComponentDependencies;
import com.avito.android.di.FavoriteSellers;
import com.avito.android.favorites.di.Favorites;
import com.avito.android.preferences.UserFavoritesStorage;
import com.avito.android.search.subscriptions.SearchSubscriptionObservable;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.viewed_items.ViewedItemsCountInteractor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H'¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H&¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/avito/android/user_favorites/di/UserFavoritesDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/cart_fab/CartFabDependencies;", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "()Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory3", "()Lcom/avito/android/util/SchedulersFactory3;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionObservable;", "searchSubscriptionObservable", "()Lcom/avito/android/search/subscriptions/SearchSubscriptionObservable;", "Lcom/avito/android/db/SearchSubscriptionDao;", "searchSubscriptionDao", "()Lcom/avito/android/db/SearchSubscriptionDao;", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "()Lcom/avito/android/account/AccountStorageInteractor;", "Lcom/avito/android/common/CounterInteractor;", "favoriteSellersCounterProvider", "()Lcom/avito/android/common/CounterInteractor;", "favoritesCounterInteractor", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/ViewedItemsTabTestGroup;", "viewedItemsTestGroup", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/viewed_items/ViewedItemsCountInteractor;", "viewedItemsCountInteractor", "()Lcom/avito/android/viewed_items/ViewedItemsCountInteractor;", "Lcom/avito/android/preferences/UserFavoritesStorage;", "userFavoritesStorage", "()Lcom/avito/android/preferences/UserFavoritesStorage;", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
public interface UserFavoritesDependencies extends ComponentDependencies, CartFabDependencies {
    @Override // com.avito.android.favorite_sellers.di.FavoriteSellersDependencies, com.avito.android.fees.di.FeesActivityDependencies, com.avito.android.photo_picker.legacy.di.PhotoPickerDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    AbTestsConfigProvider abTestConfigProvider();

    @Override // com.avito.android.abuse.details.di.AbuseDetailsDependencies, com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.residential_complex_search.di.ResidentialComplexComponentDependencies, com.avito.android.webview.di.WebViewDependencies, com.avito.android.profile.password_change.di.PasswordChangeDependencies, com.avito.android.profile.password_setting.di.PasswordSettingDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.user_adverts.expired_count.di.UserAdvertsInfoDependencies, com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutDependencies
    @NotNull
    AccountStorageInteractor accountStorageInteractor();

    @Override // com.avito.android.grouping_adverts.di.GroupingAdvertsDependencies, com.avito.android.delivery.di.component.DeliveryRdsCommonDependencies, com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentDependencies, com.avito.android.di.component.HomeActivityDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.start_publish.di.StartPublishDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.rating.user_reviews.di.UserReviewsDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.blocked_ip.di.BlockedIpDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies
    @NotNull
    ActivityIntentFactory activityIntentFactory();

    @Override // com.avito.android.favorite_sellers.di.FavoriteSellersDependencies, com.avito.android.favorite_sellers.service.di.FavoriteSellerServiceDependencies
    @FavoriteSellers
    @NotNull
    CounterInteractor favoriteSellersCounterProvider();

    @Favorites
    @NotNull
    CounterInteractor favoritesCounterInteractor();

    @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareDependencies, com.avito.android.fees.di.PackageFeeComponentDependencies, com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentDependencies, com.avito.android.user_adverts.items_search.di.ProfileItemsSearchDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.vas_performance.di.applied_services.AppliedServicesDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.info.di.InfoActivityDependencies, com.avito.android.push.UpdateInstanceIdDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies
    @NotNull
    SchedulersFactory schedulersFactory();

    @Override // com.avito.android.grouping_adverts.di.GroupingAdvertsDependencies, com.avito.android.delivery.di.component.DeliveryRdsCommonDependencies, com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentDependencies, com.avito.android.di.component.HomeActivityDependencies, com.avito.android.di.component.StoriesDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.start_publish.di.StartPublishDependencies, com.avito.android.publish_limits_info.history.di.PublishLimitsHistoryDependencies, com.avito.android.rating.user_reviews.di.UserReviewsDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationDependencies, com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneDependencies, com.avito.android.profile_phones.phone_action.di.PhoneActionDependencies, com.avito.android.profile_phones.phones_list.actions.di.PhoneActionsDependencies
    @NotNull
    SchedulersFactory3 schedulersFactory3();

    @Override // com.avito.android.di.component.SerpDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies
    @NotNull
    SearchSubscriptionDao searchSubscriptionDao();

    @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies
    @NotNull
    SearchSubscriptionObservable searchSubscriptionObservable();

    @Override // com.avito.android.viewed_items.di.ViewedItemsDependencies
    @NotNull
    UserFavoritesStorage userFavoritesStorage();

    @Override // com.avito.android.viewed_items.di.ViewedItemsDependencies
    @NotNull
    ViewedItemsCountInteractor viewedItemsCountInteractor();

    @NotNull
    SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> viewedItemsTestGroup();
}
