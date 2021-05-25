package com.avito.android.subscriptions_settings;

import com.avito.android.lib.design.snackbar.util.OptionalSnackbarElementView;
import com.avito.android.remote.error.ErrorResult;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\tH&¢\u0006\u0004\b\u0011\u0010\u000eJ\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\tH&¢\u0006\u0004\b\u0016\u0010\u000bJ\u001f\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH&¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dH&¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/avito/android/subscriptions_settings/SubscriptionSettingsView;", "Lcom/avito/android/lib/design/snackbar/util/OptionalSnackbarElementView;", "Lio/reactivex/rxjava3/core/Observable;", "", "notificationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "unsubscribeClicks", "openSubscriptionSettings", "()V", "", "closeSubscriptionSettings", "()Z", "isActivated", "setNotificationActivated", "(Z)V", "isLoading", "setNotificationLoading", "setUnsubscribeLoading", "Lio/reactivex/rxjava3/core/Maybe;", "showEnableNotificationDialog", "()Lio/reactivex/rxjava3/core/Maybe;", "dismissEvents", "isMenuShowing", "isSubscribed", "isEnabled", "setSubscribed", "(ZZ)V", "Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;", "errorDialog", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showErrorDialog", "(Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;Lkotlin/jvm/functions/Function0;)V", "favorite-sellers-core_release"}, k = 1, mv = {1, 4, 2})
public interface SubscriptionSettingsView extends OptionalSnackbarElementView {
    boolean closeSubscriptionSettings();

    @NotNull
    Observable<Unit> dismissEvents();

    boolean isMenuShowing();

    @NotNull
    Observable<Unit> notificationClicks();

    void openSubscriptionSettings();

    void setNotificationActivated(boolean z);

    void setNotificationLoading(boolean z);

    void setSubscribed(boolean z, boolean z2);

    void setUnsubscribeLoading(boolean z);

    @NotNull
    Maybe<Unit> showEnableNotificationDialog();

    void showErrorDialog(@NotNull ErrorResult.ErrorDialog errorDialog, @NotNull Function0<Unit> function0);

    @NotNull
    Observable<Unit> unsubscribeClicks();
}
