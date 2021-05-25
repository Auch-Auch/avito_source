package com.avito.android.tariff.region.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.tariff.di.HeaderModule;
import com.avito.android.tariff.region.item.RegionItemBlueprint;
import com.avito.android.tariff.region.item.RegionItemPresenter;
import com.avito.android.tariff.region.item.RegionItemPresenterImpl;
import com.avito.android.tariff.region.viewmodel.RegionConverter;
import com.avito.android.tariff.region.viewmodel.RegionConverterImpl;
import com.avito.android.tariff.region.viewmodel.RegionViewModel;
import com.avito.android.tariff.region.viewmodel.RegionViewModelFactory;
import com.avito.android.tariff.region.viewmodel.RegionViewModelImpl;
import com.avito.android.tariff.region.viewmodel.TariffRegionRepository;
import com.avito.android.tariff.region.viewmodel.TariffRegionRepositoryImpl;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/tariff/region/di/RegionModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Lcom/avito/android/tariff/region/viewmodel/RegionViewModel;", "provideViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/tariff/region/viewmodel/RegionViewModel;", "<init>", "()V", "Declarations", "tariff_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class, HeaderModule.class})
public final class RegionModule {
    @NotNull
    public static final RegionModule INSTANCE = new RegionModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00132\u0006\u0010\u001a\u001a\u00020\u0017H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010 \u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH'¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/avito/android/tariff/region/di/RegionModule$Declarations;", "", "Lcom/avito/android/tariff/region/viewmodel/TariffRegionRepositoryImpl;", "regionRepository", "Lcom/avito/android/tariff/region/viewmodel/TariffRegionRepository;", "provideRepository", "(Lcom/avito/android/tariff/region/viewmodel/TariffRegionRepositoryImpl;)Lcom/avito/android/tariff/region/viewmodel/TariffRegionRepository;", "Lcom/avito/android/tariff/region/viewmodel/RegionConverterImpl;", "converter", "Lcom/avito/android/tariff/region/viewmodel/RegionConverter;", "provideConverter", "(Lcom/avito/android/tariff/region/viewmodel/RegionConverterImpl;)Lcom/avito/android/tariff/region/viewmodel/RegionConverter;", "Lcom/avito/android/tariff/region/viewmodel/RegionViewModelFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/tariff/region/viewmodel/RegionViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "provideTitlePresenter", "(Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/region/item/RegionItemPresenterImpl;", "Lcom/avito/android/tariff/region/item/RegionItemPresenter;", "provideRegionPresenterImpl", "(Lcom/avito/android/tariff/region/item/RegionItemPresenterImpl;)Lcom/avito/android/tariff/region/item/RegionItemPresenter;", "itemPresenter", "provideRegionPresenter", "(Lcom/avito/android/tariff/region/item/RegionItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/region/item/RegionItemBlueprint;", "itemBlueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideRegionBlueprint", "(Lcom/avito/android/tariff/region/item/RegionItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "tariff_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        RegionConverter provideConverter(@NotNull RegionConverterImpl regionConverterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideRegionBlueprint(@NotNull RegionItemBlueprint regionItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideRegionPresenter(@NotNull RegionItemPresenter regionItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        RegionItemPresenter provideRegionPresenterImpl(@NotNull RegionItemPresenterImpl regionItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        TariffRegionRepository provideRepository(@NotNull TariffRegionRepositoryImpl tariffRegionRepositoryImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideTitlePresenter(@NotNull PaidServiceHeaderItemPresenter paidServiceHeaderItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory provideViewModelFactory(@NotNull RegionViewModelFactory regionViewModelFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final RegionViewModel provideViewModel(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(fragment, factory).get(RegionViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (RegionViewModel) viewModel;
    }
}
