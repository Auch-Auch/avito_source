package com.avito.android.advert.item.carousel_photogallery;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.Video;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b%\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003Bq\u0012\b\b\u0002\u0010\"\u001a\u00020\b\u0012\b\b\u0002\u0010#\u001a\u00020\u000b\u0012\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\b\b\u0002\u0010'\u001a\u00020\b\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010)\u001a\u00020\u0004\u0012\b\b\u0002\u0010*\u001a\u00020\u001c\u0012\b\b\u0002\u0010+\u001a\u00020\u001f¢\u0006\u0004\b\\\u0010]J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0017\u0010\nJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0016J\u0010\u0010\u001d\u001a\u00020\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÆ\u0003¢\u0006\u0004\b \u0010!J\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\u000b2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020\b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010)\u001a\u00020\u00042\b\b\u0002\u0010*\u001a\u00020\u001c2\b\b\u0002\u0010+\u001a\u00020\u001fHÆ\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b.\u0010\rJ\u0010\u0010/\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b/\u0010\u0016J\u001a\u00103\u001a\u0002022\b\u00101\u001a\u0004\u0018\u000100HÖ\u0003¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b5\u0010\u0016J \u0010:\u001a\u0002092\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b:\u0010;R!\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\u0011R\u001c\u0010+\u001a\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010!R\u001c\u0010\"\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010\nR\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010\u0016\"\u0004\bH\u0010IR\u001c\u0010#\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010\rR\u001b\u0010(\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010\u001aR\u001b\u0010%\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010\u0014R\"\u0010*\u001a\u00020\u001c8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010\u001e\"\u0004\bV\u0010WR\u001c\u0010)\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bX\u0010F\u001a\u0004\bY\u0010\u0016R\u0019\u0010'\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\bZ\u0010C\u001a\u0004\b[\u0010\n¨\u0006^"}, d2 = {"Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/Image;", "component3", "()Ljava/util/List;", "Lcom/avito/android/remote/model/Video;", "component4", "()Lcom/avito/android/remote/model/Video;", "component5", "()I", "component6", "Lcom/avito/android/remote/model/ForegroundImage;", "component7", "()Lcom/avito/android/remote/model/ForegroundImage;", "component8", "Lcom/avito/android/remote/model/SerpDisplayType;", "component9", "()Lcom/avito/android/remote/model/SerpDisplayType;", "Lcom/avito/android/serp/adapter/SerpViewType;", "component10", "()Lcom/avito/android/serp/adapter/SerpViewType;", "id", "stringId", "images", "video", "currentPosition", "stateId", "infoImage", "spanCount", "displayType", "viewType", "copy", "(JLjava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/Video;IJLcom/avito/android/remote/model/ForegroundImage;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryItem;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Ljava/util/List;", "getImages", "j", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", AuthSource.SEND_ABUSE, "J", "getId", "e", "I", "getCurrentPosition", "setCurrentPosition", "(I)V", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", g.a, "Lcom/avito/android/remote/model/ForegroundImage;", "getInfoImage", "d", "Lcom/avito/android/remote/model/Video;", "getVideo", "i", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "h", "getSpanCount", "f", "getStateId", "<init>", "(JLjava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/Video;IJLcom/avito/android/remote/model/ForegroundImage;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class CarouselPhotoGalleryItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<CarouselPhotoGalleryItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final String b;
    @Nullable
    public final List<Image> c;
    @Nullable
    public final Video d;
    public int e;
    public final long f;
    @Nullable
    public final ForegroundImage g;
    public final int h;
    @NotNull
    public SerpDisplayType i;
    @NotNull
    public final SerpViewType j;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CarouselPhotoGalleryItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CarouselPhotoGalleryItem createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((Image) parcel.readParcelable(CarouselPhotoGalleryItem.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new CarouselPhotoGalleryItem(readLong, readString, arrayList, (Video) parcel.readParcelable(CarouselPhotoGalleryItem.class.getClassLoader()), parcel.readInt(), parcel.readLong(), (ForegroundImage) parcel.readParcelable(CarouselPhotoGalleryItem.class.getClassLoader()), parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CarouselPhotoGalleryItem[] newArray(int i) {
            return new CarouselPhotoGalleryItem[i];
        }
    }

    public CarouselPhotoGalleryItem(long j2, @NotNull String str, @Nullable List<Image> list, @Nullable Video video, int i2, long j3, @Nullable ForegroundImage foregroundImage, int i3, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j2;
        this.b = str;
        this.c = list;
        this.d = video;
        this.e = i2;
        this.f = j3;
        this.g = foregroundImage;
        this.h = i3;
        this.i = serpDisplayType;
        this.j = serpViewType;
    }

    public static /* synthetic */ CarouselPhotoGalleryItem copy$default(CarouselPhotoGalleryItem carouselPhotoGalleryItem, long j2, String str, List list, Video video, int i2, long j3, ForegroundImage foregroundImage, int i3, SerpDisplayType serpDisplayType, SerpViewType serpViewType, int i4, Object obj) {
        return carouselPhotoGalleryItem.copy((i4 & 1) != 0 ? carouselPhotoGalleryItem.getId() : j2, (i4 & 2) != 0 ? carouselPhotoGalleryItem.getStringId() : str, (i4 & 4) != 0 ? carouselPhotoGalleryItem.c : list, (i4 & 8) != 0 ? carouselPhotoGalleryItem.d : video, (i4 & 16) != 0 ? carouselPhotoGalleryItem.e : i2, (i4 & 32) != 0 ? carouselPhotoGalleryItem.f : j3, (i4 & 64) != 0 ? carouselPhotoGalleryItem.g : foregroundImage, (i4 & 128) != 0 ? carouselPhotoGalleryItem.getSpanCount() : i3, (i4 & 256) != 0 ? carouselPhotoGalleryItem.getDisplayType() : serpDisplayType, (i4 & 512) != 0 ? carouselPhotoGalleryItem.getViewType() : serpViewType);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final SerpViewType component10() {
        return getViewType();
    }

    @NotNull
    public final String component2() {
        return getStringId();
    }

    @Nullable
    public final List<Image> component3() {
        return this.c;
    }

    @Nullable
    public final Video component4() {
        return this.d;
    }

    public final int component5() {
        return this.e;
    }

    public final long component6() {
        return this.f;
    }

    @Nullable
    public final ForegroundImage component7() {
        return this.g;
    }

    public final int component8() {
        return getSpanCount();
    }

    @NotNull
    public final SerpDisplayType component9() {
        return getDisplayType();
    }

    @NotNull
    public final CarouselPhotoGalleryItem copy(long j2, @NotNull String str, @Nullable List<Image> list, @Nullable Video video, int i2, long j3, @Nullable ForegroundImage foregroundImage, int i3, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        return new CarouselPhotoGalleryItem(j2, str, list, video, i2, j3, foregroundImage, i3, serpDisplayType, serpViewType);
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i2) {
        return copy$default(this, 0, null, null, null, 0, 0, null, i2, null, null, 895, null);
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
        if (!(obj instanceof CarouselPhotoGalleryItem)) {
            return false;
        }
        CarouselPhotoGalleryItem carouselPhotoGalleryItem = (CarouselPhotoGalleryItem) obj;
        return getId() == carouselPhotoGalleryItem.getId() && Intrinsics.areEqual(getStringId(), carouselPhotoGalleryItem.getStringId()) && Intrinsics.areEqual(this.c, carouselPhotoGalleryItem.c) && Intrinsics.areEqual(this.d, carouselPhotoGalleryItem.d) && this.e == carouselPhotoGalleryItem.e && this.f == carouselPhotoGalleryItem.f && Intrinsics.areEqual(this.g, carouselPhotoGalleryItem.g) && getSpanCount() == carouselPhotoGalleryItem.getSpanCount() && Intrinsics.areEqual(getDisplayType(), carouselPhotoGalleryItem.getDisplayType()) && Intrinsics.areEqual(getViewType(), carouselPhotoGalleryItem.getViewType());
    }

    public final int getCurrentPosition() {
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.i;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Nullable
    public final List<Image> getImages() {
        return this.c;
    }

    @Nullable
    public final ForegroundImage getInfoImage() {
        return this.g;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.h;
    }

    public final long getStateId() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Nullable
    public final Video getVideo() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.j;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int a3 = c.a(getId()) * 31;
        String stringId = getStringId();
        int i2 = 0;
        int hashCode = (a3 + (stringId != null ? stringId.hashCode() : 0)) * 31;
        List<Image> list = this.c;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        Video video = this.d;
        int hashCode3 = (((((hashCode2 + (video != null ? video.hashCode() : 0)) * 31) + this.e) * 31) + c.a(this.f)) * 31;
        ForegroundImage foregroundImage = this.g;
        int spanCount = (getSpanCount() + ((hashCode3 + (foregroundImage != null ? foregroundImage.hashCode() : 0)) * 31)) * 31;
        SerpDisplayType displayType = getDisplayType();
        int hashCode4 = (spanCount + (displayType != null ? displayType.hashCode() : 0)) * 31;
        SerpViewType viewType = getViewType();
        if (viewType != null) {
            i2 = viewType.hashCode();
        }
        return hashCode4 + i2;
    }

    public final void setCurrentPosition(int i2) {
        this.e = i2;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.i = serpDisplayType;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CarouselPhotoGalleryItem(id=");
        L.append(getId());
        L.append(", stringId=");
        L.append(getStringId());
        L.append(", images=");
        L.append(this.c);
        L.append(", video=");
        L.append(this.d);
        L.append(", currentPosition=");
        L.append(this.e);
        L.append(", stateId=");
        L.append(this.f);
        L.append(", infoImage=");
        L.append(this.g);
        L.append(", spanCount=");
        L.append(getSpanCount());
        L.append(", displayType=");
        L.append(getDisplayType());
        L.append(", viewType=");
        L.append(getViewType());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        List<Image> list = this.c;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((Image) l0.next(), i2);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.d, i2);
        parcel.writeInt(this.e);
        parcel.writeLong(this.f);
        parcel.writeParcelable(this.g, i2);
        parcel.writeInt(this.h);
        parcel.writeString(this.i.name());
        parcel.writeString(this.j.name());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CarouselPhotoGalleryItem(long r19, java.lang.String r21, java.util.List r22, com.avito.android.remote.model.Video r23, int r24, long r25, com.avito.android.remote.model.ForegroundImage r27, int r28, com.avito.android.remote.model.SerpDisplayType r29, com.avito.android.serp.adapter.SerpViewType r30, int r31, t6.r.a.j r32) {
        /*
            r18 = this;
            r0 = r31
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000c
            com.avito.android.advert_core.advert.AdvertDetailsItem r1 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_GALLERY
            long r3 = (long) r2
            r6 = r3
            goto L_0x000e
        L_0x000c:
            r6 = r19
        L_0x000e:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0018
            java.lang.String r1 = java.lang.String.valueOf(r6)
            r8 = r1
            goto L_0x001a
        L_0x0018:
            r8 = r21
        L_0x001a:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0020
            r11 = 0
            goto L_0x0022
        L_0x0020:
            r11 = r24
        L_0x0022:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x002a
            r1 = 0
            r12 = r1
            goto L_0x002c
        L_0x002a:
            r12 = r25
        L_0x002c:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0033
            r1 = 0
            r14 = r1
            goto L_0x0035
        L_0x0033:
            r14 = r27
        L_0x0035:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x003e
            com.avito.android.remote.model.SerpDisplayType r1 = com.avito.android.remote.model.SerpDisplayType.Grid
            r16 = r1
            goto L_0x0040
        L_0x003e:
            r16 = r29
        L_0x0040:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0049
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r17 = r0
            goto L_0x004b
        L_0x0049:
            r17 = r30
        L_0x004b:
            r5 = r18
            r9 = r22
            r10 = r23
            r15 = r28
            r5.<init>(r6, r8, r9, r10, r11, r12, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.carousel_photogallery.CarouselPhotoGalleryItem.<init>(long, java.lang.String, java.util.List, com.avito.android.remote.model.Video, int, long, com.avito.android.remote.model.ForegroundImage, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}
