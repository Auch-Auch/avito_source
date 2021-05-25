package com.avito.android.advert.item.commercials;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdSize;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.SerpCommercialBanner;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u000f\u0012\u0006\u0010#\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%B\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00020\u0003¢\u0006\u0004\b$\u0010'J!\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8V@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\u00020\u00148\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000bR\u0016\u0010\u001e\u001a\u00020\u001b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010#\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006)"}, d2 = {"Lcom/avito/android/advert/item/commercials/AdvertSerpCommercialBanner;", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "getId", "()J", "id", "", "getStringId", "()Ljava/lang/String;", "stringId", "", AuthSource.SEND_ABUSE, "Z", "isExternalAd", "()Z", "getSpanCount", "spanCount", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "getCommercialSerpItem", "()Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "commercialSerpItem", "<init>", "(Lcom/avito/android/serp/adapter/ViewTypeSerpItem;)V", "parcel", "(Landroid/os/Parcel;)V", "CREATOR", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertSerpCommercialBanner implements PersistableSerpItem, ViewTypeSerpItem {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    public final boolean a;
    @NotNull
    public final ViewTypeSerpItem b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert/item/commercials/AdvertSerpCommercialBanner$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/advert/item/commercials/AdvertSerpCommercialBanner;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/advert/item/commercials/AdvertSerpCommercialBanner;", "", "size", "", "newArray", "(I)[Lcom/avito/android/advert/item/commercials/AdvertSerpCommercialBanner;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<AdvertSerpCommercialBanner> {
        public CREATOR() {
        }

        public CREATOR(j jVar) {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AdvertSerpCommercialBanner createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AdvertSerpCommercialBanner(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AdvertSerpCommercialBanner[] newArray(int i) {
            return new AdvertSerpCommercialBanner[i];
        }
    }

    public AdvertSerpCommercialBanner(@NotNull ViewTypeSerpItem viewTypeSerpItem) {
        Intrinsics.checkNotNullParameter(viewTypeSerpItem, "commercialSerpItem");
        this.b = viewTypeSerpItem;
        this.a = true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final ViewTypeSerpItem getCommercialSerpItem() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean getHasStablePosition() {
        return PersistableSerpItem.DefaultImpls.getHasStablePosition(this);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.b.getId();
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.b.getSpanCount();
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b.getStringId();
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.b.getViewType();
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean isExternalAd() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@Nullable Parcel parcel, int i) {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdvertSerpCommercialBanner(@NotNull Parcel parcel) {
        this(new SerpCommercialBanner(0, "", SerpViewType.BIG, SerpDisplayType.Grid, 2, AdSize.BIG, null));
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
