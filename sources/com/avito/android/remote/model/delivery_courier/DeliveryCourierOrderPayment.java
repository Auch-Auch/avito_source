package com.avito.android.remote.model.delivery_courier;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderPayment;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "paymentUrl", "Ljava/lang/String;", "getPaymentUrl", "()Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "getAdvertId", ChannelContext.Item.USER_ID, "getUserId", AnalyticFieldsName.orderId, "getOrderId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierOrderPayment implements Parcelable {
    public static final Parcelable.Creator<DeliveryCourierOrderPayment> CREATOR = new Creator();
    @SerializedName("itemId")
    @NotNull
    private final String advertId;
    @SerializedName(AnalyticFieldsName.orderId)
    @NotNull
    private final String orderId;
    @SerializedName("paymentUrl")
    @NotNull
    private final String paymentUrl;
    @SerializedName(ChannelContext.Item.USER_ID)
    @NotNull
    private final String userId;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeliveryCourierOrderPayment> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryCourierOrderPayment createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DeliveryCourierOrderPayment(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryCourierOrderPayment[] newArray(int i) {
            return new DeliveryCourierOrderPayment[i];
        }
    }

    public DeliveryCourierOrderPayment(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        a.b1(str, AnalyticFieldsName.orderId, str2, BookingInfoActivity.EXTRA_ITEM_ID, str3, ChannelContext.Item.USER_ID, str4, "paymentUrl");
        this.orderId = str;
        this.advertId = str2;
        this.userId = str3;
        this.paymentUrl = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getAdvertId() {
        return this.advertId;
    }

    @NotNull
    public final String getOrderId() {
        return this.orderId;
    }

    @NotNull
    public final String getPaymentUrl() {
        return this.paymentUrl;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.orderId);
        parcel.writeString(this.advertId);
        parcel.writeString(this.userId);
        parcel.writeString(this.paymentUrl);
    }
}
