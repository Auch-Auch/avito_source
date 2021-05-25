package com.avito.android.brandspace.items.carousel;

import com.avito.android.brandspace.items.carousel.CarouselItemView;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/brandspace/items/carousel/CarouselPresenterImpl;", "Lcom/avito/android/brandspace/items/carousel/CarouselPresenter;", "Lcom/avito/android/brandspace/items/carousel/CarouselItemView;", "view", "Lcom/avito/android/brandspace/items/carousel/CarouselItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/brandspace/items/carousel/CarouselItemView;Lcom/avito/android/brandspace/items/carousel/CarouselItem;I)V", "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", "getPresenter", "()Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", "presenter", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/brandspace/presenter/BrandspacePresenter;Lcom/avito/android/util/SchedulersFactory3;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class CarouselPresenterImpl implements CarouselPresenter {
    @NotNull
    public final BrandspacePresenter a;
    @NotNull
    public final SchedulersFactory3 b;

    @Inject
    public CarouselPresenterImpl(@NotNull BrandspacePresenter brandspacePresenter, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(brandspacePresenter, "presenter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = brandspacePresenter;
        this.b = schedulersFactory3;
    }

    public static final void access$scheduleAutoScrollIfNeeded(CarouselPresenterImpl carouselPresenterImpl, CarouselItem carouselItem, CarouselItemView carouselItemView) {
        Objects.requireNonNull(carouselPresenterImpl);
        if (carouselItem.getNeedAutoScroll()) {
            carouselItemView.scheduleScrollToNextPage(carouselPresenterImpl.b);
        }
    }

    @NotNull
    public final BrandspacePresenter getPresenter() {
        return this.a;
    }

    @NotNull
    public final SchedulersFactory3 getSchedulers() {
        return this.b;
    }

    public void bindView(@NotNull CarouselItemView carouselItemView, @NotNull CarouselItem carouselItem, int i) {
        Intrinsics.checkNotNullParameter(carouselItemView, "view");
        Intrinsics.checkNotNullParameter(carouselItem, "item");
        carouselItemView.bind(carouselItem.getItems(), carouselItem.getCurrentPosition(), carouselItem.getCalculatedItemHeight(), new CarouselItemView.Listener(this, carouselItem, carouselItemView) { // from class: com.avito.android.brandspace.items.carousel.CarouselPresenterImpl$bindView$1
            public final /* synthetic */ CarouselPresenterImpl a;
            public final /* synthetic */ CarouselItem b;
            public final /* synthetic */ CarouselItemView c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // com.avito.android.brandspace.items.carousel.CarouselItemView.Listener
            public void onCurrentPositionChanged(int i2, boolean z) {
                this.a.getPresenter().onCarouselCurrentPositionChanged(i2, this.b, z);
                CarouselPresenterImpl.access$scheduleAutoScrollIfNeeded(this.a, this.b, this.c);
            }

            @Override // com.avito.android.brandspace.items.carousel.CarouselItemView.Listener
            public void onHeightChanged(int i2) {
                this.a.getPresenter().onCarouselHeightChanged(i2, this.b);
            }
        });
        if (carouselItem.getNeedAutoScroll()) {
            carouselItemView.scheduleScrollToNextPage(this.b);
        }
    }
}
