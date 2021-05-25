package kotlin.io;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\u0004\b&\u0010'J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\nHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\tR\u0013\u0010\u001e\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u0013\u0010\u001f\u001a\u00020\u00178F@\u0006¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0013\u0010\"\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\u0013R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\f¨\u0006("}, d2 = {"Lkotlin/io/FilePathComponents;", "", "", "beginIndex", "endIndex", "Ljava/io/File;", "subPath", "(II)Ljava/io/File;", "component1", "()Ljava/io/File;", "", "component2", "()Ljava/util/List;", "root", "segments", "copy", "(Ljava/io/File;Ljava/util/List;)Lkotlin/io/FilePathComponents;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/io/File;", "getRoot", "getSize", "size", "isRooted", "()Z", "getRootName", "rootName", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getSegments", "<init>", "(Ljava/io/File;Ljava/util/List;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class FilePathComponents {
    @NotNull
    public final File a;
    @NotNull
    public final List<File> b;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends java.io.File> */
    /* JADX WARN: Multi-variable type inference failed */
    public FilePathComponents(@NotNull File file, @NotNull List<? extends File> list) {
        Intrinsics.checkNotNullParameter(file, "root");
        Intrinsics.checkNotNullParameter(list, "segments");
        this.a = file;
        this.b = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlin.io.FilePathComponents */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilePathComponents copy$default(FilePathComponents filePathComponents, File file, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            file = filePathComponents.a;
        }
        if ((i & 2) != 0) {
            list = filePathComponents.b;
        }
        return filePathComponents.copy(file, list);
    }

    @NotNull
    public final File component1() {
        return this.a;
    }

    @NotNull
    public final List<File> component2() {
        return this.b;
    }

    @NotNull
    public final FilePathComponents copy(@NotNull File file, @NotNull List<? extends File> list) {
        Intrinsics.checkNotNullParameter(file, "root");
        Intrinsics.checkNotNullParameter(list, "segments");
        return new FilePathComponents(file, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilePathComponents)) {
            return false;
        }
        FilePathComponents filePathComponents = (FilePathComponents) obj;
        return Intrinsics.areEqual(this.a, filePathComponents.a) && Intrinsics.areEqual(this.b, filePathComponents.b);
    }

    @NotNull
    public final File getRoot() {
        return this.a;
    }

    @NotNull
    public final String getRootName() {
        String path = this.a.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "root.path");
        return path;
    }

    @NotNull
    public final List<File> getSegments() {
        return this.b;
    }

    public final int getSize() {
        return this.b.size();
    }

    public int hashCode() {
        File file = this.a;
        int i = 0;
        int hashCode = (file != null ? file.hashCode() : 0) * 31;
        List<File> list = this.b;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public final boolean isRooted() {
        String path = this.a.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "root.path");
        return path.length() > 0;
    }

    @NotNull
    public final File subPath(int i, int i2) {
        if (i < 0 || i > i2 || i2 > getSize()) {
            throw new IllegalArgumentException();
        }
        List<File> subList = this.b.subList(i, i2);
        String str = File.separator;
        Intrinsics.checkNotNullExpressionValue(str, "File.separator");
        return new File(CollectionsKt___CollectionsKt.joinToString$default(subList, str, null, null, 0, null, null, 62, null));
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("FilePathComponents(root=");
        L.append(this.a);
        L.append(", segments=");
        return a.w(L, this.b, ")");
    }
}
