package com.avito.android.favorite_sellers;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.analytics.Analytics;
import com.avito.android.common.ConstantsKt;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.snackbar.Snackbar;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.lib.design.snackbar.SnackbarView;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.recycler.responsive.ResponsiveRecyclerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.subscriptions_settings.SubscriptionSettingsView;
import com.avito.android.util.Contexts;
import com.avito.android.util.ContextsKt;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding3.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.dialog.Dialogs;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\u0006\u0010Y\u001a\u00020Q\u0012\u0006\u0010W\u001a\u00020\u0002\u0012\f\u0010r\u001a\b\u0012\u0004\u0012\u00020q0p\u0012\u0006\u0010t\u001a\u00020s\u0012\u0006\u0010v\u001a\u00020u\u0012\n\b\u0001\u0010w\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bx\u0010yJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0010J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0010J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0010J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0010J\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001e\u0010\u0014J\u000f\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\u0010J\u000f\u0010 \u001a\u00020\fH\u0016¢\u0006\u0004\b \u0010!J\u001d\u0010$\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\u0010J\u000f\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\u0010J\u000f\u0010(\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010\u0010JY\u00104\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010)2\u0006\u0010-\u001a\u00020\t2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"2\u0006\u0010/\u001a\u00020\t2\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b4\u00105J\u0010\u00106\u001a\u00020\u0011H\u0001¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\u0011H\u0001¢\u0006\u0004\b8\u00107J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0001¢\u0006\u0004\b9\u0010\u0006J\u0010\u0010:\u001a\u00020\u0011H\u0001¢\u0006\u0004\b:\u00107J\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0001¢\u0006\u0004\b;\u0010\u0006J\u0010\u0010<\u001a\u00020\u0004H\u0001¢\u0006\u0004\b<\u0010\u0010J\u0018\u0010>\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0011H\u0001¢\u0006\u0004\b>\u0010\u0014J\u0018\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u0011H\u0001¢\u0006\u0004\b@\u0010\u0014J \u0010C\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u0011H\u0001¢\u0006\u0004\bC\u0010DJ\u0018\u0010E\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u0011H\u0001¢\u0006\u0004\bE\u0010\u0014J\u0016\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aH\u0001¢\u0006\u0004\bF\u0010\u001cJ&\u0010J\u001a\u00020\u00042\u0006\u0010H\u001a\u00020G2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00040\"H\u0001¢\u0006\u0004\bJ\u0010KJ\u0016\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0001¢\u0006\u0004\bL\u0010\u0006R\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010SR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010g\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010SR\u0016\u0010i\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bh\u0010SR\u0016\u0010k\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010SR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010n¨\u0006z"}, d2 = {"Lcom/avito/android/favorite_sellers/FavoriteSellersViewImpl;", "Lcom/avito/android/favorite_sellers/FavoriteSellersView;", "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;", "Lio/reactivex/rxjava3/core/Observable;", "", "retryClicks", "()Lio/reactivex/rxjava3/core/Observable;", "refreshClicks", "retryButtonClick", "", "scrollStateChanges", "Lio/reactivex/rxjava3/core/Flowable;", "Lcom/avito/android/favorite_sellers/ViewPortState;", "viewPortChanges", "()Lio/reactivex/rxjava3/core/Flowable;", "notifyItemsChanged", "()V", "", "isVisible", "setEmptyVisible", "(Z)V", "setCommonErrorVisible", "showProgress", "hideProgress", "showOverlayError", "hideOverlayError", "Lio/reactivex/rxjava3/core/Maybe;", "showEnableNotificationsDialog", "()Lio/reactivex/rxjava3/core/Maybe;", "enabled", "setPullToRefreshEnabled", "scrollToTop", "getViewPortState", "()Lcom/avito/android/favorite_sellers/ViewPortState;", "Lkotlin/Function0;", "actionListener", "showUndoSnackbar", "(Lkotlin/jvm/functions/Function0;)V", "dismissUndoSnackbar", "showUndoProgress", "hideUndoProgress", "", "text", "textResId", "actionText", "actionTextResId", "onActionClick", "duration", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", VKApiConst.POSITION, "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "type", "showSnackbar", "(Ljava/lang/String;ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILcom/avito/android/lib/design/snackbar/SnackbarPosition;Lcom/avito/android/lib/design/snackbar/SnackbarType;)V", "canShowSnackbar", "()Z", "closeSubscriptionSettings", "dismissEvents", "isMenuShowing", "notificationClicks", "openSubscriptionSettings", "isActivated", "setNotificationActivated", "isLoading", "setNotificationLoading", "isSubscribed", "isEnabled", "setSubscribed", "(ZZ)V", "setUnsubscribeLoading", "showEnableNotificationDialog", "Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;", "errorDialog", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showErrorDialog", "(Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;Lkotlin/jvm/functions/Function0;)V", "unsubscribeClicks", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", AuthSource.SEND_ABUSE, "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "refreshLayout", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "empty", "k", "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;", "subscriptionSettingsView", "j", "view", "Lcom/avito/android/lib/design/snackbar/Snackbar;", "f", "Lcom/avito/android/lib/design/snackbar/Snackbar;", "undoSnackbar", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "i", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/recycler/responsive/ResponsiveRecyclerAdapter;", "h", "Lcom/avito/android/recycler/responsive/ResponsiveRecyclerAdapter;", "adapter", g.a, "undoProgress", "d", "retryButton", "c", "commonError", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "viewHolderBuilder", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/analytics/Analytics;", "analytics", ConstantsKt.KEY_LIST_BOTTOM_PADDING, "<init>", "(Landroid/view/View;Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;Lcom/avito/android/analytics/Analytics;Ljava/lang/Integer;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSellersViewImpl implements FavoriteSellersView, SubscriptionSettingsView {
    public final SwipeRefreshLayout a;
    public final View b;
    public final View c;
    public final View d;
    public final RecyclerView e;
    public Snackbar f;
    public final View g;
    public final ResponsiveRecyclerAdapter h;
    public ProgressOverlay i;
    public final View j;
    public final SubscriptionSettingsView k;

    public static final class a<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ FavoriteSellersViewImpl a;

        /* renamed from: com.avito.android.favorite_sellers.FavoriteSellersViewImpl$a$a  reason: collision with other inner class name */
        public static final class C0139a implements SwipeRefreshLayout.OnRefreshListener {
            public final /* synthetic */ ObservableEmitter a;

            public C0139a(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                this.a.onNext(Unit.INSTANCE);
            }
        }

        public a(FavoriteSellersViewImpl favoriteSellersViewImpl) {
            this.a = favoriteSellersViewImpl;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> observableEmitter) {
            this.a.a.setOnRefreshListener(new C0139a(observableEmitter));
        }
    }

    public FavoriteSellersViewImpl(@NotNull View view, @NotNull SubscriptionSettingsView subscriptionSettingsView, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder, @NotNull ResponsiveAdapterPresenter responsiveAdapterPresenter, @NotNull Analytics analytics, @Px @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(subscriptionSettingsView, "subscriptionSettingsView");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "viewHolderBuilder");
        Intrinsics.checkNotNullParameter(responsiveAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.j = view;
        this.k = subscriptionSettingsView;
        int i2 = R.id.swipe_refresh_layout;
        View findViewById = view.findViewById(i2);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById;
        this.a = swipeRefreshLayout;
        View findViewById2 = view.findViewById(R.id.empty);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById2;
        View findViewById3 = view.findViewById(R.id.common_error);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById3;
        View findViewById4 = view.findViewById(R.id.button_retry);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.button_retry)");
        this.d = findViewById4;
        View findViewById5 = view.findViewById(R.id.recycler);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById5;
        this.e = recyclerView;
        View findViewById6 = view.findViewById(R.id.undo_progress);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        this.g = findViewById6;
        ResponsiveRecyclerAdapter responsiveRecyclerAdapter = new ResponsiveRecyclerAdapter(responsiveAdapterPresenter, viewHolderBuilder);
        this.h = responsiveRecyclerAdapter;
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        this.i = new ProgressOverlay((ViewGroup) view, i2, analytics, false, 0, 24, null);
        Context context = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int[] pullRefreshColorScheme = ContextsKt.getPullRefreshColorScheme(context);
        swipeRefreshLayout.setColorSchemeColors(Arrays.copyOf(pullRefreshColorScheme, pullRefreshColorScheme.length));
        Context context2 = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(context2, R.attr.white));
        responsiveRecyclerAdapter.setHasStableIds(true);
        recyclerView.setAdapter(responsiveRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        if (num != null) {
            Views.changePadding$default(recyclerView, 0, 0, 0, num.intValue(), 7, null);
            recyclerView.setClipToPadding(false);
        }
    }

    @Override // com.avito.android.lib.design.snackbar.util.OptionalSnackbarElementView
    public boolean canShowSnackbar() {
        return this.k.canShowSnackbar();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public boolean closeSubscriptionSettings() {
        return this.k.closeSubscriptionSettings();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> dismissEvents() {
        return this.k.dismissEvents();
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    public void dismissUndoSnackbar() {
        Snackbar snackbar = this.f;
        if (snackbar != null) {
            snackbar.dismiss();
        }
        this.f = null;
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    @NotNull
    public ViewPortState getViewPortState() {
        RecyclerView.LayoutManager layoutManager = this.e.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        return new ViewPortState(linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition(), linearLayoutManager.findLastCompletelyVisibleItemPosition());
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    public void hideOverlayError() {
        this.i.showContent();
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    public void hideProgress() {
        this.i.showContent();
        this.a.setRefreshing(false);
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    public void hideUndoProgress() {
        Views.hide(this.g);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public boolean isMenuShowing() {
        return this.k.isMenuShowing();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> notificationClicks() {
        return this.k.notificationClicks();
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    public void notifyItemsChanged() {
        this.h.notifyDataSetChanged();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void openSubscriptionSettings() {
        this.k.openSubscriptionSettings();
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    @NotNull
    public Observable<Unit> refreshClicks() {
        Observable<Unit> create = Observable.create(new a(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…tter.onNext(Unit) }\n    }");
        return create;
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    @NotNull
    public Observable<Unit> retryButtonClick() {
        return InteropKt.toV3(RxView.clicks(this.d));
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    @NotNull
    public Observable<Unit> retryClicks() {
        return InteropKt.toV3(this.i.refreshes());
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    @NotNull
    public Observable<Integer> scrollStateChanges() {
        Observable<Integer> create = Observable.create(new FavoriteSellersViewImpl$scrollStateChanges$1(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…istener(listener) }\n    }");
        return create;
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    public void scrollToTop() {
        this.e.scrollToPosition(0);
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    public void setCommonErrorVisible(boolean z) {
        Views.setVisible(this.c, z);
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    public void setEmptyVisible(boolean z) {
        Views.setVisible(this.b, z);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setNotificationActivated(boolean z) {
        this.k.setNotificationActivated(z);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setNotificationLoading(boolean z) {
        this.k.setNotificationLoading(z);
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    public void setPullToRefreshEnabled(boolean z) {
        this.a.setEnabled(z);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setSubscribed(boolean z, boolean z2) {
        this.k.setSubscribed(z, z2);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setUnsubscribeLoading(boolean z) {
        this.k.setUnsubscribeLoading(z);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Maybe<Unit> showEnableNotificationDialog() {
        return this.k.showEnableNotificationDialog();
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    @NotNull
    public Maybe<Unit> showEnableNotificationsDialog() {
        Dialogs dialogs = Dialogs.INSTANCE;
        Context context = this.j.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        return dialogs.showEnableNotifications(context);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void showErrorDialog(@NotNull ErrorResult.ErrorDialog errorDialog, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(errorDialog, "errorDialog");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.k.showErrorDialog(errorDialog, function0);
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    public void showOverlayError() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.i, null, 1, null);
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    public void showProgress() {
        this.i.showLoading();
        Views.hide(this.b);
        Views.hide(this.c);
    }

    @Override // com.avito.android.lib.design.snackbar.util.SnackbarElementView
    public void showSnackbar(@NotNull String str, int i2, @Nullable String str2, int i3, @Nullable Function0<Unit> function0, int i4, @NotNull SnackbarPosition snackbarPosition, @NotNull SnackbarType snackbarType) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(snackbarPosition, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(snackbarType, "type");
        SnackbarExtensionsKt.showSnackbar(this.j, str, i2, str2, i3, function0, i4, snackbarPosition, snackbarType);
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    public void showUndoProgress() {
        Views.show(this.g);
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    public void showUndoSnackbar(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "actionListener");
        Snackbar showSnackbar$default = SnackbarExtensionsKt.showSnackbar$default(this.j, (String) null, R.string.undo_hint, (String) null, R.string.undo_button, function0, 0, (SnackbarPosition) null, (SnackbarType) null, 229, (Object) null);
        showSnackbar$default.setDismissListener(new SnackbarView.OnDismissListener(this) { // from class: com.avito.android.favorite_sellers.FavoriteSellersViewImpl$showUndoSnackbar$$inlined$apply$lambda$1
            public final /* synthetic */ FavoriteSellersViewImpl a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.lib.design.snackbar.SnackbarView.OnDismissListener
            public void onDismiss() {
                this.a.f = null;
            }
        });
        Unit unit = Unit.INSTANCE;
        this.f = showSnackbar$default;
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> unsubscribeClicks() {
        return this.k.unsubscribeClicks();
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersView
    @NotNull
    public Flowable<ViewPortState> viewPortChanges() {
        Flowable<ViewPortState> create = Flowable.create(new FavoriteSellersViewImpl$viewPortChanges$1(this), BackpressureStrategy.LATEST);
        Intrinsics.checkNotNullExpressionValue(create, "Flowable.create({ emitte…kpressureStrategy.LATEST)");
        return create;
    }
}
