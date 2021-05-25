package com.avito.android.code_confirmation;

import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H&¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\bH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\bH&¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0003H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\bH&¢\u0006\u0004\b\u0018\u0010\u0012J\u0017\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\bH&¢\u0006\u0004\b\u001a\u0010\u0012J\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\bH&¢\u0006\u0004\b\u001b\u0010\u0012J\u000f\u0010\u001c\u001a\u00020\u0003H&¢\u0006\u0004\b\u001c\u0010\u0016J\u001f\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0003H&¢\u0006\u0004\b \u0010\u0016J\u000f\u0010!\u001a\u00020\u0003H&¢\u0006\u0004\b!\u0010\u0016J\u0017\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0003H&¢\u0006\u0004\b&\u0010\u0016J\u000f\u0010'\u001a\u00020\u0003H&¢\u0006\u0004\b'\u0010\u0016JC\u0010-\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030*2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030*H&¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0003H&¢\u0006\u0004\b/\u0010\u0016¨\u00060"}, d2 = {"Lcom/avito/android/code_confirmation/CodeConfirmationView;", "", "Lio/reactivex/Observable;", "", "sendClicks", "()Lio/reactivex/Observable;", "requestClicks", "navigationClicks", "", "codeChanged", "getCode", "()Ljava/lang/String;", "", "length", "setCodeLength", "(I)V", "code", "showCode", "(Ljava/lang/String;)V", "text", "showTimer", "showRequestButton", "()V", "error", "showError", "message", "showMessage", "showCodeError", "hideCodeError", "highlightText", "showText", "(Ljava/lang/String;Ljava/lang/String;)V", "showProgress", "hideProgress", "", "enabled", "setSendButtonEnabled", "(Z)V", PlatformActions.HIDE_KEYBOARD, "requestFieldFocus", "title", "agreeButtonTitle", "Lkotlin/Function0;", "onAgree", "onCancel", "showUserDialog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "closeUserDialog", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public interface CodeConfirmationView {
    void closeUserDialog();

    @NotNull
    Observable<String> codeChanged();

    @NotNull
    String getCode();

    void hideCodeError();

    void hideKeyboard();

    void hideProgress();

    @NotNull
    Observable<Unit> navigationClicks();

    @NotNull
    Observable<Unit> requestClicks();

    void requestFieldFocus();

    @NotNull
    Observable<Unit> sendClicks();

    void setCodeLength(int i);

    void setSendButtonEnabled(boolean z);

    void showCode(@NotNull String str);

    void showCodeError(@NotNull String str);

    void showError(@NotNull String str);

    void showMessage(@NotNull String str);

    void showProgress();

    void showRequestButton();

    void showText(@NotNull String str, @NotNull String str2);

    void showTimer(@NotNull String str);

    void showUserDialog(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02);
}
