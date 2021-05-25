package com.avito.android.profile.password_change;

import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0014\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0006J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0006J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\nH&¢\u0006\u0004\b\u0013\u0010\rJ\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\bJ\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\bJ\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0002H&¢\u0006\u0004\b\u0019\u0010\u0006J\u000f\u0010\u001a\u001a\u00020\u0004H&¢\u0006\u0004\b\u001a\u0010\bJ\u000f\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u0004H&¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u001d\u001a\u00020\u0004H&¢\u0006\u0004\b\u001d\u0010\bJ\u000f\u0010\u001e\u001a\u00020\u0004H&¢\u0006\u0004\b\u001e\u0010\bR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010!R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010!R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010!R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010!R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010!R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010!R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u0010!¨\u00063"}, d2 = {"Lcom/avito/android/profile/password_change/PasswordChangeView;", "", "", "oldPassword", "", "fillOldPassword", "(Ljava/lang/String;)V", "highlightOldPassword", "()V", "highlightNewPassword", "", "isHidden", "setOldPasswordInputHidden", "(Z)V", "setNewPasswordInputHidden", "error", "showOldPasswordError", "showNewPasswordError", "enabled", "setButtonEnabled", "showProgress", "hideProgress", "showButtonProgress", "hideButtonProgress", "message", "showSnackbar", PlatformActions.HIDE_KEYBOARD, "onDestroyView", "showViewsForSessionsFlow", "hideViewsForSessionsFlow", "scrollToBottom", "Lio/reactivex/Observable;", "getOldPasswordIconClicks", "()Lio/reactivex/Observable;", "oldPasswordIconClicks", "getOldPasswordChanges", "oldPasswordChanges", "getActionDoneClicks", "actionDoneClicks", "getForgotPasswordClicks", "forgotPasswordClicks", "getNavigationClicks", "navigationClicks", "getNewPasswordIconClicks", "newPasswordIconClicks", "getKeyboardVisibilityChanges", "keyboardVisibilityChanges", "getNewPasswordChanges", "newPasswordChanges", "getButtonClicks", "buttonClicks", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface PasswordChangeView {
    void fillOldPassword(@NotNull String str);

    @NotNull
    Observable<Unit> getActionDoneClicks();

    @NotNull
    Observable<Unit> getButtonClicks();

    @NotNull
    Observable<Unit> getForgotPasswordClicks();

    @NotNull
    Observable<Boolean> getKeyboardVisibilityChanges();

    @NotNull
    Observable<Unit> getNavigationClicks();

    @NotNull
    Observable<String> getNewPasswordChanges();

    @NotNull
    Observable<Unit> getNewPasswordIconClicks();

    @NotNull
    Observable<String> getOldPasswordChanges();

    @NotNull
    Observable<Unit> getOldPasswordIconClicks();

    void hideButtonProgress();

    void hideKeyboard();

    void hideProgress();

    void hideViewsForSessionsFlow();

    void highlightNewPassword();

    void highlightOldPassword();

    void onDestroyView();

    void scrollToBottom();

    void setButtonEnabled(boolean z);

    void setNewPasswordInputHidden(boolean z);

    void setOldPasswordInputHidden(boolean z);

    void showButtonProgress();

    void showNewPasswordError(@NotNull String str);

    void showOldPasswordError(@NotNull String str);

    void showProgress();

    void showSnackbar(@NotNull String str);

    void showViewsForSessionsFlow();
}
