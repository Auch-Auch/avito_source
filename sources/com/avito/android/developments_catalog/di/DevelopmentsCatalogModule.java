package com.avito.android.developments_catalog.di;

import a2.b.a.a.a;
import com.avito.android.advert_core.map.MapBlueprint;
import com.avito.android.advert_core.map.di.MapModule;
import com.avito.android.analytics.Analytics;
import com.avito.android.developments_catalog.DevelopmentsCatalogInteractor;
import com.avito.android.developments_catalog.DevelopmentsCatalogInteractorImpl;
import com.avito.android.developments_catalog.DevelopmentsCatalogPresenter;
import com.avito.android.developments_catalog.DevelopmentsCatalogPresenterImpl;
import com.avito.android.developments_catalog.analytics.DevelopmentsCatalogAnalyticsInteractor;
import com.avito.android.developments_catalog.analytics.DevelopmentsCatalogAnalyticsInteractorImpl;
import com.avito.android.developments_catalog.items.address.di.AddressModule;
import com.avito.android.developments_catalog.items.alert.AlertBannerModule;
import com.avito.android.developments_catalog.items.avitoOffers.di.AvitoOffersModule;
import com.avito.android.developments_catalog.items.buildingProgress.di.BuildingProgressModule;
import com.avito.android.developments_catalog.items.consultation.di.ConsultationModule;
import com.avito.android.developments_catalog.items.contactbar.di.ContactsModule;
import com.avito.android.developments_catalog.items.description.DescriptionExpandListener;
import com.avito.android.developments_catalog.items.description.di.DescriptionModule;
import com.avito.android.developments_catalog.items.disclaimer.DisclaimerDetailsClickListener;
import com.avito.android.developments_catalog.items.disclaimer.di.DisclaimerModule;
import com.avito.android.developments_catalog.items.divider.di.DividerModule;
import com.avito.android.developments_catalog.items.gap.GapModule;
import com.avito.android.developments_catalog.items.infoParams.di.InfoParamsModule;
import com.avito.android.developments_catalog.items.metro.di.MetroModule;
import com.avito.android.developments_catalog.items.params.di.ParamsModule;
import com.avito.android.developments_catalog.items.photoGallery.di.PhotoGalleryModule;
import com.avito.android.developments_catalog.items.skeleton.di.SkeletonModule;
import com.avito.android.developments_catalog.items.title.di.TitleModule;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerFragment;
import com.avito.android.photo_gallery.common.GalleryPageListener;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.DestroyableViewHolderBuilderImpl;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001 B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ4\u0010\t\u001a\u00020\b2\u001b\b\u0001\u0010\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\b\u00040\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0016\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\bH\u0001¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/avito/android/developments_catalog/di/DevelopmentsCatalogModule;", "", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "Lcom/avito/android/advert_core/map/MapBlueprint;", "mapBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "(Ljava/util/Set;Lcom/avito/android/advert_core/map/MapBlueprint;)Lcom/avito/konveyor/ItemBinder;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "presenter", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "destroyableViewHolderBuilder", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "provideSafeRecyclerAdapter$developments_catalog_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "provideSafeRecyclerAdapter", "itemBinder", "provideAdapterPresenter$developments_catalog_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "provideDestroyableViewHolderBuilder$developments_catalog_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder", "<init>", "()V", "Declarations", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {PhoneNumberFormatterModule.class, Declarations.class, SkeletonModule.class, TitleModule.class, InfoParamsModule.class, PhotoGalleryModule.class, ContactsModule.class, MetroModule.class, AddressModule.class, MapModule.class, AvitoOffersModule.class, ParamsModule.class, DescriptionModule.class, GapModule.class, DividerModule.class, DisclaimerModule.class, BuildingProgressModule.class, AlertBannerModule.class, DialogRouterModule.class, ConsultationModule.class})
public final class DevelopmentsCatalogModule {
    @NotNull
    public static final DevelopmentsCatalogModule INSTANCE = new DevelopmentsCatalogModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J%\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tH'¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\tH'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\tH'¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/developments_catalog/di/DevelopmentsCatalogModule$Declarations;", "", "Lcom/avito/android/util/Formatter;", "", "formatter", "bindPriceFormatter", "(Lcom/avito/android/util/Formatter;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenterImpl;", "presenter", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenter;", "bindPresenter", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenterImpl;)Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenter;", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogInteractorImpl;", "interactor", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogInteractor;", "bindInteractor", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogInteractorImpl;)Lcom/avito/android/developments_catalog/DevelopmentsCatalogInteractor;", "Lcom/avito/android/developments_catalog/analytics/DevelopmentsCatalogAnalyticsInteractorImpl;", "Lcom/avito/android/developments_catalog/analytics/DevelopmentsCatalogAnalyticsInteractor;", "bindAnalyticsInteractor", "(Lcom/avito/android/developments_catalog/analytics/DevelopmentsCatalogAnalyticsInteractorImpl;)Lcom/avito/android/developments_catalog/analytics/DevelopmentsCatalogAnalyticsInteractor;", "Lcom/avito/android/developments_catalog/items/disclaimer/DisclaimerDetailsClickListener;", "bindDisclaimerDetailsClickListener", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenter;)Lcom/avito/android/developments_catalog/items/disclaimer/DisclaimerDetailsClickListener;", "Lcom/avito/android/developments_catalog/items/description/DescriptionExpandListener;", "bindDescriptionExpandListener", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenter;)Lcom/avito/android/developments_catalog/items/description/DescriptionExpandListener;", "Lcom/avito/android/photo_gallery/common/GalleryPageListener;", "bindGalleryPageListener", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenter;)Lcom/avito/android/photo_gallery/common/GalleryPageListener;", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        DevelopmentsCatalogAnalyticsInteractor bindAnalyticsInteractor(@NotNull DevelopmentsCatalogAnalyticsInteractorImpl developmentsCatalogAnalyticsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        DescriptionExpandListener bindDescriptionExpandListener(@NotNull DevelopmentsCatalogPresenter developmentsCatalogPresenter);

