package com.avito.android.brandspace.presenter.virtualitems;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.virtualitems.VirtualItem;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.AdvertSource;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItemsImpl;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\"\u001a\u00020\u0017\u0012\u0006\u0010#\u001a\u00020\u001a\u0012\u0006\u0010$\u001a\u00020\f\u0012\u0006\u0010%\u001a\u00020\u001e\u0012\b\b\u0002\u0010&\u001a\u00020\f¢\u0006\u0004\bI\u0010JJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0013\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0001¢\u0006\u0004\b\u0015\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0016\u0010\u000eJ\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u000eJ\u0010\u0010\u001f\u001a\u00020\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b!\u0010\u000eJB\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\"\u001a\u00020\u00172\b\b\u0002\u0010#\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020\f2\b\b\u0002\u0010%\u001a\u00020\u001e2\b\b\u0002\u0010&\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010*\u001a\u00020)HÖ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010-\u001a\u00020,HÖ\u0001¢\u0006\u0004\b-\u0010.J\u001a\u00101\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u00010/HÖ\u0003¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020,HÖ\u0001¢\u0006\u0004\b3\u0010.J \u00107\u001a\u00020\t2\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020,HÖ\u0001¢\u0006\u0004\b7\u00108R\u001c\u0010$\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b$\u0010\u000eR\u0019\u0010%\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010 R\u001c\u0010\"\u001a\u00020\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010\u0019R\u001c\u0010#\u001a\u00020\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010\u001cR\u0019\u0010&\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010:\u001a\u0004\b&\u0010\u000eR\u0016\u0010H\u001a\u00020E8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006K"}, d2 = {"Lcom/avito/android/brandspace/presenter/virtualitems/SnippetListNoErrorVirtualItem;", "Lcom/avito/android/brandspace/presenter/virtualitems/VirtualItem;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/ExtraLoadingListItems;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "getUnpackItems", "()Ljava/util/List;", "oldItem", "newItem", "", "replaceItem", "(Lcom/avito/android/brandspace/presenter/BrandspaceItem;Lcom/avito/android/brandspace/presenter/BrandspaceItem;)V", "", "isUnpackable", "()Z", "errorLoading", "()V", "", "items", "addItems", "(Ljava/util/List;)V", "getResult", "isLoaded", "", "component1", "()J", "Lcom/avito/android/brandspace/items/BlockType;", "component2", "()Lcom/avito/android/brandspace/items/BlockType;", "component3", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/ExtraLoadingListItemsImpl;", "component4", "()Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/ExtraLoadingListItemsImpl;", "component5", "id", "type", "isReplaceableItem", "addableItem", "isUnpackBeforeLoad", "copy", "(JLcom/avito/android/brandspace/items/BlockType;ZLcom/avito/android/brandspace/presenter/virtualitems/extraloading/ExtraLoadingListItemsImpl;Z)Lcom/avito/android/brandspace/presenter/virtualitems/SnippetListNoErrorVirtualItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Z", "d", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/ExtraLoadingListItemsImpl;", "getAddableItem", AuthSource.SEND_ABUSE, "J", "getId", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", "e", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "getAdvertSource", "()Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "advertSource", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;ZLcom/avito/android/brandspace/presenter/virtualitems/extraloading/ExtraLoadingListItemsImpl;Z)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class SnippetListNoErrorVirtualItem implements VirtualItem, ExtraLoadingListItems {
    public static final Parcelable.Creator<SnippetListNoErrorVirtualItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final BlockType b;
    public final boolean c;
    @NotNull
    public final ExtraLoadingListItemsImpl d;
    public final boolean e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SnippetListNoErrorVirtualItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SnippetListNoErrorVirtualItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SnippetListNoErrorVirtualItem(parcel.readLong(), (BlockType) Enum.valueOf(BlockType.class, parcel.readString()), parcel.readInt() != 0, ExtraLoadingListItemsImpl.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SnippetListNoErrorVirtualItem[] newArray(int i) {
            return new SnippetListNoErrorVirtualItem[i];
        }
    }

    public SnippetListNoErrorVirtualItem(long j, @NotNull BlockType blockType, boolean z, @NotNull ExtraLoadingListItemsImpl extraLoadingListItemsImpl, boolean z2) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(extraLoadingListItemsImpl, "addableItem");
        this.a = j;
        this.b = blockType;
        this.c = z;
        this.d = extraLoadingListItemsImpl;
        this.e = z2;
    }

    public static /* synthetic */ SnippetListNoErrorVirtualItem copy$default(SnippetListNoErrorVirtualItem snippetListNoErrorVirtualItem, long j, BlockType blockType, boolean z, ExtraLoadingListItemsImpl extraLoadingListItemsImpl, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = snippetListNoErrorVirtualItem.getId();
        }
        if ((i & 2) != 0) {
            blockType = snippetListNoErrorVirtualItem.getType();
        }
        if ((i & 4) != 0) {
            z = snippetListNoErrorVirtualItem.isReplaceableItem();
        }
        if ((i & 8) != 0) {
            extraLoadingListItemsImpl = snippetListNoErrorVirtualItem.d;
        }
        if ((i & 16) != 0) {
            z2 = snippetListNoErrorVirtualItem.e;
        }
        return snippetListNoErrorVirtualItem.copy(j, blockType, z, extraLoadingListItemsImpl, z2);
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems
    public void addItems(@NotNull List<? extends BrandspaceItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.d.addItems(list);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final BlockType component2() {
        return getType();
    }

    public final boolean component3() {
        return isReplaceableItem();
    }

    @NotNull
    public final ExtraLoadingListItemsImpl component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    @NotNull
    public final SnippetListNoErrorVirtualItem copy(long j, @NotNull BlockType blockType, boolean z, @NotNull ExtraLoadingListItemsImpl extraLoadingListItemsImpl, boolean z2) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(extraLoadingListItemsImpl, "addableItem");
        return new SnippetListNoErrorVirtualItem(j, blockType, z, extraLoadingListItemsImpl, z2);
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
        if (!(obj instanceof SnippetListNoErrorVirtualItem)) {
            return false;
        }
        SnippetListNoErrorVirtualItem snippetListNoErrorVirtualItem = (SnippetListNoErrorVirtualItem) obj;
        return getId() == snippetListNoErrorVirtualItem.getId() && Intrinsics.areEqual(getType(), snippetListNoErrorVirtualItem.getType()) && isReplaceableItem() == snippetListNoErrorVirtualItem.isReplaceableItem() && Intrinsics.areEqual(this.d, snippetListNoErrorVirtualItem.d) && this.e == snippetListNoErrorVirtualItem.e;
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems
    public void errorLoading() {
    }

    @NotNull
    public final ExtraLoadingListItemsImpl getAddableItem() {
        return this.d;
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems
    @NotNull
    public AdvertSource getAdvertSource() {
        return this.d.getAdvertSource();
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems
    @NotNull
    public List<BrandspaceItem> getResult() {
        return this.d.getResult();
    }

    @Override // com.avito.android.brandspace.presenter.TrackableBrandspaceItem, com.avito.android.item_visibility_tracker.ItemVisibilityTracker.Item
    public long getTrackId() {
        return VirtualItem.DefaultImpls.getTrackId(this);
    }

    @Override // com.avito.android.brandspace.presenter.BrandspaceItem
    @NotNull
    public BlockType getType() {
        return this.b;
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.VirtualItem
    @NotNull
    public List<BrandspaceItem> getUnpackItems() {
        return this.d.getResult();
    }

    @Override // java.lang.Object
    public int hashCode() {
        int a3 = c.a(getId()) * 31;
        BlockType type = getType();
        int i = 0;
        int hashCode = (a3 + (type != null ? type.hashCode() : 0)) * 31;
        boolean isReplaceableItem = isReplaceableItem();
        int i2 = 1;
        if (isReplaceableItem) {
            isReplaceableItem = true;
        }
        int i3 = isReplaceableItem ? 1 : 0;
        int i4 = isReplaceableItem ? 1 : 0;
        int i5 = isReplaceableItem ? 1 : 0;
        int i6 = (hashCode + i3) * 31;
        ExtraLoadingListItemsImpl extraLoadingListItemsImpl = this.d;
        if (extraLoadingListItemsImpl != null) {
            i = extraLoadingListItemsImpl.hashCode();
        }
        int i7 = (i6 + i) * 31;
        boolean z = this.e;
        if (!z) {
            i2 = z ? 1 : 0;
        }
        return i7 + i2;
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems
    public boolean isLoaded() {
        return this.d.isLoaded();
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.VirtualItem
    public boolean isReplaceableItem() {
        return this.c;
    }

    public final boolean isUnpackBeforeLoad() {
        return this.e;
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.VirtualItem
    public boolean isUnpackable() {
        return this.e || this.d.isLoaded();
    }

    @Override // com.avito.android.brandspace.presenter.virtualitems.VirtualItem
    public void replaceItem(@NotNull BrandspaceItem brandspaceItem, @NotNull BrandspaceItem brandspaceItem2) {
        Intrinsics.checkNotNullParameter(brandspaceItem, "oldItem");
        Intrinsics.checkNotNullParameter(brandspaceItem2, "newItem");
        this.d.replaceItem(brandspaceItem, brandspaceItem2);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SnippetListNoErrorVirtualItem(id=");
        L.append(getId());
        L.append(", type=");
        L.append(getType());
        L.append(", isReplaceableItem=");
        L.append(isReplaceableItem());
        L.append(", addableItem=");
        L.append(this.d);
        L.append(", isUnpackBeforeLoad=");
        return a.B(L, this.e, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b.name());
        parcel.writeInt(this.c ? 1 : 0);
        this.d.writeToParcel(parcel, 0);
        parcel.writeInt(this.e ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SnippetListNoErrorVirtualItem(long j, BlockType blockType, boolean z, ExtraLoadingListItemsImpl extraLoadingListItemsImpl, boolean z2, int i, j jVar) {
        this(j, blockType, z, extraLoadingListItemsImpl, (i & 16) != 0 ? true : z2);
    }
}
