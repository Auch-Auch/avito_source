package com.avito.android.advert;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert.item.commercials.PositionedBannerContainer;
import com.avito.android.html_formatter.HtmlCharSequence;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.DeliveryInfoResponse;
import com.avito.android.remote.model.section.SectionResponse;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002\u0017\u0018J3\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H&¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u0011\u0010\u0012J3\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0016\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/avito/android/advert/AdvertDetailsInteractor;", "", "", "context", "requestId", "marketplaceLocationId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsWithMeta;", "getAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/section/SectionResponse;", "getComplementaryItems", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "", "Lcom/avito/android/advert/item/commercials/PositionedBannerContainer;", "getCommercials", "(Lcom/avito/android/remote/model/AdvertDetails;)Lio/reactivex/rxjava3/core/Observable;", "locationIdFrom", "locationIdTo", "Lcom/avito/android/remote/model/DeliveryInfoResponse;", "getDeliveryInfo", "AdvertDetailsMeta", "AdvertDetailsWithMeta", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsInteractor {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsMeta;", "Landroid/os/Parcelable;", "Lcom/avito/android/html_formatter/HtmlCharSequence;", "component1", "()Lcom/avito/android/html_formatter/HtmlCharSequence;", "formattedDescription", "copy", "(Lcom/avito/android/html_formatter/HtmlCharSequence;)Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsMeta;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/html_formatter/HtmlCharSequence;", "getFormattedDescription", "<init>", "(Lcom/avito/android/html_formatter/HtmlCharSequence;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class AdvertDetailsMeta implements Parcelable {
        public static final Parcelable.Creator<AdvertDetailsMeta> CREATOR = new Creator();
        @Nullable
        public final HtmlCharSequence a;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<AdvertDetailsMeta> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AdvertDetailsMeta createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new AdvertDetailsMeta((HtmlCharSequence) parcel.readParcelable(AdvertDetailsMeta.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AdvertDetailsMeta[] newArray(int i) {
                return new AdvertDetailsMeta[i];
            }
        }

        public AdvertDetailsMeta(@Nullable HtmlCharSequence htmlCharSequence) {
            this.a = htmlCharSequence;
        }

        public static /* synthetic */ AdvertDetailsMeta copy$default(AdvertDetailsMeta advertDetailsMeta, HtmlCharSequence htmlCharSequence, int i, Object obj) {
            if ((i & 1) != 0) {
                htmlCharSequence = advertDetailsMeta.a;
            }
            return advertDetailsMeta.copy(htmlCharSequence);
        }

        @Nullable
        public final HtmlCharSequence component1() {
            return this.a;
        }

        @NotNull
        public final AdvertDetailsMeta copy(@Nullable HtmlCharSequence htmlCharSequence) {
            return new AdvertDetailsMeta(htmlCharSequence);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof AdvertDetailsMeta) && Intrinsics.areEqual(this.a, ((AdvertDetailsMeta) obj).a);
            }
            return true;
        }

        @Nullable
        public final HtmlCharSequence getFormattedDescription() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            HtmlCharSequence htmlCharSequence = this.a;
            if (htmlCharSequence != null) {
                return htmlCharSequence.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("AdvertDetailsMeta(formattedDescription=");
            L.append((Object) this.a);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.a, i);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsWithMeta;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/AdvertDetails;", "component1", "()Lcom/avito/android/remote/model/AdvertDetails;", "Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsMeta;", "component2", "()Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsMeta;", "advert", "meta", "copy", "(Lcom/avito/android/remote/model/AdvertDetails;Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsMeta;)Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsWithMeta;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsMeta;", "getMeta", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/AdvertDetails;", "getAdvert", "<init>", "(Lcom/avito/android/remote/model/AdvertDetails;Lcom/avito/android/advert/AdvertDetailsInteractor$AdvertDetailsMeta;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class AdvertDetailsWithMeta implements Parcelable {
        public static final Parcelable.Creator<AdvertDetailsWithMeta> CREATOR = new Creator();
        @NotNull
        public final AdvertDetails a;
        @Nullable
        public final AdvertDetailsMeta b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<AdvertDetailsWithMeta> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AdvertDetailsWithMeta createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new AdvertDetailsWithMeta((AdvertDetails) parcel.readParcelable(AdvertDetailsWithMeta.class.getClassLoader()), parcel.readInt() != 0 ? AdvertDetailsMeta.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AdvertDetailsWithMeta[] newArray(int i) {
                return new AdvertDetailsWithMeta[i];
            }
        }

        public AdvertDetailsWithMeta(@NotNull AdvertDetails advertDetails, @Nullable AdvertDetailsMeta advertDetailsMeta) {
            Intrinsics.checkNotNullParameter(advertDetails, "advert");
            this.a = advertDetails;
            this.b = advertDetailsMeta;
        }

        public static /* synthetic */ AdvertDetailsWithMeta copy$default(AdvertDetailsWithMeta advertDetailsWithMeta, AdvertDetails advertDetails, AdvertDetailsMeta advertDetailsMeta, int i, Object obj) {
            if ((i & 1) != 0) {
                advertDetails = advertDetailsWithMeta.a;
            }
            if ((i & 2) != 0) {
                advertDetailsMeta = advertDetailsWithMeta.b;
            }
            return advertDetailsWithMeta.copy(advertDetails, advertDetailsMeta);
        }

        @NotNull
        public final AdvertDetails component1() {
            return this.a;
        }

        @Nullable
        public final AdvertDetailsMeta component2() {
            return this.b;
        }

        @NotNull
        public final AdvertDetailsWithMeta copy(@NotNull AdvertDetails advertDetails, @Nullable AdvertDetailsMeta advertDetailsMeta) {
            Intrinsics.checkNotNullParameter(advertDetails, "advert");
            return new AdvertDetailsWithMeta(advertDetails, advertDetailsMeta);
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
            if (!(obj instanceof AdvertDetailsWithMeta)) {
                return false;
            }
            AdvertDetailsWithMeta advertDetailsWithMeta = (AdvertDetailsWithMeta) obj;
            return Intrinsics.areEqual(this.a, advertDetailsWithMeta.a) && Intrinsics.areEqual(this.b, advertDetailsWithMeta.b);
        }

        @NotNull
        public final AdvertDetails getAdvert() {
            return this.a;
        }

        @Nullable
        public final AdvertDetailsMeta getMeta() {
            return this.b;
        }

        @Override // java.lang.Object
        public int hashCode() {
            AdvertDetails advertDetails = this.a;
            int i = 0;
            int hashCode = (advertDetails != null ? advertDetails.hashCode() : 0) * 31;
            AdvertDetailsMeta advertDetailsMeta = this.b;
            if (advertDetailsMeta != null) {
                i = advertDetailsMeta.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("AdvertDetailsWithMeta(advert=");
            L.append(this.a);
            L.append(", meta=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.a, i);
            AdvertDetailsMeta advertDetailsMeta = this.b;
            if (advertDetailsMeta != null) {
                parcel.writeInt(1);
                advertDetailsMeta.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }
    }

    @NotNull
    Observable<AdvertDetailsWithMeta> getAdvertDetails(@Nullable String str, @Nullable String str2, @Nullable String str3);

    @NotNull
    Observable<List<PositionedBannerContainer>> getCommercials(@Nullable AdvertDetails advertDetails);

    @NotNull
    Observable<SectionResponse> getComplementaryItems();

    @NotNull
    Observable<DeliveryInfoResponse> getDeliveryInfo(@Nullable String str, @Nullable String str2, @Nullable String str3);
}
