package com.avito.android.short_term_rent.hotels.data;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.hotels.HotelsLocation;
import com.avito.android.str_calendar.utils.DateRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b)\u0010*J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\r\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\n\"\u0004\b\u001d\u0010\u001eR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004\"\u0004\b\"\u0010#R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/data/FiltersData;", "", "Lcom/avito/android/remote/model/hotels/HotelsLocation;", "component1", "()Lcom/avito/android/remote/model/hotels/HotelsLocation;", "Lcom/avito/android/str_calendar/utils/DateRange;", "component2", "()Lcom/avito/android/str_calendar/utils/DateRange;", "Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;", "component3", "()Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;", "location", "dates", "people", "copy", "(Lcom/avito/android/remote/model/hotels/HotelsLocation;Lcom/avito/android/str_calendar/utils/DateRange;Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;)Lcom/avito/android/short_term_rent/hotels/data/FiltersData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;", "getPeople", "setPeople", "(Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/hotels/HotelsLocation;", "getLocation", "setLocation", "(Lcom/avito/android/remote/model/hotels/HotelsLocation;)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/str_calendar/utils/DateRange;", "getDates", "setDates", "(Lcom/avito/android/str_calendar/utils/DateRange;)V", "<init>", "(Lcom/avito/android/remote/model/hotels/HotelsLocation;Lcom/avito/android/str_calendar/utils/DateRange;Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class FiltersData {
    @Nullable
    public HotelsLocation a;
    @NotNull
    public DateRange b;
    @NotNull
    public BookingPeople c;

    public FiltersData(@Nullable HotelsLocation hotelsLocation, @NotNull DateRange dateRange, @NotNull BookingPeople bookingPeople) {
        Intrinsics.checkNotNullParameter(dateRange, "dates");
        Intrinsics.checkNotNullParameter(bookingPeople, "people");
        this.a = hotelsLocation;
        this.b = dateRange;
        this.c = bookingPeople;
    }

    public static /* synthetic */ FiltersData copy$default(FiltersData filtersData, HotelsLocation hotelsLocation, DateRange dateRange, BookingPeople bookingPeople, int i, Object obj) {
        if ((i & 1) != 0) {
            hotelsLocation = filtersData.a;
        }
        if ((i & 2) != 0) {
            dateRange = filtersData.b;
        }
        if ((i & 4) != 0) {
            bookingPeople = filtersData.c;
        }
        return filtersData.copy(hotelsLocation, dateRange, bookingPeople);
    }

    @Nullable
    public final HotelsLocation component1() {
        return this.a;
    }

    @NotNull
    public final DateRange component2() {
        return this.b;
    }

    @NotNull
    public final BookingPeople component3() {
        return this.c;
    }

    @NotNull
    public final FiltersData copy(@Nullable HotelsLocation hotelsLocation, @NotNull DateRange dateRange, @NotNull BookingPeople bookingPeople) {
        Intrinsics.checkNotNullParameter(dateRange, "dates");
        Intrinsics.checkNotNullParameter(bookingPeople, "people");
        return new FiltersData(hotelsLocation, dateRange, bookingPeople);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FiltersData)) {
            return false;
        }
        FiltersData filtersData = (FiltersData) obj;
        return Intrinsics.areEqual(this.a, filtersData.a) && Intrinsics.areEqual(this.b, filtersData.b) && Intrinsics.areEqual(this.c, filtersData.c);
    }

    @NotNull
    public final DateRange getDates() {
        return this.b;
    }

    @Nullable
    public final HotelsLocation getLocation() {
        return this.a;
    }

    @NotNull
    public final BookingPeople getPeople() {
        return this.c;
    }

    public int hashCode() {
        HotelsLocation hotelsLocation = this.a;
        int i = 0;
        int hashCode = (hotelsLocation != null ? hotelsLocation.hashCode() : 0) * 31;
        DateRange dateRange = this.b;
        int hashCode2 = (hashCode + (dateRange != null ? dateRange.hashCode() : 0)) * 31;
        BookingPeople bookingPeople = this.c;
        if (bookingPeople != null) {
            i = bookingPeople.hashCode();
        }
        return hashCode2 + i;
    }

    public final void setDates(@NotNull DateRange dateRange) {
        Intrinsics.checkNotNullParameter(dateRange, "<set-?>");
        this.b = dateRange;
    }

    public final void setLocation(@Nullable HotelsLocation hotelsLocation) {
        this.a = hotelsLocation;
    }

    public final void setPeople(@NotNull BookingPeople bookingPeople) {
        Intrinsics.checkNotNullParameter(bookingPeople, "<set-?>");
        this.c = bookingPeople;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("FiltersData(location=");
        L.append(this.a);
        L.append(", dates=");
        L.append(this.b);
        L.append(", people=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }
}
