package com.avito.android.profile_phones.phone_management;

import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\u000bJ#\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0003H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\u000bJ\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0007H&¢\u0006\u0004\b\u0018\u0010\u000bJ\u000f\u0010\u0019\u001a\u00020\u0003H&¢\u0006\u0004\b\u0019\u0010\u0015J\u000f\u0010\u001a\u001a\u00020\u0003H&¢\u0006\u0004\b\u001a\u0010\u0015J\u000f\u0010\u001b\u001a\u00020\u0003H&¢\u0006\u0004\b\u001b\u0010\u0015J\u000f\u0010\u001c\u001a\u00020\u0003H&¢\u0006\u0004\b\u001c\u0010\u0015J\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u001d\u0010\u000bJ\u0017\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b \u0010!JC\u0010'\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030$H&¢\u0006\u0004\b'\u0010(J\u001f\u0010'\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H&¢\u0006\u0004\b'\u0010\u0013J\u000f\u0010)\u001a\u00020\u0003H&¢\u0006\u0004\b)\u0010\u0015J\u000f\u0010*\u001a\u00020\u0003H&¢\u0006\u0004\b*\u0010\u0015¨\u0006+"}, d2 = {"Lcom/avito/android/profile_phones/phone_management/PhoneManagementView;", "", "Lio/reactivex/Observable;", "", "buttonClicks", "()Lio/reactivex/Observable;", "navigationClicks", "", "phoneChanges", "title", "setTitle", "(Ljava/lang/String;)V", "phone", "setPhone", "hint", "setPhoneHint", "text", "highlightedText", "showText", "(Ljava/lang/String;Ljava/lang/String;)V", "showUnknownError", "()V", "error", "showError", "showPhoneError", "hidePhoneError", "showProgress", "hideProgress", PlatformActions.HIDE_KEYBOARD, "setButtonText", "", "enabled", "setButtonEnabled", "(Z)V", "message", "agreeButtonTitle", "Lkotlin/Function0;", "onAgree", "onCancel", "showUserDialog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "closeUserDialog", "requestFieldFocus", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneManagementView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void showText$default(PhoneManagementView phoneManagementView, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                phoneManagementView.showText(str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showText");
        }
    }

    @NotNull
    Observable<Unit> buttonClicks();

    void closeUserDialog();

    void hideKeyboard();

    void hidePhoneError();

    void hideProgress();

    @NotNull
    Observable<Unit> navigationClicks();

    @NotNull
    Observable<String> phoneChanges();

    void requestFieldFocus();

    void setButtonEnabled(boolean z);

    void setButtonText(@NotNull String str);

    void setPhone(@NotNull String str);

    void setPhoneHint(@NotNull String str);

    void setTitle(@NotNull String str);

    void showError(@NotNull String str);

    void showPhoneError(@NotNull String str);

    void showProgress();

    void showText(@NotNull String str, @Nullable String str2);

    void showUnknownError();

    void showUserDialog(@NotNull String str, @NotNull String str2);

    void showUserDialog(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02);
}
