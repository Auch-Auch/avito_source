package com.avito.android.search.filter;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Direction;
import com.avito.android.remote.model.District;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.Metro;
import com.avito.android.remote.model.metro_lines.MetroResponseBody;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020!0\u001a\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020+0\u001a\u0012\b\b\u0002\u0010*\u001a\u00020%¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020!0\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u0019\u0010*\u001a\u00020%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001f\u0010.\u001a\b\u0012\u0004\u0012\u00020+0\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010\u001f¨\u00061"}, d2 = {"Lcom/avito/android/search/filter/LocationInfo;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Location;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Location;", "getTopLocation", "()Lcom/avito/android/remote/model/Location;", "topLocation", "Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", "d", "Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", "getNewMetroBody", "()Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", "newMetroBody", AuthSource.SEND_ABUSE, "getLocation", "location", "", "Lcom/avito/android/remote/model/Metro;", "c", "Ljava/util/List;", "getMetro", "()Ljava/util/List;", "metro", "Lcom/avito/android/remote/model/District;", "e", "getDistricts", "districts", "", g.a, "Z", "getRenamed", "()Z", "renamed", "Lcom/avito/android/remote/model/Direction;", "f", "getDirections", "directions", "<init>", "(Lcom/avito/android/remote/model/Location;Lcom/avito/android/remote/model/Location;Ljava/util/List;Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;Ljava/util/List;Ljava/util/List;Z)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class LocationInfo implements Parcelable {
    public static final Parcelable.Creator<LocationInfo> CREATOR = new Creator();
    @NotNull
    public final Location a;
    @Nullable
    public final Location b;
    @NotNull
    public final List<Metro> c;
    @Nullable
    public final MetroResponseBody d;
    @NotNull
    public final List<District> e;
    @NotNull
    public final List<Direction> f;
    public final boolean g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<LocationInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LocationInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            Location location = (Location) parcel.readParcelable(LocationInfo.class.getClassLoader());
            Location location2 = (Location) parcel.readParcelable(LocationInfo.class.getClassLoader());
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((Metro) parcel.readParcelable(LocationInfo.class.getClassLoader()));
                readInt--;
            }
            MetroResponseBody metroResponseBody = (MetroResponseBody) parcel.readParcelable(LocationInfo.class.getClassLoader());
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add((District) parcel.readParcelable(LocationInfo.class.getClassLoader()));
                readInt2--;
            }
            int readInt3 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(readInt3);
            while (readInt3 != 0) {
                arrayList3.add((Direction) parcel.readParcelable(LocationInfo.class.getClassLoader()));
                readInt3--;
            }
            return new LocationInfo(location, location2, arrayList, metroResponseBody, arrayList2, arrayList3, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LocationInfo[] newArray(int i) {
            return new LocationInfo[i];
        }
    }

    public LocationInfo(@NotNull Location location, @Nullable Location location2, @NotNull List<Metro> list, @Nullable MetroResponseBody metroResponseBody, @NotNull List<District> list2, @NotNull List<Direction> list3, boolean z) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(list, "metro");
        Intrinsics.checkNotNullParameter(list2, "districts");
        Intrinsics.checkNotNullParameter(list3, "directions");
        this.a = location;
        this.b = location2;
        this.c = list;
        this.d = metroResponseBody;
        this.e = list2;
        this.f = list3;
        this.g = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<Direction> getDirections() {
        return this.f;
    }

    @NotNull
    public final List<District> getDistricts() {
        return this.e;
    }

    @NotNull
    public final Location getLocation() {
        return this.a;
    }

    @NotNull
    public final List<Metro> getMetro() {
        return this.c;
    }

    @Nullable
    public final MetroResponseBody getNewMetroBody() {
        return this.d;
    }

    public final boolean getRenamed() {
        return this.g;
    }

    @Nullable
    public final Location getTopLocation() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
        Iterator n0 = a.n0(this.c, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((Metro) n0.next(), i);
        }
        parcel.writeParcelable(this.d, i);
        Iterator n02 = a.n0(this.e, parcel);
        while (n02.hasNext()) {
            parcel.writeParcelable((District) n02.next(), i);
        }
        Iterator n03 = a.n0(this.f, parcel);
        while (n03.hasNext()) {
            parcel.writeParcelable((Direction) n03.next(), i);
        }
        parcel.writeInt(this.g ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocationInfo(Location location, Location location2, List list, MetroResponseBody metroResponseBody, List list2, List list3, boolean z, int i, j jVar) {
        this(location, location2, list, metroResponseBody, list2, list3, (i & 64) != 0 ? false : z);
    }
}