        @PerFragment
        @Binds
        @NotNull
        DisclaimerDetailsClickListener bindDisclaimerDetailsClickListener(@NotNull DevelopmentsCatalogPresenter developmentsCatalogPresenter);

        @PerFragment
        @Binds
        @NotNull
        GalleryPageListener bindGalleryPageListener(@NotNull DevelopmentsCatalogPresenter developmentsCatalogPresenter);

        @PerFragment
        @Binds
        @NotNull
        DevelopmentsCatalogInteractor bindInteractor(@NotNull DevelopmentsCatalogInteractorImpl developmentsCatalogInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        DevelopmentsCatalogPresenter bindPresenter(@NotNull DevelopmentsCatalogPresenterImpl developmentsCatalogPresenterImpl);

        @Binds
        @NotNull
        @PerFragment
        Formatter<String> bindPriceFormatter(@PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode @NotNull Formatter<String> formatter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter$developments_catalog_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DestroyableViewHolderBuilder provideDestroyableViewHolderBuilder$developments_catalog_release(@NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new DestroyableViewHolderBuilderImpl(itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder(@DevelopmentsCatalogBlueprints @NotNull Set<ItemBlueprint<?, ?>> set, @NotNull MapBlueprint mapBlueprint) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        Intrinsics.checkNotNullParameter(mapBlueprint, "mapBlueprint");
        ItemBinder.Builder registerItem = new ItemBinder.Builder().registerItem(mapBlueprint);
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            registerItem.registerItem(it.next());
        }
        return registerItem.build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SafeRecyclerAdapter provideSafeRecyclerAdapter$developments_catalog_release(@NotNull AdapterPresenter adapterPresenter, @NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder, @NotNull BuildInfo buildInfo, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "presenter");
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder, "destroyableViewHolderBuilder");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new SafeRecyclerAdapter(adapterPresenter, destroyableViewHolderBuilder, buildInfo, analytics);
    }
}
