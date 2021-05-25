package com.avito.android.advert_core.feature_teasers.common;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogInfo;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b(\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001cB\u0001\u0012\u0006\u0010#\u001a\u00020\b\u0012\u0006\u0010$\u001a\u00020\u0004\u0012\u0006\u0010%\u001a\u00020\r\u0012\b\b\u0002\u0010&\u001a\u00020\u0010\u0012\b\b\u0002\u0010'\u001a\u00020\u0013\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\r\u0012\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00160\u001d\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\r¢\u0006\u0004\ba\u0010bJ\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u000fJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u001dHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b \u0010\u000fJ\u0012\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b!\u0010\u000fJ\u0012\u0010\"\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\"\u0010\u000fJ\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010&\u001a\u00020\u00102\b\b\u0002\u0010'\u001a\u00020\u00132\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\r2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00160\u001d2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b1\u0010\u000fJ\u0010\u00102\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b2\u0010\fJ\u001a\u00106\u001a\u0002052\b\u00104\u001a\u0004\u0018\u000103HÖ\u0003¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b8\u0010\fJ \u0010=\u001a\u00020<2\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b=\u0010>R\"\u0010&\u001a\u00020\u00108\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010\u0012\"\u0004\bB\u0010CR\u001c\u0010$\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\fR\u001b\u0010-\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010\u000fR\u001f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00160\u001d8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010\u001fR\u001b\u0010(\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010\u0018R\u001b\u0010.\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010H\u001a\u0004\bQ\u0010\u000fR\u001c\u0010#\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010\nR\u001c\u0010'\u001a\u00020\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010\u0015R\u001c\u0010%\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bX\u0010H\u001a\u0004\bY\u0010\u000fR\u001b\u0010)\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010\u001bR\u001b\u0010*\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010H\u001a\u0004\b^\u0010\u000fR\u001b\u0010,\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b_\u0010H\u001a\u0004\b`\u0010\u000f¨\u0006d"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "", "component1", "()J", "component2", "()I", "", "component3", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/SerpDisplayType;", "component4", "()Lcom/avito/android/remote/model/SerpDisplayType;", "Lcom/avito/android/serp/adapter/SerpViewType;", "component5", "()Lcom/avito/android/serp/adapter/SerpViewType;", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserOption;", "component6", "()Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserOption;", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo;", "component7", "()Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo;", "component8", "", "component9", "()Ljava/util/List;", "component10", "component11", "component12", "id", "spanCount", "stringId", "displayType", "viewType", "title", "dialogInfo", MessengerShareContentUtility.SUBTITLE, "features", "additionalInfoLink", "featureSlug", "buttonText", "copy", "(JILjava/lang/String;Lcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserOption;Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", AuthSource.BOOKING_ORDER, "I", "getSpanCount", "k", "Ljava/lang/String;", "getFeatureSlug", "i", "Ljava/util/List;", "getFeatures", "f", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserOption;", "getTitle", "l", "getButtonText", AuthSource.SEND_ABUSE, "J", "getId", "e", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "c", "getStringId", g.a, "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo;", "getDialogInfo", "h", "getSubtitle", "j", "getAdditionalInfoLink", "<init>", "(JILjava/lang/String;Lcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserOption;Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Icon", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsFeatureTeaserItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<AdvertDetailsFeatureTeaserItem> CREATOR = new Creator();
    public final long a;
    public final int b;
    @NotNull
    public final String c;
    @NotNull
    public SerpDisplayType d;
    @NotNull
    public final SerpViewType e;
    @Nullable
    public final AdvertDetailsFeatureTeaserOption f;
    @Nullable
    public final AdvertDetailsFeatureTeaserDialogInfo g;
    @Nullable
    public final String h;
    @NotNull
    public final List<AdvertDetailsFeatureTeaserOption> i;
    @Nullable
    public final String j;
    @Nullable
    public final String k;
    @Nullable
    public final String l;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDetailsFeatureTeaserItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsFeatureTeaserItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            SerpDisplayType serpDisplayType = (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString());
            SerpViewType serpViewType = (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString());
            AdvertDetailsFeatureTeaserOption createFromParcel = parcel.readInt() != 0 ? AdvertDetailsFeatureTeaserOption.CREATOR.createFromParcel(parcel) : null;
            AdvertDetailsFeatureTeaserDialogInfo advertDetailsFeatureTeaserDialogInfo = (AdvertDetailsFeatureTeaserDialogInfo) parcel.readParcelable(AdvertDetailsFeatureTeaserItem.class.getClassLoader());
            String readString2 = parcel.readString();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add(AdvertDetailsFeatureTeaserOption.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new AdvertDetailsFeatureTeaserItem(readLong, readInt, readString, serpDisplayType, serpViewType, createFromParcel, advertDetailsFeatureTeaserDialogInfo, readString2, arrayList, parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsFeatureTeaserItem[] newArray(int i) {
            return new AdvertDetailsFeatureTeaserItem[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem$Icon;", "", "<init>", "(Ljava/lang/String;I)V", "Protected", "Ok", "Locked", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public enum Icon {
        Protected,
        Ok,
        Locked
    }

    public AdvertDetailsFeatureTeaserItem(long j2, int i2, @NotNull String str, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType, @Nullable AdvertDetailsFeatureTeaserOption advertDetailsFeatureTeaserOption, @Nullable AdvertDetailsFeatureTeaserDialogInfo advertDetailsFeatureTeaserDialogInfo, @Nullable String str2, @NotNull List<AdvertDetailsFeatureTeaserOption> list, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        Intrinsics.checkNotNullParameter(list, "features");
        this.a = j2;
        this.b = i2;
        this.c = str;
        this.d = serpDisplayType;
        this.e = serpViewType;
        this.f = advertDetailsFeatureTeaserOption;
        this.g = advertDetailsFeatureTeaserDialogInfo;
        this.h = str2;
        this.i = list;
        this.j = str3;
        this.k = str4;
        this.l = str5;
    }

    public static /* synthetic */ AdvertDetailsFeatureTeaserItem copy$default(AdvertDetailsFeatureTeaserItem advertDetailsFeatureTeaserItem, long j2, int i2, String str, SerpDisplayType serpDisplayType, SerpViewType serpViewType, AdvertDetailsFeatureTeaserOption advertDetailsFeatureTeaserOption, AdvertDetailsFeatureTeaserDialogInfo advertDetailsFeatureTeaserDialogInfo, String str2, List list, String str3, String str4, String str5, int i3, Object obj) {
        return advertDetailsFeatureTeaserItem.copy((i3 & 1) != 0 ? advertDetailsFeatureTeaserItem.getId() : j2, (i3 & 2) != 0 ? advertDetailsFeatureTeaserItem.getSpanCount() : i2, (i3 & 4) != 0 ? advertDetailsFeatureTeaserItem.getStringId() : str, (i3 & 8) != 0 ? advertDetailsFeatureTeaserItem.getDisplayType() : serpDisplayType, (i3 & 16) != 0 ? advertDetailsFeatureTeaserItem.getViewType() : serpViewType, (i3 & 32) != 0 ? advertDetailsFeatureTeaserItem.f : advertDetailsFeatureTeaserOption, (i3 & 64) != 0 ? advertDetailsFeatureTeaserItem.g : advertDetailsFeatureTeaserDialogInfo, (i3 & 128) != 0 ? advertDetailsFeatureTeaserItem.h : str2, (i3 & 256) != 0 ? advertDetailsFeatureTeaserItem.i : list, (i3 & 512) != 0 ? advertDetailsFeatureTeaserItem.j : str3, (i3 & 1024) != 0 ? advertDetailsFeatureTeaserItem.k : str4, (i3 & 2048) != 0 ? advertDetailsFeatureTeaserItem.l : str5);
    }

    public final long component1() {
        return getId();
    }

    @Nullable
    public final String component10() {
        return this.j;
    }

    @Nullable
    public final String component11() {
        return this.k;
    }

    @Nullable
    public final String component12() {
        return this.l;
    }

    public final int component2() {
        return getSpanCount();
    }

    @NotNull
    public final String component3() {
        return getStringId();
    }

    @NotNull
    public final SerpDisplayType component4() {
        return getDisplayType();
    }

    @NotNull
    public final SerpViewType component5() {
        return getViewType();
    }

    @Nullable
    public final AdvertDetailsFeatureTeaserOption component6() {
        return this.f;
    }

    @Nullable
    public final AdvertDetailsFeatureTeaserDialogInfo component7() {
        return this.g;
    }

    @Nullable
    public final String component8() {
        return this.h;
    }

    @NotNull
    public final List<AdvertDetailsFeatureTeaserOption> component9() {
        return this.i;
    }

    @NotNull
    public final AdvertDetailsFeatureTeaserItem copy(long j2, int i2, @NotNull String str, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType, @Nullable AdvertDetailsFeatureTeaserOption advertDetailsFeatureTeaserOption, @Nullable AdvertDetailsFeatureTeaserDialogInfo advertDetailsFeatureTeaserDialogInfo, @Nullable String str2, @NotNull List<AdvertDetailsFeatureTeaserOption> list, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        Intrinsics.checkNotNullParameter(list, "features");
        return new AdvertDetailsFeatureTeaserItem(j2, i2, str, serpDisplayType, serpViewType, advertDetailsFeatureTeaserOption, advertDetailsFeatureTeaserDialogInfo, str2, list, str3, str4, str5);
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i2) {
        return copy$default(this, 0, i2, null, null, null, null, null, null, null, null, null, null, 4093, null);
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
        if (!(obj instanceof AdvertDetailsFeatureTeaserItem)) {
            return false;
        }
        AdvertDetailsFeatureTeaserItem advertDetailsFeatureTeaserItem = (AdvertDetailsFeatureTeaserItem) obj;
        return getId() == advertDetailsFeatureTeaserItem.getId() && getSpanCount() == advertDetailsFeatureTeaserItem.getSpanCount() && Intrinsics.areEqual(getStringId(), advertDetailsFeatureTeaserItem.getStringId()) && Intrinsics.areEqual(getDisplayType(), advertDetailsFeatureTeaserItem.getDisplayType()) && Intrinsics.areEqual(getViewType(), advertDetailsFeatureTeaserItem.getViewType()) && Intrinsics.areEqual(this.f, advertDetailsFeatureTeaserItem.f) && Intrinsics.areEqual(this.g, advertDetailsFeatureTeaserItem.g) && Intrinsics.areEqual(this.h, advertDetailsFeatureTeaserItem.h) && Intrinsics.areEqual(this.i, advertDetailsFeatureTeaserItem.i) && Intrinsics.areEqual(this.j, advertDetailsFeatureTeaserItem.j) && Intrinsics.areEqual(this.k, advertDetailsFeatureTeaserItem.k) && Intrinsics.areEqual(this.l, advertDetailsFeatureTeaserItem.l);
    }

    @Nullable
    public final String getAdditionalInfoLink() {
        return this.j;
    }

    @Nullable
    public final String getButtonText() {
        return this.l;
    }

    @Nullable
    public final AdvertDetailsFeatureTeaserDialogInfo getDialogInfo() {
        return this.g;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.d;
    }

    @Nullable
    public final String getFeatureSlug() {
        return this.k;
    }

    @NotNull
    public final List<AdvertDetailsFeatureTeaserOption> getFeatures() {
        return this.i;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c;
    }

    @Nullable
    public final String getSubtitle() {
        return this.h;
    }

    @Nullable
    public final AdvertDetailsFeatureTeaserOption getTitle() {
        return this.f;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.e;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int spanCount = (getSpanCount() + (c.a(getId()) * 31)) * 31;
        String stringId = getStringId();
        int i2 = 0;
        int hashCode = (spanCount + (stringId != null ? stringId.hashCode() : 0)) * 31;
        SerpDisplayType displayType = getDisplayType();
        int hashCode2 = (hashCode + (displayType != null ? displayType.hashCode() : 0)) * 31;
        SerpViewType viewType = getViewType();
        int hashCode3 = (hashCode2 + (viewType != null ? viewType.hashCode() : 0)) * 31;
        AdvertDetailsFeatureTeaserOption advertDetailsFeatureTeaserOption = this.f;
        int hashCode4 = (hashCode3 + (advertDetailsFeatureTeaserOption != null ? advertDetailsFeatureTeaserOption.hashCode() : 0)) * 31;
        AdvertDetailsFeatureTeaserDialogInfo advertDetailsFeatureTeaserDialogInfo = this.g;
        int hashCode5 = (hashCode4 + (advertDetailsFeatureTeaserDialogInfo != null ? advertDetailsFeatureTeaserDialogInfo.hashCode() : 0)) * 31;
        String str = this.h;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 31;
        List<AdvertDetailsFeatureTeaserOption> list = this.i;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.j;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.k;
        int hashCode9 = (hashCode8 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.l;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode9 + i2;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.d = serpDisplayType;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AdvertDetailsFeatureTeaserItem(id=");
        L.append(getId());
        L.append(", spanCount=");
        L.append(getSpanCount());
        L.append(", stringId=");
        L.append(getStringId());
        L.append(", displayType=");
        L.append(getDisplayType());
        L.append(", viewType=");
        L.append(getViewType());
        L.append(", title=");
        L.append(this.f);
        L.append(", dialogInfo=");
        L.append(this.g);
        L.append(", subtitle=");
        L.append(this.h);
        L.append(", features=");
        L.append(this.i);
        L.append(", additionalInfoLink=");
        L.append(this.j);
        L.append(", featureSlug=");
        L.append(this.k);
        L.append(", buttonText=");
        return a.t(L, this.l, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d.name());
        parcel.writeString(this.e.name());
        AdvertDetailsFeatureTeaserOption advertDetailsFeatureTeaserOption = this.f;
        if (advertDetailsFeatureTeaserOption != null) {
            parcel.writeInt(1);
            advertDetailsFeatureTeaserOption.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.g, i2);
        parcel.writeString(this.h);
        Iterator n0 = a.n0(this.i, parcel);
        while (n0.hasNext()) {
            ((AdvertDetailsFeatureTeaserOption) n0.next()).writeToParcel(parcel, 0);
        }
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertDetailsFeatureTeaserItem(long j2, int i2, String str, SerpDisplayType serpDisplayType, SerpViewType serpViewType, AdvertDetailsFeatureTeaserOption advertDetailsFeatureTeaserOption, AdvertDetailsFeatureTeaserDialogInfo advertDetailsFeatureTeaserDialogInfo, String str2, List list, String str3, String str4, String str5, int i3, j jVar) {
        this(j2, i2, str, (i3 & 8) != 0 ? SerpDisplayType.Grid : serpDisplayType, (i3 & 16) != 0 ? SerpViewType.SINGLE : serpViewType, advertDetailsFeatureTeaserOption, (i3 & 64) != 0 ? null : advertDetailsFeatureTeaserDialogInfo, (i3 & 128) != 0 ? null : str2, (i3 & 256) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 512) != 0 ? null : str3, (i3 & 1024) != 0 ? null : str4, (i3 & 2048) != 0 ? null : str5);
    }
}
