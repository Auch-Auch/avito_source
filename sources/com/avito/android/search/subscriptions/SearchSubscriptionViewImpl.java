package com.avito.android.search.subscriptions;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.analytics.Analytics;
import com.avito.android.common.ConstantsKt;
import com.avito.android.deep_linking.links.SearchPushSubscription;
import com.avito.android.lib.design.R;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.saved_searches.SavedSearchView;
import com.avito.android.saved_searches.SavedSearchViewImpl;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\u0006\u0010=\u001a\u00020(\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010A\u001a\u00020>\u0012\f\u0010F\u001a\b\u0012\u0004\u0012\u00020C0B\u0012\u0006\u0010H\u001a\u00020G\u0012\n\b\u0001\u0010I\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\bJ\u0010KJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0005J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0016\u0010\u0005J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0001¢\u0006\u0004\b\u0017\u0010\u0014J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012H\u0001¢\u0006\u0004\b\u0019\u0010\u0014J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0001¢\u0006\u0004\b\u001a\u0010\u0014J,\u0010 \u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001f\u001a\u00020\u001eH\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\"\u0010\u0005J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\rH\u0001¢\u0006\u0004\b$\u0010\u0010J\u0010\u0010%\u001a\u00020\u0003H\u0001¢\u0006\u0004\b%\u0010\u0005J\u0010\u0010&\u001a\u00020\u0003H\u0001¢\u0006\u0004\b&\u0010\u0005J\u0010\u0010'\u001a\u00020\u0003H\u0001¢\u0006\u0004\b'\u0010\u0005R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010*R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020C0B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006L"}, d2 = {"Lcom/avito/android/search/subscriptions/SearchSubscriptionViewImpl;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionView;", "Lcom/avito/android/saved_searches/SavedSearchView;", "", "onDataSourceUnavailable", "()V", "showProgress", "hideProgress", "showRefreshing", "hideRefreshing", "showEmpty", "hideEmpty", "onDataChanged", "", "error", "showError", "(Ljava/lang/String;)V", "scrollToTop", "Lio/reactivex/rxjava3/core/Observable;", "applyAction", "()Lio/reactivex/rxjava3/core/Observable;", "closeAction", "closeDialog", "deleteAction", "", "frequencyChangedAction", "openSettingsAction", "Lcom/avito/android/deep_linking/links/SearchPushSubscription;", "subscriptionParams", "selectedId", "", "pushEnabled", "show", "(Lcom/avito/android/deep_linking/links/SearchPushSubscription;Ljava/lang/Integer;Z)V", "showErrorMessage", "message", "showMessage", "showSubscriptionEditedMessage", "showSubscriptionMessage", "showUnsubscriptionMessage", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "emptyView", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "d", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter;", "f", "Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter;", "presenter", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", AuthSource.SEND_ABUSE, "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "swipeRefreshLayout", "e", "view", "Lcom/avito/konveyor/adapter/AdapterPresenter;", g.a, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "h", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "viewHolderBuilder", "Lcom/avito/android/analytics/Analytics;", "analytics", ConstantsKt.KEY_LIST_BOTTOM_PADDING, "<init>", "(Landroid/view/View;Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;Lcom/avito/android/analytics/Analytics;Ljava/lang/Integer;)V", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
public final class SearchSubscriptionViewImpl implements SearchSubscriptionView, SavedSearchView {
    public final SwipeRefreshLayout a;
    public final View b;
    public final RecyclerView c;
    public final ProgressOverlay d;
    public final View e;
    public final SearchSubscriptionPresenter f;
    public final AdapterPresenter g;
    public final ViewHolderBuilder<BaseViewHolder> h;
    public final /* synthetic */ SavedSearchViewImpl i;

    public static final class a implements SwipeRefreshLayout.OnRefreshListener {
        public final /* synthetic */ SearchSubscriptionViewImpl a;

        public a(SearchSubscriptionViewImpl searchSubscriptionViewImpl) {
            this.a = searchSubscriptionViewImpl;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            this.a.f.onRefresh();
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SearchSubscriptionViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SearchSubscriptionViewImpl searchSubscriptionViewImpl) {
            super(0);
            this.a = searchSubscriptionViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.f.onRefresh();
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: com.avito.konveyor.blueprint.ViewHolderBuilder<? extends com.avito.konveyor.adapter.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public SearchSubscriptionViewImpl(@NotNull View view, @NotNull SearchSubscriptionPresenter searchSubscriptionPresenter, @NotNull AdapterPresenter adapterPresenter, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder, @NotNull Analytics analytics, @Px @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(searchSubscriptionPresenter, "presenter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "viewHolderBuilder");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.i = new SavedSearchViewImpl(view);
        this.e = view;
        this.f = searchSubscriptionPresenter;
        this.g = adapterPresenter;
        this.h = viewHolderBuilder;
        View findViewById = view.findViewById(R.id.swipe_refresh_layout);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById;
        this.a = swipeRefreshLayout;
        View findViewById2 = view.findViewById(R.id.empty);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById2;
        View findViewById3 = view.findViewById(R.id.search_subscription_list);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.c = recyclerView;
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) view, R.id.content, analytics, false, 0, 24, null);
        this.d = progressOverlay;
        swipeRefreshLayout.setOnRefreshListener(new a(this));
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        Context context3 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "view.context");
        Context context4 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "view.context");
        swipeRefreshLayout.setColorSchemeColors(Contexts.getColorByAttr(context, R.attr.blue), Contexts.getColorByAttr(context2, R.attr.violet), Contexts.getColorByAttr(context3, R.attr.green), Contexts.getColorByAttr(context4, R.attr.red));
        Context context5 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "view.context");
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(context5, R.attr.white));
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        if (num != null) {
            Views.changePadding$default(recyclerView, 0, 0, 0, num.intValue(), 7, null);
            recyclerView.setClipToPadding(false);
        }
        progressOverlay.setOnRefreshListener(new b(this));
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    @NotNull
    public Observable<Unit> applyAction() {
        PublishRelay<Unit> applyAction = this.i.applyAction();
        Intrinsics.checkNotNullExpressionValue(applyAction, "applyAction(...)");
        return applyAction;
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    @NotNull
    public Observable<Unit> closeAction() {
        PublishRelay<Unit> closeAction = this.i.closeAction();
        Intrinsics.checkNotNullExpressionValue(closeAction, "closeAction(...)");
        return closeAction;
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void closeDialog() {
        this.i.closeDialog();
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    @NotNull
    public Observable<Unit> deleteAction() {
        PublishRelay<Unit> deleteAction = this.i.deleteAction();
        Intrinsics.checkNotNullExpressionValue(deleteAction, "deleteAction(...)");
        return deleteAction;
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    @NotNull
    public Observable<Integer> frequencyChangedAction() {
        PublishRelay<Integer> frequencyChangedAction = this.i.frequencyChangedAction();
        Intrinsics.checkNotNullExpressionValue(frequencyChangedAction, "frequencyChangedAction(...)");
        return frequencyChangedAction;
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionView
    public void hideEmpty() {
        Views.setVisible(this.b, false);
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionView
    public void hideProgress() {
        this.d.showContent();
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionView
    public void hideRefreshing() {
        this.a.setRefreshing(false);
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionView
    public void onDataChanged() {
        if (this.c.getAdapter() == null) {
            this.c.setAdapter(new SimpleRecyclerAdapter(this.g, this.h));
            return;
        }
        RecyclerView.Adapter adapter = this.c.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionView
    public void onDataSourceUnavailable() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.d, null, 1, null);
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    @NotNull
    public Observable<Unit> openSettingsAction() {
        PublishRelay<Unit> openSettingsAction = this.i.openSettingsAction();
        Intrinsics.checkNotNullExpressionValue(openSettingsAction, "openSettingsAction(...)");
        return openSettingsAction;
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionView
    public void scrollToTop() {
        this.c.scrollToPosition(0);
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void show(@NotNull SearchPushSubscription searchPushSubscription, @Nullable Integer num, boolean z) {
        Intrinsics.checkNotNullParameter(searchPushSubscription, "subscriptionParams");
        this.i.show(searchPushSubscription, num, z);
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionView
    public void showEmpty() {
        Views.setVisible(this.b, true);
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.showSnackBar$default(this.e, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void showErrorMessage() {
        this.i.showErrorMessage();
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.i.showMessage(str);
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionView
    public void showProgress() {
        this.d.showLoading();
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionView
    public void showRefreshing() {
        this.a.setRefreshing(true);
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void showSubscriptionEditedMessage() {
        this.i.showSubscriptionEditedMessage();
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void showSubscriptionMessage() {
        this.i.showSubscriptionMessage();
    }

    @Override // com.avito.android.saved_searches.SavedSearchView
    public void showUnsubscriptionMessage() {
        this.i.showUnsubscriptionMessage();
    }
}
