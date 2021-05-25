package net.gotev.uploadservice.protocols.binary;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.gotev.uploadservice.HttpUploadRequest;
import net.gotev.uploadservice.UploadTask;
import net.gotev.uploadservice.data.UploadFile;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00022\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\n\"\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ%\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0016¢\u0006\u0004\b\f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u00168T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lnet/gotev/uploadservice/protocols/binary/BinaryUploadRequest;", "Lnet/gotev/uploadservice/HttpUploadRequest;", "", MessageMetaInfo.COLUMN_PATH, "setFileToUpload", "(Ljava/lang/String;)Lnet/gotev/uploadservice/protocols/binary/BinaryUploadRequest;", "paramName", "paramValue", "addParameter", "(Ljava/lang/String;Ljava/lang/String;)Lnet/gotev/uploadservice/protocols/binary/BinaryUploadRequest;", "", "array", "addArrayParameter", "(Ljava/lang/String;[Ljava/lang/String;)Lnet/gotev/uploadservice/protocols/binary/BinaryUploadRequest;", "", "list", "(Ljava/lang/String;Ljava/util/List;)Lnet/gotev/uploadservice/protocols/binary/BinaryUploadRequest;", "startUpload", "()Ljava/lang/String;", "", AuthSource.BOOKING_ORDER, "()V", "Ljava/lang/Class;", "Lnet/gotev/uploadservice/UploadTask;", "getTaskClass", "()Ljava/lang/Class;", "taskClass", "Landroid/content/Context;", "context", "serverUrl", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class BinaryUploadRequest extends HttpUploadRequest<BinaryUploadRequest> {

    public static final class a extends Lambda implements Function0<String> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return "This upload method does not support adding parameters";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BinaryUploadRequest(@NotNull Context context, @NotNull String str) {
        super(context, str);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "serverUrl");
    }

    public final void b() {
        String simpleName = BinaryUploadRequest.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        UploadServiceLogger.error$default(simpleName, UploadServiceLogger.NA, null, a.a, 4, null);
    }

    @Override // net.gotev.uploadservice.UploadRequest
    @NotNull
    public Class<? extends UploadTask> getTaskClass() {
        return BinaryUploadTask.class;
    }

    @NotNull
    public final BinaryUploadRequest setFileToUpload(@NotNull String str) throws IOException {
        Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
        getFiles().clear();
        getFiles().add(new UploadFile(str, null, 2, null));
        return this;
    }

    @Override // net.gotev.uploadservice.UploadRequest
    @NotNull
    public String startUpload() {
        if (!getFiles().isEmpty()) {
            return super.startUpload();
        }
        throw new IllegalArgumentException("Set the file to be used in the request body first!".toString());
    }

    @Override // net.gotev.uploadservice.HttpUploadRequest
    @NotNull
    public BinaryUploadRequest addParameter(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "paramName");
        Intrinsics.checkNotNullParameter(str2, "paramValue");
        b();
        return this;
    }

    @Override // net.gotev.uploadservice.HttpUploadRequest
    @NotNull
    public BinaryUploadRequest addArrayParameter(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, "paramName");
        Intrinsics.checkNotNullParameter(strArr, "array");
        b();
        return this;
    }

    @Override // net.gotev.uploadservice.HttpUploadRequest
    @NotNull
    public BinaryUploadRequest addArrayParameter(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "paramName");
        Intrinsics.checkNotNullParameter(list, "list");
        b();
        return this;
    }
}
