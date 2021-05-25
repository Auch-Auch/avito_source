package com.avito.android.brandspace.presenter.virtualitems;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.virtualitems.AddableItemsWithLoadingBrandspaceItem;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b+\u0010,J#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R\"\u0010\u000e\u001a\u00020\n8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010'R\u001c\u0010\r\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\t¨\u0006-"}, d2 = {"Lcom/avito/android/brandspace/presenter/virtualitems/SnippetGridLoader;", "Lcom/avito/android/brandspace/presenter/virtualitems/AddableItemsWithLoadingBrandspaceItem;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "items", "replace", "(Ljava/util/List;)Ljava/util/List;", "", "component1", "()J", "Lcom/avito/android/brandspace/items/BlockType;", "component2", "()Lcom/avito/android/brandspace/items/BlockType;", "id", "type", "copy", "(JLcom/avito/android/brandspace/items/BlockType;)Lcom/avito/android/brandspace/presenter/virtualitems/SnippetGridLoader;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", "setType", "(Lcom/avito/android/brandspace/items/BlockType;)V", AuthSource.SEND_ABUSE, "J", "getId", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class SnippetGridLoader implements AddableItemsWithLoadingBrandspaceItem {
    public static final Parcelable.Creator<SnippetGridLoader> CREATOR = new Creator();
    public final long a;
    @NotNull
    public BlockType b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SnippetGridLoader> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SnippetGridLoader createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SnippetGridLoader(parcel.readLong(), (BlockType) Enum.valueOf(BlockType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SnippetGridLoader[] newArray(int i) {
            return new SnippetGridLoader[i];
        }
    }

    public SnippetGridLoader(long j, @NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        this.a = j;
        this.b = blockType;
    }

    public static /* synthetic */ SnippetGridLoader copy$default(SnippetGridLoader snippetGridLoader, long j, BlockType blockType, int i, Object obj) {
        if ((i & 1) != 0) {
            j = snippetGridLoader.getId();
        }
        if ((i & 2) != 0) {
            blockType = snippetGridLoader.getType();
        }
        return snippetGridLoader.copy(j, blockType);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final BlockType component2() {
        return getType();
    }

    @NotNull
    public final SnippetGridLoader copy(long j, @NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        return new SnippetGridLoader(j, blockType);
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
        if (!(obj instanceof SnippetGridLoader)) {
            return false;
        }
        SnippetGridLoader snippetGridLoader = (SnippetGridLoader) obj;
        return getId() == snippetGridLoader.getId() && Intrinsics.areEqual(getType(), snippetGridLoader.getType());
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Override // com.avito.android.brandspace.presenter.TrackableBrandspaceItem, com.avito.android.item_visibility_tracker.ItemVisibilityTracker.Item
    public long getTrackId() {
        return AddableItemsWithLoadingBrandspaceItem.DefaultImpls.getTrackId(this);
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
        return a3 + (type != null ? type.hashCode() : 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.brandspace.presenter.BrandspaceItem> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.brandspace.presenter.virtualitems.AddableItemsWithLoadingBrandspaceItem
    @NotNull
    public List<BrandspaceItem> replace(@NotNull List<? extends BrandspaceItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        return list;
    }

    public void setType(@NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(blockType, "<set-?>");
        this.b = blockType;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SnippetGridLoader(id=");
        L.append(getId());
        L.append(", type=");
        L.append(getType());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b.name());
    }
}
