package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/RequestPayUrlResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "paymentUrl", "Ljava/lang/String;", "getPaymentUrl", "()Ljava/lang/String;", AnalyticFieldsName.orderId, "getOrderId", "Lcom/avito/android/deep_linking/links/DeepLink;", "redirect", "Lcom/avito/android/deep_linking/links/DeepLink;", "getRedirect", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class RequestPayUrlResponse implements Parcelable {
    public static final Parcelable.Creator<RequestPayUrlResponse> CREATOR = new Creator();
    @SerializedName(AnalyticFieldsName.orderId)
    @Nullable
    private final String orderId;
    @SerializedName("paymentUrl")
    @Nullable
    private final String paymentUrl;
    @SerializedName("redirect")
    @Nullable
    private final DeepLink redirect;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<RequestPayUrlResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RequestPayUrlResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new RequestPayUrlResponse(parcel.readString(), parcel.readString(), (DeepLink) parcel.readParcelable(RequestPayUrlResponse.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RequestPayUrlResponse[] newArray(int i) {
            return new RequestPayUrlResponse[i];
        }
    }

    public RequestPayUrlResponse(@Nullable String str, @Nullable String str2, @Nullable DeepLink deepLink) {
        this.orderId = str;
        this.paymentUrl = str2;
        this.redirect = deepLink;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getOrderId() {
        return this.orderId;
    }

    @Nullable
    public final String getPaymentUrl() {
        return this.paymentUrl;
    }

    @Nullable
    public final DeepLink getRedirect() {
        return this.redirect;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.orderId);
        parcel.writeString(this.paymentUrl);
        parcel.writeParcelable(this.redirect, i);
    }
}
