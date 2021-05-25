package com.avito.android.remote.model.notification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/model/notification/NotificationsCount;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", VKApiConst.UNREAD, "I", "getUnread", "<init>", "(I)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationsCount implements Parcelable {
    public static final Parcelable.Creator<NotificationsCount> CREATOR = new Creator();
    @SerializedName(VKApiConst.UNREAD)
    private final int unread;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<NotificationsCount> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationsCount createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new NotificationsCount(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationsCount[] newArray(int i) {
            return new NotificationsCount[i];
        }
    }

    public NotificationsCount(int i) {
        this.unread = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getUnread() {
        return this.unread;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.unread);
    }
}
