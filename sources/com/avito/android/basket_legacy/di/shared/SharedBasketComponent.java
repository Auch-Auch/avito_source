package com.avito.android.basket_legacy.di.shared;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.basket_legacy.di.ScreenAnalytics;
import com.avito.android.basket_legacy.di.checkout.LegacyCheckoutDependencies;
import com.avito.android.basket_legacy.di.fees.FeesBasketModule;
import com.avito.android.basket_legacy.di.vas.PerformanceVasModule;
import com.avito.android.basket_legacy.di.vas.VisualVasModule;
import com.avito.android.basket_legacy.ui.BasketActivity;
import com.avito.android.di.PerActivity;
import com.avito.android.fees.refactor.di.PackageFeesDependencies;
import com.avito.android.vas_performance.di.perfomance_legacy.PerformanceVasDependencies;
import com.avito.android.vas_performance.di.visual_legacy.VisualVasDependencies;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\nJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/basket_legacy/di/shared/SharedBasketComponent;", "Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutDependencies;", "Lcom/avito/android/fees/refactor/di/PackageFeesDependencies;", "Lcom/avito/android/vas_performance/di/perfomance_legacy/PerformanceVasDependencies;", "Lcom/avito/android/vas_performance/di/visual_legacy/VisualVasDependencies;", "Lcom/avito/android/basket_legacy/ui/BasketActivity;", "basketActivity", "", "inject", "(Lcom/avito/android/basket_legacy/ui/BasketActivity;)V", "Builder", "basket_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {BasketDependencies.class}, modules = {SharedModule.class, FeesBasketModule.class, PerformanceVasModule.class, VisualVasModule.class})
@PerActivity
public interface SharedBasketComponent extends LegacyCheckoutDependencies, PackageFeesDependencies, PerformanceVasDependencies, VisualVasDependencies {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00002\b\b\u0001\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/basket_legacy/di/shared/SharedBasketComponent$Builder;", "", "Lcom/avito/android/basket_legacy/di/shared/BasketDependencies;", "dependencies", "basketDependencies", "(Lcom/avito/android/basket_legacy/di/shared/BasketDependencies;)Lcom/avito/android/basket_legacy/di/shared/SharedBasketComponent$Builder;", "Lcom/avito/android/basket_legacy/di/shared/SharedModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "sharedModule", "(Lcom/avito/android/basket_legacy/di/shared/SharedModule;)Lcom/avito/android/basket_legacy/di/shared/SharedBasketComponent$Builder;", "Lcom/avito/android/basket_legacy/di/fees/FeesBasketModule;", "packageFeesModule", "(Lcom/avito/android/basket_legacy/di/fees/FeesBasketModule;)Lcom/avito/android/basket_legacy/di/shared/SharedBasketComponent$Builder;", "Lcom/avito/android/basket_legacy/di/vas/PerformanceVasModule;", "performanceVasModule", "(Lcom/avito/android/basket_legacy/di/vas/PerformanceVasModule;)Lcom/avito/android/basket_legacy/di/shared/SharedBasketComponent$Builder;", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "withScreen", "(Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/basket_legacy/di/shared/SharedBasketComponent$Builder;", "", "subComponents", "withSubComponents", "(Z)Lcom/avito/android/basket_legacy/di/shared/SharedBasketComponent$Builder;", "Lcom/avito/android/basket_legacy/di/shared/SharedBasketComponent;", "build", "()Lcom/avito/android/basket_legacy/di/shared/SharedBasketComponent;", "basket_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        Builder basketDependencies(@NotNull BasketDependencies basketDependencies);

        @NotNull
        SharedBasketComponent build();

        @NotNull
        Builder packageFeesModule(@NotNull FeesBasketModule feesBasketModule);

        @NotNull
        Builder performanceVasModule(@NotNull PerformanceVasModule performanceVasModule);

        @NotNull
        Builder sharedModule(@NotNull SharedModule sharedModule);

        @BindsInstance
        @NotNull
        Builder withScreen(@ScreenAnalytics @NotNull Screen screen);

        @BindsInstance
        @NotNull
        Builder withSubComponents(@ScreenAnalytics boolean z);
    }

    void inject(@NotNull BasketActivity basketActivity);
}
