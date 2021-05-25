package com.avito.android.advert_core.messenger;

import com.avito.android.booking.info.BookingInfoActivity;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.Channel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractor;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/rxjava3/core/Single;", "", "notifySellerAboutCall", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "source", "Lru/avito/messenger/api/entity/Channel;", "createChat", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertMessengerInteractor {
    @NotNull
    Single<Channel> createChat(@NotNull String str, @Nullable String str2);

    @NotNull
    Single<Boolean> notifySellerAboutCall(@NotNull String str);
}
