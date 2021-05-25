package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0014\b\b\u0018\u0000 42\u00020\u0001:\u00014B?\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0015¢\u0006\u0004\b1\u00102B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b1\u00103J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017JH\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u0015HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001f\u0010\rJ\u0010\u0010 \u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b \u0010\nJ\u001a\u0010#\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b#\u0010$R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010%\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b&\u0010'R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b)\u0010\rR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010*\u001a\u0004\b+\u0010\u0011R\"\u0010\u001b\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010,\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010/R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b0\u0010\r¨\u00065"}, d2 = {"Lcom/avito/android/remote/model/SearchRadius;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Long;", "Lcom/avito/android/remote/model/Coordinates;", "component4", "()Lcom/avito/android/remote/model/Coordinates;", "", "component5", "()Z", "id", "title", "distanceInMeters", "coordinates", "isActive", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/avito/android/remote/model/Coordinates;Z)Lcom/avito/android/remote/model/SearchRadius;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "setActive", "(Z)V", "Ljava/lang/String;", "getTitle", "Ljava/lang/Long;", "getDistanceInMeters", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "setCoordinates", "(Lcom/avito/android/remote/model/Coordinates;)V", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/avito/android/remote/model/Coordinates;Z)V", "(Landroid/os/Parcel;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SearchRadius implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SearchRadius> CREATOR = Parcels.creator(SearchRadius$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("coordinates")
    @NotNull
    private Coordinates coordinates;
    @SerializedName("distanceInMeters")
    @Nullable
    private final Long distanceInMeters;
    @SerializedName("id")
    @Nullable
    private final String id;
    @SerializedName("isActive")
    private boolean isActive;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/SearchRadius$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/SearchRadius;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public SearchRadius() {
        this(null, null, null, null, false, 31, null);
    }

    public SearchRadius(@Nullable String str, @Nullable String str2, @Nullable Long l, @NotNull Coordinates coordinates2, boolean z) {
        Intrinsics.checkNotNullParameter(coordinates2, "coordinates");
        this.id = str;
        this.title = str2;
        this.distanceInMeters = l;
        this.coordinates = coordinates2;
        this.isActive = z;
    }

    public static /* synthetic */ SearchRadius copy$default(SearchRadius searchRadius, String str, String str2, Long l, Coordinates coordinates2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searchRadius.id;
        }
        if ((i & 2) != 0) {
            str2 = searchRadius.title;
        }
        if ((i & 4) != 0) {
            l = searchRadius.distanceInMeters;
        }
        if ((i & 8) != 0) {
            coordinates2 = searchRadius.coordinates;
        }
        if ((i & 16) != 0) {
            z = searchRadius.isActive;
        }
        return searchRadius.copy(str, str2, l, coordinates2, z);
    }

    @Nullable
    public final String component1() {
        return this.id;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final Long component3() {
        return this.distanceInMeters;
    }

    @NotNull
    public final Coordinates component4() {
        return this.coordinates;
    }

    public final boolean component5() {
        return this.isActive;
    }

    @NotNull
    public final SearchRadius copy(@Nullable String str, @Nullable String str2, @Nullable Long l, @NotNull Coordinates coordinates2, boolean z) {
        Intrinsics.checkNotNullParameter(coordinates2, "coordinates");
        return new SearchRadius(str, str2, l, coordinates2, z);
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
        if (!(obj instanceof SearchRadius)) {
            return false;
        }
        SearchRadius searchRadius = (SearchRadius) obj;
        return Intrinsics.areEqual(this.id, searchRadius.id) && Intrinsics.areEqual(this.title, searchRadius.title) && Intrinsics.areEqual(this.distanceInMeters, searchRadius.distanceInMeters) && Intrinsics.areEqual(this.coordinates, searchRadius.coordinates) && this.isActive == searchRadius.isActive;
    }

    @NotNull
    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    @Nullable
    public final Long getDistanceInMeters() {
        return this.distanceInMeters;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.distanceInMeters;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Coordinates coordinates2 = this.coordinates;
        if (coordinates2 != null) {
            i = coordinates2.hashCode();
        }
        int i2 = (hashCode3 + i) * 31;
        boolean z = this.isActive;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    public final void setCoordinates(@NotNull Coordinates coordinates2) {
        Intrinsics.checkNotNullParameter(coordinates2, "<set-?>");
        this.coordinates = coordinates2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SearchRadius(id=");
        L.append(this.id);
        L.append(", title=");
        L.append(this.title);
        L.append(", distanceInMeters=");
        L.append(this.distanceInMeters);
        L.append(", coordinates=");
        L.append(this.coordinates);
        L.append(", isActive=");
        return a.B(L, this.isActive, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeValue(this.distanceInMeters);
        parcel.writeParcelable(this.coordinates, i);
        ParcelsKt.writeBool(parcel, this.isActive);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchRadius(String str, String str2, Long l, Coordinates coordinates2, boolean z, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) == 0 ? l : null, (i & 8) != 0 ? new Coordinates(0.0d, 0.0d) : coordinates2, (i & 16) != 0 ? false : z);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SearchRadius(@org.jetbrains.annotations.NotNull android.os.Parcel r8) {
        /*
            r7 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r2 = r8.readString()
            java.lang.String r3 = r8.readString()
            java.lang.Class r0 = java.lang.Long.TYPE
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.Object r0 = r8.readValue(r0)
            boolean r1 = r0 instanceof java.lang.Long
            if (r1 != 0) goto L_0x001c
            r0 = 0
        L_0x001c:
            r4 = r0
            java.lang.Long r4 = (java.lang.Long) r4
            java.lang.Class<com.avito.android.remote.model.Coordinates> r0 = com.avito.android.remote.model.Coordinates.class
            android.os.Parcelable r0 = a2.b.a.a.a.z1(r0, r8)
            r5 = r0
            com.avito.android.remote.model.Coordinates r5 = (com.avito.android.remote.model.Coordinates) r5
            boolean r6 = com.avito.android.util.ParcelsKt.readBool(r8)
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.SearchRadius.<init>(android.os.Parcel):void");
    }
}
