package t6.q.g;

import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.model.Navigation;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.io.path.ExperimentalPathApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.y.m;
public class c extends b {
    @SinceKotlin(version = "1.4")
    @NotNull
    @ExperimentalPathApi
    public static final Path createTempDirectory(@Nullable Path path, @Nullable String str, @NotNull FileAttribute<?>... fileAttributeArr) {
        Intrinsics.checkNotNullParameter(fileAttributeArr, Navigation.ATTRIBUTES);
        if (path != null) {
            Path createTempDirectory = Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
            Intrinsics.checkNotNullExpressionValue(createTempDirectory, "Files.createTempDirector…ory, prefix, *attributes)");
            return createTempDirectory;
        }
        Path createTempDirectory2 = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createTempDirectory2, "Files.createTempDirectory(prefix, *attributes)");
        return createTempDirectory2;
    }

    public static /* synthetic */ Path createTempDirectory$default(Path path, String str, FileAttribute[] fileAttributeArr, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return createTempDirectory(path, str, fileAttributeArr);
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    @ExperimentalPathApi
    public static final Path createTempFile(@Nullable Path path, @Nullable String str, @Nullable String str2, @NotNull FileAttribute<?>... fileAttributeArr) {
        Intrinsics.checkNotNullParameter(fileAttributeArr, Navigation.ATTRIBUTES);
        if (path != null) {
            Path createTempFile = Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
            Intrinsics.checkNotNullExpressionValue(createTempFile, "Files.createTempFile(dir…fix, suffix, *attributes)");
            return createTempFile;
        }
        Path createTempFile2 = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createTempFile2, "Files.createTempFile(prefix, suffix, *attributes)");
        return createTempFile2;
    }

    public static /* synthetic */ Path createTempFile$default(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return createTempFile(path, str, str2, fileAttributeArr);
    }

    @PublishedApi
    @NotNull
    public static final Void fileAttributeViewNotAvailable(@NotNull Path path, @NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(path, MessageMetaInfo.COLUMN_PATH);
        Intrinsics.checkNotNullParameter(cls, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + cls + " is not available for the file " + path + FormatterType.defaultDecimalSeparator);
    }

    @NotNull
    public static final String getExtension(@NotNull Path path) {
        String obj;
        String substringAfterLast;
        Intrinsics.checkNotNullParameter(path, "$this$extension");
        Path fileName = path.getFileName();
        return (fileName == null || (obj = fileName.toString()) == null || (substringAfterLast = StringsKt__StringsKt.substringAfterLast(obj, FormatterType.defaultDecimalSeparator, "")) == null) ? "" : substringAfterLast;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalPathApi
    public static /* synthetic */ void getExtension$annotations(Path path) {
    }

    @NotNull
    public static final String getInvariantSeparatorsPath(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "$this$invariantSeparatorsPath");
        return getInvariantSeparatorsPathString(path);
    }

    @Deprecated(message = "Use invariantSeparatorsPathString property instead.", replaceWith = @ReplaceWith(expression = "invariantSeparatorsPathString", imports = {}))
    @SinceKotlin(version = "1.4")
    @ExperimentalPathApi
    public static /* synthetic */ void getInvariantSeparatorsPath$annotations(Path path) {
    }

    @NotNull
    public static final String getInvariantSeparatorsPathString(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "$this$invariantSeparatorsPathString");
        FileSystem fileSystem = path.getFileSystem();
        Intrinsics.checkNotNullExpressionValue(fileSystem, "fileSystem");
        String separator = fileSystem.getSeparator();
        if (!(!Intrinsics.areEqual(separator, "/"))) {
            return path.toString();
        }
        String obj = path.toString();
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        return m.replace$default(obj, separator, "/", false, 4, (Object) null);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalPathApi
    public static /* synthetic */ void getInvariantSeparatorsPathString$annotations(Path path) {
    }

    @NotNull
    public static final String getName(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "$this$name");
        Path fileName = path.getFileName();
        String obj = fileName != null ? fileName.toString() : null;
        return obj != null ? obj : "";
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalPathApi
    public static /* synthetic */ void getName$annotations(Path path) {
    }

    @NotNull
    public static final String getNameWithoutExtension(@NotNull Path path) {
        String obj;
        String substringBeforeLast$default;
        Intrinsics.checkNotNullParameter(path, "$this$nameWithoutExtension");
        Path fileName = path.getFileName();
        return (fileName == null || (obj = fileName.toString()) == null || (substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(obj, ".", null, 2, null)) == null) ? "" : substringBeforeLast$default;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalPathApi
    public static /* synthetic */ void getNameWithoutExtension$annotations(Path path) {
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalPathApi
    @InlineOnly
    public static /* synthetic */ void getPathString$annotations(Path path) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.NotNull
    @kotlin.io.path.ExperimentalPathApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<java.nio.file.Path> listDirectoryEntries(@org.jetbrains.annotations.NotNull java.nio.file.Path r1, @org.jetbrains.annotations.NotNull java.lang.String r2) {
        /*
            java.lang.String r0 = "$this$listDirectoryEntries"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "glob"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.nio.file.DirectoryStream r1 = java.nio.file.Files.newDirectoryStream(r1, r2)
            java.lang.String r2 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ all -> 0x001c }
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r1)     // Catch:{ all -> 0x001c }
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r0)
            return r2
        L_0x001c:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001e }
        L_0x001e:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.q.g.c.listDirectoryEntries(java.nio.file.Path, java.lang.String):java.util.List");
    }

    public static /* synthetic */ List listDirectoryEntries$default(Path path, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "*";
        }
        return listDirectoryEntries(path, str);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalPathApi
    @NotNull
    public static final Path relativeTo(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "$this$relativeTo");
        Intrinsics.checkNotNullParameter(path2, "base");
        try {
            return a.c.a(path, path2);
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            throw new IllegalArgumentException(Intrinsics.stringPlus(message, "\nthis path: " + path + "\nbase path: " + path2), e);
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalPathApi
    @Nullable
    public static final Path relativeToOrNull(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "$this$relativeToOrNull");
        Intrinsics.checkNotNullParameter(path2, "base");
        try {
            return a.c.a(path, path2);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalPathApi
    @NotNull
    public static final Path relativeToOrSelf(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "$this$relativeToOrSelf");
        Intrinsics.checkNotNullParameter(path2, "base");
        Path relativeToOrNull = relativeToOrNull(path, path2);
        return relativeToOrNull != null ? relativeToOrNull : path;
    }
}
