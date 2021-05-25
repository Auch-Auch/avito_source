package t6.q;

import java.io.File;
import kotlin.io.FileSystemException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class f extends FileSystemException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(@NotNull File file) {
        super(file, null, null, 6, null);
        Intrinsics.checkNotNullParameter(file, "file");
    }
}
