package net.gotev.uploadservice.protocols.multipart;

import android.content.Context;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.HttpUploadRequest;
import net.gotev.uploadservice.UploadTask;
import net.gotev.uploadservice.data.UploadFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t8T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lnet/gotev/uploadservice/protocols/multipart/MultipartUploadRequest;", "Lnet/gotev/uploadservice/HttpUploadRequest;", "", "filePath", "parameterName", "fileName", "contentType", "addFileToUpload", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/gotev/uploadservice/protocols/multipart/MultipartUploadRequest;", "Ljava/lang/Class;", "Lnet/gotev/uploadservice/UploadTask;", "getTaskClass", "()Ljava/lang/Class;", "taskClass", "Landroid/content/Context;", "context", "serverUrl", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class MultipartUploadRequest extends HttpUploadRequest<MultipartUploadRequest> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultipartUploadRequest(@NotNull Context context, @NotNull String str) {
        super(context, str);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "serverUrl");
    }

    public static /* synthetic */ MultipartUploadRequest addFileToUpload$default(MultipartUploadRequest multipartUploadRequest, String str, String str2, String str3, String str4, int i, Object obj) throws FileNotFoundException {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        return multipartUploadRequest.addFileToUpload(str, str2, str3, str4);
    }

    @JvmOverloads
    @NotNull
    public final MultipartUploadRequest addFileToUpload(@NotNull String str, @NotNull String str2) throws FileNotFoundException {
        return addFileToUpload$default(this, str, str2, null, null, 12, null);
    }

    @JvmOverloads
    @NotNull
    public final MultipartUploadRequest addFileToUpload(@NotNull String str, @NotNull String str2, @Nullable String str3) throws FileNotFoundException {
        return addFileToUpload$default(this, str, str2, str3, null, 8, null);
    }

    @JvmOverloads
    @NotNull
    public final MultipartUploadRequest addFileToUpload(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(str, "filePath");
        Intrinsics.checkNotNullParameter(str2, "parameterName");
        boolean z = true;
        if ((m.isBlank(str) ^ true) && (m.isBlank(str2) ^ true)) {
            ArrayList<UploadFile> files = getFiles();
            UploadFile uploadFile = new UploadFile(str, null, 2, null);
            UploadFileExtensionsKt.setParameterName(uploadFile, str2);
            if (str4 == null || m.isBlank(str4)) {
                str4 = uploadFile.getHandler().contentType(getContext());
            }
            UploadFileExtensionsKt.setContentType(uploadFile, str4);
            if (str3 != null && !m.isBlank(str3)) {
                z = false;
            }
            if (z) {
                str3 = uploadFile.getHandler().name(getContext());
            }
            UploadFileExtensionsKt.setRemoteFileName(uploadFile, str3);
            Unit unit = Unit.INSTANCE;
            files.add(uploadFile);
            return this;
        }
        throw new IllegalArgumentException("Please specify valid filePath and parameterName. They cannot be blank.".toString());
    }

    @Override // net.gotev.uploadservice.UploadRequest
    @NotNull
    public Class<? extends UploadTask> getTaskClass() {
        return MultipartUploadTask.class;
    }
}
