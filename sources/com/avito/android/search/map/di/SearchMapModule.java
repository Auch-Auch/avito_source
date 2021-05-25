package com.avito.android.search.map.di;

import com.avito.android.Features;
import com.avito.android.ab_tests.groups.ViewedItemsTabTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.async_phone.AsyncPhoneAuthRouter;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.google.GoogleAvitoMapAttachHelper;
import com.avito.android.avito_map.yandex.YandexAvitoMapAttachHelper;
import com.avito.android.component.search.SuggestInteractor;
import com.avito.android.deep_linking.ClickStreamLinkHandler;
import com.avito.android.deep_linking.SimpleClickStreamLinkHandler;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.RichSnippetsModule;
import com.avito.android.di.module.SerpAdapterModule;
import com.avito.android.di.module.SerpItemConverterModule;
import com.avito.android.di.module.SpanAdapterModule;
import com.avito.android.di.module.WitcherModule;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.favorite.FavoriteAdvertsResourceProviderImpl;
import com.avito.android.inline_filters.di.InlineFiltersModule;
import com.avito.android.location.di.SavedLocationInteractorModule;
import com.avito.android.location.di.module.FindLocationModule;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.permissions.LocationPermissionProviderImpl;
import com.avito.android.redux.DefaultSubscribableStore;
import com.avito.android.redux.Middleware;
import com.avito.android.redux.Reducer;
import com.avito.android.redux.SubscribableStore;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SuggestParamsConverter;
import com.avito.android.remote.model.SuggestParamsConverterImpl;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.saved_searches.di.SavedSearchesModule;
import com.avito.android.search.SearchDeepLinkInteractor;
import com.avito.android.search.SearchDeepLinkInteractorImpl;
import com.avito.android.search.map.SearchMapFragment;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.SearchMapViewFactory;
import com.avito.android.search.map.SearchMapViewFactoryImpl;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.favorite_pins.FavoritePinsInteractor;
import com.avito.android.search.map.favorite_pins.FavouritePinsInteractorImpl;
import com.avito.android.search.map.interactor.MapAreaConverter;
import com.avito.android.search.map.interactor.MapAreaConverterImpl;
import com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor;
import com.avito.android.search.map.interactor.SearchMapAnalyticsInteractorImpl;
import com.avito.android.search.map.interactor.SearchMapInteractor;
import com.avito.android.search.map.interactor.SearchMapInteractorImpl;
import com.avito.android.search.map.metric.SearchMapTracker;
import com.avito.android.search.map.metric.SearchMapTrackerImpl;
import com.avito.android.search.map.middleware.AdvertItemEventMiddleware;
import com.avito.android.search.map.middleware.LoadMiddleware;
import com.avito.android.search.map.middleware.LocationMiddleware;
import com.avito.android.search.map.middleware.LocationMiddlewareImpl;
import com.avito.android.search.map.middleware.LoggingMiddleware;
import com.avito.android.search.map.middleware.LoggingMiddlewareImpl;
import com.avito.android.search.map.middleware.NavigationMiddleware;
import com.avito.android.search.map.middleware.NavigationMiddlewareImpl;
import com.avito.android.search.map.middleware.SubscriptionMiddleware;
import com.avito.android.search.map.provider.PublishFloatingViewsProvider;
import com.avito.android.search.map.provider.SearchHashProvider;
import com.avito.android.search.map.provider.SearchHashProviderImpl;
import com.avito.android.search.map.reducer.LoadReducer;
import com.avito.android.search.map.reducer.MapReducer;
import com.avito.android.search.map.reducer.PinAdvertsReducer;
import com.avito.android.search.map.reducer.SerpReducer;
import com.avito.android.search.map.reducer.SubscriptionReducer;
import com.avito.android.search.map.reducer.UiReducer;
import com.avito.android.search.map.utils.BottomSheetBehaviourEventsProvider;
import com.avito.android.search.map.utils.LatLngBoundsKt;
import com.avito.android.search.map.view.MarkerIconFactory;
import com.avito.android.search.map.view.MarkerIconFactoryImpl;
import com.avito.android.search.map.view.SerpListResourcesProvider;
import com.avito.android.search.map.view.advert.AdvertItemEventListener;
import com.avito.android.search.map.view.advert.AdvertItemEventListenerImpl;
import com.avito.android.search.subscriptions.SerpSearchSubscriptionInteractor;
import com.avito.android.search.subscriptions.SerpSearchSubscriptionInteractorImpl;
import com.avito.android.search.subscriptions.SubscribeSearchInteractor;
import com.avito.android.search.subscriptions.SubscribeSearchInteractorImpl;
import com.avito.android.serp.SerpSnippetInteractor;
import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.ad.AdResourceProviderImpl;
import com.avito.android.serp.adapter.promo_card.PromoCardItemPresenter;
import com.avito.android.serp.analytics.SerpTracker;
import com.avito.android.serp.analytics.SerpTrackerImpl;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.GeoContract;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.maps.model.LatLngBounds;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationItemConverter;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationItemConverterImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001BB\t\b\u0002¢\u0006\u0004\b@\u0010AJ\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\rJ§\u0001\u00102\u001a\u0018\u0012\t\u0012\u00070+¢\u0006\u0002\b0\u0012\t\u0012\u000701¢\u0006\u0002\b00/2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010.\u001a\u00020-H\u0007¢\u0006\u0004\b2\u00103J\u0017\u00107\u001a\u0002062\u0006\u00105\u001a\u000204H\u0007¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u0002092\u0006\u0010.\u001a\u00020-H\u0007¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<H\u0007¢\u0006\u0004\b>\u0010?¨\u0006C"}, d2 = {"Lcom/avito/android/search/map/di/SearchMapModule;", "", "Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "provideTreeParent$map_release", "(Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractor;)Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "provideTreeParent", "Lcom/avito/android/search/map/provider/PublishFloatingViewsProvider;", "providePublishFloatingViewsPresenter", "()Lcom/avito/android/search/map/provider/PublishFloatingViewsProvider;", "Lcom/avito/android/search/map/utils/BottomSheetBehaviourEventsProvider;", "provideSerpBottomSheetBehaviourProvider", "()Lcom/avito/android/search/map/utils/BottomSheetBehaviourEventsProvider;", "providePinAdvertsBottomSheetBehaviourProvider", "Lcom/avito/android/search/map/middleware/LoggingMiddleware;", "loggingMiddleware", "Lcom/avito/android/search/map/middleware/NavigationMiddleware;", "navigationMiddleware", "Lcom/avito/android/search/map/middleware/LoadMiddleware;", "loadMiddleware", "Lcom/avito/android/search/map/middleware/AdvertItemEventMiddleware;", "advertItemEventMiddleware", "Lcom/avito/android/search/map/middleware/LocationMiddleware;", "locationMiddleware", "Lcom/avito/android/search/map/middleware/SubscriptionMiddleware;", "subscriptionMiddleware", "Lcom/avito/android/search/map/reducer/LoadReducer;", "loadReducer", "Lcom/avito/android/search/map/reducer/SerpReducer;", "serpReducer", "Lcom/avito/android/search/map/reducer/MapReducer;", "mapReducer", "Lcom/avito/android/search/map/reducer/PinAdvertsReducer;", "pinAdvertsReducer", "Lcom/avito/android/search/map/reducer/UiReducer;", "uiReducer", "Lcom/avito/android/search/map/reducer/SubscriptionReducer;", "subscriptionReducer", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/search/map/view/SerpListResourcesProvider;", "resourceProvider", "Lcom/avito/android/search/map/SearchMapState;", "searchMapState", "Lcom/avito/android/search/map/SearchMapFragment$Factory$Arguments;", "arguments", "Lcom/avito/android/redux/SubscribableStore;", "Lkotlin/jvm/JvmWildcard;", "Lcom/avito/android/search/map/action/MapAction;", "provideStore", "(Lcom/avito/android/search/map/middleware/LoggingMiddleware;Lcom/avito/android/search/map/middleware/NavigationMiddleware;Lcom/avito/android/search/map/middleware/LoadMiddleware;Lcom/avito/android/search/map/middleware/AdvertItemEventMiddleware;Lcom/avito/android/search/map/middleware/LocationMiddleware;Lcom/avito/android/search/map/middleware/SubscriptionMiddleware;Lcom/avito/android/search/map/reducer/LoadReducer;Lcom/avito/android/search/map/reducer/SerpReducer;Lcom/avito/android/search/map/reducer/MapReducer;Lcom/avito/android/search/map/reducer/PinAdvertsReducer;Lcom/avito/android/search/map/reducer/UiReducer;Lcom/avito/android/search/map/reducer/SubscriptionReducer;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/search/map/view/SerpListResourcesProvider;Lcom/avito/android/search/map/SearchMapState;Lcom/avito/android/search/map/SearchMapFragment$Factory$Arguments;)Lcom/avito/android/redux/SubscribableStore;", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "provideAvitoMapAttachHelper", "(Lcom/avito/android/Features;)Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "Lcom/avito/android/remote/model/SearchParams;", "provideSearchParams", "(Lcom/avito/android/search/map/SearchMapFragment$Factory$Arguments;)Lcom/avito/android/remote/model/SearchParams;", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/ViewedItemsTabTestGroup;", "provideViewedItemsTabTestGroup", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "<init>", "()V", "Dependencies", "map_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SavedLocationInteractorModule.class, AdvertItemEventListenerModule.class, PhoneNumberFormatterModule.class, PinAdvertsListModule.class, RichSnippetsModule.class, WitcherModule.class, SerpAdapterModule.class, SerpInteractorModule.class, SerpItemConverterModule.class, SerpListModule.class, SpanAdapterModule.class, ViewPortProviderModule.class, ViewedPinsModule.class, Dependencies.class, InlineFiltersModule.class, SavedSearchesModule.class, FindLocationModule.class})
public final class SearchMapModule {
    @NotNull
    public static final SearchMapModule INSTANCE = new SearchMapModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000ì\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001dH'¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H'¢\u0006\u0004\b$\u0010%J\u0017\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020&H'¢\u0006\u0004\b)\u0010*J\u0017\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020+H'¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u0002012\u0006\u0010\"\u001a\u000200H'¢\u0006\u0004\b2\u00103J\u0017\u00106\u001a\u0002052\u0006\u0010,\u001a\u000204H'¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u0002092\u0006\u0010,\u001a\u000208H'¢\u0006\u0004\b:\u0010;J\u0017\u0010?\u001a\u00020>2\u0006\u0010=\u001a\u00020<H'¢\u0006\u0004\b?\u0010@J\u0017\u0010C\u001a\u00020B2\u0006\u0010\u0003\u001a\u00020AH'¢\u0006\u0004\bC\u0010DJ\u0017\u0010G\u001a\u00020F2\u0006\u0010\u0003\u001a\u00020EH'¢\u0006\u0004\bG\u0010HJ%\u0010L\u001a\b\u0012\u0004\u0012\u00020J0I2\u000e\b\u0001\u0010K\u001a\b\u0012\u0004\u0012\u00020J0IH'¢\u0006\u0004\bL\u0010MJ\u0017\u0010P\u001a\u00020O2\u0006\u0010\u0003\u001a\u00020NH'¢\u0006\u0004\bP\u0010QJ\u0017\u0010T\u001a\u00020S2\u0006\u0010\b\u001a\u00020RH'¢\u0006\u0004\bT\u0010UJ\u0017\u0010X\u001a\u00020W2\u0006\u0010\u0003\u001a\u00020VH'¢\u0006\u0004\bX\u0010YJ\u0017\u0010[\u001a\u00020Z2\u0006\u0010\u0003\u001a\u00020\u0011H'¢\u0006\u0004\b[\u0010\\J\u0017\u0010_\u001a\u00020^2\u0006\u0010\"\u001a\u00020]H'¢\u0006\u0004\b_\u0010`J\u0017\u0010c\u001a\u00020b2\u0006\u0010\"\u001a\u00020aH'¢\u0006\u0004\bc\u0010dJ\u0017\u0010h\u001a\u00020g2\u0006\u0010f\u001a\u00020eH'¢\u0006\u0004\bh\u0010iJ\u0017\u0010l\u001a\u00020k2\u0006\u0010\b\u001a\u00020jH'¢\u0006\u0004\bl\u0010mJ\u001d\u0010q\u001a\b\u0012\u0004\u0012\u00020p0I2\u0006\u0010o\u001a\u00020nH'¢\u0006\u0004\bq\u0010rJ\u0017\u0010v\u001a\u00020u2\u0006\u0010t\u001a\u00020sH'¢\u0006\u0004\bv\u0010wJ\u0017\u0010y\u001a\u00020x2\u0006\u0010\u0019\u001a\u00020\u001eH'¢\u0006\u0004\by\u0010zJ\u0017\u0010|\u001a\u00020{2\u0006\u0010\u0019\u001a\u00020\u001eH'¢\u0006\u0004\b|\u0010}¨\u0006~"}, d2 = {"Lcom/avito/android/search/map/di/SearchMapModule$Dependencies;", "", "Lcom/avito/android/search/map/favorite_pins/FavouritePinsInteractorImpl;", "interactor", "Lcom/avito/android/search/map/favorite_pins/FavoritePinsInteractor;", "bindFavoritePinsInteractor", "(Lcom/avito/android/search/map/favorite_pins/FavouritePinsInteractorImpl;)Lcom/avito/android/search/map/favorite_pins/FavoritePinsInteractor;", "Lcom/avito/android/remote/model/SearchParamsConverterImpl;", "converter", "Lcom/avito/android/remote/model/SearchParamsConverter;", "bindSearchParamsConverter", "(Lcom/avito/android/remote/model/SearchParamsConverterImpl;)Lcom/avito/android/remote/model/SearchParamsConverter;", "Lcom/avito/android/remote/model/SuggestParamsConverterImpl;", "Lcom/avito/android/remote/model/SuggestParamsConverter;", "bindSuggestParamsConverter", "(Lcom/avito/android/remote/model/SuggestParamsConverterImpl;)Lcom/avito/android/remote/model/SuggestParamsConverter;", "Lcom/avito/android/search/map/interactor/SearchMapInteractorImpl;", "Lcom/avito/android/search/map/interactor/SearchMapInteractor;", "bindSearchMapInteractor", "(Lcom/avito/android/search/map/interactor/SearchMapInteractorImpl;)Lcom/avito/android/search/map/interactor/SearchMapInteractor;", "Lcom/avito/android/search/SearchDeepLinkInteractorImpl;", "Lcom/avito/android/search/SearchDeepLinkInteractor;", "bindSearchDeepLinkInteractor", "(Lcom/avito/android/search/SearchDeepLinkInteractorImpl;)Lcom/avito/android/search/SearchDeepLinkInteractor;", "Lcom/avito/android/search/map/view/MarkerIconFactoryImpl;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/search/map/view/MarkerIconFactory;", "bindMarkerIconFactory", "(Lcom/avito/android/search/map/view/MarkerIconFactoryImpl;)Lcom/avito/android/search/map/view/MarkerIconFactory;", "Lcom/avito/android/search/map/view/advert/AdvertItemEventListenerImpl;", "Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;", "bindAdvertItemEventListener", "(Lcom/avito/android/search/map/view/advert/AdvertItemEventListenerImpl;)Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;", "Lcom/avito/android/favorite/FavoriteAdvertsResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/favorite/FavoriteAdvertsResourceProvider;", "bindFavoriteAdvertsResourceProvider", "(Lcom/avito/android/favorite/FavoriteAdvertsResourceProviderImpl;)Lcom/avito/android/favorite/FavoriteAdvertsResourceProvider;", "Lcom/avito/android/search/map/SearchMapViewFactoryImpl;", "factory", "Lcom/avito/android/search/map/SearchMapViewFactory;", "bindSearchMapViewFactory", "(Lcom/avito/android/search/map/SearchMapViewFactoryImpl;)Lcom/avito/android/search/map/SearchMapViewFactory;", "Lcom/avito/android/search/map/middleware/LocationMiddlewareImpl;", "middleware", "Lcom/avito/android/search/map/middleware/LocationMiddleware;", "bindLocationMiddleware", "(Lcom/avito/android/search/map/middleware/LocationMiddlewareImpl;)Lcom/avito/android/search/map/middleware/LocationMiddleware;", "Lcom/avito/android/permissions/LocationPermissionProviderImpl;", "Lcom/avito/android/permissions/LocationPermissionProvider;", "bindLocationPermissionProvider", "(Lcom/avito/android/permissions/LocationPermissionProviderImpl;)Lcom/avito/android/permissions/LocationPermissionProvider;", "Lcom/avito/android/search/map/middleware/LoggingMiddlewareImpl;", "Lcom/avito/android/search/map/middleware/LoggingMiddleware;", "bindLoggingMiddleware", "(Lcom/avito/android/search/map/middleware/LoggingMiddlewareImpl;)Lcom/avito/android/search/map/middleware/LoggingMiddleware;", "Lcom/avito/android/search/map/middleware/NavigationMiddlewareImpl;", "Lcom/avito/android/search/map/middleware/NavigationMiddleware;", "bindNavigationMiddleware", "(Lcom/avito/android/search/map/middleware/NavigationMiddlewareImpl;)Lcom/avito/android/search/map/middleware/NavigationMiddleware;", "Lcom/avito/android/deep_linking/SimpleClickStreamLinkHandler;", "handler", "Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "bindClickStreamLinkHandler", "(Lcom/avito/android/deep_linking/SimpleClickStreamLinkHandler;)Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractorImpl;", "Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractor;", "bindSearchMapAnalyticsInteractor", "(Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractorImpl;)Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractor;", "Lcom/avito/android/search/subscriptions/SubscribeSearchInteractorImpl;", "Lcom/avito/android/search/subscriptions/SubscribeSearchInteractor;", "bindSubscribeSearchInteractor", "(Lcom/avito/android/search/subscriptions/SubscribeSearchInteractorImpl;)Lcom/avito/android/search/subscriptions/SubscribeSearchInteractor;", "Lcom/avito/android/util/Formatter;", "", "phoneFormatter", "bindPhoneFormatter", "(Lcom/avito/android/util/Formatter;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/search/subscriptions/SerpSearchSubscriptionInteractorImpl;", "Lcom/avito/android/search/subscriptions/SerpSearchSubscriptionInteractor;", "bindSerpSearchSubscriptionInteractor", "(Lcom/avito/android/search/subscriptions/SerpSearchSubscriptionInteractorImpl;)Lcom/avito/android/search/subscriptions/SerpSearchSubscriptionInteractor;", "Lcom/avito/android/search/map/interactor/MapAreaConverterImpl;", "Lcom/avito/android/search/map/interactor/MapAreaConverter;", "bindMapAreaConverter", "(Lcom/avito/android/search/map/interactor/MapAreaConverterImpl;)Lcom/avito/android/search/map/interactor/MapAreaConverter;", "Lcom/avito/android/serp/SerpSnippetInteractor$Impl;", "Lcom/avito/android/serp/SerpSnippetInteractor;", "bindSerpSnippetInteractor", "(Lcom/avito/android/serp/SerpSnippetInteractor$Impl;)Lcom/avito/android/serp/SerpSnippetInteractor;", "Lcom/avito/android/component/search/SuggestInteractor;", "bindSuggestInteractor", "(Lcom/avito/android/search/map/interactor/SearchMapInteractor;)Lcom/avito/android/component/search/SuggestInteractor;", "Lcom/avito/android/search/map/metric/SearchMapTrackerImpl;", "Lcom/avito/android/search/map/metric/SearchMapTracker;", "bindSearchMapTracker", "(Lcom/avito/android/search/map/metric/SearchMapTrackerImpl;)Lcom/avito/android/search/map/metric/SearchMapTracker;", "Lcom/avito/android/serp/ad/AdResourceProviderImpl;", "Lcom/avito/android/serp/ad/AdResourceProvider;", "bindAdResourceProvider", "(Lcom/avito/android/serp/ad/AdResourceProviderImpl;)Lcom/avito/android/serp/ad/AdResourceProvider;", "Lcom/avito/android/search/map/provider/SearchHashProviderImpl;", "searchHashProvider", "Lcom/avito/android/search/map/provider/SearchHashProvider;", "bindSearchHashProvider", "(Lcom/avito/android/search/map/provider/SearchHashProviderImpl;)Lcom/avito/android/search/map/provider/SearchHashProvider;", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverterImpl;", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverter;", "bindActionItemConverter", "(Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverterImpl;)Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverter;", "Lcom/avito/android/util/ErrorFormatterImpl;", "formatter", "", "bindErrorFormatter", "(Lcom/avito/android/util/ErrorFormatterImpl;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/serp/analytics/SerpTrackerImpl;", "tracker", "Lcom/avito/android/serp/analytics/SerpTracker;", "bindsSerpTracker", "(Lcom/avito/android/serp/analytics/SerpTrackerImpl;)Lcom/avito/android/serp/analytics/SerpTracker;", "Lcom/avito/android/async_phone/AsyncPhoneAuthRouter;", "bindAsyncPhoneAuthRouter", "(Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;)Lcom/avito/android/async_phone/AsyncPhoneAuthRouter;", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter$Router;", "bindReportBannerRouter", "(Lcom/avito/android/search/map/view/advert/AdvertItemEventListener;)Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter$Router;", "map_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        ShortcutNavigationItemConverter bindActionItemConverter(@NotNull ShortcutNavigationItemConverterImpl shortcutNavigationItemConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        AdResourceProvider bindAdResourceProvider(@NotNull AdResourceProviderImpl adResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertItemEventListener bindAdvertItemEventListener(@NotNull AdvertItemEventListenerImpl advertItemEventListenerImpl);

        @PerFragment
        @Binds
        @NotNull
        AsyncPhoneAuthRouter bindAsyncPhoneAuthRouter(@NotNull AdvertItemEventListener advertItemEventListener);

        @PerFragment
        @Binds
        @NotNull
        ClickStreamLinkHandler bindClickStreamLinkHandler(@NotNull SimpleClickStreamLinkHandler simpleClickStreamLinkHandler);

        @Binds
        @NotNull
        @PerFragment
        Formatter<Throwable> bindErrorFormatter(@NotNull ErrorFormatterImpl errorFormatterImpl);

        @PerFragment
        @Binds
        @NotNull
        FavoriteAdvertsResourceProvider bindFavoriteAdvertsResourceProvider(@NotNull FavoriteAdvertsResourceProviderImpl favoriteAdvertsResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        FavoritePinsInteractor bindFavoritePinsInteractor(@NotNull FavouritePinsInteractorImpl favouritePinsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        LocationMiddleware bindLocationMiddleware(@NotNull LocationMiddlewareImpl locationMiddlewareImpl);

        @PerFragment
        @Binds
        @NotNull
        LocationPermissionProvider bindLocationPermissionProvider(@NotNull LocationPermissionProviderImpl locationPermissionProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        LoggingMiddleware bindLoggingMiddleware(@NotNull LoggingMiddlewareImpl loggingMiddlewareImpl);

        @PerFragment
        @Binds
        @NotNull
        MapAreaConverter bindMapAreaConverter(@NotNull MapAreaConverterImpl mapAreaConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        MarkerIconFactory bindMarkerIconFactory(@NotNull MarkerIconFactoryImpl markerIconFactoryImpl);

        @PerFragment
        @Binds
        @NotNull
        NavigationMiddleware bindNavigationMiddleware(@NotNull NavigationMiddlewareImpl navigationMiddlewareImpl);

        @Binds
        @NotNull
        @PerFragment
        Formatter<String> bindPhoneFormatter(@PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode @NotNull Formatter<String> formatter);

        @PerFragment
        @Binds
        @NotNull
        PromoCardItemPresenter.Router bindReportBannerRouter(@NotNull AdvertItemEventListener advertItemEventListener);

        @PerFragment
        @Binds
        @NotNull
        SearchDeepLinkInteractor bindSearchDeepLinkInteractor(@NotNull SearchDeepLinkInteractorImpl searchDeepLinkInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        SearchHashProvider bindSearchHashProvider(@NotNull SearchHashProviderImpl searchHashProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        SearchMapAnalyticsInteractor bindSearchMapAnalyticsInteractor(@NotNull SearchMapAnalyticsInteractorImpl searchMapAnalyticsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        SearchMapInteractor bindSearchMapInteractor(@NotNull SearchMapInteractorImpl searchMapInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        SearchMapTracker bindSearchMapTracker(@NotNull SearchMapTrackerImpl searchMapTrackerImpl);

        @PerFragment
        @Binds
        @NotNull
        SearchMapViewFactory bindSearchMapViewFactory(@NotNull SearchMapViewFactoryImpl searchMapViewFactoryImpl);

        @PerFragment
        @Binds
        @NotNull
        SearchParamsConverter bindSearchParamsConverter(@NotNull SearchParamsConverterImpl searchParamsConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        SerpSearchSubscriptionInteractor bindSerpSearchSubscriptionInteractor(@NotNull SerpSearchSubscriptionInteractorImpl serpSearchSubscriptionInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        SerpSnippetInteractor bindSerpSnippetInteractor(@NotNull SerpSnippetInteractor.Impl impl);

        @PerFragment
        @Binds
        @NotNull
        SubscribeSearchInteractor bindSubscribeSearchInteractor(@NotNull SubscribeSearchInteractorImpl subscribeSearchInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        SuggestInteractor bindSuggestInteractor(@NotNull SearchMapInteractor searchMapInteractor);

        @PerFragment
        @Binds
        @NotNull
        SuggestParamsConverter bindSuggestParamsConverter(@NotNull SuggestParamsConverterImpl suggestParamsConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        SerpTracker bindsSerpTracker(@NotNull SerpTrackerImpl serpTrackerImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AvitoMapAttachHelper provideAvitoMapAttachHelper(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        if (features.getYandexMapsInSearchOnMap().invoke().booleanValue()) {
            return new YandexAvitoMapAttachHelper();
        }
        return new GoogleAvitoMapAttachHelper();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    @PinAdvertsBottomSheetEventsProvider
    public static final BottomSheetBehaviourEventsProvider providePinAdvertsBottomSheetBehaviourProvider() {
        return new BottomSheetBehaviourEventsProvider();
    }

    @PublishFloatingViews
    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final PublishFloatingViewsProvider providePublishFloatingViewsPresenter() {
        return new PublishFloatingViewsProvider();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SearchParams provideSearchParams(@NotNull SearchMapFragment.Factory.Arguments arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        return arguments.getSearchParams();
    }

    @Provides
    @JvmStatic
    @SerpBottomSheetEventsProvider
    @NotNull
    @PerFragment
    public static final BottomSheetBehaviourEventsProvider provideSerpBottomSheetBehaviourProvider() {
        return new BottomSheetBehaviourEventsProvider();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SubscribableStore<SearchMapState, ? super MapAction> provideStore(@NotNull LoggingMiddleware loggingMiddleware, @NotNull NavigationMiddleware navigationMiddleware, @NotNull LoadMiddleware loadMiddleware, @NotNull AdvertItemEventMiddleware advertItemEventMiddleware, @NotNull LocationMiddleware locationMiddleware, @NotNull SubscriptionMiddleware subscriptionMiddleware, @NotNull LoadReducer loadReducer, @NotNull SerpReducer serpReducer, @NotNull MapReducer mapReducer, @NotNull PinAdvertsReducer pinAdvertsReducer, @NotNull UiReducer uiReducer, @NotNull SubscriptionReducer subscriptionReducer, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SerpListResourcesProvider serpListResourcesProvider, @Nullable SearchMapState searchMapState, @NotNull SearchMapFragment.Factory.Arguments arguments) {
        SerpDisplayType serpDisplayType;
        int i;
        SerpDisplayType serpDisplayType2;
        SearchMapState searchMapState2;
        int i2;
        SearchMapState.SerpState serpState;
        Intrinsics.checkNotNullParameter(loggingMiddleware, "loggingMiddleware");
        Intrinsics.checkNotNullParameter(navigationMiddleware, "navigationMiddleware");
        Intrinsics.checkNotNullParameter(loadMiddleware, "loadMiddleware");
        Intrinsics.checkNotNullParameter(advertItemEventMiddleware, "advertItemEventMiddleware");
        Intrinsics.checkNotNullParameter(locationMiddleware, "locationMiddleware");
        Intrinsics.checkNotNullParameter(subscriptionMiddleware, "subscriptionMiddleware");
        Intrinsics.checkNotNullParameter(loadReducer, "loadReducer");
        Intrinsics.checkNotNullParameter(serpReducer, "serpReducer");
        Intrinsics.checkNotNullParameter(mapReducer, "mapReducer");
        Intrinsics.checkNotNullParameter(pinAdvertsReducer, "pinAdvertsReducer");
        Intrinsics.checkNotNullParameter(uiReducer, "uiReducer");
        Intrinsics.checkNotNullParameter(subscriptionReducer, "subscriptionReducer");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(serpListResourcesProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (searchMapState == null || (serpState = searchMapState.getSerpState()) == null || (serpDisplayType = serpState.getDisplayType()) == null) {
            serpDisplayType = arguments.getSearchParams().getDisplayType();
        }
        int columnsCount = serpListResourcesProvider.getColumnsCount();
        if (searchMapState != null) {
            if (searchMapState.getSerpState().getDisplayType() != serpDisplayType) {
                serpDisplayType2 = serpDisplayType;
                i2 = columnsCount;
                searchMapState2 = SearchMapState.copy$default(searchMapState, null, null, null, null, null, SearchMapState.SerpState.copy$default(searchMapState.getSerpState(), null, null, false, null, serpDisplayType, null, null, 0, null, null, false, null, false, 0, 0, false, null, null, null, 524263, null), null, false, false, 479, null);
            } else {
                i2 = columnsCount;
                serpDisplayType2 = serpDisplayType;
                searchMapState2 = searchMapState;
            }
            if (searchMapState2.getSerpState().getColumns() != i2) {
                i = i2;
                searchMapState2 = SearchMapState.copy$default(searchMapState2, null, null, null, null, null, SearchMapState.SerpState.copy$default(searchMapState2.getSerpState(), null, null, false, null, null, null, null, 0, null, null, false, null, false, i, 0, false, null, null, null, 516095, null), null, false, false, 479, null);
            } else {
                i = i2;
            }
        } else {
            serpDisplayType2 = serpDisplayType;
            i = columnsCount;
            searchMapState2 = searchMapState;
        }
        if (searchMapState2 == null) {
            Area mapArea = arguments.getMapArea();
            Area searchArea = arguments.getSearchArea();
            SearchParams searchParams = arguments.getSearchParams();
            LatLngBounds latLngBounds = null;
            LatLngBounds latLngBounds2 = mapArea != null ? LatLngBoundsKt.toLatLngBounds(mapArea) : null;
            if (searchArea != null) {
                latLngBounds = LatLngBoundsKt.toLatLngBounds(searchArea);
            }
            SearchMapState.MapState mapState = new SearchMapState.MapState(arguments.getMapZoomLevel(), latLngBounds, latLngBounds2, false, null, null, false, null, null, null, null, false, mapArea != null, false, null, false, false, true, null, 389112, null);
            String mapSerpState = arguments.getMapSerpState();
            if (mapSerpState == null) {
                mapSerpState = "none";
            }
            searchMapState2 = new SearchMapState(null, null, searchParams, null, mapState, new SearchMapState.SerpState(null, null, false, null, serpDisplayType2, null, mapSerpState, 0, searchArea, null, false, null, false, i, 0, false, arguments.getContext(), null, null, 450223, null), null, false, arguments.getShowSimpleMap(), 203, null);
        }
        return new DefaultSubscribableStore(CollectionsKt__CollectionsKt.listOf((Object[]) new Reducer[]{loadReducer, mapReducer, pinAdvertsReducer, serpReducer, uiReducer, subscriptionReducer}), CollectionsKt__CollectionsKt.listOf((Object[]) new Middleware[]{loggingMiddleware, navigationMiddleware, loadMiddleware, advertItemEventMiddleware, locationMiddleware, subscriptionMiddleware}), schedulersFactory3.mainThread(), searchMapState2);
    }

    @Provides
    @JvmStatic
    @Nullable
    @PerFragment
    public static final TreeClickStreamParent provideTreeParent$map_release(@NotNull SearchMapAnalyticsInteractor searchMapAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(searchMapAnalyticsInteractor, "analyticsInteractor");
        return searchMapAnalyticsInteractor.getParent();
    }

    @Provides
    @JvmStatic
    @Nullable
    @PerFragment
    public static final SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> provideViewedItemsTabTestGroup() {
        return null;
    }
}
