package com.avito.android.vas_performance.di.applied_services;

import com.avito.android.di.PerFragment;
import com.avito.android.vas_performance.ui.applied_services.AppliedServicesDialogFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/vas_performance/di/applied_services/AppliedServicesComponent;", "", "Lcom/avito/android/vas_performance/ui/applied_services/AppliedServicesDialogFragment;", "fragment", "", "inject", "(Lcom/avito/android/vas_performance/ui/applied_services/AppliedServicesDialogFragment;)V", "Builder", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {AppliedServicesDependencies.class}, modules = {AppliedServicesModule.class})
@PerFragment
public interface AppliedServicesComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/vas_performance/di/applied_services/AppliedServicesComponent$Builder;", "", "Lcom/avito/android/vas_performance/di/applied_services/AppliedServicesModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "(Lcom/avito/android/vas_performance/di/applied_services/AppliedServicesModule;)Lcom/avito/android/vas_performance/di/applied_services/AppliedServicesComponent$Builder;", "Lcom/avito/android/vas_performance/di/applied_services/AppliedServicesDependencies;", "dependencies", "(Lcom/avito/android/vas_performance/di/applied_services/AppliedServicesDependencies;)Lcom/avito/android/vas_performance/di/applied_services/AppliedServicesComponent$Builder;", "Lcom/avito/android/vas_performance/di/applied_services/AppliedServicesComponent;", "build", "()Lcom/avito/android/vas_performance/di/applied_services/AppliedServicesComponent;", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        AppliedServicesComponent build();

        @NotNull
        Builder dependencies(@NotNull AppliedServicesDependencies appliedServicesDependencies);

        @NotNull
        Builder module(@NotNull AppliedServicesModule appliedServicesModule);
    }

    void inject(@NotNull AppliedServicesDialogFragment appliedServicesDialogFragment);
}
