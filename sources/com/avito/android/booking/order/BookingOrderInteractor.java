package com.avito.android.booking.order;

import com.avito.android.booking.remote.model.BookingOrderCreationResponse;
import com.avito.android.booking.remote.model.BookingOrderResponse;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderInteractor;", "", "", "itemId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/booking/remote/model/BookingOrderResponse;", "loadBookingOrderData", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "email", "Lcom/avito/android/booking/remote/model/BookingOrderCreationResponse;", "createBookingOrder", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "booking_release"}, k = 1, mv = {1, 4, 2})
public interface BookingOrderInteractor {
    @NotNull
    Observable<LoadingState<BookingOrderCreationResponse>> createBookingOrder(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<LoadingState<BookingOrderResponse>> loadBookingOrderData(@NotNull String str);
}
