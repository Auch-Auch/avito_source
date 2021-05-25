package com.avito.android.basket.checkout.di;

import a2.b.a.a.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.basket.checkout.ResourceProvider;
import com.avito.android.basket.checkout.ResourceProviderImpl;
import com.avito.android.basket.checkout.item.checkout.CheckoutItemBlueprint;
import com.avito.android.basket.checkout.item.checkout.CheckoutItemClickListener;
import com.avito.android.basket.checkout.item.checkout.CheckoutItemPresenter;
import com.avito.android.basket.checkout.item.disclaimer.CheckoutDisclaimerItemPresenter;
import com.avito.android.basket.checkout.item.disclaimer.DisclaimerItemBlueprint;
import com.avito.android.basket.checkout.item.price.PriceItemBlueprint;
import com.avito.android.basket.checkout.item.price.PriceItemPresenter;
import com.avito.android.basket.checkout.item.prolongation.ProlongationItemBlueprint;
import com.avito.android.basket.checkout.item.prolongation.ProlongationItemPresenter;
import com.avito.android.basket.checkout.item.prolongation.ProlongationItemPresenterImpl;
import com.avito.android.basket.checkout.utils.CheckoutCalculator;
import com.avito.android.basket.checkout.utils.CheckoutCalculatorImpl;
import com.avito.android.basket.checkout.utils.PriceItemCreator;
import com.avito.android.basket.checkout.utils.PriceItemCreatorImpl;
import com.avito.android.basket.checkout.viewmodel.CheckoutCommitConverter;
import com.avito.android.basket.checkout.viewmodel.CheckoutCommitConverterImpl;
import com.avito.android.basket.checkout.viewmodel.CheckoutConverter;
import com.avito.android.basket.checkout.viewmodel.CheckoutConverterImpl;
import com.avito.android.basket.checkout.viewmodel.CheckoutRepository;
import com.avito.android.basket.checkout.viewmodel.CheckoutRepositoryImpl;
import com.avito.android.basket.checkout.viewmodel.CheckoutViewModel;
import com.avito.android.basket.checkout.viewmodel.CheckoutViewModelFactory;
import com.avito.android.basket.checkout.viewmodel.CheckoutViewModelImpl;
import com.avito.android.basket_legacy.utils.PriceFormatter;
import com.avito.android.basket_legacy.utils.PriceFormatterImpl;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.tariff.di.HeaderModule;
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
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/basket/checkout/di/CheckoutModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutViewModel;", "provideViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/basket/checkout/viewmodel/CheckoutViewModel;", "viewModel", "Lcom/avito/android/basket/checkout/item/checkout/CheckoutItemClickListener;", "provideCheckoutItemListener", "(Lcom/avito/android/basket/checkout/viewmodel/CheckoutViewModel;)Lcom/avito/android/basket/checkout/item/checkout/CheckoutItemClickListener;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideSimpleRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "<init>", "()V", "Declarations", "basket_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class, HeaderModule.class})
public final class CheckoutModule {
    @NotNull
    public static final CheckoutModule INSTANCE = new CheckoutModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00132\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u001fH'¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00132\u0006\u0010\u0017\u001a\u00020 H'¢\u0006\u0004\b#\u0010$J\u001f\u0010&\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c2\u0006\u0010\u001b\u001a\u00020%H'¢\u0006\u0004\b&\u0010'J\u001f\u0010)\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00132\u0006\u0010\u0017\u001a\u00020(H'¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c2\u0006\u0010\u001b\u001a\u00020+H'¢\u0006\u0004\b,\u0010-J\u001f\u0010/\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00132\u0006\u0010\u0017\u001a\u00020.H'¢\u0006\u0004\b/\u00100J\u001f\u00102\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c2\u0006\u0010\u001b\u001a\u000201H'¢\u0006\u0004\b2\u00103J\u0017\u00107\u001a\u0002062\u0006\u00105\u001a\u000204H'¢\u0006\u0004\b7\u00108J\u0017\u0010<\u001a\u00020;2\u0006\u0010:\u001a\u000209H'¢\u0006\u0004\b<\u0010=J\u0017\u0010A\u001a\u00020@2\u0006\u0010?\u001a\u00020>H'¢\u0006\u0004\bA\u0010BJ\u0017\u0010F\u001a\u00020E2\u0006\u0010D\u001a\u00020CH'¢\u0006\u0004\bF\u0010GJ\u0017\u0010K\u001a\u00020J2\u0006\u0010I\u001a\u00020HH'¢\u0006\u0004\bK\u0010LJ\u0017\u0010P\u001a\u00020O2\u0006\u0010N\u001a\u00020MH'¢\u0006\u0004\bP\u0010Q¨\u0006R"}, d2 = {"Lcom/avito/android/basket/checkout/di/CheckoutModule$Declarations;", "", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutRepositoryImpl;", "repository", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutRepository;", "provideRepository", "(Lcom/avito/android/basket/checkout/viewmodel/CheckoutRepositoryImpl;)Lcom/avito/android/basket/checkout/viewmodel/CheckoutRepository;", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutConverterImpl;", "converter", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutConverter;", "provideConverter", "(Lcom/avito/android/basket/checkout/viewmodel/CheckoutConverterImpl;)Lcom/avito/android/basket/checkout/viewmodel/CheckoutConverter;", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutViewModelFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/basket/checkout/viewmodel/CheckoutViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "provideTitlePresenter", "(Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/basket/checkout/item/checkout/CheckoutItemPresenter;", "itemPresenter", "provideCheckoutItemPresenter", "(Lcom/avito/android/basket/checkout/item/checkout/CheckoutItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/basket/checkout/item/checkout/CheckoutItemBlueprint;", "itemBlueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideCheckoutItemBlueprint", "(Lcom/avito/android/basket/checkout/item/checkout/CheckoutItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/basket/checkout/item/prolongation/ProlongationItemPresenterImpl;", "Lcom/avito/android/basket/checkout/item/prolongation/ProlongationItemPresenter;", "provideProlongationPresenterImpl", "(Lcom/avito/android/basket/checkout/item/prolongation/ProlongationItemPresenterImpl;)Lcom/avito/android/basket/checkout/item/prolongation/ProlongationItemPresenter;", "provideProlongationItemPresenter", "(Lcom/avito/android/basket/checkout/item/prolongation/ProlongationItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/basket/checkout/item/prolongation/ProlongationItemBlueprint;", "provideProlongationItemBlueprint", "(Lcom/avito/android/basket/checkout/item/prolongation/ProlongationItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/basket/checkout/item/price/PriceItemPresenter;", "providePricePresenter", "(Lcom/avito/android/basket/checkout/item/price/PriceItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/basket/checkout/item/price/PriceItemBlueprint;", "providePriceBlueprint", "(Lcom/avito/android/basket/checkout/item/price/PriceItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/basket/checkout/item/disclaimer/CheckoutDisclaimerItemPresenter;", "provideDisclaimerPresenter", "(Lcom/avito/android/basket/checkout/item/disclaimer/CheckoutDisclaimerItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/basket/checkout/item/disclaimer/DisclaimerItemBlueprint;", "provideDisclaimerBlueprint", "(Lcom/avito/android/basket/checkout/item/disclaimer/DisclaimerItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/basket/checkout/ResourceProviderImpl;", "resourceProvider", "Lcom/avito/android/basket/checkout/ResourceProvider;", "provideResourceProvider", "(Lcom/avito/android/basket/checkout/ResourceProviderImpl;)Lcom/avito/android/basket/checkout/ResourceProvider;", "Lcom/avito/android/tariff/view/TariffBarConverterImpl;", "barConverterImpl", "Lcom/avito/android/tariff/view/TariffBarConverter;", "provideBarConverter", "(Lcom/avito/android/tariff/view/TariffBarConverterImpl;)Lcom/avito/android/tariff/view/TariffBarConverter;", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutCommitConverterImpl;", "commitConverterImpl", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutCommitConverter;", "provideCheckoutCommitConverter", "(Lcom/avito/android/basket/checkout/viewmodel/CheckoutCommitConverterImpl;)Lcom/avito/android/basket/checkout/viewmodel/CheckoutCommitConverter;", "Lcom/avito/android/basket_legacy/utils/PriceFormatterImpl;", "formatter", "Lcom/avito/android/basket_legacy/utils/PriceFormatter;", "providePriceFormatter", "(Lcom/avito/android/basket_legacy/utils/PriceFormatterImpl;)Lcom/avito/android/basket_legacy/utils/PriceFormatter;", "Lcom/avito/android/basket/checkout/utils/CheckoutCalculatorImpl;", "calculator", "Lcom/avito/android/basket/checkout/utils/CheckoutCalculator;", "providePriceItemCalculator", "(Lcom/avito/android/basket/checkout/utils/CheckoutCalculatorImpl;)Lcom/avito/android/basket/checkout/utils/CheckoutCalculator;", "Lcom/avito/android/basket/checkout/utils/PriceItemCreatorImpl;", "creator", "Lcom/avito/android/basket/checkout/utils/PriceItemCreator;", "providePriceItemCreator", "(Lcom/avito/android/basket/checkout/utils/PriceItemCreatorImpl;)Lcom/avito/android/basket/checkout/utils/PriceItemCreator;", "basket_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        TariffBarConverter provideBarConverter(@NotNull TariffBarConverterImpl tariffBarConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        CheckoutCommitConverter provideCheckoutCommitConverter(@NotNull CheckoutCommitConverterImpl checkoutCommitConverterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideCheckoutItemBlueprint(@NotNull CheckoutItemBlueprint checkoutItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideCheckoutItemPresenter(@NotNull CheckoutItemPresenter checkoutItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        CheckoutConverter provideConverter(@NotNull CheckoutConverterImpl checkoutConverterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideDisclaimerBlueprint(@NotNull DisclaimerItemBlueprint disclaimerItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideDisclaimerPresenter(@NotNull CheckoutDisclaimerItemPresenter checkoutDisclaimerItemPresenter);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> providePriceBlueprint(@NotNull PriceItemBlueprint priceItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        PriceFormatter providePriceFormatter(@NotNull PriceFormatterImpl priceFormatterImpl);

