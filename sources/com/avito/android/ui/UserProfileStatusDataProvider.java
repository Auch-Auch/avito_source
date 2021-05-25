package com.avito.android.ui;

import com.avito.android.remote.model.ProfileInfo;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0016\u0010\u0016\u001a\u00020\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\tR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/avito/android/ui/UserProfileStatusDataProvider;", "", "", "updateUnreadMessagesAndExpiredAdverts", "()V", "updateUserFavoritesCounters", "Lio/reactivex/rxjava3/core/Observable;", "", "getUnreadMessagesCount", "()Lio/reactivex/rxjava3/core/Observable;", "unreadMessagesCount", "getTotalBadgeCount", "totalBadgeCount", "getFavoritesCount", "favoritesCount", "getUnreadNotificationsCount", "unreadNotificationsCount", "getSavedSearchesCount", "savedSearchesCount", "getExpiredAdvertsCount", "expiredAdvertsCount", "", "isLogged", "()Z", "Lcom/avito/android/remote/model/ProfileInfo;", "getProfileInfo", "profileInfo", "getFavoriteSellersCount", "favoriteSellersCount", "core_release"}, k = 1, mv = {1, 4, 2})
public interface UserProfileStatusDataProvider {
    @NotNull
    Observable<Integer> getExpiredAdvertsCount();

    @NotNull
    Observable<Integer> getFavoriteSellersCount();

    @NotNull
    Observable<Integer> getFavoritesCount();

    @NotNull
    Observable<ProfileInfo> getProfileInfo();

    @NotNull
    Observable<Integer> getSavedSearchesCount();

    @NotNull
    Observable<Integer> getTotalBadgeCount();

    @NotNull
    Observable<Integer> getUnreadMessagesCount();

    @NotNull
    Observable<Integer> getUnreadNotificationsCount();

    boolean isLogged();

    void updateUnreadMessagesAndExpiredAdverts();

    void updateUserFavoritesCounters();
}
