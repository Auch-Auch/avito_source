package com.avito.android.favorite_sellers.adapter.advert_list.di;

import a2.b.a.a.a;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert.viewed.ViewedAdvertsPresenterImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenterImpl;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemBlueprint;
import com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemPresenter;
import com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemPresenterImpl;
import com.avito.android.section.item.SectionAdvertItemBlueprintImpl;
import com.avito.android.section.item.SectionAdvertItemDoubleBlueprintImpl;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import dagger.multibindings.IntoSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u000b\u001a\u00020\u00022\u001b\b\u0001\u0010\n\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b¢\u0006\u0002\b\t0\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b0\u0007H\u0007¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/advert_list/di/AdvertListItemModule;", "", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "provideItemBinder", "(Ljava/util/Set;)Lcom/avito/konveyor/ItemBinder;", "provideItemBlueprints", "()Ljava/util/Set;", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "favoriteAdvertsInteractor", "Lcom/avito/android/favorite/FavoriteAdvertsResourceProvider;", "resourceProvider", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "provideFavoriteAdvertsPresenter", "(Lcom/avito/android/favorite/FavoriteAdvertsInteractor;Lcom/avito/android/favorite/FavoriteAdvertsResourceProvider;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "viewedAdvertsInteractor", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "provideViewedAdvertsPresenter", "(Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "<init>", "()V", "Declarations", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class AdvertListItemModule {
    @NotNull
    public static final AdvertListItemModule INSTANCE = new AdvertListItemModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/advert_list/di/AdvertListItemModule$Declarations;", "", "Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindBlueprint", "(Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenterImpl;", "presenter", "Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenter;", "bindPresenter", "(Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenterImpl;)Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenter;", "Lcom/avito/android/section/item/SectionAdvertItemBlueprintImpl;", "bindRecommendationAdvertItemBlueprint", "(Lcom/avito/android/section/item/SectionAdvertItemBlueprintImpl;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/section/item/SectionAdvertItemDoubleBlueprintImpl;", "bindRecommendationAdvertItemDoubleBlueprint", "(Lcom/avito/android/section/item/SectionAdvertItemDoubleBlueprintImpl;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindBlueprint(@NotNull AdvertListItemBlueprint advertListItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        AdvertListItemPresenter bindPresenter(@NotNull AdvertListItemPresenterImpl advertListItemPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        @ForAdvertList
        ItemBlueprint<?, ?> bindRecommendationAdvertItemBlueprint(@NotNull SectionAdvertItemBlueprintImpl sectionAdvertItemBlueprintImpl);

        @Binds
        @IntoSet
        @NotNull
        @ForAdvertList
        ItemBlueprint<?, ?> bindRecommendationAdvertItemDoubleBlueprint(@NotNull SectionAdvertItemDoubleBlueprintImpl sectionAdvertItemDoubleBlueprintImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @ForAdvertList
    public static final AdapterPresenter provideAdapterPresenter(@ForAdvertList @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @ForAdvertList
    public static final FavoriteAdvertsPresenter provideFavoriteAdvertsPresenter(@NotNull FavoriteAdvertsInteractor favoriteAdvertsInteractor, @NotNull FavoriteAdvertsResourceProvider favoriteAdvertsResourceProvider, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsInteractor, "favoriteAdvertsInteractor");
        Intrinsics.checkNotNullParameter(favoriteAdvertsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        return new FavoriteAdvertsPresenterImpl(favoriteAdvertsInteractor, favoriteAdvertsResourceProvider, schedulersFactory3);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    @ForAdvertList
    public static final ItemBinder provideItemBinder(@ForAdvertList @NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            builder = builder.registerItem(it.next());
        }
        return builder.build();
    }

    @ElementsIntoSet
    @NotNull
    @Provides
    @JvmStatic
    @PerFragment
    @ForAdvertList
    public static final Set<ItemBlueprint<?, ?>> provideItemBlueprints() {
        return y.emptySet();
    }

    @Provides
    @JvmStatic
    @NotNull
    @ForAdvertList
    public static final ViewedAdvertsPresenter provideViewedAdvertsPresenter(@NotNull ViewedAdvertsEventInteractor viewedAdvertsEventInteractor, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(viewedAdvertsEventInteractor, "viewedAdvertsInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        return new ViewedAdvertsPresenterImpl(viewedAdvertsEventInteractor, schedulersFactory3);
    }
}
