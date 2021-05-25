package net.gotev.uploadservice.exceptions;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.network.ServerResponse;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lnet/gotev/uploadservice/exceptions/UploadError;", "", "Lnet/gotev/uploadservice/network/ServerResponse;", AuthSource.SEND_ABUSE, "Lnet/gotev/uploadservice/network/ServerResponse;", "getServerResponse", "()Lnet/gotev/uploadservice/network/ServerResponse;", "serverResponse", "<init>", "(Lnet/gotev/uploadservice/network/ServerResponse;)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class UploadError extends Throwable {
    @NotNull
    public final ServerResponse a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadError(@NotNull ServerResponse serverResponse) {
        super("Upload error");
        Intrinsics.checkNotNullParameter(serverResponse, "serverResponse");
        this.a = serverResponse;
    }

    @NotNull
    public final ServerResponse getServerResponse() {
        return this.a;
    }
}
