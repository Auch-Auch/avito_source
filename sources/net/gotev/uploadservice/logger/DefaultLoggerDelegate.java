package net.gotev.uploadservice.logger;

import a2.b.a.a.a;
import com.avito.android.util.preferences.Names;
import kotlin.Metadata;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\f¨\u0006\u0011"}, d2 = {"Lnet/gotev/uploadservice/logger/DefaultLoggerDelegate;", "Lnet/gotev/uploadservice/logger/UploadServiceLogger$Delegate;", "", "component", "uploadId", "message", "", OkListener.KEY_EXCEPTION, "", "error", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", Names.DEBUG, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "info", "<init>", "()V", "Companion", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class DefaultLoggerDelegate implements UploadServiceLogger.Delegate {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lnet/gotev/uploadservice/logger/DefaultLoggerDelegate$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Override // net.gotev.uploadservice.logger.UploadServiceLogger.Delegate
    public void debug(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a.Z0(str, "component", str2, "uploadId", str3, "message");
    }

    @Override // net.gotev.uploadservice.logger.UploadServiceLogger.Delegate
    public void error(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Throwable th) {
        a.Z0(str, "component", str2, "uploadId", str3, "message");
    }

    @Override // net.gotev.uploadservice.logger.UploadServiceLogger.Delegate
    public void info(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a.Z0(str, "component", str2, "uploadId", str3, "message");
    }
}
