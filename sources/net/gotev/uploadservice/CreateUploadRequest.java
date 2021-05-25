package net.gotev.uploadservice;

import android.content.Context;
import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.data.UploadTaskParameters;
import net.gotev.uploadservice.persistence.PersistableData;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R$\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t8T@\u0014X\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lnet/gotev/uploadservice/CreateUploadRequest;", "Lnet/gotev/uploadservice/UploadRequest;", "Lnet/gotev/uploadservice/persistence/PersistableData;", "getAdditionalParameters", "()Lnet/gotev/uploadservice/persistence/PersistableData;", "Lnet/gotev/uploadservice/data/UploadTaskParameters;", "h", "Lnet/gotev/uploadservice/data/UploadTaskParameters;", "params", "Ljava/lang/Class;", "Lnet/gotev/uploadservice/UploadTask;", "getTaskClass", "()Ljava/lang/Class;", "getTaskClass$annotations", "()V", "taskClass", "Companion", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class CreateUploadRequest extends UploadRequest<CreateUploadRequest> {
    public static final Companion Companion = new Companion(null);
    public final UploadTaskParameters h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lnet/gotev/uploadservice/CreateUploadRequest$Companion;", "", "Landroid/content/Context;", "context", "", "json", "Lnet/gotev/uploadservice/CreateUploadRequest;", "fromJson", "(Landroid/content/Context;Ljava/lang/String;)Lnet/gotev/uploadservice/CreateUploadRequest;", "Landroid/os/Parcel;", "parcel", "fromParcel", "(Landroid/content/Context;Landroid/os/Parcel;)Lnet/gotev/uploadservice/CreateUploadRequest;", "Lnet/gotev/uploadservice/persistence/PersistableData;", "data", "fromPersistableData", "(Landroid/content/Context;Lnet/gotev/uploadservice/persistence/PersistableData;)Lnet/gotev/uploadservice/CreateUploadRequest;", "<init>", "()V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        @NotNull
        public final CreateUploadRequest fromJson(@NotNull Context context, @NotNull String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "json");
            return fromPersistableData(context, PersistableData.CREATOR.fromJson(str));
        }

        @JvmStatic
        @NotNull
        public final CreateUploadRequest fromParcel(@NotNull Context context, @NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return fromPersistableData(context, PersistableData.CREATOR.createFromParcel(parcel));
        }

        @JvmStatic
        @NotNull
        public final CreateUploadRequest fromPersistableData(@NotNull Context context, @NotNull PersistableData persistableData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(persistableData, "data");
            return new CreateUploadRequest(context, UploadTaskParameters.Companion.createFromPersistableData(persistableData), null);
        }

        public Companion(j jVar) {
        }
    }

    public CreateUploadRequest(Context context, UploadTaskParameters uploadTaskParameters, j jVar) {
        super(context, "https://empty");
        this.h = uploadTaskParameters;
        setUploadID(uploadTaskParameters.getId());
        setAutoDeleteSuccessfullyUploadedFiles(uploadTaskParameters.getAutoDeleteSuccessfullyUploadedFiles());
        getFiles().addAll(uploadTaskParameters.getFiles());
        m540setMaxRetries(uploadTaskParameters.getMaxRetries());
        setServerUrl(uploadTaskParameters.getServerUrl());
    }

    @JvmStatic
    @NotNull
    public static final CreateUploadRequest fromJson(@NotNull Context context, @NotNull String str) {
        return Companion.fromJson(context, str);
    }

    @JvmStatic
    @NotNull
    public static final CreateUploadRequest fromParcel(@NotNull Context context, @NotNull Parcel parcel) {
        return Companion.fromParcel(context, parcel);
    }

    @JvmStatic
    @NotNull
    public static final CreateUploadRequest fromPersistableData(@NotNull Context context, @NotNull PersistableData persistableData) {
        return Companion.fromPersistableData(context, persistableData);
    }

    public static /* synthetic */ void getTaskClass$annotations() {
    }

    @Override // net.gotev.uploadservice.UploadRequest
    @NotNull
    public PersistableData getAdditionalParameters() {
        return this.h.getAdditionalParameters();
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends net.gotev.uploadservice.UploadTask> */
    @Override // net.gotev.uploadservice.UploadRequest
    @NotNull
    public Class<? extends UploadTask> getTaskClass() {
        return Class.forName(this.h.getTaskClass());
    }
}
