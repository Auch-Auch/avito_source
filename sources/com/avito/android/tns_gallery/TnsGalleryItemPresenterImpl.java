package com.avito.android.tns_gallery;

import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Size;
import com.avito.android.remote.model.TnsGalleryImage;
import com.avito.android.util.ViewSize;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/tns_gallery/TnsGalleryItemPresenterImpl;", "Lcom/avito/android/tns_gallery/TnsGalleryItemPresenter;", "Lcom/avito/android/tns_gallery/TnsGalleryItemView;", "view", "Lcom/avito/android/tns_gallery/TnsGalleryItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/tns_gallery/TnsGalleryItemView;Lcom/avito/android/tns_gallery/TnsGalleryItem;I)V", "Lcom/avito/android/tns_gallery/TnsGalleryItemSizeHelper;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/tns_gallery/TnsGalleryItemSizeHelper;", "sizeHelper", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clicksConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;Lcom/avito/android/tns_gallery/TnsGalleryItemSizeHelper;)V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public final class TnsGalleryItemPresenterImpl implements TnsGalleryItemPresenter {
    public final Consumer<TnsGalleryItemClickAction> a;
    public final TnsGalleryItemSizeHelper b;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ TnsGalleryItemPresenterImpl a;
        public final /* synthetic */ TnsGalleryItem b;

        public a(TnsGalleryItemPresenterImpl tnsGalleryItemPresenterImpl, TnsGalleryItem tnsGalleryItem) {
            this.a = tnsGalleryItemPresenterImpl;
            this.b = tnsGalleryItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            Consumer consumer = this.a.a;
            List<TnsGalleryImage> images = this.b.getImages();
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(images, 10));
            Iterator<T> it = images.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getImage());
            }
            consumer.accept(new TnsGalleryItemClickAction(arrayList, (int) this.b.getId()));
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ TnsGalleryItemView a;
        public final /* synthetic */ Disposable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(TnsGalleryItemView tnsGalleryItemView, Disposable disposable) {
            super(0);
            this.a = tnsGalleryItemView;
            this.b = disposable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.b.dispose();
            this.a.setUnbindListener(null);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public TnsGalleryItemPresenterImpl(@NotNull Consumer<TnsGalleryItemClickAction> consumer, @NotNull TnsGalleryItemSizeHelper tnsGalleryItemSizeHelper) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        Intrinsics.checkNotNullParameter(tnsGalleryItemSizeHelper, "sizeHelper");
        this.a = consumer;
        this.b = tnsGalleryItemSizeHelper;
    }

    public void bindView(@NotNull TnsGalleryItemView tnsGalleryItemView, @NotNull TnsGalleryItem tnsGalleryItem, int i) {
        Intrinsics.checkNotNullParameter(tnsGalleryItemView, "view");
        Intrinsics.checkNotNullParameter(tnsGalleryItem, "item");
        TnsGalleryImage tnsGalleryImage = tnsGalleryItem.getImages().get((int) tnsGalleryItem.getId());
        Size originalSize = tnsGalleryImage.getOriginalSize();
        float width = originalSize != null ? ((float) originalSize.getWidth()) / ((float) originalSize.getHeight()) : 1.0f;
        ViewSize containerViewSize = this.b.getContainerViewSize(width);
        tnsGalleryItemView.setContainerSize(containerViewSize.getWidth(), containerViewSize.getHeight());
        tnsGalleryItemView.setImageMustFitContainer(this.b.isImageMustFitContainer(width, containerViewSize));
        tnsGalleryItemView.showImage(AvitoPictureKt.pictureOf$default(tnsGalleryImage.getImage(), false, 0.0f, 0.0f, null, 28, null));
        tnsGalleryItemView.setUnbindListener(new b(tnsGalleryItemView, tnsGalleryItemView.getItemClicks().subscribe(new a(this, tnsGalleryItem))));
    }
}
