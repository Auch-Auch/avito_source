package net.gotev.uploadservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010$\u001a\u00020\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0014\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000fR\u0019\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000fR\u0019\u0010!\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010$\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b#\u0010\u000f¨\u0006'"}, d2 = {"Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;", "e", "Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;", "getError", "()Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;", "error", "", AuthSource.BOOKING_ORDER, "Z", "isRingToneEnabled", "()Z", "f", "getCancelled", AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, "d", "getSuccess", "success", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getNotificationChannelId", "()Ljava/lang/String;", "notificationChannelId", "c", "getProgress", "progress", "<init>", "(Ljava/lang/String;ZLnet/gotev/uploadservice/data/UploadNotificationStatusConfig;Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class UploadNotificationConfig implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @NotNull
    public final String a;
    public final boolean b;
    @NotNull
    public final UploadNotificationStatusConfig c;
    @NotNull
    public final UploadNotificationStatusConfig d;
    @NotNull
    public final UploadNotificationStatusConfig e;
    @NotNull
    public final UploadNotificationStatusConfig f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            boolean z = parcel.readInt() != 0;
            Parcelable.Creator creator = UploadNotificationStatusConfig.CREATOR;
            return new UploadNotificationConfig(readString, z, (UploadNotificationStatusConfig) creator.createFromParcel(parcel), (UploadNotificationStatusConfig) creator.createFromParcel(parcel), (UploadNotificationStatusConfig) creator.createFromParcel(parcel), (UploadNotificationStatusConfig) creator.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i) {
            return new UploadNotificationConfig[i];
        }
    }

    public UploadNotificationConfig(@NotNull String str, boolean z, @NotNull UploadNotificationStatusConfig uploadNotificationStatusConfig, @NotNull UploadNotificationStatusConfig uploadNotificationStatusConfig2, @NotNull UploadNotificationStatusConfig uploadNotificationStatusConfig3, @NotNull UploadNotificationStatusConfig uploadNotificationStatusConfig4) {
        Intrinsics.checkNotNullParameter(str, "notificationChannelId");
        Intrinsics.checkNotNullParameter(uploadNotificationStatusConfig, "progress");
        Intrinsics.checkNotNullParameter(uploadNotificationStatusConfig2, "success");
        Intrinsics.checkNotNullParameter(uploadNotificationStatusConfig3, "error");
        Intrinsics.checkNotNullParameter(uploadNotificationStatusConfig4, AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED);
        this.a = str;
        this.b = z;
        this.c = uploadNotificationStatusConfig;
        this.d = uploadNotificationStatusConfig2;
        this.e = uploadNotificationStatusConfig3;
        this.f = uploadNotificationStatusConfig4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final UploadNotificationStatusConfig getCancelled() {
        return this.f;
    }

    @NotNull
    public final UploadNotificationStatusConfig getError() {
        return this.e;
    }

    @NotNull
    public final String getNotificationChannelId() {
        return this.a;
    }

    @NotNull
    public final UploadNotificationStatusConfig getProgress() {
        return this.c;
    }

    @NotNull
    public final UploadNotificationStatusConfig getSuccess() {
        return this.d;
    }

    public final boolean isRingToneEnabled() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeInt(this.b ? 1 : 0);
        this.c.writeToParcel(parcel, 0);
        this.d.writeToParcel(parcel, 0);
        this.e.writeToParcel(parcel, 0);
        this.f.writeToParcel(parcel, 0);
    }
}
