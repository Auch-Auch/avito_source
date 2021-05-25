package com.avito.android.delivery.di.component;

import com.avito.android.delivery.di.module.DeliveryProfileSettingsModule;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsActivity;
import com.avito.android.di.PerActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/delivery/di/component/DeliveryProfileSettingsComponent;", "", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsActivity;", "activity", "", "inject", "(Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsActivity;)V", "Builder", "delivery_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {DeliveryDependencies.class}, modules = {DeliveryProfileSettingsModule.class})
@PerActivity
public interface DeliveryProfileSettingsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/delivery/di/component/DeliveryProfileSettingsComponent$Builder;", "", "Lcom/avito/android/delivery/di/component/DeliveryDependencies;", "deliveryDependencies", "(Lcom/avito/android/delivery/di/component/DeliveryDependencies;)Lcom/avito/android/delivery/di/component/DeliveryProfileSettingsComponent$Builder;", "Lcom/avito/android/delivery/di/module/DeliveryProfileSettingsModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "deliveryProfileSettingsModule", "(Lcom/avito/android/delivery/di/module/DeliveryProfileSettingsModule;)Lcom/avito/android/delivery/di/component/DeliveryProfileSettingsComponent$Builder;", "Lcom/avito/android/delivery/di/component/DeliveryProfileSettingsComponent;", "build", "()Lcom/avito/android/delivery/di/component/DeliveryProfileSettingsComponent;", "delivery_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        DeliveryProfileSettingsComponent build();

        @NotNull
        Builder deliveryDependencies(@NotNull DeliveryDependencies deliveryDependencies);

        @NotNull
        Builder deliveryProfileSettingsModule(@NotNull DeliveryProfileSettingsModule deliveryProfileSettingsModule);
    }

    void inject(@NotNull DeliveryProfileSettingsActivity deliveryProfileSettingsActivity);
}
