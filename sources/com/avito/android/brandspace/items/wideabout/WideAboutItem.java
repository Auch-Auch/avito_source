package com.avito.android.brandspace.items.wideabout;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.TrackableBrandspaceItem;
import com.avito.android.brandspace.remote.model.BrandspaceAboutParagraphElement;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e¢\u0006\u0004\b?\u0010@J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0011J\\\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\nJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b%\u0010\u001fJ \u0010*\u001a\u00020)2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b*\u0010+R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\nR\"\u0010\u0015\u001a\u00020\u00058\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u00103R\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0011R\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010\u0004R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010\rR\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b=\u00105\u001a\u0004\b>\u0010\u0011¨\u0006A"}, d2 = {"Lcom/avito/android/brandspace/items/wideabout/WideAboutItem;", "Lcom/avito/android/brandspace/presenter/TrackableBrandspaceItem;", "", "component1", "()J", "Lcom/avito/android/brandspace/items/BlockType;", "component2", "()Lcom/avito/android/brandspace/items/BlockType;", "", "component3", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "component4", "()Lcom/avito/android/remote/model/Image;", "", "Lcom/avito/android/brandspace/remote/model/BrandspaceAboutParagraphElement;", "component5", "()Ljava/util/List;", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "component6", "id", "type", "title", "image", "paragraphs", "narrowAboutItems", "copy", "(JLcom/avito/android/brandspace/items/BlockType;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/util/List;Ljava/util/List;)Lcom/avito/android/brandspace/items/wideabout/WideAboutItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Ljava/lang/String;", "getTitle", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", "setType", "(Lcom/avito/android/brandspace/items/BlockType;)V", "e", "Ljava/util/List;", "getParagraphs", AuthSource.SEND_ABUSE, "J", "getId", "d", "Lcom/avito/android/remote/model/Image;", "getImage", "f", "getNarrowAboutItems", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/util/List;Ljava/util/List;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class WideAboutItem implements TrackableBrandspaceItem {
    public static final Parcelable.Creator<WideAboutItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public BlockType b;
    @Nullable
    public final String c;
    @Nullable
    public final Image d;
    @NotNull
    public final List<BrandspaceAboutParagraphElement> e;
    @NotNull
    public final List<BrandspaceItem> f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<WideAboutItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WideAboutItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            long readLong = parcel.readLong();
            BlockType blockType = (BlockType) Enum.valueOf(BlockType.class, parcel.readString());
            String readString = parcel.readString();
            Image image = (Image) parcel.readParcelable(WideAboutItem.class.getClassLoader());
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((BrandspaceAboutParagraphElement) parcel.readParcelable(WideAboutItem.class.getClassLoader()));
                readInt--;
            }
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add((BrandspaceItem) parcel.readParcelable(WideAboutItem.class.getClassLoader()));
                readInt2--;
            }
            return new WideAboutItem(readLong, blockType, readString, image, arrayList, arrayList2);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WideAboutItem[] newArray(int i) {
            return new WideAboutItem[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.List<? extends com.avito.android.brandspace.presenter.BrandspaceItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public WideAboutItem(long j, @NotNull BlockType blockType, @Nullable String str, @Nullable Image image, @NotNull List<BrandspaceAboutParagraphElement> list, @NotNull List<? extends BrandspaceItem> list2) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(list, "paragraphs");
        Intrinsics.checkNotNullParameter(list2, "narrowAboutItems");
        this.a = j;
        this.b = blockType;
        this.c = str;
        this.d = image;
        this.e = list;
        this.f = list2;
    }

    public static /* synthetic */ WideAboutItem copy$default(WideAboutItem wideAboutItem, long j, BlockType blockType, String str, Image image, List list, List list2, int i, Object obj) {
        return wideAboutItem.copy((i & 1) != 0 ? wideAboutItem.getId() : j, (i & 2) != 0 ? wideAboutItem.getType() : blockType, (i & 4) != 0 ? wideAboutItem.c : str, (i & 8) != 0 ? wideAboutItem.d : image, (i & 16) != 0 ? wideAboutItem.e : list, (i & 32) != 0 ? wideAboutItem.f : list2);
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
    public final Image component4() {
        return this.d;
    }

    @NotNull
    public final List<BrandspaceAboutParagraphElement> component5() {
        return this.e;
    }

    @NotNull
    public final List<BrandspaceItem> component6() {
        return this.f;
    }

    @NotNull
    public final WideAboutItem copy(long j, @NotNull BlockType blockType, @Nullable String str, @Nullable Image image, @NotNull List<BrandspaceAboutParagraphElement> list, @NotNull List<? extends BrandspaceItem> list2) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(list, "paragraphs");
        Intrinsics.checkNotNullParameter(list2, "narrowAboutItems");
        return new WideAboutItem(j, blockType, str, image, list, list2);
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
        if (!(obj instanceof WideAboutItem)) {
            return false;
        }
        WideAboutItem wideAboutItem = (WideAboutItem) obj;
        return getId() == wideAboutItem.getId() && Intrinsics.areEqual(getType(), wideAboutItem.getType()) && Intrinsics.areEqual(this.c, wideAboutItem.c) && Intrinsics.areEqual(this.d, wideAboutItem.d) && Intrinsics.areEqual(this.e, wideAboutItem.e) && Intrinsics.areEqual(this.f, wideAboutItem.f);
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Nullable
    public final Image getImage() {
        return this.d;
    }

    @NotNull
    public final List<BrandspaceItem> getNarrowAboutItems() {
        return this.f;
    }

    @NotNull
    public final List<BrandspaceAboutParagraphElement> getParagraphs() {
        return this.e;
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
        Image image = this.d;
        int hashCode3 = (hashCode2 + (image != null ? image.hashCode() : 0)) * 31;
        List<BrandspaceAboutParagraphElement> list = this.e;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<BrandspaceItem> list2 = this.f;
        if (list2 != null) {
            i = list2.hashCode();
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
        StringBuilder L = a.L("WideAboutItem(id=");
        L.append(getId());
        L.append(", type=");
        L.append(getType());
        L.append(", title=");
        L.append(this.c);
        L.append(", image=");
        L.append(this.d);
        L.append(", paragraphs=");
        L.append(this.e);
        L.append(", narrowAboutItems=");
        return a.w(L, this.f, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b.name());
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
        Iterator n0 = a.n0(this.e, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((BrandspaceAboutParagraphElement) n0.next(), i);
        }
        Iterator n02 = a.n0(this.f, parcel);
        while (n02.hasNext()) {
            parcel.writeParcelable((BrandspaceItem) n02.next(), i);
        }
    }
}
