package androidx.core.net;

import a2.b.a.a.a;
import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\b¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0004*\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "Landroid/net/Uri;", "toUri", "(Ljava/lang/String;)Landroid/net/Uri;", "Ljava/io/File;", "(Ljava/io/File;)Landroid/net/Uri;", "toFile", "(Landroid/net/Uri;)Ljava/io/File;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class UriKt {
    @NotNull
    public static final File toFile(@NotNull Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "$this$toFile");
        if (Intrinsics.areEqual(uri.getScheme(), "file")) {
            String path = uri.getPath();
            if (path != null) {
                return new File(path);
            }
            throw new IllegalArgumentException(a.W2("Uri path is null: ", uri).toString());
        }
        throw new IllegalArgumentException(a.W2("Uri lacks 'file' scheme: ", uri).toString());
    }

    @NotNull
    public static final Uri toUri(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toUri");
        Uri parse = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        return parse;
    }

    @NotNull
    public static final Uri toUri(@NotNull File file) {
        Intrinsics.checkParameterIsNotNull(file, "$this$toUri");
        Uri fromFile = Uri.fromFile(file);
        Intrinsics.checkExpressionValueIsNotNull(fromFile, "Uri.fromFile(this)");
        return fromFile;
    }
}
