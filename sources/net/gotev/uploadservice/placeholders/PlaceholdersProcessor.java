package net.gotev.uploadservice.placeholders;

import kotlin.Metadata;
import net.gotev.uploadservice.data.UploadInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lnet/gotev/uploadservice/placeholders/PlaceholdersProcessor;", "", "", "message", "Lnet/gotev/uploadservice/data/UploadInfo;", "uploadInfo", "processPlaceholders", "(Ljava/lang/String;Lnet/gotev/uploadservice/data/UploadInfo;)Ljava/lang/String;", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public interface PlaceholdersProcessor {
    @NotNull
    String processPlaceholders(@Nullable String str, @NotNull UploadInfo uploadInfo);
}
