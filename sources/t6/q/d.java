package t6.q;

import java.io.File;
import kotlin.io.FileTreeWalk;
import kotlin.io.FileWalkDirection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public class d extends c {
    @NotNull
    public static final FileTreeWalk walk(@NotNull File file, @NotNull FileWalkDirection fileWalkDirection) {
        Intrinsics.checkNotNullParameter(file, "$this$walk");
        Intrinsics.checkNotNullParameter(fileWalkDirection, "direction");
        return new FileTreeWalk(file, fileWalkDirection);
    }

    public static /* synthetic */ FileTreeWalk walk$default(File file, FileWalkDirection fileWalkDirection, int i, Object obj) {
        if ((i & 1) != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        return walk(file, fileWalkDirection);
    }

    @NotNull
    public static final FileTreeWalk walkBottomUp(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "$this$walkBottomUp");
        return walk(file, FileWalkDirection.BOTTOM_UP);
    }

    @NotNull
    public static final FileTreeWalk walkTopDown(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "$this$walkTopDown");
        return walk(file, FileWalkDirection.TOP_DOWN);
    }
}
