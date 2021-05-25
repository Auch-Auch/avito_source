package com.avito.android.tariff.change.di;

import a2.b.a.a.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.tariff.change.item.benefit.di.BenefitItemModule;
import com.avito.android.tariff.change.item.button.di.ButtonItemModule;
import com.avito.android.tariff.change.item.title.di.TitleItemModule;
import com.avito.android.tariff.change.viewmodel.TariffChangeConverter;
import com.avito.android.tariff.change.viewmodel.TariffChangeConverterImpl;
import com.avito.android.tariff.change.viewmodel.TariffChangeRepository;
import com.avito.android.tariff.change.viewmodel.TariffChangeRepositoryImpl;
import com.avito.android.tariff.change.viewmodel.TariffChangeViewModel;
import com.avito.android.tariff.change.viewmodel.TariffChangeViewModelFactory;
import com.avito.android.tariff.change.viewmodel.TariffChangeViewModelImpl;
import com.avito.android.tariff.di.HeaderModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00110\u0010H\u0001¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/avito/android/tariff/change/di/TariffChangeModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Lcom/avito/android/tariff/change/viewmodel/TariffChangeViewModel;", "provideViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/tariff/change/viewmodel/TariffChangeViewModel;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideSimpleRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "provideItemPresenters$tariff_release", "()Ljava/util/Set;", "provideItemPresenters", "<init>", "()V", "Declarations", "tariff_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class, BenefitItemModule.class, TitleItemModule.class, HeaderModule.class, ButtonItemModule.class})
public final class TariffChangeModule {
    @NotNull
    public static final TariffChangeModule INSTANCE = new TariffChangeModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/tariff/change/di/TariffChangeModule$Declarations;", "", "Lcom/avito/android/tariff/change/viewmodel/TariffChangeViewModelFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/tariff/change/viewmodel/TariffChangeViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/tariff/change/viewmodel/TariffChangeRepositoryImpl;", "repository", "Lcom/avito/android/tariff/change/viewmodel/TariffChangeRepository;", "provideRepository", "(Lcom/avito/android/tariff/change/viewmodel/TariffChangeRepositoryImpl;)Lcom/avito/android/tariff/change/viewmodel/TariffChangeRepository;", "Lcom/avito/android/tariff/change/viewmodel/TariffChangeConverterImpl;", "converter", "Lcom/avito/android/tariff/change/viewmodel/TariffChangeConverter;", "provideConverter", "(Lcom/avito/android/tariff/change/viewmodel/TariffChangeConverterImpl;)Lcom/avito/android/tariff/change/viewmodel/TariffChangeConverter;", "tariff_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        TariffChangeConverter provideConverter(@NotNull TariffChangeConverterImpl tariffChangeConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        TariffChangeRepository provideRepository(@NotNull TariffChangeRepositoryImpl tariffChangeRepositoryImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory provideViewModelFactory(@NotNull TariffChangeViewModelFactory tariffChangeViewModelFactory);
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    @PerFragment
    public static final Set<ItemPresenter<?, ?>> provideItemPresenters$tariff_release() {
        return y.emptySet();
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
    public static final TariffChangeViewModel provideViewModel(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(fragment, factory).get(TariffChangeViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (TariffChangeViewModel) viewModel;
    }
}
