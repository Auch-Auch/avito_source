package com.avito.android.safedeal.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b0\u00101J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJX\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b \u0010\u001bJ \u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b%\u0010&R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b(\u0010\u0007R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b\u0015\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b+\u0010\u0004R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010*\u001a\u0004\b,\u0010\u0004R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b-\u0010\u0007R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010.\u001a\u0004\b/\u0010\f¨\u00062"}, d2 = {"Lcom/avito/android/safedeal/remote/model/OrderType;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "component2", "()Lcom/avito/android/remote/model/text/AttributedText;", "component3", "component4", "Lcom/avito/android/deep_linking/links/DeepLink;", "component5", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "component6", "()Ljava/lang/Boolean;", "type", "title", MessengerShareContentUtility.SUBTITLE, "promoLabel", "deepLink", "isAvailable", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Boolean;)Lcom/avito/android/safedeal/remote/model/OrderType;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "getSubtitle", "Ljava/lang/Boolean;", "Ljava/lang/String;", "getPromoLabel", "getType", "getTitle", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Boolean;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class OrderType implements Parcelable {
    public static final Parcelable.Creator<OrderType> CREATOR = new Creator();
    @SerializedName("deepLink")
    @Nullable
    private final DeepLink deepLink;
    @SerializedName("isAvailable")
    @Nullable
    private final Boolean isAvailable;
    @SerializedName("promoLabel")
    @Nullable
    private final String promoLabel;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @Nullable
    private final AttributedText subtitle;
    @SerializedName("title")
    @Nullable
    private final AttributedText title;
    @SerializedName("type")
    @Nullable
    private final String type;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<OrderType> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderType createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            AttributedText attributedText = (AttributedText) parcel.readParcelable(OrderType.class.getClassLoader());
            AttributedText attributedText2 = (AttributedText) parcel.readParcelable(OrderType.class.getClassLoader());
            String readString2 = parcel.readString();
            DeepLink deepLink = (DeepLink) parcel.readParcelable(OrderType.class.getClassLoader());
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            return new OrderType(readString, attributedText, attributedText2, readString2, deepLink, bool);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderType[] newArray(int i) {
            return new OrderType[i];
        }
    }

    public OrderType(@Nullable String str, @Nullable AttributedText attributedText, @Nullable AttributedText attributedText2, @Nullable String str2, @Nullable DeepLink deepLink2, @Nullable Boolean bool) {
        this.type = str;
        this.title = attributedText;
        this.subtitle = attributedText2;
        this.promoLabel = str2;
        this.deepLink = deepLink2;
        this.isAvailable = bool;
    }

    public static /* synthetic */ OrderType copy$default(OrderType orderType, String str, AttributedText attributedText, AttributedText attributedText2, String str2, DeepLink deepLink2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderType.type;
        }
        if ((i & 2) != 0) {
            attributedText = orderType.title;
        }
        if ((i & 4) != 0) {
            attributedText2 = orderType.subtitle;
        }
        if ((i & 8) != 0) {
            str2 = orderType.promoLabel;
        }
        if ((i & 16) != 0) {
            deepLink2 = orderType.deepLink;
        }
        if ((i & 32) != 0) {
            bool = orderType.isAvailable;
        }
        return orderType.copy(str, attributedText, attributedText2, str2, deepLink2, bool);
    }

    @Nullable
    public final String component1() {
        return this.type;
    }

    @Nullable
    public final AttributedText component2() {
        return this.title;
    }

    @Nullable
    public final AttributedText component3() {
        return this.subtitle;
    }

    @Nullable
    public final String component4() {
        return this.promoLabel;
    }

    @Nullable
    public final DeepLink component5() {
        return this.deepLink;
    }

    @Nullable
    public final Boolean component6() {
        return this.isAvailable;
    }

    @NotNull
    public final OrderType copy(@Nullable String str, @Nullable AttributedText attributedText, @Nullable AttributedText attributedText2, @Nullable String str2, @Nullable DeepLink deepLink2, @Nullable Boolean bool) {
        return new OrderType(str, attributedText, attributedText2, str2, deepLink2, bool);
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
        if (!(obj instanceof OrderType)) {
            return false;
        }
        OrderType orderType = (OrderType) obj;
        return Intrinsics.areEqual(this.type, orderType.type) && Intrinsics.areEqual(this.title, orderType.title) && Intrinsics.areEqual(this.subtitle, orderType.subtitle) && Intrinsics.areEqual(this.promoLabel, orderType.promoLabel) && Intrinsics.areEqual(this.deepLink, orderType.deepLink) && Intrinsics.areEqual(this.isAvailable, orderType.isAvailable);
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final String getPromoLabel() {
        return this.promoLabel;
    }

    @Nullable
    public final AttributedText getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final AttributedText getTitle() {
        return this.title;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        AttributedText attributedText = this.title;
        int hashCode2 = (hashCode + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
        AttributedText attributedText2 = this.subtitle;
        int hashCode3 = (hashCode2 + (attributedText2 != null ? attributedText2.hashCode() : 0)) * 31;
        String str2 = this.promoLabel;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        DeepLink deepLink2 = this.deepLink;
        int hashCode5 = (hashCode4 + (deepLink2 != null ? deepLink2.hashCode() : 0)) * 31;
        Boolean bool = this.isAvailable;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode5 + i;
    }

    @Nullable
    public final Boolean isAvailable() {
        return this.isAvailable;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("OrderType(type=");
        L.append(this.type);
        L.append(", title=");
        L.append(this.title);
        L.append(", subtitle=");
        L.append(this.subtitle);
        L.append(", promoLabel=");
        L.append(this.promoLabel);
        L.append(", deepLink=");
        L.append(this.deepLink);
        L.append(", isAvailable=");
        return a.o(L, this.isAvailable, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.type);
        parcel.writeParcelable(this.title, i);
        parcel.writeParcelable(this.subtitle, i);
        parcel.writeString(this.promoLabel);
        parcel.writeParcelable(this.deepLink, i);
        Boolean bool = this.isAvailable;
        if (bool != null) {
            parcel.writeInt(1);
            z = bool.booleanValue();
        } else {
            z = false;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        parcel.writeInt(i2);
    }
}
