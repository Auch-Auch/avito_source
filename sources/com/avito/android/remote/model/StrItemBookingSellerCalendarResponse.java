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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0003\u001d\u001e\u001fBA\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/StrItemBookingSellerCalendarResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/StrItemBookingSellerCalendarResponse$SellerCalendarItem;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "Lcom/avito/android/remote/model/StrItemBookingSellerCalendarResponse$DateRange;", "bookedDateRanges", "getBookedDateRanges", "Lcom/avito/android/remote/model/StrItemBookingSellerCalendarResponse$BaseParameters;", "baseParameters", "Lcom/avito/android/remote/model/StrItemBookingSellerCalendarResponse$BaseParameters;", "getBaseParameters", "()Lcom/avito/android/remote/model/StrItemBookingSellerCalendarResponse$BaseParameters;", "unavailableDateRanges", "getUnavailableDateRanges", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/StrItemBookingSellerCalendarResponse$BaseParameters;Ljava/util/List;)V", "BaseParameters", "DateRange", "SellerCalendarItem", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrItemBookingSellerCalendarResponse implements Parcelable {
    public static final Parcelable.Creator<StrItemBookingSellerCalendarResponse> CREATOR = new Creator();
    @SerializedName("baseParameters")
    @Nullable
    private final BaseParameters baseParameters;
    @SerializedName("bookedDateRanges")
    @Nullable
    private final List<DateRange> bookedDateRanges;
    @SerializedName("items")
    @Nullable
    private final List<SellerCalendarItem> items;
    @SerializedName("unavailableDateRanges")
    @Nullable
    private final List<DateRange> unavailableDateRanges;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/StrItemBookingSellerCalendarResponse$BaseParameters;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "nightPrice", "Ljava/lang/String;", "getNightPrice", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    public static final class BaseParameters implements Parcelable {
        public static final Parcelable.Creator<BaseParameters> CREATOR = new Creator();
        @SerializedName("nightPrice")
        @NotNull
        private final String nightPrice;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<BaseParameters> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final BaseParameters createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new BaseParameters(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final BaseParameters[] newArray(int i) {
                return new BaseParameters[i];
            }
        }

        public BaseParameters(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "nightPrice");
            this.nightPrice = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getNightPrice() {
            return this.nightPrice;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.nightPrice);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<StrItemBookingSellerCalendarResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StrItemBookingSellerCalendarResponse createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(parcel, "in");
            ArrayList arrayList3 = null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(DateRange.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList2.add(DateRange.CREATOR.createFromParcel(parcel));
                    readInt2--;
                }
            } else {
                arrayList2 = null;
            }
            BaseParameters createFromParcel = parcel.readInt() != 0 ? BaseParameters.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt3 = parcel.readInt();
                ArrayList arrayList4 = new ArrayList(readInt3);
                while (readInt3 != 0) {
                    arrayList4.add(SellerCalendarItem.CREATOR.createFromParcel(parcel));
                    readInt3--;
                }
                arrayList3 = arrayList4;
            }
            return new StrItemBookingSellerCalendarResponse(arrayList, arrayList2, createFromParcel, arrayList3);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StrItemBookingSellerCalendarResponse[] newArray(int i) {
            return new StrItemBookingSellerCalendarResponse[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/StrItemBookingSellerCalendarResponse$DateRange;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "startDate", "Ljava/lang/String;", "getStartDate", "()Ljava/lang/String;", "endDate", "getEndDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    public static final class DateRange implements Parcelable {
        public static final Parcelable.Creator<DateRange> CREATOR = new Creator();
        @SerializedName("endDate")
        @NotNull
        private final String endDate;
        @SerializedName("startDate")
        @NotNull
        private final String startDate;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<DateRange> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final DateRange createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new DateRange(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final DateRange[] newArray(int i) {
                return new DateRange[i];
            }
        }

        public DateRange(@NotNull String str, @NotNull String str2) {
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
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/StrItemBookingSellerCalendarResponse$SellerCalendarItem;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "overridenNightPrice", "Ljava/lang/String;", "getOverridenNightPrice", "()Ljava/lang/String;", "", "hasEditedParameters", "Z", "getHasEditedParameters", "()Z", Sort.DATE, "getDate", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    public static final class SellerCalendarItem implements Parcelable {
        public static final Parcelable.Creator<SellerCalendarItem> CREATOR = new Creator();
        @SerializedName(Sort.DATE)
        @NotNull
        private final String date;
        @SerializedName("hasEditedParameters")
        private final boolean hasEditedParameters;
        @SerializedName("overridenNightPrice")
        @Nullable
        private final String overridenNightPrice;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<SellerCalendarItem> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final SellerCalendarItem createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new SellerCalendarItem(parcel.readString(), parcel.readInt() != 0, parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final SellerCalendarItem[] newArray(int i) {
                return new SellerCalendarItem[i];
            }
        }

        public SellerCalendarItem(@NotNull String str, boolean z, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, Sort.DATE);
            this.date = str;
            this.hasEditedParameters = z;
            this.overridenNightPrice = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getDate() {
            return this.date;
        }

        public final boolean getHasEditedParameters() {
            return this.hasEditedParameters;
        }

        @Nullable
        public final String getOverridenNightPrice() {
            return this.overridenNightPrice;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.date);
            parcel.writeInt(this.hasEditedParameters ? 1 : 0);
            parcel.writeString(this.overridenNightPrice);
        }
    }

    public StrItemBookingSellerCalendarResponse(@Nullable List<DateRange> list, @Nullable List<DateRange> list2, @Nullable BaseParameters baseParameters2, @Nullable List<SellerCalendarItem> list3) {
        this.bookedDateRanges = list;
        this.unavailableDateRanges = list2;
        this.baseParameters = baseParameters2;
        this.items = list3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final BaseParameters getBaseParameters() {
        return this.baseParameters;
    }

    @Nullable
    public final List<DateRange> getBookedDateRanges() {
        return this.bookedDateRanges;
    }

    @Nullable
    public final List<SellerCalendarItem> getItems() {
        return this.items;
    }

    @Nullable
    public final List<DateRange> getUnavailableDateRanges() {
        return this.unavailableDateRanges;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        List<DateRange> list = this.bookedDateRanges;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((DateRange) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        List<DateRange> list2 = this.unavailableDateRanges;
        if (list2 != null) {
            Iterator l02 = a.l0(parcel, 1, list2);
            while (l02.hasNext()) {
                ((DateRange) l02.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        BaseParameters baseParameters2 = this.baseParameters;
        if (baseParameters2 != null) {
            parcel.writeInt(1);
            baseParameters2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        List<SellerCalendarItem> list3 = this.items;
        if (list3 != null) {
            Iterator l03 = a.l0(parcel, 1, list3);
            while (l03.hasNext()) {
                ((SellerCalendarItem) l03.next()).writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }
}
