package ru.avito.component.serp;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.cyclic_gallery.image_carousel.GalleryRatio;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0004¨\u0006\n"}, d2 = {"Lru/avito/component/serp/SerpItemViewConfig;", "", "", "isTextPrefetchEnabled", "()Z", "Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;", "getGalleryRatio", "()Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;", "galleryRatio", "isPriceOnTop", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface SerpItemViewConfig {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @Nullable
        public static GalleryRatio getGalleryRatio(@NotNull SerpItemViewConfig serpItemViewConfig) {
            return null;
        }
    }

    @Nullable
    GalleryRatio getGalleryRatio();

    boolean isPriceOnTop();

    boolean isTextPrefetchEnabled();
}
