package com.avito.android.photo_picker.legacy.di;

import com.avito.android.PublishIntentFactory;
import com.avito.android.di.PerActivity;
import com.avito.android.photo_picker.PhotoPickerActivity;
import com.avito.android.photo_picker.camera.di.CameraDependencies;
import com.avito.android.photo_picker.edit.di.EditPhotoDependencies;
import com.avito.android.photo_picker.gallery.di.GalleryPickerDependencies;
import com.google.gson.Gson;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u0000 \t2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\n\tJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/photo_picker/legacy/di/PhotoPickerComponent;", "Lcom/avito/android/photo_picker/gallery/di/GalleryPickerDependencies;", "Lcom/avito/android/photo_picker/camera/di/CameraDependencies;", "Lcom/avito/android/photo_picker/edit/di/EditPhotoDependencies;", "Lcom/avito/android/photo_picker/PhotoPickerActivity;", "activity", "", "inject", "(Lcom/avito/android/photo_picker/PhotoPickerActivity;)V", "Companion", "Builder", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PhotoPickerDependencies.class}, modules = {PhotoPickerModule.class, CameraItemPresenterModule.class})
@PerActivity
public interface PhotoPickerComponent extends GalleryPickerDependencies, CameraDependencies, EditPhotoDependencies {
    @NotNull
    public static final Companion Companion = Companion.a;
    @NotNull
    public static final String MAX_PHOTO_COUNT = "max_photo_count";
    @NotNull
    public static final String MODE = "mode";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00002\b\b\u0001\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/photo_picker/legacy/di/PhotoPickerComponent$Builder;", "", "Lcom/avito/android/photo_picker/legacy/di/PhotoPickerDependencies;", "dependencies", "(Lcom/avito/android/photo_picker/legacy/di/PhotoPickerDependencies;)Lcom/avito/android/photo_picker/legacy/di/PhotoPickerComponent$Builder;", "Lcom/avito/android/photo_picker/legacy/di/PhotoPickerModule;", "photoPickerModule", "(Lcom/avito/android/photo_picker/legacy/di/PhotoPickerModule;)Lcom/avito/android/photo_picker/legacy/di/PhotoPickerComponent$Builder;", "Lcom/avito/android/photo_picker/legacy/di/CameraItemPresenterModule;", "cameraItemPresenterModule", "(Lcom/avito/android/photo_picker/legacy/di/CameraItemPresenterModule;)Lcom/avito/android/photo_picker/legacy/di/PhotoPickerComponent$Builder;", "Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;", "mode", "withMode", "(Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;)Lcom/avito/android/photo_picker/legacy/di/PhotoPickerComponent$Builder;", "", "maxPhotoCount", "withMaxPhotoCount", "(I)Lcom/avito/android/photo_picker/legacy/di/PhotoPickerComponent$Builder;", "Lcom/google/gson/Gson;", "gson", "withGson", "(Lcom/google/gson/Gson;)Lcom/avito/android/photo_picker/legacy/di/PhotoPickerComponent$Builder;", "Lcom/avito/android/photo_picker/legacy/di/PhotoPickerComponent;", "build", "()Lcom/avito/android/photo_picker/legacy/di/PhotoPickerComponent;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PhotoPickerComponent build();

        @NotNull
        Builder cameraItemPresenterModule(@NotNull CameraItemPresenterModule cameraItemPresenterModule);

        @NotNull
        Builder dependencies(@NotNull PhotoPickerDependencies photoPickerDependencies);

        @NotNull
        Builder photoPickerModule(@NotNull PhotoPickerModule photoPickerModule);

        @BindsInstance
        @NotNull
        Builder withGson(@NotNull Gson gson);

        @BindsInstance
        @NotNull
        Builder withMaxPhotoCount(@Named("max_photo_count") int i);

        @BindsInstance
        @NotNull
        Builder withMode(@Named("mode") @NotNull PublishIntentFactory.PhotoPickerMode photoPickerMode);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/photo_picker/legacy/di/PhotoPickerComponent$Companion;", "", "", "MAX_PHOTO_COUNT", "Ljava/lang/String;", "MODE", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        @NotNull
        public static final String MAX_PHOTO_COUNT = "max_photo_count";
        @NotNull
        public static final String MODE = "mode";
        public static final /* synthetic */ Companion a = new Companion();
    }

    void inject(@NotNull PhotoPickerActivity photoPickerActivity);
}
