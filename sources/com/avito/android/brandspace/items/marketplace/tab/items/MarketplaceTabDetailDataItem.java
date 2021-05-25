package com.avito.android.brandspace.items.marketplace.tab.items;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.items.button.ButtonItem;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ:\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\rR\u001c\u0010\u000f\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\n¨\u00062"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/tab/items/MarketplaceTabDetailDataItem;", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "", "component1", "()J", "Lcom/avito/android/brandspace/items/BlockType;", "component2", "()Lcom/avito/android/brandspace/items/BlockType;", "", "component3", "()Ljava/lang/String;", "Lcom/avito/android/brandspace/items/button/ButtonItem;", "component4", "()Lcom/avito/android/brandspace/items/button/ButtonItem;", "id", "type", "tabName", "action", "copy", "(JLcom/avito/android/brandspace/items/BlockType;Ljava/lang/String;Lcom/avito/android/brandspace/items/button/ButtonItem;)Lcom/avito/android/brandspace/items/marketplace/tab/items/MarketplaceTabDetailDataItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Lcom/avito/android/brandspace/items/button/ButtonItem;", "getAction", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", AuthSource.SEND_ABUSE, "J", "getId", "c", "Ljava/lang/String;", "getTabName", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;Ljava/lang/String;Lcom/avito/android/brandspace/items/button/ButtonItem;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceTabDetailDataItem implements BrandspaceItem {
    public static final Parcelable.Creator<MarketplaceTabDetailDataItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final BlockType b;
    @NotNull
    public final String c;
    @Nullable
    public final ButtonItem d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MarketplaceTabDetailDataItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceTabDetailDataItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new MarketplaceTabDetailDataItem(parcel.readLong(), (BlockType) Enum.valueOf(BlockType.class, parcel.readString()), parcel.readString(), parcel.readInt() != 0 ? ButtonItem.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceTabDetailDataItem[] newArray(int i) {
            return new MarketplaceTabDetailDataItem[i];
        }
    }

    public MarketplaceTabDetailDataItem(long j, @NotNull BlockType blockType, @NotNull String str, @Nullable ButtonItem buttonItem) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(str, "tabName");
        this.a = j;
        this.b = blockType;
        this.c = str;
        this.d = buttonItem;
    }

    public static /* synthetic */ MarketplaceTabDetailDataItem copy$default(MarketplaceTabDetailDataItem marketplaceTabDetailDataItem, long j, BlockType blockType, String str, ButtonItem buttonItem, int i, Object obj) {
        if ((i & 1) != 0) {
            j = marketplaceTabDetailDataItem.getId();
        }
        if ((i & 2) != 0) {
            blockType = marketplaceTabDetailDataItem.getType();
        }
        if ((i & 4) != 0) {
            str = marketplaceTabDetailDataItem.c;
        }
        if ((i & 8) != 0) {
            buttonItem = marketplaceTabDetailDataItem.d;
        }
        return marketplaceTabDetailDataItem.copy(j, blockType, str, buttonItem);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final BlockType component2() {
        return getType();
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final ButtonItem component4() {
        return this.d;
    }

    @NotNull
    public final MarketplaceTabDetailDataItem copy(long j, @NotNull BlockType blockType, @NotNull String str, @Nullable ButtonItem buttonItem) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(str, "tabName");
        return new MarketplaceTabDetailDataItem(j, blockType, str, buttonItem);
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
        if (!(obj instanceof MarketplaceTabDetailDataItem)) {
            return false;
        }
        MarketplaceTabDetailDataItem marketplaceTabDetailDataItem = (MarketplaceTabDetailDataItem) obj;
        return getId() == marketplaceTabDetailDataItem.getId() && Intrinsics.areEqual(getType(), marketplaceTabDetailDataItem.getType()) && Intrinsics.areEqual(this.c, marketplaceTabDetailDataItem.c) && Intrinsics.areEqual(this.d, marketplaceTabDetailDataItem.d);
    }

    @Nullable
    public final ButtonItem getAction() {
        return this.d;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @NotNull
    public final String getTabName() {
        return this.c;
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
        String str = this.c;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        ButtonItem buttonItem = this.d;
        if (buttonItem != null) {
            i = buttonItem.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("MarketplaceTabDetailDataItem(id=");
        L.append(getId());
        L.append(", type=");
        L.append(getType());
        L.append(", tabName=");
        L.append(this.c);
        L.append(", action=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b.name());
        parcel.writeString(this.c);
        ButtonItem buttonItem = this.d;
        if (buttonItem != null) {
            parcel.writeInt(1);
            buttonItem.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MarketplaceTabDetailDataItem(long j, BlockType blockType, String str, ButtonItem buttonItem, int i, j jVar) {
        this(j, (i & 2) != 0 ? BlockType.MARKETPLACE_TAB : blockType, str, buttonItem);
    }
}
