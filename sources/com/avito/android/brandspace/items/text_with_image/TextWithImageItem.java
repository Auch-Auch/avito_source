package com.avito.android.brandspace.items.text_with_image;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.presenter.TrackableBrandspaceItem;
import com.avito.android.brandspace.remote.model.BrandspaceTextWithImageImagePlacement;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u00106\u001a\u00020/\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\b\u0010%\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010(\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010.\u001a\u0004\u0018\u00010)¢\u0006\u0004\b7\u00108J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010%\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!R\u001b\u0010(\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R\u001b\u0010.\u001a\u0004\u0018\u00010)8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\"\u00106\u001a\u00020/8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/avito/android/brandspace/items/text_with_image/TextWithImageItem;", "Lcom/avito/android/brandspace/presenter/TrackableBrandspaceItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "c", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithImageImagePlacement;", "d", "Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithImageImagePlacement;", "getImagePlacement", "()Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithImageImagePlacement;", "imagePlacement", "", "f", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", "e", "getTitle", "title", g.a, "getAdditionalDescription", "additionalDescription", "Lcom/avito/android/remote/model/Action;", "h", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/brandspace/items/BlockType;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", "()Lcom/avito/android/brandspace/items/BlockType;", "setType", "(Lcom/avito/android/brandspace/items/BlockType;)V", "type", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;Lcom/avito/android/remote/model/Image;Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithImageImagePlacement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class TextWithImageItem implements TrackableBrandspaceItem {
    public static final Parcelable.Creator<TextWithImageItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public BlockType b;
    @Nullable
    public final Image c;
    @NotNull
    public final BrandspaceTextWithImageImagePlacement d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    @Nullable
    public final Action h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<TextWithImageItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TextWithImageItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new TextWithImageItem(parcel.readLong(), (BlockType) Enum.valueOf(BlockType.class, parcel.readString()), (Image) parcel.readParcelable(TextWithImageItem.class.getClassLoader()), (BrandspaceTextWithImageImagePlacement) Enum.valueOf(BrandspaceTextWithImageImagePlacement.class, parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), (Action) parcel.readParcelable(TextWithImageItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TextWithImageItem[] newArray(int i) {
            return new TextWithImageItem[i];
        }
    }

    public TextWithImageItem(long j, @NotNull BlockType blockType, @Nullable Image image, @NotNull BrandspaceTextWithImageImagePlacement brandspaceTextWithImageImagePlacement, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Action action) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(brandspaceTextWithImageImagePlacement, "imagePlacement");
        this.a = j;
        this.b = blockType;
        this.c = image;
        this.d = brandspaceTextWithImageImagePlacement;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = action;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Action getAction() {
        return this.h;
    }

    @Nullable
    public final String getAdditionalDescription() {
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

    @NotNull
    public final BrandspaceTextWithImageImagePlacement getImagePlacement() {
        return this.d;
    }

    @Nullable
    public final String getTitle() {
        return this.e;
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
        parcel.writeParcelable(this.c, i);
        parcel.writeString(this.d.name());
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeParcelable(this.h, i);
    }
}
