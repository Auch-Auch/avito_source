package com.avito.android.basket.paid_services.di;

import android.content.res.Resources;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.basket.checkout.di.CheckoutDependencies;
import com.avito.android.basket.paid_services.PaidServicesActivity;
import com.avito.android.di.PerActivity;
import com.avito.android.tariff.di.SharedTariffModule;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.vas_performance.di.perfomance.PerformanceVasDependenciesNew;
import com.avito.android.vas_performance.di.visual.VisualVasDependenciesNew;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\nJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/basket/paid_services/di/PaidServicesComponent;", "Lcom/avito/android/tariff/di/TariffStepDependencies;", "Lcom/avito/android/basket/checkout/di/CheckoutDependencies;", "Lcom/avito/android/vas_performance/di/perfomance/PerformanceVasDependenciesNew;", "Lcom/avito/android/vas_performance/di/visual/VisualVasDependenciesNew;", "Lcom/avito/android/basket/paid_services/PaidServicesActivity;", "activity", "", "inject", "(Lcom/avito/android/basket/paid_services/PaidServicesActivity;)V", "Builder", "basket_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PaidServicesDependencies.class}, modules = {RoutingModule.class, SharedTariffModule.class})
@PerActivity
public interface PaidServicesComponent extends TariffStepDependencies, CheckoutDependencies, PerformanceVasDependenciesNew, VisualVasDependenciesNew {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/basket/paid_services/di/PaidServicesComponent$Builder;", "", "Lcom/avito/android/basket/paid_services/di/PaidServicesDependencies;", "dependencies", "(Lcom/avito/android/basket/paid_services/di/PaidServicesDependencies;)Lcom/avito/android/basket/paid_services/di/PaidServicesComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/basket/paid_services/di/PaidServicesComponent$Builder;", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "(Lcom/avito/android/analytics/screens/Screen;)Lcom/avito/android/basket/paid_services/di/PaidServicesComponent$Builder;", "Lcom/avito/android/basket/paid_services/di/PaidServicesComponent;", "build", "()Lcom/avito/android/basket/paid_services/di/PaidServicesComponent;", "basket_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PaidServicesComponent build();

        @NotNull
        Builder dependencies(@NotNull PaidServicesDependencies paidServicesDependencies);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder screen(@NotNull Screen screen);
    }

    void inject(@NotNull PaidServicesActivity paidServicesActivity);
}
