package com.avito.android.advert_core.aler_banner;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.BannerType;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010-\u001a\u00020\u0013\u0012\u0006\u0010*\u001a\u00020%\u0012\u0006\u00100\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010$\u001a\u00020\u001f¢\u0006\u0004\b1\u00102J\u0017\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ \u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001e\u001a\u00020\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010$\u001a\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010*\u001a\u00020%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010-\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0015\u001a\u0004\b,\u0010\u0017R\u001c\u00100\u001a\u00020\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010\u0015\u001a\u0004\b/\u0010\u0017¨\u00063"}, d2 = {"Lcom/avito/android/advert_core/aler_banner/AlertBannerItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "f", "I", "getSpanCount", "spanCount", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "e", "J", "getId", "()J", "id", "Lcom/avito/android/serp/adapter/SerpViewType;", g.a, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "Lcom/avito/android/remote/model/BannerType;", "c", "Lcom/avito/android/remote/model/BannerType;", "getType", "()Lcom/avito/android/remote/model/BannerType;", "type", AuthSource.BOOKING_ORDER, "getText", "text", "d", "getStringId", "stringId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/BannerType;Ljava/lang/String;JILcom/avito/android/serp/adapter/SerpViewType;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AlertBannerItem implements BlockItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<AlertBannerItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final BannerType c;
    @NotNull
    public final String d;
    public final long e;
    public final int f;
    @NotNull
    public final SerpViewType g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AlertBannerItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AlertBannerItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AlertBannerItem(parcel.readString(), parcel.readString(), (BannerType) Enum.valueOf(BannerType.class, parcel.readString()), parcel.readString(), parcel.readLong(), parcel.readInt(), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AlertBannerItem[] newArray(int i) {
            return new AlertBannerItem[i];
        }
    }

    public AlertBannerItem(@NotNull String str, @NotNull String str2, @NotNull BannerType bannerType, @NotNull String str3, long j, int i, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(bannerType, "type");
        Intrinsics.checkNotNullParameter(str3, "stringId");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = str;
        this.b = str2;
        this.c = bannerType;
        this.d = str3;
        this.e = j;
        this.f = i;
        this.g = serpViewType;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i) {
        return new AlertBannerItem(this.a, this.b, this.c, getStringId(), getId(), i, null, 64, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.d;
    }

    @NotNull
    public final String getText() {
        return this.b;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }

    @NotNull
    public final BannerType getType() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c.name());
        parcel.writeString(this.d);
        parcel.writeLong(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g.name());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AlertBannerItem(String str, String str2, BannerType bannerType, String str3, long j, int i, SerpViewType serpViewType, int i2, j jVar) {
        this(str, str2, bannerType, str3, j, i, (i2 & 64) != 0 ? SerpViewType.SINGLE : serpViewType);
    }
}
