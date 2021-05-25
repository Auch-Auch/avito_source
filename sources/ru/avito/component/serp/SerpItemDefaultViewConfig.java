package ru.avito.component.serp;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.cyclic_gallery.image_carousel.GalleryRatio;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\u0006\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0006\u0010\u0005R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lru/avito/component/serp/SerpItemDefaultViewConfig;", "Lru/avito/component/serp/SerpItemViewConfig;", "", "isTextPrefetchEnabled", "Z", "()Z", "isPriceOnTop", "Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;", AuthSource.SEND_ABUSE, "Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;", "getGalleryRatio", "()Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;", "galleryRatio", "<init>", "(Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SerpItemDefaultViewConfig implements SerpItemViewConfig {
    @Nullable
    public final GalleryRatio a;

    public SerpItemDefaultViewConfig() {
        this(null, 1, null);
    }

    public SerpItemDefaultViewConfig(@Nullable GalleryRatio galleryRatio) {
        this.a = galleryRatio;
    }

    @Override // ru.avito.component.serp.SerpItemViewConfig
    @Nullable
    public GalleryRatio getGalleryRatio() {
        return this.a;
    }

    @Override // ru.avito.component.serp.SerpItemViewConfig
    public boolean isPriceOnTop() {
        return false;
    }

    @Override // ru.avito.component.serp.SerpItemViewConfig
    public boolean isTextPrefetchEnabled() {
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SerpItemDefaultViewConfig(GalleryRatio galleryRatio, int i, j jVar) {
        this((i & 1) != 0 ? null : galleryRatio);
    }
}
