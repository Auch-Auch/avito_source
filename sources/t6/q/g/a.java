package t6.q.g;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.y.m;
public final class a {
    public static final Path a = Paths.get("", new String[0]);
    public static final Path b = Paths.get("..", new String[0]);
    @NotNull
    public static final a c = new a();

    @NotNull
    public final Path a(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, MessageMetaInfo.COLUMN_PATH);
        Intrinsics.checkNotNullParameter(path2, "base");
        Path normalize = path2.normalize();
        Path normalize2 = path.normalize();
        Path relativize = normalize.relativize(normalize2);
        Intrinsics.checkNotNullExpressionValue(normalize, "bn");
        int nameCount = normalize.getNameCount();
        Intrinsics.checkNotNullExpressionValue(normalize2, "pn");
        int min = Math.min(nameCount, normalize2.getNameCount());
        for (int i = 0; i < min; i++) {
            Path name = normalize.getName(i);
            Path path3 = b;
            if (!Intrinsics.areEqual(name, path3)) {
                break;
            } else if (!Intrinsics.areEqual(normalize2.getName(i), path3)) {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (!(!Intrinsics.areEqual(normalize2, normalize)) || !Intrinsics.areEqual(normalize, a)) {
            String obj = relativize.toString();
            Intrinsics.checkNotNullExpressionValue(relativize, "rn");
            FileSystem fileSystem = relativize.getFileSystem();
            Intrinsics.checkNotNullExpressionValue(fileSystem, "rn.fileSystem");
            String separator = fileSystem.getSeparator();
            Intrinsics.checkNotNullExpressionValue(separator, "rn.fileSystem.separator");
            if (m.endsWith$default(obj, separator, false, 2, null)) {
                FileSystem fileSystem2 = relativize.getFileSystem();
                FileSystem fileSystem3 = relativize.getFileSystem();
                Intrinsics.checkNotNullExpressionValue(fileSystem3, "rn.fileSystem");
                normalize2 = fileSystem2.getPath(StringsKt___StringsKt.dropLast(obj, fileSystem3.getSeparator().length()), new String[0]);
            } else {
                normalize2 = relativize;
            }
        }
        Intrinsics.checkNotNullExpressionValue(normalize2, "r");
        return normalize2;
    }
}
