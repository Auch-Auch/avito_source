package com.avito.android.user_stats.di;

import a2.b.a.a.a;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.di.PerFragment;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemBlueprint;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemComparator;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemPayloadCreator;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemPresenter;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.BarItemPresenterImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0015\u001a\u00020\u00122\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0001\u0010\u000f\u001a\u00020\t2\b\b\u0001\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0019\u001a\u00020\u00162\b\b\u0001\u0010\u000f\u001a\u00020\u00122\b\b\u0001\u0010\b\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010 \u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/avito/android/user_stats/di/UserStatsPlotModule;", "", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemBlueprint;", "barBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$user_stats_release", "(Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "provideAdapter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "Ldagger/Lazy;", "Landroidx/recyclerview/widget/ListUpdateCallback;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideDataAwareAdapter$user_stats_release", "(Ldagger/Lazy;Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideDataAwareAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter$user_stats_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemComparator;", "contentsComparator", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemPayloadCreator;", "payloadCreator", "provideDiffCalculator$user_stats_release", "(Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemComparator;Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemPayloadCreator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator", "<init>", "()V", "Declarations", "user-stats_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class UserStatsPlotModule {
    @NotNull
    public static final UserStatsPlotModule INSTANCE = new UserStatsPlotModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/user_stats/di/UserStatsPlotModule$Declarations;", "", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemPresenterImpl;", "impl", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemPresenter;", "bindBarItemPresenter", "(Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemPresenterImpl;)Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemPresenter;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroidx/recyclerview/widget/ListUpdateCallback;", "provideListUpdateCallback", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "user-stats_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        BarItemPresenter bindBarItemPresenter(@NotNull BarItemPresenterImpl barItemPresenterImpl);

        @UserStatsChart
        @Binds
        @NotNull
        @PerFragment
        ListUpdateCallback provideListUpdateCallback(@UserStatsChart @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter);
    }

    @Provides
    @UserStatsChart
    @NotNull
    @PerFragment
    public final SimpleAdapterPresenter provideAdapter(@UserStatsChart @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @UserStatsChart
    @NotNull
    @PerFragment
    public final AdapterPresenter provideDataAwareAdapter$user_stats_release(@UserStatsChart @NotNull Lazy<ListUpdateCallback> lazy, @UserStatsChart @NotNull SimpleAdapterPresenter simpleAdapterPresenter, @UserStatsChart @NotNull DiffCalculator diffCalculator) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(simpleAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
        return new DataAwareAdapterPresenterImpl(lazy, simpleAdapterPresenter, diffCalculator);
    }

    @Provides
    @UserStatsChart
    @NotNull
    @PerFragment
    public final DiffCalculator provideDiffCalculator$user_stats_release(@NotNull BarItemComparator barItemComparator, @NotNull BarItemPayloadCreator barItemPayloadCreator) {
        Intrinsics.checkNotNullParameter(barItemComparator, "contentsComparator");
        Intrinsics.checkNotNullParameter(barItemPayloadCreator, "payloadCreator");
        return new SimpleDiffCalculator(barItemComparator, null, false, barItemPayloadCreator, 2, null);
    }

    @Provides
    @UserStatsChart
    @NotNull
    @PerFragment
    public final ItemBinder provideItemBinder$user_stats_release(@NotNull BarItemBlueprint barItemBlueprint) {
        Intrinsics.checkNotNullParameter(barItemBlueprint, "barBlueprint");
        return new ItemBinder.Builder().registerItem(barItemBlueprint).build();
    }

    @Provides
    @UserStatsChart
    @NotNull
    @PerFragment
    public final SimpleRecyclerAdapter provideRecyclerAdapter$user_stats_release(@UserStatsChart @NotNull AdapterPresenter adapterPresenter, @UserStatsChart @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter, itemBinder);
        simpleRecyclerAdapter.setHasStableIds(true);
        return simpleRecyclerAdapter;
    }
}
