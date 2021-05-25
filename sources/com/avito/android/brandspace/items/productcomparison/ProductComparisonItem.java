package com.avito.android.brandspace.items.productcomparison;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem;
import com.avito.android.brandspace.presenter.TrackableBrandspaceItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b \b\b\u0018\u00002\u00020\u00012\u00020\u0002BW\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0014¢\u0006\u0004\bK\u0010LJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016Jl\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u0014HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\"\u0010\u000eJ\u0010\u0010#\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b#\u0010\u0016J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b)\u0010\u0016J \u0010.\u001a\u00020-2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b.\u0010/R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u000eR\"\u0010\u001f\u001a\u00020\u00148\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u00107R\"\u0010\u001e\u001a\u00020\u00148\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b8\u00104\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u00107R\"\u0010\u0019\u001a\u00020\u00068\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\b\"\u0004\b>\u0010?R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010\u000bR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\bC\u00101\u001a\u0004\bD\u0010\u000eR\u001c\u0010\u0018\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010\u0005R\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010\u0013¨\u0006M"}, d2 = {"Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItem;", "Lcom/avito/android/brandspace/presenter/TrackableBrandspaceItem;", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurableItem;", "", "component1", "()J", "Lcom/avito/android/brandspace/items/BlockType;", "component2", "()Lcom/avito/android/brandspace/items/BlockType;", "Lcom/avito/android/remote/model/Image;", "component3", "()Lcom/avito/android/remote/model/Image;", "", "component4", "()Ljava/lang/String;", "component5", "", "Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemProperty;", "component6", "()Ljava/util/List;", "", "component7", "()I", "component8", "id", "type", "image", "title", "description", "properties", "precalculatedTextHeight", "precalculatedMetricsHash", "copy", "(JLcom/avito/android/brandspace/items/BlockType;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;II)Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItem;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "e", "Ljava/lang/String;", "getDescription", "h", "I", "getPrecalculatedMetricsHash", "setPrecalculatedMetricsHash", "(I)V", g.a, "getPrecalculatedTextHeight", "setPrecalculatedTextHeight", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", "setType", "(Lcom/avito/android/brandspace/items/BlockType;)V", "c", "Lcom/avito/android/remote/model/Image;", "getImage", "d", "getTitle", AuthSource.SEND_ABUSE, "J", "getId", "f", "Ljava/util/List;", "getProperties", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;II)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class ProductComparisonItem implements TrackableBrandspaceItem, TextMeasurableItem {
    public static final Parcelable.Creator<ProductComparisonItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public BlockType b;
    @Nullable
    public final Image c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @NotNull
    public final List<ProductComparisonItemProperty> f;
    public int g;
    public int h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ProductComparisonItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ProductComparisonItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            long readLong = parcel.readLong();
            BlockType blockType = (BlockType) Enum.valueOf(BlockType.class, parcel.readString());
            Image image = (Image) parcel.readParcelable(ProductComparisonItem.class.getClassLoader());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(ProductComparisonItemProperty.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new ProductComparisonItem(readLong, blockType, image, readString, readString2, arrayList, parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ProductComparisonItem[] newArray(int i) {
            return new ProductComparisonItem[i];
        }
    }

    public ProductComparisonItem(long j, @NotNull BlockType blockType, @Nullable Image image, @Nullable String str, @Nullable String str2, @NotNull List<ProductComparisonItemProperty> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(list, "properties");
        this.a = j;
        this.b = blockType;
        this.c = image;
        this.d = str;
        this.e = str2;
        this.f = list;
        this.g = i;
        this.h = i2;
    }

    public static /* synthetic */ ProductComparisonItem copy$default(ProductComparisonItem productComparisonItem, long j, BlockType blockType, Image image, String str, String str2, List list, int i, int i2, int i3, Object obj) {
        return productComparisonItem.copy((i3 & 1) != 0 ? productComparisonItem.getId() : j, (i3 & 2) != 0 ? productComparisonItem.getType() : blockType, (i3 & 4) != 0 ? productComparisonItem.c : image, (i3 & 8) != 0 ? productComparisonItem.d : str, (i3 & 16) != 0 ? productComparisonItem.e : str2, (i3 & 32) != 0 ? productComparisonItem.f : list, (i3 & 64) != 0 ? productComparisonItem.getPrecalculatedTextHeight() : i, (i3 & 128) != 0 ? productComparisonItem.getPrecalculatedMetricsHash() : i2);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final BlockType component2() {
        return getType();
    }

    @Nullable
    public final Image component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @NotNull
    public final List<ProductComparisonItemProperty> component6() {
        return this.f;
    }

    public final int component7() {
        return getPrecalculatedTextHeight();
    }

    public final int component8() {
        return getPrecalculatedMetricsHash();
    }

    @NotNull
    public final ProductComparisonItem copy(long j, @NotNull BlockType blockType, @Nullable Image image, @Nullable String str, @Nullable String str2, @NotNull List<ProductComparisonItemProperty> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(list, "properties");
        return new ProductComparisonItem(j, blockType, image, str, str2, list, i, i2);
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
        if (!(obj instanceof ProductComparisonItem)) {
            return false;
        }
        ProductComparisonItem productComparisonItem = (ProductComparisonItem) obj;
        return getId() == productComparisonItem.getId() && Intrinsics.areEqual(getType(), productComparisonItem.getType()) && Intrinsics.areEqual(this.c, productComparisonItem.c) && Intrinsics.areEqual(this.d, productComparisonItem.d) && Intrinsics.areEqual(this.e, productComparisonItem.e) && Intrinsics.areEqual(this.f, productComparisonItem.f) && getPrecalculatedTextHeight() == productComparisonItem.getPrecalculatedTextHeight() && getPrecalculatedMetricsHash() == productComparisonItem.getPrecalculatedMetricsHash();
    }

    @Nullable
    public final String getDescription() {
        return this.e;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Nullable
    public final Image getImage() {
        return this.c;
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem
    public int getPrecalculatedMetricsHash() {
        return this.h;
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem
    public int getPrecalculatedTextHeight() {
        return this.g;
    }

    @NotNull
    public final List<ProductComparisonItemProperty> getProperties() {
        return this.f;
    }

    @Nullable
    public final String getTitle() {
        return this.d;
    }

    @Override // com.avito.android.brandspace.presenter.TrackableBrandspaceItem, com.avito.android.item_visibility_tracker.ItemVisibilityTracker.Item
    public long getTrackId() {
        return TrackableBrandspaceItem.DefaultImpls.getTrackId(this);
    }

    @Override // com.avito.android.brandspace.presenter.BrandspaceItem
    @NotNull
    public BlockType getType() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int a3 = c.a(getId()) * 31;
        BlockType type = getType();
        int i = 0;
        int hashCode = (a3 + (type != null ? type.hashCode() : 0)) * 31;
        Image image = this.c;
        int hashCode2 = (hashCode + (image != null ? image.hashCode() : 0)) * 31;
        String str = this.d;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.e;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<ProductComparisonItemProperty> list = this.f;
        if (list != null) {
            i = list.hashCode();
        }
        return getPrecalculatedMetricsHash() + ((getPrecalculatedTextHeight() + ((hashCode4 + i) * 31)) * 31);
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem
    public void setPrecalculatedMetricsHash(int i) {
        this.h = i;
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem
    public void setPrecalculatedTextHeight(int i) {
        this.g = i;
    }

    public void setType(@NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(blockType, "<set-?>");
        this.b = blockType;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProductComparisonItem(id=");
        L.append(getId());
        L.append(", type=");
        L.append(getType());
        L.append(", image=");
        L.append(this.c);
        L.append(", title=");
        L.append(this.d);
        L.append(", description=");
        L.append(this.e);
        L.append(", properties=");
        L.append(this.f);
        L.append(", precalculatedTextHeight=");
        L.append(getPrecalculatedTextHeight());
        L.append(", precalculatedMetricsHash=");
        L.append(getPrecalculatedMetricsHash());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b.name());
        parcel.writeParcelable(this.c, i);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        Iterator n0 = a.n0(this.f, parcel);
        while (n0.hasNext()) {
            ((ProductComparisonItemProperty) n0.next()).writeToParcel(parcel, 0);
        }
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProductComparisonItem(long j, BlockType blockType, Image image, String str, String str2, List list, int i, int i2, int i3, j jVar) {
        this(j, blockType, image, str, str2, list, (i3 & 64) != 0 ? 0 : i, (i3 & 128) != 0 ? 0 : i2);
    }
}
