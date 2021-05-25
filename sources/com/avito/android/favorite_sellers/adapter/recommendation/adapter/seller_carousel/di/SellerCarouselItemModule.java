package com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.di;

import com.avito.android.favorite_sellers.adapter.recommendation.ForRecommendation;
import com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemBlueprint;
import com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemPresenter;
import com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemPresenterImpl;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/di/SellerCarouselItemModule;", "", "<init>", "()V", "Declarations", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class SellerCarouselItemModule {
    @NotNull
    public static final SellerCarouselItemModule INSTANCE = new SellerCarouselItemModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/di/SellerCarouselItemModule$Declarations;", "", "Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/SellerCarouselItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindBlueprint", "(Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/SellerCarouselItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/SellerCarouselItemPresenterImpl;", "presenter", "Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/SellerCarouselItemPresenter;", "bindSellerCarouselPresenter", "(Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/SellerCarouselItemPresenterImpl;)Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/SellerCarouselItemPresenter;", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        @ForRecommendation
        ItemBlueprint<?, ?> bindBlueprint(@NotNull SellerCarouselItemBlueprint sellerCarouselItemBlueprint);

        @Binds
        @NotNull
        SellerCarouselItemPresenter bindSellerCarouselPresenter(@NotNull SellerCarouselItemPresenterImpl sellerCarouselItemPresenterImpl);
    }
}
