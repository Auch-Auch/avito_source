package com.avito.android.photo_gallery;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b$\b\b\u0018\u00002\u00020\u0001B{\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\b\u0010%\u001a\u0004\u0018\u00010\f\u0012\b\u0010&\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010'\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010,\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b]\u0010^J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0011J\u0012\u0010!\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0001\u0010.\u001a\u00020\u00002\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010$\u001a\u00020\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010 HÆ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b0\u0010\u0011J\u0010\u00101\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b1\u0010\u000bJ\u001a\u00105\u001a\u0002042\b\u00103\u001a\u0004\u0018\u000102HÖ\u0003¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b7\u0010\u000bJ \u0010<\u001a\u00020;2\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b<\u0010=R\u001b\u0010+\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010\u001eR\u0019\u0010$\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010\u000bR\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\tR\u001b\u0010*\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010\u001bR\u001b\u0010)\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010\u0018R\u001b\u0010(\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010\u0015R\u001b\u0010%\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010\u000eR\u001b\u0010-\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010\"R\u001b\u0010'\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010\u0011R\u001b\u0010&\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bY\u0010W\u001a\u0004\bZ\u0010\u0011R\u001b\u0010,\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b[\u0010W\u001a\u0004\b\\\u0010\u0011¨\u0006_"}, d2 = {"Lcom/avito/android/photo_gallery/PhotoGalleryData;", "Landroid/os/Parcelable;", "", "pos", "copyWithPosition", "(I)Lcom/avito/android/photo_gallery/PhotoGalleryData;", "", "Lcom/avito/android/remote/model/Image;", "component1", "()Ljava/util/List;", "component2", "()I", "Lcom/avito/android/remote/model/Video;", "component3", "()Lcom/avito/android/remote/model/Video;", "", "component4", "()Ljava/lang/String;", "component5", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "component6", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "Lcom/avito/android/remote/model/AdvertActions;", "component7", "()Lcom/avito/android/remote/model/AdvertActions;", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "component8", "()Lcom/avito/android/remote/model/advert_details/ContactBarData;", "", "component9", "()Ljava/lang/Long;", "component10", "Lcom/avito/android/remote/model/ForegroundImage;", "component11", "()Lcom/avito/android/remote/model/ForegroundImage;", "images", VKApiConst.POSITION, "video", BookingInfoActivity.EXTRA_ITEM_ID, "categoryId", "treeParent", "actions", "data", "stateId", "searchContext", "foregroundImage", "copy", "(Ljava/util/List;ILcom/avito/android/remote/model/Video;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/remote/model/AdvertActions;Lcom/avito/android/remote/model/advert_details/ContactBarData;Ljava/lang/Long;Ljava/lang/String;Lcom/avito/android/remote/model/ForegroundImage;)Lcom/avito/android/photo_gallery/PhotoGalleryData;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "i", "Ljava/lang/Long;", "getStateId", AuthSource.BOOKING_ORDER, "I", "getPosition", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getImages", "h", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "getData", g.a, "Lcom/avito/android/remote/model/AdvertActions;", "getActions", "f", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getTreeParent", "c", "Lcom/avito/android/remote/model/Video;", "getVideo", "k", "Lcom/avito/android/remote/model/ForegroundImage;", "getForegroundImage", "e", "Ljava/lang/String;", "getCategoryId", "d", "getAdvertId", "j", "getSearchContext", "<init>", "(Ljava/util/List;ILcom/avito/android/remote/model/Video;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/remote/model/AdvertActions;Lcom/avito/android/remote/model/advert_details/ContactBarData;Ljava/lang/Long;Ljava/lang/String;Lcom/avito/android/remote/model/ForegroundImage;)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoGalleryData implements Parcelable {
    public static final Parcelable.Creator<PhotoGalleryData> CREATOR = new Creator();
    @NotNull
    public final List<Image> a;
    public final int b;
    @Nullable
    public final Video c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final TreeClickStreamParent f;
    @Nullable
    public final AdvertActions g;
    @Nullable
    public final ContactBarData h;
    @Nullable
    public final Long i;
    @Nullable
    public final String j;
    @Nullable
    public final ForegroundImage k;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PhotoGalleryData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoGalleryData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((Image) parcel.readParcelable(PhotoGalleryData.class.getClassLoader()));
                readInt--;
            }
            return new PhotoGalleryData(arrayList, parcel.readInt(), (Video) parcel.readParcelable(PhotoGalleryData.class.getClassLoader()), parcel.readString(), parcel.readString(), (TreeClickStreamParent) parcel.readParcelable(PhotoGalleryData.class.getClassLoader()), (AdvertActions) parcel.readParcelable(PhotoGalleryData.class.getClassLoader()), (ContactBarData) parcel.readParcelable(PhotoGalleryData.class.getClassLoader()), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readString(), (ForegroundImage) parcel.readParcelable(PhotoGalleryData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoGalleryData[] newArray(int i) {
            return new PhotoGalleryData[i];
        }
    }

    public PhotoGalleryData(@NotNull List<Image> list, int i2, @Nullable Video video, @Nullable String str, @Nullable String str2, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable AdvertActions advertActions, @Nullable ContactBarData contactBarData, @Nullable Long l, @Nullable String str3, @Nullable ForegroundImage foregroundImage) {
        Intrinsics.checkNotNullParameter(list, "images");
        this.a = list;
        this.b = i2;
        this.c = video;
        this.d = str;
        this.e = str2;
        this.f = treeClickStreamParent;
        this.g = advertActions;
        this.h = contactBarData;
        this.i = l;
        this.j = str3;
        this.k = foregroundImage;
    }

    public static /* synthetic */ PhotoGalleryData copy$default(PhotoGalleryData photoGalleryData, List list, int i2, Video video, String str, String str2, TreeClickStreamParent treeClickStreamParent, AdvertActions advertActions, ContactBarData contactBarData, Long l, String str3, ForegroundImage foregroundImage, int i3, Object obj) {
        return photoGalleryData.copy((i3 & 1) != 0 ? photoGalleryData.a : list, (i3 & 2) != 0 ? photoGalleryData.b : i2, (i3 & 4) != 0 ? photoGalleryData.c : video, (i3 & 8) != 0 ? photoGalleryData.d : str, (i3 & 16) != 0 ? photoGalleryData.e : str2, (i3 & 32) != 0 ? photoGalleryData.f : treeClickStreamParent, (i3 & 64) != 0 ? photoGalleryData.g : advertActions, (i3 & 128) != 0 ? photoGalleryData.h : contactBarData, (i3 & 256) != 0 ? photoGalleryData.i : l, (i3 & 512) != 0 ? photoGalleryData.j : str3, (i3 & 1024) != 0 ? photoGalleryData.k : foregroundImage);
    }

    @NotNull
    public final List<Image> component1() {
        return this.a;
    }

    @Nullable
    public final String component10() {
        return this.j;
    }

    @Nullable
    public final ForegroundImage component11() {
        return this.k;
    }

    public final int component2() {
        return this.b;
    }

    @Nullable
    public final Video component3() {
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
    public final TreeClickStreamParent component6() {
        return this.f;
    }

    @Nullable
    public final AdvertActions component7() {
        return this.g;
    }

    @Nullable
    public final ContactBarData component8() {
        return this.h;
    }

    @Nullable
    public final Long component9() {
        return this.i;
    }

    @NotNull
    public final PhotoGalleryData copy(@NotNull List<Image> list, int i2, @Nullable Video video, @Nullable String str, @Nullable String str2, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable AdvertActions advertActions, @Nullable ContactBarData contactBarData, @Nullable Long l, @Nullable String str3, @Nullable ForegroundImage foregroundImage) {
        Intrinsics.checkNotNullParameter(list, "images");
        return new PhotoGalleryData(list, i2, video, str, str2, treeClickStreamParent, advertActions, contactBarData, l, str3, foregroundImage);
    }

    @NotNull
    public final PhotoGalleryData copyWithPosition(int i2) {
        return new PhotoGalleryData(this.a, i2, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
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
        if (!(obj instanceof PhotoGalleryData)) {
            return false;
        }
        PhotoGalleryData photoGalleryData = (PhotoGalleryData) obj;
        return Intrinsics.areEqual(this.a, photoGalleryData.a) && this.b == photoGalleryData.b && Intrinsics.areEqual(this.c, photoGalleryData.c) && Intrinsics.areEqual(this.d, photoGalleryData.d) && Intrinsics.areEqual(this.e, photoGalleryData.e) && Intrinsics.areEqual(this.f, photoGalleryData.f) && Intrinsics.areEqual(this.g, photoGalleryData.g) && Intrinsics.areEqual(this.h, photoGalleryData.h) && Intrinsics.areEqual(this.i, photoGalleryData.i) && Intrinsics.areEqual(this.j, photoGalleryData.j) && Intrinsics.areEqual(this.k, photoGalleryData.k);
    }

    @Nullable
    public final AdvertActions getActions() {
        return this.g;
    }

    @Nullable
    public final String getAdvertId() {
        return this.d;
    }

    @Nullable
    public final String getCategoryId() {
        return this.e;
    }

    @Nullable
    public final ContactBarData getData() {
        return this.h;
    }

    @Nullable
    public final ForegroundImage getForegroundImage() {
        return this.k;
    }

    @NotNull
    public final List<Image> getImages() {
        return this.a;
    }

    public final int getPosition() {
        return this.b;
    }

    @Nullable
    public final String getSearchContext() {
        return this.j;
    }

    @Nullable
    public final Long getStateId() {
        return this.i;
    }

    @Nullable
    public final TreeClickStreamParent getTreeParent() {
        return this.f;
    }

    @Nullable
    public final Video getVideo() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        List<Image> list = this.a;
        int i2 = 0;
        int hashCode = (((list != null ? list.hashCode() : 0) * 31) + this.b) * 31;
        Video video = this.c;
        int hashCode2 = (hashCode + (video != null ? video.hashCode() : 0)) * 31;
        String str = this.d;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.e;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        TreeClickStreamParent treeClickStreamParent = this.f;
        int hashCode5 = (hashCode4 + (treeClickStreamParent != null ? treeClickStreamParent.hashCode() : 0)) * 31;
        AdvertActions advertActions = this.g;
        int hashCode6 = (hashCode5 + (advertActions != null ? advertActions.hashCode() : 0)) * 31;
        ContactBarData contactBarData = this.h;
        int hashCode7 = (hashCode6 + (contactBarData != null ? contactBarData.hashCode() : 0)) * 31;
        Long l = this.i;
        int hashCode8 = (hashCode7 + (l != null ? l.hashCode() : 0)) * 31;
        String str3 = this.j;
        int hashCode9 = (hashCode8 + (str3 != null ? str3.hashCode() : 0)) * 31;
        ForegroundImage foregroundImage = this.k;
        if (foregroundImage != null) {
            i2 = foregroundImage.hashCode();
        }
        return hashCode9 + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("PhotoGalleryData(images=");
        L.append(this.a);
        L.append(", position=");
        L.append(this.b);
        L.append(", video=");
        L.append(this.c);
        L.append(", advertId=");
        L.append(this.d);
        L.append(", categoryId=");
        L.append(this.e);
        L.append(", treeParent=");
        L.append(this.f);
        L.append(", actions=");
        L.append(this.g);
        L.append(", data=");
        L.append(this.h);
        L.append(", stateId=");
        L.append(this.i);
        L.append(", searchContext=");
        L.append(this.j);
        L.append(", foregroundImage=");
        L.append(this.k);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.a, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((Image) n0.next(), i2);
        }
        parcel.writeInt(this.b);
        parcel.writeParcelable(this.c, i2);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeParcelable(this.f, i2);
        parcel.writeParcelable(this.g, i2);
        parcel.writeParcelable(this.h, i2);
        Long l = this.i;
        if (l != null) {
            a.I0(parcel, 1, l);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.j);
        parcel.writeParcelable(this.k, i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoGalleryData(List list, int i2, Video video, String str, String str2, TreeClickStreamParent treeClickStreamParent, AdvertActions advertActions, ContactBarData contactBarData, Long l, String str3, ForegroundImage foregroundImage, int i3, j jVar) {
        this(list, i2, video, str, str2, treeClickStreamParent, advertActions, contactBarData, (i3 & 256) != 0 ? -1L : l, str3, (i3 & 1024) != 0 ? null : foregroundImage);
    }
}
