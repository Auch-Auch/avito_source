package com.avito.android.safedeal.delivery_type;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.marketplace.MarketplacePresenterKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.safedeal.delivery_courier.ScreenStyle;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJF\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0012\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0019J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b#\u0010$R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b\u0010\u0010\u0007R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010&\u001a\u0004\b.\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u000b¨\u00064"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/DeliveryTypeData;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "Lcom/avito/android/safedeal/delivery_courier/ScreenStyle;", "component4", "()Lcom/avito/android/safedeal/delivery_courier/ScreenStyle;", "Lcom/avito/android/remote/model/ParametrizedEvent;", "component5", "()Lcom/avito/android/remote/model/ParametrizedEvent;", "itemId", "isMarketplace", "searchContext", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, MarketplacePresenterKt.KEY_CONTACT_EVENT, "copy", "(Ljava/lang/String;ZLjava/lang/String;Lcom/avito/android/safedeal/delivery_courier/ScreenStyle;Lcom/avito/android/remote/model/ParametrizedEvent;)Lcom/avito/android/safedeal/delivery_type/DeliveryTypeData;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getItemId", "e", "Lcom/avito/android/remote/model/ParametrizedEvent;", "getContactEvent", AuthSource.BOOKING_ORDER, "Z", "c", "getSearchContext", "d", "Lcom/avito/android/safedeal/delivery_courier/ScreenStyle;", "getStyle", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Lcom/avito/android/safedeal/delivery_courier/ScreenStyle;Lcom/avito/android/remote/model/ParametrizedEvent;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryTypeData implements Parcelable {
    public static final Parcelable.Creator<DeliveryTypeData> CREATOR = new Creator();
    @NotNull
    public final String a;
    public final boolean b;
    @Nullable
    public final String c;
    @NotNull
    public final ScreenStyle d;
    @Nullable
    public final ParametrizedEvent e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeliveryTypeData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryTypeData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DeliveryTypeData(parcel.readString(), parcel.readInt() != 0, parcel.readString(), (ScreenStyle) Enum.valueOf(ScreenStyle.class, parcel.readString()), (ParametrizedEvent) parcel.readParcelable(DeliveryTypeData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryTypeData[] newArray(int i) {
            return new DeliveryTypeData[i];
        }
    }

    public DeliveryTypeData(@NotNull String str, boolean z, @Nullable String str2, @NotNull ScreenStyle screenStyle, @Nullable ParametrizedEvent parametrizedEvent) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(screenStyle, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        this.a = str;
        this.b = z;
        this.c = str2;
        this.d = screenStyle;
        this.e = parametrizedEvent;
    }

    public static /* synthetic */ DeliveryTypeData copy$default(DeliveryTypeData deliveryTypeData, String str, boolean z, String str2, ScreenStyle screenStyle, ParametrizedEvent parametrizedEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deliveryTypeData.a;
        }
        if ((i & 2) != 0) {
            z = deliveryTypeData.b;
        }
        if ((i & 4) != 0) {
            str2 = deliveryTypeData.c;
        }
        if ((i & 8) != 0) {
            screenStyle = deliveryTypeData.d;
        }
        if ((i & 16) != 0) {
            parametrizedEvent = deliveryTypeData.e;
        }
        return deliveryTypeData.copy(str, z, str2, screenStyle, parametrizedEvent);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final boolean component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final ScreenStyle component4() {
        return this.d;
    }

    @Nullable
    public final ParametrizedEvent component5() {
        return this.e;
    }

    @NotNull
    public final DeliveryTypeData copy(@NotNull String str, boolean z, @Nullable String str2, @NotNull ScreenStyle screenStyle, @Nullable ParametrizedEvent parametrizedEvent) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(screenStyle, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        return new DeliveryTypeData(str, z, str2, screenStyle, parametrizedEvent);
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
        if (!(obj instanceof DeliveryTypeData)) {
            return false;
        }
        DeliveryTypeData deliveryTypeData = (DeliveryTypeData) obj;
        return Intrinsics.areEqual(this.a, deliveryTypeData.a) && this.b == deliveryTypeData.b && Intrinsics.areEqual(this.c, deliveryTypeData.c) && Intrinsics.areEqual(this.d, deliveryTypeData.d) && Intrinsics.areEqual(this.e, deliveryTypeData.e);
    }

    @Nullable
    public final ParametrizedEvent getContactEvent() {
        return this.e;
    }

    @NotNull
    public final String getItemId() {
        return this.a;
    }

    @Nullable
    public final String getSearchContext() {
        return this.c;
    }

    @NotNull
    public final ScreenStyle getStyle() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.b;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode + i2) * 31;
        String str2 = this.c;
        int hashCode2 = (i5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ScreenStyle screenStyle = this.d;
        int hashCode3 = (hashCode2 + (screenStyle != null ? screenStyle.hashCode() : 0)) * 31;
        ParametrizedEvent parametrizedEvent = this.e;
        if (parametrizedEvent != null) {
            i = parametrizedEvent.hashCode();
        }
        return hashCode3 + i;
    }

    public final boolean isMarketplace() {
        return this.b;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DeliveryTypeData(itemId=");
        L.append(this.a);
        L.append(", isMarketplace=");
        L.append(this.b);
        L.append(", searchContext=");
        L.append(this.c);
        L.append(", style=");
        L.append(this.d);
        L.append(", contactEvent=");
        L.append(this.e);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeInt(this.b ? 1 : 0);
        parcel.writeString(this.c);
        parcel.writeString(this.d.name());
        parcel.writeParcelable(this.e, i);
    }
}
