package com.avito.android.search.map.middleware;

import a2.a.a.k2.b.g.r;
import a2.a.a.k2.b.g.s;
import android.os.Parcelable;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.event.ContactSource;
import com.avito.android.async_phone.AsyncPhoneItem;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.async_phone.AsyncPhoneRequestData;
import com.avito.android.deep_linking.ClickStreamLinkHandler;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.ClickStreamLink;
import com.avito.android.deep_linking.links.CreateChannelLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.ItemsSearchLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import com.avito.android.inline_filters.InlineFiltersPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.remote.model.search.suggest.SuggestDeeplink;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.LoadAction;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.action.MapViewAction;
import com.avito.android.search.map.action.SearchParamsChangedAction;
import com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor;
import com.avito.android.search.map.middleware.NavigationMiddleware;
import com.avito.android.search.map.utils.LatLngBoundsKt;
import com.avito.android.search.map.utils.SnackBarCallbackType;
import com.avito.android.search.map.view.advert.AdvertItemEvent;
import com.avito.android.serp.adapter.SerpItem;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenterKt;
import com.avito.android.util.LoadingState;
import com.google.android.gms.maps.model.LatLngBounds;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.ObservablesKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.shortcut_navigation_bar.adapter.ClarifyButtonItem;
import ru.avito.component.shortcut_navigation_bar.adapter.InlineFilterNavigationItem;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItemImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u00100\u001a\u00020.\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010,\u001a\u00020)¢\u0006\u0004\b1\u00102J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJW\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010-R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010/¨\u00063"}, d2 = {"Lcom/avito/android/search/map/middleware/NavigationMiddlewareImpl;", "Lcom/avito/android/search/map/middleware/NavigationMiddleware;", "Lcom/avito/android/search/map/middleware/NavigationMiddleware$Router;", "router", "", "attachRouter", "(Lcom/avito/android/search/map/middleware/NavigationMiddleware$Router;)V", "detachRouter", "()V", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/search/map/action/MapAction;", "actions", "Lcom/avito/android/search/map/SearchMapState;", "state", "create", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "searchMapState", "Lcom/avito/android/remote/model/Image;", "image", "", "advertTitle", "advertPrice", "advertOldPrice", AuthSource.SEND_ABUSE, "(Lcom/avito/android/search/map/middleware/NavigationMiddleware$Router;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/search/map/SearchMapState;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "c", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/search/map/SearchMapState;)Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/account/AccountStateProvider;", "d", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/inline_filters/InlineFiltersPresenter;", "e", "Lcom/avito/android/inline_filters/InlineFiltersPresenter;", "inlineFiltersPresenter", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "f", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "asyncPhonePresenter", "Lcom/avito/android/search/map/middleware/NavigationMiddleware$Router;", "Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "clickStreamLinkHandler", "<init>", "(Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractor;Lcom/avito/android/deep_linking/ClickStreamLinkHandler;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/inline_filters/InlineFiltersPresenter;Lcom/avito/android/async_phone/AsyncPhonePresenter;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class NavigationMiddlewareImpl implements NavigationMiddleware {
    public NavigationMiddleware.Router a;
    public final SearchMapAnalyticsInteractor b;
    public final ClickStreamLinkHandler c;
    public final AccountStateProvider d;
    public final InlineFiltersPresenter e;
    public final AsyncPhonePresenter f;

    public static final class a<T> implements Consumer<Pair<? extends MapAction, ? extends SearchMapState>> {
        public final /* synthetic */ NavigationMiddlewareImpl a;

        public a(NavigationMiddlewareImpl navigationMiddlewareImpl) {
            this.a = navigationMiddlewareImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Pair<? extends MapAction, ? extends SearchMapState> pair) {
            DeepLink targetLink;
            Pair<? extends MapAction, ? extends SearchMapState> pair2 = pair;
            MapAction mapAction = (MapAction) pair2.component1();
            SearchMapState searchMapState = (SearchMapState) pair2.component2();
            NavigationMiddleware.Router router = this.a.a;
            if (router == null) {
                return;
            }
            if (mapAction instanceof MapViewAction.NavigationClicked) {
                router.close();
            } else if (mapAction instanceof MapViewAction.FiltersButtonClicked) {
                router.showFiltersScreen(searchMapState.getSearchParams(), searchMapState.getSerpState().getArea(), searchMapState.getSerpState().getPanelState(), searchMapState.getShowSimpleMap());
            } else if (mapAction instanceof MapViewAction.FollowDeepLink) {
                router.followDeepLink(((MapViewAction.FollowDeepLink) mapAction).getDeepLink());
            } else if (mapAction instanceof MapViewAction.ClearGeoFiltersAction) {
                router.followDeepLink(((MapViewAction.ClearGeoFiltersAction) mapAction).getDeepLink());
            } else if (mapAction instanceof MapViewAction.GoToSerpAction) {
                router.followDeepLink(((MapViewAction.GoToSerpAction) mapAction).getDeepLink());
            } else if (mapAction instanceof MapViewAction.ShortcutClicked) {
                MapViewAction.ShortcutClicked shortcutClicked = (MapViewAction.ShortcutClicked) mapAction;
                ShortcutNavigationItem shortcutItem = shortcutClicked.getShortcutItem();
                if (shortcutItem instanceof ShortcutNavigationItemImpl) {
                    NavigationMiddlewareImpl navigationMiddlewareImpl = this.a;
                    DeepLink deepLink = shortcutClicked.getShortcutItem().getDeepLink();
                    if (deepLink == null) {
                        deepLink = new NoMatchLink();
                    }
                    Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                    NavigationMiddlewareImpl.b(navigationMiddlewareImpl, router, deepLink, searchMapState, null, null, null, null, 120);
                } else if (shortcutItem instanceof InlineFilterNavigationItem) {
                    this.a.e.openInlineFilter((InlineFilterNavigationItem) shortcutClicked.getShortcutItem(), searchMapState.getSearchParams(), searchMapState.getShowSimpleMap());
                } else if (shortcutItem instanceof ClarifyButtonItem) {
                    router.showFiltersScreen(searchMapState.getSearchParams(), searchMapState.getSerpState().getArea(), searchMapState.getSerpState().getPanelState(), searchMapState.getShowSimpleMap());
                }
            } else if (mapAction instanceof AdvertItemEvent.AdvertClicked) {
                NavigationMiddlewareImpl navigationMiddlewareImpl2 = this.a;
                AdvertItemEvent.AdvertClicked advertClicked = (AdvertItemEvent.AdvertClicked) mapAction;
                DeepLink deepLink2 = advertClicked.getAdvert().getDeepLink();
                Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                navigationMiddlewareImpl2.a(router, deepLink2, searchMapState, advertClicked.getImage(), advertClicked.getAdvert().getTitle(), advertClicked.getAdvert().getPrice(), advertClicked.getAdvert().getPreviousPrice());
            } else if (mapAction instanceof AdvertItemEvent.AdvertXlClicked) {
                NavigationMiddlewareImpl navigationMiddlewareImpl3 = this.a;
                AdvertItemEvent.AdvertXlClicked advertXlClicked = (AdvertItemEvent.AdvertXlClicked) mapAction;
                DeepLink deepLink3 = advertXlClicked.getAdvert().getDeepLink();
                Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                navigationMiddlewareImpl3.a(router, deepLink3, searchMapState, advertXlClicked.getImage(), advertXlClicked.getAdvert().getTitle(), advertXlClicked.getAdvert().getPrice(), advertXlClicked.getAdvert().getPreviousPrice());
            } else if (mapAction instanceof AdvertItemEvent.AdvertCall) {
                AdvertItemEvent.AdvertCall advertCall = (AdvertItemEvent.AdvertCall) mapAction;
                NavigationMiddlewareImpl.access$onContactActionClicked(this.a, advertCall.getAdvertId(), advertCall.getDeepLink(), advertCall.getContactSource());
            } else if (mapAction instanceof AdvertItemEvent.AdvertWrite) {
                AdvertItemEvent.AdvertWrite advertWrite = (AdvertItemEvent.AdvertWrite) mapAction;
                NavigationMiddlewareImpl.access$onContactActionClicked(this.a, advertWrite.getAdvertId(), advertWrite.getDeepLink(), advertWrite.getContactSource());
            } else if (mapAction instanceof MapViewAction.SearchBySuggest) {
                MapViewAction.SearchBySuggest searchBySuggest = (MapViewAction.SearchBySuggest) mapAction;
                if (searchBySuggest.getSuggestAction() instanceof SuggestDeeplink) {
                    NavigationMiddlewareImpl navigationMiddlewareImpl4 = this.a;
                    DeepLink deepLink4 = ((SuggestDeeplink) searchBySuggest.getSuggestAction()).getDeepLink();
                    Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                    NavigationMiddlewareImpl.b(navigationMiddlewareImpl4, router, deepLink4, searchMapState, null, null, null, null, 120);
                }
            } else if (mapAction instanceof AdvertItemEvent.EmptyPlaceholderActionClicked) {
                NavigationMiddlewareImpl navigationMiddlewareImpl5 = this.a;
                DeepLink deepLink5 = ((AdvertItemEvent.EmptyPlaceholderActionClicked) mapAction).getDeepLink();
                Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                NavigationMiddlewareImpl.b(navigationMiddlewareImpl5, router, deepLink5, searchMapState, null, null, null, null, 120);
            } else if (mapAction instanceof AdvertItemEvent.WitcherItemSearchButtonClicked) {
                NavigationMiddlewareImpl navigationMiddlewareImpl6 = this.a;
                DeepLink deepLink6 = ((AdvertItemEvent.WitcherItemSearchButtonClicked) mapAction).getDeepLink();
                Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                NavigationMiddlewareImpl.b(navigationMiddlewareImpl6, router, deepLink6, searchMapState, null, null, null, null, 120);
            } else if (mapAction instanceof AdvertItemEvent.WarningItemActionClicked) {
                NavigationMiddlewareImpl navigationMiddlewareImpl7 = this.a;
                DeepLink deepLink7 = ((AdvertItemEvent.WarningItemActionClicked) mapAction).getDeepLink();
                Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                NavigationMiddlewareImpl.b(navigationMiddlewareImpl7, router, deepLink7, searchMapState, null, null, null, null, 120);
            } else if (mapAction instanceof AdvertItemEvent.GroupClicked) {
                AdvertItemEvent.GroupClicked groupClicked = (AdvertItemEvent.GroupClicked) mapAction;
                DeepLink deepLink8 = groupClicked.getDeepLink();
                if (deepLink8 instanceof ItemsSearchLink) {
                    ItemsSearchLink itemsSearchLink = (ItemsSearchLink) deepLink8;
                    if (itemsSearchLink.getExpanded() != null) {
                        itemsSearchLink.getSearchParams().setDisplayType(searchMapState.getSerpState().getDisplayType());
                    }
                }
                NavigationMiddlewareImpl navigationMiddlewareImpl8 = this.a;
                DeepLink deepLink9 = groupClicked.getDeepLink();
                Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                NavigationMiddlewareImpl.b(navigationMiddlewareImpl8, router, deepLink9, searchMapState, null, null, null, null, 120);
            } else if (mapAction instanceof AdvertItemEvent.DeepLinkClicked) {
                NavigationMiddlewareImpl navigationMiddlewareImpl9 = this.a;
                DeepLink deepLink10 = ((AdvertItemEvent.DeepLinkClicked) mapAction).getDeepLink();
                Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                NavigationMiddlewareImpl.b(navigationMiddlewareImpl9, router, deepLink10, searchMapState, null, null, null, null, 120);
            } else if (mapAction instanceof SearchParamsChangedAction) {
                SearchParamsChangedAction searchParamsChangedAction = (SearchParamsChangedAction) mapAction;
                if ((searchParamsChangedAction.getDeepLink() instanceof ItemsSearchLink) && !((ItemsSearchLink) searchParamsChangedAction.getDeepLink()).getShowMap() && !((ItemsSearchLink) searchParamsChangedAction.getDeepLink()).getShowSimpleMap()) {
                    router.followDeepLink(searchParamsChangedAction.getDeepLink(), this.a.b.getParent());
                    router.leaveScreen();
                }
            } else if (mapAction instanceof LoadAction.LoadSearchDeepLink) {
                LoadAction.LoadSearchDeepLink loadSearchDeepLink = (LoadAction.LoadSearchDeepLink) mapAction;
                if (loadSearchDeepLink.getState() instanceof LoadingState.Loaded) {
                    Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                    NavigationMiddlewareImpl.b(this.a, router, (DeepLink) ((LoadingState.Loaded) loadSearchDeepLink.getState()).getData(), searchMapState, null, null, null, null, 120);
                    router.leaveScreen();
                }
            } else if (mapAction instanceof MapViewAction.LocationSnackBarCallback) {
                if (((MapViewAction.LocationSnackBarCallback) mapAction).getType() == SnackBarCallbackType.ACTION_CLICK) {
                    router.showApplicationPermissionsSettings();
                }
            } else if (mapAction instanceof MapViewAction.InlineFilterSelected) {
                NavigationMiddlewareImpl navigationMiddlewareImpl10 = this.a;
                DeepLink deepLink11 = ((MapViewAction.InlineFilterSelected) mapAction).getDeepLink();
                Intrinsics.checkNotNullExpressionValue(searchMapState, "state");
                router.clarifySearchByDeeplink(navigationMiddlewareImpl10.c(deepLink11, searchMapState));
            } else if (mapAction instanceof MapViewAction.ErrorMessage) {
                router.showErrorMessage(((MapViewAction.ErrorMessage) mapAction).getError());
            } else {
                SerpItem serpItem = null;
                if (mapAction instanceof MapViewAction.RequestAuthAction) {
                    if (!this.a.d.isAuthorized()) {
                        NavigationMiddleware.Router.DefaultImpls.showAuth$default(router, NavigationMiddleware.Router.Reason.SEARCH_SUBSCRIPTION, null, 2, null);
                    }
                } else if (mapAction instanceof MapViewAction.ShowNotificationSettingsScreenAction) {
                    router.showNotificationSettingsScreen();
                } else if (mapAction instanceof AdvertItemEvent.AuthForPhoneRequest) {
                    router.showAuth(NavigationMiddleware.Router.Reason.PHONE_REQUEST, ((AdvertItemEvent.AuthForPhoneRequest) mapAction).getData());
                } else if (mapAction instanceof MapViewAction.SuccessAuthForPhoneRequest) {
                    Parcelable data = ((MapViewAction.SuccessAuthForPhoneRequest) mapAction).getData();
                    Objects.requireNonNull(data, "null cannot be cast to non-null type com.avito.android.async_phone.AsyncPhoneRequestData");
                    AsyncPhoneRequestData asyncPhoneRequestData = (AsyncPhoneRequestData) data;
                    AsyncPhoneItem item = asyncPhoneRequestData.getItem();
                    ContactSource contactSource = asyncPhoneRequestData.getContactSource();
                    if (item instanceof SerpItem) {
                        serpItem = item;
                    }
                    SerpItem serpItem2 = serpItem;
                    if (serpItem2 != null && (targetLink = AdvertRichItemPresenterKt.getTargetLink(serpItem2)) != null) {
                        if (targetLink instanceof PhoneRequestLink) {
                            this.a.f.loadPhoneLink(item, null, targetLink, contactSource, new r(item, contactSource, this, mapAction, searchMapState));
                        } else {
                            router.followDeepLink(targetLink);
                        }
                    }
                }
            }
        }
    }

    public static final class b<T, R> implements Function<Pair<? extends MapAction, ? extends SearchMapState>, ObservableSource<? extends MapAction>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends MapAction> apply(Pair<? extends MapAction, ? extends SearchMapState> pair) {
            return Observable.empty();
        }
    }

    @Inject
    public NavigationMiddlewareImpl(@NotNull SearchMapAnalyticsInteractor searchMapAnalyticsInteractor, @NotNull ClickStreamLinkHandler clickStreamLinkHandler, @NotNull AccountStateProvider accountStateProvider, @NotNull InlineFiltersPresenter inlineFiltersPresenter, @NotNull AsyncPhonePresenter asyncPhonePresenter) {
        Intrinsics.checkNotNullParameter(searchMapAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(clickStreamLinkHandler, "clickStreamLinkHandler");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(inlineFiltersPresenter, "inlineFiltersPresenter");
        Intrinsics.checkNotNullParameter(asyncPhonePresenter, "asyncPhonePresenter");
        this.b = searchMapAnalyticsInteractor;
        this.c = clickStreamLinkHandler;
        this.d = accountStateProvider;
        this.e = inlineFiltersPresenter;
        this.f = asyncPhonePresenter;
    }

    public static final void access$onContactActionClicked(NavigationMiddlewareImpl navigationMiddlewareImpl, String str, DeepLink deepLink, ContactSource contactSource) {
        Objects.requireNonNull(navigationMiddlewareImpl);
        if (deepLink != null) {
            if (deepLink instanceof ClickStreamLink) {
                navigationMiddlewareImpl.c.handleDeepLink((ClickStreamLink) deepLink, new s(navigationMiddlewareImpl, str, contactSource));
            } else if (deepLink instanceof PhoneLink) {
                NavigationMiddleware.Router router = navigationMiddlewareImpl.a;
                if (router != null) {
                    router.showCallDialog((PhoneLink) deepLink, str, contactSource.getFromXl());
                }
            } else if (deepLink instanceof CreateChannelLink) {
                NavigationMiddleware.Router router2 = navigationMiddlewareImpl.a;
                if (router2 != null) {
                    router2.followDeepLink(deepLink);
                }
                CreateChannelLink createChannelLink = (CreateChannelLink) deepLink;
                navigationMiddlewareImpl.b.sendWriteToSeller(createChannelLink.getItemId(), contactSource, createChannelLink.getContext());
            } else {
                NavigationMiddleware.Router router3 = navigationMiddlewareImpl.a;
                if (router3 != null) {
                    router3.followDeepLink(deepLink);
                }
            }
        }
    }

    public static /* synthetic */ void b(NavigationMiddlewareImpl navigationMiddlewareImpl, NavigationMiddleware.Router router, DeepLink deepLink, SearchMapState searchMapState, Image image, String str, String str2, String str3, int i) {
        int i2 = i & 8;
        int i3 = i & 16;
        int i4 = i & 32;
        int i5 = i & 64;
        navigationMiddlewareImpl.a(router, deepLink, searchMapState, null, null, null, null);
    }

    public final void a(NavigationMiddleware.Router router, DeepLink deepLink, SearchMapState searchMapState, Image image, String str, String str2, String str3) {
        DeepLink c2 = c(deepLink, searchMapState);
        if (c2 instanceof AdvertDetailsLink) {
            AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) c2;
            NavigationMiddleware.Router.DefaultImpls.openAdvertDetails$default(router, advertDetailsLink.getItemId(), advertDetailsLink.getContext(), str != null ? str : "", str2, str3, image, this.b.getParent(), false, 128, null);
            return;
        }
        router.followDeepLink(c2, this.b.getParent());
    }

    @Override // com.avito.android.search.map.middleware.NavigationMiddleware
    public void attachRouter(@NotNull NavigationMiddleware.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.a = router;
    }

    public final DeepLink c(DeepLink deepLink, SearchMapState searchMapState) {
        DeepLink deepLink2 = deepLink;
        if (deepLink2 instanceof ItemsSearchLink) {
            ItemsSearchLink itemsSearchLink = (ItemsSearchLink) deepLink2;
            if (itemsSearchLink.getShowMap() || itemsSearchLink.getShowSimpleMap()) {
                LatLngBounds mapBounds = searchMapState.getMapState().getMapBounds();
                Area area = mapBounds != null ? LatLngBoundsKt.toArea(mapBounds) : null;
                Area searchArea = itemsSearchLink.getSearchArea();
                if (searchArea == null) {
                    searchArea = searchMapState.getSerpState().getArea();
                }
                SearchParams searchParams = itemsSearchLink.getSearchParams();
                String context = itemsSearchLink.getContext();
                boolean showMap = itemsSearchLink.getShowMap();
                String mapSerpState = itemsSearchLink.getMapSerpState();
                if (mapSerpState == null) {
                    mapSerpState = searchMapState.getSerpState().getPanelState();
                }
                deepLink2 = new ItemsSearchLink(searchParams, context, showMap, searchArea, area, mapSerpState, searchMapState.getMapState().getZoom(), null, false, null, null, itemsSearchLink.getShowSimpleMap(), 1792, null);
            }
        }
        return deepLink2;
    }

    @Override // com.avito.android.redux.Middleware
    @NotNull
    public Observable<MapAction> create(@NotNull Observable<MapAction> observable, @NotNull Observable<SearchMapState> observable2) {
        Intrinsics.checkNotNullParameter(observable, "actions");
        Intrinsics.checkNotNullParameter(observable2, "state");
        Observable<MapAction> flatMap = ObservablesKt.withLatestFrom(observable, observable2).doOnNext(new a(this)).flatMap(b.a);
        Intrinsics.checkNotNullExpressionValue(flatMap, "actions.withLatestFrom(s…able.empty<MapAction>() }");
        return flatMap;
    }

    @Override // com.avito.android.search.map.middleware.NavigationMiddleware
    public void detachRouter() {
        this.a = null;
    }
}
