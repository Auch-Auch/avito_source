package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0012\u0013\u0014B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/model/StrBookingCalendar;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/StrBookingCalendar$BookingCalendarData;", "bookingCalendarData", "Lcom/avito/android/remote/model/StrBookingCalendar$BookingCalendarData;", "getBookingCalendarData", "()Lcom/avito/android/remote/model/StrBookingCalendar$BookingCalendarData;", "<init>", "(Lcom/avito/android/remote/model/StrBookingCalendar$BookingCalendarData;)V", "AvailableCheckOutDateRange", "BookingCalendarData", "BookingCalendarItem", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrBookingCalendar implements Parcelable {
    public static final Parcelable.Creator<StrBookingCalendar> CREATOR = new Creator();
    @SerializedName("bookingCalendarData")
    @NotNull
    private final BookingCalendarData bookingCalendarData;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/StrBookingCalendar$AvailableCheckOutDateRange;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "endDate", "Ljava/lang/String;", "getEndDate", "()Ljava/lang/String;", "startDate", "getStartDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    public static final class AvailableCheckOutDateRange implements Parcelable {
        public static final Parcelable.Creator<AvailableCheckOutDateRange> CREATOR = new Creator();
        @SerializedName("endDate")
        @NotNull
        private final String endDate;
        @SerializedName("startDate")
        @NotNull
        private final String startDate;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<AvailableCheckOutDateRange> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AvailableCheckOutDateRange createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new AvailableCheckOutDateRange(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AvailableCheckOutDateRange[] newArray(int i) {
                return new AvailableCheckOutDateRange[i];
            }
        }

        public AvailableCheckOutDateRange(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "startDate");
            Intrinsics.checkNotNullParameter(str2, "endDate");
            this.startDate = str;
            this.endDate = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getEndDate() {
            return this.endDate;
        }

        @NotNull
        public final String getStartDate() {
            return this.startDate;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.startDate);
            parcel.writeString(this.endDate);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/StrBookingCalendar$BookingCalendarData;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/StrBookingCalendar$BookingCalendarItem;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    public static final class BookingCalendarData implements Parcelable {
        public static final Parcelable.Creator<BookingCalendarData> CREATOR = new Creator();
        @SerializedName("items")
        @NotNull
        private final List<BookingCalendarItem> items;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<BookingCalendarData> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final BookingCalendarData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(BookingCalendarItem.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                return new BookingCalendarData(arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final BookingCalendarData[] newArray(int i) {
                return new BookingCalendarData[i];
            }
        }

        public BookingCalendarData(@NotNull List<BookingCalendarItem> list) {
            Intrinsics.checkNotNullParameter(list, "items");
            this.items = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<BookingCalendarItem> getItems() {
            return this.items;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Iterator n0 = a.n0(this.items, parcel);
            while (n0.hasNext()) {
                ((BookingCalendarItem) n0.next()).writeToParcel(parcel, 0);
            }
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/StrBookingCalendar$BookingCalendarItem;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", Sort.DATE, "Ljava/lang/String;", "getDate", "()Ljava/lang/String;", "", "isCheckInAvailable", "Z", "()Z", "Lcom/avito/android/remote/model/StrBookingCalendar$AvailableCheckOutDateRange;", "availableCheckOutDateRange", "Lcom/avito/android/remote/model/StrBookingCalendar$AvailableCheckOutDateRange;", "getAvailableCheckOutDateRange", "()Lcom/avito/android/remote/model/StrBookingCalendar$AvailableCheckOutDateRange;", "<init>", "(Ljava/lang/String;ZLcom/avito/android/remote/model/StrBookingCalendar$AvailableCheckOutDateRange;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    public static final class BookingCalendarItem implements Parcelable {
        public static final Parcelable.Creator<BookingCalendarItem> CREATOR = new Creator();
        @SerializedName("availableCheckOutDateRange")
        @Nullable
        private final AvailableCheckOutDateRange availableCheckOutDateRange;
        @SerializedName(Sort.DATE)
        @NotNull
        private final String date;
        @SerializedName("isCheckInAvailable")
        private final boolean isCheckInAvailable;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<BookingCalendarItem> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final BookingCalendarItem createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new BookingCalendarItem(parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0 ? AvailableCheckOutDateRange.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final BookingCalendarItem[] newArray(int i) {
                return new BookingCalendarItem[i];
            }
        }

        public BookingCalendarItem(@NotNull String str, boolean z, @Nullable AvailableCheckOutDateRange availableCheckOutDateRange2) {
            Intrinsics.checkNotNullParameter(str, Sort.DATE);
            this.date = str;
            this.isCheckInAvailable = z;
            this.availableCheckOutDateRange = availableCheckOutDateRange2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final AvailableCheckOutDateRange getAvailableCheckOutDateRange() {
            return this.availableCheckOutDateRange;
        }

        @NotNull
        public final String getDate() {
            return this.date;
        }

        public final boolean isCheckInAvailable() {
            return this.isCheckInAvailable;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.date);
            parcel.writeInt(this.isCheckInAvailable ? 1 : 0);
            AvailableCheckOutDateRange availableCheckOutDateRange2 = this.availableCheckOutDateRange;
            if (availableCheckOutDateRange2 != null) {
                parcel.writeInt(1);
                availableCheckOutDateRange2.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<StrBookingCalendar> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StrBookingCalendar createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new StrBookingCalendar(BookingCalendarData.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StrBookingCalendar[] newArray(int i) {
            return new StrBookingCalendar[i];
        }
    }

    public StrBookingCalendar(@NotNull BookingCalendarData bookingCalendarData2) {
        Intrinsics.checkNotNullParameter(bookingCalendarData2, "bookingCalendarData");
        this.bookingCalendarData = bookingCalendarData2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final BookingCalendarData getBookingCalendarData() {
        return this.bookingCalendarData;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.bookingCalendarData.writeToParcel(parcel, 0);
    }
}
