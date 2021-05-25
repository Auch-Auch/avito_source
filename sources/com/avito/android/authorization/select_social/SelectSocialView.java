package com.avito.android.authorization.select_social;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u0003H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H&¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0003H&¢\u0006\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/authorization/select_social/SelectSocialView;", "", "Lio/reactivex/Observable;", "", "navigationClicks", "()Lio/reactivex/Observable;", "", "message", "showError", "(Ljava/lang/String;)V", "title", "showErrorDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "showToast", "showProgress", "()V", "hideProgress", "notifyItemsChanged", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface SelectSocialView {
    void hideProgress();

    @NotNull
    Observable<Unit> navigationClicks();

    void notifyItemsChanged();

    void showError(@NotNull String str);

    void showErrorDialog(@Nullable String str, @Nullable String str2);

    void showProgress();

    void showToast(@NotNull String str);
}
