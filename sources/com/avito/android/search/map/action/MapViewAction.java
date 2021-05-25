package com.avito.android.search.map.action;

import a2.b.a.a.a;
import android.location.Location;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.SaveSearchLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.suggest.SuggestAction;
import com.avito.android.saved_searches.SearchSubscribeReason;
import com.avito.android.search.map.utils.SnackBarCallbackType;
import com.avito.android.search.map.view.MarkerItem;
import com.avito.android.serp.adapter.FavorableItem;
import com.google.android.gms.maps.model.LatLngBounds;
import com.vk.sdk.api.VKApiConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:4\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./01234567B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001489:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijk¨\u0006l"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction;", "Lcom/avito/android/search/map/action/MapAction;", "<init>", "()V", "AddMyLocation", "AppendPinAdverts", "AppendSerp", "ButtonPanelRetry", "ChangeFavoritePin", "CheckLocationRationale", "ClearGeoFiltersAction", "CollapseSerpPanel", "ErrorMessage", "FiltersButtonClicked", "FindMeButtonClicked", "FollowDeepLink", "GoToLocation", "GoToSerpAction", "GradientVisibilityAction", "HidePinAdvertsPanel", "InlineFilterSelected", "LocationRationalResult", "LocationSnackBarCallback", "MapChanges", "MapClicked", "MapGestureMovedEnd", "MapInitializationStarted", "MapInitialized", "MapMoved", "MapSettleAction", "MapSettled", "MapSettledFirstTime", "MapVisible", "MapZoomInButtonClicked", "MapZoomOutButtonClicked", "MarkerClicked", "NavigationClicked", "PinAdvertsPanelScrollStateChanged", "PinAdvertsPanelStateChanged", "PushSubscriptionStateChanged", "RefreshClicked", "RequestAuthAction", "RetryAppendPinAdverts", "RetryAppendSerp", "SearchByQuery", "SearchBySuggest", "SearchSubscriptionButtonClicked", "SerpPanelScrollStateChanged", "SerpPanelStateChanged", "ShortcutClicked", "ShortcutsVisibility", "ShowListButtonClicked", "ShowNotificationSettingsScreenAction", "Snippet", "SuccessAuthForPhoneRequest", "UpdateSearchLocation", "Lcom/avito/android/search/map/action/MapViewAction$NavigationClicked;", "Lcom/avito/android/search/map/action/MapViewAction$ChangeFavoritePin;", "Lcom/avito/android/search/map/action/MapViewAction$UpdateSearchLocation;", "Lcom/avito/android/search/map/action/MapViewAction$SearchSubscriptionButtonClicked;", "Lcom/avito/android/search/map/action/MapViewAction$SearchBySuggest;", "Lcom/avito/android/search/map/action/MapViewAction$SearchByQuery;", "Lcom/avito/android/search/map/action/MapViewAction$FiltersButtonClicked;", "Lcom/avito/android/search/map/action/MapViewAction$FindMeButtonClicked;", "Lcom/avito/android/search/map/action/MapViewAction$CheckLocationRationale;", "Lcom/avito/android/search/map/action/MapViewAction$LocationRationalResult;", "Lcom/avito/android/search/map/action/MapViewAction$LocationSnackBarCallback;", "Lcom/avito/android/search/map/action/MapViewAction$ShowListButtonClicked;", "Lcom/avito/android/search/map/action/MapViewAction$MapInitializationStarted;", "Lcom/avito/android/search/map/action/MapViewAction$MapInitialized;", "Lcom/avito/android/search/map/action/MapViewAction$MapVisible;", "Lcom/avito/android/search/map/action/MapViewAction$ShortcutClicked;", "Lcom/avito/android/search/map/action/MapViewAction$SerpPanelStateChanged;", "Lcom/avito/android/search/map/action/MapViewAction$MapMoved;", "Lcom/avito/android/search/map/action/MapViewAction$MapSettled;", "Lcom/avito/android/search/map/action/MapViewAction$MapSettledFirstTime;", "Lcom/avito/android/search/map/action/MapViewAction$MapChanges;", "Lcom/avito/android/search/map/action/MapViewAction$MapGestureMovedEnd;", "Lcom/avito/android/search/map/action/MapViewAction$MarkerClicked;", "Lcom/avito/android/search/map/action/MapViewAction$MapClicked;", "Lcom/avito/android/search/map/action/MapViewAction$RefreshClicked;", "Lcom/avito/android/search/map/action/MapViewAction$PinAdvertsPanelStateChanged;", "Lcom/avito/android/search/map/action/MapViewAction$ButtonPanelRetry;", "Lcom/avito/android/search/map/action/MapViewAction$AppendPinAdverts;", "Lcom/avito/android/search/map/action/MapViewAction$RetryAppendPinAdverts;", "Lcom/avito/android/search/map/action/MapViewAction$AppendSerp;", "Lcom/avito/android/search/map/action/MapViewAction$RetryAppendSerp;", "Lcom/avito/android/search/map/action/MapViewAction$PinAdvertsPanelScrollStateChanged;", "Lcom/avito/android/search/map/action/MapViewAction$GoToLocation;", "Lcom/avito/android/search/map/action/MapViewAction$AddMyLocation;", "Lcom/avito/android/search/map/action/MapViewAction$SerpPanelScrollStateChanged;", "Lcom/avito/android/search/map/action/MapViewAction$MapSettleAction;", "Lcom/avito/android/search/map/action/MapViewAction$GradientVisibilityAction;", "Lcom/avito/android/search/map/action/MapViewAction$FollowDeepLink;", "Lcom/avito/android/search/map/action/MapViewAction$InlineFilterSelected;", "Lcom/avito/android/search/map/action/MapViewAction$PushSubscriptionStateChanged;", "Lcom/avito/android/search/map/action/MapViewAction$RequestAuthAction;", "Lcom/avito/android/search/map/action/MapViewAction$ShowNotificationSettingsScreenAction;", "Lcom/avito/android/search/map/action/MapViewAction$ClearGeoFiltersAction;", "Lcom/avito/android/search/map/action/MapViewAction$GoToSerpAction;", "Lcom/avito/android/search/map/action/MapViewAction$ErrorMessage;", "Lcom/avito/android/search/map/action/MapViewAction$Snippet;", "Lcom/avito/android/search/map/action/MapViewAction$ShortcutsVisibility;", "Lcom/avito/android/search/map/action/MapViewAction$MapZoomInButtonClicked;", "Lcom/avito/android/search/map/action/MapViewAction$MapZoomOutButtonClicked;", "Lcom/avito/android/search/map/action/MapViewAction$CollapseSerpPanel;", "Lcom/avito/android/search/map/action/MapViewAction$HidePinAdvertsPanel;", "Lcom/avito/android/search/map/action/MapViewAction$SuccessAuthForPhoneRequest;", "map_release"}, k = 1, mv = {1, 4, 2})
public abstract class MapViewAction implements MapAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$AddMyLocation;", "Lcom/avito/android/search/map/action/MapViewAction;", "Landroid/location/Location;", AuthSource.SEND_ABUSE, "Landroid/location/Location;", "getMyLocation", "()Landroid/location/Location;", "myLocation", "<init>", "(Landroid/location/Location;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class AddMyLocation extends MapViewAction {
        @NotNull
        public final Location a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AddMyLocation(@NotNull Location location) {
            super(null);
            Intrinsics.checkNotNullParameter(location, "myLocation");
            this.a = location;
        }

        @NotNull
        public final Location getMyLocation() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$AppendPinAdverts;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class AppendPinAdverts extends MapViewAction {
        @NotNull
        public static final AppendPinAdverts INSTANCE = new AppendPinAdverts();

        public AppendPinAdverts() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$AppendSerp;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class AppendSerp extends MapViewAction {
        @NotNull
        public static final AppendSerp INSTANCE = new AppendSerp();

        public AppendSerp() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$ButtonPanelRetry;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class ButtonPanelRetry extends MapViewAction {
        @NotNull
        public static final ButtonPanelRetry INSTANCE = new ButtonPanelRetry();

        public ButtonPanelRetry() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$ChangeFavoritePin;", "Lcom/avito/android/search/map/action/MapViewAction;", "Lcom/avito/android/serp/adapter/FavorableItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/FavorableItem;", "getItem", "()Lcom/avito/android/serp/adapter/FavorableItem;", "item", "<init>", "(Lcom/avito/android/serp/adapter/FavorableItem;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class ChangeFavoritePin extends MapViewAction {
        @NotNull
        public final FavorableItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChangeFavoritePin(@NotNull FavorableItem favorableItem) {
            super(null);
            Intrinsics.checkNotNullParameter(favorableItem, "item");
            this.a = favorableItem;
        }

        @NotNull
        public final FavorableItem getItem() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$CheckLocationRationale;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class CheckLocationRationale extends MapViewAction {
        @NotNull
        public static final CheckLocationRationale INSTANCE = new CheckLocationRationale();

        public CheckLocationRationale() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$ClearGeoFiltersAction;", "Lcom/avito/android/search/map/action/MapViewAction;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class ClearGeoFiltersAction extends MapViewAction {
        @NotNull
        public final DeepLink a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ClearGeoFiltersAction(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = deepLink;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$CollapseSerpPanel;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class CollapseSerpPanel extends MapViewAction {
        @NotNull
        public static final CollapseSerpPanel INSTANCE = new CollapseSerpPanel();

        public CollapseSerpPanel() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$ErrorMessage;", "Lcom/avito/android/search/map/action/MapViewAction;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getError", "()Ljava/lang/Throwable;", "error", "<init>", "(Ljava/lang/Throwable;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class ErrorMessage extends MapViewAction {
        @NotNull
        public final Throwable a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ErrorMessage(@NotNull Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "error");
            this.a = th;
        }

        @NotNull
        public final Throwable getError() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$FiltersButtonClicked;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class FiltersButtonClicked extends MapViewAction {
        @NotNull
        public static final FiltersButtonClicked INSTANCE = new FiltersButtonClicked();

        public FiltersButtonClicked() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$FindMeButtonClicked;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class FindMeButtonClicked extends MapViewAction {
        @NotNull
        public static final FindMeButtonClicked INSTANCE = new FindMeButtonClicked();

        public FindMeButtonClicked() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$FollowDeepLink;", "Lcom/avito/android/search/map/action/MapViewAction;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class FollowDeepLink extends MapViewAction {
        @NotNull
        public final DeepLink a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FollowDeepLink(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = deepLink;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$GoToLocation;", "Lcom/avito/android/search/map/action/MapViewAction;", "Landroid/location/Location;", AuthSource.SEND_ABUSE, "Landroid/location/Location;", "getPosition", "()Landroid/location/Location;", VKApiConst.POSITION, "<init>", "(Landroid/location/Location;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class GoToLocation extends MapViewAction {
        @NotNull
        public final Location a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GoToLocation(@NotNull Location location) {
            super(null);
            Intrinsics.checkNotNullParameter(location, VKApiConst.POSITION);
            this.a = location;
        }

        @NotNull
        public final Location getPosition() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$GoToSerpAction;", "Lcom/avito/android/search/map/action/MapViewAction;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class GoToSerpAction extends MapViewAction {
        @NotNull
        public final DeepLink a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GoToSerpAction(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = deepLink;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$GradientVisibilityAction;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class GradientVisibilityAction extends MapViewAction {
        @NotNull
        public static final GradientVisibilityAction INSTANCE = new GradientVisibilityAction();

        public GradientVisibilityAction() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$HidePinAdvertsPanel;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class HidePinAdvertsPanel extends MapViewAction {
        @NotNull
        public static final HidePinAdvertsPanel INSTANCE = new HidePinAdvertsPanel();

        public HidePinAdvertsPanel() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$InlineFilterSelected;", "Lcom/avito/android/search/map/action/MapViewAction;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class InlineFilterSelected extends MapViewAction {
        @NotNull
        public final DeepLink a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InlineFilterSelected(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = deepLink;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$LocationRationalResult;", "Lcom/avito/android/search/map/action/MapViewAction;", "", AuthSource.SEND_ABUSE, "Z", "getResult", "()Z", "result", "<init>", "(Z)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class LocationRationalResult extends MapViewAction {
        public final boolean a;

        public LocationRationalResult(boolean z) {
            super(null);
            this.a = z;
        }

        public final boolean getResult() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$LocationSnackBarCallback;", "Lcom/avito/android/search/map/action/MapViewAction;", "Lcom/avito/android/search/map/utils/SnackBarCallbackType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/search/map/utils/SnackBarCallbackType;", "getType", "()Lcom/avito/android/search/map/utils/SnackBarCallbackType;", "type", "<init>", "(Lcom/avito/android/search/map/utils/SnackBarCallbackType;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class LocationSnackBarCallback extends MapViewAction {
        @NotNull
        public final SnackBarCallbackType a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LocationSnackBarCallback(@NotNull SnackBarCallbackType snackBarCallbackType) {
            super(null);
            Intrinsics.checkNotNullParameter(snackBarCallbackType, "type");
            this.a = snackBarCallbackType;
        }

        @NotNull
        public final SnackBarCallbackType getType() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$MapChanges;", "Lcom/avito/android/search/map/action/MapViewAction;", "", AuthSource.BOOKING_ORDER, "Z", "isGesture", "()Z", AuthSource.SEND_ABUSE, "isZoom", "<init>", "(ZZ)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class MapChanges extends MapViewAction {
        public final boolean a;
        public final boolean b;

        public MapChanges(boolean z, boolean z2) {
            super(null);
            this.a = z;
            this.b = z2;
        }

        public final boolean isGesture() {
            return this.b;
        }

        public final boolean isZoom() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$MapClicked;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class MapClicked extends MapViewAction {
        @NotNull
        public static final MapClicked INSTANCE = new MapClicked();

        public MapClicked() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$MapGestureMovedEnd;", "Lcom/avito/android/search/map/action/MapViewAction;", "Lcom/google/android/gms/maps/model/LatLngBounds;", AuthSource.SEND_ABUSE, "Lcom/google/android/gms/maps/model/LatLngBounds;", "getBounds", "()Lcom/google/android/gms/maps/model/LatLngBounds;", "bounds", "", AuthSource.BOOKING_ORDER, "F", "getZoom", "()F", "zoom", "<init>", "(Lcom/google/android/gms/maps/model/LatLngBounds;F)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class MapGestureMovedEnd extends MapViewAction {
        @NotNull
        public final LatLngBounds a;
        public final float b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MapGestureMovedEnd(@NotNull LatLngBounds latLngBounds, float f) {
            super(null);
            Intrinsics.checkNotNullParameter(latLngBounds, "bounds");
            this.a = latLngBounds;
            this.b = f;
        }

        @NotNull
        public final LatLngBounds getBounds() {
            return this.a;
        }

        public final float getZoom() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$MapInitializationStarted;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class MapInitializationStarted extends MapViewAction {
        @NotNull
        public static final MapInitializationStarted INSTANCE = new MapInitializationStarted();

        public MapInitializationStarted() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$MapInitialized;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class MapInitialized extends MapViewAction {
        @NotNull
        public static final MapInitialized INSTANCE = new MapInitialized();

        public MapInitialized() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$MapMoved;", "Lcom/avito/android/search/map/action/MapViewAction;", "", "toString", "()Ljava/lang/String;", "Lcom/google/android/gms/maps/model/LatLngBounds;", AuthSource.SEND_ABUSE, "Lcom/google/android/gms/maps/model/LatLngBounds;", "getBounds", "()Lcom/google/android/gms/maps/model/LatLngBounds;", "bounds", "", AuthSource.BOOKING_ORDER, "F", "getZoom", "()F", "zoom", "<init>", "(Lcom/google/android/gms/maps/model/LatLngBounds;F)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class MapMoved extends MapViewAction {
        @NotNull
        public final LatLngBounds a;
        public final float b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MapMoved(@NotNull LatLngBounds latLngBounds, float f) {
            super(null);
            Intrinsics.checkNotNullParameter(latLngBounds, "bounds");
            this.a = latLngBounds;
            this.b = f;
        }

        @NotNull
        public final LatLngBounds getBounds() {
            return this.a;
        }

        public final float getZoom() {
            return this.b;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("MapMoved(bounds=");
            L.append(this.a);
            L.append(";zoom=");
            L.append(this.b);
            L.append(')');
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$MapSettleAction;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class MapSettleAction extends MapViewAction {
        @NotNull
        public static final MapSettleAction INSTANCE = new MapSettleAction();

        public MapSettleAction() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$MapSettled;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class MapSettled extends MapViewAction {
        @NotNull
        public static final MapSettled INSTANCE = new MapSettled();

        public MapSettled() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$MapSettledFirstTime;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class MapSettledFirstTime extends MapViewAction {
        @NotNull
        public static final MapSettledFirstTime INSTANCE = new MapSettledFirstTime();

        public MapSettledFirstTime() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$MapVisible;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class MapVisible extends MapViewAction {
        @NotNull
        public static final MapVisible INSTANCE = new MapVisible();

        public MapVisible() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$MapZoomInButtonClicked;", "Lcom/avito/android/search/map/action/MapViewAction;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Float;", "getZoom", "()Ljava/lang/Float;", "zoom", "<init>", "(Ljava/lang/Float;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class MapZoomInButtonClicked extends MapViewAction {
        @Nullable
        public final Float a;

        public MapZoomInButtonClicked(@Nullable Float f) {
            super(null);
            this.a = f;
        }

        @Nullable
        public final Float getZoom() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$MapZoomOutButtonClicked;", "Lcom/avito/android/search/map/action/MapViewAction;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Float;", "getZoom", "()Ljava/lang/Float;", "zoom", "<init>", "(Ljava/lang/Float;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class MapZoomOutButtonClicked extends MapViewAction {
        @Nullable
        public final Float a;

        public MapZoomOutButtonClicked(@Nullable Float f) {
            super(null);
            this.a = f;
        }

        @Nullable
        public final Float getZoom() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$MarkerClicked;", "Lcom/avito/android/search/map/action/MapViewAction;", "Lcom/avito/android/search/map/view/MarkerItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/search/map/view/MarkerItem;", "getItem", "()Lcom/avito/android/search/map/view/MarkerItem;", "item", "<init>", "(Lcom/avito/android/search/map/view/MarkerItem;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class MarkerClicked extends MapViewAction {
        @NotNull
        public final MarkerItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MarkerClicked(@NotNull MarkerItem markerItem) {
            super(null);
            Intrinsics.checkNotNullParameter(markerItem, "item");
            this.a = markerItem;
        }

        @NotNull
        public final MarkerItem getItem() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$NavigationClicked;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class NavigationClicked extends MapViewAction {
        @NotNull
        public static final NavigationClicked INSTANCE = new NavigationClicked();

        public NavigationClicked() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$PinAdvertsPanelScrollStateChanged;", "Lcom/avito/android/search/map/action/MapViewAction;", "", AuthSource.SEND_ABUSE, "Z", "getBackToMapVisible", "()Z", "backToMapVisible", "<init>", "(Z)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class PinAdvertsPanelScrollStateChanged extends MapViewAction {
        public final boolean a;

        public PinAdvertsPanelScrollStateChanged(boolean z) {
            super(null);
            this.a = z;
        }

        public final boolean getBackToMapVisible() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$PinAdvertsPanelStateChanged;", "Lcom/avito/android/search/map/action/MapViewAction;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getState", "()Ljava/lang/String;", "state", "<init>", "(Ljava/lang/String;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class PinAdvertsPanelStateChanged extends MapViewAction {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PinAdvertsPanelStateChanged(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "state");
            this.a = str;
        }

        @NotNull
        public final String getState() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\n\u0010\u000bR%\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$PushSubscriptionStateChanged;", "Lcom/avito/android/search/map/action/MapViewAction;", "Lkotlin/Pair;", "Lcom/avito/android/saved_searches/SearchSubscribeReason;", "Lcom/avito/android/deep_linking/links/SaveSearchLink;", AuthSource.SEND_ABUSE, "Lkotlin/Pair;", "getSubscribeData", "()Lkotlin/Pair;", "subscribeData", "<init>", "(Lkotlin/Pair;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class PushSubscriptionStateChanged extends MapViewAction {
        @NotNull
        public final Pair<SearchSubscribeReason, SaveSearchLink> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.Pair<? extends com.avito.android.saved_searches.SearchSubscribeReason, ? extends com.avito.android.deep_linking.links.SaveSearchLink> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PushSubscriptionStateChanged(@NotNull Pair<? extends SearchSubscribeReason, ? extends SaveSearchLink> pair) {
            super(null);
            Intrinsics.checkNotNullParameter(pair, "subscribeData");
            this.a = pair;
        }

        @NotNull
        public final Pair<SearchSubscribeReason, SaveSearchLink> getSubscribeData() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$RefreshClicked;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class RefreshClicked extends MapViewAction {
        @NotNull
        public static final RefreshClicked INSTANCE = new RefreshClicked();

        public RefreshClicked() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$RequestAuthAction;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class RequestAuthAction extends MapViewAction {
        public RequestAuthAction() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$RetryAppendPinAdverts;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class RetryAppendPinAdverts extends MapViewAction {
        @NotNull
        public static final RetryAppendPinAdverts INSTANCE = new RetryAppendPinAdverts();

        public RetryAppendPinAdverts() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$RetryAppendSerp;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class RetryAppendSerp extends MapViewAction {
        @NotNull
        public static final RetryAppendSerp INSTANCE = new RetryAppendSerp();

        public RetryAppendSerp() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$SearchByQuery;", "Lcom/avito/android/search/map/action/MapViewAction;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getQuery", "()Ljava/lang/String;", "query", "<init>", "(Ljava/lang/String;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class SearchByQuery extends MapViewAction {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SearchByQuery(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "query");
            this.a = str;
        }

        @NotNull
        public final String getQuery() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$SearchBySuggest;", "Lcom/avito/android/search/map/action/MapViewAction;", "Lcom/avito/android/remote/model/search/suggest/SuggestAction;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/search/suggest/SuggestAction;", "getSuggestAction", "()Lcom/avito/android/remote/model/search/suggest/SuggestAction;", "suggestAction", "<init>", "(Lcom/avito/android/remote/model/search/suggest/SuggestAction;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class SearchBySuggest extends MapViewAction {
        @NotNull
        public final SuggestAction a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SearchBySuggest(@NotNull SuggestAction suggestAction) {
            super(null);
            Intrinsics.checkNotNullParameter(suggestAction, "suggestAction");
            this.a = suggestAction;
        }

        @NotNull
        public final SuggestAction getSuggestAction() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$SearchSubscriptionButtonClicked;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class SearchSubscriptionButtonClicked extends MapViewAction {
        @NotNull
        public static final SearchSubscriptionButtonClicked INSTANCE = new SearchSubscriptionButtonClicked();

        public SearchSubscriptionButtonClicked() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$SerpPanelScrollStateChanged;", "Lcom/avito/android/search/map/action/MapViewAction;", "", AuthSource.SEND_ABUSE, "Z", "getCanBeShown", "()Z", "canBeShown", "<init>", "(Z)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class SerpPanelScrollStateChanged extends MapViewAction {
        public final boolean a;

        public SerpPanelScrollStateChanged(boolean z) {
            super(null);
            this.a = z;
        }

        public final boolean getCanBeShown() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$SerpPanelStateChanged;", "Lcom/avito/android/search/map/action/MapViewAction;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getState", "()Ljava/lang/String;", "state", "<init>", "(Ljava/lang/String;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class SerpPanelStateChanged extends MapViewAction {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SerpPanelStateChanged(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "state");
            this.a = str;
        }

        @NotNull
        public final String getState() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$ShortcutClicked;", "Lcom/avito/android/search/map/action/MapViewAction;", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", AuthSource.SEND_ABUSE, "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "getShortcutItem", "()Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "shortcutItem", "<init>", "(Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShortcutClicked extends MapViewAction {
        @NotNull
        public final ShortcutNavigationItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShortcutClicked(@NotNull ShortcutNavigationItem shortcutNavigationItem) {
            super(null);
            Intrinsics.checkNotNullParameter(shortcutNavigationItem, "shortcutItem");
            this.a = shortcutNavigationItem;
        }

        @NotNull
        public final ShortcutNavigationItem getShortcutItem() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$ShortcutsVisibility;", "Lcom/avito/android/search/map/action/MapViewAction;", "", AuthSource.SEND_ABUSE, "Z", "getVisible", "()Z", "visible", "<init>", "(Z)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShortcutsVisibility extends MapViewAction {
        public final boolean a;

        public ShortcutsVisibility(boolean z) {
            super(null);
            this.a = z;
        }

        public final boolean getVisible() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$ShowListButtonClicked;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShowListButtonClicked extends MapViewAction {
        @NotNull
        public static final ShowListButtonClicked INSTANCE = new ShowListButtonClicked();

        public ShowListButtonClicked() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$ShowNotificationSettingsScreenAction;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShowNotificationSettingsScreenAction extends MapViewAction {
        public ShowNotificationSettingsScreenAction() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$Snippet;", "Lcom/avito/android/search/map/action/MapViewAction;", "<init>", "()V", "Click", "Close", "Visibility", "Lcom/avito/android/search/map/action/MapViewAction$Snippet$Click;", "Lcom/avito/android/search/map/action/MapViewAction$Snippet$Close;", "Lcom/avito/android/search/map/action/MapViewAction$Snippet$Visibility;", "map_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Snippet extends MapViewAction {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u001f\u001a\u00020\u000f\u0012\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b \u0010!R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR'\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001f\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$Snippet$Click;", "Lcom/avito/android/search/map/action/MapViewAction$Snippet;", "", "e", "Ljava/lang/Boolean;", "getClosesElement", "()Ljava/lang/Boolean;", "closesElement", "Lcom/avito/android/deep_linking/links/DeepLink;", "c", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getAnalytics", "()Ljava/util/Map;", "analytics", "", "d", "I", "getPosition", "()I", VKApiConst.POSITION, AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "<init>", "(Ljava/lang/String;Ljava/util/Map;Lcom/avito/android/deep_linking/links/DeepLink;ILjava/lang/Boolean;)V", "map_release"}, k = 1, mv = {1, 4, 2})
        public static final class Click extends Snippet {
            @NotNull
            public final String a;
            @Nullable
            public final Map<String, String> b;
            @NotNull
            public final DeepLink c;
            public final int d;
            @Nullable
            public final Boolean e;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Click(String str, Map map, DeepLink deepLink, int i, Boolean bool, int i2, j jVar) {
                this(str, map, deepLink, i, (i2 & 16) != 0 ? null : bool);
            }

            @Nullable
            public final Map<String, String> getAnalytics() {
                return this.b;
            }

            @Nullable
            public final Boolean getClosesElement() {
                return this.e;
            }

            @NotNull
            public final DeepLink getDeepLink() {
                return this.c;
            }

            @NotNull
            public final String getId() {
                return this.a;
            }

            public final int getPosition() {
                return this.d;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Click(@NotNull String str, @Nullable Map<String, String> map, @NotNull DeepLink deepLink, int i, @Nullable Boolean bool) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                this.a = str;
                this.b = map;
                this.c = deepLink;
                this.d = i;
                this.e = bool;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015R'\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$Snippet$Close;", "Lcom/avito/android/search/map/action/MapViewAction$Snippet;", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getAnalytics", "()Ljava/util/Map;", "analytics", "", "c", "I", "getPosition", "()I", VKApiConst.POSITION, AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "<init>", "(Ljava/lang/String;Ljava/util/Map;I)V", "map_release"}, k = 1, mv = {1, 4, 2})
        public static final class Close extends Snippet {
            @NotNull
            public final String a;
            @Nullable
            public final Map<String, String> b;
            public final int c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Close(@NotNull String str, @Nullable Map<String, String> map, int i) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "id");
                this.a = str;
                this.b = map;
                this.c = i;
            }

            @Nullable
            public final Map<String, String> getAnalytics() {
                return this.b;
            }

            @NotNull
            public final String getId() {
                return this.a;
            }

            public final int getPosition() {
                return this.c;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R'\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$Snippet$Visibility;", "Lcom/avito/android/search/map/action/MapViewAction$Snippet;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getAnalytics", "()Ljava/util/Map;", "analytics", "", "c", "Z", "isVisible", "()Z", "<init>", "(Ljava/lang/String;Ljava/util/Map;Z)V", "map_release"}, k = 1, mv = {1, 4, 2})
        public static final class Visibility extends Snippet {
            @NotNull
            public final String a;
            @Nullable
            public final Map<String, String> b;
            public final boolean c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Visibility(@NotNull String str, @Nullable Map<String, String> map, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "id");
                this.a = str;
                this.b = map;
                this.c = z;
            }

            @Nullable
            public final Map<String, String> getAnalytics() {
                return this.b;
            }

            @NotNull
            public final String getId() {
                return this.a;
            }

            public final boolean isVisible() {
                return this.c;
            }
        }

        public Snippet() {
            super(null);
        }

        public Snippet(j jVar) {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$SuccessAuthForPhoneRequest;", "Lcom/avito/android/search/map/action/MapViewAction;", "Landroid/os/Parcelable;", AuthSource.SEND_ABUSE, "Landroid/os/Parcelable;", "getData", "()Landroid/os/Parcelable;", "data", "<init>", "(Landroid/os/Parcelable;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class SuccessAuthForPhoneRequest extends MapViewAction {
        @NotNull
        public final Parcelable a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SuccessAuthForPhoneRequest(@NotNull Parcelable parcelable) {
            super(null);
            Intrinsics.checkNotNullParameter(parcelable, "data");
            this.a = parcelable;
        }

        @NotNull
        public final Parcelable getData() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/MapViewAction$UpdateSearchLocation;", "Lcom/avito/android/search/map/action/MapViewAction;", "Lcom/avito/android/remote/model/Location;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Location;", "getLocation", "()Lcom/avito/android/remote/model/Location;", "location", "<init>", "(Lcom/avito/android/remote/model/Location;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class UpdateSearchLocation extends MapViewAction {
        @NotNull
        public final com.avito.android.remote.model.Location a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UpdateSearchLocation(@NotNull com.avito.android.remote.model.Location location) {
            super(null);
            Intrinsics.checkNotNullParameter(location, "location");
            this.a = location;
        }

        @NotNull
        public final com.avito.android.remote.model.Location getLocation() {
            return this.a;
        }
    }

    public MapViewAction() {
    }

    public MapViewAction(j jVar) {
    }
}
