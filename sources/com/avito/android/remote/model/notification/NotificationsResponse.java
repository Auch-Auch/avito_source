package com.avito.android.remote.model.notification;

import a2.b.a.a.a;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/notification/NotificationsResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/notification/Notification;", "notifications", "Ljava/util/List;", "getNotifications", "()Ljava/util/List;", "Landroid/net/Uri;", "nextPage", "Landroid/net/Uri;", "getNextPage", "()Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;Ljava/util/List;)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationsResponse implements Parcelable {
    public static final Parcelable.Creator<NotificationsResponse> CREATOR = new Creator();
    @SerializedName("nextPage")
    @Nullable
    private final Uri nextPage;
    @SerializedName("notifications")
    @NotNull
    private final List<Notification> notifications;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<NotificationsResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationsResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            Uri uri = (Uri) parcel.readParcelable(NotificationsResponse.class.getClassLoader());
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(Notification.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new NotificationsResponse(uri, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationsResponse[] newArray(int i) {
            return new NotificationsResponse[i];
        }
    }

    public NotificationsResponse(@Nullable Uri uri, @NotNull List<Notification> list) {
        Intrinsics.checkNotNullParameter(list, "notifications");
        this.nextPage = uri;
        this.notifications = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Uri getNextPage() {
        return this.nextPage;
    }

    @NotNull
    public final List<Notification> getNotifications() {
        return this.notifications;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.nextPage, i);
        Iterator n0 = a.n0(this.notifications, parcel);
        while (n0.hasNext()) {
            ((Notification) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
