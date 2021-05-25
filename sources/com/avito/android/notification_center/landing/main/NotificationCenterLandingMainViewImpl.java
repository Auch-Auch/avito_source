package com.avito.android.notification_center.landing.main;

import a2.g.r.g;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import com.avito.android.analytics.Analytics;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.image_loader.Picture;
import com.avito.android.notification_center.R;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.util.ActionMenu;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
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
import ru.avito.component.button.ButtonImpl;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010d\u001a\u00020D\u0012\u0006\u0010f\u001a\u00020e¢\u0006\u0004\bg\u0010hJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u0019\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\nJ\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\nJ\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0017J\u0010\u0010\u001a\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u0010\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0001¢\u0006\u0004\b \u0010!J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0001¢\u0006\u0004\b\"\u0010!J.\u0010&\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u001f2\b\b\u0001\u0010$\u001a\u00020\u001f2\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010(H\u0001¢\u0006\u0004\b*\u0010+J\u001a\u0010-\u001a\u00020\u00032\b\b\u0001\u0010,\u001a\u00020\u001fH\u0001¢\u0006\u0004\b-\u0010.J\u001a\u00100\u001a\u00020\u00032\b\b\u0001\u0010/\u001a\u00020\u001fH\u0001¢\u0006\u0004\b0\u0010.J\u001a\u00102\u001a\u00020\u00032\b\b\u0001\u00101\u001a\u00020\u001fH\u0001¢\u0006\u0004\b2\u0010.J&\u00105\u001a\u00020\u00032\b\b\u0001\u00103\u001a\u00020\u001f2\n\b\u0003\u00104\u001a\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0004\b5\u00106J\u0018\u00108\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u001bH\u0001¢\u0006\u0004\b8\u00109J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020:H\u0001¢\u0006\u0004\b\u0010\u0010;J\u001a\u0010\u0010\u001a\u00020\u00032\b\b\u0001\u0010<\u001a\u00020\u001fH\u0001¢\u0006\u0004\b\u0010\u0010.J\u0018\u0010=\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u001bH\u0001¢\u0006\u0004\b=\u00109J\u001e\u0010A\u001a\u00020\u00032\f\u0010@\u001a\b\u0012\u0004\u0012\u00020?0>H\u0001¢\u0006\u0004\bA\u0010BJ\u0010\u0010C\u001a\u00020\u0003H\u0001¢\u0006\u0004\bC\u0010\u0005R\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR:\u0010S\u001a&\u0012\f\u0012\n P*\u0004\u0018\u00010\u00030\u0003 P*\u0012\u0012\f\u0012\n P*\u0004\u0018\u00010\u00030\u0003\u0018\u00010O0O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010MR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010\\¨\u0006i"}, d2 = {"Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainViewImpl;", "Lcom/avito/android/notification_center/landing/main/NotificationCenterLandingMainView;", "Lru/avito/component/appbar/AppBar;", "", "showProgress", "()V", "showContent", "", "error", "showError", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "title", "setTitle", "description", "setDescription", "text", "setActionButtonText", "Lio/reactivex/Observable;", "getActionButtonClicks", "()Lio/reactivex/Observable;", "getBackButtonClicks", "getRetryButtonClicks", "hideActionsMenu", "", "isVisible", "()Z", "Lio/reactivex/rxjava3/core/Observable;", "", "menuCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationCallbacks", "itemPosition", "icon", "tintColorAttr", "setActionMenuItemIcon", "(IILjava/lang/Integer;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setIcon", "(Lcom/avito/android/image_loader/Picture;)V", "menuId", "setMenu", "(I)V", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "drawableRes", "tintColorAttrId", "setNavigationIcon", "(ILjava/lang/Integer;)V", "visible", "setShadowVisible", "(Z)V", "", "(Ljava/lang/CharSequence;)V", "stringRes", "setVisible", "", "Lcom/avito/android/util/ActionMenu;", "actions", "showActionsMenu", "(Ljava/util/List;)V", "showToolbar", "Landroid/view/View;", "e", "Landroid/view/View;", "imageHolder", "Lru/avito/component/button/ButtonImpl;", "i", "Lru/avito/component/button/ButtonImpl;", "actionView", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "backRelay", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "actionRelay", "c", "retryRelay", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "d", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lru/avito/component/text/TextImpl;", g.a, "Lru/avito/component/text/TextImpl;", "titleView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "f", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "h", "descriptionView", "view", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/analytics/Analytics;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingMainViewImpl implements NotificationCenterLandingMainView, AppBar {
    public final PublishRelay<Unit> a = PublishRelay.create();
    public final Observable<Unit> b;
    public final Observable<Unit> c;
    public final ProgressOverlay d;
    public final View e;
    public final SimpleDraweeView f;
    public final TextImpl g;
    public final TextImpl h;
    public final ButtonImpl i;
    public final /* synthetic */ AppBarImpl j;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ NotificationCenterLandingMainViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(NotificationCenterLandingMainViewImpl notificationCenterLandingMainViewImpl) {
            super(0);
            this.a = notificationCenterLandingMainViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            PublishRelay publishRelay = this.a.a;
            Unit unit = Unit.INSTANCE;
            publishRelay.accept(unit);
            return unit;
        }
    }

    public NotificationCenterLandingMainViewImpl(@NotNull View view, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        int i2 = R.id.content;
        View findViewById = view.findViewById(i2);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.j = new AppBarImpl(view, findViewById, false, 4, null);
        View findViewById2 = view.findViewById(R.id.content_holder);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById2, i2, analytics, false, 0, 24, null);
        this.d = progressOverlay;
        View findViewById3 = view.findViewById(R.id.image_holder);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.e = findViewById3;
        View findViewById4 = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.f = (SimpleDraweeView) findViewById4;
        View findViewById5 = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.title)");
        this.g = new TextImpl(findViewById5);
        View findViewById6 = view.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.description)");
        this.h = new TextImpl(findViewById6);
        View findViewById7 = view.findViewById(R.id.action);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.action)");
        ButtonImpl buttonImpl = new ButtonImpl(findViewById7);
        this.i = buttonImpl;
        this.c = progressOverlay.refreshes();
        AppBar.DefaultImpls.setNavigationIcon$default(this, com.avito.android.ui_components.R.drawable.ic_back_24_blue, null, 2, null);
        this.b = InteropKt.toV2(navigationCallbacks());
        buttonImpl.setClickListener(new a(this));
    }

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainView
    @NotNull
    public Observable<Unit> getActionButtonClicks() {
        PublishRelay<Unit> publishRelay = this.a;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "actionRelay");
        return publishRelay;
    }

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainView
    @NotNull
    public Observable<Unit> getBackButtonClicks() {
        return this.b;
    }

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainView
    @NotNull
    public Observable<Unit> getRetryButtonClicks() {
        return this.c;
    }

    @Override // ru.avito.component.appbar.AppBar
    public void hideActionsMenu() {
        this.j.hideActionsMenu();
    }

    @Override // ru.avito.component.appbar.AppBar
    public boolean isVisible() {
        return this.j.isVisible();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public io.reactivex.rxjava3.core.Observable<Integer> menuCallbacks() {
        return this.j.menuCallbacks();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public io.reactivex.rxjava3.core.Observable<Unit> navigationCallbacks() {
        return this.j.navigationCallbacks();
    }

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainView
    public void setActionButtonText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.i.setText(str);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setActionMenuItemIcon(int i2, @DrawableRes int i3, @AttrRes @Nullable Integer num) {
        this.j.setActionMenuItemIcon(i2, i3, num);
    }

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainView
    public void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        this.h.setText(str);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setIcon(@Nullable Picture picture) {
        this.j.setIcon(picture);
    }

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainView
    public void setImage(@Nullable Image image) {
        if (image != null) {
            Views.show(this.e);
            Uri width = Images.fit$default(image, this.f, 0.0f, 0.0f, 2, 6, null).width();
            ImageRequest.Builder requestBuilder = SimpleDraweeViewsKt.getRequestBuilder(this.f);
            if (width == null) {
                width = Uri.EMPTY;
            }
            Intrinsics.checkNotNullExpressionValue(width, "uri ?: Uri.EMPTY");
            requestBuilder.uri(width).autoPlayAnimations(true).load();
            return;
        }
        Views.hide(this.e);
        SimpleDraweeViewsKt.getRequestBuilder(this.f).clear();
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenu(@MenuRes int i2) {
        this.j.setMenu(i2);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColor(@ColorRes int i2) {
        this.j.setMenuTintColor(i2);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColorAttr(@AttrRes int i2) {
        this.j.setMenuTintColorAttr(i2);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setNavigationIcon(@DrawableRes int i2, @AttrRes @Nullable Integer num) {
        this.j.setNavigationIcon(i2, num);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setShadowVisible(boolean z) {
        this.j.setShadowVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@StringRes int i2) {
        this.j.setTitle(i2);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.j.setTitle(charSequence);
    }

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.g.setText(str);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setVisible(boolean z) {
        this.j.setVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showActionsMenu(@NotNull List<ActionMenu> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        this.j.showActionsMenu(list);
    }

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainView
    public void showContent() {
        this.d.showContent();
    }

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.d.showLoadingProblem(str);
    }

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainView
    public void showProgress() {
        this.d.showLoading();
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showToolbar() {
        this.j.showToolbar();
    }

    @Override // com.avito.android.notification_center.landing.main.NotificationCenterLandingMainView
    public void showError() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.d, null, 1, null);
    }
}
