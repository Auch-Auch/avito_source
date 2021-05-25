package com.avito.android.remote.model.service_subscription_legacy;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.service_subscription.remote.ServiceSubscription;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/service_subscription_legacy/ServiceSubscriptionResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/service_subscription/remote/ServiceSubscription;", "subscription", "Lcom/avito/android/service_subscription/remote/ServiceSubscription;", "getSubscription", "()Lcom/avito/android/service_subscription/remote/ServiceSubscription;", "<init>", "(Ljava/lang/String;Lcom/avito/android/service_subscription/remote/ServiceSubscription;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ServiceSubscriptionResponse implements Parcelable {
    public static final Parcelable.Creator<ServiceSubscriptionResponse> CREATOR = new Creator();
    @SerializedName("subscription")
    @Nullable
    private final ServiceSubscription subscription;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ServiceSubscriptionResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ServiceSubscriptionResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ServiceSubscriptionResponse(parcel.readString(), parcel.readInt() != 0 ? ServiceSubscription.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ServiceSubscriptionResponse[] newArray(int i) {
            return new ServiceSubscriptionResponse[i];
        }
    }

    public ServiceSubscriptionResponse(@Nullable String str, @Nullable ServiceSubscription serviceSubscription) {
        this.title = str;
        this.subscription = serviceSubscription;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final ServiceSubscription getSubscription() {
        return this.subscription;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        ServiceSubscription serviceSubscription = this.subscription;
        if (serviceSubscription != null) {
            parcel.writeInt(1);
            serviceSubscription.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
