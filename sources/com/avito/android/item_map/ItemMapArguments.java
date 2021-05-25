package com.avito.android.item_map;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.item_map.remote.model.AmenityButton;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.GeoReference;
import com.facebook.appevents.integrity.IntegrityManager;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b#\b\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000e\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010$\u001a\u00020\u0005\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\n¢\u0006\u0004\bU\u0010VJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u0012\u0010\fJ\u0018\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0011J\u0010\u0010\u0015\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u0018\u0010\fJ®\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000e2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b(\u0010\fJ\u0010\u0010*\u001a\u00020)HÖ\u0001¢\u0006\u0004\b*\u0010+J\u001a\u0010.\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010,HÖ\u0003¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020)HÖ\u0001¢\u0006\u0004\b0\u0010+J \u00105\u001a\u0002042\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020)HÖ\u0001¢\u0006\u0004\b5\u00106R\u0019\u0010\"\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010\u0007R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010\fR\u001b\u0010%\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010;\u001a\u0004\b>\u0010\fR\u0019\u0010\u001c\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b?\u00108\u001a\u0004\b@\u0010\u0007R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010;\u001a\u0004\bB\u0010\fR!\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\u0011R!\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010D\u001a\u0004\bG\u0010\u0011R\u0019\u0010$\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bH\u00108\u001a\u0004\bI\u0010\u0007R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bM\u00108\u001a\u0004\bN\u0010\u0007R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010K\u001a\u0004\bP\u0010\u0004R\u0019\u0010#\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bQ\u00108\u001a\u0004\bR\u0010\u0007R\u001b\u0010 \u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010;\u001a\u0004\bT\u0010\f¨\u0006W"}, d2 = {"Lcom/avito/android/item_map/ItemMapArguments;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/Coordinates;", "component1", "()Lcom/avito/android/remote/model/Coordinates;", "", "component2", "()Z", "component3", "component4", "", "component5", "()Ljava/lang/String;", "component6", "", "Lcom/avito/android/remote/model/GeoReference;", "component7", "()Ljava/util/List;", "component8", "Lcom/avito/android/item_map/remote/model/AmenityButton;", "component9", "component10", "component11", "component12", "component13", "itemCoordinates", "hasFindMeButton", "myCoordinates", "hasBottomSheet", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "title", "geoReference", "itemId", "amenityButtons", "showMeOnMap", "hasCreateRouteButton", "shouldTrackMapMovement", "fromPage", "copy", "(Lcom/avito/android/remote/model/Coordinates;ZLcom/avito/android/remote/model/Coordinates;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;ZZZLjava/lang/String;)Lcom/avito/android/item_map/ItemMapArguments;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "j", "Z", "getShowMeOnMap", "f", "Ljava/lang/String;", "getTitle", AuthSource.OPEN_CHANNEL_LIST, "getFromPage", "d", "getHasBottomSheet", "e", "getAddress", g.a, "Ljava/util/List;", "getGeoReference", "i", "getAmenityButtons", "l", "getShouldTrackMapMovement", "c", "Lcom/avito/android/remote/model/Coordinates;", "getMyCoordinates", AuthSource.BOOKING_ORDER, "getHasFindMeButton", AuthSource.SEND_ABUSE, "getItemCoordinates", "k", "getHasCreateRouteButton", "h", "getItemId", "<init>", "(Lcom/avito/android/remote/model/Coordinates;ZLcom/avito/android/remote/model/Coordinates;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;ZZZLjava/lang/String;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
public final class ItemMapArguments implements Parcelable {
    public static final Parcelable.Creator<ItemMapArguments> CREATOR = new Creator();
    @Nullable
    public final Coordinates a;
    public final boolean b;
    @Nullable
    public final Coordinates c;
    public final boolean d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final List<GeoReference> g;
    @Nullable
    public final String h;
    @Nullable
    public final List<AmenityButton> i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    @Nullable
    public final String m;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ItemMapArguments> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ItemMapArguments createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            Coordinates coordinates = (Coordinates) parcel.readParcelable(ItemMapArguments.class.getClassLoader());
            boolean z = parcel.readInt() != 0;
            Coordinates coordinates2 = (Coordinates) parcel.readParcelable(ItemMapArguments.class.getClassLoader());
            boolean z2 = parcel.readInt() != 0;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            ArrayList arrayList2 = null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((GeoReference) parcel.readParcelable(ItemMapArguments.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            String readString3 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList2.add((AmenityButton) parcel.readParcelable(ItemMapArguments.class.getClassLoader()));
                    readInt2--;
                }
            }
            return new ItemMapArguments(coordinates, z, coordinates2, z2, readString, readString2, arrayList, readString3, arrayList2, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ItemMapArguments[] newArray(int i) {
            return new ItemMapArguments[i];
        }
    }

