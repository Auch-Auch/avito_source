package com.avito.android.notification_center.landing.feedback;

import a2.g.r.g;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import com.avito.android.analytics.Analytics;
import com.avito.android.image_loader.Picture;
import com.avito.android.notification_center.R;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.util.ActionMenu;
import com.avito.android.util.ButtonsKt;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.rx3.InteropKt;
import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.appbar.AppBar;
import ru.avito.component.appbar.AppBarImpl;
import ru.avito.component.button.ButtonImpl;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010U\u001a\u00020R\u0012\u0006\u0010Y\u001a\u00020V\u0012\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00030Z\u0012\u0006\u0010o\u001a\u00020n¢\u0006\u0004\bp\u0010qJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\fJ\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\fJ\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\fJ\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001aJ\u0017\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010\fJ\u0010\u0010 \u001a\u00020\u0003H\u0001¢\u0006\u0004\b \u0010\u0005J\u0010\u0010\"\u001a\u00020!H\u0001¢\u0006\u0004\b\"\u0010#J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$H\u0001¢\u0006\u0004\b&\u0010'J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030$H\u0001¢\u0006\u0004\b(\u0010'J.\u0010,\u001a\u00020\u00032\u0006\u0010)\u001a\u00020%2\b\b\u0001\u0010*\u001a\u00020%2\n\b\u0001\u0010+\u001a\u0004\u0018\u00010%H\u0001¢\u0006\u0004\b,\u0010-J\u001a\u00100\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010.H\u0001¢\u0006\u0004\b0\u00101J\u001a\u00103\u001a\u00020\u00032\b\b\u0001\u00102\u001a\u00020%H\u0001¢\u0006\u0004\b3\u00104J\u001a\u00106\u001a\u00020\u00032\b\b\u0001\u00105\u001a\u00020%H\u0001¢\u0006\u0004\b6\u00104J\u001a\u00108\u001a\u00020\u00032\b\b\u0001\u00107\u001a\u00020%H\u0001¢\u0006\u0004\b8\u00104J&\u0010;\u001a\u00020\u00032\b\b\u0001\u00109\u001a\u00020%2\n\b\u0003\u0010:\u001a\u0004\u0018\u00010%H\u0001¢\u0006\u0004\b;\u0010<J\u0018\u0010>\u001a\u00020\u00032\u0006\u0010=\u001a\u00020!H\u0001¢\u0006\u0004\b>\u0010?J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020@H\u0001¢\u0006\u0004\b\u0012\u0010AJ\u001a\u0010\u0012\u001a\u00020\u00032\b\b\u0001\u0010B\u001a\u00020%H\u0001¢\u0006\u0004\b\u0012\u00104J\u0018\u0010C\u001a\u00020\u00032\u0006\u0010=\u001a\u00020!H\u0001¢\u0006\u0004\bC\u0010?J\u001e\u0010G\u001a\u00020\u00032\f\u0010F\u001a\b\u0012\u0004\u0012\u00020E0DH\u0001¢\u0006\u0004\bG\u0010HJ\u0010\u0010I\u001a\u00020\u0003H\u0001¢\u0006\u0004\bI\u0010\u0005R\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00030Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010LR\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010e\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010PR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bk\u0010l¨\u0006r"}, d2 = {"Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackViewImpl;", "Lcom/avito/android/notification_center/landing/feedback/NotificationCenterLandingFeedbackView;", "Lru/avito/component/appbar/AppBar;", "", "showProgress", "()V", "showContent", "showProgressDialog", "hideProgressDialog", "", "error", "showError", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "title", "setTitle", "description", "setDescription", "text", "setPositiveActionButtonText", "setNegativeActionButtonText", "Lio/reactivex/Observable;", "getPositiveActionButtonClicks", "()Lio/reactivex/Observable;", "getNegativeActionButtonClicks", "getBackButtonClicks", "getRetryButtonClicks", "message", "showResultMessage", "hideActionsMenu", "", "isVisible", "()Z", "Lio/reactivex/rxjava3/core/Observable;", "", "menuCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationCallbacks", "itemPosition", "icon", "tintColorAttr", "setActionMenuItemIcon", "(IILjava/lang/Integer;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setIcon", "(Lcom/avito/android/image_loader/Picture;)V", "menuId", "setMenu", "(I)V", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "drawableRes", "tintColorAttrId", "setNavigationIcon", "(ILjava/lang/Integer;)V", "visible", "setShadowVisible", "(Z)V", "", "(Ljava/lang/CharSequence;)V", "stringRes", "setVisible", "", "Lcom/avito/android/util/ActionMenu;", "actions", "showActionsMenu", "(Ljava/util/List;)V", "showToolbar", "Lru/avito/component/text/TextImpl;", "c", "Lru/avito/component/text/TextImpl;", "descriptionView", "Lru/avito/component/button/ButtonImpl;", "e", "Lru/avito/component/button/ButtonImpl;", "negativeActionView", "Landroid/view/View;", "h", "Landroid/view/View;", "view", "Lcom/avito/android/util/DialogRouter;", "i", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lio/reactivex/functions/Consumer;", "j", "Lio/reactivex/functions/Consumer;", "onCancel", AuthSource.BOOKING_ORDER, "titleView", "Lcom/facebook/drawee/view/SimpleDraweeView;", AuthSource.SEND_ABUSE, "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "d", "positiveActionView", "Lcom/avito/android/progress_overlay/ProgressOverlay;", g.a, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/app/Dialog;", "f", "Landroid/app/Dialog;", "dialog", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/util/DialogRouter;Lio/reactivex/functions/Consumer;Lcom/avito/android/analytics/Analytics;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingFeedbackViewImpl implements NotificationCenterLandingFeedbackView, AppBar {
    public final SimpleDraweeView a;
    public final TextImpl b;
    public final TextImpl c;
    public final ButtonImpl d;
    public final ButtonImpl e;
    public Dialog f;
    public final ProgressOverlay g;
    public final View h;
    public final DialogRouter i;
    public final Consumer<Unit> j;
    public final /* synthetic */ AppBarImpl k;

    public static final class a implements DialogInterface.OnCancelListener {
        public final /* synthetic */ NotificationCenterLandingFeedbackViewImpl a;
        public final /* synthetic */ Dialog b;

        public a(NotificationCenterLandingFeedbackViewImpl notificationCenterLandingFeedbackViewImpl, Dialog dialog) {
            this.a = notificationCenterLandingFeedbackViewImpl;
            this.b = dialog;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            this.a.f = null;
            this.b.setOnCancelListener(null);
            this.a.j.accept(Unit.INSTANCE);
        }
    }

    public NotificationCenterLandingFeedbackViewImpl(@NotNull View view, @NotNull DialogRouter dialogRouter, @NotNull Consumer<Unit> consumer, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        Intrinsics.checkNotNullParameter(consumer, "onCancel");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        int i2 = R.id.content;
        View findViewById = view.findViewById(i2);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.k = new AppBarImpl(view, findViewById, false, 4, null);
        this.h = view;
        this.i = dialogRouter;
        this.j = consumer;
        View findViewById2 = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.a = (SimpleDraweeView) findViewById2;
        View findViewById3 = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.title)");
        this.b = new TextImpl(findViewById3);
        View findViewById4 = view.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.description)");
        this.c = new TextImpl(findViewById4);
        View findViewById5 = view.findViewById(R.id.positive_action);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.positive_action)");
        this.d = new ButtonImpl(findViewById5);
        View findViewById6 = view.findViewById(R.id.negative_action);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.negative_action)");
        this.e = new ButtonImpl(findViewById6);
        View findViewById7 = view.findViewById(R.id.content_holder);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.ViewGroup");
        this.g = new ProgressOverlay((ViewGroup) findViewById7, i2, analytics, false, 0, 24, null);
        AppBar.DefaultImpls.setNavigationIcon$default(this, com.avito.android.ui_components.R.drawable.ic_close_24_blue, null, 2, null);
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackView
    @NotNull
    public Observable<Unit> getBackButtonClicks() {
        return InteropKt.toV2(navigationCallbacks());
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackView
    @NotNull
    public Observable<Unit> getNegativeActionButtonClicks() {
        return InteropKt.toV2(ButtonsKt.clicks(this.e));
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackView
    @NotNull
    public Observable<Unit> getPositiveActionButtonClicks() {
        return InteropKt.toV2(ButtonsKt.clicks(this.d));
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackView
    @NotNull
    public Observable<Unit> getRetryButtonClicks() {
        return this.g.refreshes();
    }

    @Override // ru.avito.component.appbar.AppBar
    public void hideActionsMenu() {
        this.k.hideActionsMenu();
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackView
    public void hideProgressDialog() {
        Dialog dialog = this.f;
        if (dialog != null) {
            dialog.setOnCancelListener(null);
        }
        Dialog dialog2 = this.f;
        if (dialog2 != null) {
            dialog2.dismiss();
        }
        this.f = null;
    }

    @Override // ru.avito.component.appbar.AppBar
    public boolean isVisible() {
        return this.k.isVisible();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public io.reactivex.rxjava3.core.Observable<Integer> menuCallbacks() {
        return this.k.menuCallbacks();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public io.reactivex.rxjava3.core.Observable<Unit> navigationCallbacks() {
        return this.k.navigationCallbacks();
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setActionMenuItemIcon(int i2, @DrawableRes int i3, @AttrRes @Nullable Integer num) {
        this.k.setActionMenuItemIcon(i2, i3, num);
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackView
    public void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        this.c.setText(str);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setIcon(@Nullable Picture picture) {
        this.k.setIcon(picture);
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackView
    public void setImage(@NotNull Image image) {
        Intrinsics.checkNotNullParameter(image, "image");
        Uri width = Images.fit$default(image, this.a, 0.0f, 0.0f, 2, 6, null).width();
        if (width != null) {
            SimpleDraweeViewsKt.getRequestBuilder(this.a).uri(width).load();
        }
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenu(@MenuRes int i2) {
        this.k.setMenu(i2);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColor(@ColorRes int i2) {
        this.k.setMenuTintColor(i2);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColorAttr(@AttrRes int i2) {
        this.k.setMenuTintColorAttr(i2);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setNavigationIcon(@DrawableRes int i2, @AttrRes @Nullable Integer num) {
        this.k.setNavigationIcon(i2, num);
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackView
    public void setNegativeActionButtonText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.e.setText(str);
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackView
    public void setPositiveActionButtonText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.d.setText(str);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setShadowVisible(boolean z) {
        this.k.setShadowVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@StringRes int i2) {
        this.k.setTitle(i2);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.k.setTitle(charSequence);
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.b.setText(str);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setVisible(boolean z) {
        this.k.setVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showActionsMenu(@NotNull List<ActionMenu> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        this.k.showActionsMenu(list);
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackView
    public void showContent() {
        this.g.showContent();
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.g.showLoadingProblem(str);
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackView
    public void showProgress() {
        this.g.showLoading();
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackView
    public void showProgressDialog() {
        if (this.f == null) {
            Dialog showSimpleWaitingDialog = this.i.showSimpleWaitingDialog();
            showSimpleWaitingDialog.setOnCancelListener(new a(this, showSimpleWaitingDialog));
            this.f = showSimpleWaitingDialog;
        }
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackView
    public void showResultMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Context context = this.h.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showToolbar() {
        this.k.showToolbar();
    }

    @Override // com.avito.android.notification_center.landing.feedback.NotificationCenterLandingFeedbackView
    public void showError() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.g, null, 1, null);
    }
}
