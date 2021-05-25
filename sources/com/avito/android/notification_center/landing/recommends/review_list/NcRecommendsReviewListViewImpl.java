package com.avito.android.notification_center.landing.recommends.review_list;

import a2.g.r.g;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ActionMenu;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxrelay2.PublishRelay;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010X\u001a\u00020U\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u0010_\u001a\u00020^\u0012\u0006\u0010a\u001a\u00020`\u0012\u0006\u0010c\u001a\u00020b¢\u0006\u0004\bd\u0010eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0015\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H\u0001¢\u0006\u0004\b\u001d\u0010\u001cJ.\u0010!\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001a2\b\b\u0001\u0010\u001f\u001a\u00020\u001a2\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u001aH\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010#H\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010(\u001a\u00020\u00032\b\b\u0001\u0010'\u001a\u00020\u001aH\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010+\u001a\u00020\u00032\b\b\u0001\u0010*\u001a\u00020\u001aH\u0001¢\u0006\u0004\b+\u0010)J\u001a\u0010-\u001a\u00020\u00032\b\b\u0001\u0010,\u001a\u00020\u001aH\u0001¢\u0006\u0004\b-\u0010)J&\u00100\u001a\u00020\u00032\b\b\u0001\u0010.\u001a\u00020\u001a2\n\b\u0003\u0010/\u001a\u0004\u0018\u00010\u001aH\u0001¢\u0006\u0004\b0\u00101J\u0018\u00103\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0016H\u0001¢\u0006\u0004\b3\u00104J\u0018\u00107\u001a\u00020\u00032\u0006\u00106\u001a\u000205H\u0001¢\u0006\u0004\b7\u00108J\u001a\u00107\u001a\u00020\u00032\b\b\u0001\u00109\u001a\u00020\u001aH\u0001¢\u0006\u0004\b7\u0010)J\u0018\u0010:\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0016H\u0001¢\u0006\u0004\b:\u00104J\u001e\u0010>\u001a\u00020\u00032\f\u0010=\u001a\b\u0012\u0004\u0012\u00020<0;H\u0001¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020\u0003H\u0001¢\u0006\u0004\b@\u0010\u0005R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR:\u0010]\u001a&\u0012\f\u0012\n Z*\u0004\u0018\u00010\u00030\u0003 Z*\u0012\u0012\f\u0012\n Z*\u0004\u0018\u00010\u00030\u0003\u0018\u00010Y0Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\¨\u0006f"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListViewImpl;", "Lcom/avito/android/notification_center/landing/recommends/review_list/NcRecommendsReviewListView;", "Lru/avito/component/appbar/AppBar;", "", "showProgress", "()V", "showContent", "", "error", "showError", "(Ljava/lang/String;)V", "notifyDataChanged", "showProgressDialog", "hideProgressDialog", "message", "showMessage", "Lio/reactivex/Observable;", "getCancelDialogCallback", "()Lio/reactivex/Observable;", "getBackButtonClicks", "getRetryButtonClicks", "hideActionsMenu", "", "isVisible", "()Z", "Lio/reactivex/rxjava3/core/Observable;", "", "menuCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationCallbacks", "itemPosition", "icon", "tintColorAttr", "setActionMenuItemIcon", "(IILjava/lang/Integer;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setIcon", "(Lcom/avito/android/image_loader/Picture;)V", "menuId", "setMenu", "(I)V", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "drawableRes", "tintColorAttrId", "setNavigationIcon", "(ILjava/lang/Integer;)V", "visible", "setShadowVisible", "(Z)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "stringRes", "setVisible", "", "Lcom/avito/android/util/ActionMenu;", "actions", "showActionsMenu", "(Ljava/util/List;)V", "showToolbar", "Lcom/avito/android/util/DialogRouter;", g.a, "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/app/Dialog;", "e", "Landroid/app/Dialog;", "dialog", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroid/view/View;", "f", "Landroid/view/View;", "view", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "dialogRelay", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/util/DialogRouter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/analytics/Analytics;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NcRecommendsReviewListViewImpl implements NcRecommendsReviewListView, AppBar {
    public final SimpleRecyclerAdapter a;
    public final PublishRelay<Unit> b = PublishRelay.create();
    public final ProgressOverlay c;
    public final RecyclerView d;
    public Dialog e;
    public final View f;
    public final DialogRouter g;
    public final /* synthetic */ AppBarImpl h;

    public static final class a implements DialogInterface.OnCancelListener {
        public final /* synthetic */ NcRecommendsReviewListViewImpl a;
        public final /* synthetic */ Dialog b;

        public a(NcRecommendsReviewListViewImpl ncRecommendsReviewListViewImpl, Dialog dialog) {
            this.a = ncRecommendsReviewListViewImpl;
            this.b = dialog;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            this.b.setOnCancelListener(null);
            this.a.b.accept(Unit.INSTANCE);
            this.a.e = null;
        }
    }

    public NcRecommendsReviewListViewImpl(@NotNull View view, @NotNull DialogRouter dialogRouter, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        int i = R.id.content;
        View findViewById = view.findViewById(i);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.h = new AppBarImpl(view, findViewById, false, 4, null);
        this.f = view;
        this.g = dialogRouter;
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter, itemBinder);
        this.a = simpleRecyclerAdapter;
        View findViewById2 = view.findViewById(R.id.container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        this.c = new ProgressOverlay((ViewGroup) findViewById2, i, analytics, false, 0, 24, null);
        View findViewById3 = view.findViewById(i);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.d = recyclerView;
        recyclerView.setAdapter(simpleRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        AppBar.DefaultImpls.setNavigationIcon$default(this, com.avito.android.ui_components.R.drawable.ic_back_24_blue, null, 2, null);
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListView
    @NotNull
    public Observable<Unit> getBackButtonClicks() {
        return InteropKt.toV2(navigationCallbacks());
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListView
    @NotNull
    public Observable<Unit> getCancelDialogCallback() {
        PublishRelay<Unit> publishRelay = this.b;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "dialogRelay");
        return publishRelay;
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListView
    @NotNull
    public Observable<Unit> getRetryButtonClicks() {
        return this.c.refreshes();
    }

    @Override // ru.avito.component.appbar.AppBar
    public void hideActionsMenu() {
        this.h.hideActionsMenu();
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListView
    public void hideProgressDialog() {
        Dialog dialog = this.e;
        if (dialog != null) {
            dialog.setOnCancelListener(null);
            dialog.dismiss();
            this.e = null;
        }
    }

    @Override // ru.avito.component.appbar.AppBar
    public boolean isVisible() {
        return this.h.isVisible();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public io.reactivex.rxjava3.core.Observable<Integer> menuCallbacks() {
        return this.h.menuCallbacks();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public io.reactivex.rxjava3.core.Observable<Unit> navigationCallbacks() {
        return this.h.navigationCallbacks();
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListView
    public void notifyDataChanged() {
        this.a.notifyDataSetChanged();
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setActionMenuItemIcon(int i, @DrawableRes int i2, @AttrRes @Nullable Integer num) {
        this.h.setActionMenuItemIcon(i, i2, num);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setIcon(@Nullable Picture picture) {
        this.h.setIcon(picture);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenu(@MenuRes int i) {
        this.h.setMenu(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColor(@ColorRes int i) {
        this.h.setMenuTintColor(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColorAttr(@AttrRes int i) {
        this.h.setMenuTintColorAttr(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setNavigationIcon(@DrawableRes int i, @AttrRes @Nullable Integer num) {
        this.h.setNavigationIcon(i, num);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setShadowVisible(boolean z) {
        this.h.setShadowVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@StringRes int i) {
        this.h.setTitle(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.h.setTitle(charSequence);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setVisible(boolean z) {
        this.h.setVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showActionsMenu(@NotNull List<ActionMenu> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        this.h.showActionsMenu(list);
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListView
    public void showContent() {
        this.c.showContent();
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.c.showLoadingProblem(str);
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Context context = this.f.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListView
    public void showProgress() {
        this.c.showLoading();
    }

    @Override // com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListView
    public void showProgressDialog() {
        if (this.e == null) {
            Dialog showSimpleWaitingDialog = this.g.showSimpleWaitingDialog();
            showSimpleWaitingDialog.setOnCancelListener(new a(this, showSimpleWaitingDialog));
            this.e = showSimpleWaitingDialog;
        }
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showToolbar() {
        this.h.showToolbar();
    }
}
