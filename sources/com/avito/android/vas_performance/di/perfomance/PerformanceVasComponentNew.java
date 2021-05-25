package com.avito.android.vas_performance.di.perfomance;

import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.vas_performance.ui.PerformanceVasFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/vas_performance/di/perfomance/PerformanceVasComponentNew;", "", "Lcom/avito/android/vas_performance/ui/PerformanceVasFragment;", "fragment", "", "inject", "(Lcom/avito/android/vas_performance/ui/PerformanceVasFragment;)V", "Factory", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PerformanceVasDependenciesNew.class}, modules = {ListModuleNew.class, PerformanceVasModuleNew.class, PerformanceVasAnalyticsModuleNew.class})
@PerFragment
public interface PerformanceVasComponentNew {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/vas_performance/di/perfomance/PerformanceVasComponentNew$Factory;", "", "Lcom/avito/android/vas_performance/di/perfomance/PerformanceVasDependenciesNew;", "dependencies", "Lcom/avito/android/vas_performance/di/perfomance/PerformanceVasModuleNew;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/vas_performance/di/perfomance/PerformanceVasComponentNew;", "create", "(Lcom/avito/android/vas_performance/di/perfomance/PerformanceVasDependenciesNew;Lcom/avito/android/vas_performance/di/perfomance/PerformanceVasModuleNew;Landroidx/fragment/app/Fragment;)Lcom/avito/android/vas_performance/di/perfomance/PerformanceVasComponentNew;", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        PerformanceVasComponentNew create(@NotNull PerformanceVasDependenciesNew performanceVasDependenciesNew, @NotNull PerformanceVasModuleNew performanceVasModuleNew, @BindsInstance @NotNull Fragment fragment);
    }

    void inject(@NotNull PerformanceVasFragment performanceVasFragment);
}
