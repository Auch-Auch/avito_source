package com.avito.android.auto_catalog.items.serp;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.auto_catalog.AutoCatalogItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B5\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010*\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0010\u0012\b\b\u0002\u0010&\u001a\u00020\u001f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0019¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u001c\u0010\u001e\u001a\u00020\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010*\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\t¨\u0006-"}, d2 = {"Lcom/avito/android/auto_catalog/items/serp/SerpHeaderItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "c", "getStringId", "stringId", "Lcom/avito/android/serp/adapter/SerpViewType;", "e", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "Lcom/avito/android/remote/model/SerpDisplayType;", "d", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", AuthSource.BOOKING_ORDER, "I", "getSpanCount", "spanCount", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class SerpHeaderItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<SerpHeaderItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    public final int b;
    @NotNull
    public final String c;
    @NotNull
    public SerpDisplayType d;
    @NotNull
    public final SerpViewType e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SerpHeaderItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SerpHeaderItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SerpHeaderItem(parcel.readString(), parcel.readInt(), parcel.readString(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SerpHeaderItem[] newArray(int i) {
            return new SerpHeaderItem[i];
        }
    }

    public SerpHeaderItem(@NotNull String str, int i, @NotNull String str2, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = serpDisplayType;
        this.e = serpViewType;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i) {
        return new SerpHeaderItem(this.a, i, getStringId(), getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return BlockItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c;
    }

    @NotNull
    public final String getText() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.d = serpDisplayType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d.name());
        parcel.writeString(this.e.name());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SerpHeaderItem(String str, int i, String str2, SerpDisplayType serpDisplayType, SerpViewType serpViewType, int i2, j jVar) {
        this(str, i, (i2 & 4) != 0 ? AutoCatalogItem.ITEM_SERP_HEADER.toString() : str2, (i2 & 8) != 0 ? SerpDisplayType.Grid : serpDisplayType, (i2 & 16) != 0 ? SerpViewType.SINGLE : serpViewType);
    }
}
