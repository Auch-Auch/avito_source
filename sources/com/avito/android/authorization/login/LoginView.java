package com.avito.android.authorization.login;

import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.preferences.Preference;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\b\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\t\u0010\u0005J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\n\u0010\u0005J\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0003H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H&¢\u0006\u0004\b\u0016\u0010\u0010J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0003H&¢\u0006\u0004\b\u0018\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0003H&¢\u0006\u0004\b\u001a\u0010\u0015J\u000f\u0010\u001b\u001a\u00020\u0007H&¢\u0006\u0004\b\u001b\u0010\u0010J\u000f\u0010\u001c\u001a\u00020\u0007H&¢\u0006\u0004\b\u001c\u0010\u0010J\u000f\u0010\u001d\u001a\u00020\u0007H&¢\u0006\u0004\b\u001d\u0010\u0010J\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0003H&¢\u0006\u0004\b\u001e\u0010\u0015J\u000f\u0010\u001f\u001a\u00020\u0007H&¢\u0006\u0004\b\u001f\u0010\u0010J\u0017\u0010 \u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0003H&¢\u0006\u0004\b \u0010\u0015J\u000f\u0010!\u001a\u00020\u0007H&¢\u0006\u0004\b!\u0010\u0010J\u001f\u0010$\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H&¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0007H&¢\u0006\u0004\b&\u0010\u0010J'\u0010*\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(H&¢\u0006\u0004\b*\u0010+JC\u0010*\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00032\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070-2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070-H&¢\u0006\u0004\b*\u00100JK\u0010*\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u00032\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00070-2\u0006\u00103\u001a\u00020\u00032\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00070-H&¢\u0006\u0004\b*\u00105J\u001f\u0010*\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H&¢\u0006\u0004\b*\u0010%J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0003H&¢\u0006\u0004\b*\u0010\u0015J\u000f\u00106\u001a\u00020\u0007H&¢\u0006\u0004\b6\u0010\u0010J\u000f\u00107\u001a\u00020\u0007H&¢\u0006\u0004\b7\u0010\u0010J\u0017\u00108\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0003H&¢\u0006\u0004\b8\u0010\u0015¨\u00069"}, d2 = {"Lcom/avito/android/authorization/login/LoginView;", "", "Lio/reactivex/Observable;", "", "loginChanges", "()Lio/reactivex/Observable;", "passwordChanges", "", "navigationClicks", "loginClicks", "forgotPasswordClicks", "", "enabled", "setLoginButtonEnabled", "(Z)V", PlatformActions.HIDE_KEYBOARD, "()V", "showProgress", "hideProgress", "message", "showError", "(Ljava/lang/String;)V", "showUnknownError", "login", "setLogin", Preference.PASSWORD, "setPassword", "showLogin", "hideLogin", "setFocusOnPasswordField", "showLoginError", "hideLoginError", "showPasswordError", "hidePasswordError", "text", "highlightText", "showText", "(Ljava/lang/String;Ljava/lang/String;)V", "hideText", "title", "", "action", "showUserDialog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;)V", "agreeButtonTitle", "Lkotlin/Function0;", "onAgree", "onCancel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "firstActionButtonTitle", "onFirstAction", "secondActionButtonTitle", "onSecondAction", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "closeUserDialog", "requestFieldFocus", "showToast", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface LoginView {
    void closeUserDialog();

    @NotNull
    Observable<Unit> forgotPasswordClicks();

    void hideKeyboard();

    void hideLogin();

    void hideLoginError();

    void hidePasswordError();

    void hideProgress();

    void hideText();

    @NotNull
    Observable<String> loginChanges();

    @NotNull
    Observable<Unit> loginClicks();

    @NotNull
    Observable<Unit> navigationClicks();

    @NotNull
    Observable<String> passwordChanges();

    void requestFieldFocus();

    void setFocusOnPasswordField();

    void setLogin(@NotNull String str);

    void setLoginButtonEnabled(boolean z);

    void setPassword(@NotNull String str);

    void showError(@NotNull String str);

    void showLogin();

    void showLoginError(@NotNull String str);

    void showPasswordError(@NotNull String str);

    void showProgress();

    void showText(@NotNull String str, @NotNull String str2);

    void showToast(@NotNull String str);

    void showUnknownError();

    void showUserDialog(@NotNull String str);

    void showUserDialog(@NotNull String str, @NotNull String str2);

    void showUserDialog(@NotNull String str, @NotNull String str2, @NotNull CharSequence charSequence);

    void showUserDialog(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function0<Unit> function0, @NotNull String str4, @NotNull Function0<Unit> function02);

    void showUserDialog(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02);
}
