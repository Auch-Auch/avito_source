package com.avito.android.remote.model.delivery_courier;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0012\u0013\u0014B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$ScreenData;", "screenData", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$ScreenData;", "getScreenData", "()Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$ScreenData;", "<init>", "(Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$ScreenData;)V", "Data", "Item", "ScreenData", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierTimeIntervals implements Parcelable {
    public static final Parcelable.Creator<DeliveryCourierTimeIntervals> CREATOR = new Creator();
    @SerializedName("screenData")
    @Nullable
    private final ScreenData screenData;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeliveryCourierTimeIntervals> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryCourierTimeIntervals createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DeliveryCourierTimeIntervals(parcel.readInt() != 0 ? ScreenData.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryCourierTimeIntervals[] newArray(int i) {
            return new DeliveryCourierTimeIntervals[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$Data;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "startDate", "Ljava/lang/String;", "getStartDate", "()Ljava/lang/String;", "endDate", "getEndDate", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Data implements Parcelable {
        public static final Parcelable.Creator<Data> CREATOR = new Creator();
        @SerializedName("endDate")
        @Nullable
        private final String endDate;
        @SerializedName("startDate")
        @Nullable
        private final String startDate;
        @SerializedName("title")
        @Nullable
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Data> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Data createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Data(parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Data[] newArray(int i) {
                return new Data[i];
            }
        }

        public Data(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.title = str;
            this.startDate = str2;
            this.endDate = str3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getEndDate() {
            return this.endDate;
        }

        @Nullable
        public final String getStartDate() {
            return this.startDate;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.startDate);
            parcel.writeString(this.endDate);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$Item;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$ScreenData;", "nestedScreenData", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$ScreenData;", "getNestedScreenData", "()Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$ScreenData;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$Data;", "data", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$Data;", "getData", "()Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$Data;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$ScreenData;Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$Data;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Item implements Parcelable {
        public static final Parcelable.Creator<Item> CREATOR = new Creator();
        @SerializedName("data")
        @Nullable
        private final Data data;
        @SerializedName("nestedScreenData")
        @Nullable
        private final ScreenData nestedScreenData;
        @SerializedName("title")
        @Nullable
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Item> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Item createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                Data data = null;
                ScreenData createFromParcel = parcel.readInt() != 0 ? ScreenData.CREATOR.createFromParcel(parcel) : null;
                if (parcel.readInt() != 0) {
                    data = Data.CREATOR.createFromParcel(parcel);
                }
                return new Item(readString, createFromParcel, data);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Item[] newArray(int i) {
                return new Item[i];
            }
        }

        public Item(@Nullable String str, @Nullable ScreenData screenData, @Nullable Data data2) {
            this.title = str;
            this.nestedScreenData = screenData;
            this.data = data2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Data getData() {
            return this.data;
        }

        @Nullable
        public final ScreenData getNestedScreenData() {
            return this.nestedScreenData;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            ScreenData screenData = this.nestedScreenData;
            if (screenData != null) {
                parcel.writeInt(1);
                screenData.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            Data data2 = this.data;
            if (data2 != null) {
                parcel.writeInt(1);
                data2.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B!\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$ScreenData;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierTimeIntervals$Item;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class ScreenData implements Parcelable {
        public static final Parcelable.Creator<ScreenData> CREATOR = new Creator();
        @SerializedName("items")
        @Nullable
        private final List<Item> items;
        @SerializedName("title")
        @Nullable
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ScreenData> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ScreenData createFromParcel(@NotNull Parcel parcel) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    arrayList = new ArrayList(readInt);
                    while (readInt != 0) {
                        arrayList.add(Item.CREATOR.createFromParcel(parcel));
                        readInt--;
                    }
                } else {
                    arrayList = null;
                }
                return new ScreenData(readString, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ScreenData[] newArray(int i) {
                return new ScreenData[i];
            }
        }

        public ScreenData(@Nullable String str, @Nullable List<Item> list) {
            this.title = str;
            this.items = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final List<Item> getItems() {
            return this.items;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            List<Item> list = this.items;
            if (list != null) {
                Iterator l0 = a.l0(parcel, 1, list);
                while (l0.hasNext()) {
                    ((Item) l0.next()).writeToParcel(parcel, 0);
                }
                return;
            }
            parcel.writeInt(0);
        }
    }

    public DeliveryCourierTimeIntervals(@Nullable ScreenData screenData2) {
        this.screenData = screenData2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final ScreenData getScreenData() {
        return this.screenData;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        ScreenData screenData2 = this.screenData;
        if (screenData2 != null) {
            parcel.writeInt(1);
            screenData2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
