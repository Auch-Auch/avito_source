package com.avito.android.profile.sessions.info;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/avito/android/profile/sessions/info/SessionsInfoView;", "", "", "bindTextsForPasswordChange", "()V", "bindTextsForLogout", "expandInfo", "Lio/reactivex/rxjava3/core/Observable;", "getHelpCenterLinkClicks", "()Lio/reactivex/rxjava3/core/Observable;", "helpCenterLinkClicks", "getNavigationClicks", "navigationClicks", "getExpandInfoClicks", "expandInfoClicks", "getButtonClicks", "buttonClicks", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface SessionsInfoView {
    void bindTextsForLogout();

    void bindTextsForPasswordChange();

    void expandInfo();

    @NotNull
    Observable<Unit> getButtonClicks();

    @NotNull
    Observable<Unit> getExpandInfoClicks();

    @NotNull
    Observable<Unit> getHelpCenterLinkClicks();

    @NotNull
    Observable<Unit> getNavigationClicks();
}
