package com.avito.android.user_stats.di;

import a2.b.a.a.a;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.di.PerFragment;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.user_stats.tab.UserStatsChartBarItemConverter;
import com.avito.android.user_stats.tab.UserStatsChartBarItemConverterImpl;
import com.avito.android.user_stats.tab.UserStatsProvider;
import com.avito.android.user_stats.tab.UserStatsTabInteractor;
import com.avito.android.user_stats.tab.UserStatsTabInteractorImpl;
import com.avito.android.user_stats.tab.UserStatsTabViewModel;
import com.avito.android.user_stats.tab.UserStatsTabViewModelFactory;
import com.avito.android.user_stats.tab.UserStatsTemplateItemConverter;
import com.avito.android.user_stats.tab.UserStatsTemplateItemConverterImpl;
import com.avito.android.user_stats.tab.list.UserStatsTemplateUnitComparator;
import com.avito.android.user_stats.tab.list.items.UserStatsTemplateUnitPayloadCreator;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.ChartItemBlueprint;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.ChartItemPresenter;
import com.avito.android.user_stats.tab.list.items.blueprints.chart.ChartItemPresenterImpl;
import com.avito.android.user_stats.tab.list.items.blueprints.description.DescriptionBlueprint;
import com.avito.android.user_stats.tab.list.items.blueprints.description.DescriptionItemPresenter;
import com.avito.android.user_stats.tab.list.items.blueprints.description.DescriptionItemPresenterImpl;
import com.avito.android.user_stats.tab.list.items.blueprints.header.HeaderItemBlueprint;
import com.avito.android.user_stats.tab.list.items.blueprints.header.HeaderItemPresenter;
import com.avito.android.user_stats.tab.list.items.blueprints.header.HeaderItemPresenterImpl;
import com.avito.android.user_stats.tab.list.items.blueprints.space.SpaceBlueprint;
import com.avito.android.user_stats.tab.list.items.blueprints.space.SpaceItemPresenter;
import com.avito.android.user_stats.tab.list.items.blueprints.space.SpaceItemPresenterImpl;
import com.avito.android.user_stats.tab.list.items.blueprints.two_columns.TwoColumnsBlueprint;
import com.avito.android.user_stats.tab.list.items.blueprints.two_columns.TwoColumnsItemPresenter;
import com.avito.android.user_stats.tab.list.items.blueprints.two_columns.TwoColumnsItemPresenterImpl;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.user_stats.model.UserStatsTabData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001GB\t\b\u0002¢\u0006\u0004\bE\u0010FJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ2\u0010%\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030#¢\u0006\u0002\b$0\"2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b%\u0010&J\u0017\u0010,\u001a\u00020)2\u0006\u0010(\u001a\u00020'H\u0001¢\u0006\u0004\b*\u0010+J\u0017\u00101\u001a\u00020.2\u0006\u0010-\u001a\u00020\u001aH\u0001¢\u0006\u0004\b/\u00100J-\u0010:\u001a\u0002072\f\u00103\u001a\b\u0012\u0004\u0012\u00020)022\u0006\u00104\u001a\u00020.2\u0006\u00106\u001a\u000205H\u0001¢\u0006\u0004\b8\u00109J\u001f\u0010A\u001a\u0002052\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=H\u0001¢\u0006\u0004\b?\u0010@J\u001f\u0010D\u001a\u00020'2\u0006\u00104\u001a\u0002072\u0006\u0010-\u001a\u00020\u001aH\u0001¢\u0006\u0004\bB\u0010C¨\u0006H"}, d2 = {"Lcom/avito/android/user_stats/di/UserStatsTabModule;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelStoreOwner", "Lcom/avito/android/user_stats/tab/UserStatsTabViewModelFactory;", "factory", "Lcom/avito/android/user_stats/tab/UserStatsTabViewModel;", "provideUserStats", "(Landroidx/lifecycle/ViewModelStoreOwner;Lcom/avito/android/user_stats/tab/UserStatsTabViewModelFactory;)Lcom/avito/android/user_stats/tab/UserStatsTabViewModel;", "", "tabId", "Lcom/avito/android/user_stats/tab/UserStatsProvider;", "userStatsProvider", "Lcom/avito/user_stats/model/UserStatsTabData;", "provideTabModel", "(Ljava/lang/String;Lcom/avito/android/user_stats/tab/UserStatsProvider;)Lcom/avito/user_stats/model/UserStatsTabData;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemBlueprint;", "chart", "Lcom/avito/android/user_stats/tab/list/items/blueprints/header/HeaderItemBlueprint;", TariffPackageInfoConverterKt.HEADER_STRING_ID, "Lcom/avito/android/user_stats/tab/list/items/blueprints/two_columns/TwoColumnsBlueprint;", "twoColumns", "Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionBlueprint;", "description", "Lcom/avito/android/user_stats/tab/list/items/blueprints/space/SpaceBlueprint;", "space", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$user_stats_release", "(Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemBlueprint;Lcom/avito/android/user_stats/tab/list/items/blueprints/header/HeaderItemBlueprint;Lcom/avito/android/user_stats/tab/list/items/blueprints/two_columns/TwoColumnsBlueprint;Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionBlueprint;Lcom/avito/android/user_stats/tab/list/items/blueprints/space/SpaceBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemPresenter;", "chartItemPresenter", "Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenter;", "descriptionItemPresenter", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "provideItemPresentersSet", "(Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemPresenter;Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenter;)Ljava/util/Set;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroidx/recyclerview/widget/ListUpdateCallback;", "provideListUpdateCallback$user_stats_release", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "provideListUpdateCallback", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "provideAdapterPresenter$user_stats_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "provideAdapterPresenter", "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideDataAwareAdapterPresenterImpl$user_stats_release", "(Ldagger/Lazy;Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideDataAwareAdapterPresenterImpl", "Lcom/avito/android/user_stats/tab/list/UserStatsTemplateUnitComparator;", "contentsComparator", "Lcom/avito/android/user_stats/tab/list/items/UserStatsTemplateUnitPayloadCreator;", "payloadCreator", "provideDiffCalculator$user_stats_release", "(Lcom/avito/android/user_stats/tab/list/UserStatsTemplateUnitComparator;Lcom/avito/android/user_stats/tab/list/items/UserStatsTemplateUnitPayloadCreator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator", "provideRecyclerAdapter$user_stats_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "<init>", "()V", "Declarations", "user-stats_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, UserStatsPlotModule.class})
public final class UserStatsTabModule {
    @NotNull
    public static final UserStatsTabModule INSTANCE = new UserStatsTabModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u001fH'¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020#H'¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/avito/android/user_stats/di/UserStatsTabModule$Declarations;", "", "Lcom/avito/android/user_stats/tab/UserStatsTabInteractorImpl;", "impl", "Lcom/avito/android/user_stats/tab/UserStatsTabInteractor;", "bindInteractor", "(Lcom/avito/android/user_stats/tab/UserStatsTabInteractorImpl;)Lcom/avito/android/user_stats/tab/UserStatsTabInteractor;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemPresenterImpl;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemPresenter;", "bindChartItemPresenter", "(Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemPresenterImpl;)Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/ChartItemPresenter;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/header/HeaderItemPresenterImpl;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/header/HeaderItemPresenter;", "bindHeaderItemPresenter", "(Lcom/avito/android/user_stats/tab/list/items/blueprints/header/HeaderItemPresenterImpl;)Lcom/avito/android/user_stats/tab/list/items/blueprints/header/HeaderItemPresenter;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/two_columns/TwoColumnsItemPresenterImpl;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/two_columns/TwoColumnsItemPresenter;", "bindTwoColumnsItemPresenter", "(Lcom/avito/android/user_stats/tab/list/items/blueprints/two_columns/TwoColumnsItemPresenterImpl;)Lcom/avito/android/user_stats/tab/list/items/blueprints/two_columns/TwoColumnsItemPresenter;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenterImpl;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenter;", "bindDescriptionItemPresenter", "(Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenterImpl;)Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenter;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/space/SpaceItemPresenterImpl;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/space/SpaceItemPresenter;", "bindSpaceItemPresenter", "(Lcom/avito/android/user_stats/tab/list/items/blueprints/space/SpaceItemPresenterImpl;)Lcom/avito/android/user_stats/tab/list/items/blueprints/space/SpaceItemPresenter;", "Lcom/avito/android/util/text/AttributedTextFormatterImpl;", "Lcom/avito/android/util/text/AttributedTextFormatter;", "bindFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatterImpl;)Lcom/avito/android/util/text/AttributedTextFormatter;", "Lcom/avito/android/user_stats/tab/UserStatsTemplateItemConverterImpl;", "Lcom/avito/android/user_stats/tab/UserStatsTemplateItemConverter;", "bindTemplateItemConverter", "(Lcom/avito/android/user_stats/tab/UserStatsTemplateItemConverterImpl;)Lcom/avito/android/user_stats/tab/UserStatsTemplateItemConverter;", "Lcom/avito/android/user_stats/tab/UserStatsChartBarItemConverterImpl;", "Lcom/avito/android/user_stats/tab/UserStatsChartBarItemConverter;", "bindChartItemConverter", "(Lcom/avito/android/user_stats/tab/UserStatsChartBarItemConverterImpl;)Lcom/avito/android/user_stats/tab/UserStatsChartBarItemConverter;", "user-stats_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        UserStatsChartBarItemConverter bindChartItemConverter(@NotNull UserStatsChartBarItemConverterImpl userStatsChartBarItemConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        ChartItemPresenter bindChartItemPresenter(@NotNull ChartItemPresenterImpl chartItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        DescriptionItemPresenter bindDescriptionItemPresenter(@NotNull DescriptionItemPresenterImpl descriptionItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        AttributedTextFormatter bindFormatter(@NotNull AttributedTextFormatterImpl attributedTextFormatterImpl);

        @PerFragment
        @Binds
        @NotNull
        HeaderItemPresenter bindHeaderItemPresenter(@NotNull HeaderItemPresenterImpl headerItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        UserStatsTabInteractor bindInteractor(@NotNull UserStatsTabInteractorImpl userStatsTabInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        SpaceItemPresenter bindSpaceItemPresenter(@NotNull SpaceItemPresenterImpl spaceItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        UserStatsTemplateItemConverter bindTemplateItemConverter(@NotNull UserStatsTemplateItemConverterImpl userStatsTemplateItemConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        TwoColumnsItemPresenter bindTwoColumnsItemPresenter(@NotNull TwoColumnsItemPresenterImpl twoColumnsItemPresenterImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SimpleAdapterPresenter provideAdapterPresenter$user_stats_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @NotNull
    @PerFragment
    public final AdapterPresenter provideDataAwareAdapterPresenterImpl$user_stats_release(@NotNull Lazy<ListUpdateCallback> lazy, @NotNull SimpleAdapterPresenter simpleAdapterPresenter, @NotNull DiffCalculator diffCalculator) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(simpleAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
        return new DataAwareAdapterPresenterImpl(lazy, simpleAdapterPresenter, diffCalculator);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DiffCalculator provideDiffCalculator$user_stats_release(@NotNull UserStatsTemplateUnitComparator userStatsTemplateUnitComparator, @NotNull UserStatsTemplateUnitPayloadCreator userStatsTemplateUnitPayloadCreator) {
        Intrinsics.checkNotNullParameter(userStatsTemplateUnitComparator, "contentsComparator");
        Intrinsics.checkNotNullParameter(userStatsTemplateUnitPayloadCreator, "payloadCreator");
        return new SimpleDiffCalculator(userStatsTemplateUnitComparator, null, false, userStatsTemplateUnitPayloadCreator, 2, null);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideItemBinder$user_stats_release(@NotNull ChartItemBlueprint chartItemBlueprint, @NotNull HeaderItemBlueprint headerItemBlueprint, @NotNull TwoColumnsBlueprint twoColumnsBlueprint, @NotNull DescriptionBlueprint descriptionBlueprint, @NotNull SpaceBlueprint spaceBlueprint) {
        Intrinsics.checkNotNullParameter(chartItemBlueprint, "chart");
        Intrinsics.checkNotNullParameter(headerItemBlueprint, TariffPackageInfoConverterKt.HEADER_STRING_ID);
        Intrinsics.checkNotNullParameter(twoColumnsBlueprint, "twoColumns");
        Intrinsics.checkNotNullParameter(descriptionBlueprint, "description");
        Intrinsics.checkNotNullParameter(spaceBlueprint, "space");
        return new ItemBinder.Builder().registerItem(chartItemBlueprint).registerItem(headerItemBlueprint).registerItem(twoColumnsBlueprint).registerItem(descriptionBlueprint).registerItem(spaceBlueprint).build();
    }

    @Provides
    @NotNull
    @PerFragment
    public final Set<ItemPresenter<?, ?>> provideItemPresentersSet(@NotNull ChartItemPresenter chartItemPresenter, @NotNull DescriptionItemPresenter descriptionItemPresenter) {
        Intrinsics.checkNotNullParameter(chartItemPresenter, "chartItemPresenter");
        Intrinsics.checkNotNullParameter(descriptionItemPresenter, "descriptionItemPresenter");
        return y.setOf((Object[]) new ItemPresenter[]{chartItemPresenter, descriptionItemPresenter});
    }

    @Provides
    @PerFragment
    @NotNull
    public final ListUpdateCallback provideListUpdateCallback$user_stats_release(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        return simpleRecyclerAdapter;
    }

    @Provides
    @PerFragment
    @NotNull
    public final SimpleRecyclerAdapter provideRecyclerAdapter$user_stats_release(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter, itemBinder);
        simpleRecyclerAdapter.setHasStableIds(true);
        return simpleRecyclerAdapter;
    }

    @Provides
    @PerFragment
    @Nullable
    public final UserStatsTabData provideTabModel(@UserStatsTabId @NotNull String str, @NotNull UserStatsProvider userStatsProvider) {
        Intrinsics.checkNotNullParameter(str, "tabId");
        Intrinsics.checkNotNullParameter(userStatsProvider, "userStatsProvider");
        return userStatsProvider.getTabDataModel(str);
    }

    @Provides
    @PerFragment
    @NotNull
    public final UserStatsTabViewModel provideUserStats(@NotNull ViewModelStoreOwner viewModelStoreOwner, @NotNull UserStatsTabViewModelFactory userStatsTabViewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(userStatsTabViewModelFactory, "factory");
        ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner, userStatsTabViewModelFactory).get(UserStatsTabViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(viewMo…TabViewModel::class.java)");
        return (UserStatsTabViewModel) viewModel;
    }
}
