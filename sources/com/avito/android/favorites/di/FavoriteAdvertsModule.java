package com.avito.android.favorites.di;

import a2.b.a.a.a;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.DateTimeFormatterModule;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.favorites.FavoriteAdvertItemConverter;
import com.avito.android.favorites.FavoriteAdvertItemConverterImpl;
import com.avito.android.favorites.FavoriteAdvertItemConverterResourceProvider;
import com.avito.android.favorites.FavoriteAdvertItemConverterResourceProviderImpl;
import com.avito.android.favorites.FavoriteAdvertsListInteractorImpl;
import com.avito.android.favorites.FavoriteListResourceProvider;
import com.avito.android.favorites.FavoriteListResourceProviderImpl;
import com.avito.android.favorites.FavoriteResourceProvider;
import com.avito.android.favorites.FavoriteResourceProviderImpl;
import com.avito.android.favorites.FavoriteStorage;
import com.avito.android.favorites.FavoritesListInteractor;
import com.avito.android.favorites.FavoritesListPresenter;
import com.avito.android.favorites.FavoritesListPresenterImpl;
import com.avito.android.favorites.PrefFavoriteStorage;
import com.avito.android.favorites.action.FavoriteItemAction;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemBlueprint;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenter;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenterImpl;
import com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemBlueprint;
import com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenter;
import com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenterImpl;
import com.avito.android.favorites.adapter.error.FavoriteErrorItemBlueprint;
import com.avito.android.favorites.adapter.error.FavoriteErrorItemPresenter;
import com.avito.android.favorites.adapter.error.FavoriteErrorItemPresenterImpl;
import com.avito.android.favorites.adapter.loading.FavoriteLoadingItemBlueprint;
import com.avito.android.favorites.adapter.loading.FavoriteLoadingItemPresenter;
import com.avito.android.favorites.adapter.loading.FavoriteLoadingItemPresenterImpl;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.util.AdvertPriceFormatter;
import com.avito.android.util.Formatter;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ9\u0010\u000f\u001a\u00020\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/avito/android/favorites/di/FavoriteAdvertsModule;", "", "", "canBuyerAskSellerTtlItem", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemBlueprint;", "advertItemBlueprint", "Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemBlueprint;", "testAdvertItemBlueprint", "Lcom/avito/android/favorites/adapter/loading/FavoriteLoadingItemBlueprint;", "loadingItemBlueprint", "Lcom/avito/android/favorites/adapter/error/FavoriteErrorItemBlueprint;", "errorLoadingBluePrint", "Lcom/avito/konveyor/ItemBinder;", "provideFavoriteItemBinder$favorites_release", "(ZLcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemBlueprint;Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemBlueprint;Lcom/avito/android/favorites/adapter/loading/FavoriteLoadingItemBlueprint;Lcom/avito/android/favorites/adapter/error/FavoriteErrorItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideFavoriteItemBinder", "favoritesItemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideFavoriteAdapterPresenter$favorites_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideFavoriteAdapterPresenter", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestSConfigProvider", "provideIsBuyerCanAskSellerTtlItem$favorites_release", "(Lcom/avito/android/Features;Lcom/avito/android/ab_tests/AbTestsConfigProvider;)Z", "provideIsBuyerCanAskSellerTtlItem", "<init>", "()V", "Declarations", "favorites_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DateTimeFormatterModule.class, Declarations.class, ErrorHelperModule.class})
public final class FavoriteAdvertsModule {
    @NotNull
    public static final FavoriteAdvertsModule INSTANCE = new FavoriteAdvertsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u001fH'¢\u0006\u0004\b \u0010!J\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"H'¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020'H'¢\u0006\u0004\b)\u0010*J\u0017\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020+H'¢\u0006\u0004\b.\u0010/J\u0017\u00103\u001a\u0002022\u0006\u00101\u001a\u000200H'¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u0002062\u0006\u0010\u001b\u001a\u000205H'¢\u0006\u0004\b7\u00108J\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020<0;2\u0006\u0010:\u001a\u000209H'¢\u0006\u0004\b=\u0010>J#\u0010C\u001a\b\u0012\u0004\u0012\u00020@0B2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020@0?H'¢\u0006\u0004\bC\u0010DJ#\u0010F\u001a\b\u0012\u0004\u0012\u00020@0E2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020@0?H'¢\u0006\u0004\bF\u0010G¨\u0006H"}, d2 = {"Lcom/avito/android/favorites/di/FavoriteAdvertsModule$Declarations;", "", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemPresenterImpl;", "presenter", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemPresenter;", "bindFavoriteAdvertItemPresenter", "(Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemPresenterImpl;)Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemPresenter;", "Lcom/avito/android/favorites/FavoritesListPresenter;", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemPresenter$Listener;", "bindFavoriteAdvertItemPresenterListener", "(Lcom/avito/android/favorites/FavoritesListPresenter;)Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemPresenter$Listener;", "Lcom/avito/android/favorites/adapter/loading/FavoriteLoadingItemPresenterImpl;", "Lcom/avito/android/favorites/adapter/loading/FavoriteLoadingItemPresenter;", "bindFavoriteLoadingItemPresenter", "(Lcom/avito/android/favorites/adapter/loading/FavoriteLoadingItemPresenterImpl;)Lcom/avito/android/favorites/adapter/loading/FavoriteLoadingItemPresenter;", "Lcom/avito/android/favorites/adapter/error/FavoriteErrorItemPresenterImpl;", "Lcom/avito/android/favorites/adapter/error/FavoriteErrorItemPresenter;", "bindFavoriteErrorItemPresenter", "(Lcom/avito/android/favorites/adapter/error/FavoriteErrorItemPresenterImpl;)Lcom/avito/android/favorites/adapter/error/FavoriteErrorItemPresenter;", "Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemPresenter$Listener;", "bindTestFavoriteAdvertItemPresenterListener", "(Lcom/avito/android/favorites/FavoritesListPresenter;)Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemPresenter$Listener;", "Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemPresenterImpl;", "Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemPresenter;", "bindTestFavoriteAdvertItemPresenter", "(Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemPresenterImpl;)Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemPresenter;", "Lcom/avito/android/favorites/FavoriteListResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/favorites/FavoriteListResourceProvider;", "bindFavoriteListResourceProvider", "(Lcom/avito/android/favorites/FavoriteListResourceProviderImpl;)Lcom/avito/android/favorites/FavoriteListResourceProvider;", "Lcom/avito/android/favorites/FavoritesListPresenterImpl;", "bindFavoritesListPresenter", "(Lcom/avito/android/favorites/FavoritesListPresenterImpl;)Lcom/avito/android/favorites/FavoritesListPresenter;", "Lcom/avito/android/favorites/FavoriteAdvertsListInteractorImpl;", "interactor", "Lcom/avito/android/favorites/FavoritesListInteractor;", "bindFavoritesListInteractor", "(Lcom/avito/android/favorites/FavoriteAdvertsListInteractorImpl;)Lcom/avito/android/favorites/FavoritesListInteractor;", "Lcom/avito/android/favorites/FavoriteResourceProviderImpl;", "Lcom/avito/android/favorites/FavoriteResourceProvider;", "bindFavoriteResourceProvider", "(Lcom/avito/android/favorites/FavoriteResourceProviderImpl;)Lcom/avito/android/favorites/FavoriteResourceProvider;", "Lcom/avito/android/favorites/PrefFavoriteStorage;", "storage", "Lcom/avito/android/favorites/FavoriteStorage;", "bindFavoriteStorage", "(Lcom/avito/android/favorites/PrefFavoriteStorage;)Lcom/avito/android/favorites/FavoriteStorage;", "Lcom/avito/android/favorites/FavoriteAdvertItemConverterImpl;", "converter", "Lcom/avito/android/favorites/FavoriteAdvertItemConverter;", "bindFavoriteAdvertItemConverter", "(Lcom/avito/android/favorites/FavoriteAdvertItemConverterImpl;)Lcom/avito/android/favorites/FavoriteAdvertItemConverter;", "Lcom/avito/android/favorites/FavoriteAdvertItemConverterResourceProviderImpl;", "Lcom/avito/android/favorites/FavoriteAdvertItemConverterResourceProvider;", "bindFavoriteAdvertItemConverterResourceProvider", "(Lcom/avito/android/favorites/FavoriteAdvertItemConverterResourceProviderImpl;)Lcom/avito/android/favorites/FavoriteAdvertItemConverterResourceProvider;", "Lcom/avito/android/util/AdvertPriceFormatter;", "formatter", "Lcom/avito/android/util/Formatter;", "Lcom/avito/android/remote/model/AdvertPrice;", "bindAdvertPriceFormatter", "(Lcom/avito/android/util/AdvertPriceFormatter;)Lcom/avito/android/util/Formatter;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/favorites/action/FavoriteItemAction;", "relay", "Lio/reactivex/Observable;", "bindActionObservable", "(Lcom/jakewharton/rxrelay2/PublishRelay;)Lio/reactivex/Observable;", "Lio/reactivex/functions/Consumer;", "bindActionConsumer", "(Lcom/jakewharton/rxrelay2/PublishRelay;)Lio/reactivex/functions/Consumer;", "favorites_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        @PerFragment
        Consumer<FavoriteItemAction> bindActionConsumer(@NotNull PublishRelay<FavoriteItemAction> publishRelay);

        @Binds
        @NotNull
        @PerFragment
        Observable<FavoriteItemAction> bindActionObservable(@NotNull PublishRelay<FavoriteItemAction> publishRelay);

        @Binds
        @NotNull
        @PerFragment
        Formatter<AdvertPrice> bindAdvertPriceFormatter(@NotNull AdvertPriceFormatter advertPriceFormatter);

        @PerFragment
        @Binds
        @NotNull
        FavoriteAdvertItemConverter bindFavoriteAdvertItemConverter(@NotNull FavoriteAdvertItemConverterImpl favoriteAdvertItemConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        FavoriteAdvertItemConverterResourceProvider bindFavoriteAdvertItemConverterResourceProvider(@NotNull FavoriteAdvertItemConverterResourceProviderImpl favoriteAdvertItemConverterResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        FavoriteAdvertItemPresenter bindFavoriteAdvertItemPresenter(@NotNull FavoriteAdvertItemPresenterImpl favoriteAdvertItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        FavoriteAdvertItemPresenter.Listener bindFavoriteAdvertItemPresenterListener(@NotNull FavoritesListPresenter favoritesListPresenter);

        @PerFragment
        @Binds
        @NotNull
        FavoriteErrorItemPresenter bindFavoriteErrorItemPresenter(@NotNull FavoriteErrorItemPresenterImpl favoriteErrorItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        FavoriteListResourceProvider bindFavoriteListResourceProvider(@NotNull FavoriteListResourceProviderImpl favoriteListResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        FavoriteLoadingItemPresenter bindFavoriteLoadingItemPresenter(@NotNull FavoriteLoadingItemPresenterImpl favoriteLoadingItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        FavoriteResourceProvider bindFavoriteResourceProvider(@NotNull FavoriteResourceProviderImpl favoriteResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        FavoriteStorage bindFavoriteStorage(@NotNull PrefFavoriteStorage prefFavoriteStorage);

        @PerFragment
        @Binds
        @NotNull
        FavoritesListInteractor bindFavoritesListInteractor(@NotNull FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        FavoritesListPresenter bindFavoritesListPresenter(@NotNull FavoritesListPresenterImpl favoritesListPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        TestFavoriteAdvertItemPresenter bindTestFavoriteAdvertItemPresenter(@NotNull TestFavoriteAdvertItemPresenterImpl testFavoriteAdvertItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        TestFavoriteAdvertItemPresenter.Listener bindTestFavoriteAdvertItemPresenterListener(@NotNull FavoritesListPresenter favoritesListPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideFavoriteAdapterPresenter$favorites_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "favoritesItemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideFavoriteItemBinder$favorites_release(@CanBuyerAskSellerItem boolean z, @NotNull FavoriteAdvertItemBlueprint favoriteAdvertItemBlueprint, @NotNull TestFavoriteAdvertItemBlueprint testFavoriteAdvertItemBlueprint, @NotNull FavoriteLoadingItemBlueprint favoriteLoadingItemBlueprint, @NotNull FavoriteErrorItemBlueprint favoriteErrorItemBlueprint) {
        Intrinsics.checkNotNullParameter(favoriteAdvertItemBlueprint, "advertItemBlueprint");
        Intrinsics.checkNotNullParameter(testFavoriteAdvertItemBlueprint, "testAdvertItemBlueprint");
        Intrinsics.checkNotNullParameter(favoriteLoadingItemBlueprint, "loadingItemBlueprint");
        Intrinsics.checkNotNullParameter(favoriteErrorItemBlueprint, "errorLoadingBluePrint");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        if (z) {
            builder.registerItem(testFavoriteAdvertItemBlueprint);
        } else {
            builder.registerItem(favoriteAdvertItemBlueprint);
        }
        builder.registerItem(favoriteLoadingItemBlueprint);
        builder.registerItem(favoriteErrorItemBlueprint);
        return builder.build();
    }

    @Provides
    @JvmStatic
    @CanBuyerAskSellerItem
    @PerFragment
    public static final boolean provideIsBuyerCanAskSellerTtlItem$favorites_release(@NotNull Features features, @NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestSConfigProvider");
        return features.getByuerAsksSellerTtlItem().invoke().booleanValue() && abTestsConfigProvider.buyerAsksSellerTtlItem().getTestGroup().isTest();
    }
}
