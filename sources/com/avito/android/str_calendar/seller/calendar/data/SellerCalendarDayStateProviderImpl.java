package com.avito.android.str_calendar.seller.calendar.data;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.calendar.utils.CalendarUtilsKt;
import com.avito.android.str_calendar.calendar.view.data.CalendarData;
import com.avito.android.str_calendar.calendar.view.data.items.CalendarItem;
import com.avito.android.str_calendar.calendar.view.data.items.CalendarItemState;
import com.avito.android.str_calendar.calendar.view.data.items.CalendarMonth;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.Position;
import com.avito.android.str_calendar.seller.calendar.model.SellerCalendarInfo;
import com.avito.android.str_calendar.utils.DateRange;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J!\u0010\u001b\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001dR\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010 R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001dR\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010#¨\u0006)"}, d2 = {"Lcom/avito/android/str_calendar/seller/calendar/data/SellerCalendarDayStateProviderImpl;", "Lcom/avito/android/str_calendar/seller/calendar/data/SellerCalendarDayStateProvider;", "Ljava/util/Date;", "day", "selectedDate", "Lcom/avito/android/str_calendar/utils/DateRange;", "selectedRange", "Lcom/avito/android/str_calendar/seller/calendar/data/SellerDayItemState;", "getDayState", "(Ljava/util/Date;Ljava/util/Date;Lcom/avito/android/str_calendar/utils/DateRange;)Lcom/avito/android/str_calendar/seller/calendar/data/SellerDayItemState;", "nextDate", "Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;", "getEmptyItemState", "(Ljava/util/Date;Lcom/avito/android/str_calendar/utils/DateRange;)Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;", "Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo;", "calendarInfo", "Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo$SellerCalendarItem;", "dayItem", "dayDate", "d", "(Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo;Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo$SellerCalendarItem;Ljava/util/Date;)Lcom/avito/android/str_calendar/seller/calendar/data/SellerDayItemState;", "", "", AuthSource.SEND_ABUSE, "(Ljava/util/List;Ljava/util/Date;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/Position;", "c", "(Ljava/util/List;Ljava/util/Date;)Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/Position;", "Ljava/util/List;", "unavailableRanges", "", "Ljava/util/Map;", "dayStates", "bookedRanges", "Ljava/util/Date;", "currentDate", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarData;", "calendarData", "<init>", "(Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo;Lcom/avito/android/str_calendar/calendar/view/data/CalendarData;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCalendarDayStateProviderImpl implements SellerCalendarDayStateProvider {
    public final List<DateRange> a;
    public final List<DateRange> b;
    public final Date c;
    public final Map<Date, SellerDayItemState> d = new LinkedHashMap();

    public SellerCalendarDayStateProviderImpl(@NotNull SellerCalendarInfo sellerCalendarInfo, @NotNull CalendarData calendarData) {
        Intrinsics.checkNotNullParameter(sellerCalendarInfo, "calendarInfo");
        Intrinsics.checkNotNullParameter(calendarData, "calendarData");
        this.a = sellerCalendarInfo.getBookedDateRanges();
        this.b = sellerCalendarInfo.getUnavailableDateRanges();
        Date time = CalendarUtilsKt.getCalendar().getTime();
        Intrinsics.checkNotNullExpressionValue(time, "getCalendar().time");
        this.c = time;
        for (T t : sellerCalendarInfo.getItems()) {
            Date date = t.getDate();
            this.d.put(date, d(sellerCalendarInfo, t, date));
        }
        for (T t2 : ((CalendarMonth) CollectionsKt___CollectionsKt.first((List<? extends Object>) calendarData.getMonths())).getItems()) {
            if (t2 instanceof CalendarItem.Item) {
                Date date2 = t2.getDate();
                if (this.d.get(date2) == null) {
                    this.d.put(date2, d(sellerCalendarInfo, null, date2));
                }
            }
        }
    }

    public final boolean a(List<DateRange> list, Date date) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().contains(date)) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(List<DateRange> list, Date date) {
        boolean z;
        Iterator<T> it = list.iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            T next = it.next();
            if (date.compareTo(next.getStart()) > 0 && date.compareTo(next.getEndInclusive()) <= 0) {
                z = true;
                continue;
            }
        } while (!z);
        return true;
    }

    public final Position c(List<DateRange> list, Date date) {
        for (T t : list) {
            if (t.contains(date)) {
                if (Intrinsics.areEqual(t.getStart(), date) && Intrinsics.areEqual(t.getEndInclusive(), date)) {
                    return Position.SINGLE;
                }
                if (Intrinsics.areEqual(t.getStart(), date)) {
                    return Position.LEFT;
                }
                if (Intrinsics.areEqual(t.getEndInclusive(), date)) {
                    return Position.RIGHT;
                }
                if (t.getStart().compareTo(date) < 0 && t.getEndInclusive().compareTo(date) > 0) {
                    return Position.MIDDLE;
                }
                throw new IllegalStateException("Day not belongs to range");
            }
        }
        throw new IllegalStateException("Day not found in ranges");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0025, code lost:
        if (r11 != null) goto L_0x0032;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.avito.android.str_calendar.seller.calendar.data.SellerDayItemState d(com.avito.android.str_calendar.seller.calendar.model.SellerCalendarInfo r11, com.avito.android.str_calendar.seller.calendar.model.SellerCalendarInfo.SellerCalendarItem r12, java.util.Date r13) {
        /*
            r10 = this;
            com.avito.android.str_calendar.seller.calendar.data.SellerDayItemState r9 = new com.avito.android.str_calendar.seller.calendar.data.SellerDayItemState
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 63
            r8 = 0
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            java.lang.String r0 = ""
            if (r12 != 0) goto L_0x0014
            goto L_0x0028
        L_0x0014:
            boolean r1 = r12.getHasEditedParameters()
            r9.setHasEditedParameters(r1)
            boolean r1 = r9.getHasEditedParameters()
            if (r1 == 0) goto L_0x002a
            java.lang.String r11 = r12.getOverridenNightPrice()
            if (r11 == 0) goto L_0x0028
            goto L_0x0032
        L_0x0028:
            r11 = r0
            goto L_0x0032
        L_0x002a:
            com.avito.android.str_calendar.seller.calendar.model.SellerCalendarInfo$BaseParameters r11 = r11.getBaseParameters()
            java.lang.String r11 = r11.getNightPrice()
        L_0x0032:
            r9.setNightPrice(r11)
            java.util.Date r11 = r10.c
            int r11 = r11.compareTo(r13)
            if (r11 <= 0) goto L_0x003f
            r11 = 1
            goto L_0x0040
        L_0x003f:
            r11 = 0
        L_0x0040:
            if (r11 == 0) goto L_0x004b
            com.avito.android.str_calendar.seller.calendar.data.Status r11 = com.avito.android.str_calendar.seller.calendar.data.Status.PAST
            r9.setPrimaryStatus(r11)
            r9.setNightPrice(r0)
            goto L_0x0078
        L_0x004b:
            java.util.List<com.avito.android.str_calendar.utils.DateRange> r11 = r10.a
            boolean r11 = r10.a(r11, r13)
            if (r11 == 0) goto L_0x0062
            com.avito.android.str_calendar.seller.calendar.data.Status r11 = com.avito.android.str_calendar.seller.calendar.data.Status.BOOKED
            r9.setPrimaryStatus(r11)
            java.util.List<com.avito.android.str_calendar.utils.DateRange> r11 = r10.a
            com.avito.android.str_calendar.calendar.view.konveyor.items.day.Position r11 = r10.c(r11, r13)
            r9.setPrimaryPosition(r11)
            goto L_0x0078
        L_0x0062:
            java.util.List<com.avito.android.str_calendar.utils.DateRange> r11 = r10.b
            boolean r11 = r10.a(r11, r13)
            if (r11 == 0) goto L_0x0078
            com.avito.android.str_calendar.seller.calendar.data.Status r11 = com.avito.android.str_calendar.seller.calendar.data.Status.UNAVAILABLE
            r9.setPrimaryStatus(r11)
            java.util.List<com.avito.android.str_calendar.utils.DateRange> r11 = r10.b
            com.avito.android.str_calendar.calendar.view.konveyor.items.day.Position r11 = r10.c(r11, r13)
            r9.setPrimaryPosition(r11)
        L_0x0078:
            java.util.Date r11 = r10.c
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r13)
            if (r11 == 0) goto L_0x008a
            com.avito.android.str_calendar.seller.calendar.data.Status r11 = com.avito.android.str_calendar.seller.calendar.data.Status.CURRENT
            r9.setSecondaryStatus(r11)
            com.avito.android.str_calendar.calendar.view.konveyor.items.day.Position r11 = com.avito.android.str_calendar.calendar.view.konveyor.items.day.Position.SINGLE
            r9.setSecondaryPosition(r11)
        L_0x008a:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.str_calendar.seller.calendar.data.SellerCalendarDayStateProviderImpl.d(com.avito.android.str_calendar.seller.calendar.model.SellerCalendarInfo, com.avito.android.str_calendar.seller.calendar.model.SellerCalendarInfo$SellerCalendarItem, java.util.Date):com.avito.android.str_calendar.seller.calendar.data.SellerDayItemState");
    }

    @Override // com.avito.android.str_calendar.seller.calendar.data.SellerCalendarDayStateProvider
    @NotNull
    public SellerDayItemState getDayState(@NotNull Date date, @Nullable Date date2, @Nullable DateRange dateRange) {
        Position position;
        Intrinsics.checkNotNullParameter(date, "day");
        SellerDayItemState sellerDayItemState = this.d.get(date);
        if (sellerDayItemState != null) {
            if (date2 != null && Intrinsics.areEqual(date2, date)) {
                sellerDayItemState = SellerDayItemState.copy$default(sellerDayItemState, null, null, null, null, false, null, 63, null);
                sellerDayItemState.setSecondaryStatus(Status.SELECTED);
                sellerDayItemState.setSecondaryPosition(Position.SINGLE);
            }
            SellerDayItemState sellerDayItemState2 = sellerDayItemState;
            if (dateRange != null && dateRange.contains(date)) {
                sellerDayItemState2 = SellerDayItemState.copy$default(sellerDayItemState2, null, null, null, null, false, null, 63, null);
                sellerDayItemState2.setSecondaryStatus(Status.SELECTED);
                if (Intrinsics.areEqual(date, dateRange.getStart())) {
                    position = Position.LEFT;
                } else if (Intrinsics.areEqual(date, dateRange.getEndInclusive())) {
                    position = Position.RIGHT;
                } else {
                    position = Position.MIDDLE;
                }
                sellerDayItemState2.setSecondaryPosition(position);
            }
            return sellerDayItemState2;
        }
        throw new IllegalStateException("Attempt to get state of unknown day " + date);
    }

    @Override // com.avito.android.str_calendar.seller.calendar.data.SellerCalendarDayStateProvider
    @NotNull
    public CalendarItemState getEmptyItemState(@NotNull Date date, @Nullable DateRange dateRange) {
        Intrinsics.checkNotNullParameter(date, "nextDate");
        if (dateRange != null && dateRange.contains(date) && (!Intrinsics.areEqual(dateRange.getStart(), date))) {
            return CalendarItemState.SELECTED;
        }
        if (b(this.a, date)) {
            return CalendarItemState.BOOKED_SELLER;
        }
        if (b(this.b, date)) {
            return CalendarItemState.UNAVAILABLE_SELLER;
        }
        return CalendarItemState.NORMAL;
    }
}
