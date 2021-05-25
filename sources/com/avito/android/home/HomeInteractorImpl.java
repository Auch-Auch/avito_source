package com.avito.android.home;

import com.avito.android.IdProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.adapter.MoreActionsItemProcessor;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.home.analytics.HomeTracker;
import com.avito.android.location.LocationSource;
import com.avito.android.location.SavedLocation;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.CommercialBanner;
import com.avito.android.remote.model.HomeElementResult;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.LocationKt;
import com.avito.android.remote.model.Options;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpDisplayTypeKt;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.SerpVipAdverts;
import com.avito.android.remote.model.Shortcuts;
import com.avito.android.remote.model.Story;
import com.avito.android.remote.model.SuggestParamsConverter;
import com.avito.android.remote.model.search.suggest.SuggestItem;
import com.avito.android.remote.model.search.suggest.SuggestResponse;
import com.avito.android.remote.model.serp.Banner;
import com.avito.android.remote.model.serp.BannerPayload;
import com.avito.android.remote.model.serp.BannerRotationResponse;
import com.avito.android.remote.model.serp.Banners;
import com.avito.android.search.SearchDeepLinkInteractor;
import com.avito.android.serp.CommercialBannersInteractor;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.serp.adapter.SerpCommercialBanner;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.serp.adapter.snippet.SnippetItem;
import com.avito.android.stories.StartupBannerInteractor;
import com.avito.android.stories.StartupBannerLocker;
import com.avito.android.stories.StartupStoryBanner;
import com.avito.android.stories.StoriesInteractor;
import com.avito.android.stories.StoriesItem;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.UrlParams;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0001\b\u0007\u0012\u0006\u0010U\u001a\u00020R\u0012\u0006\u0010p\u001a\u00020m\u0012\u0006\u0010]\u001a\u00020Z\u0012\u0006\u0010a\u001a\u00020^\u0012\u0006\u0010\u001a\u00020|\u0012\u0006\u0010Y\u001a\u00020V\u0012\u0006\u0010{\u001a\u00020x\u0012\u0006\u0010i\u001a\u00020f\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010w\u001a\u00020t\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010s\u001a\u00020\u0002\u0012\u0006\u0010Q\u001a\u00020\u0003\u0012\u0007\u0010\u0001\u001a\u00020\u0004\u0012\u0006\u0010e\u001a\u00020b\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\t\u0010\u0001\u001a\u0004\u0018\u000101¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJW\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00172\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ7\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00172\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001f\u0010 J#\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00050\u00172\u0006\u0010!\u001a\u00020\u0011H\u0016¢\u0006\u0004\b#\u0010$J\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017H\u0016¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0016¢\u0006\u0004\b'\u0010&J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0016¢\u0006\u0004\b(\u0010&J\u0015\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017H\u0016¢\u0006\u0004\b)\u0010&J\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u00172\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b-\u0010.J%\u0010/\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103J\u0015\u00105\u001a\b\u0012\u0004\u0012\u0002040\u0017H\u0016¢\u0006\u0004\b5\u0010&JJ\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u00180\u00172\u0006\u0010!\u001a\u00020\u00112\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u00010\u00112\b\u00109\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010:\u001a\u00020\u0013H\u0001¢\u0006\u0004\b<\u0010=J\u0018\u0010?\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\rH\u0001¢\u0006\u0004\b?\u0010@J$\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0\u00180\u00172\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\bB\u0010,J\u0018\u0010C\u001a\u00020\b2\u0006\u0010>\u001a\u00020\rH\u0001¢\u0006\u0004\bC\u0010DJ\u0010\u0010E\u001a\u00020\bH\u0001¢\u0006\u0004\bE\u0010FJ\u001e\u0010I\u001a\u00020\b2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020G0\u0005H\u0001¢\u0006\u0004\bI\u0010\nJ\u0010\u0010K\u001a\u00020JH\u0001¢\u0006\u0004\bK\u0010LJ\u0016\u0010N\u001a\b\u0012\u0004\u0012\u00020M0\u0017H\u0001¢\u0006\u0004\bN\u0010&R\u0016\u0010Q\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010l\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010s\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010w\u001a\u00020t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010{\u001a\u00020x8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010\u001a\u00020|8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\t\u0010\u0001R\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/home/HomeInteractorImpl;", "Lcom/avito/android/home/HomeInteractor;", "Lcom/avito/android/search/SearchDeepLinkInteractor;", "Lcom/avito/android/stories/StoriesInteractor;", "Lcom/avito/android/stories/StartupBannerInteractor;", "", "Lcom/avito/android/remote/model/SerpElement;", MessengerShareContentUtility.ELEMENTS, "", AuthSource.SEND_ABUSE, "(Ljava/util/List;)V", "Lcom/avito/android/remote/model/Location;", "location", "", "offset", "page", "columnCount", "", "tabId", "", "hideSeenBadge", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/home/HomePageResult;", "loadAdverts", "(Lcom/avito/android/remote/model/Location;IIILjava/lang/String;ZLcom/avito/android/remote/model/SerpDisplayType;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "items", "locationId", "loadAds", "(Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/SerpDisplayType;)Lio/reactivex/rxjava3/core/Observable;", "query", "Lcom/avito/android/remote/model/search/suggest/SuggestItem;", "loadSuggestions", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "isLocationChanged", "()Lio/reactivex/rxjava3/core/Observable;", "onLogin", "onLocationChanged", "loadLocation", "Lcom/avito/android/remote/model/Shortcuts;", "loadMainShortcuts", "(Lcom/avito/android/remote/model/Location;)Lio/reactivex/rxjava3/core/Observable;", "updateStoredLocationId", "(Lcom/avito/android/remote/model/Location;)V", "resolveItems", "(Ljava/util/List;Z)V", "Lcom/avito/android/home/HomeInteractorState;", "onSaveState", "()Lcom/avito/android/home/HomeInteractorState;", "Lcom/avito/android/serp/adapter/snippet/SnippetItem;", "loadWarning", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "context", "clearGeoFilters", UrlParams.SIMPLE_MAP, "Lcom/avito/android/deep_linking/links/DeepLink;", "loadSearchDeepLink", "(Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Ljava/lang/Boolean;Z)Lio/reactivex/rxjava3/core/Observable;", "id", "isStoryViewed", "(I)Z", "Lcom/avito/android/stories/StoriesItem;", "loadStories", "markStoryViewed", "(I)V", "resetLastUpdatedTimestamp", "()V", "Lcom/avito/android/remote/model/Story;", "stories", "updateStoriesViewedStatus", "Lcom/avito/android/stories/StartupBannerLocker;", "lockStartupBanner", "()Lcom/avito/android/stories/StartupBannerLocker;", "Lcom/avito/android/stories/StartupStoryBanner;", "startupBanner", "p", "Lcom/avito/android/stories/StoriesInteractor;", "storiesInteractor", "Lcom/avito/android/remote/LocationApi;", "d", "Lcom/avito/android/remote/LocationApi;", "locationApi", "Lcom/avito/android/remote/model/SuggestParamsConverter;", "i", "Lcom/avito/android/remote/model/SuggestParamsConverter;", "suggestConverter", "Lcom/avito/android/serp/SerpItemProcessor;", "f", "Lcom/avito/android/serp/SerpItemProcessor;", "itemProcessor", "Lcom/avito/android/adapter/MoreActionsItemProcessor;", a2.g.r.g.a, "Lcom/avito/android/adapter/MoreActionsItemProcessor;", "moreActionsItemProcessor", "Lcom/avito/android/home/analytics/HomeTracker;", "r", "Lcom/avito/android/home/analytics/HomeTracker;", "tracker", "Lcom/avito/android/location/SavedLocationInteractor;", "k", "Lcom/avito/android/location/SavedLocationInteractor;", "locationInteractor", "c", "Ljava/lang/String;", "lastUserId", "Lcom/avito/android/remote/SearchApi;", "e", "Lcom/avito/android/remote/SearchApi;", "searchApi", "o", "Lcom/avito/android/search/SearchDeepLinkInteractor;", "searchDeepLinkInteractor", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "j", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/serp/CommercialBannersInteractor;", "h", "Lcom/avito/android/serp/CommercialBannersInteractor;", "commercialBannersInteractor", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "s", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "locationAnalyticsInteractor", "Lcom/avito/android/IdProvider;", "l", "Lcom/avito/android/IdProvider;", "idProvider", VKApiConst.Q, "Lcom/avito/android/stories/StartupBannerInteractor;", "startupBannerInteractor", "Lcom/avito/android/account/AccountStateProvider;", "n", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/remote/model/Shortcuts;", ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS, AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Location;", "state", "<init>", "(Lcom/avito/android/remote/LocationApi;Lcom/avito/android/remote/SearchApi;Lcom/avito/android/serp/SerpItemProcessor;Lcom/avito/android/adapter/MoreActionsItemProcessor;Lcom/avito/android/serp/CommercialBannersInteractor;Lcom/avito/android/remote/model/SuggestParamsConverter;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/location/SavedLocationInteractor;Lcom/avito/android/IdProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/search/SearchDeepLinkInteractor;Lcom/avito/android/stories/StoriesInteractor;Lcom/avito/android/stories/StartupBannerInteractor;Lcom/avito/android/home/analytics/HomeTracker;Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;Lcom/avito/android/home/HomeInteractorState;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class HomeInteractorImpl implements HomeInteractor, SearchDeepLinkInteractor, StoriesInteractor, StartupBannerInteractor {
    public Shortcuts a;
    public Location b;
    public String c;
    public final LocationApi d;
    public final SearchApi e;
    public final SerpItemProcessor f;
    public final MoreActionsItemProcessor g;
    public final CommercialBannersInteractor h;
    public final SuggestParamsConverter i;
    public final TypedErrorThrowableConverter j;
    public final SavedLocationInteractor k;
    public final IdProvider l;
    public final SchedulersFactory3 m;
    public final AccountStateProvider n;
    public final SearchDeepLinkInteractor o;
    public final StoriesInteractor p;
    public final StartupBannerInteractor q;
    public final HomeTracker r;
    public final LocationAnalyticsInteractor s;

    public static final class a<T, R> implements Function<Location, Boolean> {
        public final /* synthetic */ HomeInteractorImpl a;

        public a(HomeInteractorImpl homeInteractorImpl) {
            this.a = homeInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Boolean apply(Location location) {
            return Boolean.valueOf(!Intrinsics.areEqual(location, this.a.b));
        }
    }

    public static final class b<T> implements Predicate<ViewTypeSerpItem> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(ViewTypeSerpItem viewTypeSerpItem) {
            ViewTypeSerpItem viewTypeSerpItem2 = viewTypeSerpItem;
            return (viewTypeSerpItem2 instanceof SerpCommercialBanner) && ((SerpCommercialBanner) viewTypeSerpItem2).getHasNotLoadedAd();
        }
    }

    public static final class c<T, R> implements Function<ViewTypeSerpItem, SerpCommercialBanner> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SerpCommercialBanner apply(ViewTypeSerpItem viewTypeSerpItem) {
            ViewTypeSerpItem viewTypeSerpItem2 = viewTypeSerpItem;
            Objects.requireNonNull(viewTypeSerpItem2, "null cannot be cast to non-null type com.avito.android.serp.adapter.SerpCommercialBanner");
            return (SerpCommercialBanner) viewTypeSerpItem2;
        }
    }

    public static final class d<T, R> implements Function<SerpCommercialBanner, ObservableSource<? extends SerpCommercialBanner>> {
        public final /* synthetic */ HomeInteractorImpl a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;

        public d(HomeInteractorImpl homeInteractorImpl, long j, String str) {
            this.a = homeInteractorImpl;
            this.b = j;
            this.c = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends SerpCommercialBanner> apply(SerpCommercialBanner serpCommercialBanner) {
            SerpCommercialBanner serpCommercialBanner2 = serpCommercialBanner;
            CommercialBanner commercialBanner = serpCommercialBanner2.getCommercialBanner();
            Objects.requireNonNull(commercialBanner, "null cannot be cast to non-null type com.avito.android.remote.model.CommercialBanner");
            return this.a.h.loadBanner(commercialBanner, this.b, null, this.c).map(new a2.a.a.a1.d(serpCommercialBanner2)).onErrorReturn(new a2.a.a.a1.e(serpCommercialBanner2));
        }
    }

    public static final class e<T, R> implements Function<SerpCommercialBanner, List<? extends ViewTypeSerpItem>> {
        public final /* synthetic */ HomeInteractorImpl a;
        public final /* synthetic */ SerpDisplayType b;

        public e(HomeInteractorImpl homeInteractorImpl, SerpDisplayType serpDisplayType) {
            this.a = homeInteractorImpl;
            this.b = serpDisplayType;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends ViewTypeSerpItem> apply(SerpCommercialBanner serpCommercialBanner) {
            return this.a.f.convertSync(t6.n.d.listOf(serpCommercialBanner), SerpDisplayTypeKt.orDefault(this.b));
        }
    }

    public static final class f<T> implements Predicate<List<? extends ViewTypeSerpItem>> {
        public static final f a = new f();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(List<? extends ViewTypeSerpItem> list) {
            List<? extends ViewTypeSerpItem> list2 = list;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            return !list2.isEmpty();
        }
    }

    public static final class g<T, R> implements Function<List<? extends ViewTypeSerpItem>, ViewTypeSerpItem> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ViewTypeSerpItem apply(List<? extends ViewTypeSerpItem> list) {
            List<? extends ViewTypeSerpItem> list2 = list;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            return (ViewTypeSerpItem) CollectionsKt___CollectionsKt.first((List<? extends Object>) list2);
        }
    }

    public static final class h<T, R> implements Function<HomePageResult, LoadingState<? super HomePageResult>> {
        public static final h a = new h();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super HomePageResult> apply(HomePageResult homePageResult) {
            return new LoadingState.Loaded(homePageResult);
        }
    }

    public static final class i<T, R> implements Function<Throwable, LoadingState<? super HomePageResult>> {
        public final /* synthetic */ HomeInteractorImpl a;

        public i(HomeInteractorImpl homeInteractorImpl) {
            this.a = homeInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super HomePageResult> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.j;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class j<T, R> implements Function<SavedLocationInteractor.AnalyticsInfoLocation, SavedLocation> {
        public final /* synthetic */ HomeInteractorImpl a;

        public j(HomeInteractorImpl homeInteractorImpl) {
            this.a = homeInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SavedLocation apply(SavedLocationInteractor.AnalyticsInfoLocation analyticsInfoLocation) {
            Location location;
            SavedLocationInteractor.AnalyticsInfoLocation analyticsInfoLocation2 = analyticsInfoLocation;
            LocationAnalyticsInteractor locationAnalyticsInteractor = this.a.s;
            HashMap<LocationSource, String> storageInfo = analyticsInfoLocation2.getStorageInfo();
            SavedLocation savedLocation = analyticsInfoLocation2.getSavedLocation();
            locationAnalyticsInteractor.trackLocationStorageRequested(storageInfo, analyticsInfoLocation2.getFromBlock(), (savedLocation == null || (location = savedLocation.getLocation()) == null) ? null : location.getId());
            return analyticsInfoLocation2.getSavedLocation();
        }
    }

    public static final class k<T, R> implements Function<SavedLocation, ObservableSource<? extends Location>> {
        public final /* synthetic */ HomeInteractorImpl a;

        public k(HomeInteractorImpl homeInteractorImpl) {
            this.a = homeInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends Location> apply(SavedLocation savedLocation) {
            Location location;
            Location location2;
            SavedLocation savedLocation2 = savedLocation;
            Location location3 = this.a.b;
            String str = null;
            if (Intrinsics.areEqual((savedLocation2 == null || (location2 = savedLocation2.getLocation()) == null) ? null : location2.getId(), "")) {
                Observable just = Observable.just(savedLocation2.getLocation());
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                return just;
            }
            if (location3 != null) {
                if (Intrinsics.areEqual(savedLocation2 != null ? savedLocation2.getLocation() : null, location3)) {
                    this.a.r.trackLocationLoadedFromSave(null);
                    Observable just2 = Observable.just(Location.copy$default(location3, null, null, false, false, false, false, null, savedLocation2.getForcedByUser(), null, null, 895, null));
                    Intrinsics.checkNotNullExpressionValue(just2, "Observable.just(this)");
                    return just2;
                }
            }
            if (savedLocation2 == null || !savedLocation2.getActual()) {
                if (!(savedLocation2 == null || (location = savedLocation2.getLocation()) == null)) {
                    str = location.getId();
                }
                this.a.r.trackLocationLoadedFromSave(str);
                if (str != null) {
                    return this.a.d.getLocation(str).doOnNext(new a2.a.a.a1.g(this));
                }
                return Observable.empty();
            }
            this.a.r.trackLocationLoadedFromSave(null);
            Observable just3 = Observable.just(Location.copy$default(savedLocation2.getLocation(), null, null, false, false, false, false, null, savedLocation2.getForcedByUser(), null, null, 895, null));
            Intrinsics.checkNotNullExpressionValue(just3, "Observable.just(this)");
            return just3;
        }
    }

    public static final class l<T> implements Consumer<Location> {
        public final /* synthetic */ HomeInteractorImpl a;

        public l(HomeInteractorImpl homeInteractorImpl) {
            this.a = homeInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Location location) {
            Location location2 = location;
            if (!Intrinsics.areEqual(this.a.b, location2)) {
                this.a.a = null;
                this.a.b = location2;
            }
        }
    }

    public static final class m<T> implements Consumer<Shortcuts> {
        public final /* synthetic */ HomeInteractorImpl a;

        public m(HomeInteractorImpl homeInteractorImpl) {
            this.a = homeInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Shortcuts shortcuts) {
            Shortcuts shortcuts2 = shortcuts;
            List<Action> list = shortcuts2.getList();
            if (!(list == null || list.isEmpty())) {
                this.a.a = shortcuts2;
            }
        }
    }

    public static final class n<T, R> implements Function<SuggestResponse, List<? extends SuggestItem>> {
        public static final n a = new n();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends SuggestItem> apply(SuggestResponse suggestResponse) {
            return CollectionsKt___CollectionsKt.filterNotNull(suggestResponse.getResult());
        }
    }

    public static final class o<T, R> implements Function<BannerRotationResponse, ObservableSource<? extends SnippetItem>> {
        public final /* synthetic */ HomeInteractorImpl a;

        public o(HomeInteractorImpl homeInteractorImpl) {
            this.a = homeInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends SnippetItem> apply(BannerRotationResponse bannerRotationResponse) {
            List<Banner> list;
            Banners banners = bannerRotationResponse.getBanners();
            if (banners == null || (list = banners.getTop()) == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            if (!(!list.isEmpty())) {
                return Observable.empty();
            }
            Banner banner = list.get(0);
            BannerPayload payload = banner.getPayload();
            long generateId = this.a.l.generateId();
            String id = banner.getId();
            Action action = payload.getAction();
            Image image = payload.getImage();
            String text = payload.getText();
            Boolean closable = banner.getClosable();
            Observable just = Observable.just(new SnippetItem(generateId, id, 6, action, image, text, closable != null ? closable.booleanValue() : false, null));
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return just;
        }
    }

    public static final class p<T> implements Predicate<Boolean> {
        public final /* synthetic */ HomeInteractorImpl a;

        public p(HomeInteractorImpl homeInteractorImpl) {
            this.a = homeInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            return bool2.booleanValue() && (Intrinsics.areEqual(this.a.c, this.a.n.getCurrentUserId()) ^ true);
        }
    }

    public static final class q<T> implements Consumer<Boolean> {
        public final /* synthetic */ HomeInteractorImpl a;

        public q(HomeInteractorImpl homeInteractorImpl) {
            this.a = homeInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            HomeInteractorImpl homeInteractorImpl = this.a;
            homeInteractorImpl.c = homeInteractorImpl.n.getCurrentUserId();
        }
    }

    public static final class r<T, R> implements Function<Boolean, Unit> {
        public static final r a = new r();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Unit apply(Boolean bool) {
            return Unit.INSTANCE;
        }
    }

    @Inject
    public HomeInteractorImpl(@NotNull LocationApi locationApi, @NotNull SearchApi searchApi, @NotNull SerpItemProcessor serpItemProcessor, @NotNull MoreActionsItemProcessor moreActionsItemProcessor, @NotNull CommercialBannersInteractor commercialBannersInteractor, @NotNull SuggestParamsConverter suggestParamsConverter, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SavedLocationInteractor savedLocationInteractor, @NotNull IdProvider idProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AccountStateProvider accountStateProvider, @NotNull SearchDeepLinkInteractor searchDeepLinkInteractor, @NotNull StoriesInteractor storiesInteractor, @NotNull StartupBannerInteractor startupBannerInteractor, @NotNull HomeTracker homeTracker, @NotNull LocationAnalyticsInteractor locationAnalyticsInteractor, @Nullable HomeInteractorState homeInteractorState) {
        String currentUserId;
        Intrinsics.checkNotNullParameter(locationApi, "locationApi");
        Intrinsics.checkNotNullParameter(searchApi, "searchApi");
        Intrinsics.checkNotNullParameter(serpItemProcessor, "itemProcessor");
        Intrinsics.checkNotNullParameter(moreActionsItemProcessor, "moreActionsItemProcessor");
        Intrinsics.checkNotNullParameter(commercialBannersInteractor, "commercialBannersInteractor");
        Intrinsics.checkNotNullParameter(suggestParamsConverter, "suggestConverter");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(savedLocationInteractor, "locationInteractor");
        Intrinsics.checkNotNullParameter(idProvider, "idProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(searchDeepLinkInteractor, "searchDeepLinkInteractor");
        Intrinsics.checkNotNullParameter(storiesInteractor, "storiesInteractor");
        Intrinsics.checkNotNullParameter(startupBannerInteractor, "startupBannerInteractor");
        Intrinsics.checkNotNullParameter(homeTracker, "tracker");
        Intrinsics.checkNotNullParameter(locationAnalyticsInteractor, "locationAnalyticsInteractor");
        this.d = locationApi;
        this.e = searchApi;
        this.f = serpItemProcessor;
        this.g = moreActionsItemProcessor;
        this.h = commercialBannersInteractor;
        this.i = suggestParamsConverter;
        this.j = typedErrorThrowableConverter;
        this.k = savedLocationInteractor;
        this.l = idProvider;
        this.m = schedulersFactory3;
        this.n = accountStateProvider;
        this.o = searchDeepLinkInteractor;
        this.p = storiesInteractor;
        this.q = startupBannerInteractor;
        this.r = homeTracker;
        this.s = locationAnalyticsInteractor;
        Location location = null;
        this.a = homeInteractorState != null ? homeInteractorState.getShortcuts() : null;
        this.b = homeInteractorState != null ? homeInteractorState.getLocation() : location;
        this.c = (homeInteractorState == null || (currentUserId = homeInteractorState.getUserId()) == null) ? accountStateProvider.getCurrentUserId() : currentUserId;
    }

    public static final HomePageResult access$createHomePageResult(HomeInteractorImpl homeInteractorImpl, HomeElementResult homeElementResult, int i2, SerpDisplayType serpDisplayType) {
        Objects.requireNonNull(homeInteractorImpl);
        homeInteractorImpl.a(homeElementResult.getElements());
        if (serpDisplayType == null) {
            Options options = homeElementResult.getOptions();
            serpDisplayType = SerpDisplayTypeKt.orDefault(options != null ? options.getDisplayType() : null);
        }
        return new HomePageResult(homeInteractorImpl.g.fillItems(homeInteractorImpl.f.sortAndAdjustSync(homeInteractorImpl.f.convertSync(homeElementResult.getElements(), serpDisplayType), i2), homeElementResult.getMoreActions()), serpDisplayType, homeElementResult.getTabs(), homeElementResult.getSearchHint(), homeElementResult.getXHash(), homeElementResult.getLocation());
    }

    public final void a(List<? extends SerpElement> list) {
        for (T t : list) {
            t.setUniqueId(this.l.generateId());
            if (t instanceof SerpVipAdverts) {
                a(t.getAdverts());
            }
        }
    }

    @Override // com.avito.android.home.HomeInteractor
    @NotNull
    public Observable<Boolean> isLocationChanged() {
        return a2.b.a.a.a.a2(this.m, this.k.savedLocation(null, true).map(new a(this)), "locationInteractor.saved…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.stories.StoriesInteractor
    public boolean isStoryViewed(int i2) {
        return this.p.isStoryViewed(i2);
    }

    @Override // com.avito.android.home.HomeInteractor
    @NotNull
    public Observable<ViewTypeSerpItem> loadAds(@NotNull List<? extends ViewTypeSerpItem> list, @Nullable String str, @Nullable SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(list, "items");
        Observable<ViewTypeSerpItem> map = Observable.fromIterable(list).filter(b.a).map(c.a).flatMap(new d(this, this.h.getPageCdtm(), str)).map(new e(this, serpDisplayType)).filter(f.a).map(g.a);
        Intrinsics.checkNotNullExpressionValue(map, "Observable.fromIterable(…      .map { it.first() }");
        return map;
    }

    @Override // com.avito.android.home.HomeInteractor
    @NotNull
    public Observable<LoadingState<HomePageResult>> loadAdverts(@NotNull Location location, int i2, int i3, int i4, @Nullable String str, boolean z, @Nullable SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(location, "location");
        this.r.startLoadingAdverts();
        this.f.setHideSeenBadge(z);
        Boolean bool = null;
        if (location.getId().length() == 0) {
            location = null;
        }
        SearchApi searchApi = this.e;
        Integer valueOf = Integer.valueOf(i2);
        String id = location != null ? location.getId() : null;
        if (location != null) {
            bool = Boolean.valueOf(location.getForcedByUser());
        }
        Observable<LoadingState<HomePageResult>> onErrorReturn = a2.b.a.a.a.a2(this.m, searchApi.getHomePageSerpElements(valueOf, id, str, bool, Integer.valueOf(i3)).map(new a2.a.a.a1.f(this, i3, i4, serpDisplayType)), "searchApi.getHomePageSer…scribeOn(schedulers.io())").map(h.a).startWithItem(LoadingState.Loading.INSTANCE).onErrorReturn(new i(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "loadHomePageAdverts(\n   …eConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.home.HomeInteractor
    @NotNull
    public Observable<Location> loadLocation() {
        Observable<Location> doOnNext = SavedLocationInteractor.DefaultImpls.wrappedLocation$default(this.k, null, false, 3, null).subscribeOn(this.m.io()).map(new j(this)).flatMap(new k(this)).doOnNext(new l(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "locationInteractor.wrapp…          }\n            }");
        return doOnNext;
    }

    @Override // com.avito.android.home.HomeInteractor
    @NotNull
    public Observable<Shortcuts> loadMainShortcuts(@NotNull Location location) {
        Observable<Shortcuts> observable;
        Intrinsics.checkNotNullParameter(location, "location");
        Shortcuts shortcuts = this.a;
        boolean z = true;
        if (shortcuts != null) {
            this.r.startLoadingShortcuts(true);
            observable = Observable.just(shortcuts);
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.just(this)");
        } else {
            this.r.startLoadingShortcuts(false);
            if (location.getId().length() != 0) {
                z = false;
            }
            Boolean bool = null;
            if (z) {
                location = null;
            }
            SearchApi searchApi = this.e;
            String id = location != null ? location.getId() : null;
            if (location != null) {
                bool = Boolean.valueOf(location.getForcedByUser());
            }
            observable = searchApi.getHomeShortcuts(id, bool);
        }
        Observable<Shortcuts> doOnNext = observable.subscribeOn(this.m.io()).doOnNext(new m(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "shortcutRequest\n        …          }\n            }");
        return doOnNext;
    }

    @Override // com.avito.android.search.SearchDeepLinkInteractor
    @NotNull
    public Observable<LoadingState<DeepLink>> loadSearchDeepLink(@NotNull String str, @NotNull SearchParams searchParams, @Nullable String str2, @Nullable Boolean bool, boolean z) {
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        return this.o.loadSearchDeepLink(str, searchParams, str2, bool, z);
    }

    @Override // com.avito.android.stories.StoriesInteractor
    @NotNull
    public Observable<LoadingState<StoriesItem>> loadStories(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        return this.p.loadStories(location);
    }

    @Override // com.avito.android.component.search.SuggestInteractor
    @NotNull
    public Observable<List<SuggestItem>> loadSuggestions(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        Location location = this.b;
        Observable<R> map = this.e.getSearchSuggestV8(str, this.i.convertToMap(new SearchParams(null, null, location != null ? location.getId() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388603, null))).subscribeOn(this.m.io()).map(n.a);
        Intrinsics.checkNotNullExpressionValue(map, "searchApi.getSearchSugge….result.filterNotNull() }");
        return map;
    }

    @Override // com.avito.android.home.HomeInteractor
    @NotNull
    public Observable<SnippetItem> loadWarning() {
        return a2.b.a.a.a.a2(this.m, this.e.getMainWarning().flatMap(new o(this)), "searchApi.getMainWarning…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.stories.StartupBannerInteractor
    @NotNull
    public StartupBannerLocker lockStartupBanner() {
        return this.q.lockStartupBanner();
    }

    @Override // com.avito.android.stories.StoriesInteractor
    public void markStoryViewed(int i2) {
        this.p.markStoryViewed(i2);
    }

    @Override // com.avito.android.home.HomeInteractor
    @NotNull
    public Observable<Unit> onLocationChanged() {
        return this.k.getOnLocationChanged();
    }

    @Override // com.avito.android.home.HomeInteractor
    @NotNull
    public Observable<Unit> onLogin() {
        Observable<R> map = this.n.authorized().filter(new p(this)).doOnNext(new q(this)).map(r.a);
        Intrinsics.checkNotNullExpressionValue(map, "accountStateProvider.aut…            .map { Unit }");
        return map;
    }

    @Override // com.avito.android.home.HomeInteractor
    @NotNull
    public HomeInteractorState onSaveState() {
        return new HomeInteractorState(this.a, this.b, this.n.getCurrentUserId());
    }

    @Override // com.avito.android.stories.StoriesInteractor
    public void resetLastUpdatedTimestamp() {
        this.p.resetLastUpdatedTimestamp();
    }

    @Override // com.avito.android.home.HomeInteractor
    public void resolveItems(@NotNull List<? extends ViewTypeSerpItem> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        this.f.setHideSeenBadge(z);
        this.f.resolveItemsSync(list);
        this.g.resolveStatus(list);
    }

    @Override // com.avito.android.stories.StartupBannerInteractor
    @NotNull
    public Observable<StartupStoryBanner> startupBanner() {
        return this.q.startupBanner();
    }

    @Override // com.avito.android.home.HomeInteractor
    public void updateStoredLocationId(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        this.b = LocationKt.createLocation(location.getId(), "");
        SavedLocationInteractor.DefaultImpls.saveLocation$default(this.k, location, LocationSource.LOCATION_FROM_LAAS, false, 4, null);
    }

    @Override // com.avito.android.stories.StoriesInteractor
    public void updateStoriesViewedStatus(@NotNull List<Story> list) {
        Intrinsics.checkNotNullParameter(list, "stories");
        this.p.updateStoriesViewedStatus(list);
    }
}
