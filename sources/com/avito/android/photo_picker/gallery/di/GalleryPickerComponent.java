package com.avito.android.photo_picker.gallery.di;

import android.content.ContentResolver;
import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.photo_picker.gallery.GalleryPickerFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/photo_picker/gallery/di/GalleryPickerComponent;", "", "Lcom/avito/android/photo_picker/gallery/GalleryPickerFragment;", "fragment", "", "inject", "(Lcom/avito/android/photo_picker/gallery/GalleryPickerFragment;)V", "Builder", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {GalleryPickerDependencies.class}, modules = {GalleryPickerModule.class})
@PerFragment
public interface GalleryPickerComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/photo_picker/gallery/di/GalleryPickerComponent$Builder;", "", "Lcom/avito/android/photo_picker/gallery/di/GalleryPickerDependencies;", "dependencies", "(Lcom/avito/android/photo_picker/gallery/di/GalleryPickerDependencies;)Lcom/avito/android/photo_picker/gallery/di/GalleryPickerComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "withFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/photo_picker/gallery/di/GalleryPickerComponent$Builder;", "Landroid/content/ContentResolver;", "resolver", "contentResolver", "(Landroid/content/ContentResolver;)Lcom/avito/android/photo_picker/gallery/di/GalleryPickerComponent$Builder;", "Lcom/avito/android/photo_picker/gallery/di/GalleryPickerComponent;", "build", "()Lcom/avito/android/photo_picker/gallery/di/GalleryPickerComponent;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        GalleryPickerComponent build();

        @BindsInstance
        @NotNull
        Builder contentResolver(@NotNull ContentResolver contentResolver);

        @NotNull
        Builder dependencies(@NotNull GalleryPickerDependencies galleryPickerDependencies);

        @BindsInstance
        @NotNull
        Builder withFragment(@NotNull Fragment fragment);
    }

    void inject(@NotNull GalleryPickerFragment galleryPickerFragment);
}
