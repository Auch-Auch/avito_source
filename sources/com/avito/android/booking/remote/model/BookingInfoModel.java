package com.avito.android.booking.remote.model;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010\bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b&\u0010\u0004¨\u0006)"}, d2 = {"Lcom/avito/android/booking/remote/model/BookingInfoModel;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/booking/remote/model/BookingInfoElement;", "component2", "()Ljava/util/List;", "Lcom/avito/android/booking/remote/model/BookingInfoAction;", "component3", "()Lcom/avito/android/booking/remote/model/BookingInfoAction;", "title", "items", "action", "copy", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/booking/remote/model/BookingInfoAction;)Lcom/avito/android/booking/remote/model/BookingInfoModel;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getItems", "Lcom/avito/android/booking/remote/model/BookingInfoAction;", "getAction", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/booking/remote/model/BookingInfoAction;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingInfoModel implements Parcelable {
    public static final Parcelable.Creator<BookingInfoModel> CREATOR = new Creator();
    @SerializedName("action")
    @Nullable
    private final BookingInfoAction action;
    @SerializedName("items")
    @NotNull
    private final List<BookingInfoElement> items;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BookingInfoModel> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BookingInfoModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(BookingInfoElement.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new BookingInfoModel(readString, arrayList, parcel.readInt() != 0 ? BookingInfoAction.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BookingInfoModel[] newArray(int i) {
            return new BookingInfoModel[i];
        }
    }

    public BookingInfoModel(@Nullable String str, @NotNull List<BookingInfoElement> list, @Nullable BookingInfoAction bookingInfoAction) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.title = str;
        this.items = list;
        this.action = bookingInfoAction;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.booking.remote.model.BookingInfoModel */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BookingInfoModel copy$default(BookingInfoModel bookingInfoModel, String str, List list, BookingInfoAction bookingInfoAction, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bookingInfoModel.title;
        }
        if ((i & 2) != 0) {
            list = bookingInfoModel.items;
        }
        if ((i & 4) != 0) {
            bookingInfoAction = bookingInfoModel.action;
        }
        return bookingInfoModel.copy(str, list, bookingInfoAction);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final List<BookingInfoElement> component2() {
        return this.items;
    }

    @Nullable
    public final BookingInfoAction component3() {
        return this.action;
    }

    @NotNull
    public final BookingInfoModel copy(@Nullable String str, @NotNull List<BookingInfoElement> list, @Nullable BookingInfoAction bookingInfoAction) {
        Intrinsics.checkNotNullParameter(list, "items");
        return new BookingInfoModel(str, list, bookingInfoAction);
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
        if (!(obj instanceof BookingInfoModel)) {
            return false;
        }
        BookingInfoModel bookingInfoModel = (BookingInfoModel) obj;
        return Intrinsics.areEqual(this.title, bookingInfoModel.title) && Intrinsics.areEqual(this.items, bookingInfoModel.items) && Intrinsics.areEqual(this.action, bookingInfoModel.action);
    }

    @Nullable
    public final BookingInfoAction getAction() {
        return this.action;
    }

    @NotNull
    public final List<BookingInfoElement> getItems() {
        return this.items;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<BookingInfoElement> list = this.items;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        BookingInfoAction bookingInfoAction = this.action;
        if (bookingInfoAction != null) {
            i = bookingInfoAction.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BookingInfoModel(title=");
        L.append(this.title);
        L.append(", items=");
        L.append(this.items);
        L.append(", action=");
        L.append(this.action);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        Iterator n0 = a.n0(this.items, parcel);
        while (n0.hasNext()) {
            ((BookingInfoElement) n0.next()).writeToParcel(parcel, 0);
        }
        BookingInfoAction bookingInfoAction = this.action;
        if (bookingInfoAction != null) {
            parcel.writeInt(1);
            bookingInfoAction.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
