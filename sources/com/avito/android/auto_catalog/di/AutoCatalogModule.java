package com.avito.android.auto_catalog.di;

import a2.b.a.a.a;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.analytics.Analytics;
import com.avito.android.auto_catalog.AutoCatalogInteractor;
import com.avito.android.auto_catalog.AutoCatalogInteractorImpl;
import com.avito.android.auto_catalog.AutoCatalogPresenter;
import com.avito.android.auto_catalog.AutoCatalogPresenterImpl;
import com.avito.android.auto_catalog.analytics.AutoCatalogAnalyticsInteractor;
import com.avito.android.auto_catalog.analytics.AutoCatalogAnalyticsInteractorImpl;
import com.avito.android.auto_catalog.items.AutoCatalogResourceProvider;
import com.avito.android.auto_catalog.items.AutoCatalogResourceProviderImpl;
import com.avito.android.auto_catalog.items.gap.GapModule;
import com.avito.android.auto_catalog.items.image.di.ImageModule;
import com.avito.android.auto_catalog.items.serp.di.SerpModule;
import com.avito.android.auto_catalog.items.skeleton.di.SkeletonModule;
import com.avito.android.auto_catalog.items.specs_selector.di.SpecsSelectorModule;
import com.avito.android.auto_catalog.items.title.di.TitleModule;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.AdvertItemModule;
import com.avito.android.di.module.DateTimeFormatterModule;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule;
import com.avito.android.di.module.SerpItemConverterModule;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.DestroyableViewHolderBuilderImpl;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl;
import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.ad.AdResourceProviderImpl;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.GridPositionProviderImpl;
import com.avito.android.serp.adapter.RdsAdvertGridItemBlueprint;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SerpSpanProviderImpl;
import com.avito.android.serp.adapter.SpanLookup;
import com.avito.android.serp.adapter.SpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004+,-.B\t\b\u0002¢\u0006\u0004\b)\u0010*J4\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u001b\b\u0001\u0010\u0007\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005¢\u0006\u0002\b\u00060\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0016\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\bH\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010#\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0001¢\u0006\u0004\b!\u0010\"J\u001f\u0010(\u001a\u00020%2\u0006\u0010$\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0001¢\u0006\u0004\b&\u0010'¨\u0006/"}, d2 = {"Lcom/avito/android/auto_catalog/di/AutoCatalogModule;", "", "Lcom/avito/android/serp/adapter/RdsAdvertGridItemBlueprint;", "rdsAdvertGridItemBlueprint", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "(Lcom/avito/android/serp/adapter/RdsAdvertGridItemBlueprint;Ljava/util/Set;)Lcom/avito/konveyor/ItemBinder;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "presenter", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "destroyableViewHolderBuilder", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "provideSafeRecyclerAdapter$auto_catalog_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "provideSafeRecyclerAdapter", "itemBinder", "provideAdapterPresenter$auto_catalog_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "provideDestroyableViewHolderBuilder$auto_catalog_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder", "Lcom/avito/android/auto_catalog/items/AutoCatalogResourceProvider;", "autoCatalogResourceProvider", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "provideGridPositionProvider$auto_catalog_release", "(Lcom/avito/android/auto_catalog/items/AutoCatalogResourceProvider;)Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "provideGridPositionProvider", "gridPositionProvider", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "provideSpanProvider$auto_catalog_release", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Lcom/avito/android/auto_catalog/items/AutoCatalogResourceProvider;)Lcom/avito/android/serp/adapter/SerpSpanProvider;", "provideSpanProvider", "<init>", "()V", "AutoCatalogBlueprints", "Declarations", "FromScreen", "SearchContext", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, DateTimeFormatterModule.class, AdvertItemModule.class, FavoriteAdvertsPresenterModule.class, SerpItemConverterModule.class, SkeletonModule.class, TitleModule.class, ImageModule.class, GapModule.class, SpecsSelectorModule.class, SerpModule.class})
public final class AutoCatalogModule {
    @NotNull
    public static final AutoCatalogModule INSTANCE = new AutoCatalogModule();

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/auto_catalog/di/AutoCatalogModule$AutoCatalogBlueprints;", "", "<init>", "()V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface AutoCatalogBlueprints {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u000eH'¢\u0006\u0004\b \u0010!J\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"H'¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020'H'¢\u0006\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/avito/android/auto_catalog/di/AutoCatalogModule$Declarations;", "", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", GeoContract.PROVIDER, "Lcom/avito/android/serp/adapter/SpanProvider;", "bindSpanProvider", "(Lcom/avito/android/serp/adapter/SerpSpanProvider;)Lcom/avito/android/serp/adapter/SpanProvider;", "Lcom/avito/android/serp/adapter/SpanLookup;", "lookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "bindSpanLookup", "(Lcom/avito/android/serp/adapter/SpanLookup;)Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "Lcom/avito/android/auto_catalog/AutoCatalogPresenterImpl;", "presenter", "Lcom/avito/android/auto_catalog/AutoCatalogPresenter;", "bindPresenter", "(Lcom/avito/android/auto_catalog/AutoCatalogPresenterImpl;)Lcom/avito/android/auto_catalog/AutoCatalogPresenter;", "Lcom/avito/android/auto_catalog/AutoCatalogInteractorImpl;", "interactor", "Lcom/avito/android/auto_catalog/AutoCatalogInteractor;", "bindInteractor", "(Lcom/avito/android/auto_catalog/AutoCatalogInteractorImpl;)Lcom/avito/android/auto_catalog/AutoCatalogInteractor;", "Lcom/avito/android/auto_catalog/analytics/AutoCatalogAnalyticsInteractorImpl;", "Lcom/avito/android/auto_catalog/analytics/AutoCatalogAnalyticsInteractor;", "bindAnalyticsInteractor", "(Lcom/avito/android/auto_catalog/analytics/AutoCatalogAnalyticsInteractorImpl;)Lcom/avito/android/auto_catalog/analytics/AutoCatalogAnalyticsInteractor;", "Lcom/avito/android/auto_catalog/items/AutoCatalogResourceProviderImpl;", "resourceProvider", "Lcom/avito/android/auto_catalog/items/AutoCatalogResourceProvider;", "bindResourceProvider", "(Lcom/avito/android/auto_catalog/items/AutoCatalogResourceProviderImpl;)Lcom/avito/android/auto_catalog/items/AutoCatalogResourceProvider;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "bindAdvertItemListener", "(Lcom/avito/android/auto_catalog/AutoCatalogPresenter;)Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/remote/model/SearchParamsConverterImpl;", "converter", "Lcom/avito/android/remote/model/SearchParamsConverter;", "provideSearchParamsConverter", "(Lcom/avito/android/remote/model/SearchParamsConverterImpl;)Lcom/avito/android/remote/model/SearchParamsConverter;", "Lcom/avito/android/serp/ad/AdResourceProviderImpl;", "Lcom/avito/android/serp/ad/AdResourceProvider;", "bindAdResourceProvider", "(Lcom/avito/android/serp/ad/AdResourceProviderImpl;)Lcom/avito/android/serp/ad/AdResourceProvider;", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        AdResourceProvider bindAdResourceProvider(@NotNull AdResourceProviderImpl adResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertItemListener bindAdvertItemListener(@NotNull AutoCatalogPresenter autoCatalogPresenter);

        @PerFragment
        @Binds
        @NotNull
        AutoCatalogAnalyticsInteractor bindAnalyticsInteractor(@NotNull AutoCatalogAnalyticsInteractorImpl autoCatalogAnalyticsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        AutoCatalogInteractor bindInteractor(@NotNull AutoCatalogInteractorImpl autoCatalogInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        AutoCatalogPresenter bindPresenter(@NotNull AutoCatalogPresenterImpl autoCatalogPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        AutoCatalogResourceProvider bindResourceProvider(@NotNull AutoCatalogResourceProviderImpl autoCatalogResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        GridLayoutManager.SpanSizeLookup bindSpanLookup(@NotNull SpanLookup spanLookup);

        @PerFragment
        @Binds
        @NotNull
        SpanProvider bindSpanProvider(@NotNull SerpSpanProvider serpSpanProvider);

        @PerFragment
        @Binds
        @NotNull
        SearchParamsConverter provideSearchParamsConverter(@NotNull SearchParamsConverterImpl searchParamsConverterImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/auto_catalog/di/AutoCatalogModule$FromScreen;", "", "<init>", "()V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface FromScreen {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/auto_catalog/di/AutoCatalogModule$SearchContext;", "", "<init>", "()V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface SearchContext {
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$auto_catalog_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DestroyableViewHolderBuilder provideDestroyableViewHolderBuilder$auto_catalog_release(@NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new DestroyableViewHolderBuilderImpl(itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SpannedGridPositionProvider provideGridPositionProvider$auto_catalog_release(@NotNull AutoCatalogResourceProvider autoCatalogResourceProvider) {
        Intrinsics.checkNotNullParameter(autoCatalogResourceProvider, "autoCatalogResourceProvider");
        return new GridPositionProviderImpl(autoCatalogResourceProvider.spanCount());
    }

    @Provides
    @NotNull
    @PerFragment
    public final ItemBinder provideItemBinder(@NotNull RdsAdvertGridItemBlueprint rdsAdvertGridItemBlueprint, @AutoCatalogBlueprints @NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(rdsAdvertGridItemBlueprint, "rdsAdvertGridItemBlueprint");
        Intrinsics.checkNotNullParameter(set, "blueprints");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        builder.registerItem(rdsAdvertGridItemBlueprint);
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            builder.registerItem(it.next());
        }
        return builder.build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final SafeRecyclerAdapter provideSafeRecyclerAdapter$auto_catalog_release(@NotNull AdapterPresenter adapterPresenter, @NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder, @NotNull BuildInfo buildInfo, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "presenter");
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder, "destroyableViewHolderBuilder");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new SafeRecyclerAdapter(adapterPresenter, destroyableViewHolderBuilder, buildInfo, analytics);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SerpSpanProvider provideSpanProvider$auto_catalog_release(@NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull AutoCatalogResourceProvider autoCatalogResourceProvider) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(autoCatalogResourceProvider, "autoCatalogResourceProvider");
        return new SerpSpanProviderImpl(autoCatalogResourceProvider.spanCount(), spannedGridPositionProvider);
    }
}
