package com.avito.android.str_calendar.seller.calendar.data;

import com.avito.android.str_calendar.calendar.view.data.CalendarData;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataBuilderImpl;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSource;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSourceProvider;
import com.avito.android.str_calendar.seller.calendar.model.SellerCalendarInfo;
import com.avito.android.str_calendar.utils.DateRange;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/str_calendar/seller/calendar/data/SellerCalendarDataSourceProvider;", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo;", "data", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSource;", "getDataSource", "(Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo;)Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSource;", "<init>", "()V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCalendarDataSourceProvider implements CalendarDataSourceProvider<SellerCalendarInfo> {
    @NotNull
    public CalendarDataSource getDataSource(@NotNull SellerCalendarInfo sellerCalendarInfo) {
        Intrinsics.checkNotNullParameter(sellerCalendarInfo, "data");
        CalendarData build = new CalendarDataBuilderImpl(new DateRange(((SellerCalendarInfo.SellerCalendarItem) CollectionsKt___CollectionsKt.first((List<? extends Object>) sellerCalendarInfo.getItems())).getDate(), ((SellerCalendarInfo.SellerCalendarItem) CollectionsKt___CollectionsKt.last((List<? extends Object>) sellerCalendarInfo.getItems())).getDate())).build();
        SellerCalendarDayStateProviderImpl sellerCalendarDayStateProviderImpl = new SellerCalendarDayStateProviderImpl(sellerCalendarInfo, build);
        return new SellerCalendarDataSource(build, new SellerCalendarDataConverter(sellerCalendarDayStateProviderImpl), sellerCalendarDayStateProviderImpl);
    }
}
