package t6.q;

import com.avito.android.lib.design.input.FormatterType;
import com.facebook.appevents.codeless.internal.Constants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.FilePathComponents;
import kotlin.io.OnErrorAction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import ru.ok.android.sdk.OkListener;
import t6.y.m;
public class e extends d {

    public static final class a extends Lambda implements Function2 {
        public static final a a = new a();

        public a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(Object obj, Object obj2) {
            IOException iOException = (IOException) obj2;
            Intrinsics.checkNotNullParameter((File) obj, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(iOException, OkListener.KEY_EXCEPTION);
            throw iOException;
        }
    }

    public static final class b extends Lambda implements Function2<File, IOException, Unit> {
        public final /* synthetic */ Function2 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Function2 function2) {
            super(2);
            this.a = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(File file, IOException iOException) {
            File file2 = file;
            IOException iOException2 = iOException;
            Intrinsics.checkNotNullParameter(file2, "f");
            Intrinsics.checkNotNullParameter(iOException2, "e");
            if (((OnErrorAction) this.a.invoke(file2, iOException2)) != OnErrorAction.TERMINATE) {
                return Unit.INSTANCE;
            }
            throw new f(file2);
        }
    }

    public static final List<File> b(List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (name != null) {
                int hashCode = name.hashCode();
                if (hashCode != 46) {
                    if (hashCode == 1472 && name.equals("..")) {
                        if (arrayList.isEmpty() || !(!Intrinsics.areEqual(((File) CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList)).getName(), ".."))) {
                            arrayList.add(file);
                        } else {
                            arrayList.remove(arrayList.size() - 1);
                        }
                    }
                } else if (name.equals(".")) {
                }
            }
            arrayList.add(file);
        }
        return arrayList;
    }

    public static final String c(File file, File file2) {
        FilePathComponents components = b.toComponents(file);
        FilePathComponents filePathComponents = new FilePathComponents(components.getRoot(), b(components.getSegments()));
        FilePathComponents components2 = b.toComponents(file2);
        FilePathComponents filePathComponents2 = new FilePathComponents(components2.getRoot(), b(components2.getSegments()));
        if (!Intrinsics.areEqual(filePathComponents.getRoot(), filePathComponents2.getRoot())) {
            return null;
        }
        int size = filePathComponents2.getSize();
        int size2 = filePathComponents.getSize();
        int i = 0;
        int min = Math.min(size2, size);
        while (i < min && Intrinsics.areEqual(filePathComponents.getSegments().get(i), filePathComponents2.getSegments().get(i))) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = size - 1;
        if (i2 >= i) {
            while (!Intrinsics.areEqual(filePathComponents2.getSegments().get(i2).getName(), "..")) {
                sb.append("..");
                if (i2 != i) {
                    sb.append(File.separatorChar);
                }
                if (i2 != i) {
                    i2--;
                }
            }
            return null;
        }
        if (i < size2) {
            if (i < size) {
                sb.append(File.separatorChar);
            }
            List drop = CollectionsKt___CollectionsKt.drop(filePathComponents.getSegments(), i);
            String str = File.separator;
            Intrinsics.checkNotNullExpressionValue(str, "File.separator");
            CollectionsKt___CollectionsKt.joinTo$default(drop, sb, str, null, null, 0, null, null, 124, null);
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean copyRecursively(@org.jetbrains.annotations.NotNull java.io.File r11, @org.jetbrains.annotations.NotNull java.io.File r12, boolean r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.io.File, ? super java.io.IOException, ? extends kotlin.io.OnErrorAction> r14) {
        /*
        // Method dump skipped, instructions count: 229
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.q.e.copyRecursively(java.io.File, java.io.File, boolean, kotlin.jvm.functions.Function2):boolean");
    }

    public static /* synthetic */ boolean copyRecursively$default(File file, File file2, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function2 = a.a;
        }
        return copyRecursively(file, file2, z, function2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0064, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0065, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0068, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006b, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006c, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006f, code lost:
        throw r7;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.io.File copyTo(@org.jetbrains.annotations.NotNull java.io.File r6, @org.jetbrains.annotations.NotNull java.io.File r7, boolean r8, int r9) {
        /*
            java.lang.String r0 = "$this$copyTo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            boolean r0 = r6.exists()
            if (r0 == 0) goto L_0x0070
            boolean r0 = r7.exists()
            if (r0 == 0) goto L_0x002f
            if (r8 == 0) goto L_0x0027
            boolean r8 = r7.delete()
            if (r8 == 0) goto L_0x001f
            goto L_0x002f
        L_0x001f:
            kotlin.io.FileAlreadyExistsException r8 = new kotlin.io.FileAlreadyExistsException
            java.lang.String r9 = "Tried to overwrite the destination, but failed to delete it."
            r8.<init>(r6, r7, r9)
            throw r8
        L_0x0027:
            kotlin.io.FileAlreadyExistsException r8 = new kotlin.io.FileAlreadyExistsException
            java.lang.String r9 = "The destination file already exists."
            r8.<init>(r6, r7, r9)
            throw r8
        L_0x002f:
            boolean r8 = r6.isDirectory()
            if (r8 == 0) goto L_0x0044
            boolean r8 = r7.mkdirs()
            if (r8 == 0) goto L_0x003c
            goto L_0x0061
        L_0x003c:
            kotlin.io.FileSystemException r8 = new kotlin.io.FileSystemException
            java.lang.String r9 = "Failed to create target directory."
            r8.<init>(r6, r7, r9)
            throw r8
        L_0x0044:
            java.io.File r8 = r7.getParentFile()
            if (r8 == 0) goto L_0x004d
            r8.mkdirs()
        L_0x004d:
            java.io.FileInputStream r8 = new java.io.FileInputStream
            r8.<init>(r6)
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x0069 }
            r6.<init>(r7)     // Catch:{ all -> 0x0069 }
            kotlin.io.ByteStreamsKt.copyTo(r8, r6, r9)     // Catch:{ all -> 0x0062 }
            r9 = 0
            kotlin.io.CloseableKt.closeFinally(r6, r9)
            kotlin.io.CloseableKt.closeFinally(r8, r9)
        L_0x0061:
            return r7
        L_0x0062:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0064 }
        L_0x0064:
            r9 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r7)
            throw r9
        L_0x0069:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x006b }
        L_0x006b:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r6)
            throw r7
        L_0x0070:
            kotlin.io.NoSuchFileException r7 = new kotlin.io.NoSuchFileException
            r2 = 0
            r4 = 2
            r5 = 0
            java.lang.String r3 = "The source file doesn't exist."
            r0 = r7
            r1 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.q.e.copyTo(java.io.File, java.io.File, boolean, int):java.io.File");
    }

    public static /* synthetic */ File copyTo$default(File file, File file2, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 8192;
        }
        return copyTo(file, file2, z, i);
    }

    @Deprecated(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    @NotNull
    public static final File createTempDir(@NotNull String str, @Nullable String str2, @Nullable File file) {
        Intrinsics.checkNotNullParameter(str, "prefix");
        File createTempFile = File.createTempFile(str, str2, file);
        createTempFile.delete();
        if (createTempFile.mkdir()) {
            Intrinsics.checkNotNullExpressionValue(createTempFile, "dir");
            return createTempFile;
        }
        throw new IOException("Unable to create temporary directory " + createTempFile + FormatterType.defaultDecimalSeparator);
    }

    public static /* synthetic */ File createTempDir$default(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return createTempDir(str, str2, file);
    }

    @Deprecated(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    @NotNull
    public static final File createTempFile(@NotNull String str, @Nullable String str2, @Nullable File file) {
        Intrinsics.checkNotNullParameter(str, "prefix");
        File createTempFile = File.createTempFile(str, str2, file);
        Intrinsics.checkNotNullExpressionValue(createTempFile, "File.createTempFile(prefix, suffix, directory)");
        return createTempFile;
    }

    public static /* synthetic */ File createTempFile$default(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return createTempFile(str, str2, file);
    }

    public static final boolean deleteRecursively(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "$this$deleteRecursively");
        Iterator it = d.walkBottomUp(file).iterator();
        while (true) {
            boolean z = true;
            while (true) {
                if (!it.hasNext()) {
                    return z;
                }
                File file2 = (File) it.next();
                if (file2.delete() || !file2.exists()) {
                    if (z) {
                    }
                }
                z = false;
            }
        }
    }

    public static final boolean endsWith(@NotNull File file, @NotNull File file2) {
        Intrinsics.checkNotNullParameter(file, "$this$endsWith");
        Intrinsics.checkNotNullParameter(file2, "other");
        FilePathComponents components = b.toComponents(file);
        FilePathComponents components2 = b.toComponents(file2);
        if (components2.isRooted()) {
            return Intrinsics.areEqual(file, file2);
        }
        int size = components.getSize() - components2.getSize();
        if (size < 0) {
            return false;
        }
        return components.getSegments().subList(size, components.getSize()).equals(components2.getSegments());
    }

    @NotNull
    public static final String getExtension(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "$this$extension");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return StringsKt__StringsKt.substringAfterLast(name, (char) FormatterType.defaultDecimalSeparator, "");
    }

    @NotNull
    public static final String getInvariantSeparatorsPath(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "$this$invariantSeparatorsPath");
        if (File.separatorChar != '/') {
            String path = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path, MessageMetaInfo.COLUMN_PATH);
            return m.replace$default(path, File.separatorChar, '/', false, 4, (Object) null);
        }
        String path2 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, MessageMetaInfo.COLUMN_PATH);
        return path2;
    }

    @NotNull
    public static final String getNameWithoutExtension(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "$this$nameWithoutExtension");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return StringsKt__StringsKt.substringBeforeLast$default(name, ".", (String) null, 2, (Object) null);
    }

    @NotNull
    public static final File normalize(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "$this$normalize");
        FilePathComponents components = b.toComponents(file);
        File root = components.getRoot();
        List<File> b2 = b(components.getSegments());
        String str = File.separator;
        Intrinsics.checkNotNullExpressionValue(str, "File.separator");
        return resolve(root, CollectionsKt___CollectionsKt.joinToString$default(b2, str, null, null, 0, null, null, 62, null));
    }

    @NotNull
    public static final File relativeTo(@NotNull File file, @NotNull File file2) {
        Intrinsics.checkNotNullParameter(file, "$this$relativeTo");
        Intrinsics.checkNotNullParameter(file2, "base");
        return new File(toRelativeString(file, file2));
    }

    @Nullable
    public static final File relativeToOrNull(@NotNull File file, @NotNull File file2) {
        Intrinsics.checkNotNullParameter(file, "$this$relativeToOrNull");
        Intrinsics.checkNotNullParameter(file2, "base");
        String c = c(file, file2);
        if (c != null) {
            return new File(c);
        }
        return null;
    }

    @NotNull
    public static final File relativeToOrSelf(@NotNull File file, @NotNull File file2) {
        Intrinsics.checkNotNullParameter(file, "$this$relativeToOrSelf");
        Intrinsics.checkNotNullParameter(file2, "base");
        String c = c(file, file2);
        return c != null ? new File(c) : file;
    }

    @NotNull
    public static final File resolve(@NotNull File file, @NotNull File file2) {
        Intrinsics.checkNotNullParameter(file, "$this$resolve");
        Intrinsics.checkNotNullParameter(file2, Constants.PATH_TYPE_RELATIVE);
        if (b.isRooted(file2)) {
            return file2;
        }
        String file3 = file.toString();
        Intrinsics.checkNotNullExpressionValue(file3, "this.toString()");
        if ((file3.length() == 0) || StringsKt__StringsKt.endsWith$default((CharSequence) file3, File.separatorChar, false, 2, (Object) null)) {
            return new File(a2.b.a.a.a.Y2(file3, file2));
        }
        StringBuilder L = a2.b.a.a.a.L(file3);
        L.append(File.separatorChar);
        L.append(file2);
        return new File(L.toString());
    }

    @NotNull
    public static final File resolveSibling(@NotNull File file, @NotNull File file2) {
        Intrinsics.checkNotNullParameter(file, "$this$resolveSibling");
        Intrinsics.checkNotNullParameter(file2, Constants.PATH_TYPE_RELATIVE);
        FilePathComponents components = b.toComponents(file);
        return resolve(resolve(components.getRoot(), components.getSize() == 0 ? new File("..") : components.subPath(0, components.getSize() - 1)), file2);
    }

    public static final boolean startsWith(@NotNull File file, @NotNull File file2) {
        Intrinsics.checkNotNullParameter(file, "$this$startsWith");
        Intrinsics.checkNotNullParameter(file2, "other");
        FilePathComponents components = b.toComponents(file);
        FilePathComponents components2 = b.toComponents(file2);
        if (!(!Intrinsics.areEqual(components.getRoot(), components2.getRoot())) && components.getSize() >= components2.getSize()) {
            return components.getSegments().subList(0, components2.getSize()).equals(components2.getSegments());
        }
        return false;
    }

    @NotNull
    public static final String toRelativeString(@NotNull File file, @NotNull File file2) {
        Intrinsics.checkNotNullParameter(file, "$this$toRelativeString");
        Intrinsics.checkNotNullParameter(file2, "base");
        String c = c(file, file2);
        if (c != null) {
            return c;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + file2 + FormatterType.defaultDecimalSeparator);
    }

    @NotNull
    public static final File resolve(@NotNull File file, @NotNull String str) {
        Intrinsics.checkNotNullParameter(file, "$this$resolve");
        Intrinsics.checkNotNullParameter(str, Constants.PATH_TYPE_RELATIVE);
        return resolve(file, new File(str));
    }

    @NotNull
    public static final File resolveSibling(@NotNull File file, @NotNull String str) {
        Intrinsics.checkNotNullParameter(file, "$this$resolveSibling");
        Intrinsics.checkNotNullParameter(str, Constants.PATH_TYPE_RELATIVE);
        return resolveSibling(file, new File(str));
    }

    public static final boolean startsWith(@NotNull File file, @NotNull String str) {
        Intrinsics.checkNotNullParameter(file, "$this$startsWith");
        Intrinsics.checkNotNullParameter(str, "other");
        return startsWith(file, new File(str));
    }

    public static final boolean endsWith(@NotNull File file, @NotNull String str) {
        Intrinsics.checkNotNullParameter(file, "$this$endsWith");
        Intrinsics.checkNotNullParameter(str, "other");
        return endsWith(file, new File(str));
    }
}
