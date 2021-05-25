package ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info;

import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.serp.cyclic_gallery.image_carousel.CarouselActions;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItemView;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItemView;Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clicksConsumer", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams;", "c", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams;", "sellerInfoParams", "", AuthSource.BOOKING_ORDER, "F", "widthRatio", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;FLru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CarouselSellerItemPresenter implements ItemPresenter<CarouselSellerItemView, CarouselSellerItem> {
    public final Consumer<CarouselActions> a;
    public final float b;
    public final SellerInfoParams c;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CarouselSellerItemPresenter a;
        public final /* synthetic */ CarouselSellerItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CarouselSellerItemPresenter carouselSellerItemPresenter, CarouselSellerItem carouselSellerItem) {
            super(0);
            this.a = carouselSellerItemPresenter;
            this.b = carouselSellerItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(new CarouselActions.DeeplinkClick(this.b.getDeeplink()));
            return Unit.INSTANCE;
        }
    }

    public CarouselSellerItemPresenter(@NotNull Consumer<CarouselActions> consumer, float f, @NotNull SellerInfoParams sellerInfoParams) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        Intrinsics.checkNotNullParameter(sellerInfoParams, "sellerInfoParams");
        this.a = consumer;
        this.b = f;
        this.c = sellerInfoParams;
    }

    public void bindView(@NotNull CarouselSellerItemView carouselSellerItemView, @NotNull CarouselSellerItem carouselSellerItem, int i) {
        Intrinsics.checkNotNullParameter(carouselSellerItemView, "view");
        Intrinsics.checkNotNullParameter(carouselSellerItem, "item");
        carouselSellerItemView.setName(carouselSellerItem.getSellerName());
        carouselSellerItemView.setNameMaxLines(this.c.getTitleMaxLines());
        carouselSellerItemView.setRating(carouselSellerItem.getRating());
        carouselSellerItemView.setReviewCount(carouselSellerItem.getReviewCount());
        if (carouselSellerItem.getExternalVerification() != null) {
            carouselSellerItemView.setExternalVerification(carouselSellerItem.getExternalVerification());
        } else if (carouselSellerItem.getSellerTypeName() != null) {
            carouselSellerItemView.setSellerTypeName(carouselSellerItem.getSellerTypeName());
        } else {
            carouselSellerItemView.hideExternalVerification();
        }
        carouselSellerItemView.setInternalVerification(carouselSellerItem.getInternalVerification());
        if (this.c.getPhotoEnabled()) {
            carouselSellerItemView.setLogo(AvitoPictureKt.pictureOf$default(carouselSellerItem.getLogo(), true, 0.0f, 0.0f, null, 28, null), carouselSellerItem.isShop());
        } else {
            carouselSellerItemView.hideLogo();
        }
        carouselSellerItemView.setWidthRatio(this.b);
        carouselSellerItemView.setPadding(this.c.getSideOffset());
        if (carouselSellerItem.getDeeplink() == null) {
            carouselSellerItemView.setOnClickListener(null);
        } else {
            carouselSellerItemView.setOnClickListener(new a(this, carouselSellerItem));
        }
    }
}
