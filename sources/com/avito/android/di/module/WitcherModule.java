package com.avito.android.di.module;

import a2.b.a.a.a;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert.viewed.ViewedAdvertsPresenterImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenterImpl;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.serp.adapter.AdvertItemGridBlueprint;
import com.avito.android.serp.adapter.witcher.WitcherAnalyticsInteractor;
import com.avito.android.serp.adapter.witcher.WitcherAnalyticsInteractorImpl;
import com.avito.android.serp.adapter.witcher.WitcherItemPresenter;
import com.avito.android.serp.adapter.witcher.WitcherItemPresenterImpl;
import com.avito.android.serp.adapter.witcher.WitcherResourceProvider;
import com.avito.android.serp.adapter.witcher.WitcherResourceProviderImpl;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/avito/android/di/module/WitcherModule;", "", "Lcom/avito/android/serp/adapter/AdvertItemGridBlueprint;", "advertItemGridBlueprint", "Lcom/avito/konveyor/ItemBinder;", "providesWitcherItemsBinder", "(Lcom/avito/android/serp/adapter/AdvertItemGridBlueprint;)Lcom/avito/konveyor/ItemBinder;", "itemsBinder", "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "provideWitcherAdapter$serp_core_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "provideWitcherAdapter", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "favoriteAdvertsInteractor", "Lcom/avito/android/favorite/FavoriteAdvertsResourceProvider;", "resourceProvider", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "provideWitcherFavoriteAdvertsPresenter$serp_core_release", "(Lcom/avito/android/favorite/FavoriteAdvertsInteractor;Lcom/avito/android/favorite/FavoriteAdvertsResourceProvider;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "provideWitcherFavoriteAdvertsPresenter", "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "viewedAdvertsInteractor", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "provideWitcherViewedAdvertsPresenter$serp_core_release", "(Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "provideWitcherViewedAdvertsPresenter", "<init>", "()V", "Declarations", "WitcherItemsSavedState", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class WitcherModule {
    @NotNull
    public static final WitcherModule INSTANCE = new WitcherModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/di/module/WitcherModule$Declarations;", "", "Lcom/avito/android/serp/adapter/witcher/WitcherResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/serp/adapter/witcher/WitcherResourceProvider;", "bindsWitcherResourceProvider", "(Lcom/avito/android/serp/adapter/witcher/WitcherResourceProviderImpl;)Lcom/avito/android/serp/adapter/witcher/WitcherResourceProvider;", "Lcom/avito/android/serp/adapter/witcher/WitcherAnalyticsInteractorImpl;", "interactor", "Lcom/avito/android/serp/adapter/witcher/WitcherAnalyticsInteractor;", "bindsAnalyticsInteractor", "(Lcom/avito/android/serp/adapter/witcher/WitcherAnalyticsInteractorImpl;)Lcom/avito/android/serp/adapter/witcher/WitcherAnalyticsInteractor;", "Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenterImpl;", "presenter", "Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;", "bindWitcherItemPresenter", "(Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenterImpl;)Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Reusable
        @Binds
        @NotNull
        WitcherItemPresenter bindWitcherItemPresenter(@NotNull WitcherItemPresenterImpl witcherItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        WitcherAnalyticsInteractor bindsAnalyticsInteractor(@NotNull WitcherAnalyticsInteractorImpl witcherAnalyticsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        WitcherResourceProvider bindsWitcherResourceProvider(@NotNull WitcherResourceProviderImpl witcherResourceProviderImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/di/module/WitcherModule$WitcherItemsSavedState;", "", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface WitcherItemsSavedState {
    }

    @WitcherAdapter
    @Provides
    @NotNull
    public final SimpleAdapterPresenter provideWitcherAdapter$serp_core_release(@WitcherItemBinder @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemsBinder", itemBinder, itemBinder);
    }

    @Provides
    @WitcherFavoriteAdverts
    @NotNull
    public final FavoriteAdvertsPresenter provideWitcherFavoriteAdvertsPresenter$serp_core_release(@NotNull FavoriteAdvertsInteractor favoriteAdvertsInteractor, @NotNull FavoriteAdvertsResourceProvider favoriteAdvertsResourceProvider, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(favoriteAdvertsInteractor, "favoriteAdvertsInteractor");
        Intrinsics.checkNotNullParameter(favoriteAdvertsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        return new FavoriteAdvertsPresenterImpl(favoriteAdvertsInteractor, favoriteAdvertsResourceProvider, schedulersFactory3);
    }

    @Provides
    @WitcherViewedAdverts
    @NotNull
    public final ViewedAdvertsPresenter provideWitcherViewedAdvertsPresenter$serp_core_release(@NotNull ViewedAdvertsEventInteractor viewedAdvertsEventInteractor, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(viewedAdvertsEventInteractor, "viewedAdvertsInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        return new ViewedAdvertsPresenterImpl(viewedAdvertsEventInteractor, schedulersFactory3);
    }

    @Provides
    @NotNull
    @PerFragment
    @WitcherItemBinder
    public final ItemBinder providesWitcherItemsBinder(@NotNull AdvertItemGridBlueprint advertItemGridBlueprint) {
        Intrinsics.checkNotNullParameter(advertItemGridBlueprint, "advertItemGridBlueprint");
        return new ItemBinder.Builder().registerItem(advertItemGridBlueprint).build();
    }
}
