package com.avito.android.booking.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/avito/android/booking/remote/model/BookingInput;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/booking/remote/model/BookingConstraint;", "constraints", "Ljava/util/List;", "getConstraints", "()Ljava/util/List;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "text", "getText", "description", "getDescription", InternalConstsKt.PLACEHOLDER, "getPlaceholder", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingInput implements Parcelable {
    public static final Parcelable.Creator<BookingInput> CREATOR = new Creator();
    @SerializedName("constraints")
    @Nullable
    private final List<BookingConstraint> constraints;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName(InternalConstsKt.PLACEHOLDER)
    @Nullable
    private final String placeholder;
    @SerializedName("text")
    @Nullable
    private final String text;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BookingInput> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BookingInput createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(BookingConstraint.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new BookingInput(readString, readString2, readString3, readString4, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BookingInput[] newArray(int i) {
            return new BookingInput[i];
        }
    }

    public BookingInput(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable List<BookingConstraint> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.description = str2;
        this.text = str3;
        this.placeholder = str4;
        this.constraints = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<BookingConstraint> getConstraints() {
        return this.constraints;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getPlaceholder() {
        return this.placeholder;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.text);
        parcel.writeString(this.placeholder);
        List<BookingConstraint> list = this.constraints;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((BookingConstraint) l0.next()).writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }
}
