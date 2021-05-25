package com.avito.android.serp.adapter.vertical_main.vertical_filter.di;

import a2.b.a.a.a;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.PerFragment;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.DestroyableViewHolderBuilderImpl;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterInteractor;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterInteractorImpl;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalSearchFilterResourceProvider;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalSearchFilterResourceProviderImpl;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.VerticalSearchFilterItemPresenter;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.VerticalSearchFilterItemPresenterImpl;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.VerticalSearchFilterMultiSelectItemBlueprint;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.VerticalSearchFilterSelectItemBlueprint;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented.VerticalSearchFilterSegmentedItemBlueprint;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented.VerticalSearchFilterSegmentedItemBlueprintImpl;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented.VerticalSearchFilterSegmentedItemPresenter;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented.VerticalSearchFilterSegmentedItemPresenterImpl;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.item.VerticalFilterItemPresenter;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.item.VerticalFilterItemPresenterImpl;
import com.avito.android.util.BuildInfo;
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
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001 B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ4\u0010\t\u001a\u00020\b2\u001b\b\u0001\u0010\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\b\u00040\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ3\u0010\u0016\u001a\u00020\u00132\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u001a\u001a\u00020\u000b2\b\b\u0001\u0010\u0017\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001d\u001a\u00020\r2\b\b\u0001\u0010\u0017\u001a\u00020\bH\u0001¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/di/VerticalFilterModule;", "", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemBlueprint;", "verticalSearchFilterSegmentedItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "(Ljava/util/Set;Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "presenter", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "destroyableViewHolderBuilder", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "provideSafeRecyclerAdapter$serp_core_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "provideSafeRecyclerAdapter", "itemBinder", "provideAdapterPresenter$serp_core_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "provideDestroyableViewHolderBuilder$serp_core_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder", "<init>", "()V", "Dependencies", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class})
public final class VerticalFilterModule {
    @NotNull
    public static final VerticalFilterModule INSTANCE = new VerticalFilterModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c2\u0006\u0010\u001b\u001a\u00020\u001fH'¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\"H'¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/di/VerticalFilterModule$Dependencies;", "", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemPresenterImpl;", "verticalFilterItemPresenterImpl", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemPresenter;", "bindVerticalFilterItemPresenter", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemPresenterImpl;)Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemPresenter;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterInteractorImpl;", "verticalFilterInteractorImpl", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterInteractor;", "bindVerticalFilterInteractor", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterInteractorImpl;)Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterInteractor;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalSearchFilterResourceProviderImpl;", "resourceProvider", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalSearchFilterResourceProvider;", "bindResourceProvider", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalSearchFilterResourceProviderImpl;)Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalSearchFilterResourceProvider;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterItemPresenterImpl;", "presenter", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterItemPresenter;", "bindVerticalSearchFilterItemPresenter", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterItemPresenterImpl;)Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterItemPresenter;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemPresenterImpl;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemPresenter;", "bindVerticalSearchFilterSegmentedItemPresenter", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemPresenterImpl;)Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemPresenter;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterSelectItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindVerticalSearchFilterSelectItemBlueprint", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterSelectItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterMultiSelectItemBlueprint;", "bindVerticalSearchFilterMultiSelectItemBlueprint", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterMultiSelectItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemBlueprintImpl;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemBlueprint;", "bindVerticalSearchFilterSegmentedItemBlueprint", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemBlueprintImpl;)Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemBlueprint;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        VerticalSearchFilterResourceProvider bindResourceProvider(@NotNull VerticalSearchFilterResourceProviderImpl verticalSearchFilterResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        VerticalFilterInteractor bindVerticalFilterInteractor(@NotNull VerticalFilterInteractorImpl verticalFilterInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        VerticalFilterItemPresenter bindVerticalFilterItemPresenter(@NotNull VerticalFilterItemPresenterImpl verticalFilterItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        VerticalSearchFilterItemPresenter bindVerticalSearchFilterItemPresenter(@NotNull VerticalSearchFilterItemPresenterImpl verticalSearchFilterItemPresenterImpl);

        @VerticalSearchFilterBlueprints
        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindVerticalSearchFilterMultiSelectItemBlueprint(@NotNull VerticalSearchFilterMultiSelectItemBlueprint verticalSearchFilterMultiSelectItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        VerticalSearchFilterSegmentedItemBlueprint bindVerticalSearchFilterSegmentedItemBlueprint(@NotNull VerticalSearchFilterSegmentedItemBlueprintImpl verticalSearchFilterSegmentedItemBlueprintImpl);

        @PerFragment
        @Binds
        @NotNull
        VerticalSearchFilterSegmentedItemPresenter bindVerticalSearchFilterSegmentedItemPresenter(@NotNull VerticalSearchFilterSegmentedItemPresenterImpl verticalSearchFilterSegmentedItemPresenterImpl);

        @VerticalSearchFilterBlueprints
        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindVerticalSearchFilterSelectItemBlueprint(@NotNull VerticalSearchFilterSelectItemBlueprint verticalSearchFilterSelectItemBlueprint);
    }

    @Provides
    @NotNull
    @VerticalSearchFilterAdapterPresenter
    @PerFragment
    public final AdapterPresenter provideAdapterPresenter$serp_core_release(@VerticalSearchFilterItemBinder @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @VerticalSearchFilterViewHolder
    @NotNull
    @PerFragment
    public final DestroyableViewHolderBuilder provideDestroyableViewHolderBuilder$serp_core_release(@VerticalSearchFilterItemBinder @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new DestroyableViewHolderBuilderImpl(itemBinder);
    }

    @Provides
    @NotNull
    @VerticalSearchFilterItemBinder
    @PerFragment
    public final ItemBinder provideItemBinder(@VerticalSearchFilterBlueprints @NotNull Set<ItemBlueprint<?, ?>> set, @NotNull VerticalSearchFilterSegmentedItemBlueprint verticalSearchFilterSegmentedItemBlueprint) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        Intrinsics.checkNotNullParameter(verticalSearchFilterSegmentedItemBlueprint, "verticalSearchFilterSegmentedItemBlueprint");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            builder.registerItem(it.next());
        }
        return builder.registerItem(verticalSearchFilterSegmentedItemBlueprint).build();
    }

    @Provides
    @NotNull
    @PerFragment
    @VerticalSearchFilterRecyclerAdapter
    public final SafeRecyclerAdapter provideSafeRecyclerAdapter$serp_core_release(@VerticalSearchFilterAdapterPresenter @NotNull AdapterPresenter adapterPresenter, @VerticalSearchFilterViewHolder @NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder, @NotNull BuildInfo buildInfo, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "presenter");
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder, "destroyableViewHolderBuilder");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new SafeRecyclerAdapter(adapterPresenter, destroyableViewHolderBuilder, buildInfo, analytics);
    }
}
