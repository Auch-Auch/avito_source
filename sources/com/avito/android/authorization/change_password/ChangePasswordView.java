package com.avito.android.authorization.change_password;

import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.preferences.Preference;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0003H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H&¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0003H&¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0003H&¢\u0006\u0004\b\u0019\u0010\u0012J\u000f\u0010\u001a\u001a\u00020\u0003H&¢\u0006\u0004\b\u001a\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/avito/android/authorization/change_password/ChangePasswordView;", "", "Lio/reactivex/Observable;", "", "saveClicks", "()Lio/reactivex/Observable;", "navigationClicks", "", "passwordChanged", Preference.PASSWORD, "setPassword", "(Ljava/lang/String;)V", "error", "showError", "message", "showMessage", "showPasswordError", "hidePasswordError", "()V", "showProgress", "hideProgress", "", "enabled", "setSaveButtonEnabled", "(Z)V", PlatformActions.HIDE_KEYBOARD, "requestFieldFocus", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface ChangePasswordView {
    void hideKeyboard();

    void hidePasswordError();

    void hideProgress();

    @NotNull
    Observable<Unit> navigationClicks();

    @NotNull
    Observable<String> passwordChanged();

    void requestFieldFocus();

    @NotNull
    Observable<Unit> saveClicks();

    void setPassword(@NotNull String str);

    void setSaveButtonEnabled(boolean z);

    void showError(@NotNull String str);

    void showMessage(@NotNull String str);

    void showPasswordError(@NotNull String str);

    void showProgress();
}
