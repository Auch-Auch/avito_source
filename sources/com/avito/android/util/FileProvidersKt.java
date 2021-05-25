package com.avito.android.util;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "Ljava/io/File;", "file", "Landroid/net/Uri;", "getUriForFile", "(Landroid/content/Context;Ljava/io/File;)Landroid/net/Uri;", "android_release"}, k = 2, mv = {1, 4, 2})
public final class FileProvidersKt {
    @NotNull
    public static final Uri getUriForFile(@NotNull Context context, @NotNull File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file);
        Intrinsics.checkNotNullExpressionValue(uriForFile, "FileProvider.getUriForFi…Name + \".provider\", file)");
        return uriForFile;
    }
}
