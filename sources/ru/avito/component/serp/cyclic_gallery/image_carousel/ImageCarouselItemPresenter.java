package ru.avito.component.serp.cyclic_gallery.image_carousel;

import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.serp.cyclic_gallery.image_carousel.CarouselActions;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/ImageCarouselItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ImageCarouselItemView;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ImageCarouselItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lru/avito/component/serp/cyclic_gallery/image_carousel/ImageCarouselItemView;Lru/avito/component/serp/cyclic_gallery/image_carousel/ImageCarouselItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clicksConsumer", "", AuthSource.BOOKING_ORDER, "F", "widthRatio", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;F)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ImageCarouselItemPresenter implements ItemPresenter<ImageCarouselItemView, ImageCarouselItem> {
    public final Consumer<CarouselActions> a;
    public final float b;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ Uri a;
        public final /* synthetic */ ImageCarouselItemPresenter b;
        public final /* synthetic */ int c;

        public a(Uri uri, ImageCarouselItemPresenter imageCarouselItemPresenter, ImageCarouselItem imageCarouselItem, int i) {
            this.a = uri;
            this.b = imageCarouselItemPresenter;
            this.c = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            Object obj;
            Uri uri = this.a;
            if (uri != null) {
                obj = new CarouselActions.VideoClick(uri, this.c);
            } else {
                obj = new CarouselActions.ImageClick(this.c);
            }
            this.b.a.accept(obj);
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ImageCarouselItemView a;
        public final /* synthetic */ Disposable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ImageCarouselItemView imageCarouselItemView, Disposable disposable) {
            super(0);
            this.a = imageCarouselItemView;
            this.b = disposable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setUnbindListener(null);
            this.b.dispose();
            return Unit.INSTANCE;
        }
    }

    public ImageCarouselItemPresenter(@NotNull Consumer<CarouselActions> consumer, float f) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        this.a = consumer;
        this.b = f;
    }

    public void bindView(@NotNull ImageCarouselItemView imageCarouselItemView, @NotNull ImageCarouselItem imageCarouselItem, int i) {
        Intrinsics.checkNotNullParameter(imageCarouselItemView, "view");
        Intrinsics.checkNotNullParameter(imageCarouselItem, "item");
        Uri videoLink = imageCarouselItem.getVideoLink();
        imageCarouselItemView.setUnbindListener(new b(imageCarouselItemView, imageCarouselItemView.clicks().subscribe(new a(videoLink, this, imageCarouselItem, i))));
        imageCarouselItemView.setWidthRatio(this.b);
        imageCarouselItemView.setImage(imageCarouselItem.getPicture());
        imageCarouselItemView.setIsVideoPreview(videoLink != null);
    }
}
