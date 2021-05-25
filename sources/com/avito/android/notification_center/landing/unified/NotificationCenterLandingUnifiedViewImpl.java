package com.avito.android.notification_center.landing.unified;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.image_loader.Picture;
import com.avito.android.notification_center.R;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ActionMenu;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.appbar.AppBar;
import ru.avito.component.appbar.AppBarImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u0010V\u001a\u00020U\u0012\u0006\u0010X\u001a\u00020W¢\u0006\u0004\bY\u0010ZJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0015\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H\u0001¢\u0006\u0004\b\u001c\u0010\u001bJ.\u0010 \u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00112\b\b\u0001\u0010\u001e\u001a\u00020\u00112\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\"H\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010'\u001a\u00020\u00032\b\b\u0001\u0010&\u001a\u00020\u0011H\u0001¢\u0006\u0004\b'\u0010\u0014J\u001a\u0010)\u001a\u00020\u00032\b\b\u0001\u0010(\u001a\u00020\u0011H\u0001¢\u0006\u0004\b)\u0010\u0014J\u001a\u0010+\u001a\u00020\u00032\b\b\u0001\u0010*\u001a\u00020\u0011H\u0001¢\u0006\u0004\b+\u0010\u0014J&\u0010.\u001a\u00020\u00032\b\b\u0001\u0010,\u001a\u00020\u00112\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b.\u0010/J\u0018\u00101\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0016H\u0001¢\u0006\u0004\b1\u00102J\u0018\u00105\u001a\u00020\u00032\u0006\u00104\u001a\u000203H\u0001¢\u0006\u0004\b5\u00106J\u001a\u00105\u001a\u00020\u00032\b\b\u0001\u00107\u001a\u00020\u0011H\u0001¢\u0006\u0004\b5\u0010\u0014J\u0018\u00108\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0016H\u0001¢\u0006\u0004\b8\u00102J\u001e\u0010<\u001a\u00020\u00032\f\u0010;\u001a\b\u0012\u0004\u0012\u00020:09H\u0001¢\u0006\u0004\b<\u0010=J\u0010\u0010>\u001a\u00020\u0003H\u0001¢\u0006\u0004\b>\u0010\u0005R\u001e\u0010C\u001a\n @*\u0004\u0018\u00010?0?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010E¨\u0006["}, d2 = {"Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedViewImpl;", "Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedView;", "Lru/avito/component/appbar/AppBar;", "", "showProgress", "()V", "showContent", "", "error", "showLoadingError", "(Ljava/lang/String;)V", "notifyDataChanged", "Lio/reactivex/Observable;", "getBackButtonClicks", "()Lio/reactivex/Observable;", "getRetryButtonClicks", "showError", "", VKApiConst.POSITION, "notifyItemAtPositionChanged", "(I)V", "hideActionsMenu", "", "isVisible", "()Z", "Lio/reactivex/rxjava3/core/Observable;", "menuCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationCallbacks", "itemPosition", "icon", "tintColorAttr", "setActionMenuItemIcon", "(IILjava/lang/Integer;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setIcon", "(Lcom/avito/android/image_loader/Picture;)V", "menuId", "setMenu", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "drawableRes", "tintColorAttrId", "setNavigationIcon", "(ILjava/lang/Integer;)V", "visible", "setShadowVisible", "(Z)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "stringRes", "setVisible", "", "Lcom/avito/android/util/ActionMenu;", "actions", "showActionsMenu", "(Ljava/util/List;)V", "showToolbar", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "d", "Lio/reactivex/Observable;", "backRelay", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "e", "retryRelay", "Landroid/view/View;", "view", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/analytics/Analytics;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingUnifiedViewImpl implements NotificationCenterLandingUnifiedView, AppBar {
    public final SimpleRecyclerAdapter a;
    public final ProgressOverlay b;
    public final RecyclerView c;
    public final Observable<Unit> d = InteropKt.toV2(navigationCallbacks());
    public final Observable<Unit> e;
    public final /* synthetic */ AppBarImpl f;

    public NotificationCenterLandingUnifiedViewImpl(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        int i = R.id.recycler_view;
        View findViewById = view.findViewById(i);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.f = new AppBarImpl(view, findViewById, false, 4, null);
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter, itemBinder);
        this.a = simpleRecyclerAdapter;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
        this.c = recyclerView;
        simpleRecyclerAdapter.setHasStableIds(true);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.content_holder);
        Intrinsics.checkNotNullExpressionValue(viewGroup, "contentHolder");
        ProgressOverlay progressOverlay = new ProgressOverlay(viewGroup, i, analytics, false, 0, 24, null);
        this.b = progressOverlay;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setAdapter(simpleRecyclerAdapter);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        this.e = progressOverlay.refreshes();
    }

    @Override // com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedView
    @NotNull
    public Observable<Unit> getBackButtonClicks() {
        return this.d;
    }

    @Override // com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedView
    @NotNull
    public Observable<Unit> getRetryButtonClicks() {
        return this.e;
    }

    @Override // ru.avito.component.appbar.AppBar
    public void hideActionsMenu() {
        this.f.hideActionsMenu();
    }

    @Override // ru.avito.component.appbar.AppBar
    public boolean isVisible() {
        return this.f.isVisible();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public io.reactivex.rxjava3.core.Observable<Integer> menuCallbacks() {
        return this.f.menuCallbacks();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public io.reactivex.rxjava3.core.Observable<Unit> navigationCallbacks() {
        return this.f.navigationCallbacks();
    }

    @Override // com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedView
    public void notifyDataChanged() {
        this.a.notifyDataSetChanged();
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsView, com.avito.android.advert.viewed.ViewedAdvertsView
    public void notifyItemAtPositionChanged(int i) {
        this.a.notifyItemChanged(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setActionMenuItemIcon(int i, @DrawableRes int i2, @AttrRes @Nullable Integer num) {
        this.f.setActionMenuItemIcon(i, i2, num);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setIcon(@Nullable Picture picture) {
        this.f.setIcon(picture);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenu(@MenuRes int i) {
        this.f.setMenu(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColor(@ColorRes int i) {
        this.f.setMenuTintColor(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColorAttr(@AttrRes int i) {
        this.f.setMenuTintColorAttr(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setNavigationIcon(@DrawableRes int i, @AttrRes @Nullable Integer num) {
        this.f.setNavigationIcon(i, num);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setShadowVisible(boolean z) {
        this.f.setShadowVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@StringRes int i) {
        this.f.setTitle(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.f.setTitle(charSequence);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setVisible(boolean z) {
        this.f.setVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showActionsMenu(@NotNull List<ActionMenu> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        this.f.showActionsMenu(list);
    }

    @Override // com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedView
    public void showContent() {
        this.b.showContent();
    }

    @Override // com.avito.android.legacy_mvp.ErrorMessageView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        RecyclerView recyclerView = this.c;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "recyclerView.context");
        ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
    }

    @Override // com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedView
    public void showLoadingError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.b.showLoadingProblem(str);
    }

    @Override // com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedView
    public void showProgress() {
        this.b.showLoading();
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showToolbar() {
        this.f.showToolbar();
    }

    @Override // com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedView
    public void showLoadingError() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.b, null, 1, null);
    }
}
