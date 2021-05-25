package com.avito.android.abuse.details;

import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\bH&¢\u0006\u0004\b\u000b\u0010\nJ%\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0004J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u001b\u0010\u001aJ\u001d\u0010\u001e\u001a\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0002H&¢\u0006\u0004\b \u0010\u0004¨\u0006!"}, d2 = {"Lcom/avito/android/abuse/details/AbuseDetailsView;", "", "", "showCloseNavigation", "()V", "showBackNavigation", "showSendButton", "hideSendButton", "Lio/reactivex/rxjava3/core/Observable;", "sendClicks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationClicks", "", "message", "Lkotlin/Function0;", "callback", "showError", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "showSnackbar", "(Ljava/lang/String;)V", "showLoading", "showContent", "notifyItemsChanged", "", FirebaseAnalytics.Param.INDEX, "notifyItemRemoved", "(I)V", "scrollToPosition", "", "indexes", "setDividers", "(Ljava/lang/Iterable;)V", PlatformActions.HIDE_KEYBOARD, "abuse_release"}, k = 1, mv = {1, 4, 2})
public interface AbuseDetailsView {
    void hideKeyboard();

    void hideSendButton();

    @NotNull
    Observable<Unit> navigationClicks();

    void notifyItemRemoved(int i);

    void notifyItemsChanged();

    void scrollToPosition(int i);

    @NotNull
    Observable<Unit> sendClicks();

    void setDividers(@NotNull Iterable<Integer> iterable);

    void showBackNavigation();

    void showCloseNavigation();

    void showContent();

    void showError(@NotNull String str, @NotNull Function0<Unit> function0);

    void showLoading();

    void showSendButton();

    void showSnackbar(@NotNull String str);
}
