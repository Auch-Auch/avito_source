package com.avito.android.str_calendar.utils;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0004\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J$\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\u0005¨\u0006$"}, d2 = {"Lcom/avito/android/str_calendar/utils/DateRange;", "Lkotlin/ranges/ClosedRange;", "Ljava/util/Date;", "Landroid/os/Parcelable;", "component1", "()Ljava/util/Date;", "component2", Tracker.Events.CREATIVE_START, "endInclusive", "copy", "(Ljava/util/Date;Ljava/util/Date;)Lcom/avito/android/str_calendar/utils/DateRange;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Ljava/util/Date;", "getEndInclusive", AuthSource.SEND_ABUSE, "getStart", "<init>", "(Ljava/util/Date;Ljava/util/Date;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class DateRange implements ClosedRange<Date>, Parcelable {
    public static final Parcelable.Creator<DateRange> CREATOR = new Creator();
    @NotNull
    public final Date a;
    @NotNull
    public final Date b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DateRange> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DateRange createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DateRange((Date) parcel.readSerializable(), (Date) parcel.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DateRange[] newArray(int i) {
            return new DateRange[i];
        }
    }

    public DateRange(@NotNull Date date, @NotNull Date date2) {
        Intrinsics.checkNotNullParameter(date, Tracker.Events.CREATIVE_START);
        Intrinsics.checkNotNullParameter(date2, "endInclusive");
        this.a = date;
        this.b = date2;
    }

    public static /* synthetic */ DateRange copy$default(DateRange dateRange, Date date, Date date2, int i, Object obj) {
        if ((i & 1) != 0) {
            date = dateRange.getStart();
        }
        if ((i & 2) != 0) {
            date2 = dateRange.getEndInclusive();
        }
        return dateRange.copy(date, date2);
    }

    @NotNull
    public final Date component1() {
        return getStart();
    }

    @NotNull
    public final Date component2() {
        return getEndInclusive();
    }

    @NotNull
    public final DateRange copy(@NotNull Date date, @NotNull Date date2) {
        Intrinsics.checkNotNullParameter(date, Tracker.Events.CREATIVE_START);
        Intrinsics.checkNotNullParameter(date2, "endInclusive");
        return new DateRange(date, date2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateRange)) {
            return false;
        }
        DateRange dateRange = (DateRange) obj;
        return Intrinsics.areEqual(getStart(), dateRange.getStart()) && Intrinsics.areEqual(getEndInclusive(), dateRange.getEndInclusive());
    }

    @Override // java.lang.Object
    public int hashCode() {
        Date start = getStart();
        int i = 0;
        int hashCode = (start != null ? start.hashCode() : 0) * 31;
        Date endInclusive = getEndInclusive();
        if (endInclusive != null) {
            i = endInclusive.hashCode();
        }
        return hashCode + i;
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return ClosedRange.DefaultImpls.isEmpty(this);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DateRange(start=");
        L.append(getStart());
        L.append(", endInclusive=");
        L.append(getEndInclusive());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeSerializable(this.a);
        parcel.writeSerializable(this.b);
    }

    public boolean contains(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "value");
        return ClosedRange.DefaultImpls.contains(this, date);
    }

    @Override // kotlin.ranges.ClosedRange
    @NotNull
    public Date getEndInclusive() {
        return this.b;
    }

    @Override // kotlin.ranges.ClosedRange
    @NotNull
    public Date getStart() {
        return this.a;
    }
}
