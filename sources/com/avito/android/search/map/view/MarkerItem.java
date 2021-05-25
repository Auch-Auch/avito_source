package com.avito.android.search.map.view;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ServiceTypeKt;
import com.avito.android.remote.model.search.map.Form;
import com.avito.android.remote.model.search.map.Highlight;
import com.google.android.gms.maps.model.LatLng;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u000b\f\r\u000eB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0001\u0004\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/search/map/view/MarkerItem;", "Landroid/os/Parcelable;", "", "getMapId", "()Ljava/lang/String;", "Lcom/google/android/gms/maps/model/LatLng;", "getCoordinates", "()Lcom/google/android/gms/maps/model/LatLng;", "coordinates", "<init>", "()V", "MyLocation", "Pin", "Rash", "SpecialPin", "Lcom/avito/android/search/map/view/MarkerItem$MyLocation;", "Lcom/avito/android/search/map/view/MarkerItem$Pin;", "Lcom/avito/android/search/map/view/MarkerItem$Rash;", "Lcom/avito/android/search/map/view/MarkerItem$SpecialPin;", "map_release"}, k = 1, mv = {1, 4, 2})
public abstract class MarkerItem implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007¨\u0006 "}, d2 = {"Lcom/avito/android/search/map/view/MarkerItem$MyLocation;", "Lcom/avito/android/search/map/view/MarkerItem;", "", "getMapId", "()Ljava/lang/String;", "Lcom/google/android/gms/maps/model/LatLng;", "component1", "()Lcom/google/android/gms/maps/model/LatLng;", "coordinates", "copy", "(Lcom/google/android/gms/maps/model/LatLng;)Lcom/avito/android/search/map/view/MarkerItem$MyLocation;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Lcom/google/android/gms/maps/model/LatLng;", "getCoordinates", "<init>", "(Lcom/google/android/gms/maps/model/LatLng;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class MyLocation extends MarkerItem {
        public static final Parcelable.Creator<MyLocation> CREATOR = new Creator();
        @NotNull
        public final LatLng a;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<MyLocation> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final MyLocation createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new MyLocation(LatLng.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final MyLocation[] newArray(int i) {
                return new MyLocation[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MyLocation(@NotNull LatLng latLng) {
            super(null);
            Intrinsics.checkNotNullParameter(latLng, "coordinates");
            this.a = latLng;
        }

        public static /* synthetic */ MyLocation copy$default(MyLocation myLocation, LatLng latLng, int i, Object obj) {
            if ((i & 1) != 0) {
                latLng = myLocation.getCoordinates();
            }
            return myLocation.copy(latLng);
        }

        @NotNull
        public final LatLng component1() {
            return getCoordinates();
        }

        @NotNull
        public final MyLocation copy(@NotNull LatLng latLng) {
            Intrinsics.checkNotNullParameter(latLng, "coordinates");
            return new MyLocation(latLng);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof MyLocation) && Intrinsics.areEqual(getCoordinates(), ((MyLocation) obj).getCoordinates());
            }
            return true;
        }

        @Override // com.avito.android.search.map.view.MarkerItem
        @NotNull
        public LatLng getCoordinates() {
            return this.a;
        }

        @Override // com.avito.android.search.map.view.MarkerItem
        @NotNull
        public String getMapId() {
            return MarkerItemKt.ID_MY_LOCATION;
        }

        @Override // java.lang.Object
        public int hashCode() {
            LatLng coordinates = getCoordinates();
            if (coordinates != null) {
                return coordinates.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("MyLocation(coordinates=");
            L.append(getCoordinates());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.a.writeToParcel(parcel, 0);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010!\n\u0002\b)\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007Bq\u0012\u0006\u0010 \u001a\u00020\b\u0012\b\u0010!\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\"\u001a\u00020\r\u0012\u0006\u0010#\u001a\u00020\u0010\u0012\u0006\u0010$\u001a\u00020\u0013\u0012\b\b\u0002\u0010%\u001a\u00020\r\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010'\u001a\u00020\r\u0012\u0006\u0010(\u001a\u00020\b\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\bn\u0010oJ\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u000fJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0017\u0010\nJ\u0010\u0010\u0018\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u000fJ\u0010\u0010\u0019\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0019\u0010\nJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\"\u001a\u00020\r2\b\b\u0002\u0010#\u001a\u00020\u00102\b\b\u0002\u0010$\u001a\u00020\u00132\b\b\u0002\u0010%\u001a\u00020\r2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001dHÆ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b-\u0010\nJ\u0010\u0010.\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b.\u0010\u0015J\u001a\u00101\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u00010/HÖ\u0003¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b3\u0010\u0015J \u00108\u001a\u0002072\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b8\u00109R\u001c\u0010(\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010\nR.\u0010F\u001a\b\u0012\u0004\u0012\u00020\b0=8\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\b>\u0010?\u0012\u0004\bD\u0010E\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR.\u0010L\u001a\b\u0012\u0004\u0012\u00020\b0G8\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\bH\u0010?\u0012\u0004\bK\u0010E\u001a\u0004\bI\u0010A\"\u0004\bJ\u0010CR\"\u0010 \u001a\u00020\b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bM\u0010;\u001a\u0004\bN\u0010\n\"\u0004\bO\u0010PR\u001c\u0010#\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010\u0012R\"\u0010%\u001a\u00020\r8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\b%\u0010\u000f\"\u0004\bV\u0010WR\u001e\u0010)\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010\u001cR$\u0010!\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b[\u0010;\u001a\u0004\b\\\u0010\n\"\u0004\b]\u0010PR\"\u0010$\u001a\u00020\u00138\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010\u0015\"\u0004\ba\u0010bR\u001e\u0010*\u001a\u0004\u0018\u00010\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010\u001fR\"\u0010\"\u001a\u00020\r8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bf\u0010U\u001a\u0004\bg\u0010\u000f\"\u0004\bh\u0010WR\"\u0010'\u001a\u00020\r8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bi\u0010U\u001a\u0004\b'\u0010\u000f\"\u0004\bj\u0010WR$\u0010&\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bk\u0010;\u001a\u0004\bl\u0010\n\"\u0004\bm\u0010P¨\u0006p"}, d2 = {"Lcom/avito/android/search/map/view/MarkerItem$Pin;", "Lcom/avito/android/search/map/view/MarkerItem;", "Lcom/avito/android/search/map/view/PartialMarker;", "Lcom/avito/android/search/map/view/MarkerWithPrice;", "Lcom/avito/android/search/map/view/MarkerWithMultipleItemIds;", "Lcom/avito/android/search/map/view/MarkerWithId;", "Lcom/avito/android/search/map/view/MarkerWithHighlight;", "Lcom/avito/android/search/map/view/MarkerWithForm;", "", "getMapId", "()Ljava/lang/String;", "component1", "component2", "", "component3", "()Z", "Lcom/google/android/gms/maps/model/LatLng;", "component4", "()Lcom/google/android/gms/maps/model/LatLng;", "", "component5", "()I", "component6", "component7", "component8", "component9", "Lcom/avito/android/remote/model/search/map/Form;", "component10", "()Lcom/avito/android/remote/model/search/map/Form;", "Lcom/avito/android/remote/model/search/map/Highlight;", "component11", "()Lcom/avito/android/remote/model/search/map/Highlight;", "id", "text", "selected", "coordinates", "count", "isViewed", "price", "isFavorite", "favoritesIds", "form", ServiceTypeKt.SERVICE_HIGHLIGHT, "copy", "(Ljava/lang/String;Ljava/lang/String;ZLcom/google/android/gms/maps/model/LatLng;IZLjava/lang/String;ZLjava/lang/String;Lcom/avito/android/remote/model/search/map/Form;Lcom/avito/android/remote/model/search/map/Highlight;)Lcom/avito/android/search/map/view/MarkerItem$Pin;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "k", "Ljava/lang/String;", "getFavoritesIds", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getListIds", "()Ljava/util/List;", "setListIds", "(Ljava/util/List;)V", "getListIds$annotations", "()V", "listIds", "", AuthSource.BOOKING_ORDER, "getListFavoritesIds", "setListFavoritesIds", "getListFavoritesIds$annotations", "listFavoritesIds", "c", "getId", "setId", "(Ljava/lang/String;)V", "f", "Lcom/google/android/gms/maps/model/LatLng;", "getCoordinates", "h", "Z", "setViewed", "(Z)V", "l", "Lcom/avito/android/remote/model/search/map/Form;", "getForm", "d", "getText", "setText", g.a, "I", "getCount", "setCount", "(I)V", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/remote/model/search/map/Highlight;", "getHighlight", "e", "getSelected", "setSelected", "j", "setFavorite", "i", "getPrice", "setPrice", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLcom/google/android/gms/maps/model/LatLng;IZLjava/lang/String;ZLjava/lang/String;Lcom/avito/android/remote/model/search/map/Form;Lcom/avito/android/remote/model/search/map/Highlight;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class Pin extends MarkerItem implements PartialMarker, MarkerWithPrice, MarkerWithMultipleItemIds, MarkerWithId, MarkerWithHighlight, MarkerWithForm {
        public static final Parcelable.Creator<Pin> CREATOR = new Creator();
        @NotNull
        public List<String> a;
        @NotNull
        public List<String> b;
        @NotNull
        public String c;
        @Nullable
        public String d;
        public boolean e;
        @NotNull
        public final LatLng f;
        public int g;
        public boolean h;
        @Nullable
        public String i;
        public boolean j;
        @NotNull
        public final String k;
        @Nullable
        public final Form l;
        @Nullable
        public final Highlight m;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Pin> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Pin createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Pin(parcel.readString(), parcel.readString(), parcel.readInt() != 0, LatLng.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0 ? (Form) Enum.valueOf(Form.class, parcel.readString()) : null, parcel.readInt() != 0 ? (Highlight) Enum.valueOf(Highlight.class, parcel.readString()) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Pin[] newArray(int i) {
                return new Pin[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Pin(String str, String str2, boolean z, LatLng latLng, int i2, boolean z2, String str3, boolean z3, String str4, Form form, Highlight highlight, int i3, j jVar) {
            this(str, str2, z, latLng, i2, (i3 & 32) != 0 ? false : z2, (i3 & 64) != 0 ? null : str3, (i3 & 128) != 0 ? false : z3, str4, (i3 & 512) != 0 ? null : form, (i3 & 1024) != 0 ? null : highlight);
        }

        public static /* synthetic */ Pin copy$default(Pin pin, String str, String str2, boolean z, LatLng latLng, int i2, boolean z2, String str3, boolean z3, String str4, Form form, Highlight highlight, int i3, Object obj) {
            return pin.copy((i3 & 1) != 0 ? pin.getId() : str, (i3 & 2) != 0 ? pin.getText() : str2, (i3 & 4) != 0 ? pin.getSelected() : z, (i3 & 8) != 0 ? pin.getCoordinates() : latLng, (i3 & 16) != 0 ? pin.getCount() : i2, (i3 & 32) != 0 ? pin.isViewed() : z2, (i3 & 64) != 0 ? pin.getPrice() : str3, (i3 & 128) != 0 ? pin.isFavorite() : z3, (i3 & 256) != 0 ? pin.getFavoritesIds() : str4, (i3 & 512) != 0 ? pin.getForm() : form, (i3 & 1024) != 0 ? pin.getHighlight() : highlight);
        }

        public static /* synthetic */ void getListFavoritesIds$annotations() {
        }

        public static /* synthetic */ void getListIds$annotations() {
        }

        @NotNull
        public final String component1() {
            return getId();
        }

        @Nullable
        public final Form component10() {
            return getForm();
        }

        @Nullable
        public final Highlight component11() {
            return getHighlight();
        }

        @Nullable
        public final String component2() {
            return getText();
        }

        public final boolean component3() {
            return getSelected();
        }

        @NotNull
        public final LatLng component4() {
            return getCoordinates();
        }

        public final int component5() {
            return getCount();
        }

        public final boolean component6() {
            return isViewed();
        }

        @Nullable
        public final String component7() {
            return getPrice();
        }

        public final boolean component8() {
            return isFavorite();
        }

        @NotNull
        public final String component9() {
            return getFavoritesIds();
        }

        @NotNull
        public final Pin copy(@NotNull String str, @Nullable String str2, boolean z, @NotNull LatLng latLng, int i2, boolean z2, @Nullable String str3, boolean z3, @NotNull String str4, @Nullable Form form, @Nullable Highlight highlight) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(latLng, "coordinates");
            Intrinsics.checkNotNullParameter(str4, "favoritesIds");
            return new Pin(str, str2, z, latLng, i2, z2, str3, z3, str4, form, highlight);
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
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            return Intrinsics.areEqual(getId(), pin.getId()) && Intrinsics.areEqual(getText(), pin.getText()) && getSelected() == pin.getSelected() && Intrinsics.areEqual(getCoordinates(), pin.getCoordinates()) && getCount() == pin.getCount() && isViewed() == pin.isViewed() && Intrinsics.areEqual(getPrice(), pin.getPrice()) && isFavorite() == pin.isFavorite() && Intrinsics.areEqual(getFavoritesIds(), pin.getFavoritesIds()) && Intrinsics.areEqual(getForm(), pin.getForm()) && Intrinsics.areEqual(getHighlight(), pin.getHighlight());
        }

        @Override // com.avito.android.search.map.view.MarkerItem
        @NotNull
        public LatLng getCoordinates() {
            return this.f;
        }

        @Override // com.avito.android.search.map.view.MarkerWithCount
        public int getCount() {
            return this.g;
        }

        @Override // com.avito.android.search.map.view.MarkerWithFavorite
        @NotNull
        public String getFavoritesIds() {
            return this.k;
        }

        @Override // com.avito.android.search.map.view.MarkerWithForm
        @Nullable
        public Form getForm() {
            return this.l;
        }

        @Override // com.avito.android.search.map.view.MarkerWithHighlight
        @Nullable
        public Highlight getHighlight() {
            return this.m;
        }

        @Override // com.avito.android.search.map.view.MarkerWithId
        @NotNull
        public String getId() {
            return this.c;
        }

        @Override // com.avito.android.search.map.view.MarkerWithFavorite
        @NotNull
        public List<String> getListFavoritesIds() {
            return this.b;
        }

        @Override // com.avito.android.search.map.view.MarkerWithMultipleItemIds
        @NotNull
        public List<String> getListIds() {
            return this.a;
        }

        @Override // com.avito.android.search.map.view.MarkerItem
        @NotNull
        public String getMapId() {
            return a.H(new Object[]{Integer.valueOf(getCount()), Boolean.valueOf(isViewed()), Boolean.valueOf(getSelected()), getPrice(), Boolean.valueOf(isFavorite()), getHighlight(), getForm()}, 7, "%s%s%s%s%s%s%s", "java.lang.String.format(this, *args)");
        }

        @Override // com.avito.android.search.map.view.MarkerWithPrice
        @Nullable
        public String getPrice() {
            return this.i;
        }

        @Override // com.avito.android.search.map.view.SelectableMarker
        public boolean getSelected() {
            return this.e;
        }

        @Override // com.avito.android.search.map.view.MarkerWithText
        @Nullable
        public String getText() {
            return this.d;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String id = getId();
            int i2 = 0;
            int hashCode = (id != null ? id.hashCode() : 0) * 31;
            String text = getText();
            int hashCode2 = (hashCode + (text != null ? text.hashCode() : 0)) * 31;
            boolean selected = getSelected();
            int i3 = 1;
            if (selected) {
                selected = true;
            }
            int i4 = selected ? 1 : 0;
            int i5 = selected ? 1 : 0;
            int i6 = selected ? 1 : 0;
            int i7 = (hashCode2 + i4) * 31;
            LatLng coordinates = getCoordinates();
            int count = (getCount() + ((i7 + (coordinates != null ? coordinates.hashCode() : 0)) * 31)) * 31;
            boolean isViewed = isViewed();
            if (isViewed) {
                isViewed = true;
            }
            int i8 = isViewed ? 1 : 0;
            int i9 = isViewed ? 1 : 0;
            int i10 = isViewed ? 1 : 0;
            int i11 = (count + i8) * 31;
            String price = getPrice();
            int hashCode3 = (i11 + (price != null ? price.hashCode() : 0)) * 31;
            boolean isFavorite = isFavorite();
            if (!isFavorite) {
                i3 = isFavorite;
            }
            int i12 = (hashCode3 + i3) * 31;
            String favoritesIds = getFavoritesIds();
            int hashCode4 = (i12 + (favoritesIds != null ? favoritesIds.hashCode() : 0)) * 31;
            Form form = getForm();
            int hashCode5 = (hashCode4 + (form != null ? form.hashCode() : 0)) * 31;
            Highlight highlight = getHighlight();
            if (highlight != null) {
                i2 = highlight.hashCode();
            }
            return hashCode5 + i2;
        }

        @Override // com.avito.android.search.map.view.MarkerWithFavorite
        public boolean isFavorite() {
            return this.j;
        }

        @Override // com.avito.android.search.map.view.ViewableMarker
        public boolean isViewed() {
            return this.h;
        }

        @Override // com.avito.android.search.map.view.MarkerWithCount
        public void setCount(int i2) {
            this.g = i2;
        }

        @Override // com.avito.android.search.map.view.MarkerWithFavorite
        public void setFavorite(boolean z) {
            this.j = z;
        }

        @Override // com.avito.android.search.map.view.MarkerWithId
        public void setId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.c = str;
        }

        @Override // com.avito.android.search.map.view.MarkerWithFavorite
        public void setListFavoritesIds(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.b = list;
        }

        @Override // com.avito.android.search.map.view.MarkerWithMultipleItemIds
        public void setListIds(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.a = list;
        }

        @Override // com.avito.android.search.map.view.MarkerWithPrice
        public void setPrice(@Nullable String str) {
            this.i = str;
        }

        @Override // com.avito.android.search.map.view.SelectableMarker
        public void setSelected(boolean z) {
            this.e = z;
        }

        @Override // com.avito.android.search.map.view.MarkerWithText
        public void setText(@Nullable String str) {
            this.d = str;
        }

        @Override // com.avito.android.search.map.view.ViewableMarker
        public void setViewed(boolean z) {
            this.h = z;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Pin(id=");
            L.append(getId());
            L.append(", text=");
            L.append(getText());
            L.append(", selected=");
            L.append(getSelected());
            L.append(", coordinates=");
            L.append(getCoordinates());
            L.append(", count=");
            L.append(getCount());
            L.append(", isViewed=");
            L.append(isViewed());
            L.append(", price=");
            L.append(getPrice());
            L.append(", isFavorite=");
            L.append(isFavorite());
            L.append(", favoritesIds=");
            L.append(getFavoritesIds());
            L.append(", form=");
            L.append(getForm());
            L.append(", highlight=");
            L.append(getHighlight());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i2) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeInt(this.e ? 1 : 0);
            this.f.writeToParcel(parcel, 0);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeString(this.i);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeString(this.k);
            Form form = this.l;
            if (form != null) {
                parcel.writeInt(1);
                parcel.writeString(form.name());
            } else {
                parcel.writeInt(0);
            }
            Highlight highlight = this.m;
            if (highlight != null) {
                parcel.writeInt(1);
                parcel.writeString(highlight.name());
                return;
            }
            parcel.writeInt(0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Pin(@NotNull String str, @Nullable String str2, boolean z, @NotNull LatLng latLng, int i2, boolean z2, @Nullable String str3, boolean z3, @NotNull String str4, @Nullable Form form, @Nullable Highlight highlight) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(latLng, "coordinates");
            Intrinsics.checkNotNullParameter(str4, "favoritesIds");
            this.c = str;
            this.d = str2;
            this.e = z;
            this.f = latLng;
            this.g = i2;
            this.h = z2;
            this.i = str3;
            this.j = z3;
            this.k = str4;
            this.l = form;
            this.m = highlight;
            this.a = StringsKt__StringsKt.split$default((CharSequence) getId(), new String[]{","}, false, 0, 6, (Object) null);
            this.b = CollectionsKt___CollectionsKt.toMutableList((Collection) StringsKt__StringsKt.split$default((CharSequence) getFavoritesIds(), new String[]{","}, false, 0, 6, (Object) null));
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010!\n\u0002\b)\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006Be\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u000b\u0012\u0006\u0010 \u001a\u00020\u000e\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\"\u001a\u00020\u0012\u0012\b\b\u0002\u0010#\u001a\u00020\u000b\u0012\b\b\u0002\u0010$\u001a\u00020\u000b\u0012\u0006\u0010%\u001a\u00020\u0007\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\bh\u0010iJ\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0011\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0015\u0010\rJ\u0010\u0010\u0016\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0016\u0010\rJ\u0010\u0010\u0017\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0017\u0010\tJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJz\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u00072\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001bHÆ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b*\u0010\tJ\u0010\u0010+\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b+\u0010\u0014J\u001a\u0010.\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010,HÖ\u0003¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b0\u0010\u0014J \u00105\u001a\u0002042\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b5\u00106R.\u0010@\u001a\b\u0012\u0004\u0012\u00020\u0007078\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\b8\u00109\u0012\u0004\b>\u0010?\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R.\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00070A8\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\bB\u00109\u0012\u0004\bE\u0010?\u001a\u0004\bC\u0010;\"\u0004\bD\u0010=R\"\u0010\u001f\u001a\u00020\u000b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010\r\"\u0004\bJ\u0010KR\u001e\u0010&\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010\u001aR\"\u0010$\u001a\u00020\u000b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bO\u0010H\u001a\u0004\b$\u0010\r\"\u0004\bP\u0010KR\u001e\u0010'\u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010\u001dR$\u0010!\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010\t\"\u0004\bW\u0010XR\"\u0010\u001e\u001a\u00020\u00078\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bY\u0010U\u001a\u0004\bZ\u0010\t\"\u0004\b[\u0010XR\u001c\u0010 \u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010\u0010R\"\u0010\"\u001a\u00020\u00128\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010\u0014\"\u0004\bb\u0010cR\"\u0010#\u001a\u00020\u000b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bd\u0010H\u001a\u0004\b#\u0010\r\"\u0004\be\u0010KR\u001c\u0010%\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bf\u0010U\u001a\u0004\bg\u0010\t¨\u0006j"}, d2 = {"Lcom/avito/android/search/map/view/MarkerItem$Rash;", "Lcom/avito/android/search/map/view/MarkerItem;", "Lcom/avito/android/search/map/view/PartialMarker;", "Lcom/avito/android/search/map/view/MarkerWithMultipleItemIds;", "Lcom/avito/android/search/map/view/MarkerWithId;", "Lcom/avito/android/search/map/view/MarkerWithHighlight;", "Lcom/avito/android/search/map/view/MarkerWithForm;", "", "getMapId", "()Ljava/lang/String;", "component1", "", "component2", "()Z", "Lcom/google/android/gms/maps/model/LatLng;", "component3", "()Lcom/google/android/gms/maps/model/LatLng;", "component4", "", "component5", "()I", "component6", "component7", "component8", "Lcom/avito/android/remote/model/search/map/Form;", "component9", "()Lcom/avito/android/remote/model/search/map/Form;", "Lcom/avito/android/remote/model/search/map/Highlight;", "component10", "()Lcom/avito/android/remote/model/search/map/Highlight;", "id", "selected", "coordinates", "text", "count", "isViewed", "isFavorite", "favoritesIds", "form", ServiceTypeKt.SERVICE_HIGHLIGHT, "copy", "(Ljava/lang/String;ZLcom/google/android/gms/maps/model/LatLng;Ljava/lang/String;IZZLjava/lang/String;Lcom/avito/android/remote/model/search/map/Form;Lcom/avito/android/remote/model/search/map/Highlight;)Lcom/avito/android/search/map/view/MarkerItem$Rash;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getListIds", "()Ljava/util/List;", "setListIds", "(Ljava/util/List;)V", "getListIds$annotations", "()V", "listIds", "", AuthSource.BOOKING_ORDER, "getListFavoritesIds", "setListFavoritesIds", "getListFavoritesIds$annotations", "listFavoritesIds", "d", "Z", "getSelected", "setSelected", "(Z)V", "k", "Lcom/avito/android/remote/model/search/map/Form;", "getForm", "i", "setFavorite", "l", "Lcom/avito/android/remote/model/search/map/Highlight;", "getHighlight", "f", "Ljava/lang/String;", "getText", "setText", "(Ljava/lang/String;)V", "c", "getId", "setId", "e", "Lcom/google/android/gms/maps/model/LatLng;", "getCoordinates", g.a, "I", "getCount", "setCount", "(I)V", "h", "setViewed", "j", "getFavoritesIds", "<init>", "(Ljava/lang/String;ZLcom/google/android/gms/maps/model/LatLng;Ljava/lang/String;IZZLjava/lang/String;Lcom/avito/android/remote/model/search/map/Form;Lcom/avito/android/remote/model/search/map/Highlight;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class Rash extends MarkerItem implements PartialMarker, MarkerWithMultipleItemIds, MarkerWithId, MarkerWithHighlight, MarkerWithForm {
        public static final Parcelable.Creator<Rash> CREATOR = new Creator();
        @NotNull
        public List<String> a;
        @NotNull
        public List<String> b;
        @NotNull
        public String c;
        public boolean d;
        @NotNull
        public final LatLng e;
        @Nullable
        public String f;
        public int g;
        public boolean h;
        public boolean i;
        @NotNull
        public final String j;
        @Nullable
        public final Form k;
        @Nullable
        public final Highlight l;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Rash> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Rash createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Rash(parcel.readString(), parcel.readInt() != 0, LatLng.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0 ? (Form) Enum.valueOf(Form.class, parcel.readString()) : null, parcel.readInt() != 0 ? (Highlight) Enum.valueOf(Highlight.class, parcel.readString()) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Rash[] newArray(int i) {
                return new Rash[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Rash(String str, boolean z, LatLng latLng, String str2, int i2, boolean z2, boolean z3, String str3, Form form, Highlight highlight, int i3, j jVar) {
            this(str, z, latLng, str2, i2, (i3 & 32) != 0 ? false : z2, (i3 & 64) != 0 ? false : z3, str3, (i3 & 256) != 0 ? null : form, (i3 & 512) != 0 ? null : highlight);
        }

        public static /* synthetic */ Rash copy$default(Rash rash, String str, boolean z, LatLng latLng, String str2, int i2, boolean z2, boolean z3, String str3, Form form, Highlight highlight, int i3, Object obj) {
            return rash.copy((i3 & 1) != 0 ? rash.getId() : str, (i3 & 2) != 0 ? rash.getSelected() : z, (i3 & 4) != 0 ? rash.getCoordinates() : latLng, (i3 & 8) != 0 ? rash.getText() : str2, (i3 & 16) != 0 ? rash.getCount() : i2, (i3 & 32) != 0 ? rash.isViewed() : z2, (i3 & 64) != 0 ? rash.isFavorite() : z3, (i3 & 128) != 0 ? rash.getFavoritesIds() : str3, (i3 & 256) != 0 ? rash.getForm() : form, (i3 & 512) != 0 ? rash.getHighlight() : highlight);
        }

        public static /* synthetic */ void getListFavoritesIds$annotations() {
        }

        public static /* synthetic */ void getListIds$annotations() {
        }

        @NotNull
        public final String component1() {
            return getId();
        }

        @Nullable
        public final Highlight component10() {
            return getHighlight();
        }

        public final boolean component2() {
            return getSelected();
        }

        @NotNull
        public final LatLng component3() {
            return getCoordinates();
        }

        @Nullable
        public final String component4() {
            return getText();
        }

        public final int component5() {
            return getCount();
        }

        public final boolean component6() {
            return isViewed();
        }

        public final boolean component7() {
            return isFavorite();
        }

        @NotNull
        public final String component8() {
            return getFavoritesIds();
        }

        @Nullable
        public final Form component9() {
            return getForm();
        }

        @NotNull
        public final Rash copy(@NotNull String str, boolean z, @NotNull LatLng latLng, @Nullable String str2, int i2, boolean z2, boolean z3, @NotNull String str3, @Nullable Form form, @Nullable Highlight highlight) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(latLng, "coordinates");
            Intrinsics.checkNotNullParameter(str3, "favoritesIds");
            return new Rash(str, z, latLng, str2, i2, z2, z3, str3, form, highlight);
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
            if (!(obj instanceof Rash)) {
                return false;
            }
            Rash rash = (Rash) obj;
            return Intrinsics.areEqual(getId(), rash.getId()) && getSelected() == rash.getSelected() && Intrinsics.areEqual(getCoordinates(), rash.getCoordinates()) && Intrinsics.areEqual(getText(), rash.getText()) && getCount() == rash.getCount() && isViewed() == rash.isViewed() && isFavorite() == rash.isFavorite() && Intrinsics.areEqual(getFavoritesIds(), rash.getFavoritesIds()) && Intrinsics.areEqual(getForm(), rash.getForm()) && Intrinsics.areEqual(getHighlight(), rash.getHighlight());
        }

        @Override // com.avito.android.search.map.view.MarkerItem
        @NotNull
        public LatLng getCoordinates() {
            return this.e;
        }

        @Override // com.avito.android.search.map.view.MarkerWithCount
        public int getCount() {
            return this.g;
        }

        @Override // com.avito.android.search.map.view.MarkerWithFavorite
        @NotNull
        public String getFavoritesIds() {
            return this.j;
        }

        @Override // com.avito.android.search.map.view.MarkerWithForm
        @Nullable
        public Form getForm() {
            return this.k;
        }

        @Override // com.avito.android.search.map.view.MarkerWithHighlight
        @Nullable
        public Highlight getHighlight() {
            return this.l;
        }

        @Override // com.avito.android.search.map.view.MarkerWithId
        @NotNull
        public String getId() {
            return this.c;
        }

        @Override // com.avito.android.search.map.view.MarkerWithFavorite
        @NotNull
        public List<String> getListFavoritesIds() {
            return this.b;
        }

        @Override // com.avito.android.search.map.view.MarkerWithMultipleItemIds
        @NotNull
        public List<String> getListIds() {
            return this.a;
        }

        @Override // com.avito.android.search.map.view.MarkerItem
        @NotNull
        public String getMapId() {
            return a.H(new Object[]{Integer.valueOf(getCount()), Boolean.valueOf(isViewed()), Boolean.valueOf(getSelected()), Boolean.valueOf(isFavorite()), getHighlight(), getForm()}, 6, "%s%s%s%s%s%s", "java.lang.String.format(this, *args)");
        }

        @Override // com.avito.android.search.map.view.SelectableMarker
        public boolean getSelected() {
            return this.d;
        }

        @Override // com.avito.android.search.map.view.MarkerWithText
        @Nullable
        public String getText() {
            return this.f;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String id = getId();
            int i2 = 0;
            int hashCode = (id != null ? id.hashCode() : 0) * 31;
            boolean selected = getSelected();
            int i3 = 1;
            if (selected) {
                selected = true;
            }
            int i4 = selected ? 1 : 0;
            int i5 = selected ? 1 : 0;
            int i6 = selected ? 1 : 0;
            int i7 = (hashCode + i4) * 31;
            LatLng coordinates = getCoordinates();
            int hashCode2 = (i7 + (coordinates != null ? coordinates.hashCode() : 0)) * 31;
            String text = getText();
            int count = (getCount() + ((hashCode2 + (text != null ? text.hashCode() : 0)) * 31)) * 31;
            boolean isViewed = isViewed();
            if (isViewed) {
                isViewed = true;
            }
            int i8 = isViewed ? 1 : 0;
            int i9 = isViewed ? 1 : 0;
            int i10 = isViewed ? 1 : 0;
            int i11 = (count + i8) * 31;
            boolean isFavorite = isFavorite();
            if (!isFavorite) {
                i3 = isFavorite;
            }
            int i12 = (i11 + i3) * 31;
            String favoritesIds = getFavoritesIds();
            int hashCode3 = (i12 + (favoritesIds != null ? favoritesIds.hashCode() : 0)) * 31;
            Form form = getForm();
            int hashCode4 = (hashCode3 + (form != null ? form.hashCode() : 0)) * 31;
            Highlight highlight = getHighlight();
            if (highlight != null) {
                i2 = highlight.hashCode();
            }
            return hashCode4 + i2;
        }

        @Override // com.avito.android.search.map.view.MarkerWithFavorite
        public boolean isFavorite() {
            return this.i;
        }

        @Override // com.avito.android.search.map.view.ViewableMarker
        public boolean isViewed() {
            return this.h;
        }

        @Override // com.avito.android.search.map.view.MarkerWithCount
        public void setCount(int i2) {
            this.g = i2;
        }

        @Override // com.avito.android.search.map.view.MarkerWithFavorite
        public void setFavorite(boolean z) {
            this.i = z;
        }

        @Override // com.avito.android.search.map.view.MarkerWithId
        public void setId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.c = str;
        }

        @Override // com.avito.android.search.map.view.MarkerWithFavorite
        public void setListFavoritesIds(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.b = list;
        }

        @Override // com.avito.android.search.map.view.MarkerWithMultipleItemIds
        public void setListIds(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.a = list;
        }

        @Override // com.avito.android.search.map.view.SelectableMarker
        public void setSelected(boolean z) {
            this.d = z;
        }

        @Override // com.avito.android.search.map.view.MarkerWithText
        public void setText(@Nullable String str) {
            this.f = str;
        }

        @Override // com.avito.android.search.map.view.ViewableMarker
        public void setViewed(boolean z) {
            this.h = z;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Rash(id=");
            L.append(getId());
            L.append(", selected=");
            L.append(getSelected());
            L.append(", coordinates=");
            L.append(getCoordinates());
            L.append(", text=");
            L.append(getText());
            L.append(", count=");
            L.append(getCount());
            L.append(", isViewed=");
            L.append(isViewed());
            L.append(", isFavorite=");
            L.append(isFavorite());
            L.append(", favoritesIds=");
            L.append(getFavoritesIds());
            L.append(", form=");
            L.append(getForm());
            L.append(", highlight=");
            L.append(getHighlight());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i2) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.c);
            parcel.writeInt(this.d ? 1 : 0);
            this.e.writeToParcel(parcel, 0);
            parcel.writeString(this.f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeString(this.j);
            Form form = this.k;
            if (form != null) {
                parcel.writeInt(1);
                parcel.writeString(form.name());
            } else {
                parcel.writeInt(0);
            }
            Highlight highlight = this.l;
            if (highlight != null) {
                parcel.writeInt(1);
                parcel.writeString(highlight.name());
                return;
            }
            parcel.writeInt(0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Rash(@NotNull String str, boolean z, @NotNull LatLng latLng, @Nullable String str2, int i2, boolean z2, boolean z3, @NotNull String str3, @Nullable Form form, @Nullable Highlight highlight) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(latLng, "coordinates");
            Intrinsics.checkNotNullParameter(str3, "favoritesIds");
            this.c = str;
            this.d = z;
            this.e = latLng;
            this.f = str2;
            this.g = i2;
            this.h = z2;
            this.i = z3;
            this.j = str3;
            this.k = form;
            this.l = highlight;
            this.a = StringsKt__StringsKt.split$default((CharSequence) getId(), new String[]{","}, false, 0, 6, (Object) null);
            this.b = CollectionsKt___CollectionsKt.toMutableList((Collection) StringsKt__StringsKt.split$default((CharSequence) getFavoritesIds(), new String[]{","}, false, 0, 6, (Object) null));
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0005\"\u0004\b!\u0010\"R\u001c\u0010\u000b\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\t¨\u0006("}, d2 = {"Lcom/avito/android/search/map/view/MarkerItem$SpecialPin;", "Lcom/avito/android/search/map/view/MarkerItem;", "Lcom/avito/android/search/map/view/MarkerWithId;", "", "getMapId", "()Ljava/lang/String;", "component1", "Lcom/google/android/gms/maps/model/LatLng;", "component2", "()Lcom/google/android/gms/maps/model/LatLng;", "id", "coordinates", "copy", "(Ljava/lang/String;Lcom/google/android/gms/maps/model/LatLng;)Lcom/avito/android/search/map/view/MarkerItem$SpecialPin;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "setId", "(Ljava/lang/String;)V", AuthSource.BOOKING_ORDER, "Lcom/google/android/gms/maps/model/LatLng;", "getCoordinates", "<init>", "(Ljava/lang/String;Lcom/google/android/gms/maps/model/LatLng;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class SpecialPin extends MarkerItem implements MarkerWithId {
        public static final Parcelable.Creator<SpecialPin> CREATOR = new Creator();
        @NotNull
        public String a;
        @NotNull
        public final LatLng b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<SpecialPin> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final SpecialPin createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new SpecialPin(parcel.readString(), LatLng.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final SpecialPin[] newArray(int i) {
                return new SpecialPin[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SpecialPin(@NotNull String str, @NotNull LatLng latLng) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(latLng, "coordinates");
            this.a = str;
            this.b = latLng;
        }

        public static /* synthetic */ SpecialPin copy$default(SpecialPin specialPin, String str, LatLng latLng, int i, Object obj) {
            if ((i & 1) != 0) {
                str = specialPin.getId();
            }
            if ((i & 2) != 0) {
                latLng = specialPin.getCoordinates();
            }
            return specialPin.copy(str, latLng);
        }

        @NotNull
        public final String component1() {
            return getId();
        }

        @NotNull
        public final LatLng component2() {
            return getCoordinates();
        }

        @NotNull
        public final SpecialPin copy(@NotNull String str, @NotNull LatLng latLng) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(latLng, "coordinates");
            return new SpecialPin(str, latLng);
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
            if (!(obj instanceof SpecialPin)) {
                return false;
            }
            SpecialPin specialPin = (SpecialPin) obj;
            return Intrinsics.areEqual(getId(), specialPin.getId()) && Intrinsics.areEqual(getCoordinates(), specialPin.getCoordinates());
        }

        @Override // com.avito.android.search.map.view.MarkerItem
        @NotNull
        public LatLng getCoordinates() {
            return this.b;
        }

        @Override // com.avito.android.search.map.view.MarkerWithId
        @NotNull
        public String getId() {
            return this.a;
        }

        @Override // com.avito.android.search.map.view.MarkerItem
        @NotNull
        public String getMapId() {
            return a.H(new Object[]{getCoordinates()}, 1, "special_pin_%s", "java.lang.String.format(this, *args)");
        }

        @Override // java.lang.Object
        public int hashCode() {
            String id = getId();
            int i = 0;
            int hashCode = (id != null ? id.hashCode() : 0) * 31;
            LatLng coordinates = getCoordinates();
            if (coordinates != null) {
                i = coordinates.hashCode();
            }
            return hashCode + i;
        }

        @Override // com.avito.android.search.map.view.MarkerWithId
        public void setId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.a = str;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("SpecialPin(id=");
            L.append(getId());
            L.append(", coordinates=");
            L.append(getCoordinates());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            this.b.writeToParcel(parcel, 0);
        }
    }

    public MarkerItem() {
    }

    @NotNull
    public abstract LatLng getCoordinates();

    @NotNull
    public abstract String getMapId();

    public MarkerItem(j jVar) {
    }
}