    public ItemMapArguments() {
        this(null, false, null, false, null, null, null, null, null, false, false, false, null, 8191, null);
    }

    public ItemMapArguments(@Nullable Coordinates coordinates, boolean z, @Nullable Coordinates coordinates2, boolean z2, @Nullable String str, @Nullable String str2, @Nullable List<GeoReference> list, @Nullable String str3, @Nullable List<AmenityButton> list2, boolean z3, boolean z4, boolean z5, @Nullable String str4) {
        this.a = coordinates;
        this.b = z;
        this.c = coordinates2;
        this.d = z2;
        this.e = str;
        this.f = str2;
        this.g = list;
        this.h = str3;
        this.i = list2;
        this.j = z3;
        this.k = z4;
        this.l = z5;
        this.m = str4;
    }

    public static /* synthetic */ ItemMapArguments copy$default(ItemMapArguments itemMapArguments, Coordinates coordinates, boolean z, Coordinates coordinates2, boolean z2, String str, String str2, List list, String str3, List list2, boolean z3, boolean z4, boolean z5, String str4, int i2, Object obj) {
        return itemMapArguments.copy((i2 & 1) != 0 ? itemMapArguments.a : coordinates, (i2 & 2) != 0 ? itemMapArguments.b : z, (i2 & 4) != 0 ? itemMapArguments.c : coordinates2, (i2 & 8) != 0 ? itemMapArguments.d : z2, (i2 & 16) != 0 ? itemMapArguments.e : str, (i2 & 32) != 0 ? itemMapArguments.f : str2, (i2 & 64) != 0 ? itemMapArguments.g : list, (i2 & 128) != 0 ? itemMapArguments.h : str3, (i2 & 256) != 0 ? itemMapArguments.i : list2, (i2 & 512) != 0 ? itemMapArguments.j : z3, (i2 & 1024) != 0 ? itemMapArguments.k : z4, (i2 & 2048) != 0 ? itemMapArguments.l : z5, (i2 & 4096) != 0 ? itemMapArguments.m : str4);
    }

    @Nullable
    public final Coordinates component1() {
        return this.a;
    }

    public final boolean component10() {
        return this.j;
    }

    public final boolean component11() {
        return this.k;
    }

    public final boolean component12() {
        return this.l;
    }

    @Nullable
    public final String component13() {
        return this.m;
    }

    public final boolean component2() {
        return this.b;
    }

    @Nullable
    public final Coordinates component3() {
        return this.c;
    }

    public final boolean component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @Nullable
    public final String component6() {
        return this.f;
    }

    @Nullable
    public final List<GeoReference> component7() {
        return this.g;
    }

    @Nullable
    public final String component8() {
        return this.h;
    }

    @Nullable
    public final List<AmenityButton> component9() {
        return this.i;
    }

    @NotNull
    public final ItemMapArguments copy(@Nullable Coordinates coordinates, boolean z, @Nullable Coordinates coordinates2, boolean z2, @Nullable String str, @Nullable String str2, @Nullable List<GeoReference> list, @Nullable String str3, @Nullable List<AmenityButton> list2, boolean z3, boolean z4, boolean z5, @Nullable String str4) {
        return new ItemMapArguments(coordinates, z, coordinates2, z2, str, str2, list, str3, list2, z3, z4, z5, str4);
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
        if (!(obj instanceof ItemMapArguments)) {
            return false;
        }
        ItemMapArguments itemMapArguments = (ItemMapArguments) obj;
        return Intrinsics.areEqual(this.a, itemMapArguments.a) && this.b == itemMapArguments.b && Intrinsics.areEqual(this.c, itemMapArguments.c) && this.d == itemMapArguments.d && Intrinsics.areEqual(this.e, itemMapArguments.e) && Intrinsics.areEqual(this.f, itemMapArguments.f) && Intrinsics.areEqual(this.g, itemMapArguments.g) && Intrinsics.areEqual(this.h, itemMapArguments.h) && Intrinsics.areEqual(this.i, itemMapArguments.i) && this.j == itemMapArguments.j && this.k == itemMapArguments.k && this.l == itemMapArguments.l && Intrinsics.areEqual(this.m, itemMapArguments.m);
    }

    @Nullable
    public final String getAddress() {
        return this.e;
    }

