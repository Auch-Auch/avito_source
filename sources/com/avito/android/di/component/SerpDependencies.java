package com.avito.android.di.component;

import com.avito.android.CategoriesInteractor;
import com.avito.android.IdProvider;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.AutoGenerationsFilterWithPhotos;
import com.avito.android.ab_tests.JustDialSellerPhoneTestGroup;
import com.avito.android.ab_tests.OrangeAdBage;
import com.avito.android.ab_tests.configs.OrangeAdBadgeTestGroup;
import com.avito.android.ab_tests.groups.SerpSkeletonTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithControl2;
import com.avito.android.ab_tests.models.AbTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.cart_fab.CartFabDependencies;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.db.DbHelper;
import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.di.AdvertItemAbDependencies;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.favorite.FavoriteAdvertsEventInteractor;
import com.avito.android.favorite.FavoriteAdvertsUploadInteractor;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.preferences.MutableTokenStorage;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.AsyncPhoneApi;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.search.subscriptions.SearchSubscriptionConsumer;
import com.avito.android.serp.ad.MyTargetImageBgProvider;
import com.avito.android.serp.dfp_mobile_ads.DfpMobileAdsWrapper;
import com.avito.android.server_time.TimeSource;
import com.avito.android.server_time.UtcTimeSource;
import com.avito.android.subscriptions.remote.SubscriptionsApi;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H&¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H&¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H&¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H&¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H&¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H&¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H&¢\u0006\u0004\b5\u00106J\u000f\u00108\u001a\u000207H&¢\u0006\u0004\b8\u00109J\u000f\u0010;\u001a\u00020:H&¢\u0006\u0004\b;\u0010<J\u000f\u0010>\u001a\u00020=H&¢\u0006\u0004\b>\u0010?J\u000f\u0010A\u001a\u00020@H&¢\u0006\u0004\bA\u0010BJ\u000f\u0010D\u001a\u00020CH&¢\u0006\u0004\bD\u0010EJ\u000f\u0010G\u001a\u00020FH&¢\u0006\u0004\bG\u0010HJ\u000f\u0010J\u001a\u00020IH&¢\u0006\u0004\bJ\u0010KJ\u000f\u0010M\u001a\u00020LH&¢\u0006\u0004\bM\u0010NJ\u000f\u0010P\u001a\u00020OH&¢\u0006\u0004\bP\u0010QJ\u000f\u0010S\u001a\u00020RH&¢\u0006\u0004\bS\u0010TJ\u0015\u0010W\u001a\b\u0012\u0004\u0012\u00020V0UH'¢\u0006\u0004\bW\u0010XJ\u000f\u0010Z\u001a\u00020YH&¢\u0006\u0004\bZ\u0010[J\u0015\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\\H'¢\u0006\u0004\b^\u0010_J\u0015\u0010b\u001a\b\u0012\u0004\u0012\u00020a0`H'¢\u0006\u0004\bb\u0010c¨\u0006d"}, d2 = {"Lcom/avito/android/di/component/SerpDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/di/AdvertItemAbDependencies;", "Lcom/avito/android/cart_fab/CartFabDependencies;", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestsConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "Lru/avito/messenger/api/AvitoMessengerApi;", "avitoMessengerApi", "()Lru/avito/messenger/api/AvitoMessengerApi;", "Lcom/avito/android/CategoriesInteractor;", "categoriesInteractor", "()Lcom/avito/android/CategoriesInteractor;", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "()Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "Lcom/avito/android/db/DbHelper;", "dbHelper", "()Lcom/avito/android/db/DbHelper;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "Lcom/avito/android/serp/dfp_mobile_ads/DfpMobileAdsWrapper;", "dfpMobileAdsWrapper", "()Lcom/avito/android/serp/dfp_mobile_ads/DfpMobileAdsWrapper;", "Lcom/avito/android/favorite/FavoriteAdvertsEventInteractor;", "favoriteAdvertsEventInteractor", "()Lcom/avito/android/favorite/FavoriteAdvertsEventInteractor;", "Lcom/avito/android/favorite/FavoriteAdvertsUploadInteractor;", "favoriteAdvertsUploadInteractor", "()Lcom/avito/android/favorite/FavoriteAdvertsUploadInteractor;", "Lcom/avito/android/db/favorites/FavoritesSyncDao;", "favoritesSyncDao", "()Lcom/avito/android/db/favorites/FavoritesSyncDao;", "Lcom/avito/android/IdProvider;", "idProvider", "()Lcom/avito/android/IdProvider;", "Ljava/util/Locale;", "locale", "()Ljava/util/Locale;", "Lcom/avito/android/preferences/MutableTokenStorage;", "mutableGcmTokenStorage", "()Lcom/avito/android/preferences/MutableTokenStorage;", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "()Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "Lcom/avito/android/profile/ProfileInfoStorage;", "profileInfoStorage", "()Lcom/avito/android/profile/ProfileInfoStorage;", "Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "myTargetImageBgProvider", "()Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "Lcom/avito/android/remote/SearchApi;", "searchApi", "()Lcom/avito/android/remote/SearchApi;", "Lcom/avito/android/remote/AsyncPhoneApi;", "asyncPhoneApi", "()Lcom/avito/android/remote/AsyncPhoneApi;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;", "searchSubscriptionConsumer", "()Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;", "Lcom/avito/android/db/SearchSubscriptionDao;", "searchSubscriptionDao", "()Lcom/avito/android/db/SearchSubscriptionDao;", "Lcom/avito/android/subscriptions/remote/SubscriptionsApi;", "subscriptionsApi", "()Lcom/avito/android/subscriptions/remote/SubscriptionsApi;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "()Lcom/avito/android/server_time/TimeSource;", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "()Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "typedErrorThrowableConverter", "()Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "Lcom/avito/android/server_time/UtcTimeSource;", "utcTimeSource", "()Lcom/avito/android/server_time/UtcTimeSource;", "Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "viewedAdvertsDao", "()Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "viewedAdvertsEventInteractor", "()Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "Lcom/avito/android/ab_tests/models/AbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithControl2;", "justDialSellerPhoneTestGroup", "()Lcom/avito/android/ab_tests/models/AbTestGroup;", "Lcom/avito/android/ab_tests/groups/SerpSkeletonTestGroup;", "serpSkeletonTestGroup", "()Lcom/avito/android/ab_tests/groups/SerpSkeletonTestGroup;", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/OrangeAdBadgeTestGroup;", "orangeAdBadgeTestGroup", "()Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "autoGenerationsFilterWithPhotosTestGroup", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface SerpDependencies extends CoreComponentDependencies, AdvertItemAbDependencies, CartFabDependencies {
    @Override // com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.wizard.di.WizardDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies
    @NotNull
    AbTestsConfigProvider abTestsConfigProvider();

    @Override // com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies
    @NotNull
    AsyncPhoneApi asyncPhoneApi();

    @Override // com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.select.di.SelectDialogDependencies
    @AutoGenerationsFilterWithPhotos
    @NotNull
    SingleManuallyExposedAbTestGroup<SimpleTestGroup> autoGenerationsFilterWithPhotosTestGroup();

    @Override // com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    AvitoMessengerApi avitoMessengerApi();

    @Override // com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.search.filter.di.FiltersDependencies
    @NotNull
    CategoriesInteractor categoriesInteractor();

    @Override // com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsDependencies, com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    ConnectivityProvider connectivityProvider();

    @Override // com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.photo_picker.legacy.di.PhotoContentProviderDependencies
    @NotNull
    DbHelper dbHelper();

    @Override // com.avito.android.di.component.StoriesDependencies, com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.notification_center.list.di.NotificationCenterListDependencies, com.avito.android.webview.di.WebViewDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.di.MessageIsReadMarkerDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies
    @NotNull
    DeepLinkFactory deepLinkFactory();

    @NotNull
    DfpMobileAdsWrapper dfpMobileAdsWrapper();

    @Override // com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.viewed_items.di.ViewedItemsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    FavoriteAdvertsEventInteractor favoriteAdvertsEventInteractor();

    @Override // com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    FavoriteAdvertsUploadInteractor favoriteAdvertsUploadInteractor();

    @Override // com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    FavoritesSyncDao favoritesSyncDao();

    @Override // com.avito.android.developments_catalog.di.DevelopmentsCatalogDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies
    @NotNull
    IdProvider idProvider();

    @Override // com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.advert.di.AdvertFragmentDependencies
    @JustDialSellerPhoneTestGroup
    @NotNull
    AbTestGroup<SimpleTestGroupWithControl2> justDialSellerPhoneTestGroup();

    @Override // com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.viewed_items.di.ViewedItemsDependencies, com.avito.android.notification_center.list.di.NotificationCenterListDependencies, com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsDependencies, com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedDependencies, com.avito.android.express_cv.di.ExpressCvDependencies, com.avito.android.basket.paid_services.di.PaidServicesDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponentDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    Locale locale();

    @NotNull
    MutableTokenStorage mutableGcmTokenStorage();

    @Override // com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    MyTargetImageBgProvider myTargetImageBgProvider();

    @Override // com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.di.SendMetricsServiceDependencies, com.avito.android.notifications_settings.di.NotificationsSettingsDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    NotificationManagerProvider notificationManagerProvider();

    @Override // com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.advert.di.AdvertFragmentDependencies
    @OrangeAdBage
    @NotNull
    ExposedAbTestGroup<OrangeAdBadgeTestGroup> orangeAdBadgeTestGroup();

    @Override // com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsDependencies, com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedDependencies, com.avito.android.authorization.login.di.LoginDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.settings.di.SettingsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    ProfileInfoStorage profileInfoStorage();

    @Override // com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.category.di.CategoryDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.select.di.SelectDialogDependencies, com.avito.android.settings.di.SettingsDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies
    @NotNull
    SearchApi searchApi();

    @Override // com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies
    @NotNull
    SearchSubscriptionConsumer searchSubscriptionConsumer();

    @Override // com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies
    @NotNull
    SearchSubscriptionDao searchSubscriptionDao();

    @NotNull
    SerpSkeletonTestGroup serpSkeletonTestGroup();

    @Override // com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies
    @NotNull
    SubscriptionsApi subscriptionsApi();

    @Override // com.avito.android.di.component.StoriesDependencies, com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.location_list.di.LocationListDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.phone_confirmation.di.PhoneConfirmationDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.viewed_items.di.ViewedItemsDependencies, com.avito.android.payment.di.component.PaymentDependencies, com.avito.android.notification_center.list.di.NotificationCenterListDependencies, com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsDependencies, com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedDependencies, com.avito.android.express_cv.di.ExpressCvDependencies, com.avito.android.geo.di.GeoDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.deep_linking.di.AppLinkDependencies, com.avito.android.certificate_pinning.di.UnsafeNetworkDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponentDependencies, com.avito.android.messenger.di.MessageIsReadMarkerDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.DirectReplyServiceDependencies, com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.deep_linking.di.DeepLinkingDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    TimeSource timeSource();

    @Override // com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies
    @NotNull
    TreeStateIdGenerator treeStateIdGenerator();

    @Override // com.avito.android.di.component.StoriesDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.service_subscription.di.SubscriptionFragmentDependencies, com.avito.android.location_list.di.LocationListDependencies, com.avito.android.developments_catalog.di.DevelopmentsCatalogDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.start_publish.di.StartPublishDependencies, com.avito.android.publish.di.NewAdvertDependencies, com.avito.android.publish_limits_info.history.di.PublishLimitsHistoryDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.viewed_items.di.ViewedItemsDependencies, com.avito.android.autoteka_details.di.AutotekaDetailsDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.profile_phones.phone_management.di.PhoneManagementDependencies, com.avito.android.code_confirmation.di.CodeConfirmationDependencies, com.avito.android.authorization.login.di.LoginDependencies, com.avito.android.authorization.reset_password.di.ResetPasswordDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.notes.di.AdvertDetailsNoteDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies, com.avito.android.profile.sessions.list.di.SessionsListDependencies, com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutDependencies, com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.booking.di.BookingInfoDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.verification.di.VerificationsListDependencies, com.avito.android.verification.di.VerificationStatusDependencies, com.avito.android.verification.di.VerificationActionDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    TypedErrorThrowableConverter typedErrorThrowableConverter();

    @Override // com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.favorites.di.FavoriteAdvertsDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    UtcTimeSource utcTimeSource();

    @Override // com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsDependencies, com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    ViewedAdvertsDao viewedAdvertsDao();

    @Override // com.avito.android.public_profile.di.ProfileAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.search.map.di.SearchMapDependencies, com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsDependencies, com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    ViewedAdvertsEventInteractor viewedAdvertsEventInteractor();
}
