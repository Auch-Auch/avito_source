package com.avito.android.photo_picker.legacy.di;

import android.os.Build;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.PrivatePhotosStorageImpl;
import com.avito.android.util.shared_image_files_storage.LegacySharedPhotosStorage;
import com.avito.android.util.shared_image_files_storage.MediaStoreSharedPhotosStorage;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/photo_picker/legacy/di/PhotoPickerStorageModule;", "", "Lcom/avito/android/util/shared_image_files_storage/LegacySharedPhotosStorage;", "legacyStorage", "Lcom/avito/android/util/shared_image_files_storage/MediaStoreSharedPhotosStorage;", "mediaStorage", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "provideSharedFilesStorage", "(Lcom/avito/android/util/shared_image_files_storage/LegacySharedPhotosStorage;Lcom/avito/android/util/shared_image_files_storage/MediaStoreSharedPhotosStorage;)Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "Lcom/avito/android/util/PrivatePhotosStorageImpl;", "impl", "Lcom/avito/android/util/PrivatePhotosStorage;", "providePhotoFilesStorage", "(Lcom/avito/android/util/PrivatePhotosStorageImpl;)Lcom/avito/android/util/PrivatePhotosStorage;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PhotoPickerStorageModule {
    @NotNull
    public static final PhotoPickerStorageModule INSTANCE = new PhotoPickerStorageModule();

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final PrivatePhotosStorage providePhotoFilesStorage(@NotNull PrivatePhotosStorageImpl privatePhotosStorageImpl) {
        Intrinsics.checkNotNullParameter(privatePhotosStorageImpl, "impl");
        return privatePhotosStorageImpl;
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final SharedPhotosStorage provideSharedFilesStorage(@NotNull LegacySharedPhotosStorage legacySharedPhotosStorage, @NotNull MediaStoreSharedPhotosStorage mediaStoreSharedPhotosStorage) {
        Intrinsics.checkNotNullParameter(legacySharedPhotosStorage, "legacyStorage");
        Intrinsics.checkNotNullParameter(mediaStoreSharedPhotosStorage, "mediaStorage");
        return Build.VERSION.SDK_INT < 29 ? legacySharedPhotosStorage : mediaStoreSharedPhotosStorage;
    }
}
