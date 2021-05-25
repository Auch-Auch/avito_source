package com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u0017¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001f\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b¨\u0006\""}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartnerArguments;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/net/Uri;", AuthSource.BOOKING_ORDER, "Landroid/net/Uri;", "getUrl", "()Landroid/net/Uri;", "url", "Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartner;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartner;", "getPartner", "()Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartner;", VKApiUserFull.RelativeType.PARTNER, "", "c", "Ljava/lang/String;", "getAdvertId", "()Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "d", "getBrokerSession", "brokerSession", "<init>", "(Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartner;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class CreditPartnerArguments implements Parcelable {
    public static final Parcelable.Creator<CreditPartnerArguments> CREATOR = new Creator();
    @NotNull
    public final CreditPartner a;
    @NotNull
    public final Uri b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CreditPartnerArguments> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CreditPartnerArguments createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CreditPartnerArguments((CreditPartner) Enum.valueOf(CreditPartner.class, parcel.readString()), (Uri) parcel.readParcelable(CreditPartnerArguments.class.getClassLoader()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CreditPartnerArguments[] newArray(int i) {
            return new CreditPartnerArguments[i];
        }
    }

    public CreditPartnerArguments(@NotNull CreditPartner creditPartner, @NotNull Uri uri, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(creditPartner, VKApiUserFull.RelativeType.PARTNER);
        Intrinsics.checkNotNullParameter(uri, "url");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "brokerSession");
        this.a = creditPartner;
        this.b = uri;
        this.c = str;
        this.d = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getAdvertId() {
        return this.c;
    }

    @NotNull
    public final String getBrokerSession() {
        return this.d;
    }

    @NotNull
    public final CreditPartner getPartner() {
        return this.a;
    }

    @NotNull
    public final Uri getUrl() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a.name());
        parcel.writeParcelable(this.b, i);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }
}
