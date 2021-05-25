package com.avito.android.brandspace.items.marketplace.categories;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.presenter.TrackableBrandspaceItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.UniversalColor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0011¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013JL\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\rJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b%\u0010\u001fJ \u0010*\u001a\u00020)2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b*\u0010+R\u001c\u0010\u0015\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\nR\u0019\u0010\u0019\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u0013R\u0019\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010\rR\u0019\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\u0010¨\u0006@"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/categories/CategoryItem;", "Lcom/avito/android/brandspace/presenter/TrackableBrandspaceItem;", "", "component1", "()J", "Lcom/avito/android/brandspace/items/BlockType;", "component2", "()Lcom/avito/android/brandspace/items/BlockType;", "Lcom/avito/android/remote/model/Image;", "component3", "()Lcom/avito/android/remote/model/Image;", "", "component4", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/UniversalColor;", "component5", "()Lcom/avito/android/remote/model/UniversalColor;", "Lcom/avito/android/remote/model/Action;", "component6", "()Lcom/avito/android/remote/model/Action;", "id", "type", "image", "title", "backgroundColor", "action", "copy", "(JLcom/avito/android/brandspace/items/BlockType;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/Action;)Lcom/avito/android/brandspace/items/marketplace/categories/CategoryItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", AuthSource.SEND_ABUSE, "J", "getId", "c", "Lcom/avito/android/remote/model/Image;", "getImage", "f", "Lcom/avito/android/remote/model/Action;", "getAction", "d", "Ljava/lang/String;", "getTitle", "e", "Lcom/avito/android/remote/model/UniversalColor;", "getBackgroundColor", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/Action;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryItem implements TrackableBrandspaceItem {
    public static final Parcelable.Creator<CategoryItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final BlockType b;
    @NotNull
    public final Image c;
    @NotNull
    public final String d;
    @NotNull
    public final UniversalColor e;
    @NotNull
    public final Action f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CategoryItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoryItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CategoryItem(parcel.readLong(), (BlockType) Enum.valueOf(BlockType.class, parcel.readString()), (Image) parcel.readParcelable(CategoryItem.class.getClassLoader()), parcel.readString(), (UniversalColor) parcel.readParcelable(CategoryItem.class.getClassLoader()), (Action) parcel.readParcelable(CategoryItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CategoryItem[] newArray(int i) {
            return new CategoryItem[i];
        }
    }

    public CategoryItem(long j, @NotNull BlockType blockType, @NotNull Image image, @NotNull String str, @NotNull UniversalColor universalColor, @NotNull Action action) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(universalColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(action, "action");
        this.a = j;
        this.b = blockType;
        this.c = image;
        this.d = str;
        this.e = universalColor;
        this.f = action;
    }

    public static /* synthetic */ CategoryItem copy$default(CategoryItem categoryItem, long j, BlockType blockType, Image image, String str, UniversalColor universalColor, Action action, int i, Object obj) {
        return categoryItem.copy((i & 1) != 0 ? categoryItem.getId() : j, (i & 2) != 0 ? categoryItem.getType() : blockType, (i & 4) != 0 ? categoryItem.c : image, (i & 8) != 0 ? categoryItem.d : str, (i & 16) != 0 ? categoryItem.e : universalColor, (i & 32) != 0 ? categoryItem.f : action);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final BlockType component2() {
        return getType();
    }

    @NotNull
    public final Image component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final UniversalColor component5() {
        return this.e;
    }

    @NotNull
    public final Action component6() {
        return this.f;
    }

    @NotNull
    public final CategoryItem copy(long j, @NotNull BlockType blockType, @NotNull Image image, @NotNull String str, @NotNull UniversalColor universalColor, @NotNull Action action) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(universalColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(action, "action");
        return new CategoryItem(j, blockType, image, str, universalColor, action);
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
        return getId() == categoryItem.getId() && Intrinsics.areEqual(getType(), categoryItem.getType()) && Intrinsics.areEqual(this.c, categoryItem.c) && Intrinsics.areEqual(this.d, categoryItem.d) && Intrinsics.areEqual(this.e, categoryItem.e) && Intrinsics.areEqual(this.f, categoryItem.f);
    }

    @NotNull
    public final Action getAction() {
        return this.f;
    }

    @NotNull
    public final UniversalColor getBackgroundColor() {
        return this.e;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @NotNull
    public final Image getImage() {
        return this.c;
    }

    @NotNull
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
        UniversalColor universalColor = this.e;
        int hashCode4 = (hashCode3 + (universalColor != null ? universalColor.hashCode() : 0)) * 31;
        Action action = this.f;
        if (action != null) {
            i = action.hashCode();
        }
        return hashCode4 + i;
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
        L.append(", backgroundColor=");
        L.append(this.e);
        L.append(", action=");
        L.append(this.f);
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
        parcel.writeParcelable(this.e, i);
        parcel.writeParcelable(this.f, i);
    }
}
