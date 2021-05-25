package ru.avito.component.serp;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.serp.cyclic_gallery.image_carousel.CarouselActionItemBlueprint;
import ru.avito.component.serp.cyclic_gallery.image_carousel.CarouselActionItemPresenter;
import ru.avito.component.serp.cyclic_gallery.image_carousel.CarouselActions;
import ru.avito.component.serp.cyclic_gallery.image_carousel.GalleryRatio;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarouselItemBlueprint;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarouselItemPresenter;
import ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItemBlueprint;
import ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItemPresenter;
import ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.SellerInfoParams;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR$\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lru/avito/component/serp/ImageGalleryItemBinderFactoryImpl;", "Lru/avito/component/serp/ImageGalleryItemBinderFactory;", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "", AuthSource.BOOKING_ORDER, "I", "getPhotoViewType", "()I", "photoViewType", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "blueprints", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions;", "consumer", "Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;", "galleryRatio", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams;", "sellerInfoParams", "<init>", "(Lcom/jakewharton/rxrelay3/PublishRelay;Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ImageGalleryItemBinderFactoryImpl implements ImageGalleryItemBinderFactory {
    public final List<ItemBlueprint<?, ?>> a;
    public final int b;

    public ImageGalleryItemBinderFactoryImpl(@NotNull PublishRelay<CarouselActions> publishRelay, @NotNull GalleryRatio galleryRatio, @NotNull SellerInfoParams sellerInfoParams) {
        Intrinsics.checkNotNullParameter(publishRelay, "consumer");
        Intrinsics.checkNotNullParameter(galleryRatio, "galleryRatio");
        Intrinsics.checkNotNullParameter(sellerInfoParams, "sellerInfoParams");
        ImageCarouselItemBlueprint imageCarouselItemBlueprint = new ImageCarouselItemBlueprint(new ImageCarouselItemPresenter(publishRelay, galleryRatio.getImageWidthRatio()));
        CarouselActionItemBlueprint carouselActionItemBlueprint = new CarouselActionItemBlueprint(new CarouselActionItemPresenter(publishRelay, galleryRatio.getActionRatio()));
        CarouselSellerItemBlueprint carouselSellerItemBlueprint = new CarouselSellerItemBlueprint(new CarouselSellerItemPresenter(publishRelay, galleryRatio.getSellerRatio(), sellerInfoParams));
        int i = 0;
        List<ItemBlueprint<?, ?>> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ItemBlueprint[]{imageCarouselItemBlueprint, carouselActionItemBlueprint, carouselSellerItemBlueprint});
        this.a = listOf;
        Iterator<ItemBlueprint<?, ?>> it = listOf.iterator();
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next() instanceof ImageCarouselItemBlueprint) {
                break;
            } else {
                i++;
            }
        }
        this.b = i;
    }

    @Override // ru.avito.component.serp.ImageGalleryItemBinderFactory
    @NotNull
    public ItemBinder getItemBinder() {
        ItemBinder.Builder builder = new ItemBinder.Builder();
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            builder.registerItem(it.next());
        }
        return builder.build();
    }

    @Override // ru.avito.component.serp.ImageGalleryItemBinderFactory
    public int getPhotoViewType() {
        return this.b;
    }
}
