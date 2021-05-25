package com.avito.android.tariff.info.di;

import a2.b.a.a.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.di.PerFragment;
import com.avito.android.tariff.di.HeaderModule;
import com.avito.android.tariff.info.item.disclaimer.di.DisclaimerItemModule;
import com.avito.android.tariff.info.item.info.di.InfoItemModule;
import com.avito.android.tariff.info.item.package_info.di.PackageInfoItemModule;
import com.avito.android.tariff.info.item.package_title.di.PackageTitleItemModule;
import com.avito.android.tariff.info.ui.TariffInfoViewTypeProvider;
import com.avito.android.tariff.info.ui.TariffInfoViewTypeProviderImpl;
import com.avito.android.tariff.info.viewmodel.TariffInfoConverter;
import com.avito.android.tariff.info.viewmodel.TariffInfoConverterImpl;
import com.avito.android.tariff.info.viewmodel.TariffInfoRepository;
import com.avito.android.tariff.info.viewmodel.TariffInfoRepositoryImpl;
import com.avito.android.tariff.info.viewmodel.TariffInfoViewModel;
import com.avito.android.tariff.info.viewmodel.TariffInfoViewModelFactory;
import com.avito.android.tariff.info.viewmodel.TariffInfoViewModelImpl;
import com.avito.android.tariff.view.TariffBarConverter;
import com.avito.android.tariff.view.TariffBarConverterImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ViewTypeProvider;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\u0016\u001a\u00020\u000b2\u0019\u0010\u0013\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0011¢\u0006\u0002\b\u00120\u0010H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/avito/android/tariff/info/di/TariffInfoModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Lcom/avito/android/tariff/info/viewmodel/TariffInfoViewModel;", "provideViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/tariff/info/viewmodel/TariffInfoViewModel;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideSimpleRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "provideItemBinder$tariff_release", "(Ljava/util/Set;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/konveyor/blueprint/ViewTypeProvider;", "viewTypeProvider", "provideAdapterPresenter$tariff_release", "(Lcom/avito/konveyor/ItemBinder;Lcom/avito/konveyor/blueprint/ViewTypeProvider;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "<init>", "()V", "Declarations", "tariff_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, HeaderModule.class, PackageInfoItemModule.class, DisclaimerItemModule.class, InfoItemModule.class, PackageTitleItemModule.class})
public final class TariffInfoModule {
    @NotNull
    public static final TariffInfoModule INSTANCE = new TariffInfoModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H'¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/tariff/info/di/TariffInfoModule$Declarations;", "", "Lcom/avito/android/tariff/info/viewmodel/TariffInfoViewModelFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/tariff/info/viewmodel/TariffInfoViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/tariff/info/viewmodel/TariffInfoRepositoryImpl;", "repository", "Lcom/avito/android/tariff/info/viewmodel/TariffInfoRepository;", "provideRepository", "(Lcom/avito/android/tariff/info/viewmodel/TariffInfoRepositoryImpl;)Lcom/avito/android/tariff/info/viewmodel/TariffInfoRepository;", "Lcom/avito/android/tariff/info/viewmodel/TariffInfoConverterImpl;", "converter", "Lcom/avito/android/tariff/info/viewmodel/TariffInfoConverter;", "provideConverter", "(Lcom/avito/android/tariff/info/viewmodel/TariffInfoConverterImpl;)Lcom/avito/android/tariff/info/viewmodel/TariffInfoConverter;", "Lcom/avito/android/tariff/view/TariffBarConverterImpl;", "barConverterImpl", "Lcom/avito/android/tariff/view/TariffBarConverter;", "provideBarConverter", "(Lcom/avito/android/tariff/view/TariffBarConverterImpl;)Lcom/avito/android/tariff/view/TariffBarConverter;", "Lcom/avito/android/tariff/info/ui/TariffInfoViewTypeProviderImpl;", "viewTypeProvider", "Lcom/avito/android/tariff/info/ui/TariffInfoViewTypeProvider;", "provideViewTypeProviderImpl", "(Lcom/avito/android/tariff/info/ui/TariffInfoViewTypeProviderImpl;)Lcom/avito/android/tariff/info/ui/TariffInfoViewTypeProvider;", "Lcom/avito/konveyor/blueprint/ViewTypeProvider;", "provideViewTypeProvider", "(Lcom/avito/android/tariff/info/ui/TariffInfoViewTypeProvider;)Lcom/avito/konveyor/blueprint/ViewTypeProvider;", "tariff_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        TariffBarConverter provideBarConverter(@NotNull TariffBarConverterImpl tariffBarConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        TariffInfoConverter provideConverter(@NotNull TariffInfoConverterImpl tariffInfoConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        TariffInfoRepository provideRepository(@NotNull TariffInfoRepositoryImpl tariffInfoRepositoryImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory provideViewModelFactory(@NotNull TariffInfoViewModelFactory tariffInfoViewModelFactory);

        @PerFragment
        @Binds
        @NotNull
        ViewTypeProvider provideViewTypeProvider(@NotNull TariffInfoViewTypeProvider tariffInfoViewTypeProvider);

        @PerFragment
        @Binds
        @NotNull
        TariffInfoViewTypeProvider provideViewTypeProviderImpl(@NotNull TariffInfoViewTypeProviderImpl tariffInfoViewTypeProviderImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter$tariff_release(@NotNull ItemBinder itemBinder, @NotNull ViewTypeProvider viewTypeProvider) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(viewTypeProvider, "viewTypeProvider");
        return new SimpleAdapterPresenter(viewTypeProvider, itemBinder);
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
    public static final SimpleRecyclerAdapter provideSimpleRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final TariffInfoViewModel provideViewModel(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(fragment, factory).get(TariffInfoViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (TariffInfoViewModel) viewModel;
    }
}
