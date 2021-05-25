package com.avito.android.async_phone;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.event.ContactSource;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/async_phone/AsyncPhoneRequestData;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/analytics/event/ContactSource;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/event/ContactSource;", "getContactSource", "()Lcom/avito/android/analytics/event/ContactSource;", "contactSource", "Lcom/avito/android/async_phone/AsyncPhoneItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/async_phone/AsyncPhoneItem;", "getItem", "()Lcom/avito/android/async_phone/AsyncPhoneItem;", "item", "<init>", "(Lcom/avito/android/async_phone/AsyncPhoneItem;Lcom/avito/android/analytics/event/ContactSource;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AsyncPhoneRequestData implements Parcelable {
    public static final Parcelable.Creator<AsyncPhoneRequestData> CREATOR = new Creator();
    @NotNull
    public final AsyncPhoneItem a;
    @NotNull
    public final ContactSource b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AsyncPhoneRequestData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AsyncPhoneRequestData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AsyncPhoneRequestData((AsyncPhoneItem) parcel.readParcelable(AsyncPhoneRequestData.class.getClassLoader()), (ContactSource) Enum.valueOf(ContactSource.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AsyncPhoneRequestData[] newArray(int i) {
            return new AsyncPhoneRequestData[i];
        }
    }

    public AsyncPhoneRequestData(@NotNull AsyncPhoneItem asyncPhoneItem, @NotNull ContactSource contactSource) {
        Intrinsics.checkNotNullParameter(asyncPhoneItem, "item");
        Intrinsics.checkNotNullParameter(contactSource, "contactSource");
        this.a = asyncPhoneItem;
        this.b = contactSource;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final ContactSource getContactSource() {
        return this.b;
    }

    @NotNull
    public final AsyncPhoneItem getItem() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.a, i);
        parcel.writeString(this.b.name());
    }
}
