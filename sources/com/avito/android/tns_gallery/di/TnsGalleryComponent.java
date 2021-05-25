package com.avito.android.tns_gallery.di;

import android.app.Activity;
import com.avito.android.Features;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.tns_gallery.TnsGallerySettings;
import com.avito.android.tns_gallery.TnsGalleryViewImpl;
import dagger.BindsInstance;
import dagger.Component;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Component(modules = {TnsGalleryItemModule.class})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/tns_gallery/di/TnsGalleryComponent;", "", "Lcom/avito/android/tns_gallery/TnsGalleryViewImpl;", "galleryView", "", "inject", "(Lcom/avito/android/tns_gallery/TnsGalleryViewImpl;)V", "Factory", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public interface TnsGalleryComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J=\u0010\f\u001a\u00020\u000b2\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/tns_gallery/di/TnsGalleryComponent$Factory;", "", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "imageClicks", "Landroid/app/Activity;", "context", "Lcom/avito/android/tns_gallery/TnsGallerySettings;", "settings", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/tns_gallery/di/TnsGalleryComponent;", "create", "(Lio/reactivex/rxjava3/functions/Consumer;Landroid/app/Activity;Lcom/avito/android/tns_gallery/TnsGallerySettings;Lcom/avito/android/Features;)Lcom/avito/android/tns_gallery/di/TnsGalleryComponent;", "tns-core_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        TnsGalleryComponent create(@BindsInstance @NotNull Consumer<TnsGalleryItemClickAction> consumer, @BindsInstance @NotNull Activity activity, @BindsInstance @NotNull TnsGallerySettings tnsGallerySettings, @BindsInstance @NotNull Features features);
    }

    void inject(@NotNull TnsGalleryViewImpl tnsGalleryViewImpl);
}
