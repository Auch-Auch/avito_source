package com.avito.android.authorization.login_protection;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH&¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\nJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0003H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH&¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0012\u001a\u00020\bH&¢\u0006\u0004\b\u0012\u0010\nR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005¨\u0006\u0015"}, d2 = {"Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "getSearchTextChanges", "()Lio/reactivex/rxjava3/core/Observable;", "getSearchText", "()Ljava/lang/String;", "", "showSearchInput", "()V", "onDataChanged", "showProgress", "hideProgress", "message", "showSnackbar", "(Ljava/lang/String;)V", "showDescriptionForTfa", "showDescriptionForAntihack", "getNavigationClicks", "navigationClicks", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface LoginProtectionPhoneListView {
    @NotNull
    Observable<Unit> getNavigationClicks();

    @Nullable
    String getSearchText();

    @Nullable
    Observable<String> getSearchTextChanges();

    void hideProgress();

    void onDataChanged();

    void showDescriptionForAntihack();

    void showDescriptionForTfa();

    void showProgress();

    void showSearchInput();

    void showSnackbar(@NotNull String str);
}
