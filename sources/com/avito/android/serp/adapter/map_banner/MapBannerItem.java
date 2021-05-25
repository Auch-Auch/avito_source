package com.avito.android.serp.adapter.map_banner;

import a2.b.a.a.a;
import a2.g.r.g;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.SerpViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b8\u00109J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\u00020!8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\"\u0010#\u0012\u0004\b%\u0010&\u001a\u0004\b\"\u0010$R\u001c\u0010)\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010\u0013\u001a\u0004\b(\u0010\u0015R\"\u00100\u001a\u00020*8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b+\u0010,\u0012\u0004\b/\u0010&\u001a\u0004\b-\u0010.R\"\u00104\u001a\u00020!8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b1\u0010#\u0012\u0004\b3\u0010&\u001a\u0004\b2\u0010$R\u001b\u00107\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u001d\u001a\u0004\b6\u0010\u001f¨\u0006:"}, d2 = {"Lcom/avito/android/serp/adapter/map_banner/MapBannerItem;", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "h", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "e", "Ljava/lang/String;", "getButtonText", "()Ljava/lang/String;", "buttonText", "c", "I", "getSpanCount", "spanCount", "Landroid/net/Uri;", g.a, "Landroid/net/Uri;", "getDarkMapScreenUri", "()Landroid/net/Uri;", "darkMapScreenUri", "", "isExternalAd", "Z", "()Z", "isExternalAd$annotations", "()V", "d", "getStringId", "stringId", "Lcom/avito/android/serp/adapter/SerpViewType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType$annotations", "viewType", AuthSource.BOOKING_ORDER, "getHasStablePosition", "getHasStablePosition$annotations", "hasStablePosition", "f", "getLightMapScreenUri", "lightMapScreenUri", "<init>", "(ILjava/lang/String;Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;Lcom/avito/android/deep_linking/links/DeepLink;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class MapBannerItem implements PersistableSerpItem {
    public static final Parcelable.Creator<MapBannerItem> CREATOR = new Creator();
    @NotNull
    public final SerpViewType a;
    public final boolean b;
    public final int c;
    @NotNull
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final Uri f;
    @Nullable
    public final Uri g;
    @Nullable
    public final DeepLink h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MapBannerItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MapBannerItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new MapBannerItem(parcel.readInt(), parcel.readString(), parcel.readString(), (Uri) parcel.readParcelable(MapBannerItem.class.getClassLoader()), (Uri) parcel.readParcelable(MapBannerItem.class.getClassLoader()), (DeepLink) parcel.readParcelable(MapBannerItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MapBannerItem[] newArray(int i) {
            return new MapBannerItem[i];
        }
    }

    public MapBannerItem(int i, @NotNull String str, @Nullable String str2, @Nullable Uri uri, @Nullable Uri uri2, @Nullable DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.c = i;
        this.d = str;
        this.e = str2;
        this.f = uri;
        this.g = uri2;
        this.h = deepLink;
        this.a = SerpViewType.SINGLE;
        this.b = true;
    }

    public static /* synthetic */ void getHasStablePosition$annotations() {
    }

    public static /* synthetic */ void getViewType$annotations() {
    }

    public static /* synthetic */ void isExternalAd$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getButtonText() {
        return this.e;
    }

    @Nullable
    public final Uri getDarkMapScreenUri() {
        return this.g;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.h;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean getHasStablePosition() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return PersistableSerpItem.DefaultImpls.getId(this);
    }

    @Nullable
    public final Uri getLightMapScreenUri() {
        return this.f;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean isExternalAd() {
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeParcelable(this.f, i);
        parcel.writeParcelable(this.g, i);
        parcel.writeParcelable(this.h, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MapBannerItem(int i, String str, String str2, Uri uri, Uri uri2, DeepLink deepLink, int i2, j jVar) {
        this(i, (i2 & 2) != 0 ? a.I2("UUID.randomUUID().toString()") : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? null : uri, (i2 & 16) != 0 ? null : uri2, (i2 & 32) != 0 ? null : deepLink);
    }
}
