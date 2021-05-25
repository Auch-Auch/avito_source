package com.avito.android.user_subscribers;

import com.avito.android.user_subscribers.adapter.UserSubscriberItem;
import com.avito.konveyor.data_source.DataSource;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/user_subscribers/UserSubscribersView;", "", "Lio/reactivex/Observable;", "", "refreshClicks", "()Lio/reactivex/Observable;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/user_subscribers/adapter/UserSubscriberItem;", "dataSource", "setItems", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "show", "showEmptyState", "(Z)V", "hideRefreshProgress", "()V", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
public interface UserSubscribersView {
    void hideRefreshProgress();

    @NotNull
    Observable<Unit> refreshClicks();

    void setItems(@NotNull DataSource<UserSubscriberItem> dataSource);

    void showEmptyState(boolean z);
}
