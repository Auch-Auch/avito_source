package com.avito.android.photo_gallery.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.di.PerActivity;
import com.avito.android.photo_gallery.LegacyPhotoGalleryActivity;
import com.avito.android.serp.analytics.BannerPageSource;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/photo_gallery/di/LegacyPhotoGalleryActivityComponent;", "", "Lcom/avito/android/photo_gallery/LegacyPhotoGalleryActivity;", "activity", "", "inject", "(Lcom/avito/android/photo_gallery/LegacyPhotoGalleryActivity;)V", "Builder", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PhotoGalleryDependencies.class}, modules = {LegacyPhotoGalleryModule.class})
@PerActivity
public interface LegacyPhotoGalleryActivityComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\u0004\u0010\bJ\u0019\u0010\u0004\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\u0004\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/photo_gallery/di/LegacyPhotoGalleryActivityComponent$Builder;", "", "Landroid/app/Activity;", "activity", "with", "(Landroid/app/Activity;)Lcom/avito/android/photo_gallery/di/LegacyPhotoGalleryActivityComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/photo_gallery/di/LegacyPhotoGalleryActivityComponent$Builder;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "(Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)Lcom/avito/android/photo_gallery/di/LegacyPhotoGalleryActivityComponent$Builder;", "Lcom/avito/android/serp/analytics/BannerPageSource;", "pageSource", "withBannerPageSource", "(Lcom/avito/android/serp/analytics/BannerPageSource;)Lcom/avito/android/photo_gallery/di/LegacyPhotoGalleryActivityComponent$Builder;", "Lcom/avito/android/photo_gallery/di/PhotoGalleryDependencies;", "photoGalleryDependencies", "(Lcom/avito/android/photo_gallery/di/PhotoGalleryDependencies;)Lcom/avito/android/photo_gallery/di/LegacyPhotoGalleryActivityComponent$Builder;", "Lcom/avito/android/photo_gallery/di/LegacyPhotoGalleryActivityComponent;", "build", "()Lcom/avito/android/photo_gallery/di/LegacyPhotoGalleryActivityComponent;", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        LegacyPhotoGalleryActivityComponent build();

        @NotNull
        Builder photoGalleryDependencies(@NotNull PhotoGalleryDependencies photoGalleryDependencies);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder with(@Nullable TreeClickStreamParent treeClickStreamParent);

        @BindsInstance
        @NotNull
        Builder withBannerPageSource(@NotNull BannerPageSource bannerPageSource);
    }

    void inject(@NotNull LegacyPhotoGalleryActivity legacyPhotoGalleryActivity);
}
