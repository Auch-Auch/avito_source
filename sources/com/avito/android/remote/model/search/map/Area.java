package com.avito.android.remote.model.search.map;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Coordinates;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ$\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0016\u0010\nJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\rR\u001c\u0010\u000f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001e\u0010\r¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/search/map/Area;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/Coordinates;", "component1", "()Lcom/avito/android/remote/model/Coordinates;", "component2", "topLeft", "bottomRight", "copy", "(Lcom/avito/android/remote/model/Coordinates;Lcom/avito/android/remote/model/Coordinates;)Lcom/avito/android/remote/model/search/map/Area;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/Coordinates;", "getBottomRight", "getTopLeft", "<init>", "(Lcom/avito/android/remote/model/Coordinates;Lcom/avito/android/remote/model/Coordinates;)V", "CREATOR", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Area implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @SerializedName("bottomRight")
    @NotNull
    private final Coordinates bottomRight;
    @SerializedName("topLeft")
    @NotNull
    private final Coordinates topLeft;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/search/map/Area$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/search/map/Area;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/search/map/Area;", "", "size", "", "newArray", "(I)[Lcom/avito/android/remote/model/search/map/Area;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<Area> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(j jVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public Area createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Area((Coordinates) a.z1(Coordinates.class, parcel), (Coordinates) a.z1(Coordinates.class, parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public Area[] newArray(int i) {
            return new Area[i];
        }
    }

    public Area(@NotNull Coordinates coordinates, @NotNull Coordinates coordinates2) {
        Intrinsics.checkNotNullParameter(coordinates, "topLeft");
        Intrinsics.checkNotNullParameter(coordinates2, "bottomRight");
        this.topLeft = coordinates;
        this.bottomRight = coordinates2;
    }

    public static /* synthetic */ Area copy$default(Area area, Coordinates coordinates, Coordinates coordinates2, int i, Object obj) {
        if ((i & 1) != 0) {
            coordinates = area.topLeft;
        }
        if ((i & 2) != 0) {
            coordinates2 = area.bottomRight;
        }
        return area.copy(coordinates, coordinates2);
    }

    @NotNull
    public final Coordinates component1() {
        return this.topLeft;
    }

    @NotNull
    public final Coordinates component2() {
        return this.bottomRight;
    }

    @NotNull
    public final Area copy(@NotNull Coordinates coordinates, @NotNull Coordinates coordinates2) {
        Intrinsics.checkNotNullParameter(coordinates, "topLeft");
        Intrinsics.checkNotNullParameter(coordinates2, "bottomRight");
        return new Area(coordinates, coordinates2);
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
        if (!(obj instanceof Area)) {
            return false;
        }
        Area area = (Area) obj;
        return Intrinsics.areEqual(this.topLeft, area.topLeft) && Intrinsics.areEqual(this.bottomRight, area.bottomRight);
    }

    @NotNull
    public final Coordinates getBottomRight() {
        return this.bottomRight;
    }

    @NotNull
    public final Coordinates getTopLeft() {
        return this.topLeft;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Coordinates coordinates = this.topLeft;
        int i = 0;
        int hashCode = (coordinates != null ? coordinates.hashCode() : 0) * 31;
        Coordinates coordinates2 = this.bottomRight;
        if (coordinates2 != null) {
            i = coordinates2.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Area(topLeft=");
        L.append(this.topLeft);
        L.append(", bottomRight=");
        L.append(this.bottomRight);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.topLeft, i);
        parcel.writeParcelable(this.bottomRight, i);
    }
}
