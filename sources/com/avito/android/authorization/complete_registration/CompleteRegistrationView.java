package com.avito.android.authorization.complete_registration;

import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.preferences.Preference;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\b\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\t\u0010\u0005J\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0003H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H&¢\u0006\u0004\b\u0015\u0010\u000fJ\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0003H&¢\u0006\u0004\b\u0017\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0003H&¢\u0006\u0004\b\u0019\u0010\u0014J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0003H&¢\u0006\u0004\b\u001a\u0010\u0014J\u000f\u0010\u001b\u001a\u00020\u0007H&¢\u0006\u0004\b\u001b\u0010\u000fJ\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0003H&¢\u0006\u0004\b\u001c\u0010\u0014J\u000f\u0010\u001d\u001a\u00020\u0007H&¢\u0006\u0004\b\u001d\u0010\u000fJ\u000f\u0010\u001e\u001a\u00020\u0007H&¢\u0006\u0004\b\u001e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/avito/android/authorization/complete_registration/CompleteRegistrationView;", "", "Lio/reactivex/Observable;", "", "nameChanges", "()Lio/reactivex/Observable;", "passwordChanges", "", "navigationClicks", "registerClicks", "", "enabled", "setRegisterButtonEnabled", "(Z)V", PlatformActions.HIDE_KEYBOARD, "()V", "showProgress", "hideProgress", "message", "showError", "(Ljava/lang/String;)V", "showUnknownError", "name", "setName", Preference.PASSWORD, "setPassword", "showNameError", "hideNameError", "showPasswordError", "hidePasswordError", "requestFieldFocus", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface CompleteRegistrationView {
    void hideKeyboard();

    void hideNameError();

    void hidePasswordError();

    void hideProgress();

    @NotNull
    Observable<String> nameChanges();

    @NotNull
    Observable<Unit> navigationClicks();

    @NotNull
    Observable<String> passwordChanges();

    @NotNull
    Observable<Unit> registerClicks();

    void requestFieldFocus();

    void setName(@NotNull String str);

    void setPassword(@NotNull String str);

    void setRegisterButtonEnabled(boolean z);

    void showError(@NotNull String str);

    void showNameError(@NotNull String str);

    void showPasswordError(@NotNull String str);

    void showProgress();

    void showUnknownError();
}
