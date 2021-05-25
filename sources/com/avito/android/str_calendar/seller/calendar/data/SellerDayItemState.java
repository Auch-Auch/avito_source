package com.avito.android.str_calendar.seller.calendar.data;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.Position;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b$\b\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJL\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000fJ\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004\"\u0004\b\"\u0010#R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\u0004\"\u0004\b&\u0010#R\"\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010+R\"\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\f\"\u0004\b/\u00100R\"\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u00105R\u0013\u00107\u001a\u00020\n8F@\u0006¢\u0006\u0006\u001a\u0004\b6\u0010\fR\"\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b8\u0010(\u001a\u0004\b9\u0010\u0007\"\u0004\b:\u0010+¨\u0006="}, d2 = {"Lcom/avito/android/str_calendar/seller/calendar/data/SellerDayItemState;", "", "Lcom/avito/android/str_calendar/seller/calendar/data/Status;", "component1", "()Lcom/avito/android/str_calendar/seller/calendar/data/Status;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/Position;", "component2", "()Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/Position;", "component3", "component4", "", "component5", "()Z", "", "component6", "()Ljava/lang/String;", "primaryStatus", "primaryPosition", "secondaryStatus", "secondaryPosition", "hasEditedParameters", "nightPrice", "copy", "(Lcom/avito/android/str_calendar/seller/calendar/data/Status;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/Position;Lcom/avito/android/str_calendar/seller/calendar/data/Status;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/Position;ZLjava/lang/String;)Lcom/avito/android/str_calendar/seller/calendar/data/SellerDayItemState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Lcom/avito/android/str_calendar/seller/calendar/data/Status;", "getSecondaryStatus", "setSecondaryStatus", "(Lcom/avito/android/str_calendar/seller/calendar/data/Status;)V", AuthSource.SEND_ABUSE, "getPrimaryStatus", "setPrimaryStatus", "d", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/Position;", "getSecondaryPosition", "setSecondaryPosition", "(Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/Position;)V", "e", "Z", "getHasEditedParameters", "setHasEditedParameters", "(Z)V", "f", "Ljava/lang/String;", "getNightPrice", "setNightPrice", "(Ljava/lang/String;)V", "getSelected", "selected", AuthSource.BOOKING_ORDER, "getPrimaryPosition", "setPrimaryPosition", "<init>", "(Lcom/avito/android/str_calendar/seller/calendar/data/Status;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/Position;Lcom/avito/android/str_calendar/seller/calendar/data/Status;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/Position;ZLjava/lang/String;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerDayItemState {
    @NotNull
    public Status a;
    @NotNull
    public Position b;
    @NotNull
    public Status c;
    @NotNull
    public Position d;
    public boolean e;
    @NotNull
    public String f;

    public SellerDayItemState() {
        this(null, null, null, null, false, null, 63, null);
    }

    public SellerDayItemState(@NotNull Status status, @NotNull Position position, @NotNull Status status2, @NotNull Position position2, boolean z, @NotNull String str) {
        Intrinsics.checkNotNullParameter(status, "primaryStatus");
        Intrinsics.checkNotNullParameter(position, "primaryPosition");
        Intrinsics.checkNotNullParameter(status2, "secondaryStatus");
        Intrinsics.checkNotNullParameter(position2, "secondaryPosition");
        Intrinsics.checkNotNullParameter(str, "nightPrice");
        this.a = status;
        this.b = position;
        this.c = status2;
        this.d = position2;
        this.e = z;
        this.f = str;
    }

    public static /* synthetic */ SellerDayItemState copy$default(SellerDayItemState sellerDayItemState, Status status, Position position, Status status2, Position position2, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            status = sellerDayItemState.a;
        }
        if ((i & 2) != 0) {
            position = sellerDayItemState.b;
        }
        if ((i & 4) != 0) {
            status2 = sellerDayItemState.c;
        }
        if ((i & 8) != 0) {
            position2 = sellerDayItemState.d;
        }
        if ((i & 16) != 0) {
            z = sellerDayItemState.e;
        }
        if ((i & 32) != 0) {
            str = sellerDayItemState.f;
        }
        return sellerDayItemState.copy(status, position, status2, position2, z, str);
    }

    @NotNull
    public final Status component1() {
        return this.a;
    }

    @NotNull
    public final Position component2() {
        return this.b;
    }

    @NotNull
    public final Status component3() {
        return this.c;
    }

    @NotNull
    public final Position component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    @NotNull
    public final String component6() {
        return this.f;
    }

    @NotNull
    public final SellerDayItemState copy(@NotNull Status status, @NotNull Position position, @NotNull Status status2, @NotNull Position position2, boolean z, @NotNull String str) {
        Intrinsics.checkNotNullParameter(status, "primaryStatus");
        Intrinsics.checkNotNullParameter(position, "primaryPosition");
        Intrinsics.checkNotNullParameter(status2, "secondaryStatus");
        Intrinsics.checkNotNullParameter(position2, "secondaryPosition");
        Intrinsics.checkNotNullParameter(str, "nightPrice");
        return new SellerDayItemState(status, position, status2, position2, z, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SellerDayItemState)) {
            return false;
        }
        SellerDayItemState sellerDayItemState = (SellerDayItemState) obj;
        return Intrinsics.areEqual(this.a, sellerDayItemState.a) && Intrinsics.areEqual(this.b, sellerDayItemState.b) && Intrinsics.areEqual(this.c, sellerDayItemState.c) && Intrinsics.areEqual(this.d, sellerDayItemState.d) && this.e == sellerDayItemState.e && Intrinsics.areEqual(this.f, sellerDayItemState.f);
    }

    public final boolean getHasEditedParameters() {
        return this.e;
    }

    @NotNull
    public final String getNightPrice() {
        return this.f;
    }

    @NotNull
    public final Position getPrimaryPosition() {
        return this.b;
    }

    @NotNull
    public final Status getPrimaryStatus() {
        return this.a;
    }

    @NotNull
    public final Position getSecondaryPosition() {
        return this.d;
    }

    @NotNull
    public final Status getSecondaryStatus() {
        return this.c;
    }

    public final boolean getSelected() {
        Status status = this.a;
        Status status2 = Status.SELECTED;
        return status == status2 || this.c == status2;
    }

    public int hashCode() {
        Status status = this.a;
        int i = 0;
        int hashCode = (status != null ? status.hashCode() : 0) * 31;
        Position position = this.b;
        int hashCode2 = (hashCode + (position != null ? position.hashCode() : 0)) * 31;
        Status status2 = this.c;
        int hashCode3 = (hashCode2 + (status2 != null ? status2.hashCode() : 0)) * 31;
        Position position2 = this.d;
        int hashCode4 = (hashCode3 + (position2 != null ? position2.hashCode() : 0)) * 31;
        boolean z = this.e;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode4 + i2) * 31;
        String str = this.f;
        if (str != null) {
            i = str.hashCode();
        }
        return i5 + i;
    }

    public final void setHasEditedParameters(boolean z) {
        this.e = z;
    }

    public final void setNightPrice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f = str;
    }

    public final void setPrimaryPosition(@NotNull Position position) {
        Intrinsics.checkNotNullParameter(position, "<set-?>");
        this.b = position;
    }

    public final void setPrimaryStatus(@NotNull Status status) {
        Intrinsics.checkNotNullParameter(status, "<set-?>");
        this.a = status;
    }

    public final void setSecondaryPosition(@NotNull Position position) {
        Intrinsics.checkNotNullParameter(position, "<set-?>");
        this.d = position;
    }

    public final void setSecondaryStatus(@NotNull Status status) {
        Intrinsics.checkNotNullParameter(status, "<set-?>");
        this.c = status;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SellerDayItemState(primaryStatus=");
        L.append(this.a);
        L.append(", primaryPosition=");
        L.append(this.b);
        L.append(", secondaryStatus=");
        L.append(this.c);
        L.append(", secondaryPosition=");
        L.append(this.d);
        L.append(", hasEditedParameters=");
        L.append(this.e);
        L.append(", nightPrice=");
        return a.t(L, this.f, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SellerDayItemState(Status status, Position position, Status status2, Position position2, boolean z, String str, int i, j jVar) {
        this((i & 1) != 0 ? Status.NORMAL : status, (i & 2) != 0 ? Position.DEFAULT : position, (i & 4) != 0 ? Status.NONE : status2, (i & 8) != 0 ? Position.DEFAULT : position2, (i & 16) != 0 ? false : z, (i & 32) != 0 ? "" : str);
    }
}
