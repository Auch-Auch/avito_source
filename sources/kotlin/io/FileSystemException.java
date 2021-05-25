package kotlin.io;

import com.avito.android.remote.auth.AuthSource;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Lkotlin/io/FileSystemException;", "Ljava/io/IOException;", "", "c", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "reason", "Ljava/io/File;", AuthSource.SEND_ABUSE, "Ljava/io/File;", "getFile", "()Ljava/io/File;", "file", AuthSource.BOOKING_ORDER, "getOther", "other", "<init>", "(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public class FileSystemException extends IOException {
    @NotNull
    public final File a;
    @Nullable
    public final File b;
    @Nullable
    public final String c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FileSystemException(File file, File file2, String str, int i, j jVar) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }

    @NotNull
    public final File getFile() {
        return this.a;
    }

    @Nullable
    public final File getOther() {
        return this.b;
    }

    @Nullable
    public final String getReason() {
        return this.c;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSystemException(@NotNull File file, @Nullable File file2, @Nullable String str) {
        super(ExceptionsKt.access$constructMessage(file, file2, str));
        Intrinsics.checkNotNullParameter(file, "file");
        this.a = file;
        this.b = file2;
        this.c = str;
    }
}
