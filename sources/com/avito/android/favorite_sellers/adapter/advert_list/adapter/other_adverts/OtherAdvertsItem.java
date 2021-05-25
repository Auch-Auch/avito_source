package com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.util.Parcels;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 -2\u00020\u0001:\u0001-B)\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010'\u001a\u00020\u0015\u0012\u0006\u0010*\u001a\u00020\u0015\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b+\u0010,J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u0004R\u001c\u0010\u0014\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u001a\u001a\u00020\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\"\u001a\u00020!8\u0016@\u0016XD¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$R\u0019\u0010'\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010\u0019R\u0019\u0010*\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010\u0019¨\u0006."}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/OtherAdvertsItem;", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "I", "getSpanCount", "spanCount", "Lcom/avito/android/serp/adapter/SerpViewType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "", "c", "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Lcom/avito/android/deep_linking/links/DeepLink;", "f", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "isExternalAd", "Z", "()Z", "d", "getTitle", "title", "e", "getSubtitle", MessengerShareContentUtility.SUBTITLE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "Companion", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class OtherAdvertsItem implements PersistableSerpItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<OtherAdvertsItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final SerpViewType a = SerpViewType.SINGLE;
    public final int b = 1;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @Nullable
    public final DeepLink f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/OtherAdvertsItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/OtherAdvertsItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, OtherAdvertsItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public OtherAdvertsItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new OtherAdvertsItem(a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), (DeepLink) parcel2.readParcelable(DeepLink.class.getClassLoader()));
        }
    }

    public OtherAdvertsItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable DeepLink deepLink) {
        a2.b.a.a.a.Z0(str, "stringId", str2, "title", str3, MessengerShareContentUtility.SUBTITLE);
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = deepLink;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.f;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean getHasStablePosition() {
        return PersistableSerpItem.DefaultImpls.getHasStablePosition(this);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return PersistableSerpItem.DefaultImpls.getId(this);
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

    @NotNull
    public final String getSubtitle() {
        return this.e;
    }

    @NotNull
    public final String getTitle() {
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
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(getStringId());
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeParcelable(this.f, i);
    }
}
