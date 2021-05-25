package net.gotev.uploadservice.data;

import a2.b.a.a.a;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import net.gotev.uploadservice.UploadServiceConfig;
import net.gotev.uploadservice.network.ServerResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\b\u0018\u0000 72\u00020\u0001:\u00017B1\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b5\u00106J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J<\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\"\u0010\u001cJ \u0010'\u001a\u00020&2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b'\u0010(R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\rR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\nR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u0010¨\u00068"}, d2 = {"Lnet/gotev/uploadservice/data/BroadcastData;", "Landroid/os/Parcelable;", "Landroid/content/Intent;", "toIntent", "()Landroid/content/Intent;", "Lnet/gotev/uploadservice/data/UploadStatus;", "component1", "()Lnet/gotev/uploadservice/data/UploadStatus;", "Lnet/gotev/uploadservice/data/UploadInfo;", "component2", "()Lnet/gotev/uploadservice/data/UploadInfo;", "Lnet/gotev/uploadservice/network/ServerResponse;", "component3", "()Lnet/gotev/uploadservice/network/ServerResponse;", "", "component4", "()Ljava/lang/Throwable;", "status", "uploadInfo", "serverResponse", OkListener.KEY_EXCEPTION, "copy", "(Lnet/gotev/uploadservice/data/UploadStatus;Lnet/gotev/uploadservice/data/UploadInfo;Lnet/gotev/uploadservice/network/ServerResponse;Ljava/lang/Throwable;)Lnet/gotev/uploadservice/data/BroadcastData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Lnet/gotev/uploadservice/network/ServerResponse;", "getServerResponse", AuthSource.SEND_ABUSE, "Lnet/gotev/uploadservice/data/UploadStatus;", "getStatus", AuthSource.BOOKING_ORDER, "Lnet/gotev/uploadservice/data/UploadInfo;", "getUploadInfo", "d", "Ljava/lang/Throwable;", "getException", "<init>", "(Lnet/gotev/uploadservice/data/UploadStatus;Lnet/gotev/uploadservice/data/UploadInfo;Lnet/gotev/uploadservice/network/ServerResponse;Ljava/lang/Throwable;)V", "Companion", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class BroadcastData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final UploadStatus a;
    @NotNull
    public final UploadInfo b;
    @Nullable
    public final ServerResponse c;
    @Nullable
    public final Throwable d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lnet/gotev/uploadservice/data/BroadcastData$Companion;", "", "Landroid/content/Intent;", "intent", "Lnet/gotev/uploadservice/data/BroadcastData;", "fromIntent", "(Landroid/content/Intent;)Lnet/gotev/uploadservice/data/BroadcastData;", "", "paramName", "Ljava/lang/String;", "<init>", "()V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @Nullable
        public final BroadcastData fromIntent(@NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return (BroadcastData) intent.getParcelableExtra("broadcastData");
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BroadcastData((UploadStatus) Enum.valueOf(UploadStatus.class, parcel.readString()), (UploadInfo) UploadInfo.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? (ServerResponse) ServerResponse.CREATOR.createFromParcel(parcel) : null, (Throwable) parcel.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i) {
            return new BroadcastData[i];
        }
    }

    @JvmOverloads
    public BroadcastData(@NotNull UploadStatus uploadStatus, @NotNull UploadInfo uploadInfo) {
        this(uploadStatus, uploadInfo, null, null, 12, null);
    }

    @JvmOverloads
    public BroadcastData(@NotNull UploadStatus uploadStatus, @NotNull UploadInfo uploadInfo, @Nullable ServerResponse serverResponse) {
        this(uploadStatus, uploadInfo, serverResponse, null, 8, null);
    }

    @JvmOverloads
    public BroadcastData(@NotNull UploadStatus uploadStatus, @NotNull UploadInfo uploadInfo, @Nullable ServerResponse serverResponse, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(uploadStatus, "status");
        Intrinsics.checkNotNullParameter(uploadInfo, "uploadInfo");
        this.a = uploadStatus;
        this.b = uploadInfo;
        this.c = serverResponse;
        this.d = th;
    }

    public static /* synthetic */ BroadcastData copy$default(BroadcastData broadcastData, UploadStatus uploadStatus, UploadInfo uploadInfo, ServerResponse serverResponse, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            uploadStatus = broadcastData.a;
        }
        if ((i & 2) != 0) {
            uploadInfo = broadcastData.b;
        }
        if ((i & 4) != 0) {
            serverResponse = broadcastData.c;
        }
        if ((i & 8) != 0) {
            th = broadcastData.d;
        }
        return broadcastData.copy(uploadStatus, uploadInfo, serverResponse, th);
    }

    @NotNull
    public final UploadStatus component1() {
        return this.a;
    }

    @NotNull
    public final UploadInfo component2() {
        return this.b;
    }

    @Nullable
    public final ServerResponse component3() {
        return this.c;
    }

    @Nullable
    public final Throwable component4() {
        return this.d;
    }

    @NotNull
    public final BroadcastData copy(@NotNull UploadStatus uploadStatus, @NotNull UploadInfo uploadInfo, @Nullable ServerResponse serverResponse, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(uploadStatus, "status");
        Intrinsics.checkNotNullParameter(uploadInfo, "uploadInfo");
        return new BroadcastData(uploadStatus, uploadInfo, serverResponse, th);
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
        if (!(obj instanceof BroadcastData)) {
            return false;
        }
        BroadcastData broadcastData = (BroadcastData) obj;
        return Intrinsics.areEqual(this.a, broadcastData.a) && Intrinsics.areEqual(this.b, broadcastData.b) && Intrinsics.areEqual(this.c, broadcastData.c) && Intrinsics.areEqual(this.d, broadcastData.d);
    }

    @Nullable
    public final Throwable getException() {
        return this.d;
    }

    @Nullable
    public final ServerResponse getServerResponse() {
        return this.c;
    }

    @NotNull
    public final UploadStatus getStatus() {
        return this.a;
    }

    @NotNull
    public final UploadInfo getUploadInfo() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        UploadStatus uploadStatus = this.a;
        int i = 0;
        int hashCode = (uploadStatus != null ? uploadStatus.hashCode() : 0) * 31;
        UploadInfo uploadInfo = this.b;
        int hashCode2 = (hashCode + (uploadInfo != null ? uploadInfo.hashCode() : 0)) * 31;
        ServerResponse serverResponse = this.c;
        int hashCode3 = (hashCode2 + (serverResponse != null ? serverResponse.hashCode() : 0)) * 31;
        Throwable th = this.d;
        if (th != null) {
            i = th.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public final Intent toIntent() {
        Intent intent = new Intent(UploadServiceConfig.getBroadcastStatusAction());
        intent.setPackage(UploadServiceConfig.getNamespace());
        intent.putExtra("broadcastData", this);
        return intent;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BroadcastData(status=");
        L.append(this.a);
        L.append(", uploadInfo=");
        L.append(this.b);
        L.append(", serverResponse=");
        L.append(this.c);
        L.append(", exception=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a.name());
        this.b.writeToParcel(parcel, 0);
        ServerResponse serverResponse = this.c;
        if (serverResponse != null) {
            parcel.writeInt(1);
            serverResponse.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeSerializable(this.d);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BroadcastData(UploadStatus uploadStatus, UploadInfo uploadInfo, ServerResponse serverResponse, Throwable th, int i, j jVar) {
        this(uploadStatus, uploadInfo, (i & 4) != 0 ? null : serverResponse, (i & 8) != 0 ? null : th);
    }
}
