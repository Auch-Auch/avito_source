package com.avito.android.remote.model.metro_lines;

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
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/model/metro_lines/MetroStation;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "lineIds", "Ljava/util/List;", "getLineIds", "()Ljava/util/List;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "id", "I", "getId", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class MetroStation implements Parcelable {
    public static final Parcelable.Creator<MetroStation> CREATOR = new Creator();
    @SerializedName("id")
    private final int id;
    @SerializedName("lineIds")
    @NotNull
    private final List<Integer> lineIds;
    @SerializedName("name")
    @NotNull
    private final String name;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MetroStation> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MetroStation createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add(Integer.valueOf(parcel.readInt()));
                readInt2--;
            }
            return new MetroStation(readInt, readString, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MetroStation[] newArray(int i) {
            return new MetroStation[i];
        }
    }

    public MetroStation(int i, @NotNull String str, @NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "lineIds");
        this.id = i;
        this.name = str;
        this.lineIds = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final List<Integer> getLineIds() {
        return this.lineIds;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        Iterator n0 = a.n0(this.lineIds, parcel);
        while (n0.hasNext()) {
            parcel.writeInt(((Integer) n0.next()).intValue());
        }
    }
}
