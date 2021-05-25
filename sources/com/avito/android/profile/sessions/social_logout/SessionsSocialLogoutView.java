package com.avito.android.profile.sessions.social_logout;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutView;", "", "", "showButtonProgress", "()V", "hideButtonProgress", "", "message", "showMessage", "(Ljava/lang/String;)V", "Lio/reactivex/rxjava3/core/Observable;", "getNavigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationClicks", "getButtonClicks", "buttonClicks", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface SessionsSocialLogoutView {
    @NotNull
    Observable<Unit> getButtonClicks();

    @NotNull
    Observable<Unit> getNavigationClicks();

    void hideButtonProgress();

    void showButtonProgress();

    void showMessage(@NotNull String str);
}
