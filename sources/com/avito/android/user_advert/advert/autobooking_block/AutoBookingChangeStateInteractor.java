package com.avito.android.user_advert.advert.autobooking_block;

import com.avito.android.booking.remote.BookingApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SimpleMessageResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.user_advert.advert.switcher_block.SwitcherChangeStateInteractor;
import io.reactivex.rxjava3.core.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/user_advert/advert/autobooking_block/AutoBookingChangeStateInteractor;", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherChangeStateInteractor;", "", "itemId", "", "enabled", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/SimpleMessageResult;", "setSwitcherEnabled", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/booking/remote/BookingApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/booking/remote/BookingApi;", "api", "<init>", "(Lcom/avito/android/booking/remote/BookingApi;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class AutoBookingChangeStateInteractor implements SwitcherChangeStateInteractor {
    public final BookingApi a;

    @Inject
    public AutoBookingChangeStateInteractor(@NotNull BookingApi bookingApi) {
        Intrinsics.checkNotNullParameter(bookingApi, "api");
        this.a = bookingApi;
    }

    @Override // com.avito.android.user_advert.advert.switcher_block.SwitcherChangeStateInteractor
    @NotNull
    public Single<TypedResult<SimpleMessageResult>> setSwitcherEnabled(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return this.a.setBookingEnabled(str, z);
    }
}
