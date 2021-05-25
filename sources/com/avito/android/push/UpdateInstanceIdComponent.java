package com.avito.android.push;

import com.avito.android.di.PerService;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/push/UpdateInstanceIdComponent;", "", "Lcom/avito/android/push/UpdateInstanceIdWorker;", "worker", "", "inject", "(Lcom/avito/android/push/UpdateInstanceIdWorker;)V", "Factory", "push_release"}, k = 1, mv = {1, 4, 2})
@PerService
@Component(dependencies = {UpdateInstanceIdDependencies.class}, modules = {UpdateInstanceIdModule.class})
public interface UpdateInstanceIdComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/push/UpdateInstanceIdComponent$Factory;", "", "Lcom/avito/android/push/UpdateInstanceIdDependencies;", "dependencies", "Lcom/avito/android/push/UpdateInstanceIdModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "Lcom/avito/android/push/UpdateInstanceIdComponent;", "create", "(Lcom/avito/android/push/UpdateInstanceIdDependencies;Lcom/avito/android/push/UpdateInstanceIdModule;)Lcom/avito/android/push/UpdateInstanceIdComponent;", "push_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        UpdateInstanceIdComponent create(@NotNull UpdateInstanceIdDependencies updateInstanceIdDependencies, @NotNull UpdateInstanceIdModule updateInstanceIdModule);
    }

    void inject(@NotNull UpdateInstanceIdWorker updateInstanceIdWorker);
}
