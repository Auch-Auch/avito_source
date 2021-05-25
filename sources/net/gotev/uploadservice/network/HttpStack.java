package net.gotev.uploadservice.network;

import java.io.IOException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lnet/gotev/uploadservice/network/HttpStack;", "", "", "uploadId", "method", "url", "Lnet/gotev/uploadservice/network/HttpRequest;", "newRequest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/gotev/uploadservice/network/HttpRequest;", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public interface HttpStack {
    @NotNull
    HttpRequest newRequest(@NotNull String str, @NotNull String str2, @NotNull String str3) throws IOException;
}
