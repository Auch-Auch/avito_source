package com.avito.android.str_calendar.booking.model;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\nJ\u001a\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u0019\u0010\u000e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\nR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0007¨\u0006&"}, d2 = {"Lcom/avito/android/str_calendar/booking/model/CalendarBookingRestriction;", "", "Ljava/util/Date;", "component1", "()Ljava/util/Date;", "", "component2", "()Z", "", "component3", "()I", "component4", Sort.DATE, "available", "minimalDuration", "maximalDuration", "copy", "(Ljava/util/Date;ZII)Lcom/avito/android/str_calendar/booking/model/CalendarBookingRestriction;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/Date;", "getDate", "d", "I", "getMaximalDuration", "c", "getMinimalDuration", AuthSource.BOOKING_ORDER, "Z", "getAvailable", "<init>", "(Ljava/util/Date;ZII)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class CalendarBookingRestriction {
    @NotNull
    public final Date a;
    public final boolean b;
    public final int c;
    public final int d;

    public CalendarBookingRestriction(@NotNull Date date, boolean z, int i, int i2) {
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        this.a = date;
        this.b = z;
        this.c = i;
        this.d = i2;
    }

    public static /* synthetic */ CalendarBookingRestriction copy$default(CalendarBookingRestriction calendarBookingRestriction, Date date, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            date = calendarBookingRestriction.a;
        }
        if ((i3 & 2) != 0) {
            z = calendarBookingRestriction.b;
        }
        if ((i3 & 4) != 0) {
            i = calendarBookingRestriction.c;
        }
        if ((i3 & 8) != 0) {
            i2 = calendarBookingRestriction.d;
        }
        return calendarBookingRestriction.copy(date, z, i, i2);
    }

    @NotNull
    public final Date component1() {
        return this.a;
    }

    public final boolean component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    public final int component4() {
        return this.d;
    }

    @NotNull
    public final CalendarBookingRestriction copy(@NotNull Date date, boolean z, int i, int i2) {
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        return new CalendarBookingRestriction(date, z, i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarBookingRestriction)) {
            return false;
        }
        CalendarBookingRestriction calendarBookingRestriction = (CalendarBookingRestriction) obj;
        return Intrinsics.areEqual(this.a, calendarBookingRestriction.a) && this.b == calendarBookingRestriction.b && this.c == calendarBookingRestriction.c && this.d == calendarBookingRestriction.d;
    }

    public final boolean getAvailable() {
        return this.b;
    }

    @NotNull
    public final Date getDate() {
        return this.a;
    }

    public final int getMaximalDuration() {
        return this.d;
    }

    public final int getMinimalDuration() {
        return this.c;
    }

    public int hashCode() {
        Date date = this.a;
        int hashCode = (date != null ? date.hashCode() : 0) * 31;
        boolean z = this.b;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return ((((hashCode + i) * 31) + this.c) * 31) + this.d;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("CalendarBookingRestriction(date=");
        L.append(this.a);
        L.append(", available=");
        L.append(this.b);
        L.append(", minimalDuration=");
        L.append(this.c);
        L.append(", maximalDuration=");
        return a.j(L, this.d, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CalendarBookingRestriction(Date date, boolean z, int i, int i2, int i3, j jVar) {
        this(date, z, i, (i3 & 8) != 0 ? Integer.MAX_VALUE : i2);
    }
}
