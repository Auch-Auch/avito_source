package com.avito.android.remote.model.hotels;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u001f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001a¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004R\u001c\u0010\u0013\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000f¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/hotels/Children;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", MessengerShareContentUtility.SUBTITLE, "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", "max", "I", "getMax", "title", "getTitle", "Lcom/avito/android/remote/model/hotels/Age;", "preselected", "Lcom/avito/android/remote/model/hotels/Age;", "getPreselected", "()Lcom/avito/android/remote/model/hotels/Age;", "", "ages", "Ljava/util/List;", "getAges", "()Ljava/util/List;", "addButtonTitle", "getAddButtonTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/avito/android/remote/model/hotels/Age;Ljava/util/List;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class Children implements Parcelable {
    public static final Parcelable.Creator<Children> CREATOR = new Creator();
    @SerializedName("addButtonTitle")
    @NotNull
    private final String addButtonTitle;
    @SerializedName("ages")
    @NotNull
    private final List<Age> ages;
    @SerializedName("max")
    private final int max;
    @SerializedName("preselected")
    @NotNull
    private final Age preselected;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @NotNull
    private final String subtitle;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Children> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Children createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            int readInt = parcel.readInt();
            Age createFromParcel = Age.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add(Age.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new Children(readString, readString2, readString3, readInt, createFromParcel, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Children[] newArray(int i) {
            return new Children[i];
        }
    }

    public Children(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @NotNull Age age, @NotNull List<Age> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(str3, "addButtonTitle");
        Intrinsics.checkNotNullParameter(age, "preselected");
        Intrinsics.checkNotNullParameter(list, "ages");
        this.title = str;
        this.subtitle = str2;
        this.addButtonTitle = str3;
        this.max = i;
        this.preselected = age;
        this.ages = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getAddButtonTitle() {
        return this.addButtonTitle;
    }

    @NotNull
    public final List<Age> getAges() {
        return this.ages;
    }

    public final int getMax() {
        return this.max;
    }

    @NotNull
    public final Age getPreselected() {
        return this.preselected;
    }

    @NotNull
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeString(this.addButtonTitle);
        parcel.writeInt(this.max);
        this.preselected.writeToParcel(parcel, 0);
        Iterator n0 = a.n0(this.ages, parcel);
        while (n0.hasNext()) {
            ((Age) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
