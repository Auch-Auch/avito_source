package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/SellerSubscriptionInfo;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "isNotificationsActivated", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "isSubscribed", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SellerSubscriptionInfo implements Parcelable {
    public static final Parcelable.Creator<SellerSubscriptionInfo> CREATOR = new Creator();
    @SerializedName("isNotificationsActivated")
    @Nullable
    private final Boolean isNotificationsActivated;
    @SerializedName("isSubscribed")
    @Nullable
    private final Boolean isSubscribed;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SellerSubscriptionInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SellerSubscriptionInfo createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            boolean z = true;
            Boolean bool2 = null;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool2 = Boolean.valueOf(z);
            }
            return new SellerSubscriptionInfo(bool, bool2);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SellerSubscriptionInfo[] newArray(int i) {
            return new SellerSubscriptionInfo[i];
        }
    }

    public SellerSubscriptionInfo(@Nullable Boolean bool, @Nullable Boolean bool2) {
        this.isSubscribed = bool;
        this.isNotificationsActivated = bool2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Boolean isNotificationsActivated() {
        return this.isNotificationsActivated;
    }

    @Nullable
    public final Boolean isSubscribed() {
        return this.isSubscribed;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Boolean bool = this.isSubscribed;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool2 = this.isNotificationsActivated;
        if (bool2 != null) {
            a.G0(parcel, 1, bool2);
        } else {
            parcel.writeInt(0);
        }
    }
}
