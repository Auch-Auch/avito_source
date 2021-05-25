package com.avito.android.user_subscribers;

import android.net.Uri;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/user_subscribers/UserSubscribersInteractor;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/user_subscribers/SubscriberList;", "getSubscriberList", "()Lio/reactivex/Observable;", "Landroid/net/Uri;", "nextPage", "(Landroid/net/Uri;)Lio/reactivex/Observable;", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
public interface UserSubscribersInteractor {
    @NotNull
    Observable<SubscriberList> getSubscriberList();

    @NotNull
    Observable<SubscriberList> getSubscriberList(@NotNull Uri uri);
}
