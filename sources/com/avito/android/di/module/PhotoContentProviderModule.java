package com.avito.android.di.module;

import android.content.ContentResolver;
import com.avito.android.db.DbHelper;
import com.avito.android.di.PerContentProvider;
import com.avito.android.photo_picker.legacy.provider.PhotoContentProviderDelegate;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ContentProviderDelegate;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/di/module/PhotoContentProviderModule;", "", "Lcom/avito/android/util/BuildInfo;", "build", "Lcom/avito/android/db/DbHelper;", "dbHelper", "Landroid/content/ContentResolver;", "contentResolver", "Lcom/avito/android/util/ContentProviderDelegate;", "providePhotoContentProviderDelegate$photo_picker_release", "(Lcom/avito/android/util/BuildInfo;Lcom/avito/android/db/DbHelper;Landroid/content/ContentResolver;)Lcom/avito/android/util/ContentProviderDelegate;", "providePhotoContentProviderDelegate", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PhotoContentProviderModule {
    @NotNull
    public static final PhotoContentProviderModule INSTANCE = new PhotoContentProviderModule();

    @Provides
    @JvmStatic
    @NotNull
    @PerContentProvider
    public static final ContentProviderDelegate providePhotoContentProviderDelegate$photo_picker_release(@NotNull BuildInfo buildInfo, @NotNull DbHelper dbHelper, @NotNull ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(buildInfo, "build");
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        return new PhotoContentProviderDelegate(dbHelper, buildInfo, contentResolver);
    }
}
