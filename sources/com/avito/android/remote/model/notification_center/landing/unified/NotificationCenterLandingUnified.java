package com.avito.android.remote.model.notification_center.landing.unified;

import a2.b.a.a.a;
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
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingUnified;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/notification_center/landing/unified/NotificationCenterLandingField;", "fields", "Ljava/util/List;", "getFields", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingUnified implements Parcelable {
    public static final Parcelable.Creator<NotificationCenterLandingUnified> CREATOR = new Creator();
    @SerializedName("fields")
    @NotNull
    private final List<NotificationCenterLandingField> fields;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<NotificationCenterLandingUnified> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationCenterLandingUnified createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((NotificationCenterLandingField) parcel.readParcelable(NotificationCenterLandingUnified.class.getClassLoader()));
                readInt--;
            }
            return new NotificationCenterLandingUnified(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationCenterLandingUnified[] newArray(int i) {
            return new NotificationCenterLandingUnified[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.notification_center.landing.unified.NotificationCenterLandingField> */
    /* JADX WARN: Multi-variable type inference failed */
    public NotificationCenterLandingUnified(@NotNull List<? extends NotificationCenterLandingField> list) {
        Intrinsics.checkNotNullParameter(list, "fields");
        this.fields = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<NotificationCenterLandingField> getFields() {
        return this.fields;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.fields, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((NotificationCenterLandingField) n0.next(), i);
        }
    }
}
