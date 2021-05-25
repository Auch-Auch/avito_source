package com.avito.android.favorite_sellers.adapter.recommendation.advert_details.di;

import a2.b.a.a.a;
import com.avito.android.di.PerFragment;
import com.avito.android.favorite_sellers.adapter.recommendation.ForRecommendation;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenterImpl;
import com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.di.SellerCarouselItemModule;
import com.avito.android.favorite_sellers.adapter.recommendation.advert_details.AdvertDetailsRecommendationItemBlueprint;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u000b\u001a\u00020\u00022\u001b\b\u0001\u0010\n\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b¢\u0006\u0002\b\t0\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/recommendation/advert_details/di/AdvertDetailsRecommendationItemModule;", "", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "provideItemBinder", "(Ljava/util/Set;)Lcom/avito/konveyor/ItemBinder;", "<init>", "()V", "Declarations", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, SellerCarouselItemModule.class})
public final class AdvertDetailsRecommendationItemModule {
    @NotNull
    public static final AdvertDetailsRecommendationItemModule INSTANCE = new AdvertDetailsRecommendationItemModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/recommendation/advert_details/di/AdvertDetailsRecommendationItemModule$Declarations;", "", "Lcom/avito/android/favorite_sellers/adapter/recommendation/advert_details/AdvertDetailsRecommendationItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindBlueprint", "(Lcom/avito/android/favorite_sellers/adapter/recommendation/advert_details/AdvertDetailsRecommendationItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenterImpl;", "presenter", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter;", "bindRecommendationPresenter", "(Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenterImpl;)Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter;", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        ItemBlueprint<?, ?> bindBlueprint(@NotNull AdvertDetailsRecommendationItemBlueprint advertDetailsRecommendationItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        RecommendationItemPresenter bindRecommendationPresenter(@NotNull RecommendationItemPresenterImpl recommendationItemPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @ForRecommendation
    public static final AdapterPresenter provideAdapterPresenter(@ForRecommendation @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @ForRecommendation
    @PerFragment
    public static final ItemBinder provideItemBinder(@ForRecommendation @NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            builder = builder.registerItem(it.next());
        }
        return builder.build();
    }
}
