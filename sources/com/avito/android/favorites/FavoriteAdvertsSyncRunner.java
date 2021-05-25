package com.avito.android.favorites;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/favorites/FavoriteAdvertsSyncRunner;", "", "Landroid/content/Context;", "context", "", "startSync", "(Landroid/content/Context;)V", "startUpload", "startUploadRemoved", "startWipeLocal", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public interface FavoriteAdvertsSyncRunner {
    void startSync(@NotNull Context context);

    void startUpload(@NotNull Context context);

    void startUploadRemoved(@NotNull Context context);

    void startWipeLocal(@NotNull Context context);
}
