package com.avito.android.section.di;

import a2.b.a.a.a;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert.viewed.ViewedAdvertsPresenterImpl;
import com.avito.android.di.ViewedAdvertsModule;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenterImpl;
import com.avito.android.section.RdsSectionResourceProviderImpl;
import com.avito.android.section.SectionItem;
import com.avito.android.section.SectionItemView;
import com.avito.android.section.SectionResourceProvider;
import com.avito.android.section.SectionResourceProviderImpl;
import com.avito.android.section.complementary.ComplementaryResourceProviderImpl;
import com.avito.android.section.complementary.ComplementarySectionBlueprint;
import com.avito.android.section.complementary.ComplementaryTitleWithActionBlueprint;
import com.avito.android.section.item.ComplementaryAdvertItemBlueprint;
import com.avito.android.section.item.ComplementaryAdvertItemBlueprintImpl;
import com.avito.android.section.item.ComplementaryAdvertItemDoubleBlueprint;
import com.avito.android.section.item.ComplementaryAdvertItemDoubleBlueprintImpl;
import com.avito.android.section.item.SectionAdvertItemBlueprint;
import com.avito.android.section.item.SectionAdvertItemBlueprintImpl;
import com.avito.android.section.item.SectionAdvertItemDoubleBlueprint;
import com.avito.android.section.item.SectionAdvertItemDoubleBlueprintImpl;
import com.avito.android.section.item.SectionAdvertItemPresenter;
import com.avito.android.section.item.SectionAdvertItemPresenterImpl;
import com.avito.android.section.item.SectionItemWidthProvider;
import com.avito.android.section.item.SectionItemWidthProviderImpl;
import com.avito.android.section.title_with_action.SectionTitleWithActionItem;
import com.avito.android.section.title_with_action.SectionTitleWithActionItemView;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001(B\t\b\u0002¢\u0006\u0004\b&\u0010'J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000e\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0017\u001a\u00020\u00142\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0001\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001a\u001a\u00020\u00142\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0018\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0019\u0010\u0016J\u001f\u0010!\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b\u001f\u0010 J!\u0010#\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0001\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b\"\u0010 J!\u0010%\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0001\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b$\u0010 ¨\u0006)"}, d2 = {"Lcom/avito/android/section/di/SectionAdvertItemsModule;", "", "Lcom/avito/android/section/item/ComplementaryAdvertItemBlueprint;", "complementaryAdvertItemBlueprint", "Lcom/avito/android/section/item/ComplementaryAdvertItemDoubleBlueprint;", "complementaryAdvertItemDoubleBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideComplementarySectionItemBinder$serp_core_release", "(Lcom/avito/android/section/item/ComplementaryAdvertItemBlueprint;Lcom/avito/android/section/item/ComplementaryAdvertItemDoubleBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideComplementarySectionItemBinder", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideComplementaryTypeAdapterPresenter$serp_core_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideComplementaryTypeAdapterPresenter", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/section/item/SectionItemWidthProvider;", "complementaryItemWidthProvider", "Lcom/avito/android/section/item/SectionAdvertItemPresenter;", "provideComplementarySectionAdvertItemPresenter$serp_core_release", "(Ldagger/Lazy;Lcom/avito/android/section/item/SectionItemWidthProvider;)Lcom/avito/android/section/item/SectionAdvertItemPresenter;", "provideComplementarySectionAdvertItemPresenter", "recommendationItemWidthProvider", "provideSectionAdvertItemPresenter$serp_core_release", "provideSectionAdvertItemPresenter", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/section/SectionResourceProvider;", GeoContract.PROVIDER, "provideSectionItemWidthProvider$serp_core_release", "(Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/section/SectionResourceProvider;)Lcom/avito/android/section/item/SectionItemWidthProvider;", "provideSectionItemWidthProvider", "provideRdsSectionItemWidthProvider$serp_core_release", "provideRdsSectionItemWidthProvider", "provideComplementarySectionItemWidthProvider$serp_core_release", "provideComplementarySectionItemWidthProvider", "<init>", "()V", "Declarations", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {ViewedAdvertsModule.class, FavoriteAdvertsPresenterModule.class, Declarations.class})
public final class SectionAdvertItemsModule {
    @NotNull
    public static final SectionAdvertItemsModule INSTANCE = new SectionAdvertItemsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0010H'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0013H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\u0006\u0010\u0003\u001a\u00020\u001eH'¢\u0006\u0004\b\"\u0010#J#\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0\u001f2\u0006\u0010\u0003\u001a\u00020$H'¢\u0006\u0004\b'\u0010(J\u0017\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020)H'¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020/2\u0006\u0010*\u001a\u00020.H'¢\u0006\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/avito/android/section/di/SectionAdvertItemsModule$Declarations;", "", "Lcom/avito/android/section/item/SectionAdvertItemBlueprintImpl;", "blueprint", "Lcom/avito/android/section/item/SectionAdvertItemBlueprint;", "bindSectionAdvertItemBlueprint", "(Lcom/avito/android/section/item/SectionAdvertItemBlueprintImpl;)Lcom/avito/android/section/item/SectionAdvertItemBlueprint;", "Lcom/avito/android/section/item/SectionAdvertItemDoubleBlueprintImpl;", "Lcom/avito/android/section/item/SectionAdvertItemDoubleBlueprint;", "bindSectionAdvertItemDoubleBlueprint", "(Lcom/avito/android/section/item/SectionAdvertItemDoubleBlueprintImpl;)Lcom/avito/android/section/item/SectionAdvertItemDoubleBlueprint;", "Lcom/avito/android/section/SectionResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/section/SectionResourceProvider;", "bindSectionResourceProviderImpl", "(Lcom/avito/android/section/SectionResourceProviderImpl;)Lcom/avito/android/section/SectionResourceProvider;", "Lcom/avito/android/section/RdsSectionResourceProviderImpl;", "bindRdsSectionResourceProvider", "(Lcom/avito/android/section/RdsSectionResourceProviderImpl;)Lcom/avito/android/section/SectionResourceProvider;", "Lcom/avito/android/section/complementary/ComplementaryResourceProviderImpl;", "bindComplementaryResourceProvider", "(Lcom/avito/android/section/complementary/ComplementaryResourceProviderImpl;)Lcom/avito/android/section/SectionResourceProvider;", "Lcom/avito/android/section/item/ComplementaryAdvertItemBlueprintImpl;", "Lcom/avito/android/section/item/ComplementaryAdvertItemBlueprint;", "bindComplementaryAdvertItemBlueprint", "(Lcom/avito/android/section/item/ComplementaryAdvertItemBlueprintImpl;)Lcom/avito/android/section/item/ComplementaryAdvertItemBlueprint;", "Lcom/avito/android/section/item/ComplementaryAdvertItemDoubleBlueprintImpl;", "Lcom/avito/android/section/item/ComplementaryAdvertItemDoubleBlueprint;", "bindComplementaryAdvertItemDoubleBlueprint", "(Lcom/avito/android/section/item/ComplementaryAdvertItemDoubleBlueprintImpl;)Lcom/avito/android/section/item/ComplementaryAdvertItemDoubleBlueprint;", "Lcom/avito/android/section/complementary/ComplementarySectionBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/section/SectionItemView;", "Lcom/avito/android/section/SectionItem;", "bindComplementarySectionBlueprint", "(Lcom/avito/android/section/complementary/ComplementarySectionBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/section/complementary/ComplementaryTitleWithActionBlueprint;", "Lcom/avito/android/section/title_with_action/SectionTitleWithActionItemView;", "Lcom/avito/android/section/title_with_action/SectionTitleWithActionItem;", "bindComplementaryTitleWithActionBlueprint", "(Lcom/avito/android/section/complementary/ComplementaryTitleWithActionBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/favorite/FavoriteAdvertsPresenterImpl;", "presenter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "bindFavoriteAdvertsPresenter", "(Lcom/avito/android/favorite/FavoriteAdvertsPresenterImpl;)Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenterImpl;", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "bindViewedAdvertsPresenter", "(Lcom/avito/android/advert/viewed/ViewedAdvertsPresenterImpl;)Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Reusable
        @Binds
        @NotNull
        ComplementaryAdvertItemBlueprint bindComplementaryAdvertItemBlueprint(@NotNull ComplementaryAdvertItemBlueprintImpl complementaryAdvertItemBlueprintImpl);

        @Reusable
        @Binds
        @NotNull
        ComplementaryAdvertItemDoubleBlueprint bindComplementaryAdvertItemDoubleBlueprint(@NotNull ComplementaryAdvertItemDoubleBlueprintImpl complementaryAdvertItemDoubleBlueprintImpl);

        @Reusable
        @Binds
        @ComplementaryResourceProvider
        @NotNull
        SectionResourceProvider bindComplementaryResourceProvider(@NotNull ComplementaryResourceProviderImpl complementaryResourceProviderImpl);

        @Reusable
        @Binds
        @NotNull
        ItemBlueprint<SectionItemView, SectionItem> bindComplementarySectionBlueprint(@NotNull ComplementarySectionBlueprint complementarySectionBlueprint);

        @Reusable
        @Binds
        @NotNull
        ItemBlueprint<SectionTitleWithActionItemView, SectionTitleWithActionItem> bindComplementaryTitleWithActionBlueprint(@NotNull ComplementaryTitleWithActionBlueprint complementaryTitleWithActionBlueprint);

        @ComplementaryFavoriteAdvertsPresenter
        @Binds
        @NotNull
        FavoriteAdvertsPresenter bindFavoriteAdvertsPresenter(@NotNull FavoriteAdvertsPresenterImpl favoriteAdvertsPresenterImpl);

        @RdsSectionResourceProvider
        @Reusable
        @Binds
        @NotNull
        SectionResourceProvider bindRdsSectionResourceProvider(@NotNull RdsSectionResourceProviderImpl rdsSectionResourceProviderImpl);

        @Reusable
        @Binds
        @NotNull
        SectionAdvertItemBlueprint bindSectionAdvertItemBlueprint(@NotNull SectionAdvertItemBlueprintImpl sectionAdvertItemBlueprintImpl);

        @Reusable
        @Binds
        @NotNull
        SectionAdvertItemDoubleBlueprint bindSectionAdvertItemDoubleBlueprint(@NotNull SectionAdvertItemDoubleBlueprintImpl sectionAdvertItemDoubleBlueprintImpl);

        @Reusable
        @Binds
        @NotNull
        SectionResourceProvider bindSectionResourceProviderImpl(@NotNull SectionResourceProviderImpl sectionResourceProviderImpl);

        @ComplementaryViewedAdvertsPresenter
        @Binds
        @NotNull
        ViewedAdvertsPresenter bindViewedAdvertsPresenter(@NotNull ViewedAdvertsPresenterImpl viewedAdvertsPresenterImpl);
    }

    @Provides
    @JvmStatic
    @Reusable
    @ComplementaryAdvertItemPresenter
    @NotNull
    public static final SectionAdvertItemPresenter provideComplementarySectionAdvertItemPresenter$serp_core_release(@NotNull Lazy<AdvertItemListener> lazy, @ComplementaryItemWidthProvider @NotNull SectionItemWidthProvider sectionItemWidthProvider) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(sectionItemWidthProvider, "complementaryItemWidthProvider");
        return new SectionAdvertItemPresenterImpl(lazy, sectionItemWidthProvider);
    }

    @Provides
    @JvmStatic
    @Reusable
    @ComplementarySectionItemBinder
    @NotNull
    public static final ItemBinder provideComplementarySectionItemBinder$serp_core_release(@NotNull ComplementaryAdvertItemBlueprint complementaryAdvertItemBlueprint, @NotNull ComplementaryAdvertItemDoubleBlueprint complementaryAdvertItemDoubleBlueprint) {
        Intrinsics.checkNotNullParameter(complementaryAdvertItemBlueprint, "complementaryAdvertItemBlueprint");
        Intrinsics.checkNotNullParameter(complementaryAdvertItemDoubleBlueprint, "complementaryAdvertItemDoubleBlueprint");
        return new ItemBinder.Builder().registerItem(complementaryAdvertItemBlueprint).registerItem(complementaryAdvertItemDoubleBlueprint).build();
    }

    @ComplementaryItemWidthProvider
    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final SectionItemWidthProvider provideComplementarySectionItemWidthProvider$serp_core_release(@NotNull DeviceMetrics deviceMetrics, @ComplementaryResourceProvider @NotNull SectionResourceProvider sectionResourceProvider) {
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(sectionResourceProvider, GeoContract.PROVIDER);
        return new SectionItemWidthProviderImpl(deviceMetrics, sectionResourceProvider);
    }

    @Provides
    @JvmStatic
    @NotNull
    @ComplementarySectionItemPresenter
    public static final AdapterPresenter provideComplementaryTypeAdapterPresenter$serp_core_release(@ComplementarySectionItemBinder @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    @RdsItemWidthProvider
    public static final SectionItemWidthProvider provideRdsSectionItemWidthProvider$serp_core_release(@NotNull DeviceMetrics deviceMetrics, @RdsSectionResourceProvider @NotNull SectionResourceProvider sectionResourceProvider) {
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(sectionResourceProvider, GeoContract.PROVIDER);
        return new SectionItemWidthProviderImpl(deviceMetrics, sectionResourceProvider);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final SectionAdvertItemPresenter provideSectionAdvertItemPresenter$serp_core_release(@NotNull Lazy<AdvertItemListener> lazy, @NotNull SectionItemWidthProvider sectionItemWidthProvider) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(sectionItemWidthProvider, "recommendationItemWidthProvider");
        return new SectionAdvertItemPresenterImpl(lazy, sectionItemWidthProvider);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final SectionItemWidthProvider provideSectionItemWidthProvider$serp_core_release(@NotNull DeviceMetrics deviceMetrics, @NotNull SectionResourceProvider sectionResourceProvider) {
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(sectionResourceProvider, GeoContract.PROVIDER);
        return new SectionItemWidthProviderImpl(deviceMetrics, sectionResourceProvider);
    }
}
