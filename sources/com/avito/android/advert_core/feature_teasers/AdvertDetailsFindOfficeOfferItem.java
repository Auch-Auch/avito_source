package com.avito.android.advert_core.feature_teasers;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.serp.adapter.promo_card.PromoCardItem;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aBK\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/AdvertDetailsFindOfficeOfferItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "spanCount", "", "stringId", "Lcom/avito/android/remote/model/UniversalColor;", "backgroundColor", "highlightedBackgroundColor", "title", "Lcom/avito/android/deep_linking/links/DeepLink;", "action", MessengerShareContentUtility.SUBTITLE, "actionText", "<init>", "(ILjava/lang/String;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsFindOfficeOfferItem extends PromoCardItem implements BlockItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AdvertDetailsFindOfficeOfferItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/AdvertDetailsFindOfficeOfferItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/advert_core/feature_teasers/AdvertDetailsFindOfficeOfferItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, AdvertDetailsFindOfficeOfferItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AdvertDetailsFindOfficeOfferItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new AdvertDetailsFindOfficeOfferItem(parcel2.readInt(), a2.b.a.a.a.u2(parcel2, "readString()!!"), (UniversalColor) a2.b.a.a.a.z1(UniversalColor.class, parcel2), (UniversalColor) a2.b.a.a.a.z1(UniversalColor.class, parcel2), a2.b.a.a.a.u2(parcel2, "readString()!!"), (DeepLink) a2.b.a.a.a.z1(DeepLink.class, parcel2), parcel2.readString(), parcel2.readString());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsFindOfficeOfferItem(int i, @NotNull String str, @NotNull UniversalColor universalColor, @NotNull UniversalColor universalColor2, @NotNull String str2, @NotNull DeepLink deepLink, @Nullable String str3, @Nullable String str4) {
        super(false, null, i, str, universalColor, universalColor2, str2, null, deepLink, str3, str4, null, false, 6275, null);
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(universalColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(universalColor2, "highlightedBackgroundColor");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(deepLink, "action");
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i) {
        return new AdvertDetailsFindOfficeOfferItem(i, getStringId(), getBackgroundColor(), getHighlightedBackgroundColor(), getTitle(), getAction(), getSubtitle(), getActionText());
    }

    @Override // com.avito.android.serp.adapter.promo_card.PromoCardItem, com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return BlockItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.android.serp.adapter.promo_card.PromoCardItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(getSpanCount());
        parcel.writeString(getStringId());
        parcel.writeParcelable(getBackgroundColor(), i);
        parcel.writeParcelable(getHighlightedBackgroundColor(), i);
        parcel.writeString(getTitle());
        parcel.writeParcelable(getAction(), i);
        parcel.writeString(getSubtitle());
        parcel.writeString(getActionText());
    }
}
