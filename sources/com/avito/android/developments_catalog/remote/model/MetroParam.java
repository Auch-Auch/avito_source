package com.avito.android.developments_catalog.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Sort;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJD\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\fR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010\u0007R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b&\u0010\u0004R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b'\u0010\u0007¨\u0006*"}, d2 = {"Lcom/avito/android/developments_catalog/remote/model/MetroParam;", "Landroid/os/Parcelable;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "", "Lcom/avito/android/developments_catalog/remote/model/MetroLine;", "component4", "()Ljava/util/List;", "id", "name", Sort.DISTANCE, "lines", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/developments_catalog/remote/model/MetroParam;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getLines", "Ljava/lang/String;", "getName", "I", "getId", "getDistance", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class MetroParam implements Parcelable {
    public static final Parcelable.Creator<MetroParam> CREATOR = new Creator();
    @SerializedName(Sort.DISTANCE)
    @Nullable
    private final String distance;
    @SerializedName("id")
    private final int id;
    @SerializedName("lines")
    @Nullable
    private final List<MetroLine> lines;
    @SerializedName("name")
    @Nullable
    private final String name;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MetroParam> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MetroParam createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList.add(MetroLine.CREATOR.createFromParcel(parcel));
                    readInt2--;
                }
            } else {
                arrayList = null;
            }
            return new MetroParam(readInt, readString, readString2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MetroParam[] newArray(int i) {
            return new MetroParam[i];
        }
    }

    public MetroParam(int i, @Nullable String str, @Nullable String str2, @Nullable List<MetroLine> list) {
        this.id = i;
        this.name = str;
        this.distance = str2;
        this.lines = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.developments_catalog.remote.model.MetroParam */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MetroParam copy$default(MetroParam metroParam, int i, String str, String str2, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = metroParam.id;
        }
        if ((i2 & 2) != 0) {
            str = metroParam.name;
        }
        if ((i2 & 4) != 0) {
            str2 = metroParam.distance;
        }
        if ((i2 & 8) != 0) {
            list = metroParam.lines;
        }
        return metroParam.copy(i, str, str2, list);
    }

    public final int component1() {
        return this.id;
    }

    @Nullable
    public final String component2() {
        return this.name;
    }

    @Nullable
    public final String component3() {
        return this.distance;
    }

    @Nullable
    public final List<MetroLine> component4() {
        return this.lines;
    }

    @NotNull
    public final MetroParam copy(int i, @Nullable String str, @Nullable String str2, @Nullable List<MetroLine> list) {
        return new MetroParam(i, str, str2, list);
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
        if (!(obj instanceof MetroParam)) {
            return false;
        }
        MetroParam metroParam = (MetroParam) obj;
        return this.id == metroParam.id && Intrinsics.areEqual(this.name, metroParam.name) && Intrinsics.areEqual(this.distance, metroParam.distance) && Intrinsics.areEqual(this.lines, metroParam.lines);
    }

    @Nullable
    public final String getDistance() {
        return this.distance;
    }

    public final int getId() {
        return this.id;
    }

    @Nullable
    public final List<MetroLine> getLines() {
        return this.lines;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.id * 31;
        String str = this.name;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.distance;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<MetroLine> list = this.lines;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("MetroParam(id=");
        L.append(this.id);
        L.append(", name=");
        L.append(this.name);
        L.append(", distance=");
        L.append(this.distance);
        L.append(", lines=");
        return a.w(L, this.lines, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.distance);
        List<MetroLine> list = this.lines;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((MetroLine) l0.next()).writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }
}
