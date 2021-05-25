package com.avito.android.advert.item.cre_geo_report;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.teaser.TeaserInsight;
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
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001;BW\u0012\b\b\u0002\u00105\u001a\u00020.\u0012\b\b\u0002\u0010&\u001a\u00020!\u0012\u0006\u0010)\u001a\u00020\u0017\u0012\u0006\u0010-\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u00108\u001a\u00020\u0017\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u0010¢\u0006\u0004\b9\u0010:J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015R\u001c\u0010&\u001a\u00020!8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010)\u001a\u00020\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010\u0019\u001a\u0004\b(\u0010\u001bR\u001c\u0010-\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\tR\"\u00105\u001a\u00020.8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0019\u00108\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u0019\u001a\u0004\b7\u0010\u001b¨\u0006<"}, d2 = {"Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/teaser/TeaserInsight;", g.a, "Ljava/util/List;", "getInsights", "()Ljava/util/List;", "insights", "", "e", "Ljava/lang/String;", "getAdvertId", "()Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/remote/model/Action;", "h", "getActions", "actions", "Lcom/avito/android/serp/adapter/SerpViewType;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "c", "getStringId", "stringId", "d", "I", "getSpanCount", "spanCount", "Lcom/avito/android/remote/model/SerpDisplayType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "f", "getTitle", "title", "<init>", "(Lcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "Companion", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsGeoReportTeaserItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<AdvertDetailsGeoReportTeaserItem> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TYPE_BUY = "/buy";
    @NotNull
    public static final String TYPE_EXAMPLE = "/example";
    @NotNull
    public SerpDisplayType a;
    @NotNull
    public final SerpViewType b;
    @NotNull
    public final String c;
    public final int d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;
    @NotNull
    public final List<TeaserInsight> g;
    @NotNull
    public final List<Action> h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/item/cre_geo_report/AdvertDetailsGeoReportTeaserItem$Companion;", "", "", "TYPE_BUY", "Ljava/lang/String;", "TYPE_EXAMPLE", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDetailsGeoReportTeaserItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsGeoReportTeaserItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            SerpDisplayType serpDisplayType = (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString());
            SerpViewType serpViewType = (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString());
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add((TeaserInsight) parcel.readParcelable(AdvertDetailsGeoReportTeaserItem.class.getClassLoader()));
                readInt2--;
            }
            int readInt3 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt3);
            while (readInt3 != 0) {
                arrayList2.add((Action) parcel.readParcelable(AdvertDetailsGeoReportTeaserItem.class.getClassLoader()));
                readInt3--;
            }
            return new AdvertDetailsGeoReportTeaserItem(serpDisplayType, serpViewType, readString, readInt, readString2, readString3, arrayList, arrayList2);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsGeoReportTeaserItem[] newArray(int i) {
            return new AdvertDetailsGeoReportTeaserItem[i];
        }
    }

    public AdvertDetailsGeoReportTeaserItem(@NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType, @NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull List<TeaserInsight> list, @NotNull List<Action> list2) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(list, "insights");
        Intrinsics.checkNotNullParameter(list2, "actions");
        this.a = serpDisplayType;
        this.b = serpViewType;
        this.c = str;
        this.d = i;
        this.e = str2;
        this.f = str3;
        this.g = list;
        this.h = list2;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i) {
        return new AdvertDetailsGeoReportTeaserItem(getDisplayType(), getViewType(), getStringId(), i, this.e, this.f, this.g, this.h);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<Action> getActions() {
        return this.h;
    }

    @NotNull
    public final String getAdvertId() {
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.a;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return BlockItem.DefaultImpls.getId(this);
    }

    @NotNull
    public final List<TeaserInsight> getInsights() {
        return this.g;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c;
    }

    @NotNull
    public final String getTitle() {
        return this.f;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.a = serpDisplayType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a.name());
        parcel.writeString(this.b.name());
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        Iterator n0 = a.n0(this.g, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((TeaserInsight) n0.next(), i);
        }
        Iterator n02 = a.n0(this.h, parcel);
        while (n02.hasNext()) {
            parcel.writeParcelable((Action) n02.next(), i);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertDetailsGeoReportTeaserItem(SerpDisplayType serpDisplayType, SerpViewType serpViewType, String str, int i, String str2, String str3, List list, List list2, int i2, j jVar) {
        this((i2 & 1) != 0 ? SerpDisplayType.Grid : serpDisplayType, (i2 & 2) != 0 ? SerpViewType.SINGLE : serpViewType, str, i, str2, str3, list, list2);
    }
}
