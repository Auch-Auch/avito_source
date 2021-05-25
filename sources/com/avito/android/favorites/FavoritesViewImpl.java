package com.avito.android.favorites;

import a2.a.a.t0.x0;
import a2.a.a.t0.y0;
import a2.g.r.g;
import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.analytics.Analytics;
import com.avito.android.common.ConstantsKt;
import com.avito.android.favorites.FavoritesView;
import com.avito.android.lib.design.R;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.ContextsKt;
import com.avito.android.util.MenuWrapper;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.google.android.material.snackbar.Snackbar;
import com.vk.sdk.api.VKApiConst;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010I\u001a\u00020F\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010K\u001a\u00020J\u0012\n\b\u0001\u0010L\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\bM\u0010NJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\bJ-\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006O"}, d2 = {"Lcom/avito/android/favorites/FavoritesViewImpl;", "Lcom/avito/android/favorites/FavoritesView;", "", "onDataChanged", "()V", "", "message", "showErrorOverlay", "(Ljava/lang/String;)V", "showProgress", "hideProgress", "stopPullToRefresh", "", "isVisible", "setMenuVisibility", "(Z)V", "showEmptyView", "hideEmptyView", "showMessage", "action", "Lkotlin/Function0;", "actionListener", "showMessageWithAction", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "dismissMessageWithAction", "", VKApiConst.POSITION, "notifyItemAtPositionChanged", "(I)V", "scrollToTop", "Lcom/avito/konveyor/ItemBinder;", "k", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/favorites/FavoritesView$Presenter;", "i", "Lcom/avito/android/favorites/FavoritesView$Presenter;", "presenter", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", AuthSource.BOOKING_ORDER, "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "refreshLayout", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "e", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/google/android/material/snackbar/Snackbar;", "f", "Lcom/google/android/material/snackbar/Snackbar;", "snackbarWithAction", "Landroid/view/View;", "d", "Landroid/view/View;", "emptyView", "Lcom/avito/android/util/MenuWrapper;", "h", "Lcom/avito/android/util/MenuWrapper;", "menuWrapper", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "j", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroid/view/ViewGroup;", g.a, "Landroid/view/ViewGroup;", "rootView", "Lcom/avito/android/analytics/Analytics;", "analytics", ConstantsKt.KEY_LIST_BOTTOM_PADDING, "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/util/MenuWrapper;Lcom/avito/android/favorites/FavoritesView$Presenter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/analytics/Analytics;Ljava/lang/Integer;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class FavoritesViewImpl implements FavoritesView {
    public final Context a;
    public final SwipeRefreshLayout b;
    public final RecyclerView c;
    public final View d;
    public final ProgressOverlay e;
    public Snackbar f;
    public final ViewGroup g;
    public final MenuWrapper h;
    public final FavoritesView.Presenter i;
    public final AdapterPresenter j;
    public final ItemBinder k;

    public static final class a implements SwipeRefreshLayout.OnRefreshListener {
        public final /* synthetic */ FavoritesViewImpl a;

        public a(FavoritesViewImpl favoritesViewImpl) {
            this.a = favoritesViewImpl;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            this.a.i.onPullRefresh();
        }
    }

    public static final class b extends Lambda implements Function1<MenuItem, Unit> {
        public final /* synthetic */ FavoritesViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(FavoritesViewImpl favoritesViewImpl) {
            super(1);
            this.a = favoritesViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MenuItem menuItem) {
            MenuItem menuItem2 = menuItem;
            Intrinsics.checkNotNullParameter(menuItem2, "item");
            int itemId = menuItem2.getItemId();
            if (itemId == R.id.menu_remove_all) {
                FavoritesViewImpl.access$showRemoveAllDialog(this.a);
            } else if (itemId == R.id.menu_remove_inactive) {
                this.a.i.onRemoveInactiveClicked();
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ FavoritesViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(FavoritesViewImpl favoritesViewImpl) {
            super(0);
            this.a = favoritesViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.i.onRetry();
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function2<Menu, MenuInflater, Unit> {
        public final /* synthetic */ boolean a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(boolean z) {
            super(2);
            this.a = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Menu menu, MenuInflater menuInflater) {
            Menu menu2 = menu;
            MenuInflater menuInflater2 = menuInflater;
            Intrinsics.checkNotNullParameter(menu2, "menu");
            Intrinsics.checkNotNullParameter(menuInflater2, "inflater");
            menu2.clear();
            if (this.a) {
                menuInflater2.inflate(R.menu.favorites_list, menu2);
            }
            return Unit.INSTANCE;
        }
    }

    public FavoritesViewImpl(@NotNull ViewGroup viewGroup, @NotNull MenuWrapper menuWrapper, @NotNull FavoritesView.Presenter presenter, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, @NotNull Analytics analytics, @Px @Nullable Integer num) {
        ProgressOverlay progressOverlay;
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(menuWrapper, "menuWrapper");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.g = viewGroup;
        this.h = menuWrapper;
        this.i = presenter;
        this.j = adapterPresenter;
        this.k = itemBinder;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this.a = context;
        View findViewById = viewGroup.findViewById(R.id.swipe_refresh_layout);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById;
        this.b = swipeRefreshLayout;
        View findViewById2 = viewGroup.findViewById(R.id.recycler_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.c = recyclerView;
        View findViewById3 = viewGroup.findViewById(16908292);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById3;
        ProgressOverlay progressOverlay2 = new ProgressOverlay(viewGroup, R.id.content, analytics, false, 0, 24, null);
        this.e = progressOverlay2;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setItemAnimator(null);
        if (num != null) {
            progressOverlay = progressOverlay2;
            Views.changePadding$default(recyclerView, 0, 0, 0, num.intValue(), 7, null);
            recyclerView.setClipToPadding(false);
        } else {
            progressOverlay = progressOverlay2;
        }
        Context context2 = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int[] pullRefreshColorScheme = ContextsKt.getPullRefreshColorScheme(context2);
        swipeRefreshLayout.setColorSchemeColors(Arrays.copyOf(pullRefreshColorScheme, pullRefreshColorScheme.length));
        Context context3 = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(context3, R.attr.white));
        swipeRefreshLayout.setOnRefreshListener(new a(this));
        menuWrapper.setOnItemClicked(new b(this));
        progressOverlay.setOnRefreshListener(new c(this));
    }

    public static final void access$showRemoveAllDialog(FavoritesViewImpl favoritesViewImpl) {
        new AlertDialog.Builder(favoritesViewImpl.a).setMessage(favoritesViewImpl.a.getString(R.string.config_remove_favorites)).setPositiveButton(favoritesViewImpl.a.getString(com.avito.android.ui_components.R.string.yes), new x0(favoritesViewImpl)).setNegativeButton(favoritesViewImpl.a.getString(com.avito.android.ui_components.R.string.cancel), y0.a).setCancelable(true).show();
    }

    @Override // com.avito.android.favorites.FavoritesView
    public void dismissMessageWithAction() {
        Snackbar snackbar = this.f;
        if (snackbar != null) {
            snackbar.dismiss();
        }
    }

    @Override // com.avito.android.favorites.FavoritesView
    public void hideEmptyView() {
        Views.hide(this.d);
    }

    @Override // com.avito.android.favorites.FavoritesView
    public void hideProgress() {
        this.e.showContent();
    }

    @Override // com.avito.android.advert.viewed.ViewedAdvertsView
    public void notifyItemAtPositionChanged(int i2) {
        RecyclerView.Adapter adapter = this.c.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i2);
        }
    }

    @Override // com.avito.android.favorites.FavoritesView
    public void onDataChanged() {
        if (this.c.getAdapter() == null) {
            this.c.setAdapter(new SimpleRecyclerAdapter(this.j, this.k));
            return;
        }
        RecyclerView.Adapter adapter = this.c.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.favorites.FavoritesView
    public void scrollToTop() {
        this.c.scrollToPosition(0);
    }

    @Override // com.avito.android.favorites.FavoritesView
    public void setMenuVisibility(boolean z) {
        this.h.changeMenu(new d(z));
    }

    @Override // com.avito.android.favorites.FavoritesView
    public void showEmptyView() {
        Views.show(this.d);
    }

    @Override // com.avito.android.favorites.FavoritesView
    public void showErrorOverlay(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.e.showLoadingProblem(str);
    }

    @Override // com.avito.android.favorites.FavoritesView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.g, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 124, (Object) null);
    }

    @Override // com.avito.android.favorites.FavoritesView
    public void showMessageWithAction(@NotNull String str, @NotNull String str2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, "action");
        Intrinsics.checkNotNullParameter(function0, "actionListener");
        Snackbar showSnackBar$default = Views.showSnackBar$default(this.g, str, 0, str2, 0, function0, (Function0) null, 0, 104, (Object) null);
        showSnackBar$default.addCallback(new Snackbar.Callback(this) { // from class: com.avito.android.favorites.FavoritesViewImpl$showMessageWithAction$$inlined$apply$lambda$1
            public final /* synthetic */ FavoritesViewImpl a;

            {
                this.a = r1;
            }

            @Override // com.google.android.material.snackbar.Snackbar.Callback
            public void onDismissed(@Nullable Snackbar snackbar, int i2) {
                if (this.a.f == snackbar) {
                    this.a.f = null;
                }
            }
        });
        this.f = showSnackBar$default;
    }

    @Override // com.avito.android.favorites.FavoritesView
    public void showProgress() {
        this.e.showLoading();
    }

    @Override // com.avito.android.favorites.FavoritesView
    public void stopPullToRefresh() {
        this.b.setRefreshing(false);
    }
}
