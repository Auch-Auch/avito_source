package com.avito.android.short_term_rent.hotels.data;

import com.avito.android.remote.model.hotels.Dates;
import com.avito.android.remote.model.hotels.HotelsLocation;
import com.avito.android.str_calendar.calendar.utils.CalendarUtilsKt;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.android.str_calendar.utils.StrDateUtilsKt;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\u000b\u001a\u00020\n*\u00020\t¢\u0006\u0004\b\u000b\u0010\f\u001a\u0011\u0010\r\u001a\u00020\n*\u00020\t¢\u0006\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/data/FiltersData;", "", "", "toFieldMap", "(Lcom/avito/android/short_term_rent/hotels/data/FiltersData;)Ljava/util/Map;", "Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;", "", "calculateGuests", "(Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;)I", "Lcom/avito/android/remote/model/hotels/Dates;", "Lcom/avito/android/str_calendar/utils/DateRange;", "toDateRange", "(Lcom/avito/android/remote/model/hotels/Dates;)Lcom/avito/android/str_calendar/utils/DateRange;", "toRestrictionsRange", "short-term-rent_release"}, k = 2, mv = {1, 4, 2})
public final class FiltersDataKt {
    public static final int calculateGuests(@NotNull BookingPeople bookingPeople) {
        Intrinsics.checkNotNullParameter(bookingPeople, "$this$calculateGuests");
        return bookingPeople.getChildren().size() + bookingPeople.getAdults();
    }

    @NotNull
    public static final DateRange toDateRange(@NotNull Dates dates) {
        Intrinsics.checkNotNullParameter(dates, "$this$toDateRange");
        Date time = CalendarUtilsKt.getCalendar(dates.getFrom()).getTime();
        Intrinsics.checkNotNullExpressionValue(time, "getCalendar(from).time");
        Date time2 = CalendarUtilsKt.getCalendar(dates.getTo()).getTime();
        Intrinsics.checkNotNullExpressionValue(time2, "getCalendar(to).time");
        return new DateRange(time, time2);
    }

    @NotNull
    public static final Map<String, String> toFieldMap(@NotNull FiltersData filtersData) {
        Intrinsics.checkNotNullParameter(filtersData, "$this$toFieldMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HotelsLocation location = filtersData.getLocation();
        if (location != null) {
            linkedHashMap.put("locationId", String.valueOf(location.getId()));
            linkedHashMap.put("type", location.getType());
            linkedHashMap.put("name", location.getName());
        }
        linkedHashMap.put("from", StrDateUtilsKt.convertToStrDate(filtersData.getDates().getStart()));
        linkedHashMap.put("to", StrDateUtilsKt.convertToStrDate(filtersData.getDates().getEndInclusive()));
        linkedHashMap.put("rooms", "1");
        linkedHashMap.put("adults", String.valueOf(filtersData.getPeople().getAdults()));
        int i = 0;
        for (T t : filtersData.getPeople().getChildren()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            linkedHashMap.put("children[" + i + ']', String.valueOf(t.getValue()));
            i = i2;
        }
        return linkedHashMap;
    }

    @NotNull
    public static final DateRange toRestrictionsRange(@NotNull Dates dates) {
        Intrinsics.checkNotNullParameter(dates, "$this$toRestrictionsRange");
        Date time = CalendarUtilsKt.getCalendar(dates.getFromLowerBound()).getTime();
        Intrinsics.checkNotNullExpressionValue(time, "getCalendar(fromLowerBound).time");
        Date time2 = CalendarUtilsKt.getCalendar(dates.getToUpperBound()).getTime();
        Intrinsics.checkNotNullExpressionValue(time2, "getCalendar(toUpperBound).time");
        return new DateRange(time, time2);
    }
}
