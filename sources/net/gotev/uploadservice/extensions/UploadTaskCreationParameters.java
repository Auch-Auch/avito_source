package net.gotev.uploadservice.extensions;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.data.UploadTaskParameters;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lnet/gotev/uploadservice/extensions/UploadTaskCreationParameters;", "", "Lnet/gotev/uploadservice/data/UploadTaskParameters;", "component1", "()Lnet/gotev/uploadservice/data/UploadTaskParameters;", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "component2", "()Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "params", "notificationConfig", "copy", "(Lnet/gotev/uploadservice/data/UploadTaskParameters;Lnet/gotev/uploadservice/data/UploadNotificationConfig;)Lnet/gotev/uploadservice/extensions/UploadTaskCreationParameters;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lnet/gotev/uploadservice/data/UploadTaskParameters;", "getParams", AuthSource.BOOKING_ORDER, "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", "getNotificationConfig", "<init>", "(Lnet/gotev/uploadservice/data/UploadTaskParameters;Lnet/gotev/uploadservice/data/UploadNotificationConfig;)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class UploadTaskCreationParameters {
    @NotNull
    public final UploadTaskParameters a;
    @NotNull
    public final UploadNotificationConfig b;

    public UploadTaskCreationParameters(@NotNull UploadTaskParameters uploadTaskParameters, @NotNull UploadNotificationConfig uploadNotificationConfig) {
        Intrinsics.checkNotNullParameter(uploadTaskParameters, "params");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
        this.a = uploadTaskParameters;
        this.b = uploadNotificationConfig;
    }

    public static /* synthetic */ UploadTaskCreationParameters copy$default(UploadTaskCreationParameters uploadTaskCreationParameters, UploadTaskParameters uploadTaskParameters, UploadNotificationConfig uploadNotificationConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            uploadTaskParameters = uploadTaskCreationParameters.a;
        }
        if ((i & 2) != 0) {
            uploadNotificationConfig = uploadTaskCreationParameters.b;
        }
        return uploadTaskCreationParameters.copy(uploadTaskParameters, uploadNotificationConfig);
    }

    @NotNull
    public final UploadTaskParameters component1() {
        return this.a;
    }

    @NotNull
    public final UploadNotificationConfig component2() {
        return this.b;
    }

    @NotNull
    public final UploadTaskCreationParameters copy(@NotNull UploadTaskParameters uploadTaskParameters, @NotNull UploadNotificationConfig uploadNotificationConfig) {
        Intrinsics.checkNotNullParameter(uploadTaskParameters, "params");
        Intrinsics.checkNotNullParameter(uploadNotificationConfig, "notificationConfig");
        return new UploadTaskCreationParameters(uploadTaskParameters, uploadNotificationConfig);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadTaskCreationParameters)) {
            return false;
        }
        UploadTaskCreationParameters uploadTaskCreationParameters = (UploadTaskCreationParameters) obj;
        return Intrinsics.areEqual(this.a, uploadTaskCreationParameters.a) && Intrinsics.areEqual(this.b, uploadTaskCreationParameters.b);
    }

    @NotNull
    public final UploadNotificationConfig getNotificationConfig() {
        return this.b;
    }

    @NotNull
    public final UploadTaskParameters getParams() {
        return this.a;
    }

    public int hashCode() {
        UploadTaskParameters uploadTaskParameters = this.a;
        int i = 0;
        int hashCode = (uploadTaskParameters != null ? uploadTaskParameters.hashCode() : 0) * 31;
        UploadNotificationConfig uploadNotificationConfig = this.b;
        if (uploadNotificationConfig != null) {
            i = uploadNotificationConfig.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("UploadTaskCreationParameters(params=");
        L.append(this.a);
        L.append(", notificationConfig=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
