package com.avito.android.booking.order;

import com.avito.android.booking.remote.model.BookingConstraint;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/booking/order/BookingOrderInputValidatorImpl;", "Lcom/avito/android/booking/order/BookingOrderInputValidator;", "", "inputText", "", "Lcom/avito/android/booking/remote/model/BookingConstraint;", "constraints", "Lcom/avito/android/booking/order/ValidationResult;", "validate", "(Ljava/lang/CharSequence;Ljava/util/List;)Lcom/avito/android/booking/order/ValidationResult;", "<init>", "()V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingOrderInputValidatorImpl implements BookingOrderInputValidator {
    @Override // com.avito.android.booking.order.BookingOrderInputValidator
    @NotNull
    public ValidationResult validate(@NotNull CharSequence charSequence, @NotNull List<BookingConstraint> list) {
        Intrinsics.checkNotNullParameter(charSequence, "inputText");
        Intrinsics.checkNotNullParameter(list, "constraints");
        for (T t : list) {
            if (!new Regex(t.getPattern()).matches(charSequence)) {
                return new ValidationResult(false, t.getErrorText());
            }
        }
        return new ValidationResult(true, null, 2, null);
    }
}
