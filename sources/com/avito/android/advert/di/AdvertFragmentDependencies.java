package com.avito.android.advert.di;

import com.avito.android.FavoriteSellersRepository;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.AdvertContactApplyWithoutChat;
import com.avito.android.ab_tests.AdvertDetailsNoCallFeedback;
import com.avito.android.ab_tests.AdvertSpeedUpTest;
import com.avito.android.ab_tests.AntiFraudCheckList;
import com.avito.android.ab_tests.JobApplicationProgressBar;
import com.avito.android.ab_tests.JustDialSellerPhoneTestGroup;
import com.avito.android.ab_tests.OrangeAdBage;
import com.avito.android.ab_tests.SendEmployersPhoneOnCallToSellerButtonClickInResumes;
import com.avito.android.ab_tests.configs.AntiFraudCheckListTestGroup;
import com.avito.android.ab_tests.configs.OrangeAdBadgeTestGroup;
import com.avito.android.ab_tests.configs.SravniWebTestGroup;
import com.avito.android.ab_tests.configs.TinkoffCreditCalculatorTestGroup;
import com.avito.android.ab_tests.groups.AdvertAutotekaTeaserInGalleryTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsIcebreakerStyleTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceBadgeBarItemTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceImprovingContentItemsTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsNoCallFeedbackTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsPriceSubscriptionTestGroup;
import com.avito.android.ab_tests.groups.SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithControl2;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNoneControl2;
import com.avito.android.ab_tests.models.AbTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.advert.item.delivery.AdvertDeliveryStorage;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert_core.analytics.broker.SravniAnalyticsEventLogger;
import com.avito.android.advert_core.teaser.TeaserObserver;
import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.screens.TrackerInfoProvider;
import com.avito.android.autoteka.remote.AutotekaApi;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.AppCallsUsageTracker;
import com.avito.android.calls_shared.CallUuidProvider;
import com.avito.android.cart_fab.CartFabDependencies;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.di.AdvertItemAbDependencies;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.domteka.DomotekaApi;
import com.avito.android.favorite.FavoriteAdvertsEventInteractor;
import com.avito.android.favorite.FavoriteAdvertsUploadInteractor;
import com.avito.android.favorites.FavoriteAdvertsSyncEventProvider;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.job.JobApi;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.AsyncPhoneApi;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.safedeal.remote.SafeDealApi;
import com.avito.android.serp.ad.MyTargetImageBgProvider;
import com.avito.android.server_time.TimeSource;
import com.avito.android.server_time.UtcTimeSource;
import com.avito.android.spare_parts.remote.SparePartsApi;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.sravni.android.bankproduct.network.di.SravniNetworkConfiguration;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ü\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H&¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H&¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H&¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H&¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H&¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H&¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H&¢\u0006\u0004\b5\u00106J\u000f\u00108\u001a\u000207H&¢\u0006\u0004\b8\u00109J\u000f\u0010;\u001a\u00020:H&¢\u0006\u0004\b;\u0010<J\u000f\u0010>\u001a\u00020=H&¢\u0006\u0004\b>\u0010?J\u000f\u0010A\u001a\u00020@H&¢\u0006\u0004\bA\u0010BJ\u000f\u0010D\u001a\u00020CH&¢\u0006\u0004\bD\u0010EJ\u000f\u0010G\u001a\u00020FH&¢\u0006\u0004\bG\u0010HJ\u000f\u0010J\u001a\u00020IH&¢\u0006\u0004\bJ\u0010KJ\u000f\u0010M\u001a\u00020LH&¢\u0006\u0004\bM\u0010NJ\u000f\u0010P\u001a\u00020OH&¢\u0006\u0004\bP\u0010QJ\u000f\u0010S\u001a\u00020RH&¢\u0006\u0004\bS\u0010TJ\u000f\u0010V\u001a\u00020UH&¢\u0006\u0004\bV\u0010WJ\u000f\u0010Y\u001a\u00020XH&¢\u0006\u0004\bY\u0010ZJ\u000f\u0010\\\u001a\u00020[H&¢\u0006\u0004\b\\\u0010]J\u000f\u0010_\u001a\u00020^H&¢\u0006\u0004\b_\u0010`J\u000f\u0010b\u001a\u00020aH&¢\u0006\u0004\bb\u0010cJ\u0015\u0010f\u001a\b\u0012\u0004\u0012\u00020e0dH'¢\u0006\u0004\bf\u0010gJ\u0015\u0010j\u001a\b\u0012\u0004\u0012\u00020i0hH&¢\u0006\u0004\bj\u0010kJ\u000f\u0010m\u001a\u00020lH&¢\u0006\u0004\bm\u0010nJ\u000f\u0010p\u001a\u00020oH&¢\u0006\u0004\bp\u0010qJ\u0015\u0010t\u001a\b\u0012\u0004\u0012\u00020s0rH&¢\u0006\u0004\bt\u0010uJ\u000f\u0010w\u001a\u00020vH&¢\u0006\u0004\bw\u0010xJ\u000f\u0010z\u001a\u00020yH&¢\u0006\u0004\bz\u0010{J\u000f\u0010}\u001a\u00020|H&¢\u0006\u0004\b}\u0010~J\u0012\u0010\u0001\u001a\u00020H&¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u0001H&¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u0001H&¢\u0006\u0006\b\u0001\u0010\u0001J\u0018\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010dH'¢\u0006\u0005\b\u0001\u0010gJ\u0018\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010rH'¢\u0006\u0005\b\u0001\u0010uJ\u0018\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010rH&¢\u0006\u0005\b\u0001\u0010uJ\u001a\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H&¢\u0006\u0006\b\u0001\u0010\u0001J\u0018\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010rH&¢\u0006\u0005\b\u0001\u0010uJ\u0018\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010rH&¢\u0006\u0005\b\u0001\u0010uJ\u001a\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H'¢\u0006\u0006\b\u0001\u0010\u0001J\u0018\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010dH'¢\u0006\u0005\b\u0001\u0010gJ\u001a\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H'¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u0001H&¢\u0006\u0006\b\u0001\u0010\u0001J\u0018\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010hH'¢\u0006\u0005\b\u0001\u0010kJ\u001a\u0010¡\u0001\u001a\n\u0012\u0005\u0012\u00030 \u00010\u0001H'¢\u0006\u0006\b¡\u0001\u0010\u0001J\u0018\u0010£\u0001\u001a\t\u0012\u0005\u0012\u00030¢\u00010hH&¢\u0006\u0005\b£\u0001\u0010kJ\u0018\u0010¥\u0001\u001a\t\u0012\u0005\u0012\u00030¤\u00010rH&¢\u0006\u0005\b¥\u0001\u0010uJ\u0013\u0010§\u0001\u001a\u00030¦\u0001H&¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u0013\u0010ª\u0001\u001a\u00030©\u0001H&¢\u0006\u0006\bª\u0001\u0010«\u0001¨\u0006¬\u0001"}, d2 = {"Lcom/avito/android/advert/di/AdvertFragmentDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/di/AdvertItemAbDependencies;", "Lcom/avito/android/cart_fab/CartFabDependencies;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "Lcom/avito/android/domteka/DomotekaApi;", "domotekaApi", "()Lcom/avito/android/domteka/DomotekaApi;", "Lcom/avito/android/profile/ProfileInfoStorage;", "profileInfoStorage", "()Lcom/avito/android/profile/ProfileInfoStorage;", "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "advertDetailsApi", "()Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "Lru/avito/messenger/api/AvitoMessengerApi;", "avitoMessengerApi", "()Lru/avito/messenger/api/AvitoMessengerApi;", "Lcom/avito/android/job/JobApi;", "jobApi", "()Lcom/avito/android/job/JobApi;", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestsConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "Ljava/util/Locale;", "locale", "()Ljava/util/Locale;", "Lcom/avito/android/favorites/FavoriteAdvertsSyncEventProvider;", "favoriteAdvertsSyncEventProvider", "()Lcom/avito/android/favorites/FavoriteAdvertsSyncEventProvider;", "Lcom/avito/android/db/favorites/FavoritesSyncDao;", "favoritesSyncDao", "()Lcom/avito/android/db/favorites/FavoritesSyncDao;", "Lcom/avito/android/favorite/FavoriteAdvertsEventInteractor;", "favoriteAdvertsEventInteractor", "()Lcom/avito/android/favorite/FavoriteAdvertsEventInteractor;", "Lcom/avito/android/favorite/FavoriteAdvertsUploadInteractor;", "favoriteAdvertsUploadInteractor", "()Lcom/avito/android/favorite/FavoriteAdvertsUploadInteractor;", "Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "viewedAdvertsDao", "()Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "viewedAdvertsEventInteractor", "()Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "()Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "trackerInfoProvider", "()Lcom/avito/android/analytics/screens/TrackerInfoProvider;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "()Lcom/avito/android/server_time/TimeSource;", "Lcom/avito/android/server_time/UtcTimeSource;", "utcTimeSource", "()Lcom/avito/android/server_time/UtcTimeSource;", "Lcom/avito/android/autoteka/remote/AutotekaApi;", "autotekaApi", "()Lcom/avito/android/autoteka/remote/AutotekaApi;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "typedErrorThrowableConverter", "()Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "Lcom/avito/android/advert/item/delivery/AdvertDeliveryStorage;", "advertDeliveryStorage", "()Lcom/avito/android/advert/item/delivery/AdvertDeliveryStorage;", "Lcom/avito/android/remote/DeliveryApi;", "deliveryApi", "()Lcom/avito/android/remote/DeliveryApi;", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "()Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "Lcom/avito/android/remote/FavoriteSellersApi;", "favoriteSellersApi", "()Lcom/avito/android/remote/FavoriteSellersApi;", "Lcom/avito/android/FavoriteSellersRepository;", "favoriteSellersRepository", "()Lcom/avito/android/FavoriteSellersRepository;", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "()Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "Lcom/avito/android/spare_parts/remote/SparePartsApi;", "sparePartsApi", "()Lcom/avito/android/spare_parts/remote/SparePartsApi;", "Lcom/avito/android/safedeal/remote/SafeDealApi;", "safeDealApi", "()Lcom/avito/android/safedeal/remote/SafeDealApi;", "Lcom/avito/android/remote/ProfileApi;", "profileApi", "()Lcom/avito/android/remote/ProfileApi;", "Lcom/avito/android/advert_core/teaser/TeaserObserver;", "teaserObserver", "()Lcom/avito/android/advert_core/teaser/TeaserObserver;", "Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "myTargetImageBgProvider", "()Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "graphitePrefix", "()Lcom/avito/android/analytics/grafana/GraphitePrefix;", "Lcom/avito/android/ab_tests/models/AbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithControl2;", "justDialSellerPhoneTestGroup", "()Lcom/avito/android/ab_tests/models/AbTestGroup;", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/SravniWebTestGroup;", "sravniWebTestGroup", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lru/sravni/android/bankproduct/network/di/SravniNetworkConfiguration;", "sravniConfiguration", "()Lru/sravni/android/bankproduct/network/di/SravniNetworkConfiguration;", "Lcom/avito/android/advert_core/analytics/broker/SravniAnalyticsEventLogger;", "sravniEventLogger", "()Lcom/avito/android/advert_core/analytics/broker/SravniAnalyticsEventLogger;", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdvertDetailsPriceSubscriptionTestGroup;", "advertDetailsPriceSubscription", "()Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/analytics/NetworkTypeProvider;", "networkTypeProvider", "()Lcom/avito/android/analytics/NetworkTypeProvider;", "Lcom/avito/android/remote/AsyncPhoneApi;", "asyncPhoneApi", "()Lcom/avito/android/remote/AsyncPhoneApi;", "Lcom/avito/android/calls/remote/CallsApi;", "callsApi", "()Lcom/avito/android/calls/remote/CallsApi;", "Lcom/avito/android/calls_shared/AppCallsUsageTracker;", "appCallUsageTracker", "()Lcom/avito/android/calls_shared/AppCallsUsageTracker;", "Lcom/avito/android/calls_shared/CallUuidProvider;", "callUuidProvider", "()Lcom/avito/android/calls_shared/CallUuidProvider;", "Lcom/avito/android/permissions/PermissionChecker;", "permissionChecker", "()Lcom/avito/android/permissions/PermissionChecker;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithNoneControl2;", "advertSpeedUpTest", "Lcom/avito/android/ab_tests/groups/AdvertDetailsNoCallFeedbackTestGroup;", "advertDetailsNoCallFeedbackTestGroup", "Lcom/avito/android/ab_tests/groups/AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup;", "advertDetailsMarketplaceNoPurchaseFeedbackTestGroup", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdvertDetailsMarketplaceImprovingContentItemsTestGroup;", "advertDetailsMarketplaceImprovingContentItemsTestGroup", "()Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithNone;", "advertDetailsMarketplaceDeliveryItemTestGroup", "Lcom/avito/android/ab_tests/groups/AdvertDetailsMarketplaceBadgeBarItemTestGroup;", "advertDetailsMarketplaceBadgeBarItemTestGroup", "advertContactApplyWithoutChatTestGroup", "Lcom/avito/android/ab_tests/groups/SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup;", "sendEmployersPhoneOnCallToSellerButtonClickInResumes", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "jobApplicationProgressBarTestGroup", "Lcom/avito/android/ab_tests/groups/AdvertDetailsIcebreakerStyleTestGroup;", "advertDetailsIcebreakerStyleTestGroup", "()Lcom/avito/android/ab_tests/groups/AdvertDetailsIcebreakerStyleTestGroup;", "Lcom/avito/android/ab_tests/configs/AntiFraudCheckListTestGroup;", "antiFraudCheckListTest", "Lcom/avito/android/ab_tests/configs/OrangeAdBadgeTestGroup;", "orangeAdBadgeTestGroup", "Lcom/avito/android/ab_tests/configs/TinkoffCreditCalculatorTestGroup;", "tinkoffCreditCalculatorTestGroup", "Lcom/avito/android/ab_tests/groups/AdvertAutotekaTeaserInGalleryTestGroup;", "advertAutotekaTeaserInGalleryTestGroup", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "()Lcom/avito/android/html_formatter/HtmlCleaner;", "Lcom/avito/android/html_formatter/HtmlRenderer;", "htmlRenderer", "()Lcom/avito/android/html_formatter/HtmlRenderer;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertFragmentDependencies extends CoreComponentDependencies, AdvertItemAbDependencies, CartFabDependencies {
    @Override // com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies
    @NotNull
    AbTestsConfigProvider abTestsConfigProvider();

    @NotNull
    ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> advertAutotekaTeaserInGalleryTestGroup();

    @AdvertContactApplyWithoutChat
    @NotNull
    ExposedAbTestGroup<SimpleTestGroupWithNone> advertContactApplyWithoutChatTestGroup();

    @NotNull
    AdvertDeliveryStorage advertDeliveryStorage();

    @Override // com.avito.android.advert.badge_details.di.BadgeDetailsDependencies, com.avito.android.advert.consultation_form.di.ConsultationFormDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    AdvertDetailsApi advertDetailsApi();

    @NotNull
    AdvertDetailsIcebreakerStyleTestGroup advertDetailsIcebreakerStyleTestGroup();

    @NotNull
    ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceBadgeBarItemTestGroup> advertDetailsMarketplaceBadgeBarItemTestGroup();

    @NotNull
    ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> advertDetailsMarketplaceDeliveryItemTestGroup();

    @NotNull
    ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup> advertDetailsMarketplaceImprovingContentItemsTestGroup();

    @NotNull
    ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup> advertDetailsMarketplaceNoPurchaseFeedbackTestGroup();

    @AdvertDetailsNoCallFeedback
    @NotNull
    ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup> advertDetailsNoCallFeedbackTestGroup();

    @NotNull
    ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup> advertDetailsPriceSubscription();

    @AdvertSpeedUpTest
    @NotNull
    AbTestGroup<SimpleTestGroupWithNoneControl2> advertSpeedUpTest();

    @AntiFraudCheckList
    @NotNull
    SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup> antiFraudCheckListTest();

    @NotNull
    AppCallsUsageTracker appCallUsageTracker();

    @Override // com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies
    @NotNull
    AsyncPhoneApi asyncPhoneApi();

    @NotNull
    AutotekaApi autotekaApi();

    @NotNull
    AvitoMessengerApi avitoMessengerApi();

    @Override // com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies
    @NotNull
    CallUuidProvider callUuidProvider();

    @Override // com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies, com.avito.android.in_app_calls.di.SendCallLogsDependencies
    @NotNull
    CallsApi callsApi();

    @Override // com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    ConnectivityProvider connectivityProvider();

    @Override // com.avito.android.payment.lib.di.PaymentLibraryDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies
    @NotNull
    DeepLinkFactory deepLinkFactory();

    @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies
    @NotNull
    DeliveryApi deliveryApi();

    @NotNull
    DomotekaApi domotekaApi();

    @Override // com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    FavoriteAdvertsEventInteractor favoriteAdvertsEventInteractor();

    @Override // com.avito.android.advert.closed.di.ClosedAdvertDependencies
    @NotNull
    FavoriteAdvertsSyncEventProvider favoriteAdvertsSyncEventProvider();

    @Override // com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    FavoriteAdvertsUploadInteractor favoriteAdvertsUploadInteractor();

    @Override // com.avito.android.user_subscribers.di.UserSubscribersDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    FavoriteSellersApi favoriteSellersApi();

    @Override // com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    FavoriteSellersRepository favoriteSellersRepository();

    @Override // com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    FavoritesSyncDao favoritesSyncDao();

    @Override // com.avito.android.item_map.di.ItemMapDependencies
    @NotNull
    GraphitePrefix graphitePrefix();

    @Override // com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrSellerCalendarParametersDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierSummaryDependencies
    @NotNull
    HtmlCleaner htmlCleaner();

    @Override // com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrSellerCalendarParametersDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierSummaryDependencies
    @NotNull
    HtmlRenderer htmlRenderer();

    @NotNull
    JobApi jobApi();

    @JobApplicationProgressBar
    @NotNull
    ExposedAbTestGroup<SimpleTestGroup> jobApplicationProgressBarTestGroup();

    @JustDialSellerPhoneTestGroup
    @NotNull
    AbTestGroup<SimpleTestGroupWithControl2> justDialSellerPhoneTestGroup();

    @Override // com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    Locale locale();

    @NotNull
    MyTargetImageBgProvider myTargetImageBgProvider();

    @Override // com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies
    @NotNull
    NetworkTypeProvider networkTypeProvider();

    @NotNull
    NotificationManagerProvider notificationManagerProvider();

    @OrangeAdBage
    @NotNull
    ExposedAbTestGroup<OrangeAdBadgeTestGroup> orangeAdBadgeTestGroup();

    @Override // com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies
    @NotNull
    PermissionChecker permissionChecker();

    @Override // com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationDependencies, com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneDependencies, com.avito.android.profile_phones.phone_action.di.PhoneActionDependencies, com.avito.android.profile.tfa.settings.di.TfaSettingsDependencies
    @NotNull
    ProfileApi profileApi();

    @NotNull
    ProfileInfoStorage profileInfoStorage();

    @Override // com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies
    @NotNull
    SafeDealApi safeDealApi();

    @SendEmployersPhoneOnCallToSellerButtonClickInResumes
    @NotNull
    AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup> sendEmployersPhoneOnCallToSellerButtonClickInResumes();

    @NotNull
    SparePartsApi sparePartsApi();

    @NotNull
    SravniNetworkConfiguration sravniConfiguration();

    @NotNull
    SravniAnalyticsEventLogger sravniEventLogger();

    @NotNull
    SingleManuallyExposedAbTestGroup<SravniWebTestGroup> sravniWebTestGroup();

    @NotNull
    TeaserObserver teaserObserver();

    @Override // com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    TimeSource timeSource();

    @NotNull
    SingleManuallyExposedAbTestGroup<TinkoffCreditCalculatorTestGroup> tinkoffCreditCalculatorTestGroup();

    @NotNull
    TrackerInfoProvider trackerInfoProvider();

    @Override // com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies
    @NotNull
    TreeStateIdGenerator treeStateIdGenerator();

    @Override // com.avito.android.payment.lib.di.PaymentLibraryDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies, com.avito.android.profile.sessions.list.di.SessionsListDependencies, com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutDependencies, com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.booking.di.BookingInfoDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.verification.di.VerificationsListDependencies, com.avito.android.verification.di.VerificationStatusDependencies, com.avito.android.verification.di.VerificationActionDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    TypedErrorThrowableConverter typedErrorThrowableConverter();

    @NotNull
    UtcTimeSource utcTimeSource();

    @Override // com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    ViewedAdvertsDao viewedAdvertsDao();

    @Override // com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    ViewedAdvertsEventInteractor viewedAdvertsEventInteractor();
}
