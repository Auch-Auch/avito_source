package com.avito.android.brandspace.items.paragraph;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.presenter.TrackableBrandspaceItem;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ<\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0012\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b \u0010!R\u001c\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\nR\"\u0010\r\u001a\u00020\u00058\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010,R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010&\u001a\u0004\b.\u0010\n¨\u00061"}, d2 = {"Lcom/avito/android/brandspace/items/paragraph/ParagraphItem;", "Lcom/avito/android/brandspace/presenter/TrackableBrandspaceItem;", "", "component1", "()J", "Lcom/avito/android/brandspace/items/BlockType;", "component2", "()Lcom/avito/android/brandspace/items/BlockType;", "", "component3", "()Ljava/lang/String;", "component4", "id", "type", "title", "text", "copy", "(JLcom/avito/android/brandspace/items/BlockType;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/brandspace/items/paragraph/ParagraphItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "J", "getId", "d", "Ljava/lang/String;", "getText", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", "setType", "(Lcom/avito/android/brandspace/items/BlockType;)V", "c", "getTitle", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;Ljava/lang/String;Ljava/lang/String;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class ParagraphItem implements TrackableBrandspaceItem {
    public static final Parcelable.Creator<ParagraphItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public BlockType b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ParagraphItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ParagraphItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ParagraphItem(parcel.readLong(), (BlockType) Enum.valueOf(BlockType.class, parcel.readString()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ParagraphItem[] newArray(int i) {
            return new ParagraphItem[i];
        }
    }

    public ParagraphItem(long j, @NotNull BlockType blockType, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        this.a = j;
        this.b = blockType;
        this.c = str;
        this.d = str2;
    }

    public static /* synthetic */ ParagraphItem copy$default(ParagraphItem paragraphItem, long j, BlockType blockType, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = paragraphItem.getId();
        }
        if ((i & 2) != 0) {
            blockType = paragraphItem.getType();
        }
        if ((i & 4) != 0) {
            str = paragraphItem.c;
        }
        if ((i & 8) != 0) {
            str2 = paragraphItem.d;
        }
        return paragraphItem.copy(j, blockType, str, str2);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final BlockType component2() {
        return getType();
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final ParagraphItem copy(long j, @NotNull BlockType blockType, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        return new ParagraphItem(j, blockType, str, str2);
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
        if (!(obj instanceof ParagraphItem)) {
            return false;
        }
        ParagraphItem paragraphItem = (ParagraphItem) obj;
        return getId() == paragraphItem.getId() && Intrinsics.areEqual(getType(), paragraphItem.getType()) && Intrinsics.areEqual(this.c, paragraphItem.c) && Intrinsics.areEqual(this.d, paragraphItem.d);
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Nullable
    public final String getText() {
        return this.d;
    }

    @Nullable
    public final String getTitle() {
        return this.c;
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
        String str = this.c;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public void setType(@NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(blockType, "<set-?>");
        this.b = blockType;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ParagraphItem(id=");
        L.append(getId());
        L.append(", type=");
        L.append(getType());
        L.append(", title=");
        L.append(this.c);
        L.append(", text=");
        return a.t(L, this.d, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b.name());
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }
}
