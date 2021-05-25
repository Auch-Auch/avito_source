package com.avito.android.publish.objects.di;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.analytics.Analytics;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.di.PerFragment;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.photo.BitmapFileProviderImpl;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.photo_picker.legacy.PhotoInteractorImpl;
import com.avito.android.photo_picker.legacy.UploadingProgressInteractor;
import com.avito.android.photo_picker.legacy.UploadingProgressInteractorImpl;
import com.avito.android.photo_picker.legacy.service.UploadingInteractor;
import com.avito.android.photo_picker.legacy.service.UploadingInteractorImpl;
import com.avito.android.photo_view.ImageListInteractor;
import com.avito.android.photo_view.ImageListInteractorImpl;
import com.avito.android.photo_view.ImageListPresenter;
import com.avito.android.photo_view.ImageListPresenterImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.SchedulersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u0010-\u001a\u00020*¢\u0006\u0004\b0\u00101J'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010 \u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010$\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\"\u0010#J\u001f\u0010)\u001a\u00020&2\u0006\u0010!\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u001bH\u0001¢\u0006\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00062"}, d2 = {"Lcom/avito/android/publish/objects/di/ImageUploadModule;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "Lcom/avito/android/photo/BitmapFileProvider;", "provideBitmapFileProvider$publish_release", "(Landroid/app/Application;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/PrivatePhotosStorage;)Lcom/avito/android/photo/BitmapFileProvider;", "provideBitmapFileProvider", "Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;", "provideUploadingInteractor$publish_release", "(Landroid/app/Application;)Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;", "provideUploadingInteractor", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "computerVisionInteractor", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "providePhotoInteractor$publish_release", "(Landroid/app/Application;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/computer_vision/ComputerVisionInteractor;)Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "providePhotoInteractor", "Lcom/avito/android/photo_view/ImageListInteractor;", "imageListInteractor", "uploadingInteractor", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/photo_view/ImageListPresenter;", "provideImageListPresenter$publish_release", "(Lcom/avito/android/photo_view/ImageListInteractor;Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/photo_view/ImageListPresenter;", "provideImageListPresenter", "photoInteractor", "provideImageListInteractor$publish_release", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/photo_picker/legacy/PhotoInteractor;)Lcom/avito/android/photo_view/ImageListInteractor;", "provideImageListInteractor", "schedulers", "Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;", "provideUploadingProgressInteractor$publish_release", "(Lcom/avito/android/photo_picker/legacy/PhotoInteractor;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;", "provideUploadingProgressInteractor", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "draftId", "Landroidx/fragment/app/FragmentActivity;", "activity", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ImageUploadModule {
    public final String a;

    public ImageUploadModule(@NotNull FragmentActivity fragmentActivity, @NotNull String str) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(str, "draftId");
        this.a = str;
    }

    @Provides
    @PerFragment
    @NotNull
    public final BitmapFileProvider provideBitmapFileProvider$publish_release(@NotNull Application application, @NotNull Analytics analytics, @NotNull PrivatePhotosStorage privatePhotosStorage) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(privatePhotosStorage, "privatePhotosStorage");
        Context applicationContext = application.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "application.applicationContext");
        return new BitmapFileProviderImpl(applicationContext, analytics, privatePhotosStorage);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ImageListInteractor provideImageListInteractor$publish_release(@NotNull SchedulersFactory schedulersFactory, @NotNull PhotoInteractor photoInteractor) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(photoInteractor, "photoInteractor");
        return new ImageListInteractorImpl(this.a, schedulersFactory, photoInteractor);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ImageListPresenter provideImageListPresenter$publish_release(@NotNull ImageListInteractor imageListInteractor, @NotNull UploadingInteractor uploadingInteractor, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(imageListInteractor, "imageListInteractor");
        Intrinsics.checkNotNullParameter(uploadingInteractor, "uploadingInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new ImageListPresenterImpl(imageListInteractor, uploadingInteractor, schedulersFactory);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PhotoInteractor providePhotoInteractor$publish_release(@NotNull Application application, @NotNull BuildInfo buildInfo, @NotNull ComputerVisionInteractor computerVisionInteractor) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(computerVisionInteractor, "computerVisionInteractor");
        Looper mainLooper = application.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "application.mainLooper");
        ContentResolver contentResolver = application.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "application.contentResolver");
        return new PhotoInteractorImpl(mainLooper, buildInfo, contentResolver, computerVisionInteractor);
    }

    @Provides
    @PerFragment
    @NotNull
    public final UploadingInteractor provideUploadingInteractor$publish_release(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        return new UploadingInteractorImpl(application, this.a, false, 4, null);
    }

    @Provides
    @PerFragment
    @NotNull
    public final UploadingProgressInteractor provideUploadingProgressInteractor$publish_release(@NotNull PhotoInteractor photoInteractor, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(photoInteractor, "photoInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        return new UploadingProgressInteractorImpl(this.a, photoInteractor, schedulersFactory);
    }
}
