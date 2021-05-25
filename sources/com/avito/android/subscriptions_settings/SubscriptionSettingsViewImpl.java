package com.avito.android.subscriptions_settings;

import a2.a.a.c3.b;
import a2.g.r.g;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.Action;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.dialog.Dialogs;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0004hijkB\u000f\u0012\u0006\u0010b\u001a\u00020_¢\u0006\u0004\bf\u0010gJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001b\u0010\u000fJ\u0017\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u000fJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\nH\u0016¢\u0006\u0004\b \u0010\fJY\u0010-\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010!2\u0006\u0010&\u001a\u00020#2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\u0006\u0010(\u001a\u00020#2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\nH\u0016¢\u0006\u0004\b/\u0010\fJ\u000f\u00100\u001a\u00020\u0003H\u0002¢\u0006\u0004\b0\u0010\tJ\u000f\u00101\u001a\u00020\u0003H\u0002¢\u0006\u0004\b1\u0010\tJ\u000f\u00102\u001a\u00020\u0003H\u0002¢\u0006\u0004\b2\u0010\tR\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HRD\u0010\u0006\u001a0\u0012\f\u0012\n K*\u0004\u0018\u00010\u00030\u0003 K*\u0017\u0012\f\u0012\n K*\u0004\u0018\u00010\u00030\u0003\u0018\u00010J¢\u0006\u0002\bL0J¢\u0006\u0002\bL8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NRD\u0010\u0007\u001a0\u0012\f\u0012\n K*\u0004\u0018\u00010\u00030\u0003 K*\u0017\u0012\f\u0012\n K*\u0004\u0018\u00010\u00030\u0003\u0018\u00010J¢\u0006\u0002\bL0J¢\u0006\u0002\bL8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u00109R\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010HRD\u0010\u0004\u001a0\u0012\f\u0012\n K*\u0004\u0018\u00010\u00030\u0003 K*\u0017\u0012\f\u0012\n K*\u0004\u0018\u00010\u00030\u0003\u0018\u00010J¢\u0006\u0002\bL0J¢\u0006\u0002\bL8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010NR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010]\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010AR\u0018\u0010^\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00105R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010c\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010=R\u0018\u0010e\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bd\u0010A¨\u0006l"}, d2 = {"Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl;", "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;", "Lio/reactivex/rxjava3/core/Observable;", "", "notificationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "unsubscribeClicks", "dismissEvents", "openSubscriptionSettings", "()V", "", "closeSubscriptionSettings", "()Z", "isActivated", "setNotificationActivated", "(Z)V", "isSubscribed", "isEnabled", "setSubscribed", "(ZZ)V", "Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;", "errorDialog", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showErrorDialog", "(Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;Lkotlin/jvm/functions/Function0;)V", "isLoading", "setNotificationLoading", "setUnsubscribeLoading", "Lio/reactivex/rxjava3/core/Maybe;", "showEnableNotificationDialog", "()Lio/reactivex/rxjava3/core/Maybe;", "isMenuShowing", "", "text", "", "textResId", "actionText", "actionTextResId", "onActionClick", "duration", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", VKApiConst.POSITION, "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "type", "showSnackbar", "(Ljava/lang/String;ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILcom/avito/android/lib/design/snackbar/SnackbarPosition;Lcom/avito/android/lib/design/snackbar/SnackbarType;)V", "canShowSnackbar", AuthSource.BOOKING_ORDER, "c", AuthSource.SEND_ABUSE, "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "unsubscriptionIcon", "Landroid/widget/ProgressBar;", "d", "Landroid/widget/ProgressBar;", "notificationsProgress", "Landroid/widget/TextView;", g.a, "Landroid/widget/TextView;", "unsubscriptionTitle", "Landroid/view/View;", "i", "Landroid/view/View;", "unsubscriptionItem", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "settingsDialog", "o", "Z", "isNotificationLoading", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "k", "Lcom/jakewharton/rxrelay3/PublishRelay;", "l", "h", "unsubscriptionProgress", "Lcom/avito/android/lib/design/dialog/Dialog;", VKApiConst.Q, "Lcom/avito/android/lib/design/dialog/Dialog;", "dialog", "p", "isSubscriptionLoading", "j", "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$State;", "n", "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$State;", "state", "rootView", "notificationsIcon", "Landroid/content/Context;", "r", "Landroid/content/Context;", "context", "notificationsTitle", "e", "notificationsItem", "<init>", "(Landroid/content/Context;)V", "EnabledState", "NotificationState", "State", "SubscriptionState", "favorite-sellers-core_release"}, k = 1, mv = {1, 4, 2})
public final class SubscriptionSettingsViewImpl implements SubscriptionSettingsView {
    public View a;
    public ImageView b;
    public TextView c;
    public ProgressBar d;
    public View e;
    public ImageView f;
    public TextView g;
    public ProgressBar h;
    public View i;
    public final PublishRelay<Unit> j = PublishRelay.create();
    public final PublishRelay<Unit> k = PublishRelay.create();
    public final PublishRelay<Unit> l = PublishRelay.create();
    public BottomSheetDialog m;
    public State n = new State(NotificationState.ON, SubscriptionState.SUBSCRIBED, EnabledState.ENABLED);
    public boolean o;
    public boolean p;
    public Dialog q;
    public final Context r;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$EnabledState;", "", "<init>", "(Ljava/lang/String;I)V", "ENABLED", "DISABLED", "favorite-sellers-core_release"}, k = 1, mv = {1, 4, 2})
    public enum EnabledState {
        ENABLED,
        DISABLED
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$NotificationState;", "", "<init>", "(Ljava/lang/String;I)V", "ON", "OFF", "favorite-sellers-core_release"}, k = 1, mv = {1, 4, 2})
    public enum NotificationState {
        ON,
        OFF
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\n¨\u0006%"}, d2 = {"Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$State;", "", "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$NotificationState;", "component1", "()Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$NotificationState;", "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$SubscriptionState;", "component2", "()Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$SubscriptionState;", "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$EnabledState;", "component3", "()Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$EnabledState;", "notificationState", "subscriptionState", "enabledState", "copy", "(Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$NotificationState;Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$SubscriptionState;Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$EnabledState;)Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$State;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$NotificationState;", "getNotificationState", AuthSource.BOOKING_ORDER, "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$SubscriptionState;", "getSubscriptionState", "c", "Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$EnabledState;", "getEnabledState", "<init>", "(Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$NotificationState;Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$SubscriptionState;Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$EnabledState;)V", "favorite-sellers-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public final NotificationState a;
        @NotNull
        public final SubscriptionState b;
        @NotNull
        public final EnabledState c;

