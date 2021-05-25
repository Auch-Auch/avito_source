package com.avito.android.profile.password_setting;

import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u000eJ\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u000eR\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016¨\u0006 "}, d2 = {"Lcom/avito/android/profile/password_setting/PasswordSettingView;", "", "", "isHidden", "", "setPasswordInputHidden", "(Z)V", "", "error", "showPasswordError", "(Ljava/lang/String;)V", "enabled", "setButtonEnabled", "showButtonProgress", "()V", "hideButtonProgress", "message", "showSnackbar", PlatformActions.HIDE_KEYBOARD, "onDestroyView", "Lio/reactivex/Observable;", "getNavigationClicks", "()Lio/reactivex/Observable;", "navigationClicks", "getActionDoneClicks", "actionDoneClicks", "getPasswordIconClicks", "passwordIconClicks", "getPasswordChanges", "passwordChanges", "getButtonClicks", "buttonClicks", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface PasswordSettingView {
    @NotNull
    Observable<Unit> getActionDoneClicks();

    @NotNull
    Observable<Unit> getButtonClicks();

    @NotNull
    Observable<Unit> getNavigationClicks();

    @NotNull
    Observable<String> getPasswordChanges();

    @NotNull
    Observable<Unit> getPasswordIconClicks();

    void hideButtonProgress();

    void hideKeyboard();

    void onDestroyView();

    void setButtonEnabled(boolean z);

    void setPasswordInputHidden(boolean z);

    void showButtonProgress();

    void showPasswordError(@NotNull String str);

    void showSnackbar(@NotNull String str);
}
