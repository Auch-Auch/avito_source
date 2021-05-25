package com.avito.android.shop.detailed.item;

import a2.g.r.g;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.component.search.SearchBar;
import com.avito.android.component.search.SearchBarImpl;
import com.avito.android.design.widget.search_view.SubscriptionButtonState;
import com.avito.android.design.widget.search_view.ToolbarSearchViewImpl;
import com.avito.android.lastclick.LastClick;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.recycler.responsive.ResponsiveRecyclerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.search.suggest.SuggestAction;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.shop.detailed.ShopDetailedViewPresenter;
import com.avito.android.shop.detailed.ShopItemDecorator;
import com.avito.android.ui.adapter.GridLayoutAppendingAdapter;
import com.avito.android.ui.adapter.GridLayoutAppendingHandler;
import com.avito.android.ui_components.R;
import com.avito.android.util.DialogUtils;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B]\u0012\u0007\u0010\u0001\u001a\u00020k\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010¤\u0001\u001a\u00030¡\u0001\u0012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001\u0012\u0006\u0010j\u001a\u00020g\u0012\b\u0010¦\u0001\u001a\u00030¥\u0001\u0012\b\u0010¨\u0001\u001a\u00030§\u0001\u0012\b\u0010ª\u0001\u001a\u00030©\u0001¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0012J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0007J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u0007J\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u0012J\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u0012J\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u000bJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u0012J%\u0010#\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0016¢\u0006\u0004\b#\u0010$JY\u0010.\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010(\u001a\u00020\b2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r2\u0006\u0010*\u001a\u00020\b2\u0006\u0010\t\u001a\u00020+2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0005H\u0001¢\u0006\u0004\b0\u0010\u0012J\u0012\u00101\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u0005H\u0001¢\u0006\u0004\b3\u0010\u0012J\u0010\u00105\u001a\u000204H\u0001¢\u0006\u0004\b5\u00106J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\b07H\u0001¢\u0006\u0004\b8\u00109J\u0016\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000507H\u0001¢\u0006\u0004\b:\u00109J\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00020407H\u0001¢\u0006\u0004\b;\u00109J8\u0010@\u001a\u00020\u00052\b\b\u0001\u0010<\u001a\u00020\b2\b\b\u0001\u0010=\u001a\u00020\b2\b\b\u0002\u0010>\u001a\u0002042\b\b\u0002\u0010?\u001a\u000204H\u0001¢\u0006\u0004\b@\u0010AJ$\u0010C\u001a\u00020\u00052\b\b\u0001\u0010<\u001a\u00020\b2\b\b\u0001\u0010B\u001a\u00020\bH\u0001¢\u0006\u0004\bC\u0010DJ\u0016\u0010F\u001a\b\u0012\u0004\u0012\u00020E07H\u0001¢\u0006\u0004\bF\u00109J\u0018\u0010H\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0003H\u0001¢\u0006\u0004\bH\u0010\u0007J\u0010\u0010I\u001a\u00020\u0005H\u0001¢\u0006\u0004\bI\u0010\u0012J\u001a\u0010K\u001a\u00020\u00052\b\b\u0001\u0010J\u001a\u00020\bH\u0001¢\u0006\u0004\bK\u0010\u000bJ\"\u0010M\u001a\u00020\u00052\b\b\u0001\u0010<\u001a\u00020\b2\u0006\u0010L\u001a\u000204H\u0001¢\u0006\u0004\bM\u0010NJ\u001a\u0010P\u001a\u00020\u00052\b\b\u0001\u0010O\u001a\u00020\bH\u0001¢\u0006\u0004\bP\u0010\u000bJ\u001a\u0010R\u001a\u00020\u00052\b\b\u0001\u0010Q\u001a\u00020\bH\u0001¢\u0006\u0004\bR\u0010\u000bJ\u001a\u0010T\u001a\u00020\u00052\b\b\u0001\u0010S\u001a\u00020\bH\u0001¢\u0006\u0004\bT\u0010\u000bJ\u0018\u0010U\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0003H\u0001¢\u0006\u0004\bU\u0010\u0007J\u0018\u0010W\u001a\u00020\u00052\u0006\u0010V\u001a\u000204H\u0001¢\u0006\u0004\bW\u0010XJ\u0018\u0010Y\u001a\u00020\u00052\u0006\u0010L\u001a\u000204H\u0001¢\u0006\u0004\bY\u0010XJ\u0010\u0010Z\u001a\u00020\u0005H\u0001¢\u0006\u0004\bZ\u0010\u0012J\u0010\u0010[\u001a\u00020\u0005H\u0001¢\u0006\u0004\b[\u0010\u0012J\u0018\u0010\\\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\bH\u0001¢\u0006\u0004\b\\\u0010\u000bJ0\u0010`\u001a\u00020\u00052\b\b\u0001\u0010]\u001a\u00020\b2\b\b\u0001\u0010^\u001a\u00020\b2\n\b\u0001\u0010_\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b`\u0010aJ\u0016\u0010b\u001a\b\u0012\u0004\u0012\u00020\u000307H\u0001¢\u0006\u0004\bb\u00109J\u0018\u0010e\u001a\u00020\u00052\u0006\u0010d\u001a\u00020cH\u0001¢\u0006\u0004\be\u0010fR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010|\u001a\u00020k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010mR\u0019\u0010\u0001\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b~\u0010R\u0018\u0010\u0001\u001a\u00020w8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010yR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R$\u0010\u0001\u001a\r \u0001*\u0005\u0018\u00010\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020k8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010mR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R!\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010 \u0001\u001a\u00020w8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010yR\u001a\u0010¤\u0001\u001a\u00030¡\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001¨\u0006­\u0001"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopDetailedRedesignViewImpl;", "Lcom/avito/android/shop/detailed/item/ShopDetailedRedesignView;", "Lcom/avito/android/component/search/SearchBar;", "", "message", "", "showNotFoundError", "(Ljava/lang/String;)V", "", VKApiConst.POSITION, "scrollToPosition", "(I)V", "phone", "Lkotlin/Function0;", "handler", "addPhoneToDialog", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "showPhoneDialog", "()V", "closePhoneDialog", "showLoading", "hideLoading", "showRetryOverlay", "count", "setColumnsCount", "error", "showError", "showMessage", "showCallButton", "onDataSourceChanged", "notifyItemAtPositionChanged", "showContent", "Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;", "errorDialog", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showErrorDialog", "(Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;Lkotlin/jvm/functions/Function0;)V", "text", "textResId", "actionText", "actionTextResId", "onActionClick", "duration", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "type", "showSnackbar", "(Ljava/lang/String;ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILcom/avito/android/lib/design/snackbar/SnackbarPosition;Lcom/avito/android/lib/design/snackbar/SnackbarType;)V", "close", "getQuery", "()Ljava/lang/String;", "hideNavigationIcon", "", "isVisible", "()Z", "Lio/reactivex/rxjava3/core/Observable;", "menuCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationCallbacks", "openCallbacks", "itemId", "drawableId", "needToTint", "favoritesIconRedesignNeedToTint", "replaceMenuItemIcon", "(IIZZ)V", "stringRes", "replaceMenuItemTitle", "(II)V", "Lcom/avito/android/remote/model/search/suggest/SuggestAction;", "searchSuggestsCallbacks", "hint", "setHint", "setInvisibleSearch", "menuId", "setMenu", "visible", "setMenuItemVisible", "(IZ)V", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "drawableRes", "setNavigationIcon", "setQuery", "enabled", "setSearchEnabled", "(Z)V", "setVisible", "showActionProgress", "showSavedSearchesTooltipIfNeeded", "showSelectedFiltersCount", "targetIdRes", "titleRes", "descriptionRes", "showTapTarget", "(IILjava/lang/Integer;)V", "submitCallbacks", "Lcom/avito/android/design/widget/search_view/SubscriptionButtonState;", "subscriptionButtonState", "toggleSubscriptionButton", "(Lcom/avito/android/design/widget/search_view/SubscriptionButtonState;)V", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", VKApiConst.Q, "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Landroid/view/View;", "e", "Landroid/view/View;", "callButton", "Lcom/avito/android/design/widget/search_view/ToolbarSearchViewImpl;", "c", "Lcom/avito/android/design/widget/search_view/ToolbarSearchViewImpl;", "toolbar", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "shopDetailedContainer", "i", "shadow", "Landroidx/appcompat/app/AlertDialog;", "l", "Landroidx/appcompat/app/AlertDialog;", "phoneCallDialog", "k", "dialogViewContainer", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "f", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", g.a, "Landroid/view/LayoutInflater;", "layoutInflater", AuthSource.OPEN_CHANNEL_LIST, "view", "Lcom/avito/android/shop/detailed/ShopDetailedViewPresenter;", "n", "Lcom/avito/android/shop/detailed/ShopDetailedViewPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "p", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "viewHolderBuilder", "Landroidx/recyclerview/widget/GridLayoutManager;", "h", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "notFoundView", "j", "dialogView", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "o", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "adapterPresenter", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Landroid/view/View;Lcom/avito/android/shop/detailed/ShopDetailedViewPresenter;Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory3;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopDetailedRedesignViewImpl implements ShopDetailedRedesignView, SearchBar {
    public final TextView a;
    public final RecyclerView b;
    public final ToolbarSearchViewImpl c;
    public final ViewGroup d;
    public final View e;
    public final ProgressOverlay f;
    public final LayoutInflater g;
    public final GridLayoutManager h;
    public final View i;
    public final ViewGroup j;
    public final ViewGroup k;
    public AlertDialog l;
    public final View m;
    public final ShopDetailedViewPresenter n;
    public final ResponsiveAdapterPresenter o;
    public final ViewHolderBuilder<BaseViewHolder> p;
    public final SpannedGridPositionProvider q;
    public final /* synthetic */ SearchBarImpl r;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ShopDetailedRedesignViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ShopDetailedRedesignViewImpl shopDetailedRedesignViewImpl) {
            super(0);
            this.a = shopDetailedRedesignViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.n.onRefresh();
            return Unit.INSTANCE;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ShopDetailedRedesignViewImpl a;

        public c(ShopDetailedRedesignViewImpl shopDetailedRedesignViewImpl) {
            this.a = shopDetailedRedesignViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.n.onCallButtonPressed();
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public static final d a = new d();

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            LastClick.Updater.update();
            dialogInterface.dismiss();
        }
    }

    public static final class e implements DialogInterface.OnDismissListener {
        public final /* synthetic */ ShopDetailedRedesignViewImpl a;

        public e(ShopDetailedRedesignViewImpl shopDetailedRedesignViewImpl) {
            this.a = shopDetailedRedesignViewImpl;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            LastClick.Updater.update();
            this.a.n.onPhoneDialogDismissed();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r22v0, resolved type: com.avito.konveyor.blueprint.ViewHolderBuilder<? extends com.avito.konveyor.adapter.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public ShopDetailedRedesignViewImpl(@NotNull View view, @NotNull ShopDetailedViewPresenter shopDetailedViewPresenter, @NotNull ResponsiveAdapterPresenter responsiveAdapterPresenter, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder, @NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup, @NotNull Analytics analytics, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(shopDetailedViewPresenter, "presenter");
        Intrinsics.checkNotNullParameter(responsiveAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "viewHolderBuilder");
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(spanSizeLookup, "spanSizeLookup");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        int i2 = R.id.toolbar_search;
        View findViewById = view.findViewById(i2);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.r = new SearchBarImpl(findViewById, schedulersFactory3, null, 4, null);
        this.m = view;
        this.n = shopDetailedViewPresenter;
        this.o = responsiveAdapterPresenter;
        this.p = viewHolderBuilder;
        this.q = spannedGridPositionProvider;
        View findViewById2 = view.findViewById(com.avito.android.shop.R.id.not_found_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById2;
        View findViewById3 = view.findViewById(com.avito.android.shop.R.id.recycler_view);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.b = recyclerView;
        View findViewById4 = view.findViewById(i2);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.design.widget.search_view.ToolbarSearchViewImpl");
        ToolbarSearchViewImpl toolbarSearchViewImpl = (ToolbarSearchViewImpl) findViewById4;
        this.c = toolbarSearchViewImpl;
        View findViewById5 = view.findViewById(com.avito.android.shop.R.id.not_found_view_container);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById5;
        this.d = viewGroup;
        View findViewById6 = view.findViewById(com.avito.android.shop.R.id.call_button);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        this.e = findViewById6;
        this.g = LayoutInflater.from(view.getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), view.getResources().getInteger(R.integer.profile_adverts_columns), 1, false);
        this.h = gridLayoutManager;
        View findViewById7 = view.findViewById(com.avito.android.shop.R.id.shadow_call_btn);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        this.i = findViewById7;
        View inflate = View.inflate(view.getContext(), com.avito.android.shop.R.layout.shop_call_dialog, null);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        this.j = viewGroup2;
        View findViewById8 = viewGroup2.findViewById(com.avito.android.shop.R.id.shop_call_dialog_container);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.view.ViewGroup");
        this.k = (ViewGroup) findViewById8;
        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        recyclerView.setLayoutManager(gridLayoutManager);
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        recyclerView.addItemDecoration(new ShopItemDecorator(resources));
        recyclerView.setItemAnimator(null);
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, com.avito.android.shop.R.id.content, analytics, false, 0, 24, null);
        this.f = progressOverlay;
        progressOverlay.setOnRefreshListener(new a(this));
        toolbarSearchViewImpl.setNavigationIcon(R.drawable.ic_back_24_blue);
        toolbarSearchViewImpl.setMenu(com.avito.android.shop.R.menu.shop_list);
    }

    @Override // com.avito.android.shop.detailed.item.ShopDetailedRedesignView
    public void addPhoneToDialog(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(function0, "handler");
        View inflate = this.g.inflate(com.avito.android.shop.R.layout.shop_call_dialog_phone, this.j, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) inflate;
        textView.setText(str);
        textView.setOnClickListener(new b(function0));
        this.k.addView(textView);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void close() {
        this.r.close();
    }

    @Override // com.avito.android.shop.detailed.item.ShopDetailedRedesignView
    public void closePhoneDialog() {
        AlertDialog alertDialog;
        if (DialogUtils.isShowing(this.l) && (alertDialog = this.l) != null) {
            alertDialog.dismiss();
        }
    }

    @Override // com.avito.android.component.search.SearchBar
    @Nullable
    public String getQuery() {
        return this.r.getQuery();
    }

    @Override // com.avito.android.shop.detailed.item.ShopDetailedRedesignView
    public void hideLoading() {
        this.f.showContent();
    }

    @Override // com.avito.android.component.search.SearchBar
    public void hideNavigationIcon() {
        this.r.hideNavigationIcon();
    }

    @Override // com.avito.android.component.search.SearchBar
    public boolean isVisible() {
        return this.r.isVisible();
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<Integer> menuCallbacks() {
        return this.r.menuCallbacks();
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<Unit> navigationCallbacks() {
        return this.r.navigationCallbacks();
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsView, com.avito.android.advert.viewed.ViewedAdvertsView
    public void notifyItemAtPositionChanged(int i2) {
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i2);
        }
    }

    @Override // com.avito.android.shop.detailed.item.ShopDetailedRedesignView
    public void onDataSourceChanged() {
        if (this.b.getAdapter() == null) {
            GridLayoutAppendingAdapter gridLayoutAppendingAdapter = new GridLayoutAppendingAdapter(new ResponsiveRecyclerAdapter(this.o, this.p), new GridLayoutAppendingHandler(this.n, this.q));
            gridLayoutAppendingAdapter.setHasStableIds(true);
            this.b.setAdapter(gridLayoutAppendingAdapter);
            return;
        }
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<Boolean> openCallbacks() {
        return this.r.openCallbacks();
    }

    @Override // com.avito.android.component.search.SearchBar
    public void replaceMenuItemIcon(@IdRes int i2, @DrawableRes int i3, boolean z, boolean z2) {
        this.r.replaceMenuItemIcon(i2, i3, z, z2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void replaceMenuItemTitle(@IdRes int i2, @StringRes int i3) {
        this.r.replaceMenuItemTitle(i2, i3);
    }

    @Override // com.avito.android.shop.detailed.item.ShopDetailedRedesignView
    public void scrollToPosition(int i2) {
        this.h.scrollToPositionWithOffset(i2, 0);
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<SuggestAction> searchSuggestsCallbacks() {
        return this.r.searchSuggestsCallbacks();
    }

    @Override // com.avito.android.shop.detailed.item.ShopDetailedRedesignView
    public void setColumnsCount(int i2) {
        this.h.setSpanCount(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        this.r.setHint(str);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setInvisibleSearch() {
        this.r.setInvisibleSearch();
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setMenu(@MenuRes int i2) {
        this.r.setMenu(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setMenuItemVisible(@IdRes int i2, boolean z) {
        this.r.setMenuItemVisible(i2, z);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setMenuTintColor(@ColorRes int i2) {
        this.r.setMenuTintColor(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setMenuTintColorAttr(@AttrRes int i2) {
        this.r.setMenuTintColorAttr(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setNavigationIcon(@DrawableRes int i2) {
        this.r.setNavigationIcon(i2);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setQuery(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.r.setQuery(str);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setSearchEnabled(boolean z) {
        this.r.setSearchEnabled(z);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void setVisible(boolean z) {
        this.r.setVisible(z);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void showActionProgress() {
        this.r.showActionProgress();
    }

    @Override // com.avito.android.shop.detailed.item.ShopDetailedRedesignView
    public void showCallButton() {
        Views.show(this.i);
        Views.show(this.e);
        this.e.setOnClickListener(new c(this));
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsContainerView
    public void showContent() {
        hideLoading();
    }

    @Override // com.avito.android.legacy_mvp.ErrorMessageView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.showSnackBar$default(this.m, str, 0, (String) null, 3, (Function0) null, (Function0) null, 0, 118, (Object) null);
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsContainerView
    public void showErrorDialog(@NotNull ErrorResult.ErrorDialog errorDialog, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(errorDialog, "errorDialog");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    @Override // com.avito.android.shop.detailed.item.ShopDetailedRedesignView
    public void showLoading() {
        this.f.showLoading();
    }

    @Override // com.avito.android.shop.detailed.item.ShopDetailedRedesignView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.m, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.shop.detailed.item.ShopDetailedRedesignView
    public void showNotFoundError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.a.setText(str);
        Views.show(this.a);
        Views.hide(this.b);
    }

    @Override // com.avito.android.shop.detailed.item.ShopDetailedRedesignView
    public void showPhoneDialog() {
        if (!DialogUtils.isShowing(this.l)) {
            if (this.l == null) {
                this.l = new AlertDialog.Builder(this.m.getContext()).setNegativeButton(com.avito.android.deprecated_design.R.string.dismiss, d.a).setOnDismissListener(new e(this)).setView(this.j).create();
            }
            AlertDialog alertDialog = this.l;
            Intrinsics.checkNotNull(alertDialog);
            alertDialog.show();
        }
    }

    @Override // com.avito.android.shop.detailed.item.ShopDetailedRedesignView
    public void showRetryOverlay() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.f, null, 1, null);
    }

    @Override // com.avito.android.component.search.SearchBar
    public void showSavedSearchesTooltipIfNeeded() {
        this.r.showSavedSearchesTooltipIfNeeded();
    }

    @Override // com.avito.android.component.search.SearchBar
    public void showSelectedFiltersCount(int i2) {
        this.r.showSelectedFiltersCount(i2);
    }

    @Override // com.avito.android.lib.design.snackbar.util.SnackbarElementView
    public void showSnackbar(@NotNull String str, int i2, @Nullable String str2, int i3, @Nullable Function0<Unit> function0, int i4, @NotNull SnackbarPosition snackbarPosition, @NotNull SnackbarType snackbarType) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(snackbarPosition, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(snackbarType, "type");
        View view = this.m;
        if (view != null) {
            SnackbarExtensionsKt.showSnackbar(view, str, i2, str2, i3, function0, i4, snackbarPosition, snackbarType);
        }
    }

    @Override // com.avito.android.component.search.SearchBar
    public void showTapTarget(@IdRes int i2, @StringRes int i3, @StringRes @Nullable Integer num) {
        this.r.showTapTarget(i2, i3, num);
    }

    @Override // com.avito.android.component.search.SearchBar
    @NotNull
    public Observable<String> submitCallbacks() {
        return this.r.submitCallbacks();
    }

    @Override // com.avito.android.component.search.SearchBar
    public void toggleSubscriptionButton(@NotNull SubscriptionButtonState subscriptionButtonState) {
        Intrinsics.checkNotNullParameter(subscriptionButtonState, "subscriptionButtonState");
        this.r.toggleSubscriptionButton(subscriptionButtonState);
    }
}
