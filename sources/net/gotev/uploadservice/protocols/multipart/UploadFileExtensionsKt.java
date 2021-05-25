package net.gotev.uploadservice.protocols.multipart;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.data.UploadFile;
import net.gotev.uploadservice.extensions.CollectionsExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\",\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00018@@@X\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\",\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00018@@@X\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u0004\"\u0004\b\t\u0010\u0006\",\u0010\r\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00018@@@X\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0004\"\u0004\b\f\u0010\u0006¨\u0006\u000e"}, d2 = {"Lnet/gotev/uploadservice/data/UploadFile;", "", "value", "getParameterName", "(Lnet/gotev/uploadservice/data/UploadFile;)Ljava/lang/String;", "setParameterName", "(Lnet/gotev/uploadservice/data/UploadFile;Ljava/lang/String;)V", "parameterName", "getRemoteFileName", "setRemoteFileName", "remoteFileName", "getContentType", "setContentType", "contentType", "uploadservice_release"}, k = 2, mv = {1, 4, 0})
public final class UploadFileExtensionsKt {
    @Nullable
    public static final String getContentType(@NotNull UploadFile uploadFile) {
        Intrinsics.checkNotNullParameter(uploadFile, "$this$contentType");
        return uploadFile.getProperties().get("multipartContentType");
    }

    @Nullable
    public static final String getParameterName(@NotNull UploadFile uploadFile) {
        Intrinsics.checkNotNullParameter(uploadFile, "$this$parameterName");
        return uploadFile.getProperties().get("multipartParamName");
    }

    @Nullable
    public static final String getRemoteFileName(@NotNull UploadFile uploadFile) {
        Intrinsics.checkNotNullParameter(uploadFile, "$this$remoteFileName");
        return uploadFile.getProperties().get("multipartRemoteFileName");
    }

    public static final void setContentType(@NotNull UploadFile uploadFile, @Nullable String str) {
        Intrinsics.checkNotNullParameter(uploadFile, "$this$contentType");
        CollectionsExtensionsKt.setOrRemove(uploadFile.getProperties(), "multipartContentType", str);
    }

    public static final void setParameterName(@NotNull UploadFile uploadFile, @Nullable String str) {
        Intrinsics.checkNotNullParameter(uploadFile, "$this$parameterName");
        CollectionsExtensionsKt.setOrRemove(uploadFile.getProperties(), "multipartParamName", str);
    }

    public static final void setRemoteFileName(@NotNull UploadFile uploadFile, @Nullable String str) {
        Intrinsics.checkNotNullParameter(uploadFile, "$this$remoteFileName");
        CollectionsExtensionsKt.setOrRemove(uploadFile.getProperties(), "multipartRemoteFileName", str);
    }
}
