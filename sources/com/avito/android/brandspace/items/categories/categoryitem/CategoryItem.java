package com.avito.android.brandspace.items.categories.categoryitem;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem;
import com.avito.android.brandspace.presenter.TrackableBrandspaceItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\"\b\b\u0018\u00002\u00020\u00012\u00020\u0002B]\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0014\u0012\b\b\u0002\u0010 \u001a\u00020\u0014¢\u0006\u0004\bN\u0010OJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016Jt\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u0014HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b#\u0010\u000eJ\u0010\u0010$\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b$\u0010\u0016J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b*\u0010\u0016J \u0010/\u001a\u00020.2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b/\u00100R\"\u0010 \u001a\u00020\u00148\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u00105R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u000bR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\u000eR\"\u0010\u001f\u001a\u00020\u00148\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b<\u00102\u001a\u0004\b=\u0010\u0016\"\u0004\b>\u00105R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b@\u0010\u000eR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010:\u001a\u0004\bB\u0010\u000eR\"\u0010\u0019\u001a\u00020\u00068\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\b\"\u0004\bF\u0010GR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010\u0013R\u001c\u0010\u0018\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010\u0005¨\u0006P"}, d2 = {"Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItem;", "Lcom/avito/android/brandspace/presenter/TrackableBrandspaceItem;", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurableItem;", "", "component1", "()J", "Lcom/avito/android/brandspace/items/BlockType;", "component2", "()Lcom/avito/android/brandspace/items/BlockType;", "Lcom/avito/android/remote/model/Image;", "component3", "()Lcom/avito/android/remote/model/Image;", "", "component4", "()Ljava/lang/String;", "component5", "component6", "Lcom/avito/android/remote/model/Action;", "component7", "()Lcom/avito/android/remote/model/Action;", "", "component8", "()I", "component9", "id", "type", "image", "title", MessengerShareContentUtility.SUBTITLE, "description", "action", "precalculatedTextHeight", "precalculatedMetricsHash", "copy", "(JLcom/avito/android/brandspace/items/BlockType;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;II)Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItem;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "i", "I", "getPrecalculatedMetricsHash", "setPrecalculatedMetricsHash", "(I)V", "c", "Lcom/avito/android/remote/model/Image;", "getImage", "f", "Ljava/lang/String;", "getDescription", "h", "getPrecalculatedTextHeight", "setPrecalculatedTextHeight", "e", "getSubtitle", "d", "getTitle", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", "setType", "(Lcom/avito/android/brandspace/items/BlockType;)V", g.a, "Lcom/avito/android/remote/model/Action;", "getAction", AuthSource.SEND_ABUSE, "J", "getId", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;II)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryItem implements TrackableBrandspaceItem, TextMeasurableItem {
    public static final Parcelable.Creator<CategoryItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public BlockType b;
    @Nullable
    public final Image c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final Action g;
    public int h;
    public int i;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CategoryItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoryItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CategoryItem(parcel.readLong(), (BlockType) Enum.valueOf(BlockType.class, parcel.readString()), (Image) parcel.readParcelable(CategoryItem.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), (Action) parcel.readParcelable(CategoryItem.class.getClassLoader()), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoryItem[] newArray(int i) {
            return new CategoryItem[i];
        }
    }

    public CategoryItem(long j, @NotNull BlockType blockType, @Nullable Image image, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Action action, int i2, int i3) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        this.a = j;
        this.b = blockType;
        this.c = image;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = action;
        this.h = i2;
        this.i = i3;
    }

    public static /* synthetic */ CategoryItem copy$default(CategoryItem categoryItem, long j, BlockType blockType, Image image, String str, String str2, String str3, Action action, int i2, int i3, int i4, Object obj) {
        return categoryItem.copy((i4 & 1) != 0 ? categoryItem.getId() : j, (i4 & 2) != 0 ? categoryItem.getType() : blockType, (i4 & 4) != 0 ? categoryItem.c : image, (i4 & 8) != 0 ? categoryItem.d : str, (i4 & 16) != 0 ? categoryItem.e : str2, (i4 & 32) != 0 ? categoryItem.f : str3, (i4 & 64) != 0 ? categoryItem.g : action, (i4 & 128) != 0 ? categoryItem.getPrecalculatedTextHeight() : i2, (i4 & 256) != 0 ? categoryItem.getPrecalculatedMetricsHash() : i3);
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

    @Nullable
    public final String component6() {
        return this.f;
    }

    @Nullable
    public final Action component7() {
        return this.g;
    }

    public final int component8() {
        return getPrecalculatedTextHeight();
    }

    public final int component9() {
        return getPrecalculatedMetricsHash();
    }

    @NotNull
    public final CategoryItem copy(long j, @NotNull BlockType blockType, @Nullable Image image, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Action action, int i2, int i3) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        return new CategoryItem(j, blockType, image, str, str2, str3, action, i2, i3);
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
        if (!(obj instanceof CategoryItem)) {
            return false;
        }
        CategoryItem categoryItem = (CategoryItem) obj;
        return getId() == categoryItem.getId() && Intrinsics.areEqual(getType(), categoryItem.getType()) && Intrinsics.areEqual(this.c, categoryItem.c) && Intrinsics.areEqual(this.d, categoryItem.d) && Intrinsics.areEqual(this.e, categoryItem.e) && Intrinsics.areEqual(this.f, categoryItem.f) && Intrinsics.areEqual(this.g, categoryItem.g) && getPrecalculatedTextHeight() == categoryItem.getPrecalculatedTextHeight() && getPrecalculatedMetricsHash() == categoryItem.getPrecalculatedMetricsHash();
    }

    @Nullable
    public final Action getAction() {
        return this.g;
    }

    @Nullable
    public final String getDescription() {
        return this.f;
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
        return this.i;
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem
    public int getPrecalculatedTextHeight() {
        return this.h;
    }

    @Nullable
    public final String getSubtitle() {
        return this.e;
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
        int i2 = 0;
        int hashCode = (a3 + (type != null ? type.hashCode() : 0)) * 31;
        Image image = this.c;
        int hashCode2 = (hashCode + (image != null ? image.hashCode() : 0)) * 31;
        String str = this.d;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.e;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Action action = this.g;
        if (action != null) {
            i2 = action.hashCode();
        }
        return getPrecalculatedMetricsHash() + ((getPrecalculatedTextHeight() + ((hashCode5 + i2) * 31)) * 31);
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem
    public void setPrecalculatedMetricsHash(int i2) {
        this.i = i2;
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem
    public void setPrecalculatedTextHeight(int i2) {
        this.h = i2;
    }

    public void setType(@NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(blockType, "<set-?>");
        this.b = blockType;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CategoryItem(id=");
        L.append(getId());
        L.append(", type=");
        L.append(getType());
        L.append(", image=");
        L.append(this.c);
        L.append(", title=");
        L.append(this.d);
        L.append(", subtitle=");
        L.append(this.e);
        L.append(", description=");
        L.append(this.f);
        L.append(", action=");
        L.append(this.g);
        L.append(", precalculatedTextHeight=");
        L.append(getPrecalculatedTextHeight());
        L.append(", precalculatedMetricsHash=");
        L.append(getPrecalculatedMetricsHash());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b.name());
        parcel.writeParcelable(this.c, i2);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeParcelable(this.g, i2);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CategoryItem(long j, BlockType blockType, Image image, String str, String str2, String str3, Action action, int i2, int i3, int i4, j jVar) {
        this(j, blockType, image, str, str2, str3, action, (i4 & 128) != 0 ? 0 : i2, (i4 & 256) != 0 ? 0 : i3);
    }
}
