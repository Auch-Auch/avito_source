package com.avito.android.tariff.landing.di;

import a2.b.a.a.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.tariff.di.HeaderModule;
import com.avito.android.tariff.landing.item.icon.IconItemBlueprint;
import com.avito.android.tariff.landing.item.icon.IconItemPresenter;
import com.avito.android.tariff.landing.item.text.TextItemBlueprint;
import com.avito.android.tariff.landing.item.text.TextItemPresenter;
import com.avito.android.tariff.landing.viewmodel.LandingConverter;
import com.avito.android.tariff.landing.viewmodel.LandingConverterImpl;
import com.avito.android.tariff.landing.viewmodel.LandingInteractor;
import com.avito.android.tariff.landing.viewmodel.LandingInteractorImpl;
import com.avito.android.tariff.landing.viewmodel.TariffLandingViewModel;
import com.avito.android.tariff.landing.viewmodel.TariffLandingViewModelFactory;
import com.avito.android.tariff.landing.viewmodel.TariffLandingViewModelImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/tariff/landing/di/LandingModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Lcom/avito/android/tariff/landing/viewmodel/TariffLandingViewModel;", "provideViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/tariff/landing/viewmodel/TariffLandingViewModel;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideSimpleRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "<init>", "()V", "Declarations", "tariff_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class, HeaderModule.class})
public final class LandingModule {
    @NotNull
    public static final LandingModule INSTANCE = new LandingModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00132\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00132\u0006\u0010\u0017\u001a\u00020\u001fH'¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c2\u0006\u0010\u001b\u001a\u00020\"H'¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/avito/android/tariff/landing/di/LandingModule$Declarations;", "", "Lcom/avito/android/tariff/landing/viewmodel/LandingInteractorImpl;", "landingInteractor", "Lcom/avito/android/tariff/landing/viewmodel/LandingInteractor;", "provideInteractor", "(Lcom/avito/android/tariff/landing/viewmodel/LandingInteractorImpl;)Lcom/avito/android/tariff/landing/viewmodel/LandingInteractor;", "Lcom/avito/android/tariff/landing/viewmodel/LandingConverterImpl;", "converter", "Lcom/avito/android/tariff/landing/viewmodel/LandingConverter;", "provideConverter", "(Lcom/avito/android/tariff/landing/viewmodel/LandingConverterImpl;)Lcom/avito/android/tariff/landing/viewmodel/LandingConverter;", "Lcom/avito/android/tariff/landing/viewmodel/TariffLandingViewModelFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/tariff/landing/viewmodel/TariffLandingViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "provideTitlePresenter", "(Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/landing/item/icon/IconItemPresenter;", "itemPresenter", "provideIconPresenter", "(Lcom/avito/android/tariff/landing/item/icon/IconItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/landing/item/icon/IconItemBlueprint;", "itemBlueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideIconBlueprint", "(Lcom/avito/android/tariff/landing/item/icon/IconItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/tariff/landing/item/text/TextItemPresenter;", "provideTextItemPresenter", "(Lcom/avito/android/tariff/landing/item/text/TextItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/tariff/landing/item/text/TextItemBlueprint;", "provideTextItemBlueprint", "(Lcom/avito/android/tariff/landing/item/text/TextItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "tariff_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        LandingConverter provideConverter(@NotNull LandingConverterImpl landingConverterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideIconBlueprint(@NotNull IconItemBlueprint iconItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideIconPresenter(@NotNull IconItemPresenter iconItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        LandingInteractor provideInteractor(@NotNull LandingInteractorImpl landingInteractorImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideTextItemBlueprint(@NotNull TextItemBlueprint textItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideTextItemPresenter(@NotNull TextItemPresenter textItemPresenter);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideTitlePresenter(@NotNull PaidServiceHeaderItemPresenter paidServiceHeaderItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory provideViewModelFactory(@NotNull TariffLandingViewModelFactory tariffLandingViewModelFactory);
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
    public static final TariffLandingViewModel provideViewModel(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(fragment, factory).get(TariffLandingViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (TariffLandingViewModel) viewModel;
    }
}
