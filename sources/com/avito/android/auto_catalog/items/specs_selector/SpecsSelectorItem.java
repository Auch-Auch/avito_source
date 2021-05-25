package com.avito.android.auto_catalog.items.specs_selector;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.auto_catalog.AutoCatalogItem;
import com.avito.android.auto_catalog.remote.model.ModificationItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BY\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010-\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u0012\u0006\u00105\u001a\u00020\u0004\u0012\b\b\u0002\u0010)\u001a\u00020\"\u0012\b\b\u0002\u0010=\u001a\u000208¢\u0006\u0004\b>\u0010?J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u000f\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010)\u001a\u00020\"8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0019\u0010-\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0012R\u0019\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010\u001cR\u0019\u0010\u000e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b\u000e\u00102R\u001c\u00105\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u0010+\u001a\u0004\b4\u0010\u0012R\u0019\u0010\n\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010+\u001a\u0004\b7\u0010\u0012R\u001c\u0010=\u001a\u0002088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<¨\u0006@"}, d2 = {"Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "", "titleSelected", "specsId", "Lcom/avito/android/auto_catalog/remote/model/ModificationItem;", "modification", "", "isClickableSelector", "copyWithModification", "(Ljava/lang/String;ILcom/avito/android/auto_catalog/remote/model/ModificationItem;Z)Lcom/avito/android/advert_core/advert/BlockItem;", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "f", "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "c", "Lcom/avito/android/auto_catalog/remote/model/ModificationItem;", "getModification", "()Lcom/avito/android/auto_catalog/remote/model/ModificationItem;", "Lcom/avito/android/remote/model/SerpDisplayType;", "h", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "e", "I", "getSchemePosition", "schemePosition", AuthSource.SEND_ABUSE, "getTitleSelected", "d", "Z", "()Z", g.a, "getSpanCount", "spanCount", AuthSource.BOOKING_ORDER, "getSpecsId", "Lcom/avito/android/serp/adapter/SerpViewType;", "i", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "<init>", "(Ljava/lang/String;ILcom/avito/android/auto_catalog/remote/model/ModificationItem;ZILjava/lang/String;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class SpecsSelectorItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<SpecsSelectorItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    public final int b;
    @Nullable
    public final ModificationItem c;
    public final boolean d;
    public final int e;
    @NotNull
    public final String f;
    public final int g;
    @NotNull
    public SerpDisplayType h;
    @NotNull
    public final SerpViewType i;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SpecsSelectorItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SpecsSelectorItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SpecsSelectorItem(parcel.readString(), parcel.readInt(), (ModificationItem) parcel.readParcelable(SpecsSelectorItem.class.getClassLoader()), parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SpecsSelectorItem[] newArray(int i) {
            return new SpecsSelectorItem[i];
        }
    }

    public SpecsSelectorItem(@NotNull String str, int i2, @Nullable ModificationItem modificationItem, boolean z, int i3, @NotNull String str2, int i4, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "titleSelected");
        Intrinsics.checkNotNullParameter(str2, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = str;
        this.b = i2;
        this.c = modificationItem;
        this.d = z;
        this.e = i3;
        this.f = str2;
        this.g = i4;
        this.h = serpDisplayType;
        this.i = serpViewType;
    }

    @NotNull
    public final BlockItem copyWithModification(@NotNull String str, int i2, @Nullable ModificationItem modificationItem, boolean z) {
        Intrinsics.checkNotNullParameter(str, "titleSelected");
        return new SpecsSelectorItem(str, i2, modificationItem, z, this.e, getStringId(), getSpanCount(), getDisplayType(), getViewType());
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i2) {
        return new SpecsSelectorItem(this.a, this.b, this.c, this.d, this.e, getStringId(), i2, getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.h;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return BlockItem.DefaultImpls.getId(this);
    }

    @Nullable
    public final ModificationItem getModification() {
        return this.c;
    }

    public final int getSchemePosition() {
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.g;
    }

    public final int getSpecsId() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.f;
    }

    @NotNull
    public final String getTitleSelected() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.i;
    }

    public final boolean isClickableSelector() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.h = serpDisplayType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeParcelable(this.c, i2);
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g);
        parcel.writeString(this.h.name());
        parcel.writeString(this.i.name());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SpecsSelectorItem(String str, int i2, ModificationItem modificationItem, boolean z, int i3, String str2, int i4, SerpDisplayType serpDisplayType, SerpViewType serpViewType, int i5, j jVar) {
        this(str, i2, modificationItem, z, (i5 & 16) != 0 ? -2 : i3, (i5 & 32) != 0 ? AutoCatalogItem.ITEM_SPECS_SELECTED.toString() : str2, i4, (i5 & 128) != 0 ? SerpDisplayType.Grid : serpDisplayType, (i5 & 256) != 0 ? SerpViewType.SINGLE : serpViewType);
    }
}
