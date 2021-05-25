package com.avito.android.advert.item.show_on_map;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.item.details.ParameterId;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.facebook.appevents.integrity.IntegrityManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BC\u0012\u0006\u0010\u0018\u001a\u00020\u0010\u0012\u0006\u00103\u001a\u00020\u0010\u0012\u0006\u00100\u001a\u00020+\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010$\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u0019\u0012\b\b\u0002\u0010*\u001a\u00020%¢\u0006\u0004\b4\u00105J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\"\u0010 \u001a\u00020\u00198\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010$\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\tR\u001c\u0010*\u001a\u00020%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0019\u00100\u001a\u00020+8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0019\u00103\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0012\u001a\u0004\b2\u0010\u0014¨\u00066"}, d2 = {"Lcom/avito/android/advert/item/show_on_map/AdvertDetailsShowOnMapItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "d", "Ljava/lang/String;", "getAddress", "()Ljava/lang/String;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, AuthSource.SEND_ABUSE, "getStringId", "stringId", "Lcom/avito/android/remote/model/SerpDisplayType;", "f", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "e", "I", "getSpanCount", "spanCount", "Lcom/avito/android/serp/adapter/SerpViewType;", g.a, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "Lcom/avito/android/remote/model/Coordinates;", "c", "Lcom/avito/android/remote/model/Coordinates;", "getCoords", "()Lcom/avito/android/remote/model/Coordinates;", ParameterId.COORDS, AuthSource.BOOKING_ORDER, "getTitle", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsShowOnMapItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<AdvertDetailsShowOnMapItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final Coordinates c;
    @NotNull
    public final String d;
    public final int e;
    @NotNull
    public SerpDisplayType f;
    @NotNull
    public final SerpViewType g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDetailsShowOnMapItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsShowOnMapItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertDetailsShowOnMapItem(parcel.readString(), parcel.readString(), (Coordinates) parcel.readParcelable(AdvertDetailsShowOnMapItem.class.getClassLoader()), parcel.readString(), parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsShowOnMapItem[] newArray(int i) {
            return new AdvertDetailsShowOnMapItem[i];
        }
    }

    public AdvertDetailsShowOnMapItem(@NotNull String str, @NotNull String str2, @NotNull Coordinates coordinates, @NotNull String str3, int i, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(coordinates, ParameterId.COORDS);
        Intrinsics.checkNotNullParameter(str3, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = str;
        this.b = str2;
        this.c = coordinates;
        this.d = str3;
        this.e = i;
        this.f = serpDisplayType;
        this.g = serpViewType;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i) {
        return new AdvertDetailsShowOnMapItem(getStringId(), this.b, this.c, this.d, i, getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getAddress() {
        return this.d;
    }

    @NotNull
    public final Coordinates getCoords() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return BlockItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.g;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.f = serpDisplayType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f.name());
        parcel.writeString(this.g.name());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertDetailsShowOnMapItem(String str, String str2, Coordinates coordinates, String str3, int i, SerpDisplayType serpDisplayType, SerpViewType serpViewType, int i2, j jVar) {
        this(str, str2, coordinates, str3, i, (i2 & 32) != 0 ? SerpDisplayType.Grid : serpDisplayType, (i2 & 64) != 0 ? SerpViewType.SINGLE : serpViewType);
    }
}
