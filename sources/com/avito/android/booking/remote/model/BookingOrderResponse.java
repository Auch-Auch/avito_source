package com.avito.android.booking.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/avito/android/booking/remote/model/BookingOrderResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/booking/remote/model/BookingOrderInfo;", "orderInfo", "Lcom/avito/android/booking/remote/model/BookingOrderInfo;", "getOrderInfo", "()Lcom/avito/android/booking/remote/model/BookingOrderInfo;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/booking/remote/model/BookingInput;", "input", "Lcom/avito/android/booking/remote/model/BookingInput;", "getInput", "()Lcom/avito/android/booking/remote/model/BookingInput;", "buttonTitle", "getButtonTitle", "<init>", "(Ljava/lang/String;Lcom/avito/android/booking/remote/model/BookingInput;Lcom/avito/android/booking/remote/model/BookingOrderInfo;Ljava/lang/String;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingOrderResponse implements Parcelable {
    public static final Parcelable.Creator<BookingOrderResponse> CREATOR = new Creator();
    @SerializedName("buttonTitle")
    @NotNull
    private final String buttonTitle;
    @SerializedName("input")
    @NotNull
    private final BookingInput input;
    @SerializedName("info")
    @NotNull
    private final BookingOrderInfo orderInfo;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BookingOrderResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BookingOrderResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BookingOrderResponse(parcel.readString(), BookingInput.CREATOR.createFromParcel(parcel), BookingOrderInfo.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BookingOrderResponse[] newArray(int i) {
            return new BookingOrderResponse[i];
        }
    }

    public BookingOrderResponse(@NotNull String str, @NotNull BookingInput bookingInput, @NotNull BookingOrderInfo bookingOrderInfo, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(bookingInput, "input");
        Intrinsics.checkNotNullParameter(bookingOrderInfo, "orderInfo");
        Intrinsics.checkNotNullParameter(str2, "buttonTitle");
        this.title = str;
        this.input = bookingInput;
        this.orderInfo = bookingOrderInfo;
        this.buttonTitle = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    @NotNull
    public final BookingInput getInput() {
        return this.input;
    }

    @NotNull
    public final BookingOrderInfo getOrderInfo() {
        return this.orderInfo;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        this.input.writeToParcel(parcel, 0);
        this.orderInfo.writeToParcel(parcel, 0);
        parcel.writeString(this.buttonTitle);
    }
}
