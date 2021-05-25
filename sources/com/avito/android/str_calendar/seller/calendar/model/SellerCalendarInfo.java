package com.avito.android.str_calendar.seller.calendar.model;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.str_calendar.utils.DateRange;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B9\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0002\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0002\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo;", "", "", "Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo$SellerCalendarItem;", "d", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "Lcom/avito/android/str_calendar/utils/DateRange;", AuthSource.SEND_ABUSE, "getBookedDateRanges", "bookedDateRanges", "Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo$BaseParameters;", "c", "Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo$BaseParameters;", "getBaseParameters", "()Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo$BaseParameters;", "baseParameters", AuthSource.BOOKING_ORDER, "getUnavailableDateRanges", "unavailableDateRanges", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo$BaseParameters;Ljava/util/List;)V", "BaseParameters", "SellerCalendarItem", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCalendarInfo {
    @NotNull
    public final List<DateRange> a;
    @NotNull
    public final List<DateRange> b;
    @NotNull
    public final BaseParameters c;
    @NotNull
    public final List<SellerCalendarItem> d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo$BaseParameters;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getNightPrice", "()Ljava/lang/String;", "nightPrice", "<init>", "(Ljava/lang/String;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
    public static final class BaseParameters {
        @NotNull
        public final String a;

        public BaseParameters(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "nightPrice");
            this.a = str;
        }

        @NotNull
        public final String getNightPrice() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/str_calendar/seller/calendar/model/SellerCalendarInfo$SellerCalendarItem;", "", "", "c", "Ljava/lang/String;", "getOverridenNightPrice", "()Ljava/lang/String;", "overridenNightPrice", "Ljava/util/Date;", AuthSource.SEND_ABUSE, "Ljava/util/Date;", "getDate", "()Ljava/util/Date;", Sort.DATE, "", AuthSource.BOOKING_ORDER, "Z", "getHasEditedParameters", "()Z", "hasEditedParameters", "<init>", "(Ljava/util/Date;ZLjava/lang/String;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
    public static final class SellerCalendarItem {
        @NotNull
        public final Date a;
        public final boolean b;
        @Nullable
        public final String c;

        public SellerCalendarItem(@NotNull Date date, boolean z, @Nullable String str) {
            Intrinsics.checkNotNullParameter(date, Sort.DATE);
            this.a = date;
            this.b = z;
            this.c = str;
        }

        @NotNull
        public final Date getDate() {
            return this.a;
        }

        public final boolean getHasEditedParameters() {
            return this.b;
        }

        @Nullable
        public final String getOverridenNightPrice() {
            return this.c;
        }
    }

    public SellerCalendarInfo(@NotNull List<DateRange> list, @NotNull List<DateRange> list2, @NotNull BaseParameters baseParameters, @NotNull List<SellerCalendarItem> list3) {
        Intrinsics.checkNotNullParameter(list, "bookedDateRanges");
        Intrinsics.checkNotNullParameter(list2, "unavailableDateRanges");
        Intrinsics.checkNotNullParameter(baseParameters, "baseParameters");
        Intrinsics.checkNotNullParameter(list3, "items");
        this.a = list;
        this.b = list2;
        this.c = baseParameters;
        this.d = list3;
    }

    @NotNull
    public final BaseParameters getBaseParameters() {
        return this.c;
    }

    @NotNull
    public final List<DateRange> getBookedDateRanges() {
        return this.a;
    }

    @NotNull
    public final List<SellerCalendarItem> getItems() {
        return this.d;
    }

    @NotNull
    public final List<DateRange> getUnavailableDateRanges() {
        return this.b;
    }
}
