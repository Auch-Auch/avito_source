package com.avito.android.shop.awards;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.image_loader.Picture;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop.R;
import com.avito.android.util.ActionMenu;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.appbar.AppBar;
import ru.avito.component.appbar.AppBarImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u0010K\u001a\u00020J\u0012\u0006\u0010M\u001a\u00020L\u0012\u0006\u0010N\u001a\u00020\u000f¢\u0006\u0004\bO\u0010PJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\tJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u000e\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0001¢\u0006\u0004\b\u0016\u0010\u0015J.\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00132\b\b\u0001\u0010\u0018\u001a\u00020\u00132\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\u00052\b\b\u0001\u0010 \u001a\u00020\u0013H\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010$\u001a\u00020\u00052\b\b\u0001\u0010#\u001a\u00020\u0013H\u0001¢\u0006\u0004\b$\u0010\"J\u001a\u0010&\u001a\u00020\u00052\b\b\u0001\u0010%\u001a\u00020\u0013H\u0001¢\u0006\u0004\b&\u0010\"J&\u0010)\u001a\u00020\u00052\b\b\u0001\u0010'\u001a\u00020\u00132\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u0013H\u0001¢\u0006\u0004\b)\u0010*J\u0018\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u000fH\u0001¢\u0006\u0004\b,\u0010-J\u0018\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020.H\u0001¢\u0006\u0004\b0\u00101J\u001a\u00100\u001a\u00020\u00052\b\b\u0001\u00102\u001a\u00020\u0013H\u0001¢\u0006\u0004\b0\u0010\"J\u0018\u00103\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u000fH\u0001¢\u0006\u0004\b3\u0010-J\u001e\u00107\u001a\u00020\u00052\f\u00106\u001a\b\u0012\u0004\u0012\u00020504H\u0001¢\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u00020\u0005H\u0001¢\u0006\u0004\b9\u0010\tR\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006Q"}, d2 = {"Lcom/avito/android/shop/awards/AwardsViewImpl;", "Lcom/avito/android/shop/awards/AwardsView;", "Lru/avito/component/appbar/AppBar;", "", "error", "", "showError", "(Ljava/lang/String;)V", "showLoading", "()V", "hideLoading", "showContent", "showRetryOverlay", "showShopNotFoundError", "hideActionsMenu", "", "isVisible", "()Z", "Lio/reactivex/rxjava3/core/Observable;", "", "menuCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationCallbacks", "itemPosition", "icon", "tintColorAttr", "setActionMenuItemIcon", "(IILjava/lang/Integer;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setIcon", "(Lcom/avito/android/image_loader/Picture;)V", "menuId", "setMenu", "(I)V", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "drawableRes", "tintColorAttrId", "setNavigationIcon", "(ILjava/lang/Integer;)V", "visible", "setShadowVisible", "(Z)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "stringRes", "setVisible", "", "Lcom/avito/android/util/ActionMenu;", "actions", "showActionsMenu", "(Ljava/util/List;)V", "showToolbar", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "notFoundView", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/ViewGroup;", "view", "Lcom/avito/android/shop/awards/AwardsViewPresenter;", "presenter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/android/analytics/Analytics;", "analytics", "arrowBackNavigationIcon", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/shop/awards/AwardsViewPresenter;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Lcom/avito/android/analytics/Analytics;Z)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class AwardsViewImpl implements AwardsView, AppBar {
    public final RecyclerView a;
    public final TextView b;
    public final ProgressOverlay c;
    public final /* synthetic */ AppBarImpl d;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AwardsViewPresenter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AwardsViewPresenter awardsViewPresenter) {
            super(0);
            this.a = awardsViewPresenter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.onRefresh();
            return Unit.INSTANCE;
        }
    }

    public AwardsViewImpl(@NotNull ViewGroup viewGroup, @NotNull AwardsViewPresenter awardsViewPresenter, @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @NotNull Analytics analytics, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "view");
        Intrinsics.checkNotNullParameter(awardsViewPresenter, "presenter");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.d = new AppBarImpl(viewGroup, null, false, 4, null);
        View findViewById = viewGroup.findViewById(R.id.awards_recycler);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.a = recyclerView;
        View findViewById2 = viewGroup.findViewById(R.id.shop_not_found);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        ProgressOverlay progressOverlay = new ProgressOverlay(recyclerView, R.id.scroll_view, analytics, false, 0, 24, null);
        this.c = progressOverlay;
        progressOverlay.setOnRefreshListener(new a(awardsViewPresenter));
        if (z) {
            AppBar.DefaultImpls.setNavigationIcon$default(this, com.avito.android.ui_components.R.drawable.ic_back_24_black, null, 2, null);
        } else {
            AppBar.DefaultImpls.setNavigationIcon$default(this, com.avito.android.ui_components.R.drawable.ic_close_24_blue, null, 2, null);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(viewGroup.getContext()));
        recyclerView.setAdapter(simpleRecyclerAdapter);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void hideActionsMenu() {
        this.d.hideActionsMenu();
    }

    @Override // com.avito.android.shop.awards.AwardsView
    public void hideLoading() {
        this.c.showContent();
    }

    @Override // ru.avito.component.appbar.AppBar
    public boolean isVisible() {
        return this.d.isVisible();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public Observable<Integer> menuCallbacks() {
        return this.d.menuCallbacks();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public Observable<Unit> navigationCallbacks() {
        return this.d.navigationCallbacks();
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setActionMenuItemIcon(int i, @DrawableRes int i2, @AttrRes @Nullable Integer num) {
        this.d.setActionMenuItemIcon(i, i2, num);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setIcon(@Nullable Picture picture) {
        this.d.setIcon(picture);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenu(@MenuRes int i) {
        this.d.setMenu(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColor(@ColorRes int i) {
        this.d.setMenuTintColor(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColorAttr(@AttrRes int i) {
        this.d.setMenuTintColorAttr(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setNavigationIcon(@DrawableRes int i, @AttrRes @Nullable Integer num) {
        this.d.setNavigationIcon(i, num);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setShadowVisible(boolean z) {
        this.d.setShadowVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@StringRes int i) {
        this.d.setTitle(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.d.setTitle(charSequence);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setVisible(boolean z) {
        this.d.setVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showActionsMenu(@NotNull List<ActionMenu> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        this.d.showActionsMenu(list);
    }

    @Override // com.avito.android.shop.awards.AwardsView
    public void showContent() {
        RecyclerView.Adapter adapter = this.a.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.shop.awards.AwardsView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.showSnackBar$default(this.a, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.shop.awards.AwardsView
    public void showLoading() {
        this.c.showLoading();
    }

    @Override // com.avito.android.shop.awards.AwardsView
    public void showRetryOverlay() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.c, null, 1, null);
    }

    @Override // com.avito.android.shop.awards.AwardsView
    public void showShopNotFoundError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.hide(this.a);
        Views.show(this.b);
        this.b.setText(str);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showToolbar() {
        this.d.showToolbar();
    }
}