        @PerFragment
        @Binds
        @NotNull
        CheckoutCalculator providePriceItemCalculator(@NotNull CheckoutCalculatorImpl checkoutCalculatorImpl);

        @PerFragment
        @Binds
        @NotNull
        PriceItemCreator providePriceItemCreator(@NotNull PriceItemCreatorImpl priceItemCreatorImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> providePricePresenter(@NotNull PriceItemPresenter priceItemPresenter);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideProlongationItemBlueprint(@NotNull ProlongationItemBlueprint prolongationItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideProlongationItemPresenter(@NotNull ProlongationItemPresenter prolongationItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        ProlongationItemPresenter provideProlongationPresenterImpl(@NotNull ProlongationItemPresenterImpl prolongationItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        CheckoutRepository provideRepository(@NotNull CheckoutRepositoryImpl checkoutRepositoryImpl);

        @PerFragment
        @Binds
        @NotNull
        ResourceProvider provideResourceProvider(@NotNull ResourceProviderImpl resourceProviderImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideTitlePresenter(@NotNull PaidServiceHeaderItemPresenter paidServiceHeaderItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory provideViewModelFactory(@NotNull CheckoutViewModelFactory checkoutViewModelFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final CheckoutItemClickListener provideCheckoutItemListener(@NotNull CheckoutViewModel checkoutViewModel) {
        Intrinsics.checkNotNullParameter(checkoutViewModel, "viewModel");
        return checkoutViewModel;
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
    public static final CheckoutViewModel provideViewModel(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(fragment, factory).get(CheckoutViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (CheckoutViewModel) viewModel;
    }
}
