package com.avito.android.photo_picker.legacy.di;

import android.app.Application;
import com.avito.android.analytics.Analytics;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.photo.BitmapFileProviderImpl;
import com.avito.android.util.PrivatePhotosStorage;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/photo_picker/legacy/di/UploadConverterModule;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "Lcom/avito/android/photo/BitmapFileProvider;", "provideBitmapFileProvider$photo_picker_release", "(Landroid/app/Application;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/PrivatePhotosStorage;)Lcom/avito/android/photo/BitmapFileProvider;", "provideBitmapFileProvider", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class UploadConverterModule {
    @Provides
    @Reusable
    @NotNull
    public final BitmapFileProvider provideBitmapFileProvider$photo_picker_release(@NotNull Application application, @NotNull Analytics analytics, @NotNull PrivatePhotosStorage privatePhotosStorage) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(privatePhotosStorage, "privatePhotosStorage");
        return new BitmapFileProviderImpl(application, analytics, privatePhotosStorage);
    }
}
