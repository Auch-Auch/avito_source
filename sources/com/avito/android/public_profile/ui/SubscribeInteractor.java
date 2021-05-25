package com.avito.android.public_profile.ui;

import com.avito.android.public_profile.remote.model.SubscribeInfo;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/public_profile/ui/SubscribeInteractor;", "", "", "userKey", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "subscribe", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "unsubscribe", "", "needActivate", "Lio/reactivex/rxjava3/core/Completable;", "changeNotifications", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Completable;", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public interface SubscribeInteractor {
    @NotNull
    Completable changeNotifications(@NotNull String str, boolean z);

    @NotNull
    Single<SubscribeInfo> subscribe(@NotNull String str);

    @NotNull
    Single<SubscribeInfo> unsubscribe(@NotNull String str);
}
