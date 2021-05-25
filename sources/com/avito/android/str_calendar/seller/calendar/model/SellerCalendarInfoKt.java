package com.avito.android.str_calendar.seller.calendar.model;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.StrItemBookingSellerCalendarResponse;
import com.avito.android.str_calendar.seller.calendar.model.SellerCalendarInfo;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.android.str_calendar.utils.StrDateUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004*\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/StrItemBookingSellerCalendarResponse;", "Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo;", "convert", "(Lcom/avito/android/remote/model/StrItemBookingSellerCalendarResponse;)Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo;", "", "Lcom/avito/android/remote/model/StrItemBookingSellerCalendarResponse$DateRange;", "Lcom/avito/android/str_calendar/utils/DateRange;", AuthSource.SEND_ABUSE, "(Ljava/util/List;)Ljava/util/List;", "str-calendar_release"}, k = 2, mv = {1, 4, 2})
public final class SellerCalendarInfoKt {
    public static final List<DateRange> a(List<StrItemBookingSellerCalendarResponse.DateRange> list) {
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            arrayList.add(new DateRange(StrDateUtilsKt.convertStrDateToDate(t.getStartDate()), StrDateUtilsKt.convertStrDateToDate(t.getEndDate())));
        }
        return arrayList;
    }

    @NotNull
    public static final SellerCalendarInfo convert(@NotNull StrItemBookingSellerCalendarResponse strItemBookingSellerCalendarResponse) {
        String str;
        List list;
        Intrinsics.checkNotNullParameter(strItemBookingSellerCalendarResponse, "$this$convert");
        List<StrItemBookingSellerCalendarResponse.DateRange> bookedDateRanges = strItemBookingSellerCalendarResponse.getBookedDateRanges();
        List<DateRange> a = bookedDateRanges != null ? a(bookedDateRanges) : CollectionsKt__CollectionsKt.emptyList();
        List<StrItemBookingSellerCalendarResponse.DateRange> unavailableDateRanges = strItemBookingSellerCalendarResponse.getUnavailableDateRanges();
        List<DateRange> a3 = unavailableDateRanges != null ? a(unavailableDateRanges) : CollectionsKt__CollectionsKt.emptyList();
        StrItemBookingSellerCalendarResponse.BaseParameters baseParameters = strItemBookingSellerCalendarResponse.getBaseParameters();
        if (baseParameters == null || (str = baseParameters.getNightPrice()) == null) {
            str = "";
        }
        SellerCalendarInfo.BaseParameters baseParameters2 = new SellerCalendarInfo.BaseParameters(str);
        List<StrItemBookingSellerCalendarResponse.SellerCalendarItem> items = strItemBookingSellerCalendarResponse.getItems();
        if (items != null) {
            list = new ArrayList(e.collectionSizeOrDefault(items, 10));
            for (T t : items) {
                list.add(new SellerCalendarInfo.SellerCalendarItem(StrDateUtilsKt.convertStrDateToDate(t.getDate()), t.getHasEditedParameters(), t.getOverridenNightPrice()));
            }
        } else {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return new SellerCalendarInfo(a, a3, baseParameters2, list);
    }
}
