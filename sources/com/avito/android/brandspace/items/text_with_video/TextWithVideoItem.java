package com.avito.android.brandspace.items.text_with_video;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.presenter.TrackableBrandspaceItem;
import com.avito.android.brandspace.remote.model.BrandspaceTextWithVideoImagePlacement;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001BY\u0012\u0006\u00103\u001a\u00020.\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010$\u001a\u00020\u001f\u0012\b\u00109\u001a\u0004\u0018\u00010%\u0012\b\u00106\u001a\u0004\u0018\u00010%\u0012\b\u0010*\u001a\u0004\u0018\u00010%\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010-\u001a\u0004\u0018\u00010%¢\u0006\u0004\b:\u0010;J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u000b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001e\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010$\u001a\u00020\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010*\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010-\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b,\u0010)R\u001c\u00103\u001a\u00020.8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001b\u00106\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010'\u001a\u0004\b5\u0010)R\u001b\u00109\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010'\u001a\u0004\b8\u0010)¨\u0006<"}, d2 = {"Lcom/avito/android/brandspace/items/text_with_video/TextWithVideoItem;", "Lcom/avito/android/brandspace/presenter/TrackableBrandspaceItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/brandspace/items/BlockType;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", "()Lcom/avito/android/brandspace/items/BlockType;", "setType", "(Lcom/avito/android/brandspace/items/BlockType;)V", "type", "Lcom/avito/android/remote/model/Action;", "h", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Image;", "c", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithVideoImagePlacement;", "d", "Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithVideoImagePlacement;", "getImagePlacement", "()Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithVideoImagePlacement;", "imagePlacement", "", g.a, "Ljava/lang/String;", "getAdditionalDescription", "()Ljava/lang/String;", "additionalDescription", "i", "getVideoUrl", "videoUrl", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "f", "getDescription", "description", "e", "getTitle", "title", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;Lcom/avito/android/remote/model/Image;Lcom/avito/android/brandspace/remote/model/BrandspaceTextWithVideoImagePlacement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;Ljava/lang/String;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class TextWithVideoItem implements TrackableBrandspaceItem {
    public static final Parcelable.Creator<TextWithVideoItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public BlockType b;
    @NotNull
    public final Image c;
    @NotNull
    public final BrandspaceTextWithVideoImagePlacement d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    @Nullable
    public final Action h;
    @Nullable
    public final String i;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<TextWithVideoItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TextWithVideoItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new TextWithVideoItem(parcel.readLong(), (BlockType) Enum.valueOf(BlockType.class, parcel.readString()), (Image) parcel.readParcelable(TextWithVideoItem.class.getClassLoader()), (BrandspaceTextWithVideoImagePlacement) Enum.valueOf(BrandspaceTextWithVideoImagePlacement.class, parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), (Action) parcel.readParcelable(TextWithVideoItem.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TextWithVideoItem[] newArray(int i) {
            return new TextWithVideoItem[i];
        }
    }

    public TextWithVideoItem(long j, @NotNull BlockType blockType, @NotNull Image image, @NotNull BrandspaceTextWithVideoImagePlacement brandspaceTextWithVideoImagePlacement, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Action action, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(brandspaceTextWithVideoImagePlacement, "imagePlacement");
        this.a = j;
        this.b = blockType;
        this.c = image;
        this.d = brandspaceTextWithVideoImagePlacement;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = action;
        this.i = str4;
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

    @NotNull
    public final Image getImage() {
        return this.c;
    }

    @NotNull
    public final BrandspaceTextWithVideoImagePlacement getImagePlacement() {
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

    @Nullable
    public final String getVideoUrl() {
        return this.i;
    }

    public void setType(@NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(blockType, "<set-?>");
        this.b = blockType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b.name());
        parcel.writeParcelable(this.c, i2);
        parcel.writeString(this.d.name());
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeParcelable(this.h, i2);
        parcel.writeString(this.i);
    }
}
