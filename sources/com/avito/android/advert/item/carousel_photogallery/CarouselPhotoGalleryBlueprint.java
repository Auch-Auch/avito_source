package com.avito.android.advert.item.carousel_photogallery;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.advert_details.R;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryView;", "Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryPresenter;", "getPresenter", "()Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryPresenter;", "presenter", "Lcom/avito/android/util/ImplicitIntentFactory;", "c", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryPresenter;Lcom/avito/android/util/ImplicitIntentFactory;Lcom/avito/android/analytics/Analytics;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class CarouselPhotoGalleryBlueprint implements ItemBlueprint<CarouselPhotoGalleryView, CarouselPhotoGalleryItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<CarouselPhotoGalleryViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.advert_details_carousel_photo_gallery, new a(this));
    @NotNull
    public final CarouselPhotoGalleryPresenter b;
    public final ImplicitIntentFactory c;
    public final Analytics d;

    public static final class a extends Lambda implements Function2<ViewGroup, View, CarouselPhotoGalleryViewImpl> {
        public final /* synthetic */ CarouselPhotoGalleryBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CarouselPhotoGalleryBlueprint carouselPhotoGalleryBlueprint) {
            super(2);
            this.a = carouselPhotoGalleryBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public CarouselPhotoGalleryViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new CarouselPhotoGalleryViewImpl(view2, this.a.c, this.a.d, false, 1, 8, null);
        }
    }

    @Inject
    public CarouselPhotoGalleryBlueprint(@NotNull CarouselPhotoGalleryPresenter carouselPhotoGalleryPresenter, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(carouselPhotoGalleryPresenter, "presenter");
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "implicitIntentFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = carouselPhotoGalleryPresenter;
        this.c = implicitIntentFactory;
        this.d = analytics;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<CarouselPhotoGalleryViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof CarouselPhotoGalleryItem;
    }

    /* Return type fixed from 'com.avito.android.advert.item.carousel_photogallery.CarouselPhotoGalleryPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<CarouselPhotoGalleryView, CarouselPhotoGalleryItem> getPresenter() {
        return this.b;
    }
}
