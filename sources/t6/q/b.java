package t6.q;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.FilePathComponents;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.n.e;
public class b {
    public static final int a(String str) {
        char c;
        int indexOf$default;
        int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, File.separatorChar, 0, false, 4, (Object) null);
        if (indexOf$default2 == 0) {
            if (str.length() <= 1 || str.charAt(1) != (c = File.separatorChar) || (indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, c, 2, false, 4, (Object) null)) < 0) {
                return 1;
            }
            int indexOf$default3 = StringsKt__StringsKt.indexOf$default((CharSequence) str, File.separatorChar, indexOf$default + 1, false, 4, (Object) null);
            if (indexOf$default3 >= 0) {
                return indexOf$default3 + 1;
            }
            return str.length();
        } else if (indexOf$default2 > 0 && str.charAt(indexOf$default2 - 1) == ':') {
            return indexOf$default2 + 1;
        } else {
            if (indexOf$default2 != -1 || !StringsKt__StringsKt.endsWith$default((CharSequence) str, ':', false, 2, (Object) null)) {
                return 0;
            }
            return str.length();
        }
    }

    @NotNull
    public static final File getRoot(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "$this$root");
        return new File(getRootName(file));
    }

    @NotNull
    public static final String getRootName(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "$this$rootName");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, MessageMetaInfo.COLUMN_PATH);
        String path2 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, MessageMetaInfo.COLUMN_PATH);
        int a = a(path2);
        Objects.requireNonNull(path, "null cannot be cast to non-null type java.lang.String");
        String substring = path.substring(0, a);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean isRooted(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "$this$isRooted");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, MessageMetaInfo.COLUMN_PATH);
        return a(path) > 0;
    }

    @NotNull
    public static final File subPath(@NotNull File file, int i, int i2) {
        Intrinsics.checkNotNullParameter(file, "$this$subPath");
        return toComponents(file).subPath(i, i2);
    }

    @NotNull
    public static final FilePathComponents toComponents(@NotNull File file) {
        List list;
        Intrinsics.checkNotNullParameter(file, "$this$toComponents");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, MessageMetaInfo.COLUMN_PATH);
        int a = a(path);
        String substring = path.substring(0, a);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String substring2 = path.substring(a);
        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
        if (substring2.length() == 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else {
            List<String> split$default = StringsKt__StringsKt.split$default((CharSequence) substring2, new char[]{File.separatorChar}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(split$default, 10));
            for (String str : split$default) {
                arrayList.add(new File(str));
            }
            list = arrayList;
        }
        return new FilePathComponents(new File(substring), list);
    }
}
