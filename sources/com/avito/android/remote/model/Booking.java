package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\u0007¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/Booking;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/BookingButton;", "component1", "()Lcom/avito/android/remote/model/BookingButton;", "Lcom/avito/android/remote/model/text/AttributedText;", "component2", "()Lcom/avito/android/remote/model/text/AttributedText;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "text", "copy", "(Lcom/avito/android/remote/model/BookingButton;Lcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/remote/model/Booking;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/BookingButton;", "getButton", "Lcom/avito/android/remote/model/text/AttributedText;", "getText", "<init>", "(Lcom/avito/android/remote/model/BookingButton;Lcom/avito/android/remote/model/text/AttributedText;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Booking implements Parcelable {
    public static final Parcelable.Creator<Booking> CREATOR = new Creator();
    @SerializedName(PhonePageSourceKt.PHONE_SOURCE_BUTTON)
    @NotNull
    private final BookingButton button;
    @SerializedName("text")
    @Nullable
    private final AttributedText text;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Booking> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Booking createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new Booking(BookingButton.CREATOR.createFromParcel(parcel), (AttributedText) parcel.readParcelable(Booking.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Booking[] newArray(int i) {
            return new Booking[i];
        }
    }

    public Booking(@NotNull BookingButton bookingButton, @Nullable AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(bookingButton, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        this.button = bookingButton;
        this.text = attributedText;
    }

    public static /* synthetic */ Booking copy$default(Booking booking, BookingButton bookingButton, AttributedText attributedText, int i, Object obj) {
        if ((i & 1) != 0) {
            bookingButton = booking.button;
        }
        if ((i & 2) != 0) {
            attributedText = booking.text;
        }
        return booking.copy(bookingButton, attributedText);
    }

    @NotNull
    public final BookingButton component1() {
        return this.button;
    }

    @Nullable
    public final AttributedText component2() {
        return this.text;
    }

    @NotNull
    public final Booking copy(@NotNull BookingButton bookingButton, @Nullable AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(bookingButton, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        return new Booking(bookingButton, attributedText);
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
        if (!(obj instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) obj;
        return Intrinsics.areEqual(this.button, booking.button) && Intrinsics.areEqual(this.text, booking.text);
    }

    @NotNull
    public final BookingButton getButton() {
        return this.button;
    }

    @Nullable
    public final AttributedText getText() {
        return this.text;
    }

    @Override // java.lang.Object
    public int hashCode() {
        BookingButton bookingButton = this.button;
        int i = 0;
        int hashCode = (bookingButton != null ? bookingButton.hashCode() : 0) * 31;
        AttributedText attributedText = this.text;
        if (attributedText != null) {
            i = attributedText.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Booking(button=");
        L.append(this.button);
        L.append(", text=");
        L.append(this.text);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.button.writeToParcel(parcel, 0);
        parcel.writeParcelable(this.text, i);
    }
}
