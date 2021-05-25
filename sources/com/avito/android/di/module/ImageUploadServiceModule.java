package com.avito.android.di.module;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.PerService;
import com.avito.android.photo.BitmapFileProvider;
import com.avito.android.photo.BitmapFileProviderImpl;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.ExifExtraDataSerializerImpl;
import com.avito.android.photo_picker.PhotoUploadKt;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.photo_picker.legacy.PhotoInteractorImpl;
import com.avito.android.photo_picker.legacy.api.MessengerImageUploadInteractor;
import com.avito.android.photo_picker.legacy.api.UploadConverterProvider;
import com.avito.android.photo_picker.legacy.api.UploadConverterProviderImpl;
import com.avito.android.photo_picker.legacy.api.UploadInteractor;
import com.avito.android.photo_picker.legacy.api.UploadInteractorProvider;
import com.avito.android.photo_picker.legacy.api.UploadInteractorProviderImpl;
import com.avito.android.photo_picker.legacy.remote.PickerApi;
import com.avito.android.photo_picker.legacy.service.ImageUploadServiceDelegate;
import com.avito.android.photo_picker.legacy.service.ImageUploadServiceDelegateImpl;
import com.avito.android.photo_picker.legacy.service.PublishImageUploadInteractor;
import com.avito.android.photo_picker.legacy.service.RatingsFilesUploadInteractor;
import com.avito.android.photo_picker.legacy.service.RatingsImagesUploadInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.service.ServiceCountdownHandler;
import com.avito.android.service.ServiceCountdownHandlerImpl;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.SchedulersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.Messenger;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001:\u00012B\t\b\u0002¢\u0006\u0004\b1\u0010/J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e2\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0007¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b%\u0010&R*\u00100\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b(\u0010)\u0012\u0004\b.\u0010/\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00063"}, d2 = {"Lcom/avito/android/di/module/ImageUploadServiceModule;", "", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "photoInteractor", "Lcom/avito/android/photo_picker/legacy/api/UploadInteractorProvider;", "uploadInteractorProvider", "Lcom/avito/android/photo_picker/legacy/api/UploadConverterProvider;", "uploadConverterProvider", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/photo_picker/legacy/service/ImageUploadServiceDelegate;", "provideImageUploadServiceDelegate", "(Lcom/avito/android/photo_picker/legacy/PhotoInteractor;Lcom/avito/android/photo_picker/legacy/api/UploadInteractorProvider;Lcom/avito/android/photo_picker/legacy/api/UploadConverterProvider;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/photo_picker/legacy/service/ImageUploadServiceDelegate;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "Lcom/avito/android/photo/BitmapFileProvider;", "provideBitmapFileProvider", "(Landroid/app/Application;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/PrivatePhotosStorage;)Lcom/avito/android/photo/BitmapFileProvider;", "Lcom/avito/android/service/ServiceCountdownHandler;", "provideServiceCountdownHandler", "()Lcom/avito/android/service/ServiceCountdownHandler;", "Lcom/avito/android/photo_picker/legacy/remote/PickerApi;", "api", "Lru/avito/messenger/Messenger;", "Lru/avito/messenger/api/AvitoMessengerApi;", "messenger", "", "", "Lcom/avito/android/photo_picker/legacy/api/UploadInteractor;", "provideUploadInteractors", "(Lcom/avito/android/photo_picker/legacy/remote/PickerApi;Lru/avito/messenger/Messenger;)Ljava/util/Map;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "providePhotoInteractor", "(Landroid/app/Application;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "Lcom/avito/android/service/ServiceCountdownHandler$Listener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/service/ServiceCountdownHandler$Listener;", "getServiceStateListener", "()Lcom/avito/android/service/ServiceCountdownHandler$Listener;", "setServiceStateListener", "(Lcom/avito/android/service/ServiceCountdownHandler$Listener;)V", "getServiceStateListener$annotations", "()V", "serviceStateListener", "<init>", "Declarations", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class ImageUploadServiceModule {
    @NotNull
    public static final ImageUploadServiceModule INSTANCE = new ImageUploadServiceModule();
    @Nullable
    public static volatile ServiceCountdownHandler.Listener a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/di/module/ImageUploadServiceModule$Declarations;", "", "Lcom/avito/android/photo_picker/ExifExtraDataSerializerImpl;", "serializer", "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "provideExifExtraDataSerializer", "(Lcom/avito/android/photo_picker/ExifExtraDataSerializerImpl;)Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "Lcom/avito/android/photo_picker/legacy/api/UploadConverterProviderImpl;", "impl", "Lcom/avito/android/photo_picker/legacy/api/UploadConverterProvider;", "provideUploadConverter", "(Lcom/avito/android/photo_picker/legacy/api/UploadConverterProviderImpl;)Lcom/avito/android/photo_picker/legacy/api/UploadConverterProvider;", "Lcom/avito/android/photo_picker/legacy/api/UploadInteractorProviderImpl;", "Lcom/avito/android/photo_picker/legacy/api/UploadInteractorProvider;", "provideUploadApi", "(Lcom/avito/android/photo_picker/legacy/api/UploadInteractorProviderImpl;)Lcom/avito/android/photo_picker/legacy/api/UploadInteractorProvider;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerService
        @Binds
        @NotNull
        ExifExtraDataSerializer provideExifExtraDataSerializer(@NotNull ExifExtraDataSerializerImpl exifExtraDataSerializerImpl);

        @PerService
        @Binds
        @NotNull
        UploadInteractorProvider provideUploadApi(@NotNull UploadInteractorProviderImpl uploadInteractorProviderImpl);

        @PerService
        @Binds
        @NotNull
        UploadConverterProvider provideUploadConverter(@NotNull UploadConverterProviderImpl uploadConverterProviderImpl);
    }

    @Nullable
    public static final ServiceCountdownHandler.Listener getServiceStateListener() {
        return a;
    }

    @JvmStatic
    @VisibleForTesting
    public static /* synthetic */ void getServiceStateListener$annotations() {
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerService
    public static final BitmapFileProvider provideBitmapFileProvider(@NotNull Application application, @NotNull Analytics analytics, @NotNull PrivatePhotosStorage privatePhotosStorage) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(privatePhotosStorage, "privatePhotosStorage");
        Context applicationContext = application.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "application.applicationContext");
        return new BitmapFileProviderImpl(applicationContext, analytics, privatePhotosStorage);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerService
    public static final ImageUploadServiceDelegate provideImageUploadServiceDelegate(@NotNull PhotoInteractor photoInteractor, @NotNull UploadInteractorProvider uploadInteractorProvider, @NotNull UploadConverterProvider uploadConverterProvider, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(photoInteractor, "photoInteractor");
        Intrinsics.checkNotNullParameter(uploadInteractorProvider, "uploadInteractorProvider");
        Intrinsics.checkNotNullParameter(uploadConverterProvider, "uploadConverterProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new ImageUploadServiceDelegateImpl(photoInteractor, uploadInteractorProvider, uploadConverterProvider, schedulersFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerService
    public static final ServiceCountdownHandler provideServiceCountdownHandler() {
        return new ServiceCountdownHandlerImpl("ImageUploadService", a);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerService
    public static final Map<String, UploadInteractor> provideUploadInteractors(@NotNull PickerApi pickerApi, @NotNull Messenger<AvitoMessengerApi> messenger) {
        Intrinsics.checkNotNullParameter(pickerApi, "api");
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        HashMap hashMap = new HashMap();
        hashMap.put(PhotoUploadKt.UPLOAD_TYPE_PUBLISH, new PublishImageUploadInteractor(pickerApi));
        hashMap.put("messenger", new MessengerImageUploadInteractor(messenger.getImageUploadApi()));
        hashMap.put(PhotoUploadKt.UPLOAD_TYPE_RATINGS_FILES, new RatingsFilesUploadInteractor(pickerApi));
        hashMap.put(PhotoUploadKt.UPLOAD_TYPE_RATINGS_IMAGES, new RatingsImagesUploadInteractor(pickerApi));
        return hashMap;
    }

    public static final void setServiceStateListener(@Nullable ServiceCountdownHandler.Listener listener) {
        a = listener;
    }

    @PerService
    @Provides
    @NotNull
    public final PhotoInteractor providePhotoInteractor(@NotNull Application application, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Looper mainLooper = application.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "application.mainLooper");
        ContentResolver contentResolver = application.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "application.contentResolver");
        return new PhotoInteractorImpl(mainLooper, buildInfo, contentResolver, null, 8, null);
    }
}
