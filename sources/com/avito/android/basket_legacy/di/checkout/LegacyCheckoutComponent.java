package com.avito.android.basket_legacy.di.checkout;

import com.avito.android.basket_legacy.ui.LegacyCheckoutFragment;
import com.avito.android.di.PerFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutComponent;", "", "Lcom/avito/android/basket_legacy/ui/LegacyCheckoutFragment;", "fragment", "", "inject", "(Lcom/avito/android/basket_legacy/ui/LegacyCheckoutFragment;)V", "Builder", "basket_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {LegacyCheckoutDependencies.class}, modules = {LegacyCheckoutUiModule.class, LegacyCheckoutViewModelModule.class})
@PerFragment
public interface LegacyCheckoutComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutComponent$Builder;", "", "Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutDependencies;", "dependencies", "(Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutDependencies;)Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutComponent$Builder;", "Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutViewModelModule;", "modelModule", "basketViewModelModule", "(Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutViewModelModule;)Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutComponent$Builder;", "Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutUiModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "checkoutModule", "(Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutUiModule;)Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutComponent$Builder;", "Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutComponent;", "build", "()Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutComponent;", "basket_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        Builder basketViewModelModule(@NotNull LegacyCheckoutViewModelModule legacyCheckoutViewModelModule);

        @NotNull
        LegacyCheckoutComponent build();

        @NotNull
        Builder checkoutModule(@NotNull LegacyCheckoutUiModule legacyCheckoutUiModule);

        @NotNull
        Builder dependencies(@NotNull LegacyCheckoutDependencies legacyCheckoutDependencies);
    }

    void inject(@NotNull LegacyCheckoutFragment legacyCheckoutFragment);
}
