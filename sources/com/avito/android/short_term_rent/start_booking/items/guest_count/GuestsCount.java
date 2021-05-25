package com.avito.android.short_term_rent.start_booking.items.guest_count;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCount;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "count", "title", "copy", "(ILjava/lang/String;)Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCount;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getCount", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "<init>", "(ILjava/lang/String;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class GuestsCount {
    public final int a;
    @NotNull
    public final String b;

    public GuestsCount(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a = i;
        this.b = str;
    }

    public static /* synthetic */ GuestsCount copy$default(GuestsCount guestsCount, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = guestsCount.a;
        }
        if ((i2 & 2) != 0) {
            str = guestsCount.b;
        }
        return guestsCount.copy(i, str);
    }

    public final int component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final GuestsCount copy(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new GuestsCount(i, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GuestsCount)) {
            return false;
        }
        GuestsCount guestsCount = (GuestsCount) obj;
        return this.a == guestsCount.a && Intrinsics.areEqual(this.b, guestsCount.b);
    }

    public final int getCount() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    public int hashCode() {
        int i = this.a * 31;
        String str = this.b;
        return i + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("GuestsCount(count=");
        L.append(this.a);
        L.append(", title=");
        return a.t(L, this.b, ")");
    }
}
