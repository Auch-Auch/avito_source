package com.avito.android.str_calendar.seller.calendar.data;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.str_calendar.calendar.view.data.CalendarData;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataConverter;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSource;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller.SellerDayItem;
import com.avito.android.str_calendar.calendar.view.konveyor.items.empty.EmptyItem;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.konveyor.blueprint.Item;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.Relay;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b/\u00100J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0006J\u001d\u0010\u0014\u001a\u00020\u0007*\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0017\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R(\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010$R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010)¨\u00061"}, d2 = {"Lcom/avito/android/str_calendar/seller/calendar/data/SellerCalendarDataSource;", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSource;", "Ljava/util/Date;", Sort.DATE, "", "onItemSelected", "(Ljava/util/Date;)Z", "", "onClearSelection", "()V", "Lcom/avito/android/str_calendar/utils/DateRange;", "getSelectedRange", "()Lcom/avito/android/str_calendar/utils/DateRange;", "getSelectedDate", "()Ljava/util/Date;", "", "positionOfDate", "(Ljava/util/Date;)I", AuthSource.SEND_ABUSE, "selectedDate", "d", "(Ljava/util/Date;Ljava/util/Date;)V", "select", "c", "(Lcom/avito/android/str_calendar/utils/DateRange;Z)V", "Lcom/jakewharton/rxrelay2/Relay;", "", "Lcom/avito/konveyor/blueprint/Item;", "Lcom/jakewharton/rxrelay2/Relay;", "getListItemsObservable", "()Lcom/jakewharton/rxrelay2/Relay;", "listItemsObservable", "Lcom/avito/android/str_calendar/seller/calendar/data/SellerCalendarDayStateProvider;", "e", "Lcom/avito/android/str_calendar/seller/calendar/data/SellerCalendarDayStateProvider;", "stateProvider", "Lcom/avito/android/str_calendar/utils/DateRange;", "selectedRange", AuthSource.BOOKING_ORDER, "Ljava/util/Date;", "", "Ljava/util/List;", "items", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarData;", "calendarData", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataConverter;", "converter", "<init>", "(Lcom/avito/android/str_calendar/calendar/view/data/CalendarData;Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataConverter;Lcom/avito/android/str_calendar/seller/calendar/data/SellerCalendarDayStateProvider;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCalendarDataSource implements CalendarDataSource {
    @NotNull
    public final Relay<List<Item>> a;
    public Date b;
    public DateRange c;
    public final List<Item> d;
    public final SellerCalendarDayStateProvider e;

    public SellerCalendarDataSource(@NotNull CalendarData calendarData, @NotNull CalendarDataConverter calendarDataConverter, @NotNull SellerCalendarDayStateProvider sellerCalendarDayStateProvider) {
        Intrinsics.checkNotNullParameter(calendarData, "calendarData");
        Intrinsics.checkNotNullParameter(calendarDataConverter, "converter");
        Intrinsics.checkNotNullParameter(sellerCalendarDayStateProvider, "stateProvider");
        this.e = sellerCalendarDayStateProvider;
        BehaviorRelay create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create<List<Item>>()");
        this.a = create;
        List<Item> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) calendarDataConverter.convert(calendarData, null, null));
        this.d = mutableList;
        getListItemsObservable().accept(mutableList);
    }

    public static SellerDayItem b(SellerCalendarDataSource sellerCalendarDataSource, SellerDayItem sellerDayItem, Date date, DateRange dateRange, int i) {
        if ((i & 2) != 0) {
            date = null;
        }
        if ((i & 4) != 0) {
            dateRange = null;
        }
        return new SellerDayItem(sellerDayItem.getId(), sellerDayItem.getText(), sellerCalendarDataSource.e.getDayState(sellerDayItem.getDate(), date, dateRange), sellerDayItem.getDate());
    }

    public final boolean a(Date date) {
        Date date2 = this.b;
        if (date2 != null) {
            d(date2, null);
        }
        DateRange dateRange = this.c;
        if (dateRange != null) {
            c(dateRange, false);
        }
        this.c = null;
        d(date, date);
        this.b = date;
        getListItemsObservable().accept(this.d);
        return true;
    }

    public final void c(DateRange dateRange, boolean z) {
        for (int positionOfDate = positionOfDate(dateRange.getStart()); positionOfDate < this.d.size(); positionOfDate++) {
            Item item = this.d.get(positionOfDate);
            DateRange dateRange2 = null;
            if (item instanceof SellerDayItem) {
                SellerDayItem sellerDayItem = (SellerDayItem) item;
                if (sellerDayItem.getDate().compareTo(dateRange.getEndInclusive()) <= 0) {
                    this.d.set(positionOfDate, b(this, sellerDayItem, null, z ? dateRange : null, 2));
                } else {
                    return;
                }
            } else if (item instanceof EmptyItem) {
                EmptyItem emptyItem = (EmptyItem) item;
                if (emptyItem.getNextDate().compareTo(dateRange.getEndInclusive()) <= 0) {
                    List<Item> list = this.d;
                    if (z) {
                        dateRange2 = dateRange;
                    }
                    list.set(positionOfDate, new EmptyItem(emptyItem.getId(), emptyItem.getNextDate(), this.e.getEmptyItemState(emptyItem.getNextDate(), dateRange2)));
                } else {
                    return;
                }
            } else {
                continue;
            }
        }
    }

    public final void d(Date date, Date date2) {
        int positionOfDate = positionOfDate(date);
        Item item = this.d.get(positionOfDate);
        if (item instanceof SellerDayItem) {
            this.d.set(positionOfDate, b(this, (SellerDayItem) item, date2, null, 4));
        }
    }

    @Override // com.avito.android.str_calendar.calendar.view.data.CalendarDataSource
    @Nullable
    public Date getSelectedDate() {
        return this.b;
    }

    @Override // com.avito.android.str_calendar.calendar.view.data.CalendarDataSource
    @Nullable
    public DateRange getSelectedRange() {
        return this.c;
    }

    @Override // com.avito.android.str_calendar.calendar.view.data.CalendarDataSource
    public void onClearSelection() {
        Date date = this.b;
        if (date != null) {
            d(date, null);
        }
        this.b = null;
        DateRange dateRange = this.c;
        if (dateRange != null) {
            c(dateRange, false);
        }
        this.c = null;
        getListItemsObservable().accept(this.d);
    }

    @Override // com.avito.android.str_calendar.calendar.view.data.CalendarDataSource
    public boolean onItemSelected(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        Date date2 = this.b;
        if (date2 == null) {
            a(date);
            return true;
        } else if (date2.compareTo(date) > 0) {
            a(date);
            return true;
        } else if (this.c != null) {
            a(date);
            return true;
        } else if (Intrinsics.areEqual(date2, date)) {
            return false;
        } else {
            Date date3 = this.b;
            if (date3 != null) {
                d(date3, null);
                this.b = null;
            }
            DateRange dateRange = new DateRange(date2, date);
            c(dateRange, true);
            this.c = dateRange;
            getListItemsObservable().accept(this.d);
            return true;
        }
    }

    @Override // com.avito.android.str_calendar.calendar.view.data.CalendarDataSource
    public int positionOfDate(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        int i = 0;
        for (Item item : this.d) {
            if ((item instanceof SellerDayItem) && Intrinsics.areEqual(((SellerDayItem) item).getDate(), date)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // com.avito.android.str_calendar.calendar.view.data.CalendarDataSource
    @NotNull
    public Relay<List<Item>> getListItemsObservable() {
        return this.a;
    }
}
