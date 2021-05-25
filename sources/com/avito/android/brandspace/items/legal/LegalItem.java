package com.avito.android.brandspace.items.legal;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.presenter.TrackableBrandspaceItem;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001e\u001a\u00020\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/brandspace/items/legal/LegalItem;", "Lcom/avito/android/brandspace/presenter/TrackableBrandspaceItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "c", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "Lcom/avito/android/brandspace/items/BlockType;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", "()Lcom/avito/android/brandspace/items/BlockType;", "setType", "(Lcom/avito/android/brandspace/items/BlockType;)V", "type", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;Ljava/lang/String;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class LegalItem implements TrackableBrandspaceItem {
    public static final Parcelable.Creator<LegalItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public BlockType b;
    @NotNull
    public final String c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<LegalItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LegalItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new LegalItem(parcel.readLong(), (BlockType) Enum.valueOf(BlockType.class, parcel.readString()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LegalItem[] newArray(int i) {
            return new LegalItem[i];
        }
    }

    public LegalItem(long j, @NotNull BlockType blockType, @NotNull String str) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(str, "text");
        this.a = j;
        this.b = blockType;
        this.c = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @NotNull
    public final String getText() {
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

    public void setType(@NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(blockType, "<set-?>");
        this.b = blockType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b.name());
        parcel.writeString(this.c);
    }
}
