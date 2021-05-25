package com.avito.android.advert_core.map;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.developments_catalog.remote.model.MapPreview;
import com.avito.android.item_map.remote.model.AmenityButton;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.item.details.ParameterId;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.conveyor_item.ParcelableItem;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004Bq\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010;\u001a\u00020\u0017\u0012\u0006\u0010)\u001a\u00020$\u0012\u0006\u0010#\u001a\u00020\u0017\u0012\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*\u0012\b\u0010J\u001a\u0004\u0018\u00010E\u0012\u0006\u0010A\u001a\u00020<\u0012\u0006\u0010D\u001a\u00020\u0017\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\b\b\u0002\u00108\u001a\u000201\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\bK\u0010LJ\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010 \u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u0019\u0010#\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001bR\u0019\u0010)\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R!\u00100\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\"\u00108\u001a\u0002018\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0019\u0010;\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u0019\u001a\u0004\b:\u0010\u001bR\u001c\u0010A\u001a\u00020<8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001c\u0010D\u001a\u00020\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bB\u0010\u0019\u001a\u0004\bC\u0010\u001bR\u001b\u0010J\u001a\u0004\u0018\u00010E8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I¨\u0006M"}, d2 = {"Lcom/avito/android/advert_core/map/MapItem;", "Lcom/avito/conveyor_item/ParcelableItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/serp/adapter/SerpViewType;", "k", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getItemId", "()Ljava/lang/String;", "itemId", "i", "I", "getSpanCount", "spanCount", "d", "getAddress", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/Coordinates;", "c", "Lcom/avito/android/remote/model/Coordinates;", "getCoords", "()Lcom/avito/android/remote/model/Coordinates;", ParameterId.COORDS, "", "Lcom/avito/android/item_map/remote/model/AmenityButton;", "e", "Ljava/util/List;", "getAmenityButtons", "()Ljava/util/List;", "amenityButtons", "Lcom/avito/android/remote/model/SerpDisplayType;", "j", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", AuthSource.BOOKING_ORDER, "getTitle", "title", "", g.a, "J", "getId", "()J", "id", "h", "getStringId", "stringId", "Lcom/avito/android/developments_catalog/remote/model/MapPreview;", "f", "Lcom/avito/android/developments_catalog/remote/model/MapPreview;", "getMapPreview", "()Lcom/avito/android/developments_catalog/remote/model/MapPreview;", "mapPreview", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/developments_catalog/remote/model/MapPreview;JLjava/lang/String;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class MapItem implements ParcelableItem, BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<MapItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final Coordinates c;
    @NotNull
    public final String d;
    @Nullable
    public final List<AmenityButton> e;
    @Nullable
    public final MapPreview f;
    public final long g;
    @NotNull
    public final String h;
    public final int i;
    @NotNull
    public SerpDisplayType j;
    @NotNull
    public final SerpViewType k;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MapItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MapItem createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Coordinates coordinates = (Coordinates) parcel.readParcelable(MapItem.class.getClassLoader());
            String readString3 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((AmenityButton) parcel.readParcelable(MapItem.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new MapItem(readString, readString2, coordinates, readString3, arrayList, (MapPreview) parcel.readParcelable(MapItem.class.getClassLoader()), parcel.readLong(), parcel.readString(), parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MapItem[] newArray(int i) {
            return new MapItem[i];
        }
    }

    public MapItem(@NotNull String str, @NotNull String str2, @NotNull Coordinates coordinates, @NotNull String str3, @Nullable List<AmenityButton> list, @Nullable MapPreview mapPreview, long j2, @NotNull String str4, int i2, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(coordinates, ParameterId.COORDS);
        Intrinsics.checkNotNullParameter(str3, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        Intrinsics.checkNotNullParameter(str4, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = str;
        this.b = str2;
        this.c = coordinates;
        this.d = str3;
        this.e = list;
        this.f = mapPreview;
        this.g = j2;
        this.h = str4;
        this.i = i2;
        this.j = serpDisplayType;
        this.k = serpViewType;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i2) {
        return new MapItem(this.a, this.b, this.c, this.d, this.e, this.f, getId(), getStringId(), i2, getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getAddress() {
        return this.d;
    }

    @Nullable
    public final List<AmenityButton> getAmenityButtons() {
        return this.e;
    }

    @NotNull
    public final Coordinates getCoords() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.j;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.g;
    }

    @NotNull
    public final String getItemId() {
        return this.a;
    }

    @Nullable
    public final MapPreview getMapPreview() {
        return this.f;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.i;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.h;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.k;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.j = serpDisplayType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i2);
        parcel.writeString(this.d);
        List<AmenityButton> list = this.e;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((AmenityButton) l0.next(), i2);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.f, i2);
        parcel.writeLong(this.g);
        parcel.writeString(this.h);
        parcel.writeInt(this.i);
        parcel.writeString(this.j.name());
        parcel.writeString(this.k.name());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MapItem(String str, String str2, Coordinates coordinates, String str3, List list, MapPreview mapPreview, long j2, String str4, int i2, SerpDisplayType serpDisplayType, SerpViewType serpViewType, int i3, j jVar) {
        this((i3 & 1) != 0 ? "" : str, str2, coordinates, str3, list, mapPreview, j2, str4, (i3 & 256) != 0 ? 1 : i2, (i3 & 512) != 0 ? SerpDisplayType.Grid : serpDisplayType, (i3 & 1024) != 0 ? SerpViewType.SINGLE : serpViewType);
    }
}
