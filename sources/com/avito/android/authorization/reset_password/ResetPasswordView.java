package com.avito.android.authorization.reset_password;

import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0006H&¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0003H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H&¢\u0006\u0004\b\u0014\u0010\u000eJ\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0003H&¢\u0006\u0004\b\u0016\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0003H&¢\u0006\u0004\b\u0017\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\u0006H&¢\u0006\u0004\b\u0018\u0010\u000eJ%\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H&¢\u0006\u0004\b\u001d\u0010\u000eJ\u000f\u0010\u001e\u001a\u00020\u0006H&¢\u0006\u0004\b\u001e\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/authorization/reset_password/ResetPasswordView;", "", "Lio/reactivex/Observable;", "", "loginChanges", "()Lio/reactivex/Observable;", "", "navigationClicks", "resetPasswordClicks", "", "enabled", "setResetPasswordButtonEnabled", "(Z)V", PlatformActions.HIDE_KEYBOARD, "()V", "showProgress", "hideProgress", "message", "showError", "(Ljava/lang/String;)V", "showUnknownError", "login", "setLogin", "showLoginError", "hideLoginError", "Lkotlin/Function0;", "onOk", "showUserDialog", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "closeUserDialog", "requestFieldFocus", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface ResetPasswordView {
    void closeUserDialog();

    void hideKeyboard();

    void hideLoginError();

    void hideProgress();

    @NotNull
    Observable<String> loginChanges();

    @NotNull
    Observable<Unit> navigationClicks();

    void requestFieldFocus();

    @NotNull
    Observable<Unit> resetPasswordClicks();

    void setLogin(@NotNull String str);

    void setResetPasswordButtonEnabled(boolean z);

    void showError(@NotNull String str);

    void showLoginError(@NotNull String str);

    void showProgress();

    void showUnknownError();

    void showUserDialog(@NotNull String str, @NotNull Function0<Unit> function0);
}
