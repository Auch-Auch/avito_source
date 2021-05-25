package com.avito.android.tariff.tariff_package_info.di;

import a2.b.a.a.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.di.PerFragment;
import com.avito.android.tariff.tariff_package_info.recycler.TariffPackageBlueprint;
import com.avito.android.tariff.tariff_package_info.recycler.TariffPackagePresenter;
import com.avito.android.tariff.tariff_package_info.recycler.header.TariffPackageHeaderBlueprint;
import com.avito.android.tariff.tariff_package_info.recycler.header.TariffPackageHeaderPresenter;
import com.avito.android.tariff.tariff_package_info.recycler.microcategory.TariffPackageMicrcategoryBlueprint;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverter;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterImpl;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoRepository;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoRepositoryImpl;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoViewModel;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoViewModelFactory;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoViewModelImpl;
import com.avito.android.tariff.view.TariffBarConverter;
import com.avito.android.tariff.view.TariffBarConverterImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J*\u0010\u0019\u001a\u00020\u000b2\u0019\u0010\u0016\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0014¢\u0006\u0002\b\u00150\u0013H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u001a\u0010\u0011J\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/avito/android/tariff/tariff_package_info/di/TariffPackageInfoModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoViewModel;", "provideViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoViewModel;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideAdapterPresenter$tariff_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "provideItemBinder$tariff_release", "(Ljava/util/Set;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "provideMicroCategoryAdapterPresenter$tariff_release", "provideMicroCategoryAdapterPresenter", "Lcom/avito/android/tariff/tariff_package_info/recycler/microcategory/TariffPackageMicrcategoryBlueprint;", "tariffPackageMicrocategoryBlueprint", "provideMicroCategoryItemBinder$tariff_release", "(Lcom/avito/android/tariff/tariff_package_info/recycler/microcategory/TariffPackageMicrcategoryBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideMicroCategoryItemBinder", "<init>", "()V", "Declarations", "tariff_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class TariffPackageInfoModule {
    @NotNull
    public static final TariffPackageInfoModule INSTANCE = new TariffPackageInfoModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e2\u0006\u0010\r\u001a\u00020\u0016H'¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00132\u0006\u0010\u0012\u001a\u00020\u0019H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH'¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H'¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/avito/android/tariff/tariff_package_info/di/TariffPackageInfoModule$Declarations;", "", "Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoViewModelFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoRepositoryImpl;", "tariffPackageInfoRepository", "Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoRepository;", "provideRepository", "(Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoRepositoryImpl;)Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoRepository;", "Lcom/avito/android/tariff/tariff_package_info/recycler/TariffPackageBlueprint;", "itemBlueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "providePackageInfoBlueprint", "(Lcom/avito/android/tariff/tariff_package_info/recycler/TariffPackageBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/tariff/tariff_package_info/recycler/TariffPackagePresenter;", "itemPresenter", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "providePackageInfoPresenter", "(Lcom/avito/android/tariff/tariff_package_info/recycler/TariffPackagePresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/tariff_package_info/recycler/header/TariffPackageHeaderBlueprint;", "provideHeaderBlueprint", "(Lcom/avito/android/tariff/tariff_package_info/recycler/header/TariffPackageHeaderBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/tariff/tariff_package_info/recycler/header/TariffPackageHeaderPresenter;", "provideHeaderPresenter", "(Lcom/avito/android/tariff/tariff_package_info/recycler/header/TariffPackageHeaderPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/view/TariffBarConverterImpl;", "barConverterImpl", "Lcom/avito/android/tariff/view/TariffBarConverter;", "provideBarConverter", "(Lcom/avito/android/tariff/view/TariffBarConverterImpl;)Lcom/avito/android/tariff/view/TariffBarConverter;", "Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoConverterImpl;", "converter", "Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoConverter;", "provideConverter", "(Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoConverterImpl;)Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoConverter;", "tariff_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        TariffBarConverter provideBarConverter(@NotNull TariffBarConverterImpl tariffBarConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        TariffPackageInfoConverter provideConverter(@NotNull TariffPackageInfoConverterImpl tariffPackageInfoConverterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideHeaderBlueprint(@NotNull TariffPackageHeaderBlueprint tariffPackageHeaderBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideHeaderPresenter(@NotNull TariffPackageHeaderPresenter tariffPackageHeaderPresenter);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> providePackageInfoBlueprint(@NotNull TariffPackageBlueprint tariffPackageBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> providePackageInfoPresenter(@NotNull TariffPackagePresenter tariffPackagePresenter);

        @PerFragment
        @Binds
        @NotNull
        TariffPackageInfoRepository provideRepository(@NotNull TariffPackageInfoRepositoryImpl tariffPackageInfoRepositoryImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory provideViewModelFactory(@NotNull TariffPackageInfoViewModelFactory tariffPackageInfoViewModelFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter$tariff_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$tariff_release(@NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            builder = builder.registerItem(it.next());
        }
        return builder.build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SimpleRecyclerAdapter provideRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final TariffPackageInfoViewModel provideViewModel(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(fragment, factory).get(TariffPackageInfoViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (TariffPackageInfoViewModel) viewModel;
    }

    @Provides
    @NotNull
    @PerFragment
    @TariffPackageMicrocategoryAdapterPresenter
    public final AdapterPresenter provideMicroCategoryAdapterPresenter$tariff_release(@TariffPackageMicrocategoryItemBinder @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @NotNull
    @TariffPackageMicrocategoryItemBinder
    @PerFragment
    public final ItemBinder provideMicroCategoryItemBinder$tariff_release(@NotNull TariffPackageMicrcategoryBlueprint tariffPackageMicrcategoryBlueprint) {
        Intrinsics.checkNotNullParameter(tariffPackageMicrcategoryBlueprint, "tariffPackageMicrocategoryBlueprint");
        return new ItemBinder.Builder().registerItem(tariffPackageMicrcategoryBlueprint).build();
    }
}
