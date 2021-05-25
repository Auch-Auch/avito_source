package com.avito.android.serp.adapter;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdSize;
import com.avito.android.remote.model.CommercialBanner;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BA\u0012\u0006\u0010.\u001a\u00020'\u0012\u0006\u0010E\u001a\u00020@\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010;\u001a\u000204\u0012\u0006\u00102\u001a\u00020\b\u0012\u0006\u0010&\u001a\u00020!\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bF\u0010GJ\u0017\u0010\u0006\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0018\u001a\u00020\u00178F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001b\u001a\u00020\u00178F@\u0006¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0019R\u001b\u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010&\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\"\u0010.\u001a\u00020'8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u00102\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\nR\u0013\u00103\u001a\u00020\u00178F@\u0006¢\u0006\u0006\u001a\u0004\b3\u0010\u0019R\"\u0010;\u001a\u0002048\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010?\u001a\u00020'2\u0006\u0010<\u001a\u00020'8V@VX\u000e¢\u0006\f\u001a\u0004\b=\u0010+\"\u0004\b>\u0010-R\u001c\u0010E\u001a\u00020@8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D¨\u0006H"}, d2 = {"Lcom/avito/android/serp/adapter/SerpCommercialBanner;", "Lcom/avito/android/remote/model/SerpElement;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "Lcom/avito/android/remote/model/CommercialBanner;", "banner", "copyWithCommercialBanner", "(Lcom/avito/android/remote/model/CommercialBanner;)Lcom/avito/android/serp/adapter/SerpCommercialBanner;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/serp/adapter/SerpViewType;", "c", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "", "isEmpty", "()Z", "getHasNotLoadedAd", "hasNotLoadedAd", g.a, "Lcom/avito/android/remote/model/CommercialBanner;", "getCommercialBanner", "()Lcom/avito/android/remote/model/CommercialBanner;", "commercialBanner", "Lcom/avito/android/remote/model/AdSize;", "f", "Lcom/avito/android/remote/model/AdSize;", "getAdSize", "()Lcom/avito/android/remote/model/AdSize;", "adSize", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "setId", "(J)V", "id", "e", "I", "getSpanCount", "spanCount", "isLoaded", "Lcom/avito/android/remote/model/SerpDisplayType;", "d", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "value", "getUniqueId", "setUniqueId", "uniqueId", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "<init>", "(JLjava/lang/String;Lcom/avito/android/serp/adapter/SerpViewType;Lcom/avito/android/remote/model/SerpDisplayType;ILcom/avito/android/remote/model/AdSize;Lcom/avito/android/remote/model/CommercialBanner;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpCommercialBanner implements SerpElement, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<SerpCommercialBanner> CREATOR = new Creator();
    public long a;
    @NotNull
    public final String b;
    @NotNull
    public final SerpViewType c;
    @NotNull
    public SerpDisplayType d;
    public final int e;
    @NotNull
    public final AdSize f;
    @Nullable
    public final CommercialBanner g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SerpCommercialBanner> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SerpCommercialBanner createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SerpCommercialBanner(parcel.readLong(), parcel.readString(), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), parcel.readInt(), (AdSize) Enum.valueOf(AdSize.class, parcel.readString()), (CommercialBanner) parcel.readParcelable(SerpCommercialBanner.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SerpCommercialBanner[] newArray(int i) {
            return new SerpCommercialBanner[i];
        }
    }

    public SerpCommercialBanner(long j, @NotNull String str, @NotNull SerpViewType serpViewType, @NotNull SerpDisplayType serpDisplayType, int i, @NotNull AdSize adSize, @Nullable CommercialBanner commercialBanner) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        this.a = j;
        this.b = str;
        this.c = serpViewType;
        this.d = serpDisplayType;
        this.e = i;
        this.f = adSize;
        this.g = commercialBanner;
    }

    @NotNull
    public final SerpCommercialBanner copyWithCommercialBanner(@Nullable CommercialBanner commercialBanner) {
        return new SerpCommercialBanner(getId(), getStringId(), getViewType(), getDisplayType(), getSpanCount(), this.f, commercialBanner);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final AdSize getAdSize() {
        return this.f;
    }

    @Nullable
    public final CommercialBanner getCommercialBanner() {
        return this.g;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.d;
    }

    public final boolean getHasNotLoadedAd() {
        CommercialBanner commercialBanner;
        return !isEmpty() && (commercialBanner = this.g) != null && !commercialBanner.isLoaded();
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public long getUniqueId() {
        return getId();
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.c;
    }

    public final boolean isEmpty() {
        return this.g == null;
    }

    public final boolean isLoaded() {
        CommercialBanner commercialBanner = this.g;
        return commercialBanner != null && commercialBanner.isLoaded();
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.d = serpDisplayType;
    }

    public void setId(long j) {
        this.a = j;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public void setUniqueId(long j) {
        setId(j);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c.name());
        parcel.writeString(this.d.name());
        parcel.writeInt(this.e);
        parcel.writeString(this.f.name());
        parcel.writeParcelable(this.g, i);
    }
}
