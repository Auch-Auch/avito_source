package com.avito.android.advert.item.photogallery;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AutotekaCpoTeaser;
import com.avito.android.remote.model.AutotekaTeaserResult;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0001\u0012\b\b\u0002\u0010*\u001a\u00020%\u0012\b\b\u0002\u0010>\u001a\u00020\u0010\u0012\u000e\u0010W\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010Q\u0012\b\u0010D\u001a\u0004\u0018\u00010?\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u0010!\u001a\u00020\u0004\u0012\b\b\u0002\u0010-\u001a\u00020%\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010$\u001a\u00020\u0004\u0012\b\b\u0002\u00105\u001a\u00020.\u0012\b\b\u0002\u0010P\u001a\u00020K\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010E¢\u0006\u0004\bX\u0010YJ\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010 R\u001c\u0010$\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\tR\u001c\u0010*\u001a\u00020%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010-\u001a\u00020%8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b,\u0010)R\"\u00105\u001a\u00020.8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001b\u0010;\u001a\u0004\u0018\u0001068\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001c\u0010>\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b<\u0010\u0012\u001a\u0004\b=\u0010\u0014R\u001b\u0010D\u001a\u0004\u0018\u00010?8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001b\u0010J\u001a\u0004\u0018\u00010E8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001c\u0010P\u001a\u00020K8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR!\u0010W\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010Q8\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V¨\u0006Z"}, d2 = {"Lcom/avito/android/advert/item/photogallery/AdvertDetailsGalleryItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "h", "Ljava/lang/String;", "getAdvertId", "()Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/remote/model/ForegroundImage;", "i", "Lcom/avito/android/remote/model/ForegroundImage;", "getInfoImage", "()Lcom/avito/android/remote/model/ForegroundImage;", "infoImage", "f", "I", "getCurrentPosition", "setCurrentPosition", "(I)V", "currentPosition", "j", "getSpanCount", "spanCount", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", g.a, "getStateId", "stateId", "Lcom/avito/android/remote/model/SerpDisplayType;", "k", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "Lcom/avito/android/remote/model/AutotekaCpoTeaser;", "e", "Lcom/avito/android/remote/model/AutotekaCpoTeaser;", "getCpoTeaser", "()Lcom/avito/android/remote/model/AutotekaCpoTeaser;", "cpoTeaser", AuthSource.BOOKING_ORDER, "getStringId", "stringId", "Lcom/avito/android/remote/model/Video;", "d", "Lcom/avito/android/remote/model/Video;", "getVideo", "()Lcom/avito/android/remote/model/Video;", "video", "Lcom/avito/android/remote/model/AutotekaTeaserResult;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/remote/model/AutotekaTeaserResult;", "getAutotekaTeaser", "()Lcom/avito/android/remote/model/AutotekaTeaserResult;", "autotekaTeaser", "Lcom/avito/android/serp/adapter/SerpViewType;", "l", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "", "Lcom/avito/android/remote/model/Image;", "c", "Ljava/util/List;", "getImages", "()Ljava/util/List;", "images", "<init>", "(JLjava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/Video;Lcom/avito/android/remote/model/AutotekaCpoTeaser;IJLjava/lang/String;Lcom/avito/android/remote/model/ForegroundImage;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;Lcom/avito/android/remote/model/AutotekaTeaserResult;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsGalleryItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<AdvertDetailsGalleryItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final String b;
    @Nullable
    public final List<Image> c;
    @Nullable
    public final Video d;
    @Nullable
    public final AutotekaCpoTeaser e;
    public int f;
    public final long g;
    @NotNull
    public final String h;
    @Nullable
    public final ForegroundImage i;
    public final int j;
    @NotNull
    public SerpDisplayType k;
    @NotNull
    public final SerpViewType l;
    @Nullable
    public final AutotekaTeaserResult m;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDetailsGalleryItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsGalleryItem createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((Image) parcel.readParcelable(AdvertDetailsGalleryItem.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new AdvertDetailsGalleryItem(readLong, readString, arrayList, (Video) parcel.readParcelable(AdvertDetailsGalleryItem.class.getClassLoader()), (AutotekaCpoTeaser) parcel.readParcelable(AdvertDetailsGalleryItem.class.getClassLoader()), parcel.readInt(), parcel.readLong(), parcel.readString(), (ForegroundImage) parcel.readParcelable(AdvertDetailsGalleryItem.class.getClassLoader()), parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()), (AutotekaTeaserResult) parcel.readParcelable(AdvertDetailsGalleryItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsGalleryItem[] newArray(int i) {
            return new AdvertDetailsGalleryItem[i];
        }
    }

    public AdvertDetailsGalleryItem(long j2, @NotNull String str, @Nullable List<Image> list, @Nullable Video video, @Nullable AutotekaCpoTeaser autotekaCpoTeaser, int i2, long j3, @NotNull String str2, @Nullable ForegroundImage foregroundImage, int i3, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType, @Nullable AutotekaTeaserResult autotekaTeaserResult) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j2;
        this.b = str;
        this.c = list;
        this.d = video;
        this.e = autotekaCpoTeaser;
        this.f = i2;
        this.g = j3;
        this.h = str2;
        this.i = foregroundImage;
        this.j = i3;
        this.k = serpDisplayType;
        this.l = serpViewType;
        this.m = autotekaTeaserResult;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i2) {
        return new AdvertDetailsGalleryItem(getId(), getStringId(), this.c, this.d, this.e, this.f, this.g, this.h, this.i, i2, getDisplayType(), getViewType(), this.m);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getAdvertId() {
        return this.h;
    }

    @Nullable
    public final AutotekaTeaserResult getAutotekaTeaser() {
        return this.m;
    }

    @Nullable
    public final AutotekaCpoTeaser getCpoTeaser() {
        return this.e;
    }

    public final int getCurrentPosition() {
        return this.f;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.k;
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
        return this.i;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.j;
    }

    public final long getStateId() {
        return this.g;
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
        return this.l;
    }

    public final void setCurrentPosition(int i2) {
        this.f = i2;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.k = serpDisplayType;
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
        parcel.writeParcelable(this.e, i2);
        parcel.writeInt(this.f);
        parcel.writeLong(this.g);
        parcel.writeString(this.h);
        parcel.writeParcelable(this.i, i2);
        parcel.writeInt(this.j);
        parcel.writeString(this.k.name());
        parcel.writeString(this.l.name());
        parcel.writeParcelable(this.m, i2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertDetailsGalleryItem(long r22, java.lang.String r24, java.util.List r25, com.avito.android.remote.model.Video r26, com.avito.android.remote.model.AutotekaCpoTeaser r27, int r28, long r29, java.lang.String r31, com.avito.android.remote.model.ForegroundImage r32, int r33, com.avito.android.remote.model.SerpDisplayType r34, com.avito.android.serp.adapter.SerpViewType r35, com.avito.android.remote.model.AutotekaTeaserResult r36, int r37, t6.r.a.j r38) {
        /*
            r21 = this;
            r0 = r37
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000c
            com.avito.android.advert_core.advert.AdvertDetailsItem r1 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_GALLERY
            long r3 = (long) r2
            r6 = r3
            goto L_0x000e
        L_0x000c:
            r6 = r22
        L_0x000e:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0018
            java.lang.String r1 = java.lang.String.valueOf(r6)
            r8 = r1
            goto L_0x001a
        L_0x0018:
            r8 = r24
        L_0x001a:
            r1 = r0 & 16
            r3 = 0
            if (r1 == 0) goto L_0x0021
            r11 = r3
            goto L_0x0023
        L_0x0021:
            r11 = r27
        L_0x0023:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0029
            r12 = 0
            goto L_0x002b
        L_0x0029:
            r12 = r28
        L_0x002b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0033
            r1 = 0
            r13 = r1
            goto L_0x0035
        L_0x0033:
            r13 = r29
        L_0x0035:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x003c
            r16 = r3
            goto L_0x003e
        L_0x003c:
            r16 = r32
        L_0x003e:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0047
            com.avito.android.remote.model.SerpDisplayType r1 = com.avito.android.remote.model.SerpDisplayType.Grid
            r18 = r1
            goto L_0x0049
        L_0x0047:
            r18 = r34
        L_0x0049:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0052
            com.avito.android.serp.adapter.SerpViewType r1 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r19 = r1
            goto L_0x0054
        L_0x0052:
            r19 = r35
        L_0x0054:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x005b
            r20 = r3
            goto L_0x005d
        L_0x005b:
            r20 = r36
        L_0x005d:
            r5 = r21
            r9 = r25
            r10 = r26
            r15 = r31
            r17 = r33
            r5.<init>(r6, r8, r9, r10, r11, r12, r13, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.photogallery.AdvertDetailsGalleryItem.<init>(long, java.lang.String, java.util.List, com.avito.android.remote.model.Video, com.avito.android.remote.model.AutotekaCpoTeaser, int, long, java.lang.String, com.avito.android.remote.model.ForegroundImage, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, com.avito.android.remote.model.AutotekaTeaserResult, int, t6.r.a.j):void");
    }
}
