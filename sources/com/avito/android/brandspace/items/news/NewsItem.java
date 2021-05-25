package com.avito.android.brandspace.items.news;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem;
import com.avito.android.brandspace.presenter.TrackableBrandspaceItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b \b\b\u0018\u00002\u00020\u00012\u00020\u0002BQ\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u001a\u001a\u00020\f\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0013¢\u0006\u0004\bJ\u0010KJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015Jf\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001a\u001a\u00020\f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u001e\u001a\u00020\u0013HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b!\u0010\u000eJ\u0010\u0010\"\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\"\u0010\u0015J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b(\u0010\u0015J \u0010-\u001a\u00020,2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b-\u0010.R\"\u0010\u001e\u001a\u00020\u00138\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u00103R\"\u0010\u001d\u001a\u00020\u00138\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b4\u00100\u001a\u0004\b5\u0010\u0015\"\u0004\b6\u00103R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010\u000eR\u0019\u0010\u001a\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b:\u00108\u001a\u0004\b;\u0010\u000eR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\u0012R\u001c\u0010\u0017\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010\u0005R\"\u0010\u0018\u001a\u00020\u00068\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010\b\"\u0004\bE\u0010FR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010\u000b¨\u0006L"}, d2 = {"Lcom/avito/android/brandspace/items/news/NewsItem;", "Lcom/avito/android/brandspace/presenter/TrackableBrandspaceItem;", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurableItem;", "", "component1", "()J", "Lcom/avito/android/brandspace/items/BlockType;", "component2", "()Lcom/avito/android/brandspace/items/BlockType;", "Lcom/avito/android/remote/model/Image;", "component3", "()Lcom/avito/android/remote/model/Image;", "", "component4", "()Ljava/lang/String;", "component5", "Lcom/avito/android/remote/model/Action;", "component6", "()Lcom/avito/android/remote/model/Action;", "", "component7", "()I", "component8", "id", "type", "image", "title", "description", "action", "precalculatedTextHeight", "precalculatedMetricsHash", "copy", "(JLcom/avito/android/brandspace/items/BlockType;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;II)Lcom/avito/android/brandspace/items/news/NewsItem;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "h", "I", "getPrecalculatedMetricsHash", "setPrecalculatedMetricsHash", "(I)V", g.a, "getPrecalculatedTextHeight", "setPrecalculatedTextHeight", "e", "Ljava/lang/String;", "getDescription", "d", "getTitle", "f", "Lcom/avito/android/remote/model/Action;", "getAction", AuthSource.SEND_ABUSE, "J", "getId", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/BlockType;", "getType", "setType", "(Lcom/avito/android/brandspace/items/BlockType;)V", "c", "Lcom/avito/android/remote/model/Image;", "getImage", "<init>", "(JLcom/avito/android/brandspace/items/BlockType;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;II)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class NewsItem implements TrackableBrandspaceItem, TextMeasurableItem {
    public static final Parcelable.Creator<NewsItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public BlockType b;
    @Nullable
    public final Image c;
    @NotNull
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final Action f;
    public int g;
    public int h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<NewsItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NewsItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new NewsItem(parcel.readLong(), (BlockType) Enum.valueOf(BlockType.class, parcel.readString()), (Image) parcel.readParcelable(NewsItem.class.getClassLoader()), parcel.readString(), parcel.readString(), (Action) parcel.readParcelable(NewsItem.class.getClassLoader()), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NewsItem[] newArray(int i) {
            return new NewsItem[i];
        }
    }

    public NewsItem(long j, @NotNull BlockType blockType, @Nullable Image image, @NotNull String str, @Nullable String str2, @Nullable Action action, int i, int i2) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(str, "title");
        this.a = j;
        this.b = blockType;
        this.c = image;
        this.d = str;
        this.e = str2;
        this.f = action;
        this.g = i;
        this.h = i2;
    }

    public static /* synthetic */ NewsItem copy$default(NewsItem newsItem, long j, BlockType blockType, Image image, String str, String str2, Action action, int i, int i2, int i3, Object obj) {
        return newsItem.copy((i3 & 1) != 0 ? newsItem.getId() : j, (i3 & 2) != 0 ? newsItem.getType() : blockType, (i3 & 4) != 0 ? newsItem.c : image, (i3 & 8) != 0 ? newsItem.d : str, (i3 & 16) != 0 ? newsItem.e : str2, (i3 & 32) != 0 ? newsItem.f : action, (i3 & 64) != 0 ? newsItem.getPrecalculatedTextHeight() : i, (i3 & 128) != 0 ? newsItem.getPrecalculatedMetricsHash() : i2);
    }

    public final long component1() {
        return getId();
    }

    @NotNull
    public final BlockType component2() {
        return getType();
    }

    @Nullable
    public final Image component3() {
        return this.c;
    }

    @NotNull
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

    public final int component7() {
        return getPrecalculatedTextHeight();
    }

    public final int component8() {
        return getPrecalculatedMetricsHash();
    }

    @NotNull
    public final NewsItem copy(long j, @NotNull BlockType blockType, @Nullable Image image, @NotNull String str, @Nullable String str2, @Nullable Action action, int i, int i2) {
        Intrinsics.checkNotNullParameter(blockType, "type");
        Intrinsics.checkNotNullParameter(str, "title");
        return new NewsItem(j, blockType, image, str, str2, action, i, i2);
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
        if (!(obj instanceof NewsItem)) {
            return false;
        }
        NewsItem newsItem = (NewsItem) obj;
        return getId() == newsItem.getId() && Intrinsics.areEqual(getType(), newsItem.getType()) && Intrinsics.areEqual(this.c, newsItem.c) && Intrinsics.areEqual(this.d, newsItem.d) && Intrinsics.areEqual(this.e, newsItem.e) && Intrinsics.areEqual(this.f, newsItem.f) && getPrecalculatedTextHeight() == newsItem.getPrecalculatedTextHeight() && getPrecalculatedMetricsHash() == newsItem.getPrecalculatedMetricsHash();
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

    @Nullable
    public final Image getImage() {
        return this.c;
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem
    public int getPrecalculatedMetricsHash() {
        return this.h;
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem
    public int getPrecalculatedTextHeight() {
        return this.g;
    }

    @NotNull
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
        return getPrecalculatedMetricsHash() + ((getPrecalculatedTextHeight() + ((hashCode4 + i) * 31)) * 31);
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem
    public void setPrecalculatedMetricsHash(int i) {
        this.h = i;
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem
    public void setPrecalculatedTextHeight(int i) {
        this.g = i;
    }

    public void setType(@NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(blockType, "<set-?>");
        this.b = blockType;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("NewsItem(id=");
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
        L.append(", precalculatedTextHeight=");
        L.append(getPrecalculatedTextHeight());
        L.append(", precalculatedMetricsHash=");
        L.append(getPrecalculatedMetricsHash());
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
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NewsItem(long j, BlockType blockType, Image image, String str, String str2, Action action, int i, int i2, int i3, j jVar) {
        this(j, blockType, image, str, str2, action, (i3 & 64) != 0 ? 0 : i, (i3 & 128) != 0 ? 0 : i2);
    }
}
