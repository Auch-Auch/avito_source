package com.avito.android.short_term_rent.hotels.data;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.hotels.Age;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\u0019R(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;", "", "", "component1", "()I", "", "Lcom/avito/android/remote/model/hotels/Age;", "component2", "()Ljava/util/List;", "adults", "children", "copy", "(ILjava/util/List;)Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getAdults", "setAdults", "(I)V", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getChildren", "setChildren", "(Ljava/util/List;)V", "<init>", "(ILjava/util/List;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class BookingPeople {
    public int a;
    @NotNull
    public List<Age> b;

    public BookingPeople(int i, @NotNull List<Age> list) {
        Intrinsics.checkNotNullParameter(list, "children");
        this.a = i;
        this.b = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.short_term_rent.hotels.data.BookingPeople */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BookingPeople copy$default(BookingPeople bookingPeople, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bookingPeople.a;
        }
        if ((i2 & 2) != 0) {
            list = bookingPeople.b;
        }
        return bookingPeople.copy(i, list);
    }

    public final int component1() {
        return this.a;
    }

    @NotNull
    public final List<Age> component2() {
        return this.b;
    }

    @NotNull
    public final BookingPeople copy(int i, @NotNull List<Age> list) {
        Intrinsics.checkNotNullParameter(list, "children");
        return new BookingPeople(i, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BookingPeople)) {
            return false;
        }
        BookingPeople bookingPeople = (BookingPeople) obj;
        return this.a == bookingPeople.a && Intrinsics.areEqual(this.b, bookingPeople.b);
    }

    public final int getAdults() {
        return this.a;
    }

    @NotNull
    public final List<Age> getChildren() {
        return this.b;
    }

    public int hashCode() {
        int i = this.a * 31;
        List<Age> list = this.b;
        return i + (list != null ? list.hashCode() : 0);
    }

    public final void setAdults(int i) {
        this.a = i;
    }

    public final void setChildren(@NotNull List<Age> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.b = list;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("BookingPeople(adults=");
        L.append(this.a);
        L.append(", children=");
        return a.w(L, this.b, ")");
    }
}
