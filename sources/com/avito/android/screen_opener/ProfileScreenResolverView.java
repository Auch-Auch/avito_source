package com.avito.android.screen_opener;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/avito/android/screen_opener/ProfileScreenResolverView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "buttonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationClicks", "showProgress", "()V", "hideProgress", "", "text", "showError", "(Ljava/lang/CharSequence;)V", "", "message", "showUserBanned", "(Ljava/lang/String;)V", "showUserRemoved", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileScreenResolverView {
    @NotNull
    Observable<Unit> buttonClicks();

    void hideProgress();

    @NotNull
    Observable<Unit> navigationClicks();

    void showError(@NotNull CharSequence charSequence);

    void showProgress();

    void showUserBanned(@NotNull String str);

    void showUserRemoved(@NotNull String str);
}
