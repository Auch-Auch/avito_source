package com.avito.android.short_term_rent.hotels.data;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.utils.DateRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/data/HotelsCalendarRestrictions;", "", "Lcom/avito/android/str_calendar/utils/DateRange;", "component1", "()Lcom/avito/android/str_calendar/utils/DateRange;", "", "component2", "()I", "datesRestrictions", "maxLengthRestriction", "copy", "(Lcom/avito/android/str_calendar/utils/DateRange;I)Lcom/avito/android/short_term_rent/hotels/data/HotelsCalendarRestrictions;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "I", "getMaxLengthRestriction", AuthSource.SEND_ABUSE, "Lcom/avito/android/str_calendar/utils/DateRange;", "getDatesRestrictions", "<init>", "(Lcom/avito/android/str_calendar/utils/DateRange;I)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class HotelsCalendarRestrictions {
    @NotNull
    public final DateRange a;
    public final int b;

    public HotelsCalendarRestrictions(@NotNull DateRange dateRange, int i) {
        Intrinsics.checkNotNullParameter(dateRange, "datesRestrictions");
        this.a = dateRange;
        this.b = i;
    }

    public static /* synthetic */ HotelsCalendarRestrictions copy$default(HotelsCalendarRestrictions hotelsCalendarRestrictions, DateRange dateRange, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            dateRange = hotelsCalendarRestrictions.a;
        }
        if ((i2 & 2) != 0) {
            i = hotelsCalendarRestrictions.b;
        }
        return hotelsCalendarRestrictions.copy(dateRange, i);
    }

    @NotNull
    public final DateRange component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @NotNull
    public final HotelsCalendarRestrictions copy(@NotNull DateRange dateRange, int i) {
        Intrinsics.checkNotNullParameter(dateRange, "datesRestrictions");
        return new HotelsCalendarRestrictions(dateRange, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HotelsCalendarRestrictions)) {
            return false;
        }
        HotelsCalendarRestrictions hotelsCalendarRestrictions = (HotelsCalendarRestrictions) obj;
        return Intrinsics.areEqual(this.a, hotelsCalendarRestrictions.a) && this.b == hotelsCalendarRestrictions.b;
    }

    @NotNull
    public final DateRange getDatesRestrictions() {
        return this.a;
    }

    public final int getMaxLengthRestriction() {
        return this.b;
    }

    public int hashCode() {
        DateRange dateRange = this.a;
        return ((dateRange != null ? dateRange.hashCode() : 0) * 31) + this.b;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("HotelsCalendarRestrictions(datesRestrictions=");
        L.append(this.a);
        L.append(", maxLengthRestriction=");
        return a.j(L, this.b, ")");
    }
}