        public State(@NotNull NotificationState notificationState, @NotNull SubscriptionState subscriptionState, @NotNull EnabledState enabledState) {
            Intrinsics.checkNotNullParameter(notificationState, "notificationState");
            Intrinsics.checkNotNullParameter(subscriptionState, "subscriptionState");
            Intrinsics.checkNotNullParameter(enabledState, "enabledState");
            this.a = notificationState;
            this.b = subscriptionState;
            this.c = enabledState;
        }

        public static /* synthetic */ State copy$default(State state, NotificationState notificationState, SubscriptionState subscriptionState, EnabledState enabledState, int i, Object obj) {
            if ((i & 1) != 0) {
                notificationState = state.a;
            }
            if ((i & 2) != 0) {
                subscriptionState = state.b;
            }
            if ((i & 4) != 0) {
                enabledState = state.c;
            }
            return state.copy(notificationState, subscriptionState, enabledState);
        }

        @NotNull
        public final NotificationState component1() {
            return this.a;
        }

        @NotNull
        public final SubscriptionState component2() {
            return this.b;
        }

        @NotNull
        public final EnabledState component3() {
            return this.c;
        }

        @NotNull
        public final State copy(@NotNull NotificationState notificationState, @NotNull SubscriptionState subscriptionState, @NotNull EnabledState enabledState) {
            Intrinsics.checkNotNullParameter(notificationState, "notificationState");
            Intrinsics.checkNotNullParameter(subscriptionState, "subscriptionState");
            Intrinsics.checkNotNullParameter(enabledState, "enabledState");
            return new State(notificationState, subscriptionState, enabledState);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return Intrinsics.areEqual(this.a, state.a) && Intrinsics.areEqual(this.b, state.b) && Intrinsics.areEqual(this.c, state.c);
        }

