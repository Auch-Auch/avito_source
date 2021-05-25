package com.avito.android.advert.item.commercials;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SerpCommercialBanner;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/avito/android/advert/item/commercials/PositionedBannerContainer;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/serp/adapter/SerpCommercialBanner;", "component2", "()Lcom/avito/android/serp/adapter/SerpCommercialBanner;", VKApiConst.POSITION, "banner", "copy", "(Ljava/lang/String;Lcom/avito/android/serp/adapter/SerpCommercialBanner;)Lcom/avito/android/advert/item/commercials/PositionedBannerContainer;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/SerpCommercialBanner;", "getBanner", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPosition", "<init>", "(Ljava/lang/String;Lcom/avito/android/serp/adapter/SerpCommercialBanner;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class PositionedBannerContainer implements Parcelable {
    public static final Parcelable.Creator<PositionedBannerContainer> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final SerpCommercialBanner b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PositionedBannerContainer> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PositionedBannerContainer createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PositionedBannerContainer(parcel.readString(), (SerpCommercialBanner) parcel.readParcelable(PositionedBannerContainer.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PositionedBannerContainer[] newArray(int i) {
            return new PositionedBannerContainer[i];
        }
    }

    public PositionedBannerContainer(@NotNull String str, @NotNull SerpCommercialBanner serpCommercialBanner) {
        Intrinsics.checkNotNullParameter(str, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(serpCommercialBanner, "banner");
        this.a = str;
        this.b = serpCommercialBanner;
    }

    public static /* synthetic */ PositionedBannerContainer copy$default(PositionedBannerContainer positionedBannerContainer, String str, SerpCommercialBanner serpCommercialBanner, int i, Object obj) {
        if ((i & 1) != 0) {
            str = positionedBannerContainer.a;
        }
        if ((i & 2) != 0) {
            serpCommercialBanner = positionedBannerContainer.b;
        }
        return positionedBannerContainer.copy(str, serpCommercialBanner);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final SerpCommercialBanner component2() {
        return this.b;
    }

    @NotNull
    public final PositionedBannerContainer copy(@NotNull String str, @NotNull SerpCommercialBanner serpCommercialBanner) {
        Intrinsics.checkNotNullParameter(str, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(serpCommercialBanner, "banner");
        return new PositionedBannerContainer(str, serpCommercialBanner);
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
        if (!(obj instanceof PositionedBannerContainer)) {
            return false;
        }
        PositionedBannerContainer positionedBannerContainer = (PositionedBannerContainer) obj;
        return Intrinsics.areEqual(this.a, positionedBannerContainer.a) && Intrinsics.areEqual(this.b, positionedBannerContainer.b);
    }

    @NotNull
    public final SerpCommercialBanner getBanner() {
        return this.b;
    }

    @NotNull
    public final String getPosition() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        SerpCommercialBanner serpCommercialBanner = this.b;
        if (serpCommercialBanner != null) {
            i = serpCommercialBanner.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("PositionedBannerContainer(position=");
        L.append(this.a);
        L.append(", banner=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
    }
}
