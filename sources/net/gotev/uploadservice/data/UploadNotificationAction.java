package net.gotev.uploadservice.data;

import a2.b.a.a.a;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b,\u0010-J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ.\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0007J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0007J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0007R\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\r¨\u0006."}, d2 = {"Lnet/gotev/uploadservice/data/UploadNotificationAction;", "Landroid/os/Parcelable;", "Landroidx/core/app/NotificationCompat$Action;", "asAction", "()Landroidx/core/app/NotificationCompat$Action;", "", "component1", "()I", "", "component2", "()Ljava/lang/CharSequence;", "Landroid/app/PendingIntent;", "component3", "()Landroid/app/PendingIntent;", "icon", "title", "intent", "copy", "(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Lnet/gotev/uploadservice/data/UploadNotificationAction;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "I", "getIcon", AuthSource.BOOKING_ORDER, "Ljava/lang/CharSequence;", "getTitle", "c", "Landroid/app/PendingIntent;", "getIntent", "<init>", "(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class UploadNotificationAction implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    public final int a;
    @NotNull
    public final CharSequence b;
    @NotNull
    public final PendingIntent c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new UploadNotificationAction(parcel.readInt(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i) {
            return new UploadNotificationAction[i];
        }
    }

    public UploadNotificationAction(int i, @NotNull CharSequence charSequence, @NotNull PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        Intrinsics.checkNotNullParameter(pendingIntent, "intent");
        this.a = i;
        this.b = charSequence;
        this.c = pendingIntent;
    }

    public static /* synthetic */ UploadNotificationAction copy$default(UploadNotificationAction uploadNotificationAction, int i, CharSequence charSequence, PendingIntent pendingIntent, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = uploadNotificationAction.a;
        }
        if ((i2 & 2) != 0) {
            charSequence = uploadNotificationAction.b;
        }
        if ((i2 & 4) != 0) {
            pendingIntent = uploadNotificationAction.c;
        }
        return uploadNotificationAction.copy(i, charSequence, pendingIntent);
    }

    @NotNull
    public final NotificationCompat.Action asAction() {
        NotificationCompat.Action build = new NotificationCompat.Action.Builder(this.a, this.b, this.c).build();
        Intrinsics.checkNotNullExpressionValue(build, "NotificationCompat.Actio…n, title, intent).build()");
        return build;
    }

    public final int component1() {
        return this.a;
    }

    @NotNull
    public final CharSequence component2() {
        return this.b;
    }

    @NotNull
    public final PendingIntent component3() {
        return this.c;
    }

    @NotNull
    public final UploadNotificationAction copy(int i, @NotNull CharSequence charSequence, @NotNull PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        Intrinsics.checkNotNullParameter(pendingIntent, "intent");
        return new UploadNotificationAction(i, charSequence, pendingIntent);
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
        if (!(obj instanceof UploadNotificationAction)) {
            return false;
        }
        UploadNotificationAction uploadNotificationAction = (UploadNotificationAction) obj;
        return this.a == uploadNotificationAction.a && Intrinsics.areEqual(this.b, uploadNotificationAction.b) && Intrinsics.areEqual(this.c, uploadNotificationAction.c);
    }

    public final int getIcon() {
        return this.a;
    }

    @NotNull
    public final PendingIntent getIntent() {
        return this.c;
    }

    @NotNull
    public final CharSequence getTitle() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.a * 31;
        CharSequence charSequence = this.b;
        int i2 = 0;
        int hashCode = (i + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        PendingIntent pendingIntent = this.c;
        if (pendingIntent != null) {
            i2 = pendingIntent.hashCode();
        }
        return hashCode + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("UploadNotificationAction(icon=");
        L.append(this.a);
        L.append(", title=");
        L.append(this.b);
        L.append(", intent=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.a);
        TextUtils.writeToParcel(this.b, parcel, 0);
        this.c.writeToParcel(parcel, 0);
    }
}