        @NotNull
        public final EnabledState getEnabledState() {
            return this.c;
        }

        @NotNull
        public final NotificationState getNotificationState() {
            return this.a;
        }

        @NotNull
        public final SubscriptionState getSubscriptionState() {
            return this.b;
        }

        public int hashCode() {
            NotificationState notificationState = this.a;
            int i = 0;
            int hashCode = (notificationState != null ? notificationState.hashCode() : 0) * 31;
            SubscriptionState subscriptionState = this.b;
            int hashCode2 = (hashCode + (subscriptionState != null ? subscriptionState.hashCode() : 0)) * 31;
            EnabledState enabledState = this.c;
            if (enabledState != null) {
                i = enabledState.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("State(notificationState=");
            L.append(this.a);
            L.append(", subscriptionState=");
            L.append(this.b);
            L.append(", enabledState=");
            L.append(this.c);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/subscriptions_settings/SubscriptionSettingsViewImpl$SubscriptionState;", "", "<init>", "(Ljava/lang/String;I)V", "SUBSCRIBED", "NOT_SUBSCRIBED", "favorite-sellers-core_release"}, k = 1, mv = {1, 4, 2})
    public enum SubscriptionState {
        SUBSCRIBED,
        NOT_SUBSCRIBED
    }

    public static final class a extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
        public final /* synthetic */ ErrorResult.ErrorDialog a;
        public final /* synthetic */ Function0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ErrorResult.ErrorDialog errorDialog, Function0 function0) {
            super(2);
            this.a = errorDialog;
            this.b = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
            Action action;
            Dialog.Config config2 = config;
            DialogInterface dialogInterface2 = dialogInterface;
            Intrinsics.checkNotNullParameter(config2, "$receiver");
            Intrinsics.checkNotNullParameter(dialogInterface2, "it");
            config2.setTitle(this.a.getUserDialog().getTitle());
            config2.setSubtitle(this.a.getUserDialog().getMessage());
            config2.setCloseButtonVisible(this.a.getUserDialog().getCancelable());
            List<Action> actions = this.a.getUserDialog().getActions();
            if (!(actions == null || (action = actions.get(0)) == null)) {
                config2.addPrimaryButton(action.getTitle(), new b(this, config2, dialogInterface2));
            }
            return Unit.INSTANCE;
        }
    }

    public SubscriptionSettingsViewImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.r = context;
    }

    public final void a() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
    }

