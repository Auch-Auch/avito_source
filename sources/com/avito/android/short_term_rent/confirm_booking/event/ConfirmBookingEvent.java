package com.avito.android.short_term_rent.confirm_booking.event;

import a2.b.a.a.a;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\tR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/avito/android/short_term_rent/confirm_booking/event/ConfirmBookingEvent;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()I", BookingInfoActivity.EXTRA_ITEM_ID, "checkInDate", "checkOutDate", "guestsCount", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/avito/android/short_term_rent/confirm_booking/event/ConfirmBookingEvent;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getCheckInDate", "c", "getCheckOutDate", "d", "I", "getGuestsCount", AuthSource.SEND_ABUSE, "getAdvertId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class ConfirmBookingEvent {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    public final int d;

    public ConfirmBookingEvent(@NotNull String str, @NotNull String str2, @NotNull String str3, int i) {
        a.Z0(str, BookingInfoActivity.EXTRA_ITEM_ID, str2, "checkInDate", str3, "checkOutDate");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
    }

    public static /* synthetic */ ConfirmBookingEvent copy$default(ConfirmBookingEvent confirmBookingEvent, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = confirmBookingEvent.a;
        }
        if ((i2 & 2) != 0) {
            str2 = confirmBookingEvent.b;
        }
        if ((i2 & 4) != 0) {
            str3 = confirmBookingEvent.c;
        }
        if ((i2 & 8) != 0) {
            i = confirmBookingEvent.d;
        }
        return confirmBookingEvent.copy(str, str2, str3, i);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    public final int component4() {
        return this.d;
    }

    @NotNull
    public final ConfirmBookingEvent copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "checkInDate");
        Intrinsics.checkNotNullParameter(str3, "checkOutDate");
        return new ConfirmBookingEvent(str, str2, str3, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfirmBookingEvent)) {
            return false;
        }
        ConfirmBookingEvent confirmBookingEvent = (ConfirmBookingEvent) obj;
        return Intrinsics.areEqual(this.a, confirmBookingEvent.a) && Intrinsics.areEqual(this.b, confirmBookingEvent.b) && Intrinsics.areEqual(this.c, confirmBookingEvent.c) && this.d == confirmBookingEvent.d;
    }

    @NotNull
    public final String getAdvertId() {
        return this.a;
    }

    @NotNull
    public final String getCheckInDate() {
        return this.b;
    }

    @NotNull
    public final String getCheckOutDate() {
        return this.c;
    }

    public final int getGuestsCount() {
        return this.d;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((hashCode2 + i) * 31) + this.d;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ConfirmBookingEvent(advertId=");
        L.append(this.a);
        L.append(", checkInDate=");
        L.append(this.b);
        L.append(", checkOutDate=");
        L.append(this.c);
        L.append(", guestsCount=");
        return a.j(L, this.d, ")");
    }
}
