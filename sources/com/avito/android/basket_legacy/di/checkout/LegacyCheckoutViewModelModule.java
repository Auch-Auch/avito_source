package com.avito.android.basket_legacy.di.checkout;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.basket_legacy.di.AdvertId;
import com.avito.android.basket_legacy.di.LfRequired;
import com.avito.android.basket_legacy.di.VasContext;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.basket_legacy.utils.CrossClickListener;
import com.avito.android.basket_legacy.utils.DisclaimerProvider;
import com.avito.android.basket_legacy.utils.DisclaimerProviderImpl;
import com.avito.android.basket_legacy.utils.FeesToBasketItemConverter;
import com.avito.android.basket_legacy.utils.FeesToBasketItemConverterImpl;
import com.avito.android.basket_legacy.utils.PriceCalculator;
import com.avito.android.basket_legacy.utils.PriceCalculatorImpl;
import com.avito.android.basket_legacy.utils.PriceFormatter;
import com.avito.android.basket_legacy.utils.PriceFormatterImpl;
import com.avito.android.basket_legacy.utils.StringProvider;
import com.avito.android.basket_legacy.utils.StringProviderImpl;
import com.avito.android.basket_legacy.utils.VasToBasketItemConverter;
import com.avito.android.basket_legacy.utils.VasToBasketItemConverterImpl;
import com.avito.android.basket_legacy.viewmodels.checkout.CheckoutViewModelImpl;
import com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModel;
import com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModelFactory;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u00012B\u0019\u0012\u0006\u0010/\u001a\u00020,\u0012\b\u0010+\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b0\u00101J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\rJ}\u0010'\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u000e2\b\b\u0001\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutViewModelModule;", "", "Lcom/avito/android/basket_legacy/viewmodels/checkout/LegacyCheckoutViewModelFactory;", "factory", "Lcom/avito/android/basket_legacy/viewmodels/checkout/LegacyCheckoutViewModel;", "provideBasketScreenViewModelImpl", "(Lcom/avito/android/basket_legacy/viewmodels/checkout/LegacyCheckoutViewModelFactory;)Lcom/avito/android/basket_legacy/viewmodels/checkout/LegacyCheckoutViewModel;", "checkoutViewModel", "Lcom/avito/android/basket_legacy/utils/CrossClickListener;", "provideCrossClickListener", "(Lcom/avito/android/basket_legacy/viewmodels/checkout/LegacyCheckoutViewModel;)Lcom/avito/android/basket_legacy/utils/CrossClickListener;", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "provideDeeplinkClickListener", "(Lcom/avito/android/basket_legacy/viewmodels/checkout/LegacyCheckoutViewModel;)Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "", BookingInfoActivity.EXTRA_ITEM_ID, "vasContext", "", "lfRequired", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "basketRepository", "Lcom/avito/android/basket_legacy/utils/VasToBasketItemConverter;", "itemConverter", "Lcom/avito/android/basket_legacy/utils/FeesToBasketItemConverter;", "feesConverter", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/basket_legacy/utils/PriceCalculator;", "priceCalculator", "Lcom/avito/android/basket_legacy/utils/StringProvider;", "stringProvider", "Lcom/avito/android/basket_legacy/utils/DisclaimerProvider;", "disclaimerProvider", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "provideViewModelFactory", "(Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/basket_legacy/repositories/BasketRepository;Lcom/avito/android/basket_legacy/utils/VasToBasketItemConverter;Lcom/avito/android/basket_legacy/utils/FeesToBasketItemConverter;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/basket_legacy/utils/PriceCalculator;Lcom/avito/android/basket_legacy/utils/StringProvider;Lcom/avito/android/basket_legacy/utils/DisclaimerProvider;Lcom/avito/android/Features;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/basket_legacy/viewmodels/checkout/LegacyCheckoutViewModelFactory;", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "openedFrom", "Landroidx/fragment/app/Fragment;", AuthSource.SEND_ABUSE, "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "Declarations", "basket_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class LegacyCheckoutViewModelModule {
    public final Fragment a;
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutViewModelModule$Declarations;", "", "Lcom/avito/android/basket_legacy/utils/VasToBasketItemConverterImpl;", "vasToBasketItemConverterImpl", "Lcom/avito/android/basket_legacy/utils/VasToBasketItemConverter;", "provideItemConverter", "(Lcom/avito/android/basket_legacy/utils/VasToBasketItemConverterImpl;)Lcom/avito/android/basket_legacy/utils/VasToBasketItemConverter;", "Lcom/avito/android/basket_legacy/utils/StringProviderImpl;", "stringProviderImpl", "Lcom/avito/android/basket_legacy/utils/StringProvider;", "provideStringProvider", "(Lcom/avito/android/basket_legacy/utils/StringProviderImpl;)Lcom/avito/android/basket_legacy/utils/StringProvider;", "Lcom/avito/android/basket_legacy/utils/FeesToBasketItemConverterImpl;", "feesToBasketItemConverter", "Lcom/avito/android/basket_legacy/utils/FeesToBasketItemConverter;", "provideFeesConverter", "(Lcom/avito/android/basket_legacy/utils/FeesToBasketItemConverterImpl;)Lcom/avito/android/basket_legacy/utils/FeesToBasketItemConverter;", "Lcom/avito/android/basket_legacy/utils/PriceCalculatorImpl;", "calculator", "Lcom/avito/android/basket_legacy/utils/PriceCalculator;", "providePriceCalculator", "(Lcom/avito/android/basket_legacy/utils/PriceCalculatorImpl;)Lcom/avito/android/basket_legacy/utils/PriceCalculator;", "Lcom/avito/android/basket_legacy/utils/DisclaimerProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/basket_legacy/utils/DisclaimerProvider;", "provideDisclaimerProvider", "(Lcom/avito/android/basket_legacy/utils/DisclaimerProviderImpl;)Lcom/avito/android/basket_legacy/utils/DisclaimerProvider;", "Lcom/avito/android/basket_legacy/utils/PriceFormatterImpl;", "formatter", "Lcom/avito/android/basket_legacy/utils/PriceFormatter;", "providePriceFormatter", "(Lcom/avito/android/basket_legacy/utils/PriceFormatterImpl;)Lcom/avito/android/basket_legacy/utils/PriceFormatter;", "basket_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        DisclaimerProvider provideDisclaimerProvider(@NotNull DisclaimerProviderImpl disclaimerProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        FeesToBasketItemConverter provideFeesConverter(@NotNull FeesToBasketItemConverterImpl feesToBasketItemConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        VasToBasketItemConverter provideItemConverter(@NotNull VasToBasketItemConverterImpl vasToBasketItemConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        PriceCalculator providePriceCalculator(@NotNull PriceCalculatorImpl priceCalculatorImpl);

        @PerFragment
        @Binds
        @NotNull
        PriceFormatter providePriceFormatter(@NotNull PriceFormatterImpl priceFormatterImpl);

        @PerFragment
        @Binds
        @NotNull
        StringProvider provideStringProvider(@NotNull StringProviderImpl stringProviderImpl);
    }

    public LegacyCheckoutViewModelModule(@NotNull Fragment fragment, @Nullable String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.a = fragment;
        this.b = str;
    }

    @Provides
    @PerFragment
    @NotNull
    public final LegacyCheckoutViewModel provideBasketScreenViewModelImpl(@NotNull LegacyCheckoutViewModelFactory legacyCheckoutViewModelFactory) {
        Intrinsics.checkNotNullParameter(legacyCheckoutViewModelFactory, "factory");
        ViewModel viewModel = ViewModelProviders.of(this.a, legacyCheckoutViewModelFactory).get(CheckoutViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (LegacyCheckoutViewModel) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final CrossClickListener provideCrossClickListener(@NotNull LegacyCheckoutViewModel legacyCheckoutViewModel) {
        Intrinsics.checkNotNullParameter(legacyCheckoutViewModel, "checkoutViewModel");
        return legacyCheckoutViewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final OnDeepLinkClickListener provideDeeplinkClickListener(@NotNull LegacyCheckoutViewModel legacyCheckoutViewModel) {
        Intrinsics.checkNotNullParameter(legacyCheckoutViewModel, "checkoutViewModel");
        return legacyCheckoutViewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final LegacyCheckoutViewModelFactory provideViewModelFactory(@AdvertId @NotNull String str, @VasContext @NotNull String str2, @LfRequired boolean z, @NotNull BasketRepository basketRepository, @NotNull VasToBasketItemConverter vasToBasketItemConverter, @NotNull FeesToBasketItemConverter feesToBasketItemConverter, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull PriceCalculator priceCalculator, @NotNull StringProvider stringProvider, @NotNull DisclaimerProvider disclaimerProvider, @NotNull Features features, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "vasContext");
        Intrinsics.checkNotNullParameter(basketRepository, "basketRepository");
        Intrinsics.checkNotNullParameter(vasToBasketItemConverter, "itemConverter");
        Intrinsics.checkNotNullParameter(feesToBasketItemConverter, "feesConverter");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(priceCalculator, "priceCalculator");
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        Intrinsics.checkNotNullParameter(disclaimerProvider, "disclaimerProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new LegacyCheckoutViewModelFactory(str, str2, this.b, z, basketRepository, vasToBasketItemConverter, feesToBasketItemConverter, deepLinkIntentFactory, activityIntentFactory, priceCalculator, stringProvider, disclaimerProvider, features, schedulersFactory);
    }
}
