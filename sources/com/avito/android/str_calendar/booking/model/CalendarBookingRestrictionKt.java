package com.avito.android.str_calendar.booking.model;

import com.avito.android.remote.model.StrItemBookingRestriction;
import com.avito.android.str_calendar.utils.StrDateUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/StrItemBookingRestriction;", "Lcom/avito/android/str_calendar/booking/model/CalendarBookingRestriction;", "convert", "(Lcom/avito/android/remote/model/StrItemBookingRestriction;)Lcom/avito/android/str_calendar/booking/model/CalendarBookingRestriction;", "str-calendar_release"}, k = 2, mv = {1, 4, 2})
public final class CalendarBookingRestrictionKt {
    @NotNull
    public static final CalendarBookingRestriction convert(@NotNull StrItemBookingRestriction strItemBookingRestriction) {
        Intrinsics.checkNotNullParameter(strItemBookingRestriction, "$this$convert");
        return new CalendarBookingRestriction(StrDateUtilsKt.convertStrDateToDate(strItemBookingRestriction.getDate()), strItemBookingRestriction.getAvailable(), strItemBookingRestriction.getMinimalDuration(), 0, 8, null);
    }
}
