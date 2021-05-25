package com.avito.android.photo_picker.camera.di;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import com.avito.android.di.PerFragment;
import com.avito.android.photo_picker.camera.CameraFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/photo_picker/camera/di/CameraComponent;", "", "Lcom/avito/android/photo_picker/camera/CameraFragment;", "fragment", "", "inject", "(Lcom/avito/android/photo_picker/camera/CameraFragment;)V", "Builder", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {CameraDependencies.class}, modules = {CameraModule.class})
@PerFragment
public interface CameraComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/photo_picker/camera/di/CameraComponent$Builder;", "", "Lcom/avito/android/photo_picker/camera/di/CameraDependencies;", "dependencies", "(Lcom/avito/android/photo_picker/camera/di/CameraDependencies;)Lcom/avito/android/photo_picker/camera/di/CameraComponent$Builder;", "Landroid/content/ContentResolver;", "resolver", "withContentResolver", "(Landroid/content/ContentResolver;)Lcom/avito/android/photo_picker/camera/di/CameraComponent$Builder;", "Landroid/graphics/Point;", "displaySize", "withDisplaySize", "(Landroid/graphics/Point;)Lcom/avito/android/photo_picker/camera/di/CameraComponent$Builder;", "Landroid/view/Display;", "display", "withDisplay", "(Landroid/view/Display;)Lcom/avito/android/photo_picker/camera/di/CameraComponent$Builder;", "Landroid/content/Context;", "context", "withContext", "(Landroid/content/Context;)Lcom/avito/android/photo_picker/camera/di/CameraComponent$Builder;", "Lcom/avito/android/photo_picker/camera/di/CameraComponent;", "build", "()Lcom/avito/android/photo_picker/camera/di/CameraComponent;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        CameraComponent build();

        @NotNull
        Builder dependencies(@NotNull CameraDependencies cameraDependencies);

        @BindsInstance
        @NotNull
        Builder withContentResolver(@NotNull ContentResolver contentResolver);

        @BindsInstance
        @NotNull
        Builder withContext(@NotNull Context context);

        @BindsInstance
        @NotNull
        Builder withDisplay(@NotNull Display display);

        @BindsInstance
        @NotNull
        Builder withDisplaySize(@NotNull Point point);
    }

    void inject(@NotNull CameraFragment cameraFragment);
}
