package com.avito.android.select.new_metro.di;

import a2.b.a.a.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.di.PerFragment;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.remote.model.metro_lines.MetroResponseBody;
import com.avito.android.select.R;
import com.avito.android.select.new_metro.ItemsHolder;
import com.avito.android.select.new_metro.MetroResponseToItemsConverter;
import com.avito.android.select.new_metro.SelectMetroParams;
import com.avito.android.select.new_metro.adapter.MetroItemsComparator;
import com.avito.android.select.new_metro.adapter.checkbox_listitem.CheckBoxListItemViewProvider;
import com.avito.android.select.new_metro.adapter.filter.MetroFilterItemBluePrint;
import com.avito.android.select.new_metro.adapter.filter.MetroFilterItemPresenter;
import com.avito.android.select.new_metro.adapter.filter.MetroFilterItemPresenterImpl;
import com.avito.android.select.new_metro.adapter.gap.MetroListGapItemBlueprint;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemBluePrint;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemPresenter;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemPresenterImpl;
import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItemBluePrint;
import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItemPresenter;
import com.avito.android.select.new_metro.adapter.metro_station.MetroStationItemPresenterImpl;
import com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemBlueprint;
import com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemPresenter;
import com.avito.android.select.new_metro.adapter.selected_stations.MetroSelectedStationsItemPresenterImpl;
import com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypeBluePrint;
import com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypePresenter;
import com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypePresenterImpl;
import com.avito.android.select.new_metro.view_model.SelectMetroViewModel;
import com.avito.android.select.new_metro.view_model.SelectMetroViewModelFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001PB\t\b\u0002¢\u0006\u0004\bN\u0010OJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010 \u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010#\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0016H\u0001¢\u0006\u0004\b!\u0010\"J\u0017\u0010)\u001a\u00020&2\u0006\u0010%\u001a\u00020$H\u0001¢\u0006\u0004\b'\u0010(J'\u00101\u001a\u00020.2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020&H\u0001¢\u0006\u0004\b/\u00100J-\u0010:\u001a\u0002072\u0006\u00103\u001a\u0002022\u0006\u0010\u0005\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020504H\u0001¢\u0006\u0004\b8\u00109J\u0017\u0010?\u001a\u00020\n2\u0006\u0010<\u001a\u00020;H\u0001¢\u0006\u0004\b=\u0010>J\u001f\u0010E\u001a\u00020\f2\u0006\u0010A\u001a\u00020@2\u0006\u0010\u001b\u001a\u00020BH\u0001¢\u0006\u0004\bC\u0010DJ\u001f\u0010I\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020@2\u0006\u0010\u001b\u001a\u00020FH\u0001¢\u0006\u0004\bG\u0010HJ\u0017\u0010M\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020JH\u0001¢\u0006\u0004\bK\u0010L¨\u0006Q"}, d2 = {"Lcom/avito/android/select/new_metro/di/SelectMetroFragmentModule;", "", "Lcom/avito/android/select/new_metro/view_model/SelectMetroViewModelFactory;", "viewModelFactory", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/select/new_metro/view_model/SelectMetroViewModel;", "getSelectViewModel$select_release", "(Lcom/avito/android/select/new_metro/view_model/SelectMetroViewModelFactory;Landroidx/fragment/app/Fragment;)Lcom/avito/android/select/new_metro/view_model/SelectMetroViewModel;", "getSelectViewModel", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemBluePrint;", "metroLineBluePrint", "Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItemBluePrint;", "metroStationItemBluePrint", "Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItemBluePrint;", "metroFilterItemBluePrint", "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeBluePrint;", "metroListOutputTypeBluePrint", "Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemBlueprint;", "metroSelectedStationsBlueprint", "Lcom/avito/android/select/new_metro/adapter/gap/MetroListGapItemBlueprint;", "metroListGapItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "getBinder$select_release", "(Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemBluePrint;Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItemBluePrint;Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItemBluePrint;Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeBluePrint;Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemBlueprint;Lcom/avito/android/select/new_metro/adapter/gap/MetroListGapItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "getBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "presenter", "binder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter$select_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "getAdapter$select_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapter", "Lcom/avito/android/select/new_metro/adapter/MetroItemsComparator;", "itemsComparator", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator$select_release", "(Lcom/avito/android/select/new_metro/adapter/MetroItemsComparator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator", "Landroidx/recyclerview/widget/ListUpdateCallback;", "updateCallback", "adapterPresenter", "diffCalculator", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter$select_release", "(Landroidx/recyclerview/widget/ListUpdateCallback;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter", "Lcom/avito/android/select/new_metro/SelectMetroParams;", "params", "", "", "selectedStations", "Lcom/avito/android/select/new_metro/ItemsHolder;", "getItemsHolder$select_release", "(Lcom/avito/android/select/new_metro/SelectMetroParams;Landroidx/fragment/app/Fragment;Ljava/util/List;)Lcom/avito/android/select/new_metro/ItemsHolder;", "getItemsHolder", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenter;", "metroLinePresenter", "getGetMetroLineBluePrint$select_release", "(Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenter;)Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemBluePrint;", "getGetMetroLineBluePrint", "Lcom/avito/android/select/new_metro/adapter/checkbox_listitem/CheckBoxListItemViewProvider;", "viewProvider", "Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItemPresenter;", "getMetroStationItemBlueprint$select_release", "(Lcom/avito/android/select/new_metro/adapter/checkbox_listitem/CheckBoxListItemViewProvider;Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItemPresenter;)Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItemBluePrint;", "getMetroStationItemBlueprint", "Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItemPresenter;", "getMetroFilterItemProvider$select_release", "(Lcom/avito/android/select/new_metro/adapter/checkbox_listitem/CheckBoxListItemViewProvider;Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItemPresenter;)Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItemBluePrint;", "getMetroFilterItemProvider", "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypePresenter;", "getMetroListOutputTypeBluePrint$select_release", "(Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypePresenter;)Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeBluePrint;", "getMetroListOutputTypeBluePrint", "<init>", "()V", "Bindings", "select_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Bindings.class, SelectMetroBaseModule.class})
public final class SelectMetroFragmentModule {
    @NotNull
    public static final SelectMetroFragmentModule INSTANCE = new SelectMetroFragmentModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/select/new_metro/di/SelectMetroFragmentModule$Bindings;", "", "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypePresenterImpl;", "impl", "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypePresenter;", "getMetroListOutputTypePresenter", "(Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypePresenterImpl;)Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypePresenter;", "Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemPresenterImpl;", "Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemPresenter;", "getMetroSelectedStationsItemPresenter", "(Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemPresenterImpl;)Lcom/avito/android/select/new_metro/adapter/selected_stations/MetroSelectedStationsItemPresenter;", "Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItemPresenterImpl;", "Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItemPresenter;", "getMetroFilterItemPresenter", "(Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItemPresenterImpl;)Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItemPresenter;", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenterImpl;", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenter;", "getMetroLineItemPresenter", "(Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenterImpl;)Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenter;", "Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItemPresenterImpl;", "Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItemPresenter;", "getMetroStationItemPresenter", "(Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItemPresenterImpl;)Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItemPresenter;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroidx/recyclerview/widget/ListUpdateCallback;", "getListUpdateCallback", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "select_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Bindings {
        @PerFragment
        @Binds
        @NotNull
        ListUpdateCallback getListUpdateCallback(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter);

        @PerFragment
        @Binds
        @NotNull
        MetroFilterItemPresenter getMetroFilterItemPresenter(@NotNull MetroFilterItemPresenterImpl metroFilterItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        MetroLineItemPresenter getMetroLineItemPresenter(@NotNull MetroLineItemPresenterImpl metroLineItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        MetroListOutputTypePresenter getMetroListOutputTypePresenter(@NotNull MetroListOutputTypePresenterImpl metroListOutputTypePresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        MetroSelectedStationsItemPresenter getMetroSelectedStationsItemPresenter(@NotNull MetroSelectedStationsItemPresenterImpl metroSelectedStationsItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        MetroStationItemPresenter getMetroStationItemPresenter(@NotNull MetroStationItemPresenterImpl metroStationItemPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter getAdapter$select_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "binder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder getBinder$select_release(@NotNull MetroLineItemBluePrint metroLineItemBluePrint, @NotNull MetroStationItemBluePrint metroStationItemBluePrint, @NotNull MetroFilterItemBluePrint metroFilterItemBluePrint, @NotNull MetroListOutputTypeBluePrint metroListOutputTypeBluePrint, @NotNull MetroSelectedStationsItemBlueprint metroSelectedStationsItemBlueprint, @NotNull MetroListGapItemBlueprint metroListGapItemBlueprint) {
        Intrinsics.checkNotNullParameter(metroLineItemBluePrint, "metroLineBluePrint");
        Intrinsics.checkNotNullParameter(metroStationItemBluePrint, "metroStationItemBluePrint");
        Intrinsics.checkNotNullParameter(metroFilterItemBluePrint, "metroFilterItemBluePrint");
        Intrinsics.checkNotNullParameter(metroListOutputTypeBluePrint, "metroListOutputTypeBluePrint");
        Intrinsics.checkNotNullParameter(metroSelectedStationsItemBlueprint, "metroSelectedStationsBlueprint");
        Intrinsics.checkNotNullParameter(metroListGapItemBlueprint, "metroListGapItemBlueprint");
        return new ItemBinder.Builder().registerItem(metroLineItemBluePrint).registerItem(metroFilterItemBluePrint).registerItem(metroStationItemBluePrint).registerItem(metroListOutputTypeBluePrint).registerItem(metroSelectedStationsItemBlueprint).registerItem(metroListGapItemBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final MetroLineItemBluePrint getGetMetroLineBluePrint$select_release(@NotNull MetroLineItemPresenter metroLineItemPresenter) {
        Intrinsics.checkNotNullParameter(metroLineItemPresenter, "metroLinePresenter");
        return new MetroLineItemBluePrint(metroLineItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemsHolder getItemsHolder$select_release(@NotNull SelectMetroParams selectMetroParams, @NotNull Fragment fragment, @NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(selectMetroParams, "params");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(list, "selectedStations");
        MetroResponseBody metroWithLines = selectMetroParams.getMetroWithLines();
        Intrinsics.checkNotNull(metroWithLines);
        String string = fragment.getString(R.string.select_metro_all_stations_filter_name);
        Intrinsics.checkNotNullExpressionValue(string, "fragment.getString(R.str…all_stations_filter_name)");
        return new MetroResponseToItemsConverter(metroWithLines, string, list);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final MetroFilterItemBluePrint getMetroFilterItemProvider$select_release(@NotNull CheckBoxListItemViewProvider checkBoxListItemViewProvider, @NotNull MetroFilterItemPresenter metroFilterItemPresenter) {
        Intrinsics.checkNotNullParameter(checkBoxListItemViewProvider, "viewProvider");
        Intrinsics.checkNotNullParameter(metroFilterItemPresenter, "presenter");
        return new MetroFilterItemBluePrint(metroFilterItemPresenter, checkBoxListItemViewProvider.getViewHolderProvider());
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final MetroListOutputTypeBluePrint getMetroListOutputTypeBluePrint$select_release(@NotNull MetroListOutputTypePresenter metroListOutputTypePresenter) {
        Intrinsics.checkNotNullParameter(metroListOutputTypePresenter, "presenter");
        return new MetroListOutputTypeBluePrint(metroListOutputTypePresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final MetroStationItemBluePrint getMetroStationItemBlueprint$select_release(@NotNull CheckBoxListItemViewProvider checkBoxListItemViewProvider, @NotNull MetroStationItemPresenter metroStationItemPresenter) {
        Intrinsics.checkNotNullParameter(checkBoxListItemViewProvider, "viewProvider");
        Intrinsics.checkNotNullParameter(metroStationItemPresenter, "presenter");
        return new MetroStationItemBluePrint(metroStationItemPresenter, checkBoxListItemViewProvider.getViewHolderProvider());
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SimpleRecyclerAdapter getRecyclerAdapter$select_release(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "presenter", itemBinder, "binder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SelectMetroViewModel getSelectViewModel$select_release(@NotNull SelectMetroViewModelFactory selectMetroViewModelFactory, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(selectMetroViewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = ViewModelProviders.of(fragment, selectMetroViewModelFactory).get(SelectMetroViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…troViewModel::class.java]");
        return (SelectMetroViewModel) viewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DataAwareAdapterPresenter provideDataAwareAdapterPresenter$select_release(@NotNull ListUpdateCallback listUpdateCallback, @NotNull AdapterPresenter adapterPresenter, @NotNull DiffCalculator diffCalculator) {
        Intrinsics.checkNotNullParameter(listUpdateCallback, "updateCallback");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
        Factory create = InstanceFactory.create(listUpdateCallback);
        Objects.requireNonNull(create, "null cannot be cast to non-null type dagger.internal.InstanceFactory<androidx.recyclerview.widget.ListUpdateCallback>");
        return new DataAwareAdapterPresenterImpl((InstanceFactory) create, adapterPresenter, diffCalculator);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DiffCalculator provideDiffCalculator$select_release(@NotNull MetroItemsComparator metroItemsComparator) {
        Intrinsics.checkNotNullParameter(metroItemsComparator, "itemsComparator");
        return new SimpleDiffCalculator(metroItemsComparator, metroItemsComparator, true, null, 8, null);
    }
}
