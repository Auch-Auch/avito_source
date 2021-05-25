package com.avito.android.booking.order;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderPresenter;", "", "Lcom/avito/android/booking/order/BookingOrderView;", "view", "", "bindView", "(Lcom/avito/android/booking/order/BookingOrderView;)V", "Lcom/avito/android/booking/order/BookingOrderScreenState;", "state", "resolveScreenState", "(Lcom/avito/android/booking/order/BookingOrderScreenState;)V", "unbindView", "()V", "booking_release"}, k = 1, mv = {1, 4, 2})
public interface BookingOrderPresenter {
    void bindView(@NotNull BookingOrderView bookingOrderView);

    void resolveScreenState(@NotNull BookingOrderScreenState bookingOrderScreenState);

    void unbindView();
}
