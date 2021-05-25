package com.avito.android.booking.order;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderResourceProvider;", "", "", "unknownErrorMessage", "()Ljava/lang/String;", "", "inputDescriptionNormalTextColor", "()I", "inputDescriptionErrorTextColor", "paymentErrorMessage", "booking_release"}, k = 1, mv = {1, 4, 2})
public interface BookingOrderResourceProvider {
    int inputDescriptionErrorTextColor();

    int inputDescriptionNormalTextColor();

    @NotNull
    String paymentErrorMessage();

    @NotNull
    String unknownErrorMessage();
}