    @Nullable
    public final List<AmenityButton> getAmenityButtons() {
        return this.i;
    }

    @Nullable
    public final String getFromPage() {
        return this.m;
    }

    @Nullable
    public final List<GeoReference> getGeoReference() {
        return this.g;
    }

    public final boolean getHasBottomSheet() {
        return this.d;
    }

    public final boolean getHasCreateRouteButton() {
        return this.k;
    }

    public final boolean getHasFindMeButton() {
        return this.b;
    }

    @Nullable
    public final Coordinates getItemCoordinates() {
        return this.a;
    }

    @Nullable
    public final String getItemId() {
        return this.h;
    }

    @Nullable
    public final Coordinates getMyCoordinates() {
        return this.c;
    }

    public final boolean getShouldTrackMapMovement() {
        return this.l;
    }

    public final boolean getShowMeOnMap() {
        return this.j;
    }

    @Nullable
    public final String getTitle() {
        return this.f;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Coordinates coordinates = this.a;
        int i2 = 0;
        int hashCode = (coordinates != null ? coordinates.hashCode() : 0) * 31;
        boolean z = this.b;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (hashCode + i4) * 31;
        Coordinates coordinates2 = this.c;
        int hashCode2 = (i7 + (coordinates2 != null ? coordinates2.hashCode() : 0)) * 31;
        boolean z2 = this.d;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (hashCode2 + i8) * 31;
        String str = this.e;
        int hashCode3 = (i11 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<GeoReference> list = this.g;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.h;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<AmenityButton> list2 = this.i;
        int hashCode7 = (hashCode6 + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z3 = this.j;
        if (z3) {
            z3 = true;
        }
        int i12 = z3 ? 1 : 0;
        int i13 = z3 ? 1 : 0;
        int i14 = z3 ? 1 : 0;
        int i15 = (hashCode7 + i12) * 31;
        boolean z4 = this.k;
        if (z4) {
            z4 = true;
        }
        int i16 = z4 ? 1 : 0;
        int i17 = z4 ? 1 : 0;
        int i18 = z4 ? 1 : 0;
        int i19 = (i15 + i16) * 31;
        boolean z5 = this.l;
        if (!z5) {
            i3 = z5 ? 1 : 0;
        }
        int i20 = (i19 + i3) * 31;
        String str4 = this.m;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return i20 + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ItemMapArguments(itemCoordinates=");
        L.append(this.a);
        L.append(", hasFindMeButton=");
        L.append(this.b);
        L.append(", myCoordinates=");
        L.append(this.c);
        L.append(", hasBottomSheet=");
        L.append(this.d);
        L.append(", address=");
        L.append(this.e);
        L.append(", title=");
        L.append(this.f);
        L.append(", geoReference=");
        L.append(this.g);
        L.append(", itemId=");
        L.append(this.h);
        L.append(", amenityButtons=");
        L.append(this.i);
        L.append(", showMeOnMap=");
        L.append(this.j);
        L.append(", hasCreateRouteButton=");
        L.append(this.k);
        L.append(", shouldTrackMapMovement=");
        L.append(this.l);
        L.append(", fromPage=");
        return a.t(L, this.m, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.a, i2);
        parcel.writeInt(this.b ? 1 : 0);
        parcel.writeParcelable(this.c, i2);
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        List<GeoReference> list = this.g;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((GeoReference) l0.next(), i2);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.h);
        List<AmenityButton> list2 = this.i;
        if (list2 != null) {
            Iterator l02 = a.l0(parcel, 1, list2);
            while (l02.hasNext()) {
                parcel.writeParcelable((AmenityButton) l02.next(), i2);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeString(this.m);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemMapArguments(Coordinates coordinates, boolean z, Coordinates coordinates2, boolean z2, String str, String str2, List list, String str3, List list2, boolean z3, boolean z4, boolean z5, String str4, int i2, j jVar) {
        this((i2 & 1) != 0 ? null : coordinates, (i2 & 2) != 0 ? true : z, (i2 & 4) != 0 ? null : coordinates2, (i2 & 8) != 0 ? true : z2, (i2 & 16) != 0 ? null : str, (i2 & 32) != 0 ? null : str2, (i2 & 64) != 0 ? null : list, (i2 & 128) != 0 ? null : str3, (i2 & 256) != 0 ? null : list2, (i2 & 512) == 0 ? z3 : true, (i2 & 1024) != 0 ? false : z4, (i2 & 2048) == 0 ? z5 : false, (i2 & 4096) == 0 ? str4 : null);
    }
}
