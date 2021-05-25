package com.avito.android.search.map.interactor;

import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.advert_core.analytics.contactbar.ShowPhoneDialerEvent;
import com.avito.android.advert_core.analytics.contactbar.ShowPhoneDialogEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.CallToSellerConfirmedEvent;
import com.avito.android.analytics.event.CallToSellerEvent;
import com.avito.android.analytics.event.CallToSellerEventKt;
import com.avito.android.analytics.event.ClickFindMeEvent;
import com.avito.android.analytics.event.ClickPinEvent;
import com.avito.android.analytics.event.ClickResetSerpEvent;
import com.avito.android.analytics.event.ClickSearchActionEvent;
import com.avito.android.analytics.event.ClickShortcutEvent;
import com.avito.android.analytics.event.ClickSuggestParametrizedEvent;
import com.avito.android.analytics.event.ContactSource;
import com.avito.android.analytics.event.LoadSerpEvent;
import com.avito.android.analytics.event.MapMoveEvent;
import com.avito.android.analytics.event.MapZoomEvent;
import com.avito.android.analytics.event.MarkerItemsLoadedEvent;
import com.avito.android.analytics.event.NotRestoreStateEvent;
import com.avito.android.analytics.event.ShowSearchMapEvent;
import com.avito.android.analytics.event.WriteToSellerTreeEvent;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.ScreenIdField;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.search.suggest.SuggestAnalyticsEvent;
import com.avito.android.search.map.analytics.event.BackPressMapTreeEvent;
import com.avito.android.search.map.analytics.event.ClearGeoFiltersEvent;
import com.avito.android.search.map.analytics.event.EntranceToMapEvent;
import com.avito.android.search.map.analytics.event.ExitFromMapEvent;
import com.avito.android.search.map.analytics.event.SearchByMapEvent;
import com.avito.android.search.map.di.InitTreeClickStreamParent;
import com.avito.android.search.map.provider.SearchHashProvider;
import com.avito.android.search.map.utils.LatLngBoundsKt;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B5\b\u0007\u0012\u0006\u0010d\u001a\u00020a\u0012\u0006\u0010^\u001a\u00020[\u0012\u0006\u0010h\u001a\u00020e\u0012\u0006\u0010l\u001a\u00020i\u0012\n\b\u0001\u0010`\u001a\u0004\u0018\u00010?¢\u0006\u0004\bo\u0010pJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J3\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J=\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ_\u0010&\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b&\u0010'J!\u0010*\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J#\u0010,\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b,\u0010-J#\u0010.\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b.\u0010-J\u0017\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0013H\u0016¢\u0006\u0004\b0\u00101J\u001f\u00103\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u0013H\u0016¢\u0006\u0004\b3\u00104J'\u00106\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u00132\u0006\u00105\u001a\u00020(H\u0016¢\u0006\u0004\b6\u00107J)\u0010:\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00132\b\u00108\u001a\u0004\u0018\u00010\u00132\u0006\u00109\u001a\u00020(H\u0016¢\u0006\u0004\b:\u00107J)\u0010=\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00132\u0006\u0010<\u001a\u00020;2\b\u00108\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b=\u0010>J\u000f\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0002H\u0016¢\u0006\u0004\bB\u0010\u0004J\u0011\u0010D\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0004\bD\u0010EJ\u0011\u0010F\u001a\u0004\u0018\u00010?H\u0016¢\u0006\u0004\bF\u0010AJ\u0017\u0010I\u001a\u00020\u00022\u0006\u0010H\u001a\u00020GH\u0016¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u0002H\u0016¢\u0006\u0004\bK\u0010\u0004J#\u0010N\u001a\u00020\u00022\u0012\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130L0LH\u0016¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u0002H\u0016¢\u0006\u0004\bP\u0010\u0004J\u000f\u0010Q\u001a\u00020\u0002H\u0016¢\u0006\u0004\bQ\u0010\u0004J\u0017\u0010R\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020?H\u0002¢\u0006\u0004\bT\u0010AR\u0018\u0010W\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010Z\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010`\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010YR\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010m¨\u0006q"}, d2 = {"Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractorImpl;", "Lcom/avito/android/search/map/interactor/SearchMapAnalyticsInteractor;", "", "sendEntranceToMap", "()V", "sendShowScreenEvent", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "total", "Lcom/google/android/gms/maps/model/LatLngBounds;", "bounds", "", "mapZoom", "sendSearchByMap", "(Lcom/avito/android/remote/model/SearchParams;JLcom/google/android/gms/maps/model/LatLngBounds;Ljava/lang/Float;)V", "sendExitFromMap", "Lcom/avito/android/remote/model/SerpDisplayType;", "serpDisplayType", "", "xHash", "sendSerpLoad", "(Lcom/avito/android/remote/model/SearchParams;JLcom/google/android/gms/maps/model/LatLngBounds;Lcom/avito/android/remote/model/SerpDisplayType;Ljava/lang/String;)V", "serpPanelState", "shortcutTitle", "categoryId", "sendClickShortcut", "(Ljava/lang/String;Lcom/google/android/gms/maps/model/LatLngBounds;Ljava/lang/String;Ljava/lang/String;)V", "sendClickFindMe", "(Lcom/google/android/gms/maps/model/LatLngBounds;)V", "", "Lcom/avito/android/analytics/event/ClickPinEvent$PinType;", "pinType", "Lcom/avito/android/analytics/event/ClickPinEvent$PinState;", "pinState", "Lcom/avito/android/analytics/event/ClickPinEvent$PinHighlight;", "pinHighlight", "pinPrice", "sendClickPin", "(Ljava/lang/String;Lcom/google/android/gms/maps/model/LatLngBounds;ILjava/lang/String;Ljava/lang/Float;Lcom/avito/android/analytics/event/ClickPinEvent$PinType;Lcom/avito/android/analytics/event/ClickPinEvent$PinState;Lcom/avito/android/analytics/event/ClickPinEvent$PinHighlight;Ljava/lang/String;)V", "", "fromActionBar", "sendClickBack", "(Ljava/lang/String;Z)V", "sendMapScroll", "(Lcom/google/android/gms/maps/model/LatLngBounds;Ljava/lang/Float;)V", "sendMapZoom", BookingInfoActivity.EXTRA_ITEM_ID, "sendAdvertXlConfirmedCall", "(Ljava/lang/String;)V", "source", "sendShowPhoneDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "success", "sendShowPhoneDialer", "(Ljava/lang/String;Ljava/lang/String;Z)V", "context", "fromXl", "sendCallToSeller", "Lcom/avito/android/analytics/event/ContactSource;", "contactSource", "sendWriteToSeller", "(Ljava/lang/String;Lcom/avito/android/analytics/event/ContactSource;Ljava/lang/String;)V", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getParent", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "searchParamChange", "Lcom/avito/android/search/map/interactor/ParentType;", "getParentType", "()Lcom/avito/android/search/map/interactor/ParentType;", "getSavedParent", "Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;", "event", "sendClickSearchSuggest", "(Lcom/avito/android/remote/model/search/suggest/SuggestAnalyticsEvent;)V", "sendSearchSubmit", "", "items", "sendMarkerItemsLoaded", "(Ljava/util/List;)V", "sendResetActionClick", "sendNotRestoreState", "sendClearGeoFilters", "(Lcom/avito/android/remote/model/SearchParams;)V", AuthSource.SEND_ABUSE, "c", "Lcom/avito/android/search/map/interactor/ParentType;", "parentType", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "transitionReasonParent", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "e", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "h", "parent", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/Features;", "f", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/search/map/provider/SearchHashProvider;", g.a, "Lcom/avito/android/search/map/provider/SearchHashProvider;", "searchHashProvider", "J", "stateId", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/provider/TreeStateIdGenerator;Lcom/avito/android/Features;Lcom/avito/android/search/map/provider/SearchHashProvider;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SearchMapAnalyticsInteractorImpl implements SearchMapAnalyticsInteractor {
    public long a;
    public TreeClickStreamParent b;
    public ParentType c;
    public final Analytics d;
    public final TreeStateIdGenerator e;
    public Features f;
    public final SearchHashProvider g;
    public TreeClickStreamParent h;

    @Inject
    public SearchMapAnalyticsInteractorImpl(@NotNull Analytics analytics, @NotNull TreeStateIdGenerator treeStateIdGenerator, @NotNull Features features, @NotNull SearchHashProvider searchHashProvider, @InitTreeClickStreamParent @Nullable TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(treeStateIdGenerator, "treeStateIdGenerator");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(searchHashProvider, "searchHashProvider");
        this.d = analytics;
        this.e = treeStateIdGenerator;
        this.f = features;
        this.g = searchHashProvider;
        this.h = treeClickStreamParent;
        this.a = treeStateIdGenerator.nextStateId();
    }

    public final TreeClickStreamParent a() {
        return new TreeClickStreamParent(this.a, ScreenIdField.SERP.name(), null, null);
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    @NotNull
    public TreeClickStreamParent getParent() {
        TreeClickStreamParent treeClickStreamParent = this.b;
        return treeClickStreamParent != null ? treeClickStreamParent : a();
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    @Nullable
    public ParentType getParentType() {
        return this.c;
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    @Nullable
    public TreeClickStreamParent getSavedParent() {
        return this.h;
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void searchParamChange() {
        this.c = ParentType.SEARCH_PARAMS_CHANGE;
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendAdvertXlConfirmedCall(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.d.track(new CallToSellerConfirmedEvent(str, null));
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendCallToSeller(@NotNull String str, @Nullable String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.d.track(new CallToSellerEvent(str, null, str2, z ? CallToSellerEventKt.CALL_SOURCE_XL_ITEM : "s", 0));
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendClearGeoFilters(@NotNull SearchParams searchParams) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        this.d.track(new ClearGeoFiltersEvent(searchParams, this.g.getSearchHash()));
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendClickBack(@Nullable String str, boolean z) {
        this.d.track(new BackPressMapTreeEvent(this.e.nextStateId(), this.h, str, z));
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendClickFindMe(@Nullable LatLngBounds latLngBounds) {
        this.d.track(new ClickFindMeEvent(this.e.nextStateId(), this.h, latLngBounds != null ? LatLngBoundsKt.toAnalyticsCoords(latLngBounds) : null, this.g.getSearchHash()));
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendClickPin(@NotNull String str, @Nullable LatLngBounds latLngBounds, int i, @Nullable String str2, @Nullable Float f2, @NotNull ClickPinEvent.PinType pinType, @NotNull ClickPinEvent.PinState pinState, @NotNull ClickPinEvent.PinHighlight pinHighlight, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "serpPanelState");
        Intrinsics.checkNotNullParameter(pinType, "pinType");
        Intrinsics.checkNotNullParameter(pinState, "pinState");
        Intrinsics.checkNotNullParameter(pinHighlight, "pinHighlight");
        long nextStateId = this.e.nextStateId();
        this.d.track(new ClickPinEvent(nextStateId, this.h, str, latLngBounds != null ? LatLngBoundsKt.toAnalyticsCoords(latLngBounds) : null, str2, i, this.g.getSearchHash(), f2 != null ? (int) f2.floatValue() : 0, pinType, pinState, pinHighlight, str3));
        this.b = new TreeClickStreamParent(nextStateId, ScreenIdField.SERP.name(), null, null);
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendClickSearchSuggest(@NotNull SuggestAnalyticsEvent suggestAnalyticsEvent) {
        Intrinsics.checkNotNullParameter(suggestAnalyticsEvent, "event");
        this.d.track(ClickSuggestParametrizedEvent.Companion.fromAction(suggestAnalyticsEvent));
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendClickShortcut(@NotNull String str, @Nullable LatLngBounds latLngBounds, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "serpPanelState");
        Intrinsics.checkNotNullParameter(str2, "shortcutTitle");
        long nextStateId = this.e.nextStateId();
        this.d.track(new ClickShortcutEvent(nextStateId, this.h, str, latLngBounds != null ? LatLngBoundsKt.toAnalyticsCoords(latLngBounds) : null, str2, str3));
        this.b = new TreeClickStreamParent(nextStateId, ScreenIdField.SERP.name(), null, null);
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendEntranceToMap() {
        long nextStateId = this.e.nextStateId();
        this.a = nextStateId;
        this.d.track(new EntranceToMapEvent(nextStateId, this.h));
        this.h = a();
        this.c = ParentType.ENTRANCE_TO_MAP;
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendExitFromMap() {
        this.d.track(new ExitFromMapEvent(this.e.nextStateId(), this.h));
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendMapScroll(@Nullable LatLngBounds latLngBounds, @Nullable Float f2) {
        this.d.track(new MapMoveEvent(this.e.nextStateId(), this.h, latLngBounds != null ? LatLngBoundsKt.toAnalyticsCoords(latLngBounds) : null, this.g.getSearchHash(), f2 != null ? (int) f2.floatValue() : 0));
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendMapZoom(@Nullable LatLngBounds latLngBounds, @Nullable Float f2) {
        this.d.track(new MapZoomEvent(this.e.nextStateId(), this.h, latLngBounds != null ? LatLngBoundsKt.toAnalyticsCoords(latLngBounds) : null, this.g.getSearchHash(), f2 != null ? (int) f2.floatValue() : 0));
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendMarkerItemsLoaded(@NotNull List<? extends List<String>> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.d.track(new MarkerItemsLoadedEvent(this.e.nextStateId(), this.h, d.listOf(list), this.g.getSearchHash()));
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendNotRestoreState() {
        this.d.track(new NotRestoreStateEvent(ScreenIdField.SERP.name()));
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendResetActionClick() {
        this.d.track(new ClickResetSerpEvent());
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendSearchByMap(@NotNull SearchParams searchParams, long j, @Nullable LatLngBounds latLngBounds, @Nullable Float f2) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        long nextStateId = this.e.nextStateId();
        this.a = nextStateId;
        this.d.track(new SearchByMapEvent(nextStateId, this.h, searchParams, j, latLngBounds != null ? LatLngBoundsKt.toAnalyticsCoords(latLngBounds) : null, this.g.getAndUpdateSearchHash(), f2 != null ? (int) f2.floatValue() : 0));
        this.h = a();
        this.c = ParentType.MAP;
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendSearchSubmit() {
        this.d.track(new ClickSearchActionEvent());
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendSerpLoad(@NotNull SearchParams searchParams, long j, @Nullable LatLngBounds latLngBounds, @Nullable SerpDisplayType serpDisplayType, @Nullable String str) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        long nextStateId = this.e.nextStateId();
        this.a = nextStateId;
        this.d.track(new LoadSerpEvent(nextStateId, this.h, searchParams, j, latLngBounds != null ? LatLngBoundsKt.toAnalyticsCoords(latLngBounds) : null, serpDisplayType, null, null, str, 192, null));
        TreeClickStreamParent a3 = a();
        this.h = a3;
        this.b = a3;
        this.c = ParentType.SERP;
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendShowPhoneDialer(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "source");
        this.d.track(new ShowPhoneDialerEvent(str, str2, z, null, null, 24, null));
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendShowPhoneDialog(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "source");
        this.d.track(new ShowPhoneDialogEvent(str, str2));
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendShowScreenEvent() {
        if (this.f.getNewShowScreenClickstreamEvents().invoke().booleanValue()) {
            this.d.track(new ShowSearchMapEvent());
        }
    }

    @Override // com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor
    public void sendWriteToSeller(@NotNull String str, @NotNull ContactSource contactSource, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(contactSource, "contactSource");
        this.d.track(new WriteToSellerTreeEvent(this.e.nextStateId(), this.h, str, contactSource.getFromXl() ? WriteToSellerTreeEvent.SOURCE_XL_ADVERT_SNIPPET : "s", contactSource.getBlock(), ScreenIdField.SERP.getId(), str2));
    }
}
