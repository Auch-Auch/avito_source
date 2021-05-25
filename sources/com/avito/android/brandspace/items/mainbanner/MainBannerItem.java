package com.avito.android.brandspace.items.mainbanner;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.presenter.TrackableBrandspaceItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b=\u0010>J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JR\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\rJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b#\u0010\u001dJ \u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b(\u0010)R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0011R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\rR\u001c\u0010\u0012\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\nR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010.\u001a\u0004\b7\u0010\rR\"\u0010\u0013\u001a\u00020\u00058\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010\u0007\"\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/avito/android/brandspace/items/mainbanner/MainBannerItem;", "Lcom/avito/android/brandspace/presenter/TrackableBrandspaceItem;", "", "component1", "()J", "Lcom/avito/android/brandspace/items/BlockType;", "component2", "()Lcom/avito/android/brandspace/items/BlockType;", "Lcom/avito/android/remote/model/Image;", "component3", "()Lcom/avito/android/remote/model/Image;", "", "component4", "()Ljava/lang/String;", "component5", "Lcom/avito/android/remote/model/Action;", "component6", "()Lcom/avito/android/remote/model/Action;", "id", "type", "image", "title", "description", "action", "copy", "(JLcom/avito/android/brandspace/items/BlockType;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)Lcom/avito/android/brandspace/items/mainbanner/MainBannerItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "f", "Lcom/avito/android/remote/model/Action;", "getAction", "e", "Ljava/lang/String;", "getDescription", AuthSource.SEND_ABUSE, "J", "getId", "c", "Lcom/avito/android/remote/model/Image;", "getImage", "d", "getTitle", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", "setType", "(Lcom/avito/android/brandspace/items/BlockType;)V", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MainBannerItem implements TrackableBrandspaceItem {
    public static final Parcelable.Creator<MainBannerItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public BlockType b;
    @NotNull
    public final Image c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final Action f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MainBannerItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MainBannerItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new MainBannerItem(parcel.readLong(), (BlockType) Enum.valueOf(BlockType.class, parcel.readString()), (Image) parcel.readParcelable(MainBannerItem.class.getClassLoader()), parcel.readString(), parcel.readString(), (Action) parcel.readParcelable(MainBannerItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MainBannerItem[] newArray(int i) {
            return new MainBannerItem[i];
        }
    }

    public MainBannerItem(long j, @NotNull BlockType blockType, @NotNull Image image, @Nullable String str, @Nullable String str2, @Nullable Action action) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(image, "image");
        this.a = j;
        this.b = blockType;
        this.c = image;
        this.d = str;
        this.e = str2;
        this.f = action;
    }

    public static /* synthetic */ MainBannerItem copy$default(MainBannerItem mainBannerItem, long j, BlockType blockType, Image image, String str, String str2, Action action, int i, Object obj) {
        return mainBannerItem.copy((i & 1) != 0 ? mainBannerItem.getId() : j, (i & 2) != 0 ? mainBannerItem.getType() : blockType, (i & 4) != 0 ? mainBannerItem.c : image, (i & 8) != 0 ? mainBannerItem.d : str, (i & 16) != 0 ? mainBannerItem.e : str2, (i & 32) != 0 ? mainBannerItem.f : action);
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

    @Nullable
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @Nullable
    public final Action component6() {
        return this.f;
    }

    @NotNull
    public final MainBannerItem copy(long j, @NotNull BlockType blockType, @NotNull Image image, @Nullable String str, @Nullable String str2, @Nullable Action action) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(image, "image");
        return new MainBannerItem(j, blockType, image, str, str2, action);
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
        if (!(obj instanceof MainBannerItem)) {
            return false;
        }
        MainBannerItem mainBannerItem = (MainBannerItem) obj;
        return getId() == mainBannerItem.getId() && Intrinsics.areEqual(getType(), mainBannerItem.getType()) && Intrinsics.areEqual(this.c, mainBannerItem.c) && Intrinsics.areEqual(this.d, mainBannerItem.d) && Intrinsics.areEqual(this.e, mainBannerItem.e) && Intrinsics.areEqual(this.f, mainBannerItem.f);
    }

    @Nullable
    public final Action getAction() {
        return this.f;
    }

    @Nullable
    public final String getDescription() {
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
        Action action = this.f;
        if (action != null) {
            i = action.hashCode();
        }
        return hashCode4 + i;
    }

    public void setType(@NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(blockType, "<set-?>");
        this.b = blockType;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("MainBannerItem(id=");
        L.append(getId());
        L.append(", type=");
        L.append(getType());
        L.append(", image=");
        L.append(this.c);
        L.append(", title=");
        L.append(this.d);
        L.append(", description=");
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
        parcel.writeString(this.e);
        parcel.writeParcelable(this.f, i);
    }
}
