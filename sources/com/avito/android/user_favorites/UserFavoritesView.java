package com.avito.android.user_favorites;

import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H&¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0003H&¢\u0006\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/avito/android/user_favorites/UserFavoritesView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "notifyTabCountersChanged", "()V", "notifyTabsChanged", "", VKApiConst.POSITION, "setTabPosition", "(I)V", "pageChanges", "scrollToTop", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
public interface UserFavoritesView {
    @NotNull
    Observable<Unit> navigationClicks();

    void notifyTabCountersChanged();

    void notifyTabsChanged();

    @NotNull
    Observable<Integer> pageChanges();

    void scrollToTop();

    void setTabPosition(int i);
}
