package com.avito.android.util;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/util/PrivatePhotosStorage;", "", "Ljava/io/File;", "createTempFile", "()Ljava/io/File;", "file", "", "deleteFile", "(Ljava/io/File;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "checkFileExists", "(Landroid/net/Uri;)Z", "", "exceptUris", "clearCache", "(Ljava/util/List;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface PrivatePhotosStorage {
    boolean checkFileExists(@NotNull Uri uri);

    void clearCache(@NotNull List<? extends Uri> list);

    @NotNull
    File createTempFile();

    void deleteFile(@NotNull File file);
}
