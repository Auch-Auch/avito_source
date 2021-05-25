package com.avito.android.booking.info;

import com.avito.android.booking.remote.model.BookingInfoModel;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/booking/info/BookingInfoInteractor;", "", "", "itemId", BookingInfoActivity.EXTRA_FROM_BLOCK, "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/booking/remote/model/BookingInfoModel;", "loadBookingInfo", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "booking_release"}, k = 1, mv = {1, 4, 2})
public interface BookingInfoInteractor {
    @NotNull
    Observable<TypedResult<BookingInfoModel>> loadBookingInfo(@NotNull String str, @NotNull String str2);
}
