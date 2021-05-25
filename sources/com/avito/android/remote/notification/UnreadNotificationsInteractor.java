package com.avito.android.remote.notification;

import com.avito.android.analytics.event.SavedSearchesCounter;
import com.avito.android.remote.model.messenger.UnreadMessagesCounter;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H&¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/notification/UnreadNotificationsInteractor;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/analytics/event/SavedSearchesCounter;", "savedSearchesCount", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/messenger/UnreadMessagesCounter;", "unreadMessagesCount", "Lcom/avito/android/remote/notification/AdvertsCount;", "expiredAdvertsCount", "", "update", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface UnreadNotificationsInteractor {
    @NotNull
    Observable<AdvertsCount> expiredAdvertsCount();

    @NotNull
    Observable<SavedSearchesCounter> savedSearchesCount();

    @NotNull
    Observable<UnreadMessagesCounter> unreadMessagesCount();

    void update();
}