    public final void b() {
        if (this.m != null) {
            ImageView imageView = this.b;
            if (imageView != null) {
                Views.setVisible(imageView, !this.o);
            }
            ProgressBar progressBar = this.d;
            if (progressBar != null) {
                Views.setVisible(progressBar, this.o);
            }
            View view = this.e;
            if (view != null) {
                view.setEnabled(!this.o);
            }
            View view2 = this.i;
            if (view2 != null) {
                view2.setEnabled(!this.o);
            }
            if (this.n.getNotificationState() == NotificationState.ON) {
                ImageView imageView2 = this.b;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.ic_notifications_off);
                }
                TextView textView = this.c;
                if (textView != null) {
                    textView.setText(com.avito.android.favorite_sellers_core.R.string.subscription_settings_disable_notification);
                }
            }
            if (this.n.getNotificationState() == NotificationState.OFF) {
                ImageView imageView3 = this.b;
                if (imageView3 != null) {
                    imageView3.setImageResource(R.drawable.ic_notifications_on);
                }
                TextView textView2 = this.c;
                if (textView2 != null) {
                    textView2.setText(com.avito.android.favorite_sellers_core.R.string.subscription_settings_enable_notification);
                }
            }
        }
    }

    public final void c() {
        if (this.m != null) {
            Views.setVisible(this.f, !this.p);
            Views.setVisible(this.h, this.p);
            View view = this.e;
            if (view != null) {
                view.setEnabled(!this.p);
            }
            View view2 = this.i;
            if (view2 != null) {
                view2.setEnabled(!this.p);
            }
            if (this.n.getEnabledState() == EnabledState.DISABLED || this.n.getSubscriptionState() == SubscriptionState.NOT_SUBSCRIBED) {
                View view3 = this.e;
                if (view3 != null) {
                    view3.setVisibility(8);
                }
            } else {
                View view4 = this.e;
                if (view4 != null) {
                    view4.setVisibility(0);
                }
            }
            if (this.n.getSubscriptionState() == SubscriptionState.SUBSCRIBED) {
                ImageView imageView = this.f;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.ic_unsubscribe_24);
                    Context context = imageView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    imageView.setColorFilter(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.red));
                }
                TextView textView = this.g;
                if (textView != null) {
                    textView.setText(com.avito.android.favorite_sellers_core.R.string.subscription_settings_unsubscribe);
                    Context context2 = textView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    textView.setTextColor(Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.red));
                }
            }
            if (this.n.getSubscriptionState() == SubscriptionState.NOT_SUBSCRIBED) {
                ImageView imageView2 = this.f;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.ic_subscriber_user_filled_24);
                    Context context3 = imageView2.getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "context");
                    imageView2.setColorFilter(Contexts.getColorByAttr(context3, com.avito.android.lib.design.R.attr.black));
                }
                TextView textView2 = this.g;
                if (textView2 != null) {
                    textView2.setText(com.avito.android.favorite_sellers_core.R.string.subscription_settings_subscribe);
                    Context context4 = textView2.getContext();
                    Intrinsics.checkNotNullExpressionValue(context4, "context");
                    textView2.setTextColor(Contexts.getColorByAttr(context4, com.avito.android.lib.design.R.attr.black));
                }
            }
        }
    }

    @Override // com.avito.android.lib.design.snackbar.util.OptionalSnackbarElementView
    public boolean canShowSnackbar() {
        return isMenuShowing();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public boolean closeSubscriptionSettings() {
        BottomSheetDialog bottomSheetDialog = this.m;
        if (bottomSheetDialog == null || !bottomSheetDialog.isShowing()) {
            return false;
        }
        BottomSheetDialog bottomSheetDialog2 = this.m;
        if (bottomSheetDialog2 != null) {
            bottomSheetDialog2.dismiss();
        }
        this.m = null;
        a();
        return true;
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> dismissEvents() {
        PublishRelay<Unit> publishRelay = this.l;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "dismissEvents");
        return publishRelay;
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public boolean isMenuShowing() {
        BottomSheetDialog bottomSheetDialog = this.m;
        if (bottomSheetDialog != null) {
            return bottomSheetDialog.isShowing();
        }
        return false;
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> notificationClicks() {
        PublishRelay<Unit> publishRelay = this.j;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "notificationClicks");
        return publishRelay;
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void openSubscriptionSettings() {
        if (this.m == null) {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.r, 0, 2, null);
            bottomSheetDialog.setContentView(com.avito.android.favorite_sellers_core.R.layout.subscription_menu);
            View findViewById = bottomSheetDialog.findViewById(com.avito.android.favorite_sellers_core.R.id.subscriptions_settings_root);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
            this.a = findViewById;
            View findViewById2 = bottomSheetDialog.findViewById(com.avito.android.favorite_sellers_core.R.id.notifications_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(id)");
            this.b = (ImageView) findViewById2;
            View findViewById3 = bottomSheetDialog.findViewById(com.avito.android.favorite_sellers_core.R.id.notifications_title);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(id)");
            this.c = (TextView) findViewById3;
            View findViewById4 = bottomSheetDialog.findViewById(com.avito.android.favorite_sellers_core.R.id.notifications_item);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(id)");
            this.e = findViewById4;
            View findViewById5 = bottomSheetDialog.findViewById(com.avito.android.favorite_sellers_core.R.id.notifications_progress);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(id)");
            this.d = (ProgressBar) findViewById5;
            View findViewById6 = bottomSheetDialog.findViewById(com.avito.android.favorite_sellers_core.R.id.unsubscription_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(id)");
            this.f = (ImageView) findViewById6;
            View findViewById7 = bottomSheetDialog.findViewById(com.avito.android.favorite_sellers_core.R.id.unsubscription_title);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(id)");
            this.g = (TextView) findViewById7;
            View findViewById8 = bottomSheetDialog.findViewById(com.avito.android.favorite_sellers_core.R.id.unsubscription_progress);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(id)");
            this.h = (ProgressBar) findViewById8;
            View findViewById9 = bottomSheetDialog.findViewById(com.avito.android.favorite_sellers_core.R.id.unsubscription_item);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(id)");
            this.i = findViewById9;
            View view = this.e;
            if (view != null) {
                view.setOnClickListener(new m2(0, this));
            }
            View view2 = this.i;
            if (view2 != null) {
                view2.setOnClickListener(new m2(1, this));
            }
            Context context = bottomSheetDialog.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            bottomSheetDialog.setPeekHeight(Contexts.getDisplayHeight(context));
            bottomSheetDialog.setCancelable(true);
            bottomSheetDialog.setCanceledOnTouchOutside(true);
            BottomSheetDialog.setHeaderParams$default(bottomSheetDialog, null, null, false, true, 2, null);
            bottomSheetDialog.setOnDismissListener(new a2.a.a.c3.a(this));
            this.m = bottomSheetDialog;
            b();
            c();
            BottomSheetDialog bottomSheetDialog2 = this.m;
            if (bottomSheetDialog2 != null) {
                bottomSheetDialog2.show();
            }
        }
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setNotificationActivated(boolean z) {
        NotificationState notificationState;
        if (z) {
            notificationState = NotificationState.ON;
        } else {
            notificationState = NotificationState.OFF;
        }
        this.n = new State(notificationState, this.n.getSubscriptionState(), this.n.getEnabledState());
        b();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setNotificationLoading(boolean z) {
        this.o = z;
        b();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setSubscribed(boolean z, boolean z2) {
        SubscriptionState subscriptionState;
        EnabledState enabledState;
        if (z) {
            subscriptionState = SubscriptionState.SUBSCRIBED;
        } else {
            subscriptionState = SubscriptionState.NOT_SUBSCRIBED;
        }
        if (z2) {
            enabledState = EnabledState.ENABLED;
        } else {
            enabledState = EnabledState.DISABLED;
        }
        this.n = new State(this.n.getNotificationState(), subscriptionState, enabledState);
        c();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setUnsubscribeLoading(boolean z) {
        this.p = z;
        c();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Maybe<Unit> showEnableNotificationDialog() {
        return Dialogs.INSTANCE.showEnableNotifications(this.r);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void showErrorDialog(@NotNull ErrorResult.ErrorDialog errorDialog, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(errorDialog, "errorDialog");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Dialog dialog = this.q;
        if (dialog != null) {
            dialog.dismiss();
        }
        Dialog create$default = Dialog.Companion.create$default(Dialog.Companion, this.r, 0, 0, new a(errorDialog, function0), 6, null);
        this.q = create$default;
        if (create$default != null) {
            create$default.show();
        }
    }

    @Override // com.avito.android.lib.design.snackbar.util.SnackbarElementView
    public void showSnackbar(@NotNull String str, int i2, @Nullable String str2, int i3, @Nullable Function0<Unit> function0, int i4, @NotNull SnackbarPosition snackbarPosition, @NotNull SnackbarType snackbarType) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(snackbarPosition, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(snackbarType, "type");
        View view = this.a;
        if (view != null) {
            SnackbarExtensionsKt.showSnackbar(view, str, i2, str2, i3, function0, i4, snackbarPosition, snackbarType);
        }
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> unsubscribeClicks() {
        PublishRelay<Unit> publishRelay = this.k;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "unsubscribeClicks");
        return publishRelay;
    }
}
