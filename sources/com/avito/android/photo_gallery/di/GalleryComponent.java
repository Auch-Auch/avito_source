package com.avito.android.photo_gallery.di;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.di.PerFragment;
import com.avito.android.photo_gallery.GalleryFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/photo_gallery/di/GalleryComponent;", "", "Lcom/avito/android/photo_gallery/GalleryFragment;", "fragment", "", "inject", "(Lcom/avito/android/photo_gallery/GalleryFragment;)V", "Factory", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {GalleryDependencies.class}, modules = {GalleryTrackerModule.class})
@PerFragment
public interface GalleryComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/photo_gallery/di/GalleryComponent$Factory;", "", "Lcom/avito/android/photo_gallery/di/GalleryDependencies;", "dependencies", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "", "isSubComponent", "Lcom/avito/android/photo_gallery/di/GalleryComponent;", "create", "(Lcom/avito/android/photo_gallery/di/GalleryDependencies;Lcom/avito/android/analytics/screens/Screen;Z)Lcom/avito/android/photo_gallery/di/GalleryComponent;", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        GalleryComponent create(@NotNull GalleryDependencies galleryDependencies, @ScreenAnalytics @BindsInstance @NotNull Screen screen, @ScreenAnalytics @BindsInstance boolean z);
    }

    void inject(@NotNull GalleryFragment galleryFragment);
}
