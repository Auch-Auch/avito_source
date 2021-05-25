package com.avito.android.public_profile.ui;

import android.view.View;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.public_profile_stuff.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.subscriptions_settings.SubscriptionSettingsView;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010A\u001a\u00020@\u0012\b\b\u0002\u0010;\u001a\u00020\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0010\u0010\u000fJ\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0014\u0010\u000fJ\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0001¢\u0006\u0004\b\u0015\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0016\u0010\rJ\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0018\u0010\u0007J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0019\u0010\u0007J \u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u001e\u0010\u0007J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u001fH\u0001¢\u0006\u0004\b \u0010!J&\u0010&\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050$H\u0001¢\u0006\u0004\b&\u0010'JZ\u00102\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010\b2\u0006\u0010+\u001a\u00020(2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010$2\u0006\u0010-\u001a\u00020(2\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200H\u0001¢\u0006\u0004\b2\u00103J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0001¢\u0006\u0004\b4\u0010\u0013R\"\u00108\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u0013R\u0016\u0010;\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006D"}, d2 = {"Lcom/avito/android/public_profile/ui/SubscribeButtonsViewImpl;", "Lcom/avito/android/public_profile/ui/SubscribeButtonsView;", "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;", "", "isLoading", "", "setSubscribeLoading", "(Z)V", "", "text", "showSubscribeButton", "(Ljava/lang/String;)V", "hideSubscribeButton", "()V", "canShowSnackbar", "()Z", "closeSubscriptionSettings", "Lio/reactivex/rxjava3/core/Observable;", "dismissEvents", "()Lio/reactivex/rxjava3/core/Observable;", "isMenuShowing", "notificationClicks", "openSubscriptionSettings", "isActivated", "setNotificationActivated", "setNotificationLoading", "isSubscribed", "isEnabled", "setSubscribed", "(ZZ)V", "setUnsubscribeLoading", "Lio/reactivex/rxjava3/core/Maybe;", "showEnableNotificationDialog", "()Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;", "errorDialog", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showErrorDialog", "(Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;Lkotlin/jvm/functions/Function0;)V", "", "textResId", "actionText", "actionTextResId", "onActionClick", "duration", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", VKApiConst.POSITION, "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "type", "showSnackbar", "(Ljava/lang/String;ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILcom/avito/android/lib/design/snackbar/SnackbarPosition;Lcom/avito/android/lib/design/snackbar/SnackbarType;)V", "unsubscribeClicks", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/core/Observable;", "getSubscribeButtonClicks", "subscribeButtonClicks", "c", "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;", "subscriptionSettingsView", "Lcom/avito/android/lib/design/button/Button;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/button/Button;", "subscribeButton", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class SubscribeButtonsViewImpl implements SubscribeButtonsView, SubscriptionSettingsView {
    public final Button a;
    @NotNull
    public final Observable<Unit> b;
    public final SubscriptionSettingsView c;

    public SubscribeButtonsViewImpl(@NotNull View view, @NotNull SubscriptionSettingsView subscriptionSettingsView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(subscriptionSettingsView, "subscriptionSettingsView");
        this.c = subscriptionSettingsView;
        View findViewById = view.findViewById(R.id.subscribe_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById;
        this.a = button;
        this.b = RxView.clicks(button);
    }

    @Override // com.avito.android.lib.design.snackbar.util.OptionalSnackbarElementView
    public boolean canShowSnackbar() {
        return this.c.canShowSnackbar();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public boolean closeSubscriptionSettings() {
        return this.c.closeSubscriptionSettings();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> dismissEvents() {
        return this.c.dismissEvents();
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    @NotNull
    public Observable<Unit> getSubscribeButtonClicks() {
        return this.b;
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    public void hideSubscribeButton() {
        Views.conceal(this.a);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public boolean isMenuShowing() {
        return this.c.isMenuShowing();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> notificationClicks() {
        return this.c.notificationClicks();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void openSubscriptionSettings() {
        this.c.openSubscriptionSettings();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setNotificationActivated(boolean z) {
        this.c.setNotificationActivated(z);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setNotificationLoading(boolean z) {
        this.c.setNotificationLoading(z);
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    public void setSubscribeLoading(boolean z) {
        this.c.setUnsubscribeLoading(z);
        if (!this.c.isMenuShowing()) {
            this.a.setEnabled(!z);
            this.a.setLoading(z);
        }
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setSubscribed(boolean z, boolean z2) {
        this.c.setSubscribed(z, z2);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setUnsubscribeLoading(boolean z) {
        this.c.setUnsubscribeLoading(z);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Maybe<Unit> showEnableNotificationDialog() {
        return this.c.showEnableNotificationDialog();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void showErrorDialog(@NotNull ErrorResult.ErrorDialog errorDialog, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(errorDialog, "errorDialog");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.c.showErrorDialog(errorDialog, function0);
    }

    @Override // com.avito.android.lib.design.snackbar.util.SnackbarElementView
    public void showSnackbar(@NotNull String str, int i, @Nullable String str2, int i2, @Nullable Function0<Unit> function0, int i3, @NotNull SnackbarPosition snackbarPosition, @NotNull SnackbarType snackbarType) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(snackbarPosition, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(snackbarType, "type");
        this.c.showSnackbar(str, i, str2, i2, function0, i3, snackbarPosition, snackbarType);
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    public void showSubscribeButton(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.a.setText(str);
        Views.show(this.a);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> unsubscribeClicks() {
        return this.c.unsubscribeClicks();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SubscribeButtonsViewImpl(android.view.View r1, com.avito.android.subscriptions_settings.SubscriptionSettingsView r2, int r3, t6.r.a.j r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0012
            com.avito.android.subscriptions_settings.SubscriptionSettingsViewImpl r2 = new com.avito.android.subscriptions_settings.SubscriptionSettingsViewImpl
            android.content.Context r3 = r1.getContext()
            java.lang.String r4 = "view.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r2.<init>(r3)
        L_0x0012:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.public_profile.ui.SubscribeButtonsViewImpl.<init>(android.view.View, com.avito.android.subscriptions_settings.SubscriptionSettingsView, int, t6.r.a.j):void");
    }
}
