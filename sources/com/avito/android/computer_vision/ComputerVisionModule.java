package com.avito.android.computer_vision;

import android.app.Application;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.PhotoPickerEventTracker;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.computer_vision.multiupload.MultiuploadComputerVisionInteractor;
import com.avito.android.photo.BitmapFileProviderImpl;
import com.avito.android.photo_picker.legacy.remote.PickerApi;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.SchedulersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014JG\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/computer_vision/ComputerVisionModule;", "", "Lcom/avito/android/photo_picker/legacy/remote/PickerApi;", "api", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/analytics/PhotoPickerEventTracker;", "eventTracker", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "provideComputerVisionInteractor", "(Lcom/avito/android/photo_picker/legacy/remote/PickerApi;Landroid/app/Application;Lcom/avito/android/analytics/PhotoPickerEventTracker;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/util/PrivatePhotosStorage;)Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ComputerVisionModule {
    @NotNull
    public static final ComputerVisionModule INSTANCE = new ComputerVisionModule();

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final ComputerVisionInteractor provideComputerVisionInteractor(@NotNull PickerApi pickerApi, @NotNull Application application, @NotNull PhotoPickerEventTracker photoPickerEventTracker, @NotNull Analytics analytics, @NotNull SchedulersFactory schedulersFactory, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull PrivatePhotosStorage privatePhotosStorage) {
        Intrinsics.checkNotNullParameter(pickerApi, "api");
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(photoPickerEventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        Intrinsics.checkNotNullParameter(privatePhotosStorage, "privatePhotosStorage");
        return new MultiuploadComputerVisionInteractor(pickerApi, photoPickerEventTracker, new BitmapFileProviderImpl(application, analytics, privatePhotosStorage), schedulersFactory, publishAnalyticsDataProvider);
    }
}
