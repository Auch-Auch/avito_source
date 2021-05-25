package net.gotev.uploadservice.placeholders;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.data.UploadElapsedTime;
import net.gotev.uploadservice.data.UploadInfo;
import net.gotev.uploadservice.data.UploadRate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\fJ!\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lnet/gotev/uploadservice/placeholders/DefaultPlaceholdersProcessor;", "Lnet/gotev/uploadservice/placeholders/PlaceholdersProcessor;", "Lnet/gotev/uploadservice/data/UploadElapsedTime;", "uploadElapsedTime", "", "(Lnet/gotev/uploadservice/data/UploadElapsedTime;)Ljava/lang/String;", "Lnet/gotev/uploadservice/data/UploadRate;", "uploadRate", "(Lnet/gotev/uploadservice/data/UploadRate;)Ljava/lang/String;", "", "percent", "uploadProgress", "(I)Ljava/lang/String;", "uploadedFiles", "remainingFiles", "totalFiles", "message", "Lnet/gotev/uploadservice/data/UploadInfo;", "uploadInfo", "processPlaceholders", "(Ljava/lang/String;Lnet/gotev/uploadservice/data/UploadInfo;)Ljava/lang/String;", "<init>", "()V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public class DefaultPlaceholdersProcessor implements PlaceholdersProcessor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            UploadRate.UploadRateUnit.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
        }
    }

    @Override // net.gotev.uploadservice.placeholders.PlaceholdersProcessor
    @NotNull
    public String processPlaceholders(@Nullable String str, @NotNull UploadInfo uploadInfo) {
        Intrinsics.checkNotNullParameter(uploadInfo, "uploadInfo");
        if (str == null) {
            return "";
        }
        int successfullyUploadedFiles = uploadInfo.getSuccessfullyUploadedFiles();
        int size = uploadInfo.getFiles().size();
        return m.replace$default(m.replace$default(m.replace$default(m.replace$default(m.replace$default(m.replace$default(str, Placeholder.ElapsedTime.getValue(), uploadElapsedTime(uploadInfo.getElapsedTime()), false, 4, (Object) null), Placeholder.UploadRate.getValue(), uploadRate(uploadInfo.getUploadRate()), false, 4, (Object) null), Placeholder.Progress.getValue(), uploadProgress(uploadInfo.getProgressPercent()), false, 4, (Object) null), Placeholder.UploadedFiles.getValue(), uploadedFiles(successfullyUploadedFiles), false, 4, (Object) null), Placeholder.RemainingFiles.getValue(), remainingFiles(size - successfullyUploadedFiles), false, 4, (Object) null), Placeholder.TotalFiles.getValue(), totalFiles(size), false, 4, (Object) null);
    }

    @NotNull
    public String remainingFiles(int i) {
        return String.valueOf(i);
    }

    @NotNull
    public String totalFiles(int i) {
        return String.valueOf(i);
    }

    @NotNull
    public String uploadElapsedTime(@NotNull UploadElapsedTime uploadElapsedTime) {
        Intrinsics.checkNotNullParameter(uploadElapsedTime, "uploadElapsedTime");
        if (uploadElapsedTime.getMinutes() == 0) {
            return uploadElapsedTime.getSeconds() + " sec";
        }
        return uploadElapsedTime.getMinutes() + " min " + uploadElapsedTime.getSeconds() + " sec";
    }

    @NotNull
    public String uploadProgress(int i) {
        return i + " %";
    }

    @NotNull
    public String uploadRate(@NotNull UploadRate uploadRate) {
        String str;
        Intrinsics.checkNotNullParameter(uploadRate, "uploadRate");
        int ordinal = uploadRate.getUnit().ordinal();
        if (ordinal == 0) {
            str = "b/s";
        } else if (ordinal == 1) {
            str = "kb/s";
        } else if (ordinal == 2) {
            str = "Mb/s";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return uploadRate.getValue() + ' ' + str;
    }

    @NotNull
    public String uploadedFiles(int i) {
        return String.valueOf(i);
    }
}
