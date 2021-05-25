package com.avito.android.booking.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/booking/remote/model/BookingOrderCreationResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingOrderCreationResponse implements Parcelable {
    public static final Parcelable.Creator<BookingOrderCreationResponse> CREATOR = new Creator();
    @SerializedName("deepLink")
    @NotNull
    private final DeepLink deepLink;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BookingOrderCreationResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BookingOrderCreationResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BookingOrderCreationResponse((DeepLink) parcel.readParcelable(BookingOrderCreationResponse.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BookingOrderCreationResponse[] newArray(int i) {
            return new BookingOrderCreationResponse[i];
        }
    }

    public BookingOrderCreationResponse(@NotNull DeepLink deepLink2) {
        Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
        this.deepLink = deepLink2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.deepLink, i);
    }
}
