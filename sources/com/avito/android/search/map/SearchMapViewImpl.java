package com.avito.android.search.map;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.component.search.SearchBar;
import com.avito.android.component.search.SearchBarImpl;
import com.avito.android.component.search.SuggestInteractor;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.SaveSearchLink;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.inline_filters.InlineFiltersPresenter;
import com.avito.android.inline_filters.dialog.InlineFilterDialogFactory;
import com.avito.android.inline_filters.dialog.InlineFilterDialogOpener;
import com.avito.android.inline_filters.dialog.InlineFilterDialogOpenerImpl;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.lib.design.button.Button;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.remote.model.search.suggest.SuggestAction;
import com.avito.android.saved_searches.SavedSearchesPresenter;
import com.avito.android.saved_searches.SearchSubscribeReason;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.MapViewAction;
import com.avito.android.search.map.di.PinAdvertsList;
import com.avito.android.search.map.metric.SearchMapTracker;
import com.avito.android.search.map.utils.SnackBarCallbackObservable;
import com.avito.android.search.map.utils.SnackBarCallbackType;
import com.avito.android.search.map.utils.SnackBarsKt$disableSwipeToDismiss$1$1;
import com.avito.android.search.map.view.MapInteractor;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.search.map.view.SerpListResourcesProvider;
import com.avito.android.search.map.view.ZoomButton;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.ui_components.R;
import com.avito.android.util.AvitoSnackbar;
import com.avito.android.util.Contexts;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.jakewharton.rxbinding4.view.RxView;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.bottom_sheet.BottomSheet;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBarImpl;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B¡\u0001\u0012\u0006\u0010j\u001a\u000206\u0012\u0006\u0010O\u001a\u00020L\u0012\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010r\u001a\u00020o\u0012\u0006\u0010|\u001a\u00020y\u0012\b\u0010¡\u0001\u001a\u00030 \u0001\u0012\b\u0010£\u0001\u001a\u00030¢\u0001\u0012\n\b\u0001\u0010¥\u0001\u001a\u00030¤\u0001\u0012\b\u0010§\u0001\u001a\u00030¦\u0001\u0012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010v\u001a\u00020s¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007JC\u0010\u000f\u001a$\u0012\u0006\u0012\u0004\u0018\u00010\f \u000e*\u0011\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\b¢\u0006\u0002\b\r0\b¢\u0006\u0002\b\r*\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0001¢\u0006\u0004\b\u001b\u0010\u001cJq\u0010+\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u001a2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\t0\"2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0(2\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0(H\u0001¢\u0006\u0004\b+\u0010,R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00105\u001a\b\u0012\u0004\u0012\u000202018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010>\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010=R\u0016\u0010A\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010/R\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u000202018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u00104R\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020\t018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u00104R\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u001c\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X.¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u00108R\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010j\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u00108R\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010x\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u00108R\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010~\u001a\u00020e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010gR\u0017\u0010\u0001\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010/R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u000f\u0010\u0001R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010aR(\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\b8\u0016@\u0016X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R!\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006ª\u0001"}, d2 = {"Lcom/avito/android/search/map/SearchMapViewImpl;", "Lcom/avito/android/search/map/SearchMapView;", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogOpener;", "Lcom/avito/android/search/map/SearchMapState;", "state", "", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/search/map/SearchMapState;)Z", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "", "Lio/reactivex/rxjava3/annotations/NonNull;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "(Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/util/SchedulersFactory3;)Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Lazy;", "Lcom/google/android/material/snackbar/Snackbar;", "c", "(Lkotlin/Lazy;)Z", "newState", "render", "(Lcom/avito/android/search/map/SearchMapState;)V", "dismiss", "()V", "Landroid/os/Parcelable;", "onSaveState", "()Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/search/Filter;", "filter", "", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "convertedItems", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "Lkotlin/ParameterName;", "name", "selectedValue", "filterSetListener", "Lkotlin/Function0;", "filterCloseListener", "closeButtonListener", "show", "(Lcom/avito/android/remote/model/search/Filter;Ljava/util/List;Landroid/os/Parcelable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", "k", "Landroid/widget/TextView;", "buttonPanelErrorRetryButton", "Lcom/jakewharton/rxrelay3/Relay;", "Lcom/avito/android/deep_linking/links/DeepLink;", "w", "Lcom/jakewharton/rxrelay3/Relay;", "goToSerpActionRelay", "Landroid/view/View;", "i", "Landroid/view/View;", "buttonPanelLoader", "e", "bottomPanel", "Lcom/avito/android/component/search/SearchBar;", "Lcom/avito/android/component/search/SearchBar;", "searchBar", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "mapContainer", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "f", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "findMeButton", "u", "emptyMapTitle", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "n", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/search/map/view/MapInteractor;", "B", "Lcom/avito/android/search/map/view/MapInteractor;", "mapInteractor", "Lru/avito/component/bottom_sheet/BottomSheet;", "x", "Lru/avito/component/bottom_sheet/BottomSheet;", "emptyMapDialog", "Lcom/avito/android/search/map/view/ZoomButton;", "l", "Lcom/avito/android/search/map/view/ZoomButton;", "buttonZoomMap", VKApiConst.VERSION, "emptyMapDialogActionRelay", "r", "mapVisibleRelay", "Lcom/avito/android/search/map/utils/SnackBarCallbackObservable;", "o", "Lcom/avito/android/search/map/utils/SnackBarCallbackObservable;", "locationPermissionSnackBarObservable", "p", "Lkotlin/Lazy;", "locationSnackbar", "j", "buttonPanelError", "Lcom/avito/android/lib/design/button/Button;", "t", "Lcom/avito/android/lib/design/button/Button;", "emptyMapActionButton", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "view", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "s", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mapGlobalLayoutListener", "Lcom/avito/android/search/map/metric/SearchMapTracker;", "C", "Lcom/avito/android/search/map/metric/SearchMapTracker;", "mapTracker", "Lcom/avito/android/Features;", "G", "Lcom/avito/android/Features;", "features", a2.g.r.g.a, "buttonPanel", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "D", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "listItemVisibilityTracker", AuthSource.OPEN_CHANNEL_LIST, "buttonGoToSerp", "h", "showListButton", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBar;", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBar;", ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS, VKApiConst.Q, "noAdvertsSnackbar", "Lcom/avito/android/search/map/action/MapViewAction;", "z", "Lio/reactivex/rxjava3/core/Observable;", "getActions", "()Lio/reactivex/rxjava3/core/Observable;", "actions", "Lcom/avito/android/search/map/view/SerpListResourcesProvider;", "F", "Lcom/avito/android/search/map/view/SerpListResourcesProvider;", "resourcesProvider", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "serpContainer", "y", "Lcom/avito/android/search/map/SearchMapState;", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithNone;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "backNavigationTestGroup", "backClickObservable", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/component/search/SuggestInteractor;", "suggestInteractor", "Lcom/avito/android/inline_filters/InlineFiltersPresenter;", "inlineFiltersPresenter", "Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "savedSearchesPresenter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "pinAdvertsFavoritePresenter", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;", "inlineFilterDialogFactory", "<init>", "(Landroid/view/View;Lcom/avito/android/search/map/view/MapInteractor;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/component/search/SuggestInteractor;Lcom/avito/android/search/map/metric/SearchMapTracker;Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;Lcom/avito/android/inline_filters/InlineFiltersPresenter;Lcom/avito/android/saved_searches/SavedSearchesPresenter;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;Lcom/avito/android/search/map/view/SerpListResourcesProvider;Lcom/avito/android/Features;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SearchMapViewImpl implements SearchMapView, InlineFilterDialogOpener {
    public final View A;
    public final MapInteractor B;
    public final SearchMapTracker C;
    public final ItemVisibilityTracker D;
    public final ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> E;
    public final SerpListResourcesProvider F;
    public final Features G;
    public final /* synthetic */ InlineFilterDialogOpenerImpl H;
    public final ShortcutNavigationBar a;
    public final SearchBar b;
    public final ViewGroup c;
    public final FrameLayout d;
    public final View e;
    public final FloatingActionButton f;
    public final View g;
    public final TextView h;
    public final View i;
    public final View j;
    public final TextView k;
    public final ZoomButton l;
    public final Button m;
    public final ProgressOverlay n;
    public final SnackBarCallbackObservable o;
    public Lazy<? extends Snackbar> p;
    public final Lazy<Snackbar> q = t6.c.lazy(new x(this));
    public final Relay<Unit> r;
    public final ViewTreeObserver.OnGlobalLayoutListener s;
    public Button t;
    public TextView u;
    public final Relay<DeepLink> v;
    public final Relay<DeepLink> w;
    public final BottomSheet x;
    public SearchMapState y;
    @NotNull
    public final Observable<MapViewAction> z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            LoadState.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[3] = 2;
            LoadState.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[2] = 1;
            iArr2[3] = 2;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T, R> implements Function<Unit, MapViewAction> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public final MapViewAction apply(Unit unit) {
            int i = this.a;
            if (i == 0) {
                return SearchMapViewImpl.access$backClickAction((SearchMapViewImpl) this.b);
            }
            if (i == 1) {
                return SearchMapViewImpl.access$backClickAction((SearchMapViewImpl) this.b);
            }
            throw null;
        }
    }

    public static final class b<T, R> implements Function<Unit, MapViewAction.RefreshClicked> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.RefreshClicked apply(Unit unit) {
            return MapViewAction.RefreshClicked.INSTANCE;
        }
    }

    public static final class c<T, R> implements Function<Unit, MapViewAction.ButtonPanelRetry> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.ButtonPanelRetry apply(Unit unit) {
            return MapViewAction.ButtonPanelRetry.INSTANCE;
        }
    }

    public static final class d<T, R> implements Function<SnackBarCallbackType, MapViewAction.LocationSnackBarCallback> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.LocationSnackBarCallback apply(SnackBarCallbackType snackBarCallbackType) {
            SnackBarCallbackType snackBarCallbackType2 = snackBarCallbackType;
            Intrinsics.checkNotNullExpressionValue(snackBarCallbackType2, "it");
            return new MapViewAction.LocationSnackBarCallback(snackBarCallbackType2);
        }
    }

    public static final class e<T, R> implements Function<DeepLink, MapViewAction.InlineFilterSelected> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.InlineFilterSelected apply(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            return new MapViewAction.InlineFilterSelected(deepLink2);
        }
    }

    public static final class f<T, R> implements Function<Throwable, MapViewAction.ErrorMessage> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.ErrorMessage apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new MapViewAction.ErrorMessage(th2);
        }
    }

    public static final class g<T, R> implements Function<Pair<? extends SearchSubscribeReason, ? extends SaveSearchLink>, MapViewAction.PushSubscriptionStateChanged> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.PushSubscriptionStateChanged apply(Pair<? extends SearchSubscribeReason, ? extends SaveSearchLink> pair) {
            Pair<? extends SearchSubscribeReason, ? extends SaveSearchLink> pair2 = pair;
            Intrinsics.checkNotNullExpressionValue(pair2, "it");
            return new MapViewAction.PushSubscriptionStateChanged(pair2);
        }
    }

    public static final class h<T, R> implements Function<Unit, MapViewAction.RequestAuthAction> {
        public static final h a = new h();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.RequestAuthAction apply(Unit unit) {
            return new MapViewAction.RequestAuthAction();
        }
    }

    public static final class i<T, R> implements Function<Unit, MapViewAction.ShowNotificationSettingsScreenAction> {
        public static final i a = new i();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.ShowNotificationSettingsScreenAction apply(Unit unit) {
            return new MapViewAction.ShowNotificationSettingsScreenAction();
        }
    }

    public static final class j<T, R> implements Function<Unit, MapViewAction.MapVisible> {
        public static final j a = new j();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.MapVisible apply(Unit unit) {
            return MapViewAction.MapVisible.INSTANCE;
        }
    }

    public static final class k<T, R> implements Function<Float, MapViewAction.MapZoomInButtonClicked> {
        public static final k a = new k();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.MapZoomInButtonClicked apply(Float f) {
            return new MapViewAction.MapZoomInButtonClicked(f);
        }
    }

    public static final class l<T, R> implements Function<FavorableItem, MapViewAction.ChangeFavoritePin> {
        public static final l a = new l();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.ChangeFavoritePin apply(FavorableItem favorableItem) {
            FavorableItem favorableItem2 = favorableItem;
            Intrinsics.checkNotNullExpressionValue(favorableItem2, "it");
            return new MapViewAction.ChangeFavoritePin(favorableItem2);
        }
    }

    public static final class m<T, R> implements Function<Float, MapViewAction.MapZoomOutButtonClicked> {
        public static final m a = new m();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.MapZoomOutButtonClicked apply(Float f) {
            return new MapViewAction.MapZoomOutButtonClicked(f);
        }
    }

    public static final class n<T, R> implements Function<DeepLink, MapViewAction.ClearGeoFiltersAction> {
        public static final n a = new n();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.ClearGeoFiltersAction apply(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            return new MapViewAction.ClearGeoFiltersAction(deepLink2);
        }
    }

    public static final class o<T, R> implements Function<DeepLink, MapViewAction.GoToSerpAction> {
        public static final o a = new o();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.GoToSerpAction apply(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            return new MapViewAction.GoToSerpAction(deepLink2);
        }
    }

    public static final class p<T, R> implements Function<Integer, MapViewAction> {
        public static final p a = new p();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction apply(Integer num) {
            Integer num2 = num;
            int i = R.id.menu_subscription;
            if (num2 != null && num2.intValue() == i) {
                return MapViewAction.SearchSubscriptionButtonClicked.INSTANCE;
            }
            int i2 = R.id.menu_clarify;
            if (num2 != null && num2.intValue() == i2) {
                return MapViewAction.FiltersButtonClicked.INSTANCE;
            }
            throw new RuntimeException("Unknown menu item clicked");
        }
    }

    public static final class q<T, R> implements Function<Unit, MapViewAction.MapSettleAction> {
        public final /* synthetic */ SearchMapViewImpl a;

        public q(SearchMapViewImpl searchMapViewImpl) {
            this.a = searchMapViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.MapSettleAction apply(Unit unit) {
            SearchMapState.MapState mapState;
            SearchMapState searchMapState = this.a.y;
            if (((searchMapState == null || (mapState = searchMapState.getMapState()) == null) ? null : mapState.getInitialMapBounds()) == null) {
                this.a.C.startMapDraw();
                this.a.n.showContent();
                this.a.C.trackMapDraw();
            }
            return MapViewAction.MapSettleAction.INSTANCE;
        }
    }

    public static final class r<T, R> implements Function<SuggestAction, MapViewAction.SearchBySuggest> {
        public static final r a = new r();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.SearchBySuggest apply(SuggestAction suggestAction) {
            SuggestAction suggestAction2 = suggestAction;
            Intrinsics.checkNotNullExpressionValue(suggestAction2, "it");
            return new MapViewAction.SearchBySuggest(suggestAction2);
        }
    }

    public static final class s<T, R> implements Function<String, MapViewAction.SearchByQuery> {
        public static final s a = new s();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.SearchByQuery apply(String str) {
            String str2 = str;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            return new MapViewAction.SearchByQuery(str2);
        }
    }

    public static final class t<T, R> implements Function<Unit, MapViewAction.FindMeButtonClicked> {
        public static final t a = new t();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.FindMeButtonClicked apply(Unit unit) {
            return MapViewAction.FindMeButtonClicked.INSTANCE;
        }
    }

    public static final class u<T, R> implements Function<Unit, MapViewAction.ShowListButtonClicked> {
        public static final u a = new u();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.ShowListButtonClicked apply(Unit unit) {
            return MapViewAction.ShowListButtonClicked.INSTANCE;
        }
    }

    public static final class v<T, R> implements Function<ShortcutNavigationItem, MapViewAction.ShortcutClicked> {
        public static final v a = new v();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MapViewAction.ShortcutClicked apply(ShortcutNavigationItem shortcutNavigationItem) {
            ShortcutNavigationItem shortcutNavigationItem2 = shortcutNavigationItem;
            Intrinsics.checkNotNullExpressionValue(shortcutNavigationItem2, "it");
            return new MapViewAction.ShortcutClicked(shortcutNavigationItem2);
        }
    }

    public static final class w<T, R> implements Function<Unit, Float> {
        public final /* synthetic */ SearchMapViewImpl a;

        public w(SearchMapViewImpl searchMapViewImpl) {
            this.a = searchMapViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Float apply(Unit unit) {
            return this.a.B.getCurrentZoom();
        }
    }

    public static final class x extends Lambda implements Function0<Snackbar> {
        public final /* synthetic */ SearchMapViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public x(SearchMapViewImpl searchMapViewImpl) {
            super(0);
            this.a = searchMapViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Snackbar invoke() {
            Snackbar make$default = AvitoSnackbar.make$default(AvitoSnackbar.INSTANCE, this.a.A, R.string.empty_map_message, -2, null, 0, null, null, 0, 0, 504, null);
            View view = make$default.getView();
            Intrinsics.checkNotNullExpressionValue(view, "view");
            Views.withPreDrawListener(view, true, new SnackBarsKt$disableSwipeToDismiss$1$1(make$default));
            return make$default;
        }
    }

    public SearchMapViewImpl(@NotNull View view, @NotNull MapInteractor mapInteractor, @NotNull Observable<Unit> observable, @NotNull Analytics analytics, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SuggestInteractor suggestInteractor, @NotNull SearchMapTracker searchMapTracker, @NotNull ItemVisibilityTracker itemVisibilityTracker, @NotNull InlineFiltersPresenter inlineFiltersPresenter, @NotNull SavedSearchesPresenter savedSearchesPresenter, @PinAdvertsList @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull InlineFilterDialogFactory inlineFilterDialogFactory, @NotNull ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> manuallyExposedAbTestGroup, @NotNull SerpListResourcesProvider serpListResourcesProvider, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mapInteractor, "mapInteractor");
        Intrinsics.checkNotNullParameter(observable, "backClickObservable");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(suggestInteractor, "suggestInteractor");
        Intrinsics.checkNotNullParameter(searchMapTracker, "mapTracker");
        Intrinsics.checkNotNullParameter(itemVisibilityTracker, "listItemVisibilityTracker");
        Intrinsics.checkNotNullParameter(inlineFiltersPresenter, "inlineFiltersPresenter");
        Intrinsics.checkNotNullParameter(savedSearchesPresenter, "savedSearchesPresenter");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "pinAdvertsFavoritePresenter");
        Intrinsics.checkNotNullParameter(inlineFilterDialogFactory, "inlineFilterDialogFactory");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "backNavigationTestGroup");
        Intrinsics.checkNotNullParameter(serpListResourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        this.H = new InlineFilterDialogOpenerImpl(inlineFilterDialogFactory);
        this.A = view;
        this.B = mapInteractor;
        this.C = searchMapTracker;
        this.D = itemVisibilityTracker;
        this.E = manuallyExposedAbTestGroup;
        this.F = serpListResourcesProvider;
        this.G = features;
        View findViewById = view.findViewById(R.id.shortcuts_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        ShortcutNavigationBarImpl shortcutNavigationBarImpl = new ShortcutNavigationBarImpl(findViewById, null, null, features.getLoadFontsFromAssets().invoke().booleanValue(), 6, null);
        this.a = shortcutNavigationBarImpl;
        View findViewById2 = view.findViewById(R.id.toolbar_search);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        SearchBarImpl searchBarImpl = new SearchBarImpl(findViewById2, schedulersFactory3, suggestInteractor);
        this.b = searchBarImpl;
        View findViewById3 = view.findViewById(R.id.map);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById3;
        this.c = viewGroup;
        View findViewById4 = view.findViewById(R.id.serp_container);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.d = (FrameLayout) findViewById4;
        View findViewById5 = view.findViewById(R.id.bottom_panel);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.e = findViewById5;
        View findViewById6 = findViewById5.findViewById(R.id.find_me_button);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type com.google.android.material.floatingactionbutton.FloatingActionButton");
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById6;
        this.f = floatingActionButton;
        View findViewById7 = findViewById5.findViewById(R.id.button_panel);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        this.g = findViewById7;
        View findViewById8 = findViewById7.findViewById(R.id.show_list_button);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById8;
        this.h = textView;
        View findViewById9 = findViewById7.findViewById(R.id.button_panel_load_progress);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.view.View");
        this.i = findViewById9;
        View findViewById10 = findViewById7.findViewById(R.id.button_panel_error);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.view.View");
        this.j = findViewById10;
        View findViewById11 = findViewById7.findViewById(R.id.button_panel_error_retry);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById11;
        this.k = textView2;
        View findViewById12 = view.findViewById(R.id.zoom_map);
        Objects.requireNonNull(findViewById12, "null cannot be cast to non-null type com.avito.android.search.map.view.ZoomButton");
        ZoomButton zoomButton = (ZoomButton) findViewById12;
        this.l = zoomButton;
        View findViewById13 = findViewById5.findViewById(R.id.go_to_serp_button);
        Objects.requireNonNull(findViewById13, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.m = (Button) findViewById13;
        View findViewById14 = view.findViewById(R.id.progress_overlay_container);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "view.findViewById(R.id.progress_overlay_container)");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById14, R.id.container, analytics, false, 0, 24, null);
        this.n = progressOverlay;
        SnackBarCallbackObservable snackBarCallbackObservable = new SnackBarCallbackObservable();
        this.o = snackBarCallbackObservable;
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.r = create;
        SearchMapViewImpl$mapGlobalLayoutListener$1 searchMapViewImpl$mapGlobalLayoutListener$1 = new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.avito.android.search.map.SearchMapViewImpl$mapGlobalLayoutListener$1
            public final /* synthetic */ SearchMapViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (SearchMapViewImpl.access$checkMapVisible(this.a)) {
                    this.a.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    this.a.r.accept(Unit.INSTANCE);
                }
            }
        };
        this.s = searchMapViewImpl$mapGlobalLayoutListener$1;
        PublishRelay create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.v = create2;
        PublishRelay create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.w = create3;
        BottomSheet.Companion companion = BottomSheet.Companion;
        View findViewById15 = view.findViewById(R.id.bottom_sheet);
        Objects.requireNonNull(findViewById15, "null cannot be cast to non-null type android.view.View");
        BottomSheet create4 = companion.create(findViewById15);
        create4.setContentView(R.layout.search_map_dialog_empty_map);
        create4.close();
        create4.setHideable(false);
        View contentView = create4.getContentView();
        Button button = null;
        this.u = contentView != null ? (TextView) contentView.findViewById(R.id.dialog_empty_map_title) : null;
        View contentView2 = create4.getContentView();
        this.t = contentView2 != null ? (Button) contentView2.findViewById(R.id.dialog_empty_map_action_button) : button;
        create4.setPeekHeight(new BottomSheet.PeekHeight.Absolute(Views.dpToPx(create4.getView(), 154)));
        create4.setNotchVisibility(BottomSheet.NotchVisibility.ALWAYS_HIDDEN);
        Views.conceal(create4.getView());
        this.x = create4;
        searchBarImpl.setMenu(R.menu.item_list_saved_searches_push);
        int i2 = R.drawable.ic_back_24_blue;
        searchBarImpl.setNavigationIcon(i2);
        searchBarImpl.setNavigationIcon(i2);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        shortcutNavigationBarImpl.overrideVisibleBackground(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.white));
        inlineFiltersPresenter.attachViews(shortcutNavigationBarImpl, this, searchBarImpl);
        SearchMapState searchMapState = this.y;
        if (searchMapState == null || !searchMapState.getShowSimpleMap()) {
            textView.setText(R.string.search_map_show_list);
        }
        textView.setGravity(16);
        textView2.setText(R.string.try_again);
        progressOverlay.showLoading();
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(searchMapViewImpl$mapGlobalLayoutListener$1);
        Observable<MapViewAction> merge = Observable.merge(CollectionsKt__CollectionsKt.listOf((Object[]) new Observable[]{mapInteractor.mapActions(), observable.map(new a(0, this)), searchBarImpl.navigationCallbacks().map(new a(1, this)), searchBarImpl.menuCallbacks().map(p.a), this.B.mapSettles().map(new q(this)), searchBarImpl.searchSuggestsCallbacks().map(r.a), searchBarImpl.submitCallbacks().map(s.a), RxView.clicks(floatingActionButton).map(t.a), RxView.clicks(textView).map(u.a), shortcutNavigationBarImpl.shortcutClicks().map(v.a), InteropKt.toV3(progressOverlay.refreshes()).map(b.a), RxView.clicks(textView2).map(c.a), snackBarCallbackObservable.callbackObservable$map_release().map(d.a), inlineFiltersPresenter.inlineFilterSelected().map(e.a), inlineFiltersPresenter.errors().map(f.a), savedSearchesPresenter.subscribeAction().map(g.a), savedSearchesPresenter.requestAuthAction().map(h.a), savedSearchesPresenter.showSettingsAction().map(i.a), create.map(j.a), a(zoomButton.getZoomInClicks(), schedulersFactory3).map(k.a), favoriteAdvertsPresenter.subscribeToFavoriteButtonClicked().map(l.a), a(zoomButton.getZoomOutClicks(), schedulersFactory3).map(m.a), create2.map(n.a), create3.map(o.a)}));
        Intrinsics.checkNotNullExpressionValue(merge, "Observable.merge(\n      …        }\n        )\n    )");
        this.z = merge;
    }

    public static final MapViewAction access$backClickAction(SearchMapViewImpl searchMapViewImpl) {
        SearchMapState.PinAdvertsState pinAdvertsState;
        SearchMapState.SerpState serpState;
        if (!searchMapViewImpl.G.getNewMapBackNavigation().invoke().booleanValue()) {
            return MapViewAction.NavigationClicked.INSTANCE;
        }
        searchMapViewImpl.E.expose();
        boolean isTest = searchMapViewImpl.E.getTestGroup().isTest();
        String str = null;
        if (isTest) {
            SearchMapState searchMapState = searchMapViewImpl.y;
            if (Intrinsics.areEqual((searchMapState == null || (serpState = searchMapState.getSerpState()) == null) ? null : serpState.getPanelState(), PanelStateKt.PANEL_EXPANDED)) {
                return MapViewAction.CollapseSerpPanel.INSTANCE;
            }
        }
        if (isTest) {
            SearchMapState searchMapState2 = searchMapViewImpl.y;
            if (!(searchMapState2 == null || (pinAdvertsState = searchMapState2.getPinAdvertsState()) == null)) {
                str = pinAdvertsState.getPanelState();
            }
            if (!Intrinsics.areEqual(str, PanelStateKt.PANEL_HIDDEN)) {
                return MapViewAction.HidePinAdvertsPanel.INSTANCE;
            }
        }
        return MapViewAction.NavigationClicked.INSTANCE;
    }

    public static final boolean access$checkMapVisible(SearchMapViewImpl searchMapViewImpl) {
        ViewParent viewParent = searchMapViewImpl.c;
        while (viewParent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) viewParent;
            if (viewGroup.getVisibility() != 0) {
                return false;
            }
            viewParent = viewGroup.getParent();
        }
        return true;
    }

    public final Observable<Float> a(Observable<Unit> observable, SchedulersFactory3 schedulersFactory3) {
        return observable.throttleFirst(150, TimeUnit.MILLISECONDS, schedulersFactory3.computation()).observeOn(schedulersFactory3.mainThread()).map(new w(this));
    }

    public final boolean b(SearchMapState searchMapState) {
        String panelState = searchMapState.getSerpState().getPanelState();
        return searchMapState.getSerpState().isSerpReady() && (Intrinsics.areEqual(panelState, PanelStateKt.PANEL_HIDDEN) || Intrinsics.areEqual(panelState, "none")) && Intrinsics.areEqual(searchMapState.getPinAdvertsState().getPanelState(), PanelStateKt.PANEL_HIDDEN);
    }

    public final boolean c(Lazy<? extends Snackbar> lazy) {
        return lazy.isInitialized() && ((Snackbar) lazy.getValue()).isShown();
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFilterDialogOpener
    public void dismiss() {
        this.H.dismiss();
    }

    @Override // com.avito.android.search.map.SearchMapView
    @NotNull
    public Observable<MapViewAction> getActions() {
        return this.z;
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFilterDialogOpener
    @Nullable
    public Parcelable onSaveState() {
        return this.H.onSaveState();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:361:0x065c, code lost:
        if (r5 == null) goto L_0x065f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0200, code lost:
        if (((r2 == null || (r5 = r2.getSerpState()) == null) ? null : r5.getLoadState()) != com.avito.android.search.map.LoadState.LOAD) goto L_0x0227;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02d8  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02e0  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0392  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x03c2  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x03cb  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x03d0  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x03db  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x03e0  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x03e3 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x03ea A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0406  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0437  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0439  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x045a  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0469  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x047b  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0496  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x04b9  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x04bc  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x04d0  */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x04df  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0532  */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x0540  */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0574  */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x058f  */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0600  */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x0616  */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x0632  */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x063d  */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x0650  */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x065b  */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x07ef  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01d8  */
    @Override // com.avito.android.search.map.SearchMapView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void render(@org.jetbrains.annotations.NotNull com.avito.android.search.map.SearchMapState r22) {
        /*
        // Method dump skipped, instructions count: 2068
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.map.SearchMapViewImpl.render(com.avito.android.search.map.SearchMapState):void");
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFilterDialogOpener
    public void show(@NotNull Filter filter, @NotNull List<InlineFiltersDialogItem> list, @Nullable Parcelable parcelable, @NotNull Function1<? super InlineFilterValue, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(list, "convertedItems");
        Intrinsics.checkNotNullParameter(function1, "filterSetListener");
        Intrinsics.checkNotNullParameter(function0, "filterCloseListener");
        Intrinsics.checkNotNullParameter(function02, "closeButtonListener");
        this.H.show(filter, list, parcelable, function1, function0, function02);
    }
}
